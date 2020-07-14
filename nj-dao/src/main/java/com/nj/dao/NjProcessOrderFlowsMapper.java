package com.nj.dao;

import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.model.generate.NjProcessOrderFlowsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProcessOrderFlowsMapper {
    long countByExample(NjProcessOrderFlowsExample example);

    int deleteByExample(NjProcessOrderFlowsExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProcessOrderFlows record);

    int insertSelective(NjProcessOrderFlows record);

    List<NjProcessOrderFlows> selectByExample(NjProcessOrderFlowsExample example);

    NjProcessOrderFlows selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProcessOrderFlows record, @Param("example") NjProcessOrderFlowsExample example);

    int updateByExample(@Param("record") NjProcessOrderFlows record, @Param("example") NjProcessOrderFlowsExample example);

    int updateByPrimaryKeySelective(NjProcessOrderFlows record);

    int updateByPrimaryKey(NjProcessOrderFlows record);
}