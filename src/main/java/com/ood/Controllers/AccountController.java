package com.ood.Controllers;

import com.ood.Model.Accounts.AbsAccount;
import com.ood.Model.Stocks.StockBean;
import com.ood.Model.Stocks.UserStock;
import com.ood.Utils.Constants;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;
import com.ood.Validation.BankJudge;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    private AbsAccount controlledAccount;

    private DatabaseManager dbManager;

    private BankJudge bankJudge;

    public AccountController() {
        bankJudge=BankJudge.getInstance();
        dbManager=DatabaseManager.getInstance();
    }

    public void sendMoneyTo(String to_aid, double amount){
        controlledAccount.getTransactionController().createTransaction(
                controlledAccount.getBean().getAid(),to_aid,amount);
    }

    public void withdrawMoney(double amount){
        if(BankJudge.getInstance().canWithdraw(controlledAccount,amount))
        {
            dbManager.updateBalance(controlledAccount.getBean().getAid(),amount+ Constants.WITHDRAW_FEE);
        }else
        {
            //TODO alert user not enough deposites.
        }
    }

    public void addMoney(double amount){
        dbManager.updateBalance(controlledAccount.getBean().getAid(),amount+ Constants.WITHDRAW_FEE);
    }

    public void buyStock(float stockProportion,String sid){
        if(bankJudge.canBuyStock(controlledAccount,stockProportion,sid))
        {
            String aid = controlledAccount.getBean().getAid();
            StockBean bean=dbManager.getStock(sid);
            double price = stockProportion * bean.getPrice();
            List<UserStock> userStocks = dbManager.getUserStocks(aid);
            for(UserStock stock: userStocks){
                if (stock.getSid() == sid){
                    dbManager.updateUserStock(aid,sid, (double) stockProportion);
                }
                else{
                    String dateTime = Utils.getDateTime();
                    UserStock newUserStock = new UserStock(sid, aid, stockProportion, dateTime);
                    dbManager.insertUserStock(newUserStock);
                }
            }
            dbManager.updateBalance(controlledAccount.getBean().getAid(), -price);
        }
    }

    public void sellStock(String sid)
    {
        String aid = controlledAccount.getBean().getAid();
        StockBean bean=dbManager.getStock(sid);
        double price = bean.getPrice();
        double ownedProportion = dbManager.getSpecificUserStock(aid, sid).getProportion();
        double valueStock = ownedProportion * price;
        dbManager.updateBalance(controlledAccount.getBean().getAid(), valueStock);
    }

    public AbsAccount getControlledAccount() {
        return controlledAccount;
    }

    public void setControlledAccount(AbsAccount controlledAccount) {
        this.controlledAccount = controlledAccount;
    }


}
