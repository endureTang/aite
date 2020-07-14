package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjSmsLog;
import com.nj.model.generate.NjSmsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjSmsLogMapper extends BaseMapper {
    long countByExample(NjSmsLogExample example);

    int deleteByExample(NjSmsLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjSmsLog record);

    int insertSelective(NjSmsLog record);

    List<NjSmsLog> selectByExample(NjSmsLogExample example);

    NjSmsLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjSmsLog record, @Param("example") NjSmsLogExample example);

    int updateByExample(@Param("record") NjSmsLog record, @Param("example") NjSmsLogExample example);

    int updateByPrimaryKeySelective(NjSmsLog record);

    int updateByPrimaryKey(NjSmsLog record);
}