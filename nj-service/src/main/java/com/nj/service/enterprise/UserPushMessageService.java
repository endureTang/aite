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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.common.Constants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.DateUtil;
import com.nj.dao.NjUserPushMessageMapper;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjUserDebtMessageRecord;
import com.nj.model.generate.NjUserPushMessage;
import com.nj.service.itf.AppUserService;

@Transactional
@Service("userPushMessageService")
public class UserPushMessageService {
	
	@Resource(name = "debtTransMessageService")
	DebtTransMessageService debtTransMessageService;
	
	@Resource(name = "orderService")
	OrderService orderService;
	
	@Resource(name = "coporateService")
	CoporateService coporateService;
	
	@Resource(name = "itfAppUserService")
	AppUserService appUserService;

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insert(NjUserDebtMessageRecord njUserDebtMessageRecord) throws Exception {
		
		//获取订单最新一次债转信息
		NjUserDebtMessageRecord debtMessageRecord = debtTransMessageService.selectLastMsgByOrderNo(njUserDebtMessageRecord.getOrderNo());
		//获取订单信息
		NjLoanOrder order = orderService.getOrderByOrderNo(njUserDebtMessageRecord.getOrderNo());
		//获取企业信息
		NjCoporate coporate = coporateService.getCoporateById(order.getCompanyId());
		//获取用户信息
		NjAppUser njAppUser = appUserService.getAppUser(order.getUserId());
		NjUserPushMessage message = new NjUserPushMessage();
		message.setPushId(order.getCompanyId());
		message.setReceiveId(order.getUserId());
		message.setPushName(coporate.getCompanName());
		message.setReceiveName(njAppUser.getMobile());
		message.setTitle(Constants.PUSHMESSAGE.transTitle);
		message.setContent(Constants.PUSHMESSAGE.transContentPartOne+debtMessageRecord.getTransDate()+Constants.PUSHMESSAGE.transContentPartTwo+"("+DateUtil.formatDate(debtMessageRecord.getTransDate())+")");
		message.setPushDate(debtMessageRecord.getTransDate());
		message.setIsRead(0);
		message.setDelFlag(0);
		message.setType(1);
		//保存债转通知信息
		NjUserPushMessageMapper mapper = dao.getMapper(NjUserPushMessageMapper.class);
		mapper.insertSelective(message);
		//清理债转记录
		debtTransMessageService.deleteByOrderNo(njUserDebtMessageRecord.getOrderNo());
	}

}
