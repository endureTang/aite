package com.nj.service.enterprise;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.fee.constant.EBusinessFee;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.NjStatisticsOrderMapper;
import com.nj.dao.NjStatisticsOverdayMapper;
import com.nj.dao.NjStatisticsReturnMoneyMapper;
import com.nj.dao.NjStatisticsSummaryMapper;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.model.generate.NjLoanOrderExample;
import com.nj.model.generate.NjLoanOrderExample.Criteria;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductExample;
import com.nj.model.generate.NjStatisticsOrder;
import com.nj.model.generate.NjStatisticsOrderExample;
import com.nj.model.generate.NjStatisticsOverday;
import com.nj.model.generate.NjStatisticsOverdayExample;
import com.nj.model.generate.NjStatisticsReturnMoney;
import com.nj.model.generate.NjStatisticsReturnMoneyExample;
import com.nj.model.generate.NjStatisticsSummary;
import com.nj.model.generate.NjStatisticsSummaryExample;
import com.nj.mongoModel.RepayPlan;
import com.nj.mongoModel.after.RepayPlanDetaileNew;
import com.nj.mongoModel.after.RepayPlanNew;
import com.nj.service.remoteing.RepayPlanNewService;



/**
 * 订单统计service
 */
@Service("orderStatisticService")
@Transactional(readOnly=true)
public class OrderStatisticService {
	
	private Logger logger = LoggerFactory.getLogger(OrderStatisticService.class);
	
	@Autowired
	private NjLoanOrderMapper njLoanOrderMapper;
	@Autowired
	private NjLoanOrderMapperExtend njLoanOrderMapperExtend;
	@Autowired
	private NjStatisticsOrderMapper njStatisticsOrderMapper;
	@Autowired
	private RepayPlanNewService repayPlanNewService;
	@Autowired
	private NjStatisticsReturnMoneyMapper njStatisticsReturnMoneyMapper;
	@Autowired
	private NjProductMapper njProductMapper;
	@Autowired
	private NjStatisticsOverdayMapper njStatisticsOverdayMapper;
	@Autowired
	private NjStatisticsSummaryMapper njStatisticsSummaryMapper;

	/**
	 * 获取今日进件数量
	 */
	public Long getEntryOrderNumForToday(String coporateId,List<String> productIds){
		
		NjLoanOrderExample example = new NjLoanOrderExample();
		Criteria c = example.createCriteria();
		c.andCreateDateBetween(DateUtil.getBeginDateForDay(new Date()), DateUtil.getEndDateForDay(new Date()));
		c.andDelFlagEqualTo(false);
		if (StringUtils.isNotEmpty(coporateId)) {
			c.andCompanyIdEqualTo(coporateId);
		}
		if(!CollectionUtils.isEmpty(productIds)){
			c.andProductIdIn(productIds);
		}
		
		return Long.parseLong(njLoanOrderMapper.countByExample(example)+"");
	}
	
	/**
	 * 获取今日审批通过的订单数量
	 */
	public Long getAuditPassOrderNumForToday(String coporateId,List<String> productIds){
		return njLoanOrderMapperExtend.getAuditPassOrderNumForToday(coporateId, productIds);
	}
	
	/**
	 * 获取时间区间内的统计数据和：进件数和、通过数和
	 * 统计表中的数据由于跑批时间问题，并不包含当天的数据
	 */
	public Long[] getEntryOrderStatisForDateSection(String beginDate,String endDate,String coporateId,List<String> productIds){
		
		List<NjStatisticsOrder> list = getStatisticsOrderByDateSection(beginDate, endDate,coporateId,productIds);
		
		Long curEntryOrderNum = 0l;				//进件数
		Long curAuditPassOrderNum = 0l;			//审核通过数
		for (NjStatisticsOrder statisOrder : list) {
			curEntryOrderNum += Long.valueOf(statisOrder.getOrderNum()).longValue();
			curAuditPassOrderNum += Long.valueOf(statisOrder.getPassNum()).longValue();
		}
		
		Long[] result = new Long[2];
		result[0] = curEntryOrderNum;
		result[1] = curAuditPassOrderNum;
		
		return result;
	}
	
	/**
	 * 获取今日放款金额
	 */
	public BigDecimal getMakeLoanAmtForToday(String coporateId,List<String> productIds){
		return njLoanOrderMapperExtend.getMakeLoanAmtForToday(coporateId, productIds);
	}
	
