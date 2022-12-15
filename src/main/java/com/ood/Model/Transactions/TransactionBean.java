package com.ood.Model.Transactions;

import com.ood.Enums.CurrencyEnum;

public class TransactionBean {

    private String tid;
    private String from_uid;
    private String to_uid;
    private double amount;
    private CurrencyEnum currencyEnum;
    private String timeStamp;
    private String fromName;
    private String toName;

    public String getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(String from_uid) {
        this.from_uid = from_uid;
    }

    public String getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(String to_uid) {
        this.to_uid = to_uid;
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
