package com.mac.cdp.androidbaidusign.util;

import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by cdpmac on 15/9/17.
 */
public class ApacheHttpClient implements IHttpClient {
    public static CookieStore cookieStore=new BasicCookieStore();
    public static CloseableHttpClient client= HttpClients.custom()
            .setDefaultCookieStore(cookieStore).build();
    public static Map<String,String> nullPostData=new HashMap<String,String>();
    @Override
    public String get(String url){
        return get(url, nullPostData);
    }
    @Override
    public String get(String Url, Map<String, String> FormData) {
        //todo FormData to querystring
        HttpGet httpget = new HttpGet(Url);
        return request(httpget);
    }

    @Override
    public String post(String Url) {
        return post(Url, nullPostData);
    }

    @Override
    public String post(String Url, Map<String, String> FormData) {
        List<NameValuePair> col = new ArrayList<NameValuePair>();
        HttpPost httpPost = new HttpPost(Url);
        for(Map.Entry < String, String > postPara : FormData.entrySet()) {
            col.add(new BasicNameValuePair(postPara.getKey(),
                    postPara.getValue()));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(col));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return request(httpPost);
    }

    @Override
    public String getCookieString() {
        List<Cookie> cookies= cookieStore.getCookies();
        StringBuilder sb=new StringBuilder();
        for (Cookie c:cookies) {
            sb.append(c.getName()+"="+c.getValue()+";");
        }
        return  sb.toString();
    }
    private String request(HttpUriRequest request){
        CloseableHttpResponse response=null;
        String result="";
        try {
            response= client.execute(request);
            result = convertResopnseToString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  result;
        }
    }


    public String oldpost(String PublicKey,String Pwd) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("publickey", PublicKey));
        nvps.add(new BasicNameValuePair("password", Pwd));
        try {
            HttpPost httpPost = new HttpPost(
                    "http://45.78.20.183:3000");
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response1 = httpclient.execute(httpPost);
            return convertResopnseToString(response1);

        } finally {
            httpclient.close();
        }
    }
    private String convertResopnseToString(CloseableHttpResponse response) throws IOException {
        ByteArrayInputStream bis = null;
            bis = new ByteArrayInputStream(
                        EntityUtils.toByteArray(response.getEntity()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis));
        StringBuilder sb = new StringBuilder();
        String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        return sb.toString();
    }

}
