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
 * May 6, 2015    YangShengJun         Create the class
*/

package com.nj.service.base.system;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.SHA;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.extend.SysResourceMapperExtend;
import com.nj.dao.extend.SysRoleMapperExtend;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjCoporateUserExample;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysResource;
import com.nj.model.generate.SysRole;
import com.nj.service.enterprise.NjCoporateUserService;

/**
 * @FileName LoginService.java
 * @Description: 
 *
 * @Date May 6, 2015 
 * @author YangShengJun
 * @version 1.0
 * 
 */
@Transactional(readOnly=true)
@Service("loginService")
public class LoginService {
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Resource 
	private  NjCoporateUserService njCoporateUserService;
	@Resource 
	private  SysRoleMapperExtend sysRoleMapperExtend;
	

	public List<String> getRightsRolesId(String userId) throws Exception {
		SysRoleMapperExtend sm = dao.getMapper(SysRoleMapperExtend.class);
		return  sm.findRolesIdByUserId(userId);
	}
	
	public List<SysResource> getRightsParentMenus(String userId) throws Exception {
		SysResourceMapperExtend sm = dao.getMapper(SysResourceMapperExtend.class);
		//如果是超级管理员
		if(userId.equals("1")) {
			return  sm.findAllParentMenus();
		}else {
			return  sm.findParentMenusByUserId(userId);
		}
		
	}
	/*
	 * 根据用户和公司获取菜单
	 */
	public List<SysResource> getParentMenus(PageData pd) throws Exception {
		SysResourceMapperExtend sm = dao.getMapper(SysResourceMapperExtend.class);
		return  sm.findParentMenusByCondition(pd);
	}
	public List<SysResource> getRightsSubMenus(Map<?, ?> parames) throws Exception {
		SysResourceMapperExtend sm = dao.getMapper(SysResourceMapperExtend.class);
		return  sm.findMenusByUserIdAndParent(parames);
	}
	/**
	 * 用户登陆
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public NjUserInfo checkUserLogin(String mobile,String password) throws Exception{
		boolean result = true;
		String errInfo="";
		NjUserInfoMapper uiMapper = dao.getMapper(NjUserInfoMapper.class);
		NjUserInfo userInfo = uiMapper.selectByMobile(mobile);
		if(userInfo==null) {
			result = false;
			errInfo = "该手机号不是系统用户，请联系管理员！";
			throw new Exception(errInfo);
		}
		if(!userInfo.getPassword().equals(SHA.getSHA256StrJava(password))) {
			result = false;
			errInfo = "密码错误";
		}
		if(userInfo.getState()==1) {
			result = false;
			errInfo = "该用户已禁用！";
		}
		if(!result) {
			throw new Exception(errInfo);
		}
		userInfo.setUserMobile(mobile);
		return userInfo;
	}
	
	
	/**
	 * 用户登陆
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public NjUserInfo checkUserLogin(String mobile) throws Exception{
		boolean result = true;
		String errInfo="";
		NjUserInfoMapper uiMapper = dao.getMapper(NjUserInfoMapper.class);
		NjUserInfo userInfo = uiMapper.selectByMobile(mobile);
		if(userInfo==null) {
			result = false;
			errInfo = "该手机号不是系统用户，请联系管理员！";
			throw new Exception(errInfo);
		}
		
		if(userInfo.getState()==1) {
			result = false;
			errInfo = "该用户已禁用！";
		}
		if(!result) {
			throw new Exception(errInfo);
		}
		userInfo.setUserMobile(mobile);
		return userInfo;
	}
	
	
	/**
	 * 用户登陆
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public NjUserInfo checkUserLogin2(String mobile,String password) throws Exception{
		boolean result = true;
		String errInfo="";
		NjUserInfoMapper uiMapper = dao.getMapper(NjUserInfoMapper.class);
		NjUserInfo userInfo = uiMapper.selectByMobile(mobile);
		if(userInfo==null) {
			result = false;
			errInfo = "该手机号不是系统用户，请联系管理员！";
			throw new Exception(errInfo);
		}
		if(!userInfo.getPassword().equals(new SimpleHash("SHA-1", "MD5", password).toString()) ) {
			result = false;
			errInfo = "密码错误";
		}
		if(userInfo.getState()==1) {
			result = false;
			errInfo = "该用户已禁用！";
		}
		if(!result) {
			throw new Exception(errInfo);
		}
		userInfo.setUserMobile(mobile);
		return userInfo;
	}
	
	public  NjCoporateUser  getCorUser(String userId) throws Exception{
		NjCoporateUserExample example  =  new  NjCoporateUserExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<NjCoporateUser> list = njCoporateUserService.selectByExample(example  );
		NjCoporateUser njCoporateUser ;
		if(list.size()==1){
			 njCoporateUser = list.get(0);
		}else{
			throw new  Exception("业务经理id="+userId+"找不到对用公司编号");
		}
		return  njCoporateUser;
	}
	
	public  List<SysRole>  getRoleByUserIdFresh(String  userId) throws Exception{
		Assert.hasLength(userId, "用户Id不能为空");
		List<SysRole> list = sysRoleMapperExtend.selectRoleByUserIdFresh(userId);
		return  list;
	}
	
}
