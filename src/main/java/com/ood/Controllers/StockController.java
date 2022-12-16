package com.ood.Controllers;

import com.ood.Model.Accounts.AbsAccount;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Model.Stocks.StockBean;
import com.ood.Model.Transactions.TransactionBean;
import com.ood.Utils.DatabaseManager;
import com.ood.Validation.BankJudge;
import com.ood.Views.*;

import java.util.List;

/**
 * Controller Class for handling stocks by connecting stocks in user accounts in front end, validation using bankJudge and data in the backend
 */
public class StockController {

    private StockInfo stock_info;
    private DatabaseManager dbManager;
    private ViewContainer viewContainer;
    private BankJudge bankJudge;

    public StockController(){
        bankJudge=BankJudge.getInstance();
        dbManager=DatabaseManager.getInstance();
        viewContainer= ViewContainer.getInstance();
        stock_info = (StockInfo) viewContainer.getPage("StockInfo");
        stock_info.setVisible(false);
        stock_info.setStock_controller(this);
    }

    public void updateStock(String sid,double price)
    {
        DatabaseManager.getInstance().updateStock(sid,price);
    }

    public void updateStockInfoView(){

        List<StockBean> stocks=dbManager.getStocks();
        stock_info.WriteToTable(stocks);
    }
}
