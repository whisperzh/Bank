package com.ood;

import com.ood.Service.ATMService;
import com.ood.Service.IService;

public class Main {
    public static void main(String[] args) {
        test();
        IService service=new ATMService();
        service.start();
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

//        AccountBean bean=new AccountBean();
//        bean.setAccountEnum(AccountEnum.CHECKINGS);
//        bean.setAid(Utils.generateRandomUUID());
//        bean.setEmail("rmzhang@bu.edu");
//        bean.setUid("SSN01");
//        DatabaseManager.getDbManager().insertAccountBean(bean);

//        LoanController lc=new LoanController();
//        lc.createLoan("SSN01",100000.0f, CurrencyEnum.USD);
//        lc.getUserLoanRecord("SSN01");
//        IService service=new ATMService();

//        DatabaseManager.getDbManager().updateStock("stk004",24345);
    }
}