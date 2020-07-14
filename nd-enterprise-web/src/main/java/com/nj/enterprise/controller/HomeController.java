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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jdjf.util.account.AccountCenterUtil;
import com.jdjf.util.http.HttpUtil;
import com.jdjf.util.sign.Base64Util;
import com.jdjf.util.sign.SignCommonUtil;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.core.base.util.Const;
import com.nj.core.base.common.Constants;

import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UserSessions;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.enterprise.constant.WebConfig;
import com.nj.enterprise.utils.Util;
import com.nj.model.datamodel.WebInitConfig;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysResource;
import com.nj.model.generate.SysRole;
import com.nj.service.base.system.LoginService;
import com.nj.service.enterprise.EnterpriseService;
import com.nj.service.enterprise.NjCoporateUserService;
import com.nj.service.enterprise.NjUserService;
import com.nj.service.itf.TfcfHttpService;

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
public class HomeController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	@Resource(name ="njUserService")
	private NjUserService njUserService;

	@Resource(name="tfcfHttpService")
	private TfcfHttpService tfcfHttpService;

	@Resource(name ="njCoporateUserService")
	private NjCoporateUserService njCoporateUserService;
	
	@Resource(name="webConfig")
	private WebConfig webConfig;
	
/*	@Resource(name ="cachesService")
	private CachesService cachesService;*/
	
	@RequestMapping("/")
    public String index() {
        return "forward:/index.jsp";
    }

	/*
	 * 主页
	 */
	@RequestMapping(value = "/home")
	public ModelAndView homeIndex(Page page,HttpServletRequest request,HttpSession httpSession) {
		ModelAndView mv = this.getModelAndView();

		try {
			PageData pd = this.getPageData();
			//从session中取出用户信息
			String phoneNum = (String) httpSession.getAttribute(EntpriseConstant.SessionKey.TOKEN_NAME);  
			//logger.info("userId:{},user name:{}",Util.getCurrentUserId(),Util.getCurrentUser().getUserName());
			//判断用户是否在能借里面注册过
			if(StringUtils.isNotEmptyAndNull(phoneNum)){
				
				PageData input = new PageData();
				input.put("userMobile", phoneNum);
				
				//根据手机号获取用户信息
				NjUserInfo user = Util.getCurrentUser();
				/*NjUserInfo user = njUserService.getNjUserInfo(input);
				if(user == null){
					mv.setViewName(EntpriseConstant.Pages.CREATE_ACCOUNT);
					return mv;
				}
				
				httpSession.setAttribute(EntpriseConstant.SessionKey.USER, user);
				//超级管理员可以创建公司
				boolean isSysAdmin = njUserService.isSysAdminUser(user.getId());
				httpSession.setAttribute(EntpriseConstant.SessionKey.USER_SYS_ADMIN, isSysAdmin);//系统超级管理员
*/				
				String i_coporateId = pd.getString("coporateId");
				/*if(StringUtils.isNotEmpty(i_coporateId)){//选择公司进入
					//加载用户权限
					boolean isCoporateAdmin = njUserService.isAdminUser(i_coporateId, user.getId());
					httpSession.setAttribute(EntpriseConstant.SessionKey.IS_COPORATE_ADMIN, isCoporateAdmin);	//企业管理员
					
					boolean isBusinessExecutive = njUserService.isBusinessExecutive(i_coporateId, user.getId());
					httpSession.setAttribute(EntpriseConstant.SessionKey.IS_BUSINESS_EXECUTIVE, isBusinessExecutive);	//业务主管
				}*/
				
				
				//挂靠公司信息
				PageData res = njUserService.getJoinedCompany(input);
				
				//判断用户是否存在
				int size = res.getInteger("count");
				//至少存在一个公司
				if(size >= 1){
					//结果按是否默认降序排列
					List<?> records = (ArrayList<?>) res.get(EntpriseConstant.Datas.RESULT);
					Map<?, ?> selectedRecord = null;
					//根据选择的公司过滤
					for(Object ele : records){
						Map<?, ?> record = (Map<?, ?>) ele;
						String coporateId = (String) record.get("coporateId");
						if(coporateId.equals(i_coporateId)){
							selectedRecord = record;
							break;
						}
						
					}

					if(selectedRecord != null || 1 == size){ //选择了公司或者挂靠公司只有一个
						
						if(1 == size){	//只有一个挂靠公司时，默认直接进入
							selectedRecord = (Map<?, ?>) records.get(0);
						}
						
						String id = (String) selectedRecord.get("userId");
						httpSession.setAttribute(EntpriseConstant.SessionKey.USER_ID, id);
						String coporateId = (String) selectedRecord.get("coporateId");
						String coporateName = (String) selectedRecord.get("companName");
						String userName = String.valueOf(selectedRecord.get("userName"));
						httpSession.setAttribute("userName", userName);
						httpSession.setAttribute(EntpriseConstant.SessionKey.COPORATE_ID, coporateId);
						logger.debug("coporateId: " + coporateId);
						httpSession.setAttribute(EntpriseConstant.SessionKey.COPORATE_NAME, coporateName);
						
						httpSession.setAttribute(EntpriseConstant.SessionKey.USER_COPORATE, selectedRecord);
						
						//加载用户权限
						boolean isAdmin = njUserService.isAdminUser(coporateId, user.getId());
						httpSession.setAttribute(EntpriseConstant.SessionKey.IS_COPORATE_ADMIN, isAdmin);//公司管理员
						
						boolean isBusinessExecutive = njUserService.isBusinessExecutive(selectedRecord.get("coporateId").toString(), user.getId());
						httpSession.setAttribute(EntpriseConstant.SessionKey.IS_BUSINESS_EXECUTIVE, isBusinessExecutive);	//业务主管
						
						//进入主页
						initRights(httpSession);
						
						//根据请求域名判断渲染不同登录界面风格
						WebInitConfig ndConfig = webConfig.getJdndConfig();
						String basePath = request.getServerName(); 
						if(basePath.equals(ndConfig.getUrl())) {
							request.setAttribute("indexLogo", ndConfig.getIndexLogo());
							request.setAttribute("welcome", ndConfig.getWelcome());
							request.setAttribute("title", ndConfig.getTitle());
						}else {
							WebInitConfig wdConfig = webConfig.getWdjrConfig();
							request.setAttribute("indexLogo", wdConfig.getIndexLogo());
							request.setAttribute("welcome", wdConfig.getWelcome());
							request.setAttribute("title", wdConfig.getTitle());
						}
						mv.setViewName(EntpriseConstant.Pages.HOME_PAGE);
					}else{
						//未选择公司
						Map<?, ?> record = (Map<?, ?>)records.get(0);
						String userName = String.valueOf(record.get("userName"));
						httpSession.setAttribute("userName", userName);
						mv.addObject("companys", records);
						mv.setViewName(EntpriseConstant.Pages.CHOICE_COMPANY);
					}
					httpSession.removeAttribute("companys");
					httpSession.setAttribute("companys", records);
										
				}else{
					if(user != null){
						mv.addObject("user", user);
						String userName = String.valueOf(user.getUserName());
						httpSession.setAttribute("userName", userName);
						logger.debug("userName:" + userName);
					}
					
					mv.setViewName(EntpriseConstant.Pages.CREATE_ACCOUNT);
				}
				
			}else{
				//未登录，跳转到统一用户中心
				mv.setViewName(EntpriseConstant.Pages.USER_LOGIN);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return mv;
	}
	
	/**
	 * 访问系统首页
	 */
	@RequestMapping(value = "/welcomePage")
	public ModelAndView welcomePage(Page page,HttpSession httpSession,String welcome,String title) {
		ModelAndView mv = this.getModelAndView();
		mv.addObject("welcome", welcome);
		mv.addObject("title", title);
		mv.setViewName(EntpriseConstant.Pages.WELCOME_PAGE);
		return mv;
		
	}
	/*
	 * 进入首页
	 */
	@RequestMapping(value = "/main")
	private void gotoIndex(Page page,HttpSession httpSession){
		
	}
	/**
	 * 访问系统首页
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletResponse response,HttpSession httpSession) {
		ModelAndView mv = this.getModelAndView();
		httpSession.invalidate();
		mv.setViewName(EntpriseConstant.Pages.USER_LOGIN);
		return mv;
		
		/*try {
			NjUserInfo user = (NjUserInfo) httpSession.getAttribute(EntpriseConstant.SessionKey.USER);
			//1. 调用统一用户中心登出
			AccountCenterUtil.setCenterKey("ed7d597ef32c0319fec0536eb017c314");//渠道秘钥
			AccountCenterUtil.setChannelCode("nj_server");//渠道编码
			String msg = AccountCenterUtil.userLoginOutForChannel(user.getUserMobile());	
				
			JSONObject json=JSONObject.parseObject(msg);
			JSONObject jsonResult=json.getJSONObject("result");
			if("SUCCESS".equals(json.getString("return_code"))){
				//通信成功
				if("SUCCESS".equals(jsonResult.getString("result_code"))){
					//2.系统登出
					httpSession.invalidate();
					response.sendRedirect(Constants.URL.AUTH_URL);
				}else{				
					//密码验证失败
					if("10002".equals(jsonResult.getString("error_code"))){
						httpSession.invalidate();
						response.sendRedirect(Constants.URL.AUTH_URL);
					}else{
						httpSession.invalidate();
						response.sendRedirect(Constants.URL.backServerHost);
					}
					String errorMsg=jsonResult.getString("error_msg");
					String errorCode=jsonResult.getString("error_code");
					System.out.println(errorCode+":"+errorMsg);
				}
			}else{
				//通信失败
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	/**
	 * 完善个人信息
	 */
	@RequestMapping(value = "/enterprise/toAddAcct")
	public ModelAndView toAddAcct(Page page,HttpSession httpSession) {
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			//拉取用户的数据
			String phoneNum = (String) httpSession.getAttribute(EntpriseConstant.SessionKey.TOKEN_NAME);
			
			pd.put("userMobile", phoneNum);
			NjUserInfo user = njUserService.getNjUserInfo(pd);
			mv.addObject("user", user);
			mv.setViewName(EntpriseConstant.Pages.CREATE_ACCOUNT);
			
		} catch (Exception e) {
			
		}
		return mv;
	}
	
	/**
	 * 完善个人信息
	 */
	/*@RequestMapping(value = "/enterprise/addAcct")
	public ModelAndView addAcct(Page page,HttpSession httpSession) {
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("userMobile", (String) httpSession.getAttribute(EntpriseConstant.SessionKey.TOKEN_NAME));
			
			//更新或插入用户信息
			String userId = pd.getString("id");
			NjUserInfo userInfo;
			if(StringUtils.isNotEmptyAndNull( userId)){
				userInfo = enterpriseService.updateAcctInfo(pd);
			}else{
				//新建用户未加入或创建任何公司
				pd.put("state", EntpriseConstant.UserState.UNSUBMIT);
				userInfo = enterpriseService.createAcctInfo(pd);
			}
			httpSession.setAttribute(EntpriseConstant.SessionKey.USER, userInfo);
			//到选择角色页面
			mv.setViewName("/auth/entrance");
			mv.addObject("user", userInfo);
			httpSession.setAttribute(EntpriseConstant.SessionKey.USER_ID,userInfo.getId());
//			httpSession.setAttribute("user", userInfo);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return mv;
	}*/
	
	/**
	 * 加入或参加公司
	 */
	@RequestMapping(value = "/enterprise/toEntrance")
	public ModelAndView toEntrance(Page page,HttpSession httpSession) {
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			Boolean user =  (boolean) httpSession.getAttribute(EntpriseConstant.SessionKey.USER_SYS_ADMIN);
			mv.addObject("isAdmin", user);
			mv.setViewName("/auth/entrance");
		} catch (Exception e) {
			
		}
		return mv;
	}
	
	/**
	 * 加入页面
	 */
	@RequestMapping(value = "/enterprise/toJoin")
	public ModelAndView toJoin(Page page) {
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("/auth/join");
		} catch (Exception e) {
		}
		return mv;
	}		
