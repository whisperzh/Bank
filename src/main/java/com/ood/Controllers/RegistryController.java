package com.ood.Controllers;

import com.ood.Enums.AccountEnum;
import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Balance.BalanceBean;
import com.ood.Model.Users.UserBean;
import com.ood.Utils.Constants;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;
import com.ood.Validation.BankJudge;
import com.ood.Views.SavingsApplication;
import com.ood.Views.ViewContainer;

import javax.swing.*;
import java.util.Dictionary;
import java.util.List;

/**
 * Controller Class for handling registered users and for connecting between user accounts in front end, validation using bankJudge and data in the backend
 */
public class RegistryController {

    private SavingsApplication view;
    private DatabaseManager dbManager;
    private ViewContainer viewContainer;

    private BankJudge bankJudge;
    public RegistryController() {
        dbManager=DatabaseManager.getInstance();
        bankJudge=BankJudge.getInstance();
        viewContainer = ViewContainer.getInstance();
        view= (SavingsApplication) viewContainer.getPage("SavingsApplication");
        view.setController(this);
        view.getjPanel2().setVisible(false);
        view.getjLabel7().setVisible(true);
    }
    public void register(UserBean bean)
    {
        DatabaseManager dbm=DatabaseManager.getInstance();
        if(dbm.hasUserBean(bean))
        {
            view.getjLabel8().setVisible(true);
        }else
        {
            dbm.insertUserBean(bean);
            view.getjLabel8().setVisible(false);
        }
    }

    //handle validation of the first form passed from Views - Savings Application
    public void validateFirstForm(Dictionary userDetails){

        String email = userDetails.get("email").toString();
        String ssn = userDetails.get("ssn").toString();
        String birthdate = userDetails.get("birthdate").toString();

        int flag = 0;
        if(!BankJudge.getInstance().check_integer(ssn) || !BankJudge.getInstance().check_ssn(ssn)){
            JOptionPane.showMessageDialog(view, "Please enter a valid social security number of 9 digits");
            flag = 1;
        }
        if(email.equals("") || !BankJudge.getInstance().check_emailAddress(email)){
            JOptionPane.showMessageDialog(view, "Please enter a valid email address");
            flag = 1;
        }
        if(!BankJudge.getInstance().check_birthdate(birthdate)){
            JOptionPane.showMessageDialog(view, "Please enter a valid birth date in the yyyy-mm-dd format");
            flag = 1;
        }
        if(flag == 0){
            view.getjPanel2().setVisible(true);
            view.getjLabel7().setVisible(true);
            UserBean tempBean = DatabaseManager.getInstance().getUserbean(ssn);
            if(tempBean == null){
                view.getjLabel8().setVisible(false);
            }
            else
            {
                view.getjLabel8().setVisible(true);
            }
        }
    }

    public void secondFormValidation(Dictionary bean){
        String username = bean.get("username").toString();
        String password = bean.get("password").toString();
        String uid = bean.get("ssn").toString();
        String email = bean.get("email").toString();
        Double amount = Double.parseDouble(bean.get("amount").toString());
        String amountStr = bean.get("amount").toString();
        String birthdate = bean.get("birthdate").toString();
        String first = bean.get("first").toString();
        String last = bean.get("last").toString();

        UserBean tempBean = DatabaseManager.getInstance().getUserbean(uid);


        Boolean checking = (Boolean)bean.get("checking");
        String aid = Utils.generateRandomUUID();
        int flag = 0;
        if(!(BankJudge.getInstance().checkPassword(password))){
            JOptionPane.showMessageDialog(view, "Please enter a valid password. \nPassword must have:\n-at least 8 characters and at most 20 characters\n-at least one digit\n-at least one upper case alphabet.\n -at least one lower case alphabet.\n-at least one special character which includes !@#$%&*()-+=^.\n-should not contain any white space.");
            flag = 1;
        }

        if(!(BankJudge.getInstance().check_integer(amountStr))){
            JOptionPane.showMessageDialog(view, "Please enter a valid amount");
            flag = 1;
        }
        if(flag == 0){
            UserBean userbean = new UserBean();
            userbean.setAdmin(false);
            userbean.setBirthday(birthdate);
            userbean.setPassword(password);
            userbean.setSsn(uid);
            userbean.setFirstName(first);
            userbean.setLastName(last);
            userbean.setUserName(username);

            //create the user in the database if his record does not exist
            register(userbean);

            AccountEnum accountType= AccountEnum.StringtoType("SAVINGS");
            AccountBean b = new AccountBean();
            b.setUid(uid);
            b.setAccountEnum(accountType);
            b.setEmail(email);
            b.setAid(aid);
            int savingsAccountFlag = 0;
            int checkingsAccountFlag = 0;

            List<AccountBean> userAccounts = dbManager.getUsersAccounts(uid);
            for(AccountBean abean: userAccounts){
                if(abean.getAccountEnum().toString() == "SAVINGS"){
                    savingsAccountFlag = 1;
                }
                if(abean.getAccountEnum().toString() == "CHECKINGS"){
                    checkingsAccountFlag = 1;
                }
            }
            BalanceBean balanceBean = new BalanceBean();
            if(savingsAccountFlag == 0){
                dbManager.insertAccountBean(b);
                //create a balance record for the user
                balanceBean.setAid(aid);
                //create a record in balance table with amount-fee
                balanceBean.setAmount(amount- Constants.OPEN_ACCOUNT_FEE);
                balanceBean.setCurrencyEnum(CurrencyEnum.toType("USD"));
                dbManager.insertBalanceBean(balanceBean);
                JOptionPane.showMessageDialog(view, "A new savings account has been opened for user with ssn "+uid);
            }
            else
            {
                JOptionPane.showMessageDialog(view, "Savings account already exists for user with ssn "+uid);
            }
            //if user also wants a checking account
            if(checking == true){
                String aid2 = Utils.generateRandomUUID();
                b.setAid(aid2);
                accountType= AccountEnum.StringtoType("CHECKINGS");
                b.setAccountEnum(accountType);
                if(checkingsAccountFlag == 0){
                    dbManager.insertAccountBean(b);
                    balanceBean.setAid(aid2);
                    //create a 0 balance checking account
                    balanceBean.setAmount(0);
                    balanceBean.setCurrencyEnum(CurrencyEnum.toType("USD"));
                    dbManager.insertBalanceBean(balanceBean);
                    JOptionPane.showMessageDialog(view, "A new checking account has been opened for user with ssn "+uid);
                }
                else{
                    JOptionPane.showMessageDialog(view, "Checking account already exists for user with ssn "+uid);
                }
            }
        }
    }
}
