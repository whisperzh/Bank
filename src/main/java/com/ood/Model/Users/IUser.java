package com.ood.Model.Users;

import com.ood.Model.Accounts.IAccount;

/**
 * Interface for maintaining a user in the bank. This interface defines all the common functionality that is required for each user to have in the bank
 */
public interface IUser {
    public void initAccounts();
    IAccount getUserCheckingAccount();
    IAccount getUserSavingAccount();
    IAccount getUserSecurityAccount();

}
