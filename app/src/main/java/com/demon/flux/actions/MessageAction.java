package com.demon.flux.actions;

/**
 * Created by demon.li on 2016/7/17.
 */
public class MessageAction extends Action {

    public static final String ACTION_NEW_MESSAGE = "new_message";

    public MessageAction(String type, Object data) {
        super(type, data);
    }
}
