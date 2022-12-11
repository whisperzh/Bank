package com.ood.Factories;

import com.ood.Model.Accounts.*;

public class AccountFactory {
    public static IAccount createAccount(String accountType, AccountBean bean){
        if(accountType == null || accountType.isEmpty()){
            return null;
        }
        IAccount account = null;
        switch(accountType){
            case "saving":
                account= new SavingAccount(bean);
                break;
            case "checking":
                account = new CheckingAccount(bean);
                break;
            case "security":
                account = new SecurityAccount(bean);
                break;
//                throw new IllegalArgumentException("You can only create saving, checking, security account. You have entered "+accountType);
        }
        return account;
    }
}
