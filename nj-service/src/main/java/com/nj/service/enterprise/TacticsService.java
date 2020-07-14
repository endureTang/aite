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

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.dao.extend.NjProductTacticsPropertyMapperExtend;

@Transactional(readOnly = true)
@Service("tacticsService")
public class TacticsService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	private static Logger logger = LoggerFactory.getLogger(TacticsService.class);
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	@SuppressWarnings("rawtypes")
	public Map getTacticsByProdId(String productId) throws Exception {
		
		NjProductTacticsPropertyMapperExtend mapper = dao.getMapper(NjProductTacticsPropertyMapperExtend.class);
		PageData input = new PageData();
		input.put("productId", productId);
		List<Map> results = mapper.getTacticsByProdId(input);
		if(results.size() > 0){
			return results.get(0);
		}
		return null;
	}
	
}