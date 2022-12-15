package com.ood.Controllers;

import com.ood.Model.Users.UserBean;
import com.ood.Utils.DatabaseManager;

/**
 * Controller Class for handling registered users and for connecting between user accounts in front end, validation using bankJudge and data in the backend
 */
public class RegistryController {
    public void register(UserBean bean)
    {
        DatabaseManager dbm=DatabaseManager.getInstance();
        if(dbm.hasUserBean(bean))
        {
            //alert
        }else
        {
            dbm.insertUserBean(bean);
        }
    }
}
