package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.NjUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserInfoMapper extends BaseMapper {
    long countByExample(NjUserInfoExample example);

    int deleteByExample(NjUserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserInfo record);

    int insertSelective(NjUserInfo record);

    List<NjUserInfo> selectByExample(NjUserInfoExample example);

    NjUserInfo selectByPrimaryKey(String id);
    
    NjUserInfo selectByMobile(String mobile);

    int updateByExampleSelective(@Param("record") NjUserInfo record, @Param("example") NjUserInfoExample example);

    int updateByExample(@Param("record") NjUserInfo record, @Param("example") NjUserInfoExample example);

    int updateByPrimaryKeySelective(NjUserInfo record);

    int updateByPrimaryKey(NjUserInfo record);
}