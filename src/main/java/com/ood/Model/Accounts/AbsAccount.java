package com.ood.Model.Accounts;

import com.ood.Controllers.TransactionController;
import com.ood.Model.Deposits;

public abstract class AbsAccount implements IAccount{
    private AccountBean bean;

    private Deposits deposits;

    private TransactionController transactionController;

    public AbsAccount(AccountBean bean) {
        this.bean = bean;
        transactionController=new TransactionController(bean.getAid());
    }

    public Deposits getDeposits() {
        return deposits;
    }

    public void setDeposits(Deposits deposits) {
        this.deposits = deposits;
    }

    public AccountBean getBean() {
        return bean;
    }

    public void setBean(AccountBean bean) {
        this.bean = bean;
    }

    public void addMoney(double amount)
    {
        deposits.addAmount(amount);
    }
    @Override
    public double getRegularBalance() {
        return deposits.getUSDAmount();
    }

    @Override
    public void addAmount(double amount) {

    }
}
