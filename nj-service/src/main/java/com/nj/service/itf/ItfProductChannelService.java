package com.nj.service.itf;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjChannelMapper;
import com.nj.dao.NjChannelRelativeMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.dao.extend.NjProductChannelMapperExtend;
import com.nj.model.generate.NjChannel;
import com.nj.model.generate.NjChannelRelative;
import com.nj.model.generate.NjProductChannel;

@Service("itfProductChannelService")
public class ItfProductChannelService {
	@Resource(name="BaseDao")
	private BaseDao dao;
	
	public String getSubChannelNameBySubId(String subChannelId) throws Exception{
		NjChannelRelativeMapper mapper = dao.getMapper(NjChannelRelativeMapper.class);
		NjChannelRelative rel = mapper.selectByPrimaryKey(subChannelId);
		if(rel ==null)
			return null;
		return rel.getName();
/*		NjUserInfoMapper userMapper = dao.getMapper(NjUserInfoMapper.class);
		NjUserInfo user = userMapper.selectByPrimaryKey(rel.getChannelAcct());
		if(user ==null)
			return null;
		return user.getUserName();*/
	}
	
	public Map<String,Object> getChannelMapByAgentId(String agentId)throws Exception{
		NjProductChannelMapperExtend mapper = dao.getMapper(NjProductChannelMapperExtend.class);
		return mapper.getChannelMapByAgentId( agentId);
	}
	
	public Map<String,Object> getChannelMapBySubId(String subChannelId)throws Exception{
		NjProductChannelMapperExtend mapper = dao.getMapper(NjProductChannelMapperExtend.class);
		return mapper.getChannelMapBySubId( subChannelId);
	}
	
	public Map<String, Object> getChannelMapByChannelId(String channelId) throws Exception{
		if(StringUtils.isEmpty(channelId)){
			return null;
		}
		NjProductChannelMapper mapper = dao.getMapper(NjProductChannelMapper.class);
		NjProductChannel channel= mapper.selectByPrimaryKey(channelId);
//		NjChannelMapper mapper = dao.getMapper(NjChannelMapper.class);
//		NjChannel channel = mapper.selectByPrimaryKey(channelId);
		if (channel != null) {
			Map<String, Object> result = new HashMap<String, Object>();
//			result.put("channelId", channel.getId());
			result.put("channelCode", channel.getChannelCode());
			result.put("channelName", channel.getChannelName());
//			result.put("channelNo", channel.getChannelId());
			return result;
		}
		return null;
	}
		
}
