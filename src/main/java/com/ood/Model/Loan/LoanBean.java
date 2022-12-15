package com.ood.Model.Loan;

import com.ood.Enums.CurrencyEnum;

/**
 * Concrete class that contains all the attributes and methods required to maintain a loan in the bank
 */
public class LoanBean {
    private String lid;
    private String uid;
    private CurrencyEnum currencyEnum;
    private double amount;
    private String date;
    private boolean is_clear;
    private String clear_date;

    public String getClear_date() {
        return clear_date;
    }

    public void setClear_date(String clear_date) {
        this.clear_date = clear_date;
    }

    public boolean isIs_clear() {
        return is_clear;
    }

    public void setIs_clear(boolean is_clear) {
        this.is_clear = is_clear;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