/*
 *  join company
 */
	@RequestMapping(value = "/enterprise/join")
	public ModelAndView join(Page page, HttpSession session) {
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
//			NjUserInfo user = (NjUserInfo) session.getAttribute(EntpriseConstant.SessionKey.USER);
//			//创建成功后进入主页
//			pd.put("userId", user.getId());
//			enterpriseService.join(pd);
			mv.addObject("coporateId", pd.getString("coporateId"));
			mv.setViewName(EntpriseConstant.Pages.APPLY_REASON);
		} catch (Exception e) {
			logger.error("enterprise/join: " + e.getMessage());
		}
		return mv;
	}
	
	@RequestMapping(value = "/enterprise/toCreate")
	public ModelAndView toCreate(Page page) {
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("/auth/create");
			

		} catch (Exception e) {
			
		}
		return mv;
	}
	
	@RequestMapping(value = "/enterprise/validate")
	@ResponseBody
	public PageData validateForCreateCoporate() throws Exception{
		PageData pd = enterpriseService.validateForCreateCoporate(this.getPageData());
		return pd;
	}
	
	@RequestMapping(value = "/enterprise/create")
	public ModelAndView create(Page page, HttpSession session) throws Exception {
		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			
			NjUserInfo user = (NjUserInfo) session.getAttribute(EntpriseConstant.SessionKey.USER);
			pd.put("userId", user.getId());
			pd.put("userMobile", user.getUserMobile());
			mv.addObject("userId", user.getId());
			
			//创建成功后进入主页
			List<SysRole> allRoles= enterpriseService.getAllSysRoles();
			logger.debug("allRoles:" + allRoles.toString());
			for(SysRole role : allRoles){
				if(role.getRoleType().equals(EntpriseConstant.DataKey.ADMIN_ROLE_TYPE)){
					pd.put("roleId", role.getId());
					break;
				}
			}
			NjCoporate nc = enterpriseService.create(pd);
			mv.addObject("isJoin", 1);
			mv.addObject("coporateID", nc.getId());
			mv.setViewName("/auth/create");
			logger.info("/enterprise/create: " + pd.toString());
		return mv;
	}
	
	@RequestMapping(value = "/enterprise/bind")
	@ResponseBody
	public PageData bind(Page page, HttpSession session) throws Exception {
		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			NjUserInfo user = (NjUserInfo) session.getAttribute(EntpriseConstant.SessionKey.USER);
			pd.put("userId", user.getId());
			String coporateId = pd.getString("coporateId");
			
			//调用财富端接口验证
			String result = tfcfHttpService.doHttpPostForTfcf("", "", pd, com.nj.core.base.common.Constants.TFCF.VERIFY_MEMBER_SMS);
			
			if(StringUtils.isNotEmptyAndNull(result)){
				//根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
				JSONObject tfcfResp1 = JSONObject.parseObject(result);
				logger.debug("tfcfResp1:" + tfcfResp1);
				
				if(tfcfResp1 != null && tfcfResp1.getInteger("resultStatus") == 0){	
						//更新用户的openId和用户的状态
						String openUserId = tfcfResp1.getJSONObject("optional").getString("userid");
						logger.debug("tfcfResp1.getJSONObjectoptional:" + openUserId);
						PageData input = new PageData();
						input.put("userId", user.getId());
						input.put("openUserId", openUserId);
						input.put("coporateId", coporateId);
						njUserService.bindAccount(input);
						//成功后绑定企业与业务账户关系
//						mv.setViewName("redirect:/home");
						pd.put("status", EntpriseConstant.RestData.SUCCESS);
					} else {
						pd.put("status", EntpriseConstant.RestData.FAILURE);
						pd.put("msg", tfcfResp1.getString("msg"));
					}
			}
			
			logger.info("/enterprise/create: " + pd.toString());
		return pd;
	}
	
	@RequestMapping(value="/enterprise/cancelJoin")
	@ResponseBody
	public PageData cancelJoin(NjCoporateUser nUser, HttpSession session){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			NjUserInfo user = (NjUserInfo) session.getAttribute(EntpriseConstant.SessionKey.USER);
			nUser.setUserId(user.getId());
			
			njCoporateUserService.delete(nUser);
			result.put("msg", "取消申请成功");
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("batch delete role error", e);
			result.put("status", 0);
			result.put("msg", "取消申请失败");
		}
		return result;
	}
	
	private void initRights(HttpSession session) {
		try {

			List<String> allRightsUrls = new ArrayList<String>();

			
//			List<String> roles = loginService.getRightsRolesId(njUser.getId());
//			session.setAttribute(Const.SESSION_ROLES_NAME, roles);

			
			List<SysResource> menuList = new ArrayList<>();
			
			// 添加菜单权限信息（含分类菜单）
			PageData crite = new PageData();
			crite.put("userId", (String)session.getAttribute(EntpriseConstant.SessionKey.USER_ID));
			crite.put("coporateId", session.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID));
			List<SysResource> menus = loginService.getParentMenus(crite);
			// menuList.addAll(menus);
			session.setAttribute(com.nj.core.base.util.Constants.USER_SESSION_RESOURCE, menus);
			UserSessions.set(com.nj.core.base.util.Constants.USER_SESSION_RESOURCE, menus);
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

			}

			// 菜单和按钮数据，用于登陆成功后生成菜单树
			session.setAttribute(Const.SESSION_ALLMENULIST, menuList);
			session.setAttribute(Const.SESSION_ALLBUTTONLIST, null);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	@RequestMapping(value = "/clearCache")
	@ResponseBody
	public void clearCache(){
		 EhCacheUtil.getInstance().clearAll();
	}
	
	public static void main(String [] args){
		

		
		AccountCenterUtil.setCenterKey("ed7d597ef32c0319fec0536eb017c314");//渠道秘钥
		AccountCenterUtil.setChannelCode("nj_server");//渠道编码
		String msg=AccountCenterUtil.userLoginOutForChannel("15928062648");
		logger.debug(msg);
	}
	
}
