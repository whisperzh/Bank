package com.ood.Views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a class which allows us to create instances of all the web pages previously called.
 * This allows the time taken to load the page reduce drastically.
 * We only return the instances when the pages are called and the data is filled in the template accordingly.
 * The page's visibility is then set to true, until then the previously opened pages can't be seen by the user.
 */
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
    public static void fullSizeFrame(JFrame jFrame){
        Dimension myScreen = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setSize(myScreen.width,myScreen.height);
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

            }else if(name.contains("CustomerDashboard")) {
                jFrame = new CustomerDashboard();
            }else if(name.contains("LoanInformation")) {
                jFrame = new LoanInformation();
            } else if (name.contains("CheckingsActivity")) {
                jFrame = new CheckingsActivity();
            }else if (name.contains("CheckingsDetails")) {
                jFrame = new CheckingsDetails();
            }else if (name.contains("CheckingsTransfer")) {
                jFrame = new CheckingsTransfer();
            }else if (name.contains("CheckingsWithdraw")) {
                jFrame = new CheckingsWithdraw();

            }else if(name.contains("LoanApplication")) {
                jFrame=new LoanApplication();

            }else if(name.contains("SavingsApplication")){
                jFrame=new SavingsApplication();
            }
            else if(name.contains("LoginPage"))
            {
                jFrame=new LoginPage();
            }else if(name.contains("LoanInformation")){
             jFrame=new LoanInformation();
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
            }else if(name.contains("HomePage"))
            {
                jFrame=new HomePage();
            } else if (name.contains("StockInfo")) {
                jFrame = new StockInfo();
            } else if (name.contains("StocksOwned")) {
                jFrame = new StocksOwned();
            } else if (name.contains("SellStocks")) {
                jFrame = new SellStocks();
            }
            //fullSizeFrame(jFrame);
            //jFrame.setState(Frame.NORMAL);
            jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
            map.put(name,jFrame);
            return jFrame;
        }else {
            return map.get(name);
        }


    }
}
