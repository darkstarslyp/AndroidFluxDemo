package com.demon.login.action;

/**
 * Created by demon.li on 2016/7/17.
 */
public class Action <T>{

    private String type;
    private T data;

    public Action(String type, T data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
