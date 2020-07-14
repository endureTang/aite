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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.RegExpUtil;
import com.nj.core.base.util.SHA;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysUser;
import com.nj.service.base.system.RoleService;
import com.nj.service.enterprise.NjUserExdService;
import com.nj.service.enterprise.SysUserService;

/**
 * @FileName SysUserController.java
 * @Description:
 *
 */
@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(SysUserController.class);

	@Resource(name = "sysUserService")
	private SysUserService sysUserService;
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	@Resource(name = "njUserExdService")
	private NjUserExdService userExdService;


	@GetMapping(value="list")
	@ResourcesAnnotion(uri="/sysUser/list",name="系统用户",resourceType=1,parentId="1")
	public ModelAndView page() {
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/sysUser/user_list");
		return mv;
	}

	@PostMapping(value = "/list")
	@ResponseBody
	public PageData list() {
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = sysUserService.list(pd);
		} catch (Exception e) {
			logger.error("list user error", e);
			result = new PageData();
		}
		return result;
	}
	
	@GetMapping(value = "/add")
	public ModelAndView toNjAdd() {
		ModelAndView mv = super.getModelAndView();
		try {
			PageData pd = new PageData();
			pd.put("type", 1);
			mv.addObject("roleList", roleService.getAllRoleList(pd));
		} catch (Exception e) {
			logger.error("获取产品出错：", e.getMessage());
		}
		mv.setViewName("sys/sysUser/nj_user_add");
		return mv;
	}

	@PostMapping(value = "/add")
	@ResponseBody
	public PageData njAdd(HttpSession httpSession) {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();

			// 用户名
			String userName = pd.getString("name").toLowerCase();
			pd.put("userName", userName);

			// 电话号码
			String phone = pd.getString("phone").toLowerCase();
			pd.put("phone", phone);

			// 邮件
			String email = pd.getString("email").toLowerCase();
			pd.put("email", email);

			// 描述
			String remarks = pd.getString("remarks").toLowerCase();
			pd.put("remarks", remarks);
			// 登录名
			String loginName = pd.getString("loginName").toLowerCase();
			pd.put("loginName", loginName);
			
			SysUser info = sysUserService.getByMobile(phone);
			if(null != info) {
				result.put("status", 0);
				result.put("msg", "用户电话已存在");
				return result;
			}
			
			pd.put("coporateId", "231f0babdad4454b96e607f2f62c6ff4");

			// 密码
			String password = pd.getString("password");
			if (password != null && password.length() > 0) {				
				if (!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)) {
					result.put("status", 0);
					result.put("msg", "密码必须为8到16位的数字字母组成");
					return result;
				}
				pd.put("password", new SimpleHash("SHA-1", "MD5", password).toString());
			}
			
			// 状态
			pd.put("state", 0);

			// 创建日期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pd.put("createDate", df.format(new Date()));

			// id
			String uuid = UUID.randomUUID().toString();
			pd.put("id", uuid.replace("-", ""));

			SysUser user = (SysUser) httpSession.getAttribute("sessionUser");
			pd.put("createBy", user.getLoginName());
			userExdService.addSysUser(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add user error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	
	@GetMapping(value = "/edit")
	public ModelAndView toNjEdit(@RequestParam String userId) {
		PageData pd = new PageData();
		try {
			SysUser sysUser = sysUserService.getByUserId(userId);
			pd.put("id", sysUser.getId());
			pd.put("name", sysUser.getName());
			pd.put("loginName", sysUser.getLoginName());
			pd.put("phone", sysUser.getPhone());
			pd.put("password", sysUser.getPassword());
			pd.put("remarks", sysUser.getRemarks());
			pd.put("type", 1);
			pd.put("roleList", roleService.getAllRoleList(pd));
			pd.put("hasRoleList", roleService.getUserHasRoleList(userId,1));
			
		} catch (Exception e) {
			logger.error("get user error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/sysUser/nj_user_edit");
		return mv;
	}

	@PostMapping(value = "/edit")
	@ResponseBody
	public PageData njEdit(HttpSession httpSession) {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			
			String id = pd.getString("id");
			pd.put("id", id);
			pd.put("userId", id);
			
			String name = pd.getString("name");
			pd.put("name", name);
			
			//SysUser sysUser = sysUserService.getByUserId(id);
			//pd.put("password", sysUser.getPassword());
			String password = pd.getString("password");
			if (!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)) {
				result.put("status", 0);
				result.put("msg", "密码必须为8到16位的数字字母组成");
				return result;
			}
			
			password = new SimpleHash("SHA-1", "MD5", password).toString();
			pd.put("password", password);	
			
			//pd.remove("password");
			String email = pd.getString("email");
			pd.put("email", email);
			
			String phone = pd.getString("phone");
			pd.put("phone", phone);

			// 修改日期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pd.put("updateDate", df.format(new Date()));
			
			SysUser user = (SysUser) httpSession.getAttribute("sessionUser");
			pd.put("updateBy", user.getLoginName());
			
			userExdService.editSysUser(pd);

			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit user error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public PageData delete(@RequestParam String userId) {
		PageData result = new PageData();
		try {
			PageData pd = new PageData();
			pd.put("id", userId);
			userExdService.deleteSysUser(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete user error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
}
