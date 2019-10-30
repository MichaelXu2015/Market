package com.michael.entity;

import java.math.BigDecimal;

/**
 * 一对一查询结果
 */
public class OrderExpressDetail {

    private String orderNo;
    private String userId;
    private BigDecimal amount;

    private OrderExpress orderExpress;

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

    public OrderExpress getOrderExpress() {
        return orderExpress;
    }

    public void setOrderExpress(OrderExpress orderExpress) {
        this.orderExpress = orderExpress;
    }

    @Override
    public String toString() {
        return "OrderExpressDetail{" +
                "orderNo='" + orderNo + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", orderExpress=" + orderExpress +
                '}';
    }
}
