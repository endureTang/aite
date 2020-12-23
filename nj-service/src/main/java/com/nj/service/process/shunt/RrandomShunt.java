package com.nj.service.process.shunt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.nj.core.base.common.Constants;
import com.nj.core.base.enums.EProcessResult;
import com.nj.core.base.enums.ERoleType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nj.core.base.util.Const;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.PageData;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjProcessMapperExtend;
import com.nj.model.datamodel.ExamineUserDO;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.service.process.IAutoProcess;

import javax.annotation.Resource;

/**
 * 
 * @Name com.nj.service.process.RrandomShunt
 * @Description 随机分配
 * 
 * @Author bruce
 * @Version 2018年2月8日 下午3:43:47
 * @Copyright 金鼎财富
 *
 */
@Service("rrandomShunt")
public class RrandomShunt extends BaseShunt implements IAutoProcess{
	@Resource
	NjProcessMapperExtend njProcessMapperExtend;
	@Resource
	NjLoanOrderMapperExtend loanOrderMapperExtend;
	
	/**
	 * 统计派单情况
	 * @return
	 */
	@Override
	protected List<ExamineUserDO> statShunt(String orderId){
		List<ExamineUserDO> userDOList = new ArrayList();
		NjLoanOrder order = orderMapper.selectByPrimaryKey(orderId);
		String[] productIds = {order.getProductId()};
		PageData pd = new PageData();
		pd.put("productIds", Arrays.asList(productIds));
		pd.put("companyId", Constants.DEFAULT_COMPANY_ID);
		pd.put("roleType", ERoleType.RISKCONTROLCOMMISSIONER.getValue());
		List<Map> result = loanOrderMapperExtend.selectDispatchUserListByProductIdIds(pd);
		for(Map map:result) {
			ExamineUserDO userDO = new ExamineUserDO();
			userDO.setId(map.get("user_id").toString());
			userDO.setUserName(map.get("user_name").toString());
			userDOList.add(userDO);
		}
		return userDOList;
	}
	/**
	 * 订单流程分配
	 * @return
	 * @throws Exception 
	 */
	@Override
	protected List<NjProcessOrderFlows> allotProcess(String orderId,List<NjProcessOrderFlows> processList,List<ExamineUserDO> userList) {
		
		List<NjProcessOrderFlows> processAllowList = new ArrayList<NjProcessOrderFlows>();
		int i=0;
		for(NjProcessOrderFlows process:processList) {
			if(Arrays.asList(Const.MANUAL_CHECK).contains(process.getProcessId())) {
				NjProcessOrderFlows processAllow = new NjProcessOrderFlows();
				processAllow.setOrderId(orderId);
				processAllow.setProcessId(process.getProcessId());
				ExamineUserDO userDO = getRandomUser(userList);
				if(userDO==null) {
					logger.error("审批人员人数,少于手动过程数量,自动分单失败,进行手动分单");
					return null;
				}
				processAllow.setUserId(userDO.getId());
				processAllowList.add(processAllow);
			}
		}
		return processAllowList;
	}
	/**
	 * 使用随机数选择用户
	 * @param userList
	 * @return
	 */
	private ExamineUserDO getRandomUser(List<ExamineUserDO> userList) {
		Random random = new Random();
		if(userList.size()<1) {
			return null;
		}
		int index = random.nextInt(userList.size());
		ExamineUserDO userDO = userList.get(index);
		userList.remove(index);
		logger.debug("随机选择:{}",userDO.getUserName());
		return userDO;
				
	}

}
