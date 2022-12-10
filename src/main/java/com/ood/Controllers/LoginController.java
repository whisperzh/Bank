package com.ood.Controllers;
import com.ood.Model.Users.UserBean;
import com.ood.Utils.DatabaseManager;

public class LoginController {
    public void login(String userName,String password)
    {
          DatabaseManager dbm=DatabaseManager.getDbManager();
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
