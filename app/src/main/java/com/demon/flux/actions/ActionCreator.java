package com.demon.flux.actions;

import com.demon.flux.dispatcher.Dispatcher;

/**
 * Created by demon.li on 2016/7/17.
 */
public class ActionCreator {

    private static ActionCreator instance;

    private Dispatcher mDispatcher;

    public ActionCreator(Dispatcher mDispatcher) {
        this.mDispatcher = mDispatcher;
    }

    public static ActionCreator get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new ActionCreator(dispatcher);
        }
        return instance;
    }

    public void sendMessage(String message){
         mDispatcher.dispatch(new MessageAction(MessageAction.ACTION_NEW_MESSAGE,message));
    }


}
