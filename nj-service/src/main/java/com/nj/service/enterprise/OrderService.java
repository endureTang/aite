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

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jd.core.util.DateTimeHelper;
import com.jd.core.util.RandomUtil;
import com.nj.bean.OfflineRepayBean;
import com.nj.core.base.common.AddressConstants;
import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProcessInfo;
import com.nj.core.base.enums.EProcessResult;
import com.nj.core.base.enums.ERoleType;
import com.nj.core.base.enums.ESysDictType;
import com.nj.core.base.exception.BaseException;
import com.nj.core.base.exception.ExistException;
import com.nj.core.base.exception.ParamsException;
import com.nj.core.base.util.AESUtil;
import com.nj.core.base.util.CardCheck;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.FileOperationUtil;
import com.nj.core.base.util.IdentifyUtil;
import com.nj.core.base.util.ImageAnd64Binary;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UserSessions;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.NjAssetGradeMapper;
import com.nj.dao.NjBaseInfoCompanyMapper;
import com.nj.dao.NjChannelRelativeMapper;
import com.nj.dao.NjChannelUserMapper;
import com.nj.dao.NjContactCompanyMapper;
import com.nj.dao.NjCoporateMapper;
import com.nj.dao.NjDeductionNoticeMapper;
import com.nj.dao.NjHouseAttachmentMapper;
import com.nj.dao.NjLoanOrderCheckRecordMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjOrderArchiveRecordMapper;
import com.nj.dao.NjOrderAreaMapper;
import com.nj.dao.NjOrderAttachmentMapper;
import com.nj.dao.NjOrderDebtMapper;
import com.nj.dao.NjOrderFeeMapper;
import com.nj.dao.NjOrderHouseMapper;
import com.nj.dao.NjOrderPawnHouseLinkMapper;
import com.nj.dao.NjOrderPawnHouseMapper;
import com.nj.dao.NjOrderRelativeMapper;
import com.nj.dao.NjOrderUpdateAttachmentMapper;
import com.nj.dao.NjOrderUpdateLogMapper;
import com.nj.dao.NjOrderUserCarMapper;
import com.nj.dao.NjOrderWorkMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.dao.NjScenesCompanyMapper;
import com.nj.dao.NjStatisticsSummaryMapper;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.dao.NjUserBusinessApprovalMapper;
import com.nj.dao.NjUserBusinessSurveyMapper;
import com.nj.dao.NjUserCarMapper;
import com.nj.dao.NjUserContactMapper;
import com.nj.dao.NjUserDebtInfoMapper;
import com.nj.dao.NjUserHouseMapper;
import com.nj.dao.NjUserRelativesMapper;
import com.nj.dao.NjUserSpotMapper;
import com.nj.dao.NjUserWorkInfoMapper;
import com.nj.dao.NjWithdrawingRecordMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.SysUpdateTableLogMapper;
import com.nj.dao.extend.NjAppUserBasicInfoMapperExtend;
import com.nj.dao.extend.NjAppUserCarMapperExtend;
import com.nj.dao.extend.NjAppUserRelativesMapperExtend;
import com.nj.dao.extend.NjAppUserWorkMapperExtend;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjOrderAreaMapperExtend;
import com.nj.dao.extend.NjOrderProcessMapperExtend;
import com.nj.dao.extend.NjOrderUpdateLogMapperExtend;
import com.nj.dao.extend.NjProcessMapperExtend;
import com.nj.dao.extend.NjProductChannelMapperExtend;
import com.nj.dao.extend.NjProductCycleMapperExtend;
import com.nj.dao.extend.NjProductTempMapperExtend;
import com.nj.dao.extend.NjStatisticsSummaryMapperExtend;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.dao.extend.NjWithdrawingRecordMapperExtend;
import com.nj.model.constant.LoanOrderConstant;
import com.nj.model.datamodel.UpdatePlanDto;
import com.nj.model.esign.constants.EsignFileCateConstant;
import com.nj.model.generate.NjAssetGrade;
import com.nj.model.generate.NjBankInfo;
import com.nj.model.generate.NjBaseInfoCompany;
import com.nj.model.generate.NjChannelRelative;
import com.nj.model.generate.NjChannelUser;
import com.nj.model.generate.NjChannelUserExample;
import com.nj.model.generate.NjContactCompany;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateExample;
import com.nj.model.generate.NjDeductionNotice;
import com.nj.model.generate.NjHouseAttachment;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjLoanOrderCheckRecord;
import com.nj.model.generate.NjLoanOrderCheckRecordExample;
import com.nj.model.generate.NjLoanOrderExample;
import com.nj.model.generate.NjLoanOrderExample.Criteria;
import com.nj.model.generate.NjOrderArchiveRecord;
import com.nj.model.generate.NjOrderArchiveRecordExample;
import com.nj.model.generate.NjOrderArea;
import com.nj.model.generate.NjOrderAreaExample;
import com.nj.model.generate.NjOrderAttachmentExample;
import com.nj.model.generate.NjOrderBhRecord;
import com.nj.model.generate.NjOrderDebt;
import com.nj.model.generate.NjOrderFee;
import com.nj.model.generate.NjOrderFeeExample;
import com.nj.model.generate.NjOrderFlowProcedure;
import com.nj.model.generate.NjOrderFlows;
import com.nj.model.generate.NjOrderHouse;
import com.nj.model.generate.NjOrderPawnHouse;
import com.nj.model.generate.NjOrderPawnHouseLink;
import com.nj.model.generate.NjOrderPawnHouseLinkExample;
import com.nj.model.generate.NjOrderRelative;
import com.nj.model.generate.NjOrderUpdateAttachment;
import com.nj.model.generate.NjOrderUpdateAttachmentExample;
import com.nj.model.generate.NjOrderUpdateLog;
import com.nj.model.generate.NjOrderUpdateLogExample;
import com.nj.model.generate.NjOrderUserCar;
import com.nj.model.generate.NjOrderWork;
import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductTemp;
import com.nj.model.generate.NjProductTransactionOffline;
import com.nj.model.generate.NjProductTransactionOnline;
import com.nj.model.generate.NjScenesCompany;
import com.nj.model.generate.NjStatisticsSummary;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserBasicInfo;
import com.nj.model.generate.NjUserBusinessApproval;
import com.nj.model.generate.NjUserBusinessApprovalExample;
import com.nj.model.generate.NjUserBusinessSurvey;
import com.nj.model.generate.NjUserBusinessSurveyExample;
import com.nj.model.generate.NjUserCar;
import com.nj.model.generate.NjUserContact;
import com.nj.model.generate.NjUserContactExample;
import com.nj.model.generate.NjUserDebtInfo;
import com.nj.model.generate.NjUserHouse;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.NjUserRelatives;
import com.nj.model.generate.NjUserSpot;
import com.nj.model.generate.NjUserSpotExample;
import com.nj.model.generate.NjUserWorkInfo;
import com.nj.model.generate.NjWithdrawingRecord;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysDictExample;
import com.nj.model.generate.SysUpdateTableLog;
import com.nj.model.vo.OrderUpdateLogVO;
import com.nj.service.base.system.DictService;
import com.nj.service.esign.ApiEsignService;
import com.nj.service.esign.UserSignService;
import com.nj.service.itf.FileOperationService;
import com.nj.service.itf.ItfFaceIdService;
import com.nj.service.itf.TfcfHttpService;
import com.nj.service.itf.UserBankCardService;
import com.nj.service.process.ManualProcess;
import com.nj.service.remoteing.BhDataService;
import com.nj.service.remoteing.RepayPlanNewService;
import com.timevale.esign.sdk.tech.bean.PosBean;
import com.timevale.esign.sdk.tech.bean.SignPDFFileBean;
import com.timevale.esign.sdk.tech.impl.constants.SignType;

/**
 * @author 009
 *
 */

@Service("orderService")
public class OrderService extends BaseCachesService {

	/*
	 * @Resource(name = "BaseDao") private BaseDao dao;
	 */
	@Resource
	private ManualProcess manualProcess;

	@Resource(name = "tfcfHttpService")
	private TfcfHttpService tfcfHttpService;

	@Resource
	private NjProcessMapperExtend processMapperExtend;

	@Resource(name = "itfFaceIdService")
	private ItfFaceIdService itfFaceIdService;

	@Resource
	private NjOrderUpdateLogMapperExtend orderUpdateLogMapperExtend;

	@Autowired
	private SizeFilterService filterService;

	@Resource(name = "apiEsignService")
	private ApiEsignService apiEsignService;

	@Resource(name = "userSignService")
	private UserSignService userSignService;

	@Resource
	private NjCoporateMapper njCoporateMapper;
	@Resource
	private NjLoanOrderMapper NjLoanOrderMapper;
	@Resource
	private NjLoanOrderMapperExtend njLoanOrderMapperExtend;
	@Resource
	private NjStatisticsSummaryMapper NjStatisticsSummaryMapper;
	@Resource
	private NjStatisticsSummaryMapperExtend njStatisticsSummaryMapperExtend;

	@Resource(name = "fileOperationService")
	private FileOperationService fileOperationService;

	@Resource(name = "userBankCardService")
	private UserBankCardService userBankCardService;

	@Autowired
	private RepayPlanNewService repayPlanNewService;
	
	@Autowired
	private BhDataService bhDataService;

	@Resource
	private DictService dictService;

	private static Logger logger = LoggerFactory.getLogger(OrderService.class);

	/*
	 * 获取待生成合同的订单
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getOrdsByStatus(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getOrdsByStatus(pd);
	}
	
	/**
	 * 获取进件日期在指定日期之间通过的订单
	 *   @param statisticalDateBegin 统计开始日期，包含开始日期
	 *   @param statisticalDateEnd 统计结束日期，不包含日期当天
	 *   @param statusNotInList 查询订单状态不在该list的订单
	 * @throws Exception 
	 */
	public List<NjLoanOrder> getCrossOrderList(Date statisticalDateBegin,Date statisticalDateEnd,List<Integer> statusNotInList) throws Exception{
		
		NjLoanOrderExample ex = new NjLoanOrderExample();
		Criteria c = ex.createCriteria();
		c.andDelFlagEqualTo(false)
		 .andCreateDateLessThan(statisticalDateEnd)
		 .andCreateDateGreaterThanOrEqualTo(statisticalDateBegin);
		
		if(!org.springframework.util.CollectionUtils.isEmpty(statusNotInList)){
			c.andStatusNotIn(statusNotInList);
		}
		
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		return mapper.selectByExample(ex);
	}

	public NjLoanOrder getOrderByOrderNo(String orderNo) throws Exception {
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample example = new NjLoanOrderExample();
		example.createCriteria().andOrderNoEqualTo(orderNo).andDelFlagEqualTo(false);
		List<NjLoanOrder> orders = mapper.selectByExample(example);
		if (orders == null || orders.isEmpty())
			return null;
		return orders.get(0);
	}

	public NjLoanOrder getOrder(String orderId) throws Exception {
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		return mapper.selectByPrimaryKey(orderId);
	}

	@SuppressWarnings("rawtypes")
	public PageData getOrderList(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		pd.put("page", pd.getPage());
		List<Map> results = mapper.selectOrdersListPage(pd);

		logger.debug("results: " + pd.getPageInfo().getTotalResult());
		PageData pd1 = new PageData();
		// pd1.put(Const.DRAW, pd.getString(Const.DRAW));
		// pd1.put(Constants.Datas.RECORDSTOTAL,
		// pd.getPageInfo().getTotalResult());
		pd1.put(Constants.Datas.RECORDSFILTERED, pd.getPageInfo().getTotalResult());
		pd1.put(Constants.Datas.NDATA, results);
		return pd1;
	}

	@SuppressWarnings("rawtypes")
	public PageData getOrderListForThird(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		pd.put("page", pd.getPage());
		List<Map> results = mapper.selectOrdersListPageForThird(pd);

		logger.debug("results: " + pd.getPageInfo().getTotalResult());
		PageData pd1 = new PageData();
		// pd1.put(Const.DRAW, pd.getString(Const.DRAW));
		// pd1.put(Constants.Datas.RECORDSTOTAL,
		// pd.getPageInfo().getTotalResult());
		pd1.put(Constants.Datas.RECORDSFILTERED, pd.getPageInfo().getTotalResult());
		pd1.put(Constants.Datas.NDATA, results);
		return pd1;
	}

	public Map getOrderInfo(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map result = mapper.getOrderDetailsByNo(pd.getString("orderNo"));

		return result;
	}

	public List<NjUserRelatives> getRecentRelativesInfo(String orderId) throws Exception {
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		return sm.getRelativesByOrderId(orderId);
	}

	public List<NjUserRelatives> getContactsByOrderNo(String orderId) throws Exception {
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		return sm.getContactsByOrderNo(orderId);
	}

	public List<Map> getRelativesList(String orderId) throws Exception {
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		return sm.getRelativesListByOrderId(orderId);
	}

	/**
	 * 通过订单ID查询配偶信息
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Map> getRelativesSpouse(String orderId) throws Exception {

		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		return sm.getRelativesSpouseByOrderId(orderId);

	}

	/**
	 * 通过订单ID查询抵押房信息
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Map> getHousePawnByOrderId(String orderId) throws Exception {

		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		return sm.getHousePawnByOrderId(orderId);
	}

	/**
	 * 根据订单ID查询业务调查
	 * 
	 * @return
	 * @throws Exception
	 */
	public NjUserBusinessSurvey getBusinessSurveyByOrderId(String orderId) throws Exception {

		NjUserBusinessSurveyMapper mapper = dao.getMapper(NjUserBusinessSurveyMapper.class);
		NjUserBusinessSurveyExample example = new NjUserBusinessSurveyExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andIsDelEqualTo(false);
		List<NjUserBusinessSurvey> listUserBusinessSurvey = mapper.selectByExample(example);
		if (listUserBusinessSurvey != null && listUserBusinessSurvey.size() > 0) {
			return listUserBusinessSurvey.get(0);
		}
		return null;

	}

