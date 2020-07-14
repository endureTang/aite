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

package com.nj.core.base.util.mail;

import java.net.MalformedURLException;
import java.net.URL;
/**   

 */
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.core.io.UrlResource;
import org.springframework.mail.SimpleMailMessage;  
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.nj.core.base.controller.BaseController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @FileName SimpleMailSender.java
 * @Description: 简单邮件（不带附件的邮件）发送器
 *
 * @Date Apr 19, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class SimpleMailSender extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(SimpleMailSender.class);
	/**
	 * 以文本格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件的信息
	 */
	public boolean sendTextMail(MailSenderInfo mailInfo) throws Exception {
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);


		// 根据session创建一个邮件消息
		Message mailMessage = new MimeMessage(sendMailSession);
		// 创建邮件发送者地址
		Address from = new InternetAddress(mailInfo.getFromAddress());
		Address[] tos = InternetAddress.parse(mailInfo.getToAddress());
		// 设置邮件消息的发送者
		mailMessage.setFrom(from);
		// 创建邮件的接收者地址，并设置到邮件消息中
/*		Address to = new InternetAddress(mailInfo.getToAddress());*/
		mailMessage.setRecipients(Message.RecipientType.TO, tos);
		// 设置邮件消息的主题
		mailMessage.setSubject(mailInfo.getSubject());
		// 设置邮件消息发送的时间
		mailMessage.setSentDate(new Date());
		// 设置邮件消息的主要内容
		String mailContent = mailInfo.getContent();
		mailMessage.setText(mailContent);
		// 发送邮件
		Transport.send(mailMessage);

		return true;
	}

	/**
	 * 以HTML格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件信息
	 */
	public boolean sendHtmlMail(MailSenderInfo mailInfo) throws Exception {
		System.setProperty("mail.mime.charset","UTF-8");
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.isValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);

		// 根据session创建一个邮件消息
		Message mailMessage = new MimeMessage(sendMailSession);
		// 创建邮件发送者地址
		Address from = new InternetAddress(mailInfo.getFromAddress());
		// 设置邮件消息的发送者
		mailMessage.setFrom(from);
		// 创建邮件的接收者地址，并设置到邮件消息中
		/*Address to = new InternetAddress(mailInfo.getToAddress());*/
		Address[] tos = InternetAddress.parse(mailInfo.getToAddress());
		try{
			if(mailInfo.getBccAddress()!= null && mailInfo.getBccAddress().length()>0){
				Address[] bccs = InternetAddress.parse(mailInfo.getBccAddress());
				if(bccs!= null && bccs.length>0){
					mailMessage.setRecipients(Message.RecipientType.BCC, bccs);
				}
			}
			if(mailInfo.getCcAddress() != null && mailInfo.getCcAddress().length()>0){
				Address[] ccs = InternetAddress.parse(mailInfo.getCcAddress());
				if(ccs!= null && ccs.length>0){
					mailMessage.setRecipients(Message.RecipientType.CC, ccs);
				}
			}
		}catch(Exception e){
			
		}
		// Message.RecipientType.TO属性表示接收者的类型为TO
		mailMessage.setRecipients(Message.RecipientType.TO, tos);
		
		// 设置邮件消息的主题
		mailMessage.setSubject(mailInfo.getSubject());
		// 设置邮件消息发送的时间
		mailMessage.setSentDate(new Date());
		// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
		Multipart mainPart = new MimeMultipart("related");
		// 创建一个包含HTML内容的MimeBodyPart
		  // first part  (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "";
        htmlText += mailInfo.getContent();
        htmlText += "<center><img src=\"cid:image\"></center>";
       /* String htmlText = "<H1>Hello</H1><img src=\""+ mailInfo.getLogUrl()+"\">";*/
        messageBodyPart.setContent(htmlText, "text/html;charset=UTF-8");
        // add it
        mainPart.addBodyPart(messageBodyPart);

        /*
        // second part (the image)
        messageBodyPart = new MimeBodyPart();
        URL url = new URL("http://cycon.cn/imgs/logo.jpg");
        URLDataSource fds = new URLDataSource(url);
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID","<image>");
        mainPart.addBodyPart(messageBodyPart); 
        */
        
        /*
         * attachement
         */
        for(String resource: mailInfo.getResources())
        {
        	if(resource != null && resource.length()>0){
        		System.out.println("===:"+resource);
        		MimeBodyPart attch = new MimeBodyPart();
        	
        		mainPart.addBodyPart(attch);
//	           	 DataSource ds1 = new FileDataSource("/tmp/uploadImgs/log.txt");
//        		DataSource ds1 = new FileDataSource(resource);
        		URL url = new URL(resource);
        		DataSource ds1 = new URLDataSource(url);
	           	DataHandler dataHandler1 = new DataHandler(ds1);
	           	attch.setDataHandler(dataHandler1);
	           	attch.setContentID(resource);
//	           	attch.setContent(mp);
	           	attch.setFileName(resource);
	           	
        	}
        	
        }
        
		// 将MiniMultipart对象设置为邮件内容
		mailMessage.setContent(mainPart);
		// 发送邮件
		Transport.send(mailMessage);
		return true;
	}

	/** *//** 
     * 发送带动态图象的HTML邮件，所谓动态图象就是在发送邮件时 
     * 动态地生成一个图片，然后再随HTML格式的邮件发送出去。 
     * @throws MessagingException  
	 * @throws MalformedURLException 
     * @throws IOException  
     * 
     */ 
    public void sendDynamicImageMail(JavaMailSender  mailsender,MailSenderInfo mailInfo) throws Exception{  
           
       /* JavaMailSenderImpl mailsender = new JavaMailSenderImpl();  */
        MimeMessage mimeMessage = mailsender.createMimeMessage();  
        mimeMessage.setHeader("Disposition-Notification-To", "1");
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "GB2312");  
           
        StringBuffer html = new StringBuffer();  
        html.append("<html>");  
        html.append("<head>");  
        html.append("<meta http-equiv='Content-Type' content='text/html; charset=gb2312'>");  
        html.append("</head>");  
        html.append("<body bgcolor='#ccccff'>");  
        html.append("<center>");  
        html.append("<h1>你好</h1>");  
        html.append("<img src='cid:png'>");//cid:png中的png就是下面的helper.addInline("png",image);中的png  
        html.append("</body>");  
        html.append("</html>");  
           
        //设定邮件的正文内容  
        helper.setText(html.toString(), true);  
           
        //new一个UrlResource对象，注意http://localhost:8080/springtiles/makechart.png看起来好像一个png格式的  
        //图片，其实makechart.png本质上是一个Servlet，在这个Servlet中用JFreeChart构造了一个3D的图象。  
        UrlResource image = new UrlResource(mailInfo.getLogUrl());  
           
        //把生成的image图象添加到邮件信息中  
        helper.addInline("png",image);  
           
        helper.setFrom(mailInfo.getFromAddress());  
      /*  helper.setTo(mailInfo.getToAddress()); */
    /*    helper.setTo(InternetAddress.parse(mailInfo.getToAddress()));*/
        helper.setBcc(InternetAddress.parse(mailInfo.getToAddress()));
        helper.setSubject("主题");  
           
        logger.info(mimeMessage.getContentID());  

           
           
        mailsender.send(mimeMessage);  
        logger.info("dynamic image mail has bean sent !");  
    }  
    
	/*
	 * @title:标题
	 * 
	 * @content:内容
	 * 
	 * @type:类型,1:文本格式;2:html格式
	 * 
	 * @tomail:接收的邮箱
	 */
	public boolean sendMail(String title, String content, String type, String tomail) throws Exception {

		// 这个类主要是设置邮件

		// TODO: 改到配置文件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.qq.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("nemoyn@163.com");
		mailInfo.setPassword("tttt");// 您的邮箱密码
		mailInfo.setFromAddress("nemoyn@163.com");
		mailInfo.setToAddress(tomail);
		mailInfo.setSubject(title);
		mailInfo.setContent(content);
		// 这个类主要来发送邮件

		SimpleMailSender sms = new SimpleMailSender();

		if ("1".equals(type)) {
			return sms.sendTextMail(mailInfo);// 发送文体格式
		} else if ("2".equals(type)) {
			return sms.sendHtmlMail(mailInfo);// 发送html格式
		}
		return false;
	}

	/**
	 * @param SMTP
	 *            邮件服务器
	 * @param PORT
	 *            端口
	 * @param EMAIL
	 *            本邮箱账号
	 * @param PAW
	 *            本邮箱密码
	 * @param toEMAIL
	 *            对方箱账号
	 * @param TITLE
	 *            标题
	 * @param CONTENT
	 *            内容
	 * @param TYPE
	 *            1：文本格式;2：HTML格式
	 */
	public static void sendEmail(String SMTP, String PORT, String EMAIL, String PAW, String toEMAIL, String TITLE, String CONTENT,
			String TYPE) throws Exception {

		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();

		mailInfo.setMailServerHost(SMTP);
		mailInfo.setMailServerPort(PORT);
		mailInfo.setValidate(true);
		mailInfo.setUserName(EMAIL);
		mailInfo.setPassword(PAW);
		mailInfo.setFromAddress(EMAIL);
		mailInfo.setToAddress(toEMAIL);
		mailInfo.setSubject(TITLE);
		mailInfo.setContent(CONTENT);
		// 这个类主要来发送邮件

		SimpleMailSender sms = new SimpleMailSender();

		if ("1".equals(TYPE)) {
			sms.sendTextMail(mailInfo);
		} else {
			sms.sendHtmlMail(mailInfo);
		}

	}

	public static void main(String[] args) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.qq.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("nemoyn@163.com");
		mailInfo.setPassword("tttt");// 您的邮箱密码
		mailInfo.setFromAddress("nemoyn@163.com");
		mailInfo.setToAddress("244131196@qq.com");
		mailInfo.setSubject("设置邮箱标题");
		mailInfo.setContent("设置邮箱内容");
		// 这个类主要来发送邮件

		// SimpleMailSender sms = new SimpleMailSender();
		// sms.sendTextMail(mailInfo);//发送文体格式
		// sms.sendHtmlMail(mailInfo);//发送html格式

	}

}
