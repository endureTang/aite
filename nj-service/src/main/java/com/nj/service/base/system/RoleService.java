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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.enums.ERoleType;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.SysResourceMapper;
import com.nj.dao.SysRoleMapper;
import com.nj.dao.SysRoleResourceMapper;
import com.nj.dao.extend.SysRoleMapperExtend;
import com.nj.dao.extend.SysRoleResourceMapperExtend;
import com.nj.model.generate.SysResource;
import com.nj.model.generate.SysResourceExample;
import com.nj.model.generate.SysRole;
import com.nj.model.generate.SysRoleExample;
import com.nj.model.generate.SysRoleExample.Criteria;
import com.nj.model.generate.SysRoleResource;
import com.nj.model.generate.SysRoleResourceExample;
import com.nj.model.generate.SysUser;

/**
 * @FileName RoleService.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional
@Service("roleService")
public class RoleService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
    @Resource
    private SysRoleMapper  SysRoleMapper;
    
    @Resource
    private SysRoleResourceMapper  sysRoleResourceMapper;
    
    @Resource
    private SysRoleResourceMapperExtend  sysRoleResourceMapperExtend;
    
    @Resource
    private SysRoleMapperExtend  sysRoleMapperExtend;
    
	public PageData list(PageData pd) throws Exception {
//		PageData result = new PageData();
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
//		
//		result.put(Const.DRAW, pd.getString(Const.DRAW));
//		result.put(Const.RECORDSTOTAL, totalNum);
//		result.put(Const.RECORDSFILTERED, totalNum);
//		result.put(Const.NDATA, pds);
		
		// 创建公司

		
		SysRoleMapper sm = dao.getMapper(SysRoleMapper.class);
		
		SysRoleExample example = new SysRoleExample();
		Criteria criteria = example.createCriteria();   
		criteria.andDelFlagEqualTo(false);
		if(pd.containsKey("type") && pd.getInteger("type")!=null) {
			criteria.andTypeEqualTo(pd.getInteger("type"));
		}
		
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("name", search);
		}else{
			pd.remove("keyword");
		}
		
		String coporateId = pd.getString("coporateId");
		if (!StringUtils.isNotBlank(coporateId)) {
			pd.remove("coporateId");
		}
		
		 
		 List<Map> selectRoleList = sm.selectRoleList( pd);
		 ERoleType[] eRoleTypes = ERoleType.values();
		 Map<String,String>  roleMap  =  new HashMap<String,String>();
		 for(ERoleType type :eRoleTypes){
			 roleMap.put(type.getValue(), type.getName());
		 }
		 for(Map map :selectRoleList){
			 String  str  = (String) map.get("roleType");
			 String  roleTypeName  = roleMap.containsKey(str)?roleMap.get(str):str;
			 map.put("roleType", roleTypeName);
			
		 }
		 long  selectRoleListCount = sm.selectRoleListCount(pd);
		 PageData pd1 = new PageData();

		pd1.put(Constants.Datas.RECORDSFILTERED, selectRoleListCount);
		pd1.put(Constants.Datas.NDATA, selectRoleList);
		return pd1;
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void add(PageData pd) throws Exception {
		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		
		SysRole role = new SysRole();
		if(pd.getString("roleName") != null){
			role.setName(pd.getString("roleName"));
		}
		if(pd.getString("description") != null){
			role.setRemarks(pd.getString("description"));
		}
		if(pd.getString("type") != null){
			role.setType(pd.getInteger("type"));
		}
		if(pd.getString("coporateId") != null){
			role.setOfficeId(pd.getString("coporateId"));
		}
		
		if(pd.getString("roleType") != null){
			role.setRoleType(pd.getString("roleType"));
		}
		
		role.setId(UuidUtil.get32UUID());
		role.setCreateBy(user.getId());
		role.setCreateDate(new Date());
		role.setUpdateBy(user.getId());
		role.setUpdateDate(new Date());
		role.setDelFlag(false);
		
		SysRoleMapper sm = dao.getMapper(SysRoleMapper.class);
		sm.insert(role);
	}
	
	public SysRole getById(String id) throws Exception {
		SysRoleMapper sm = dao.getMapper(SysRoleMapper.class);
		return sm.selectByPrimaryKey(id);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void edit(PageData pd) throws Exception {
		SysRoleMapper srMapper = dao.getMapper(SysRoleMapper.class);
		SysRole record = new SysRole();
		record.setId(pd.getString("roleId"));
		record.setName(pd.getString("roleName"));
		record.setRemarks(pd.getString("remarks"));
		record.setOfficeId(pd.getString("coporateId"));
		record.setType(pd.getInteger("type"));
		record.setUpdateDate(new Date());
		if(pd.getString("roleType") != null){
			record.setRoleType(pd.getString("roleType"));
		}
		srMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer delete(String id) throws Exception {
		SysRoleMapperExtend sm = dao.getMapper(SysRoleMapperExtend.class);
		return sm.delete(id);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer batchDelete(PageData pd) throws Exception {
		List<String> idList = com.nj.core.base.util.StringUtils.splitToStr(pd.getString("ids"), Const.COMMA);
		if (null != idList && idList.size() > 0) {
			pd.put("idList", idList);
			SysRoleMapperExtend sm = dao.getMapper(SysRoleMapperExtend.class);
			return sm.batchDelete(pd);
		}
		return 0;
	}

	public List<PageData> listTreeData(String roleId) throws Exception {

		

		
		
		List<PageData> result = new ArrayList<PageData>();
		
		SysResourceMapper resourceMapper = dao.getMapper(SysResourceMapper.class);
		String[] strs= {"2","3"};
		SysResourceExample rExample = new SysResourceExample();
		com.nj.model.generate.SysResourceExample.Criteria rCriteria = rExample.createCriteria();
		rCriteria.andParentIdGreaterThanOrEqualTo("0");
		//rCriteria.andIsShowEqualTo(SysResource.IsShow.LOAN.getValue());
		rCriteria.andIsShowIn(Arrays.asList(strs));
		
		List<SysResource> allResourceList = resourceMapper.selectByExample(rExample);
		
		SysRoleResourceMapper rrMapper = dao.getMapper(SysRoleResourceMapper.class);
		SysRoleResourceExample rrExample = new SysRoleResourceExample();
		com.nj.model.generate.SysRoleResourceExample.Criteria rrCriteria = rrExample.createCriteria();
		rrCriteria.andRoleIdEqualTo(String.valueOf(roleId));
		List<SysRoleResource> rrList = rrMapper.selectByExample(rrExample);
		
		Map<String,SysRoleResource> map = new HashMap<String,SysRoleResource>();
		for (SysRoleResource rr : rrList) {
			map.put(rr.getMenuId(), rr);
		}
		
		for (SysResource r : allResourceList) {
			PageData pd = new PageData();
			pd.put("id", r.getId());
			pd.put("pId", r.getParentId());
			pd.put("name", r.getName());
			pd.put("open", "true");
			if(map.containsKey(r.getId())){
				pd.put("checked", true);
			}
			result.add(pd);
		}
		return result;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void editRight(PageData pd) throws Exception {
		
		String selIds = pd.getString("selIds");
		String roleId = pd.getString("roleId");
		
		SysRoleResourceMapperExtend rrMapperEx = dao.getMapper(SysRoleResourceMapperExtend.class);
		rrMapperEx.deleteSysAuth(roleId, SysResource.IsShow.LOAN.getValue());
		
		if (StringUtils.isNotBlank(selIds)) {
			List<PageData> list = new ArrayList<PageData>();
			String[] selIdArray = selIds.split(",");
			for (String resourceId : selIdArray) {
				PageData p = new PageData();
				p.put("roleId", roleId);
				p.put("menuId", resourceId);
				list.add(p);
			}
			
			SysRoleResourceMapperExtend srrMapperEx = dao.getMapper(SysRoleResourceMapperExtend.class);
			srrMapperEx.batchInsert(list);
		}
	}

	/**
	 * 获取所有角色列表
	 * @param pd
	 * @return
	 * @throws Exception 
	 */
	public List<SysRole> getAllRoleList(PageData pd) throws Exception {
		SysRoleMapperExtend extend = dao.getMapper(SysRoleMapperExtend.class);
		return extend.selectAllRoleList(pd);
	}

	/**
	 * 根据用户ID获取用户拥有角色列表
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	public List<SysRole> getUserHasRoleList(String userId,Integer type) throws Exception {
		SysRoleMapperExtend extend = dao.getMapper(SysRoleMapperExtend.class);
		PageData pd = new PageData();
		pd.put("userId", userId);
		pd.put("type", type);
		return extend.selectUserHasRoleList(pd);
	}

	public List<PageData> listTreeDataSys(String roleId) throws Exception {
		List<PageData> result = new ArrayList<PageData>();
		
		SysResourceMapper resourceMapper = dao.getMapper(SysResourceMapper.class);
		String[] strs= {"1"};
		SysResourceExample rExample = new SysResourceExample();
		com.nj.model.generate.SysResourceExample.Criteria rCriteria = rExample.createCriteria();
		rCriteria.andParentIdGreaterThanOrEqualTo("0");
		//rCriteria.andIsShowEqualTo(SysResource.IsShow.LOAN.getValue());
		rCriteria.andIsShowIn(Arrays.asList(strs));
		
		List<SysResource> allResourceList = resourceMapper.selectByExample(rExample);
		
		SysRoleResourceMapper rrMapper = dao.getMapper(SysRoleResourceMapper.class);
		SysRoleResourceExample rrExample = new SysRoleResourceExample();
		com.nj.model.generate.SysRoleResourceExample.Criteria rrCriteria = rrExample.createCriteria();
		rrCriteria.andRoleIdEqualTo(String.valueOf(roleId));
		List<SysRoleResource> rrList = rrMapper.selectByExample(rrExample);
		
		Map<String,SysRoleResource> map = new HashMap<String,SysRoleResource>();
		for (SysRoleResource rr : rrList) {
			map.put(rr.getMenuId(), rr);
		}
		
		for (SysResource r : allResourceList) {
			PageData pd = new PageData();
			pd.put("id", r.getId());
			pd.put("pId", r.getParentId());
			pd.put("name", r.getName());
			pd.put("open", "true");
			if(map.containsKey(r.getId())){
				pd.put("checked", true);
			}
			result.add(pd);
		}
		return result;
	}
	
	public  boolean  validateRoleType(PageData  pd) throws Exception{
		boolean  flag  =  false;
	
		String roleId = pd.getString("roleId");
		SysRoleMapper mapper = dao.getMapper(SysRoleMapper.class);
		SysRoleExample example  =  new SysRoleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andDelFlagEqualTo(false);
		
		String  roleType  = pd.getString("roleType");
		if(ERoleType.NORMAL.getValue().equalsIgnoreCase(roleType)){
			flag  =  true;
		}else{
		
			if(StringUtils.isBlank(roleType)){
				return  flag;
			}else{
				createCriteria.andRoleTypeEqualTo(roleType);
			}
			//type:1管理；2；业务
			String type = pd.getString("type");
			String officeId = pd.getString("coporateId");
			if("1".equals(type)){
				createCriteria.andOfficeIdIsNull();
			}else{
				createCriteria.andOfficeIdEqualTo(officeId);
			}
			List<SysRole> list = mapper.selectByExample(example  );
		
			if(list.size()== 0){
				flag  = true;
			}else{
				flag  =  true;
				for(SysRole  sysRole: list){
					System.out.println("roleId=="+roleId);
					System.out.println("sysRole.getId()=="+sysRole.getId());
					if(!roleId.equalsIgnoreCase(sysRole.getId()) ){
					   flag  =  false;
					   break;
					}
				}
			
			}
		
		}
		return  flag;
	}
	
	public  List<SysRole>  selectByExample(SysRoleExample example){
		List<SysRole> list = SysRoleMapper.selectByExample(example);
		return  list;
	}
    
	@Transactional(readOnly=false)
	public void copyRights(String sourceCoporateId, String targetCoporateId) {
		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		
		
		
	
		SysRoleExample example  =  new  SysRoleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andOfficeIdEqualTo(targetCoporateId);
		List<SysRole> invalidRoleObjList = SysRoleMapper.selectByExample(example);
		List<String> invalidRoleList =  new  ArrayList<String>();
		for(SysRole  sysRole:  invalidRoleObjList){
			invalidRoleList.add( sysRole.getId() );
		}
		SysRoleMapper.deleteByExample(example );
		
		//得到角色对应的权限信息
		List<Map<String,Object>> resourceList = sysRoleMapperExtend.selectResourceByCoporateId(sourceCoporateId);
		Map<String,String>  resourceMap =  new  HashMap<String,String>();
		for(Map<String,Object>  map : resourceList){
			String  roleId = String.valueOf( map.get("roleId") );
			String  menuId = String.valueOf( map.get("menuId") );
			if(resourceMap.containsKey(roleId)){
				String value = resourceMap.get(roleId);
				value= value+","+menuId;
				resourceMap.put(roleId, value);
			}else{
				resourceMap.put(roleId, menuId);
			}
		}
		
		
		//更新角色表
		example.clear();
		Criteria queryCri = example.createCriteria();
		queryCri.andOfficeIdEqualTo(sourceCoporateId);
		queryCri.andDelFlagEqualTo(false);
		List<SysRole> list = SysRoleMapper.selectByExample(example);
       Map<String,String>  targetResourceMap =  new  HashMap<String,String>();
		for(SysRole  sysRole:  list){
			String uuid = UuidUtil.get32UUID();
			SysRole  role  =  new  SysRole();
			BeanUtils.copyProperties(sysRole, role);
			role.setId(uuid);
			role.setOfficeId(targetCoporateId);
			role.setCreateBy(user.getId());
			role.setCreateDate(new Date());
			role.setUpdateBy(user.getId());
			role.setUpdateDate(new Date());
			role.setRoleType(sysRole.getRoleType());
			SysRoleMapper.insert(role);
			targetResourceMap.put(uuid, resourceMap.get(sysRole.getId()) );
		}
		
		
		//删除权限表
		SysRoleResourceExample delexample =  new SysRoleResourceExample();
		delexample.createCriteria().andRoleIdIn(invalidRoleList);
		if(invalidRoleList.size()>0){
			sysRoleResourceMapper.deleteByExample(delexample );
		}
		
		
		//更新权限表
		List<SysRoleResource> insertList =   new  ArrayList<SysRoleResource>();
		Iterator<Entry<String, String>> iterator = targetResourceMap.entrySet().iterator();
		while(iterator.hasNext()){
			
			Entry<String, String> entry = iterator.next();
			String roleId = entry.getKey();
			String[] valueArray = entry.getValue().split(",",-1);
			
			for(String value:valueArray){
				SysRoleResource  srr  =  new  SysRoleResource();
				srr.setMenuId(value);
				srr.setRoleId(roleId);
				srr.setId(UuidUtil.get32UUID());
				
				insertList.add(srr);
			}
			
		}
		sysRoleResourceMapperExtend.freshBatchInsert(insertList);
		
	}

	public List<Map<String,String>>  getRoleList() {
		List<Map<String,String>>  list  =  new  LinkedList<Map<String,String>>();
		ERoleType[] values = ERoleType.values();
		for(ERoleType  type: values){
			Map<String,String>  map  =  new HashMap<String,String>();
			map.put("roleName",type.getName());
			map.put("roleValue",type.getValue());
			list.add(map);
		}
		return list;
	}
	


}
