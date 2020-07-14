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
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.nj.model.generate.SysRole;
import com.nj.service.base.system.RoleService;
import com.nj.service.enterprise.CoporateService;

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
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Resource(name = "roleService")
	private RoleService roleService;
	
	@Resource(name = "coporateService")
	private CoporateService coporateService;
	
	@ResourcesAnnotion(uri="/role/page",name="角色管理",resourceType=1,parentId="3")
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/role/role_list");
		return mv;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public PageData list(HttpServletRequest request){
		//DataTableResult result = new DataTableResult(request);
		PageData result = new PageData();
		try {
			
			PageData pd = super.getPageData();
			pd.put("start", pd.getInteger("start"));
			pd.put("length", pd.getInteger("length"));
			result = roleService.list(pd);
//			if(list != null && list.size() > 0){
//				result.insertDataList(list);
//				result.setTotalCount(list.size());	
//				
//				result.put(Const.DRAW, pd.getString(Const.DRAW));
//				result.put(Const.RECORDSTOTAL, list.size());
//				result.put(Const.RECORDSFILTERED, list.size());
//			}
			result.put(Const.DRAW, pd.getString(Const.DRAW));
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return result;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView toAdd(){
		ModelAndView mv = super.getModelAndView();
		List<Map<String,String>> roleList = roleService.getRoleList();
		mv.addObject("roleList", roleList);
		mv.setViewName("sys/role/role_add");
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			boolean validateRoleType = roleService.validateRoleType(  pd);
			if(!validateRoleType){
				result.put("status", 0);
				result.put("msg", "新增失败：角色类型"+pd.getString("roleType")+"已经存在");
			}else{
				roleService.add(pd);
				result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("add role error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam String roleId) throws Exception{
		SysRole role = null;
		try {
			role = roleService.getById(roleId);
		} catch (Exception e) {
			logger.error("get role error", e);
		}
		PageData pd  =  new  PageData();
		List<Map> coporateList = coporateService.selectAllList(pd);
		List<Map<String,String>> roleList = roleService.getRoleList();
		ModelAndView mv = super.getModelAndView();
		mv.addObject("role", role);
		mv.addObject("roleList", roleList);
		mv.addObject("coporateList", coporateList);
		mv.setViewName("sys/role/role_edit");
		return mv;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			boolean validateRoleType = roleService.validateRoleType( pd);
			if(!validateRoleType){
				result.put("status", 0);
				result.put("msg", "更新失败：角色类型"+pd.getString("roleType")+"已经存在");
			}else{
				roleService.edit(pd);
				result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("edit role error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam String id){
		PageData result = new PageData();
		try {
			Integer line = roleService.delete(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
		} catch (Exception e) {
			logger.error("delete role error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchDelete")
	@ResponseBody
	public PageData batchDelete(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			int length = pd.getString("ids").split(",").length;
			Integer line =roleService.batchDelete(pd);
			if(line<length){
				result.put("status", 0);
				result.put("msg", "成功【"+line+"】条,失败【"+(length-line)+"】条");
			}else{
			result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("batch delete role error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/editRight", method=RequestMethod.GET)
	public ModelAndView toEditRight(@RequestParam String roleId){
//		PageData pd = null;
//		try {
//			pd = roleService.getById(id);
//		} catch (Exception e) {
//			logger.error("to edit right error", e);
//		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("roleId", roleId);
		mv.setViewName("sys/role/role_right_edit");
		return mv;
	}
	
	@RequestMapping(value="/resNodes")
	@ResponseBody
	public List<PageData> resNodes(@RequestParam String roleId){
		List<PageData> treeData = null;
		try {
			SysRole role = roleService.getById(roleId);
			if(role != null) {
				if(role.getType().intValue() == 1) {
					treeData = roleService.listTreeDataSys(roleId);
				}else if(role.getType().intValue() == 2){
					treeData = roleService.listTreeData(roleId);
				}else {
					logger.error("type不能为空");
				}
			}else {
				logger.error(roleId+"没有检索到相关角色");
			}
		} catch (Exception e) {
			logger.error("get res nodes error", e);
			treeData = new ArrayList<PageData>();
		}
		return treeData;
	}
	
	@RequestMapping(value="/editRight", method=RequestMethod.POST)
	@ResponseBody
	public PageData editRight(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			roleService.editRight(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit right error", e);
			result.put("status", 0);
			result.put("msg", "编辑权限失败");
		}
		return result;
	}

}
