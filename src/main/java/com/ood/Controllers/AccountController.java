package com.ood.Controllers;

import com.ood.Model.Accounts.AbsAccount;
import com.ood.Utils.Constants;
import com.ood.Utils.DatabaseManager;
import com.ood.Validation.BankJudge;

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
            // TODO
        }
    }

    public void sellStock(String sid)
    {
        // TODO
    }

    public AbsAccount getControlledAccount() {
        return controlledAccount;
    }

    public void setControlledAccount(AbsAccount controlledAccount) {
        this.controlledAccount = controlledAccount;
    }


}
