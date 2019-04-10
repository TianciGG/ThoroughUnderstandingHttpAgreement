package chauncy.httprequestutil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**   
 * @classDesc: 功能描述(服务器模拟http请求工具httpclient实现)  
 * @author: ChauncyWang
 * @createTime: 2019年4月10日 下午4:03:22   
 * @version: 1.0  
 */  
public class HttpClientUtil {
	
	public static void main(String[] args) throws ParseException, IOException {
		//get("https://www.baidu.com");
		post("http://localhost/UserFormServlet");
	}
	
	/**
	 * 
	 * @methodDesc: 功能描述(模拟发送GET请求)  
	 * @author: ChauncyWang
	 * @param: @param url
	 * @param: @throws ParseException
	 * @param: @throws IOException   
	 * @createTime: 2019年4月10日 下午4:42:34   
	 * @returnType: void
	 */
	static public void get(String url) throws ParseException, IOException{
		//创建一个默认连接
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		//获取状态码
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if(statusCode == 200){
			HttpEntity entity = httpResponse.getEntity();
			String result = EntityUtils.toString(entity,"utf-8");
			System.out.println("result:"+result);
		}
	}
	
	/**
	 * 
	 * @methodDesc: 功能描述(模拟发送POST请求)  
	 * @author: ChauncyWang
	 * @param: @param url
	 * @param: @throws ClientProtocolException
	 * @param: @throws IOException   
	 * @createTime: 2019年4月10日 下午4:42:15   
	 * @returnType: void
	 */
	static public void post(String url) throws ClientProtocolException, IOException{
		//创建一个默认连接
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("token","13724912021304102734");
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("userName", "ChauncyWang"));
		formParams.add(new BasicNameValuePair("pwd", "123456"));
		UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formParams,"utf-8"); 
		httpPost.setEntity(urlEncodedFormEntity);
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		//获取状态码
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if(statusCode == 200){
			HttpEntity entity = httpResponse.getEntity();
			String result = EntityUtils.toString(entity,"utf-8");
			System.out.println("result:"+result);
		}
	}
}
