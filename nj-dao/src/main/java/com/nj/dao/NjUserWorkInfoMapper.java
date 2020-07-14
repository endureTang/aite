package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserWorkInfo;
import com.nj.model.generate.NjUserWorkInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserWorkInfoMapper extends BaseMapper {
    long countByExample(NjUserWorkInfoExample example);

    int deleteByExample(NjUserWorkInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserWorkInfo record);

    int insertSelective(NjUserWorkInfo record);

    List<NjUserWorkInfo> selectByExample(NjUserWorkInfoExample example);

    NjUserWorkInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserWorkInfo record, @Param("example") NjUserWorkInfoExample example);

    int updateByExample(@Param("record") NjUserWorkInfo record, @Param("example") NjUserWorkInfoExample example);

    int updateByPrimaryKeySelective(NjUserWorkInfo record);

    int updateByPrimaryKey(NjUserWorkInfo record);
}