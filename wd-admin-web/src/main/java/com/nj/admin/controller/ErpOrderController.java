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
import com.nj.dao.ErpOrderMapper;
import com.nj.model.generate.ErpOrder;
import com.nj.model.generate.NjStrategy;
import com.nj.model.generate.StrategyOrder;
import com.nj.model.generate.SysDict;
import com.nj.service.base.system.DictService;
import com.nj.service.base.system.ErpOrderService;
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
import java.io.File;
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
@RequestMapping(value = "/erpOrder")
public class ErpOrderController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(ErpOrderController.class);
	
	@Resource(name = "erpOrderService")
	private ErpOrderService erpOrderService;

	@Resource(name = "strategyService")
	private StrategyService strategyService;
	@Resource
	private ErpOrderMapper erpOrderMapper;

	@ResourcesAnnotion(uri="/erpOrder/page",name="ERP订单拆分",resourceType=1,parentId="2")
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("business/order/order_list");
		return mv;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<ErpOrder> list = erpOrderService.list(pd);
			int count = erpOrderService.listAllCount(pd);
			if(list != null && list.size() > 0){
				logger.info("");
				result.insertDataList(list);
				result.setTotalCount(count);
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, count);
				result.put(Const.RECORDSFILTERED, count);
			}
		} catch (Exception e) {
			logger.error("list erpOrder error", e);
		}
		return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView toAdd() {
		ModelAndView mv = super.getModelAndView();
		try {
			int count = erpOrderService.listAllCount(null);
			if(count == 0){
				mv.addObject("message", "请先上传ERP数据，否则无法匹配");
			}
			List<NjStrategy> strategyList = strategyService.list(null);
			List<StrategyOrder> strategyOrders = erpOrderService.selectStrategyOrderList();
			mv.addObject("strategyList", strategyList);
			mv.addObject("strategyOrders", strategyOrders);
			mv.setViewName("business/order/order_add");
			return mv;
		} catch (Exception e) {
			logger.error("add erpOrder error", e);
		}
		return  mv;
	}


	/**
	* @Description:执行反馈订单拆分
	* @Param:
	* @return:
	* @Author: endure
	* @Date: 2020/7/21
	*/
	@RequestMapping(value="/doSplit", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView doSplit(HttpServletRequest request){

		ModelAndView mv = super.getModelAndView();
		try {
			List<StrategyOrder> strategyOrders = erpOrderService.updateChannelOrder(request);
			mv.addObject("strategyOrders", strategyOrders);
			mv.setViewName("business/order/order_success");
			return mv;
		} catch (Exception e) {
			logger.error("add erpOrder error", e);
		}
		return  mv;

	}
	@RequestMapping(value="/clearData", method = RequestMethod.POST)
	@ResponseBody
	public PageData clearData(HttpServletRequest request){
		PageData result = new PageData();
		try {
			//清理之前的数据
			erpOrderMapper.deleteByExample(null);
			String realPath = request.getSession().getServletContext().getRealPath("static"+File.separator +"upload" + File.separator + "excelFile" + File.separator);
			File dir = new File(realPath);
			if(dir.exists()){
				deleteFolder(dir);
			}
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add role error", e);
			result.put("status", 0);
			result.put("msg", "清空失败");
		}
		return result;
	}

	//需要注意的是当删除某一目录时，必须保证该目录下没有其他文件才能正确删除，否则将删除失败。
	private void deleteFolder(File folder) throws Exception {
		if (!folder.exists()) {
			throw new Exception("文件不存在");
		}
		File[] files = folder.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					//递归直到目录下没有文件
					deleteFolder(file);
				} else {
					//删除
					file.delete();
				}
			}
		}
		//删除
		folder.delete();

	}
	
}
