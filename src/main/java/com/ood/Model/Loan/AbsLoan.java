package com.ood.Model.Loan;

public abstract class AbsLoan {
    private LoanBean bean;

    public AbsLoan(LoanBean bean) {
        this.bean = bean;
    }
    public double getAmount() {
        return bean.getAmount();
    }
}
