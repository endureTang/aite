package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductArea;
import com.nj.model.generate.NjProductAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductAreaMapper extends BaseMapper {
    long countByExample(NjProductAreaExample example);

    int deleteByExample(NjProductAreaExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProductArea record);

    int insertSelective(NjProductArea record);

    List<NjProductArea> selectByExample(NjProductAreaExample example);

    NjProductArea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProductArea record, @Param("example") NjProductAreaExample example);

    int updateByExample(@Param("record") NjProductArea record, @Param("example") NjProductAreaExample example);

    int updateByPrimaryKeySelective(NjProductArea record);

    int updateByPrimaryKey(NjProductArea record);
}