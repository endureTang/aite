/**
 * 
 */
package com.nj.core.base.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * HttpClient工具类
 * @author MaSong
 */
public class HttpUtil {
	
	/**日志*/
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	   /**
     * 发送 GET 请求（HTTP），不带输入数据
     * @param url
     * @return
     */
    public static String doGet(String url) {
        return doGet(url, new HashMap<String, Object>());
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式
     * @param url
     * @param params
     * @return
     */
    public static String doGet(String url, Map<String, Object> params) {
        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
            if (i == 0)
                param.append("?");
            else
                param.append("&");
            param.append(key).append("=").append(params.get(key));
            i++;
        }
        apiUrl += param;
        String result = null;
        CloseableHttpClient httpclient = HttpConnectionManagerUtil.getConnection();
        try {
            HttpGet httpPost = new HttpGet(apiUrl);
            HttpResponse response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            System.out.println("执行状态码 : " + statusCode);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                result = IOUtils.toString(instream, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 发送 POST 请求（HTTP），不带输入数据
     * @param apiUrl
     * @return
     */
    public static String doPost(String apiUrl) {
        return doPost(apiUrl, new HashMap<String, Object>());
    }
    

    /**
     * 发送 POST 请求（HTTP），K-V形式
     * @param apiUrl API接口URL
     * @param params 参数map
     * @return
     */
    public static String doPost(String apiUrl, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnection();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
            	if(entry.getValue() != null) {
            		NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                            .getValue().toString());
                    pairList.add(pair);
            	}
                
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
            response = httpClient.execute(httpPost);
            System.out.println(response.toString());
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }
    
	
    /**
     * 发送 POST 请求（HTTP），JSON形式
     * @param apiUrl
     * @param json json对象
     * @return
     */
    public static String doPost(String apiUrl, Object json) {
        CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnection();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
            StringEntity stringEntity = new StringEntity(json.toString(),"UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            System.out.println(response.getStatusLine().getStatusCode());
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }
    
    
    /**
     * 发送POST请求（HTTP）,字符串形式
     * @param apiUrl
     * @param xmlStr
     * @return
     */
    public static String  doPost(String apiUrl,String str){
    	
    	 	CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnection();
	        String httpStr = null;
	        HttpPost httpPost = new HttpPost(apiUrl);
	        CloseableHttpResponse response = null;

	        try {
	            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
	            StringEntity stringEntity = new StringEntity(str,"UTF-8");//解决中文乱码问题
	            stringEntity.setContentEncoding("UTF-8");
	            stringEntity.setContentType("application/x-www-form-urlencoded");
	            httpPost.setEntity(stringEntity);
	            response = httpClient.execute(httpPost);
	            HttpEntity entity = response.getEntity();
	            //System.out.println(response.getStatusLine().getStatusCode());
	            httpStr = EntityUtils.toString(entity, "UTF-8");
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (response != null) {
	                try {
	                    EntityUtils.consume(response.getEntity());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return httpStr;    	
    }
    
    /**
     * 上传图片
     * @param apiUrl
     * @param filepath
     * @return
     */
    public static String doPostUpload(String apiUrl,String filepath){
    	
	   	 CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnection();
	     String httpStr = null;
	     HttpPost httpPost = new HttpPost(apiUrl);
	     CloseableHttpResponse response = null;
	     
	     try{
	    	 // 要上传的文件的路径
				String filePath = new String(filepath);

				// 把文件转换成流对象FileBody
				File file = new File(filePath);
				FileBody bin = new FileBody(file);
				/*StringBody uploadFileName = new StringBody("my.png",
						ContentType.create("text/plain", Consts.UTF_8));*/
				// 以浏览器兼容模式运行，防止文件名乱码。
				HttpEntity reqEntity = MultipartEntityBuilder.create()
						.setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
						.addPart("date", bin) // uploadFile对应服务端类的同名属性<File类型>
						//.addPart("uploadFileName", uploadFileName)// uploadFileName对应服务端类的同名属性<String类型>
						.setCharset(CharsetUtils.get("UTF-8")).build();

				httpPost.setEntity(reqEntity);

				System.out.println("发起请求的页面地址 " + httpPost.getRequestLine());
				// 发起请求 并返回请求的响应
				response = httpClient.execute(httpPost);
				
				// 打印响应状态
				System.out.println(response.getStatusLine());
				// 获取响应对象
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					// 打印响应长度
					System.out.println("Response content length: "
							+ resEntity.getContentLength());
					// 打印响应内容
					System.out.println(EntityUtils.toString(resEntity,
							Charset.forName("UTF-8")));
				}
	     }catch(Exception e){
	    	 e.printStackTrace();
	     } finally {
	            if (response != null) {
	                try {
	                    EntityUtils.consume(response.getEntity());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	     }
	     return httpStr; 
    }
    

    /**
     * 发送 SSL POST 请求（HTTPS），K-V形式
     * @param apiUrl API接口URL
     * @param params 参数map
     * @return
     */
    public static String doPostSSL(String apiUrl, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("utf-8")));
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
         
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
			e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }
    
    /**
     * 发送 SSL POST 请求（HTTPS），K-V形式 , header里面加值
     * @param apiUrl API接口URL
     * @param params 参数map
     * @return
     */
    public static String doPostSSL(String apiUrl, Map<String, Object> params,Map<String,String> headerMap) {
        CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
                pairList.add(pair);
            }            
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("utf-8")));
            
            // header中加值
            Iterator headerIterator = headerMap.entrySet().iterator();
            while(headerIterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) headerIterator.next();  
                httpPost.addHeader(elem.getKey(),elem.getValue());
            }
            
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode != HttpStatus.SC_OK) {
//                return null;
//            }
            HttpEntity entity = response.getEntity();
         
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
			e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }
    
    /**
     * 发送 SSL POST 请求（HTTPS），JSON形式
     * @param apiUrl API接口URL
     * @param json JSON对象
     * @return
     */
    public static String doPostSSL(String apiUrl, Object json,Map<String,String> headerMap) {
        CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
            StringEntity stringEntity = new StringEntity(json.toString(),"UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            
            // header中加值
            Iterator headerIterator = headerMap.entrySet().iterator();
            while(headerIterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) headerIterator.next();  
                httpPost.addHeader(elem.getKey(),elem.getValue());
            }
           
//            logger.info("HTTP请求参数"+JSON.toJSONString(httpPost));
//            logger.info("HTTP请求参数值：" + JSON.toJSONString(httpPost.getEntity()));
//            logger.info("HTTP请求参HEAD数值：" + JSON.toJSONString(httpPost.getAllHeaders()));
            response = httpClient.execute(httpPost);
//            logger.info("HTTP请求返回信息"+ JSON.toJSONString(response));
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity!=null) {
                httpStr = EntityUtils.toString(entity, "utf-8");
                logger.info("HTTP请求返回信息JSON"+httpStr);
            }
            return httpStr;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }
    
    
    