	/**
	 * 通过订单ID查询业务审批
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public NjUserBusinessApproval getUserBusinessApprovalByOrderId(String orderId) throws Exception {

		NjUserBusinessApprovalMapper mapper = dao.getMapper(NjUserBusinessApprovalMapper.class);
		NjUserBusinessApprovalExample example = new NjUserBusinessApprovalExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andIsDelEqualTo(false);
		List<NjUserBusinessApproval> listUserBusinessApproval = mapper.selectByExample(example);
		if (listUserBusinessApproval != null && listUserBusinessApproval.size() > 0) {
			return listUserBusinessApproval.get(0);
		}
		return null;
	}

	/**
	 * 通过订单ID查询房产信息
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Map> getHouseByOrderId(String orderId) throws Exception {
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		return sm.getHouseByOrderId(orderId);
	}

	/**
	 * 通过订单ID查询负债信息
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Map> getDebtByOrderId(String orderId) throws Exception {
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		return sm.getDebtByOrderId(orderId);
	}

	public NjUserWorkInfo getWorInfo(String orderId) throws Exception {
		NjAppUserWorkMapperExtend mapper = dao.getMapper(NjAppUserWorkMapperExtend.class);
		return mapper.getOrderWorkInfo(orderId);
	}

	public Map<String, Object> getWorInfoNew(String orderId) throws Exception {
		NjAppUserWorkMapperExtend mapper = dao.getMapper(NjAppUserWorkMapperExtend.class);
		return mapper.getOrderWorkNew(orderId);
	}

	public List getWorkAttInfo(NjUserWorkInfo workInfo) throws Exception {
		if (null == workInfo) {
			return new ArrayList<Map>();
		}
		NjAppUserWorkMapperExtend mapper = dao.getMapper(NjAppUserWorkMapperExtend.class);
		return mapper.getWorkAttMapByWorkId(workInfo.getId());

	}

	public Map getCarInfo(String orderId) throws Exception {
		NjAppUserCarMapperExtend mapper = dao.getMapper(NjAppUserCarMapperExtend.class);
		List<Map> list = mapper.getCarByOrderId(orderId);
		if (list != null && list.size() > 0) {
			Map map = list.get(0);
			if (map != null && map.containsKey("id")) {
				String carId = (String) map.get("id");
				List<Map> listMap = mapper.getUserCarAttachByCarId(carId);
				map.put("carImgList", listMap);
			}
			return map;
		}
		return null;
	}

	public Map getUserCarInfo(String orderId) throws Exception {
		NjAppUserCarMapperExtend mapper = dao.getMapper(NjAppUserCarMapperExtend.class);
		List<Map> list = mapper.getCarByOrderId(orderId);
		Map resultMap = new HashMap<>();
		if (list != null && list.size() > 0) {
			resultMap.putAll(list.get(0));
		}
		return resultMap;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map<String, Object>> getCarInfoThird(String orderId) throws Exception {

		NjAppUserCarMapperExtend mapper = dao.getMapper(NjAppUserCarMapperExtend.class);
		List<Map> list = mapper.getCarByOrderIdThird(orderId);

		SysDictMapper sdMapper = dao.getMapper(SysDictMapper.class);
		SysDictExample ex = new SysDictExample();
		ex.createCriteria().andTypeEqualTo("CLLX");
		List<SysDict> sdList = sdMapper.selectByExample(ex);
		Map<String, String> sdMap = new HashMap<String, String>();
		for (SysDict sd : sdList) {
			sdMap.put(sd.getValue(), sd.getLabelText());
		}

		Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();

		for (Map temp : list) {
			String carid = (String) temp.get("id");
			Map<String, Object> carinfoMap = map.get(carid);
			if (null == carinfoMap) {
				carinfoMap = new HashMap<String, Object>();
				map.put(carid, carinfoMap);

				carinfoMap.put("id", carid);
				carinfoMap.put("carNumber", temp.get("carNumber"));
				String carTypeFormat = sdMap.get(temp.get("carType"));
				carinfoMap.put("carType", StringUtils.isEmpty(carTypeFormat) ? "" : carTypeFormat);
				carinfoMap.put("buyPrice", temp.get("buyPrice"));
				carinfoMap.put("carAge", temp.get("carAge"));
				carinfoMap.put("shdq", temp.get("shdq"));
				carinfoMap.put("xjcd", temp.get("xjcd"));
			}

			Object filepathList = carinfoMap.get("filepathList");
			if (null == filepathList) {
				filepathList = new ArrayList<String>();
				carinfoMap.put("filepathList", filepathList);
			}
			List<String> filepathlist2 = (List<String>) filepathList;
			if (null != temp.get("filepath")) {
				filepathlist2.add(temp.get("filepath").toString());
			}
		}

		return new ArrayList(map.values());
	}

	public NjUserBasicInfo getUserBasicInfoByOrderId(String orderId) throws Exception {
		NjAppUserBasicInfoMapperExtend mapper = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
		return mapper.getUserBasicInfoByOrderId(orderId);
	}

	public NjUserBasicInfo getUserBasicInfoByUserId(String orderId) throws Exception {
		NjAppUserBasicInfoMapperExtend mapper = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
		return mapper.getUserBasicInfoByUserId(orderId);
	}

	public List getUserBasicInfoAtt(NjUserBasicInfo basicInfo) throws Exception {
		NjAppUserBasicInfoMapperExtend mapper = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
		return mapper.getBasicAttMapByWorkId(basicInfo.getId());
	}

	public List getUserBasicInfoAttByUserId(String userId) throws Exception {
		NjAppUserBasicInfoMapperExtend mapper = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
		return mapper.getBasicAttMapByWorkId(userId);
	}

	public Map getTradeInfo(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getTradeInfo(pd);
	}

	/*
	 * 生成合同服务
	 */
	public void createContract(Map ord, String tokenName, String tokenId) {
		try {
			logger.info("订单：" + ord.get("orderId") + "调用财富端生成合同接口开始...");
			String tfcfResp = tfcfHttpService.doHttpPostForTfcf(tokenName, tokenId, ord,
					com.nj.core.base.common.Constants.TFCF.CONTRACT_GENERATE);
			logger.info("响应结果: " + tfcfResp);
			logger.info("订单：" + ord.get("orderId") + "调用财富端生成合同接口结束");
			// if (StringUtils.isNotEmptyAndNull(tfcfResp)) {
			// // 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
			// ResponseMsg tfcfResp1 = JSONObject.parseObject(tfcfResp,
			// ResponseMsg.class);
			// logger.info("订单：" + ord.get("orderId") + " 生成合同，财富端响应：" +
			// tfcfResp1);
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("订单：" + ord.get("orderId") + " 生成合同错误，", e);
		}
	}

