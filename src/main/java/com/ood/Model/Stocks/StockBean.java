package com.ood.Model.Stocks;

/**
 * Concrete class that contains all the attributes and methods required to maintain stocks in the Bank
 */
public class StockBean {
    private String sid;
    private String company;
    private double price;
    private String last_update_time;

    public StockBean() {
    }

    public StockBean(String sid, String company, double price, String last_update_time) {
        this.sid = sid;
        this.company = company;
        this.price = price;
        this.last_update_time = last_update_time;
    }

    public String getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(String last_update_time) {
        this.last_update_time = last_update_time;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
