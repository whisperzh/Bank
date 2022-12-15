package com.ood.Factories;

import com.ood.Model.Accounts.*;
/**
 * Factory that generates Account of the required type using the appropriate classes
 */
public class AccountFactory {
    public static IAccount createAccount( AccountBean bean){
        IAccount account = null;
        switch(bean.getAccountEnum()){
            case SAVINGS:
                account= new SavingAccount(bean);
                break;
            case CHECKINGS:
                account = new CheckingAccount(bean);
                break;
            case SECURITY:
                account = new SecurityAccount(bean);
                break;
//                throw new IllegalArgumentException("You can only create saving, checking, security account. You have entered "+accountType);
        }
        return account;
    }
}
