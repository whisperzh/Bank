package com.ood.Controllers;

import com.ood.Views.ManagerViewAllCustomers;
import com.ood.Views.ManagerViewCustomers;
import com.ood.Views.ManagerViewTransactions;
import com.ood.Views.ViewContainer;

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

    //    private ManagerViewAllCustomers allCustomers;
//    private ManagerViewAllCustomers allCustomers;
//    private ManagerViewAllCustomers allCustomers;
//    private ManagerViewAllCustomers allCustomers;

}
