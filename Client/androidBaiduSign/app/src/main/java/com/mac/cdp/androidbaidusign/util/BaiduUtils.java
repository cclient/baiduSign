package com.mac.cdp.androidbaidusign.util;

import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by cdpmac on 15/9/17.
 */
public class BaiduUtils {
    private class BaiduLoginParas{
        public String key="";
        public String token="";
        public String username="";
        public String password="";
        public String pubkey="";
    }
    private IHttpClient client;
    public BaiduUtils(IHttpClient client){
        this.client=client;
    }

    private void setToken(BaiduLoginParas pars){
        String url="https://passport.baidu.com/v2/api/?getapi&tpl=tb&apiver=v3&tt=" + StringUtils.getCurTs() + "&class=login&logintype=dialogLogin";
        client.get(url);
        String res= client.get(url);
        JsonParser jsonparer = new JsonParser();//初始化解析json格式的对象
        pars.token=jsonparer.parse(res).getAsJsonObject().get("data").getAsJsonObject().get("token").getAsString();
        Log.e("baidu token ", "");
        Log.e("baidu cookie", client.getCookieString());
    }

    private void setKeyGetPublickey(BaiduLoginParas pars){
        String res= client.get("https://passport.baidu.com/v2/getpublickey?token=" + pars.token + "&tpl=tb&apiver=v3&tt=" + StringUtils.getCurTs());
        JsonParser jsonparer = new JsonParser();
        JsonObject ele1=jsonparer.parse(res).getAsJsonObject();
        pars.key=ele1.get("key").getAsString();
        pars.pubkey=ele1.get("pubkey").getAsString();

        Log.e("baidu pubkey ", "");
        Log.e("baidu cookie", client.getCookieString());
    }


    private void setPwd(BaiduLoginParas pars)  {
        HashMap<String,String> postkv=new HashMap<String,String>();
        postkv.put("publickey", pars.pubkey);
        postkv.put("password", pars.password);
        String res= client.post("http://45.78.20.183:3000", postkv);
        Log.e("baidu pwd ", "");
        Log.e("baidu cookie", client.getCookieString());
        try {
            pars.password=java.net.URLDecoder.decode(res, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public boolean BaiDuLogin(String userName,String passWord){
        BaiduLoginParas loginParas=new BaiduLoginParas();
        loginParas.username=userName;
        loginParas.password=passWord;
        Log.e("baidu name", loginParas.username);
        setToken(loginParas);
        Log.e("baidu token", loginParas.token);
        setKeyGetPublickey(loginParas);
        Log.e("baidu pubkey", loginParas.pubkey);
        Log.e("baidu key", loginParas.key);
        setPwd(loginParas);
        Log.e("baidu pwd", loginParas.password);
        HashMap<String,String> postkv=new HashMap<String,String>();

        postkv.put("staticpage",
                "http://tieba.baidu.com/tb/static-common/html/pass/v3Jump.html");
        postkv.put("charset", "GBK");
        postkv.put("token", loginParas.token);
        postkv.put("tpl", "tb");
        postkv.put("apiver", "v3");
        postkv.put("tt", StringUtils.getCurTs()+"");
        postkv.put("logintype", "dialogLogin");
        postkv.put("safeflg", "0");
        postkv.put("u", "0");
        postkv.put("isPhone", "false");
        postkv.put("quick_user", "0");
        postkv.put("loginmerge", "true");
        postkv.put("mem_pass", "on");
        postkv.put("password", loginParas.password);
        postkv.put("username", loginParas.username);
        postkv.put("rsakey",loginParas.key);
        postkv.put("crypttype", "12");
        postkv.put("callback", "parent.bd__pcbs__ra2bo3");
        String res= client.post("https://passport.baidu.com/v2/api/?login", postkv);
        Log.e("baidu login", res);
        Log.e("baidu pwd ", "");
        Log.e("baidu cookie", client.getCookieString());

        return (res.indexOf("err_no=0")!=-1);
    }
    public HashMap<String,String> GetWatchBars(){
        String res=client.get("http://tieba.baidu.com/f/like/mylike?v="+StringUtils.getCurTs());
        Log.e("baidu bars ", "");
        Log.e("baidu bars", client.getCookieString());
        HashMap<String,String> bars=new HashMap<String,String>();
        Document doc = Jsoup.parse(res);
        Element tabdiv = doc.getElementsByClass("forum_table").get(0);
        Log.e("baidu bars div", tabdiv.html());
        Element tbody = tabdiv.child(0).child(0);
        for (Node tr : tbody.childNodes()) {
            Node a = tr.childNode(0).childNode(0);
            Log.e("baidu my bar", a.attr("title"));
            bars.put(a.attr("title"),a.attr("href"));
        }
        return bars;
    }
}
