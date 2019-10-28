package com.michael.service.impl;

import com.github.pagehelper.PageInfo;
import com.michael.api.order.OrderApiService;
import com.michael.entity.OrderInfo;
import com.michael.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderApiService orderApiService;

    @Override
    public Integer insertOrder(OrderInfo orderInfo) {
       return orderApiService.insertOrder(orderInfo);
    }

    @Override
    public PageInfo<OrderInfo> getAllOrderInfo(Integer curPage, Integer pageSize) {
        return orderApiService.getAllOrderInfo(curPage,pageSize);
    }

    @Override
    public PageInfo<OrderInfo> getOrderInfoByUserId(Integer curPage, Integer pageSize, String userId) {
        return orderApiService.getOrderInfoByUserId(curPage,pageSize,userId);
    }


    @Override
    public OrderInfo getOrderInfoByOrderNo(String orderNo) {
        return orderApiService.getOrderInfoByOrderNo(orderNo);
    }

    @Override
    public List<OrderInfo> getOrderInfoByTime(String startTime, String endTime) {
       return orderApiService.getOrderInfoByTime(startTime,endTime);
    }




}
