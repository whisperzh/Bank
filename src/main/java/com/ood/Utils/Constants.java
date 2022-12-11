package com.ood.Utils;

public class Constants {
    public static final String URL = "jdbc:sqlite:/Users/leo/Desktop/Boston University/CS611/Bank/src/main/resources/bank.db";

    public final static float EXCHANGE_RATE_EUR_DIV_USD = (float)1.06;
    //EXCHANGE_RATE_EUR_USD = exchange rate to convert 1 euro to usd
    public final static float EXCHANGE_RATE_JPY_DIV_USD = (float)0.0073;
    //EXCHANGE_RATE_JPY_USD = exchange rate to convert 1 japanese yen to usd
    public final static double TRANSACTION_FEE=5;
    //the fee customer need to pay when they make transaction
    public final static double OPEN_ACCOUNT_FEE=25;
    //the fee customer need to pay when they open
    public final static double CLOSE_ACCOUNT_FEE=100;
    public static final double WITHDRAW_FEE = 5;
    public static final double BUY_STOCK_FEE = 0;
    //the fee customer need to pay when they open

}
