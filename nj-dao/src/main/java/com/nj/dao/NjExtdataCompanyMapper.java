package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjExtdataCompany;
import com.nj.model.generate.NjExtdataCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjExtdataCompanyMapper extends BaseMapper {
    int countByExample(NjExtdataCompanyExample example);

    int deleteByExample(NjExtdataCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjExtdataCompany record);

    int insertSelective(NjExtdataCompany record);

    List<NjExtdataCompany> selectByExample(NjExtdataCompanyExample example);

    NjExtdataCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjExtdataCompany record, @Param("example") NjExtdataCompanyExample example);

    int updateByExample(@Param("record") NjExtdataCompany record, @Param("example") NjExtdataCompanyExample example);

    int updateByPrimaryKeySelective(NjExtdataCompany record);

    int updateByPrimaryKey(NjExtdataCompany record);
}