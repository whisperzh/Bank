package com.ood.Model.Accounts;

import com.ood.Controllers.TransactionController;
import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Balance.BalanceBean;
import com.ood.Model.Balance.Deposits;
import com.ood.Utils.DatabaseManager;

import java.util.List;

public abstract class AbsAccount implements IAccount{
    private AccountBean bean;
    private Deposits deposits;
    private DatabaseManager db;
    private TransactionController transactionController;

    /**
     * Concrete class that holds common properties possessed by each account
     */
    public AbsAccount(AccountBean bean) {
        this.bean = bean;
        transactionController=new TransactionController(bean.getAid());
        db=DatabaseManager.getInstance();
        List<BalanceBean> balanceBeans=db.getBalanceBean(bean.getAid());
        deposits=new Deposits();
        for(BalanceBean b:balanceBeans)
        {
            if(b.getCurrencyEnum().equals(CurrencyEnum.USD))
            {
                deposits.setUSDAmount(b.getAmount());
            }else if(b.getCurrencyEnum().equals(CurrencyEnum.EUR))
            {
                deposits.setEURAmount(b.getAmount());
            }else if(b.getCurrencyEnum().equals(CurrencyEnum.JPY))
            {
                deposits.setJPYAmount(b.getAmount());
            }
        }

//        DatabaseManager.getInstance()
    }

    public double getBalance(){
        return deposits.getUSDAmount();
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

    @Override
    public void updateDeposits() {
        deposits=new Deposits();
        List<BalanceBean> balanceBeans=db.getBalanceBean(bean.getAid());
        for(BalanceBean b:balanceBeans)
        {
            if(b.getCurrencyEnum().equals(CurrencyEnum.USD))
            {
                deposits.setUSDAmount(b.getAmount());
            }else if(b.getCurrencyEnum().equals(CurrencyEnum.EUR))
            {
                deposits.setEURAmount(b.getAmount());
            }else if(b.getCurrencyEnum().equals(CurrencyEnum.JPY))
            {
                deposits.setJPYAmount(b.getAmount());
            }
        }
    }
}
