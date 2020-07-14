package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjChannelRelative;
import com.nj.model.generate.NjChannelRelativeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjChannelRelativeMapperExtend {

	List<Map> getChannelList(PageData pd);
	
	List<Map> getEmployeeList(PageData pd);
		
	List<Map> getLByChannelId(@Param("channelId") String channelId);
    int bindChannel(PageData pd);
    
    /**
     * 逻辑删除
     * @param id
     * @return
     */
    int deleteChannelRelative(String id);
    
}