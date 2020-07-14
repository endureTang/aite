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

package com.nj.enterprise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jd.core.util.Md5Util;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.core.base.util.AES;
import com.nj.core.base.util.AESUtil;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.RegExpUtil;
import com.nj.core.base.util.SHA;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.NjUserInfoMapper;
import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.enterprise.constant.WebConfig;
import com.nj.enterprise.shiro.CaptchaUsernamePasswordToken;
import com.nj.enterprise.utils.EnterpriseConfig;
import com.nj.model.datamodel.WebInitConfig;
import com.nj.model.generate.NjUserInfo;
import com.nj.service.base.system.LoginService;
import com.nj.service.enterprise.EnterpriseService;
import com.nj.service.enterprise.NjUserService;

/**
 * @FileName LoginController.java
 * @Description:
 *
 * @Date Apr 17, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */

@Controller
@RequestMapping(value = "/user")
public class LoginController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	@Resource(name ="njUserService")
	private NjUserService njUserService;
	
	@Resource(name="webConfig")
	private WebConfig webConfig;
	
	@Autowired
	private EnterpriseConfig enterpriseConfig;
	
	@Autowired
	NjUserInfoMapper userInfoMapper;
	
	/**
	 * 设置为默认公司
	 */
	@RequestMapping(value = "/deftCompany")
	@ResponseBody
	public PageData deftCompany(HttpSession httpSession) {
		ModelAndView mv = this.getModelAndView();
		PageData result = new PageData();
		try {
			PageData pd = this.getPageData();
			String userId = (String) httpSession.getAttribute(EntpriseConstant.SessionKey.USER_ID);
			
			httpSession.setAttribute(EntpriseConstant.SessionKey.COPORATE_ID, pd.getString("coporateId"));
//			httpSession.setAttribute(EntpriseConstant.SessionKey.COPORATE_NAME, coporateName);
			pd.put("userId", userId);
			//设置为默认公司
			njUserService.setDefaultCompany(pd);
			result.put("status", EntpriseConstant.RestData.SUCCESS);
			result.put("msg", "保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("status", EntpriseConstant.RestData.FAILURE);
			result.put("msg", "保存失败" + e.getMessage());
		}
	
		return result;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView loginView(HttpServletRequest request){
		ModelAndView mv = super.getModelAndView();
		//根据请求域名判断渲染不同登录界面风格
		WebInitConfig ndConfig = webConfig.getJdndConfig();
		String basePath = request.getServerName(); 
		if(basePath.equals(ndConfig.getUrl())) {
			request.setAttribute("logo", ndConfig.getLogo());
			request.setAttribute("title", ndConfig.getTitle());
			request.setAttribute("indexLogo", ndConfig.getIndexLogo());
			request.setAttribute("appName", ndConfig.getAppName());
			request.setAttribute("appPic", ndConfig.getAppPic());
		}else {
			WebInitConfig wdConfig = webConfig.getWdjrConfig();
			request.setAttribute("logo", wdConfig.getLogo());
			request.setAttribute("title", wdConfig.getTitle());
			request.setAttribute("indexLogo", wdConfig.getIndexLogo());
			request.setAttribute("appName", wdConfig.getAppName());
			request.setAttribute("appPic", wdConfig.getAppPic());
		}
		mv.setViewName("auth/login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public PageData userLogin(Page page, HttpSession httpSession,HttpServletResponse response) {
		
		
		PageData result = new PageData();
		PageData pd = this.getPageData();
		String keyData = pd.getString("keyData");
		keyData = keyData.replaceAll("ksbadmtn1f2izwqy", "");
		keyData = keyData.replaceAll("ipvb5cxat0zn9eg7", "");
		String keyDatas[] = keyData.split(",00,");
		Object object = EhCacheUtil.getInstance().get("passwordRetryCache", keyDatas[0]);
		Integer tryTime = object == null ? 1: (Integer)object;
		
		try {
			if (null != keyDatas && keyDatas.length == 3) {
				/*String loginName = keyDatas[0];
				String password = keyDatas[1];*/
				String password = keyDatas[1];
				
				/**密码长度验证*/
//				if(!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)){
//					result.put(EntpriseConstant.Datas.STATUS,1000);
//					result.put(EntpriseConstant.Datas.MSG, "密码必须为8到16位的数字字母组成");
//				} else {
					
					Subject subject = SecurityUtils.getSubject();  
					CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(keyDatas[0],SHA.getSHA256StrJava(keyDatas[1]),keyDatas[2]);
				    //UsernamePasswordToken token = new UsernamePasswordToken(loginName,SHA.getSHA256StrJava(password));
				    subject.login(token);
					/*NjUserInfo userInfo = loginService.checkUserLogin(loginName,password);
					httpSession.setAttribute(EntpriseConstant.SessionKey.USER_ID, userInfo.getId()); 
					httpSession.setAttribute(EntpriseConstant.SessionKey.TOKEN_NAME,userInfo.getUserMobile());*/
				    
				    // 登录成功将token写入cookie中保持长链接，目前配置的是24小时			    
				    NjUserInfo userInfo = userInfoMapper.selectByMobile(keyDatas[0]);
				    String loginToken = Md5Util.getMD5String(userInfo.getId()+UuidUtil.get32UUID());
				    userInfo.setToken(loginToken);
				    userInfoMapper.updateByPrimaryKeySelective(userInfo);
				    
				    // 写入cookie 中 ,数据进行加密存储
				    Map<String,Object> cookieMap = new HashMap<String,Object>();
				    cookieMap.put("login_token", loginToken);
				    cookieMap.put("login_time", System.currentTimeMillis());
				    cookieMap.put("mobile", userInfo.getUserMobile());
				    String cookieJson = JSON.toJSONString(cookieMap);
				    String cookieEncrypt = AES.Encrypt(cookieJson, enterpriseConfig.getTokenSecret());
					Cookie loginCookie = new Cookie("login_token",cookieEncrypt);
					loginCookie.setPath("/"); //cookie所在的目录，默认为/			
					response.addCookie(loginCookie);
				    
					result.put(EntpriseConstant.Datas.STATUS,0);
					result.put(EntpriseConstant.Datas.MSG, "OK");
//				}
				
			}else {
				result.put(EntpriseConstant.Datas.STATUS,1000);
				result.put(EntpriseConstant.Datas.MSG, "缺少参数");
			}
		}catch ( UnknownAccountException e ) {
			logger.error("登录出现错误：{}","用户未注册"+e.getMessage());
			result.put(EntpriseConstant.Datas.STATUS, 2000);
			result.put(EntpriseConstant.Datas.MSG, "用户未注册");
        } catch ( IncorrectCredentialsException e ) {
        	logger.error("登录出现错误：{}","密码错误"+e.getMessage());
			result.put(EntpriseConstant.Datas.STATUS, 2000);
			result.put(EntpriseConstant.Datas.MSG, "密码错误，剩余尝试次数："+(5-tryTime));
        } catch ( LockedAccountException e ) {
        	logger.error("登录出现错误：{}","该账户不可用"+e.getMessage());
			result.put(EntpriseConstant.Datas.STATUS, 2000);
			result.put(EntpriseConstant.Datas.MSG, "该账户不可用");
        } catch ( ExcessiveAttemptsException e ) {
        	logger.error("登录出现错误：{}","尝试次数超限"+e.getMessage());
			result.put(EntpriseConstant.Datas.STATUS, 2000);
			result.put(EntpriseConstant.Datas.MSG, "尝试次数超限，账户将被锁定十分钟。");
        } catch(ExpiredCredentialsException e) {
        	logger.error("登录出现错误：{}","验证码过期"+e.getMessage());
			result.put(EntpriseConstant.Datas.STATUS, 2000);
			result.put(EntpriseConstant.Datas.MSG, "验证码过期");
        } catch (DisabledAccountException e) {
        	logger.error("登录出现错误：{}",e.getMessage());
			result.put(EntpriseConstant.Datas.STATUS, 2000);
			result.put(EntpriseConstant.Datas.MSG, "登录出现错误:"+e.getMessage());
		} catch (Exception e) {
			logger.error("登录出现错误：{}",e.getMessage());
			result.put(EntpriseConstant.Datas.STATUS, 2000);
			result.put(EntpriseConstant.Datas.MSG, "登录出现错误，请联系管理员");
		}
		return result;
	}

	
}
