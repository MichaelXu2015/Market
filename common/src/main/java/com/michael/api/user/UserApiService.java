package com.michael.api.user;


import com.michael.api.fallback.UserApiServiceFallBack;
import com.michael.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * 提供Feign的接口调用方式,让其他模块使用
 */
@FeignClient(value = "PROVIDER-USER", fallbackFactory = UserApiServiceFallBack.class)
public interface UserApiService {

    @GetMapping("/user/login/{userName}/{password}")
    User login(@PathVariable("userName") String userName, @PathVariable("password") String password);

    @PostMapping("/user/insertUser")
    Integer insertUser(@RequestBody User user);

    @PutMapping("/user/updatePhoneNum")
    Integer updatePhoneNum(@RequestBody User user);

    @GetMapping("/user/findUserStatus/{userName}")
    Integer findUserStatus(@PathVariable("userName") String userName);

    @DeleteMapping("/user/deleteUserByUserName/{userName}")
    Integer deleteUserByUserName(@PathVariable("userName") String userName);
}
