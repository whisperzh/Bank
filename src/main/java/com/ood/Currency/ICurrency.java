package com.ood.Currency;

import com.ood.Enums.CurrencyEnum;

/**
 * currency is a collection of a certain type of currency,
 * and can only be converted to us dollars or from us dollars.
 */
public interface ICurrency {
    float convertTo(float amount, CurrencyEnum type);

}
