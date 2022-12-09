package com.ood.Currency;

import com.ood.Enums.CurrencyEnum;
import com.ood.Utils.Constants;

public class JPY_Currency extends AbsCurrency{
    private float usd_exchange_rate;
    private float eur_exchange_rate;
    private float amount;

    public JPY_Currency(float amount, float eur_exchange_rate, float usd_exchange_rate){
        this.amount = amount;
        this.eur_exchange_rate = eur_exchange_rate;
        this.usd_exchange_rate = usd_exchange_rate;
    }

    public JPY_Currency(float amount){
        this.amount = amount;
        this.eur_exchange_rate = Constants.EXCHANGE_RATE_JPY_EUR;
        this.usd_exchange_rate = Constants.EXCHANGE_RATE_JPY_USD;;
    }
    @Override
    public float convertTo(float amount, CurrencyEnum type) {
        if (type.equals("JPY")){
            return amount;
        }
        else if (type.equals("EUR")){
            return (amount*eur_exchange_rate);
        }
        else if (type.equals("USD")){
            return (amount*usd_exchange_rate);
        }
        return 0;
    }
}
