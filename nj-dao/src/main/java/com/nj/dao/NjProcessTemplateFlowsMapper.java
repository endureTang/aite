package com.nj.dao;

import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.model.generate.NjProcessTemplateFlowsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProcessTemplateFlowsMapper {
    long countByExample(NjProcessTemplateFlowsExample example);

    int deleteByExample(NjProcessTemplateFlowsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NjProcessTemplateFlows record);

    int insertSelective(NjProcessTemplateFlows record);

    List<NjProcessTemplateFlows> selectByExample(NjProcessTemplateFlowsExample example);

    NjProcessTemplateFlows selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NjProcessTemplateFlows record, @Param("example") NjProcessTemplateFlowsExample example);

    int updateByExample(@Param("record") NjProcessTemplateFlows record, @Param("example") NjProcessTemplateFlowsExample example);

    int updateByPrimaryKeySelective(NjProcessTemplateFlows record);

    int updateByPrimaryKey(NjProcessTemplateFlows record);
}