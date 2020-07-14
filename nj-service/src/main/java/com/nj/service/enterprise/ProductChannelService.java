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

package com.nj.service.enterprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.NjChannelRelativeMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.SysUserMapper;
import com.nj.dao.extend.NjChannelMapperExtend;
import com.nj.dao.extend.NjChannelRelativeMapperExtend;
import com.nj.dao.extend.NjProductChannelMapperExtend;
import com.nj.model.generate.NjChannelRelative;
import com.nj.model.generate.NjChannelRelativeExample;
import com.nj.model.generate.NjChannelRelativeExample.Criteria;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import com.nj.model.generate.NjProductScopeExample;
import com.nj.model.generate.SysDict;
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
@Transactional(readOnly=true)
@Service("productChannelService")
public class ProductChannelService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void add(NjProductChannel product) throws Exception {
		NjProductChannelMapper sm = dao.getMapper(NjProductChannelMapper.class);
		sm.insert(product);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void updateChannelName(NjProductChannel product) throws Exception {
		// shiro管理的session
		NjProductChannelMapper sm = dao.getMapper(NjProductChannelMapper.class);
		sm.updateByPrimaryKeySelective(product);
	}

	public Map getChannelInfoById(PageData pd) throws Exception {
		Map data = new HashMap<>();
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		Map map = sm.getChannelInfoById(pd);
		List<Map> list = getChannelRelativeChannelList(pd);
		List<Map> list1 = getChannelRelativeEmployeeList(pd);
		
		int len = 15;
		StringBuffer cName = new StringBuffer();
		if(list != null && list.size() > 0){
			for (Map mp : list) {
				cName.append(mp.get("channelName").toString()+"、");
			}
			if(cName.length() > len){
				cName.setLength(len);
				cName.append("...");
			}else{
				cName.setLength(cName.length()-1);
			}
		}
		
		StringBuffer eName = new StringBuffer();
		if(list1 != null && list1.size() > 0){
			for (Map mp : list1) {
				eName.append(mp.get("name").toString()+"、");
			}
			if(eName.length() > len){
				eName.setLength(len);
				eName.append("...");
			}else{
				eName.setLength(eName.length()-1);
			}
		}

		if(map != null){
			map.put("cName", cName);
			map.put("eName", eName);
		}
		
		data.put("channelInfo", map);
		data.put("channelList", list);
		data.put("employeeList", list1);
		return data;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void deleteById(String id) throws Exception {
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		sm.delete(id);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void bindChannel(PageData pd) throws Exception {
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		sm.bindChannel(pd);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void bindChannelRelative(PageData pd) throws Exception {
		NjChannelRelativeMapperExtend sm = dao.getMapper(NjChannelRelativeMapperExtend.class);
		
		sm.bindChannel(pd);
	}
	
	public List<Map> getChannelRelativeChannelList(PageData pd) throws Exception {
		NjChannelRelativeMapperExtend sm = dao.getMapper(NjChannelRelativeMapperExtend.class);
		return sm.getChannelList(pd);
	}
	
	public List<Map> getChannelRelativeEmployeeList(PageData pd) throws Exception {
		NjChannelRelativeMapperExtend sm = dao.getMapper(NjChannelRelativeMapperExtend.class);
		return sm.getEmployeeList(pd);
	}
	
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void addChannelRelative(NjChannelRelative product) throws Exception {
		// shiro管理的session
//		Subject currentUser = SecurityUtils.getSubject();
//		Session session = currentUser.getSession();
//		SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		SysUser user = new SysUser();
		user.setId("1");
		
		product.setId(UuidUtil.get32UUID());
		product.setCreateBy(user.getId());
		product.setCreateDate(new Date());
		product.setUpdateBy(user.getId());
		product.setUpdateDate(new Date());
		product.setDelFlag(false);
		
		NjChannelRelativeMapper sm = dao.getMapper(NjChannelRelativeMapper.class);
		sm.insert(product);
	}
	

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void deleteChannelRelative(String id) throws Exception {
//		NjChannelRelativeMapper sm = dao.getMapper(NjChannelRelativeMapper.class);
//		sm.deleteByPrimaryKey(id);
		NjChannelRelativeMapperExtend sm = dao.getMapper(NjChannelRelativeMapperExtend.class);
		sm.deleteChannelRelative(id);
	}

	
	
	public List<Map> getChannelList(PageData pd) throws Exception {
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		List<Map> listMap = sm.getChannelList(pd);
		if(listMap != null && listMap.size() > 0){
			for (Map map : listMap) {
				pd.put("channelId",map.get("id"));
				Map md = getChannelInfoById(pd);
				if(md != null && md.get("channelInfo") != null){
					Map channelInfo = (Map)md.get("channelInfo");
					map.put("cName", channelInfo.get("cName"));
					map.put("eName", channelInfo.get("eName"));
				}else{
					map.put("cName", "");
					map.put("eName", "");
				}
			}
		}
		
		return listMap;
		
	}
	
	public List<Map> getAllChannelsByProdId(String productId) throws Exception{
		
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		return sm.getAllChannelsByProdId(productId);
	}
	
	public List<Map> getRelChannelsByChannelInfo(String channelId) throws Exception{
		NjChannelRelativeMapperExtend sm = dao.getMapper(NjChannelRelativeMapperExtend.class);
		return sm.getLByChannelId(channelId);
	}
	
	public boolean isSaveChannelName(NjProductChannel bean) throws Exception{
		NjProductChannelMapper sm = dao.getMapper(NjProductChannelMapper.class);
		
		NjProductChannelExample example = new NjProductChannelExample();
		com.nj.model.generate.NjProductChannelExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(bean.getProductId());
		criteria.andChannelNameEqualTo(bean.getChannelName());
		criteria.andDelFlagEqualTo(false);
		
		List list = sm.selectByExample(example);
		if(list == null || list.size() == 0){
			return false;
		}
		return true;
	}
	
	public boolean isSaveChannelCode(NjProductChannel bean) throws Exception{
		NjProductChannelMapper sm = dao.getMapper(NjProductChannelMapper.class);
		
		NjProductChannelExample example = new NjProductChannelExample();
		com.nj.model.generate.NjProductChannelExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(bean.getProductId());
		criteria.andChannelCodeEqualTo(bean.getChannelCode());
		criteria.andDelFlagEqualTo(false);
		
		List list = sm.selectByExample(example);
		if(list == null || list.size() == 0){
			return false;
		}
		return true;
	}
	
	public boolean isUpdateChannelName(NjProductChannel bean) throws Exception{
		NjProductChannelMapper sm = dao.getMapper(NjProductChannelMapper.class);
		
		NjProductChannelExample example = new NjProductChannelExample();
		com.nj.model.generate.NjProductChannelExample.Criteria criteria = example.createCriteria();
		criteria.andIdNotEqualTo(bean.getId());
		criteria.andProductIdEqualTo(bean.getProductId());
		criteria.andChannelNameEqualTo(bean.getChannelName());
		criteria.andDelFlagEqualTo(false);
		
		List list = sm.selectByExample(example);
		if(list == null || list.size() == 0){
			return false;
		}
		return true;
	}
	
	public boolean isUpdateChannelCode(NjProductChannel bean) throws Exception{
		NjProductChannelMapper sm = dao.getMapper(NjProductChannelMapper.class);
		
		NjProductChannelExample example = new NjProductChannelExample();
		com.nj.model.generate.NjProductChannelExample.Criteria criteria = example.createCriteria();
		criteria.andIdNotEqualTo(bean.getId());
		criteria.andProductIdEqualTo(bean.getProductId());
		criteria.andChannelCodeEqualTo(bean.getChannelCode());
		criteria.andDelFlagEqualTo(false);
		
		List list = sm.selectByExample(example);
		if(list == null || list.size() == 0){
			return false;
		}
		return true;
	}
	
	
	public boolean isSaveChannelRelative(NjChannelRelative bean) throws Exception {

		NjChannelRelativeMapper sm = dao.getMapper(NjChannelRelativeMapper.class);
		
		NjChannelRelativeExample example = new NjChannelRelativeExample();
		com.nj.model.generate.NjChannelRelativeExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(bean.getProductId());
		criteria.andChannelIdEqualTo(bean.getChannelId());
		criteria.andDelFlagEqualTo(false);
		criteria.andChannelOpenIdEqualTo(bean.getChannelOpenId());
		
//		if(bean.getAccountType() == 0){//下级渠道
//			criteria.andNameEqualTo(bean.getName());
//		}else{
//			criteria.andChannelAcctEqualTo(bean.getChannelAcct());
//		}
		
		List list = sm.selectByExample(example);
		if(list == null || list.size() == 0){
			return false;
		}
		return true;
	}

	public NjProductChannel getChannelByChannelCodeAndProductId(String productId, String channelCode) throws Exception {
		NjProductChannelMapperExtend channelMapperExtend = dao.getMapper(NjProductChannelMapperExtend.class);
		NjProductChannel channel = channelMapperExtend.getChannelByChannelCodeAndProductId(productId,channelCode);
		return channel;
	}
}
