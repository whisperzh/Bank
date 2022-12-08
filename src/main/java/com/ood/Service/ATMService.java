package com.ood.Service;

import com.ood.Views.HomePage;

public class ATMService implements IService{

    public ATMService() {
        show_Frontend();
    }

    @Override
    public void show_BackEnd() {

    }

    @Override
    public void show_Frontend() {
        /**
         * naive code START
         */
        HomePage homePage=new HomePage();
        /**
         * naive code ENDS
         */
    }
}
