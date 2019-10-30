package com.michael.service;

import com.michael.entity.TransferAccounts;
import com.michael.entity.User;

public interface UserService {

    //登录
    User login(String userName,String password);

    //注册
    Integer insertUser(User user);

    //修改手机号
    Integer updatePhoneNum(User user);

    //查询用户状态
    Integer findUserStatus(String userName);

    //根据用户名删除用户
    Integer deleteUserByUserName(String userName);

    //更新用户金额
    Integer updateUserAccount(TransferAccounts transferAccounts);

}
