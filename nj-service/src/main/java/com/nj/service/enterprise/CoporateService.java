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

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjCoporateAuthMapper;
import com.nj.dao.NjCoporateMapper;
import com.nj.dao.NjCoporateProductTempMapper;
import com.nj.dao.extend.NjCoporateMapperExtend;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateAuth;
import com.nj.model.generate.NjCoporateAuthExample;
import com.nj.model.generate.NjCoporateExample;
import com.nj.model.generate.NjCoporateProductTemp;
import com.nj.model.generate.NjCoporateProductTempExample;
import com.nj.model.generate.SysUser;

@Transactional
@Service("coporateService")
public class CoporateService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	private static Logger logger = LoggerFactory.getLogger(CoporateService.class);
	
	@Resource
	private NjCoporateMapper njCoporateMapper;
	
	@Resource
	private NjCoporateProductTempMapper njCoporateProductTempMapper;
	
	/*
	 * 获取公司列表
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getCompanyList(PageData pd) throws Exception {
		
		String companName = pd.getString("companName");
		if(StringUtils.isEmpty(companName)){
			pd.put("companName", null);
		}else{
			pd.put("companName", "%"+companName+"%");
		}
		
		NjCoporateMapperExtend daoMapper = dao.getMapper(NjCoporateMapperExtend.class);
		
//		NjCoporateExample example = new NjCoporateExample();
//		StringBuilder sb = new StringBuilder();
//		sb.append("%").append(pd.getString("companName")).append("%");
//		example.or().andCompanNameLike(sb.toString());
		List<NjCoporate> results1 = daoMapper.getCompanyList(pd);
		List<Map> results = daoMapper.selectCompany(pd);
		
//		PageData pd1 = new PageData();
//		pd1.put("result", results);
//		pd1.put("count", results.size());
		return results;
	}
	
	public NjCoporate getCoporateById(String coporateId) throws Exception{
		NjCoporateMapper cm = dao.getMapper(NjCoporateMapper.class);
		return cm.selectByPrimaryKey(coporateId);
	}
	
	@Transactional(rollbackFor={Throwable.class},readOnly = false)
	public void insertOrgAuth(NjCoporateAuth nca) throws Exception{
		NjCoporateAuthMapper ncaMapper = dao.getMapper(NjCoporateAuthMapper.class);
		ncaMapper.insert(nca);
	}
	
	public List<NjCoporateAuth> getCoporateAuthByCopoId(String coporateId) throws Exception{
		NjCoporateAuthMapper ncaMapper = dao.getMapper(NjCoporateAuthMapper.class);
		NjCoporateAuthExample ncae = new NjCoporateAuthExample();
		ncae.createCriteria().andCoporateIdEqualTo(coporateId);
		return ncaMapper.selectByExample(ncae);
	}
	
	@Transactional(rollbackFor={Throwable.class},readOnly = false)
	public void uptCoporateAuth(NjCoporateAuth record,NjCoporateAuthExample example) throws Exception{
		NjCoporateAuthMapper ncaMapper = dao.getMapper(NjCoporateAuthMapper.class);
		ncaMapper.updateByExampleSelective(record, example);
	}

	public List<Map> selectAllList(PageData pd) throws Exception {
		NjCoporateMapperExtend daoMapper = dao.getMapper(NjCoporateMapperExtend.class);
		return daoMapper.selectAllList(pd);
	}
	/**
	 * 查询有效的企业列表
	 * @return
	 * @throws Exception
	 */
	public List<NjCoporate> selectEffectiveCoporate() throws Exception{
		NjCoporateMapper daoMapper = dao.getMapper(NjCoporateMapper.class);
		NjCoporateExample example = new NjCoporateExample();
		example.createCriteria().andDelFlagEqualTo(false);
		return daoMapper.selectByExample(example);
	}

	public List<NjCoporate> getAllCompany() throws Exception {
		NjCoporateMapperExtend daoMapper = dao.getMapper(NjCoporateMapperExtend.class);
		return  daoMapper.getAllCompany();
	}
	
	public List<NjCoporate> getAllCompanyForApp() throws Exception {
		NjCoporateMapperExtend daoMapper = dao.getMapper(NjCoporateMapperExtend.class);
		return  daoMapper.getAllCompanyForApp();
	}
	
	public List<NjCoporate> selectByExample(NjCoporateExample example) throws Exception{
		return njCoporateMapper.selectByExample(example);
	}

	public void updateCorporateInfo(PageData pd) {
		
		String coporateId = pd.getString("coporateId");
		String companName = pd.getString("companName");
		String address = pd.getString("address");
		String maxCreditLimit = pd.getString("maxCreditLimit");
		String payChannel = pd.getString("payChannel");
		String capitalEndChannel = pd.getString("capitalEndChannel");
		String productTempIds = pd.getString("productTempIds");
		Assert.hasLength(coporateId,"coporateId【分公司ID】不能为空");
		Assert.hasLength(companName);
		Assert.hasLength(address);
		Assert.hasLength(maxCreditLimit);
		Assert.hasLength(payChannel,"请选择支付渠道");
		Assert.hasLength(capitalEndChannel,"请选择资产推送渠道");
		Assert.hasLength(productTempIds,"请选择授权使用产品模板");
		//修改企业信息
		NjCoporate  njCoporate  =  new  NjCoporate();
		njCoporate.setId(coporateId);
		njCoporate.setCompanName(companName);
		njCoporate.setAddress(address);
		njCoporate.setMaxCreditLimit(Double.valueOf(maxCreditLimit) );
		njCoporate.setPayChannel(Integer.parseInt(payChannel));
		njCoporate.setCapitalEndChannel(Integer.parseInt(capitalEndChannel));
	
		njCoporateMapper.updateByPrimaryKeySelective(njCoporate);
		//修改企业授权产品模板
		NjCoporateProductTempExample example  =  new  NjCoporateProductTempExample();
		example.createCriteria().andCoporateIdEqualTo(coporateId);
		njCoporateProductTempMapper.deleteByExample(example  );
		String[] templateIdArr = productTempIds.split(",",-1);
		for(String str : templateIdArr){
			NjCoporateProductTemp  temp  =  new  NjCoporateProductTemp();
			temp.setCoporateId(coporateId);
			temp.setProductTempId(Integer.parseInt(str) );
			njCoporateProductTempMapper.insert(temp);
		}
		
		
	}
	
	/**
	 * 查询所有企业
	 * @return
	 * @throws Exception
	 */
	public List<NjCoporate> getNjCoporateAll() throws Exception{
		
		// 查询企业
		NjCoporateMapper mapper = dao.getMapper(NjCoporateMapper.class);
		NjCoporateExample example = new NjCoporateExample();
		example.createCriteria().andDelFlagEqualTo(false);
		List<NjCoporate> listNjCoporate  = mapper.selectByExample(example);
		
		return listNjCoporate;
		
	}
	
	/**
	 * 查询所有企业用户
	 * @return
	 * @throws Exception
	 */
	public List<Map> getUserInfoAll() throws Exception {
		
		NjUserInfoMapperExtend userInfoMapper = dao.getMapper(NjUserInfoMapperExtend.class);
		List<Map> listUserInfo = userInfoMapper.getUserInfoAll();
		return listUserInfo;
	}
	
	public  List<NjCoporateProductTemp>  getCoporateProductTemp(NjCoporateProductTempExample example){
		List<NjCoporateProductTemp> list = njCoporateProductTempMapper.selectByExample(example);
		return list;
	}

	public void AddCorporateInfo(PageData pd) {
		String companCode = pd.getString("companCode");
		String companName = pd.getString("companName");
		String address = pd.getString("address");
		String maxCreditLimit = pd.getString("maxCreditLimit");
		String payChannel = pd.getString("payChannel");
		String capitalEndChannel = pd.getString("capitalEndChannel");
		String productTempIds = pd.getString("productTempIds");
	    Assert.hasLength(companName);
		Assert.hasLength(address);
		Assert.hasLength(maxCreditLimit);
		Assert.hasLength(payChannel);
		Assert.hasLength(capitalEndChannel);
		Assert.hasLength(productTempIds);
		
		String get32uuid = UuidUtil.get32UUID();
		SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
		
		//修改企业信息
		NjCoporate  njCoporate  =  new  NjCoporate();
		njCoporate.setId(get32uuid);
		njCoporate.setCompanCode(companCode);
		njCoporate.setCompanName(companName);
		njCoporate.setAddress(address);
		njCoporate.setMaxCreditLimit(Double.valueOf(maxCreditLimit) );
		njCoporate.setPayChannel(Integer.parseInt(payChannel));
		njCoporate.setCapitalEndChannel(Integer.parseInt(capitalEndChannel));
		njCoporate.setCreateBy(user.getName());
		njCoporate.setCreateDate(Calendar.getInstance().getTime());
		njCoporate.setDelFlag(false);
		njCoporateMapper.insert(njCoporate);
	
		String[] templateIdArr = productTempIds.split(",",-1);
		for(String str : templateIdArr){
			NjCoporateProductTemp  temp  =  new  NjCoporateProductTemp();
			temp.setCoporateId(get32uuid);
			temp.setProductTempId(Integer.parseInt(str) );
			njCoporateProductTempMapper.insert(temp);
		}
		
		
	}

}
