package com.michael.api.fallback;

import com.michael.api.user.UserApiService;
import com.michael.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserApiServiceFallBack implements FallbackFactory<UserApiService> {
    @Override
    public UserApiService create(Throwable throwable) {
        return new UserApiService() {
            @Override
            public User login(String userName, String password) {
                return null;
            }

            @Override
            public Integer insertUser(User user) {
                return null;
            }

            @Override
            public Integer updatePhoneNum(User user) {
                return null;
            }

            @Override
            public Integer findUserStatus(String userName) {
                return null;
            }

            @Override
            public Integer deleteUserByUserName(String userName) {
                return null;
            }
        };
    }
}
