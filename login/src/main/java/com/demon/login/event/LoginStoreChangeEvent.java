package com.demon.login.event;

/**
 * Created by demon.li on 2016/7/17.
 */
public class LoginStoreChangeEvent extends BaseStoreChangeEvent {

    public int status;

    public LoginStoreChangeEvent(int status) {
        this.status = status;
    }
}
