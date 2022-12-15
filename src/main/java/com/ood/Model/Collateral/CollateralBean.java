package com.ood.Model.Collateral;

import com.ood.Enums.AccountEnum;

/**
 * Concrete class that contains all the attributes and methods required to maintain a Collateral in the Bank
 */
public class CollateralBean {
    private String name;
    private double value;
    private String cid;
    private String lid;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }
}
