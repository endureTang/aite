package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjControllerCreditCompany;
import com.nj.model.generate.NjControllerCreditCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjControllerCreditCompanyMapper extends BaseMapper {
    int countByExample(NjControllerCreditCompanyExample example);

    int deleteByExample(NjControllerCreditCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjControllerCreditCompany record);

    int insertSelective(NjControllerCreditCompany record);

    List<NjControllerCreditCompany> selectByExample(NjControllerCreditCompanyExample example);

    NjControllerCreditCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjControllerCreditCompany record, @Param("example") NjControllerCreditCompanyExample example);

    int updateByExample(@Param("record") NjControllerCreditCompany record, @Param("example") NjControllerCreditCompanyExample example);

    int updateByPrimaryKeySelective(NjControllerCreditCompany record);

    int updateByPrimaryKey(NjControllerCreditCompany record);
}