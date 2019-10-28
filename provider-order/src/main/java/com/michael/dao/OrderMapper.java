package com.michael.dao;

import com.michael.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    /*增加订单*/
    Integer insertOrder(OrderInfo orderInfo);

    /*获取所有订单,分页查找*/
    List<OrderInfo> getAllOrderInfo();

    /*通过userId获取订单*/
    List<OrderInfo> getOrderInfoByUserId(String userId);

    /*通过orderId获取订单*/
    OrderInfo getOrderInfoByOrderNo(String orderNo);

    /*通过时间范围条件查询,注意时间要传Date类型*/
    List<OrderInfo> getOrderInfoByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);








}
