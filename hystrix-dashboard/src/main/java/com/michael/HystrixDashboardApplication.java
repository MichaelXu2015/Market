package com.michael;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 1.在启动类上加上注解@EnableHystrixDashboard启动该服务
 * 2.在浏览器中启动http://localhost:port/hystrix出现监控界面
 * 3.在界面输入被监控的服务地址如：http://localhost:8004/hystrix.strean
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableHystrix
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class,args);
    }
}
