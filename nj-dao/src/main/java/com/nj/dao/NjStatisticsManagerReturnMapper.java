package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjStatisticsManagerReturn;
import com.nj.model.generate.NjStatisticsManagerReturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjStatisticsManagerReturnMapper extends BaseMapper {
    long countByExample(NjStatisticsManagerReturnExample example);

    int deleteByExample(NjStatisticsManagerReturnExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjStatisticsManagerReturn record);

    int insertSelective(NjStatisticsManagerReturn record);

    List<NjStatisticsManagerReturn> selectByExample(NjStatisticsManagerReturnExample example);

    NjStatisticsManagerReturn selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjStatisticsManagerReturn record, @Param("example") NjStatisticsManagerReturnExample example);

    int updateByExample(@Param("record") NjStatisticsManagerReturn record, @Param("example") NjStatisticsManagerReturnExample example);

    int updateByPrimaryKeySelective(NjStatisticsManagerReturn record);

    int updateByPrimaryKey(NjStatisticsManagerReturn record);
}