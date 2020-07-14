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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjProductScopeExample;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysRole;
import com.nj.model.generate.SysRoleExample;
import com.nj.model.generate.SysUserRole;
import com.nj.core.base.util.Map2Bean;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjCoporateMapper;
import com.nj.dao.NjCoporateUserMapper;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.SysRoleMapper;
import com.nj.dao.SysUserRoleMapper;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.dao.extend.SysRoleMapperExtend;
import com.nj.core.base.util.Constants;

@Transactional(readOnly = true)
@Service("njRoleService")
public class RoleService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	private static Logger logger = LoggerFactory.getLogger(RoleService.class);
	
	/*
	 * 根据用户id获取用户角色信息
	 */
	public PageData getUserRoles(PageData pd) throws Exception {
		
		//创建公司
		SysRoleMapperExtend roleDaoExd = dao.getMapper(SysRoleMapperExtend.class);
		List<Map> results = roleDaoExd.findNjUserRolesByUserId(pd);
		PageData pd1 = new PageData();
		pd1.put(Constants.Datas.RECORDSTOTAL, results.size());
		pd1.put(Constants.Datas.RECORDSFILTERED, results.size());
		pd1.put(Constants.Datas.NDATA, results);
		return pd1;
	}
	
	public List<Map> getUserRoleList(PageData pd) throws Exception {
		
		//创建公司
		SysRoleMapperExtend roleDaoExd = dao.getMapper(SysRoleMapperExtend.class);
		List<Map> results = roleDaoExd.findNjUserRolesByUserId(pd);
		return results;
	}
	/*
	 * 根据用户id获取用户所在产品归属的角色
	 */
	public PageData getUserProdRoles(PageData pd) throws Exception {
		
		//创建公司
		SysRoleMapperExtend roleDaoExd = dao.getMapper(SysRoleMapperExtend.class);
		List<Map> results = roleDaoExd.findNjUserProdRolesByUserId(pd);
		PageData pd1 = new PageData();
		pd1.put(Constants.Datas.RECORDSTOTAL, results.size());
		pd1.put(Constants.Datas.RECORDSFILTERED, results.size());
		pd1.put(Constants.Datas.NDATA, results);
		return pd1;
	}
	
	public List<Map> getUserProdRoleList(PageData pd) throws Exception {
		
		//创建公司
		SysRoleMapperExtend roleDaoExd = dao.getMapper(SysRoleMapperExtend.class);
		List<Map> results = roleDaoExd.findNjUserProdRolesByUserId(pd);
		return results;
	}
	
	public List<Map> getUserFlowRoleList(PageData pd) throws Exception {
		
		//创建公司
		SysRoleMapperExtend roleDaoExd = dao.getMapper(SysRoleMapperExtend.class);
		List<Map> results = roleDaoExd.findNjUserFlowsRolesByUserId(pd);
		return results;
	}

	/*
	 * 获取用户未分配的角色
	 */
	public List<SysRole> getAssignableRolesByUser(PageData pd) throws Exception {
		
		//创建公司
		SysRoleMapperExtend roleDaoExd = dao.getMapper(SysRoleMapperExtend.class);
		List<SysRole> results = roleDaoExd.findAssignableRolesByUserId(pd);
		PageData pd1 = new PageData();
		
		return results;
	}
	
	/*
	 * 获取用户未分配的角色
	 */
	public List<SysRole> getRolesByRoleType(List<String> list) throws Exception {
		
		List<SysRole> data = new ArrayList<>();
		
		//创建公司
		SysRoleMapper sm = dao.getMapper(SysRoleMapper.class);
		if(list != null)
		for(String type : list){
			SysRoleExample example = new SysRoleExample();
			com.nj.model.generate.SysRoleExample.Criteria criteria = example.createCriteria();
			criteria.andRoleTypeEqualTo(type);
			List<SysRole> rList = sm.selectByExample(example);
			if(rList != null && rList.size() > 0){
				data.add(rList.get(0));
//				data.addAll(rList);
			}
		}
		return data;
	}
	
	public List<SysRole> getRolesByOfficeId(String officeId) throws Exception{
		SysRoleMapper mapper = dao.getMapper(SysRoleMapper.class);
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andOfficeIdEqualTo(officeId).andDelFlagEqualTo(false).andTypeEqualTo(2);	//业务后台
		example.setOrderByClause("id");
		return mapper.selectByExample(example);
	}
}
