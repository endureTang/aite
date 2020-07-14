package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjContactCompany;
import com.nj.model.generate.NjContactCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjContactCompanyMapper extends BaseMapper {
    long countByExample(NjContactCompanyExample example);

    int deleteByExample(NjContactCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjContactCompany record);

    int insertSelective(NjContactCompany record);

    List<NjContactCompany> selectByExample(NjContactCompanyExample example);

    NjContactCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjContactCompany record, @Param("example") NjContactCompanyExample example);

    int updateByExample(@Param("record") NjContactCompany record, @Param("example") NjContactCompanyExample example);

    int updateByPrimaryKeySelective(NjContactCompany record);

    int updateByPrimaryKey(NjContactCompany record);
}