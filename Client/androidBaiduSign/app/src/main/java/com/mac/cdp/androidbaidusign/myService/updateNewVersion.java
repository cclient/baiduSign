//package com.mac.cdp.androidbaidusign.myService;//package com.mac.cdp.mytool.myService;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.IBinder;
//import android.util.Log;
//
////联系 service 和 弹出通知
//public class updateNewVersion extends Service {
//    private static final String TAG = "updateNewVersion";
////    private IBinder binder=new LocalService.LocalBinder();
//    public updateNewVersion() {
//    }
//
//    @Override
//    public void onCreate() {
//        Log.i(TAG, "onCreate");
//        //这里可以启动媒体播放器
//        // if(mediaPlayer==null)
//        //     mediaPlayer=MediaPlayer.create(this, uri);
//        super.onCreate();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.i(TAG, "onStartCommand");
//        return START_STICKY;
//    }
//
//
//    @Override
//    public void onDestroy() {
//        Log.i(TAG, "onDestroy");
//        super.onDestroy();
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//}
