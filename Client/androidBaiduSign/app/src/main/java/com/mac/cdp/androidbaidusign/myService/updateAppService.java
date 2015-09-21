package com.mac.cdp.androidbaidusign.myService;//package com.mac.cdp.mytool.myService;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mac.cdp.androidbaidusign.AppConfig;
import com.mac.cdp.androidbaidusign.R;
import com.mac.cdp.androidbaidusign.interf.ICallback;
import com.mac.cdp.androidbaidusign.util.IHttpClient;
import com.mac.cdp.androidbaidusign.util.OkHttpHttpClient;


import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class updateAppService extends Service {
    private  TimerTask intrenal;
    private  int intertime=1000;
    private final Timer timer = new Timer();
    public updateAppService() {
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
    //
    private  int id=0;
    private boolean needUpdate(int current,int lastest){
        return  current<lastest;
    }
    public  void SetUpdateNotice(){
        Log.e("baidu sign",id+" 通知");
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);


        mBuilder.setContentTitle("版本更新")//设置通知栏标题
                .setContentText("有新版本")
                .setContentIntent(getDefalutIntent(Notification.FLAG_AUTO_CANCEL)) //设置通知栏点击意图
  .setNumber(10) //设置通知集合的数量
                .setTicker("检测到新版本") //通知首次出现在通知栏，带上升动画效果的
                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
//  .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setDefaults(Notification.DEFAULT_VIBRATE)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
                        //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                .setSmallIcon(R.drawable.ic_launcher);//设置通知小ICON
        if(id<4){
            mNotificationManager.notify(id>5?id:id++,mBuilder.build());
        }



    }
    @Override
    public void onCreate() {
       String version= AppConfig.getVersion(this);
        Log.e("baidu sign", "现版本"+ version);
//        SetUpdateNotice();
        intrenal = new TimerTask() {
            @Override
            public void run() {
                IHttpClient client =new OkHttpHttpClient();

                //获取版本
//                String res= client.get("http://45.78.20.183:3000/app/version");
//                Log.w("get version",res);
//                JsonParser jsonParser=new JsonParser();
//                JsonObject element=jsonParser.parse(res).getAsJsonObject();
//                String version= element.get("item").getAsJsonObject().get("version").getAsString();
//                Log.e("baidu sign", "获取 版本");
                SetUpdateNotice();
            }
            //如果有新版 则 停止任务，并启动下载任务
            //下载任务完成  或异常时，再启动服务

        };
        timer.schedule(intrenal,intertime,intertime);
    }

    public PendingIntent getDefalutIntent(int flags){
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 1, new Intent(), flags);
        return pendingIntent;
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
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
        public updateAppService getService(){
            return updateAppService.this;
        }
    }

}
