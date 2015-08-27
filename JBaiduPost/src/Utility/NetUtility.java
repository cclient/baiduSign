package Utility;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NetUtility {
	
	
	private BasicCookieStore cookies;
	private  String Key="";
	private  String UserName="";
	private  String PublicKey="";
	private  String Pwd="";
	private  String EnPwd="";
	private  String token = "";	 
  
    
	public NetUtility(String UserName,String Pwd){
		this.UserName=UserName;
		this.Pwd=Pwd;
		this.cookies=new BasicCookieStore();
	}
	
    private static String GetTimeString(){
    	
   	 Date now = new Date(); 
     return now.getTime()+"";
    }
	
    
    
	 public  void GetToken()throws Exception {
		
		 this.cookies=null;
		 this.cookies=new BasicCookieStore( );
		   System.out.println("cookie store:" + 		 this.cookies);
//		 CloseableHttpClient httpclient = HttpClients.createMinimal();
		 CloseableHttpClient httpclient = HttpClients.custom()
	                .setDefaultCookieStore(cookies)
	                .build();       
	  	 String tt=GetTimeString();
	  	 try {
	  		 
	  		 HttpGet httpget = new HttpGet("https://passport.baidu.com/v2/api/?getapi&tpl=tb&apiver=v3&tt=" + tt + "&class=login&logintype=dialogLogin");
	         CloseableHttpResponse response1 = httpclient.execute(httpget);
	         try {
	        	 response1 = httpclient.execute(httpget);
	             ByteArrayInputStream bis = new ByteArrayInputStream(EntityUtils.toByteArray(response1.getEntity()));  
	             String ss=convertStreamToString(bis).replace("/n", "");
	             JsonParser jsonparer = new JsonParser();//��ʼ������json��ʽ�Ķ���
	             token = jsonparer.parse(ss).getAsJsonObject().get("data").getAsJsonObject().get("token").getAsString();
	             
	             System.out.println("cookie store:" + 		 this.cookies);
	         } finally {
	             response1.close();
	         }
	  	 }finally {
	  		httpclient.close();
         }

     } 

	 public void GetPublicKey()throws Exception{
		 String tt=GetTimeString();
		 CloseableHttpClient httpclient = HttpClients.custom()
	                .setDefaultCookieStore(cookies)
	                .build();
	  	 ;
		 try {
			 HttpGet httpget = new HttpGet("https://passport.baidu.com/v2/getpublickey?token=" + token + "&tpl=tb&apiver=v3&tt=" + tt);
	         CloseableHttpResponse response1 = httpclient.execute(httpget);
			 try {
		         response1 = httpclient.execute(httpget);
		         ByteArrayInputStream bis = new ByteArrayInputStream(EntityUtils.toByteArray(response1.getEntity()));  
		         String ss=convertStreamToString(bis).replace("/n", "");
		         JsonParser jsonparer = new JsonParser();//��ʼ������json��ʽ�Ķ���
		         JsonObject ele1=jsonparer.parse(ss).getAsJsonObject();
		         Key =ele1.get("key").getAsString(); 
		         PublicKey =ele1.get("pubkey").getAsString(); 
		         System.out.println("cookie store:" + 		 this.cookies);
	         } finally {
	        	 response1.close();
	         }
			 
		 }finally {
	  		httpclient.close();
         }
	 }
	 
	 

	 public  void getEnrPwd()throws Exception {
		  CloseableHttpClient httpclient = HttpClients.createDefault();
		  
		   List <NameValuePair> nvps = new ArrayList <NameValuePair>();
           nvps.add(new BasicNameValuePair("publickey", PublicKey));
           nvps.add(new BasicNameValuePair("password",Pwd));
		  try {
			   HttpPost httpPost = new HttpPost("http://localhost:3000");
	           httpPost.setEntity(new UrlEncodedFormEntity(nvps));
	           
	           CloseableHttpResponse response1 = httpclient.execute(httpPost);
				 try {
					   ByteArrayInputStream bis = new ByteArrayInputStream(EntityUtils.toByteArray(response1.getEntity()));  
			           EnPwd=convertStreamToString(bis);
			           EnPwd=EnPwd.substring(0,EnPwd.lastIndexOf("/n"));			           
			           EnPwd= java.net.URLDecoder.decode(EnPwd,   "utf-8");
		         } finally {
		        	 response1.close();
		         }
				 
			 }finally {
		  		httpclient.close();
	         }
     }

	 public  String Login() throws Exception {
		 String tt=GetTimeString();
		 List <NameValuePair> col = new ArrayList <NameValuePair>();
         col.add(new BasicNameValuePair("staticpage", "http://tieba.baidu.com/tb/static-common/html/pass/v3Jump.html"));
         col.add(new BasicNameValuePair("charset", "GBK"));
         col.add(new BasicNameValuePair("token", token));
         col.add(new BasicNameValuePair("tpl", "tb"));
         col.add(new BasicNameValuePair("apiver", "v3"));
         col.add(new BasicNameValuePair("tt", tt));
         col.add(new BasicNameValuePair("logintype", "dialogLogin"));
         col.add(new BasicNameValuePair("safeflg", "0"));
         col.add(new BasicNameValuePair("u", "0"));
         col.add(new BasicNameValuePair("isPhone", "false"));
         col.add(new BasicNameValuePair("quick_user", "0"));
         col.add(new BasicNameValuePair("loginmerge", "true"));
         col.add(new BasicNameValuePair("mem_pass", "on"));
         col.add(new BasicNameValuePair("password", EnPwd));
         col.add(new BasicNameValuePair("username", UserName));
         col.add(new BasicNameValuePair("rsakey", Key));
         col.add(new BasicNameValuePair("crypttype", "12"));
         col.add(new BasicNameValuePair("callback", "parent.bd__pcbs__ra2bo3"));
    	 CloseableHttpClient httpclient = HttpClients.custom()
	                .setDefaultCookieStore(cookies)
	                .build();
    	  try {
    		  HttpPost httpPost = new HttpPost("https://passport.baidu.com/v2/api/?login");
    		  
    		  httpPost.setEntity(new UrlEncodedFormEntity(col));
    	      CloseableHttpResponse response1 = httpclient.execute(httpPost);
				 try {
					   response1 = httpclient.execute(httpPost);
					      ByteArrayInputStream bis = new ByteArrayInputStream(EntityUtils.toByteArray(response1.getEntity()));  
					      String ss=convertStreamToString(bis).replace("/n", "");
					      
					      System.out.println(ss);
					      return ss;
		         } finally {
		        	 response1.close();
		         }
				 
			 }finally {
		  		httpclient.close();
	         }

     }

	 
	 
	 public static String convertStreamToString(InputStream is) {   
    	   BufferedReader reader = new BufferedReader(new InputStreamReader(is));   
    	        StringBuilder sb = new StringBuilder();   
    	        String line = null;   
    	        try {   
    	            while ((line = reader.readLine()) != null) {   

    	                sb.append(line + "/n");   
    	            }   

    	        } catch (IOException e) {   

    	            e.printStackTrace();   

    	        } finally {   

    	            try {   

    	                is.close();   

    	            } catch (IOException e) {   

    	                e.printStackTrace();   

    	            }   
    	        }   
    	        return sb.toString();   

    	    }   
}
