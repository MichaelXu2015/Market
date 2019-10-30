package com.michael.controller;

import com.michael.entity.OrderDetail;
import com.michael.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;


    @RequestMapping("/findAllOrderDetail")
    public List<OrderDetail> findAllOrderDetail(){
        return orderDetailService.findAllOrderDetail();
    }
}
