package com.michael.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.michael.dao.OrderMapper;
import com.michael.entity.OrderExpressDetail;
import com.michael.entity.OrderMaster;
import com.michael.entity.OrderMasterDetail;
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
    public Integer insertOrder(OrderMaster orderInfo) {
       return orderMapper.insertOrder(orderInfo);
    }

    @Override
    public PageInfo<OrderMaster> getAllOrderInfo(Integer curPage, Integer pageSize) {
        PageHelper.startPage(curPage,pageSize);
        List<OrderMaster> list = orderMapper.getAllOrderInfo();
        PageInfo<OrderMaster> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<OrderMaster> getOrderInfoByUserId(Integer curPage, Integer pageSize, String userId) {
        PageHelper.startPage(curPage,pageSize);
        List<OrderMaster> list = orderMapper.getOrderInfoByUserId(userId);
        PageInfo<OrderMaster> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }




    @Override
    public OrderMaster getOrderInfoByOrderNo(String orderNo) {
        return orderMapper.getOrderInfoByOrderNo(orderNo);
    }

    @Override
    public List<OrderMaster> getOrderInfoByTime(Date startTime, Date endTime) {
        return orderMapper.getOrderInfoByTime(startTime,endTime);
    }

    @Override
    public OrderMasterDetail getOrderDetailInfo(String orderNo) {
        return orderMapper.getOrderDetailInfo(orderNo);
    }

    @Override
    public OrderExpressDetail getOrderExpressDetailInfo(String orderNo) {
        return orderMapper.getOrderExpressDetailInfo(orderNo);
    }

    @Override
    public Integer updateOrderInfo(OrderMaster orderMaster) {
        return orderMapper.updateOrderInfo(orderMaster);
    }


}
