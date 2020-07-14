package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjDeductionRequest;
import com.nj.model.generate.NjDeductionRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjDeductionRequestMapper extends BaseMapper {
    long countByExample(NjDeductionRequestExample example);

    int deleteByExample(NjDeductionRequestExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjDeductionRequest record);

    int insertSelective(NjDeductionRequest record);

    List<NjDeductionRequest> selectByExample(NjDeductionRequestExample example);

    NjDeductionRequest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjDeductionRequest record, @Param("example") NjDeductionRequestExample example);

    int updateByExample(@Param("record") NjDeductionRequest record, @Param("example") NjDeductionRequestExample example);

    int updateByPrimaryKeySelective(NjDeductionRequest record);

    int updateByPrimaryKey(NjDeductionRequest record);
}