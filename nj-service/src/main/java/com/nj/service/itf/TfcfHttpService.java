package com.nj.service.itf;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.common.AddressConstants;
import com.nj.core.base.common.Constants;
import com.nj.core.base.util.AESUtil;
import com.nj.core.base.util.HttpUtil;

@Service("tfcfHttpService")
public class TfcfHttpService {
	
	
	private static Logger logger = LoggerFactory.getLogger(TfcfHttpService.class);
	//tokenName和tokenId都在data里，现在没有token
	public String doHttpPostForTfcf(String tokenName, String tokenId,Map<String, Object> data, String srcUri) throws Exception{
		//根据配置类来生成测试环境或正式环境
		Map<String,Object> params = new HashMap<String,Object>();
		
		data.put("tokenId", tokenId);
		data.put("tokenName",tokenName);
		//String url= Constants.TFCF.createUrl(srcUri);
		String url=AddressConstants.JdcfUrl+srcUri;
		String AESKey = AddressConstants.JdcfAesKey;
		String json = JSONObject.toJSONString(data);
		params.put("data", AESUtil.EncryptTFCF(json, AESKey));

		logger.info("request tfcf start:"+url+":"+ json);
		
 		String response = HttpUtil.doPost(url, params);
		
		logger.info("request tfcf end:"+url+":"+ response);
		if(response==null) {
			logger.info("金鼎财富接口{},超时",url);
			logger.info("参数:{}",json);
		}
		return response;
	}
	
	
	public String doHttpPostForTfcf(Map<String, Object> data, String srcUri) throws Exception {
		
		Map<String,Object> params = new HashMap<String,Object>();
		String url=AddressConstants.JdcfUrl+srcUri;
		String AESKey = AddressConstants.JdcfAesKey;
		String json = JSONObject.toJSONString(data);
		params.put("data", AESUtil.EncryptTFCF(json, AESKey));
		
		logger.info("request tfcf start:"+url+":"+ json);
 		String response = HttpUtil.doPost(url, params);
		logger.info("request tfcf end:"+url+":"+ response);
		if(response==null) {
			logger.info("金鼎财富接口{},超时",url);
			logger.info("参数:{}",json);
		}
		return response;
	}
	
	public String doHttpPostForTfcfReport(Map<String, Object> data, String srcUri) throws Exception {
		
		Map<String,Object> params = new HashMap<String,Object>();
		String url=AddressConstants.JdcfReportUrl+srcUri;
 		String response = HttpUtil.doPost(url, data);
		logger.info("request tfcf end:"+url+":"+ response);
		if(response==null) {
			logger.info("金鼎财富接口{},超时",url);
		}
		return response;
	}
	
	public HttpEntity doHttpPostFileForTfcf(String tokenName, String tokenId,Map<String, Object> data, String srcUri)throws Exception{
		Map<String,Object> params = new HashMap<String,Object>();
		
		data.put("tokenId", tokenId);
		data.put("tokenName",tokenName);
		String url= Constants.TFCF.createUrl(srcUri);
		String AESKey = AddressConstants.JdcfAesKey;
//		String url= Constants.TFCF.createUrl(srcUri);
//		String AESKey = Constants.TFCF.getAESKey();
		String json = JSONObject.toJSONString(data);
		params.put("data",  AESUtil.EncryptTFCF(json, AESKey));
		
		logger.debug("request tfcf start:"+url+":"+ json);
		
		HttpEntity entity =HttpUtil.doPostDownload(url,params);
		
		logger.debug("request tfcf end:"+entity);
		return entity;
	}
	
	public static void main(String []args) throws Exception{
		
		TfcfHttpService ser = new TfcfHttpService();
		String url ="http://127.0.0.1:8080/p2pfront/i/userOperate/userCompanyMessage";
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("userName", "datatest11");
		
		String AESKey = "e080de81bcef11e6";
		String json = JSONObject.toJSONString(data);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("data", AESUtil.EncryptTFCF(json, AESKey));
		

 		String response = HttpUtil.doPost(url, params);
		
		System.out.println(response);
	}
}
