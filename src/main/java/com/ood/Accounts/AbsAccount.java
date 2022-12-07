package com.ood.Accounts;

public abstract class AbsAccount implements IAccount{
    private AccountBean bean;

    public AccountBean getBean() {
        return bean;
    }

    public void setBean(AccountBean bean) {
        this.bean = bean;
    }
}
