package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjStatisticsOverday;
import com.nj.model.generate.NjStatisticsOverdayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjStatisticsOverdayMapper extends BaseMapper {
    int countByExample(NjStatisticsOverdayExample example);

    int deleteByExample(NjStatisticsOverdayExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjStatisticsOverday record);

    int insertSelective(NjStatisticsOverday record);

    List<NjStatisticsOverday> selectByExample(NjStatisticsOverdayExample example);

    NjStatisticsOverday selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjStatisticsOverday record, @Param("example") NjStatisticsOverdayExample example);

    int updateByExample(@Param("record") NjStatisticsOverday record, @Param("example") NjStatisticsOverdayExample example);

    int updateByPrimaryKeySelective(NjStatisticsOverday record);

    int updateByPrimaryKey(NjStatisticsOverday record);
}