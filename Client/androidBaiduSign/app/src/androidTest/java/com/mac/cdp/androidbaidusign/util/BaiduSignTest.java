package com.mac.cdp.androidbaidusign.util;

import android.util.Log;

import junit.framework.TestCase;

/**
 * Created by cdpmac on 15/9/17.
 */
public class BaiduSignTest extends TestCase {

    public void testBaiDuLogin() throws Exception {
        // when usr Apache the cookies is usefull and can get bars
//        IHttpClient client= new ApacheHttpClient();

        //while when use  okhttp the i can't get bars is the cookie not used?or other reason?
        IHttpClient client=new OkHttpHttpClient();

        BaiduUtils bs=new BaiduUtils(client);
        boolean loginresult= bs.BaiDuLogin("18701520209", "ziseyicao");
        if(loginresult){
            Log.e("baidu login", "login success");
            Log.e("baidu cookie", client.getCookieString());
            bs.GetWatchBars();
        }
        else{
            Log.e("baidu login", "login failde");
        }
    }
}