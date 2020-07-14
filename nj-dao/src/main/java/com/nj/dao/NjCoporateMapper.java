package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjCoporateMapper extends BaseMapper {
    long countByExample(NjCoporateExample example);

    int deleteByExample(NjCoporateExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjCoporate record);

    int insertSelective(NjCoporate record);

    List<NjCoporate> selectByExample(NjCoporateExample example);

    NjCoporate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjCoporate record, @Param("example") NjCoporateExample example);

    int updateByExample(@Param("record") NjCoporate record, @Param("example") NjCoporateExample example);

    int updateByPrimaryKeySelective(NjCoporate record);

    int updateByPrimaryKey(NjCoporate record);
}