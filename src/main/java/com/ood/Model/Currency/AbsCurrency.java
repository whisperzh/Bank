package com.ood.Model.Currency;

public abstract class AbsCurrency implements ICurrency{
    protected double amount;

    @Override
    public void addAmount(double amount) {
        this.amount+=amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
