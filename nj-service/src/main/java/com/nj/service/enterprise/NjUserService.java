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

package com.nj.service.enterprise;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.enums.ERoleType;
import com.nj.core.base.util.Map2Bean;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.dao.NjCoporateUserMapper;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.SysUserRoleMapper;
import com.nj.dao.extend.NjCoporateMapperExtend;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.dao.extend.SysRoleMapperExtend;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjCoporateUserExample;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.NjUserInfoExample;
import com.nj.model.generate.NjUserInfoExample.Criteria;
import com.nj.model.generate.SysUserRole;
import com.nj.model.generate.SysUserRoleExample;

@Transactional
@Service("njUserService")
public class NjUserService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	
	@Resource
	private NjUserInfoMapper  njUserMapper;

	private static Logger logger = LoggerFactory.getLogger(NjUserService.class);
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	@SuppressWarnings("rawtypes")
	public PageData getJoinedCompany(PageData pd) throws Exception {
		
		NjUserInfoMapperExtend njUserInfoDaoExd = dao.getMapper(NjUserInfoMapperExtend.class);
		List<Map> results = njUserInfoDaoExd.selectJoinedCompany(pd);
		PageData pd1 = new PageData();
		pd1.put("result", results);
		pd1.put("count", results.size());
		return pd1;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getJoinAbleCompanyList(PageData pd) throws Exception {
		
		NjUserInfoMapperExtend daoMapper = dao.getMapper(NjUserInfoMapperExtend.class);
		
		
		List<Map> results = daoMapper.selectJoinAbleCompany(pd);
		
//		PageData pd1 = new PageData();
//		pd1.put("result", results);
//		pd1.put("count", results.size());
		return results;
	}
	/*
	 * 设置为默认公司
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void setDefaultCompany(PageData pd) throws Exception {
		NjUserInfoMapperExtend njUserInfoDao= dao.getMapper(NjUserInfoMapperExtend.class);
		
		//批量update
		njUserInfoDao.updateDefaultLogin(pd);
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateUserInfo(PageData pd) throws Exception {
		NjUserInfoMapper mapperDao= dao.getMapper(NjUserInfoMapper.class);
		NjUserInfo ni = new NjUserInfo();
		Map2Bean.transMap2Bean(pd, ni);
		
		NjUserInfoExample nie = new NjUserInfoExample();
		nie.createCriteria().andIdEqualTo(pd.getString("userId"));
		//批量update
		mapperDao.updateByExampleSelective(ni, nie);
//		mapperDao.updateByPrimaryKey(ni);
	}
	
	public NjUserInfo getNjUserInfo(PageData pd) throws Exception {
		NjUserInfoMapper mapperDao= dao.getMapper(NjUserInfoMapper.class);
		NjUserInfoExample example = new NjUserInfoExample();
		Criteria cretia = example.createCriteria();
		
		String mobile = pd.getString("userMobile");
		String userId = pd.getString("userId");
		if(StringUtils.isNotEmptyAndNull(mobile)){
			cretia.andUserMobileEqualTo(mobile);
		}
		if(StringUtils.isNotEmptyAndNull(userId)){
			cretia.andIdEqualTo(userId);
		}
		
		List<NjUserInfo> users = mapperDao.selectByExample(example);
		return users.size()>0? users.get(0): null;
	}
	
	public List<Map> getUserAttachments(PageData condition) throws Exception {
		NjUserInfoMapperExtend mapperDao= dao.getMapper(NjUserInfoMapperExtend.class);
		List<Map> attachments = mapperDao.getUserAttachments(condition);
		return attachments;
	}
	
	/*
	 * 绑定公司的第三方财富
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	@SuppressWarnings("rawtypes")
	public void bindAccount(PageData pd) throws Exception {
		
		NjUserInfoMapper daoMapper = dao.getMapper(NjUserInfoMapper.class);
		
		NjUserInfoExample example = new NjUserInfoExample();
		example.createCriteria().andIdEqualTo(pd.getString("userId"));
		
		NjUserInfo record = new NjUserInfo();
		record.setOpenUserId(pd.getString("openUserId"));
		logger.debug("record" + record.getOpenUserId());
		daoMapper.updateByExampleSelective(record, example);
		
		//跟新用户公司关系
		NjCoporateMapperExtend njcoporateUserDao = dao.getMapper(NjCoporateMapperExtend.class);
		pd.put("applyDate", new Date());
		njcoporateUserDao.update(pd);
	}
	
	/**
	 * 判断用户在当前公司是否为管理员
	 * @param coporateId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean isAdminUser(String coporateId,String userId) throws Exception {
		SysUserRoleMapper mapperDao= dao.getMapper(SysUserRoleMapper.class);
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria cretia = example.createCriteria();
		cretia.andCoporateIdEqualTo(coporateId);
		cretia.andUserIdEqualTo(userId);
		
		List<SysUserRole> users = mapperDao.selectByExample(example);
		if(users != null && users.size() > 0){
			for (SysUserRole sysUserRole : users) {
				if("4".equals(sysUserRole.getRoleId())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断用户是否为超级管理员
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean isSysAdminUser(String userId) throws Exception {
		SysUserRoleMapper mapperDao= dao.getMapper(SysUserRoleMapper.class);
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria cretia = example.createCriteria();
		cretia.andUserIdEqualTo(userId);
		
		List<SysUserRole> users = mapperDao.selectByExample(example);
		if(users != null && users.size() > 0){
			for (SysUserRole sysUserRole : users) {
				if("1".equals(sysUserRole.getRoleId())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断用户是否为业务员
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean isSalesmanUser(String coporateId,String userId) throws Exception {
		SysUserRoleMapper mapperDao= dao.getMapper(SysUserRoleMapper.class);
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria cretia = example.createCriteria();
		cretia.andCoporateIdEqualTo(coporateId);
		cretia.andUserIdEqualTo(userId);
		
		List<SysUserRole> users = mapperDao.selectByExample(example);
		if(users != null && users.size() > 0){
			for (SysUserRole sysUserRole : users) {
				if("5".equals(sysUserRole.getRoleId())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断用户是否为业务主管
	 */
	public boolean isBusinessExecutive(String coporateId,String userId) throws Exception {
		SysUserRoleMapper mapperDao= dao.getMapper(SysUserRoleMapper.class);
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria cretia = example.createCriteria();
		cretia.andCoporateIdEqualTo(coporateId);
		cretia.andUserIdEqualTo(userId);
		
		List<SysUserRole> users = mapperDao.selectByExample(example);
		if(users != null && users.size() > 0){
			for (SysUserRole sysUserRole : users) {
				if("7".equals(sysUserRole.getRoleId())){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 获取用户企业id
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	public String getUserCoporateId(String userId) throws Exception {
		NjCoporateUserMapper mapper = dao.getMapper(NjCoporateUserMapper.class);
		NjCoporateUserExample example = new NjCoporateUserExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<NjCoporateUser> njUserInfo = mapper.selectByExample(example);
		if(njUserInfo != null && njUserInfo.size() > 0) {
			return njUserInfo.get(0).getCoporateId();
		}
		return null;
	}
	
	/**
	 * 获取企业的所有用户
	 */
	public List<Map> getCopoUserForAcctManagePage(Map<?, ?> param) throws Exception{
		NjUserInfoMapperExtend mapper = dao.getMapper(NjUserInfoMapperExtend.class);
		return mapper.getCopoUserForAcctManagePage(param);
	}
	
	/**
	 * 批量冻结账户
	 */
	@Transactional(rollbackFor={Throwable.class})
	public void deleteAcct(List<String> acctIdList) throws Exception{
		NjUserInfoMapper mapper = dao.getMapper(NjUserInfoMapper.class);
		if(!CollectionUtils.isEmpty(acctIdList)){
			for (String id : acctIdList) {
				NjUserInfo user = mapper.selectByPrimaryKey(id);
				user.setDelFlag(true);		//删除
				mapper.updateByPrimaryKey(user);
			}
		}
	}
	
	
	public  void  updateUser(NjUserInfo record){
		
		int updateByPrimaryKey = njUserMapper.updateByPrimaryKeySelective(record);
	}

	public String getUserRole(String id) throws Exception {
		SysRoleMapperExtend extend = dao.getMapper(SysRoleMapperExtend.class);
		return extend.selectRoleByUserId(id);
	}
	
	
	/**
	 * 通过手机号码查询用户
	 * @param mobile
	 * @return
	 */
	public NjUserInfo getUserInfoByMobile(String mobile){
		
		NjUserInfoExample example = new NjUserInfoExample();
		example.createCriteria().andUserMobileEqualTo(mobile);
		List<NjUserInfo> listUser = njUserMapper.selectByExample(example);
		if (listUser.size()>0) {
			return listUser.get(0);
		} else {
			return null;
		}
		
	}

	/**
	 * 获取企业下的所有客户经理
	 */
	public List<Map> getBusiCommForCoro(String coporateId) throws Exception{
		NjUserInfoMapperExtend mapper = dao.getMapper(NjUserInfoMapperExtend.class);
		return mapper.selectUserByRoleType(ERoleType.CUSTOMERMANAGER.getValue(), coporateId);
	}
}
