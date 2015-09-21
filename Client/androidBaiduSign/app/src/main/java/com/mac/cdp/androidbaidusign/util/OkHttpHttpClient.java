package com.mac.cdp.androidbaidusign.util;

import android.util.Log;

import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.apache.http.cookie.Cookie;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cdpmac on 15/9/14.
 */
public class OkHttpHttpClient implements IHttpClient {
    private static OkHttpClient client=new OkHttpClient();
    public static Map<String,String> nullPostData=new HashMap<String,String>();
    static{
        CookieManager cm=new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        client.setCookieHandler(cm);
    }
    public String get(String Url) {
        return get(Url,nullPostData);
    }
    public  String get(String Url,Map<String,String> FormData) {
        FormEncodingBuilder formEncodingBuilder =new FormEncodingBuilder();
        for(Map.Entry < String, String > postPara: FormData.entrySet()) {
            formEncodingBuilder.add(postPara.getKey(),postPara.getValue());
        }
        String result="";
        Request request = new Request.Builder()
                .url(Url)
                .get()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36")
                .build();
        try {
            Response res=client.newCall(request).execute();
            result=res.body().string();
        } catch (IOException e) {
            e.printStackTrace();

        }
        finally {
            return  result;
        }
    }
    public  String post(String Url) {
        return post(Url,nullPostData);
    }
    public  String post(String Url,Map<String,String> FormData) {
        FormEncodingBuilder formEncodingBuilder =new FormEncodingBuilder();
        for(Map.Entry < String, String > postPara : FormData.entrySet()) {
            formEncodingBuilder.add(postPara.getKey(),postPara.getValue());
        }
        String result="";
        Request request = new Request.Builder()
                .url(Url)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36")
                .post(formEncodingBuilder.build())
                .build();
        try {
            Response res=client.newCall(request).execute();
            result= res.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return  result;
        }
    }

    @Override
    public String getCookieString() {
        CookieManager cookieManager =(CookieManager)client.getCookieHandler();
        List<HttpCookie> cookies= cookieManager.getCookieStore().getCookies();
        StringBuilder sb=new StringBuilder();
        for (HttpCookie c:cookies) {
            sb.append(c.getName()+"="+c.getValue()+";");
        }
        return  sb.toString();
    }
}
