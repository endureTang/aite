package com.nj.service.process.shunt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nj.core.base.enums.EProcessInfo;
import com.nj.core.base.util.Const;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjProcessOrderFlowsMapper;
import com.nj.dao.extend.NjOrderProcessMapperExtend;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.model.datamodel.ExamineUserDO;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.model.generate.NjProcessOrderFlowsExample;
import com.nj.model.generate.NjUserInfo;
import com.nj.service.process.IAutoProcess;

/**
 * 
 * @Name com.nj.service.process.shunt.CdjkShunt
 * @Description 成都金坤自动分单
 * 
 * @Author bruce
 * @Version 2018年6月21日 上午10:41:58
 * @Copyright 金鼎财富
 *
 */
@Service("cdjkShunt")
public class CdjkShunt extends BaseShunt implements IAutoProcess{
	
	@Override
	protected List<ExamineUserDO> statShunt(String orderId){
		logger.info("订单：{}，能贷自动分单开始....",orderId);
		List<ExamineUserDO> userDOList = new ArrayList<ExamineUserDO>();
		try {
			NjUserInfoMapperExtend userInfoMapper = dao.getMapper(NjUserInfoMapperExtend.class);
			NjUserInfo user = userInfoMapper.selectUserByOrderId(orderId);
			if(user!=null&&user.getParentId()!=null) {
				ExamineUserDO userDO = new ExamineUserDO();
				userDO.setId(user.getId());
				userDO.setUserName(user.getUserName());
				userDOList.add(userDO);
				ExamineUserDO userDO1 = new ExamineUserDO();
				userDO1.setId(user.getParentId());
				userDO1.setUserName("");
				userDOList.add(userDO1);
			}else {
				logger.info("订单：{},没有找到客户记录和业务经理.",orderId);
				userDOList = null;
			}
			//判断用户同意产品下单金额是否超过100w
			NjLoanOrderMapper loanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
			NjLoanOrder loanOrder = loanOrderMapper.selectByPrimaryKey(orderId);
			NjOrderProcessMapperExtend orderProcessMapperExtend = dao.getMapper(NjOrderProcessMapperExtend.class);
			BigDecimal totalAmount = orderProcessMapperExtend.countAmoutnByInLoan(loanOrder.getUserId(), loanOrder.getProductId());
			//特殊需求，凉山金坤判断金额为50w
			if(loanOrder.getCompanyId().equals("1a1e2a243d304ff6bce0bc17f0512b67")) {
				logger.info("订单：{}，凉山金坤小于50w....,totalAmount:{}",orderId,totalAmount);
				if(totalAmount.compareTo(new BigDecimal("500000"))<=0) {
					//如果金额小于50w，则删除多余复审流程:风控经理审核->总监->董事长（61，62，34）
					logger.info("订单：{}，凉山金坤小于50w，删除多余流程开始",orderId);
					orderProcessMapperExtend.delectProcessFlows(EProcessInfo.MANAGER_REVIEW_CHECK.getId()+","+EProcessInfo.DIRECTOR_REVIEW_CHECK.getId()+","+EProcessInfo.MAKE_LOANS_FOURTH_CHECK.getId(),orderId);
					logger.info("订单：{}，凉山金坤小于50w，删除多余流程结束",orderId);
				}
			}else {
				logger.info("订单：{}，其他金坤小于100w....，totalAmount：{}",orderId,totalAmount);
				if(totalAmount.compareTo(new BigDecimal("1000000"))<=0) {
					//如果金额小于100w，则删除多余复审流程:风控经理审核->总监->董事长（61，62，34）
					logger.info("订单：{}，其他金坤小于100w，删除多余流程开始",orderId);
					orderProcessMapperExtend.delectProcessFlows(EProcessInfo.MANAGER_REVIEW_CHECK.getId()+","+EProcessInfo.DIRECTOR_REVIEW_CHECK.getId()+","+EProcessInfo.MAKE_LOANS_FOURTH_CHECK.getId(),orderId);
					logger.info("订单：{}，其他金坤小于100w，删除多余流程结束",orderId);
				}
			}
		}catch(Exception ex) {
			logger.info("CdjkShunt.statShunt{}",ex);
		}
		return userDOList;
	}
	
	/**
     * 查询订单流程
     *
     * @param orderId
     * @return
     * @throws Exception
     */
	@Override
    protected List<NjProcessOrderFlows> selectProcessByOrder(String orderId) throws Exception {
		Integer[] BUSINESS_ASSIGNMENT= {21,5};//业务指派过程编号
		NjProcessOrderFlowsMapper processOrderMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
        NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andProcessIdIn(Arrays.asList(BUSINESS_ASSIGNMENT));
        example.setOrderByClause(" exec_orders");
        return processOrderMapper.selectByExample(example);
    }
}
