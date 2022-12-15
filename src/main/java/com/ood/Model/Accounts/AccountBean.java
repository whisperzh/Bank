package com.ood.Model.Accounts;

import com.ood.Enums.AccountEnum;

/**
 * Concrete class that contains all the attributes and methods required to maintain an Account in the Bank
 */
public class AccountBean {
    private String email;
    private AccountEnum accountEnum;
    private String uid;
    private String aid;
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountEnum getAccountEnum() {
        return accountEnum;
    }

    public void setAccountEnum(AccountEnum accountEnum) {
        this.accountEnum = accountEnum;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
