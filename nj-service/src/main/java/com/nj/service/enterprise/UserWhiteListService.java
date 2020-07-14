///*
// * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
// * ALL RIGHTS RESERVED.
// *
// * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
// * on any form or by any means, electronic, mechanical, photocopying, recording, 
// * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
// *
// * Amendment History:
// * 
// * Date                   By              Description
// * -------------------    -----------     -------------------------------------------
// * Apr 17, 2015    YangShengJun         Create the class
// */
//
//package com.nj.service.enterprise;
//
//import java.util.List;
//import javax.annotation.Resource;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.nj.core.base.dao.BaseDao;
//import com.nj.core.base.util.Constants;
//import com.nj.core.base.util.Map2Bean;
//import com.nj.core.base.util.PageData;
//import com.nj.dao.NjProductParaMapper;
//import com.nj.dao.NjUserWhitelistMapper;
//import com.nj.model.generate.NjProductPara;
//import com.nj.model.generate.NjUserWhitelist;
//import com.nj.model.generate.NjUserWhitelistExample;
//
///**
// * @FileName RoleService.java
// * @Description: 
// *
// * @Date 2015年5月9日 
// * @author dzk
// * @version 1.0
// * 
// */
//@Transactional(readOnly=true)
//@Service("userWhiteListService")
//public class UserWhiteListService {
//
//	@Resource(name = "BaseDao")
//	private BaseDao dao;
//
//	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
//	public void add(PageData pd) throws Exception {
//
//		NjUserWhitelist record = new NjUserWhitelist();
//		Map2Bean.transMapToNewBean(pd, record);
//		
//		NjUserWhitelistMapper sm = dao.getMapper(NjUserWhitelistMapper.class);
//	
//		sm.insert(record);
//	}
//	
//	public boolean isSave(String productId,String idcard) throws Exception{
//		NjUserWhitelistMapper sm = dao.getMapper(NjUserWhitelistMapper.class);
//		
//		NjUserWhitelistExample example = new NjUserWhitelistExample();
//		com.nj.model.generate.NjUserWhitelistExample.Criteria criteria = example.createCriteria();
//		criteria.andProductIdEqualTo(productId);
//		criteria.andIdcardEqualTo(idcard);
//		criteria.andDelFlagEqualTo(false);
//		
//		List list = sm.selectByExample(example);
//		if(list == null || list.size() == 0){
//			return false;
//		}
//		return true;
//	}
//
//	
//	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
//	public PageData getListByProductId(PageData pd) throws Exception {
//
//		NjUserWhitelistMapper sm = dao.getMapper(NjUserWhitelistMapper.class);
//		NjUserWhitelistExample example = new NjUserWhitelistExample();
//		
//		example.or().andProductIdEqualTo(pd.getString("productId"))
//					.andDelFlagEqualTo(false)
//					.andNameLike("%"+pd.getString("keyword")+"%");
//		example.or().andProductIdEqualTo(pd.getString("productId"))
//					.andDelFlagEqualTo(false)
//					.andIdcardLike("%"+pd.getString("keyword")+"%");
//		
//		example.or().andProductIdEqualTo(pd.getString("productId"))
//					.andDelFlagEqualTo(false)
//					.andPhoneLike("%"+pd.getString("keyword")+"%");
//				
//		List<NjUserWhitelist> userWhitelist = sm.selectByExample(example);
//		
//		PageData pd1 = new PageData();
//
//		pd1.put(Constants.Datas.RECORDSTOTAL, userWhitelist.size());
//		pd1.put(Constants.Datas.RECORDSFILTERED, userWhitelist.size());
//		pd1.put(Constants.Datas.NDATA, userWhitelist);
//		
//		return pd1;
//	}
//	
//	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
//	public void delAll(String ids) throws Exception {
//		if(ids != null){
//			NjUserWhitelistMapper sm = dao.getMapper(NjUserWhitelistMapper.class);
//			for(String id : ids.split(",")){
//				NjUserWhitelist product = new NjUserWhitelist();
//				product.setId(id);
//				product.setDelFlag(true);
//				sm.updateByPrimaryKeySelective(product);
//			}
//		}
//	}
//	
//	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
//	public void updateState(NjProductPara njProductPara) throws Exception {
//		NjProductParaMapper sm = dao.getMapper(NjProductParaMapper.class);
//		sm.updateByPrimaryKeySelective(njProductPara);
//	}
//	
//}
