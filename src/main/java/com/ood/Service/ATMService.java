package com.ood.Service;

import com.ood.Views.HomePage;

/**
 * Concrete class of Service
 */
public class ATMService implements IService{

    public ATMService() {
    }

    @Override
    public void start() {

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
