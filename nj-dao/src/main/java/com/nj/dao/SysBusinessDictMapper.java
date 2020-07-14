package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.SysBusinessDict;
import com.nj.model.generate.SysBusinessDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBusinessDictMapper extends BaseMapper {
    int countByExample(SysBusinessDictExample example);

    int deleteByExample(SysBusinessDictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysBusinessDict record);

    int insertSelective(SysBusinessDict record);

    List<SysBusinessDict> selectByExample(SysBusinessDictExample example);

    SysBusinessDict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysBusinessDict record, @Param("example") SysBusinessDictExample example);

    int updateByExample(@Param("record") SysBusinessDict record, @Param("example") SysBusinessDictExample example);

    int updateByPrimaryKeySelective(SysBusinessDict record);

    int updateByPrimaryKey(SysBusinessDict record);
}