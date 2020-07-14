package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjPuhuiApply;
import com.nj.model.generate.NjPuhuiApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjPuhuiApplyMapper extends BaseMapper {
    long countByExample(NjPuhuiApplyExample example);

    int deleteByExample(NjPuhuiApplyExample example);

    int deleteByPrimaryKey(String loanNo);

    int insert(NjPuhuiApply record);

    int insertSelective(NjPuhuiApply record);

    List<NjPuhuiApply> selectByExample(NjPuhuiApplyExample example);

    NjPuhuiApply selectByPrimaryKey(String loanNo);

    int updateByExampleSelective(@Param("record") NjPuhuiApply record, @Param("example") NjPuhuiApplyExample example);

    int updateByExample(@Param("record") NjPuhuiApply record, @Param("example") NjPuhuiApplyExample example);

    int updateByPrimaryKeySelective(NjPuhuiApply record);

    int updateByPrimaryKey(NjPuhuiApply record);
}