package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductBusinessDict;
import com.nj.model.generate.NjProductBusinessDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductBusinessDictMapper extends BaseMapper {
    long countByExample(NjProductBusinessDictExample example);

    int deleteByExample(NjProductBusinessDictExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProductBusinessDict record);

    int insertSelective(NjProductBusinessDict record);

    List<NjProductBusinessDict> selectByExample(NjProductBusinessDictExample example);

    NjProductBusinessDict selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProductBusinessDict record, @Param("example") NjProductBusinessDictExample example);

    int updateByExample(@Param("record") NjProductBusinessDict record, @Param("example") NjProductBusinessDictExample example);

    int updateByPrimaryKeySelective(NjProductBusinessDict record);

    int updateByPrimaryKey(NjProductBusinessDict record);
}