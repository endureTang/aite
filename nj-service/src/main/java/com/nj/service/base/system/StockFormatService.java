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
import com.nj.dao.StockFormatDictMapper;
import com.nj.dao.StockFormatMapper;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.datamodel.StockFormatDictForm;
import com.nj.model.datamodel.StockFormatForm;
import com.nj.model.generate.StockFormat;
import com.nj.model.generate.StockFormatDict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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
@Service("stockFormatService")
public class StockFormatService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
    @Resource
    private StockFormatMapper stockFormatMapper;
	@Resource
	private NjStrategyMapperExtend njStrategyMapperExtend;
	@Resource
	private StockFormatDictMapper stockFormatDictMapper;


	public List<StockFormat> list(PageData pd) {
		if(pd != null){
			pd.put("start", pd.getInteger("start"));
			pd.put("length", pd.getInteger("length"));
		}
		return njStrategyMapperExtend.selectPageStockFormat(pd);
	}

	public int listAllCount(PageData pd) {
		return stockFormatMapper.countByExample(null);
	}

	public void add(StockFormatForm stockFormatForm) {
		StockFormat stockFormat = new StockFormat();
		stockFormat.setName(stockFormatForm.getName());
		stockFormat.setStatus(stockFormatForm.getStatus());
		stockFormat.setId(UuidUtil.get32UUID());
		stockFormatMapper.insertSelective(stockFormat);
		List<StockFormatDictForm> stockFormatDictForms = stockFormatForm.getStockFormatDictList();
		for (StockFormatDictForm stockFormatDictForm : stockFormatDictForms) {
			StockFormatDict stockFormatDict = new StockFormatDict();
			stockFormatDict.setId(UuidUtil.get32UUID());
			stockFormatDict.setStockFormatId(stockFormat.getId());
			stockFormatDict.setColumName(stockFormatDictForm.getColumName());
			stockFormatDict.setDictId(stockFormatDictForm.getDictId());
			stockFormatDictMapper.insertSelective(stockFormatDict);
		}
	}

	public Integer delete(String id) {
		return stockFormatMapper.deleteByPrimaryKey(id);
	}
}
