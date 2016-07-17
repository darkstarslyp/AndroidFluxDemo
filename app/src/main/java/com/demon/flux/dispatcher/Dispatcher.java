package com.demon.flux.dispatcher;

import com.demon.flux.actions.Action;
import com.demon.flux.stores.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demon.li on 2016/7/16.
 */
public class Dispatcher {

    private static Dispatcher instance;
    private final List<Store> stores = new ArrayList<>();

    public static Dispatcher get() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    Dispatcher() {}

    public void register(final Store store) {
        stores.add(store);
    }

    public void unregister(final Store store) {
        stores.remove(store);
    }

    public void dispatch(Action action) {
        post(action);
    }

    private void post(final Action action) {
        for (Store store : stores) {
            store.onAction(action);
        }
    }

}
