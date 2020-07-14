package com.nj.service.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.nj.bean.SmsCodeBean;
import com.nj.core.base.util.DateTimeHelper;

@Service("smsService2")
public class SmsService2 {
	
	private static Logger logger = LoggerFactory.getLogger(SmsService2.class);
	
	private static ConcurrentMap<String, SmsCodeBean> smsCodeMap = new ConcurrentHashMap<String, SmsCodeBean>();
	
	private static CCPRestSmsSDK smsAPI = new CCPRestSmsSDK();
	
	/**云通讯Account_sid*/
	private static final String CLOOPEN_ACOUNT_SID="8a216da858ce0b3c0158f0cc113e1490";
	
	/**云通讯Auth_token*/
	private static final String CLOOPEN_AUTH_TOKEN="9a4d3f430e4d45519b8b87208fe7d324";
	
	/** 应用APPID*/
	private static final String APPID="8a216da85af3df49015afa2d96990508";
	
	public static final String randomSet = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static final Integer EXPIRE_TIME = 2; //单位为分钟
	
	public static Boolean RUNNING =true;
	
	private static Thread cleanThread=new SmsService2.CleanMapThread();

	/**
	 * @param type:短信模板
	 * @param phone：短信接收号码
	 * @return:返回序列号
	 */
	public String sendSms(String type, String phone){
		//创建短信序列号
		String sequence= RandomStringUtils.random(12, randomSet);
		while(smsCodeMap.containsKey(sequence)){
			sequence = RandomStringUtils.random(12, randomSet);
		}
		SmsCodeBean sms = new SmsCodeBean(RandomStringUtils.random(6, "0123456789")
				,DateTimeHelper.addSeconds(new Date(), 2*60));
		
		HashMap<String, Object> result = smsAPI.sendTemplateSMS(phone,type 
				,new String[]{sms.getSmsCode(),EXPIRE_TIME.toString()});
		logger.info("send sms to phone="+phone+" type="+type+" result="+result.toString());
		if("000000".equals(result.get("statusCode"))){
			smsCodeMap.put(sequence, sms);
			return sequence;
		}
		else{
			return null;
		}
	}
		
	/**
	 * @param type:短信模板
	 * @param phone:手机号
	 * @param expire_time;失效时间，分钟为单位
	 * @return
	 */
	public String sendSms(String type, String phone, Integer expireTime){
		//创建短信序列号
		String sequence= RandomStringUtils.random(12, randomSet);
		while(smsCodeMap.containsKey(sequence)){
			sequence = RandomStringUtils.random(12, randomSet);
		}
		SmsCodeBean sms = new SmsCodeBean(RandomStringUtils.random(6, "0123456789")
				,DateTimeHelper.addSeconds(new Date(), 2*60));
		
		HashMap<String, Object> result = smsAPI.sendTemplateSMS(phone,type 
				,new String[]{sms.getSmsCode(),expireTime.toString()});
		logger.info("send sms to phone="+phone+" type="+type+" result="+result.toString());
		if("000000".equals(result.get("statusCode"))){
			smsCodeMap.put(sequence, sms);
			System.out.println("smsCodeMap=="+smsCodeMap);
			return sequence;
		}
		else{
			return null;
		}
	}
	
	public boolean validate(String sequence, String smsCode){
		System.out.println("smsCodeMap=="+smsCodeMap);
		SmsCodeBean bean = smsCodeMap.get(sequence);
		if(bean ==null){
			logger.debug("没有找到序列号对应的短信验证码");
			return false;
		}
		if(!bean.getSmsCode().equals(smsCode)){
			logger.debug("短信验证错误");
			return false;
		}
		//sms的校验时间在当前时间之前，表示校验过期
		if(DateTimeHelper.compareTwoDate(bean.getExpireTime(), new Date())==1){
			smsCodeMap.remove(sequence);
			return false;
		}
		smsCodeMap.remove(sequence);
		return true;		
	}
	
	@PostConstruct
	public void init(){
		smsAPI.init("app.cloopen.com", "8883");
		smsAPI.setAccount(CLOOPEN_ACOUNT_SID,CLOOPEN_AUTH_TOKEN);
		smsAPI.setAppId(APPID);
		cleanThread.start();
	}	
	
	public static class CleanMapThread extends Thread{

		@Override
		public void run() {
			while (RUNNING) {
				try{
					Thread.currentThread().sleep(1*60*60*1000);//每小时执行一次
				}catch(Exception e){
					logger.info("系统错误",e);
				}
				if (smsCodeMap != null) {
					Iterator<Entry<String, SmsCodeBean>> it = smsCodeMap.entrySet().iterator();
					while (it.hasNext()) {
						Entry<String, SmsCodeBean> i = it.next();
						if (i.getValue() != null
								&& (DateTimeHelper.compareTwoDate(i.getValue().getExpireTime(), new Date()) == 1)) {
							it.remove();
						}
					}
				}
			}
		}
		
	}
	
	
	/**
	 * @param type:短信模板
	 * @param phone：短信接收号码
	 * @return:返回验证码
	 */
	public String sendSMS(String type, String phone){
		//创建短信序列号
		SmsCodeBean sms = new SmsCodeBean(RandomStringUtils.random(6, "0123456789")
				,DateTimeHelper.addSeconds(new Date(), 2*60));
		
		HashMap<String, Object> result = smsAPI.sendTemplateSMS(phone,type 
				,new String[]{sms.getSmsCode(),EXPIRE_TIME.toString()});
		logger.info("send sms to phone="+phone+" type="+type+" result="+result.toString());
		if("000000".equals(result.get("statusCode"))){
			return sms.getSmsCode();
		}
		else{
			return null;
		}
	}
}
