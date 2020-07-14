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

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProcessInfo;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.dao.NjChannelMapper;
import com.nj.dao.NjCorpProdMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjProcessTemplateFlowsMapper;
import com.nj.dao.NjProdPayeeObjMapper;
import com.nj.dao.NjProdRepayObjMapper;
import com.nj.dao.NjProdRepaymentObjMapper;
import com.nj.dao.NjProductAreaMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.dao.NjProductCycleMapper;
import com.nj.dao.NjProductFeeCfgMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.NjProductOutsideApiMapper;
import com.nj.dao.NjProductScopeMapper;
import com.nj.dao.NjProductTagMapper;
import com.nj.dao.NjProductTempMapper;
import com.nj.dao.NjProductTransactionMapper;
import com.nj.dao.NjProductTypeMapper;
import com.nj.dao.NjProductUserMapper;
import com.nj.dao.SysBusinessDictMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.activiti.mapper.base.ProcessRoleUserMapper;
import com.nj.dao.activiti.mapper.base.ProcessTaskinsUserMapper;
import com.nj.dao.activiti.mapper.base.ProcessTemplateMapper;
import com.nj.dao.activiti.mapper.extend.ProcessRoleUserMapperExtend;
import com.nj.dao.extend.NjAssetGradeMapperExtend;
import com.nj.dao.extend.NjProcessTemplateFlowsMapperExtend;
import com.nj.dao.extend.NjProdPayeeObjMapperExtend;
import com.nj.dao.extend.NjProdRepayObjMapperExtend;
import com.nj.dao.extend.NjProdRepaymentObjMapperExtend;
import com.nj.dao.extend.NjProductAreaMapperExtend;
import com.nj.dao.extend.NjProductBusinessDictMapperExtend;
import com.nj.dao.extend.NjProductChannelMapperExtend;
import com.nj.dao.extend.NjProductCycleMapperExtend;
import com.nj.dao.extend.NjProductFeeCfgMapperExtend;
import com.nj.dao.extend.NjProductMapperExtend;
import com.nj.dao.extend.NjProductScopeMapperExtend;
import com.nj.dao.extend.NjProductTransactionMapperExtend;
import com.nj.dao.extend.NjProductTransactionOnlineMapperExtend;
import com.nj.dao.extend.NjProductTypeMapperExtend;
import com.nj.dao.extend.NjProductUserMapperExtend;
import com.nj.dao.extend.SysDictMapperExtend;
import com.nj.model.activiti.base.ProcessRoleUser;
import com.nj.model.activiti.base.ProcessRoleUserExample;
import com.nj.model.activiti.base.ProcessTaskinsUser;
import com.nj.model.activiti.base.ProcessTaskinsUserExample;
import com.nj.model.activiti.base.ProcessTemplate;
import com.nj.model.datamodel.NjProductModel;
import com.nj.model.datamodel.SysBusinessDictModel;
import com.nj.model.generate.NjAssetGrade;
import com.nj.model.generate.NjChannel;
import com.nj.model.generate.NjCorpProd;
import com.nj.model.generate.NjCorpProdExample;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.model.generate.NjProdPayeeObj;
import com.nj.model.generate.NjProdRepayObj;
import com.nj.model.generate.NjProdRepaymentObj;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductArea;
import com.nj.model.generate.NjProductBusinessDict;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductCycle;
import com.nj.model.generate.NjProductExample;
import com.nj.model.generate.NjProductFeeCfg;
import com.nj.model.generate.NjProductFeeCfgExample;
import com.nj.model.generate.NjProductOutsideApi;
import com.nj.model.generate.NjProductScope;
import com.nj.model.generate.NjProductScopeExample;
import com.nj.model.generate.NjProductTag;
import com.nj.model.generate.NjProductTagExample;
import com.nj.model.generate.NjProductTemp;
import com.nj.model.generate.NjProductTempExample;
import com.nj.model.generate.NjProductTransaction;
import com.nj.model.generate.NjProductTransactionOnline;
import com.nj.model.generate.NjProductType;
import com.nj.model.generate.NjProductUser;
import com.nj.model.generate.NjProductUserExample;
import com.nj.model.generate.SysBusinessDict;
import com.nj.model.generate.SysBusinessDictExample;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysOutsideApi;
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
@Transactional(readOnly = true)
@Service("productService")
public class ProductService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void add(NjProduct product, String coporateId, String tempId, String ids) throws Exception {
		// shiro管理的session
		// Subject currentUser = SecurityUtils.getSubject();
		// Session session = currentUser.getSession();
		// SysUser user = (SysUser) session.getAttribute(Const.SESSION_USER);
		SysUser user = new SysUser();
		user.setId("1");

		product.setId(UuidUtil.get32UUID());
		product.setCreateBy(user.getId());
		product.setCreateDate(new Date());
		product.setUpdateBy(user.getId());
		product.setUpdateDate(new Date());
		product.setDelFlag(false);

		NjProductMapper sm = dao.getMapper(NjProductMapper.class);
		sm.insert(product);

		NjCorpProdMapper cpm = dao.getMapper(NjCorpProdMapper.class);
		NjCorpProd cp = new NjCorpProd();
		cp.setId(UuidUtil.get32UUID());
		cp.setProductId(product.getId());
		cp.setCorporateId(coporateId);
		cpm.insert(cp);

		NjProductTempMapper ptm = dao.getMapper(NjProductTempMapper.class);
		NjProductTemp pt = new NjProductTemp();
		pt.setId(UuidUtil.get32UUID());
		pt.setProductId(product.getId());
		pt.setTemplateId(Integer.parseInt(tempId));
		ptm.insert(pt);

