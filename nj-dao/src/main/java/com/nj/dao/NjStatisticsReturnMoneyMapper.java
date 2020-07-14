package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjStatisticsReturnMoney;
import com.nj.model.generate.NjStatisticsReturnMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjStatisticsReturnMoneyMapper extends BaseMapper {
    int countByExample(NjStatisticsReturnMoneyExample example);

    int deleteByExample(NjStatisticsReturnMoneyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjStatisticsReturnMoney record);

    int insertSelective(NjStatisticsReturnMoney record);

    List<NjStatisticsReturnMoney> selectByExample(NjStatisticsReturnMoneyExample example);

    NjStatisticsReturnMoney selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjStatisticsReturnMoney record, @Param("example") NjStatisticsReturnMoneyExample example);

    int updateByExample(@Param("record") NjStatisticsReturnMoney record, @Param("example") NjStatisticsReturnMoneyExample example);

    int updateByPrimaryKeySelective(NjStatisticsReturnMoney record);

    int updateByPrimaryKey(NjStatisticsReturnMoney record);
}