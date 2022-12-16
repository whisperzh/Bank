package com.ood.Controllers;

import com.ood.Model.Transactions.TransactionBean;
import com.ood.Model.Users.UserBean;
import com.ood.Utils.DatabaseManager;
import com.ood.Views.ManagerViewAllCustomers;
import com.ood.Views.ManagerViewCustomers;
import com.ood.Views.ManagerViewTransactions;
import com.ood.Views.ViewContainer;

import java.util.List;

public class ManagerController {
    private ManagerViewAllCustomers allCustomersView;
    private ManagerViewTransactions transactionView;

    private ViewContainer viewContainer;

    public ManagerController() {
        viewContainer=ViewContainer.getInstance();

        allCustomersView = (ManagerViewAllCustomers) viewContainer.getPage("ManagerViewAllCustomers");
        allCustomersView.setVisible(false);
        allCustomersView.setController(this);

        transactionView = (ManagerViewTransactions) viewContainer.getPage("ManagerViewTransactions");
        transactionView.setVisible(false);
        transactionView.setController(this);

    }

    public void updateView(){
        List<TransactionBean> beans= DatabaseManager.getInstance().getAllTransactionBean();
        transactionView.WriteToTable(beans);
        List<UserBean> userBeans= DatabaseManager.getInstance().getAllUsers();
        allCustomersView.WriteToTable(userBeans);
    }

    //    private ManagerViewAllCustomers allCustomers;
//    private ManagerViewAllCustomers allCustomers;
//    private ManagerViewAllCustomers allCustomers;
//    private ManagerViewAllCustomers allCustomers;

}
