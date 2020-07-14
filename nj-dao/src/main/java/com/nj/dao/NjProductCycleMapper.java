package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductCycle;
import com.nj.model.generate.NjProductCycleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductCycleMapper extends BaseMapper {
    long countByExample(NjProductCycleExample example);

    int deleteByExample(NjProductCycleExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProductCycle record);

    int insertSelective(NjProductCycle record);

    List<NjProductCycle> selectByExample(NjProductCycleExample example);

    NjProductCycle selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProductCycle record, @Param("example") NjProductCycleExample example);

    int updateByExample(@Param("record") NjProductCycle record, @Param("example") NjProductCycleExample example);

    int updateByPrimaryKeySelective(NjProductCycle record);

    int updateByPrimaryKey(NjProductCycle record);
}