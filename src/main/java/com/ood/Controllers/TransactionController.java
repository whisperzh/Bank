package com.ood.Controllers;

import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Transactions.Transaction;
import com.ood.Model.Transactions.TransactionBean;
import com.ood.Utils.Utils;

public class TransactionController {
    private String aid;

    public TransactionController(String aid) {
        this.aid = aid;
    }
    public void createTransaction(String from_aid, String to_aid, double amount, CurrencyEnum currencyEnum) {
        TransactionBean bean=new TransactionBean();
        bean.setAmount(amount);
        bean.setTid(Utils.generateRandomUUID());
        bean.setCurrencyEnum(currencyEnum);
        bean.setTimeStamp(Utils.getDateTime());
        bean.setFrom_uid(from_aid);
        bean.setTo_uid(to_aid);

        new Transaction(bean);
    }

    public void createTransaction(String from_aid, String to_aid, double amount) {
        TransactionBean bean=new TransactionBean();
        bean.setAmount(amount);
        bean.setTid(Utils.generateRandomUUID());
        bean.setCurrencyEnum(CurrencyEnum.USD);
        bean.setTimeStamp(Utils.getDateTime());
        bean.setFrom_uid(from_aid);
        bean.setTo_uid(to_aid);

        new Transaction(bean);
    }
}
