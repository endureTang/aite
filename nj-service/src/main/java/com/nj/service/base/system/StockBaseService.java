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
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.StockBaseMapper;
import com.nj.dao.StockFormatDictMapper;
import com.nj.dao.StockFormatMapper;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.datamodel.StockFormatDictForm;
import com.nj.model.datamodel.StockFormatForm;
import com.nj.model.generate.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
@Service("stockBaseService")
public class StockBaseService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
    @Resource
    private StockBaseMapper stockBaseMapper;
	@Resource
	private NjStrategyMapperExtend njStrategyMapperExtend;
	@Resource
	private StockFormatDictMapper stockFormatDictMapper;


	public List<StockBase> list(PageData pd) {
		if(pd != null){
			pd.put("start", pd.getInteger("start"));
			pd.put("length", pd.getInteger("length"));
		}
		return njStrategyMapperExtend.selectPageStockBase(pd);
	}

	public int listAllCount(PageData pd) {
		StockBaseExample stockBaseExample = new StockBaseExample();
		String keyword = pd.getString("keyword");
		if(StringUtils.isNotEmpty(keyword)){
			stockBaseExample.createCriteria().andStockNoEqualTo(keyword);
		}
		return stockBaseMapper.countByExample(stockBaseExample);
	}

	public void add(StockBase stockBase) {
		stockBase.setId(UuidUtil.get32UUID());
		stockBaseMapper.insertSelective(stockBase);
	}

	public Integer delete(String id) {
		return stockBaseMapper.deleteByPrimaryKey(id);
	}

	public StockBase getById(String id) {
		return stockBaseMapper.selectByPrimaryKey(id);
	}

	public void edit(StockBase stockBase) {
		String basePrice = stockBase.getBasePrice();
		String channelPrice = stockBase.getChannelPrice();
		if(StringUtils.isNumeric(basePrice) && StringUtils.isNumeric(channelPrice)){
			Double discount = new Double(basePrice) / new Double(channelPrice);
			BigDecimal bigDecimal = new BigDecimal(discount);
			bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
			stockBase.setDiscount(bigDecimal.toString());
		}
		stockBaseMapper.updateByPrimaryKeySelective(stockBase);
	}

	public void insertBath(ArrayList<StockBase> stockBases) {
		//导入ERP基础订单前，清理之前的数据
		stockBaseMapper.deleteByExample(null);
		for (StockBase stockBase : stockBases) {
			Double discount = new Double(stockBase.getBasePrice()) / new Double(stockBase.getChannelPrice());
			BigDecimal bigDecimal = new BigDecimal(discount);
			bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
			stockBase.setDiscount(bigDecimal.toString());
			stockBaseMapper.insertSelective(stockBase);
		}
	}
}
