package com.ood.Controllers;

import com.ood.Model.Accounts.AbsAccount;

public class AccountController {
    private AbsAccount controlledAccount;

    public void sendMoneyTo(String to_aid,double amount){
        controlledAccount.getTransactionController().createTransaction(
                controlledAccount.getBean().getAid(),to_aid,amount);
    }
    public AbsAccount getControlledAccount() {
        return controlledAccount;
    }

    public void setControlledAccount(AbsAccount controlledAccount) {
        this.controlledAccount = controlledAccount;
    }
}
