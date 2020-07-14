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

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjFundConfMapper;
import com.nj.dao.NjProdPayeeObjMapper;
import com.nj.dao.NjProdRepayObjMapper;
import com.nj.dao.NjProductTransactionOfflineMapper;
import com.nj.dao.NjProductTransactionOnlineMapper;
import com.nj.dao.NjProductTransactionRelativeMapper;
import com.nj.dao.extend.NjFundMapperExtend;
import com.nj.dao.extend.NjProductTransactionMapperExtend;
import com.nj.model.generate.NjFund;
import com.nj.model.generate.NjFundConf;
import com.nj.model.generate.NjFundConfExample;
import com.nj.model.generate.NjProdPayeeObj;
import com.nj.model.generate.NjProdPayeeObjExample;
import com.nj.model.generate.NjProdRepayObj;
import com.nj.model.generate.NjProdRepayObjExample;
import com.nj.model.generate.NjProductTransaction;
import com.nj.model.generate.NjProductTransactionOffline;
import com.nj.model.generate.NjProductTransactionOfflineExample;
import com.nj.model.generate.NjProductTransactionOnline;
import com.nj.model.generate.NjProductTransactionOnlineExample;
import com.nj.model.generate.NjProductTransactionRelative;
import com.nj.model.generate.NjProductTransactionRelativeExample;

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
@Service("productTransactionService")
public class ProductTransactionService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void saveAll(PageData result) throws Exception {
		String proId = result.getString("id");
		
		NjFundConfMapper sm = dao.getMapper(NjFundConfMapper.class);
		NjFundConfExample e = new NjFundConfExample();
		e.createCriteria().andProductIdEqualTo(proId);
		sm.deleteByExample(e);
		
		NjFundConf f = new NjFundConf();
		
		f.setId(UuidUtil.get32UUID());
		f.setProductId(proId);
		f.setFundId(result.getString("sid"));
		f.setShareRate(new BigDecimal(result.getString("scale")));
		sm.insert(f);
		
		//产品还款对象
		NjProdRepayObjMapper sm1 = dao.getMapper(NjProdRepayObjMapper.class);
		NjProdRepayObjExample e1 = new NjProdRepayObjExample();
		e1.createCriteria().andProductIdEqualTo(proId);
		sm1.deleteByExample(e1);
		
		String[] select = result.getString("select").split(",");
		for(int i = 0; i < select.length; i++){
			String id = select[i];
			NjProdRepayObj o = new NjProdRepayObj();
			o.setId(UuidUtil.get32UUID());
			o.setProductId(proId);
			o.setRepayRole(Integer.parseInt(id));
			o.setRepayOrder(i);
			sm1.insert(o);
		}
		
		//产品收款对象
		NjProdPayeeObjMapper sm2 = dao.getMapper(NjProdPayeeObjMapper.class);
		NjProdPayeeObjExample e2 = new NjProdPayeeObjExample();
		e2.createCriteria().andProductIdEqualTo(proId);
		sm2.deleteByExample(e2);
		
