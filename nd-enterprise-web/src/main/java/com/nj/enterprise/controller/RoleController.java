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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.core.base.util.PageData;
import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.model.generate.SysRole;
import com.nj.service.enterprise.RoleService;
import com.nj.service.enterprise.UserRoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Resource(name = "njRoleService")
	private RoleService roleService;
	
	@Resource(name = "userRoleService")
	private UserRoleService userRoleService;
	
	/**
	 * 我的角色-page
	 */
	@RequestMapping(value = "/getUserRoles", method=RequestMethod.POST)
	@ResponseBody
	public PageData verifyPage(Page page,HttpSession httpSession) {
		PageData result = new PageData();
		try{
			
			PageData pd = this.getPageData();
			
			pd.put("coporateId", httpSession.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID));
			pd.put("id", httpSession.getAttribute(EntpriseConstant.SessionKey.USER_ID));
			result = this.roleService.getUserProdRoles(pd);
			
		} catch (Exception e) {

		}
		return result;	
	}
	
	/**
	 * 我的产品角色-data
	 */
	@RequestMapping(value = "/getUserProdRoles", method=RequestMethod.POST)
	@ResponseBody
	public PageData verifyDatas(Page page,HttpSession httpSession) {
		PageData result = new PageData();
		try{
			
			PageData pd = this.getPageData();
			
			pd.put("coporateId", httpSession.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID));
			pd.put("id", httpSession.getAttribute(EntpriseConstant.SessionKey.USER_ID));
			result = this.roleService.getUserProdRoles(pd);
			
		} catch (Exception e) {
			
		}
		return result;
	}	

	/**
	 * 分配角色-page
	 */
	@RequestMapping(value = "/assign", method=RequestMethod.GET)
	public ModelAndView assignPage(Page page) {
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			//获取用户未分配的角色列表
			List<SysRole> roles = roleService.getAssignableRolesByUser(pd);
			mv.addObject("roleId",roles);
			//page control
			mv.setViewName("/account/role_assign");
			
		} catch (Exception e) {
			
		}
		return mv;
	}
	
	/**
	 * 我的产品角色-data
	 */
	@RequestMapping(value = "/assign", method=RequestMethod.POST)
	@ResponseBody
	public PageData assignPost(Page page,HttpSession httpSession) {
		PageData result = new PageData();
		try{
			
			PageData pd = this.getPageData();
			
			pd.put("coporateId", httpSession.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID));
			pd.put("userId", httpSession.getAttribute(EntpriseConstant.SessionKey.USER_ID));
			this.userRoleService.add(pd);
			result.put("status", EntpriseConstant.RestData.SUCCESS);
			result.put("msg", "add成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
			result.put("status", EntpriseConstant.RestData.FAILURE);
			result.put("msg", "add成功");
		}
		return result;
	}

	
}
