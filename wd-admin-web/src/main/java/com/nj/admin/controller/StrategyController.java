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
import com.nj.model.generate.NjStrategy;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysRole;
import com.nj.service.base.system.DictService;
import com.nj.service.base.system.RoleService;
import com.nj.service.base.system.StrategyService;
import com.nj.service.enterprise.CoporateService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
@RequestMapping(value = "/strategy")
public class StrategyController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(StrategyController.class);
	
	@Resource(name = "strategyService")
	private StrategyService strategyService;
	@Resource(name = "dictService")
	private DictService dictService;
	
	@ResourcesAnnotion(uri="/strategy/page",name="策略列表",resourceType=1,parentId="3")
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/strategy/strategy_list");
		return mv;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<NjStrategy> list = strategyService.list(pd);
			int count = strategyService.listAllCount(pd);
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
		mv.setViewName("sys/strategy/strategy_add");
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam String id) {
		ModelAndView mv = super.getModelAndView();
		NjStrategy pd = null;
		List<SysDict> dictList = null;
		try {
			pd = strategyService.getById(id);
			dictList = dictService.selectAll();
		} catch (Exception e) {
			logger.error("get role error", e);
		}
		mv.addObject("pd", pd);
		mv.addObject("dictList", dictList);
		mv.setViewName("sys/strategy/strategy_edit");
		return mv;
	}
}
