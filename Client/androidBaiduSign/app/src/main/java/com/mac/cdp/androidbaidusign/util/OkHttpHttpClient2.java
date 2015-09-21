package com.mac.cdp.androidbaidusign.util;

import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookieStore;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cdpmac on 15/9/14.
 */
public class OkHttpHttpClient2 {
    //    /    public final static String HOST = "www.oschina.net";
    //    private static String API_URL = "http://www.oschina.net/%s";
//    public static final String PUT = "PUT";
    private static OkHttpClient client;
    public static Map<String,String> nullPostData;
    static{
        client=new OkHttpClient();

//        String sha= CyptoUtils.encode("SHA1","MIICWTCCAcICCQDN/snE1Gz/czANBgkqhkiG9w0BAQUFADBxMQswCQYDVQQGEwJD\n" +
//                "TjEQMA4GA1UECBMHQmVpamluZzESMBAGA1UEBxMJRG9uZ2NoZW5nMQ4wDAYDVQQK\n" +
//                "EwVHb3lvbzEOMAwGA1UECxMFQXVkaXQxHDAaBgNVBAMTE3d3dy5odHRwc3NlcnZl\n" +
//                "ci5jb20wHhcNMTUwNzA4MDczMjU1WhcNMTUwODA3MDczMjU1WjBxMQswCQYDVQQG\n" +
//                "EwJDTjEQMA4GA1UECBMHQmVpamluZzESMBAGA1UEBxMJRG9uZ2NoZW5nMQ4wDAYD\n" +
//                "VQQKEwVHb3lvbzEOMAwGA1UECxMFQXVkaXQxHDAaBgNVBAMTE3d3dy5odHRwc3Nl\n" +
//                "cnZlci5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAKR7JKrWrrZC2/Us\n" +
//                "4UAbXgMGB/7LD3dAImppRPvczUbFh+g7lqN667FGN6yluihdSOsfrTCGYxXLmjkm\n" +
//                "eb0rf94NEF9KHiiUVbNn2fmPMDsVMh+JV02GyPC8DzbxuLPNEz5Q2d31b5Nhh3U6\n" +
//                "vDKJqUD84YeKDdsJv6pM1weZYCbNAgMBAAEwDQYJKoZIhvcNAQEFBQADgYEAPWKI\n" +
//                "8fsO9VhlNkTWB5Q+IFKWioSVCGm4WGuqgQFF58YJprQufxsurwo9keJr2MG55Mje\n" +
//                "hl+b/FrkJWFIkhIYo/1iC7znj3kX9db6UsU56cXZkZtTxyTVH0Nma7tDFU1DLINh\n" +
//                "NWaFsqrXxxhKqLkgi2aZGDUX8gUnMTXFI7BUIqM=");
//
//        System.out.println(sha);
//        Log.w("sha1",sha);
//        client.setCertificatePinner(new CertificatePinner.Builder().add("211.155.94.195", "sha1/" + sha).build());
        nullPostData=new HashMap<String,String>();
    }

    public static String get(String Url) {
        return get(Url,nullPostData);
    }
    public static String get(String Url,Map<String,String> FormData) {
        FormEncodingBuilder formEncodingBuilder =new FormEncodingBuilder();
        for(Map.Entry < String, String > postPara: FormData.entrySet()) {
            formEncodingBuilder.add(postPara.getKey(),postPara.getValue());
        }
        Request request = new Request.Builder()
                .url(Url)
//                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36")
//                .header("Pragma", "no-cache")
//                .header("Cookie", "BAIDUID=22AF90D81EDAFB1258EAE5D3549EB71F:FG=1; TIEBA_USERTYPE=e7d5aa4e196a2a83d6d49317; PSTM=1442483175; BIDUPSID=8C0D1C2056FFD76A5E76CA8178F4C31B; H_PS_PSSID=14345_1443_16057_17286_12867_17105_17001_17004_17072_15959_17347_12118_13932_17050; BDUSS=HVGb085akNiRTZCaGlWYndUV21Ba1dPdVd-V3pzaVM2V3lxNlBPTzFhbU9IQ0pXQVFBQUFBJCQAAAAAAAAAAAEAAAD36Vsb18-76sfg0MQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAI6P-lWOj~pVd; TIEBAUID=2efb27f70bc34c2538f3e5fb; LONGID=459008503")
                .header("Cookie", "BAIDUID=55D4705805E021B0999FAF29B8EE5951:FG=1; TIEBA_USERTYPE=edaa8f295488456a80e7801e; BDUSS=nRyOU9EYlprR3VGcmROdVhTZ0hmeWdXWmN5QjUtYWI3WnQ4UlY1bFJTd3lIeUpXQVFBQUFBJCQAAAAAAAAAAAEAAAD36Vsb18-76sfg0MQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADKS-lUykvpVe; TIEBAUID=cb23caae14130a0d384a57f1")
                .get()
                .build();
        Log.w("baidu req header", "start");
        Headers reqheaders = request.headers();
        Log.w("baidu req header length",reqheaders.size()+"");
        for (int i = 0, size = reqheaders.size(); i < size; i++) {
            Log.w("baidu req header", reqheaders.name(i) + ": " + reqheaders.value(i));
        }


        try {
            Response res=client.newCall(request).execute();
            Log.w("baicai ",res.body().string());
            return res.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static String post(String Url) {
        return post(Url,nullPostData);
    }
    //HashMap 不用线程安全
    public static String post(String Url,Map<String,String> FormData) {
        FormEncodingBuilder formEncodingBuilder =new FormEncodingBuilder();
        for(Map.Entry < String, String > postPara : FormData.entrySet()) {
            formEncodingBuilder.add(postPara.getKey(),postPara.getValue());
        }
        Request request = new Request.Builder()
                .url(Url)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36")
//                .header("Pragma","no-cache")
//                .header("Cookie","BAIDUID=00715314C936AE8E870374A888CA50A7:FG=1;HOSUPPORT=1;")
                .post(formEncodingBuilder.build())
                .build();
        Log.w("baidu req header","start");
        Headers reqheaders=request.headers();
        Log.w("baidu req header length",reqheaders.size()+"");
        for (int i = 0, size = reqheaders.size(); i < size; i++) {
            Log.w("baidu req header", reqheaders.name(i) + ": " + reqheaders.value(i));
        }
        try {
            Response res=client.newCall(request).execute();
            Log.w("baidu res header","start");
            Headers resheaders=res.headers();
            for (int i = 0, size = resheaders.size(); i < size; i++) {
                Log.w("baidu res header",resheaders.name(i) + ": " + resheaders.value(i));
            }
//            return client.newCall(request).execute().body().string();
            return res.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static void setCookie(CookieManager cookieManager)
    {
        client.setCookieHandler(cookieManager);
    }
    public static void cleanCookie() {
        client.setCookieHandler(null);
    }
    public static CookieStore getCookie() {
        CookieManager cookieManager =(CookieManager)client.getCookieHandler();
        CookieStore cs= cookieManager.getCookieStore();
        return  cs;
    }
}
