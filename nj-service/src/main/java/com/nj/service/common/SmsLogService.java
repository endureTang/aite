package com.nj.service.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjSmsLogMapper;
import com.nj.model.generate.NjSmsLog;
import com.nj.model.generate.NjSmsLogExample;

/**
 * 短信日志Service
 * @author MaSong
 * @date 2018-07-23 09:27:01
 */
@Service("smsLogService")
public class SmsLogService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveSmsLog(NjSmsLog njSmsLog) throws Exception{
		NjSmsLogMapper mapper = dao.getMapper(NjSmsLogMapper.class);
		mapper.insert(njSmsLog);
	}
	
	public NjSmsLog getSmsLogByMobileAndType(String mobile ,String type) throws Exception{
		
		NjSmsLogExample example = new NjSmsLogExample();
		example.createCriteria().andMobileEqualTo(mobile).andSmsTypeEqualTo(type);
		example.setOrderByClause("create_time  desc");
		
		NjSmsLogMapper mapper = dao.getMapper(NjSmsLogMapper.class);
		List<NjSmsLog> listSmsLog = mapper.selectByExample(example);
		if (listSmsLog== null) {
			return null;
		} else {
			if (listSmsLog.size() == 0) {
				return null;
			} else {
				return listSmsLog.get(0);
			}
		}
	}
	
}
