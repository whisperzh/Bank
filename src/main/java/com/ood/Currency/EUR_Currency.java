package com.ood.Currency;

import com.ood.Enums.CurrencyEnum;

public class EUR_Currency extends AbsCurrency{
    private float usd_exchange_rate;
    private float jpy_exchange_rate;
    private float amount;

    public EUR_Currency(float amount, float jpy_exchange_rate, float usd_exchange_rate){
        this.amount = amount;
        this.jpy_exchange_rate = jpy_exchange_rate;
        this.usd_exchange_rate = usd_exchange_rate;
    }

    public EUR_Currency(float amount){
        this.amount = amount;
        this.jpy_exchange_rate = (float)143.84;
        this.usd_exchange_rate = (float)1.05;;
    }
    @Override
    public float convertTo(float amount, CurrencyEnum type) {
        if (type.equals("EUR")){
            return amount;
        }
        else if (type.equals("USD")){
            return (amount*usd_exchange_rate);
        }
        else if (type.equals("JPY")){
            return (amount*jpy_exchange_rate);
        }
        return 0;
    }
}
