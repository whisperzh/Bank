package com.ood.Model.Loan;

import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Currency.USD_Currency;

/**
 * Concrete class that holds common properties possessed by each loan record
 */
public abstract class AbsLoan {
    private LoanBean bean;

    public AbsLoan(LoanBean bean) {
        this.bean = bean;
    }
    public double getAmount() {
        return bean.getAmount();
    }
    public double getAmountInUSD(){
        return USD_Currency.valueOf(getAmount(),bean.getCurrencyEnum());
    }
    public CurrencyEnum getCurrencyEnum(){
        return bean.getCurrencyEnum();
    }

}
