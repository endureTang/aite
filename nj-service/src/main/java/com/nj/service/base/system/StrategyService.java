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

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjStrategyMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.generate.NjStrategy;
import com.nj.model.generate.SysDictExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @FileName RoleService.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional
@Service("strategyService")
public class StrategyService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
    @Resource
    private NjStrategyMapper njStrategyMapper;

	@Resource
	private NjStrategyMapperExtend njStrategyMapperExtend;

    public List<NjStrategy> list(PageData pd) throws Exception{
		if(pd != null){
			pd.put("start", pd.getInteger("start"));
			pd.put("length", pd.getInteger("length"));
		}
		return njStrategyMapperExtend.selectPage(pd);
	}

	public long listAllCount(PageData pd) throws Exception{
		return njStrategyMapper.countByExample(null);
	}

	public NjStrategy getById(String id) throws Exception{
		return njStrategyMapper.selectByPrimaryKey(id);
	}

	public void add(NjStrategy njStrategy) throws Exception{
    	njStrategy.setId(UuidUtil.get32UUID());
		njStrategyMapper.insertSelective(njStrategy);
	}

    public void edit(NjStrategy njStrategy) {
		njStrategyMapper.updateByPrimaryKeySelective(njStrategy);
    }

	public Integer delete(String id) {
		return njStrategyMapper.deleteByPrimaryKey(id);
	}
}
