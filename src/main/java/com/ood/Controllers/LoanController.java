package com.ood.Controllers;

import com.ood.Enums.CurrencyEnum;
import com.ood.Enums.LoanEnum;
import com.ood.Model.Loan.AbsLoan;
import com.ood.Model.Loan.EducationLoan;
import com.ood.Model.Loan.LoanBean;
import com.ood.Model.Loan.NormalLoan;
import com.ood.Utils.DatabaseManager;
import com.ood.Utils.Utils;
import com.ood.Validation.BankJudge;
import com.ood.Views.LoanApplication;
import com.ood.Views.ViewContainer;

/**
 * Controller Class for handling connection between loans for user accounts in front end, validation using bankJudge and data in the backend
 */
public class LoanController {

    private BankJudge bankJudge;

    private LoanApplication view;

    private ViewContainer viewContainer;

    public LoanController() {
        this.bankJudge = BankJudge.getInstance();
        viewContainer=ViewContainer.getInstance();
        view= (LoanApplication) viewContainer.getPage("LoanApplication");
        view.setController(this)
        ;
        view.setVisible(false);

    }

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
    /*public void validateCredentials(Map<String,String> loanCredentials){
        Boolean message = bankJudge.canCreateLoan(loanCredentials);
        if(message){
            //fetch details from database
        }
        else{
            JOptionPane.showMessageDialog(view ,"You have entered invalid input");
        }
    }*/
}
