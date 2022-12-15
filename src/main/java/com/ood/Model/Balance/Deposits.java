package com.ood.Model.Balance;

import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Currency.EUR_Currency;
import com.ood.Model.Currency.ICurrency;
import com.ood.Model.Currency.JPY_Currency;
import com.ood.Model.Currency.USD_Currency;
import com.ood.Utils.SimpleCollection;

/**
 * Each Account has this class, this class is responsible for managing the currencies
 */
public class Deposits extends SimpleCollection<ICurrency> {
    public Deposits(double startAmount) {
        super();
        addItem(new USD_Currency(startAmount));
        addItem(new JPY_Currency(0));
        addItem(new EUR_Currency(0));
    }

    public Deposits() {
        super();
        addItem(new USD_Currency(0));
        addItem(new JPY_Currency(0));
        addItem(new EUR_Currency(0));
    }

    public double getTotalValInUSD(){
        double total=0;
        for(ICurrency c: itemList)
        {
            if(c instanceof USD_Currency)
            {
                total+=((USD_Currency) c).getAmount();
            }else if(c instanceof JPY_Currency)
            {
                total+=JPY_Currency.valueOf(c.getAmount(), CurrencyEnum.USD);
            }else {
                total+=EUR_Currency.valueOf(c.getAmount(), CurrencyEnum.USD);
            }
        }
        return total;
    }
    public double getUSDAmount(){
        return getItemAt(0).getAmount();
    }
    public double getJPYAmount(){
        return getItemAt(1).getAmount();
    }
    public double getEURAmount(){
        return getItemAt(2).getAmount();
    }

    public void setUSDAmount(double amount){
         getItemAt(0).setAmount(amount);
    }
    public void setJPYAmount(double amount){
         getItemAt(1).setAmount(amount);
    }
    public void setEURAmount(double amount){
         getItemAt(2).setAmount(amount);
    }

    public void addAmount(double amount)
    {
        getItemAt(0).addAmount(amount);
    }
}
