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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nj.core.base.common.Constants;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductOutsideApi;
import com.nj.model.generate.NjTemplate;
import com.nj.model.generate.SysDict;
import com.nj.service.base.system.DictService;
import com.nj.service.base.system.TemplateService;
import com.nj.service.enterprise.ProductService;
import com.nj.service.enterprise.ProductTemplateService;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;

/**
 * @FileName LoginController.java
 * @Description:
 *
 * @Date Apr 17, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Resource(name = "templateService")
	private TemplateService templateService;
	
	@Resource(name = "dictService")
	private DictService dictService;

	@Resource(name = "productService")
	private ProductService productService;

	@Resource(name = "productTemplateService")
	ProductTemplateService productTemplateService;

	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView list(Page page, HttpSession httpSession) {
		ModelAndView mv = this.getModelAndView();

		PageData pd = new PageData();
		pd = this.getPageData();

		try {
			List<NjTemplate> list = templateService.getTemplateList(pd);
			mv.addObject("list", list);
			// 进入主页
			mv.setViewName("sys/product/products");
			// 2.如果没在能借注册过则调到注册界面

		} catch (Exception e) {

		}
		return mv;
	}

	/*
	 * 获取产品列表信息
	 */
	@RequestMapping(value = "/list", method=RequestMethod.POST)
	@ResponseBody
	public PageData listData(Page page, HttpSession httpSession) {
		PageData res = new PageData();
		try {
			PageData pd = new PageData();
			pd.put("state", Constants.ProductState.PUBLISHED);
			res = productService.getProductsByAdmin(pd);

		} catch (Exception e) {
			logger.debug("listData: " + e.getMessage());
		}
		return res;
	}
	
	/*
	 * 获取产品列表信息
	 */
	@RequestMapping(value = "/listAll", method=RequestMethod.POST)
	@ResponseBody
	public PageData listAllData(Page page, HttpSession httpSession) {
		PageData res = new PageData();
		try {
			PageData pd = new PageData();
			res = productService.getProductsByAdmin(pd);
		} catch (Exception e) {
			logger.debug("listData: " + e.getMessage());
		}
		return res;
	}
	

	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public ModelAndView homeIndex(Page page, HttpSession httpSession) {
		ModelAndView mv = this.getModelAndView();

		PageData pd = new PageData();
		pd = this.getPageData();

		try {
			List<NjTemplate> list = templateService.getTemplateList(pd);
			mv.addObject("list", list);
			// 进入主页
			mv.setViewName("product/chose_template");
			// 2.如果没在能借注册过则调到注册界面

		} catch (Exception e) {

		}
		return mv;
	}

	@RequestMapping(value = "/create", method=RequestMethod.GET)
	public ModelAndView toCreate(HttpServletRequest request,String tempId) {
		ModelAndView mv = this.getModelAndView();

		PageData pd = new PageData();
		pd = this.getPageData();

		try {
			mv.addObject("tempId", tempId);
			
			Map<String,Object> map = productTemplateService.getTemplateDataByTempId(request, tempId);
			
//			ITemplate it = new TemplateXMLInfo(map);
//			NjProduct product = (NjProduct) it.getBasicConfiguration();
//			mv.addObject("product", product);
			// 进入主页
			mv.setViewName("product/product_create");
			// 2.如果没在能借注册过则调到注册界面

		} catch (Exception e) {

		}
		return mv;
	}
	
	@RequestMapping(value="/pass")
	@ResponseBody
	public PageData pass(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			productService.updateAll(pd.getString("ids"),Constants.ProductState.APPROVED);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("batch delete role error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/notPass")
	@ResponseBody
	public PageData notPass(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			productService.updateAll(pd.getString("ids"),Constants.ProductState.DECLINE);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("batch delete role error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView toEditPage(){
		ModelAndView v = new ModelAndView();
		PageData pd = this.getPageData();
		try {
			NjProduct product = productService.getProductById(pd.getString("productId"));
			v.addObject("product",product);
		} catch (Exception e) {
			
		}
		v.setViewName("sys/product/productEdit");
		return v;
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(){
		PageData pd = new PageData();
		
		PageData param = this.getPageData();
		NjProduct product = new NjProduct();
		product.setId(param.getString("id"));
		product.setOpenProductId(param.getString("openProductId"));
		try {
			productService.update(product);
			pd.put("status", 1);
		} catch (Exception e) {
			pd.put("status", 0);
			pd.put("msg", "更新失败");
		}
		
		return pd;
	}
	
	@ResourcesAnnotion(uri="/product/listApi",name="产品接口",resourceType=1,parentId="2")
	@GetMapping(value="/listApi")
	public ModelAndView listApi(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("business/productApi/list");
		return mv;
	}
	@PostMapping(value="/listApi")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			String  coporateId  =  pd.getString("coporateId");
			if(StringUtils.isNotBlank(coporateId)){
				pd.put("coporateId", coporateId);
			}
			List<Map<String, Object>> list = productService.listApi(pd);
			long allCount = productService.listApiAllCount(pd);
			if(list != null && list.size() > 0){
				result.setDataList(list);
				result.setTotalCount((int)allCount);	
				
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, allCount);
				result.put(Const.RECORDSFILTERED, allCount);
			}
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return result;
	}
	
	/**
	 * 跳转到产品接口页
	 * @return
	 */
	@GetMapping(value="/outApiList")
	public ModelAndView outApiList(String productId){
		ModelAndView mv = super.getModelAndView();
		mv.addObject("productId", productId);
		mv.setViewName("business/productApi/outApiList");
		return mv;
	}
	/**
	 * 获取产品已有接口
	 * @param request
	 * @return
	 */
	@PostMapping(value="/getProductApiList")
	@ResponseBody
	public DataTableResult getProductApiList(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<Map<String, Object>> list = productService.selectProductApi(pd);
			if(list != null && list.size() > 0){
				result.setDataList(list);
				result.put(Const.DRAW, pd.getString(Const.DRAW));
			}
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return result;
	}
	
	/**
	 * 获取所有接口列表
	 * @param request
	 * @return
	 */
	@PostMapping(value="/getAllApiList")
	@ResponseBody
	public DataTableResult outApiList(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<Map<String, Object>> list = productService.selectAllApi(pd);
			if(list != null && list.size() > 0){
				result.setDataList(list);
				result.put(Const.DRAW, pd.getString(Const.DRAW));
			}
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return result;
	}
	
	/**
	 * 获取所有接口列表
	 * @param request
	 * @return
	 */
	@PostMapping(value="/saveProductApi")
	@ResponseBody
	public DataTableResult saveProductApi(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			productService.saveProductApi(pd);
			result.put("status",0);
			result.put(Const.DRAW, pd.getString(Const.DRAW));
		} catch (Exception e) {
			logger.error("系统错误", e);
			result.put("status",1000);
//			result = new PageData();
		}
		return result;
	}
}
