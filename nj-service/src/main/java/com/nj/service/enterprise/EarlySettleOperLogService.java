package com.nj.service.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.dao.EarlySettleOperLogMapper;
import com.nj.model.generate.EarlySettleOperLog;

import javax.annotation.Resource;

@Service
@Transactional(readOnly=true)
public class EarlySettleOperLogService {

	@Resource
	private EarlySettleOperLogMapper earlySettleOperLogMapper;
	
	@Transactional(rollbackFor={Throwable.class})
	public void insert(EarlySettleOperLog log){
		earlySettleOperLogMapper.insert(log);
	}
}
