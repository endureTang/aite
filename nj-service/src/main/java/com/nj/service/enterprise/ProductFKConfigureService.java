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

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjCorpProdMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.NjProductScopeMapper;
import com.nj.dao.NjProductTacticsFilterMapper;
import com.nj.dao.NjProductTacticsPropertyMapper;
import com.nj.dao.NjProductTaticsRelationMapper;
import com.nj.dao.NjProductTempMapper;
import com.nj.dao.NjProductUserMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.SysUserMapper;
import com.nj.dao.extend.NjProductMapperExtend;
import com.nj.dao.extend.NjProductTacticsPropertyMapperExtend;
import com.nj.dao.extend.NjProductUserMapperExtend;
import com.nj.model.generate.SysDictExample;
import com.nj.model.generate.NjCorpProd;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductScope;
import com.nj.model.generate.NjProductScopeExample;
import com.nj.model.generate.NjProductTacticsFilter;
import com.nj.model.generate.NjProductTacticsFilterExample;
import com.nj.model.generate.NjProductTacticsProperty;
import com.nj.model.generate.NjProductTaticsRelation;
import com.nj.model.generate.NjProductTemp;
import com.nj.model.generate.NjProductUser;
import com.nj.model.generate.NjProductUserExample;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysUser;
import com.nj.model.generate.SysDictExample.Criteria;

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
@Service("productFKConfigureService")
public class ProductFKConfigureService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void addAll(NjProductTacticsFilter filter,NjProductTacticsProperty property) throws Exception {

		filter.setId(UuidUtil.get32UUID());
		property.setId(UuidUtil.get32UUID());
		
		NjProductTacticsFilterMapper sm = dao.getMapper(NjProductTacticsFilterMapper.class);
		sm.insert(filter);
		
		NjProductTacticsPropertyMapper sm1 = dao.getMapper(NjProductTacticsPropertyMapper.class);
		sm1.insert(property);
		
		NjProductTaticsRelation rel = new NjProductTaticsRelation();
		rel.setId(UuidUtil.get32UUID());
		rel.setFilterId(filter.getId());
		rel.setPropertyId(property.getId());
		
		NjProductTaticsRelationMapper sm2 = dao.getMapper(NjProductTaticsRelationMapper.class);
		sm2.insert(rel);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void updateAll(NjProductTacticsFilter filter,NjProductTacticsProperty property) throws Exception {

		NjProductTacticsFilterMapper sm = dao.getMapper(NjProductTacticsFilterMapper.class);
		sm.updateByPrimaryKeySelective(filter);
		
		NjProductTacticsPropertyMapper sm1 = dao.getMapper(NjProductTacticsPropertyMapper.class);
		sm1.updateByPrimaryKeySelective(property);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public NjProductTacticsFilter getNjProductTacticsFilter(String productId) throws Exception {

		NjProductTacticsFilterMapper sm = dao.getMapper(NjProductTacticsFilterMapper.class);

		NjProductTacticsFilterExample example = new NjProductTacticsFilterExample();
		com.nj.model.generate.NjProductTacticsFilterExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		List<NjProductTacticsFilter> list = sm.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public NjProductTacticsProperty getNjProductTacticsProperty(PageData pd) throws Exception {
		NjProductTacticsPropertyMapperExtend sm = dao.getMapper(NjProductTacticsPropertyMapperExtend.class);
		return sm.getByProductId(pd);
	}
	
}
