package com.ood.Controllers;
import com.ood.Model.Users.UserBean;
import com.ood.Utils.DatabaseManager;
import com.ood.Validation.BankJudge;
import com.ood.Views.LoginPage;
import com.ood.Views.ViewContainer;

public class LoginController {
    private LoginPage view;
    private DatabaseManager dbManager;
    private ViewContainer viewContainer;
    private BankJudge judge;

    public LoginController() {
//        view=
    }

    public void login(String userName, String password)
    {
          DatabaseManager dbm=DatabaseManager.getInstance();
          UserBean bean=dbm.getUserbean(userName, password);
          if(bean!=null)
          {
              //activate backend service.
              System.out.println("yes");
          }
          else{
              //alert
              System.out.printf("no");
          }
    }
}
