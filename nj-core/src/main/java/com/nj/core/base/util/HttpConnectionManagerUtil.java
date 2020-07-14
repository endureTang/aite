/**
 * 
 */
package com.nj.core.base.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * HttpClient连接池管理类
 * @author MaSong
 */
public class HttpConnectionManagerUtil {
	
	/**连接管理器*/
	private static PoolingHttpClientConnectionManager connMgr=null;
	/**请求配置*/
	private static RequestConfig requestConfig=null;
	/**最大的超时时间，单位为毫秒*/
	private static final int MAX_TIMEOUT = 40000;
	/**最大读取超时时间*/
	private static final int MAX_READ_TIMEOUT=40000;
	/**从连接池获取连接实例的超时时间*/
	private static final int MAX_CONNECTION_REQUEST_TIMEOUT=40000;
	/**最大连接数*/
	private static final int MAX_TOTAL=200; 
    /**每个路由最大连接数 */
    private  static final int MAX_ROUTE_CONNECTIONS=100;  	
    

	private HttpConnectionManagerUtil(){
		 
		/**设置连接池*/
        connMgr = new PoolingHttpClientConnectionManager();
        /**设置连接池最大连接数*/
        connMgr.setMaxTotal(MAX_TOTAL);
        /**每个路由的最大连接数，比如访问的是两个地址，则会用到两个路由，最大连接为200，路由最大值不能超多过100*/
        connMgr.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
        /**在提交请求之前 测试连接是否可用，定义不活动的连接，多少秒进行验证，该字段待定*/
        //connMgr.setValidateAfterInactivity(1000);
        /**将目标主机的最大连接数增加到50,该字段待用,该字段主要用于单一的连接某个地址*/ 
        //HttpHost localhost = new HttpHost("http://blog.csdn.net/gaolu",80);
        //connMgr.setMaxPerRoute(new HttpRoute(localhost), 50);                
        
        /**连接配置*/
        RequestConfig.Builder configBuilder = RequestConfig.custom();
        /**设置连接超时时间*/
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        /**设置读取超时时间*/
        configBuilder.setSocketTimeout(MAX_READ_TIMEOUT);
        /**设置从连接池获取连接实例的超时时间*/
        configBuilder.setConnectionRequestTimeout(MAX_CONNECTION_REQUEST_TIMEOUT);
        /**创建请求配置*/
        requestConfig = configBuilder.build();
	}
	

    /**
     * 获得连接池实例
     * @return
     */
    public static PoolingHttpClientConnectionManager getInstance(){
    	if(connMgr==null){
    		synchronized (PoolingHttpClientConnectionManager.class) {
				if(connMgr==null){
					connMgr =new PoolingHttpClientConnectionManager();
					//张海添加
			        /**设置连接池最大连接数*/
			        connMgr.setMaxTotal(MAX_TOTAL);
			        /**每个路由的最大连接数，比如访问的是两个地址，则会用到两个路由，最大连接为200，路由最大值不能超多过100*/
			        connMgr.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
			        /**在提交请求之前 测试连接是否可用，定义不活动的连接，多少秒进行验证，该字段待定*/
			        //connMgr.setValidateAfterInactivity(1000);
			        /**将目标主机的最大连接数增加到50,该字段待用,该字段主要用于单一的连接某个地址*/ 
			        //HttpHost localhost = new HttpHost("http://blog.csdn.net/gaolu",80);
			        //connMgr.setMaxPerRoute(new HttpRoute(localhost), 50);                
			        
			        /**连接配置*/
			        RequestConfig.Builder configBuilder = RequestConfig.custom();
			        /**设置连接超时时间*/
			        configBuilder.setConnectTimeout(MAX_TIMEOUT);
			        /**设置读取超时时间*/
			        configBuilder.setSocketTimeout(MAX_READ_TIMEOUT);
			        /**设置从连接池获取连接实例的超时时间*/
			        configBuilder.setConnectionRequestTimeout(MAX_CONNECTION_REQUEST_TIMEOUT);
			        /**创建请求配置*/
			        requestConfig = configBuilder.build();
			        //end
				}
			}
    	}
    	return connMgr;
    }
    
	/**
     * 获取请求配置信息
     * @return
     */
    public static RequestConfig getRequestConfig(){
    	
    	if(requestConfig==null){
    		getInstance();
    	}
    	return requestConfig;
    	
    }
    
 
    /**
     * 获得CloseableHttpClient连接
     * @return
     */
    public static CloseableHttpClient getConnection(){
    	
    	if(connMgr==null){
    		getInstance();
    	}
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();   
        return httpClient;  
    }
    
    
    /**
     * 获得CloseableHttpClient连接SSL(HTTPS)
     * @return
     */
    public static CloseableHttpClient getConnectionForSSL(){
    	
    	if(connMgr==null){
    		getInstance();
    	}
    	CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();  
        return httpClient;  
    }
    
    
    /**
     * 获得CloseableHttpClient连接SSL(HTTPS)绕过证书
     * @return
     */
    public static CloseableHttpClient getConnectionForSSLNotVerify(){
    	
    	if(connMgr==null){
    		getInstance();
    	}
    	CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactoryNotVerify()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();  
        return httpClient;  
    }
   
	/**
	 * 绕过验证
	 * 	
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");

		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}
    
	/**
     * 创建SSL安全连接(绕过证书验证)
     * @return
     */
	private static SSLConnectionSocketFactory createSSLConnSocketFactoryNotVerify() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            	SSLContext sslContext = createIgnoreVerifySSL();
             
            	sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }
            });
            	
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return sslsf;
    }
	
    
    /**
     * 创建SSL安全连接
     * @return
     */
	private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            	sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }
            });
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return sslsf;
    }
    
    /**
     * 关闭连接池
     */
    public static void release() {
        if (connMgr != null) {
        	connMgr.shutdown();
        }
    }
    

}
