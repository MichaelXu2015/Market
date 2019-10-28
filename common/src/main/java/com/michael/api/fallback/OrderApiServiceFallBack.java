package com.michael.api.fallback;

import com.github.pagehelper.PageInfo;
import com.michael.api.order.OrderApiService;
import com.michael.entity.OrderInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderApiServiceFallBack implements FallbackFactory<OrderApiService> {
    @Override
    public OrderApiService create(Throwable throwable) {
        return new OrderApiService() {
            @Override
            public Integer insertOrder(OrderInfo orderInfo) {
                return null;
            }

            @Override
            public PageInfo<OrderInfo> getAllOrderInfo(Integer curPage, Integer pageSize) {
                return null;
            }

            @Override
            public PageInfo getOrderInfoByUserId(Integer curPage, Integer pageSize, String userId) {
                return null;
            }

            @Override
            public OrderInfo getOrderInfoByOrderNo(String orderNo) {
                return null;
            }

            @Override
            public List<OrderInfo> getOrderInfoByTime(String startTime, String endTime) {
                return null;
            }
        };
    }
}
