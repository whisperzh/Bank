package com.ood.Controllers;
import com.ood.Model.Users.NormalUser;
import com.ood.Model.Users.SuperUser;
import com.ood.Model.Users.UserBean;
import com.ood.Model.Users.UserEntity;
import com.ood.Utils.DatabaseManager;
import com.ood.Validation.BankJudge;
import com.ood.Views.LoginPage;
import com.ood.Views.ViewContainer;

/**
 * Controller Class for handling login functionality of user accounts in front end, validation using bankJudge and data in the backend
 */
public class LoginController {
    private LoginPage view;
    private DatabaseManager dbManager;
    private ViewContainer viewContainer;
    private BankJudge judge;
    public LoginController() {
        dbManager=DatabaseManager.getInstance();
        judge=BankJudge.getInstance();
        viewContainer=ViewContainer.getInstance();
        view= (LoginPage) viewContainer.getPage("LoginPage");
        view.setVisible(false);
        view.setController(this);
    }

    public boolean login(String userName, String password)
    {
          UserBean bean=dbManager.getUserbean(userName, password);
          if(bean!=null)
          {
              UserEntity user;
              if(bean.isAdmin())
              {
                  user=new SuperUser(bean);
              }else
              {
                  user=new NormalUser(bean);
              }
              UserControllerManager.getInstance().setControlling_user(user);

              //activate backend service.
              System.out.println("yes");
              UserControllerManager.getInstance().setLoggedin(true);
              return true;
          }
          else{
              //alert
              System.out.printf("no");
              return false;
          }
    }
}
