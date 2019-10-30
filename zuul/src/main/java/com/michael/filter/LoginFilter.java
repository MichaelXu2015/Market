package com.michael.filter;

import com.google.gson.Gson;
import com.michael.token.JWTTokenUtil;
import com.michael.token.Token;
import com.michael.token.TokenConstant;
import com.michael.util.ServerResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class LoginFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public String filterType() {
        //Filter类型,请求前执行
        return "pre";
    }

    @Override
    public int filterOrder() {
        //filter执行顺序,值越小越先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行到下一个Filter,如果为false则下一个Filter不执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.getResponse().setCharacterEncoding("UTF-8");//设置UTF-8防止中文乱码
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String uri = httpServletRequest.getRequestURI();
        System.out.println("uri === "+uri);
        if(uri.contains("/user/login") || uri.contains("/user/register") ) {
            //如果是登录或者注册不验证token
            logger.info("登录和注册不检验token");
            return null;
        }else {
            String token = httpServletRequest.getHeader("token");//在头部获取请求信息
            logger.info("token ====== "+token);
            //判断是否携带token
            if(token==null || token.equals("")) {
                //对该请求禁止路由,也就是禁止访问下游服务，后面的filter就不会执行了
                requestContext.setSendZuulResponse(false);
                //响应到客户端的信息
                requestContext.setResponseBody("{\"status\":500,\"message\":\"token 为 null\"}");
                //保存一个标记作为下一个filter的执行开关,下一个shouldFilter的判断
                requestContext.set("login-is-success", false);
                return null;


            }
            JWTTokenUtil tokenUtil = JWTTokenUtil.defaultUtil();
            Token tokenBean = tokenUtil.parse(token, TokenConstant.SECRET);
            Integer tokenResult = tokenUtil.tokenIllegality(tokenBean);
            ServerResponse sp = null;
            switch (tokenResult) {
                case 1:
                    logger.info("token 非法");
                    requestContext.setSendZuulResponse(false);
                    sp = ServerResponse.createFailMsg(500, "token非法");
                    requestContext.setResponseBody(new Gson().toJson(sp));
                    requestContext.set("login-is-success", false);
                    break;
                case 2:
                    logger.info("token 过期");
                    requestContext.setSendZuulResponse(false);
                    sp = ServerResponse.createFailMsg(500, "token过期");
                    requestContext.setResponseBody(new Gson().toJson(sp));
                    requestContext.set("login-is-success", false);
                    break;
                case 3:
                    logger.info("token 无效");
                    requestContext.setSendZuulResponse(false);
                    sp = ServerResponse.createFailMsg(500, "token无效");
                    requestContext.setResponseBody(new Gson().toJson(sp));
                    requestContext.set("login-is-success", false);
                    break;
                default:

                    break;
            }
        }

        requestContext.set("login-is-success", true);
        return null;
    }
}
