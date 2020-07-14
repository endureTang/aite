package com.nj.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysUser;

public interface SysUserMapperExtend {

	Long selectListCount(PageData pd);

	List<SysUser> selectList(PageData pd);

	SysUser getByMobile(@Param("userMobile") String userMobile);
}