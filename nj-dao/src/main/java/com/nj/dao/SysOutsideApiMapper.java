package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.SysOutsideApi;
import com.nj.model.generate.SysOutsideApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOutsideApiMapper extends BaseMapper {
    long countByExample(SysOutsideApiExample example);

    int deleteByExample(SysOutsideApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysOutsideApi record);

    int insertSelective(SysOutsideApi record);

    List<SysOutsideApi> selectByExample(SysOutsideApiExample example);

    SysOutsideApi selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysOutsideApi record, @Param("example") SysOutsideApiExample example);

    int updateByExample(@Param("record") SysOutsideApi record, @Param("example") SysOutsideApiExample example);

    int updateByPrimaryKeySelective(SysOutsideApi record);

    int updateByPrimaryKey(SysOutsideApi record);
}