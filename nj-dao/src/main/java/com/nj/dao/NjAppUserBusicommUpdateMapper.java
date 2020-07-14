package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjAppUserBusicommUpdate;
import com.nj.model.generate.NjAppUserBusicommUpdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjAppUserBusicommUpdateMapper extends BaseMapper {
    int countByExample(NjAppUserBusicommUpdateExample example);

    int deleteByExample(NjAppUserBusicommUpdateExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjAppUserBusicommUpdate record);

    int insertSelective(NjAppUserBusicommUpdate record);

    List<NjAppUserBusicommUpdate> selectByExample(NjAppUserBusicommUpdateExample example);

    NjAppUserBusicommUpdate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjAppUserBusicommUpdate record, @Param("example") NjAppUserBusicommUpdateExample example);

    int updateByExample(@Param("record") NjAppUserBusicommUpdate record, @Param("example") NjAppUserBusicommUpdateExample example);

    int updateByPrimaryKeySelective(NjAppUserBusicommUpdate record);

    int updateByPrimaryKey(NjAppUserBusicommUpdate record);
}