/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.nj.core.base.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.RequestParam;


import com.nj.core.base.util.mail.MailSenderInfo;
import com.nj.core.base.util.mail.SimpleMailSender;

public class CYMailUtil {

	@Resource(name = "mailService")
	private static String mailHost = "smtp.exmail.qq.com";
//	private static String mailHost = "smtp.qq.com";
	private static String hostPort = "25";
	private static String uac = "cycon@cycon.cn";
	private static String upwd = "JqeK193MA";
	
	private MailSenderInfo getSender(String fromAddress,String toAddress, String subject, String content){
		
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(mailHost);
		mailInfo.setMailServerPort(hostPort);
		mailInfo.setValidate(true);
		mailInfo.setUserName(uac);
		mailInfo.setPassword(upwd);// 您的邮箱密码
		if( fromAddress != null &&  fromAddress.length()>0){
			mailInfo.setFromAddress(fromAddress);
		}else{
			mailInfo.setFromAddress(uac);
		}
		
		mailInfo.setToAddress(toAddress);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
//		mailInfo.setCcs(InternetAddress.parse(toAddress));
		
		return mailInfo;
	}
	
private MailSenderInfo getFullSender(String fromAddress,String toAddress,String ccAddress,String bccAddress,List<String> resources, String subject, String content){
		
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(mailHost);
		mailInfo.setMailServerPort(hostPort);
		mailInfo.setValidate(true);
		mailInfo.setUserName(uac);
		mailInfo.setPassword(upwd);// 您的邮箱密码
		if( fromAddress != null &&  fromAddress.length()>0){
			mailInfo.setFromAddress(fromAddress);
		}else{
			mailInfo.setFromAddress(uac);
		}
		
		mailInfo.setToAddress(toAddress);
		mailInfo.setCcAddress(ccAddress);
		mailInfo.setBccAddress(bccAddress);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
//		mailInfo.setCcs(InternetAddress.parse(toAddress));
		
		mailInfo.setResources(resources);
		return mailInfo;
	}
	public PageData sendMail(String fromAddress,String toAddress,String ccAddress, String bccAddress,List<String> resources, String subject, String content){
		PageData result = new PageData();
		PageData pd = new PageData();
			
		try {
			//发送邮件到管理员邮箱
			MailSenderInfo sender = this.getFullSender(fromAddress, toAddress,ccAddress, bccAddress,resources, subject, content);
				pd.put("content",content);
				pd.put("fromAdd",fromAddress);
				pd.put("tos",toAddress);
				String uuid = UuidUtil.get32UUID();
				pd.put("uuid", uuid);
				sender.setLogUrl(Const.WEB_HOST + "/mail/"+ uuid + "/logo.jpg");
				
				//第一次发送结果
				PageData sentResult = this.sentMail(sender);
				Address[] sent = (Address[])sentResult.get("sent");
				Address[] invalide = (Address[])sentResult.get("invalid");
				Address[] unsent = (Address[])sentResult.get("unsent");
				String sentStr="", invalideStr="",unsentStr="";
				if(invalide!=null && invalide.length >0){
					invalideStr = InternetAddress.toString(invalide);
				}
				if(unsent!=null && unsent.length>0){
					unsentStr = InternetAddress.toString(unsent);
				}
				if(sent!=null && sent.length>0){
					sentStr = InternetAddress.toString(sent);
				}
				if(sentResult.getInteger("status") == 1){
					pd.put("sendStatus", "发送成功");
				}else{
					pd.put("sendStatus", "发送失败");
				}
				pd.put("msg", "第一次发送， 无效地址：" + invalideStr  +" 未发送有效地址: " + unsentStr);

				
				if(unsent!=null && unsent.length >0){
					sender.setToAddress(InternetAddress.toString(unsent));
					sender.setCcs(unsent);
					//第2次发送结果
					PageData secondResult = this.sentMail(sender);
					Address[] sent2 = (Address[])secondResult.get("sent");
					Address[] invalide2 = (Address[])secondResult.get("invalid");
					Address[] unsent2 = (Address[])secondResult.get("unsent");
					String sentStr2="", invalideStr2="",unsentStr2="";
					if(invalide2!=null && invalide2.length >0){
						pd.put("sendStatus", "部分邮箱无效，未发送成功");
						invalideStr2 = InternetAddress.toString(invalide2);
					}else if(unsent2!=null && unsent2.length>0){
						pd.put("sendStatus", "发送失败");
						unsentStr2 = InternetAddress.toString(unsent2);
					}else{
						pd.put("sendStatus", "发送成功");
					}
					
					if(sent2!=null && sent2.length>0){
						sentStr2 = InternetAddress.toString(sent2);
					}
					if(secondResult.getInteger("status") == 1){
						pd.put("sendStatus", "发送成功");
					}else{
						pd.put("sendStatus", "发送失败");
					}
					
					pd.put("tos",InternetAddress.toString(unsent));
					pd.put("msg", "第二次发送结果，  无效地址：" + invalideStr2  +" 未发送有效地址: " + unsentStr2);
				
					pd.put("sendStatus", "发送成功");
				}
				
				result.put("status", 1);
				result.put("msg", "发送成功");
				
			//mail end
			
		} catch (Exception e) {
//			logger.error("list menu error", e);
			result = new PageData();
		}
		
		return result;
	}
	
	private PageData sentMail(MailSenderInfo mailInfo){
		PageData result = new PageData();
		//发送邮件到管理员邮箱
		try {
			
			SimpleMailSender sms = new SimpleMailSender();
			sms.sendHtmlMail(mailInfo);
			/*sms.sendDynamicImageMail(mailSender,mailInfo);*/
			result.put("status", 1);
		}catch(SendFailedException e){
			e.printStackTrace();
			result = new PageData();
			//获取未发送的地址
			Address[] unsent= e.getValidUnsentAddresses();
			//获取已经发送的地址
			Address[] sent = e.getValidSentAddresses();
			//获取已经无效的地址
			Address[] invalid = e.getInvalidAddresses();
			result.put("unsent", unsent);
			result.put("sent", sent);
			result.put("invalid", invalid);
			result.put("status", 0);
		}catch(MailSendException e){
			result.put("status", 0);
			e.printStackTrace();
		}catch(Exception e){
			result.put("status", 0);
			e.printStackTrace();
		}
		//mail end
		return result;
	}
}