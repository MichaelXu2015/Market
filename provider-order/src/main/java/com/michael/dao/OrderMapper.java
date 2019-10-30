package com.michael.dao;

import com.michael.entity.OrderExpressDetail;
import com.michael.entity.OrderMaster;
import com.michael.entity.OrderMasterDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    /*增加订单*/
    Integer insertOrder(OrderMaster orderInfo);

    /*获取所有订单,分页查找*/
    List<OrderMaster> getAllOrderInfo();

    /*通过userId获取订单*/
    List<OrderMaster> getOrderInfoByUserId(String userId);

    /*通过orderId获取订单*/
    OrderMaster getOrderInfoByOrderNo(String orderNo);

    /*通过时间范围条件查询,注意时间要传Date类型*/
    List<OrderMaster> getOrderInfoByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);


    OrderMasterDetail getOrderDetailInfo(String orderNo);

    OrderExpressDetail getOrderExpressDetailInfo(String orderNo);

    Integer updateOrderInfo(OrderMaster orderMaster);





}
