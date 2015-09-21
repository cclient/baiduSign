package com.mac.cdp.androidbaidusign.myService;//package com.mac.cdp.mytool.myService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.mac.cdp.androidbaidusign.interf.ICallback;

public class activityAccessService extends Service {
    public activityAccessService() {
    }
    private ICallback callback;
//
    @Override
    public IBinder onBind(Intent intent) {
        return new MsgBinder();
    }

    public void setCallBack(ICallback iCallback){
        callback=iCallback;
    }
    //发广播，通过广播通信（个人不推荐这种）
    public  void sendBroacast(){
//        发送广播消息，把要发送的信息和用于过滤的信息(如Action、Category)装入一个Intent对象，然后通过调用 Context.sendBroadcast()、sendOrderBroadcast()或sendStickyBroadcast()方法，把 Intent对象以广播方式发送出去。
        Intent intent = new Intent("com.mac.cdp.mytool.hello");
        intent.putExtra("Name", "hellogv");
        intent.putExtra("Blog", "http://blog.csdn.net/hellogv");
        sendBroadcast(intent);//传递过去
    }
    public class MsgBinder extends Binder {
        /**
         * 获取当前Service的实例
         * @return
         */
        public activityAccessService getService(){
            return activityAccessService.this;
        }
    }

}
