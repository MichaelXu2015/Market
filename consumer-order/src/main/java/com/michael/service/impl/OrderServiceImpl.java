package com.michael.service.impl;

import com.github.pagehelper.PageInfo;
import com.michael.api.order.OrderApiService;
import com.michael.entity.OrderMaster;
import com.michael.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderApiService orderApiService;

    @Override
    public Integer insertOrder(OrderMaster orderInfo) {
       return orderApiService.insertOrder(orderInfo);
    }

    @Override
    public PageInfo<OrderMaster> getAllOrderInfo(Integer curPage, Integer pageSize) {
        return orderApiService.getAllOrderInfo(curPage,pageSize);
    }

    @Override
    public PageInfo<OrderMaster> getOrderInfoByUserId(Integer curPage, Integer pageSize, String userId) {
        return orderApiService.getOrderInfoByUserId(curPage,pageSize,userId);
    }


    @Override
    public OrderMaster getOrderInfoByOrderNo(String orderNo) {
        return orderApiService.getOrderInfoByOrderNo(orderNo);
    }

    @Override
    public List<OrderMaster> getOrderInfoByTime(String startTime, String endTime) {
       return orderApiService.getOrderInfoByTime(startTime,endTime);
    }




}
