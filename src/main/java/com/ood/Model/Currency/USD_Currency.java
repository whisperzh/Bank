package com.ood.Model.Currency;

import com.ood.Enums.CurrencyEnum;
import com.ood.Utils.Constants;

/**
 * Concrete class for maintaining functionality related to US dollars currency. This classes uses the functionality defined in the AbsCurrency class
 */
public class USD_Currency extends AbsCurrency{
    public USD_Currency(double amount){
        this.amount = amount;

    }
    @Override
    public void convertTo(float otherAmount, CurrencyEnum type) {
        this.amount-=valueOf(otherAmount,type);
    }

    public static double valueOf(double otherAmount, CurrencyEnum type) {
        if(type.equals(CurrencyEnum.JPY))
        {
            return otherAmount*Constants.EXCHANGE_RATE_JPY_DIV_USD;
        }else if(type.equals(CurrencyEnum.EUR)){
            return otherAmount*Constants.EXCHANGE_RATE_EUR_DIV_USD;
        }
        return 0;
    }
}
