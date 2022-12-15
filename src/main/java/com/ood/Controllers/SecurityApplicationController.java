package com.ood.Controllers;

import com.ood.Enums.AccountEnum;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Users.UserBean;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;
import com.ood.Validation.BankJudge;
import com.ood.Views.SecurityApplication;
import com.ood.Views.ViewContainer;

import javax.swing.*;
import java.util.Dictionary;

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

    public void openAccount(Dictionary bean){
        validateSecondForm(bean);
        if(bankJudge.canCreateSecurityAccount(uid)) {
            String username = bean.get("username").toString();
            String password = bean.get("password").toString();
            String uid = bean.get("ssn").toString();
            String email = bean.get("email").toString();
            String amount = bean.get("amount").toString();
            String aid = Utils.generateRandomUUID();
            AccountEnum accountType= AccountEnum.StringtoType("SECURITY");
            //todo have to deduct money from other account
            //todo have to insert a new balance record
            if(!(Integer.parseInt(amount)>1000)){
                JOptionPane.showMessageDialog(view, "The minimum amount of transfer must be over 1000 dollars");
            }
            if(!bankJudge.checkCorrectCombination(username, password, uid)){
                JOptionPane.showMessageDialog(view, "Data mismatch occurred. Please verify ssn provided");
            }
            AccountBean b = new AccountBean();
            b.setUid(uid);
            b.setAccountEnum(accountType);
            b.setEmail(email);
            b.setAid(aid);
            dbManager.insertAccountBean(b);
            JOptionPane.showMessageDialog(view, "A new security account has been opened for user with ssn "+uid);
        }
        JOptionPane.showMessageDialog(view, "You do not have sufficient balance to open a security account.\nMinimum required balance is 5000 dollars");;
    }

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
