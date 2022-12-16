package com.ood.Controllers;

import com.ood.Enums.AccountEnum;
import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Balance.BalanceBean;
import com.ood.Utils.Constants;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;
import com.ood.Validation.BankJudge;
import com.ood.Views.SecurityApplication;
import com.ood.Views.ViewContainer;

import javax.swing.*;
import java.util.Dictionary;
import java.util.List;

/**
 * Controller Class for handling security accounts, connection between user accounts in front end, validation using bankJudge and data in the backend
 */

public class SecurityApplicationController {
    private SecurityApplication view;
    private DatabaseManager dbManager;
    private ViewContainer viewContainer;

    private BankJudge bankJudge;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public SecurityApplicationController() {
        dbManager=DatabaseManager.getInstance();
        bankJudge=BankJudge.getInstance();
        viewContainer = ViewContainer.getInstance();
        view= (SecurityApplication) viewContainer.getPage("SecurityApplication");
        view.setController(this);
    }

    //handle validation of the first form passed from Views - Security Application
    public void validateFirstForm(Dictionary userDetails){

        String email = userDetails.get("email").toString();
        String ssn = userDetails.get("ssn").toString();
        int flag = 0;
        if(!BankJudge.getInstance().check_integer(ssn) || !BankJudge.getInstance().check_ssn(ssn)){
            JOptionPane.showMessageDialog(view, "Please enter a valid social security number");
            flag = 1;
        }
        if(email.equals("") || !BankJudge.getInstance().check_emailAddress(email)){
            JOptionPane.showMessageDialog(view, "Please enter a valid email address");
            flag = 1;
        }
        if(flag == 0){
            view.getjPanel2().setVisible(true);
        }
    }

    //handle validation for the second form in the Security Application using BankJudge and display appropriate message
    //if all validations pass, create a security account for the user
    public void openAccount(Dictionary bean){
        validateSecondForm(bean);
        if(bankJudge.canCreateSecurityAccount(uid)) {
            String username = bean.get("username").toString();
            String password = bean.get("password").toString();
            String uid = bean.get("ssn").toString();
            String email = bean.get("email").toString();
            Double amount = Double.parseDouble(bean.get("amount").toString());
            String amountStr = bean.get("amount").toString();
            String aid = Utils.generateRandomUUID();
            AccountEnum accountType= AccountEnum.StringtoType("SECURITY");
            //deduct money from the account having most money
            List<AccountBean> userAccounts = dbManager.getUsersAccounts(uid);
            String finalAid = "";
            String maxAid = "";
            Double maxAmt = 0.0;
            for(AccountBean abean: userAccounts){
                finalAid = abean.getAid();
                List<BalanceBean> balanceAccounts = dbManager.getBalanceBean(finalAid);
                for (BalanceBean balbean: balanceAccounts){
                    if(balbean.getAmount()>maxAmt){
                        maxAmt = balbean.getAmount();
                        maxAid = balbean.getAid();
                    }
                }
            }
            //insert a new balance record
            dbManager.updateBalance(maxAid, -(amount+ Constants.OPEN_ACCOUNT_FEE));
            BalanceBean bbean = new BalanceBean();
            bbean.setAmount(amount);
            bbean.setCurrencyEnum(CurrencyEnum.toType("USD"));
            bbean.setAid(aid);
            dbManager.insertBalanceBean(bbean);
            int flag = 0;
            if(!(BankJudge.getInstance().check_integer(amountStr))){
                JOptionPane.showMessageDialog(view, "Please enter a valid amount");
                flag = 1;
            }
            if(!(amount<1000)){
                JOptionPane.showMessageDialog(view, "The minimum amount of transfer must be over 1000 dollars");
                flag = 1;
            }
            if(!bankJudge.checkCorrectCombination(username, password, uid)){
                JOptionPane.showMessageDialog(view, "Data mismatch occurred. Please verify ssn provided");
                flag = 1;
            }
            if(flag!=1){
                AccountBean b = new AccountBean();
                b.setUid(uid);
                b.setAccountEnum(accountType);
                b.setEmail(email);
                b.setAid(aid);
                dbManager.insertAccountBean(b);
                JOptionPane.showMessageDialog(view, "A new security account has been opened for user with ssn "+uid);
            }
        }
        else{
            JOptionPane.showMessageDialog(view, "You do not have sufficient balance to open a security account.\nMinimum required balance is 5000 dollars");;
        }
    }

    //handle primary validation for the second form in the Security Application
    private void validateSecondForm(Dictionary bean) {
        String username = bean.get("username").toString();
        String password = bean.get("password").toString();
        String amount = bean.get("amount").toString();
        if(username.equals("")){
            JOptionPane.showMessageDialog(view, "Please enter a valid username");
        }
        if(!BankJudge.getInstance().checkPassword(password)){
            JOptionPane.showMessageDialog(view, "Please enter a valid password. \nPassword must have:\n-at least 8 characters and at most 20 characters\n-at least one digit\n-at least one upper case alphabet.\n -at least one lower case alphabet.\n-at least one special character which includes !@#$%&*()-+=^.\n-should not contain any white space.");
        }
        if(!BankJudge.getInstance().check_integer(amount)){
            JOptionPane.showMessageDialog(view, "Please enter a valid amount");
        }
    }

}
