package com.ood.Controllers;

import com.ood.Model.Users.UserEntity;

/**
 * Manager has several controllers and controls all users actions
 */
public class UserControllerManager {
    private UserEntity controlling_user;

    public UserControllerManager() {
    }

    public UserEntity getControlling_user() {
        return controlling_user;
    }

    public void setControlling_user(UserEntity controlling_user) {
        this.controlling_user = controlling_user;
    }
}
