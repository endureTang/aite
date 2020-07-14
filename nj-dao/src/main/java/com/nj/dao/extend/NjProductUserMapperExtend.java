package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.activiti.base.ProcessRoleUser;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import com.nj.model.generate.NjProductUser;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjProductUserMapperExtend {

	List<Map> getProductUserList(NjProductUser npp);
	
	List<Map> getProductRoleUserList(ProcessRoleUser npp);

	List<NjProductUser> getByParams(String userId);

	void deleteByUserId(String userId);
}