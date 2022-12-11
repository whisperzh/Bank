package com.ood.Validation;

import com.ood.Model.Accounts.IAccount;
import com.ood.Model.Loan.AbsLoan;

public class BankJudge {
    public static boolean canPayForLoan(IAccount account, AbsLoan loan)
    {
        if(account.getRegularBalance()>=loan.getAmount())
            return true;
        return false;
    }
}
