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

package com.nj.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.model.generate.SysResource;
import com.nj.model.generate.SysUser;
import com.nj.service.base.system.LoginService;
import com.nj.service.base.system.UserService;
import com.nj.core.base.util.AppUtil;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.RegExpUtil;
import com.nj.core.base.util.Tools;

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
public class LoginController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "loginService")
	private LoginService loginService;

	/**
	 * 获取登录用户的IP
	 * 
	 * @throws Exception
	 */
	public void getRemoteIP(String loginName) throws Exception {
		PageData pd = new PageData();
		HttpServletRequest request = this.getRequest();
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		pd.put("loginName", loginName);
		pd.put("ip", ip);
		userService.saveIP(pd);
	}

	/**
	 * 访问登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login_toLogin")
	public ModelAndView toLogin() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("sysname", Tools.readTxtFile(Const.SYSNAME)); // 读取系统名称
		
		String password = new SimpleHash("SHA-1", "MD5", "123456").toString();
		
		mv.setViewName("sys/admin/login");
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 请求登录，验证用户
	 */
	@RequestMapping(value = "/login_login")
	@ResponseBody
	public Object login() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		PageData pd = this.getPageData();
		String errInfo = "";
		String keyData = pd.getString("keyData");
		keyData = keyData.replaceAll("ksbadmtn1f2izwqy", "");
		keyData = keyData.replaceAll("ipvb5cxat0zn9eg7", "");
		String keyDatas[] = keyData.split(",00,");

		if (null != keyDatas && keyDatas.length == 3) {
			// shiro管理的session
			Subject currentUser = SecurityUtils.getSubject();
			Session session = currentUser.getSession();
			String sessionCode = (String) session.getAttribute(Const.SESSION_SECURITY_CODE); // 获取session中的验证码

			String code = keyDatas[2];
			boolean useValiCode = true;// 关闭验证码
			if (useValiCode && (null == code || "".equals(code))) {
				errInfo = "nullcode"; // 验证码为空
			} else {
				String loginName = keyDatas[0];
				String password = keyDatas[1];
				pd.put("loginName", loginName);
				if (!useValiCode || (Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code))) {
//					String passwd = new SimpleHash("SHA-1", loginName, password).toString(); // 密码加密
					String passwd = new SimpleHash("SHA-1", "MD5", password).toString();
					pd.put("password", passwd);
					pd = userService.getUserByNameAndPwd(pd);// TODO
																// 用于验证用户名和密码，改方法名需要改良
					if (pd != null) {
						pd.put("lastLogin", DateUtil.getTime().toString());
						userService.updateLastLogin(pd);
						SysUser user = new SysUser();// TODO
												// 改成直接从mybatis中返回的user,不需要下面逐行注入
						user.setId(pd.getString("userId"));
						user.setLoginName(pd.getString("loginName"));
						user.setPassword(pd.getString("password"));
						user.setName(pd.getString("name"));
//						user.setLastLogin(pd.getString("lastLogin"));
//						user.setIp(pd.getString("ip"));
//						user.setStatus(pd.getInteger("status"));
						session.setAttribute(Const.SESSION_USER, user);// TODO ?
						session.removeAttribute(Const.SESSION_SECURITY_CODE); // TODO
																				// ?

						// shiro加入身份验证
						Subject subject = SecurityUtils.getSubject();
						UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
						try {
							subject.login(token);
						} catch (AuthenticationException e) {
							errInfo = "身份验证失败！";
						}

					} else {
						errInfo = "usererror"; // 用户名或密码有误
					}
				} else {
					errInfo = "codeerror"; // 验证码输入有误
				}
				if (Tools.isEmpty(errInfo)) {
					errInfo = "success"; // 验证成功
				}
			}
		} else {
			errInfo = "error"; // 缺少参数
		}
		map.put("result", errInfo);
		Object obj = AppUtil.returnObject(new PageData(), map);
		return obj;
	}
	/**
	 * 访问系统首页
	 */
	@RequestMapping(value = "/sys/index")
	public ModelAndView login_index(Page page) {
		ModelAndView mv = this.getModelAndView();

		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("changeMenu", "yes");// 加载所有菜单
		try {

			// shiro管理的session
			Subject currentUser = SecurityUtils.getSubject();
			Session session = currentUser.getSession();

			SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
			if (user != null) {

				initRights(user, session);

				session.setAttribute(Const.SESSION_USERNAME, user.getLoginName()); // 放入用户名

//				List<Button> allButtonList = new ArrayList<Button>();

				mv.setViewName("sys/admin/index");
				mv.addObject("user", user);
				mv.addObject("menuList", session.getAttribute(Const.SESSION_ALLMENULIST));
//				mv.addObject("buttonList", allButtonList);
			} else {
				mv.setViewName("sys/admin/login");// session失效后跳转登录页面
			}

		} catch (Exception e) {
			mv.setViewName("sys/admin/login");
			logger.error(e.getMessage(), e);
		}
		pd.put("sysname", Tools.readTxtFile(Const.SYSNAME)); // 读取系统名称
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 进入tab标签
	 * 
	 * @return
	 */
	@RequestMapping(value = "/tab")
	public String tab() {
		return "system/admin/tab";
	}

	private void initRights(SysUser sysUser, Session session) {

		try {

			// 当前用户下的所有menu
			// List<Menu> menuList=new ArrayList<>();
			// 当前用户下的所有button
//			List<Button> buttonList = new ArrayList<Button>();

			List<String> allRightsUrls = new ArrayList<String>();

			List<String> roles = loginService.getRightsRolesId(sysUser.getId());
			session.setAttribute(Const.SESSION_ROLES_NAME, roles);
			// info.addRoles(roles);// TODO change to roleCode

			List<SysResource> menuList = new ArrayList<>();
			
			// 添加菜单权限信息（含分类菜单）
			List<SysResource> menus = loginService.getRightsParentMenus(sysUser.getId());
			// menuList.addAll(menus);
			for (SysResource menu : menus) {
				
				if("0".equals(menu.getParentId())){//一级菜单
					menuList.add(menu);
					allRightsUrls.add(menu.getHref());
					
					for (SysResource sysResource : menus) {
						if(menus != sysResource && sysResource.getParentId().equals(menu.getId())){
							menu.getSubList().add(sysResource);
							allRightsUrls.add(sysResource.getHref());
						}
					}
				}

//				Map<String, String> params = new HashMap<String, String>();
//				params.put("userId", sysUser.getUserId());
//				params.put("menuId", menu.getId()+"");
//
////				List<SysResource> subMenus = loginService.getRightsSubMenus(params);
////				menu.setSubMenu(subMenus);
//
//				for (SysResource subMenu : subMenus) {
//					allRightsUrls.add(subMenu.getHref());
//				}
			}

			// 添加按钮权限信息
//			List<Button> buttons = loginService.getRightsButtons(sysUser.getUserId());
//			buttonList.addAll(buttons);
//			for (Button button : buttons) {
//				allRightsUrls.add(button.getButtonUrl());
//			}

			// shiro用到权限列表
			session.setAttribute(Const.SESSION_ALL_RIGHTS_URL, allRightsUrls);

			// 菜单和按钮数据，用于登陆成功后生成菜单树
			session.setAttribute(Const.SESSION_ALLMENULIST, menuList);
			session.setAttribute(Const.SESSION_ALLBUTTONLIST, null);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * 进入首页后的默认页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login_default")
	public String defaultPage() {
		return "system/admin/default";
	}

	/**
	 * 用户注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();

		// shiro销毁登录，logout的时候shiro会删掉所有session
		Subject subject = SecurityUtils.getSubject();
		
		subject.logout();

		pd = this.getPageData();
		String msg = pd.getString("msg");
		pd.put("msg", msg);

		pd.put("sysname", Tools.readTxtFile(Const.SYSNAME)); // 读取系统名称
		mv.setViewName("sys/admin/login");
		mv.addObject("pd", pd);
		return mv;
	}

	/*
	 * app 登录
	 */
	
	@RequestMapping(value = "/auth",method=RequestMethod.POST)
	@ResponseBody
	public Object auth() throws Exception {	
		Map<String, String> map = new HashMap<String, String>();
		PageData pd = this.getPageData();
		String errInfo = "";
		String keyData = pd.getString("keyData");
		keyData = keyData.replaceAll("ksbadmtn1f2izwqy", "");
		keyData = keyData.replaceAll("ipvb5cxat0zn9eg7", "");
		String keyDatas[] = keyData.split(",00,");

		if (null != keyDatas && keyDatas.length == 3) {
			// shiro管理的session
			Subject currentUser = SecurityUtils.getSubject();
			Session session = currentUser.getSession();
			String sessionCode = (String) session.getAttribute(Const.SESSION_SECURITY_CODE); // 获取session中的验证码

			String code = keyDatas[2];
			boolean useValiCode = true;// 关闭验证码
			if (useValiCode && (null == code || "".equals(code))) {
				errInfo = "nullcode"; // 验证码为空
			} else {
				String loginName = keyDatas[0];
				String password = keyDatas[1];
//				if(!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)){
//					errInfo = "passworderror" ;
//				}  else {
					
					pd.put("loginName", loginName);
					if (!useValiCode || (Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code))) {
//						String passwd = new SimpleHash("SHA-1", loginName, password).toString(); // 密码加密
//						System.out.println("old:" +password);
//						String tmp = new String(StringUtils.decodeByte(password));
//						password = tmp;
						logger.error("new:" +password);
						String passwd = new SimpleHash("SHA-1", "MD5", password).toString();
						pd.put("password", passwd);
						logger.error("ecrpt:" +passwd);
						PageData ret;
						try{
						pd = userService.getUserByNameAndPwd(pd);// 
						if (pd != null) {
							userService.updateLastLogin(pd);
							SysUser user = new SysUser();
							user.setId(pd.getString("id"));
							user.setLoginName(loginName);
							user.setPassword(pd.getString("password"));
							user.setName(pd.getString("name"));
//							user.setInchargeId(pd.getInteger(""));
//							user.setInchargeName("");
//							user.setLastLogin(pd.getString("lastLogin"));
//							user.setIp(pd.getString("ip"));
//							user.setStatus(pd.getInteger("status"));
							session.setAttribute(Const.SESSION_USER, user);// TODO ?
							session.removeAttribute(Const.SESSION_SECURITY_CODE); // TODO
							map.put("sessionId", session.getId().toString());
							map.put("userId", pd.getInteger("userId")+"");
							String name = pd.getString("name");
							map.put("userName", name);
							
							List<String> roles = loginService.getRightsRolesId(user.getId());
							session.setAttribute(Const.SESSION_ROLES_NAME, roles);
							StringBuilder sb = new StringBuilder();
							for(String role: roles){
								sb.append(role);
								sb.append(";");
							}
							map.put("roleIds", sb.toString());
							session.setAttribute("RoleIds", sb.toString());
							
							// 
							// shiro加入身份验证
							Subject subject = SecurityUtils.getSubject();
							UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
//							token.setRememberMe(true);
							
							try {
								subject.login(token);
								map.put("shiroSessionId",subject.getSession().getId().toString());
							} catch (AuthenticationException e) {
								errInfo = "身份验证失败！";
							}

						} else {
							errInfo = "用户名或密码错误"; // 用户名或密码有误
						}
						}catch(Exception e){
//							map.put(key, value)
							e.printStackTrace();
							errInfo = e.getMessage(); // 缺少参数
						}
					} else {
						errInfo = "codeerror"; // 验证码输入有误
					}
					if (Tools.isEmpty(errInfo)) {
						errInfo = "success"; // 验证成功
					}
				}
				
				
//			}
		} else {
			errInfo = "缺少参数"; // 缺少参数
		}
		map.put("result", errInfo);

		Object obj = AppUtil.returnObject(new PageData(), map);
		return obj;
	}
	
	/**
	 * app注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/app/logout")
	public void appLogout() {
	
		// shiro销毁登录，logout的时候shiro会删掉所有session
		Subject subject = SecurityUtils.getSubject();
		subject.logout();

	}

}
