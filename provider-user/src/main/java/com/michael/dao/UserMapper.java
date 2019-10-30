package com.michael.dao;

import com.michael.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {




    //登录
    User login(@Param("userName") String userName, @Param("password") String password);

    //注册
    Integer insertUser(User user);

    //修改手机号
    Integer updatePhoneNum(User user);

    //查询用户状态
    Integer findUserStatus(String userName);

    //根据用户名删除用户
    Integer deleteUserByUserName(String userName);

    //更新用户金额
    Integer updateUserAccount(@Param("userName") String userName,@Param("money") Double money);


}
