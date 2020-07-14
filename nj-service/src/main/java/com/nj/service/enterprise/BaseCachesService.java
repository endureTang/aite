package com.nj.service.enterprise;

import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.ProtostuffUtil;
import com.nj.core.base.util.StringUtils;
import com.nj.model.generate.NjOrderFlowProcedure;
import com.nj.model.generate.NjOrderFlowProcedureExample;
import com.nj.model.generate.NjOrderFlows;
import com.nj.model.generate.NjOrderFlowsExample;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.NjUserInfoExample;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysDictExample;
import com.nj.model.generate.SysRole;
import com.nj.model.generate.SysRoleExample;
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.NjOrderFlowProcedureMapper;
import com.nj.dao.NjOrderFlowsMapper;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.SysRoleMapper;
import com.nj.dao.extend.NjOrderProcessMapperExtend;

public class BaseCachesService {

	@Resource(name = "BaseDao")
	protected BaseDao dao;

	private static Logger logger = LoggerFactory.getLogger(BaseCachesService.class);
	
	/*
	 * 获取系统所有角色
	 */

		public static<T> List<T> getRecords(Class<T> c, Selector s) throws InstantiationException, IllegalAccessException {
		     List<T> list = new ArrayList<T>();

		         T row = c.newInstance(); 
		         list.add(row); 
		      return list; 
		}

	public List<NjUserInfo> getAllNjUserInfo() throws Exception{
		Object cachs = EhCacheUtil.getInstance().get(EhCacheConstant.NOR_CACH, EhCacheConstant.USERS_CACHE);
		if(cachs != null){
			@SuppressWarnings("unchecked")
			List<NjUserInfo> users = (List<NjUserInfo>) cachs;
			
			return users;
			
		}else{
			logger.debug("get roles from db");
			//从数据库加载到缓存，同时返回查询结果
			NjUserInfoMapper mapper = dao.getMapper(NjUserInfoMapper.class);
			NjUserInfoExample example = new NjUserInfoExample();
			List<NjUserInfo> srs = mapper.selectByExample(example);
			
			//单独将用户放入缓存
			for(NjUserInfo user : srs){
				EhCacheUtil.getInstance().put(EhCacheConstant.NOR_CACH, user.getUserMobile(),srs);
			}
			
			EhCacheUtil.getInstance().put(EhCacheConstant.NOR_CACH, EhCacheConstant.USERS_CACHE,srs);
			return srs;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SysRole> getAllSysRoles() throws Exception{
		
		Object cachs = EhCacheUtil.getInstance().get(EhCacheConstant.NOR_CACH, EhCacheConstant.ROLES_CACH);
		if(cachs != null){
			List<SysRole> roles = (List<SysRole>) cachs;
	
			logger.debug("get roles from cache: "+ roles.toString());
			return roles;
			
		}else{
			logger.debug("get roles from db");
			//从数据库加载到缓存，同时返回查询结果
			SysRoleMapper mapper = dao.getMapper(SysRoleMapper.class);
			SysRoleExample example = new SysRoleExample();
			List<SysRole> srs = mapper.selectByExample(example);
			;
			EhCacheUtil.getInstance().put(EhCacheConstant.NOR_CACH, EhCacheConstant.ROLES_CACH,srs);
			return srs;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<NjOrderFlowProcedure> getOrderProcedures() throws Exception{
		
		Object cachs = EhCacheUtil.getInstance().get(EhCacheConstant.NOR_CACH, EhCacheConstant.ORDER_PROCEDURE);
		if(cachs != null){
			List<NjOrderFlowProcedure> roles = (List<NjOrderFlowProcedure>) cachs;
	
			logger.debug("get procedure from cache: "+ roles.toString());
			return roles;
			
		}else{
			logger.debug("get procedure from db");
			//从数据库加载到缓存，同时返回查询结果
			NjOrderFlowProcedureMapper mapper = dao.getMapper(NjOrderFlowProcedureMapper.class);
			NjOrderFlowProcedureExample example = new NjOrderFlowProcedureExample();
			List<NjOrderFlowProcedure> srs = mapper.selectByExample(example);
			
			EhCacheUtil.getInstance().put(EhCacheConstant.NOR_CACH, EhCacheConstant.ORDER_PROCEDURE,srs);
			return srs;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<NjOrderFlows> getOrderFlows() throws Exception{
		
		Object cachs = EhCacheUtil.getInstance().get(EhCacheConstant.NOR_CACH, EhCacheConstant.ORDER_FLOWS);
		if(cachs != null){
			List<NjOrderFlows> roles = (List<NjOrderFlows>) cachs;
	
			logger.debug("get procedure from cache: "+ roles.toString());
			return roles;
			
		}else{
			logger.debug("get procedure from db");
			//从数据库加载到缓存，同时返回查询结果
			NjOrderFlowsMapper mapper = dao.getMapper(NjOrderFlowsMapper.class);
			NjOrderFlowsExample example = new NjOrderFlowsExample();
			List<NjOrderFlows> srs = mapper.selectByExample(example);
			
			EhCacheUtil.getInstance().put(EhCacheConstant.NOR_CACH, EhCacheConstant.ORDER_FLOWS,srs);
			return srs;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Map> getOrderProcesses() throws Exception{
		
		Object cachs = EhCacheUtil.getInstance().get(EhCacheConstant.NOR_CACH, EhCacheConstant.ORDER_PROCESSES);
		if(cachs != null){
			List<Map> process = (List<Map>) cachs;
			return process;
			
		}else{
			logger.debug("get procedure from db");
			//从数据库加载到缓存，同时返回查询结果
			NjOrderProcessMapperExtend mapper = dao.getMapper(NjOrderProcessMapperExtend.class);
			
			List<Map> srs = mapper.getOrderProcess();
			
			EhCacheUtil.getInstance().put(EhCacheConstant.NOR_CACH, EhCacheConstant.ORDER_PROCESSES,srs);
			return srs;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Map> getProcessStatus(PageData pd) throws Exception{
		
		String processType = pd.getString("processType");
		if(!StringUtils.isNotEmptyAndNull(processType)){
			processType = EhCacheConstant.PROCESSES_STATUS;
		}
		
		Object cachs = EhCacheUtil.getInstance().get(EhCacheConstant.NOR_CACH, processType);
		if(cachs != null){
			List<Map> process = (List<Map>) cachs;
			return process;
			
		}else{
			logger.debug("get procedure from db");
			//从数据库加载到缓存，同时返回查询结果
			NjOrderProcessMapperExtend mapper = dao.getMapper(NjOrderProcessMapperExtend.class);
			
			List<Map> srs = mapper.getProcessStatus(pd);
			
			EhCacheUtil.getInstance().put(EhCacheConstant.NOR_CACH, processType,srs);
			return srs;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysDict> getDicByTypeValue(PageData pd) throws Exception{
		
		Object cachs = EhCacheUtil.getInstance().get(EhCacheConstant.NOR_CACH, EhCacheConstant.SYS_DIC_CACHE);
		if(cachs != null){
			List<SysDict> dics = (List<SysDict>) cachs;
			return dics;
			
		}else{
			SysDictMapper sm = dao.getMapper(SysDictMapper.class);
			SysDictExample example = new SysDictExample();
			List<SysDict> dicts = sm.selectByExample(example);
			EhCacheUtil.getInstance().put(EhCacheConstant.NOR_CACH, EhCacheConstant.SYS_DIC_CACHE,dicts);
			return dicts;
		}
	
	}

	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}
}

