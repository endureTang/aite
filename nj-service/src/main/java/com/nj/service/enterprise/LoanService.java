/**
 * 
 * @Name com.nj.enterprise.controller.order.LoadOrderController
 * @Description 贷中服务类
 * 
 * @Author bruce
 * @Version 2018年2月26日 下午3:06:20
 * @Copyright 金鼎财富
 *
 */

package com.nj.service.enterprise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.core.util.encrypt.EncrypRSA;
import com.jd.core.util.sign.SignCommonUtil;
import com.nj.core.base.common.AddressConstants;
import com.nj.core.base.common.api.ResponseLoanMsg;
import com.nj.core.base.common.api.ResponseSndkMsg;
import com.nj.core.base.entity.DuplicateSubmitToken;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProcessInfo;
import com.nj.core.base.enums.EProcessResult;
import com.nj.core.base.enums.EProductTemplate;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjCoporateMapper;
import com.nj.dao.NjDebitRecordLineMapper;
import com.nj.dao.NjDebitRecordMapper;
import com.nj.dao.NjLoanExaminationLogMapper;
import com.nj.dao.NjLoanOrderCheckRecordMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjLoanOrderPhoneCheckMapper;
import com.nj.dao.NjOrderUpdateLogMapper;
import com.nj.dao.NjProcessOrderFlowsMapper;
import com.nj.dao.NjRepayOfflineHistoryMapper;
import com.nj.dao.NjRepayOfflineLineHistoryMapper;
import com.nj.dao.NjRepayOfflineLineMapper;
import com.nj.dao.NjRepayOfflineMapper;
import com.nj.dao.NjUserCreditMapper;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjOrderUpdateLogMapperExtend;
import com.nj.dao.extend.NjProcessMapperExtend;
import com.nj.dao.extend.NjProductTempMapperExtend;
import com.nj.dao.extend.NjRepayOfflineLineMapperExtend;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjDebitRecord;
import com.nj.model.generate.NjDebitRecordExample;
import com.nj.model.generate.NjDebitRecordLine;
import com.nj.model.generate.NjDebitRecordLineExample;
import com.nj.model.generate.NjLoanExaminationLog;
import com.nj.model.generate.NjLoanExaminationLogExample;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjLoanOrderCheckRecord;
import com.nj.model.generate.NjLoanOrderCheckRecordExample;
import com.nj.model.generate.NjLoanOrderExample;
import com.nj.model.generate.NjLoanOrderExample.Criteria;
import com.nj.model.generate.NjLoanOrderPhoneCheck;
import com.nj.model.generate.NjLoanOrderPhoneCheckExample;
import com.nj.model.generate.NjOrderUpdateLog;
import com.nj.model.generate.NjOrderUpdateLogExample;
import com.nj.model.generate.NjProcessOrderFlowsExample;
import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.model.generate.NjProductTemp;
import com.nj.model.generate.NjRepayOffline;
import com.nj.model.generate.NjRepayOfflineExample;
import com.nj.model.generate.NjRepayOfflineHistory;
import com.nj.model.generate.NjRepayOfflineHistoryExample;
import com.nj.model.generate.NjRepayOfflineLine;
import com.nj.model.generate.NjRepayOfflineLineExample;
import com.nj.model.generate.NjRepayOfflineLineHistory;
import com.nj.model.generate.NjUserCredit;
import com.nj.model.generate.NjUserCreditExample;
import com.nj.service.itf.SndkHttpService;
import com.nj.service.itf.TfcfHttpService;
import com.nj.service.process.ManualProcess;
import com.nj.service.process.ProcessFlowsService;

@Service("loanService")
public class LoanService extends BaseCachesService {

	/*
	 * @Resource(name = "BaseDao") private BaseDao dao;
	 */

	private static Logger logger = LoggerFactory.getLogger(LoanService.class);

	@Resource(name = "tfcfHttpService")
	private TfcfHttpService tfcfHttpService;

	@Resource(name = "sndkHttpService")
	private SndkHttpService sndkHttpService;
	@Resource
	NjLoanOrderCheckRecordMapper loanOrderCheckRecordMapper;
	@Resource
	private NjProcessMapperExtend processMapperExtend;
	@Resource(name = "njProcessFlowsService")
	private ProcessFlowsService processFlowsService;
	
	@Autowired
	private ManualProcess manualProcess;
	@Autowired
	NjLoanOrderPhoneCheckMapper phoneCheckMapper;
	@Autowired
	NjLoanOrderMapper loanOrderMapper;
	@Autowired
	NjUserCreditMapper userCreditMapper;
	@Autowired
	NjProductTempMapperExtend productTempMapperExtend;
	
	@Autowired
	private  NjLoanOrderMapperExtend  njLoanOrderMapperExtend;
	
	@Autowired
	private  NjOrderUpdateLogMapper  njOrderUpdateLogMapper;
	
