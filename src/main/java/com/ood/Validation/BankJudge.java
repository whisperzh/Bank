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
 * Validation of Bank
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
        String standard_regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(standard_regex);
        if (password == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean check_integer(String recipient_number) {
        try {
            Integer.parseInt(recipient_number);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean check_ssn(String ssn) {
        int length = String.valueOf(ssn).length();
        if (length != 9) {
            return false;
        }
        return true;
    }

    public static boolean check_emailAddress(String emailAddress) {
        String regexPattern = "^(.+)@(\\\\S+)$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public boolean canPayForLoan(IAccount account, AbsLoan loan)
    {
        if(account.getRegularBalance()>=loan.getAmount())
            return true;
        return false;
    }

    public boolean canUpdateStock(String uid){
        UserBean bean= db.getUserbean(uid);
        if(bean.isAdmin())
            return true;
        return false;
    }

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

    public boolean isUserInDebt(String uid){
        List<LoanBean> loans=db.getLoanBean(uid);
        if(loans.size()>0)
            return true;
        return false;
    }

    public boolean isAccountExistByEmail(String uid,String email){
        return db.getAccountBean(uid,email)!=null;
    }
    public boolean canLogin(String username,String password){
        if(db.getUserbean(username, password)!=null)
            return true;
        return false;
    }
    public boolean isUserAdmin(String uid){
        UserBean bean=db.getUserbean(uid);
        return isUserAdmin(uid);
    }

    public boolean canCreateSecurityAccount(String uid) {
        double userAmount = db.getTotalAmountForUser(uid);
        if(userAmount > 5000){
            return true;
        }
        return false;
    }

    public boolean checkCorrectCombination(String username, String password, String ssn) {
        UserBean userbean = db.getUserbean(username, password);
        if(userbean.getSsn().equals(ssn)){
            return true;
        }
        return false;
    }
}
