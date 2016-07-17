package com.demon.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demon.login.action.ActionsCreator;
import com.demon.login.action.LoginAction;
import com.demon.login.constants.Constans;
import com.demon.login.dispatcher.Dispatcher;
import com.demon.login.event.LoginStoreChangeEvent;
import com.demon.login.model.LoginModel;
import com.demon.login.store.LoginStore;

import org.greenrobot.eventbus.Subscribe;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText _editUserName;
    private EditText _editUserPsw;
    private Button _btnLogin;

    private LoginStore mLoginStore;
    private Dispatcher mDispatcher;
    private ActionsCreator mActionsCreator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        initDendencies();
    }

    private void findViewById() {
        _btnLogin = (Button) findViewById(R.id.btn_login);
        _editUserName = (EditText) findViewById(R.id.edit_input_username);
        _editUserPsw = (EditText) findViewById(R.id.edit_input_userpsw);
        _btnLogin.setOnClickListener(this);
    }

    private void initDendencies() {
        mLoginStore = new LoginStore();
        mDispatcher = new Dispatcher();
        mActionsCreator = ActionsCreator.get(mDispatcher);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.btn_login){
            String userName = _editUserName.getText().toString();
            String userPsw  = _editUserPsw.getText().toString();
            LoginModel loginModel = new LoginModel();
            loginModel.setUserName(userName);
            loginModel.setUserPsw(userPsw);
            mActionsCreator.onAciton(new LoginAction(Constans.ACTION_LOGIN,loginModel));
        }
    }

    @Subscribe
    public void onLoginActionEvent(LoginStoreChangeEvent storeChangeEvent){
        if(storeChangeEvent==null){
            return;
        }
        if(storeChangeEvent.status == Constans.STORE_LOGIN_SUCCESS){
            Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
        }else if(storeChangeEvent.status == Constans.STORE_LOGIN_FAILED){
            Toast.makeText(this,"登陆失败",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        mDispatcher.register(mLoginStore);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDispatcher.unregister(mLoginStore);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLoginStore.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLoginStore.unregister(this);
    }
}
