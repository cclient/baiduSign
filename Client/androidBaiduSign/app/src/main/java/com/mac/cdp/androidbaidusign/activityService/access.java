package com.mac.cdp.androidbaidusign.activityService;//package com.mac.cdp.mytool.activityService;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import com.mac.cdp.mytool.myService.activityAccessService;


import com.mac.cdp.androidbaidusign.R;
import com.mac.cdp.androidbaidusign.interf.ICallback;
import com.mac.cdp.androidbaidusign.myBroadcastReceiver.MyReceiver;
import com.mac.cdp.androidbaidusign.myService.activityAccessService;

//activity 获取 service对象，之后主动调用。
//方式A 轮询主动调用 msgService内的方法。
//方式B 在activity 中写回调方法，注入service service回调

//动态注册广播接收者

public class access extends AppCompatActivity {

    private ServiceConnection conn;
    private activityAccessService msgService;
    //回调方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.mac.cdp.mytool.hello"); //为BroadcastReceiver指定action，即要监听的消息名字。
        registerReceiver(new MyReceiver(), intentFilter);
//destory 中取消;
//        unregisterReceiver(MyBroadcastReceiver); //取消监听
        conn =new ServiceConnection(){
            @Override
            public void onServiceConnected(ComponentName name, IBinder service){
                msgService=((activityAccessService.MsgBinder)service).getService();
                //设置回调
                msgService.setCallBack(new ICallback() {
                    @Override
                    public void excute() {

                    }
                });
            }
            @Override
            public void onServiceDisconnected(ComponentName name){

            }
        };

        Intent uploadLog = new Intent(this, activityAccessService.class);

        bindService(uploadLog,conn, Context.BIND_AUTO_CREATE);

//        msgService........ //主动调用

//        setContentView(R.layout.activity_access);
    }
}
