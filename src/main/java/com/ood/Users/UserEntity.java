package com.ood.Users;

import com.ood.Accounts.IAccount;

public class UserEntity implements IUser{
    private UserBean bean;
    private IAccount checkingAccount;
    private IAccount savingAccount;
    private IAccount securityAccount;

}
