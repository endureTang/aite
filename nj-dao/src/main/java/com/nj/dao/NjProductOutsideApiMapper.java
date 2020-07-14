package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductOutsideApi;
import com.nj.model.generate.NjProductOutsideApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductOutsideApiMapper extends BaseMapper {
    long countByExample(NjProductOutsideApiExample example);

    int deleteByExample(NjProductOutsideApiExample example);

    int insert(NjProductOutsideApi record);

    int insertSelective(NjProductOutsideApi record);

    List<NjProductOutsideApi> selectByExample(NjProductOutsideApiExample example);

    int updateByExampleSelective(@Param("record") NjProductOutsideApi record, @Param("example") NjProductOutsideApiExample example);

    int updateByExample(@Param("record") NjProductOutsideApi record, @Param("example") NjProductOutsideApiExample example);
}