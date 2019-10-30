package com.michael.service;

import com.github.pagehelper.PageInfo;
import com.michael.entity.OrderMaster;

import java.util.List;

public interface OrderService {

    Integer insertOrder(OrderMaster orderInfo);

    //分页查询
    PageInfo<OrderMaster> getAllOrderInfo(Integer curPage, Integer pageSize);

    PageInfo<OrderMaster> getOrderInfoByUserId(Integer curPage, Integer pageSize, String userId);

    OrderMaster getOrderInfoByOrderNo(String orderNo);

    List<OrderMaster> getOrderInfoByTime(String startTime, String endTime);
}
