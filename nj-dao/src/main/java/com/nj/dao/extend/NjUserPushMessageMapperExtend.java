package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjUserPushMessage;

public interface NjUserPushMessageMapperExtend {

	List<NjUserPushMessage> selectListByUserId(@Param("userId") String userId);

	Map selectById(@Param("id") String id);

	Integer selectUnreadMessage(@Param("userId") String userId);

	void updateUserMessageReadStatus(@Param("userId") String userId);
	
	String selectLatelyMessage(@Param("userId") String userId);

}
