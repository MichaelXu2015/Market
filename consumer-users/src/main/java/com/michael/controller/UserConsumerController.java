package com.michael.controller;

import com.michael.entity.User;
import com.michael.util.ServerResponse;
import com.michael.util.ServerResponseCode;
import com.michael.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
//MediaType.APPLICATION_JSON_UTF8_VALUE 使当前的返回为UTF-8编码的JSON字符串
@RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserConsumerController {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }


    @GetMapping("/login/{userName}/{password}")
    public ServerResponse login(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        User user = userService.login(userName, password);
        logger.info(" userName : "+userName+" password: "+password);
        if (user != null) {
            return ServerResponse.createSuccessMsg(ServerResponseCode.LOGIN_SUCCESS.getCode(), user, ServerResponseCode.LOGIN_SUCCESS.getMsg());
        }
        return ServerResponse.createFailMsg("用户名或密码错误!");
    }

    @PostMapping("/insertUser")
    public ServerResponse insertUser(@RequestBody User user) {
        Integer result = userService.insertUser(user);
        if (result > 0) {
            return ServerResponse.createSuccessMsg("添加用户成功");
        }
        return ServerResponse.createFailMsg("添加用户失败!");
    }

    @PutMapping("/updatePhoneNum")
    public ServerResponse updatePhoneNum(@RequestBody User user) {
        Integer result = userService.updatePhoneNum(user);
        if (result > 0) {
            return ServerResponse.createSuccessMsg("更新用户成功");
        }
        return ServerResponse.createFailMsg("添加用户失败!");
    }

    @GetMapping("/findUserStatus/{userName}")
    public ServerResponse findUserStatus(@PathVariable("userName") String userName) {
        String status = userService.findUserStatus(userName) == 0 ? "正常" : "锁定";
        return ServerResponse.createSuccessMsg(status);
    }

    @DeleteMapping("/deleteUserByUserName/{userName}")
    public ServerResponse deleteUserByUserName(@PathVariable("userName") String userName) {
        Integer result = userService.deleteUserByUserName(userName);
        if (result > 0) {
            return ServerResponse.createSuccessMsg("删除用户成功");
        }
        return ServerResponse.createFailMsg("删除用户失败!");
    }

}
