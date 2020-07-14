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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.AppUtil;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.SysDictMapper;
import com.nj.dao.SysResourceMapper;
import com.nj.dao.SysRoleResourceMapper;
import com.nj.dao.extend.SysDictMapperExtend;
import com.nj.dao.extend.SysResourceMapperExtend;
import com.nj.dao.SysResourceMapper;
import com.nj.model.generate.SysResource;
import com.nj.model.generate.SysResourceExample;
import com.nj.model.generate.SysResource;
import com.nj.model.generate.SysUser;
import com.nj.model.generate.SysResourceExample.Criteria;
import com.nj.model.generate.SysRoleResource;

/**
 * @FileName MenuService.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional(readOnly=true)
@Service("menuService")
public class MenuService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public List<SysResource> list(PageData pd) throws Exception {
		
		SysResourceMapper sm = dao.getMapper(SysResourceMapper.class);
		
		SysResourceExample example = new SysResourceExample();
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		
		if("1".equals(pd.get("menuType").toString())){
			criteria.andParentIdEqualTo("0");
		}else{
			criteria.andParentIdEqualTo(pd.get("parentId").toString());
		}
		
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			criteria.andNameLike("%"+search+"%");
			
			Criteria criteria1 = example.or();   
			criteria1.andDelFlagEqualTo(false);
			criteria1.andHrefLike("%"+search+"%");
			
			if("1".equals(pd.get("menuType").toString())){
				criteria1.andParentIdEqualTo("0");
			}else{
				criteria1.andParentIdEqualTo(pd.get("parentId").toString());
			}
		}
		example.setOrderByClause("sort");
		
		return sm.selectByExample(example);
	}
	
	
	public List<SysResource> listNew(PageData pd) throws Exception {
		
		SysResourceMapper sm = dao.getMapper(SysResourceMapper.class);
		
		SysResourceExample example = new SysResourceExample();
		example.setLength(pd.getInteger("length"));
		example.setStart(pd.getInteger("start"));
		
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		
		if("1".equals(pd.get("isShow").toString())){
			criteria.andIsShowEqualTo("1");
		}else if ("2".equals(pd.get("isShow").toString())) {
			criteria.andIsShowEqualTo("2");
		}else {
			criteria.andIsShowEqualTo("");
		}
		
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			criteria.andNameLike("%"+search+"%");
			
			Criteria criteria1 = example.or();   
			criteria1.andDelFlagEqualTo(false);
			criteria1.andHrefLike("%"+search+"%");
			
			if("1".equals(pd.get("isShow").toString())){
				criteria1.andIsShowEqualTo("1");
			}else{
				criteria1.andIsShowEqualTo("2");
			}
		}
		example.setOrderByClause("sort");
		
		return sm.selectByExampleNew(example);
	}
	
	
	public int listCountNew(PageData pd) throws Exception {
		
		SysResourceMapper sm = dao.getMapper(SysResourceMapper.class);
		
		SysResourceExample example = new SysResourceExample();
		example.setLength(pd.getInteger("length"));
		example.setStart(pd.getInteger("start"));
		
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		
		if("1".equals(pd.get("isShow").toString())){
			criteria.andIsShowEqualTo("1");
		}else if ("2".equals(pd.get("isShow").toString())) {
			criteria.andIsShowEqualTo("2");
		}else {
			criteria.andIsShowEqualTo("");
		}
		
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			criteria.andNameLike("%"+search+"%");
			
			Criteria criteria1 = example.or();   
			criteria1.andDelFlagEqualTo(false);
			criteria1.andHrefLike("%"+search+"%");
			
			if("1".equals(pd.get("isShow").toString())){
				criteria1.andIsShowEqualTo("1");
			}else{
				criteria1.andIsShowEqualTo("2");
			}
		}
		example.setOrderByClause("sort");
		
		return sm.selectByExampleCountNew(example);
	}
	
	public List<SysResource> listParentMenu(PageData pd) throws Exception{
		SysResourceMapper sm = dao.getMapper(SysResourceMapper.class);
		
		SysResourceExample example = new SysResourceExample();
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		
		if("1".equals(pd.get("isShow").toString())){
			criteria.andIsShowEqualTo("1");
		}else{
			criteria.andIsShowEqualTo("2");
		}
		criteria.andParentIdEqualTo("0");
		
		return sm.selectByExample(example);
	}
//	@SuppressWarnings("unchecked")
//	public List<Menu> list(PageData pd) throws Exception {
//		pd.put("menuType", 1);
//		List<Menu> menus = (List<Menu>) dao.findForList("MenuMapper.list", pd);
//		
//		pd.put("menuType", 2);
//		for (Menu menu : menus) {
//			pd.put("parentId", menu.getMenuId());
//			List<Menu> subMenus = (List<Menu>) dao.findForList("MenuMapper.list", pd);
//			menu.setSubMenu(subMenus);
//		}
//		return menus;
//	}
	
	public List<SysResource> listMenu(PageData pd) throws Exception {
		pd.put("menuType", 2);
		List<SysResource> subMenus = dao.findForList("MenuMapper.list", pd);
		return subMenus;
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void add(PageData pd) throws Exception {
		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		
		SysResource res = new SysResource();
		res.setId(UuidUtil.get32UUID());
		
		if(pd.getString("menuName") != null){
			res.setName(pd.getString("menuName"));
		}
		if(pd.getString("menuUrl") != null){
			res.setHref(pd.getString("menuUrl"));
		}
		if(pd.getString("menuOrder") != null){
			res.setSort(pd.getInteger("menuOrder"));
		}
		if(pd.getString("description") != null){
			res.setRemarks(pd.getString("description"));
		}
		if(pd.getString("parentId") != null && !"".equals(pd.getString("parentId"))){
			res.setParentId(pd.getString("parentId"));
		}else{
			res.setParentId("0");
		}
		if(pd.getString("isShow") != null){
			res.setIsShow(pd.getString("isShow"));
		}
		res.setParentIds("");
		res.setPermission("");
		
		res.setCreateBy(user.getId());
		res.setCreateDate(new Date());
		res.setUpdateBy(user.getId());
		res.setUpdateDate(new Date());
		res.setDelFlag(false);
		
		SysResourceMapper sm = dao.getMapper(SysResourceMapper.class);
		sm.insert(res);
		
		// 统一添加为企业管理员
		addRoleResource("4", res.getId());
	}
	
	public void addRoleResource(String roleId, String menuId) throws Exception{
		SysRoleResource sysRoleResource = new SysRoleResource();
		sysRoleResource.setId(UuidUtil.get32UUID());
		sysRoleResource.setRoleId(roleId);
		sysRoleResource.setMenuId(menuId);
		SysRoleResourceMapper sm = dao.getMapper(SysRoleResourceMapper.class);
		sm.insert(sysRoleResource);
	}
	
	public SysResource getById(String id) throws Exception {
		SysResourceMapper sm = dao.getMapper(SysResourceMapper.class);
		return sm.selectByPrimaryKey(id);
	}
	
	public List<SysResource> getHierarchyByPath(String url) throws Exception {
		List<SysResource> lists = new ArrayList<SysResource>(2);
		SysResource menu = (SysResource) dao.findForObject("MenuMapper.getByPath", url);
		if(menu != null){
			if(!"0".equals(menu.getParentId())){
				SysResource parent = (SysResource) dao.findForObject("getMenuById", menu.getParentId());
				lists.add(parent);
			}
			lists.add(menu);
		}
		return lists;
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void edit(SysResource res) throws Exception {
		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		
		res.setUpdateBy(user.getId());
		res.setUpdateDate(new Date());
		
		SysResourceMapper sm = dao.getMapper(SysResourceMapper.class);
		sm.updateByPrimaryKeySelective(res);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer delete(String id) throws Exception {
		SysResourceMapperExtend sm = dao.getMapper(SysResourceMapperExtend.class);
		return sm.delete(id);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer batchDelete(String ids) throws Exception {
		
		List<String> idList = com.nj.core.base.util.StringUtils.splitToStr(ids, Const.COMMA);
		if (null != idList && idList.size() > 0) {
			PageData pd = new PageData();
			pd.put("idList", idList);
			SysResourceMapperExtend sm = dao.getMapper(SysResourceMapperExtend.class);
			return sm.batchDelete(pd);
		}
		return 0;
	}

}
