package com.ood.Model.Transactions;

import com.ood.Utils.DatabaseManager;

public class Transaction {
    private TransactionBean bean;


    public Transaction(TransactionBean bean) {
        this.bean = bean;
        DatabaseManager.getInstance().insertTransactionBean(bean);

    }

    public TransactionBean getBean() {
        return bean;
    }

    public void setBean(TransactionBean bean) {
        this.bean = bean;
    }
}
