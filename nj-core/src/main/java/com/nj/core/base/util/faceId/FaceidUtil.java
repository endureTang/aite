package com.nj.core.base.util.faceId;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nj.core.base.util.HttpConnectionManagerUtil;
import com.nj.core.base.util.HttpUtil;

/**
 * Faceid Util
 * faceid 可以识别身份证
 * @author MaSong
 *
 */
public class FaceidUtil {
	 
//	 /**用户名*/
//	 private static String apiKey="eapjK1vok5bL8gOj2wipM8sNumczkrgD";
//	 /**秘钥*/					
//	 private static String api_secret="NxEHSQPaduTBzZ21BHqhTPtFP2AOrsb4";	 
	 /**用户名-正式*/						   
	 private static String apiKey="IKPWnu0Htabt-0vEn-2qsP9jFJ3yzXZ9";
	 /**秘钥*/
	 private static String api_secret="O1geYTQL27yDiwg67nKlUxwhe1GRo7-i";
	 /**查询身份证信息*/
	 private static String ocridCardUrl="https://api.faceid.com/faceid/v1/ocridcard";
	 /**照片识别*/
	 private static String detectUrl="https://api.faceid.com/faceid/v1/detect";
	 /**人脸对比*/
	 private static String verifyUrl="https://api.megvii.com/faceid/v2/verify";
	 
	 private static Logger logger =LoggerFactory.getLogger(FaceidUtil.class);
	/**
	 * 查询身份证上面的信息
	 * 身份证的正反面都可以查询，返回相关的 JSON
	 * 正面:{"race": "汉", "name": "季锦锦", "time_used": 941, "gender": "女", "id_card_number": "330782198802084329", "request_id": "1477555710,6280032b-ef09-4584-bcc1-f7344ecedb05", "birthday": {"year": "1988", "day": "8", "month": "2"}, "legality": {"Edited": 0.0, "Photocopy": 0.0, "ID Photo": 1.0, "Screen": 0.0, "Temporary ID Photo": 0.0}, "address": "浙江省义乌市北苑街道黄杨梅村10组", "head_rect": {"rt": {"y": 0.24396135, "x": 0.88666666}, "lt": {"y": 0.24637681, "x": 0.6}, "lb": {"y": 0.7198068, "x": 0.5933333}, "rb": {"y": 0.7222222, "x": 0.87666667}}, "side": "front"}
	 * 反面：{"legality": {"Edited": 0.0, "Photocopy": 0.0, "ID Photo": 0.369, "Screen": 0.631, "Temporary ID Photo": 0.0}, "request_id": "1477555769,045074ce-5c65-4916-b062-1a0918e72952", "time_used": 862, "valid_date": "2006.07.26-2016.07.26", "issued_by": "聊城市公安局东昌府分局", "side": "back"}
	 * 失败：返回的是一个html页面
	 * @param filePath	图片地址
	 * @return
	 */
	public static String ocridCard(String filePath){
		 
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("api_key", apiKey);
		 map.put("api_secret", api_secret);
		 map.put("legality","1");
		 String msg= HttpUtil.doPostUploadSSL(ocridCardUrl, filePath,"image", map);
		 //System.out.println( msg);
		 return msg;
	 }	
	
