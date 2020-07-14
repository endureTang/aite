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
import com.nj.dao.NjProductCycleMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.SysUserMapper;
import com.nj.dao.extend.SysDictMapperExtend;
import com.nj.model.generate.SysDictExample;
import com.nj.model.generate.NjProductCycle;
import com.nj.model.generate.NjProductCycleExample;
import com.nj.model.generate.SysBusinessDict;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysUser;
import com.nj.service.enterprise.BaseCachesService;
import com.nj.model.generate.SysDictExample.Criteria;

/**
 * @FileName RoleService.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional(readOnly=true)
@Service("dictService")
public class DictService extends BaseCachesService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	public List<SysDict> list(PageData pd) throws Exception {
//		String search = pd.getString("keyword");
//		if (StringUtils.isNotBlank(search)) {
//			pd.put("keyword", "%" + search + "%");
//		}
//		int totalNum = (int) dao.findForObject("RoleMapper.count", pd);
//		
//		pd.put("from", pd.getInteger("start"));
//		pd.put("size", pd.getInteger("length"));
//		List<PageData> pds = dao.findForList("RoleMapper.list", pd);
//		AppUtil.nullToEmpty(pds, new String[]{"roleName", "description"});
		
		
		SysDictMapper sm = dao.getMapper(SysDictMapper.class);
		
		SysDictExample example = new SysDictExample();
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		
		pd.put("start", pd.getInteger("start"));
		pd.put("length", pd.getInteger("length"));
		
//		String search = pd.getString("keyword");
//		if (StringUtils.isNotBlank(search)) {
//			criteria.andTypeLike("%"+pd.get("keyword").toString()+"%");
//		}
		return sm.selectAllDict(pd);
	}
	
	public int listAllCount(PageData pd) throws Exception {
//		String search = pd.getString("keyword");
//		if (StringUtils.isNotBlank(search)) {
//			pd.put("keyword", "%" + search + "%");
//		}
//		int totalNum = (int) dao.findForObject("RoleMapper.count", pd);
//		
//		pd.put("from", pd.getInteger("start"));
//		pd.put("size", pd.getInteger("length"));
//		List<PageData> pds = dao.findForList("RoleMapper.list", pd);
//		AppUtil.nullToEmpty(pds, new String[]{"roleName", "description"});
		
		
		SysDictMapper sm = dao.getMapper(SysDictMapper.class);
		
		SysDictExample example = new SysDictExample();
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		
//		String search = pd.getString("keyword");
//		if (StringUtils.isNotBlank(search)) {
//			criteria.andTypeLike("%"+pd.get("keyword").toString()+"%");
//		}
		return sm.selectAllDictCount(pd);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void add(SysDict dict) throws Exception {
		// shiro管理的session
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		
		dict.setId(UuidUtil.get32UUID());
		dict.setCreateBy(user.getId());
		dict.setCreateDate(new Date());
		dict.setUpdateBy(user.getId());
		dict.setUpdateDate(new Date());
		dict.setDelFlag(false);
		
		SysDictMapper sm = dao.getMapper(SysDictMapper.class);
		sm.insert(dict);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Long getCount(SysDict dict) throws Exception {
		// shiro管理的session
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		
		dict.setType(dict.getType());
		dict.setValue(dict.getValue());
		
		SysDictExample example = new SysDictExample();
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		if(dict != null){
			criteria.andTypeEqualTo(dict.getType());
			criteria.andValueEqualTo(dict.getValue());
		}
		
		SysDictMapper sm = dao.getMapper(SysDictMapper.class);
		return sm.countByExample(example);
	}
	
	public SysDict getById(String id) throws Exception {
		SysDictMapper sm = dao.getMapper(SysDictMapper.class);
		return sm.selectByPrimaryKey(id);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void edit(SysDict dict) throws Exception {
		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		
		dict.setUpdateBy(user.getId());
		dict.setUpdateDate(new Date());
		
		SysDictMapper sm = dao.getMapper(SysDictMapper.class);
		sm.updateByPrimaryKeySelective(dict);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer delete(String id) throws Exception {
		SysDictMapperExtend sm = dao.getMapper(SysDictMapperExtend.class);
		return sm.delete(id);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer batchDelete(PageData pd) throws Exception {
		
		List<String> idList = com.nj.core.base.util.StringUtils.splitToStr(pd.getString("ids"), Const.COMMA);
		if (null != idList && idList.size() > 0) {
			pd.put("idList", idList);
			SysDictMapperExtend sm = dao.getMapper(SysDictMapperExtend.class);
			return sm.batchDelete(pd);
		}
		return 0;
	}

	public List<PageData> listTreeData(Integer id) throws Exception {
		List<PageData> result = new ArrayList<PageData>();
		
		PageData pd = new PageData();
		pd.put("menuType", 1);
		List<PageData> menuList = dao.findForList("MenuMapper.listBy", pd);
		pd.put("menuType", 2);
		for (PageData menu : menuList) {
			PageData p1 = new PageData();
			p1.put("id", menu.getString("menuId"));
			p1.put("pId", menu.getString("parentId"));
			p1.put("name", menu.getString("menuName"));
			p1.put("open", "true");
			p1.put("resFlag", menu.getString("menuId") + "_" + menu.getString("menuType"));
			result.add(p1);
			
			pd.put("parentId", menu.getInteger("menuId"));
			List<PageData> subMenuList = dao.findForList("MenuMapper.listBy", pd);
			for (PageData subMenu : subMenuList) {
				PageData p2 = new PageData();
				p2.put("id", subMenu.getString("menuId"));
				p2.put("pId", subMenu.getString("parentId"));
				p2.put("name", subMenu.getString("menuName"));
				p2.put("open", "true");
				p2.put("resFlag", subMenu.getString("menuId") + "_" + subMenu.getString("menuType"));
				result.add(p2);
				
				List<PageData> buttonList = dao.findForList("ButtonMapper.listByMenuId", subMenu.getInteger("menuId"));
				for (PageData button : buttonList) {
					PageData p3 = new PageData();
					p3.put("id", button.getString("menuId") + "_" + button.getString("buttonId"));
					p3.put("pId", button.getString("menuId"));
					p3.put("name", button.getString("buttonName"));
					p3.put("open", "true");
					p3.put("resFlag", button.getString("buttonId") + "_" + 3);
					result.add(p3);
				}
			}
		}
		
		List<PageData> roleResList =  dao.findForList("RoleMapper.listResByid", id);
		for (PageData roleRes : roleResList) {
			String resFlag = roleRes.getInteger("resourceId") + "_" + roleRes.getInteger("resourceType");
			for (PageData p : result) {
				if (resFlag.equals(p.getString("resFlag"))) {
					p.put("checked", true);
					break;
				}
			}
		}
		
		return result;
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void editRight(PageData pd) throws Exception {
		String selRes = pd.getString("selRes");
		if (StringUtils.isNotBlank(selRes)) {
			List<PageData> list = new ArrayList<PageData>();
			Integer id = pd.getInteger("id");
			String[] resFlags = selRes.split(",");
			for (String resFlag : resFlags) {
				String[] resArr = resFlag.split("_");
				PageData p = new PageData();
				p.put("id", id);
				p.put("resourceId", Integer.valueOf(resArr[0]));
				p.put("resourceType", Integer.valueOf(resArr[1]));
				list.add(p);
			}
			dao.delete("RoleMapper.deleteResByid", id);
			dao.batchSave("RoleMapper.saveRes", list);
		}
	}
	
	
	public List<SysDict> getListByType(String type) throws Exception {
		SysDictMapper sm = dao.getMapper(SysDictMapper.class);
		SysDictExample example = new SysDictExample();
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		criteria.andTypeLike("%"+type+"%");
		example.setOrderByClause("sort");
		return sm.selectByExample(example);
	}

	public SysDict getByTypeAndValue(String type,String value) throws Exception {
		SysDictMapper sm = dao.getMapper(SysDictMapper.class);
		SysDictExample example = new SysDictExample();
		example.createCriteria().andTypeEqualTo(type).andValueEqualTo(value);
		List<SysDict> dicts = sm.selectByExample(example);
		if(dicts.size() >0){
			return dicts.get(0);
		}
		return null;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void gets(String str,List<NjProductCycle> list1) throws Exception {
		NjProductCycleMapper sm2 = dao.getMapper(NjProductCycleMapper.class);
		NjProductCycleExample example2 = new NjProductCycleExample();
		com.nj.model.generate.NjProductCycleExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andProductIdEqualTo(str);
		sm2.deleteByExample(example2);
		
		for (NjProductCycle njProductCycle : list1) {
			sm2.insert(njProductCycle);
		}
	}

	/**
	 * 根据区域类型以及上级id获取区域列表
	 * @param pd
	 * @return
	 * @throws Exception 
	 */
	public List<SysDict> getDictAreaByParent(PageData pd) throws Exception {
		SysDictMapperExtend dictMapperExtend = dao.getMapper(SysDictMapperExtend.class);
		return dictMapperExtend.getDictAreaByParent(pd);
	}

	public SysBusinessDict getRelativeTypeByKeyword(String keyword) throws Exception {
		SysDictMapperExtend dictMapperExtend = dao.getMapper(SysDictMapperExtend.class);
		return dictMapperExtend.getRelativeTypeByKeyword(keyword);
	}

	public SysDict getByValue(String repayWay) throws Exception {
		SysDictMapperExtend dictMapperExtend = dao.getMapper(SysDictMapperExtend.class);
		return dictMapperExtend.getByValue(repayWay);
	}
	
}
