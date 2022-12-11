package com.ood.Controllers;

import com.ood.Model.Accounts.AbsAccount;

public class AccountController {
    private AbsAccount controlledAccount;

    public void sendMoneyTo(String aid){

    }
    public AbsAccount getControlledAccount() {
        return controlledAccount;
    }

    public void setControlledAccount(AbsAccount controlledAccount) {
        this.controlledAccount = controlledAccount;
    }
}
