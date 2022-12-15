package com.ood.Model.Transactions;

import com.ood.Enums.CurrencyEnum;

/**
 * Concrete class that contains all the attributes and methods required to perform transactions in the Bank
 */
public class TransactionBean {

    private String tid;
    private String from_aid;
    private String to_aid;
    private double amount;
    private CurrencyEnum currencyEnum;
    private String timeStamp;
    private String fromName;
    private String toName;

    public String getFrom_aid() {
        return from_aid;
    }

    public void setFrom_aid(String from_aid) {
        this.from_aid = from_aid;
    }

    public String getTo_aid() {
        return to_aid;
    }

    public void setTo_aid(String to_aid) {
        this.to_aid = to_aid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CurrencyEnum getCurrencyEnum() {
        return currencyEnum;
    }

    public void setCurrencyEnum(CurrencyEnum currencyEnum) {
        this.currencyEnum = currencyEnum;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}
