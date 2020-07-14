package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjVersion;
import com.nj.model.generate.NjVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjVersionMapper extends BaseMapper {
    long countByExample(NjVersionExample example);

    int deleteByExample(NjVersionExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjVersion record);

    int insertSelective(NjVersion record);

    List<NjVersion> selectByExample(NjVersionExample example);

    NjVersion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjVersion record, @Param("example") NjVersionExample example);

    int updateByExample(@Param("record") NjVersion record, @Param("example") NjVersionExample example);

    int updateByPrimaryKeySelective(NjVersion record);

    int updateByPrimaryKey(NjVersion record);
}