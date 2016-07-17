package com.demon.login.store;

import com.demon.login.action.Action;
import com.demon.login.event.BaseStoreChangeEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by demon.li on 2016/7/17.
 */
public abstract class Store {

    private EventBus mEventBus = new EventBus();


    public void register(Object view){
        mEventBus.register(view);
    }

    public void unregister(Object view){
        mEventBus.unregister(view);
    }


    public abstract void onAction(Action action);

    public void emitEventChange(){
        mEventBus.post(getStoreChangeEvent());
    }

    public abstract BaseStoreChangeEvent getStoreChangeEvent();

}
