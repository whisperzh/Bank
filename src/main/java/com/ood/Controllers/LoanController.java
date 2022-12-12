package com.ood.Controllers;

import com.ood.Enums.CurrencyEnum;
import com.ood.Enums.LoanEnum;
import com.ood.Model.Loan.AbsLoan;
import com.ood.Model.Loan.EducationLoan;
import com.ood.Model.Loan.LoanBean;
import com.ood.Model.Loan.NormalLoan;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;

public class LoanController {
    public AbsLoan createLoan(LoanEnum loanType, String uid, CurrencyEnum currencyEnum, double amount){
        LoanBean bean=new LoanBean();
        bean.setLid(Utils.generateRandomUUID());
        bean.setAmount(amount);
        bean.setUid(uid);
        bean.setDate(Utils.getTodaysDate());
        bean.setCurrencyEnum(currencyEnum);
        bean.setIs_clear(false);
        DatabaseManager.getInstance().insertLoanBean(bean);
        AbsLoan loan=null;
        switch (loanType)
        {
            case EDUCATION:
                loan=new EducationLoan(bean);
                break;
            case NORMAL:
                loan=new NormalLoan(bean);
                break;
        }
        return loan;
    }

    public AbsLoan createLoan( String uid, double amount)
    {
        return createLoan(LoanEnum.NORMAL,uid,CurrencyEnum.USD,amount);
    }
}
