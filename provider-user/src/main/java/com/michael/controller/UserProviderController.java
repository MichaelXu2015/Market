package com.michael.controller;

import com.michael.entity.TransferAccounts;
import com.michael.entity.User;
import com.michael.service.UserService;
import com.michael.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserProviderController {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping("/login/{userName}/{password}")
    public User login(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        User user = userService.login(userName, password);
        logger.info(" UserProviderController userName : " + userName + " password : " + password);
        return user;
    }

    @PostMapping("/insertUser")
    public Integer insertUser(@RequestBody User user) {
        user.setUserId(UUIDUtil.createUserId());
        return userService.insertUser(user);
    }

    @PutMapping("/updatePhoneNum")
    public Integer updatePhoneNum(@RequestBody User user) {
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

    @PostMapping("/updateUserAccount")
    public Integer updateUserAccount(@RequestBody TransferAccounts transferAccounts) {
        return userService.updateUserAccount(transferAccounts);

    }

}
