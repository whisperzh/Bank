package com.ood.Utils;

/**
 * Constant variables used throughout the system is stored here for clean reuse. For updating any of the values, only this file should be changed
 */
public class Constants {
    public static final String URL = "jdbc:sqlite:src/main/resources/bank.db";

    public final static float EXCHANGE_RATE_EUR_DIV_USD = (float)1.06;
    //EXCHANGE_RATE_EUR_USD = exchange rate to convert 1 euro to usd
    public final static float EXCHANGE_RATE_JPY_DIV_USD = (float)0.0073;
    //EXCHANGE_RATE_JPY_USD = exchange rate to convert 1 japanese yen to usd
    public final static double TRANSACTION_FEE=5;
    //the fee customer needs to pay when they make any transaction
    public final static double OPEN_ACCOUNT_FEE=25;
    //the fee customer needs to pay when they open an account in the bank
    public final static double CLOSE_ACCOUNT_FEE=100;
    //the fee customer needs to pay when they close an account in the bank
    public static final double WITHDRAW_FEE = 5;
    //the fee customer needs to pay when they want to withdraw money from their account
    public static final double BUY_STOCK_FEE = 0;
    //the fee customer needs to pay when they buy stocks

}
