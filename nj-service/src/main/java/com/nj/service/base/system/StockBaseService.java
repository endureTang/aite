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

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.ChannelStockMapper;
import com.nj.dao.StockBaseMapper;
import com.nj.dao.StockFormatDictMapper;
import com.nj.dao.StockFormatMapper;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.datamodel.StockFormatDictForm;
import com.nj.model.datamodel.StockFormatForm;
import com.nj.model.generate.*;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	private static Logger logger = LoggerFactory.getLogger(StockBaseService.class);
	@Resource(name = "BaseDao")
	private BaseDao dao;
    @Resource
    private StockBaseMapper stockBaseMapper;
	@Resource
	private NjStrategyMapperExtend njStrategyMapperExtend;

	@Resource
	private ChannelStockMapper channelStockMapper;


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
			BigDecimal bigDecimal = null;
			try {
				Double discount = new Double(stockBase.getChannelPrice()) / new Double(stockBase.getBasePrice());
				bigDecimal = new BigDecimal(discount);
				bigDecimal = bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
			} catch (NumberFormatException e) {
				bigDecimal = new BigDecimal(0);
			}
			stockBase.setDiscount(bigDecimal.toString());
		}
		stockBaseMapper.updateByPrimaryKeySelective(stockBase);
	}

	public void insertBath(ArrayList<StockBase> stockBases) {
		//导入ERP基础订单前，清理之前的数据
		stockBaseMapper.deleteByExample(null);
		Map<String, String> repeatMap = new HashedMap(); //根据货号、规格生成key，实现list对象去重
		for (StockBase stockBase : stockBases) {
			String mapKey = stockBase.getStockNo() + stockBase.getSpecification();
			String data = repeatMap.get(mapKey);
			if(data != null && !data.equals("")){
				continue;
			}
			BigDecimal bigDecimal = null;
			try {
				Double discount = new Double(stockBase.getChannelPrice()) / new Double(stockBase.getBasePrice());
				bigDecimal = new BigDecimal(discount);
				bigDecimal = bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
			} catch (NumberFormatException e) {
				bigDecimal = new BigDecimal(0);
			}
			stockBase.setDiscount(bigDecimal.toString());
			stockBaseMapper.insertSelective(stockBase);
			repeatMap.put(mapKey, "data");
		}
	}

	/** 
	* @Description: 补充基础档案库和渠道库存
	* @Param:
	* @return:
	* @Author: endure
	* @Date: 2020/7/28 
	*/
	public void insertBathBaseAndChannel(ArrayList<StockBase> stockBases) {
		for (StockBase stockBase : stockBases) {
			ChannelStock channelStock = new ChannelStock();
			channelStock.setId(UuidUtil.get32UUID());
			channelStock.setAmount(stockBase.getAmount());
			channelStock.setSpecification(stockBase.getSpecification());
			channelStock.setStockNo(stockBase.getStockNo());
			channelStock.setChannelPrice(stockBase.getChannelPrice());
			channelStock.setType(1);
			channelStockMapper.insertSelective(channelStock);

			//根据货号+规格获取档案库信息
			String stockNo = stockBase.getStockNo();
			String spec = stockBase.getSpecification();
			StockBaseExample stockBaseExample = new StockBaseExample();
			stockBaseExample.createCriteria().andStockNoEqualTo(stockNo).andSpecificationEqualTo(spec);
			List<StockBase> tempStockBases = stockBaseMapper.selectByExample(stockBaseExample);
			if(tempStockBases != null && tempStockBases.size() > 0){
				continue;
			}
			BigDecimal bigDecimal = null;
			try {
				Double discount = new Double(stockBase.getChannelPrice()) / new Double(stockBase.getBasePrice());
				bigDecimal = new BigDecimal(discount);
				bigDecimal = bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP);
			} catch (NumberFormatException e) {
				bigDecimal = new BigDecimal(0);
			}
			stockBase.setDiscount(bigDecimal.toString());
			stockBaseMapper.insertSelective(stockBase);

		}
	}
}
