import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import Utility.NetUtility;





public class Main {
	  public static void main(String[] args) throws Exception {
		  //return resultΪ0��Ϊ��¼�ɹ�
//			NetUtility ntl=new NetUtility("�˺�","����");
            //��ȡtoken
			
			
			NetUtility ntl=new NetUtility("18701520209","ziseyicao");
			
			
			ntl.GetToken();
			ntl.GetToken();
            ntl.GetPublicKey();
            ntl.getEnrPwd();
            ntl.Login();
          
	    }
	
}
