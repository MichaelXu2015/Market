package com.michael.service;

import com.github.pagehelper.PageInfo;
import com.michael.entity.OrderInfo;

import java.util.List;

public interface OrderService {

    Integer insertOrder(OrderInfo orderInfo);

    //分页查询
    PageInfo<OrderInfo> getAllOrderInfo(Integer curPage, Integer pageSize);

    PageInfo<OrderInfo> getOrderInfoByUserId(Integer curPage, Integer pageSize, String userId);

    OrderInfo getOrderInfoByOrderNo(String orderNo);

    List<OrderInfo> getOrderInfoByTime(String startTime, String endTime);
}
