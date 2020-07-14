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
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.util.Constants;
import com.nj.core.base.util.Map2Bean;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjCoporateMapper;
import com.nj.dao.NjCoporateUserMapper;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.SysUserRoleMapper;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateExample;
import com.nj.model.generate.NjCoporateExample.Criteria;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.NjUserInfoExample;
import com.nj.model.generate.SysUserRole;

@Transactional(readOnly = true)
@Service("enterpriseService")
public class EnterpriseService extends BaseCachesService {

/*	@Resource(name = "BaseDao")
	private BaseDao dao;*/

	private static Logger logger = LoggerFactory.getLogger(EnterpriseService.class);
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	public PageData getAcctByRole(PageData pd) throws Exception {
		
		//创建公司
		NjUserInfoMapperExtend njUserInfoDaoExd = dao.getMapper(NjUserInfoMapperExtend.class);
		List<Map> results = njUserInfoDaoExd.selectUserByRole(pd);
		PageData pd1 = new PageData();
		pd1.put("result", results);
		pd1.put("count", results.size());
		return pd1;
	}
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	public PageData getAcctInfo(PageData pd) throws Exception {
		
		//创建公司
		NjUserInfoMapperExtend njUserInfoDaoExd = dao.getMapper(NjUserInfoMapperExtend.class);
		List<Map> results = njUserInfoDaoExd.selectByCondition(pd);
		PageData pd1 = new PageData();
		pd1.put("result", results);
		pd1.put("count", results.size());
		return pd1;
	}
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	public PageData getAllAcctByCoporate(PageData pd) throws Exception {
		
		//创建公司
		NjUserInfoMapperExtend njUserInfoDaoExd = dao.getMapper(NjUserInfoMapperExtend.class);
		int count = njUserInfoDaoExd.selectAllAccountCount(pd);
		List<Map> results = njUserInfoDaoExd.selectAllAccount(pd);
		PageData pd1 = new PageData();
		
		pd1.put(Constants.Datas.RECORDSFILTERED, count);
		pd1.put(Constants.Datas.NDATA, results);
		return pd1;
	}
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	public PageData getAllCoporateUser(PageData pd) throws Exception {
		
		//创建公司
		NjUserInfoMapperExtend njUserInfoDaoExd = dao.getMapper(NjUserInfoMapperExtend.class);
		List<Map> results = njUserInfoDaoExd.selectCoporateAccount(pd);
		PageData pd1 = new PageData();
		
		pd1.put(Constants.Datas.RECORDSFILTERED, results.size());
		pd1.put(Constants.Datas.NDATA, results);
		
		return pd1;
	}
	
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	public PageData getVerifiedAcctByCoporate(PageData pd) throws Exception {
		
		//创建公司
		NjUserInfoMapperExtend njUserInfoDaoExd = dao.getMapper(NjUserInfoMapperExtend.class);
		List<Map> countList = njUserInfoDaoExd.selectVerifiedAccountCount(pd);
		List<Map> results = njUserInfoDaoExd.selectVerifiedAccount(pd);
		PageData pd1 = new PageData();
		
		pd1.put(Constants.Datas.RECORDSFILTERED, countList.size());
		pd1.put(Constants.Datas.NDATA, results);
		return pd1;
	}

	
	/*
	 * 企业端完善个人信息 save or update
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserInfo createAcctInfo(PageData pd) throws Exception {
		
		NjUserInfoMapper njUserInfoDao = dao.getMapper(NjUserInfoMapper.class);
		
		NjUserInfo userInfoBean = new NjUserInfo();
		Map2Bean.transMapToNewBean(pd, userInfoBean);
		njUserInfoDao.insert(userInfoBean);
		
		return userInfoBean;
	}
	

	/*
	 * 企业端完善或更新个人信息
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserInfo updateAcctInfo(PageData pd) throws Exception {
		
		//创建公司
		NjUserInfoMapper njUserInfoDao = dao.getMapper(NjUserInfoMapper.class);
		NjUserInfoExample example = new NjUserInfoExample();
		example.createCriteria().andIdEqualTo(pd.getString("id"));
		NjUserInfo userInfoBean = new NjUserInfo();
		Map2Bean.transMapToNewBean(pd, userInfoBean);
		njUserInfoDao.updateByExampleSelective(userInfoBean, example);
		
		return userInfoBean;
	}
	
	/**
	 * 创建公司前的验证
	 * @throws Exception 
	 */
	@Transactional(readOnly=true)
	public PageData validateForCreateCoporate(PageData pd) throws Exception{
		NjCoporateMapper njCoporateDao = dao.getMapper(NjCoporateMapper.class);
		
		NjCoporateExample copoExampleForName = new NjCoporateExample();
		Criteria criteria = copoExampleForName.createCriteria();
		criteria.andCompanNameEqualTo(pd.getString("companyName"));
		List<NjCoporate> copoList = njCoporateDao.selectByExample(copoExampleForName);
		
		PageData result = new PageData();
		if(copoList.size() > 0){
			result.put("status", 1);
			result.put("errorMsg", "当前公司名称已经存在!");
		}else{
			result.put("status", 0);
			result.put("errorMsg", "");
		}
		
		return result;
	}
	
