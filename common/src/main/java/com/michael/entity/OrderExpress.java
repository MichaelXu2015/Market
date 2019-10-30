package com.michael.entity;

/**
 * order_express订单快递表
 */
public class OrderExpress {

    private String expressId;
    private String orderNo;//订单编号
    private String expressName;//快递名称
    private String expressNo;//快递单号

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    @Override
    public String toString() {
        return "OrderExpress{" +
                "expressId='" + expressId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", expressName='" + expressName + '\'' +
                ", expressNo='" + expressNo + '\'' +
                '}';
    }
}