	/**
	 * 查询身份证上面的信息
	 * 身份证的正反面都可以查询，返回相关的 JSON
	 * 正面:{"race": "汉", "name": "季锦锦", "time_used": 941, "gender": "女", "id_card_number": "330782198802084329", "request_id": "1477555710,6280032b-ef09-4584-bcc1-f7344ecedb05", "birthday": {"year": "1988", "day": "8", "month": "2"}, "legality": {"Edited": 0.0, "Photocopy": 0.0, "ID Photo": 1.0, "Screen": 0.0, "Temporary ID Photo": 0.0}, "address": "浙江省义乌市北苑街道黄杨梅村10组", "head_rect": {"rt": {"y": 0.24396135, "x": 0.88666666}, "lt": {"y": 0.24637681, "x": 0.6}, "lb": {"y": 0.7198068, "x": 0.5933333}, "rb": {"y": 0.7222222, "x": 0.87666667}}, "side": "front"}
	 * 反面：{"legality": {"Edited": 0.0, "Photocopy": 0.0, "ID Photo": 0.369, "Screen": 0.631, "Temporary ID Photo": 0.0}, "request_id": "1477555769,045074ce-5c65-4916-b062-1a0918e72952", "time_used": 862, "valid_date": "2006.07.26-2016.07.26", "issued_by": "聊城市公安局东昌府分局", "side": "back"}
	 * 失败：返回的是一个html页面
	 * @param filePath	图片地址
	 * @return
	 */
	public static String ocridCard(String fileName, byte[] body){
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("api_key", apiKey);
		 map.put("api_secret", api_secret);
		 map.put("legality","1");
		 
	   	 CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
	     String httpStr = null;
	     HttpPost httpPost = new HttpPost(ocridCardUrl);
	     CloseableHttpResponse response = null;
	     try{
				MultipartEntityBuilder  builder = MultipartEntityBuilder.create();
				builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
				builder.setCharset(CharsetUtils.get("UTF-8"));
				builder.addBinaryBody(fileName, body,ContentType.MULTIPART_FORM_DATA,"image");
				builder.setContentType(ContentType.MULTIPART_FORM_DATA);
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					builder.addTextBody(entry.getKey(), entry.getValue().toString());
		        }
				
				HttpEntity entity = builder.build();
				httpPost.setEntity(entity);
				// 发起请求 并返回请求的响应
				response = httpClient.execute(httpPost);
				HttpEntity resEntity = response.getEntity();				
				if(response.getStatusLine().getStatusCode() !=HttpStatus.SC_OK){
					logger.error("ocridCard fail ,the response code :"+Integer.toString(response.getStatusLine().getStatusCode()));
					//System.out.println(EntityUtils.toString(resEntity,Charset.forName("UTF-8")));
					return null;
				}
				// 获取响应对象
				if (resEntity != null) {
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
		
	/**
	 * 检测一张照片中的人脸,并返回相关信息
	 * 成功：{"time_used": 208, "request_id": "1477561698,cf9d319c-16da-4dc4-8e47-64d66cbee9a2", "faces": [{"token": "Pju1vCuNaMzRLUiXyulXMbPHU-gZmF9GmlzCbSe7qZ4=", "quality": 88.4980597836134, "quality_threshold": 30.1, "rect": {"width": 0.11717, "top": 0.13012, "height": 0.20723, "left": 0.05722}}, {"token": "Pju1vCuNaMzRLUiXyulXMRFA6qCiA4bpHUmrnU-_A04=", "quality": 1.2564092896299972, "quality_threshold": 30.1, "rect": {"width": 0.1049, "top": 0.19518, "height": 0.18554, "left": 0.83106}}, {"token": "Pju1vCuNaMzRLUiXyulXMWi25CXdaaWnPKt1NxR8c0s=", "quality": 82.35595085302202, "quality_threshold": 30.1, "rect": {"width": 0.1049, "top": 0.15904, "height": 0.18554, "left": 0.47003}}]}
	 * 没有查询出人脸{"time_used": 155, "request_id": "1477561850,d20cce65-d4dd-409f-a758-0e9b474377ad", "faces": []}
	 * @param filePath
	 * @return
	 */
	public static String detectPhoto(String filePath){
		 
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("api_key", apiKey);
		 map.put("api_secret", api_secret);
		 String msg= HttpUtil.doPostUploadSSL(detectUrl, filePath,"image", map);
		 //System.out.println(msg);
		 return msg;
	 }
	
	public static String detectPhoto(String fileName, byte[] body){
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("api_key", apiKey);
		 map.put("api_secret", api_secret);
		 map.put("multi_oriented_detection", "1");
	   	 CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
	     String httpStr = null;
	     HttpPost httpPost = new HttpPost(detectUrl);
	     CloseableHttpResponse response = null;
	     
	     try{
				MultipartEntityBuilder  builder = MultipartEntityBuilder.create();
				builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
				builder.setCharset(CharsetUtils.get("UTF-8"));
				builder.addBinaryBody(fileName, body,ContentType.MULTIPART_FORM_DATA,"image");
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					builder.addTextBody(entry.getKey(), entry.getValue().toString());
		        }
				
				HttpEntity entity = builder.build();
				httpPost.setEntity(entity);
				// 发起请求 并返回请求的响应
				response = httpClient.execute(httpPost);
				HttpEntity resEntity = response.getEntity();				
				if(response.getStatusLine().getStatusCode() !=HttpStatus.SC_OK){
					logger.error("ocridCard fail ,the response code :"+Integer.toString(response.getStatusLine().getStatusCode()));
					return null;
				}
				// 获取响应对象
				if (resEntity != null) {
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
	
	/**faceid检验
	 * @param paramStr:所有非image格式的参数
	 * @param paramFile：所有的image格式的参数，key 为name, value为image的 bin body
	 * @return faceid 返回数据
	 */
	public static String verify(Map<String,String> paramStr, Map<String,byte[]> paramFile){
		//添加api_key和api_secret
		 paramStr.put("api_key", apiKey);
		 paramStr.put("api_secret", api_secret);
	   	 CloseableHttpClient httpClient = HttpConnectionManagerUtil.getConnectionForSSL();
	     String httpStr = null;
	     HttpPost httpPost = new HttpPost(verifyUrl);
	     CloseableHttpResponse response = null;
	     
	     try{
				MultipartEntityBuilder  builder = MultipartEntityBuilder.create();
				builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
				builder.setCharset(CharsetUtils.get("UTF-8"));
				for(Map.Entry<String, byte[]>i:paramFile.entrySet()){
					builder.addBinaryBody(i.getKey(), i.getValue(),ContentType.MULTIPART_FORM_DATA,i.getKey());
				}
				for (Map.Entry<String, String> entry : paramStr.entrySet()) {
					builder.addTextBody(entry.getKey(), entry.getValue().toString(),ContentType.create("text/plain","utf-8"));
		        }
				
				HttpEntity entity = builder.build();
				httpPost.setEntity(entity);
				// 发起请求 并返回请求的响应
				response = httpClient.execute(httpPost);
				HttpEntity resEntity = response.getEntity();

				if(response.getStatusLine().getStatusCode() !=HttpStatus.SC_OK){
					logger.error("verify fail ,the response code :"+Integer.toString(response.getStatusLine().getStatusCode()));
					logger.error("response error:" +EntityUtils.toString(resEntity,Charset.forName("UTF-8")));
					return null;
				}
				if (resEntity != null) { //获取响应对象
					httpStr=EntityUtils.toString(resEntity,Charset.forName("UTF-8"));
				}				
	     }catch(Exception e){
	    	logger.error("detect error:",e);
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
	 * 人脸对比, Meglive方式采集的数据
	 * @param requestMap		  请求的参数
	 * @param requestFileMap	  请求上传文件的参数	
	 * @return
	 */
	public static String verifyMeglive(Map<String,Object> requestMap,Map<String,String> requestFileMap){
		
		requestMap.put("api_key", apiKey);
		requestMap.put("api_secret", api_secret);
		String imageBestPath=requestFileMap.get("image_best");
		String msg= HttpUtil.doPostUploadSSL(verifyUrl, imageBestPath,"image_best", requestMap);
		return msg;		
	}
	
	/**
	 * 人脸对比，采用Detect方式采集的数据，并使用faceToken进行对比
	 * @param requestMap	请求的参数
	 * @return
	 */
	public static String verifyDetect(Map<String,Object> requestMap){
		 requestMap.put("api_key", apiKey);
		 requestMap.put("api_secret", api_secret);
		 String msg= HttpUtil.doPostSSL(verifyUrl, requestMap);
		 return msg;
	}
	 
	 public static void main(String []args ){
	
	 }
	

}
