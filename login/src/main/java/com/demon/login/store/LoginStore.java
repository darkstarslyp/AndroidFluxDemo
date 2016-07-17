package com.demon.login.store;

import com.demon.login.action.Action;
import com.demon.login.constants.Constans;
import com.demon.login.event.BaseStoreChangeEvent;
import com.demon.login.event.LoginStoreChangeEvent;
import com.demon.login.model.LoginModel;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by demon.li on 2016/7/17.
 */
public class LoginStore extends Store {

    private LoginModel loginModel = new LoginModel();
    private LoginStoreChangeEvent mLoginStoreChangeEvent;

    public LoginModel getLoginModel() {
        return loginModel;
    }

    @Override
    @Subscribe
    public void onAction(Action action) {

        if (action.getType() == Constans.ACTION_LOGIN) {
            LoginModel loginModel = (LoginModel) action.getData();
            String userName = loginModel.getUserName();
            String userPsw = loginModel.getUserPsw();

            if(userName!=null&&userName.equals("admin")&&userPsw!=null&&userPsw.equals("admin")){
                mLoginStoreChangeEvent = new LoginStoreChangeEvent(Constans.STORE_LOGIN_SUCCESS);
            }else{
                mLoginStoreChangeEvent = new LoginStoreChangeEvent(Constans.STORE_LOGIN_FAILED);
            }
            emitEventChange();
        }

    }

    @Override
    public BaseStoreChangeEvent getStoreChangeEvent() {
        return mLoginStoreChangeEvent;
    }
}
