package com.nj.service.itf;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjChannelDevAccountMapper;
import com.nj.dao.NjChannelMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.model.generate.NjChannel;
import com.nj.model.generate.NjChannelDevAccount;
import com.nj.model.generate.NjChannelDevAccountExample;
import com.nj.model.generate.NjProductChannel;

@Transactional(readOnly = true)
@Service("itfChannelService")
public class ItfChannelService {
	
	private static Logger logger = LoggerFactory.getLogger(ItfChannelService.class);
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	public NjChannelDevAccount getChannelDevAccount(String appId) throws Exception{
		NjChannelDevAccountMapper mapper = dao.getMapper(NjChannelDevAccountMapper.class);
		NjChannelDevAccountExample exp = new NjChannelDevAccountExample();
		exp.createCriteria().andAppIdEqualTo(appId);
		return mapper.selectByExample(exp).get(0);
	}
	
	/**
	 * 通过产品渠道ID（订单表中的channelId）查询渠道
	 * @param productChannelId
	 * @return
	 * @throws Exception
	 */
	public NjChannel getChannelByChannelProductId(String productChannelId) throws Exception{
		
	  NjProductChannelMapper njProductChannelMapper = dao.getMapper(NjProductChannelMapper.class);
      NjProductChannel njProductChannel = njProductChannelMapper.selectByPrimaryKey(productChannelId);
      NjChannelMapper njChannelMapper = dao.getMapper(NjChannelMapper.class);
      NjChannel njChannel = njChannelMapper.selectByPrimaryKey(njProductChannel.getNjChannelId());
      return njChannel;
	}
	
	/**
	 * 通过渠道ID查询渠道
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public NjChannel getChannelById(String id) throws Exception {
		 NjChannelMapper njChannelMapper = dao.getMapper(NjChannelMapper.class);
		 return njChannelMapper.selectByPrimaryKey(id);
	} 
}