	/**
	 * 获取时间区间内的统计数据和：放款金额
	 * 统计表中的数据由于跑批时间问题，并不包含当天的数据
	 */
	public BigDecimal getMakeLoanAmtForDateSection(String beginDate,String endDate,String coporateId,List<String> productIds){
		
		List<NjStatisticsOrder> list = getStatisticsOrderByDateSection(beginDate, endDate,coporateId,productIds);
		
		BigDecimal makeLoanAmt = BigDecimal.ZERO;				//放款金额总额
		for (NjStatisticsOrder statisOrder : list) {
			makeLoanAmt = makeLoanAmt.add(statisOrder.getLoanAmount());
		}
		
		return makeLoanAmt;
	}
	
	/**
	 * 获取最新的放款金额分布统计
	 */
	public NjStatisticsSummary getNewestByCoporateId(String coporateId){
		NjStatisticsSummaryExample example = new NjStatisticsSummaryExample();
		example.createCriteria().andCompanIdEqualTo(coporateId);
		example.setOrderByClause("due_date desc");
		List<NjStatisticsSummary> list = njStatisticsSummaryMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 回款统计（数据生成和入库）
	 * 包含开始日期和结束日期
	 * 传入年月日即可。如：2018-11-11
	 */
	@Transactional(readOnly=false,rollbackFor={Throwable.class})
	public void returnMoneyStatis(Date beginDate,Date endDate){
		
		//若该时间段已存在的数据，删除
		NjStatisticsReturnMoneyExample example = new NjStatisticsReturnMoneyExample();
		example.createCriteria().andDateBetween(DateUtil.formatDateToDate(beginDate, "yyyy-MM-dd"), DateUtil.formatDateToDate(endDate, "yyyy-MM-dd"));
		njStatisticsReturnMoneyMapper.deleteByExample(example);
		
		//查询数据，若发生异常，则抛出异常回滚，若正常取得数据，则插入数据
		try {
			Integer dayNum = DateUtil.daysBetween(beginDate, endDate);
			for (int i = 0; i <= dayNum; i++) {		//循环，一天一天处理
				returnMoneyStatisForDay(beginDate, i);
			}
		} catch (Exception e) {
			logger.error("调用贷后接口getRepayPlanByActualRepayDateSection()发生异常:",e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 某天逾期统计（数据生成和入库）
	 * @param date 统计日期
	 */
	@Transactional(readOnly=false,rollbackFor={Throwable.class})
	public void overdayStatis(Date date){
		logger.info("overdayStatis()参数date="+date);
		
		Date beginDate = DateUtil.formatDateToDate(date, "yyyy-MM-dd");
		Date endDate = beginDate;
		
		//若数据已存在，则删除
		NjStatisticsOverdayExample example = new NjStatisticsOverdayExample();
		example.createCriteria().andDateBetween(beginDate, endDate);
		njStatisticsOverdayMapper.deleteByExample(example);
		
		//查询数据，若发生异常，则抛出异常回滚，若正常取得数据，则插入数据
		Map<String, String> param = new HashMap<String,String>();
		param.put("businessBeginDate", DateUtil.formatDate(date, "yyyy-MM-dd"));
		param.put("businessEndDate", DateUtil.formatDate(date, "yyyy-MM-dd"));
		
		ResponseDto<List<NjStatisticsOverday>> overdayResDto = repayPlanNewService.getOverdayStatis(JSONObject.toJSONString(param));
		if(overdayResDto.getReturnCode() != 0){
			logger.error("获取逾期统计数据getOverdayStatis（）失败：",overdayResDto.getReturnMsg());
			throw new RuntimeException(overdayResDto.getReturnMsg());
		}
		
		List<NjStatisticsOverday> dataList = overdayResDto.getResult();
		logger.info("获取NjStatisticsOverday的数据条数：" + dataList.size());
		for (NjStatisticsOverday njStatisticsOverday : dataList) {
			njStatisticsOverdayMapper.insert(njStatisticsOverday);
		}
	}

	/**
	 * 为某天统计所有回款数据并入库
	 * 有回款的企业或产品，统计表才会插入数据。没有回款的企业或产品，数据库中不会插入数据。
	 * @param beginDate
	 * @param i 当i=0时，处理开始日期那天，等于1时开始日期的下一天
	 */
	@Transactional(readOnly=false,rollbackFor={Throwable.class})
	private void returnMoneyStatisForDay(Date beginDate, int i){
		Map<String, String> param = new HashMap<String, String>();
		param.put("beginDate", DateUtil.formatDate(DateUtil.getAfterDate(beginDate, Calendar.DAY_OF_MONTH, i), "yyyy-MM-dd"));
		param.put("endDate", DateUtil.formatDate(DateUtil.getAfterDate(beginDate, Calendar.DAY_OF_MONTH, i), "yyyy-MM-dd"));
		
		ResponseDto<List<RepayPlanNew>> rpListResult = repayPlanNewService.getRepayPlanByActualRepayDateSection(JSONObject.toJSONString(param));
		if(rpListResult.getReturnCode() != 0){		//获取某天有回款的还款计划失败
			throw new RuntimeException(rpListResult.getReturnMsg());
		}
		
		List<RepayPlanNew> rpList = rpListResult.getResult();
		if(!CollectionUtils.isEmpty(rpList)){
			
			// 从企业和产品作为key,回款总金额作为value，生成map
			Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
			for (RepayPlanNew repayPlan : rpList) {
				String mapKey = repayPlan.getCoporateId()+"-"+repayPlan.getProductId();
				BigDecimal returnMoney = map.get(mapKey);
				if(null == returnMoney){
					returnMoney = BigDecimal.ZERO;
				}
				
				BigDecimal accRepayAmt = BigDecimal.ZERO;
				List<RepayPlanDetaileNew> rpdList = repayPlan.getListRepayPlanDetaileNew();
				for (RepayPlanDetaileNew repayPlanDetaileNew : rpdList) {
					if(EBusinessFee.isAcc(repayPlanDetaileNew.getBusinessFeeCode())){
						accRepayAmt = accRepayAmt.add(repayPlanDetaileNew.getBusinessFeeValue());
					}
				}
				
				returnMoney = returnMoney.add(accRepayAmt);
				
				map.put(mapKey, returnMoney);
			}
			
			// 所有产品的map<code,id>，用于根据code查询id，保存在回款统计表中
			NjProductExample pex = new NjProductExample();
			pex.createCriteria().andDelFlagEqualTo(false);
			List<NjProduct> pList = njProductMapper.selectByExample(pex);
			Map<String, String> pMap = new HashMap<String, String>();		//<code,id>
			for (NjProduct njProduct : pList) {
				pMap.put(njProduct.getProductCode(), njProduct.getId());
			}
			
			// 用上面的2个map，生成回款统计表数据，并入库
			for (java.util.Map.Entry<String, BigDecimal> entry : map.entrySet()) {
				NjStatisticsReturnMoney returnMoney = new NjStatisticsReturnMoney();
				returnMoney.setId(UuidUtil.get32UUID());
				returnMoney.setDate(DateUtil.formatDateToDate(DateUtil.getAfterDate(beginDate, Calendar.DAY_OF_MONTH, i), "yyyy-MM-dd"));
				String[] keyArr = entry.getKey().split("-");
				returnMoney.setCompanyId(keyArr[0]);
				returnMoney.setProductId(pMap.get(keyArr[1]));
				returnMoney.setReturnAmt(entry.getValue());
				
				njStatisticsReturnMoneyMapper.insert(returnMoney);
			}
		}
	}
	
	/**
	 * 获取今日的回款金额
	 */
	public BigDecimal getReturnMoneyAmtForToday(String coporateId){
		Map<String, String> param = new HashMap<String, String>();
		param.put("beginDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
		param.put("endDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
		if(StringUtils.isNotEmpty(coporateId)){
			param.put("coporateId", coporateId);		
		}
		
		ResponseDto<List<RepayPlanNew>> rpListResult = repayPlanNewService.getRepayPlanByActualRepayDateSection(JSONObject.toJSONString(param));
		if(rpListResult.getReturnCode() != 0){
			return null;
		}

		BigDecimal returnMoney = BigDecimal.ZERO;
		
		List<RepayPlanNew> data = rpListResult.getResult();
		if(!CollectionUtils.isEmpty(data)){
			for (RepayPlanNew repayPlan : data) {
				List<RepayPlanDetaileNew> rpdList = repayPlan.getListRepayPlanDetaileNew();
				for (RepayPlanDetaileNew repayPlanDetaileNew : rpdList) {
					if(EBusinessFee.isAcc(repayPlanDetaileNew.getBusinessFeeCode())){
						returnMoney = returnMoney.add(repayPlanDetaileNew.getBusinessFeeValue());
					}
				}
			}
		}
		
		return returnMoney;
	}
	
	/**
	 * 获取时间区间内的统计数据和：回款金额
	 * 统计表中的数据由于跑批时间问题，并不包含当天的数据
	 */
	public BigDecimal getReturnMoneyAmtForDateSection(String beginDate,String endDate,String coporateId,List<String> productIds){
		
		List<NjStatisticsReturnMoney> list = getStatisReturnMoneyByDateSection(beginDate, endDate,coporateId,productIds);
		
		BigDecimal returnMoneyAmt = BigDecimal.ZERO;				//回款金额总额
		for (NjStatisticsReturnMoney returnMoney : list) {
			BigDecimal returnM = returnMoney.getReturnAmt();
			returnMoneyAmt = returnMoneyAmt.add(null==returnM?BigDecimal.ZERO:returnM);
		}
		
		return returnMoneyAmt;
	}
	
	
	
	/**
	 * 通过时间区间获取统计订单数据
	 * 时间区间包括开始日期和结束日期
	 */
	public List<NjStatisticsOrder> getStatisticsOrderByDateSection(String beginDate,String endDate,String coporateId,List<String> productIds){
		NjStatisticsOrderExample example = new NjStatisticsOrderExample();
		com.nj.model.generate.NjStatisticsOrderExample.Criteria c = example.createCriteria();
		c.andTimeBetween(beginDate, endDate);
		if (StringUtils.isNotEmpty(coporateId)) {
			c.andCompanyIdEqualTo(coporateId);
		}
		if(!CollectionUtils.isEmpty(productIds)){
			c.andProductIdIn(productIds);
		}
		return njStatisticsOrderMapper.selectByExample(example);
	}
	
	/**
	 * 通过时间区间获取统计回款数据
	 * 时间区间包括开始日期和结束日期
	 */
	public List<NjStatisticsReturnMoney> getStatisReturnMoneyByDateSection(String beginDate,String endDate,String coporateId,List<String> productIds){
		NjStatisticsReturnMoneyExample example = new NjStatisticsReturnMoneyExample();
		com.nj.model.generate.NjStatisticsReturnMoneyExample.Criteria c = example.createCriteria();
		c.andDateBetween(DateUtil.parseDate(beginDate, "yyyy-MM-dd"), DateUtil.parseDate(endDate, "yyyy-MM-dd"));
		if (StringUtils.isNotEmpty(coporateId)) {
			c.andCompanyIdEqualTo(coporateId);
		}
		if(!CollectionUtils.isEmpty(productIds)){
			c.andProductIdIn(productIds);
		}
		return njStatisticsReturnMoneyMapper.selectByExample(example);
	}
	
	/**
	 * 通过时间区间获取逾期统计数据
	 * 时间区间包括开始日期和结束日期
	 */
	public List<NjStatisticsOverday> getStatisOverdayByDateSection(String beginDate,String endDate,String coporateId,List<String> productIds){
		NjStatisticsOverdayExample example = new NjStatisticsOverdayExample();
		com.nj.model.generate.NjStatisticsOverdayExample.Criteria c = example.createCriteria();
		c.andDateBetween(DateUtil.parseDate(beginDate, "yyyy-MM-dd"), DateUtil.parseDate(endDate, "yyyy-MM-dd"));
		if (StringUtils.isNotEmpty(coporateId)) {
			c.andCompanyIdEqualTo(coporateId);
		}
		if(!CollectionUtils.isEmpty(productIds)){
			c.andProductIdIn(productIds);
		}
		return njStatisticsOverdayMapper.selectByExample(example);
	}
	

	/**
	 * 通过时间集合获取逾期统计数据
	 */
	public List<NjStatisticsOverday> getStatisOverdayByDateList(List<Date> dateList,String coporateId,List<String> productIds){
		NjStatisticsOverdayExample example = new NjStatisticsOverdayExample();
		com.nj.model.generate.NjStatisticsOverdayExample.Criteria c = example.createCriteria();
		c.andDateIn(dateList);
		if (StringUtils.isNotEmpty(coporateId)) {
			c.andCompanyIdEqualTo(coporateId);
		}
		if(!CollectionUtils.isEmpty(productIds)){
			c.andProductIdIn(productIds);
		}
		return njStatisticsOverdayMapper.selectByExample(example);
	}
}
