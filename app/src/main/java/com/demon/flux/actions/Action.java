package com.demon.flux.actions;

/**
 * Created by demon.li on 2016/7/16.
 */
public class Action <T>{

    private final String type;
    private final T data;

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
