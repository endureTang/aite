package com.nj.service.enterprise;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nj.dao.NjLoanOrderCheckRecordMapper;
import com.nj.dao.extend.NjProcessMapperExtend;
import com.nj.model.generate.NjLoanOrderCheckRecord;
import com.nj.model.generate.NjLoanOrderCheckRecordExample;

/**
 * 
 * @Name com.nj.service.enterprise.AfterLoanOrderService
 * @Description 贷后订服务类
 * 
 * @Author bruce
 * @Version 2018年3月26日 下午5:15:19
 * @Copyright 金鼎财富
 *
 */
@Service
public class AfterLoanOrderService {
	
	@Autowired
	NjProcessMapperExtend processMapperExtend;
	/**
	 * 获取贷后人工核查信息
	 * @param orderId
	 * @return
	 */
	public Map<String,String> getCheckRecord(String orderId) {
		Map<String,String> loanOrderCheckRecord = processMapperExtend.selectCheckRecord(orderId, 21);
		return loanOrderCheckRecord;
	}
}
