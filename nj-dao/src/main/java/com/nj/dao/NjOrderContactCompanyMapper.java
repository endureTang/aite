package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderContactCompany;
import com.nj.model.generate.NjOrderContactCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderContactCompanyMapper extends BaseMapper {
    long countByExample(NjOrderContactCompanyExample example);

    int deleteByExample(NjOrderContactCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderContactCompany record);

    int insertSelective(NjOrderContactCompany record);

    List<NjOrderContactCompany> selectByExample(NjOrderContactCompanyExample example);

    NjOrderContactCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderContactCompany record, @Param("example") NjOrderContactCompanyExample example);

    int updateByExample(@Param("record") NjOrderContactCompany record, @Param("example") NjOrderContactCompanyExample example);

    int updateByPrimaryKeySelective(NjOrderContactCompany record);

    int updateByPrimaryKey(NjOrderContactCompany record);
}