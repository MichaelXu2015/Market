package com.michael.controller;

import com.github.pagehelper.PageInfo;
import com.michael.entity.OrderInfo;
import com.michael.service.OrderService;
import com.michael.util.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/order",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderController {

    @Autowired
    OrderService orderService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/insertOrder")
    public ServerResponse insertOrder(@RequestBody OrderInfo orderInfo) {
        Integer result = orderService.insertOrder(orderInfo);
        if(result >0){
            return ServerResponse.createSuccessMsg("增加订单成功");
        }
        return ServerResponse.createFailMsg("增加订单失败");
    }

    @GetMapping("/getAllOrderInfo/{curPage}/{pageSize}")
    public ServerResponse getAllOrderInfo(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize) {
        PageInfo<OrderInfo> orderInfoPageInfo = orderService.getAllOrderInfo(curPage,pageSize);
        if(orderInfoPageInfo.getList()!=null && orderInfoPageInfo.getList().size()!=0){
            return ServerResponse.createSuccessMsg(orderInfoPageInfo);
        }
        return ServerResponse.createFailMsg("获取分页信息失败!");
    }


    @GetMapping("/getOrderInfoByUserId/{curPage}/{pageSize}/{userId}")
    public ServerResponse getOrderInfoByUserId(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize,
                                         @PathVariable("userId") String userId) {

        PageInfo<OrderInfo> orderInfoPageInfo = orderService.getOrderInfoByUserId(curPage,pageSize,userId);
        if(orderInfoPageInfo.getList()!=null && orderInfoPageInfo.getList().size()!=0){
            return ServerResponse.createSuccessMsg(orderInfoPageInfo);
        }
        return ServerResponse.createFailMsg("获取分页信息失败!");
    }


    @GetMapping("/getOrderInfoByOrderNo/{orderNo}")
    public ServerResponse getOrderInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        OrderInfo orderInfo = orderService.getOrderInfoByOrderNo(orderNo);
        if(orderInfo!=null){
            return ServerResponse.createSuccessMsg(orderInfo);
        }
        return ServerResponse.createFailMsg("获取订单失败!");
    }

    @GetMapping("/getOrderInfoByTime/{startTime}/{endTime}")
    public ServerResponse getOrderInfoByTime(@PathVariable("startTime") String startTime,
                                              @PathVariable("endTime") String endTime) {
        logger.info("服务消费者收到参数: startTime:  "+startTime+" endTime : "+endTime);
        List<OrderInfo> list = orderService.getOrderInfoByTime(startTime,endTime);
        if(list!=null && list.size()!=0){
            return ServerResponse.createSuccessMsg(list);
        }
        return ServerResponse.createFailMsg("获取订单失败!");
    }
}
