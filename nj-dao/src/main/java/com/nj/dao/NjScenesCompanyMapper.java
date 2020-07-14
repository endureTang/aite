package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjScenesCompany;
import com.nj.model.generate.NjScenesCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjScenesCompanyMapper extends BaseMapper {
    long countByExample(NjScenesCompanyExample example);

    int deleteByExample(NjScenesCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjScenesCompany record);

    int insertSelective(NjScenesCompany record);

    List<NjScenesCompany> selectByExample(NjScenesCompanyExample example);

    NjScenesCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjScenesCompany record, @Param("example") NjScenesCompanyExample example);

    int updateByExample(@Param("record") NjScenesCompany record, @Param("example") NjScenesCompanyExample example);

    int updateByPrimaryKeySelective(NjScenesCompany record);

    int updateByPrimaryKey(NjScenesCompany record);
}