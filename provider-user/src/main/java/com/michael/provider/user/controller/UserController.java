package com.michael.provider.user.controller;

import com.michael.common.entity.User;
import com.michael.provider.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping("/login/{userName}/{password}")
    public User login(@PathVariable("userName") String userName,@PathVariable("password") String password) {
        User user = userService.login(userName,password);
        logger.info(" user : "+user);
        if(user==null){
            user = new User();
            user.setUserName("没有找到该用户!");
        }
        return user;
    }

    @PostMapping("/insertUser")
    public Integer insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PutMapping("/updatePhoneNum")
    public Integer updatePhoneNum(@RequestBody  User user) {
        return userService.updatePhoneNum(user);
    }

    @GetMapping("/findUserStatus/{userName}")
    public Integer findUserStatus(@PathVariable("userName") String userName) {
        return userService.findUserStatus(userName);
    }

    @DeleteMapping("/deleteUserByUserName/{userName}")
    public Integer deleteUserByUserName(@PathVariable("userName") String userName) {
        return userService.deleteUserByUserName(userName);
    }

}
