package com.michael.config;

import com.michael.filter.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    public LoginFilter loginFilter(){
        return new LoginFilter();
    }
}
