package com.demon.flux.stores;

import com.demon.flux.actions.Action;
import com.demon.flux.actions.MessageAction;
import com.demon.flux.model.Message;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by demon.li on 2016/7/17.
 */
public class MessageStore extends Store{

    private static MessageStore singleton;
    private Message mMessage = new Message();

    public MessageStore() {
        super();
    }

    public String getMessage() {
        return mMessage.getMessage();
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        switch (action.getType()) {
            case MessageAction.ACTION_NEW_MESSAGE:
                mMessage.setMessage((String) action.getData());
                break;
            default:
        }
        emitStoreChange();
    }


    @Override
    public Store.StoreChangeEvent changeEvent() {
        return new Store.StoreChangeEvent();
    }
}
