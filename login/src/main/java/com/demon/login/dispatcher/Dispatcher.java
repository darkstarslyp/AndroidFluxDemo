package com.demon.login.dispatcher;

import com.demon.login.action.Action;
import com.demon.login.store.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demon.li on 2016/7/17.
 */
public class Dispatcher {

    public Dispatcher() {
    }

    private List<Store> stores = new ArrayList<>();

    public void register(Store store){
       stores.add(store);
    }

    public void unregister(Store store){
        stores.remove(store);
    }

    public void dispatch(Action action){

        post(action);
    }

    private void post(Action action){
        for (Store store:stores){
            store.onAction(action);
        }
    }

}
