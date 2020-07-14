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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.Map2Bean;
import com.nj.core.base.util.PageData;
import com.nj.dao.NjChannelUserMapper;
import com.nj.dao.NjCoporateUserMapper;
import com.nj.dao.NjProductUserMapper;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.SysUserRoleMapper;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.dao.extend.SysRoleMapperExtend;
import com.nj.model.generate.NjChannelUser;
import com.nj.model.generate.NjChannelUserExample;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjProductUser;
import com.nj.model.generate.NjProductUserExample;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysUserRole;
import com.nj.model.generate.SysUserRoleExample;

@Transactional(readOnly = true)
@Service("userRoleService")
public class UserRoleService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	private static Logger logger = LoggerFactory.getLogger(UserRoleService.class);
	
	/*
	 * 根据用户id获取用户角色信息
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void add(PageData pd) throws Exception {
		
		//创建公司
		SysUserRoleMapper srm = dao.getMapper(SysUserRoleMapper.class);
		SysUserRole surBean = new SysUserRole();
		Map2Bean.transMap2Bean(pd, surBean);
		
		srm.insert(surBean);
	}
	
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void delete(PageData pd) throws Exception {
		
		//创建公司
		SysUserRoleMapper srm = dao.getMapper(SysUserRoleMapper.class);
		
		SysUserRoleExample example = new SysUserRoleExample();
		example.createCriteria().andIdEqualTo(pd.getString("id"));
		
		srm.deleteByExample(example);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void deleteByUserId(String userId) throws Exception{
		SysUserRoleMapper srm = dao.getMapper(SysUserRoleMapper.class);
		
		SysUserRoleExample example = new SysUserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		
		srm.deleteByExample(example);
	}
	
	/**
	 * 查询指定企业内指定角色类型的用户
	 */
	public List<Map> getUserByRoleTypeCoporateId(String roleType,String coporateId) throws Exception{
		SysRoleMapperExtend mapper = dao.getMapper(SysRoleMapperExtend.class);
		return mapper.getUserByRoleTypeCoporateId(roleType, coporateId);
	}
	
	/**
	 * 保存用户、用户和角色的关联数据
	 */
	@Transactional(rollbackFor={Throwable.class})
	public void saveDate(NjUserInfo user,List<SysUserRole> urList,List<NjProductUser> pUserLsit,List<NjChannelUser> cuList,NjCoporateUser cu) throws Exception{
		if(!CollectionUtils.isEmpty(urList)){
			for (SysUserRole sysUserRole : urList) {
				SysUserRoleMapper srm = dao.getMapper(SysUserRoleMapper.class);
				srm.insert(sysUserRole);
			}
		}
		if(null != user){
			NjUserInfoMapper userMapper = dao.getMapper(NjUserInfoMapper.class);
			userMapper.insert(user);
		}
		if(!CollectionUtils.isEmpty(pUserLsit)){
			NjProductUserMapper puserMapper = dao.getMapper(NjProductUserMapper.class);
			for (NjProductUser njProductUser : pUserLsit) {
				puserMapper.insert(njProductUser);
			}
		}
		if(!CollectionUtils.isEmpty(cuList)){
			NjChannelUserMapper cuMapper = dao.getMapper(NjChannelUserMapper.class);
			for (NjChannelUser njChannelUser : cuList) {
				cuMapper.insert(njChannelUser);
			}
		}
		if(null != cu){
			NjCoporateUserMapper cuMapper = dao.getMapper(NjCoporateUserMapper.class);
			cuMapper.insert(cu);
		}
	}
	
	/**
	 * 账户管理编辑页面获取数据
	 */
	public Map getUserEditData(String userId) throws Exception{
		NjUserInfoMapperExtend mapper = dao.getMapper(NjUserInfoMapperExtend.class);
		return mapper.getUserRoleInfo(userId);
	}
	
	/**
	 * 账户管理编辑页面保存数据
	 */
	@Transactional(rollbackFor={Throwable.class})
	public void userEditSave(NjUserInfo user,List<SysUserRole> insertList,List<NjProductUser> insertPUserList,List<NjChannelUser> insertCcuList) throws Exception{
		NjUserInfoMapper uiMapper = dao.getMapper(NjUserInfoMapper.class);
		uiMapper.updateByPrimaryKey(user);
		
		deleteByUserId(user.getId());
		
		if(!CollectionUtils.isEmpty(insertList)){
			for (SysUserRole sysUserRole : insertList) {
				SysUserRoleMapper srm = dao.getMapper(SysUserRoleMapper.class);
				srm.insert(sysUserRole);
			}
		}
		
		NjProductUserMapper puMapper = dao.getMapper(NjProductUserMapper.class);
		NjProductUserExample example = new NjProductUserExample();
		example.createCriteria().andUserIdEqualTo(user.getId());
		puMapper.deleteByExample(example);
		if(!CollectionUtils.isEmpty(insertPUserList)){
			for (NjProductUser njProductUser : insertPUserList) {
				puMapper.insert(njProductUser);
			}
		}
		
		
		NjChannelUserMapper cuMapper = dao.getMapper(NjChannelUserMapper.class);
		NjChannelUserExample example2 = new NjChannelUserExample();
		example2.createCriteria().andUserInfoIdEqualTo(user.getId());
		cuMapper.deleteByExample(example2);
		if(!CollectionUtils.isEmpty(insertCcuList)){
			for (NjChannelUser njChannelUser : insertCcuList) {
				cuMapper.insert(njChannelUser);
			}
		}
	}
}