	/*
	 * 创建公司
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjCoporate create(PageData pd) throws Exception {
		
		//创建公司
		NjCoporateMapper njCoporateDao = dao.getMapper(NjCoporateMapper.class);
		NjCoporate coporateBean = new NjCoporate();
		Map2Bean.transMapToNewBean(pd, coporateBean);
		coporateBean.setId(UuidUtil.get32UUID());
		coporateBean.setCreateBy(pd.getString("userMobile"));
		coporateBean.setCreateDate(new Date());
		coporateBean.setDelFlag(false);
		njCoporateDao.insert(coporateBean);
		
		String userId  = pd.getString("userId");
		//跟新用户公司关系
		NjCoporateUserMapper njcoporateUserDao = dao.getMapper(NjCoporateUserMapper.class);
		NjCoporateUser nCoprateUser = new NjCoporateUser();
		nCoprateUser.setCoporateId(coporateBean.getId());
		nCoprateUser.setUserId(pd.getString("userId"));
		nCoprateUser.setId(UuidUtil.get32UUID());
		nCoprateUser.setState(0);
		njcoporateUserDao.insert(nCoprateUser);
		
		//更新用户角色
		SysUserRoleMapper njRoleDao = dao.getMapper(SysUserRoleMapper.class);
		SysUserRole userRole = new SysUserRole();
		userRole.setUserId(pd.getString("userId"));
		userRole.setCoporateId(coporateBean.getId());
		//根据key拉取角色id
		userRole.setRoleId(pd.getString("roleId"));
		userRole.setId(UuidUtil.get32UUID());
		njRoleDao.insert(userRole);
		
		return coporateBean;
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void join(PageData pd) throws Exception {
//		NjUserInfoMapper njUserDao = dao.getMapper(NjUserInfoMapper.class);
//		NjUserInfo userBean = new NjUserInfo();

//		Map2Bean.transMapToNewBean(pd, userBean);
//		njUserDao.insert(userBean);
		//角色待企业管理员审核后分配
		
		//跟新用户公司关系
		NjCoporateUserMapper njcoporateUserDao = dao.getMapper(NjCoporateUserMapper.class);
		NjCoporateUser nCoprateUser = new NjCoporateUser();
		nCoprateUser.setCoporateId(pd.getString("coporateId"));
		nCoprateUser.setUserId(pd.getString("userId"));
		nCoprateUser.setId(UuidUtil.get32UUID());
		nCoprateUser.setState(0);
		njcoporateUserDao.insert(nCoprateUser);

	}
	
	/*
	 * **********账户审核start**************
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void decline(String ids) throws Exception {
		NjUserInfoMapperExtend njUserDao = dao.getMapper(NjUserInfoMapperExtend.class);
		if (StringUtils.isNotEmptyAndNull(ids)) {
			String[] idArr = ids.split(",");
			if (idArr.length > 0) {
				List<String> idList = new ArrayList<String>();
				for (String idStr : idArr) {
					idList.add(String.valueOf(idStr));
				}
				njUserDao.decline(idList);
			}
		}
		
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void accept(String ids) throws Exception {
		NjUserInfoMapperExtend njUserDao = dao.getMapper(NjUserInfoMapperExtend.class);
		if (StringUtils.isNotEmptyAndNull(ids)) {
			String[] idArr = ids.split(",");
			if (idArr.length > 0) {
				List<String> idList = new ArrayList<String>();
				for (String idStr : idArr) {
					idList.add(String.valueOf(idStr));
				}
				njUserDao.accept(idList);
			}
		}
		
	}
	/*
	 * *********账户审核end
	 */
}
