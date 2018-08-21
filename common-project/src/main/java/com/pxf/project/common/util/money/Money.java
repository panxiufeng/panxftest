package com.pxf.project.common.util.money;


import java.io.Serializable;
import java.math.BigDecimal;

public class Money implements Serializable {
    private static final long serialVersionUID = -5881129379387774925L;
    private BigDecimal money;
    private String currency = "RMB";

    public Money(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return this.money.setScale(4, 4);
    }

    public BigDecimal getTwoMoney() {
        return this.money.setScale(2, 4);
    }

    public void setMoney(BigDecimal money) {
        this.money = money.setScale(4, 4);
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
