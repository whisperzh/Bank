package com.ood.Validation;

import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Accounts.AbsAccount;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Accounts.IAccount;
import com.ood.Model.Accounts.SecurityAccount;
import com.ood.Model.Balance.BalanceBean;
import com.ood.Model.Loan.AbsLoan;
import com.ood.Model.Loan.LoanBean;
import com.ood.Model.Stocks.StockBean;
import com.ood.Model.Users.UserBean;
import com.ood.Utils.Constants;
import com.ood.Utils.DatabaseManager;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validation classs for all components
 * This class handles all required checks - including those for integer components,verifications required from database
 */
public class BankJudge {

    private DatabaseManager db;

    private static BankJudge bankJudge;

    public BankJudge() {
        this.db = DatabaseManager.getInstance();
    }

    public static BankJudge getInstance(){
        if(bankJudge==null)
            bankJudge=new BankJudge();
        return bankJudge;
    }

    public static boolean checkPassword(String password)
    {
        //password must match the following criteria:
        //a digit must occur at least once.
        //a lower case alphabet must occur at least once.
        //an upper case alphabet must occur at least once.
        //a special character must occur at least once.
        //white spaces are not allowed
        //password must be between 8 and 20 characters long
        /***String standard_regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";***/
        String standard_regex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$";
        Pattern pattern = Pattern.compile(standard_regex);
        if (password == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(password);
        System.out.println(matcher.matches());
        return matcher.matches();
    }

    //check for integers passed as strings
    public static boolean check_integer(String recipient_number) {
        try {
            Integer.parseInt(recipient_number);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    //check whether the provided social security number matches the set standard - i.e. it is a number that is 9 digits long
    public static boolean check_ssn(String ssn) {
        int length = String.valueOf(ssn).length();
        if (length != 9) {
            return false;
        }
        return true;
    }

    //check whether the supplied string is actually an email address
    public static boolean check_emailAddress(String emailAddress) {
        String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean check_birthdate(String date){
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.compile(regex)
                .matcher(date)
                .matches();
    }

    //verify whether a user who takes out a loan can actually repay the loan
    public boolean canPayForLoan(IAccount account, AbsLoan loan)
    {
        if(account.getRegularBalance()>=loan.getAmount())
            return true;
        return false;
    }

    //verify whether the user is authorised to update stocks
    public boolean canUpdateStock(String uid){
        UserBean bean= db.getUserbean(uid);
        if(bean.isAdmin())
            return true;
        return false;
    }

    //verify whether the user has enough money to make a withdrawal after paying the withdrawal fee
    public boolean canWithdraw(AbsAccount controlledAccount, double amount) {
        double balance = controlledAccount.getRegularBalance();
        if(Constants.WITHDRAW_FEE+balance>=amount)
        {
            return true;
        }
        return false;
    }

    public boolean canBuyStock(AbsAccount controlledAccount,float stockProportion,String sid) {
        if(controlledAccount instanceof SecurityAccount)
        {
            StockBean bean=db.getStock(sid);
            double price=stockProportion*bean.getPrice();
            if(Constants.BUY_STOCK_FEE+price>= controlledAccount.getRegularBalance())
                return true;
        }
        return false;
    }

    //verify whether the user has enough money to be able to close his account
    public boolean canCloseAccount(String aid) {
         List<BalanceBean> beans= db.getBalanceBean(aid);
        for(int i=0;i<beans.size();i++)
        {
            BalanceBean bean=beans.get(i);
            if(bean.getCurrencyEnum().equals(CurrencyEnum.USD))
            {
                if(bean.getAmount()>=Constants.CLOSE_ACCOUNT_FEE)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    //verify whether the user already has loans associated to himself
    public boolean isUserInDebt(String uid){
        List<LoanBean> loans=db.getLoanBean(uid);
        if(loans.size()>0)
            return true;
        return false;
    }

    //verify whether the uses exists using his email and uid
    public boolean isAccountExistByEmail(String uid,String email){
        return db.getAccountBean(uid,email)!=null;
    }

    //veirfy whether the user can login using the given username, password combination
    public boolean canLogin(String username,String password){
        if(db.getUserbean(username, password)!=null)
            return true;
        return false;
    }

    //check whether the user is an administrator
    public boolean isUserAdmin(String uid){
        UserBean bean=db.getUserbean(uid);
        return isUserAdmin(uid);
    }

    //verify whether the user has a sum of more than 5000 dollars in all his accounts so that he is eligible to open a security account
    public boolean canCreateSecurityAccount(String uid) {
        double userAmount = db.getTotalAmountForUser(uid);
        if(userAmount > 5000){
            return true;
        }
        return false;
    }

    //verify whether the username,password combination of a user matches his existing ssn
    public boolean checkCorrectCombination(String username, String password, String ssn) {
        UserBean userbean = db.getUserbean(username, password);
        if(userbean.getSsn().equals(ssn)){
            return true;
        }
        return false;
    }
}
