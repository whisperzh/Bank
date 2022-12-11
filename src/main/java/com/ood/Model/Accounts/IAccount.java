package com.ood.Model.Accounts;

import com.ood.Model.Deposits;

public interface IAccount {
    Deposits getDeposits();
    void setDeposits(Deposits deposits);
    AccountBean getBean();
    void setBean(AccountBean bean);
    double getRegularBalance();
    void addMoney(double amount);
}
