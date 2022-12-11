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

    @Override
    public Deposits getDeposits() {
        return deposits;
    }

    @Override
    public void setDeposits(Deposits deposits) {
        this.deposits = deposits;
    }
    @Override
    public AccountBean getBean() {
        return bean;
    }
    @Override
    public void setBean(AccountBean bean) {
        this.bean = bean;
    }
    @Override
    public void addMoney(double amount)
    {
        deposits.addAmount(amount);
    }
    @Override
    public double getRegularBalance() {
        return deposits.getUSDAmount();
    }

    public TransactionController getTransactionController() {
        return transactionController;
    }
}
