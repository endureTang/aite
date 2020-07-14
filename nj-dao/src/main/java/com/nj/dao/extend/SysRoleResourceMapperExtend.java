package com.nj.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysRoleResource;

public interface SysRoleResourceMapperExtend {
	
	public int deleteSysAuth(@Param("roleId")String roleId,@Param("isShow")String isShow);

	public int batchInsert(List<PageData> list);
	public int freshBatchInsert(List<SysRoleResource> list);
}
