package com.michael.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 一对多查询结果
 * 一个订单的orderNo对应多个订单详情
 */
public class OrderMasterDetail {


    private String orderNo;
    private String userId;
    private BigDecimal amount;
    private Integer orderStatus;

    private List<OrderDetail> orderDetails;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


    @Override
    public String toString() {
        return "OrderMasterDetail{" +
                "orderNo='" + orderNo + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", orderStatus=" + orderStatus +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
