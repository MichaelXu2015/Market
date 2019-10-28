package com.michael.service.impl;

import com.michael.api.user.UserApiService;
import com.michael.entity.User;

import com.michael.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserApiService userApiService;

    @Override
    public User login(String userName, String password) {
        return userApiService.login(userName,password);
    }

    @Override
    public Integer insertUser(User user) {
        return userApiService.insertUser(user);
    }

    @Override
    public Integer updatePhoneNum(User user) {
        return userApiService.updatePhoneNum(user);
    }

    @Override
    public Integer findUserStatus(String userName) {
        return userApiService.findUserStatus(userName);
    }

    @Override
    public Integer deleteUserByUserName(String userName) {
        return userApiService.deleteUserByUserName(userName);
    }
}
