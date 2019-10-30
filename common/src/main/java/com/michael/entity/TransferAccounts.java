package com.michael.entity;

/**
 * 转账
 */
public class TransferAccounts {

    private String payee;//收款人 userName

    private String drawee; //付款人 userName

    private Double money; //转账金额

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getDrawee() {
        return drawee;
    }

    public void setDrawee(String drawee) {
        this.drawee = drawee;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
