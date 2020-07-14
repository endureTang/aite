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

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjUserDebtMessageRecordMapper;
import com.nj.dao.extend.NjUserDebtMessageRecordMapperExtend;
import com.nj.model.generate.NjUserDebtMessageRecord;

@Transactional
@Service("debtTransMessageService")
public class DebtTransMessageService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insert(NjUserDebtMessageRecord debtMessageRecord) throws Exception {
		NjUserDebtMessageRecordMapper mapper = dao.getMapper(NjUserDebtMessageRecordMapper.class);
		mapper.insertSelective(debtMessageRecord);
	}
	
	public List<NjUserDebtMessageRecord> selectOrderNoList() throws Exception {
		NjUserDebtMessageRecordMapperExtend mapper = dao.getMapper(NjUserDebtMessageRecordMapperExtend.class);
		return mapper.selectOrderNoList();
	}

	public NjUserDebtMessageRecord selectLastMsgByOrderNo(String orderNo) throws Exception {
		NjUserDebtMessageRecordMapperExtend mapper = dao.getMapper(NjUserDebtMessageRecordMapperExtend.class);
		return mapper.selectLastMsgByOrderNo(orderNo);
	}

	public void deleteByOrderNo(String orderNo) throws Exception {
		NjUserDebtMessageRecordMapperExtend mapper = dao.getMapper(NjUserDebtMessageRecordMapperExtend.class);
		mapper.deleteByOrderNo(orderNo);
		
	}
}
