package com.ood.Enums;

/**
 * Enum Class for enumerating all possible types of currencies- currently 3 that a user in the bank can deposit and maintain
 */
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
