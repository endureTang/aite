package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjStatisticsThreePartyCall;
import com.nj.model.generate.NjStatisticsThreePartyCallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjStatisticsThreePartyCallMapper extends BaseMapper {
    long countByExample(NjStatisticsThreePartyCallExample example);

    int deleteByExample(NjStatisticsThreePartyCallExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjStatisticsThreePartyCall record);

    int insertSelective(NjStatisticsThreePartyCall record);

    List<NjStatisticsThreePartyCall> selectByExample(NjStatisticsThreePartyCallExample example);

    NjStatisticsThreePartyCall selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjStatisticsThreePartyCall record, @Param("example") NjStatisticsThreePartyCallExample example);

    int updateByExample(@Param("record") NjStatisticsThreePartyCall record, @Param("example") NjStatisticsThreePartyCallExample example);

    int updateByPrimaryKeySelective(NjStatisticsThreePartyCall record);

    int updateByPrimaryKey(NjStatisticsThreePartyCall record);
}