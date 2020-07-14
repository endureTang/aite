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

package com.nj.service.base.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.AppUtil;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.SHA;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.SysUserMapper;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysUser;
import com.nj.model.generate.SysUserExample;
import com.nj.model.generate.SysUserExample.Criteria;

/**
 * @FileName UserService.java
 * @Description:
 *
 * @Date 2015年5月9日
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional(readOnly = true)
@Service("userService")
public class UserService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Resource
	private SysUserMapper sysUserMapper;


	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	/***********************************/
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void setSKIN(PageData pd) throws Exception {
		dao.update("UserXMapper.setSKIN", pd);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveIP(PageData pd) throws Exception {
		dao.update("UserXMapper.saveIP", pd);
	}

	public PageData getUserByNameAndPwd(PageData pd) throws Exception {
		PageData result = null;
		SysUserMapper sm = dao.getMapper(SysUserMapper.class);
		logger.info(sm.toString());
		
		SysUserExample example = new SysUserExample();
		
		Criteria criteria = example.createCriteria();    
		criteria.andLoginNameEqualTo(pd.getString("loginName"));  
		criteria.andPasswordEqualTo(pd.getString("password"));
		
		List<SysUser> list = sm.selectByExample(example);
		if(list != null && list.size() == 1){
			result = new PageData();
			result.insertData(list.get(0));
		}
		return result;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateLastLogin(PageData pd) throws Exception {
//		dao.update("UserXMapper.updateLastLogin", pd);
		
		SysUser user = new SysUser();
		user.setId(pd.getString("id"));
		user.setLoginDate(new Date());

		SysUserMapper sm = dao.getMapper(SysUserMapper.class);
		sm.updateByPrimaryKeySelective(user);
		
	}

	/***********************************/

	public PageData list(PageData pd) throws Exception {
		PageData result = new PageData();
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		int totalNum = (int) dao.findForObject("UserMapper.count", pd);

		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		List<PageData> pds = dao.findForList("UserMapper.list", pd);
		AppUtil.nullToEmpty(pds, new String[] { "loginName", "lastLogin", "email", "phone", "name" });

		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}
	
	public List<PageData> getPageById(PageData pd) throws Exception {
//		PageData result = new PageData();
		pd.put("length", pd.getInteger("length"));
		pd.put("start", pd.getInteger("start"));
		List<PageData> pds = dao.findForList("UserMapper.getPageById", pd);
		
		return pds;
	}

	public PageData inchargelist(PageData pd) throws Exception {
		PageData result = new PageData();
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		List<PageData> pds = dao.findForList("UserMapper.inchargelist", pd);
		
		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.NDATA, pds);
		return result;
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void add(PageData pd) throws Exception {
		dao.save("UserMapper.add", pd);
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void addRole(PageData pd) throws Exception {
			List<PageData> list = new ArrayList<PageData>();
			list.add(pd);
			dao.batchSave("UserMapper.saveUserRoles", list);
	}
	
	public PageData getById(String userId) throws Exception {
		return (PageData) dao.findForObject("UserMapper.getById", userId);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void edit(PageData pd) throws Exception {
		dao.update("UserMapper.edit", pd);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void delete(Integer userId) throws Exception {
		dao.delete("UserMapper.delete", userId);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void batchDelete(String ids) throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idArr = ids.split(",");
			if (idArr.length > 0) {
				List<Integer> idList = new ArrayList<Integer>();
				for (String idStr : idArr) {
					idList.add(Integer.valueOf(idStr));
				}
				dao.delete("UserMapper.batchDelete", idList);
			}
		}
	}

	public List<PageData> getRoles(Integer userId) throws Exception {
		List<PageData> roles = dao.findForList("RoleMapper.listAllRoles", null);
		List<PageData> userRoles = dao.findForList("UserMapper.listUserRoleByUserId", userId);
		for (PageData role : roles) {
			Integer roleId = role.getInteger("roleId");
			for (PageData userRole : userRoles) {
				if (roleId.equals(userRole.getInteger("roleId"))) {
					role.put("checked", true);
					break;
				}
			}
		}
		return roles;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void editRole(PageData pd) throws Exception {
		String roleIds = pd.getString("roleIds");
		if (StringUtils.isNotBlank(roleIds)) {
			List<PageData> list = new ArrayList<PageData>();
			Integer userId = pd.getInteger("userId");
			String[] roleIdArr = roleIds.split(",");
			for (String roleId : roleIdArr) {
				PageData p = new PageData();
				p.put("userId", userId);
				p.put("roleId", Integer.valueOf(roleId));
				list.add(p);
			}
			dao.delete("UserMapper.deleteUserRoleByUserId", userId);
			dao.batchSave("UserMapper.saveUserRoles", list);
		}
	}

	public boolean isNameExsit(PageData pd) throws Exception {
		String loginName = pd.getString("loginName").toLowerCase();
		pd.put("loginName", loginName);
		SysUserExample example  =  new SysUserExample() ;
		example.createCriteria().andLoginNameEqualTo(loginName);
		List<SysUser> list = sysUserMapper.selectByExample(example  );
		//List<PageData> pds = dao.findForList("UserMapper.getByName", loginName);
		return list.size() > 0 ? true : false;
	}
	
	public int isMobileOrEmailExist(PageData pd) throws Exception {
		String email = pd.getString("email").toLowerCase();
		String phone = pd.getString("phone");
		String empNo = pd.getString("empNo");
		PageData ipd = new PageData();
		ipd.put("email", email);
		ipd.put("phone", phone);
		ipd.put("empNo", empNo);
		
		PageData pds = dao.findForObject("UserMapper.getByMailAndPhone", ipd);
		if(pds.getInteger("count") == 0) return 0;
		else{
			if(pds.getInteger("emailExist")>0) return 1;
			else if(pds.getInteger("empExis")>0) return 3;
			else return 2;
		}
	}
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public PageData editPassword(PageData pd) throws Exception {
		PageData result = new PageData();
		NjUserInfoMapper mapper = dao.getMapper(NjUserInfoMapper.class);
		NjUserInfo user = mapper.selectByPrimaryKey(pd.getString("userId"));
		String encodePwd = SHA.getSHA256StrJava(pd.getString("oldpassword"));
		
		if (user.getPassword().equals(encodePwd)) {
			user.setPassword(SHA.getSHA256StrJava(pd.getString("password")));
			mapper.updateByPrimaryKeySelective(user);
			result.put("status", 0);
		} else {
			result.put("status", 1);
			result.put("msg", "原密码错误");
		}
		return result;
	}

	

	public PageData editPassword2(PageData pd) throws Exception {
		PageData result = new PageData();
		
		
		SysUserExample example  =  new  SysUserExample();
		example.createCriteria().andIdEqualTo(pd.getString("userId"));
		String  oldpassword  = new SimpleHash("SHA-1", "MD5", pd.getString("oldpassword")).toString() ;
		List<SysUser> list = sysUserMapper.selectByExample(example  );
		if(list.size()>0){
			SysUser  user  =  list.get(0);
			if (user.getPassword().equals(oldpassword)) {
				user.setPassword(new SimpleHash("SHA-1", "MD5", pd.getString("password")).toString());
				sysUserMapper.updateByPrimaryKey(user);
				result.put("status", 0);
				result.put("msg", "修改成功");
			} else {
				result.put("status", 1);
				result.put("msg", "原密码错误");
			}
		}
		return result;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void offDuty(PageData pd) throws Exception {
		dao.delete("UserMapper.offDuty", pd);
	}

	public boolean getAuthority(Map<String, Object> paramMap) throws Exception {
		NjUserInfoMapperExtend extend = dao.getMapper(NjUserInfoMapperExtend.class);
		Integer count = extend.getAuthority(paramMap);
		return count == null ? false:count >0;
	}


	public List<NjUserInfo> selectListByCompanyId(PageData pd) throws Exception {
		NjUserInfoMapperExtend extend = dao.getMapper(NjUserInfoMapperExtend.class);
		return extend.selectListByCompanyId(pd);
	}
	
	public NjUserInfo getUserInfoById(String userId) throws Exception{
		NjUserInfoMapper mapper = dao.getMapper(NjUserInfoMapper.class);
		return mapper.selectByPrimaryKey(userId);
	}

}