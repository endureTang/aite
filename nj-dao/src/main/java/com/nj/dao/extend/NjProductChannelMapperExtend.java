package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjProductChannelMapperExtend {
	/**
     * 逻辑删除
     * @param id
     * @return
     */
    int delete(String id);
    

    int bindChannel(PageData pd);
    

	Map getChannelInfoById(PageData pd);

	List<Map> getChannelList(PageData pd);
	
	List<Map> getAllChannelsByProdId(@Param("productId") String productId);
	
	/**
	 * 根据渠道专员id获取其对应的渠道信息
	 * @param agentId
	 * @return
	 */
	Map<String,Object> getChannelMapByAgentId(@Param("agentId") String agentId);
	
	/**
	 * 根据关联渠道获取其对应的渠道信息
	 * @param subChannelId
	 * @return
	 */
	Map<String,Object> getChannelMapBySubId(@Param("subChannelId") String subChannelId);
	
	List<Map> getChannelDetailMapByProdId(@Param("productId") String productId);


	String getOutProductChannelId(@Param("productCode") String productCode);
	
	/**
	 * 根据传入相关条件删除
	 * @param pd
	 */
	void deleteByCondition(PageData pd);
	/**
	 * 根据产品ID获取渠道列表
	 * @param productId
	 * @return
	 */
	List<Map<String, Object>> selectByProduct(@Param("productId")String productId,@Param("type")int type);


	NjProductChannel getChannelByChannelCodeAndProductId(@Param("productId") String productId, @Param("channelCode") String channelCode);

	List<String> getChannelByProductCode(@Param("productCode") String productCode);


	List<Map<String, Object>> selectByChannelId(@Param("channelId") String channelId,@Param("productId") String productId);


	String getRepayUserIdByChannelId(@Param("channelId") String channelId);

	/**
	 * 根据主键id获取产品资金code和渠道code
	 * @param channelId
	 * @return
	 */
	Map<String, String> getChannelCodeById(@Param("channelId") String channelId);
}