package com.ood.Validation;

import com.ood.Model.Accounts.IAccount;
import com.ood.Model.Loan.AbsLoan;
import com.ood.Model.Users.UserBean;
import com.ood.Utils.DatabaseManager;

public class BankJudge {
    public static boolean canPayForLoan(IAccount account, AbsLoan loan)
    {
        if(account.getRegularBalance()>=loan.getAmount())
            return true;
        return false;
    }

    public static boolean canUpdateStock(String uid){
        UserBean bean= DatabaseManager.getDbManager().getUserbean(uid);
        if(bean.isAdmin())
            return true;
        return false;
    }
}
