package com.ood.Model.Accounts;

import com.ood.Model.Deposits;

public interface IAccount {
    public Deposits getDeposits();
    public void setDeposits(Deposits deposits);
    public AccountBean getBean();
    public void setBean(AccountBean bean);
}
