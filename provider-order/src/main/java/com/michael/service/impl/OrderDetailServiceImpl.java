package com.michael.service.impl;

import com.michael.dao.OrderDetailMapper;
import com.michael.entity.OrderDetail;
import com.michael.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;


    @Override
    public List<OrderDetail> findAllOrderDetail() {
        return orderDetailMapper.findAllOrderDetail();
    }
}
