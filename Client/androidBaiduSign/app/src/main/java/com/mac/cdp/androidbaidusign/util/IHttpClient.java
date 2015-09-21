package com.mac.cdp.androidbaidusign.util;

import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookieStore;
import java.util.Map;

/**
 * Created by cdpmac on 15/9/17.
 */
public interface IHttpClient {
    String get(String Url);
    String get(String Url,Map<String,String> FormData);
    String post(String Url);
    //HashMap 不用线程安全
    String post(String Url,Map<String,String> FormData);
    String getCookieString();

}
