package com.ood.Model.Currency;

public abstract class AbsCurrency implements ICurrency{
    protected float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
