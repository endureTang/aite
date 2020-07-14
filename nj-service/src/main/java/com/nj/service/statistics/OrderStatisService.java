package com.nj.service.statistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.StringUtils;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjLoanOrderExample;
import com.nj.model.generate.NjLoanOrderExample.Criteria;

@Service
@Transactional(readOnly=true)
public class OrderStatisService {

	@Resource(name = "BaseDao")
	protected BaseDao dao;
	
	/**
	 * 统计  进件订单  数量
	 * @param beginDate 进件开始日期，格式为yyyy-MM-dd
	 * @param endDate 进件结束日期，格式为yyyy-MM-dd
	 * @param companyId 企业id
	 * @param productId 产品id
	 */
	public long incomeOrderNum(String beginDate,String endDate,String companyId,String productId) throws Exception{
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		
		NjLoanOrderExample e = new NjLoanOrderExample();
		Criteria c = e.createCriteria();
		if(StringUtils.isNotEmpty(beginDate)){
			c.andCreateDateGreaterThanOrEqualTo(DateUtil.parseDate(beginDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(endDate)){
			c.andCreateDateLessThan(DateUtil.parseDate(endDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(companyId)){
			c.andCompanyIdEqualTo(companyId);
		}
		if(StringUtils.isNotEmpty(productId)){
			c.andProductIdEqualTo(productId);
		}
		
		return mapper.countByExample(e);
	}
	
	/**
	 * 统计 进件订单总金额
	 * @param beginDate 进件开始日期，格式为yyyy-MM-dd
	 * @param endDate 进件结束日期，格式为yyyy-MM-dd
	 * @param companyId 企业id
	 * @param productId 产品id
	 */
	public BigDecimal incomeTotalAmt(String beginDate,String endDate,String companyId,String productId) throws Exception{
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample e = new NjLoanOrderExample();
		Criteria c = e.createCriteria();
		if(StringUtils.isNotEmpty(beginDate)){
			c.andCreateDateGreaterThanOrEqualTo(DateUtil.parseDate(beginDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(endDate)){
			c.andCreateDateLessThan(DateUtil.parseDate(endDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(companyId)){
			c.andCompanyIdEqualTo(companyId);
		}
		if(StringUtils.isNotEmpty(productId)){
			c.andProductIdEqualTo(productId);
		}
		List<NjLoanOrder> list = mapper.selectByExample(e);
		BigDecimal incomeTotalAmt = BigDecimal.ZERO;
		for (NjLoanOrder njLoanOrder : list) {
			incomeTotalAmt = incomeTotalAmt.add(njLoanOrder.getAmount());
		}
		return incomeTotalAmt;
	}
	
	/**
	 * 统计 审批通过订单  数量
	 * @param beginDate 进件开始日期，格式为yyyy-MM-dd
	 * @param endDate 进件结束日期，格式为yyyy-MM-dd
	 * @param companyId 企业id
	 * @param productId 产品id
	 */
	public long auditCrossOrderNum(String beginDate,String endDate,String companyId,String productId) throws Exception{
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		
		NjLoanOrderExample e = new NjLoanOrderExample();
		Criteria c = e.createCriteria();
		if(StringUtils.isNotEmpty(beginDate)){
			c.andCreateDateGreaterThanOrEqualTo(DateUtil.parseDate(beginDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(endDate)){
			c.andCreateDateLessThan(DateUtil.parseDate(endDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(companyId)){
			c.andCompanyIdEqualTo(companyId);
		}
		if(StringUtils.isNotEmpty(productId)){
			c.andProductIdEqualTo(productId);
		}
		
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(ELoanOrderStatus.LAST_CHECK_SUCCESS.getValue());
		statusList.add(ELoanOrderStatus.CREATE_CONTRACT.getValue());
		statusList.add(ELoanOrderStatus.CONTRACT_CHECK_SUCCESS.getValue());
		statusList.add(ELoanOrderStatus.USER_CONFIRM.getValue());
		statusList.add(ELoanOrderStatus.USER_REFUSE.getValue());
		statusList.add(ELoanOrderStatus.BUILD_CORPORE.getValue());
		statusList.add(ELoanOrderStatus.FUNDRAISING_SUCCESS.getValue());
		statusList.add(ELoanOrderStatus.FUNDRAISING_FAIL.getValue());
		statusList.add(ELoanOrderStatus.START_LENDING.getValue());
		statusList.add(ELoanOrderStatus.FIRST_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.SECOND_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.THIRD_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.FOURTH_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.FIFTH_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.SIXTH_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.SEVENTH_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.REPAYMENT_PLAN_FINISH.getValue());
		statusList.add(ELoanOrderStatus.MAKE_LOANS.getValue());
		statusList.add(ELoanOrderStatus.OVERDUE.getValue());
		statusList.add(ELoanOrderStatus.REPAYMENT.getValue());
		c.andStatusIn(statusList);
		
		return mapper.countByExample(e);
	}
	
	/**
	 * 统计 审批通过订单的批复 总金额
	 * @param beginDate 进件开始日期，格式为yyyy-MM-dd
	 * @param endDate 进件结束日期，格式为yyyy-MM-dd
	 * @param companyId 企业id
	 * @param productId 产品id
	 */
	public BigDecimal auditCrossTotalAmt(String beginDate,String endDate,String companyId,String productId) throws Exception{
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		
		NjLoanOrderExample e = new NjLoanOrderExample();
		Criteria c = e.createCriteria();
		if(StringUtils.isNotEmpty(beginDate)){
			c.andCreateDateGreaterThanOrEqualTo(DateUtil.parseDate(beginDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(endDate)){
			c.andCreateDateLessThan(DateUtil.parseDate(endDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(companyId)){
			c.andCompanyIdEqualTo(companyId);
		}
		if(StringUtils.isNotEmpty(productId)){
			c.andProductIdEqualTo(productId);
		}
		
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(ELoanOrderStatus.LAST_CHECK_SUCCESS.getValue());
		statusList.add(ELoanOrderStatus.CREATE_CONTRACT.getValue());
		statusList.add(ELoanOrderStatus.CONTRACT_CHECK_SUCCESS.getValue());
		statusList.add(ELoanOrderStatus.USER_CONFIRM.getValue());
		statusList.add(ELoanOrderStatus.USER_REFUSE.getValue());
		statusList.add(ELoanOrderStatus.BUILD_CORPORE.getValue());
		statusList.add(ELoanOrderStatus.FUNDRAISING_SUCCESS.getValue());
		statusList.add(ELoanOrderStatus.FUNDRAISING_FAIL.getValue());
		statusList.add(ELoanOrderStatus.START_LENDING.getValue());
		statusList.add(ELoanOrderStatus.FIRST_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.SECOND_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.THIRD_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.FOURTH_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.FIFTH_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.SIXTH_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.SEVENTH_CHECK_LENDING.getValue());
		statusList.add(ELoanOrderStatus.REPAYMENT_PLAN_FINISH.getValue());
		statusList.add(ELoanOrderStatus.MAKE_LOANS.getValue());
		statusList.add(ELoanOrderStatus.OVERDUE.getValue());
		statusList.add(ELoanOrderStatus.REPAYMENT.getValue());
		c.andStatusIn(statusList);
		
		List<NjLoanOrder> list = mapper.selectByExample(e);
		BigDecimal auditCrossTotalAmt = BigDecimal.ZERO;
		for (NjLoanOrder njLoanOrder : list) {
			auditCrossTotalAmt = auditCrossTotalAmt.add(njLoanOrder.getAuditAmount());
		}
		return auditCrossTotalAmt;
	}
	
	/**
	 * 新增放款金额
	 * @param beginDate 进件开始日期，格式为yyyy-MM-dd
	 * @param endDate 进件结束日期，格式为yyyy-MM-dd
	 * @param companyId 企业id
	 * @param productId 产品id
	 */
	public BigDecimal newAddMakeLoanAmt(String beginDate,String endDate,String companyId,String productId) throws Exception{
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		
		NjLoanOrderExample e = new NjLoanOrderExample();
		Criteria c = e.createCriteria();
		if(StringUtils.isNotEmpty(beginDate)){
			c.andMakeLoansDateGreaterThanOrEqualTo(DateUtil.parseDate(beginDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(endDate)){
			c.andMakeLoansDateLessThan(DateUtil.parseDate(endDate, "yyyy-MM-dd"));
		}
		if(StringUtils.isNotEmpty(companyId)){
			c.andCompanyIdEqualTo(companyId);
		}
		if(StringUtils.isNotEmpty(productId)){
			c.andProductIdEqualTo(productId);
		}
		List<NjLoanOrder> list = mapper.selectByExample(e);
		BigDecimal newAddMakeLoanAmt = BigDecimal.ZERO;
		for (NjLoanOrder njLoanOrder : list) {
			newAddMakeLoanAmt = newAddMakeLoanAmt.add(njLoanOrder.getActualAmount());
		}
		return newAddMakeLoanAmt;
	}
	
	/**
	 * 查询企业下所有订单
	 */
	public List<NjLoanOrder> getOrderByCoporateId(String coporateId) throws Exception{
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrderExample ex = new NjLoanOrderExample();
		ex.createCriteria().andCompanyIdEqualTo(coporateId);
		return mapper.selectByExample(ex);
	}
}
