package com.michael.service.impl;

import com.michael.dao.UserMapper;
import com.michael.service.UserService;
import com.michael.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName,password);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer updatePhoneNum(User user) {
        return userMapper.updatePhoneNum(user);
    }

    @Override
    public Integer findUserStatus(String userName) {
        return userMapper.findUserStatus(userName);
    }

    @Override
    public Integer deleteUserByUserName(String userName) {
        return userMapper.deleteUserByUserName(userName);
    }
}
