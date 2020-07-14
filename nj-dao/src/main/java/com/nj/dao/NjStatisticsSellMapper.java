package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjStatisticsSell;
import com.nj.model.generate.NjStatisticsSellExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjStatisticsSellMapper extends BaseMapper {
    long countByExample(NjStatisticsSellExample example);

    int deleteByExample(NjStatisticsSellExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjStatisticsSell record);

    int insertSelective(NjStatisticsSell record);

    List<NjStatisticsSell> selectByExample(NjStatisticsSellExample example);

    NjStatisticsSell selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjStatisticsSell record, @Param("example") NjStatisticsSellExample example);

    int updateByExample(@Param("record") NjStatisticsSell record, @Param("example") NjStatisticsSellExample example);

    int updateByPrimaryKeySelective(NjStatisticsSell record);

    int updateByPrimaryKey(NjStatisticsSell record);
}