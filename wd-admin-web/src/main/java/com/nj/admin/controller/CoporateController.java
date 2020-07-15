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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.enums.ECapitalEndChannel;
import com.nj.core.base.enums.EProductTemplate;
import com.nj.core.base.enums.EpayChannel;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateExample;
import com.nj.model.generate.NjCoporateProductTemp;
import com.nj.model.generate.NjCoporateProductTempExample;
import com.nj.service.base.system.RoleService;
import com.nj.service.enterprise.CoporateService;


/**
 * @FileName CoporateController.java
 * @Description:
 *
 */
@Controller
@RequestMapping(value = "/coporate")
public class CoporateController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(CoporateController.class);

	@Resource(name = "coporateService")
	private CoporateService coporateService;
	

	@Resource(name = "roleService")
	private RoleService njRoleService;

	@PostMapping(value = "/list")
	@ResponseBody
	public PageData list() {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			PageHelper.startPage(pd.getInteger("start"), pd.getInteger("length"));
			PageInfo<?> info = new PageInfo<>(coporateService.selectAllList(pd));
			result.put("status", 0);
			result.put(Constants.Datas.RECORDSFILTERED, info.getTotal());
			result.put(Constants.Datas.NDATA, info.getList());
		} catch (Exception e) {
			logger.error("list user error", e);
			result = new PageData();
		}
		return result;
	}
	
	
	@GetMapping(value="/corAdd")
	public ModelAndView corAdd() throws Exception {
		PageData pd = super.getPageData();
	
		//获取授权使用产品模板列表
		List<EProductTemplate> personProductTempList = EProductTemplate.getEProductTemplateByType(EProductTemplate.TemplateType.PERSON);
		List<Map<Object,String>>  personTemplateList =  new  ArrayList<Map<Object,String>>(); 
		for(EProductTemplate eProductTemplate : personProductTempList){
			Map<Object,String>  map  =  new  HashMap<Object,String>();
			map.put(eProductTemplate.getId(), eProductTemplate.getName());
			personTemplateList.add(map);
		}
		
		List<EProductTemplate> companyProductTempList = EProductTemplate.getEProductTemplateByType(EProductTemplate.TemplateType.COMPANY);
		List<Map<Object,String>>  companyTemplateList =  new  ArrayList<Map<Object,String>>(); 
		for(EProductTemplate eProductTemplate : companyProductTempList){
			Map<Object,String>  map  =  new  HashMap<Object,String>();
			map.put(eProductTemplate.getId(), eProductTemplate.getName());
			companyTemplateList.add(map);
		}
		
		//获取支付渠道列表
		List<Map<Object,String>>  payChannelList =  new  ArrayList<Map<Object,String>>(); 
		for(EpayChannel payChannel : EpayChannel.values()){
			Map<Object,String>  map  =  new  HashMap<Object,String>();
			map.put(payChannel.getId(), payChannel.getDesc());
			payChannelList.add(map);
		}
		
		//资产推送渠道列表
		List<Map<Object,String>>  capticalEndList =  new  ArrayList<Map<Object,String>>(); 
		for(ECapitalEndChannel capitalEndChannel : ECapitalEndChannel.values()){
			Map<Object,String>  map  =  new  HashMap<Object,String>();
			map.put(capitalEndChannel.getId(), capitalEndChannel.getDesc());
			capticalEndList.add(map);
		}
	
		ModelAndView mv = super.getModelAndView();
		//mv.addObject("njCoporateObj", njCoporateList.get(0));
	
		mv.addObject("personTemplateList", personTemplateList);
		mv.addObject("companyTemplateList", companyTemplateList);
		mv.addObject("payChannelList", payChannelList);
		mv.addObject("capticalEndList", capticalEndList);
		mv.setViewName("sys/coporate/corAdd");
		return mv;
	}
	
	@PostMapping(value="/corAdd")
	@ResponseBody
	public PageData corAddCommit() {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		coporateService.AddCorporateInfo(pd);
		result.put("status", 1);
		
		return  result;
	}
	

	@GetMapping(value="/copyRights")
	public ModelAndView copyRights() {
		PageData pd = super.getPageData();
		String coporateId = pd.getString("coporateId");
		String companyName = pd.getString("companyName");
		Assert.hasLength(coporateId);
		ModelAndView mv = super.getModelAndView();
		mv.addObject("coporateId", coporateId);
		mv.addObject("companyName", companyName);
		mv.setViewName("sys/coporate/copyRights");
		return mv;
	}
	
	@PostMapping(value="/copyRights")
	@ResponseBody
	public PageData copyRightsCommit() {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		String sourceCoporateId = pd.getString("sourceCoporateId");
		String targetCoporateId = pd.getString("targetCoporateId");
		Assert.hasLength(sourceCoporateId);
		Assert.hasLength(targetCoporateId);
		
		njRoleService.copyRights(sourceCoporateId,targetCoporateId);
		result.put("status", 1);
		
		return  result;
	}
	
	@GetMapping(value="/corEdit")
	public ModelAndView corEdit() throws Exception {
		PageData pd = super.getPageData();
		String coporateId = pd.getString("coporateId");
		
		Assert.hasLength(coporateId);
		//获取被修改的对象信息
		NjCoporateExample example = new NjCoporateExample();
		example.createCriteria().andDelFlagEqualTo(false)
								.andIdEqualTo(coporateId);
		List<NjCoporate> njCoporateList = coporateService.selectByExample(example);
		
		
		NjCoporateProductTempExample tempExample =  new NjCoporateProductTempExample();
		tempExample.createCriteria().andCoporateIdEqualTo(coporateId);
		List<NjCoporateProductTemp> cptList = coporateService.getCoporateProductTemp(tempExample);
		//获取授权使用产品模板列表
		List<EProductTemplate> personProductTempList = EProductTemplate.getEProductTemplateByType(EProductTemplate.TemplateType.PERSON);
		List<Map<Object,String>>  personTemplateList =  new  ArrayList<Map<Object,String>>(); 
		for(EProductTemplate eProductTemplate : personProductTempList){
			Map<Object,String>  map  =  new  HashMap<Object,String>();
			map.put(eProductTemplate.getId(), eProductTemplate.getName());
			personTemplateList.add(map);
		}
		
		List<EProductTemplate> companyProductTempList = EProductTemplate.getEProductTemplateByType(EProductTemplate.TemplateType.COMPANY);
		List<Map<Object,String>>  companyTemplateList =  new  ArrayList<Map<Object,String>>(); 
		for(EProductTemplate eProductTemplate : companyProductTempList){
			Map<Object,String>  map  =  new  HashMap<Object,String>();
			map.put(eProductTemplate.getId(), eProductTemplate.getName());
			companyTemplateList.add(map);
		}
		
		//获取支付渠道列表
		List<Map<Object,String>>  payChannelList =  new  ArrayList<Map<Object,String>>(); 
		for(EpayChannel payChannel : EpayChannel.values()){
			Map<Object,String>  map  =  new  HashMap<Object,String>();
			map.put(payChannel.getId(), payChannel.getDesc());
			payChannelList.add(map);
		}
		
		//资产推送渠道列表
		List<Map<Object,String>>  capticalEndList =  new  ArrayList<Map<Object,String>>(); 
		for(ECapitalEndChannel capitalEndChannel : ECapitalEndChannel.values()){
			Map<Object,String>  map  =  new  HashMap<Object,String>();
			map.put(capitalEndChannel.getId(), capitalEndChannel.getDesc());
			capticalEndList.add(map);
		}
		Assert.hasLength(coporateId);
		ModelAndView mv = super.getModelAndView();
		mv.addObject("njCoporateObj", njCoporateList.get(0));
		mv.addObject("cptList", cptList);
		mv.addObject("personTemplateList", personTemplateList);
		mv.addObject("companyTemplateList", companyTemplateList);
		mv.addObject("payChannelList", payChannelList);
		mv.addObject("capticalEndList", capticalEndList);
		mv.setViewName("sys/coporate/corEdit");
		return mv;
	}
	
	@PostMapping(value="/corEdit")
	@ResponseBody
	public PageData corEditCommit() {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		coporateService.updateCorporateInfo(pd);
		result.put("status", 1);
		
		return  result;
	}
	
	
	
}
