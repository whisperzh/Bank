package com.ood.Controllers;

import com.ood.Model.Accounts.AbsAccount;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Stocks.StockBean;
import com.ood.Model.Stocks.UserStock;
import com.ood.Model.Transactions.Transaction;
import com.ood.Model.Transactions.TransactionBean;
import com.ood.Utils.Constants;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;
import com.ood.Validation.BankJudge;
import com.ood.Views.*;
import java.util.List;
/**
 * Controller Class for handling connection between user accounts in front end, validation using bankJudge and data in the backend
 */
public class AccountController {
    private AbsAccount controlledAccount;
    private AccountActivity activityTab;
    private AccountDetails detailTab;
    private AccountTransfer TransferTab;
    private AccountWithdraw withdrawTab;
    private DatabaseManager dbManager;
    private ViewContainer viewContainer;
    private BankJudge bankJudge;


    public AccountController() {
        bankJudge=BankJudge.getInstance();
        dbManager=DatabaseManager.getInstance();
        viewContainer= ViewContainer.getInstance();

        detailTab= (AccountDetails) viewContainer.getPage("AccountDetails");
        detailTab.setVisible(false);
        detailTab.setAccountController(this);

        TransferTab= (AccountTransfer) viewContainer.getPage("AccountTransfer");
        TransferTab.setVisible(false);
        TransferTab.setAccountController(this);

        withdrawTab= (AccountWithdraw) viewContainer.getPage("AccountWithdraw");
        withdrawTab.setVisible(false);
        withdrawTab.setAccountController(this);

        activityTab= (AccountActivity) viewContainer.getPage("AccountActivity");
        activityTab.setVisible(false);
        activityTab.setAccountController(this);

    }

    public void sendMoneyTo(String to_aid, double amount){
        controlledAccount.getTransactionController().createTransaction(
                controlledAccount.getBean().getAid(),to_aid,amount);
    }

    public void withdrawMoney(double amount){
        if(BankJudge.getInstance().canWithdraw(controlledAccount,amount))
        {
            dbManager.updateBalance(controlledAccount.getBean().getAid(),amount+ Constants.WITHDRAW_FEE);
        }else
        {
            //TODO alert user not enough deposites.
        }
    }

    public void addMoney(double amount){
        dbManager.updateBalance(controlledAccount.getBean().getAid(),amount+ Constants.WITHDRAW_FEE);
    }

    public void buyStock(float stockProportion,String sid){
        if(bankJudge.canBuyStock(controlledAccount,stockProportion,sid))
        {
            String aid = controlledAccount.getBean().getAid();
            StockBean bean=dbManager.getStock(sid);
            double price = stockProportion * bean.getPrice();
            List<UserStock> userStocks = dbManager.getUserStocks(aid);
            for(UserStock stock: userStocks){
                if (stock.getSid() == sid){
                    dbManager.updateUserStock(aid,sid, (double) stockProportion);
                }
                else{
                    String dateTime = Utils.getDateTime();
                    UserStock newUserStock = new UserStock(sid, aid, stockProportion, dateTime);
                    dbManager.insertUserStock(newUserStock);
                }
            }
            dbManager.updateBalance(controlledAccount.getBean().getAid(), -price);
        }
    }

    public void sellStock(String sid)
    {
        String aid = controlledAccount.getBean().getAid();
        StockBean bean=dbManager.getStock(sid);
        double price = bean.getPrice();
        double ownedProportion = dbManager.getSpecificUserStock(aid, sid).getProportion();
        double valueStock = ownedProportion * price;
        dbManager.updateBalance(controlledAccount.getBean().getAid(), valueStock);
    }

    public AbsAccount getControlledAccount() {
        return controlledAccount;
    }

    public void setControlledAccount(AbsAccount controlledAccount) {
        this.controlledAccount = controlledAccount;
    }

    public void updateView(){
        AccountBean bean=controlledAccount.getBean();
        String aid= bean.getAid();
        String email= bean.getEmail();
        String accountType=controlledAccount.getBean().getAccountEnum().toString();
        List<TransactionBean> transactions=dbManager.getTransactionBeanByAid(aid);
        activityTab.setBalance(controlledAccount.getBalance());
    }

    public void showPage(){
        activityTab.setVisible(true);
    }

}
