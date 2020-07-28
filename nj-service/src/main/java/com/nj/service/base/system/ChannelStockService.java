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
import com.nj.dao.ChannelStockMapper;
import com.nj.dao.StockBaseMapper;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.datamodel.ChannelStockModel;
import com.nj.model.datamodel.ChannelStockModelNew;
import com.nj.model.generate.ChannelStock;
import com.nj.model.generate.ChannelStockExample;
import com.nj.model.generate.StockBase;
import com.nj.model.generate.StockBaseExample;
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
@Service("channelStockService")
public class ChannelStockService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
    @Resource
    private ChannelStockMapper channelStockMapper;
    @Resource
    private StockBaseMapper stockBaseMapper;
	@Resource
	private NjStrategyMapperExtend njStrategyMapperExtend;

	public List<ChannelStock> list(PageData pd) {
		if(pd != null){
			pd.put("start", pd.getInteger("start"));
			pd.put("length", pd.getInteger("length"));
		}
		return njStrategyMapperExtend.selectPageChannelStock(pd);
	}

	public int listAllCount(PageData pd) {
		ChannelStockExample stockBaseExample = new ChannelStockExample();
		String keyword = pd.getString("keyword");
		if(pd.containsKey("type") && pd.getInteger("type")!=null) {
			stockBaseExample.createCriteria().andTypeEqualTo(pd.getInteger("type"));
		}
		if(StringUtils.isNotEmpty(keyword)){
			stockBaseExample.createCriteria().andStockNoEqualTo(keyword);
		}
		return channelStockMapper.countByExample(stockBaseExample);
	}

	public void add(ChannelStock stockBase) {
		stockBase.setId(UuidUtil.get32UUID());
		channelStockMapper.insertSelective(stockBase);
	}

	public Integer delete(String id) {
		return channelStockMapper.deleteByPrimaryKey(id);
	}

	public ChannelStock getById(String id) {
		return channelStockMapper.selectByPrimaryKey(id);
	}

	public void insertBath(ArrayList<ChannelStock> channelStocks) {
		//导入ERP基础库存前，清理之前的数据
		channelStockMapper.deleteByExample(null);
		for (ChannelStock channelStock : channelStocks) {
			if(channelStock.getType() != null && channelStock.getType() == 2){ // 如果导入表格中存在空数据，默认为问题数据
				channelStock.setChannelPrice("");
				continue;
			}else{
				//根据货号+规格获取档案库信息
				String stockNo = channelStock.getStockNo();
				String spec = channelStock.getSpecification();
				StockBaseExample stockBaseExample = new StockBaseExample();
				stockBaseExample.createCriteria().andStockNoEqualTo(stockNo).andSpecificationEqualTo(spec);
				List<StockBase> stockBases = stockBaseMapper.selectByExample(stockBaseExample);
				if(stockBases != null && stockBases.size() > 0){ // 如果存在，则添加为渠道基础库
					StockBase stockBase = stockBases.get(0);
					channelStock.setType(1);
					channelStock.setChannelPrice(stockBase.getChannelPrice());
				}else{ //否则根据数量判断是否为疑似新增库存：大于3，是，小于3，否
					if(Integer.parseInt(channelStock.getAmount()) >= 3){
						channelStock.setChannelPrice("");
						channelStock.setType(3);
					}else{
						channelStock.setType(2);
						channelStock.setChannelPrice("");
						channelStock.setRemark("根据货号、规格匹配库存档案失败");
					}
				}

			}
		}
		njStrategyMapperExtend.insertBath(channelStocks);
	}

	public void edit(ChannelStock stockBase) {
		channelStockMapper.updateByPrimaryKeySelective(stockBase);
	}

	public void clearData() {
		channelStockMapper.deleteByExample(null);
	}

	public List<ChannelStockModel> listModel(PageData pd) {
		return njStrategyMapperExtend.selectPageChannelStockModel(pd);
	}

	public List<ChannelStockModelNew> listModelNew(PageData pd) {
		return njStrategyMapperExtend.selectPageChannelStockModelNew(pd);
	}
}
