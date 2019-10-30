package com.michael.service.impl;

import com.michael.dao.UserMapper;
import com.michael.entity.TransferAccounts;
import com.michael.service.UserService;
import com.michael.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional //转账,开始事务注解
    public Integer updateUserAccount(TransferAccounts transferAccounts) {
        //收款人增加金额
        Integer result = userMapper.updateUserAccount(transferAccounts.getPayee(),transferAccounts.getMoney());
        //int a = 10/0;
        //付款人减少金额
        Integer result2 = userMapper.updateUserAccount(transferAccounts.getDrawee(),-transferAccounts.getMoney());
        if(result >0 && result2>0){
            return 1;
        }
        return 0;
    }


}
