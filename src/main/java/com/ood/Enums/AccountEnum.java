package com.ood.Enums;

public enum AccountEnum {
    CHECKINGS,
    SAVINGS,
    SECURITY;

    public static AccountEnum StringtoType(String type) {
        AccountEnum ans=null;
        switch (type)
        {
            case "CHECKINGS":
                ans = CHECKINGS;
                break;
            case "SAVINGS":
                ans =  SAVINGS;
                break;
            case "SECURITY":
                ans =  SECURITY;
                break;
        }
        return ans;
    }
}
