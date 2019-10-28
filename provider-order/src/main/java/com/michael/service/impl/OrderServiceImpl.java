package com.michael.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.michael.dao.OrderMapper;
import com.michael.entity.OrderInfo;
import com.michael.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Integer insertOrder(OrderInfo orderInfo) {
       return orderMapper.insertOrder(orderInfo);
    }

    @Override
    public PageInfo<OrderInfo> getAllOrderInfo(Integer curPage, Integer pageSize) {
        PageHelper.startPage(curPage,pageSize);
        List<OrderInfo> list = orderMapper.getAllOrderInfo();
        PageInfo<OrderInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<OrderInfo> getOrderInfoByUserId(Integer curPage, Integer pageSize, String userId) {
        PageHelper.startPage(curPage,pageSize);
        List<OrderInfo> list = orderMapper.getOrderInfoByUserId(userId);
        PageInfo<OrderInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }




    @Override
    public OrderInfo getOrderInfoByOrderNo(String orderNo) {
        return orderMapper.getOrderInfoByOrderNo(orderNo);
    }

    @Override
    public List<OrderInfo> getOrderInfoByTime(Date startTime, Date endTime) {
        return orderMapper.getOrderInfoByTime(startTime,endTime);
    }


}
