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

package com.nj.enterprise.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.entity.SystemLog;
import com.nj.core.base.enums.EProductTemplate;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.fee.constant.BusinessFeeAndAlgorithmRelation;
import com.nj.core.fee.constant.EBusinessFee;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.enterprise.utils.Util;
import com.nj.model.generate.NjProduct;
import com.nj.service.base.system.DictService;
import com.nj.service.base.system.TemplateService;
import com.nj.service.enterprise.ProductService;
import com.nj.service.enterprise.ProductTemplateService;

/**
 * @FileName LoginController.java
 * @Description:产品管理控制器
 *
 * @Date Apr 17, 2018
 * @author TangRenjian
 * @version 1.0
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

	/**
	 * 跳转到分页获取所有产品列表
	 * 
	 * @return
	 */
	@ResourcesAnnotion(uri="/product/listProductPage",name="所有产品",resourceType=2,parentId="203")
	@RequestMapping(value = "/listProductPage", method = RequestMethod.GET)
	public ModelAndView listOrderPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productManagement/productList");
		return mv;
	}
	
	/**
	 * 分页获取所有产品列表
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/listProductPage", method = RequestMethod.POST)
	@ResponseBody
	public PageData listProduct(HttpSession session) {

		PageData result = new PageData();
		PageData pd = super.getPageData();
		result.put("draw", pd.getInteger("draw"));
		try {
			pd.put("coporateId", Util.getCurrentCoporateId());
			// 查询订单数据列表
			PageHelper.startPage(pd.getInteger("start"), pd.getInteger("length"));
			PageInfo<?> info = new PageInfo<>(productService.getAllProductList(pd));

			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.RECORDSTOTAL, info.getTotal());
			result.put(Constants.Datas.RECORDSFILTERED, info.getTotal());
			result.put(Constants.Datas.NDATA, info.getList());

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}

	
	/**
	 * 分页获取所有产品列表
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/selectProduct", method = RequestMethod.POST)
	@ResourcesAnnotion(uri="/product/selectProduct",name="产品下拉",resourceType=3,parentId="/product/listProductPage")
	@ResponseBody
	public PageData selectProduct(HttpSession session) {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			pd.put("coporateId", Util.getCurrentCoporateId());
			pd.put("state", 5);//下拉列表只查询已上架
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
			result.put(Constants.Datas.NDATA, productService.getAllProductList(pd));

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	/**
	 * 跳转到新增页面
	 * 
	 * @return
	 */
	@ResourcesAnnotion(uri="/product/goAddProductBaseInfo",name="新建产品",resourceType=3,parentId="203")
	@RequestMapping(value = "/goAddProductBaseInfo", method = RequestMethod.GET)
	public ModelAndView goAddProductBaseInfoCredit(String id,String productTempId) {
		ModelAndView mv = new ModelAndView();
		if(null == id) {
			id = "";
		}
		mv.addObject("id", id);
		mv.addObject("productTempId", productTempId);
		mv.addObject("coporateId", Util.getCurrentCoporateId());
		if(productTempId.equals(EProductTemplate.Credit.getId()+"") || productTempId.equals(EProductTemplate.AUTO_FINANCE.getId()+"")) {
			mv.setViewName("productManagement/productConfigurationCredit");
		}else if(productTempId.equals(EProductTemplate.Housing.getId()+"")){
			mv.setViewName("productManagement/productConfigurationHousing");
		}else if(productTempId.equals(EProductTemplate.CASH.getId()+"")) {
			mv.setViewName("productManagement/productConfigurationCash");
		}
		return mv;
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	@ResourcesAnnotion(uri="/product/goEditProductBaseInfo",name="编辑",resourceType=3,parentId="203")
	@RequestMapping(value = "/goEditProductBaseInfo", method = RequestMethod.GET)
	public ModelAndView goEditProductBaseInfo(String id,String productTempId) {
		
		ModelAndView mv = new ModelAndView();
		if(null == id) {
			id = "";
		}
		
		mv.addObject("id", id);
		mv.addObject("productTempId", productTempId);
		mv.addObject("coporateId", Util.getCurrentCoporateId());
		
		if(productTempId.equals(EProductTemplate.Credit.getId()+"") || productTempId.equals(EProductTemplate.AUTO_FINANCE.getId()+"")) {
			mv.setViewName("productManagement/productConfigurationCredit");
		}else if(productTempId.equals(EProductTemplate.Housing.getId()+"")){
			mv.setViewName("productManagement/productConfigurationHousing");
		}else if(productTempId.equals(EProductTemplate.CASH.getId()+"")) {
			mv.setViewName("productManagement/productConfigurationCash");
		}
		return mv;
	}

	/**
	 * 获取产品信息
	 * 
	 * @param page
	 * @return
	 */
	@ResourcesAnnotion(uri="/product/productInfo",name="产品详情",resourceType=3,parentId="203")
	@RequestMapping(value = "/productInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageData productInfo(HttpSession session) {

		PageData result = new PageData();
		PageData pd = super.getPageData();
		result.put("draw", pd.getInteger("draw"));
		try {
			String page = pd.getString("page");
			if (null == page || "".equals(page.trim())) {
				result.put(Constants.Datas.STATUS, 1000);
				result.put(Constants.Datas.MSG, "page不能为空");
				return result;
			} else if ("1".equals(page)) {// 产品基本信息获取
				result.put(Constants.Datas.NDATA, productService.getProductInfoById(pd.getString("id")));
			} else if ("2".equals(page)) {// 产品渠道配置信息
				result.put(Constants.Datas.NDATA, productService.getProductChannel(pd.getString("id")));
			} else if ("3".equals(page)) {// 产品业务受理信息
				result.put(Constants.Datas.NDATA, productService.getProductBusiness(pd.getString("id")));
			} else if ("4".equals(page)) {// 交易配置信息
				result.put(Constants.Datas.NDATA, productService.getProductTransaction(pd.getString("id"),Util.getCurrentCoporateId()));
			} else if ("5".equals(page)) {// 流程配置信息
				result.put(Constants.Datas.NDATA, productService.getProductProcess(pd.getString("id")));
			} else if("6".equals(page)) { //费用配置
				result.put(Constants.Datas.NDATA, productService.getProductFee(pd.getString("id")));
			} else {
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		result.put(Constants.Datas.STATUS, 0);
		return result;
	}

	/**
	 * 更改产品状态
	 * 
	 * @param page
	 * @return
	 */
	@SystemLog(description="更改产品状态")
	@ResourcesAnnotion(uri="/product/updateProductState",name="修改状态",resourceType=3,parentId="/product/listProductPage")
	@RequestMapping(value = "/updateProductState", method = RequestMethod.POST)
	@ResponseBody
	public PageData updateProductState(HttpSession session) {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		result.put("draw", pd.getInteger("draw"));
		try {
			// 获取当前登录用户信息
			pd.put("userId", Util.getCurrentUserId());
			String ids = (String) pd.get("ids");
			String state = (String) pd.get("state");
			if (null == ids || "".equals(ids.trim())) {
				result.put(Constants.Datas.STATUS, 1000);
				result.put(Constants.Datas.MSG, "请选择需要操作的产品");
			} else if (null == state || "".equals(state.trim())) {
				result.put(Constants.Datas.STATUS, 1000);
				result.put(Constants.Datas.MSG, "请选择要进行的操作");
			} else {
				productService.updateAll(ids, Integer.parseInt(state));
				result.put(Constants.Datas.STATUS, 0);
				result.put(Constants.Datas.NDATA, "OK");
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}

	/**
	 * 保存产品基本信息
	 * 
	 * @param page
	 * @return
	 */
	@SystemLog(description="保存产品基本信息")
	@ResourcesAnnotion(uri="/product/saveProductBaseInfo",name="基本信息下一步",resourceType=3,parentId="/product/productInfo")
	@RequestMapping(value = "/saveProductBaseInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageData saveProductBaseInfo(HttpSession session, NjProduct njProduct) {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			// 获取当前登录用户信息
			pd.put("userId", Util.getCurrentUserId());
			pd.put("coporateId", Util.getCurrentCoporateId());
//			njProduct.setState(Constants.ProductState.UNSUBMIT);// 配置基本信息，产品尚未配置完成
			njProduct.setId(pd.getString("productId"));
			productService.saveOrUpdateProduct(njProduct, pd);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
			result.put(Constants.Datas.NDATA, njProduct.getId());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}

	/**
	 * 保存产品渠道信息
	 * 
	 * @param page
	 * @return
	 */
	@SystemLog(description="保存产品渠道")
	@ResourcesAnnotion(uri="/product/saveProductChannelInfo",name="渠道配置下一步",resourceType=3,parentId="/product/productInfo")
	@RequestMapping(value = "/saveProductChannelInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageData saveProductChannelInfo() {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			// 获取当前登录用户信息
			pd.put("userId", Util.getCurrentUserId());
			productService.saveProductChannel(pd);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	
	/**
	 * 获取产品业务配置数据字典dict
	 * 
	 * @param page
	 * @return
	 */
	@ResourcesAnnotion(uri="/product/listProductBusinessDictInfo",name="获取产品业务配置数据字典dict",resourceType=3,parentId="/product/listProductPage")
	@RequestMapping(value = "/listProductBusinessDictInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageData listProductBusinessDictInfo(@RequestParam String productTempId) {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			pd.put("productTempId", productTempId);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, productService.selectBusinessDict(pd));
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	
	/**
	 * 保存产品业务受理配置
	 * @param session
	 * @return
	 */
	@SystemLog(description="保存产品业务受理配置")
	@ResourcesAnnotion(uri="/product/saveProductBusinessInfo",name="业务受理配置下一步",resourceType=3,parentId="/product/productInfo")
	@RequestMapping(value = "/saveProductBusinessInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageData saveProductBusinessInfo(@RequestParam String businessItems) {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			productService.saveProductBusiness(pd,businessItems);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	
	/**
	 * 保存产品交易配置信息
	 * 
	 * @param page
	 * @return
	 */
	@SystemLog(description="保存产品交易配置")
	@ResourcesAnnotion(uri="/product/saveProductTransactionInfo",name="交易配置下一步",resourceType=3,parentId="/product/productInfo")
	@RequestMapping(value = "/saveProductTransactionInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageData saveProductTransactionInfo(HttpSession session) {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			productService.saveProductTransaction(pd);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	
	/**
	 * 保存产品流程配配置信息
	 * 
	 * @param page
	 * @return
	 */
	@SystemLog(description="保存产品流程配配置")
	@ResourcesAnnotion(uri="/product/saveProductProcess",name="流程配置保存",resourceType=3,parentId="/product/productInfo")
	@RequestMapping(value = "/saveProductProcess", method = RequestMethod.POST)
	@ResponseBody
	public PageData saveProductProcess() {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			//数据校验
			JSONArray array = JSONArray.parseArray(pd.getString("processItems"));
			if(null == array) {
				throw new Exception("配置流程项不能为空");
			}
			for (int i = 0; i < array.size(); i++) {
				JSONObject jb = array.getJSONObject(i);
				if(null == jb.getString("execAgreeStatus") || "".equals(jb.getString("execAgreeStatus"))) {
					throw new Exception("下一步动作不能为空");
				}
			}
			productService.saveProductProcess(pd);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	
	/**
	 * 获取产品费用配置项信息
	 * 
	 * @param page
	 * @return
	 */
	@ResourcesAnnotion(uri="/product/getProductFeeItems",name="获取产品费用配置项信息",resourceType=3,parentId="/product/productInfo")
	@RequestMapping(value = "/getProductFeeItems", method = RequestMethod.POST)
	@ResponseBody
	public PageData getProductFeeItems() {
		PageData result = new PageData();
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> businessFeeMap = new HashMap<>();
			for (EBusinessFee businessFee : EBusinessFee.values()) {
				businessFeeMap.put("name", businessFee.getName());
				businessFeeMap.put("code", businessFee.getCode());
				businessFeeMap.put("isMustSelected", businessFee.getIsMustSelected());
				//获取费用类型支持的算法列表
				List<EBusinessFeeAlgorithm> algorithms = BusinessFeeAndAlgorithmRelation.getAlgorithmForFee(businessFee);
				businessFeeMap.put("calList", algorithms==null?"":algorithms.toString());
				list.add(businessFeeMap);
			}
			result.put(Constants.Datas.NDATA, list);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	
	/**
	 * 保存产品费用配置信息
	 * 
	 * @param page
	 * @return
	 */
	@SystemLog(description="保存产品费用配置")
	@ResourcesAnnotion(uri="/product/saveProductFeeInfo",name="费用配置下一步",resourceType=3,parentId="/product/productInfo")
	@RequestMapping(value = "/saveProductFeeInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageData saveProductFeeInfo(HttpSession session) {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			pd.put("userId", Util.getCurrentUserId());
			productService.saveProductFeeCfg(pd);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	
}
