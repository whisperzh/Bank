package com.ood.Model.Users;

import com.ood.Model.Accounts.IAccount;

public interface IUser {
    public void initAccounts();
    IAccount getUserCheckingAccount();
    IAccount getUserSavingAccount();
    IAccount getUserSecurityAccount();

}
