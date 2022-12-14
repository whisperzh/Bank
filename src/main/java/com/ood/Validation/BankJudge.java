package com.ood.Validation;

import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Accounts.AbsAccount;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Accounts.IAccount;
import com.ood.Model.Accounts.SecurityAccount;
import com.ood.Model.Balance.BalanceBean;
import com.ood.Model.Loan.AbsLoan;
import com.ood.Model.Stocks.StockBean;
import com.ood.Model.Users.UserBean;
import com.ood.Utils.Constants;
import com.ood.Utils.DatabaseManager;

import java.util.List;

public class BankJudge {

    private DatabaseManager db;

    private static BankJudge bankJudge;

    public BankJudge() {
        this.db = DatabaseManager.getInstance();
    }

    public static BankJudge getInstance(){
        if(bankJudge==null)
            bankJudge=new BankJudge();
        return bankJudge;
    }
    public boolean canPayForLoan(IAccount account, AbsLoan loan)
    {
        if(account.getRegularBalance()>=loan.getAmount())
            return true;
        return false;
    }

    public boolean canUpdateStock(String uid){
        UserBean bean= db.getUserbean(uid);
        if(bean.isAdmin())
            return true;
        return false;
    }

    public boolean canWithdraw(AbsAccount controlledAccount, double amount) {
        double balance = controlledAccount.getRegularBalance();
        if(Constants.WITHDRAW_FEE+balance>=amount)
        {
            return true;
        }
        return false;
    }

    public boolean canBuyStock(AbsAccount controlledAccount,float stockProportion,String sid) {
        if(controlledAccount instanceof SecurityAccount)
        {
            StockBean bean=db.getStock(sid);
            double price=stockProportion*bean.getPrice();
            if(Constants.BUY_STOCK_FEE+price>= controlledAccount.getRegularBalance())
                return true;
        }
        return false;
    }

    public boolean canCloseAccount(String aid) {
         List<BalanceBean> beans= db.getBalanceBean(aid);
        for(int i=0;i<beans.size();i++)
        {
            BalanceBean bean=beans.get(i);
            if(bean.getCurrencyEnum().equals(CurrencyEnum.USD))
            {
                if(bean.getAmount()>=Constants.CLOSE_ACCOUNT_FEE)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
}