//package com.mac.cdp.androidbaidusign.util;
//
//import android.util.Log;
//
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.AsyncHttpResponseHandler;
//import com.loopj.android.http.RequestParams;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//
//import org.apache.http.Header;
//import org.apache.http.client.CookieStore;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.nodes.Node;
//import org.jsoup.select.Elements;
//
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.net.CookieHandler;
//import java.net.CookieManager;
//import java.net.CookiePolicy;
//import java.net.HttpCookie;
//import java.util.HashMap;
//import java.util.List;
//
////import static java.net.CookiePolicy;
////import org.junit.runner.RunWith;
//
//
///**
// * Created by cdpmac on 15/9/14.
// */
////@RunWith(RobolectricGradleTestRunner.class)
////@Config(constants = BuildConfig.class)
////@Config(constants = BuildConfig.class)
//
//public class net {
//    private class BaiduLoginParas{
//        public String key="";
//        public String token="";
//        public String username="";
//        public String password="";
//        public String pubkey="";
//    }
//    private void setKeyGetPublickey(BaiduLoginParas pars){
//
//        String res= ApiHttpClient.get("https://passport.baidu.com/v2/getpublickey?token=" + pars.token + "&tpl=tb&apiver=v3&tt=" + StringUtils.getCurTs());
//        JsonParser jsonparer = new JsonParser();
//        JsonObject ele1=jsonparer.parse(res).getAsJsonObject();
//        pars.key=ele1.get("key").getAsString();
//        pars.pubkey=ele1.get("pubkey").getAsString();
//        System.out.println(pars.key);
//        System.out.println(pars.key.length());
//        System.out.println(pars.pubkey);
//        System.out.println(pars.pubkey.length());
//    }
//
//    private void setToken(BaiduLoginParas pars){
//        String url="https://passport.baidu.com/v2/api/?getapi&tpl=tb&apiver=v3&tt=" + StringUtils.getCurTs() + "&class=login&logintype=dialogLogin";
//        ApiHttpClient.get(url);
//        String res= ApiHttpClient.get(url);
//        JsonParser jsonparer = new JsonParser();//初始化解析json格式的对象
//        pars.token=jsonparer.parse(res).getAsJsonObject().get("data").getAsJsonObject().get("token").getAsString();
//        System.out.println(pars.token);
////        System.out.println(pars.token.length());
//    }
//
//    public void SignTieba(String kw) {
////        Log.w("baidu sign kw",kw);
////        printCookie();
//        String tbs=GetTbsFromHtml(kw);
////        HashMap<String,String> postkv=new HashMap<String,String>();
////        postkv.put("ie", "utf-8");
////        postkv.put("kw", kw);
////        postkv.put("tbs", tbs);
////        String result=ApiHttpClient.post("http://tieba.baidu.com/sign/add",postkv);
////        Log.w("baidu sign resutl",result);
//    }
//
//
//    private void setPwd(BaiduLoginParas pars)  {
//        HashMap<String,String> postkv=new HashMap<String,String>();
//        postkv.put("publickey", pars.pubkey);
//        postkv.put("password", pars.password);
//        String res= ApiHttpClient.post("http://45.78.20.183:3000",postkv);
//
////            pars.password=res;
//        try {
//            pars.password=java.net.URLDecoder.decode(res, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void BaiDuLogin(String userName,String passWord){
//        BaiduLoginParas loginParas=new BaiduLoginParas();
//        loginParas.username=userName;
//        loginParas.password=passWord;
//        Log.e("baidu name", loginParas.username);
//        ApiHttpClient.setCookie(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
//        setToken(loginParas);
//        Log.e("baidu token", loginParas.token);
//        setKeyGetPublickey(loginParas);
//        Log.e("baidu pubkey", loginParas.pubkey);
//        Log.e("baidu key", loginParas.key);
//        setPwd(loginParas);
//        Log.e("baidu pwd", loginParas.password);
//        HashMap<String,String> postkv=new HashMap<String,String>();
//
//        postkv.put("staticpage",
//                "http://tieba.baidu.com/tb/static-common/html/pass/v3Jump.html");
//        postkv.put("charset", "GBK");
//        // postkv.put("charset", "-");
//        postkv.put("token", loginParas.token);
//        postkv.put("tpl", "tb");
//        postkv.put("apiver", "v3");
//        postkv.put("tt", StringUtils.getCurTs()+"");
//        postkv.put("logintype", "dialogLogin");
//        postkv.put("safeflg", "0");
//        postkv.put("u", "0");
//        postkv.put("isPhone", "false");
//        postkv.put("quick_user", "0");
//        postkv.put("loginmerge", "true");
//        postkv.put("mem_pass", "on");
//        postkv.put("password", loginParas.password);
//        postkv.put("username", loginParas.username);
//        postkv.put("rsakey",loginParas.key);
//        postkv.put("crypttype", "12");
//        postkv.put("callback", "parent.bd__pcbs__ra2bo3");
//
//        String res1= ApiHttpClient.post("https://passport.baidu.com/v2/api/?login", postkv);
//        Log.e("baidu login", res1);
////        printCookie();
////            GetWatchBars();
////        SignTieba("clannad");
//        GetTbsFromHtml("clannad");
//    }
//
//
//    private String GetTbsFromHtml(String kw)
//    {
//
//
//
//
//
////        ApiHttpClient.get("http://tieba.baidu.com");
////        printCookie();
//        String tiebastring="/f?kw="+kw;
////        Request req=new Request.Builder().url("http://tieba.baidu.com" + tiebastring).get().build();
//
//        String result= ApiHttpClient.get("http://tieba.baidu.com" + tiebastring);
//
////        OkHttpClient okHttpClient=new OkHttpClient();
////        CookieManager cm=new CookieManager(ApiHttpClient.getCookie(),CookiePolicy.ACCEPT_ALL);
////        CookieHandler.setDefault(cm);
////        okHttpClient.setCookieHandler(CookieHandler.getDefault());
//////        okHttpClient.setCookieHandler(cm);
////        String result= null;
////        try {
////            result = okHttpClient.newCall(req).execute().body().string();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        Log.w("baidu tbs result",result);
//                Document doc = Jsoup.parse(result);
//                String tbs = null;
//                Elements nodes = doc.head().getElementsByTag("script");
//                for (Element ele : nodes) {
//                    String text = ele.toString();
//                    Log.w("baidu script",text);
//                    int indexoftbs = text.indexOf("'tbs':");
//                    if (indexoftbs != -1) {
//                        tbs = text.substring(indexoftbs + 8, indexoftbs + 34);
//                        break;
//                    }
//                }
//        return tbs;
//    }
//
//    public void getBars(){
//        AsyncHttpClient client =new AsyncHttpClient();
//        client.setCookieStore((CookieStore) ApiHttpClient.getCookie());
//        client.get("http://tieba.baidu.com/f/like/mylike?v="+StringUtils.getCurTs(), new RequestParams(),new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int arg0, Header[] arg1,
//                                  byte[] arg2) {
//                ByteArrayInputStream bis= new ByteArrayInputStream(arg2);
////                String ss = convertStreamToString(bis).replace("/n", "");
//                BufferedReader reader = new BufferedReader(new InputStreamReader(bis));
//                StringBuilder sb = new StringBuilder();
//                String line = null;
//                try {
//                    while ((line = reader.readLine()) != null) {
//                        sb.append(line + "/n");
//                    }
//                    System.out.println(sb.toString());
//                    System.out.println(sb.toString().length());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            @Override
//            public void onFailure(int arg0, Header[] arg1,
//                                  byte[] arg2, Throwable arg3) {
//                System.out.println("网络异常,云端文件暂未删除");
//            }
//        });
//    }
//    public void printCookie(){
//        List<HttpCookie> lcoois= ApiHttpClient.getCookie().getCookies();
//        StringBuilder sb=new StringBuilder();
//        for (HttpCookie c:lcoois) {
//            sb.append(c.getName()+"\t");
//            sb.append(c.getValue()+"\t");
//            sb.append(c.getDomain()+"\n");
//        }
//        Log.e("baidu cookie",sb.toString());
//        System.out.println(sb);
//    }
//    public HashMap<String,String> GetWatchBars(){
////        ApiHttpClient.get("http://tieba.baidu.com");
////        printCookie();
////
//////        ApiHttpClient.get("http://tieba.baidu.com");
////
////        String res=ApiHttpClient.get("http://tieba.baidu.com/f/like/mylike?v="+StringUtils.getCurTs());
////        printCookie();
////        Log.w("baidu bars",res);
////        Log.w("baidu bars",res.length()+"");
////        System.out.print("baidu bars \n"+res);
////        HashMap<String,String> bars=new HashMap<String,String>();
////        Document doc = Jsoup.parse(res);
////        Element tabdiv = doc.getElementsByClass("forum_table").get(0);
////        Log.w("baidu bars div",tabdiv.html());
////        Element tbody = tabdiv.child(0).child(0);
////        Log.w("baidu bars table",tabdiv.html());
////        for (Node tr : tbody.childNodes()) {
////            // td->a
////            Node a = tr.childNode(0).childNode(0);
////            Log.w("baidu bars a", a.outerHtml());
////            System.out.println(a.attr("title"));
////            bars.put(a.attr("title"),a.attr("href"));
////        }
////        return bars;
//
//
//
//        Request req=new Request.Builder().url("http://tieba.baidu.com/f/like/mylike?v=" + StringUtils.getCurTs()).get().build();
//        OkHttpClient okHttpClient=new OkHttpClient();
//        CookieManager cm=new CookieManager(ApiHttpClient.getCookie(),CookiePolicy.ACCEPT_ALL);
//        okHttpClient.setCookieHandler(cm);
//        try {
//            String result= okHttpClient.newCall(req).execute().body().string();
//
//            System.out.print("bar string \n"+result);
//            Log.w("baidu bars div",result);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////
////        String result=  ApiHttpClient.get("http://tieba.baidu.com/f/like/mylike?v=" + StringUtils.getCurTs());
////        System.out.print("bar string \n"+result);
////        Log.w("baidu bars div",result);
//        return  null;
//    }
//
////    String get(URL url) throws IOException {
////        HttpURLConnection connection = client.open(url);
////        InputStream in = null;
////        try {
////            // Read the response.
////            in = connection.getInputStream();
////            byte[] response = readFully(in);
////            return new String(response, "UTF-8");
////        } finally {
////            if (in != null) in.close();
////        }
////    }
//
//
////    String post(URL url, byte[] body) throws IOException {
////        HttpURLConnection connection = client.open(url);
////        OutputStream out = null;
////        InputStream in = null;
////        try {
////            // Write the request.
////            connection.setRequestMethod("POST");
////            out = connection.getOutputStream();
////            out.write(body);
////            out.close();
////
////            // Read the response.
////            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
////                throw new IOException("Unexpected HTTP response: "
////                        + connection.getResponseCode() + " " + connection.getResponseMessage());
////            }
////            in = connection.getInputStream();
////            return readFirstLine(in);
////        } finally {
////            // Clean up.
////            if (out != null) out.close();
////            if (in != null) in.close();
////        }
////    }
//
//}
