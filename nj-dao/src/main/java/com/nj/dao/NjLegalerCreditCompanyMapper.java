package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjLegalerCreditCompany;
import com.nj.model.generate.NjLegalerCreditCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjLegalerCreditCompanyMapper extends BaseMapper {
    int countByExample(NjLegalerCreditCompanyExample example);

    int deleteByExample(NjLegalerCreditCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjLegalerCreditCompany record);

    int insertSelective(NjLegalerCreditCompany record);

    List<NjLegalerCreditCompany> selectByExample(NjLegalerCreditCompanyExample example);

    NjLegalerCreditCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjLegalerCreditCompany record, @Param("example") NjLegalerCreditCompanyExample example);

    int updateByExample(@Param("record") NjLegalerCreditCompany record, @Param("example") NjLegalerCreditCompanyExample example);

    int updateByPrimaryKeySelective(NjLegalerCreditCompany record);

    int updateByPrimaryKey(NjLegalerCreditCompany record);
}