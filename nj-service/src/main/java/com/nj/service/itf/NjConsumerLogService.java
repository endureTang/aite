package com.nj.service.itf;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.nj.core.base.common.Constants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.NjConsumerLogMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.extend.SysDictMapperExtend;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjConsumerLog;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysDictExample;


@Transactional(readOnly = true)
@Service("njConsumerLogService")
public class NjConsumerLogService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	private static Logger logger = LoggerFactory.getLogger(NjConsumerLogService.class);
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insertLog(NjConsumerLog log){
		try{
			NjConsumerLogMapper mapper = dao.getMapper(NjConsumerLogMapper.class);
			mapper.insert(log);
		}catch(Exception e){
			logger.error("insert NjConsumerLog error",e);
		}
	}
	
}
