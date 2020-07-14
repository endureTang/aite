package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjAppUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjAppUserMapper extends BaseMapper {
    long countByExample(NjAppUserExample example);

    int deleteByExample(NjAppUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjAppUser record);

    int insertSelective(NjAppUser record);

    List<NjAppUser> selectByExample(NjAppUserExample example);

    NjAppUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjAppUser record, @Param("example") NjAppUserExample example);

    int updateByExample(@Param("record") NjAppUser record, @Param("example") NjAppUserExample example);

    int updateByPrimaryKeySelective(NjAppUser record);

    int updateByPrimaryKey(NjAppUser record);
}