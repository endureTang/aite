package com.nj.service.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.extend.NjUserPushMessageMapperExtend;
import com.nj.model.generate.NjUserPushMessage;

@Transactional(readOnly = true)
@Service("pushMessageService")
public class PushMessageService {
	@Resource(name = "BaseDao")
    private BaseDao dao;
	
	public Map getById(String id) throws Exception {
		NjUserPushMessageMapperExtend mapper = dao.getMapper(NjUserPushMessageMapperExtend.class);
		return mapper.selectById(id);
	}
	
	public List<NjUserPushMessage> selectListByUserId(String userId) throws Exception {
		NjUserPushMessageMapperExtend mapper = dao.getMapper(NjUserPushMessageMapperExtend.class);
		
		return mapper.selectListByUserId(userId);
	}

	public Integer selectUnreadMessage(String userId) throws Exception {
		NjUserPushMessageMapperExtend mapper = dao.getMapper(NjUserPushMessageMapperExtend.class);
		return mapper.selectUnreadMessage(userId);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateUserMessageReadStatus(String userId) throws Exception {
		NjUserPushMessageMapperExtend mapper = dao.getMapper(NjUserPushMessageMapperExtend.class);
		mapper.updateUserMessageReadStatus(userId);
	}
	
	public String selectLatelyMessage(String userId) throws Exception {
		NjUserPushMessageMapperExtend mapper = dao.getMapper(NjUserPushMessageMapperExtend.class);
		return mapper.selectLatelyMessage(userId);
	}

}
