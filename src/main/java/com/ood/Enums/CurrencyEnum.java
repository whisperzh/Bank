package com.ood.Enums;

public enum CurrencyEnum {
    USD,
    EUR,
    JPY
    ;

    public static CurrencyEnum toType(String currency) {
        CurrencyEnum type=null;
        switch (currency)
        {
            case "USD":
                type=USD;
                break;
            case "EUR":
                type=EUR;
                break;
            case "JPY":
                type=JPY;
                break;
        }
        return type;
    }
}
