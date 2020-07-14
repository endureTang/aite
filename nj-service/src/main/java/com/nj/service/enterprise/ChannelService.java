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

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.entity.SystemLog;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjChannelMapper;
import com.nj.dao.NjChannelTfcfActMapper;
import com.nj.dao.extend.NjChannelMapperExtend;
import com.nj.dao.extend.NjProductMapperExtend;
import com.nj.model.generate.NjChannel;
import com.nj.model.generate.NjChannelExample;
import com.nj.model.generate.NjChannelTfcfAct;

@Transactional(readOnly = true)
@Service("channelService")
public class ChannelService extends BaseCachesService {

	private static Logger logger = LoggerFactory.getLogger(ChannelService.class);
	
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	
	public PageData getChannelListByCoporate(PageData pd) throws Exception {
		
		//创建公司
		NjChannelMapperExtend njUserInfoDaoExd = dao.getMapper(NjChannelMapperExtend.class);
		int count = njUserInfoDaoExd.getChannelListCount(pd);
		List<Map> results = njUserInfoDaoExd.getChannelList(pd);
		
		pd.put(Constants.Datas.RECORDSFILTERED, count);
		pd.put(Constants.Datas.NDATA, results);
		return pd;
	}
	
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public NjChannelTfcfAct updateChannel(PageData pd) throws Exception {
		NjChannelTfcfActMapper sm = dao.getMapper(NjChannelTfcfActMapper.class);
		NjChannelMapperExtend ext = dao.getMapper(NjChannelMapperExtend.class);
		
		String channelOpenId = pd.getString("channelOpenId");
		String channelAcct = pd.getString("channelAcct");
		String channelId = pd.getString("channelId");
		
		//插入数据
		NjChannelTfcfAct act = new NjChannelTfcfAct();
		act.setId(UuidUtil.get32UUID());
		act.setChannelId(channelId);
		act.setName(channelAcct);
		act.setTfcfId(channelOpenId);
		act.setCreateBy(pd.getString("userId"));
		act.setCreateDate(new Date());
		sm.insert(act);
		
		//绑定关系
		pd.put("acctId", act.getId());
		ext.bindChannel(pd);
		return act;
	}
	@SystemLog(description="新增渠道")
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void createChannel(NjChannel channel,int pageType) throws Exception {
		NjChannelMapper ext = dao.getMapper(NjChannelMapper.class);
		if(pageType == 0){
			channel.setId(UuidUtil.get32UUID());
			ext.insert(channel);
		}else{
			ext.updateByPrimaryKeySelective(channel);
		}
	}
	@SystemLog(description="删除渠道")
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer delete(String id) throws Exception {
		NjChannelMapperExtend sm = dao.getMapper(NjChannelMapperExtend.class);
		return sm.delete(id);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer batchDelete(PageData pd) throws Exception {
		List<String> idList = com.nj.core.base.util.StringUtils.splitToStr(pd.getString("ids"), Const.COMMA);
		if (null != idList && idList.size() > 0) {
			pd.put("idList", idList);
			NjChannelMapperExtend sm = dao.getMapper(NjChannelMapperExtend.class);
			return sm.batchDelete(pd);
		}
		return 0;
	}
	
	
	/*
	 * 根据手机号查询用户在能借系统中的状态: 用户信息  + 用户角色信息
	 */
	public PageData getChannelAllListByCoporate(PageData pd) throws Exception {
		
		//创建公司
		NjChannelMapperExtend njUserInfoDaoExd = dao.getMapper(NjChannelMapperExtend.class);
		List<Map> results = njUserInfoDaoExd.getChannelAllList(pd);
		
		pd.put("result", results);
		return pd;
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void unbind(PageData pd) throws Exception {
		NjChannelMapperExtend sm = dao.getMapper(NjChannelMapperExtend.class);
		sm.unbind1(pd);
		sm.unbind2(pd);
	}
	
	/*
	 * 查询第三方渠道
	 */
	public NjChannel getById(String id) throws Exception {
		NjChannelMapper cm = dao.getMapper(NjChannelMapper.class);
		return cm.selectByPrimaryKey(id);
	}

	/**
     * 根据传入参数获取渠道列表（暂时只有名称）
     * @param pd
     * @return
     */
	public List<NjChannel> getByParam(PageData pd) throws Exception {
		NjChannelMapperExtend sm = dao.getMapper(NjChannelMapperExtend.class);
		return sm.selectByParam(pd);
	}


	public List<Map> getChannelList(PageData pd) throws Exception {
		NjChannelMapperExtend mapper = dao.getMapper(NjChannelMapperExtend.class);
		List<Map> results = mapper.selectAllChannelListPage(pd);
		return results;
	}


	public String selectMaxChannelCode() throws Exception {
		NjChannelMapperExtend mapper = dao.getMapper(NjChannelMapperExtend.class);
		return mapper.selectMaxChannelCode();
	}
	
	public List<NjChannel> getChannelForCoporate(String companyId){
		NjChannelExample example = new NjChannelExample();
		example.createCriteria().andDelFlagEqualTo(false)
				.andCompanyIdEqualTo(companyId);	//false代表0，表示未删除
		example.setOrderByClause("create_date");
		
		try {
			NjChannelMapper channelMapper = dao.getMapper(NjChannelMapper.class);
			return channelMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("查询发生异常:",e);
			return null;
		}
	}


	public List<Map<String, Object>> getRepayChannelUserList(PageData pd) throws Exception {
		NjChannelMapperExtend channelMapperExtend = dao.getMapper(NjChannelMapperExtend.class);
		return channelMapperExtend.getRepayChannelUserList(pd);
	}
}
