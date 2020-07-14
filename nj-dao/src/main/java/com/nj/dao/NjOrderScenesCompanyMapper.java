package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderScenesCompany;
import com.nj.model.generate.NjOrderScenesCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderScenesCompanyMapper extends BaseMapper {
    long countByExample(NjOrderScenesCompanyExample example);

    int deleteByExample(NjOrderScenesCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderScenesCompany record);

    int insertSelective(NjOrderScenesCompany record);

    List<NjOrderScenesCompany> selectByExample(NjOrderScenesCompanyExample example);

    NjOrderScenesCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderScenesCompany record, @Param("example") NjOrderScenesCompanyExample example);

    int updateByExample(@Param("record") NjOrderScenesCompany record, @Param("example") NjOrderScenesCompanyExample example);

    int updateByPrimaryKeySelective(NjOrderScenesCompany record);

    int updateByPrimaryKey(NjOrderScenesCompany record);
}