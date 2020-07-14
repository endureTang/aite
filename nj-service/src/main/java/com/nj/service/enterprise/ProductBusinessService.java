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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.AppUtil;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjAcceptThresholdsMapper;
import com.nj.dao.NjChannelRelativeMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.dao.NjProductCycleMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.NjProductParaMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.SysUserMapper;
import com.nj.dao.extend.NjChannelRelativeMapperExtend;
import com.nj.dao.extend.NjProductChannelMapperExtend;
import com.nj.model.generate.NjAcceptThresholds;
import com.nj.model.generate.NjChannelRelative;
import com.nj.model.generate.NjChannelRelativeExample;
import com.nj.model.generate.NjChannelRelativeExample.Criteria;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import com.nj.model.generate.NjProductCycle;
import com.nj.model.generate.NjProductCycleExample;
import com.nj.model.generate.NjProductPara;
import com.nj.model.generate.NjProductParaExample;
import com.nj.model.generate.NjAcceptThresholdsExample;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysUser;

/**
 * @FileName RoleService.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional(readOnly=true)
@Service("productBusinessService")
public class ProductBusinessService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void saveAll(List<NjAcceptThresholds> list,NjProductPara npp,List<NjProductCycle> list1,String productId) throws Exception {
		
//		SysUser user = new SysUser();
//		user.setId("1");
//		
//		product.setId(UuidUtil.get32UUID());
//		product.setCreateBy(user.getId());
//		product.setCreateDate(new Date());
//		product.setUpdateBy(user.getId());
//		product.setUpdateDate(new Date());
//		product.setDelFlag(false);
		
		
		NjAcceptThresholdsMapper sm = dao.getMapper(NjAcceptThresholdsMapper.class);
		NjAcceptThresholdsExample example = new NjAcceptThresholdsExample();
		com.nj.model.generate.NjAcceptThresholdsExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		sm.deleteByExample(example);
		
		for (NjAcceptThresholds njProductCycle : list) {
			sm.insert(njProductCycle);
		}
		
		NjProductParaMapper sm1 = dao.getMapper(NjProductParaMapper.class);
		NjProductParaExample example1 = new NjProductParaExample();
		com.nj.model.generate.NjProductParaExample.Criteria criteria1 = example1.createCriteria();
		criteria1.andProductIdEqualTo(productId);
		sm1.deleteByExample(example1);
		sm1.insert(npp);
		
		NjProductCycleMapper sm2 = dao.getMapper(NjProductCycleMapper.class);
		NjProductCycleExample example2 = new NjProductCycleExample();
		com.nj.model.generate.NjProductCycleExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andProductIdEqualTo(productId);
		sm2.deleteByExample(example2);
		
		for (NjProductCycle njProductCycle : list1) {
			sm2.insert(njProductCycle);
		}
	}

	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void deleteById(String id) throws Exception {
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		sm.delete(id);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public List<NjAcceptThresholds>  getAcceptThresholdsList(String productId) throws Exception {

		NjAcceptThresholdsMapper sm = dao.getMapper(NjAcceptThresholdsMapper.class);
		
		NjAcceptThresholdsExample example = new NjAcceptThresholdsExample();
		com.nj.model.generate.NjAcceptThresholdsExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		
		return sm.selectByExample(example);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public NjProductPara  getProductPara(String productId) throws Exception {

		NjProductParaMapper sm = dao.getMapper(NjProductParaMapper.class);
		
		NjProductParaExample example = new NjProductParaExample();
		com.nj.model.generate.NjProductParaExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		List<NjProductPara> list = sm.selectByExample(example);
		
		if(list != null && list.size() != 0){
			return list.get(0);
		}
		return null;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public List<NjProductCycle>  getProductCycleList(String productId) throws Exception {

		NjProductCycleMapper sm = dao.getMapper(NjProductCycleMapper.class);
		
		NjProductCycleExample example = new NjProductCycleExample();
		com.nj.model.generate.NjProductCycleExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
//		example.getOrderByClause(" ");
		return sm.selectByExample(example);
	}
}
