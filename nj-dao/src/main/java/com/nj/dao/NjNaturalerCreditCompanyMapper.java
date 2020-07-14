package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjNaturalerCreditCompany;
import com.nj.model.generate.NjNaturalerCreditCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjNaturalerCreditCompanyMapper extends BaseMapper {
    int countByExample(NjNaturalerCreditCompanyExample example);

    int deleteByExample(NjNaturalerCreditCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjNaturalerCreditCompany record);

    int insertSelective(NjNaturalerCreditCompany record);

    List<NjNaturalerCreditCompany> selectByExample(NjNaturalerCreditCompanyExample example);

    NjNaturalerCreditCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjNaturalerCreditCompany record, @Param("example") NjNaturalerCreditCompanyExample example);

    int updateByExample(@Param("record") NjNaturalerCreditCompany record, @Param("example") NjNaturalerCreditCompanyExample example);

    int updateByPrimaryKeySelective(NjNaturalerCreditCompany record);

    int updateByPrimaryKey(NjNaturalerCreditCompany record);
}