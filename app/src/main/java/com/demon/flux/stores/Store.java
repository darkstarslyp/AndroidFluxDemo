package com.demon.flux.stores;

import com.demon.flux.actions.Action;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by demon.li on 2016/7/16.
 */
public abstract class Store {

    private EventBus bus = new EventBus();

    public void register(final Object view){
        this.bus.register(view);
    }

    public void unregister(final Object view){
        this.bus.unregister(view);
    }

    public void emitStoreChange(){
        bus.post(changeEvent());
    }

    abstract public StoreChangeEvent changeEvent();

    abstract public void onAction(Action action);


    public class StoreChangeEvent{}


}
