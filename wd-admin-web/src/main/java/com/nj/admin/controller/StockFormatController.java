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

package com.nj.admin.controller;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.model.datamodel.StockFormatForm;
import com.nj.model.generate.StockFormat;
import com.nj.model.generate.SysDict;
import com.nj.service.base.system.DictService;
import com.nj.service.base.system.StockFormatService;
import com.nj.service.base.system.StrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @FileName RoleController.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/stockFormat")
public class StockFormatController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(StockFormatController.class);
	
	@Resource(name = "stockFormatService")
	private StockFormatService stockFormatService;

	@Resource(name = "dictService")
	private DictService dictService;

	@ResourcesAnnotion(uri="/stockFormat/page",name="渠道库存格式",resourceType=1,parentId="3")
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/stockFormat/list");
		return mv;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<StockFormat> list = stockFormatService.list(pd);
			int count = stockFormatService.listAllCount(pd);
			logger.info("");
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(count);
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, count);
				result.put(Const.RECORDSFILTERED, count);
			}
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView toAdd() {
		ModelAndView mv = super.getModelAndView();
		List<SysDict> dictList = null;
		try {
			dictList = dictService.selectAll();
		} catch (Exception e) {
			logger.error("get role error", e);
		}
		mv.addObject("dictList", dictList);
		mv.setViewName("sys/stockFormat/add");
		return mv;
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(StockFormatForm stockFormatForm){
		PageData result = new PageData();
		try {
			stockFormatService.add(stockFormatForm);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add StockFormat error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}



	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam String id){
		PageData result = new PageData();
		try {
			Integer line = stockFormatService.delete(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败");
			}
		} catch (Exception e) {
			logger.error("delete StockFormat error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
}
