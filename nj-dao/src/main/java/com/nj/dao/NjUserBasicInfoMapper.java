package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserBasicInfo;
import com.nj.model.generate.NjUserBasicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserBasicInfoMapper extends BaseMapper {
    long countByExample(NjUserBasicInfoExample example);

    int deleteByExample(NjUserBasicInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserBasicInfo record);

    int insertSelective(NjUserBasicInfo record);

    List<NjUserBasicInfo> selectByExample(NjUserBasicInfoExample example);

    NjUserBasicInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserBasicInfo record, @Param("example") NjUserBasicInfoExample example);

    int updateByExample(@Param("record") NjUserBasicInfo record, @Param("example") NjUserBasicInfoExample example);

    int updateByPrimaryKeySelective(NjUserBasicInfo record);

    int updateByPrimaryKey(NjUserBasicInfo record);
}