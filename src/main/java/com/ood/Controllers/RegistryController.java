package com.ood.Controllers;

import com.ood.Users.UserBean;
import com.ood.Utils.DatabaseManager;

public class RegistryController {
    public void register(UserBean bean)
    {
        DatabaseManager dbm=DatabaseManager.getDbManager();
        if(dbm.hasUserBean(bean))
        {
            //alert
        }else
        {
            dbm.insertUserBean(bean);
        }
    }
}
