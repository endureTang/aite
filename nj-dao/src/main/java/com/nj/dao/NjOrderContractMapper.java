package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderContract;
import com.nj.model.generate.NjOrderContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderContractMapper extends BaseMapper {
    int countByExample(NjOrderContractExample example);

    int deleteByExample(NjOrderContractExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderContract record);

    int insertSelective(NjOrderContract record);

    List<NjOrderContract> selectByExample(NjOrderContractExample example);

    NjOrderContract selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderContract record, @Param("example") NjOrderContractExample example);

    int updateByExample(@Param("record") NjOrderContract record, @Param("example") NjOrderContractExample example);

    int updateByPrimaryKeySelective(NjOrderContract record);

    int updateByPrimaryKey(NjOrderContract record);
}