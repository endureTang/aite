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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jd.core.util.StringUtil;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysRole;
import com.nj.model.generate.SysRoleExample;
import com.nj.model.generate.SysRoleExample.Criteria;
import com.nj.model.generate.SysUser;
import com.nj.model.generate.SysUserRole;
import com.nj.service.base.system.RoleService;
import com.nj.service.base.system.UserService;
import com.nj.service.enterprise.CoporateService;
import com.nj.service.enterprise.EnterpriseService;
import com.nj.service.enterprise.NjUserExdService;
import com.nj.service.enterprise.ProductService;
import com.nj.service.enterprise.UserRoleService;
import com.nj.core.base.util.CYMailUtil;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.RegExpUtil;
import com.nj.core.base.util.SHA;

/**
 * @FileName UserController.java
 * @Description:
 *
 * @Date 2015年5月9日
 * @author dzk
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "njUserExdService")
	private NjUserExdService userExdService;

	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;
	
	@Resource(name ="productService")
	private ProductService productService;
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	@Resource(name = "coporateService")
	private CoporateService coporateService;
	
	@Resource
	private UserRoleService userRoleService;

	@RequestMapping(value = "/editPwd", method = RequestMethod.GET)
	public ModelAndView editPwd() {
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/admin/editPassword");
		return mv;
	}

	@RequestMapping(value = "/editPwd", method = RequestMethod.POST)
	@ResponseBody
	public PageData doEditPwd() {
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			Subject currentUser = SecurityUtils.getSubject();
			org.apache.shiro.session.Session session = currentUser.getSession();
			SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
			pd.put("userId", user.getId());
			
			// 密码验证
			String password = pd.getString("password");
			if(!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)){
				result = new PageData();
				result.put("status", 0);
				result.put("msg", "密码必须为8到16位的数字字母组成");
				return result;
			} 
			
			result = userService.editPassword2(pd);
		} catch (Exception e) {
			logger.error("edit password error", e);
			result = new PageData();
			result.put("status", 0);
			result.put("msg", "系统发生异常");
		}
		return result;
	}

	@RequestMapping(value = "/unauthorized")
	public ModelAndView unauthorized() {
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/admin/unauthorized");
		return mv;
	}

	@RequestMapping
	public ModelAndView page() {
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/user/user_list");
		return mv;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public PageData list() {
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = userService.list(pd);
		} catch (Exception e) {
			logger.error("list user error", e);
			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value = "/getListById")
	@ResponseBody
	public PageData getListById() {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			List<PageData> r1 = userService.getPageById(pd);
			result.put(Const.NDATA, r1);
			result.put("status", 1);
		} catch (Exception e) {
			result.put("status", 0);
			result.put("msg", e.getMessage());

			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value = "/inchargelist")
	@ResponseBody
	public PageData inchargelist() {
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = userService.inchargelist(pd);
		} catch (Exception e) {
			logger.error("list user error", e);
			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value = "/info")
	@ResponseBody
	public PageData info() {

		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			String id = pd.getString("id");
			result.put(Const.JSON_RESULT, "1");
			result.put(Const.JSON_DATA, userService.getById(id));
		} catch (Exception e) {
			result.put(Const.JSON_RESULT, "1");
			result.put(Const.JSON_MSG, e.getMessage());
			logger.error("list user error", e);
			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView toAdd() {
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/user/user_add");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public PageData add() {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			String loginName = pd.getString("loginName").toLowerCase();

			pd.put("loginName", loginName);//
			// 根据手机号和邮箱判断是否重复
			/*
			 * if(userService.isNameExsit(pd)){ result.put("status", 0);
			 * result.put("msg", "重复，请修改"); }
			 */
			int existResult = userService.isMobileOrEmailExist(pd);
			if (existResult == 1) {
				result.put("status", 0);
				result.put("msg", "邮箱重复，请修改");
				logger.error("添加用户时候邮箱重复");
			} else if (existResult == 2) {
				result.put("status", 0);
				result.put("msg", "手机号重复，请修改");
				logger.error("添加用户时候手机号重复");
			} else if (existResult == 3) {
				result.put("status", 0);
				result.put("msg", "该员工号已经存在，请修改");
				logger.error("添加用户时候手机号重复");
			} else {
				String password = pd.getString("password");
				String randomPwd = password;
				if (password != null && password.length() > 0) {
				} else {
					randomPwd = "" + nextRandom();
				}
				password = new SimpleHash("SHA-1", "MD5", randomPwd).toString();
				pd.put("password", password);
				pd.put("status", 1);

				Integer inCId = pd.getInteger("inChargeId");
				if (inCId != null) {
					pd.put("inChargeId", inCId);

				} else {
					pd.put("inChargeId", 0);
				}

				userService.add(pd);
				result.put("status", 1);

				// 设置角色

				String isAdmin = pd.getString("isAdmin");

				PageData urMapping = new PageData();
				urMapping.put("userId", pd.getInteger("id"));

				if ("true".equals(isAdmin) || "1".equals(isAdmin)) {
					urMapping.put("roleId", 2);
				} else {
					urMapping.put("roleId", 3);
				}
				userService.addRole(urMapping);

				// 添加成功后给该用户发邮件
				CYMailUtil cu = new CYMailUtil();
				String content = "亲爱的" + pd.getString("name") + ":<br><br>"
						+ "&nbsp;&nbsp;你的账户已经创建好，请登录后改变初始密码, 账号信息如下: <br>" + "&nbsp;&nbsp;手机: " + pd.getString("phone")
						+ "<br>&nbsp;&nbsp;邮箱: " + pd.getString("email") + "<br>&nbsp;&nbsp;初始密码: " + randomPwd
						+ "<br><br><center style='color:gray;'>此邮件由系统自动发出，请勿回复。</center>";
				String subject = "恭喜你，你的账户创建成功";
				cu.sendMail(null, pd.getString("email"), null, null, new ArrayList<String>(), subject, content);

			}
		} catch (Exception e) {
			logger.error("add user error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}

	final static int min = 1000;
	final static int max = 9999;

	public static int nextRandom() {
		Random rand = new Random();
		int tmp = Math.abs(rand.nextInt());
		return tmp % (max - min + 1) + min;
	}

	@RequestMapping(value = "/checkName", method = RequestMethod.POST)
	@ResponseBody
	public int checkName() {
		int result = 0;
		try {
			PageData pd = super.getPageData();
			if (userService.isNameExsit(pd)) {
				result = 1;
			}
		} catch (Exception e) {
			logger.error("check group name error", e);
		}
		return result;
	}
	

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam String userId) {
		PageData pd = null;
		try {
			pd = userService.getById(userId);
		} catch (Exception e) {
			logger.error("get user error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/user/user_edit");
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public PageData edit() {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			String password = pd.getString("password");
			if (StringUtils.isNotBlank(password)) {
				String userId = pd.getString("userId");
				PageData user = userService.getById(userId);
				// String loginName = user.getString("loginName");
				password = new SimpleHash("SHA-1", "MD5", password).toString();
				pd.put("password", password);
			} else {
				pd.remove("password");
			}
			Integer inCId = pd.getInteger("inChargeId");
			if (inCId != null) {
				pd.put("inChargeId", inCId);

			} else {
				pd.put("inChargeId", 0);
			}

			Integer status;
			String statusStr = pd.getString("status");
			if (statusStr.equals("1") || statusStr.equals("true")) {
				status = 1;

			} else {
				status = 0;
			}
			pd.put("status", status);
			userService.edit(pd);

			// 修改用户角色(单角色)
			String isAdmin = pd.getString("isAdmin");
			PageData urMapping = new PageData();
			urMapping.put("userId", pd.getInteger("userId"));

			if ("true".equals(isAdmin) || "1".equals(isAdmin)) {
				urMapping.put("roleIds", 2);
			} else {
				urMapping.put("roleIds", 3);
			}

			userService.editRole(urMapping);

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
	public PageData delete(@RequestParam Integer userId) {
		PageData result = new PageData();
		try {
			userService.delete(userId);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete user error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}

	@RequestMapping(value = "/batchDelete")
	@ResponseBody
	public PageData batchDelete(@RequestParam String ids) {
		PageData result = new PageData();
		try {
			userService.batchDelete(ids);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("batch delete user error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}

	@RequestMapping(value = "/editRole", method = RequestMethod.GET)
	public ModelAndView toEditRole(@RequestParam Integer userId) {
		List<PageData> roles = null;
		try {
			roles = userService.getRoles(userId);
		} catch (Exception e) {
			logger.error("to edit role error", e);
			roles = new ArrayList<PageData>();
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("userId", userId);
		mv.addObject("roles", roles);
		mv.setViewName("sys/user/user_role_edit");
		return mv;
	}

	@RequestMapping(value = "/editRole", method = RequestMethod.POST)
	@ResponseBody
	public PageData editRole() {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			userService.editRole(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit role error", e);
			result.put("status", 0);
			result.put("msg", "授权失败");
		}
		return result;
	}

	@RequestMapping(value = "/personalinfo")
	@ResponseBody
	public PageData personalinfo() {

		PageData result = null;
		try {
			SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);

			result = this.userService.getById(user.getId());

		} catch (Exception e) {
			logger.error("list user error", e);
			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value = "/personalmodify", method = RequestMethod.POST)
	@ResponseBody
	public PageData personalmodify() {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			String password = pd.getString("oldpassword");
			String newPwd = pd.getString("password");
			if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(newPwd)) {
				// User user =
				// (User)SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);

				// password = new SimpleHash("SHA-1", "MD5",
				// password).toString();
				// pd.put("password", password);
				// pd.put("loginName", user.getLoginName());
				// PageData dbUser = userService.getUserByNameAndPwd(pd);
				// if(dbUser != null){
				// 更新密码
				// String newPassword = new SimpleHash("SHA-1", "MD5",
				// newPwd).toString();
				// pd.put("oldpassword",password);
				// pd.put("password", newPassword);
				PageData res = this.userService.editPassword(pd);
				return res;
				// }else{
				// result.put("status", 0);
				// result.put("msg", "旧密码不对");
				// }

			} else {
				result.put("status", 0);
				result.put("msg", "旧密码或新密码不能为空");
			}

		} catch (Exception e) {
			logger.error("edit user error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}

	@RequestMapping(value = "/disable")
	@ResponseBody
	public PageData disable() {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			userService.offDuty(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete user error", e);
			result.put("status", 0);
			result.put("msg", "禁用失败");
		}
		return result;
	}

	/**
	 * 我的人员-data
	 */
	@RequestMapping(value = "/team", method = RequestMethod.POST)
	@ResponseBody
	public PageData teamDatas(Page page, HttpSession httpSession) {
		PageData result = new PageData();
		try {

			PageData pd = this.getPageData();
			pd.put("start", pd.getInteger("start"));
			pd.put("length", pd.getInteger("length"));

//			pd.put("coporateId", httpSession.getAttribute("coporateId"));
//			pd.put("id", httpSession.getAttribute("userID"));
			
			String search = pd.getString("keyword");
			if (StringUtils.isNotBlank(search)) {
				pd.put("search", search);
			}
			
			String  coporateId  =  pd.getString("coporateId");
			if(StringUtils.isNotBlank(coporateId)){
				pd.put("coporateId", coporateId);
			}else {
				pd.remove("coporateId");
			}
			
			result = this.userExdService.getUserInfo(pd);
			result.put(Const.DRAW, pd.getString(Const.DRAW));

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	

	@RequestMapping(value = "/getRolesAndProducts", method = RequestMethod.POST)
	@ResponseBody
	public PageData getRolesAndProducts() throws Exception {
		PageData result = new PageData();
		PageData pd =  super.getPageData();
		String userId = pd.getString("userId");
		pd.put("type", 2);
		pd.put("state", 5);

		String coporateId = pd.getString("coporateId");
		List<Map> productList = productService.getAllProductList(pd);
		SysRoleExample example  =  new SysRoleExample() ;
		Criteria createCriteria = example.createCriteria();
		createCriteria.andDelFlagEqualTo(false);
		createCriteria.andTypeEqualTo(2);
		if(!StringUtils.isBlank(coporateId)){
			createCriteria.andOfficeIdEqualTo(coporateId);
		}
		List<SysRole> roleList = roleService.selectByExample(example  );
		
		result.put("productList", productList);
		result.put("roleList", roleList);
		
		if(!StringUtil.isBlank(userId)){
			result.put("hasRoleList", roleService.getUserHasRoleList(userId,2));
			result.put("hasProductList", productService.getUserHasProductList(userId));
		}
		return result;
	}
	@RequestMapping(value = "/njAdd", method = RequestMethod.GET)
	public ModelAndView toNjAdd() {
		ModelAndView mv = super.getModelAndView();
		try {
			//获取产品列表
			PageData pd = new PageData();
			pd.put("type", 2);
			pd.put("state", 5);
			mv.addObject("productList", productService.getAllProductList(pd));
			mv.addObject("roleList", roleService.getAllRoleList(pd));
		} catch (Exception e) {
			logger.error("获取产品出错：", e.getMessage());
		}
		mv.setViewName("sys/user/nj_user_add");
		return mv;
	}

	@RequestMapping(value = "/njAdd", method = RequestMethod.POST)
	@ResponseBody
	public PageData njAdd(HttpSession httpSession) {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();

			// 用户名
			String userName = pd.getString("name").toLowerCase();
			pd.put("userName", userName);

			// 电话号码
			String userMobile = pd.getString("phone").toLowerCase();
			pd.put("userMobile", userMobile);

			// 邮件
			String email = pd.getString("email").toLowerCase();
			pd.put("email", email);

			// 描述
			String remarks = pd.getString("remarks").toLowerCase();
			pd.put("remarks", remarks);
			
			// 分公司编号
			String coporateId = pd.getString("coporateId").toLowerCase();
			pd.put("coporateId", coporateId);
			
			NjUserInfo info = userExdService.getByMobile(userMobile);
			if(null != info && !true==info.getDelFlag() ) {
				result.put("status", 0);
				result.put("msg", "用户电话已存在");
				return result;
			}
			// 根据手机号和邮箱判断是否重复
			/*
			 * if(userService.isNameExsit(pd)){ result.put("status", 0);
			 * result.put("msg", "重复，请修改"); }
			 */
			/*
			 * int existResult = userService.isMobileOrEmailExist(pd);
			 * if(existResult == 1){ result.put("status", 0); result.put("msg",
			 * "邮箱重复，请修改"); logger.error("添加用户时候邮箱重复"); }else if(existResult ==
			 * 2){ result.put("status", 0); result.put("msg", "手机号重复，请修改");
			 * logger.error("添加用户时候手机号重复"); }else if(existResult == 3){
			 * result.put("status", 0); result.put("msg", "该员工号已经存在，请修改");
			 * logger.error("添加用户时候手机号重复"); }
			 */

			// 密码
			String password = pd.getString("password");
//			String randomPwd = password;
//			if (password != null && password.length() > 0) {
//			} else {
//				randomPwd = "" + nextRandom();
//			}
//			password = new SimpleHash("SHA-1", "MD5", randomPwd).toString();
			if (password != null && password.length() > 0) {
				if (!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)) {
					result.put("status", 0);
					result.put("msg", "密码必须为8到16位的数字字母组成");
					return result;
				}
				pd.put("password", SHA.getSHA256StrJava(password));
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
			pd.put("delFlag", 0);
			userExdService.add(pd);

			result.put("status", 1);

			

			// 添加成功后给该用户发邮件
			// CYMailUtil cu = new CYMailUtil();
			// String content = "亲爱的"+ pd.getString("name") +":<br><br>" +
			// "&nbsp;&nbsp;你的账户已经创建好，请登录后改变初始密码, 账号信息如下: <br>"
			// + "&nbsp;&nbsp;手机: " + pd.getString("phone") +
			// "<br>&nbsp;&nbsp;邮箱: " + pd.getString("email") +
			// "<br>&nbsp;&nbsp;初始密码: " + randomPwd
			// +"<br><br><center style='color:gray;'>此邮件由系统自动发出，请勿回复。</center>";
			// String subject = "恭喜你，你的账户创建成功";
			// cu.sendMail(null, pd.getString("email"),null,null,new
			// ArrayList<String>(), subject, content);
			//

		} catch (Exception e) {
			logger.error("add user error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	
	@RequestMapping(value = "/njEdit", method = RequestMethod.GET)
	public ModelAndView toNjEdit(@RequestParam String userId) throws Exception {
		PageData pd = null;
		try {
			
			PageData pd1 = super.getPageData();
			String coporateId = pd1.getString("coporateId");
			pd = userExdService.getUserById(userId);
			pd.put("state", 5);
			pd.put("type", 2);
			pd.put("coporateId", coporateId);
			//pd.put("productList", productService.getAllProductList(pd));
			
			List<Map> productList = productService.getAllProductList(pd);
			pd.put("productList", productList);
			pd.put("hasProductList", productService.getUserHasProductList(userId));
		
			
			SysRoleExample example  =  new SysRoleExample() ;
			Criteria createCriteria = example.createCriteria();
			createCriteria.andDelFlagEqualTo(false);
			createCriteria.andTypeEqualTo(2);
			if(!StringUtils.isBlank(coporateId)){
				createCriteria.andOfficeIdEqualTo(coporateId);
			}
			List<SysRole> roleList = roleService.selectByExample(example  );
			pd.put("roleList", roleList);
			pd.put("hasRoleList", roleService.getUserHasRoleList(userId,2));
			
		} catch (Exception e) {
			logger.error("get user error", e);
		}
		
		PageData pd2 = super.getPageData();
		String  coporateId =  pd2.getString("coporateId");
		List<Map> coporateList = coporateService.selectAllList(pd);
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.addObject("userId", userId);
		mv.addObject("coporateId", coporateId);
		mv.addObject("coporateList", coporateList);
		mv.setViewName("sys/user/nj_user_edit");
		return mv;
	}

	@RequestMapping(value = "/njEdit", method = RequestMethod.POST)
	@ResponseBody
	public PageData njEdit(HttpSession httpSession) {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			
			String id = pd.getString("userId");
			pd.put("id", id);
			
			String name = pd.getString("name");
			pd.put("name", name);
			
			String password = pd.getString("password");
			if (StringUtils.isNotBlank(password)) {
		
				String pwd = userExdService.getPwdByUserId(id);
				if (!password.equals(pwd)) {
					
					if (!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)) {
						result.put("status", 0);
						result.put("msg", "密码必须为8到16位的数字字母组成");
						return result;
					}
					pd.put("password", SHA.getSHA256StrJava(password));									
				}
			} else {
				pd.remove("password");
			}
			
			String email = pd.getString("email");
			pd.put("email", email);
			
			String phone = pd.getString("phone");
			pd.put("phone", phone);
			NjUserInfo info = userExdService.getByMobile(phone);
			if(null != info && !true==info.getDelFlag() && !id.endsWith(info.getId()) ) {
				result.put("status", 0);
				result.put("msg", "用户电话已存在");
				return result;
			}
			
			
			String coporateId = pd.getString("coporateId");
			if (StringUtils.isNotBlank(coporateId)) {
				pd.put("coporateId", coporateId);
			}

			// 修改日期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pd.put("updateDate", df.format(new Date()));
			
			SysUser user = (SysUser) httpSession.getAttribute("sessionUser");
			pd.put("updateBy", user.getLoginName());
			
			userExdService.edit(pd);

			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit user error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}

	@RequestMapping(value = "/njDelete")
	@ResponseBody
	public PageData njDelete(@RequestParam String userId) {
		PageData result = new PageData();
		try {
			PageData pd = new PageData();
			pd.put("id", userId);
			userExdService.delete(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete user error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
}
