package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderBaseInfoCompany;
import com.nj.model.generate.NjOrderBaseInfoCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderBaseInfoCompanyMapper extends BaseMapper {
    long countByExample(NjOrderBaseInfoCompanyExample example);

    int deleteByExample(NjOrderBaseInfoCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderBaseInfoCompany record);

    int insertSelective(NjOrderBaseInfoCompany record);

    List<NjOrderBaseInfoCompany> selectByExample(NjOrderBaseInfoCompanyExample example);

    NjOrderBaseInfoCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderBaseInfoCompany record, @Param("example") NjOrderBaseInfoCompanyExample example);

    int updateByExample(@Param("record") NjOrderBaseInfoCompany record, @Param("example") NjOrderBaseInfoCompanyExample example);

    int updateByPrimaryKeySelective(NjOrderBaseInfoCompany record);

    int updateByPrimaryKey(NjOrderBaseInfoCompany record);
}