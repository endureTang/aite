package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjChannel;
import com.nj.model.generate.NjChannelRelative;
import com.nj.model.generate.NjChannelRelativeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjChannelMapperExtend {

	List<Map> getChannelList(PageData pd);
	
	List<Map> getChannelAllList(PageData pd);
	
	int getChannelListCount(PageData pd);
	
    int bindChannel(PageData pd);
    
    /**
     * 逻辑删除
     * @param id
     * @return
     */
    int delete(String id);
    /**
     * 批量逻辑删除
     * @param idList
     * @return
     */
    int batchDelete(PageData idList);

    int unbind1(PageData pd);
    
    int unbind2(PageData pd);

    /**
     * 根据传入参数获取渠道列表（暂时只有名称）
     * @param pd
     * @return
     */
	List<NjChannel> selectByParam(PageData pd);

	List<Map> selectAllChannelListPage(PageData pd);

	String selectMaxChannelCode();

    NjChannel findChannelByProject(String projectChannelId);

    Map<String,Object> findLimitByProjectCode(String projectCode);

	List<Map<String, Object>> getRepayChannelUserList(PageData pd);

	/**
	 * 根据渠道id获取渠道天赋财富收款账户id
	 * @param channelId
	 * @return
	 */
	String getChannelRepayUserIdById(String channelId);
    
}