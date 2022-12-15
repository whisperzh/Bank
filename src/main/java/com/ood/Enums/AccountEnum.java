package com.ood.Enums;

/**
 * Enum Class for enumerating all possible types of accounts that a user in the bank can create and maintain
 */
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
