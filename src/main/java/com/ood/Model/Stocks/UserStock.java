package com.ood.Model.Stocks;

/**
 * Concrete class for maintaining functionality that associates the user to the stock owned by them.
 */
public class UserStock {
    private String sid;
    private String aid;
    private double proportion;
    private String stock_buy_time;
    private String last_update_time;

    public UserStock() {
    }

    public UserStock(String sid, String aid, double proportion, String stock_buy_time) {
        this.sid = sid;
        this.aid = aid;
        this.proportion = proportion;
        this.stock_buy_time = stock_buy_time;
        this.last_update_time = stock_buy_time;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    public String getStock_buy_time() {
        return stock_buy_time;
    }

    public void setStock_buy_time(String stock_buy_time) {
        this.stock_buy_time = stock_buy_time;
    }

    public String getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(String last_update_time) {
        this.last_update_time = last_update_time;
    }
}
