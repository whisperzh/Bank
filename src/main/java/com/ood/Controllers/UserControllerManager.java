package com.ood.Controllers;

import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Users.UserEntity;
import com.ood.Utils.DatabaseManager;
import com.ood.Validation.BankJudge;
import com.ood.Views.HomePage;
import com.ood.Views.ViewContainer;

/**
 * Controller Class where Manager has several controllers and controls all users actions
 */
public class UserControllerManager {
    private UserEntity controlling_user;
    private DatabaseManager dbManager;
    private HomePage view;
    private ViewContainer viewContainer;
    private BankJudge bankJudge;
    private boolean isLoggedin;
    private AccountController accountController;
    private LoanController loanController;
    private LoginController loginController;
    private RegistryController registryController;
    private SecurityApplicationController securityApplicationController;
    private StockController stockController;
    private static UserControllerManager userControllerManager;
    public static UserControllerManager getInstance(){
        if(userControllerManager==null)
            userControllerManager=new UserControllerManager();
        return userControllerManager;
    }
    public UserControllerManager() {
        viewContainer=ViewContainer.getInstance();
        dbManager=DatabaseManager.getInstance();
        bankJudge=BankJudge.getInstance();
        view = (HomePage) viewContainer.getPage("HomePage");
        view.setControllerManager(this);
        initControllers();
    }
    private void initControllers(){
        accountController=new AccountController();
        loanController=new LoanController();
        loginController=new LoginController();
        registryController=new RegistryController();
        securityApplicationController=new SecurityApplicationController();
        stockController=new StockController();
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

    public AccountController getAccountController() {
        return accountController;
    }

    public LoanController getLoanController() {
        return loanController;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public RegistryController getRegistryController() {
        return registryController;
    }

    public SecurityApplicationController getSecurityApplicationController() {
        return securityApplicationController;
    }

    public StockController getStockController() {
        return stockController;
    }

    public boolean isLoggedin() {
        return isLoggedin;
    }

    public void setLoggedin(boolean loggedin) {
        isLoggedin = loggedin;
    }
}
