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
import com.nj.dao.BlackStockMapper;
import com.nj.dao.StockFormatDictMapper;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.datamodel.StockFormatDictForm;
import com.nj.model.datamodel.StockFormatForm;
import com.nj.model.generate.BlackStock;
import com.nj.model.generate.StockFormat;
import com.nj.model.generate.StockFormatDict;
import com.nj.model.generate.StockFormatDictExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @FileName BlackStockNoService.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional
@Service("blackStockNoService")
public class BlackStockNoService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
    @Resource
    private BlackStockMapper blackStockMapper;
	@Resource
	private NjStrategyMapperExtend njStrategyMapperExtend;
	public List<BlackStock> list(PageData pd) {
		if(pd != null){
			pd.put("start", pd.getInteger("start"));
			pd.put("length", pd.getInteger("length"));
		}
		return njStrategyMapperExtend.selectPageBlackStock(pd);
	}
	public int listAllCount(PageData pd) {
		return blackStockMapper.countByExample(null);
	}
	public Integer delete(String id) {
		return blackStockMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}
	public void insertBath(ArrayList<BlackStock> channelStocks) {
		njStrategyMapperExtend.insertBlackStockBath(channelStocks);
	}
    public void batchDelete(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			String[] idArr = ids.split(",");
			if (idArr.length > 0) {
				for (String idStr : idArr) {
					blackStockMapper.deleteByPrimaryKey(Integer.parseInt(idStr));
				}

			}
		}
    }

    public BlackStock get(Integer id) {
		return blackStockMapper.selectByPrimaryKey(id);
    }

	public void modify(BlackStock blackStock) {
		blackStockMapper.updateByPrimaryKey(blackStock);
		String s ="1";
		s.intern();
	}
}
