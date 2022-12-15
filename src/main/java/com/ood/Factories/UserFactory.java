package com.ood.Factories;

import com.ood.Model.Users.*;

/**
 * Factory that generates Users of the required type using the appropriate classes
 */
public class UserFactory {
    public IUser createUser(String userType, UserBean bean){
        if(userType == null || userType.isEmpty()){
            return null;
        }
        IUser user = null;
        switch(userType){
            case "normal":
                user = new NormalUser(bean);
                break;
            case "super":
                user = new SuperUser(bean);
                break;
            //default:
            //    throw new IllegalArgumentException("You can only create normal, super. You have entered "+userType);
        }
        return user;
    }
}
