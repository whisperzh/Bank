package com.ood.Model.Accounts;

import com.ood.Model.Balance.Deposits;

/**
 * Interface for maintaining an account. This interface defines all the common functionality that is required for each user with an account in the bank
 */
public interface IAccount {
    Deposits getDeposits();
    void setDeposits(Deposits deposits);
    AccountBean getBean();
    void setBean(AccountBean bean);
    double getRegularBalance();
    void addMoney(double amount);

    void updateDeposits();
}
