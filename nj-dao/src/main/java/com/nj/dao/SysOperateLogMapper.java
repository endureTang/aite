package com.nj.dao;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysOperateLog;
import com.nj.model.generate.SysOperateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOperateLogMapper {
    long countByExample(SysOperateLogExample example);

    int deleteByExample(SysOperateLogExample example);

    int deleteByPrimaryKey(Long id);
    
    int batchDelete(PageData idList);

    int insert(SysOperateLog record);

    int insertSelective(SysOperateLog record);

    List<SysOperateLog> selectByExample(SysOperateLogExample example);

    SysOperateLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysOperateLog record, @Param("example") SysOperateLogExample example);

    int updateByExample(@Param("record") SysOperateLog record, @Param("example") SysOperateLogExample example);

    int updateByPrimaryKeySelective(SysOperateLog record);

    int updateByPrimaryKey(SysOperateLog record);
}