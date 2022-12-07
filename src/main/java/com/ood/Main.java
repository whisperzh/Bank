package com.ood;

import com.ood.Accounts.AccountBean;
import com.ood.Controllers.LoginController;
import com.ood.Controllers.RegistryController;
import com.ood.Enums.AccountEnum;
import java.util.UUID;
import com.ood.Users.UserBean;
import com.ood.Utils.DatabaseManager;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
//        LoginController lc=new LoginController();
//        lc.login("Admin","123123");
//        RegistryController rc=new RegistryController();
//        UserBean bean=new UserBean();
//        bean.setBirthday("1990-01-01");
//        bean.setUserName("hjhjhjh");
//        bean.setLastName("test");
//        bean.setFirstName("test");
//        bean.setEmail("1111@test.edu");
//        bean.setAdmin(false);
//        bean.setPassword("123456");
//        rc.register(bean);
        AccountBean bean=new AccountBean();
        bean.setAccountEnum(AccountEnum.CHECKINGS);
        bean.setAid(UUID.randomUUID().toString());
        bean.setEmail("rmzhang@bu.edu");
        bean.setUid("SSN01");
        DatabaseManager.getDbManager().insertAccountBean(bean);
    }
}