package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjCreditCompany;
import com.nj.model.generate.NjCreditCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjCreditCompanyMapper extends BaseMapper {
    int countByExample(NjCreditCompanyExample example);

    int deleteByExample(NjCreditCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjCreditCompany record);

    int insertSelective(NjCreditCompany record);

    List<NjCreditCompany> selectByExample(NjCreditCompanyExample example);

    NjCreditCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjCreditCompany record, @Param("example") NjCreditCompanyExample example);

    int updateByExample(@Param("record") NjCreditCompany record, @Param("example") NjCreditCompanyExample example);

    int updateByPrimaryKeySelective(NjCreditCompany record);

    int updateByPrimaryKey(NjCreditCompany record);
}