		NjProdPayeeObj o = new NjProdPayeeObj();
		o.setId(UuidUtil.get32UUID());
		o.setProductId(proId);
		o.setPayeeRole(Integer.parseInt(result.getString("select4")));
		o.setPeyeeType(0);
		sm2.insert(o);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void saveAllOnLine(PageData result,NjProductTransactionOnline online) throws Exception {
		String proId = result.getString("productId");
		String relType = result.getString("relType");
		
		NjProductTransactionOnlineMapper sm = dao.getMapper(NjProductTransactionOnlineMapper.class);
		
		if(!"".equals(online.getId())){//删除线上配置表
			NjProductTransactionOnlineExample e = new NjProductTransactionOnlineExample();
			e.createCriteria().andIdEqualTo(online.getId());
			sm.deleteByExample(e);
		}else{
			online.setId(UuidUtil.get32UUID());
		}
		online.setIsDel(0);
		sm.insert(online);
		
		NjProductTransactionRelativeMapper sm0 = dao.getMapper(NjProductTransactionRelativeMapper.class);
		NjProductTransactionRelativeExample e0 = new NjProductTransactionRelativeExample();
		com.nj.model.generate.NjProductTransactionRelativeExample.Criteria c = e0.createCriteria();
		c.andProductIdEqualTo(proId);
		c.andTransactionTypeEqualTo(relType);
		sm0.deleteByExample(e0);
		
		NjProductTransactionRelative rel = new NjProductTransactionRelative();
		rel.setId(UuidUtil.get32UUID());
		rel.setProductId(proId);
		rel.setTransactionId(online.getId());
		rel.setTransactionType(relType);
		sm0.insert(rel);

		proId = online.getId();
		
		//产品还款对象
		NjProdRepayObjMapper sm1 = dao.getMapper(NjProdRepayObjMapper.class);
		NjProdRepayObjExample e1 = new NjProdRepayObjExample();
		e1.createCriteria().andProductIdEqualTo(proId);
		sm1.deleteByExample(e1);
		
		String[] select = result.getString("select").split(",");
		for(int i = 0; i < select.length; i++){
			String id = select[i];
			NjProdRepayObj o = new NjProdRepayObj();
			o.setId(UuidUtil.get32UUID());
			o.setProductId(proId);
			o.setRepayRole(Integer.parseInt(id));
			o.setRepayOrder(i);
			sm1.insert(o);
		}
		
		//产品收款对象
		NjProdPayeeObjMapper sm2 = dao.getMapper(NjProdPayeeObjMapper.class);
		NjProdPayeeObjExample e2 = new NjProdPayeeObjExample();
		e2.createCriteria().andProductIdEqualTo(proId);
		sm2.deleteByExample(e2);
		
		NjProdPayeeObj o = new NjProdPayeeObj();
		o.setId(UuidUtil.get32UUID());
		o.setProductId(proId);
		o.setPayeeRole(Integer.parseInt(result.getString("select4")));
		o.setPeyeeType(0);
		sm2.insert(o);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void saveAllOffLine(PageData result,NjProductTransactionOffline online) throws Exception {
		String proId = result.getString("productId");
		String relType = result.getString("relType");
		
		NjProductTransactionOfflineMapper sm = dao.getMapper(NjProductTransactionOfflineMapper.class);
		if(!"".equals(online.getId())){//删除线上配置表
			NjProductTransactionOfflineExample e = new NjProductTransactionOfflineExample();
			e.createCriteria().andIdEqualTo(online.getId());
			sm.deleteByExample(e);
		}else{
			online.setId(UuidUtil.get32UUID());
		}
		online.setIsDel(0);
		sm.insert(online);
		
		NjProductTransactionRelativeMapper sm0 = dao.getMapper(NjProductTransactionRelativeMapper.class);
		NjProductTransactionRelativeExample e1 = new NjProductTransactionRelativeExample();
		com.nj.model.generate.NjProductTransactionRelativeExample.Criteria c = e1.createCriteria();
		c.andProductIdEqualTo(proId);
		c.andTransactionTypeEqualTo(relType);
		sm0.deleteByExample(e1);
		
		NjProductTransactionRelative rel = new NjProductTransactionRelative();
		rel.setId(UuidUtil.get32UUID());
		rel.setProductId(proId);
		rel.setTransactionId(online.getId());
		rel.setTransactionType(relType);
		sm0.insert(rel);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public List<NjFund>  getQDList() throws Exception {
		NjFundMapperExtend sm = dao.getMapper(NjFundMapperExtend.class);
		return sm.getList();
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public List<NjFund>  getQDListByName(PageData pd) throws Exception {
		NjFundMapperExtend sm = dao.getMapper(NjFundMapperExtend.class);
		return sm.getListByName(pd);
	}
	
	/**
	 * 获取平台资料比例
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Map getNjFundConf(PageData pd) throws Exception {
		NjFundMapperExtend sm = dao.getMapper(NjFundMapperExtend.class);
		List<Map> list = sm.getListByProductId(pd);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 获取还款角色列表
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public List<NjProdRepayObj>  getHKList(String productId) throws Exception {
		NjProdRepayObjMapper sm = dao.getMapper(NjProdRepayObjMapper.class);
		NjProdRepayObjExample example = new NjProdRepayObjExample();
		
		com.nj.model.generate.NjProdRepayObjExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		example.setOrderByClause("repay_order");
		return sm.selectByExample(example);
	}
	
	/**
	 * 获取收款人
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public NjProdPayeeObj  getSKR(String productId) throws Exception {
		NjProdPayeeObj f = new NjProdPayeeObj();
		NjProdPayeeObjMapper sm = dao.getMapper(NjProdPayeeObjMapper.class);
		NjProdPayeeObjExample example = new NjProdPayeeObjExample();
		example.createCriteria().andProductIdEqualTo(productId);
		List<NjProdPayeeObj> list = sm.selectByExample(example);
		if(list != null && list.size() > 0){
			f = list.get(0);
		}
		return f;
	}
	
	/**
	 * 判断是否存在类型
	 * @param productId
	 * @param type
	 * @return true 存在; FALSE，不存在
	 * @throws Exception
	 */
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public boolean  isSaveModel(String productId,String type) throws Exception {
		NjProductTransactionRelativeMapper sm = dao.getMapper(NjProductTransactionRelativeMapper.class);
		NjProductTransactionRelativeExample example = new NjProductTransactionRelativeExample();
		
		com.nj.model.generate.NjProductTransactionRelativeExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		criteria.andTransactionTypeEqualTo(type);
		List list = sm.selectByExample(example);
		if(list != null && list.size() != 0){
			return true;
		}
		return false;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public NjProductTransactionOnline getOnlineById(String olId) throws Exception {
		NjProductTransactionOnline f = new NjProductTransactionOnline();
		NjProductTransactionOnlineMapper sm = dao.getMapper(NjProductTransactionOnlineMapper.class);
		NjProductTransactionOnlineExample example = new NjProductTransactionOnlineExample();
		example.createCriteria().andIdEqualTo(olId);
		List<NjProductTransactionOnline> list = sm.selectByExample(example);
		if(list != null && list.size() > 0){
			f = list.get(0);
		}
		return f;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public NjProductTransactionOffline getOfflineById(String olId) throws Exception {
		NjProductTransactionOffline f = new NjProductTransactionOffline();
		NjProductTransactionOfflineMapper sm = dao.getMapper(NjProductTransactionOfflineMapper.class);
		NjProductTransactionOfflineExample example = new NjProductTransactionOfflineExample();
		example.createCriteria().andIdEqualTo(olId);
		List<NjProductTransactionOffline> list = sm.selectByExample(example);
		if(list != null && list.size() > 0){
			f = list.get(0);
		}
		return f;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public List<NjProductTransactionRelative> getTransactionList(String productId) throws Exception {
		
		NjProductTransactionRelativeMapper sm = dao.getMapper(NjProductTransactionRelativeMapper.class);
		NjProductTransactionRelativeExample e1 = new NjProductTransactionRelativeExample();
		com.nj.model.generate.NjProductTransactionRelativeExample.Criteria c = e1.createCriteria();
		c.andProductIdEqualTo(productId);
		
		return sm.selectByExample(e1);
	}

	public NjProductTransaction getRateByProductId(String productId) throws Exception {
		NjProductTransactionMapperExtend extend = dao.getMapper(NjProductTransactionMapperExtend.class);
		return extend.getRateByProductId(productId);
	}
	
}
