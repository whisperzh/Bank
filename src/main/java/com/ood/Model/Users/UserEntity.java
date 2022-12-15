package com.ood.Model.Users;

import com.ood.Controllers.LoanController;
import com.ood.Controllers.UserControllerManager;
import com.ood.Factories.AccountFactory;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Accounts.IAccount;
import com.ood.Utils.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

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
            account= AccountFactory.createAccount(beans.get(i).getAccountEnum().toString(),beans.get(i));
            accounts.add(account);
        }
    }
}
