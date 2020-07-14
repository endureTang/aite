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

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjCoporateMapper;
import com.nj.dao.NjCoporateUserMapper;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjCoporateUserExample;
import com.nj.model.generate.NjCoporateUserExample.Criteria;

@Transactional(readOnly = true)
@Service("njCoporateUserService")
public class NjCoporateUserService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	@Resource 
	private  NjCoporateUserMapper  njCoporateUserMapper;

	private static Logger logger = LoggerFactory.getLogger(NjCoporateUserService.class);

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void updateNCU(NjCoporateUser nUser) throws Exception {
		NjCoporateUserMapper mapper = dao.getMapper(NjCoporateUserMapper.class);
		NjCoporateUserExample example = new NjCoporateUserExample();
		Criteria criteria = example.createCriteria();
		String id = nUser.getId();
		String userId = nUser.getUserId();
		String coporateId = nUser.getCoporateId();

		if(StringUtils.isNotEmptyAndNull(userId)){
			criteria.andUserIdEqualTo(userId);
		}
		if(StringUtils.isNotEmptyAndNull(coporateId)){
			criteria.andCoporateIdEqualTo(coporateId);
		}
		nUser.setId(null);
		mapper.updateByExampleSelective(nUser, example);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void join(NjCoporateUser nCoprateUser) throws Exception {
		try{
			NjCoporateUserMapper njcoporateUserDao = dao.getMapper(NjCoporateUserMapper.class);
			nCoprateUser.setId(UuidUtil.get32UUID());
			nCoprateUser.setState(0);
			nCoprateUser.setApplyDate(new Date());
			njcoporateUserDao.insert(nCoprateUser);
		}catch(Exception e){
		}
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void delete(NjCoporateUser nUser) throws Exception {
		NjCoporateUserMapper mapper = dao.getMapper(NjCoporateUserMapper.class);
		NjCoporateUserExample example = new NjCoporateUserExample();
		Criteria criteria = example.createCriteria();
		
		String userId = nUser.getUserId();
		String coporateId = nUser.getCoporateId();
		
		criteria.andUserIdEqualTo(userId);
		criteria.andCoporateIdEqualTo(coporateId);

		mapper.deleteByExample(example);
	}

	public NjCoporate getCompanyById(String companyId) throws Exception {
		NjCoporateMapper coporateMapper = dao.getMapper(NjCoporateMapper.class);
		return coporateMapper.selectByPrimaryKey(companyId);
	}
	
	public  List<NjCoporateUser> selectByExample(NjCoporateUserExample example) throws Exception {
		
	 List<NjCoporateUser> list = njCoporateUserMapper.selectByExample(example );
	 return  list;
	}
}
