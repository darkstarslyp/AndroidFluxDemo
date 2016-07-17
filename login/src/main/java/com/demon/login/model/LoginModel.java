package com.demon.login.model;

/**
 * Created by demon.li on 2016/7/17.
 */
public class LoginModel {
    private String userName;
    private String userPsw;

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPsw() {
        return userPsw;
    }
}
