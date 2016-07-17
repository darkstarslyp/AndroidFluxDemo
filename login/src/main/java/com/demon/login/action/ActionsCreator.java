package com.demon.login.action;
import com.demon.login.dispatcher.Dispatcher;

/**
 * Created by demon.li on 2016/7/17.
 */
public class ActionsCreator {

    Dispatcher dispatcher;
    public static ActionsCreator instance;

    public static ActionsCreator get( Dispatcher dispatcher) {
        if(instance==null){
            instance = new ActionsCreator(dispatcher);
        }
        return instance;
    }

    public ActionsCreator(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void onAciton(Action action){
        dispatcher.dispatch(action);
    }
}
