package com.ood.Service;

import com.ood.Controllers.UserControllerManager;
import com.ood.Views.HomePage;

/**
 * Concrete class for Service that extends the implementation
 */
public class ATMService implements IService{

    private UserControllerManager controllerManager;
    public ATMService() {
        controllerManager=new UserControllerManager();
    }
    @Override
    public void start() {
        controllerManager.showLogin();
    }

}
