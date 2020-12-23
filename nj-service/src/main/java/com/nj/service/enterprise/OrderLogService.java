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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.dao.NjLoanOrderCapitalChannelMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjOrderFeeMapper;
import com.nj.dao.NjOrderUpdateLogMapper;
import com.nj.dao.extend.NjLoanOrderCapitalChannelMapperExtend;
import com.nj.dao.extend.NjOrderFeeMapperExtend;
import com.nj.dao.extend.NjOrderUpdateLogMapperExtend;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjLoanOrderCapitalChannel;
import com.nj.model.generate.NjLoanOrderCapitalChannelExample;
import com.nj.model.generate.NjLoanOrderExample;
import com.nj.model.generate.NjOrderFee;
import com.nj.model.generate.NjOrderFeeExample;
import com.nj.model.generate.NjOrderUpdateLog;
import com.nj.model.generate.NjOrderUpdateLogExample;
import com.nj.model.vo.OrderUpdateLogVO;

@Transactional(readOnly = true)
@Service("orderLogService")
public class OrderLogService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	@Resource
	private NjOrderUpdateLogMapperExtend orderUpdateLogMapperExtend;
	
	@Resource
	private NjLoanOrderCapitalChannelMapper  njLoanOrderCapitalChannelMapper;
	
	@Resource
	private LoanService loanService;
	@Resource
	private NjLoanOrderCapitalChannelMapperExtend  njLoanOrderCapitalChannelMapperExtend;
	@Resource
	NjLoanOrderMapper loanOrderMapper;
	@Resource
	private NjOrderFeeMapperExtend njOrderFeeMapperExtend;
	@Resource
	private NjOrderFeeMapper njOrderFeeMapper;

	@SuppressWarnings("rawtypes")
	private static Logger logger = LoggerFactory.getLogger(OrderLogService.class);
	

	

	public List<OrderUpdateLogVO> listOrderLogInfo(String orderNo) throws Exception {
		NjOrderUpdateLogMapperExtend mapper = dao.getMapper(NjOrderUpdateLogMapperExtend.class);
		return mapper.selectLogByOrderNo(orderNo);
	}
	
	public List<Map<String,Object>> getProcessListByOrderId(String orderId) throws Exception {
		Map<String,Object>  map  =  new  HashMap<String,Object>();
		map.put("orderId", orderId);
	
		List<Map<String, Object>> retMap = orderUpdateLogMapperExtend.getProcessListByOrderId(map);
		return  retMap;
		
	}

	public List<Map<String,Object>> getProductPeriods(Map<String, Object> queryMap) {
		List<Map<String,Object>>  list = orderUpdateLogMapperExtend.getProductPeriods(queryMap);
		return  list;
		
	}
	
	public List<NjOrderUpdateLog> getList(Map<String, Object> queryMap) throws Exception{
		NjOrderUpdateLogMapper mapper = dao.getMapper(NjOrderUpdateLogMapper.class);
		NjOrderUpdateLogExample example = new NjOrderUpdateLogExample();
		example.setOrderByClause("update_date desc");
		com.nj.model.generate.NjOrderUpdateLogExample.Criteria c = example.createCriteria();
		
		Object orderNo = queryMap.get("orderNo");
		if(null != orderNo && StringUtils.isNotEmpty(orderNo.toString())){
			c.andOrderIdEqualTo(orderNo.toString());
		}
		
		Object processId = queryMap.get("processId");
		if(null != processId){
			c.andProcessIdEqualTo((int)processId);
		}
		
		return mapper.selectByExample(example);
	}
	
	public List<NjLoanOrderCapitalChannel> getCapticalChannelList(NjLoanOrderCapitalChannelExample example) throws Exception {
	
		List<NjLoanOrderCapitalChannel> list = njLoanOrderCapitalChannelMapper.selectByExample(example);
		
		return  list;
		
	}
	
	public List<Map<String,Object>> getCapticalChannelListByOrderId(String orderId) throws Exception {
		Map<String,Object>  map  =  new  HashMap<String,Object>();
		map.put("orderId", orderId);
	
		List<Map<String, Object>> retMap = orderUpdateLogMapperExtend.getCapticalChannelListByOrderId(map);
		return  retMap;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public boolean lendingReviewexamineOrder(PageData pd) throws Exception {
		String orderId = pd.getString("orderId");
		NjOrderFeeExample example =  new NjOrderFeeExample() ;
		example.createCriteria().andOrderIdEqualTo(orderId);
		njOrderFeeMapper.deleteByExample(example );
		
		NjLoanOrderCapitalChannelExample ex  =  new  NjLoanOrderCapitalChannelExample();
		ex.createCriteria().andOrderIdEqualTo(orderId);
		njLoanOrderCapitalChannelMapper.deleteByExample(ex);
		
		List<NjLoanOrderCapitalChannel>  capitalChannelList= (List<NjLoanOrderCapitalChannel>) pd.get("capitalChannelList");
		List<NjOrderFee>  orderFeeList= (List<NjOrderFee>) pd.get("orderFeeList");
		if(capitalChannelList!=null&&capitalChannelList.size()>0){
			njLoanOrderCapitalChannelMapperExtend.insertBathCapitalChannel(capitalChannelList);
		}
		if(orderFeeList!=null&&orderFeeList.size()>0){
			njOrderFeeMapperExtend.insertOrderFee(orderFeeList);
		}
		
		
		NjLoanOrder record  =  new NjLoanOrder();
		BigDecimal  actualAmount =new BigDecimal(pd.getString("actualAmount"));
		record.setActualAmount(actualAmount);
		
		
		NjLoanOrderExample recordExample =  new  NjLoanOrderExample();
		recordExample.createCriteria().andIdEqualTo(orderId);
		loanOrderMapper.updateByExampleSelective(record,recordExample );

		
		
		boolean flag = loanService.examineOrder(pd);
		return  flag;
	}


	@Transactional
	public boolean toAutoPay(PageData pd,NjLoanOrder loanOrder,NjLoanOrderExample example) throws Exception {
		boolean flag =  false;
		
		loanOrderMapper.updateByExampleSelective(loanOrder, example );
		
		boolean isOnliePayed = null ==loanOrder.getIsCompanyPayed()?false:loanOrder.getIsCompanyPayed();
		Boolean isOfflinePayed = null==loanOrder.getIsCapitalChannelPayed()?false:loanOrder.getIsCapitalChannelPayed();
		if(  true== isOnliePayed  &&  true==isOfflinePayed ){
				flag =	loanService.examineOrder(pd);
				if(!flag){
					String msg = "orderNo="+loanOrder.getOrderNo()+"-->放款流程跳转失败！";
					logger.error(msg);
					throw  new Exception(msg);
				}
		}else{
			
			flag =  true;
		}
		
		return flag;
	}

	public List<Map<String, Object>> getProductFeeListByOrderId(String orderId) {
		Map<String,Object>  map  =  new  HashMap<String,Object>();
		map.put("orderId", orderId);
	
		List<Map<String, Object>> retMap = orderUpdateLogMapperExtend.getOrderFeeListByOrderId(map);
		return  retMap;
	}
	
	public List<Map<String,Object>> getCapticalChannelId(String orderId) throws Exception {
		Map<String,Object>  map  =  new  HashMap<String,Object>();
		map.put("orderId", orderId);
	
		List<Map<String, Object>> retMap = orderUpdateLogMapperExtend.getCapticalChannelId(map);
		return  retMap;
		
	}
	


	
}