	/*
	 * 订单操作服务
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateOrderInfo(NjLoanOrder order, String resourceUrl, NjOrderUpdateLog log) throws Exception {

		// 根据action从配置中获取订单流转状态
		Integer state = -1;

		// 根据订单编号获取订单
		NjLoanOrderMapper mapperSelect = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample exampleSelect = new NjLoanOrderExample();
		Criteria criteSelect = exampleSelect.createCriteria();
		if (StringUtils.isNotEmptyAndNull(order.getOrderNo())) {
			criteSelect.andOrderNoEqualTo(order.getOrderNo());
		}
		List<NjLoanOrder> orders = mapperSelect.selectByExample(exampleSelect);

		// 根据订单获取当前订单的状态
		List<NjOrderFlowProcedure> procedures = this.getOrderProcedures();
		for (NjOrderFlowProcedure procedure : procedures) {

			String t_resourceUrl = procedure.getResourceUrl();
			int status = Integer.valueOf(procedure.getCurrentState());
			int currentStatus = 0;

			if (orders.size() > 0) {
				NjLoanOrder dbOrder = orders.get(0);
				currentStatus = dbOrder.getStatus();
				order.setId(dbOrder.getId());
			}

			/*
			 * if(StringUtils.isNotEmptyAndNull(order.getId())){
			 * criteSelect.andIdEqualTo(order.getId()); }
			 */
			log.setOldStatus(currentStatus);
			log.setOrderId(order.getOrderNo());
			logger.debug("resourceUrl: " + resourceUrl + " t_resourceUrl:" + t_resourceUrl + " new status:" + status
					+ " currentStatus:" + currentStatus);
			if (StringUtils.isNotEmptyAndNull(resourceUrl) && StringUtils.isNotEmptyAndNull(t_resourceUrl)
					&& resourceUrl.contains(t_resourceUrl) && status == currentStatus) {
				state = Integer.valueOf(procedure.getProcessedId());
				log.setUpdateStatus(state);
				break;
			}
		}
		if (state == -1) {
			throw new Exception("无效的操作：" + resourceUrl);
		}
		// 更新order状态及信息
		order.setStatus(state);
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample example = new NjLoanOrderExample();
		Criteria crite = example.createCriteria();

		String orderNo = order.getOrderNo();
		if (StringUtils.isNotEmptyAndNull(orderNo)) {
			crite.andOrderNoEqualTo(orderNo);
		}
		order.setId(null);
		order.setUpdateDate(new Date());
		order.setCreateDate(null);
		order.setUpdateBy(order.getCreateBy());
		order.setCreateBy(null);
		mapper.updateByExampleSelective(order, example);

		// 创建订单修改日志
		log.setUpdateDate(new Date());
		try {
			log.setUserId(String.valueOf(UserSessions.get(Constants.USER_SESSION_KEY)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.setUserId("");
		}
		if (!StringUtils.isNotEmptyAndNull(log.getId())) {
			logger.debug("id:" + log.getId());
			log.setId(UuidUtil.get32UUID());
		}
		logger.debug("id:" + log.getId());
		NjOrderUpdateLogMapper updateMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
		updateMapper.insert(log);
	}

	/**
	 * 审核订单
	 * 
	 * @param handUserId
	 *            审批人
	 * @param taskinsid
	 *            当前要审核的任务实例Id
	 * @param transationValue
	 *            传入命令的值
	 * @param comment
	 *            审批意见
	 * @param updateReason
	 *            更新原因
	 */
	/*
	 * @Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	 * public void auditOrder(String handUserId, String taskinsid, String
	 * transationValue, String comment, String updateReason, String orderId)
	 * throws Exception {
	 * 
	 * if (StringUtils.isEmpty(orderId)) { throw new Exception("传入参数订单id为空"); }
	 * 
	 * // 根据订单id找到对应processform，生成processformextend ProcessFormMapper pfm =
	 * dao.getMapper(ProcessFormMapper.class); ProcessFormExample example = new
	 * ProcessFormExample();
	 * example.createCriteria().andEntityIdEqualTo(orderId).
	 * andEntityClassEqualTo("com.nj.model.generate.NjLoanOrder");
	 * List<ProcessForm> pfList = pfm.selectByExample(example); if
	 * (CollectionUtils.isEmpty(pfList)) { throw new Exception("订单id[" + orderId
	 * + "]没有对应的流程表单"); } ProcessForm pf = pfList.get(0);
	 * pf.setAuditComment(comment);
	 * 
	 * NjUserInfoMapper userinfomapper = dao.getMapper(NjUserInfoMapper.class);
	 * pf.setHandUserId(userinfomapper.selectByPrimaryKey(handUserId).
	 * getUserMobile()); // 以前存的电话好嘛，兼容之前的代码，需查询电话号码
	 * 
	 * pf.setExplainInfo(updateReason); pfm.updateByPrimaryKey(pf);
	 * 
	 * // 生成变量map Map<String, Object> varMap = new HashMap<String, Object>();
	 * varMap.put(ProcessConstant.ProcessVar.VAR_TRANSITION, transationValue);
	 * 
	 * NjLoanOrderMapper lom = dao.getMapper(NjLoanOrderMapper.class);
	 * NjLoanOrder lo = lom.selectByPrimaryKey(orderId);
	 * varMap.put(ProcessConstant.ProcessVar.VAR_LEND_AMOUNT,
	 * lo.getAuditAmount()); // 审批后的值
	 * varMap.put(ProcessConstant.ProcessVar.VAR_LEND_RATE,
	 * lo.getAuditRating()); // 审批后的值
	 * varMap.put(ProcessConstant.ProcessVar.VAR_LEND_TERM,
	 * lo.getAuditPeriod()); // 审批后的值
	 * 
	 * // 发起流程,流程发起后，在回调类里会自动更新订单状态和插入订单更新数据 Map<String, Object> auditResult =
	 * ProcessMgrUtil.process(pf, dao, comment, taskinsid, varMap); if
	 * (!auditResult.get(ProcessConstant.MsgCode.CODE).toString().equals(
	 * ProcessConstant.MsgCode.SUCCESS_CODE)) { throw new
	 * Exception(auditResult.get(ProcessConstant.MsgCode.MSG).toString()); } }
	 */

	public void updateOrderByOrderNo(NjLoanOrder order) throws Exception {
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample example = new NjLoanOrderExample();
		example.createCriteria().andOrderNoEqualTo(order.getOrderNo());
		mapper.updateByExample(order, example);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateOrderInfo(NjLoanOrder order, NjOrderUpdateLog log) throws Exception {
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		mapper.updateByPrimaryKey(order);

		NjOrderUpdateLogMapper updateMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
		updateMapper.insert(log);
	}

	/*
	 * 财富端退回订单
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void returnOrder(NjLoanOrder order, NjOrderUpdateLog log) throws Exception {
		// 更新order状态及信息
		order.setStatus(15);
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample example = new NjLoanOrderExample();
		Criteria crite = example.createCriteria();

		String orderNo = order.getOrderNo();
		if (StringUtils.isNotEmptyAndNull(orderNo)) {
			crite.andOrderNoEqualTo(orderNo);
		}
		order.setId(null);
		order.setUpdateDate(order.getCreateDate());
		order.setCreateDate(null);
		order.setUpdateBy(order.getCreateBy());
		order.setCreateBy(null);
		mapper.updateByExampleSelective(order, example);

		// 创建订单修改日志
		// 创建订单修改日志
		log.setOrderId(order.getOrderNo());
		log.setOldStatus(11);
		log.setUpdateStatus(15);
		log.setUpdateDate(new Date());
		log.setUpdateDate(new Date());
		try {
			log.setUserId(String.valueOf(UserSessions.get(Constants.USER_SESSION_KEY)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.setUserId("");
		}
		if (!StringUtils.isNotEmptyAndNull(log.getId())) {
			logger.debug("id:" + log.getId());
			log.setId(UuidUtil.get32UUID());
		}
		logger.debug("id:" + log.getId());
		NjOrderUpdateLogMapper updateMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
		updateMapper.insert(log);
	}

	public String getValue(String type, int orderStatus) throws Exception {
		String result = "已提交";
		List<NjOrderFlows> flows = this.getOrderFlows();
		for (NjOrderFlows flow : flows) {
			if (flow.getCurrentOrderState() == orderStatus) {
				if ("OF".equals(type)) {
					result = flow.getCurrentAppProcess();
					break;
				} else {
					result = flow.getCurrentOrderDisplayState();
					break;
				}
			}
		}

		return result;
	}

	public List<Map> getRepayObjs(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getNewRepayObjs(pd);
	}

	public List<Map> getPayerObjs(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getNewPayee(pd);
	}

	public Map getTradeConfig(String productId) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		PageData input = new PageData();
		input.put("productId", productId);
		List<Map> result = mapper.getTradeConfig(input);
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public Map<String, Object> getFaceIdImageUrls(NjLoanOrder order) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		if (order == null) {
			return result;
		}
		String faceIdImage = null;
		String headImage = null;
		String emblemImage = null;
		logger.debug("start to get faceidUrls");
		// 先从nj_order_cert中查身份证信息，如果查不到，则表示是老版本的订单，从nj_order_attachment中获取
		Map<String, Object> certImages = itfFaceIdService.getCertImageByOrder(order);
		// 获取活体照片
		List<String> huotiImages = itfFaceIdService.getHuotiImageByOrder(order);
		certImages.put("faceIdImage", huotiImages);
		/*
		 * NjUserAttachmentMapperExtend mapper =
		 * dao.getMapper(NjUserAttachmentMapperExtend.class); //获取faceIdImage
		 * faceIdImage = mapper.getFaceIdImageUrl(order.getId());
		 * if(!StringUtils.isEmpty(faceIdImage)){ //result.put("faceIdImage",
		 * Constants.URL.NJ_API+faceIdImage); result.put("faceIdImage",
		 * faceIdImage); } logger.debug("faceIdImage Url is :"+faceIdImage);
		 * //获取headImage if(!StringUtils.isEmpty(order.getUserId())){ headImage
		 * = mapper.getHeadImageUrl(order.getUserId()); emblemImage =
		 * mapper.getEmblemImageUrl(order.getUserId()); }
		 * if(!StringUtils.isEmpty(headImage)){ //result.put("headImage",
		 * Constants.URL.NJ_API+headImage); result.put("headImage", headImage);
		 * } if(!StringUtils.isEmpty(emblemImage)){ //result.put("emblemImage",
		 * Constants.URL.NJ_API+emblemImage); result.put("emblemImage",
		 * emblemImage); } logger.debug("emblemImage Url is :"+emblemImage);
		 * return result;
		 */
		return certImages;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserAttachment addImgsByAuditor(NjOrderUpdateAttachment attachRelation, NjUserAttachment attachment)
			throws Exception {
		// 保存图片关系
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		attachRelation.setAttachmentId(attachment.getId());
		mapper.insert(attachment);
		// 更新订单关系
		NjOrderUpdateAttachmentMapper mapper1 = dao.getMapper(NjOrderUpdateAttachmentMapper.class);
		mapper1.insert(attachRelation);

		return attachment;
	}

	/**
	 * 保存合同附件
	 * 
	 * @param attachment
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserAttachment addImgsByAuditor(NjUserAttachment attachment) throws Exception {
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		mapper.insert(attachment);
		return attachment;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void removeImgsByAuditor(NjOrderUpdateAttachment attachRelation) throws Exception {
		// 保存图片关系
		NjOrderUpdateAttachmentMapper mapper = dao.getMapper(NjOrderUpdateAttachmentMapper.class);
		NjOrderUpdateAttachmentExample example = new NjOrderUpdateAttachmentExample();
		example.createCriteria().andAttachmentIdEqualTo(attachRelation.getAttachmentId())
				.andOrderIdEqualTo(attachRelation.getOrderId());
		mapper.deleteByExample(example);

	}

	/*
	 * 获取后台审核系统的图片
	 */
	public List<Map> getOrderAuditImgs(String orderNo) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getAuditFiles(orderNo);

	}

	public Map<String, Object> getAdditionInfo(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> ret = new ArrayList<Map>();
		List<Map<String, Object>> results = mapper.getAddition(orderId);
		if (results == null)
			return null;
		for (Map<String, Object> item : results) {
			String additionId = (String) item.get("additionId");
			if (StringUtils.isEmpty(additionId))
				continue;
			List<Map> atts = mapper.getAdditionAttachment(additionId);
			ret.addAll(atts);
		}
		Map<String, Object> rets = new HashMap<String, Object>();
		rets.put("attachment", ret);
		return rets;
	}

	public Map<String, Object> getAdditionInfoForWeb(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map<String, Object>> atts = mapper.getAdditionAttachmentForWeb(orderId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("attachment", atts);
		return result;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void deleteUserAttr(String id, SysUpdateTableLog log) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		mapper.deleteUserAttr(id);

		SysUpdateTableLogMapper mp = dao.getMapper(SysUpdateTableLogMapper.class);
		mp.insert(log);

	}

	/**
	 * 
	 * @param userId
	 * @param showNumber
	 *            null:返回所有数据 数字：返回<=指定数量的数据
	 */
	@Transactional(readOnly = true)
	public List<NjUserSpot> getUserSpot(String userId, Integer showNumber) throws Exception {
		NjUserSpotMapper usMapper = dao.getMapper(NjUserSpotMapper.class);
		NjUserSpotExample example = new NjUserSpotExample();
		com.nj.model.generate.NjUserSpotExample.Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		example.setOrderByClause("create_date desc");
		List<NjUserSpot> result = usMapper.selectByExample(example);
		if (null == showNumber) {
			return result;
		} else if (showNumber >= result.size()) {
			return result;
		} else {
			return result.subList(0, showNumber);
		}
	}

	@Transactional(readOnly = true)
	public NjUserSpot getNewestUserSpot(String userId) throws Exception {
		NjUserSpotMapper usMapper = dao.getMapper(NjUserSpotMapper.class);
		NjUserSpotExample example = new NjUserSpotExample();
		com.nj.model.generate.NjUserSpotExample.Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		example.setOrderByClause("create_date desc");
		List<NjUserSpot> list = usMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional(readOnly = true)
	public Map getInfos(Map orderInfo) throws Exception {
		Map map = new HashMap();
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);

		List<Map> lt1 = mapper.getInfo1(orderInfo);
		map.put("info1", changeStr(lt1));

		List<Map> lt2 = mapper.getInfo2(orderInfo);
		map.put("info2", changeStr(lt2));

		// map.put("info1", mapper.getInfo1(orderInfo));
		// map.put("info2", mapper.getInfo2(orderInfo));
		map.put("info3", mapper.getInfo3(orderInfo));
		map.put("info4", mapper.getInfo4(orderInfo));
		map.put("info5", mapper.getInfo5(orderInfo));
		return map;
	}

	private String changeStr(List<Map> lt) {
		StringBuffer sb = new StringBuffer("");
		if (lt != null && lt.size() > 0) {
			for (Map mp : lt) {
				sb.append(mp.get("name") + ",");
			}
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public int updateOrder(NjLoanOrder loanorder) {
		try {
			NjLoanOrderMapper lom = dao.getMapper(NjLoanOrderMapper.class);
			return lom.updateByPrimaryKey(loanorder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 得到待发起流程的订单
	 */
	public List<Map<String, Object>> getToProcessLoanOrder(Integer status) {
		try {
			NjLoanOrderMapperExtend lome = dao.getMapper(NjLoanOrderMapperExtend.class);
			return lome.getToProcessLoanOrder(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void upOrderByOrderNO(NjLoanOrder order) throws Exception {
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		mapper.updateByPrimaryKeySelective(order);
	}

	/**
	 * 查询所有待生成项目的订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Map> getToCreateProjectOrders() throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> orders = mapper.getTfcfToCreateProjectOrders();
		for (Map ord : orders) {
			if (!StringUtils.isEmpty((String) ord.get("channelId"))) {
				NjProductChannelMapper pcm = dao.getMapper(NjProductChannelMapper.class);
				NjProductChannel pc = pcm.selectByPrimaryKey((String) ord.get("channelId"));
				ord.put("whereCode", pc == null ? "" : pc.getChannelCode());
			} else {
				ord.put("whereCode", "");
			}

			if (!StringUtils.isEmpty((String) ord.get("agentId"))) {
				NjChannelRelativeMapper crm = dao.getMapper(NjChannelRelativeMapper.class);
				NjChannelRelative cr = crm.selectByPrimaryKey((String) ord.get("agentId"));
				ord.put("brokerMobile", cr == null ? "" : cr.getChannelAcct());
			} else {
				ord.put("brokerMobile", "");
			}
		}
		return orders;
	}

	/**
	 * 查询所有待财富端生成在线合同的项目 查询条件： 线上放款：nj_loan_order表的relend_method:1或者2；
	 * 财富端生成合同：nj_product_transaction_online中的is_online_sign不为空，
	 * 并且contract_generation_type=1. 订单状态 ：7
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Map> getTfcfToCreateContractOrders() throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> orders = mapper.getTfcfToCreateContractOrders();
		for (Map ord : orders) {
			if (!StringUtils.isEmpty((String) ord.get("channelId"))) {
				NjProductChannelMapper pcm = dao.getMapper(NjProductChannelMapper.class);
				com.nj.model.generate.NjProductChannel pc = pcm.selectByPrimaryKey((String) ord.get("channelId"));
				ord.put("whereCode", pc == null ? "" : pc.getChannelCode());
			} else {
				ord.put("whereCode", "");
			}

			if (!StringUtils.isEmpty((String) ord.get("agentId"))) {
				NjChannelRelativeMapper crm = dao.getMapper(NjChannelRelativeMapper.class);
				NjChannelRelative cr = crm.selectByPrimaryKey((String) ord.get("agentId"));
				ord.put("brokerMobile", cr == null ? "" : cr.getChannelAcct());
			} else {
				ord.put("brokerMobile", "");
			}
		}
		return orders;
	}

	/**
	 * 查询订单的还款人列表
	 * 
	 * @param ordeId
	 * @return repayUserTfcfId:repayers在天府财富端的id
	 */
	public List<Map> getOrderRepayers(String orderId) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getOrderRepayUsers(orderId);
	}

	/**
	 * @param orderId
	 * @return receiptUserTfcfId:收款人在天府财富的id
	 * @throws Exception
	 */
	public List<Map> getOrderReceipts(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getOrderReceiptUsers(orderId);
	}

	/**
	 * 根据订单id获取还款账户对应的天赋财富userId
	 * 
	 * @param orderId
	 * @return
	 */
	public List<Map> getOrderRepaymentUsers(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getOrderRepaymentUsers(orderId);
	}

	/*
	 * 生成天府财富项目createTfcfProject
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void createTfcfProject(Map ord, String tokenName, String tokenId) {
		try {
			logger.info("调用财富端生成天府财富项目接口开始...");
			String tfcfResp = tfcfHttpService.doHttpPostForTfcf(tokenName, tokenId, ord,
					com.nj.core.base.common.Constants.TFCF.PROJECT_GENERATE_NEW);
			logger.info("响应结果: " + tfcfResp);
			if (tfcfResp != null) {
				JSONObject tfcfResp1 = JSONObject.parseObject(tfcfResp);
				if (tfcfResp1.getInteger("resultStatus") == 0) {
					logger.error("订单：" + ord.get("orderId") + " 资产推送成功，开始进行下一个流程...");
					NjProcessTemplateFlows corporeProcess = processMapperExtend.selectProcessTemplateByOrderProcess(
							(String) ord.get("orderId"), EProcessInfo.SEND_MARK.getId());
					manualProcess.execManualProcess((String) ord.get("orderId"), "SYSTEM", corporeProcess,
							EProcessResult.AGREE, "");
				}
			}
			logger.info("调用财富端生成天府财富项目结束。");
		} catch (Exception e) {
			logger.error("订单：" + ord.get("orderId") + " 资产推送错误，", e);
		}
	}

	/**
	 * 根据订单id查询订单的线下放款交易信息
	 * 
	 * @param orderId
	 * @return
	 */
	public NjProductTransactionOffline getOffTransaction(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.selectOffTrasanction(orderId);
	}

	public NjProductTransactionOnline getOnlTransaction(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.selectOnlTrasanction(orderId);
	}

	/**
	 * @param orderNo
	 * @return：返回订单审批人
	 */
	public String getOrderAuditor(String orderNo) {
		try {
			NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
			return mapper.selectOrderAuditorName(orderNo);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * @param orderNo
	 * @return 返回订单复核人
	 */
	public String getOrderRechecker(String orderNo) {
		try {
			NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
			return mapper.selectOrderRecheckerName(orderNo);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 获取所有的不需要生成合同并且需要在财富端生成项目的订单
	 * 
	 * @return
	 */
	/*
	 * public List<NjLoanOrder> getNoContractOrders(){ try{
	 * NjLoanOrderMapperExtend mapper
	 * =dao.getMapper(NjLoanOrderMapperExtend.class); return
	 * mapper.selectNoContractOrders(); } }
	 */

	/**
	 * 获取线下放款并且需要用户在线确认的订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<NjLoanOrder> getOfflineNeedSignCallbackOrders() throws Exception {
		try {
			NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
			return mapper.selectOfflineNeedSignCallbackOrders();
		} catch (Exception e) {
			logger.info("获取线下放款待回调的订单失败", e);
			throw e;
		}
	}

	/**
	 * 获取线下放款并且需要用户在线确认的订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<NjLoanOrder> getOfflineNoSignCallbackOrders() throws Exception {
		try {
			NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
			return mapper.selectOfflineNoSignCallbackOrders();
		} catch (Exception e) {
			logger.info("获取线下放款待回调的订单失败", e);
			throw e;
		}
	}

	/**
	 * 修改线下放款需要用户在线确认的订单
	 * 
	 * @param order
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void updateOfflineNeedSignOrder(NjLoanOrder order) throws Exception {
		String resourceUrl = "order/offlineNeedSignToConfirm";
		updateOrderInfo(order, resourceUrl, new NjOrderUpdateLog());
	}

	/**
	 * 修改线下放款无需用户确认的订单
	 * 
	 * @param order
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void updateOfflineNoSignOrder(NjLoanOrder order) throws Exception {
		String resourceUrl = "order/offlineNoSignToConfirm";
		updateOrderInfo(order, resourceUrl, new NjOrderUpdateLog());
	}

	/**
	 * 修改订单，获取订单在天府财富的项目id,根据产品获得订单项目id
	 * 
	 * @param order
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public NjLoanOrder updateOrderTfcfProjectNo(NjLoanOrder order) throws Exception {
		return order;
	}

	/**
	 * 检查订单是否需要在财富端生成合同
	 * 
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public boolean isNeedCreateTFCFContract(NjLoanOrder order) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		// 查看是否需要在财富端生成合同
		if (order.getStatus() != LoanOrderConstant.STATUS_7) {
			return false;
		} else {
			if (order.getRelendMethod().equals("1") || order.getRelendMethod().equals("2")) {
				Integer ret = mapper.getOrderOnlineSignTFCFContract(order.getOrderNo());
				if (new Integer(1).equals(ret)) {
					return true;
				} else {
					return false;
				}
			} else {
				Integer ret = mapper.getOrderOfflineSignTFCFContract(order.getOrderNo());
				if (new Integer(1).equals(ret)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	/**
	 * 获取在财富端生成合同时带传送的基本参数
	 * 
	 * @param order
	 * @return
	 */
	public Map<String, Object> getOrderContractBaseParams(NjLoanOrder order) throws Exception {
		// TODO Auto-generated method stub
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map<String, Object> params = mapper.getOrderContractBaseParams(order.getOrderNo());
		if (!StringUtils.isEmpty((String) params.get("channelId"))) {
			NjProductChannelMapper pcm = dao.getMapper(NjProductChannelMapper.class);
			com.nj.model.generate.NjProductChannel pc = pcm.selectByPrimaryKey((String) params.get("channelId"));
			params.put("whereCode", pc == null ? "" : pc.getChannelCode());
		} else {
			params.put("whereCode", "");
		}

		if (!StringUtils.isEmpty((String) params.get("agentId"))) {
			NjChannelRelativeMapper crm = dao.getMapper(NjChannelRelativeMapper.class);
			NjChannelRelative cr = crm.selectByPrimaryKey((String) params.get("agentId"));
			params.put("brokerMobile", cr == null ? "" : cr.getChannelAcct());
		} else {
			params.put("brokerMobile", "");
		}
		return params;
	}

	/**
	 * 只查询7天以内的审批结束的订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<NjLoanOrder> getAuditFinishedOrder(String coporateId) throws Exception {
		// TODO Auto-generated method stub
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, -3);
		Date yesterday = calendar.getTime();
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample exp = new NjLoanOrderExample();
		exp.createCriteria().andStatusEqualTo(LoanOrderConstant.STATUS_7).andDelFlagNotEqualTo(true)
				.andUpdateDateGreaterThan(yesterday).andCompanyIdEqualTo(coporateId);
		return mapper.selectByExample(exp);
	}

	/**
	 * 查询那些审批拒绝的订单，包括反欺诈未通过和审批拒绝,只查询一天以内的订单
	 * 
	 * @return
	 */
	public List<NjLoanOrder> getAuditDeniedOrder() throws Exception {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = calendar.getTime();
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample exp = new NjLoanOrderExample();
		List<Integer> statuses = Arrays.asList(2, 4);
		exp.createCriteria().andStatusIn(statuses).andDelFlagNotEqualTo(true).andUpdateDateGreaterThan(yesterday);
		return mapper.selectByExample(exp);
	}

	/**
	 * 检查订单是否要签名
	 * 
	 * @param order
	 * @return
	 */
	public boolean isNeedSign(NjLoanOrder order) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map<String, Object> ret = mapper.getSignParam(order.getOrderNo());
		// 普惠金融临时
		if (ret == null)
			return false;
		if (ret.isEmpty())
			throw new Exception("找不到交易结构");
		if (new Integer(1).equals((Integer) ret.get("onlineOrderSign"))
				|| new Integer(1).equals((Integer) ret.get("offlineOrderSign"))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 更新不在天府财富生成合同但需用户确认的订单
	 * 
	 * @param order
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void updateNeedSignNoTFCFContractOrder(NjLoanOrder order) throws Exception {
		// TODO Auto-generated method stub
		String resourceUrl = "order/offlineNeedSignToConfirm";
		NjLoanOrder i = new NjLoanOrder();
		i.setOrderNo(order.getOrderNo());
		i.setStatus(order.getStatus());
		updateOrderInfo(i, resourceUrl, new NjOrderUpdateLog());

	}

	/**
	 * 更新无需用户确认的订单
	 * 
	 * @param order
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void updateNoSignNoTFCFContractOrder(NjLoanOrder order) throws Exception {
		String resourceUrl = "order/offlineNoSignToConfirm";
		NjLoanOrder i = new NjLoanOrder();
		i.setOrderNo(order.getOrderNo());
		i.setStatus(order.getStatus());
		updateOrderInfo(i, resourceUrl, new NjOrderUpdateLog());
	}

	/**
	 * 获取募集资金成功的订单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<NjLoanOrder> getFinanceSuccessOrder() throws Exception {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = calendar.getTime();
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample exp = new NjLoanOrderExample();
		exp.createCriteria().andStatusEqualTo(LoanOrderConstant.STATUS_12).andDelFlagNotEqualTo(true)
				.andUpdateDateGreaterThan(yesterday);
		return mapper.selectByExample(exp);
	}

	public List<NjLoanOrder> getFinanceFailOrder() throws Exception {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = calendar.getTime();
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample exp = new NjLoanOrderExample();
		exp.createCriteria().andStatusEqualTo(LoanOrderConstant.STATUS_15).andDelFlagNotEqualTo(true)
				.andUpdateDateGreaterThan(yesterday);
		return mapper.selectByExample(exp);
	}

	public List<NjLoanOrder> getUserToConfirmOrder() throws Exception {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = calendar.getTime();
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample exp = new NjLoanOrderExample();
		exp.createCriteria().andStatusEqualTo(LoanOrderConstant.STATUS_8).andDelFlagNotEqualTo(true)
				.andUpdateDateGreaterThan(yesterday);
		return mapper.selectByExample(exp);
	}

	public List<NjLoanOrder> getUserConfirmedOrder(String coporateId) throws Exception {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_MONTH, -30);
		Date yesterday = calendar.getTime();
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample exp = new NjLoanOrderExample();
		exp.createCriteria().andStatusEqualTo(ELoanOrderStatus.BUILD_CORPORE.getValue()).andDelFlagNotEqualTo(true)
				.andUpdateDateGreaterThan(yesterday).andCompanyIdEqualTo(coporateId);
		return mapper.selectByExample(exp);
	}

	public boolean needCreateTFCFProject(NjLoanOrder order) {
		if ("1".equals(order.getRelendMethod())) {
			return true;
		} else {
			return false;
		}
	}

	public Map<String, Object> getOrderTfcfProjectBaseParams(NjLoanOrder order) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map<String, Object> params = mapper.getOrderTfcfProjectBaseParams(order.getOrderNo());
		if (null == params) {
			throw new Exception("未检索到" + order.getOrderNo() + "且状态为10的相关订单信息");
		}
		if (!StringUtils.isEmpty((String) params.get("channelId"))) {
			NjProductChannelMapper pcm = dao.getMapper(NjProductChannelMapper.class);
			com.nj.model.generate.NjProductChannel pc = pcm.selectByPrimaryKey((String) params.get("channelId"));
			params.put("whereCode", pc == null ? "" : pc.getChannelCode());
		} else {
			params.put("whereCode", "");
		}

		if (!StringUtils.isEmpty((String) params.get("agentId"))) {
			NjChannelRelativeMapper crm = dao.getMapper(NjChannelRelativeMapper.class);
			NjChannelRelative cr = crm.selectByPrimaryKey((String) params.get("agentId"));
			params.put("brokerMobile", cr == null ? "" : cr.getChannelAcct());
		} else {
			params.put("brokerMobile", "");
		}
		return params;
	}

	/**
	 * 查询订单的还款人列表
	 * 
	 * @param ordeId
	 * @return repayUserTfcfId:repayers在天府财富端的id
	 */
	public Map getOrderRepayers(String coporateId, String orderNo) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> list = mapper.getOrderRepayUser(coporateId, orderNo);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public Map getOrderApplyInfo(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map result = mapper.getOrderApplyInfo(pd);

		return result;
	}

	public List<Map> getCustomerManagerList() throws Exception {
		NjUserInfoMapperExtend mapper = dao.getMapper(NjUserInfoMapperExtend.class);
		return mapper.selectUserByRoleType(ERoleType.CUSTOMERMANAGER.getValue(), null);

	}

	public List<Map> getCustomerManageListByCoporateId(String CoporateId) throws Exception {
		NjUserInfoMapperExtend mapper = dao.getMapper(NjUserInfoMapperExtend.class);
		return mapper.selectUserByRoleType(ERoleType.CUSTOMERMANAGER.getValue(), CoporateId);
	}

	public String removeSameString(String str) {
		Set<String> mLinkedSet = new LinkedHashSet<String>();
		String[] strArray = str.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArray.length; i++) {
			if (!mLinkedSet.contains(strArray[i])) {
				mLinkedSet.add(strArray[i]);
				sb.append(strArray[i] + ",");
			}
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

	public List<Map> getAllLoanOrderList(PageData pd) throws Exception {
		String roleType = pd.getString("roleType");
		// 如果是代理商角色，只看自己渠道订单
		if (roleType.contains(ERoleType.AGENT.getValue())) {
			packageChannelOrderList(pd);
		}
		// 如果是客户经理，只看自己处理的订单
		if (roleType.contains(ERoleType.CUSTOMERMANAGER.getValue())) {
			pd.put("userInfoId", pd.getString("userId"));
		}
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> results = mapper.selectAllLoanOrdersListPage(pd);

		// 修改订单状态值
		for (Map map : results) {
			int status = Integer.valueOf(map.get("orderStatus").toString());
			ELoanOrderStatus eStatus = ELoanOrderStatus.getELoanOrderStatus(status);
			if (eStatus != null) {
				map.put("orderStatus", eStatus.getName());
			} else {
				map.put("orderStatus", "--");
			}

			String auditStr = String.valueOf(map.get("audit"));
			if (auditStr != null && !auditStr.equals("")) {

				map.put("audit", this.removeSameString(auditStr));
			}
		}

		return results;
	}

	/**
	 * 贷前订单列表
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Map> listPreLoanOrderList(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		String roleType = pd.getString("roleType");

		// 如果是代理商角色，只看自己渠道订单
		if (roleType.contains(ERoleType.AGENT.getValue())) {
			pd.put("manageRole", true);
			packageChannelOrderList(pd);
			List<Map> results = mapper.selectPreLoanOrdersListPage(pd);
			setOrderStatus(results);
			return results;
		} else {
			// 如果是领导角色，能看到所有贷前，贷中订单列表
			if (roleType.contains(ERoleType.RISKCONTROLMANAGER.getValue())
					|| roleType.contains(ERoleType.RISKDIRECTOR.getValue())
					|| roleType.contains(ERoleType.RISKDIRECTOR.getValue())
					|| roleType.contains(ERoleType.CADMIN.getValue())) {
				pd.put("manageRole", true);
			}
			List<Map> results = mapper.selectPreLoanOrdersListPage(pd);
			setOrderStatus(results);
			return results;
		}
	}

	/**
	 * 封装用户渠道列表
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	private void packageChannelOrderList(PageData pd) throws Exception {
		NjChannelUserMapper channelUserMapper = dao.getMapper(NjChannelUserMapper.class);
		NjChannelUserExample example = new NjChannelUserExample();
		example.createCriteria().andUserInfoIdEqualTo(pd.getString("userId"));
		List<NjChannelUser> channelUsers = channelUserMapper.selectByExample(example);
		List<String> channelIds = new ArrayList<>();
		for (NjChannelUser njChannelUser : channelUsers) {
			channelIds.add(njChannelUser.getChannelId());
		}
		if (channelIds.size() <= 0) {
			logger.error(pd.getString("userId") + "渠道商角色未关联渠道");
			channelIds.add("-1");
		}
		pd.put("channelIds", channelIds);
	}

	/**
	 * 贷后订单列表
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Map> selectAfterLoanOrdersListPage(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		String roleType = pd.getString("roleType");
		// 如果是代理商角色，只看自己渠道订单
		if (roleType.contains(ERoleType.AGENT.getValue())) {
			packageChannelOrderList(pd);
		}
		// 如果是客户经理，只看自己处理的订单
		if (roleType.contains(ERoleType.CUSTOMERMANAGER.getValue())) {
			pd.put("userInfoId", pd.getString("userId"));
		}
		List<Map> results = mapper.selectAfterLoanOrdersListPage(pd);
		setOrderStatus(results);
		return results;
	}

	@SuppressWarnings("unchecked")
	private void setOrderStatus(List<Map> orderList) {
		// 修改订单状态值
		for (Map map : orderList) {
			int status = Integer.valueOf(map.get("orderStatus").toString());
			ELoanOrderStatus eStatus = ELoanOrderStatus.getELoanOrderStatus(status);
			if (eStatus != null) {
				map.put("orderStatus", eStatus.getName());
			} else {
				map.put("orderStatus", "--");
			}
		}
	}

	/**
	 * 查询贷中订单
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Map> selectProcessLoanOrderList(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		String roleType = pd.getString("roleType");
		if (roleType.contains(ERoleType.RISKCONTROLMANAGER.getValue())
				|| roleType.contains(ERoleType.RISKDIRECTOR.getValue())
				|| roleType.contains(ERoleType.RISKDIRECTOR.getValue())
				|| roleType.contains(ERoleType.CADMIN.getValue())) {
			pd.put("manageRole", true);
		}
		List<Map> results = mapper.selectProcessLoanOrdersListPage(pd);
		return results;
	}

	public Map getProcessLoanOrderAmount(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		pd.put("start", pd.getInteger("start"));
		pd.put("length", pd.getInteger("length"));
		Map map = mapper.selectProcessLoanOrdersCount(pd);

		return map;
	}

	public Map getLoanOrderListNumAmount(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map result = mapper.selectLoanOrdersListNumAmount(pd);

		return result;
	}

	public List<Map> getDispatchOrderList(List<String> orderIds) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> result = mapper.selectDispatchOrderList(orderIds);

		return result;
	}

	public List<String> getProductIdsByOrderIds(List<String> orderIds) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<String> result = mapper.selectProductIdsByOrderIds(orderIds);

		return result;
	}

	/**
	 * 查询所有产品审核权限的审核人员
	 * 
	 * @param productIds
	 * @return
	 * @throws Exception
	 */
	public List<Map> selectDispatchUserList(List<String> productIds) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		PageData pd = new PageData();
		pd.put("productIds", productIds);
		List<Map> result = mapper.selectDispatchUserListByProductIdIds(pd);

		return result;
	}

	/**
	 * 查询所有产品审核权限的审核人员
	 * 
	 * @param productIds
	 * @return
	 * @throws Exception
	 */
	public List<Map> selectDispatchUserList(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> result = mapper.selectDispatchUserListByProductIdIds(pd);

		return result;
	}

	public Map<?, ?> getLoanOrderUserBaseInfo(String orderId) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);

		Map result = mapper.selectLoanOrderUserBaseInfo(orderId);
		if (result == null) {
			throw new Exception("订单信息出现问题,没有查询到订单对应的用户数据.");
		}

		String identifyId = String.valueOf(result.get("identity"));
		String bankAccount = String.valueOf(result.get("bankAccount"));

		// 通过身份证计算年龄和性别
		if (identifyId != null && !identifyId.equals("")) {
			int age = IdentifyUtil.getAge(identifyId);
			result.put("age", age);

			int sex = IdentifyUtil.getSex(identifyId);
			result.put("sex", sex);
		}

		// 通过银行卡号查询银行名称
		if (bankAccount != null && !bankAccount.equals("")) {
			NjBankInfo njBankInfo = userBankCardService.selectByNumber(bankAccount,
					com.nj.core.base.common.Constants.BANKCHANNELTYPE.WD);
			if (njBankInfo != null) {
				result.put("bankName", njBankInfo.getBankName());
			} else {
				String bankName = CardCheck.getNameOfBank(bankAccount);
				result.put("bankName", bankName);
			}

		}

		return result;
	}

	public Map<?, ?> getLoanOrderUserWorkInfo(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);

		Map<?, ?> result = mapper.getLoanOrderUserWorkInfo(pd);

		return result;
	}

	public NjUserCar getLoanOrderUserCarInfo(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);

		NjUserCar result = mapper.getLoanOrderUserCarInfo(pd);

		return result;
	}

	public List<Map> getHouseAttachmentList(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);

		List<Map> result = mapper.getHouseAttachmentList(pd);

		return result;
	}

	public List<Map> getCarAttachmentList(PageData pd) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);

		List<Map> result = mapper.getCarAttachmentList(pd);

		return result;
	}

	public List<NjUserContact> getUserContactList(PageData pd) throws Exception {

		NjUserContactMapper mapper = dao.getMapper(NjUserContactMapper.class);

		NjUserContactExample example = new NjUserContactExample();
		example.createCriteria().andUserIdEqualTo(getUserIdByOrderId(pd.getString("orderId")));
		List<NjUserContact> result = mapper.selectByExample(example);

		return result;
	}

	public Map<String, Object> getUserLoginLocation(String orderId) throws Exception {

		Map<String, Object> resultMap = new HashMap<>();
		NjUserSpotMapper mapper = dao.getMapper(NjUserSpotMapper.class);

		NjUserSpotExample example = new NjUserSpotExample();
		example.createCriteria().andUserIdEqualTo(getUserIdByOrderId(orderId));
		example.setOrderByClause("create_date desc");
		List<NjUserSpot> result = mapper.selectByExample(example);
		if (result != null && result.size() > 0) {
			resultMap.put("longitude", result.get(0).getLongitude());
			resultMap.put("latitude", result.get(0).getLatitude());
			resultMap.put("createDate", result.get(0).getCreateDate());
		}

		return resultMap;
	}

	public Map getUserLoanHistory(PageData pd) throws Exception {

		Map resultMap = new HashMap<>();
		NjUserSpotMapper mapper = dao.getMapper(NjUserSpotMapper.class);

		NjUserSpotExample example = new NjUserSpotExample();
		example.createCriteria().andUserIdEqualTo(getUserIdByOrderId(pd.getString("orderId")));
		List<NjUserSpot> result = mapper.selectByExample(example);
		if (result != null && result.size() > 0) {
			resultMap.put("longitude", result.get(0).getLongitude());
			resultMap.put("latitude", result.get(0).getLatitude());
			resultMap.put("createDate", result.get(0).getCreateDate());
		}

		return resultMap;
	}

	public String getUserIdByOrderId(String orderId) throws Exception {
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder njLoanOrder = mapper.selectByPrimaryKey(orderId);
		return njLoanOrder.getUserId();
	}

	/**
	 * 更新订单基本信息
	 * 
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void updateOrderBasicInfo(PageData pd, NjUserInfo njUserInfo) throws Exception {

		// 订单ID
		String orderId = pd.get("orderId").toString();
		NjLoanOrderMapper njLoanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder njLoanOrder = njLoanOrderMapper.selectByPrimaryKey(orderId);
		String sysUserId = njUserInfo.getId();

		// 申请信息
		saveOrderApplyInfo(pd);
		// 用户基本信息
		saveLoanOrderUserBaseInfo(pd);
		// 用户工作信息
		saveLoanOrderUserWorkInfo(pd, orderId, njLoanOrder.getUserId());
		// 配偶信息
		if (pd.containsKey("spouseInfo")) {
			NjUserRelatives spouseRelative = JSON.parseObject(pd.getString("spouseInfo"), NjUserRelatives.class);
			saveSpouseRelatives(spouseRelative, orderId, njLoanOrder.getUserId());
		}
		// 用户联系人信息
		List<NjUserRelatives> urList = JSON.parseArray(pd.getString("relativesInfo"), NjUserRelatives.class);
		if (urList != null) {
			saveUserRelatives(urList, orderId, njLoanOrder.getUserId());
		}
		// 抵押物
		if (pd.containsKey("pawnInfo")) {
			List<NjOrderPawnHouse> njOrderPawnHouseList = JSON.parseArray(pd.getString("pawnInfo"),
					NjOrderPawnHouse.class);
			for (NjOrderPawnHouse njOrderPawnHouse : njOrderPawnHouseList) {
				savePawnHouse(njOrderPawnHouse, orderId, njLoanOrder.getUserId(), sysUserId);
			}
		}

		// 车辆信息
		if (pd.containsKey("userCar")) {
			NjUserCar userCar = JSON.parseObject(pd.getString("userCar"), NjUserCar.class);
			if (userCar != null) {
				saveLoanOrderUserCarInfo(userCar, orderId, njLoanOrder.getId());
			}
		}
		// 房产信息
		if (pd.containsKey("houseInfo")) {
			List<NjUserHouse> njUserHouseList = JSON.parseArray(pd.getString("houseInfo"), NjUserHouse.class);
			for (NjUserHouse njUserHouse : njUserHouseList) {
				saveHouseInfo(njUserHouse, orderId, njLoanOrder.getId(), sysUserId);
			}
		}
		// 负债信息
		String debtInfo = pd.getString("debtInfo");
		if (debtInfo != null && !debtInfo.equals("")) {
			List<NjUserDebtInfo> listDebt = JSON.parseArray(debtInfo, NjUserDebtInfo.class);
			if (listDebt != null) {
				saveDebtInfo(listDebt, orderId, njLoanOrder.getUserId());
			}
		}
	}

	/**
	 * 保存或者修改业务调查
	 * 
	 * @param pd
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public Map<String, Object> saveBusinessSurvey(PageData pd, NjUserInfo njUserInfo) throws Exception {

		Map<String, Object> map = new HashMap<>();
		// 订单ID
		String orderId = pd.getString("orderId");
		NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder njLoanOrder = orderMapper.selectByPrimaryKey(orderId);

		// 保存抵押物
		NjOrderPawnHouse njOrderPawnHouse = null;
		if (pd.containsKey("pawnInfo")) {
			njOrderPawnHouse = JSON.parseObject(pd.getString("pawnInfo"), NjOrderPawnHouse.class);
			if (!StringUtils.isEmpty(njOrderPawnHouse.getId())) {
				map.put("pawnId", njOrderPawnHouse.getId());
			}
			savePawnHouse(njOrderPawnHouse, orderId, njLoanOrder.getUserId(), njUserInfo.getId());
		} else {
			map.put("pawnId", "");
		}

		// 保存业务调查
		NjUserBusinessSurveyMapper businessMapper = dao.getMapper(NjUserBusinessSurveyMapper.class);
		NjUserBusinessSurveyExample businessExample = new NjUserBusinessSurveyExample();
		String surveyId = "";
		if (pd.containsKey("businessSurveyInfo")) {
			NjUserBusinessSurvey njUserBusinessSurvey = JSON.parseObject(pd.getString("businessSurveyInfo"),
					NjUserBusinessSurvey.class);
			if (StringUtils.isEmpty(njUserBusinessSurvey.getId())) {

				// 查询该订单是否已经存在业务调查订单
				businessExample.createCriteria().andOrderIdEqualTo(orderId);
				List<NjUserBusinessSurvey> listBusiness = businessMapper.selectByExample(businessExample);
				if (listBusiness.size() > 0) {
					throw new ExistException("新增业务调查失败，该订单已经存在业务调查信息");
				}

				// 新增
				surveyId = UuidUtil.get32UUID();
				njUserBusinessSurvey.setId(surveyId);
				njUserBusinessSurvey.setCreateBy(njUserInfo.getUserMobile());
				njUserBusinessSurvey.setCreateTime(new Date());
				njUserBusinessSurvey.setIsDel(false);
				njUserBusinessSurvey.setOrderId(orderId);
				njUserBusinessSurvey.setBusinessNo(RandomUtil.getOrderSn());
				njUserBusinessSurvey.setUpdateBy(njUserInfo.getUserMobile());
				njUserBusinessSurvey.setUpdateTime(new Date());
				njUserBusinessSurvey.setUserId(njLoanOrder.getUserId());
				njUserBusinessSurvey.setPawnId(njOrderPawnHouse.getId());
				businessMapper.insert(njUserBusinessSurvey);
			} else {
				// 修改
				surveyId = njUserBusinessSurvey.getId();
				njUserBusinessSurvey.setIsDel(false);
				njUserBusinessSurvey.setOrderId(orderId);
				njUserBusinessSurvey.setUpdateBy(njUserInfo.getUserMobile());
				njUserBusinessSurvey.setUpdateTime(new Date());
				njUserBusinessSurvey.setUserId(njLoanOrder.getUserId());
				njUserBusinessSurvey.setPawnId(njOrderPawnHouse.getId());
				businessMapper.updateByPrimaryKeySelective(njUserBusinessSurvey);
			}
			map.put("businessNo", njUserBusinessSurvey.getBusinessNo());
			map.put("createTime", DateTimeHelper.formatDateTimetoString(njUserBusinessSurvey.getCreateTime(),
					DateTimeHelper.FMT_yyyyMMdd));
		}
		map.put("surveyId", surveyId);

		return map;
	}

	/**
	 * 保存或者修改业务审批信息
	 * 
	 * @param pd
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void saveBusinessApproval(PageData pd, NjUserInfo njUserInfo) throws Exception {

		// 订单ID
		String orderId = pd.getString("orderId");
		NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder njLoanOrder = orderMapper.selectByPrimaryKey(orderId);

		// 保存业务审批
		NjUserBusinessApprovalMapper businessMapper = dao.getMapper(NjUserBusinessApprovalMapper.class);

		String businessApprovalInfo = JSON.toJSONString(pd.getMap());
		NjUserBusinessApproval njUserBusinessApproval = JSON.parseObject(businessApprovalInfo,
				NjUserBusinessApproval.class);
		if (StringUtils.isEmpty(njUserBusinessApproval.getId())) {
			// 新增
			njUserBusinessApproval.setId(UuidUtil.get32UUID());
			njUserBusinessApproval.setCreateBy(njUserInfo.getUserMobile());
			njUserBusinessApproval.setCreateTime(new Date());
			njUserBusinessApproval.setIsDel(false);
			njUserBusinessApproval.setOrderId(orderId);
			njUserBusinessApproval.setUpdateBy(njUserInfo.getUserMobile());
			njUserBusinessApproval.setUpdateTime(new Date());
			njUserBusinessApproval.setUserId(njLoanOrder.getUserId());
			businessMapper.insert(njUserBusinessApproval);
		} else {
			// 修改
			njUserBusinessApproval.setIsDel(false);
			njUserBusinessApproval.setOrderId(orderId);
			njUserBusinessApproval.setUpdateBy(njUserInfo.getUserMobile());
			njUserBusinessApproval.setUpdateTime(new Date());
			njUserBusinessApproval.setUserId(njLoanOrder.getUserId());
			businessMapper.updateByPrimaryKeySelective(njUserBusinessApproval);
		}

	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	private void saveOrderApplyInfo(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		mapper.saveOrderApplyInfo(pd);
	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	private void saveLoanOrderUserBaseInfo(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		mapper.saveLoanOrderUserBaseInfo(pd);
	}

	/**
	 * 保存/修改工作信息
	 * 
	 * @param pd
	 * @param orderId
	 * @param userId
	 * @throws Exception
	 * 
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	private void saveLoanOrderUserWorkInfo(PageData pd, String orderId, String userId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		String workId = pd.getString("workId");
		if (StringUtils.isEmpty(workId)) {
			NjUserWorkInfoMapper userWorkInfoMapper = dao.getMapper(NjUserWorkInfoMapper.class);
			NjOrderWorkMapper orderWorkMapper = dao.getMapper(NjOrderWorkMapper.class);

			Map map = pd.getMap();
			String json = JSON.toJSONString(map);
			NjUserWorkInfo njUserWorkInfo = JSON.parseObject(json, NjUserWorkInfo.class);
			njUserWorkInfo.setId(UuidUtil.get32UUID());
			njUserWorkInfo.setCreateDate(new Date());
			njUserWorkInfo.setUserId(userId);
			njUserWorkInfo.setVersion(1);
			userWorkInfoMapper.insert(njUserWorkInfo);

			NjOrderWork njOrderWork = new NjOrderWork();
			njOrderWork.setId(UuidUtil.get32UUID());
			njOrderWork.setOrderId(orderId);
			njOrderWork.setWorkId(njUserWorkInfo.getId());
			orderWorkMapper.insert(njOrderWork);

		} else {
			mapper.saveLoanOrderUserWorkInfo(pd);
		}

	}

	/**
	 * 保存/修改车辆信息
	 * 
	 * @param userCar
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void saveLoanOrderUserCarInfo(NjUserCar userCar, String orderId, String userId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		NjUserCarMapper userCarMapper = dao.getMapper(NjUserCarMapper.class);
		NjOrderUserCarMapper orderUserCarMapper = dao.getMapper(NjOrderUserCarMapper.class);
		if (StringUtils.isEmpty(userCar.getId())) {

			// 保存车辆信息
			userCar.setCreateDate(new Date());
			userCar.setDelFlag(false);
			userCar.setId(UuidUtil.get32UUID());
			userCar.setUserId(userId);
			userCar.setVersion(1);
			userCarMapper.insert(userCar);

			// 保存车辆关系
			NjOrderUserCar orderUserCar = new NjOrderUserCar();
			orderUserCar.setId(UuidUtil.get32UUID());
			orderUserCar.setOrderId(orderId);
			orderUserCar.setUserCarId(userCar.getId());
			orderUserCarMapper.insert(orderUserCar);

		} else {
			// 修改车辆信息
			mapper.saveLoanOrderUserCarInfo(userCar);
		}

	}

	/**
	 * 保存/修改联系人信息
	 * 
	 * @param urList
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	private void saveUserRelatives(List<NjUserRelatives> urList, String orderId, String userId) throws Exception {
		NjAppUserRelativesMapperExtend mapper = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		NjUserRelativesMapper userRelativeMapper = dao.getMapper(NjUserRelativesMapper.class);
		NjOrderRelativeMapper orderRelativeMapper = dao.getMapper(NjOrderRelativeMapper.class);
		for (NjUserRelatives ur : urList) {
			if (StringUtils.isEmpty(ur.getId())) {
				// 保存联系
				ur.setId(UuidUtil.get32UUID());
				ur.setCreateDate(new Date());
				ur.setDelFlag(new Byte("0"));
				ur.setVersion(1);
				ur.setUserId(userId);
				userRelativeMapper.insert(ur);

				// 添加联系人关系
				NjOrderRelative orderRelative = new NjOrderRelative();
				orderRelative.setId(UuidUtil.get32UUID());
				orderRelative.setOrderId(orderId);
				orderRelative.setRelativeId(ur.getId());
				orderRelativeMapper.insert(orderRelative);

			} else {
				mapper.updateUserRelativeById(ur);
			}
		}
	}

	/**
	 * 保存/修改配偶信息
	 * 
	 * @param spouse
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	private void saveSpouseRelatives(NjUserRelatives spouse, String orderId, String userId) throws Exception {
		NjAppUserRelativesMapperExtend mapper = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		if (StringUtils.isEmpty(spouse.getId())) {
			// 新增配偶信息
			NjUserRelativesMapper userRelativeMapper = dao.getMapper(NjUserRelativesMapper.class);
			NjOrderRelativeMapper orderRelativeMapper = dao.getMapper(NjOrderRelativeMapper.class);
			spouse.setId(UuidUtil.get32UUID());
			spouse.setCreateDate(new Date());
			spouse.setDelFlag(new Byte("0"));
			spouse.setVersion(1);
			spouse.setUserId(userId);
			userRelativeMapper.insert(spouse);

			// 添加配偶关系
			NjOrderRelative orderRelative = new NjOrderRelative();
			orderRelative.setId(UuidUtil.get32UUID());
			orderRelative.setOrderId(orderId);
			orderRelative.setRelativeId(spouse.getId());
			orderRelativeMapper.insert(orderRelative);

		} else {
			// 修改配偶信息
			mapper.updateUserRelativeById(spouse);
		}
	}

	/**
	 * 保存 /修改抵押物信息
	 * 
	 * @param njOrderPawnHouse
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	private void savePawnHouse(NjOrderPawnHouse njOrderPawnHouse, String orderId, String userId, String sysUserId)
			throws ParamsException, ExistException, Exception {
		NjAppUserRelativesMapperExtend mapper = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		NjOrderPawnHouseMapper orderPawnHouseMapper = dao.getMapper(NjOrderPawnHouseMapper.class);
		NjOrderPawnHouseLinkMapper orderPawnHouseLinkMapper = dao.getMapper(NjOrderPawnHouseLinkMapper.class);
		NjOrderPawnHouseLinkExample orderPawnHouseLinkExample = new NjOrderPawnHouseLinkExample();

		// 判断评估网站，如果填写了名称，就必须传图片（图片是附件表的ID）
		// 网站1
		if (!StringUtils.isEmpty(njOrderPawnHouse.getWebOneName())
				&& StringUtils.isEmpty(njOrderPawnHouse.getPicFileOne())) {
			throw new ParamsException("网站：" + njOrderPawnHouse.getWebOneName() + "的上传图片不能为空");
		}
		// 网站2
		if (!StringUtils.isEmpty(njOrderPawnHouse.getWebTwoName())
				&& StringUtils.isEmpty(njOrderPawnHouse.getPicFileTwo())) {
			throw new ParamsException("网站：" + njOrderPawnHouse.getWebOneName() + "的上传图片不能为空");
		}
		// 网站3
		if (!StringUtils.isEmpty(njOrderPawnHouse.getWebThreeName())
				&& StringUtils.isEmpty(njOrderPawnHouse.getPicFileThree())) {
			throw new ParamsException("网站：" + njOrderPawnHouse.getWebOneName() + "的上传图片不能为空");
		}
		// 评估公司
		if (!StringUtils.isEmpty(njOrderPawnHouse.getCompanyName())
				&& StringUtils.isEmpty(njOrderPawnHouse.getPicFileFour())) {
			throw new ParamsException("评估公司：" + njOrderPawnHouse.getWebOneName() + "的上传图片不能为空");
		}

		if (StringUtils.isEmpty(njOrderPawnHouse.getId())) {

			// 判断该订单是否已经有了抵押物，如果有则不能新增
			orderPawnHouseLinkExample.createCriteria().andOrderIdEqualTo(orderId);
			List<NjOrderPawnHouseLink> listlink = orderPawnHouseLinkMapper.selectByExample(orderPawnHouseLinkExample);
			if (listlink.size() > 0) {
				throw new ExistException("新增抵押物失败，该订单已经存在抵押物信息");
			}

			// 新增抵押物
			njOrderPawnHouse.setId(UuidUtil.get32UUID());
			njOrderPawnHouse.setCreateTime(new Date());
			njOrderPawnHouse.setIsDel(false);
			njOrderPawnHouse.setOrderId(orderId);
			njOrderPawnHouse.setUserId(userId);
			njOrderPawnHouse.setUpdateTime(new Date());
			njOrderPawnHouse.setVersion(1);
			njOrderPawnHouse.setCreateBy(sysUserId);
			njOrderPawnHouse.setUpdateBy(sysUserId);
			orderPawnHouseMapper.insert(njOrderPawnHouse);

			// 新增抵押物联系
			NjOrderPawnHouseLink orderPawnHouseLink = new NjOrderPawnHouseLink();
			orderPawnHouseLink.setId(UuidUtil.get32UUID());
			orderPawnHouseLink.setOrderId(orderId);
			orderPawnHouseLink.setPawnId(njOrderPawnHouse.getId());
			orderPawnHouseLinkMapper.insert(orderPawnHouseLink);

		} else {
			// 修改抵押物
			mapper.updatePawnHouse(njOrderPawnHouse);
		}
	}

	public void updatePawnInfoPic(NjOrderPawnHouse njOrderPawnHouse) throws Exception {
		NjAppUserRelativesMapperExtend mapper = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		mapper.updatePawnHouse(njOrderPawnHouse);
	}

	/**
	 * 保存/修改房产信息
	 * 
	 * @param njUserHouse
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	private void saveHouseInfo(NjUserHouse njUserHouse, String orderId, String userId, String sysUserId)
			throws Exception {
		NjAppUserRelativesMapperExtend mapper = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		NjUserHouseMapper userHouseMapper = dao.getMapper(NjUserHouseMapper.class);
		NjOrderHouseMapper orderHouseMapper = dao.getMapper(NjOrderHouseMapper.class);
		if (StringUtils.isEmpty(njUserHouse.getId())) {

			// 保存房产信息
			njUserHouse.setCreateDate(new Date());
			njUserHouse.setDelFlag(false);
			njUserHouse.setId(UuidUtil.get32UUID());
			njUserHouse.setUpdateDate(new Date());
			njUserHouse.setUserId(userId);
			njUserHouse.setVersion(1);
			njUserHouse.setCreateBy(sysUserId);
			njUserHouse.setUpdateBy(sysUserId);
			userHouseMapper.insert(njUserHouse);

			// 添加房产关系
			NjOrderHouse njOrderHouse = new NjOrderHouse();
			njOrderHouse.setHouseId(njUserHouse.getId());
			njOrderHouse.setId(UuidUtil.get32UUID());
			njOrderHouse.setOrderId(orderId);
			orderHouseMapper.insert(njOrderHouse);

		} else {
			// 修改房产信息
			mapper.updateHouseInfo(njUserHouse);
		}
	}

	/**
	 * 保存/修改负债信息
	 * 
	 * @param list
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	private void saveDebtInfo(List<NjUserDebtInfo> list, String orderId, String userId) throws Exception {
		NjAppUserRelativesMapperExtend mapper = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		NjUserDebtInfoMapper debtMapper = dao.getMapper(NjUserDebtInfoMapper.class);
		NjOrderDebtMapper orderDebtMapper = dao.getMapper(NjOrderDebtMapper.class);
		for (NjUserDebtInfo njUserDebtInfo : list) {
			if (StringUtils.isEmpty(njUserDebtInfo.getId())) {
				// 保存负债信息
				njUserDebtInfo.setDelFlag(false);
				njUserDebtInfo.setId(UuidUtil.get32UUID());
				njUserDebtInfo.setVersion(1);
				njUserDebtInfo.setUserId(userId);
				debtMapper.insert(njUserDebtInfo);

				// 添加关系
				NjOrderDebt orderDebt = new NjOrderDebt();
				orderDebt.setId(UuidUtil.get32UUID());
				orderDebt.setDebtId(njUserDebtInfo.getId());
				orderDebt.setOrderId(orderId);
				orderDebtMapper.insert(orderDebt);

			} else {
				// 修改负债信息
				mapper.updateDebtInfo(njUserDebtInfo);
			}
		}
	}

	/*
	 * 获取订单各信息人工核查备注信息
	 */
	public Map<?, ?> getLoanOrderInfoRemark(String orderId, String dataType) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();

		NjLoanOrderCheckRecordMapper mapper = dao.getMapper(NjLoanOrderCheckRecordMapper.class);

		NjLoanOrderCheckRecordExample exp = new NjLoanOrderCheckRecordExample();
		exp.createCriteria().andOrderIdEqualTo(orderId).andDataTypeEqualTo(Byte.valueOf(dataType));
		List<NjLoanOrderCheckRecord> result = mapper.selectByExample(exp);
		if (result != null && result.size() > 0) {
			resultMap.put("abnormal", result.get(0).getAbnormal());
			resultMap.put("remark", result.get(0).getRemark());
		} else {
			resultMap.put("abnormal", null);
			resultMap.put("remark", null);
		}

		return resultMap;
	}

	// 获取审批表记录
	public NjOrderUpdateLog getNjOrderUpdateLog(PageData pd) throws Exception {
		NjOrderUpdateLogMapper mapper = dao.getMapper(NjOrderUpdateLogMapper.class);

		NjOrderUpdateLogExample exp = new NjOrderUpdateLogExample();
		exp.createCriteria().andOrderIdEqualTo(pd.getString("orderId"));
		List<NjOrderUpdateLog> result = mapper.selectByExample(exp);

		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	// 获取审批信息
	public Map<String, String> getOrderAuditInfo(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.selectAuditInfo(orderId);
	}
	
	/**
	 * 获取订单指定processId的审批日志,按创建时间倒序排
	 */
	public List<NjOrderUpdateLog> getNjOrderUpdateLog(String orderNo,List<Integer> processIdList) throws Exception {
		
		NjOrderUpdateLogMapper mapper = dao.getMapper(NjOrderUpdateLogMapper.class);
		NjOrderUpdateLogExample exp = new NjOrderUpdateLogExample();
		com.nj.model.generate.NjOrderUpdateLogExample.Criteria c = exp.createCriteria();
		c.andOrderIdEqualTo(orderNo).andProcessIdIn(processIdList);
		
		exp.setOrderByClause("update_date desc");
		List<NjOrderUpdateLog> result = mapper.selectByExample(exp);
		return result;
	}
	
	/**
	 * 查询订单操作日志
	 * 
	 * @param orderSn
	 * @return
	 * @throws Exception
	 */
	public List<OrderUpdateLogVO> listLoanOrderOperateLog(String orderNo) throws Exception {
		List<OrderUpdateLogVO> list = orderUpdateLogMapperExtend.selectLogByOrderNo(orderNo);
		return list;
	}

	/**
	 * 查询人工审核日志
	 * 
	 * @param orderSn
	 * @return
	 */
	public List<OrderUpdateLogVO> listOrderAudite(String orderNo) {
		List<Integer> auditeStatusList = Arrays.asList(5, 51, 7);
		List<OrderUpdateLogVO> logList = orderUpdateLogMapperExtend.selectOrderLogByStatus(orderNo, auditeStatusList);
		List<OrderUpdateLogVO> newLogList = new ArrayList<OrderUpdateLogVO>();
		Map<Integer, OrderUpdateLogVO> logMap = new HashMap<Integer, OrderUpdateLogVO>();
		for (OrderUpdateLogVO updateVo : logList) {
			if (!logMap.containsKey(updateVo.getUpdateStatus())) {
				logMap.put(updateVo.getUpdateStatus(), updateVo);
				newLogList.add(updateVo);
			}
		}
		return newLogList;
	}

	public Map generateUserOrderInfo(Map data, Map check) {
		Map resultMap = new HashMap<>();
		resultMap.put("data", data);
		resultMap.put("check", check);

		return resultMap;
	}

	public Map generateUserOrderInfo(List<Map> data, Map check) {
		Map resultMap = new HashMap<>();
		resultMap.put("data", data);
		resultMap.put("check", check);

		return resultMap;
	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void addHouseAttachment(PageData pd) throws Exception {

		NjUserAttachment njUserAttachment = new NjUserAttachment();
		njUserAttachment.setId(UuidUtil.get32UUID());
		njUserAttachment.setDelFlag(false);
		njUserAttachment.setCreateDate(new Date());
		njUserAttachment.setSource(pd.getString("url"));
		njUserAttachment.setBusinessType(com.nj.core.base.common.Constants.FILE_TYPE.HOUSE);
		addUserAttachment(njUserAttachment);

		// 绑定id
		/*
		 * NjHouseAttachmentMapper attcarMapper =
		 * dao.getMapper(NjHouseAttachmentMapper.class); NjHouseAttachment
		 * houseAtt = new NjHouseAttachment();
		 * houseAtt.setId(UuidUtil.get32UUID());
		 * houseAtt.setAttachmentId(att.getId()); houseAtt.setHouseId(houseId);
		 * attcarMapper.insert(houseAtt);
		 * 
		 * 
		 * 
		 * NjHouseAttachment njHouseAttachment = new NjHouseAttachment(); String
		 * houseAttachmentId = UuidUtil.get32UUID();
		 * njHouseAttachment.setId(houseAttachmentId);
		 * 
		 * 
		 * njHouseAttachment.setHouseId(houseId);
		 * njHouseAttachment.setAttachmentId(attachmentId);
		 * addHouseAttachment(njHouseAttachment);
		 * 
		 * 
		 * NjOrderHouse njOrderHouse = new NjOrderHouse(); String orderHouseId =
		 * UuidUtil.get32UUID(); njOrderHouse.setId(orderHouseId);
		 * njOrderHouse.setOrderId(String.valueOf(pd.get("orderId")));
		 * njOrderHouse.setHouseId(String.valueOf(pd.get("houseId")));
		 * addOrderHouse(njOrderHouse);
		 */

	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void addOrderHouse(NjOrderHouse njOrderHouse) throws Exception {
		NjOrderHouseMapper mapper = dao.getMapper(NjOrderHouseMapper.class);

		mapper.insert(njOrderHouse);
	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void addHouseAttachment(NjHouseAttachment njHouseAttachment) throws Exception {
		NjHouseAttachmentMapper mapper = dao.getMapper(NjHouseAttachmentMapper.class);

		mapper.insert(njHouseAttachment);
	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void addUserAttachment(NjUserAttachment njUserAttachment) throws Exception {
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);

		mapper.insert(njUserAttachment);
	}

	public List<Map<String, Object>> productGradeSummary(String companyId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.orderProductGradeSummaryInfo(ELoanOrderStatus.USER_CONFIRM.getValue(),
				ELoanOrderStatus.BUILD_CORPORE.getValue(), ELoanOrderStatus.FUNDRAISING_SUCCESS.getValue(),
				ELoanOrderStatus.MAKE_LOANS.getValue(), companyId);
	}

	public List<Map<?, ?>> listProductGrade(String keyword, String coporateId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.listProductGrade(keyword, coporateId);
	}

	/**
	 * 生成标的物
	 * 
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void buildCorpore() throws Exception {
		long filterStart = System.currentTimeMillis();

		long summaryStart = System.currentTimeMillis();

		NjLoanOrderMapperExtend orderMapperExtend = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map<String, Object>> infos = orderMapperExtend
				.orderGradeSummaryInfo(ELoanOrderStatus.USER_CONFIRM.getValue());

		logger.debug("Summary Info:{}", infos);
		logger.debug("Summary time:{}", (System.currentTimeMillis() - summaryStart));

		NjAssetGradeMapper assetGradeMapper = dao.getMapper(NjAssetGradeMapper.class);
		List<NjAssetGrade> grades = assetGradeMapper.selectByExample(null);
		Map<String, Integer> gradeMap = grades.stream()
				.collect(Collectors.toMap(NjAssetGrade::getGrade, NjAssetGrade::getScreenRate));

		for (Map<String, Object> info : infos) {
			String grade = info.get("grade").toString();
			Long totalCount = Long.valueOf(info.get("totalCount").toString());
			long toplimit = ((BigDecimal) info.get("totalAmount"))
					.multiply(BigDecimal.valueOf(gradeMap.getOrDefault(grade, 0) / 100D)).longValue();
			if (toplimit <= 0) {
				continue;
			}
			SizeFilterContext context = new SizeFilterContext(filterService, grade, toplimit, totalCount);

			long size = context.getBestSize();

			logger.debug("grade:{}--toplimit:{}--totalCount:{}--size:{}", grade, toplimit, totalCount, size);

			orderUpdateLogMapperExtend.batchInsertByOrderInfo(size, grade, ELoanOrderStatus.BUILD_CORPORE.getValue(),
					ELoanOrderStatus.USER_CONFIRM.getValue());

			orderMapperExtend.batchUpdateByGrade(size, grade, ELoanOrderStatus.BUILD_CORPORE.getValue(),
					ELoanOrderStatus.USER_CONFIRM.getValue());
		}
		logger.debug("total filter time:{}", (System.currentTimeMillis() - filterStart));
	}

	/**
	 * 发标明细
	 * 
	 * @param keyword
	 *            产品名称或订单编号
	 * @return
	 * @throws Exception
	 */
	public List<Map<?, ?>> listBuildCorporeDetails(String keyword, String status) throws Exception {
		NjLoanOrderMapperExtend orderMapperExtend = dao.getMapper(NjLoanOrderMapperExtend.class);
		Stream<Integer> statusStream = Stream.of(ELoanOrderStatus.USER_CONFIRM.getValue(),
				ELoanOrderStatus.BUILD_CORPORE.getValue(), ELoanOrderStatus.FUNDRAISING_SUCCESS.getValue(),
				ELoanOrderStatus.MAKE_LOANS.getValue());
		return orderMapperExtend.listBuildCorporeDetails(ELoanOrderStatus.USER_CONFIRM.getValue(),
				ELoanOrderStatus.BUILD_CORPORE.getValue(), statusStream.collect(Collectors.toList()), keyword, status);
	}

	/**
	 * 验证是否满足发标条件： 待发标库总金额低于xx元，启动资产筛选规则
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean isSatisfyAutoBuildCorporeDemand() throws Exception {

		SysDictMapper dictMapper = dao.getMapper(SysDictMapper.class);
		SysDictExample example = new SysDictExample();
		example.createCriteria().andTypeEqualTo(ESysDictType.BUILD_CORPORE_LIMIT.getValue()).andDelFlagEqualTo(false);
		List<SysDict> list = dictMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return false;
		}
		SysDict dict = list.get(0);

		NjLoanOrderMapperExtend orderMapperExtend = dao.getMapper(NjLoanOrderMapperExtend.class);
		Long fundraisingSuccessAmount = orderMapperExtend
				.sumFundraisingSuccessAmount(ELoanOrderStatus.FUNDRAISING_SUCCESS.getValue());
		if (fundraisingSuccessAmount != null && fundraisingSuccessAmount < Long.parseLong(dict.getValue())) {
			return true;
		}
		return false;
	}

	public synchronized boolean autoBuildCorpore() throws Exception {
		if (this.isSatisfyAutoBuildCorporeDemand()) {
			this.buildCorpore();
			return true;
		}
		return false;
	}

	/**
	 * 获取下单用户上传资料信息
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectAttachmentListByOrderId(String orderId, Integer businessType,
			String parentIds) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map<String, Object>> result = mapper.selectAttachmentListByOrderId(orderId, businessType, parentIds);
		return result;
	}
	
	/**
	 * 获取订单指定keyword的附件
	 * @param keywords 多个keyword用,分割
	 */
	public List<Map<String, Object>> getOrderAttListByKeyword(String orderId,String fileTags) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map<String, Object>> result = mapper.getOrderAttListByFiletag(orderId, fileTags);
		return result;
	}

	public Map<String, String> selectOrderRefuceReson(String orderId) throws Exception {
		NjLoanOrderMapper loanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder loanOrder = loanOrderMapper.selectByPrimaryKey(orderId);
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.selectOrderRefuceReson(loanOrder.getOrderNo());
	}

	public List<Map> selectProcessCountByOrderId(List<String> orderList) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.selectProcessCountByOrderId(orderList);
	}

	public Integer selectMqApiListCount() throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		return extend.selectMqApiListCount();
	}

	public List<String> selectMqApiList(Map<String, Object> map) throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		return extend.selectMqApiList(map);
	}

	/**
	 * 得到贷后还款信息。 用于贷后还款信息页面的还款信息展示
	 */
	public Map<String, Object> getLoanAfterRepayInfo(String orderNo) throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		return extend.getLoanAfterRepayInfo(orderNo);
	}

	/**
	 * 用户在订单申请表签字确认
	 */
	public void orderRequestFormSign(String tokenName, String userId, String orderNo, String srcFilePath,
			String dstPdfFile, String sealData, String headImg) throws Exception {

		SignPDFFileBean pdfFile = new SignPDFFileBean();
		pdfFile.setSrcPdfFile(srcFilePath);
		pdfFile.setDstPdfFile(dstPdfFile);

		PosBean signPos = new PosBean();
		signPos.setPosType(1); // 定位类型，0-坐标定位，1-关键字定位，默认0
		signPos.setKey("甲方（借款人）："); // 关键字 TODO 做成产品或批复订单里配置
		// signPos.setPosX(200 + (160 * signedSecondPartyNum));
		signPos.setPosPage("1");

		userSignService.userPdfSign_file(orderNo, userId, EsignFileCateConstant.ORDER_APPLY_FORM, sealData, pdfFile,
				signPos, SignType.Key);

		saveFormSignHeadImg(headImg);
	}

	private void saveFormSignHeadImg(String headImg) {
		if (StringUtils.isNotEmpty(headImg)) {
			String imgPathDir = ""; // TODO 保存路径
			File dirFile = new File(imgPathDir);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			String imgPath = imgPathDir + new Date().getTime() + ".jpg";
			ImageAnd64Binary.generateImage(headImg, imgPath);
		}
	}

	/**
	 * 根据用户id和角色类型获取订单列表
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Map> getMyLoanOrderList(PageData pd) throws Exception {
		String roleType = pd.getString("roleType");
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		// 如果是风控经理，则根据角色类型和分单信息获取我的订单
		if (roleType.contains(ERoleType.RISKCONTROLMANAGER.getValue())) {
			// 风控经理能看到的订单状态
			StringBuilder statusStr = new StringBuilder();
			statusStr.append(ELoanOrderStatus.FIRST_CHECK_SUCCESS.getValue() + ",");
			statusStr.append(ELoanOrderStatus.REVIEW_CHECK_SUCCESS.getValue() + ",");
			statusStr.append(ELoanOrderStatus.DECISION_ENGINE.getValue() + ",");
			statusStr.append(ELoanOrderStatus.SECOND_CHECK_LENDING.getValue());
			pd.put("statusList", statusStr.toString());
			return mapper.selectMyOrderByChannelUserIdAndRoleType(pd);
			// 如果是风控专员
		} else if (roleType.contains(ERoleType.RISKCONTROLCOMMISSIONER.getValue())) {
			pd.put("processStatus", ELoanOrderStatus.SHUNT.getValue());
			return mapper.selectMyOrderInOrderFlow(pd);
			// 如果是客户经理，则根据用户绑定客户经理获取其订单列表
		} else if (roleType.contains(ERoleType.CUSTOMERMANAGER.getValue())) {
			// 客户经理能看到的订单状态
			StringBuilder statusStr = new StringBuilder();
			statusStr.append(ELoanOrderStatus.BUSINESS_SHUNT.getValue() + ",");
			statusStr.append(ELoanOrderStatus.LAST_CHECK_SUCCESS.getValue() + ",");
			statusStr.append(ELoanOrderStatus.CONTRACT_CHECK_SUCCESS.getValue());
			pd.put("statusList", statusStr.toString());
			return mapper.selectMyOrderInOrderFlow(pd);
			// 如果是法务，只根据订单生成合同状态获取列表
		} else if (roleType.contains(ERoleType.LEGALAFFAIRS.getValue())) {
			pd.put("processStatus", ELoanOrderStatus.CREATE_CONTRACT.getValue());
			return mapper.selectMyOrderByStatus(pd);
			// 如果是放款专员，根据订单放款复审状态获取列表
		} else if (roleType.contains(ERoleType.LENDINGPERSON.getValue())) {
			pd.put("processStatus", ELoanOrderStatus.FIRST_CHECK_LENDING.getValue());
			return mapper.selectMyOrderByStatus(pd);
			// 如果是财务，根据订单放款终审通过状态获取列表
		} else if (roleType.contains(ERoleType.FINANCEPERSON.getValue())) {
			pd.put("processStatus", ELoanOrderStatus.FIFTH_CHECK_LENDING.getValue());
			return mapper.selectMyOrderByStatus(pd);
			// 如果是财务经理，根据订单财务复核状态获取列表
		} else if (roleType.contains(ERoleType.FINANCEMANAGER.getValue())) {
			StringBuilder statusStr = new StringBuilder();
			statusStr.append(ELoanOrderStatus.SIXTH_CHECK_LENDING.getValue() + ",");
			statusStr.append(ELoanOrderStatus.SEVENTH_CHECK_LENDING.getValue());
			pd.put("statusList", statusStr.toString());
			return mapper.selectMyOrderByStatus(pd);
			// 如果是风控总监
		} else if (roleType.contains(ERoleType.RISKDIRECTOR.getValue())) {
			StringBuilder statusStr = new StringBuilder();
			statusStr.append(ELoanOrderStatus.MANAGER_REVIEW_CHECK_SUCCESS.getValue() + ",");
			statusStr.append(ELoanOrderStatus.DIRECTOR_REVIEW_CHECK_SUCCESS.getValue() + ",");
			statusStr.append(ELoanOrderStatus.FOURTH_CHECK_LENDING.getValue() + ",");
			statusStr.append(ELoanOrderStatus.THIRD_CHECK_LENDING.getValue());
			pd.put("statusList", statusStr.toString());
			return mapper.selectMyOrderInOrderFlow(pd);
			// 如果是董事长
		} else if (roleType.contains(ERoleType.CHAIRMAN.getValue())) {
			StringBuilder statusStr = new StringBuilder();
			statusStr.append(ELoanOrderStatus.DIRECTOR_REVIEW_CHECK_SUCCESS.getValue() + ",");
			statusStr.append(ELoanOrderStatus.FOURTH_CHECK_LENDING.getValue());
			pd.put("statusList", statusStr.toString());
			return mapper.selectMyOrderInOrderFlow(pd);
			// 如果是业务经理
		} else if (roleType.contains(ERoleType.BUSINESSMANAGER.getValue())) {
			StringBuilder statusStr = new StringBuilder();
			statusStr.append(ELoanOrderStatus.BUSINESS_SURVEY_SUCCESS.getValue() + ",");
			statusStr.append(ELoanOrderStatus.START_LENDING.getValue());
			pd.put("statusList", statusStr.toString());
			return mapper.selectMyOrderInOrderFlow(pd);
		} else {
			logger.error("当前用户尚未分配角色");
			throw new BaseException("当前用户尚未分配角色");
		}

	}

	private List<Map> getOrderListByRole(PageData pd) {
		return null;
	}

	public long selectAllLoanOrdersCount(PageData pd) throws Exception {
		String roleType = pd.getString("roleType");
		// 如果是代理商角色，只看自己渠道订单
		if (roleType.contains(ERoleType.AGENT.getValue())) {
			packageChannelOrderList(pd);
		}
		// 如果是客户经理，只看自己处理的订单
		if (roleType.contains(ERoleType.CUSTOMERMANAGER.getValue())) {
			pd.put("userInfoId", pd.getString("userId"));
		}
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.selectAllLoanOrdersCount(pd);
	}

	/**
	 * 获取风控专员分单用户列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Map> selectSendOrderRiskUsersList(PageData pd) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.selectSendOrderRiskUsersList(pd);
	}

	/**
	 * 还款情况页面获取订单数据
	 */
	public Map getOrderForRepaySituationPage(String orderNo) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map result = mapper.getOrderForRepaySituationPage(orderNo);
		return result;
	}

	/**
	 * 查询订单日志
	 * 
	 * @param orderId
	 *            订单ID
	 * @param processId
	 * @return
	 * @throws Exception
	 */
	public NjOrderUpdateLog getOrderUpdateLog(String orderId, int processId) throws Exception {
		NjOrderUpdateLogMapper mapper = dao.getMapper(NjOrderUpdateLogMapper.class);
		NjOrderUpdateLogExample example = new NjOrderUpdateLogExample();
		example.createCriteria().andProcessIdEqualTo(processId).andOrderIdEqualTo(orderId);
		example.setOrderByClause("update_date desc");
		List<NjOrderUpdateLog> listOrderUpdateLog = mapper.selectByExample(example);
		if (!org.springframework.util.CollectionUtils.isEmpty(listOrderUpdateLog)) {
			return listOrderUpdateLog.get(0);
		}
		return null;
	}

	/**
	 * 根据订单ID查询订单日志，并对ProcessId进行分组，且查询处每个分组中最新的信息
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Map> getOrderUpdateLogAllForProcessId(String orderId) throws Exception {

		NjOrderProcessMapperExtend mapper = dao.getMapper(NjOrderProcessMapperExtend.class);
		return mapper.getOrderUpdateLogAllForProcessId(orderId);
	}

	/**
	 * 获取产品贷款期数列表
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SysDict> getByProductId(String id) throws Exception {
		// 获取产品贷款期数列表
		NjProductCycleMapperExtend cycleMapperExtend = dao.getMapper(NjProductCycleMapperExtend.class);
		List<SysDict> cycles = cycleMapperExtend.getByProductId(id);
		return cycles;
	}

	/**
	 * 获得订单驳回列表
	 * 
	 * @param orderId
	 * @param processId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getProcessOrderFlows(String orderId, String processId) throws Exception {

		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		NjProductTempMapperExtend tempMapper = dao.getMapper(NjProductTempMapperExtend.class);
		NjProductTemp njProductTemp = tempMapper.selectProductTempByOrderId(orderId);
		return mapper.getProcessOrderFlows(orderId, processId, njProductTemp.getProcessTemplateId());
	}

	/**
	 * 订单区域统计
	 * 
	 * @throws Exception
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void saveOrderAreaCount() throws Exception {

		NjOrderAreaMapperExtend mapperExtend = dao.getMapper(NjOrderAreaMapperExtend.class);
		NjOrderAreaMapper mapper = dao.getMapper(NjOrderAreaMapper.class);
		NjOrderAreaExample example = new NjOrderAreaExample();

		// 删除所有
		mapperExtend.deleteAll();

		// 查询区域统计
		List<Map> listMap = mapperExtend.getOrderAreaCount();

		// 保存
		Date currentDate = new Date();
		for (Map map : listMap) {
			NjOrderArea njOrderArea = new NjOrderArea();
			njOrderArea.setAmount(Integer.parseInt(map.get("num").toString()));
			njOrderArea.setCode(map.get("provinceCode").toString());
			njOrderArea.setCreateTime(currentDate);
			njOrderArea.setId(UuidUtil.get32UUID());
			njOrderArea.setName(map.get("provinceName").toString());
			njOrderArea.setAuditamt(new BigDecimal(map.get("auditAmt").toString()));
			njOrderArea.setParentCode("0");
			njOrderArea.setType("1");
			mapper.insert(njOrderArea);
		}
	}

	/**
	 * 通过用户ID查询贷款累计金额
	 * 
	 * @param id
	 * @return
	 */
	public int getOrderAmountByUserId(String id) {

		return 0;
	}

	/**
	 * 获取订单初审、复审、终审人员（微鼎金融）
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectOrderAuditUserList(String orderId) throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		return extend.selectOrderAuditUserList(orderId);
	}

	/**
	 * 概要统计
	 * 
	 * @throws Exception
	 */
	public void summaryStatisticsCount() throws Exception {
		// 构建放款区间数组 auditAmountRange[i][0] <=auditAmount <auditAmountRange[i][1]
		BigDecimal[][] auditAmountRange = new BigDecimal[5][2];
		// 50万以下
		auditAmountRange[0][0] = new BigDecimal(0);
		auditAmountRange[0][1] = new BigDecimal(500000);
		// 50万到100W
		auditAmountRange[1][0] = new BigDecimal(500000);
		auditAmountRange[1][1] = new BigDecimal(1000000);
		// 100W到150W
		auditAmountRange[2][0] = new BigDecimal(1000000);
		auditAmountRange[2][1] = new BigDecimal(1500000);
		// 150wD到200W
		auditAmountRange[3][0] = new BigDecimal(1500000);
		auditAmountRange[3][1] = new BigDecimal(2000000);
		// 200W以上
		auditAmountRange[4][0] = new BigDecimal(2000000);
		auditAmountRange[4][1] = null;

		// 分页数目
		long showCount = 10000;
		// 获取到所有分公司编号
		NjCoporateExample example = new NjCoporateExample();
		example.createCriteria().andDelFlagEqualTo(false);
		List<NjCoporate> coporateList = njCoporateMapper.selectByExample(example);
		Map<String, NjCoporate> coporateListMap = new HashMap();
		Iterator<NjCoporate> iterator = coporateList.iterator();
		while (iterator.hasNext()) {
			NjCoporate njCoporate = iterator.next();
			coporateListMap.put(njCoporate.getId(), njCoporate);
		}

		// 先不考虑数据量，一次性从数据库获取结果
		List statusList = new ArrayList();
		statusList.add(ELoanOrderStatus.MAKE_LOANS.getValue());
		statusList.add(ELoanOrderStatus.REPAYMENT.getValue());

		Map<String, NjStatisticsSummary> insertMap = new HashMap<String, NjStatisticsSummary>();
		for (int i = 0; i < auditAmountRange.length; i++) {
			BigDecimal minAmount = auditAmountRange[i][0];
			BigDecimal maxAmount = auditAmountRange[i][1];
			Map<String, Object> querymap = new HashMap<String, Object>();
			querymap.put("statusList", statusList);
			querymap.put("minAmount", minAmount);
			querymap.put("maxAmount", maxAmount);
			List<Map<String, Object>> amountList = njLoanOrderMapperExtend.getSumAuditAmountForCompany(querymap);
			for (Map<String, Object> map : amountList) {

				// 公司编号
				String companyId = String.valueOf(map.get("companyId"));
				// 放款总额
				String loanAmount = String.valueOf(map.get("totalAmount"));
				// 订单笔数
				String loanNum = String.valueOf(map.get("loanNum"));
				if (!coporateListMap.containsKey(companyId)) {
					continue;
				}
				if (StringUtils.isEmpty(loanNum)) {
					loanNum = "0";
				}
				NjStatisticsSummary sumary = null;
				BigDecimal loanAmountTotal = new BigDecimal(0);
				int loanNumTotal = 0;
				if (insertMap.containsKey(companyId)) {
					sumary = insertMap.get(companyId);
					loanAmountTotal = sumary.getLoanAmount().add(new BigDecimal(loanAmount));
					loanNumTotal = Integer.parseInt(sumary.getLoanNum()) + Integer.parseInt(loanNum);

				} else {
					sumary = new NjStatisticsSummary();
					sumary.setId(UUID.randomUUID().toString());
					sumary.setCompanId(companyId);
					sumary.setFirstAmountRangeCount("0");
					sumary.setFirstAmountRangeSum(new BigDecimal("0"));
					sumary.setSecondAmountRangeCount("0");
					sumary.setSecondAmountRangeSum(new BigDecimal("0"));
					sumary.setThirdAmountRangeCount("0");
					sumary.setThirdAmountRangeSum(new BigDecimal("0"));
					sumary.setFourthAmountRangeCount("0");
					sumary.setFourthAmountRangeSum(new BigDecimal("0"));
					sumary.setFifthAmountRangeCount("0");
					sumary.setFifthAmountRangeSum(new BigDecimal("0"));
					loanAmountTotal = new BigDecimal(loanAmount);
					loanNumTotal = Integer.parseInt(loanNum);
				}

				// 给每个区间赋值
				switch (i) {
				case 0:
					sumary.setFirstAmountRangeCount(loanNum);
					sumary.setFirstAmountRangeSum(new BigDecimal(loanAmount));
					break;
				case 1:
					sumary.setSecondAmountRangeCount(loanNum);
					sumary.setSecondAmountRangeSum(new BigDecimal(loanAmount));
					break;
				case 2:
					sumary.setThirdAmountRangeCount(loanNum);
					sumary.setThirdAmountRangeSum(new BigDecimal(loanAmount));
					break;
				case 3:
					sumary.setFourthAmountRangeCount(loanNum);
					sumary.setFourthAmountRangeSum(new BigDecimal(loanAmount));
					break;
				case 4:
					sumary.setFifthAmountRangeCount(loanNum);
					sumary.setFifthAmountRangeSum(new BigDecimal(loanAmount));
					break;

				default:
					break;
				}

				sumary.setLoanAmount(loanAmountTotal);
				sumary.setLoanNum(String.valueOf(loanNumTotal));
				insertMap.put(companyId, sumary);
			}

		}

		Map<String, Object> querymap = new HashMap<String, Object>();
		querymap.put("statusList", statusList);

		List<Map<String, Object>> userCountList = njLoanOrderMapperExtend.getUserCountForCompany(querymap);
		for (Map<String, Object> map : userCountList) {
			// 公司编号
			String companyId = String.valueOf(map.get("companyId"));
			// 总共放款人数
			String loanUserCount = String.valueOf(map.get("loanUserCount"));

			NjStatisticsSummary sumary = null;
			if (insertMap.containsKey(companyId)) {
				sumary = insertMap.get(companyId);
			} else {
				String msg = "概要统计：companyId为=" + companyId + "的数据未初始化";
				logger.error(msg);
				continue;
			}
			sumary.setLoanUserCount(loanUserCount);
			insertMap.put(companyId, sumary);
		}

		// 考虑到企业表中存在企业;但是订单表中无此企业订单数据，为了保证数据的完整性必须修复数据
		Set<Entry<String, NjCoporate>> entrySet = coporateListMap.entrySet();

		for (Entry<String, NjCoporate> entry : entrySet) {
			String key = entry.getKey();
			NjCoporate value = entry.getValue();
			NjStatisticsSummary sumary = null;
			if (!insertMap.containsKey(key)) {
				sumary = new NjStatisticsSummary();
				sumary.setId(UUID.randomUUID().toString());
				sumary.setLoanAmount(new BigDecimal(0));
				sumary.setLoanNum("0");
				sumary.setLoanUserCount("0");
				sumary.setFirstAmountRangeCount("0");
				sumary.setFirstAmountRangeSum(new BigDecimal("0"));
				sumary.setSecondAmountRangeCount("0");
				sumary.setSecondAmountRangeSum(new BigDecimal("0"));
				sumary.setThirdAmountRangeCount("0");
				sumary.setThirdAmountRangeSum(new BigDecimal("0"));
				sumary.setFourthAmountRangeCount("0");
				sumary.setFourthAmountRangeSum(new BigDecimal("0"));
				sumary.setFifthAmountRangeCount("0");
				sumary.setFifthAmountRangeSum(new BigDecimal("0"));
			} else {
				sumary = insertMap.get(key);
			}
			sumary.setCompanCode(value.getCompanCode());
			sumary.setCompanId(value.getId());
			sumary.setCompanName(value.getCompanName());
			sumary.setDueDate(LocalDate.now().toString());
			sumary.setOverdueAmount(new BigDecimal(0));
			insertMap.put(key, sumary);

		}

		// 插入到数据库
		List<NjStatisticsSummary> list = new ArrayList<NjStatisticsSummary>(insertMap.values());
		njStatisticsSummaryMapperExtend.insertBath(list);
	}

	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void saveOrderArchiveRecord(PageData pd) throws Exception {

		NjOrderArchiveRecordMapper mapper = dao.getMapper(NjOrderArchiveRecordMapper.class);
		String id = pd.getString("id");
		NjOrderArchiveRecord record = new NjOrderArchiveRecord();
		record.setCarInvoice(pd.getInteger("carInvoice"));
		record.setCarWarranty(pd.getInteger("carWarranty"));
		record.setCertificate(pd.getInteger("certificate"));
		record.setCreateTime(new Date());
		record.setGpsPhoto(pd.getInteger("gpsPhoto"));
		record.setOrderId(pd.getString("orderId"));
		if (StringUtils.isEmpty(id)) {
			record.setId(UuidUtil.get32UUID());
			mapper.insertSelective(record);
		} else {
			record.setId(pd.getString("id"));
			mapper.updateByPrimaryKeySelective(record);
		}
		NjLoanOrder loanOrder = new NjLoanOrder();
		loanOrder.setId(pd.getString("orderId"));
		loanOrder.setIsArchive(pd.getInteger("isArchive"));
		NjLoanOrderMapper.updateByPrimaryKeySelective(loanOrder);
	}

	public NjOrderArchiveRecord getOrderArchiveRecord(PageData pd) throws Exception {
		NjOrderArchiveRecordMapper mapper = dao.getMapper(NjOrderArchiveRecordMapper.class);
		NjOrderArchiveRecordExample example = new NjOrderArchiveRecordExample();
		example.createCriteria().andOrderIdEqualTo(pd.getString("orderId"));
		List<NjOrderArchiveRecord> archiveRecords = mapper.selectByExample(example);
		if (archiveRecords != null && archiveRecords.size() > 0) {
			return archiveRecords.get(0);
		} else {
			return null;
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void deleteOrderAttach(PageData pd) throws Exception {
		String orderId = pd.getString("orderId");
		String attachIds = pd.getString("attachIds");
		NjOrderAttachmentMapper attachmentMapper = dao.getMapper(NjOrderAttachmentMapper.class);
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjOrderAttachmentExample example = new NjOrderAttachmentExample();
		for (String attachId : attachIds.split(",")) {
			example.createCriteria().andOrderIdEqualTo(pd.getString("orderId")).andAttachIdEqualTo(attachId);
			fileOperationService.deleteFile(attachId);
			mapper.deleteByPrimaryKey(attachId);
			attachmentMapper.deleteByExample(example);
		}
	}

	public List<Map<String, Object>> getOrderRepayUserList(String productId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getOrderRepayUserList(productId);

	}

	public List<Map<String, Object>> getChannelRateList(String channelId, String productId) throws Exception {
		NjProductChannelMapperExtend mapper = dao.getMapper(NjProductChannelMapperExtend.class);
		return mapper.selectByChannelId(channelId, productId);
	}

	/**
	 * 获取在贷款中的订单
	 */
	public List<NjLoanOrder> getLoaningOrderByUserid(String userId) throws Exception {
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample example = new NjLoanOrderExample();
		example.createCriteria().andUserIdEqualTo(userId).andDelFlagEqualTo(false)
				.andStatusLessThan(ELoanOrderStatus.REPAYMENT.getValue());
		return mapper.selectByExample(example);
	}

	/**
	 * 根据channelI获取代偿用户资金端userId
	 * 
	 * @param channelId
	 * @return
	 * @throws Exception
	 */
	public String getRepayUserIdByChannelId(String channelId) throws Exception {
		NjProductChannelMapperExtend mapper = dao.getMapper(NjProductChannelMapperExtend.class);
		return mapper.getRepayUserIdByChannelId(channelId);
	}

	/**
	 * 保存扣款通知
	 * 
	 * @param notice
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insertDeductionNotice(NjDeductionNotice notice) throws Exception {

		NjDeductionNoticeMapper mapper = dao.getMapper(NjDeductionNoticeMapper.class);
		mapper.insert(notice);
	}

	/**
	 * 查询当天进件数量
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<String> getTodayIncomeCount(String productId, Date date) throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		return extend.getTodayIncomeCount(productId, date);
	}

	/**
	 * 线下还款
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public ResponseDto offlineRepay(OfflineRepayBean offlineRepayBean) throws Exception {
		ResponseDto result = new ResponseDto();

		// 1.从应扣记录表根据订单编号和期数获取应扣记录
		NjWithdrawingRecordMapperExtend wrMapperEx = dao.getMapper(NjWithdrawingRecordMapperExtend.class);
		NjWithdrawingRecord wRecord = wrMapperEx.getRecordByOrderNoAndPeriod(offlineRepayBean.getOrderNo(),
				offlineRepayBean.getPeriod());

		// 2.若正在自动扣款中，则给出提示
		if (null != wRecord) {
			if (wRecord.getStatus() == 1 || wRecord.getStatus() == 2) { // 1:开始扣款
																		// 2:扣款中
				result.setReturnCode(-1);
				result.setReturnMsg("正在自动扣款中，不能线下还款");
				return result;
			}
		}

		// 3.更新还款计划,失败马上返回
		UpdatePlanDto rpDto = new UpdatePlanDto();
		rpDto.setOrderNo(offlineRepayBean.getOrderNo());
		rpDto.setPeriod(offlineRepayBean.getPeriod());
		rpDto.setAccRepayDate(offlineRepayBean.getAccRepayDate());
		rpDto.setDeductObj(UpdatePlanDto.MANUAL);
		rpDto.setDeductionResult("扣款成功");
		rpDto.setRepayStatus(offlineRepayBean.getRepayStatus());
		rpDto.setFeeInfoList(offlineRepayBean.getRpFeeInfoList());
		ResponseDto<Boolean> rpRd = repayPlanNewService.updateRepayPlan(rpDto);
		if (rpRd.getReturnCode() != 0) {
			result.setReturnCode(-1);
			result.setReturnMsg("更新还款计划失败");
			return result;
		}

		// 4.更新回款计划，失败最后返回，返回之前要清空应扣记录表数据
		UpdatePlanDto mbDto = new UpdatePlanDto();
		mbDto.setOrderNo(offlineRepayBean.getOrderNo());
		mbDto.setPeriod(offlineRepayBean.getPeriod());
		mbDto.setAccRepayDate(offlineRepayBean.getAccRepayDate());
		mbDto.setDeductObj(UpdatePlanDto.MANUAL);
		mbDto.setDeductionResult("扣款成功");
		mbDto.setRepayStatus(offlineRepayBean.getRepayStatus());
		mbDto.setFeeInfoList(offlineRepayBean.getMbFeeInfoList());
		ResponseDto<Boolean> mbRd = repayPlanNewService.updateMoneyBackPlan(mbDto);
		if (mbRd.getReturnCode() != 0) {
			result.setReturnCode(-1);
			result.setReturnMsg("更新回款计划失败");
		}

		// 5.清空应扣记录表
		if (null != wRecord) {
			NjWithdrawingRecordMapper wrMapper = dao.getMapper(NjWithdrawingRecordMapper.class);
			wrMapper.deleteByPrimaryKey(wRecord.getId());
		}

		// 6.返回信息
		if (result.getReturnCode() == 0) {
			result.setReturnMsg("线下还款成功");
		}

		return result;
	}

	public Map<String, String> getRepayWayMap() {

		Map<String, String> repayWayMap = (Map<String, String>) EhCacheUtil.getInstance()
				.get(EhCacheConstant.ITF.REAPY_WAY, "ALL");
		if (Objects.isNull(repayWayMap)) {
			cacheReapyWay();
			repayWayMap = (Map<String, String>) EhCacheUtil.getInstance()
					.get(EhCacheConstant.ITF.REAPY_WAY, "ALL");
		}
		return repayWayMap;
	}

	public void cacheReapyWay() {
		try {
			logger.info("----------------缓存repayway 开始---------------------");
			List<SysDict> repayWayList;

			repayWayList = dictService.getListByType("CPHKFS");

			Map<String, String> bmap = new HashMap<String, String>();
			for (SysDict dict : repayWayList) {
				bmap.put(dict.getValue(), dict.getLabelText());
			}
			Map<String, String> unmodifiableMap = Collections.unmodifiableMap(bmap);
			EhCacheUtil.getInstance().put(EhCacheConstant.ITF.REAPY_WAY, "ALL", unmodifiableMap);
			logger.info("----------------缓存repayway 结束---------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取企业进件用户基本信息
	 * @param orderId
	 * @return
	 */
	public NjBaseInfoCompany getLoanOrderCompanyUserBaseInfo(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		NjBaseInfoCompany result = mapper.selectLoanOrderCompanyUserBaseInfo(orderId);
		if (result == null) {
			throw new Exception("订单信息出现问题,没有查询到订单对应的用户数据.");
		}
		return result;
	}
	/**
	 * 获取企业进件用户基本信息
	 * @param orderId
	 * @return
	 */
	public Map<String, Object> getLoanOrderCompanyUserBaseInfoMap(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map<String, Object> result = mapper.selectLoanOrderCompanyUserBaseInfoMap(orderId);
		if (result == null) {
			throw new Exception("订单信息出现问题,没有查询到订单对应的用户数据.");
		}
		return result;
	}

	public NjContactCompany getRelativesCompanyInfo(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getContactCompanyInfoByOrderId(orderId);
		
	}
	
	public Map<String, Object> getRelativesCompanyInfoMap(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getContactCompanyInfoByOrderIdMap(orderId);
		
	}

	public NjScenesCompany getScenesCompanyInfo(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getScenesCompanyInfoByOrderId(orderId);
	}
	
	public Map<String, Object> getScenesCompanyInfoMap(String orderId) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.getScenesCompanyInfoByOrderIdMap(orderId);
	}

	/**
	 * 保存企业订单基本信息资料
	 * @param pd
	 * @throws Exception 
	 */
	public void updateCompanyOrderBasicInfo(PageData pd) throws Exception {
		
		// 订单ID
		String orderId = pd.get("orderId").toString();
		NjLoanOrderMapper njLoanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder njLoanOrder = njLoanOrderMapper.selectByPrimaryKey(orderId);
		
		// 申请订单基本信息
		if (pd.containsKey("applyInfo")) {
			JSONObject jb = JSON.parseObject(pd.getString("applyInfo"));
			njLoanOrder.setAmount(jb.getBigDecimal("amount"));
			njLoanOrder.setPeriod(jb.getInteger("period"));
			njLoanOrder.setUsageDesc(jb.getString("usageDesc"));
			njLoanOrderMapper.updateByPrimaryKeySelective(njLoanOrder);
			
		}
		// 企业用户基本信息
		if (pd.containsKey("baseInfo")) {
			NjBaseInfoCompany baseInfo = JSON.parseObject(pd.getString("baseInfo"), NjBaseInfoCompany.class);
			saveNjBaseInfoCompany(baseInfo, orderId);
		}
		// 企业联系人信息
		if (pd.containsKey("contactCompany")) {
			NjContactCompany contactCompany = JSON.parseObject(pd.getString("contactCompany"), NjContactCompany.class);
			saveNjContactCompany(contactCompany, orderId);
		}
		// 企业交易场景信息
		if (pd.containsKey("transInfo")) {
			NjScenesCompany transInfo = JSON.parseObject(pd.getString("transInfo"), NjScenesCompany.class);
			saveNjScenesCompany(transInfo, orderId);
		}
		
		
	}
	
	/**
	 * 保存企业基本信息
	 * @param transInfo
	 * @param orderId
	 * @throws Exception
	 */
	private void saveNjBaseInfoCompany(NjBaseInfoCompany baseInfo, String orderId) throws Exception {
		NjBaseInfoCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjBaseInfoCompanyMapper.class);
		if(StringUtils.isEmpty(baseInfo.getId())) {//如果为空，则插入
			baseInfo.setId(UuidUtil.get32UUID());
			baseInfoCompanyMapper.insertSelective(baseInfo);
		}else {//如果不为空，则更新
			baseInfoCompanyMapper.updateByPrimaryKeySelective(baseInfo);
		}
	}

	/**
	 * 保存企业联系人信息
	 * @param transInfo
	 * @param orderId
	 * @throws Exception
	 */
	private void saveNjContactCompany(NjContactCompany contactCompany, String orderId) throws Exception {
		NjContactCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjContactCompanyMapper.class);
		if(StringUtils.isEmpty(contactCompany.getId())) {//如果为空，则插入
			contactCompany.setId(UuidUtil.get32UUID());
			baseInfoCompanyMapper.insertSelective(contactCompany);
		}else {//如果不为空，则更新
			baseInfoCompanyMapper.updateByPrimaryKeySelective(contactCompany);
		}
	}
	
	/**
	 * 保存企业场景信息
	 * @param transInfo
	 * @param orderId
	 * @throws Exception
	 */
	private void saveNjScenesCompany(NjScenesCompany transInfo, String orderId) throws Exception {
		NjScenesCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjScenesCompanyMapper.class);
		if(StringUtils.isEmpty(transInfo.getId())) {//如果为空，则插入
			transInfo.setId(UuidUtil.get32UUID());
			baseInfoCompanyMapper.insertSelective(transInfo);
		}else {//如果不为空，则更新
			baseInfoCompanyMapper.updateByPrimaryKeySelective(transInfo);
		}
	}

	public List<Map<String, Object>> selectExportList(Map<String, Object> param) throws Exception {
		NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return mapper.selectExportList(param);
	}

	/**
	 * 获取NjOrderFee
	 * @param orderId	订单id
	 * @param businessFeeCode 
	 * @throws Exception 
	 */
	public List<NjOrderFee> getNjOrderFee(String orderId,String businessFeeCode) throws Exception{
		NjOrderFeeMapper mapper = dao.getMapper(NjOrderFeeMapper.class);
		NjOrderFeeExample e = new NjOrderFeeExample();
		com.nj.model.generate.NjOrderFeeExample.Criteria c = e.createCriteria();
		if(StringUtils.isNotEmpty(orderId)){
			c.andOrderIdEqualTo(orderId);
		}
		if(StringUtils.isNotEmpty(businessFeeCode)){
			c.andBusinessFeeCodeEqualTo(businessFeeCode);
		}
		return mapper.selectByExample(e);
	}

	/**
	 * 百行上报
	 * @param bhRecord
	 * @throws Exception
	 */
	public void doBhReport(NjOrderBhRecord bhRecord) throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map<String, Object> retMap = extend.getBhReportInfo(bhRecord.getOrderId());
		Date createDate = (Date) retMap.get("create_date");
		String uploadTs = DateUtil.formatDate(createDate, "yyyy-MM-dd'T'HH:mm:ss");
//		retMap.put("uploadTs", uploadTs);
		retMap.put("customType", 99);//客户类型，默认 未知
		retMap.put("queryReason", 1);//查询原因，默认 授信审批
		retMap.put("guaranteeType", 1);//默认为信用
		retMap.put("loanPurpose", 11);//默认为综合用款
		Map<String, Object> postMap = new HashMap<>();
		postMap.put("requestMsg", retMap);
		postMap.put("companyCode", retMap.get("companyCode"));
		String AESKey = AddressConstants.JdcfAesKey;
		String json = JSONObject.toJSONString(postMap);
		logger.info("百行上报数据"+json);
		String data = AESUtil.EncryptTFCF(json, AESKey);
		ResponseDto<String> dto = bhDataService.queryBhForC1(data);
		String orderId = (String) retMap.get("orderId");
		if(dto.getReturnCode() == 0) {//如果上报成功，更新上报状态
			extend.updateBhReportStatus(orderId);
		}else {
			logger.error("订单id："+orderId+"，百行上报失败：返回信息"+JSONObject.toJSONString(dto));
		}
		
	}

	public void doDownLoad(NjUserAttachment userAttachment) throws Exception {
	    URL url = null;
	    String filePath = "";
	    NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
	    try {
	    	int imageNumber = 0;
		    String urlList = userAttachment.getFilePath();
		    
		    //最后一个.的位置
		    int dotPlace = urlList.lastIndexOf(".");
		    //后缀名
	        String postPix = "";
	        if (dotPlace > 0) {
	            postPix = urlList.substring(dotPlace + 1);
	        }
	        if (StringUtils.isEmpty(postPix)) {
	            postPix = "jpg";
	        }
	        
	        if(postPix.indexOf("jpg") > 0 || postPix.indexOf("JPG") > 0 ) {
	        	postPix = "jpg";
	        }else if (postPix.indexOf("png") > 0 || postPix.indexOf("PNG") > 0 ) {
	        	postPix = "png";
	        }else if(postPix.indexOf("jpeg") > 0 || postPix.indexOf("JPEG") > 0) {
	        	postPix = "jpeg";
	        }else {
	        	postPix = "jpg";
	        }
		    url = new URL(urlList);
	        InputStream file = url.openStream();
	        filePath = FileOperationUtil.uploadFile("pic", file, postPix);
	        userAttachment.setFilePath(filePath);
		} catch (Exception e) {
			userAttachment.setFilePath("file not fount");
			logger.info("attachmentId：{}，文件访问失败",userAttachment.getId());
		}
       
        mapper.updateByPrimaryKeySelective(userAttachment);
        logger.info("普惠等第三方附件下载更新成功,地址：{},attachmentId：{}",filePath,userAttachment.getId());
	}
	

	public Map<String, Object> getInfoByOrderNo(String orderNo) {
		return njLoanOrderMapperExtend.getInfoByOrderNo(orderNo);
	}
}
