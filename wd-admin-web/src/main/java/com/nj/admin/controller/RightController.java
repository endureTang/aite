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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysResource;
import com.nj.service.base.system.ButtonService;
import com.nj.service.base.system.MenuService;

/**
 * @FileName RightController.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/right")
public class RightController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(RightController.class);
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	@Resource(name = "buttonService")
	private ButtonService buttonService;
	
	@ResourcesAnnotion(uri="/right/menu",name="菜单管理",resourceType=1,parentId="3")
	@RequestMapping(value="/menu")
	public ModelAndView menu(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/right/right_list");
		return mv;
	}
	
	@RequestMapping(value="/subMenu")
	public ModelAndView subMenu(@RequestParam String parentId){
		SysResource pd = null;
		try {
			pd = menuService.getById(parentId);
		} catch (Exception e) {
			logger.error("subMenu error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/right/subMenu_list");
		return mv;
	}
	
	@RequestMapping(value="/button")
	public ModelAndView button(@RequestParam String id){
		SysResource pd = null;
		try {
			pd = menuService.getById(id);
		} catch (Exception e) {
			logger.error("button error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/right/button_list");
		return mv;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult listMenu(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<SysResource> list = menuService.list(pd);
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(list.size());	
				
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, list.size());
				result.put(Const.RECORDSFILTERED, list.size());
			}
		} catch (Exception e) {
			logger.error("list menu error", e);
//			result = new PageData();
		}
		return result;
	}
	
	@RequestMapping(value="/addMenu", method=RequestMethod.GET)
	public ModelAndView toAddMenu(String parentId){
		ModelAndView mv = super.getModelAndView();
		if (parentId == null) {
			mv.addObject("parentId", 0);
			mv.addObject("menuType", 1);
		} else {
			mv.addObject("parentId", parentId);
			mv.addObject("menuType", 2);
		}
		mv.setViewName("sys/right/menu_add");
		return mv;
	}
	
	@RequestMapping(value="/addMenu", method=RequestMethod.POST)
	@ResponseBody
	public PageData addMenu(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			if (pd.get("isShow") == null || pd.get("isShow").equals("")) {
				pd.remove("parentId");
				pd.remove("menuOrder");
			}
			pd.put("status", 1);
			menuService.add(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add menu error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	@RequestMapping(value="/editMenu", method=RequestMethod.GET)
	public ModelAndView toEditMenu(@RequestParam String id){
		PageData result = new PageData();
		try {
			SysResource res = menuService.getById(id);
			result.insertData(res);
			if(StringUtils.isEmpty(res.getParentId()) || "0".equals(res.getParentId())){//一级菜单
				result.put("menuType", 1);
			}else{
				result.put("menuType", 2);
			}
		} catch (Exception e) {
			logger.error("get menu error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", result);
		mv.setViewName("sys/right/menu_edit");
		return mv;
	}
	
	@RequestMapping(value="/editMenu", method=RequestMethod.POST)
	@ResponseBody
	public PageData editMenu(SysResource res){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			menuService.edit(res);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit menu error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	@RequestMapping(value="/deleteMenu")
	@ResponseBody
	public PageData deleteMenu(@RequestParam String id){
		PageData result = new PageData();
		try {
			Integer line = menuService.delete(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
			
		} catch (Exception e) {
			logger.error("delete menu error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchDeleteMenu")
	@ResponseBody
	public PageData batchDeleteMenu(@RequestParam String ids){
		PageData result = new PageData();
		try {
			int length = ids.split(",").length;
			Integer line = menuService.batchDelete(ids);
			if(line<length){
				result.put("status", 0);
				result.put("msg", "成功【"+line+"】条,失败【"+(length-line)+"】条");
			}else{
			result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("batch delete menu error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	
	/************************Button*****************************/
	
	@RequestMapping(value="/listBtn")
	@ResponseBody
	public PageData listBtn(@RequestParam Integer id){
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = buttonService.list(pd);
		} catch (Exception e) {
			logger.error("list button error", e);
			result = new PageData();
		}
		return result;
	}
	
	@RequestMapping(value="/addBtn", method=RequestMethod.GET)
	public ModelAndView toAddBtn(@RequestParam Integer id){
		ModelAndView mv = super.getModelAndView();
		mv.addObject("id", id);
		mv.setViewName("sys/right/button_add");
		return mv;
	}
	
	@RequestMapping(value="/addBtn", method=RequestMethod.POST)
	@ResponseBody
	public PageData addBtn(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			pd.put("status", 1);
			buttonService.add(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add button error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	@RequestMapping(value="/editBtn", method=RequestMethod.GET)
	public ModelAndView toEditBtn(@RequestParam Integer buttonId){
		PageData pd = null;
		try {
			pd = buttonService.getById(buttonId);
		} catch (Exception e) {
			logger.error("get button error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/right/button_edit");
		return mv;
	}
	
	@RequestMapping(value="/editBtn", method=RequestMethod.POST)
	@ResponseBody
	public PageData editBtn(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			buttonService.edit(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit button error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	@RequestMapping(value="/deleteBtn")
	@ResponseBody
	public PageData deleteBtn(@RequestParam Integer buttonId){
		PageData result = new PageData();
		try {
			buttonService.delete(buttonId);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete button error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchDeleteBtn")
	@ResponseBody
	public PageData batchDeleteBtn(@RequestParam String ids){
		PageData result = new PageData();
		try {
			buttonService.batchDelete(ids);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("batch delete button error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}

	@RequestMapping(value="/listSysMenu")
	@ResponseBody
	public DataTableResult listSysMenu(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			pd.put("isShow", "1");
			int count = menuService.listCountNew(pd);
			List<SysResource> list = menuService.listNew(pd);
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(count);	
				
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, count);
				result.put(Const.RECORDSFILTERED, count);
			}
		} catch (Exception e) {
			logger.error("list menu error", e);
//			result = new PageData();
		}
		return result;
	}
	
	
	@RequestMapping(value="/listBussMenu")
	@ResponseBody
	public DataTableResult listBussMenu(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			pd.put("isShow", "2");
			int count = menuService.listCountNew(pd);
			List<SysResource> list = menuService.listNew(pd);
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(count);	
				
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, count);
				result.put(Const.RECORDSFILTERED, count);
			}
		} catch (Exception e) {
			logger.error("list menu error", e);
//			result = new PageData();
		}
		return result;
	}
	
	@RequestMapping(value="/listBussRes")
	@ResponseBody
	public DataTableResult listBussRes(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			pd.put("isShow", "");
			int count = menuService.listCountNew(pd);
			List<SysResource> list = menuService.listNew(pd);
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(count);	
				
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, count);
				result.put(Const.RECORDSFILTERED, count);
			}
		} catch (Exception e) {
			logger.error("list menu error", e);
//			result = new PageData();
		}
		return result;
	}
	
	@RequestMapping(value="/parentMenu")
	@ResponseBody
	public List<SysResource> parentMenu(HttpServletRequest request){
		List<SysResource> list = null;
		try {
			PageData pd = super.getPageData();
			
			list = menuService.listParentMenu(pd);

		} catch (Exception e) {
			logger.error("get parent menu error", e);
		}
		return list;
	}
}
