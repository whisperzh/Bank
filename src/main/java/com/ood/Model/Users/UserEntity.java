package com.ood.Model.Users;

import com.ood.Controllers.LoanController;
import com.ood.Controllers.UserControllerManager;
import com.ood.Factories.AccountFactory;
import com.ood.Model.Accounts.*;
import com.ood.Utils.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for maintaining functionality related to qll users
 */
public abstract class UserEntity implements IUser{
    private UserBean bean;
    private List<IAccount> accounts;

    private LoanController loanController;

    public UserEntity(UserBean bean) {
        this.bean = bean;
        initAccounts();
        loanController= UserControllerManager.getInstance().getLoanController();
    }


    public void initAccounts(){
        accounts=new ArrayList<>();
        DatabaseManager dbManager=DatabaseManager.getInstance();
        List<AccountBean> beans=dbManager.getUsersAccounts(bean.getSsn());
        if(beans==null)
            return;
        for(int i=0;i<beans.size();i++)
        {
            IAccount account = null;
            account= AccountFactory.createAccount(beans.get(i));
            accounts.add(account);
        }
    }

    @Override
    public IAccount getUserCheckingAccount() {
        for(IAccount i: accounts)
        {
            if(i instanceof CheckingAccount)
                return i;
        }
        return null;
    }

    @Override
    public IAccount getUserSavingAccount() {
        for(IAccount i: accounts)
        {
            if(i instanceof SavingAccount)
                return i;
        }
        return null;
    }

    @Override
    public IAccount getUserSecurityAccount() {
        for(IAccount i: accounts)
        {
            if(i instanceof SecurityAccount)
                return i;
        }
        return null;
    }
}
