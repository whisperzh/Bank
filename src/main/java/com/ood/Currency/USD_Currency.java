package com.ood.Currency;

import com.ood.Enums.CurrencyEnum;
import com.ood.Utils.Constants;

public class USD_Currency extends AbsCurrency{
    public USD_Currency(float amount){
        this.amount = amount;

    }
    @Override
    public void convertTo(float otherAmount, CurrencyEnum type) {
        this.amount-=valueOf(otherAmount,type);
    }

    public static float valueOf(float otherAmount, CurrencyEnum type) {
        if(type.equals(CurrencyEnum.JPY))
        {
            return otherAmount*Constants.EXCHANGE_RATE_JPY_DIV_USD;
        }else if(type.equals(CurrencyEnum.EUR)){
            return otherAmount*Constants.EXCHANGE_RATE_EUR_DIV_USD;
        }
        return 0;
    }
}
