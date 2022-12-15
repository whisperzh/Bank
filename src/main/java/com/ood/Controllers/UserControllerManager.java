package com.ood.Controllers;

import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Users.UserEntity;
import com.ood.Utils.DatabaseManager;
import com.ood.Validation.BankJudge;
import com.ood.Views.HomePage;
import com.ood.Views.ViewContainer;

/**
 * Manager has several controllers and controls all users actions
 */
public class UserControllerManager {
    private UserEntity controlling_user;
    private DatabaseManager dbManager;
    private HomePage view;
    private ViewContainer viewContainer;
    private BankJudge bankJudge;
    public UserControllerManager() {
        viewContainer=ViewContainer.getInstance();
        dbManager=DatabaseManager.getInstance();
        bankJudge=BankJudge.getInstance();
        view = (HomePage) viewContainer.getPage("HomePage");
    }

    public void closeAccount(String aid){
        if(bankJudge.canCloseAccount(aid))
            dbManager.deletAccount(aid);
    }

    public void openAccount(AccountBean bean){
        dbManager.insertAccountBean(bean);
    }

    public UserEntity getControlling_user() {
        return controlling_user;
    }

    public void setControlling_user(UserEntity controlling_user) {
        this.controlling_user = controlling_user;
    }

    public void showLogin() {
        view.setVisible(true);
    }
}
