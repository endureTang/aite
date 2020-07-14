package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjStatisticsOrder;
import com.nj.model.generate.NjStatisticsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjStatisticsOrderMapper extends BaseMapper {
    int countByExample(NjStatisticsOrderExample example);

    int deleteByExample(NjStatisticsOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjStatisticsOrder record);

    int insertSelective(NjStatisticsOrder record);

    List<NjStatisticsOrder> selectByExample(NjStatisticsOrderExample example);

    NjStatisticsOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjStatisticsOrder record, @Param("example") NjStatisticsOrderExample example);

    int updateByExample(@Param("record") NjStatisticsOrder record, @Param("example") NjStatisticsOrderExample example);

    int updateByPrimaryKeySelective(NjStatisticsOrder record);

    int updateByPrimaryKey(NjStatisticsOrder record);
}