package com.ood.Model.Loan;

import com.ood.Enums.CurrencyEnum;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;

import java.util.List;


public class LoanController {
    private String uid;

    public LoanController(String uid) {
        this.uid = uid;
    }

    public void createLoan(float amount, CurrencyEnum currency){
        LoanBean bean=new LoanBean();
        bean.setLid(Utils.generateRandomUUID());
        bean.setUid(uid);
        bean.setAmount(amount);
        bean.setCurrencyEnum(currency);
        bean.setDate(Utils.getTodaysDate());
        bean.setIs_clear(false);
        DatabaseManager.getDbManager().insertLoanBean(bean);
    }

    public List<LoanBean> getUserLoanRecord(){
        return DatabaseManager.getDbManager().getLoanBean(uid);
    }
}
