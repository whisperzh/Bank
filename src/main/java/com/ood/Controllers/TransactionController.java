package com.ood.Controllers;

import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Transactions.Transaction;
import com.ood.Model.Transactions.TransactionBean;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;

/**
 * Controller Class for handling transactions between user accounts and to connect transactions in front end, validation using bankJudge and data in the backend
 */
public class TransactionController {
    private String aid;

    public TransactionController(String aid) {
        this.aid = aid;
    }
    public Transaction createTransaction(String from_aid, String to_aid, double amount, CurrencyEnum currencyEnum) {
        TransactionBean bean=new TransactionBean();
        bean.setAmount(amount);
        bean.setTid(Utils.generateRandomUUID());
        bean.setCurrencyEnum(currencyEnum);
        bean.setTimeStamp(Utils.getDateTime());
        bean.setFrom_aid(from_aid);
        bean.setTo_aid(to_aid);
        bean.setFromName(DatabaseManager.getInstance().getUsernameForAccount(from_aid));
        bean.setToName(DatabaseManager.getInstance().getUsernameForAccount(to_aid));
        DatabaseManager.getInstance().insertTransactionBean(bean);
        return new Transaction(bean);
    }

    public void createTransaction(String from_aid, String to_aid, double amount) {
        createTransaction(from_aid,to_aid,amount,CurrencyEnum.USD);
        TransactionBean bean=new TransactionBean();
        bean.setAmount(amount);
        bean.setTid(Utils.generateRandomUUID());
        bean.setCurrencyEnum(CurrencyEnum.USD);
        bean.setTimeStamp(Utils.getDateTime());
        bean.setFrom_aid(from_aid);
        bean.setTo_aid(to_aid);
        bean.setFromName(DatabaseManager.getInstance().getUsernameForAccount(from_aid));
        bean.setToName(DatabaseManager.getInstance().getUsernameForAccount(to_aid));
        new Transaction(bean);
    }
}
