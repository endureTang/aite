package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjBaseInfoCompany;
import com.nj.model.generate.NjBaseInfoCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjBaseInfoCompanyMapper extends BaseMapper {
    long countByExample(NjBaseInfoCompanyExample example);

    int deleteByExample(NjBaseInfoCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjBaseInfoCompany record);

    int insertSelective(NjBaseInfoCompany record);

    List<NjBaseInfoCompany> selectByExample(NjBaseInfoCompanyExample example);

    NjBaseInfoCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjBaseInfoCompany record, @Param("example") NjBaseInfoCompanyExample example);

    int updateByExample(@Param("record") NjBaseInfoCompany record, @Param("example") NjBaseInfoCompanyExample example);

    int updateByPrimaryKeySelective(NjBaseInfoCompany record);

    int updateByPrimaryKey(NjBaseInfoCompany record);
}