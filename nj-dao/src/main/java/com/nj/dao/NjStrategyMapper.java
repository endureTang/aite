package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjStrategy;
import com.nj.model.generate.NjStrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjStrategyMapper extends BaseMapper {
    long countByExample(NjStrategyExample example);

    int deleteByExample(NjStrategyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjStrategy record);

    int insertSelective(NjStrategy record);

    List<NjStrategy> selectByExample(NjStrategyExample example);

    NjStrategy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjStrategy record, @Param("example") NjStrategyExample example);

    int updateByExample(@Param("record") NjStrategy record, @Param("example") NjStrategyExample example);

    int updateByPrimaryKeySelective(NjStrategy record);

    int updateByPrimaryKey(NjStrategy record);
}