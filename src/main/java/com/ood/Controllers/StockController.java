package com.ood.Controllers;

import com.ood.Utils.DatabaseManager;

/**
 * Controller Class for handling stocks by connecting stocks in user accounts in front end, validation using bankJudge and data in the backend
 */
public class StockController {
    public void updateStock(String sid,double price)
    {
        DatabaseManager.getInstance().updateStock(sid,price);
    }
}
