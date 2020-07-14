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
import com.nj.dao.NjProductAreaMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.dao.NjProductTypeMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.SysUserMapper;
import com.nj.dao.extend.NjChannelRelativeMapperExtend;
import com.nj.dao.extend.NjProductChannelMapperExtend;
import com.nj.dao.extend.NjProductMapperExtend;
import com.nj.model.generate.NjAcceptThresholds;
import com.nj.model.generate.NjAcceptThresholdsExample;
import com.nj.model.generate.NjChannelRelative;
import com.nj.model.generate.NjChannelRelativeExample;
import com.nj.model.generate.NjChannelRelativeExample.Criteria;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductArea;
import com.nj.model.generate.NjProductAreaExample;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import com.nj.model.generate.NjProductCycleExample;
import com.nj.model.generate.NjProductType;
import com.nj.model.generate.NjProductTypeExample;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductType;
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
@Service("productPublishService")
public class ProductPublishService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void saveAll(List<NjProductArea> list,NjProduct npp,List<NjProductType> list1) throws Exception {
		
//		SysUser user = new SysUser();
//		user.setId("1");
//		
//		product.setId(UuidUtil.get32UUID());
//		product.setCreateBy(user.getId());
//		product.setCreateDate(new Date());
//		product.setUpdateBy(user.getId());
//		product.setUpdateDate(new Date());
//		product.setDelFlag(false);
		
		
		
		
		NjProductAreaMapper sm = dao.getMapper(NjProductAreaMapper.class);
		
		NjProductAreaExample example = new NjProductAreaExample();
		com.nj.model.generate.NjProductAreaExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(npp.getId());
		sm.deleteByExample(example);
		
		for (NjProductArea njProductCycle : list) {
			sm.insert(njProductCycle);
		}
		
		NjProductMapperExtend sm1 = dao.getMapper(NjProductMapperExtend.class);
		int state = sm1.getProductState(npp.getId());
		if(state != 0){
			npp.setState(null);
		}
		sm1.updateVisiableScope(npp);
		
		NjProductTypeMapper sm2 = dao.getMapper(NjProductTypeMapper.class);
		NjProductTypeExample example2 = new NjProductTypeExample();
		com.nj.model.generate.NjProductTypeExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andProductIdEqualTo(npp.getId());
		sm2.deleteByExample(example2);
		
		for (NjProductType njProductCycle : list1) {
			sm2.insert(njProductCycle);
		}
	}
	
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public List<NjProductArea> getNjProductAreaList(String productId) throws Exception {

		NjProductAreaMapper sm = dao.getMapper(NjProductAreaMapper.class);
		
		NjProductAreaExample example = new NjProductAreaExample();
		com.nj.model.generate.NjProductAreaExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		
		return sm.selectByExample(example);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public NjProduct getNjProduct(String productId) throws Exception {

		NjProductMapper sm = dao.getMapper(NjProductMapper.class);
		return sm.selectByPrimaryKey(productId);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public List<NjProductType> getNjProductTypeList(String productId) throws Exception {

		NjProductTypeMapper sm = dao.getMapper(NjProductTypeMapper.class);
		
		NjProductTypeExample example = new NjProductTypeExample();
		com.nj.model.generate.NjProductTypeExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		
		return sm.selectByExample(example);
	}

	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void deleteById(String id) throws Exception {
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		sm.delete(id);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void bindChannel(PageData pd) throws Exception {
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		sm.bindChannel(pd);
	}
	
	

}
