package com.ood.Currency;

import com.ood.Enums.CurrencyEnum;
import com.ood.Utils.Constants;

public class US_Currency extends AbsCurrency{
    private float eur_exchange_rate;
    private float jpy_exchange_rate;
    private float amount;

    public US_Currency(float amount, float eur_exchange_rate, float jpy_exchange_rate){
        this.amount = amount;
        this.eur_exchange_rate = eur_exchange_rate;
        this.jpy_exchange_rate = jpy_exchange_rate;
    }

    public US_Currency(float amount){
        this.amount = amount;
        this.eur_exchange_rate = Constants.EXCHANGE_RATE_USD_EUR;
        this.jpy_exchange_rate = Constants.EXCHANGE_RATE_USD_JPY;;
    }
    @Override
    public float convertTo(float amount, CurrencyEnum type) {
        if (type.equals("USD")){
            return amount;
        }
        else if (type.equals("EUR")){
            return (amount*eur_exchange_rate);
        }
        else if (type.equals("JPY")){
            return (amount*jpy_exchange_rate);
        }
        return 0;
    }
}
