package com.nj.service.enterprise;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.extend.NjOrderBlackMapperExtend;

@Service("orderBlackService")
public class OrderBlackService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public List<Map> getBlackByOrderId(String orderId) throws Exception{
		NjOrderBlackMapperExtend obme = dao.getMapper(NjOrderBlackMapperExtend.class);
		return obme.getBlackByOrderId(orderId);
	}
}