    /**
     * 发送 SSL POST 请求（HTTPS），JSON形式
     * @param apiUrl API接口URL
     * @param json JSON对象
     * @return
     */
    public static String doPostSSL(String apiUrl, Object json) {
        CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
            StringEntity stringEntity = new StringEntity(json.toString(),"UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 SSL POST 请求（HTTPS），字符串形式
     * @param apiUrl API接口URL
     * @param str    字符串类型
     * @return
     */
    public static String doPostSSL(String apiUrl, String str) {
        CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
            StringEntity stringEntity = new StringEntity(str,"UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }
    
    /**
     * 上传文件和文本信息
     * @param apiUrl		访问地址
     * @param filepath		文件地址
     * @param filename		文件别名
     * @param params		上传文本
     * @return
     */
    public static String doPostUploadSSL(String apiUrl,String filepath,String filename,Map<String, Object> params){
    	
	   	 CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
	     String httpStr = null;
	     HttpPost httpPost = new HttpPost(apiUrl);
	     CloseableHttpResponse response = null;
	     
	     try{
	    	 	// 要上传的文件的路径
				String filePath = new String(filepath);

				// 把文件转换成流对象FileBody
				File file = new File(filePath);
				FileBody bin = new FileBody(file);
				
				//上传参数配置
				MultipartEntityBuilder  builder = MultipartEntityBuilder.create();
				builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
				builder.setCharset(CharsetUtils.get("UTF-8"));
				builder.addPart(filename, bin);
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					builder.addPart(entry.getKey(),(ContentBody)new StringBody((String)entry.getValue(),CharsetUtils.get("UTF-8")));
					//builder.addPart(entry.getKey(), (ContentBody) new StringBody((String) entry.getValue(),ContentType.MULTIPART_FORM_DATA));
		        }
				
				HttpEntity entity = builder.build();
				httpPost.setEntity(entity);

				System.out.println("发起请求的页面地址 " + httpPost.getRequestLine());
				// 发起请求 并返回请求的响应
				response = httpClient.execute(httpPost);
				
//				// 打印响应状态
//				System.out.println(response.getStatusLine());
				// 获取响应对象
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
//					// 打印响应长度
//					System.out.println("Response content length: "
//							+ resEntity.getContentLength());
//					// 打印响应内容
//					System.out.println(EntityUtils.toString(resEntity,
//							Charset.forName("UTF-8")));
					httpStr=EntityUtils.toString(resEntity,Charset.forName("UTF-8"));
				}
				
				
	     }catch(Exception e){
	    	 e.printStackTrace();
	     } finally {
	            if (response != null) {
	                try {
	                    EntityUtils.consume(response.getEntity());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	     }
	     return httpStr; 
    }
    
    public static HttpEntity doPostDownload(String apiUrl,Map<String,Object> params){
        CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnection();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        HttpEntity entity =null;
        try {
            httpPost.setConfig(HttpConnectionManagerUtil.getRequestConfig());
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }
    
    public static HttpEntity doGetDownload(String url, Map<String, Object> params) {
        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
            if (i == 0)
                param.append("?");
            else
                param.append("&");
            param.append(key).append("=").append(URLEncoder.encode(params.get(key).toString()));
            i++;
        }
        apiUrl += param;
        String result = null;
        CloseableHttpClient httpclient = HttpConnectionManagerUtil.getConnection();
        try {
            HttpGet httpPost = new HttpGet(apiUrl);
            HttpResponse response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            System.out.println("执行状态码 : " + statusCode);

            HttpEntity entity = response.getEntity();
            return entity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
