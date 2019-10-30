package com.michael.dao;

import com.michael.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {



  List<OrderDetail> findAllOrderDetail();




}
