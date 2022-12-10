package com.ood.Model.Users;

import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Accounts.CheckingAccount;
import com.ood.Model.Accounts.IAccount;
import com.ood.Model.Deposits;
import com.ood.Model.Loan.Loan;
import com.ood.Model.Loan.LoanController;
import com.ood.Utils.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

public class UserEntity implements IUser{
    private UserBean bean;
    private List<IAccount> accounts;

    private LoanController loanController;

    public UserEntity(UserBean bean) {
        this.bean = bean;
        initAccounts();
        loanController=new LoanController(bean.getSsn());
    }

    // TODO implementation
    public void initAccounts(){
        accounts=new ArrayList<>();
        DatabaseManager dbManager=DatabaseManager.getDbManager();
        List<AccountBean> beans=dbManager.getUsersAccounts(bean.getSsn());
        for(int i=0;i<beans.size();i++)
        {
            IAccount account = null;
            accounts.add(account);
        }
    }
}
