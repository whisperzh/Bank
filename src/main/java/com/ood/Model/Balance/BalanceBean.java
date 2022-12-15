package com.ood.Model.Balance;

import com.ood.Enums.CurrencyEnum;

/**
 * Concrete class that contains all the attributes and methods required to maintain a bank balance in the Bank
 */
public class BalanceBean {
    private String aid;
    private CurrencyEnum currencyEnum;
    private double amount;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public CurrencyEnum getCurrencyEnum() {
        return currencyEnum;
    }

    public void setCurrencyEnum(CurrencyEnum currencyEnum) {
        this.currencyEnum = currencyEnum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
