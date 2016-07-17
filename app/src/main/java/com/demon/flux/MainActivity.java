package com.demon.flux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.demon.flux.actions.ActionCreator;
import com.demon.flux.dispatcher.Dispatcher;
import com.demon.flux.stores.MessageStore;
import com.demon.flux.stores.Store;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    ActionCreator mActionCreator;
    Dispatcher mDispatcher;
    MessageStore mMessageStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHelloWorld = (Button)findViewById(R.id.btn_hello_world);
        btnHelloWorld.setOnClickListener(this);
        initDependencies();
    }


    void initDependencies(){
        mMessageStore =  new MessageStore();
        mDispatcher = Dispatcher.get();
        mActionCreator = ActionCreator.get(mDispatcher);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.btn_hello_world:
                mActionCreator.sendMessage("Hello World");
                break;
            default:
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        mDispatcher.register(mMessageStore);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMessageStore.register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mMessageStore.unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDispatcher.unregister(mMessageStore);
    }

    void renderHelloWorld(MessageStore messageStore){
        Toast.makeText(this,messageStore.getMessage(),Toast.LENGTH_SHORT).show();
    }


    @Subscribe
    public void onStoreChange(Store.StoreChangeEvent event) {
        renderHelloWorld(mMessageStore);
    }
}