		// 保存产品TAG
		if (ids != null && !"".equals(ids)) {
			NjProductTagMapper tagm = dao.getMapper(NjProductTagMapper.class);
			ids = ids.substring(0, ids.length() - 1);
			String[] ters = ids.split(",");
			for (String string : ters) {
				NjProductTag tag = new NjProductTag();
				tag.setId(UuidUtil.get32UUID());
				tag.setProductId(product.getId());
				tag.setTagId(string);
				tagm.insert(tag);
			}
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void update(NjProduct product) throws Exception {
		product.setUpdateDate(new Date());
		NjProductMapper sm = dao.getMapper(NjProductMapper.class);
		sm.updateByPrimaryKeySelective(product);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateTag(String productId, String ids) throws Exception {
		NjProductTagMapper tagm = dao.getMapper(NjProductTagMapper.class);

		NjProductTagExample example = new NjProductTagExample();
		com.nj.model.generate.NjProductTagExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		tagm.deleteByExample(example);

		// 保存产品TAG
		if (ids != null && !"".equals(ids)) {
			ids = ids.substring(0, ids.length() - 1);
			String[] ters = ids.split(",");
			for (String string : ters) {
				NjProductTag tag = new NjProductTag();
				tag.setId(UuidUtil.get32UUID());
				tag.setProductId(productId);
				tag.setTagId(string);
				tagm.insert(tag);
			}
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public List<NjProductTag> getProductTag(String productId) throws Exception {
		NjProductTagMapper tagm = dao.getMapper(NjProductTagMapper.class);

		NjProductTagExample example = new NjProductTagExample();
		com.nj.model.generate.NjProductTagExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);

		return tagm.selectByExample(example);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void delAll(String ids) throws Exception {
		if (ids != null) {
			NjProductMapper sm = dao.getMapper(NjProductMapper.class);
			for (String id : ids.split(",")) {
				NjProduct product = new NjProduct();
				product.setId(id);
				product.setDelFlag(true);
				sm.updateByPrimaryKeySelective(product);
			}
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public PageData getProductsByCoporateId(PageData pd) throws Exception {

		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		List<Map> results = sm.getProductsByCoporateId(pd);
		int totalCount = sm.getProductsByCoporateIdCount(pd);

		PageData pd1 = new PageData();

		pd1.put(Constants.Datas.RECORDSFILTERED, totalCount);
		pd1.put(Constants.Datas.NDATA, results);

		return pd1;
	}

	@Transactional(readOnly = true)
	public PageData getProductsByUserId(PageData pd) throws Exception {
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		List<Map> products = sm.getProductsByUserId(pd);

		PageData result = new PageData();
		result.put(Constants.Datas.NDATA, products);
		return result;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public PageData getProductsByAdmin(PageData pd) throws Exception {

		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		List<Map> results = sm.getProductsByAdmin(pd);

		PageData pd1 = new PageData();

		pd1.put(Constants.Datas.RECORDSTOTAL, results.size());
		pd1.put(Constants.Datas.RECORDSFILTERED, results.size());
		pd1.put(Constants.Datas.NDATA, results);

		return pd1;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public List<Map> getProductsByCorpAdmin(PageData pd) throws Exception {

		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);

		return sm.getProductsByCorpAdmin(pd);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void addProductScope(List<NjProductScope> list) throws Exception {
		NjProductScopeMapper cpm = dao.getMapper(NjProductScopeMapper.class);
		for (NjProductScope njProductScope : list) {
			cpm.insert(njProductScope);
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveProductScope(List<NjProductScope> list, String productId) throws Exception {
		NjProductScopeMapper cpm = dao.getMapper(NjProductScopeMapper.class);

		NjProductScopeExample example = new NjProductScopeExample();
		com.nj.model.generate.NjProductScopeExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		cpm.deleteByExample(example);

		for (NjProductScope njProductScope : list) {
			cpm.insert(njProductScope);
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public List<NjProductScope> getProductScopeList(String productId) throws Exception {

		NjProductScopeMapper cpm = dao.getMapper(NjProductScopeMapper.class);
		NjProductScopeExample example = new NjProductScopeExample();
		com.nj.model.generate.NjProductScopeExample.Criteria criteria = example.createCriteria();

		criteria.andProductIdEqualTo(productId);
		return cpm.selectByExample(example);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void addNjProductUser(NjProductUser user) throws Exception {
		NjProductUserMapper cpm = dao.getMapper(NjProductUserMapper.class);
		user.setId(UuidUtil.get32UUID());
		cpm.insert(user);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjProduct getProductById(String id) throws Exception {
		NjProductMapper cpm = dao.getMapper(NjProductMapper.class);
		return cpm.selectByPrimaryKey(id);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void addProcessRoleUser(ProcessRoleUser user, PageData pd) throws Exception {
		ProcessRoleUserMapper cpm = dao.getMapper(ProcessRoleUserMapper.class);
		user.setId(UuidUtil.get32UUID());
		cpm.insert(user);

		ProcessRoleUserMapperExtend prum = dao.getMapper(ProcessRoleUserMapperExtend.class);
		List<Map<String, String>> lt = prum.getTaskIdList(pd);
		if (lt != null && lt.size() > 0) {
			ProcessTaskinsUserMapper ptum = dao.getMapper(ProcessTaskinsUserMapper.class);
			for (Map<String, String> map : lt) {
				ProcessTaskinsUser u = new ProcessTaskinsUser();
				u.setTaskinsId(map.get("taskinsId"));
				u.setHandUser(user.getUserId());
				ptum.insert(u);
			}

		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void delProcessRoleUser(String id, PageData pd) throws Exception {
		ProcessRoleUserMapper cpm = dao.getMapper(ProcessRoleUserMapper.class);
		// ProcessRoleUserExample example = new ProcessRoleUserExample();
		// com.nj.model.activiti.base.ProcessRoleUserExample.Criteria criteria =
		// example.createCriteria();
		// criteria.andIdEqualTo(id);
		ProcessRoleUser user = cpm.selectByPrimaryKey(id);
		if (user != null) {
			cpm.deleteByPrimaryKey(id);

			ProcessRoleUserMapperExtend prum = dao.getMapper(ProcessRoleUserMapperExtend.class);
			List<Map<String, String>> lt = prum.getTaskIdList(pd);
			if (lt != null && lt.size() > 0) {
				ProcessTaskinsUserMapper ptum = dao.getMapper(ProcessTaskinsUserMapper.class);
				for (Map<String, String> map : lt) {

					ProcessTaskinsUserExample example = new ProcessTaskinsUserExample();
					com.nj.model.activiti.base.ProcessTaskinsUserExample.Criteria criteria = example.createCriteria();
					criteria.andHandUserEqualTo(user.getUserId());
					criteria.andTaskinsIdEqualTo(map.get("taskinsId"));

					ptum.deleteByExample(example);
				}

			}

		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public List<Map> getNjProductFlowUserList(String processId) throws Exception {
		NjProductUserMapperExtend cpm = dao.getMapper(NjProductUserMapperExtend.class);
		ProcessRoleUser user = new ProcessRoleUser();
		user.setProcessId(processId);
		return cpm.getProductRoleUserList(user);

	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public boolean isSaveNjProductUser(NjProductUser user) throws Exception {
		NjProductUserMapper cpm = dao.getMapper(NjProductUserMapper.class);

		NjProductUserExample example = new NjProductUserExample();
		com.nj.model.generate.NjProductUserExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(user.getRoleId());
		criteria.andUserIdEqualTo(user.getUserId());
		criteria.andProductIdEqualTo(user.getProductId());

		List<NjProductUser> list = cpm.selectByExample(example);
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public boolean isSaveProcessRoleUser(ProcessRoleUser user) throws Exception {
		ProcessRoleUserMapper cpm = dao.getMapper(ProcessRoleUserMapper.class);

		ProcessRoleUserExample example = new ProcessRoleUserExample();
		com.nj.model.activiti.base.ProcessRoleUserExample.Criteria criteria = example.createCriteria();
		criteria.andProcessIdEqualTo(user.getProcessId());
		criteria.andProcessRoleIdEqualTo(user.getProcessRoleId());
		criteria.andUserIdEqualTo(user.getUserId());

		List<ProcessRoleUser> list = cpm.selectByExample(example);
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void delNjProductUser(String id) throws Exception {
		NjProductUserMapper cpm = dao.getMapper(NjProductUserMapper.class);
		NjProductUserExample example = new NjProductUserExample();
		com.nj.model.generate.NjProductUserExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		cpm.deleteByExample(example);
	}

	public List<String> getProductImgList(String path) throws Exception {
		List<String> filelist = new ArrayList<>();
		getFileList(filelist, path);
		return filelist;
	}

	public void getFileList(List<String> filelist, String strPath) {
		File dir = new File(strPath);
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				if (files[i].isDirectory()) { // 判断是文件还是文件夹
					getFileList(filelist, files[i].getAbsolutePath()); // 获取文件绝对路径
				} else if (fileName.endsWith("jpg") || fileName.endsWith("png")) { // 判断文件名是否以.avi结尾
					String strFileName = files[i].getAbsolutePath();
					// System.out.println("---" + strFileName);
					filelist.add(files[i].getName());
				} else {
					continue;
				}
			}

		}
	}

	/*
	 * 获取参数基本参数
	 */
	public Map getProductAuditParameters(PageData pd) throws Exception {
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);

		List<Map> auditParameters = sm.getProductAuditParameters(pd);
		if (auditParameters != null && auditParameters.size() > 0) {
			return auditParameters.get(0);
		}
		return null;
	}

	/**
	 * 获取产品线上放款参数
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public NjProductTransactionOnline getProductTransactionOnline(PageData pd) throws Exception {
		NjProductTransactionOnlineMapperExtend sm = dao.getMapper(NjProductTransactionOnlineMapperExtend.class);
		List<NjProductTransactionOnline> list = sm.selectByOrderNo(pd);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 获取产品线下放款参数
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Map getProductTransactionOffline(PageData pd) throws Exception {
		NjProductTransactionOnlineMapperExtend sm = dao.getMapper(NjProductTransactionOnlineMapperExtend.class);
		List<Map> list = sm.selectOffByOrderNo(pd);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 获取所有产品列表
	 * 
	 * @param pd
	 * @return
	 */
	public List<Map> getAllProductList(PageData pd) throws Exception {
		NjProductMapperExtend mapper = dao.getMapper(NjProductMapperExtend.class);
		List<Map> results = mapper.selectAllProductListPage(pd);
		return results;
	}

	/**
	 * 更新产品状态
	 * 
	 * @param ids
	 * @param state
	 *            -1:删除； 非-1：更改状态
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateAll(String ids, int state) throws Exception {
		if (ids != null) {
			NjProductMapper sm = dao.getMapper(NjProductMapper.class);
			for (String id : ids.split(",")) {
				NjProduct product = new NjProduct();
				if (state != -1) {
					product.setId(id);
					product.setState(state);
					sm.updateByPrimaryKeySelective(product);
				} else {
					product.setId(id);
					product.setDelFlag(true);
					sm.updateByPrimaryKeySelective(product);
				}
			}
		}
	}

	/**
	 * 保存产品基本信息
	 * 
	 * @param njProduct
	 *            产品基本信息
	 * @param pd
	 *            产品相信息
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveOrUpdateProduct(NjProduct njProduct, PageData pd) throws Exception {
		SysDictMapperExtend dictMapperExtend = dao.getMapper(SysDictMapperExtend.class);
		List<SysDict> dicts = dictMapperExtend.selectByIds(pd);
		// 组装产品主表贷款期数区间用于展示
		concatProductTermInfo(dicts, njProduct, pd);
		// 保存产品，如果产品ID为空，视为新增
		NjProductMapper productMapper = dao.getMapper(NjProductMapper.class);
//		njProduct.setState(Constants.ProductState.UNSUBMIT);// 设置产品默认状态
		if (null == njProduct.getId() || njProduct.getId().trim().equals("")) {
			njProduct.setId(UuidUtil.get32UUID());
			njProduct.setDelFlag(false);
			njProduct.setState(Constants.ProductState.UNSUBMIT);// 设置产品默认状态
//			njProduct.setGrade(assetGrade.getGrade());//配置资产等级
			njProduct.setCreateBy(pd.getString("userId"));// 设置创建人
			njProduct.setCreateDate(new Date());// 设置产品创建时间
			NjProductMapperExtend njProductMapperExtend = dao.getMapper(NjProductMapperExtend.class);
			String productCode = njProductMapperExtend.getMaxProductCode();
			if(njProduct.getPriceStrategy() == null) {
				njProduct.setPriceStrategy(new Short("1"));
			}
			if(productCode != null) {
				Long tempCode = Long.parseLong(productCode) +1;
				njProduct.setProductCode(tempCode.toString());
			}
			
			productMapper.insertSelective(njProduct);
		} else {
			njProduct.setUpdateBy(pd.getString("userId"));// 设置更新人
			njProduct.setUpdateDate(new Date());// 设置更新时间
			productMapper.updateByPrimaryKeySelective(njProduct);
		}
		// 基本信息保存成功，维护产品类型
		saveProductType(njProduct.getId(), pd);
		// 维护产品贷款期数
		saeProductTerm(dicts, njProduct.getId(), pd);
		// 维护借款用途
		saveProductScope(njProduct.getId(), pd);
		// 维护产品发布区域
		saveProductArea(njProduct.getId(), pd);
		//设置产品企业关系
		saveProductCoporate(njProduct.getId(), pd);
		//设置产品模板关系
		saveProductTemp(njProduct.getId(), pd);
	}

	private void saveProductTemp(String productId, PageData pd) throws Exception {
		NjProductTempMapper mapper = dao.getMapper(NjProductTempMapper.class);
		NjProductTempExample example = new NjProductTempExample();
		example.createCriteria().andProductIdEqualTo(productId);
		List<NjProductTemp> list = mapper.selectByExample(example);
		//有则更新
		if(list != null && list.size() > 0) {
			NjProductTemp njProductTemp = list.get(0);
			njProductTemp.setTemplateId(pd.getInteger("productTempId"));
			mapper.updateByPrimaryKeySelective(njProductTemp);
		//否则新增
		}else {
			NjProductTemp njProductTemp = new NjProductTemp();
			njProductTemp.setId(UuidUtil.get32UUID());
			njProductTemp.setProductId(productId);
			njProductTemp.setTemplateId(pd.getInteger("productTempId"));
			mapper.insertSelective(njProductTemp);
		}
	}

	private void saveProductCoporate(String id, PageData pd) throws Exception {
		String coporateId = pd.getString("coporateId");
		NjCorpProd record = new NjCorpProd();
		record.setCorporateId(coporateId);
		record.setProductId(id);
		record.setId(UuidUtil.get32UUID());
		NjCorpProdMapper corpProdMapper = dao.getMapper(NjCorpProdMapper.class);
		
		NjCorpProdExample corpProdExample = new NjCorpProdExample();
		corpProdExample.createCriteria().andProductIdEqualTo(id);
		corpProdMapper.deleteByExample(corpProdExample);
		corpProdMapper.insertSelective(record);
	
	}

	/**
	 * 组装产品贷款期数区间
	 * 
	 * @param njProduct
	 * @param pd
	 * @throws Exception
	 */
	private void concatProductTermInfo(List<SysDict> dicts, NjProduct njProduct, PageData pd) throws Exception {
		if (null != dicts && dicts.size() > 0) {
			// 组装贷款区间
			if (dicts.size() == 1) {
				njProduct.setTermInfo(dicts.get(0).getLabelText());
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(dicts.get(0).getLabelText().replaceAll("期", ""));
				sb.append("~");
				sb.append(dicts.get(dicts.size() - 1).getLabelText());
				njProduct.setTermInfo(sb.toString());
			}
		}
	}

	/**
	 * 维护产品贷款期数
	 * 
	 * @param productId
	 * @param pd
	 * @throws Exception
	 */
	private void saeProductTerm(List<SysDict> dicts, String productId, PageData pd) throws Exception {
		if (null != dicts && dicts.size() > 0) {
			NjProductCycleMapper cycleMapper = dao.getMapper(NjProductCycleMapper.class);
			NjProductCycleMapperExtend cycleMapperExtend = dao.getMapper(NjProductCycleMapperExtend.class);
			NjAssetGradeMapperExtend grade = dao.getMapper(NjAssetGradeMapperExtend.class);
			NjAssetGrade assetGrade = grade.getDefaultGrade();
			if(null == assetGrade) {
				throw new Exception("没有检索到资产等级信息");
			}
			pd.put("grade", assetGrade.getGrade());
			List<NjProductCycle> njProductCycleList = new ArrayList<>();
			// 保存产品贷款期数中间表
			for (SysDict sysDict : dicts) {
				NjProductCycle njProductCycle = new NjProductCycle();
				njProductCycle.setId(UuidUtil.get32UUID());
				njProductCycle.setProductId(productId);
				njProductCycle.setSysId(sysDict.getId());
				njProductCycle.setThreType(0);
				//设置产品期数资产等级
				NjProductCycle temp = cycleMapperExtend.getBySysCycleId(sysDict.getId(), productId);
				if(null == temp) {
					njProductCycle.setGrade(pd.getString("grade"));
				}else {
					njProductCycle.setGrade(temp.getGrade()==null?pd.getString("grade"):temp.getGrade());
				}
				njProductCycleList.add(njProductCycle);
			}
			// 清空贷款期数中间表
			cycleMapperExtend.deleteByProductId(productId);
			for (NjProductCycle njProductCycle2 : njProductCycleList) {
				cycleMapper.insert(njProductCycle2);
			}
		}
	}

	/**
	 * 维护产品发类型
	 * 
	 * @param njProduct
	 * @param pd
	 * @throws Exception
	 */
	private void saveProductType(String njProductId, PageData pd) throws Exception {
		NjProductTypeMapper typeMapper = dao.getMapper(NjProductTypeMapper.class);
		NjProductTypeMapperExtend typeMapperExtend = dao.getMapper(NjProductTypeMapperExtend.class);
		// 清空产品类型中间表
		typeMapperExtend.deleteByProductId(njProductId);
		for (String typeId : pd.getString("borrowType").split(",")) {
			NjProductType njProductType = new NjProductType();
			njProductType.setId(UuidUtil.get32UUID());
			njProductType.setProductId(njProductId);
			njProductType.setTypeId(typeId);
			typeMapper.insert(njProductType);
		}
	}

	/**
	 * 维护产品用途范围信息
	 * 
	 * @param njProduct
	 * @param pd
	 * @throws Exception
	 */
	private void saveProductScope(String njProductId, PageData pd) throws Exception {
		NjProductScopeMapper scopeMapper = dao.getMapper(NjProductScopeMapper.class);
		NjProductScopeMapperExtend scopeMapperExtend = dao.getMapper(NjProductScopeMapperExtend.class);
		// 清空产品类型中间表
		scopeMapperExtend.deleteByProductId(njProductId);
		for (String scopeId : pd.getString("scope").split(",")) {
			NjProductScope njProductScope = new NjProductScope();
			njProductScope.setId(UuidUtil.get32UUID());
			njProductScope.setProductId(njProductId);
			njProductScope.setSysId(scopeId);
			scopeMapper.insert(njProductScope);
		}
	}

	/**
	 * 维护产品发布区域
	 * 
	 * @param njProduct
	 * @param pd
	 * @throws Exception
	 */
	private void saveProductArea(String njProductId, PageData pd) throws Exception {
		NjProductAreaMapper areaMapper = dao.getMapper(NjProductAreaMapper.class);
		NjProductAreaMapperExtend areaMapperExtend = dao.getMapper(NjProductAreaMapperExtend.class);

		// 清空产品发布区域信息
		areaMapperExtend.deleteByProductId(njProductId);
		JSONObject jb = JSONArray.parseObject(pd.getString("areaList"));
		if (null != jb && jb.size() > 0) {
			String type = jb.getString("type");
			// 约定如果传入类型为 0 ，则为全国发布
			if (type.equals("0")) {
				// 根据关键字 类型 获取全国发布区域
				NjProductArea njProductArea = new NjProductArea();
				njProductArea.setId(UuidUtil.get32UUID());
				njProductArea.setProductId(njProductId);
				njProductArea.setType(Byte.valueOf("0"));
				njProductArea.setAreaValue("全国");
				areaMapper.insert(njProductArea);
			} else {
				String areaIdList = jb.getString("ids");
				if(areaIdList == null || areaIdList.equals("")) {
					throw new Exception("请添加授信区域");
				}
				for (String areaId : areaIdList.split(",")) {
					NjProductArea njProductArea = new NjProductArea();
					njProductArea.setId(UuidUtil.get32UUID());
					njProductArea.setProductId(njProductId);
					
					SysDictMapper dictMapper = dao.getMapper(SysDictMapper.class);
					SysDict sysDict = dictMapper.selectByPrimaryKey(areaId);
					
					njProductArea.setAreaValue(sysDict.getLabelText());
					njProductArea.setProductId(njProductId);
					if (type.equals("1")) {
						njProductArea.setType(Byte.valueOf("1"));
						njProductArea.setProvinceId(areaId);
					} else if (type.equals("2")) {
						njProductArea.setType(Byte.valueOf("2"));
						njProductArea.setCityId(areaId);
					}

					areaMapper.insert(njProductArea);
				}
			}
		}else {
			throw new Exception("产品发布区域不能为空");
		}

	}

	/**
	 * 保存产品渠道关联信息
	 * 
	 * @param pd
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveProductChannel(PageData pd) throws Exception {

		NjProduct njProduct = new NjProduct();
		// 保存产品是否自主进件
		njProduct.setId(pd.getString("productId"));
		// 如果传入0，不为自主进件，非0：为自主进件
		njProduct.setIsOwnInput(pd.getString("isOwnChannel").equals("0") ? false : true);
		NjProductMapper njProductMapper = dao.getMapper(NjProductMapper.class);
		njProductMapper.updateByPrimaryKeySelective(njProduct);

		NjChannelMapper channelMapper = dao.getMapper(NjChannelMapper.class);
		NjProductChannelMapperExtend njProductChannelMapperExtend = dao.getMapper(NjProductChannelMapperExtend.class);
		NjProductChannelMapper njProductChannelMapper = dao.getMapper(NjProductChannelMapper.class);

		// 清空产品原有渠道信息,根据产品ID
		njProductChannelMapperExtend.deleteByCondition(pd);
		JSONArray array = JSONArray.parseArray(pd.getString("channelItems"));
		// 插入产品渠道中间表（进件渠道）
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			String channelId = jsonObject.getString("id");
			
			NjChannel njChannel = channelMapper.selectByPrimaryKey(channelId);
			NjProductChannel pdChannel = new NjProductChannel();
			pdChannel.setId(UuidUtil.get32UUID());
			pdChannel.setType(jsonObject.getShort("type"));//渠道类型。资金(2)、渠道进件(1)类型
			pdChannel.setChannelName(njChannel.getName());
			pdChannel.setChannelCode(njChannel.getCode() == null ? "暂无" : njChannel.getCode());
			pdChannel.setChannelMobile(njChannel.getMobile());
			pdChannel.setProductId(pd.getString("productId"));
			pdChannel.setNjChannelId(channelId);
			pdChannel.setChannelType(jsonObject.getInteger("channelType"));//自主进件、渠道进件、引流进件类型
			pdChannel.setCreateBy(pd.getString("userId"));// 设置创建人
			pdChannel.setCreateDate(new Date());// 设置产品创建时间
			pdChannel.setDelFlag(false);
			pdChannel.setOperateFeeType(jsonObject.getInteger("feeType"));//设置手续费类型
			String feeValue = jsonObject.getString("feeValue");
			pdChannel.setOperateFee(Float.parseFloat(feeValue));
			pdChannel.setBondType(jsonObject.getByte("bondType"));
			pdChannel.setBondValue(jsonObject.getString("bondValue"));
			njProductChannelMapper.insertSelective(pdChannel);
		}
		
		JSONArray zijinArray = JSONArray.parseArray(pd.getString("moneyChannelItems"));
		if(zijinArray != null && zijinArray.size()>0) {
			// 插入产品渠道中间表（资金渠道）
			for (int i = 0; i < zijinArray.size(); i++) {
				JSONObject jsonObject = zijinArray.getJSONObject(i);
				String channelId = jsonObject.getString("id");
				
				NjChannel njChannel = channelMapper.selectByPrimaryKey(channelId);
				NjProductChannel pdChannel = new NjProductChannel();
				pdChannel.setId(UuidUtil.get32UUID());
				pdChannel.setType(jsonObject.getShort("type"));//渠道类型。资金(2)、渠道进件(1)类型
				pdChannel.setChannelName(njChannel.getName());
				pdChannel.setChannelCode(njChannel.getCode() == null ? "暂无" : njChannel.getCode());
				pdChannel.setChannelMobile(njChannel.getMobile());
				pdChannel.setProductId(pd.getString("productId"));
				pdChannel.setNjChannelId(channelId);
				pdChannel.setCreateBy(pd.getString("userId"));// 设置创建人
				pdChannel.setCreateDate(new Date());// 设置产品创建时间
				pdChannel.setDelFlag(false);
				njProductChannelMapper.insertSelective(pdChannel);
			}
		}
		
	}

	/**
	 * 保存产品业务受理配置信息
	 * 
	 * @param pd
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveProductBusiness(PageData pd, String businessItems) throws Exception {
		// 获取业务配置项，JSON格式，传入配置id和配置输入类型

		JSONArray array = JSONArray.parseArray(businessItems);
		List<NjProductBusinessDict> insertBathList = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			NjProductBusinessDict businessDict = new NjProductBusinessDict();
			businessDict.setId(UuidUtil.get32UUID());
			businessDict.setBusiDictId(jsonObject.getIntValue("id"));
			businessDict.setInputType(jsonObject.getByte("state"));
			businessDict.setProductId(pd.getString("productId"));
			insertBathList.add(businessDict);
		}
		NjProductBusinessDictMapperExtend mapper = dao.getMapper(NjProductBusinessDictMapperExtend.class);
		// 清除产品业务配置
		mapper.deleteByProductId(pd.getString("productId"));
		// 批量插入
		if (insertBathList.size() > 0) {
			mapper.insertBath(insertBathList);
		}
	}

	/**
	 * 保存产品交易配置信息
	 * 
	 * @param pd
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveProductTransaction(PageData pd) throws Exception {

		// 保存产品相关交易配置
		NjProductMapper njProductMapper = dao.getMapper(NjProductMapper.class);
		NjProduct njProduct = new NjProduct();
		njProduct.setId(pd.getString("productId"));
		// 配置还款方式
		njProduct.setRepayWay(pd.getString("repayWay"));
		njProductMapper.updateByPrimaryKeySelective(njProduct);

		// 保存交易配置
		NjProductTransactionMapper transactionMapper = dao.getMapper(NjProductTransactionMapper.class);
		NjProductTransaction transaction = new NjProductTransaction();
		String pdTransactionId = pd.getString("pdTransactionId");

		transaction.setProductId(pd.getString("productId"));
		String repaymentPlanWay = pd.getString("repaymentPlanWay");
		// 设置还款计划表生成方式
		if (null != repaymentPlanWay && !"".equals(repaymentPlanWay)) {
			transaction.setRepaymentPlanWay(Byte.valueOf(repaymentPlanWay));
			
			// 设置还款计划表生成时间偏移量
			if (repaymentPlanWay.equals("0")) {
				String repaymentPlanDayOffset = pd.getString("repaymentPlanDayOffset");
				if(repaymentPlanDayOffset.equals("+") || repaymentPlanDayOffset.equals("-")) {
					repaymentPlanDayOffset = "0";
				}
				Integer repaymentPlanDayOffsetInt = Integer.parseInt(repaymentPlanDayOffset);
				transaction.setRepaymentPlanDayOffset(repaymentPlanDayOffsetInt);
			}
			//设置指定日期还款
			if (repaymentPlanWay.equals("2")) {
				String repaymentPlanDay = pd.getString("repaymentPlanDay");
				if(repaymentPlanDay != null ) {
					Integer repaymentPlanDayInt = Integer.parseInt(repaymentPlanDay);
					transaction.setRepaymentPlanDayOffset(repaymentPlanDayInt);
				}
			}
		}
//		// 设置手续费类型
//		if (null != pd.getString("feeType") && !"".equals(pd.getString("feeType"))) {
//			transaction.setFeeType(Byte.valueOf(pd.getString("feeType")));
//		}
//		// 设置手续费值
//		transaction.setFeeValue(pd.getString("feeValue"));
//		// 设置保证金类型
//		if (null != pd.getString("bondType") && !"".equals(pd.getString("bondType"))) {
//			transaction.setBondType(Byte.valueOf(pd.getString("bondType")));
//		}
//		// 设置保证金值
//		transaction.setBondValue(pd.getString("bondValue"));
		// 设置固定投资人利率
		if (null != pd.getString("fixedInterestRate") && !"".equals(pd.getString("fixedInterestRate"))) {
			transaction.setFixedInterestRate(new BigDecimal(pd.getString("fixedInterestRate")));
		}
		// 设置平台服务费率（等收）
		if (null != pd.getString("serviceCharge") && !"".equals(pd.getString("serviceCharge"))) {
			transaction.setServiceCharge(new BigDecimal(pd.getString("serviceCharge")));
		}
		// 设置平台服务费率（期收）
		if (null != pd.getString("serviceChargeTerm") && !"".equals(pd.getString("serviceChargeTerm"))) {
			transaction.setServiceRateTerm(new BigDecimal(pd.getString("serviceChargeTerm")));
		}
		// 设置是否提款控制
		transaction.setDrawingControl(pd.getString("drawingControl").equals("1") ? true : false);
		// 设置是否支持提前还款
		transaction.setIsPrepaySup(pd.getString("isPrepaySup").equals("1") ? true : false);
		// 设置是否罚息
		transaction.setIsPenaltySup(pd.getString("isPenaltySup").equals("1") ? true : false);
		// 设置是否需要用户确认
		transaction.setIsOnlineSign(pd.getString("isOnlineSign").equals("1") ? true : false);
		// 设置合同生成方式
		if (null != pd.getString("contractGenerationType") && !"".equals(pd.getString("contractGenerationType"))) {
			transaction.setContractGenerationType(Byte.valueOf(pd.getString("contractGenerationType")));
		}
		
		//设置自有资金放款通道
		if(pd.containsKey("ownLoanType") && pd.getString("ownLoanType") != null) {
			transaction.setOwnLoanType(new Short(pd.getString("ownLoanType")));
		}
		//设置渠道资金放款渠道
		if(pd.containsKey("channelLoanType") && pd.getString("channelLoanType") != null) {
			transaction.setChannelLoanType(new Short(pd.getString("channelLoanType")));
		}
		//设置自有资金回款通道
		if(pd.containsKey("ownPaybackType") && pd.getString("ownPaybackType") != null) {
			transaction.setOwnPaybackType(new Short(pd.getString("ownPaybackType")));
		}
		//设置渠道资金回款通道
		if(pd.containsKey("channelPaybackType") && pd.getString("channelPaybackType") != null) {
			transaction.setChannelPaybackType(new Short(pd.getString("channelPaybackType")));
		}
		
		// 设置产品的最大限额
		if(pd.containsKey("maxAmount")&& pd.getString("maxAmount") != null){
		    transaction.setMaxAmount(new BigDecimal(pd.getString("maxAmount")));
		} else {
			transaction.setMaxAmount(new BigDecimal("0"));
		}
		
		
		// 如果存在ID视为修改，否则为新增
		if (null == pdTransactionId || "".equals(pdTransactionId.trim())) {
			transaction.setId(UuidUtil.get32UUID());
			transactionMapper.insertSelective(transaction);
		} else {
			transaction.setId(pdTransactionId);
			transactionMapper.updateByPrimaryKeySelective(transaction);
		}	
		
		
		// 设置收款账户,json数组
		JSONObject repaymentJson = JSONObject.parseObject(pd.getString("repaymentItems"));
		NjProdRepaymentObjMapper njProdRepaymentObjMapper = dao.getMapper(NjProdRepaymentObjMapper.class);
		NjProdRepaymentObj njProdRepaymentObj = new NjProdRepaymentObj();
		if (null != repaymentJson ) {
			njProdRepaymentObj.setProductId(pd.getString("productId"));
			njProdRepaymentObj.setRepayRole(repaymentJson.getInteger("repaymentRole"));
			njProdRepaymentObj.setUserId(repaymentJson.getString("accountId"));
			njProdRepaymentObj.setRepayOrder(repaymentJson.getInteger("repayOrder"));
			if (null == repaymentJson.getString("id") || "".equals(repaymentJson.getString("id").trim())) {
				njProdRepaymentObj.setId(UuidUtil.get32UUID());
				njProdRepaymentObjMapper.insertSelective(njProdRepaymentObj);
			} else {
				njProdRepaymentObj.setId(repaymentJson.getString("id"));
				njProdRepaymentObjMapper.updateByPrimaryKeySelective(njProdRepaymentObj);
			}
		}

		// 设置代偿人账户,json数组
		JSONArray repayJson = JSONArray.parseArray(pd.getString("repayItems"));
		NjProdRepayObjMapper repayObjMapper = dao.getMapper(NjProdRepayObjMapper.class);
		NjProdRepayObj repayObj = new NjProdRepayObj();
		if (null != repayJson && repayJson.size() > 0) {
			for (int i = 0; i < repayJson.size(); i++) {
				JSONObject jb = repayJson.getJSONObject(i);
				repayObj.setProductId(pd.getString("productId"));
				repayObj.setRepayRole(jb.getInteger("repayRole"));
				repayObj.setUserId(jb.getString("accountId"));
				repayObj.setRepayOrder(jb.getInteger("repayOrder"));
				if (null == jb.getString("id") || "".equals(jb.getString("id").trim())) {
					repayObj.setId(UuidUtil.get32UUID());
					repayObjMapper.insertSelective(repayObj);
				} else {
					repayObj.setId(jb.getString("id"));
					repayObjMapper.updateByPrimaryKeySelective(repayObj);
				}
			}
		}

		// 设置收款对象
		JSONObject jb = JSONObject.parseObject(pd.getString("payeeItem"));
		if (null != jb) {

			NjProdPayeeObj payeeObj = new NjProdPayeeObj();
			payeeObj.setProductId(pd.getString("productId"));
			payeeObj.setPeyeeType(jb.getInteger("payeeType"));
			payeeObj.setPayeeRole(jb.getInteger("payeeRole"));
			payeeObj.setUserId(jb.getString("accountId"));
			NjProdPayeeObjMapper payeeObjMapper = dao.getMapper(NjProdPayeeObjMapper.class);
			if (null == jb.getString("id") || "".equals(jb.getString("id").trim())) {
				payeeObj.setId(UuidUtil.get32UUID());
				payeeObjMapper.insertSelective(payeeObj);
			} else {
				payeeObj.setId(jb.getString("id"));
				payeeObjMapper.updateByPrimaryKeySelective(payeeObj);
			}
		}
	}

	/**
	 * 根据产品ID获取产品相关详细信息
	 * 
	 * @param id
	 *            产品ID
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getProductInfoById(String id) throws Exception {
		// 获取产品基本信息
		NjProductMapperExtend cpm = dao.getMapper(NjProductMapperExtend.class);
		NjProduct product = cpm.getProductsById(id);

		// 获取产品贷款期数列表
		NjProductCycleMapperExtend cycleMapper = dao.getMapper(NjProductCycleMapperExtend.class);
		List<SysDict> cycleList = cycleMapper.getByProductId(id);

		// 获取产品类型列表
		NjProductTypeMapperExtend typeMapper = dao.getMapper(NjProductTypeMapperExtend.class);
		List<SysDict> typeList = typeMapper.getByProductId(id);

		// 获取产品发布区域列表
		NjProductAreaMapperExtend areaMapperExtend = dao.getMapper(NjProductAreaMapperExtend.class);
		NjProductArea njProductArea = areaMapperExtend.getTypeByProductId(id);
		Map<String, Object> areaMap = new HashMap<>();
		if(njProductArea != null) {
			NjProductAreaMapperExtend areaMapper = dao.getMapper(NjProductAreaMapperExtend.class);
			String type = njProductArea.getType().toString();
			if(type.equals("0")) {
				areaMap.put("type", 0);
			}else {
				List<Map<String, Object>> areaList = areaMapper.getByProductId(id,type);
				areaMap.put("type", type);
				areaMap.put("areaList", areaList);
			}
		}
		// 获取产品用途范围列表
		NjProductScopeMapperExtend scopeMapper = dao.getMapper(NjProductScopeMapperExtend.class);
		List<SysDict> scopeList = scopeMapper.getByProductId(id);

		Map<String, Object> retMap = new HashMap<>();
		retMap.put("productInfo", product);
		retMap.put("cycleList", cycleList);
		retMap.put("typeList", typeList);
		retMap.put("areaMap", areaMap);
		retMap.put("scopeList", scopeList);
		return retMap;
	}

	/**
	 * 获取产品渠道信息
	 * 
	 * @param productId
	 * @return
	 */
	public Map<String, Object> getProductChannel(String productId) throws Exception {
		Map<String, Object> retMap = new HashMap<>();
		NjProductChannelMapperExtend channelMapper = dao.getMapper(NjProductChannelMapperExtend.class);
		retMap.put("channelItems", channelMapper.selectByProduct(productId,1));
		retMap.put("moneyChannelItems", channelMapper.selectByProduct(productId,2));
		NjProductMapper productMapper = dao.getMapper(NjProductMapper.class);
		NjProduct njProduct = productMapper.selectByPrimaryKey(productId);
		retMap.put("isOwnChannel", njProduct.getIsOwnInput());
		return retMap;
	}

	/**
	 * 获取产品业务配置信息
	 * 
	 * @param productId
	 * @return
	 */
	public List<Map<String, Object>> getProductBusiness(String productId) throws Exception {
		NjProductBusinessDictMapperExtend businessDictMapperExtend = dao
				.getMapper(NjProductBusinessDictMapperExtend.class);
		return businessDictMapperExtend.selectByProduct(productId);
	}

	/**
	 * 获取产品交易配置信息
	 * 
	 * @param productId
	 * @return
	 */
	public Map<String, Object> getProductTransaction(String productId,String companyId) throws Exception {
		Map<String, Object> retMap = new HashMap<>();
		// 封装交易配置
		NjProductTransactionMapperExtend transactionMapperExtend = dao
				.getMapper(NjProductTransactionMapperExtend.class);
		Map<String, Object> njProductTransaction = transactionMapperExtend.selectByProductId(productId);
		//如果是小贷，则展示月利率，否则展示年利率
		if(!companyId.equals(com.nj.core.base.common.Constants.DEFAULT_COMPANY_ID)) {
			BigDecimal fixedInterestRate = (BigDecimal) njProductTransaction.get("fixedInterestRate");
			njProductTransaction.put("fixedInterestRate", fixedInterestRate == null ?"0":fixedInterestRate.divide(new BigDecimal("12"), 6));
			BigDecimal serviceCharge = (BigDecimal) njProductTransaction.get("serviceCharge");
			njProductTransaction.put("serviceCharge", serviceCharge == null ?"0":serviceCharge.divide(new BigDecimal("12"), 6));
			BigDecimal serviceChargeTerm = (BigDecimal) njProductTransaction.get("serviceChargeTerm");
			njProductTransaction.put("serviceChargeTerm", serviceChargeTerm == null ?"0":serviceChargeTerm.divide(new BigDecimal("12"), 6));
		}
		retMap.put("njProductTransaction", njProductTransaction);
		// 封装还款人信息
		NjProdRepaymentObjMapperExtend njProdRepaymentObjMapper = dao.getMapper(NjProdRepaymentObjMapperExtend.class);
		NjProdRepaymentObj repaymentObjs = njProdRepaymentObjMapper.selectByProductId(productId);
		retMap.put("repaymentObj", repaymentObjs);
		//封装代偿人信息
		NjProdRepayObjMapperExtend repayObjMapper = dao.getMapper(NjProdRepayObjMapperExtend.class);
		List<NjProdRepayObj> repayList = repayObjMapper.selectByProductId(productId);
		retMap.put("repayList", repayList);
		// 封装收款人信息
		NjProdPayeeObjMapperExtend payeeObjMapperExtend = dao.getMapper(NjProdPayeeObjMapperExtend.class);
		NjProdPayeeObj payeeObj = payeeObjMapperExtend.selectByProductId(productId);
		retMap.put("payeeObj", payeeObj);
		return retMap;
	}

	/**
	 * 获取产品业务配置项
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectBusinessDict(PageData pd) throws Exception {
		SysBusinessDictMapper dictMapper = dao.getMapper(SysBusinessDictMapper.class);
		SysBusinessDictExample example = new SysBusinessDictExample();
		String businessType = pd.getString("productTempId");
		example.createCriteria().andParentIdEqualTo(0).andBusinessTypeEqualTo(Byte.parseByte(businessType));
		
		//获取父级
		List<SysBusinessDict> parentBusinessDictList = dictMapper.selectByExample(example);
		List<Map<String, Object>> retList = new ArrayList<>();
		example = new SysBusinessDictExample();
		for (SysBusinessDict sysBusinessDict : parentBusinessDictList) {
			example.clear();
			Map<String, Object> retMap = new HashMap<>();
			retMap.put("id", sysBusinessDict.getId());
			retMap.put("showType", sysBusinessDict.getShowType());
			retMap.put("keyword", sysBusinessDict.getKeyword());
			retMap.put("descption", sysBusinessDict.getDescption());
			example.createCriteria().andParentIdEqualTo(sysBusinessDict.getId());
			List<SysBusinessDict> businessDicts = dictMapper.selectByExample(example);
			retMap.put("items", businessDicts);
			retList.add(retMap);
		}
		return retList;
	}

	/**
	 * 保存产品流程配置
	 * 
	 * @param pd
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveProductProcess(PageData pd) throws Exception {
		
		//更改产品状态
		NjProductMapper njProductMapper = dao.getMapper(NjProductMapper.class);
		NjProduct product = new NjProduct();
		product.setId(pd.getString("productId"));
		NjProduct tmpProduct = njProductMapper.selectByPrimaryKey(pd.getString("productId"));
		if(tmpProduct.getState()!= null && tmpProduct.getState().intValue() != 5) {
			product.setState(Constants.ProductState.SUBMITTED);
			njProductMapper.updateByPrimaryKeySelective(product);
		}
		// 保存流程模板基本信息
		ProcessTemplateMapper processTemplateMapper = dao.getMapper(ProcessTemplateMapper.class);
		ProcessTemplate processTemplate = new ProcessTemplate();
		// 如果是新增
		if (null == pd.getString("templateId") || "".equals(pd.getString("templateId").trim())) {
			
			//保存产品模板
			NjProductMapperExtend njProductMapperExtend = dao.getMapper(NjProductMapperExtend.class);
			
			String processId = UuidUtil.get32UUID();
			processTemplate.setId(processId);
			processTemplate.setProcessName(UuidUtil.get32UUID());
			processTemplate.setCreateTime(new Date());
			processTemplate.setIsDel(0);
			processTemplate.setBmpnName("");
			processTemplate.setPngName("");
			processTemplateMapper.insertSelective(processTemplate);
			
			// 保存产品、模板关联信息中间表
			//清空产品模板中间表
			NjProductTempMapper njProductTempMapper = dao.getMapper(NjProductTempMapper.class);
			NjProductTempExample example = new NjProductTempExample();
			example.createCriteria().andProductIdEqualTo(pd.getString("productId"));
			List<NjProductTemp> njProductTempList = njProductTempMapper.selectByExample(example);
			if(njProductTempList != null && njProductTempList.size() > 0) {
				NjProductTemp njProductTemp = njProductTempList.get(0);
				njProductTemp.setProcessTemplateId(processId);
				njProductTempMapper.updateByPrimaryKeySelective(njProductTemp);
			}else {
				NjProductTemp njProductTemp = new NjProductTemp();
				njProductTemp.setProcessTemplateId(processId);
				njProductTemp.setId(UuidUtil.get32UUID());
				njProductTemp.setProductId(pd.getString("productId"));
				njProductTempMapper.insertSelective(njProductTemp);
			}
		}else {
			processTemplate.setId(pd.getString("templateId"));
		}

		// 保存模板 流程表
		JSONArray array = JSONArray.parseArray(pd.getString("processItems"));
		NjProcessTemplateFlowsMapper flowsMapper = dao.getMapper(NjProcessTemplateFlowsMapper.class);
		// 清空之前的流程
		NjProcessTemplateFlowsMapperExtend flowsMapperExtend = dao.getMapper(NjProcessTemplateFlowsMapperExtend.class);
		flowsMapperExtend.deleteByProductId(processTemplate.getId());

		for (int i = 0; i < array.size(); i++) {
			JSONObject jb = array.getJSONObject(i);
			NjProcessTemplateFlows flows = new NjProcessTemplateFlows();
			// 设置流程表对应的流程模板
			flows.setTemplateId(processTemplate.getId());
			// 根据传入的基本流程枚举id相应枚举对象
			EProcessInfo processInfo = EProcessInfo.getEProcessInfo(jb.getIntValue("processId"));
			// 设置流程id
			flows.setProcessId(processInfo.getId());
			// 设置流程名称
			flows.setProcessName(jb.getString("processName"));
			// 设置流程类型(1:手动流程,2:自动流程,3:判断)
			flows.setType((short) processInfo.getType());
			// 设置同意订单状态后，下一步动作
			flows.setExecAgreeStatus(jb.getInteger("execAgreeStatus"));
			// 执行拒绝订单状态默认4
			flows.setExecRefuseStatus(ELoanOrderStatus.PLATFORM_REFUSE.getValue());
			// 驳回订单状态默认52
			flows.setExecRejectStatus(ELoanOrderStatus.FIRST_REJECT.getValue());
			// 设置流程顺序
			flows.setExecOrders(jb.getInteger("execOrders"));
			// 设置执行方法
			flows.setExecFunction(jb.getString("execFunction"));
			// 设置前置条件(1:agree:同意,2:reject:驳回,3:refuse:拒绝)'，默认为1
			flows.setPrecondition((short) 1);
			flowsMapper.insertSelective(flows);
		}
	}

	/**
	 * 获取流程配置
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<NjProcessTemplateFlows> getProductProcess(String productId) throws Exception {
		NjProcessTemplateFlowsMapperExtend flowsMapper = dao.getMapper(NjProcessTemplateFlowsMapperExtend.class);
		return flowsMapper.selectByProductId(productId);
	}
	/**
	 * 获取产品费用配置信息
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getProductFee(String productId) throws Exception {
		NjProductFeeCfgMapper flowsMapper = dao.getMapper(NjProductFeeCfgMapper.class);
		NjProductFeeCfgExample cfgExample = new NjProductFeeCfgExample();
		//获取还款计划费用配置信息
		cfgExample.createCriteria().andProductIdEqualTo(productId).andCfgObjEqualTo(new Short("1"));
		List<NjProductFeeCfg> repayFeeItems = flowsMapper.selectByExample(cfgExample);
		for (NjProductFeeCfg njProductFeeCfg : repayFeeItems) {
			String calCode = njProductFeeCfg.getAlgorithmCode();
			if(!StringUtils.isEmpty(calCode)) {
				EBusinessFeeAlgorithm algorithm = EBusinessFeeAlgorithm.getAlgoByCode(calCode);
				njProductFeeCfg.setAlgorithmCode(calCode+"$"+algorithm.getExplain());
			}
			
		}
		cfgExample = new NjProductFeeCfgExample();
		//获取回款计划费用配置信息
		cfgExample.createCriteria().andProductIdEqualTo(productId).andCfgObjEqualTo(new Short("2"));
		List<NjProductFeeCfg> payBakFeeItems = flowsMapper.selectByExample(cfgExample);
		for (NjProductFeeCfg njProductFeeCfg : payBakFeeItems) {
			String calCode = njProductFeeCfg.getAlgorithmCode();
			if(!StringUtils.isEmpty(calCode)) {
				EBusinessFeeAlgorithm algorithm = EBusinessFeeAlgorithm.getAlgoByCode(calCode);
				njProductFeeCfg.setAlgorithmCode(calCode+"$"+algorithm.getExplain());
			}
		}
		//
		NjProductMapper mapper = dao.getMapper(NjProductMapper.class);
		NjProduct njProduct = mapper.selectByPrimaryKey(productId);
		Map<String, Object> map = new HashMap<>();
		map.put("isOverdueAutoDeduct", njProduct.getIsOverdueAutoDeduct());
		map.put("repayFeeItems", repayFeeItems);
		map.put("payBakFeeItems", payBakFeeItems);
		return map;
	}

	/**
	 * 根据用户ID获取用户拥有产品列表
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<NjProductUser> getUserHasProductList(String userId) throws Exception {
		NjProductUserMapperExtend extend = dao.getMapper(NjProductUserMapperExtend.class);
		return extend.getByParams(userId);
	}

	/**
	 * 获取app产品列表
	 * @param paramMap
	 */
	public List<NjProduct> selectProductList(Map<String, Object> paramMap) throws Exception {
		//根据区域编号获取区域id
		SysDictMapperExtend dictMapper = dao.getMapper(SysDictMapperExtend.class);
		String areaCode = (String) paramMap.get("areaCode");
		SysDict sysDict = dictMapper.selectByDictValue(areaCode);
		if(null != sysDict) {
			String parentCode = sysDict.getParentId();
			if(parentCode != null && !parentCode.equals("0")) {
				SysDict sysDictParent = dictMapper.selectByDictValue(parentCode);
				paramMap.put("parentId", sysDictParent.getId());
			}
			paramMap.put("areaId", sysDict.getId());
			NjProductMapperExtend extend = dao.getMapper(NjProductMapperExtend.class);
			return extend.selectProductList(paramMap);
		}
		throw new Exception("没有找到区域编号"+areaCode);
	}
	
	/**
	 * 根据产品id、类型id获取产品配置项
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<SysBusinessDictModel> getProductBusinessByType(Map<String, Object> paramMap) throws Exception {
		NjProductBusinessDictMapperExtend extend = dao.getMapper(NjProductBusinessDictMapperExtend.class);
		return extend.getProductBusinessByType(paramMap);
	}

	public NjProductModel getProductDetail(String id) throws Exception {
		
		NjProductModel njProductModel = new NjProductModel();
		//获取产品信息
		NjProductMapper cpm = dao.getMapper(NjProductMapper.class);
		NjProduct njProduct = cpm.selectByPrimaryKey(id);
		njProductModel.setNjproduct(njProduct);
		NjProductMapperExtend extend = dao.getMapper(NjProductMapperExtend.class);
		//判断产品进件类型
		Map<String, Object> map = extend.getChannelType(id);
		if(null != map) {
			if(njProduct.getIsOwnInput()) {
				njProductModel.setIsChannelInput(2);
			}else {
				njProductModel.setIsChannelInput(1);
			}
		}else {
			njProductModel.setIsChannelInput(0);
		}
		//获取产品所需材料
		//2：附件资料，4：身份证相关资料
		String material = extend.selectProductMaterial(id,"2,4");
		njProductModel.setMaterial(material ==null ?"无":material);
		//获取产品贷款期数列表
		NjProductCycleMapperExtend cycleMapperExtend = dao.getMapper(NjProductCycleMapperExtend.class);
		List<SysDict> cycles = cycleMapperExtend.getByProductId(id);
		njProductModel.setTermInfoList(cycles);
		//获取产品借款用途
		NjProductScopeMapperExtend scopeMapperExtend = dao.getMapper(NjProductScopeMapperExtend.class);
		List<SysDict> scopes = scopeMapperExtend.getByProductId(id);
		njProductModel.setProductScopeList(scopes);
		//设置还款方式
		SysDictMapperExtend dictMapperExtend = dao.getMapper(SysDictMapperExtend.class);
		String repayWay = njProduct.getRepayWay();
		if(repayWay != null) {
			List<SysDict> dicts = new ArrayList<>();
			String[] repayWayList = repayWay.split(",");
			for (String string : repayWayList) {
				SysDict sysDict = dictMapperExtend.getByValue(string);
				dicts.add(sysDict);
			}
			njProductModel.setRepayWay(dicts);
		}
		//获取产品模板
		NjProductTempMapper mapper = dao.getMapper(NjProductTempMapper.class);
		NjProductTempExample example = new NjProductTempExample();
		example.createCriteria().andProductIdEqualTo(id);
		List<NjProductTemp> list = mapper.selectByExample(example);
		if(list != null &&list.size() > 0) {
			njProductModel.setTemplateId(list.get(0).getTemplateId());
		}
		return njProductModel;
	}

	/**
	 * 根据订单获取该订单产品
	 * @param orderNo
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> getProductByOrderNo(String orderNo) throws Exception {
		NjProductMapperExtend extend = dao.getMapper(NjProductMapperExtend.class);
		return extend.getProductByOrderNo(orderNo);
	}

	/**
	 * 获取产品
	 * @param pd
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> listApi(PageData pd) throws Exception {
		NjProductMapperExtend extend = dao.getMapper(NjProductMapperExtend.class);
		pd.put("start", pd.getInteger("start"));
		pd.put("length", pd.getInteger("length"));
		return extend.selectProductOutApiList(pd);
	}

	/**
	 * 获取产品接口数
	 * @param pd
	 * @return
	 * @throws Exception 
	 */
	public long listApiAllCount(PageData pd) throws Exception {
//		NjProductMapper sm = dao.getMapper(NjProductMapper.class);
//		
//		NjProductExample example = new NjProductExample();
//		com.nj.model.generate.NjProductExample.Criteria criteria = example.createCriteria();   
//		criteria.andDelFlagEqualTo(false);
//		criteria.andStateEqualTo(Constants.ProductState.ONLINE);
////		String search = pd.getString("keyword");
////		if (StringUtils.isNotBlank(search)) {
////			criteria.andTypeLike("%"+pd.get("keyword").toString()+"%");
////		}
//		return sm.countByExample(example);
		
		NjProductMapperExtend extend = dao.getMapper(NjProductMapperExtend.class);
		
		return extend.selectProductOutApiListCount(pd);
	}

	/**
	 * 获取产品已有接口
	 * @param pd
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> selectProductApi(PageData pd) throws Exception {
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		return sm.selectProductApi(pd);
	}

	/**
	 * 获取所有接口列表
	 * @param pd
	 * @return
	 * @throws Exception 
	 */
	public List<Map<String, Object>> selectAllApi(PageData pd) throws Exception {
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		return sm.selectAllApi(pd);
	}

	/**
	 * 保存产品接口
	 * @param pd
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveProductApi(PageData pd) throws Exception {
		String productId = (String) pd.get("productId");
		String apiIds = pd.getString("apiIds");
		String[] apiList = apiIds.split(",");
		if(apiList != null && apiList.length > 0) {
			NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
			//清除之前的数据
			sm.deleteProductApiByProductId(productId);
			
			NjProductOutsideApiMapper apiMapper = dao.getMapper(NjProductOutsideApiMapper.class);
			NjProductOutsideApi njProductOutsideApi = null;
			for (String apiId : apiList) {
				njProductOutsideApi = new NjProductOutsideApi();
				njProductOutsideApi.setOutsideApiId(Long.parseLong(apiId));
				njProductOutsideApi.setProductId(productId);
				apiMapper.insert(njProductOutsideApi);
			}
		}
	}

	/**
	 * 根据订单ID获取产品接口列表
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<SysOutsideApi> selectApiByOrderId(String orderId) throws Exception {
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder loanOrder = mapper.selectByPrimaryKey(orderId);
		if(loanOrder != null && loanOrder.getProductId() != null) {
			NjProductMapperExtend extend = dao.getMapper(NjProductMapperExtend.class);
			return extend.selectApiByOrderId(loanOrder.getProductId());
		}else 
			throw new Exception("未检索到相关订单信息，或者对应产品id为空");
		
	}

	/**
	 * 根据产品和展示类型获取产品配置大类列表
	 * @param paramMap
	 * @return
	 * @throws Exception 
	 */
	public List<Map> getProductBusinessTypeList(Map<String, Object> paramMap) throws Exception {
		NjProductBusinessDictMapperExtend extend = dao.getMapper(NjProductBusinessDictMapperExtend.class);
		return extend.getProductBusinessTypeList(paramMap);
	}
	/**
	 * 根据产品id获取产品模板
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public NjProductTemp getProductTemplateByProductId(String productId) throws Exception{
		NjProductTempMapper mapper = dao.getMapper(NjProductTempMapper.class);
		NjProductTempExample example = new NjProductTempExample();
		example.createCriteria().andProductIdEqualTo(productId);
		if(mapper.selectByExample(example) != null && mapper.selectByExample(example).size() > 0) {
			return mapper.selectByExample(example).get(0);
		}
		return null;
	}
	
	/**
	 * 通过产品ID查询
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<SysDict>  getProductPeriodByProductId(String productId) throws Exception{
		//获取产品贷款期数列表
		NjProductCycleMapperExtend cycleMapperExtend = dao.getMapper(NjProductCycleMapperExtend.class);
		List<SysDict> cycles = cycleMapperExtend.getByProductId(productId);
		return cycles;
	}

	public Object selectProductBusinessDict(PageData pd) throws Exception {

		SysBusinessDictMapper dictMapper = dao.getMapper(SysBusinessDictMapper.class);
		SysBusinessDictExample example = new SysBusinessDictExample();
		String businessType = pd.getString("productTempId");
		example.createCriteria().andParentIdEqualTo(0).andBusinessTypeEqualTo(Byte.parseByte(businessType));
		
		//获取父级
		List<SysBusinessDict> parentBusinessDictList = dictMapper.selectByExample(example);
		List<Map<String, Object>> retList = new ArrayList<>();
		example = new SysBusinessDictExample();
		for (SysBusinessDict sysBusinessDict : parentBusinessDictList) {
			example.clear();
			if(sysBusinessDict.getShowType().intValue() == 2 || sysBusinessDict.getShowType().intValue() == 4) {
				Map<String, Object> retMap = new HashMap<>();
				retMap.put("id", sysBusinessDict.getId());
				retMap.put("keyword", sysBusinessDict.getKeyword());
				retMap.put("descption", sysBusinessDict.getDescption());
				example.createCriteria().andParentIdEqualTo(sysBusinessDict.getId());
				List<SysBusinessDict> businessDicts = dictMapper.selectByExample(example);
				retMap.put("items", businessDicts);
				retList.add(retMap);
			}
		}
		return retList;
	
	}
	
	/**
	 * 根据订单id获取订单渠道费率（年费率）
	 * @param orderId
	 * @return
	 * @throws Exception 
	 */
	public Float getChannelFeeByOrderId(String orderId) throws Exception {
		if(orderId == null) {
			throw new Exception("com.nj.service.enterprise.getChannelFeeByOrderId:订单不能为空");
		}
		NjLoanOrderMapper loanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder loanOrder = loanOrderMapper.selectByPrimaryKey(orderId);
		NjProductChannelMapper channelMapper = dao.getMapper(NjProductChannelMapper.class);
		NjProductChannel pChannel =channelMapper.selectByPrimaryKey(loanOrder.getChannelId());
		if(pChannel.getOperateFee() == null) {
			return (float) 0;
		}
		return pChannel.getOperateFee() * 12;
	}
	
	/**
	 * 通过产品Code 查询产品
	 * @param productCode
	 * @return
	 * @throws Exception
	 */
	public NjProduct getProductByCode(String productCode) throws Exception{
		
		NjProductMapper mapper =dao.getMapper(NjProductMapper.class);
		NjProductExample example = new NjProductExample();
		example.createCriteria().andProductCodeEqualTo(productCode);
		List<NjProduct> listProduct = mapper.selectByExample(example);
		
		if (listProduct.size()>0) {
			return listProduct.get(0);
		}else {
			return null;
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveProductFeeCfg(PageData pd) throws Exception{
		String productId = pd.getString("productId");
		NjProduct njProduct = new NjProduct();
		njProduct.setId(productId);
		njProduct.setIsOverdueAutoDeduct(new Short(pd.getString("isOverdueAutoDeduct")));//设置逾期是否自动扣款
		NjProductMapper mapper = dao.getMapper(NjProductMapper.class);
		mapper.updateByPrimaryKeySelective(njProduct);
		
		String moneyArr = pd.getString("moneyArr");
		JSONArray array = JSONArray.parseArray(moneyArr);
		NjProductFeeCfg feeCfg = null;
		
		NjProductFeeCfgMapper cfgMapper = dao.getMapper(NjProductFeeCfgMapper.class);
		//根据产品id清除产品费用配置信息
		NjProductFeeCfgExample cfgExample= new NjProductFeeCfgExample();
		cfgExample.createCriteria().andProductIdEqualTo(productId);
		cfgMapper.deleteByExample(cfgExample);
		for (int i = 0; i < array.size(); i++) {
			JSONObject jb = array.getJSONObject(i);
			feeCfg = new NjProductFeeCfg();
			feeCfg.setCfgObj(jb.getShort("type"));  //配置对象。1：客户还款计划2：小贷公司回款计划
			feeCfg.setAlgorithmCode(jb.getString("calCode")); // 采用算法
			feeCfg.setBusinessFeeCode(jb.getString("code")); //费用code
			feeCfg.setCreateBy(pd.getString("userId"));
			feeCfg.setCreateDate(new Date());
			feeCfg.setId(UuidUtil.get32UUID());
			feeCfg.setProductId(productId); // 产品id
			cfgMapper.insertSelective(feeCfg);
		}
	}
	
	/**
	 * 获取企业下，所有产品，还款计划配置的费用code，去重
	 */
	public Set<String> getFeeCodeSetByCoporateId(String coporateId) throws Exception{
		NjProductFeeCfgMapperExtend feeCfgMapperExtend = dao.getMapper(NjProductFeeCfgMapperExtend.class);
		return feeCfgMapperExtend.getFeeCodeSetByCoporateId(coporateId);
	}
	
	/**
	 * 根据产品费用配置信息
	 * @param productId 产品id
	 * @param cfgObj 配置对象
	 * @param businessFeeCode 业务费用code
	 * @throws Exception 
	 */
	public NjProductFeeCfg getProductFeeCfg(String productId,Short cfgObj,String businessFeeCode) throws Exception{
		NjProductFeeCfgMapper mapper = dao.getMapper(NjProductFeeCfgMapper.class);
		NjProductFeeCfgExample e = new NjProductFeeCfgExample();
		e.createCriteria().andProductIdEqualTo(productId).andCfgObjEqualTo(cfgObj).andBusinessFeeCodeEqualTo(businessFeeCode); 
		List<NjProductFeeCfg> list = mapper.selectByExample(e);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
	}
}
