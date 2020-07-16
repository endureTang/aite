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
import com.nj.dao.NjStrategyMapper;
import com.nj.model.generate.NjStrategy;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.Map.Entry;

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

    public List<NjStrategy> list(PageData pd){
		return njStrategyMapper.selectByExample(null);
	}

	public int listAllCount(PageData pd) {
		return njStrategyMapper.countByExample(null);
	}

	public NjStrategy getById(String id) {
		return njStrategyMapper.selectByPrimaryKey(id);
	}
}
