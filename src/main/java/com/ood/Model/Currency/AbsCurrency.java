package com.ood.Model.Currency;

/**
 * Concrete class that holds common properties possessed by each currency
 */
public abstract class AbsCurrency implements ICurrency{
    protected double amount;

    @Override
    public void addAmount(double amount) {
        this.amount+=amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
