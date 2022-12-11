package com.ood.Controllers;

import com.ood.Utils.DatabaseManager;

public class StockController {
    public void updateStock(String sid,double price)
    {
        DatabaseManager.getDbManager().updateStock(sid,price);
    }
}
