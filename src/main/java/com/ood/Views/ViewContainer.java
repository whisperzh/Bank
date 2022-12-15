package com.ood.Views;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ViewContainer {
    private Map<String, JFrame> map;

    private static ViewContainer viewContainer;
    public ViewContainer() {
        this.map =new HashMap<>();
    }

    public static ViewContainer getInstance(){
        if(viewContainer==null)
            viewContainer=new ViewContainer();
        return viewContainer;
    }

    public void addPage(String name,JFrame instance){
        map.put(name,instance);
    }

    public JFrame getPage(String name)
    {
        if(map.getOrDefault(name,null)==null)
        {
            JFrame jFrame=null;
            if(name.contains("AccountActivity"))
            {
                jFrame=new AccountActivity();
            }else if(name.contains("AccountDetails"))
            {
                jFrame=new AccountDetails();
            }else if(name.contains("AccountTransfer"))
            {
                jFrame=new AccountTransfer();

            }else if(name.contains("AccountWithdraw"))
            {
                jFrame=new AccountWithdraw();

            }else if(name.contains("CustomerDashboard"))
            {
                jFrame=new CustomerDashboard();

            }else if(name.contains("LoanApplication"))
            {
                jFrame=new LoanApplication();
            }else if(name.contains("LoginPage"))
            {
                jFrame=new LoginPage();

            }
            else if(name.contains("ManagerViewCustomers"))
            {
                jFrame=new ManagerViewCustomers();

            }else if(name.contains("ManagerViewTransactions"))
            {
                jFrame=new ManagerViewTransactions();

            }else if(name.contains("SecurityApplication"))
            {
                jFrame=new SecurityApplication();
            }
            map.put(name,jFrame);
            return jFrame;
        }else {
            return map.get(name);
        }


    }
}