	@Resource
	private NjProcessOrderFlowsMapper njProcessOrderFlowsMapper;
	

	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息 + 用户角色信息
	 */
	public PageData getList(PageData pd) throws Exception {
		PageData pd1 = new PageData();
		pd1.put(Constants.Datas.RECORDSFILTERED, 0);
		pd1.put(Constants.Datas.NDATA, new ArrayList());
		try {
			int start = pd.getInteger(Constants.Datas.START);
			int length = pd.getInteger(Constants.Datas.LENGTH);
			int isPartnerOrder = pd.getInteger("isPartnerOrder");// 是否本地订单 0：本地，1：第三方

			pd.put("page", start / length + 1);
			pd.put("row", length);

			String tfcfResp = tfcfHttpService.doHttpPostForTfcf("", "", pd,
					com.nj.core.base.common.Constants.TFCF.GET_USERLOAN_RREQUESTLIST);
			logger.debug("tfcfResp: " + tfcfResp);
			if (StringUtils.isNotEmptyAndNull(tfcfResp)) {
				// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
				ResponseLoanMsg tfcfResp1 = JSONObject.parseObject(tfcfResp, ResponseLoanMsg.class);
				// JSONObject obj = JSONObject.parseObject(tfcfResp);
				if (tfcfResp1 != null) {
					// pd1.put(Constants.Datas.RECORDSTOTAL, 10);
					pd1.put(Constants.Datas.RECORDSFILTERED, tfcfResp1.getTotal());

					if (isPartnerOrder == 0) {
						pd1.put(Constants.Datas.NDATA, tfcfResp1.getRows());
					} else {
						if (tfcfResp1.getRows() != null) {
							List<Map> lt = (List<Map>) tfcfResp1.getRows();
							for (Map map : lt) {
								map.put("threeChannelName", getThreeChennelName(map));
							}
						}
						pd1.put(Constants.Datas.NDATA, tfcfResp1.getRows());
					}
					return pd1;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd1;
	}

	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息 + 用户角色信息
	 */
	public PageData getOfflineList(PageData pd) throws Exception {

		NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> results = sm.getOfflineLoanList(pd);
		int totalCount = sm.getOfflineLoanListCount(pd);

		PageData pd1 = new PageData();

		pd1.put(Constants.Datas.RECORDSFILTERED, totalCount);
		pd1.put(Constants.Datas.NDATA, results);

		return pd1;
	}

	public String getThreeChennelName(Map pd) throws Exception {
		NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map map = sm.getThreeChennelName(pd);
		if (map != null && map.get("name") != null) {
			return map.get("name").toString();
		}
		return null;
	}

	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息 + 用户角色信息
	 */
	public PageData getThreeOfflineList(PageData pd) throws Exception {

		NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map> results = sm.getThreeOfflineLoanList(pd);
		int totalCount = sm.getThreeOfflineLoanListCount(pd);

		PageData pd1 = new PageData();

		pd1.put(Constants.Datas.RECORDSFILTERED, totalCount);
		pd1.put(Constants.Datas.NDATA, results);

		return pd1;
	}

	public PageData getPlanList(PageData pd) throws Exception {
		try {
			int start = pd.getInteger(Constants.Datas.START);
			int length = pd.getInteger(Constants.Datas.LENGTH);
			pd.put("page", start / length + 1);
			pd.put("row", length);

			String tfcfResp = tfcfHttpService.doHttpPostForTfcf("", "", pd,
					com.nj.core.base.common.Constants.TFCF.GET_BORROW_REPAYLIST);
			logger.debug("tfcfResp: " + tfcfResp);
			if (StringUtils.isNotEmptyAndNull(tfcfResp)) {
				// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
				ResponseLoanMsg tfcfResp1 = JSONObject.parseObject(tfcfResp, ResponseLoanMsg.class);
				// JSONObject obj = JSONObject.parseObject(tfcfResp);
				if (tfcfResp1 != null) {
					PageData pd1 = new PageData();
					// pd1.put(Constants.Datas.RECORDSTOTAL, 10);
					pd1.put(Constants.Datas.RECORDSFILTERED, tfcfResp1.getTotal() == null ? 0 : tfcfResp1.getTotal());
					pd1.put(Constants.Datas.NDATA, tfcfResp1.getRows());
					return pd1;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Map getTfdLoanInfo(String orderNo) throws Exception {
		try {
			Map map = new HashMap<>();
			map.put("tfdRequestId", orderNo);

			String tfcfResp = tfcfHttpService.doHttpPostForTfcf("", "", map,
					com.nj.core.base.common.Constants.TFCF.GET_USERLOAN_RREQUESTDETAIL);
			logger.debug("tfcfResp: " + tfcfResp);
			if (StringUtils.isNotEmptyAndNull(tfcfResp)) {
				// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
				ResponseLoanMsg tfcfResp1 = JSONObject.parseObject(tfcfResp, ResponseLoanMsg.class);
				if (tfcfResp1 != null) {
					return tfcfResp1.getOptional();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Map getTfdLoanHKInfo(String orderNo) throws Exception {
		try {
			Map map = new HashMap<>();
			map.put("tfdRequestId", orderNo);

			String tfcfResp = tfcfHttpService.doHttpPostForTfcf("", "", map,
					com.nj.core.base.common.Constants.TFCF.GET_USERREPAY_DETAIL);
			logger.debug("tfcfResp: " + tfcfResp);
			if (StringUtils.isNotEmptyAndNull(tfcfResp)) {
				// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
				ResponseLoanMsg tfcfResp1 = JSONObject.parseObject(tfcfResp, ResponseLoanMsg.class);
				if (tfcfResp1 != null) {
					return tfcfResp1.getOptional();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public HttpEntity donwload(String orderNo) throws Exception {
		try {
			Map map = new HashMap<>();
			map.put("tfdRequestId", orderNo);

			HttpEntity tfcfResp = tfcfHttpService.doHttpPostFileForTfcf("", "", map,
					com.nj.core.base.common.Constants.TFCF.DONWLOAD_CONSUMER_CONTRACT);
			logger.debug("tfcfResp: " + tfcfResp);
			return tfcfResp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Map getLoanInfo(PageData pd) throws Exception {
		// pd.put("orderNo", "000199990013000017");//测试
		NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
		Map map = sm.getLoanInfoByOrderNo(pd);
		if (map != null) {
			String name = (String) map.get("channelName");
			if (StringUtils.isEmpty(name)) {
				if (map.get("channelName2") != null) {
					Object channelName = StringUtils.isEmpty(map.get("channelName2").toString())
							? map.get("channelName1")
							: map.get("channelName2");
					map.put("channelName", channelName);
				}
			}
		}
		return map;
	}

	public List getAttachmentInfo(String orderNo) throws Exception {
		try {
			Map map = new HashMap<>();
			map.put("tfdRequestId", orderNo);

			String tfcfResp = tfcfHttpService.doHttpPostForTfcf("", "", map,
					com.nj.core.base.common.Constants.TFCF.GET_ATTACHMENT_LIST);
			logger.debug("tfcfResp: " + tfcfResp);
			if (StringUtils.isNotEmptyAndNull(tfcfResp)) {
				// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
				ResponseLoanMsg tfcfResp1 = JSONObject.parseObject(tfcfResp, ResponseLoanMsg.class);
				if (tfcfResp1 != null) {
					return tfcfResp1.getRows();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void addLog(NjLoanExaminationLog log) throws Exception {
		NjLoanExaminationLogMapper sm = dao.getMapper(NjLoanExaminationLogMapper.class);
		log.setId(UuidUtil.get32UUID());
		log.setCreatedate(new Date());
		sm.insert(log);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public List<NjLoanExaminationLog> getLogList(String orderId) throws Exception {
		NjLoanExaminationLogMapper sm = dao.getMapper(NjLoanExaminationLogMapper.class);

		NjLoanExaminationLogExample example = new NjLoanExaminationLogExample();
		com.nj.model.generate.NjLoanExaminationLogExample.Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(orderId);

		return sm.selectByExample(example);
	}

	/**
	 * 获取线下贷款还款计划
	 * 
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public NjRepayOffline getLoanHKInfo(String orderNo) throws Exception {
		NjRepayOfflineMapper mapper = dao.getMapper(NjRepayOfflineMapper.class);
		NjRepayOfflineExample example = new NjRepayOfflineExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		List<NjRepayOffline> orders = mapper.selectByExample(example);
		if (orders == null || orders.isEmpty())
			return null;
		return orders.get(0);
	}

	/**
	 * 获取线下贷款还款计划列表
	 * 
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public PageData getLoanHKInfoList(PageData pd) throws Exception {

		NjRepayOfflineLineMapperExtend sm = dao.getMapper(NjRepayOfflineLineMapperExtend.class);
		List<Map> results = sm.getRepayOfflineList(pd);
		int totalCount = sm.getRepayOfflineListCount(pd);

		PageData pd1 = new PageData();
		pd1.put(Constants.Datas.RECORDSFILTERED, totalCount);
		pd1.put(Constants.Datas.NDATA, results);
		return pd1;
	}

	/**
	 * 手动更新线下贷款还款计划列表
	 * 
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateOfflineInfo(String orderNo, NjRepayOfflineLine obj) throws Exception {
		NjRepayOfflineLineMapper sm = dao.getMapper(NjRepayOfflineLineMapper.class);
		sm.updateByPrimaryKeySelective(obj);

		NjRepayOfflineHistoryMapper rohm = dao.getMapper(NjRepayOfflineHistoryMapper.class);

		NjRepayOfflineHistoryExample example = new NjRepayOfflineHistoryExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		example.setOrderByClause("create_time desc");

		List<NjRepayOfflineHistory> orders = rohm.selectByExample(example);
		if (orders != null && orders.size() > 0) {
			NjRepayOfflineLineHistory o = new NjRepayOfflineLineHistory();
			o.setId(UuidUtil.get32UUID());
			o.setOfflineHistoryId(orders.get(0).getId());
			o.setOfflineRepayLineId(obj.getId());
			o.setChangeOper("edit");
			o.setPlanRepayDay(obj.getPlanRepayDay());
			o.setActualRepayDay(obj.getActualRepayDay());
			o.setTotalAmount(obj.getTotalAmount());
			o.setPrincipal(obj.getPrincipal());
			o.setInterest(obj.getInterest());
			o.setStatus(obj.getStatus());

			NjRepayOfflineLineHistoryMapper rolhm = dao.getMapper(NjRepayOfflineLineHistoryMapper.class);
			rolhm.insert(o);
		}
	}

	/**
	 * 自动更新线下贷款还款计划列表
	 * 
	 * @param orderNo
	 * @param id
	 * @param state
	 *            10未到期,20到期未还款,30还款处理中,90已还款
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateOfflineInfo(String orderNo, String id, String state) throws Exception {
		NjRepayOfflineLine obj = new NjRepayOfflineLine();
		obj.setId(id);
		obj.setStatus(state);
		obj.setActualRepayDay(new Date());

		NjRepayOfflineLineMapper sm = dao.getMapper(NjRepayOfflineLineMapper.class);
		sm.updateByPrimaryKeySelective(obj);

		NjRepayOfflineHistoryMapper rohm = dao.getMapper(NjRepayOfflineHistoryMapper.class);

		NjRepayOfflineHistoryExample example = new NjRepayOfflineHistoryExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		example.setOrderByClause("create_time desc");

		List<NjRepayOfflineHistory> orders = rohm.selectByExample(example);
		if (orders != null && orders.size() > 0) {
			NjRepayOfflineLineHistory o = new NjRepayOfflineLineHistory();
			o.setId(UuidUtil.get32UUID());
			o.setOfflineHistoryId(orders.get(0).getId());
			o.setOfflineRepayLineId(obj.getId());
			o.setChangeOper("system");
			o.setPlanRepayDay(obj.getPlanRepayDay());
			o.setActualRepayDay(obj.getActualRepayDay());
			o.setTotalAmount(obj.getTotalAmount());
			o.setPrincipal(obj.getPrincipal());
			o.setInterest(obj.getInterest());
			o.setStatus(obj.getStatus());

			NjRepayOfflineLineHistoryMapper rolhm = dao.getMapper(NjRepayOfflineLineHistoryMapper.class);
			rolhm.insert(o);
		}
	}

	/**
	 * 获取线下贷款还款计划列表
	 * 
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public List<NjRepayOfflineLine> getLoanOfflineInfoList(String id) throws Exception {

		NjRepayOfflineLineMapper sm = dao.getMapper(NjRepayOfflineLineMapper.class);

		NjRepayOfflineLineExample example = new NjRepayOfflineLineExample();
		example.createCriteria().andOfflineRepayIdEqualTo(id);
		example.setOrderByClause("plan_repay_day");

		List<NjRepayOfflineLine> orders = sm.selectByExample(example);
		if (orders == null || orders.isEmpty())
			return null;
		return orders;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveLoanOfflineList(String orderNo, String repayId, String userId, List<NjRepayOfflineLine> list)
			throws Exception {

		Collections.sort(list, new Comparator<NjRepayOfflineLine>() {

			@Override
			public int compare(NjRepayOfflineLine o1, NjRepayOfflineLine o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getPlanRepayDay().getTime() - o2.getPlanRepayDay().getTime());
			}

		});
		double total = 0, principal = 0, interest = 0;
		String status = "90";
		String historyId = UuidUtil.get32UUID();

		List<NjRepayOfflineLineHistory> hList = new ArrayList<>(list.size());
		for (NjRepayOfflineLine njRepayOfflineLine : list) {
			total += njRepayOfflineLine.getTotalAmount().doubleValue();
			interest += njRepayOfflineLine.getInterest().doubleValue();
			principal += njRepayOfflineLine.getPrincipal().doubleValue();

			if (!"90".equals(njRepayOfflineLine.getStatus())) {
				status = "10";
			}

			NjRepayOfflineLineHistory o = new NjRepayOfflineLineHistory();
			o.setId(UuidUtil.get32UUID());
			o.setOfflineHistoryId(historyId);
			o.setOfflineRepayLineId(njRepayOfflineLine.getId());
			o.setChangeOper("add");
			o.setPlanRepayDay(njRepayOfflineLine.getPlanRepayDay());
			o.setActualRepayDay(njRepayOfflineLine.getActualRepayDay());
			o.setTotalAmount(njRepayOfflineLine.getTotalAmount());
			o.setPrincipal(njRepayOfflineLine.getPrincipal());
			o.setInterest(njRepayOfflineLine.getInterest());
			o.setStatus(njRepayOfflineLine.getStatus());

			hList.add(o);

		}
		NjRepayOffline rof = new NjRepayOffline();
		rof.setId(repayId);
		rof.setTotalAmount(new BigDecimal(total));
		rof.setPrincipal(new BigDecimal(principal));
		rof.setInterest(new BigDecimal(interest));
		rof.setStatus(status);
		rof.setUpdateTime(new Date());

		NjRepayOfflineHistory rofh = new NjRepayOfflineHistory();
		rofh.setId(historyId);
		rofh.setOrderNo(orderNo);
		rofh.setTotalAmount(new BigDecimal(total));
		rofh.setPrincipal(new BigDecimal(principal));
		rofh.setInterest(new BigDecimal(interest));
		rofh.setChangeType("import");
		rofh.setCreateTime(new Date());
		rofh.setCreateBy(userId);
		rofh.setNumber(0);

		// 1.更新主表
		NjRepayOfflineMapper rom = dao.getMapper(NjRepayOfflineMapper.class);
		rom.updateByPrimaryKeySelective(rof);

		// 2.更新从表,先删除，在新增
		NjRepayOfflineLineMapper sm = dao.getMapper(NjRepayOfflineLineMapper.class);
		NjRepayOfflineLineExample example = new NjRepayOfflineLineExample();
		example.createCriteria().andOfflineRepayIdEqualTo(repayId);
		sm.deleteByExample(example);

		for (NjRepayOfflineLine nro : list) {
			sm.insert(nro);
		}

		// 3.更新主表历史
		NjRepayOfflineHistoryMapper rohm = dao.getMapper(NjRepayOfflineHistoryMapper.class);
		rohm.insert(rofh);

		NjRepayOfflineLineHistoryMapper rolhm = dao.getMapper(NjRepayOfflineLineHistoryMapper.class);
		for (NjRepayOfflineLineHistory temp : hList) {
			rolhm.insert(temp);
		}

	}

	public List<Map> getRepaidPersonCardInfoList(String orderNo) throws Exception {

		return null;
	}

	public Map getSndkInfo(String orderNo) throws Exception {
		try {
			Map map = new HashMap<>();
			map.put("cardHolderName", "黄晓明");
			map.put("certNo", "510681198606180618");
			map.put("mobileNo", "18116623375");
			map.put("cardNo", "8000000000000000291");

			String tfcfResp = sndkHttpService.doHttpPostForSndk("nj_server", "TEST_KJ", "TEST_KJ", "01", map,
					com.nj.core.base.common.Constants.SNDK.BIND_BANK_CARD);
			logger.debug("sndkResp: " + tfcfResp);
			if (StringUtils.isNotEmptyAndNull(tfcfResp)) {
				tfcfResp = tfcfResp.replace("\\", "");
				tfcfResp = tfcfResp.substring(1, tfcfResp.length() - 1);
				// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
				ResponseSndkMsg tfcfResp1 = JSONObject.parseObject(tfcfResp, ResponseSndkMsg.class);

				// JSONObject obj = JSONObject.parseObject(tfcfResp);
				if (tfcfResp1 != null && tfcfResp1.isSuccess()) {
					// pd1.put(Constants.Datas.RECORDSTOTAL, 10);
					if (tfcfResp1.getResult() != null) {
						String no = tfcfResp1.getResult().get("jd_serial_no").toString();
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取线下贷款还款计划列表
	 * 
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public List<Map> getLoanPlanList(PageData pd) throws Exception {
		// 查询全部期数
		pd.put("start", 0);
		pd.put("length", 100);
		NjRepayOfflineLineMapperExtend sm = dao.getMapper(NjRepayOfflineLineMapperExtend.class);
		List<Map> results = sm.getRepayOfflineList(pd);
		return results;
	}

	

	

	

	/**
	 * 转换单位分
	 * 
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	public String change(String amount) throws Exception {
		BigDecimal a = new BigDecimal(amount);
		return a.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 更新扣款记录表
	 * 
	 * @param orderNo
	 * @param planId
	 * @param map
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void createDebitRecord(String orderNo, String planId, Map map, int state, String snOrderNo)
			throws Exception {

		NjDebitRecord obj = new NjDebitRecord();
		String id = UuidUtil.get32UUID();
		obj.setId(id);
		obj.setOrderNo(orderNo);
		obj.setSerialNumber("");
		obj.setMerchantNumber(map.get("merchantNo").toString());
		obj.setMerchantOrderNumber(map.get("outOrderNo").toString());
		obj.setMerchantOrderTime(new Date());
		obj.setOrderMoney(map.get("orderAmount").toString());
		obj.setMerchantBalanceMoney(map.get("merchantAmount").toString());
		obj.setDebitType("singleperiod");
		obj.setSnOrderNo(snOrderNo);
		obj.setRemark("system");
		obj.setDebitState(state);
		obj.setCreateTime(new Date());

		NjDebitRecordLine ol = new NjDebitRecordLine();
		ol.setId(UuidUtil.get32UUID());
		ol.setOrderNo(orderNo);
		ol.setRepayOfflineLineId(planId);
		ol.setDebitRecordId(id);
		ol.setCreateTime(new Date());

		NjDebitRecordMapper sm = dao.getMapper(NjDebitRecordMapper.class);
		sm.insert(obj);
		NjDebitRecordLineMapper rlm = dao.getMapper(NjDebitRecordLineMapper.class);
		rlm.insert(ol);
	}

	public List<NjDebitRecord> getProcessOrder() throws Exception {
		NjDebitRecordMapper rolm = dao.getMapper(NjDebitRecordMapper.class);
		NjDebitRecordExample example = new NjDebitRecordExample();
		example.createCriteria().andDebitStateEqualTo(1);
		return rolm.selectByExample(example);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateProcessOrder(NjDebitRecord debitRecord, boolean isSuccess) throws Exception {
		int state = 0;
		String stateStr = "90";
		if (!isSuccess) {
			state = 2;
			stateStr = "10";
		}

		// 1.更新扣款记录状态
		NjDebitRecord now = new NjDebitRecord();
		now.setId(debitRecord.getId());
		now.setDebitState(state);
		now.setUpdateTime(new Date());
		now.setRemark("自动更新扣款状态");
		NjDebitRecordMapper sm = dao.getMapper(NjDebitRecordMapper.class);
		sm.updateByPrimaryKeySelective(now);

		// 2.更新计划任务状态
		NjDebitRecordLineMapper sm1 = dao.getMapper(NjDebitRecordLineMapper.class);
		NjDebitRecordLineExample example = new NjDebitRecordLineExample();
		example.createCriteria().andDebitRecordIdEqualTo(debitRecord.getId());
		List<NjDebitRecordLine> list = sm1.selectByExample(example);
		if (list != null && list.size() == 1) {
			NjDebitRecordLine obj = list.get(0);
			String orderNo = obj.getOrderNo();
			String planId = obj.getRepayOfflineLineId();
			// 更新还款计划表
			updateOfflineInfo(orderNo, planId, stateStr);
		}
	}

	
	/**
	 * 查询审核记录
	 * 
	 * @param orderId
	 * @return
	 */
	public List<NjLoanOrderCheckRecord> selectCheckRecord(String orderId) {
		NjLoanOrderCheckRecordExample example = new NjLoanOrderCheckRecordExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andDataTypeLessThan((byte)10);
		return loanOrderCheckRecordMapper.selectByExample(example);
	}
	/**
	 * 查询人工核查记录
	 * @param orderId
	 * @return
	 */
	public List<NjLoanOrderCheckRecord> selectManualCheckRecord(String orderId) {
		NjLoanOrderCheckRecordExample example = new NjLoanOrderCheckRecordExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andDataTypeGreaterThan((byte)10);
		return loanOrderCheckRecordMapper.selectByExample(example);
	}
	public NjLoanOrderCheckRecord selectCheckRecordByType(String orderId,Byte dataType) {
		NjLoanOrderCheckRecord record = null;
		NjLoanOrderCheckRecordExample example = new NjLoanOrderCheckRecordExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andDataTypeEqualTo(dataType);
		List<NjLoanOrderCheckRecord> list = loanOrderCheckRecordMapper.selectByExample(example);
		if(list.size()>0) {
			record = list.get(0);
		}
		return record;
	}
	/*
	 * 添加订单核查记录
	 */
	@Transactional(readOnly = false, rollbackFor = { Throwable.class })
	public void saveOrderInfoCheck(String checkUserId,List<NjLoanOrderCheckRecord> checkRecordList) throws Exception {
		NjLoanOrderCheckRecordMapper mapper = dao.getMapper(NjLoanOrderCheckRecordMapper.class);
		for(NjLoanOrderCheckRecord njLoanOrderCheckRecord:checkRecordList) {
			NjLoanOrderCheckRecord oldRecord = selectCheckRecordByType(njLoanOrderCheckRecord.getOrderId(),njLoanOrderCheckRecord.getDataType());
			if(oldRecord==null) {
				njLoanOrderCheckRecord.setId(UuidUtil.get32UUID());
				njLoanOrderCheckRecord.setCheckUserId(checkUserId);
				njLoanOrderCheckRecord.setCheckDate(new Date());
				mapper.insert(njLoanOrderCheckRecord);
			}else {
				njLoanOrderCheckRecord.setId(oldRecord.getId());
				njLoanOrderCheckRecord.setCheckDate(new Date());
				njLoanOrderCheckRecord.setCheckUserId(checkUserId);
				mapper.updateByPrimaryKey(njLoanOrderCheckRecord);
			}
			if(njLoanOrderCheckRecord.getDataType()==21) {
				//修改贷后订单反欺诈状态
				NjLoanOrder loanOrder  = loanOrderMapper.selectByPrimaryKey(njLoanOrderCheckRecord.getOrderId());
				int afrerStatus = (njLoanOrderCheckRecord.getAbnormal()==true?1:0);
				loanOrder.setAfterStatus((byte)afrerStatus);
				loanOrderMapper.updateByPrimaryKeySelective(loanOrder);
			}
		}
		
	}

	/**
	 * @param i
	 * @return
	 */
	private Byte Byte(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 人工审核(同意)
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@DuplicateSubmitToken(type = DuplicateSubmitToken.REQUEST)
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public boolean examineOrder(PageData pd) throws Exception{
		int processId = pd.getInteger("processId");
		String orderId=pd.getString("orderId");
		String remarkExtend=pd.getString("remarkExtend");
		//驳回 流程id
		int rejectProcessId=0;
	    if(!StringUtils.isEmpty(pd.getString("rejectProcessId"))) {
	      rejectProcessId = pd.getInteger("rejectProcessId");
	    }
		EProcessResult epInfo = EProcessResult.getEProcessResult(Short.valueOf(pd.getString("resultValue")));
		NjProductTemp productTemp = productTempMapperExtend.selectProductTempByOrderId(orderId);
		NjLoanOrder loanOrder  = loanOrderMapper.selectByPrimaryKey(orderId);
		if(epInfo.equals(EProcessResult.AGREE)) {
			
			if(EProductTemplate.Housing.getId()!=productTemp.getTemplateId().intValue()) {
				if(processId==EProcessInfo.FIRST_CHECK.getId()) {
					//初审且同意，先保存订单信息
					loanOrder.setAuditAmount(new BigDecimal(pd.getString("auditAmount")));
					loanOrder.setGeAgcyAdvice(pd.getString("geAgcyAdvice"));//担保方式
					loanOrder.setEnterpriseCase(pd.getString("enterpriseCase"));//借款用途
					loanOrder.setProjectContent(pd.getString("projectContent"));//项目概况
					loanOrder.setFundsUse(pd.getString("fundsUse"));//还款来源
					loanOrder.setRiskGrade(pd.getString("riskGrade"));//风险等级
					loanOrder.setAuditPeriod(loanOrder.getPeriod());//期数
					loanOrder.setRepayWay(loanOrder.getRepayWay());//还款方式
				}
			}else {
				if(!StringUtils.isEmpty(remarkExtend)) {
					JSONObject jb = JSONObject.parseObject(remarkExtend);
					String auditAmount = jb.getString("auditAmount");
					Integer period = jb.getInteger("auditPeriod");
					String rating = jb.getString("auditMonthRate");
					Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
					if(!StringUtils.isEmpty(rating) && !pattern.matcher(rating).matches()) {
						throw new Exception("利率必须为数字");
					}
					if(pd.getString("remark") == null || pd.getString("remark").equals("")) {
						pd.put("remark", jb.getString("remark"));
					}
					if(!StringUtils.isEmpty(auditAmount) && !StringUtils.isEmpty(rating)) {
						loanOrder.setAuditAmount(new BigDecimal(auditAmount));
						loanOrder.setAuditPeriod(period);//期数
						loanOrder.setRepayWay(jb.getString("repayWay"));//还款方式
						loanOrder.setAuditRating(rating);
						loanOrder.setAuditServiceRating("0");
					}
				}
			}
			loanOrder.setAuditRemarks(pd.getString("remark"));
			loanOrderMapper.updateByPrimaryKey(loanOrder);
		}
		logger.info("selectProcessTemplateByOrderProcess参数：orderId="+orderId+",processId="+processId);
		NjProcessTemplateFlows currentProcess = processMapperExtend.selectProcessTemplateByOrderProcess(orderId,processId);
		if (currentProcess == null) {
			logger.error("订单:{},没有查询到过程:{}", orderId, processId);
			throw new Exception("没有查询到过程");
		}
		
		boolean result = manualProcess.execManualProcess(orderId, pd.getString("userId"), currentProcess, epInfo, pd.getString("remark"),rejectProcessId);
		//流程执行成功后，更新审批意见
		if(result && !StringUtils.isEmpty(remarkExtend)) {
			updateApprovalOpinion(loanOrder.getOrderNo(), processId, remarkExtend);
		}
		NjProcessTemplateFlows nextCurrent = processFlowsService.selectNextProcess(currentProcess, EProcessResult.AGREE);
		if(nextCurrent != null) {
			//如果小贷大于100万流程，审批金额小于100万，则手动触发董事长流程，并删除该流程
			//如果订单流程走的大于100万
			NjProcessOrderFlowsExample processExample = new NjProcessOrderFlowsExample();
			processExample.createCriteria().andOrderIdEqualTo(loanOrder.getId());
			//查询已放款订单金额
			Double makeLoanAmount = njLoanOrderMapperExtend.selectAmountByUserId(loanOrder.getUserId(),ELoanOrderStatus.MAKE_LOANS.getValue());
			
			Long processCount = njProcessOrderFlowsMapper.countByExample(processExample);//获取流程个数
			//如果订单流程已经删除，驳回后重新大于100万，则重置流程
			if(processCount> 20 && processCount <23 && loanOrder.getAuditAmount().doubleValue() + makeLoanAmount > 1000000) {
				throw new Exception("批复金额变动频繁，请重置订单流程。");
			}
			if(((nextCurrent.getProcessId() == EProcessInfo.LAST_CHECK.getId()&& processCount.intValue() == AddressConstants.CdjkProcessNumber.intValue())  
					|| (nextCurrent.getProcessId() == EProcessInfo.MAKE_LOANS_FIFTH_CHECK.getId() && processCount.intValue() == AddressConstants.CdjkProcessNumber.intValue() -1)) //董事长流程
					&& EProductTemplate.Housing.getId()==productTemp.getTemplateId().intValue() //小贷订单
					&& loanOrder.getAuditAmount().doubleValue() < new BigDecimal("1000000").doubleValue()) {//审批金额小于100万
				//如果订单该用户已放款金额小于100w，则自动执行终审流程
				//特殊需求，凉山金坤判断金额为50w
				if(loanOrder.getCompanyId().equals("1a1e2a243d304ff6bce0bc17f0512b67")) {
					if(makeLoanAmount + loanOrder.getAuditAmount().doubleValue() < 500000) {
						boolean resultTwo = manualProcess.execManualProcess(orderId, pd.getString("userId"), nextCurrent, epInfo, pd.getString("remark"),rejectProcessId);
						if(!resultTwo) {
							throw new Exception("流程执行出错");
						}
						//删除该流程
						NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
						example.createCriteria().andOrderIdEqualTo(orderId).andProcessIdEqualTo(nextCurrent.getProcessId());
						njProcessOrderFlowsMapper.deleteByExample(example);
						//删除该流程日志
						NjOrderUpdateLogMapper logMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
						NjOrderUpdateLogExample logExample = new NjOrderUpdateLogExample();
						logExample.createCriteria().andOrderIdEqualTo(loanOrder.getOrderNo()).andProcessIdEqualTo(nextCurrent.getProcessId());
						logMapper.deleteByExample(logExample);
					}
				}else {//其他金坤为100w
					if(makeLoanAmount + loanOrder.getAuditAmount().doubleValue() < 1000000) {
						boolean resultTwo = manualProcess.execManualProcess(orderId, pd.getString("userId"), nextCurrent, epInfo, pd.getString("remark"),rejectProcessId);
						if(!resultTwo) {
							throw new Exception("流程执行出错");
						}
						//删除该流程
						NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
						example.createCriteria().andOrderIdEqualTo(orderId).andProcessIdEqualTo(nextCurrent.getProcessId());
						njProcessOrderFlowsMapper.deleteByExample(example);
						//删除该流程日志
						NjOrderUpdateLogMapper logMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
						NjOrderUpdateLogExample logExample = new NjOrderUpdateLogExample();
						logExample.createCriteria().andOrderIdEqualTo(loanOrder.getOrderNo()).andProcessIdEqualTo(nextCurrent.getProcessId());
						logMapper.deleteByExample(logExample);
					}
				}
				
			}
		}
		
		return result;
	
	}
	/**
	 * 再次提交审核
	 * @param orderId
	 * @param userId
	 * @throws Exception 
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void repeatSubmit(String orderId,String userId) throws Exception {
		
		NjProcessTemplateFlows beforProcess = processFlowsService.selectBeforManualProcess(orderId);
		if(beforProcess==null) {
			throw new Exception("该订单没有找到手动审核过程,不能再次提交。");
		}
		//更新订单状态
		NjLoanOrder loanOrder  = loanOrderMapper.selectByPrimaryKey(orderId);
		int oldStatus=loanOrder.getStatus();
		loanOrder.setStatus(beforProcess.getExecAgreeStatus());
		loanOrderMapper.updateByPrimaryKey(loanOrder);
		//更新订单过程
		NjOrderUpdateLogMapperExtend orderLogExtendMapper= dao.getMapper(NjOrderUpdateLogMapperExtend.class);
		orderLogExtendMapper.updateLogStatus(orderId, beforProcess.getExecOrders());
		//新增日志
		NjOrderUpdateLogMapper orderLogMapper= dao.getMapper(NjOrderUpdateLogMapper.class);
		NjOrderUpdateLog orderLog = new NjOrderUpdateLog();
		orderLog.setProcessId(EProcessInfo.MODIFY_DATA.getId());
		orderLog.setId(UuidUtil.get32UUID());
		orderLog.setOldStatus(oldStatus);
		orderLog.setOrderId(loanOrder.getOrderNo());
		orderLog.setUpdateDate(new Date());
		orderLog.setUpdateStatus(beforProcess.getExecAgreeStatus());
		orderLog.setUpdateReason("再次申请审批");
		orderLog.setRemark("操作人修改资料后，再次提交申请");
		orderLog.setUserId(userId);
		orderLogMapper.insert(orderLog);
	}

	/**
	 * 批量手动分单
	 * 
	 * @param orderIds
	 * @param users
	 * @return
	 * @throws Exception
	 */
	public void batchManualShunt(List<String> orderIds, String execUserId, List<String> users) throws Exception {
		for (String orderId : orderIds) {
			saveManualShunt(orderId, execUserId, users);
		}
	}
	

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	private void saveManualShunt(String orderId, String execUserId, List<String> users) throws Exception {
		// 查询当前过程
		NjProcessTemplateFlows currentProcess = processMapperExtend.selectProcessTemplateByOrderProcess(orderId,
				EProcessInfo.MANUAL_SHUNT.getId());
		if (currentProcess == null) {
			logger.error("订单:{},没有查询到手动分单过程.");
			throw new Exception("没有查询到手动分单过程");
		}
		// 保存分单信息
		processFlowsService.saveManualShunt(orderId, users);
		// 执行手动分单过程
		manualProcess.execManualProcess(orderId, execUserId, currentProcess, EProcessResult.AGREE, "手动分单成功");
	}
	
	/**
	 * 保存电核记录
	 * @param phoneCheck
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void savePhoneCheck(NjLoanOrderPhoneCheck phoneCheck) throws Exception {
		if(null == phoneCheck.getId() || "".equals(phoneCheck.getId())) {
			phoneCheck.setId(UuidUtil.get32UUID());
			phoneCheckMapper.insert(phoneCheck);
		}else {
			phoneCheckMapper.updateByPrimaryKeySelective(phoneCheck);
		}
		
	}
	/**
	 * 查询电核记录
	 * @param orderId
	 * @return
	 */
	public List<NjLoanOrderPhoneCheck> selectTeleAudit(String orderId) {
		NjLoanOrderPhoneCheckExample example = new NjLoanOrderPhoneCheckExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return phoneCheckMapper.selectByExample(example);
	}
	
	public void saveUserCredit(NjUserCredit userCredit) throws Exception{
		NjUserCredit oldUserCredit = selectUserCreditByOrder(userCredit.getOrderId());
		if(oldUserCredit==null) {
			//新增
			userCredit.setId(UuidUtil.get32UUID());
			userCreditMapper.insert(userCredit);
		}else {
			//更新
			userCredit.setId(oldUserCredit.getId());
			userCreditMapper.updateByPrimaryKey(userCredit);
		}
	}
	public NjUserCredit selectUserCreditByOrder(String orderId) throws Exception{
		NjUserCredit userCredit = null;
		NjUserCreditExample example = new NjUserCreditExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		List<NjUserCredit> list = userCreditMapper.selectByExample(example);
		if(list.size()>0) {
			userCredit = list.get(0);
		}
		return userCredit;
	}

	/**
	 * 获取统计基本信息
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> getStatisticsBase(String companyId) throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		return extend.getStatisticsBase(companyId);
	}

	/**
	 * 获取各类资产统计信息
	 * @param paramMap
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> selectAssetsStatistics(Map<String, Object> paramMap) throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map<String, Object>> listCount = extend.selectCountByProduct(paramMap);
		List<Map<String, Object>> listAmount = extend.selectAmountByProduct(paramMap);
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("listCount", listCount);
		retMap.put("listAmount", listAmount);
		return retMap;
	}

	/**
	 * 获取进件走势统计
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selecIncomingStatistics(Map<String, Object> paramMap) throws Exception {
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		List<Map<String, Object>> listCount = extend.selectCountByDate(paramMap);
		List<Map<String, Object>> listAmount = extend.selectAmountByDate(paramMap);
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("listCount", listCount);
		retMap.put("listAmount", listAmount);
		return retMap;
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void deletePhoneCheck(String id) throws Exception{
		phoneCheckMapper.deleteByPrimaryKey(id);
	}

	public NjLoanOrderPhoneCheck getPhoneCheck(String id) throws Exception {
		return phoneCheckMapper.selectByPrimaryKey(id);
	}
	public  List<NjLoanOrder>  selectByExample(NjLoanOrderExample example){
		List<NjLoanOrder> list = loanOrderMapper.selectByExample(example);
		return  list;
	}

	public PageInfo<Map<String, Object>>  selectByStatus(Map<String, Object> map) {
		String  page  =  (String) map.get("page");
		String  limit  =  (String) map.get("limit");
		if(!StringUtils.isEmpty(page)){
			PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
		}
		List<Map<String, Object>> list = njLoanOrderMapperExtend.selectByStatus(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
		
		return   pageInfo;
	}

	public boolean lendingReviewOrder(PageData pd) throws Exception {
		
			boolean   examineOrder = this.examineOrder(pd);
			 if(examineOrder){
			 //批复期数
			 Integer auditPeriod = pd.getInteger("auditPeriod");
			 //批复金额
			 String auditAmount = pd.getString("auditAmount");
			 //批复月利率
			 String auditRatingMonth  =  pd.getString("auditRatingMonth");
			 BigDecimal  big =  new BigDecimal(auditRatingMonth);
			 BigDecimal auditRating = big.multiply( new  BigDecimal(12) );
			 //批复还款方式
			 String repayWay  =  pd.getString("repayWay");
			 
			Map<String,Object>  map =  new  HashMap<String,Object>();
			map.put("auditPeriod", auditPeriod);
			map.put("auditAmount", auditAmount);
			map.put("auditRating", auditRating);
			map.put("repayWay", repayWay);
			
			String remark2 = JSONUtils.toJSONString(map);
			
			String orderId = pd.getString("orderId");
			//对表nj_loan_order数据写入
			NjLoanOrderExample example  =  new NjLoanOrderExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andIdEqualTo(orderId);
			List<NjLoanOrder> list = loanOrderMapper.selectByExample(example  );
			if(list.size()<=0){
				String  str  = "主键 id："+orderId+"，在表nj_loan_order中找不到对应的记录";
				logger.error(str);
				throw new Exception(str);
			}
			NjLoanOrder njLoanOrder = list.get(0);
			njLoanOrder.setAuditPeriod(auditPeriod);
			njLoanOrder.setAuditAmount(new BigDecimal(auditAmount));
			njLoanOrder.setAuditRating(String.valueOf(auditRating) );
			njLoanOrder.setRepayWay(repayWay);
			loanOrderMapper.updateByPrimaryKey(njLoanOrder);
			
		
			//对nj_ordr_update_log表中数据进行写入
			NjOrderUpdateLogExample nulExample =  new  NjOrderUpdateLogExample();
			com.nj.model.generate.NjOrderUpdateLogExample.Criteria nulCreateCriteria = nulExample.createCriteria();
			nulCreateCriteria.andOrderIdEqualTo("orderId");
			List<NjOrderUpdateLog> nulList = njOrderUpdateLogMapper.selectByExample(nulExample );
			if(list.size()<=0){
				String  str  = "orderId："+orderId+"，在表nj_order_update_log中找不到对应的记录";
				logger.error(str);
				throw new Exception(str);
			}
			NjOrderUpdateLog njOrderUpdateLog = nulList.get(0);
			njOrderUpdateLog.setRemark2(remark2);
			njOrderUpdateLogMapper.updateByPrimaryKey(njOrderUpdateLog);
		 }
		
		return examineOrder;
	}
	
	/**
	 * 流程执行成功后，更新审批意见
	 * @param orderNo 订单编号
	 * @param execUserId 操作人
	 * @param eProcessInfo 当前订单状态
	 * @param remark 审批意见json串
	 * @throws Exception
	 */
	private void updateApprovalOpinion(String orderNo,Integer processId, String remark) throws Exception {
		
		//更新流程日志审批意见
		//根据订单id，操作人，流程id获取流程日志
		NjOrderUpdateLogMapper logMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
		NjOrderUpdateLogExample example = new NjOrderUpdateLogExample();
		example.createCriteria().andOrderIdEqualTo(orderNo).andProcessIdEqualTo(processId);
		example.setOrderByClause("update_date desc");
		List<NjOrderUpdateLog> updateLogs = logMapper.selectByExample(example);
		if(updateLogs != null && updateLogs.size() > 0) {
			NjOrderUpdateLog log = updateLogs.get(0);
			log.setRemark2(remark);
			logMapper.updateByPrimaryKeySelective(log);
		}else {
			throw new Exception("没有查询到订单流程日志信息:orderNo："+orderNo+"，流程id："+processId);
		}
	}
		
}
