package com.nj.dao;

import com.nj.model.generate.NjUserCredit;
import com.nj.model.generate.NjUserCreditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserCreditMapper {
    long countByExample(NjUserCreditExample example);

    int deleteByExample(NjUserCreditExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserCredit record);

    int insertSelective(NjUserCredit record);

    List<NjUserCredit> selectByExample(NjUserCreditExample example);

    NjUserCredit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserCredit record, @Param("example") NjUserCreditExample example);

    int updateByExample(@Param("record") NjUserCredit record, @Param("example") NjUserCreditExample example);

    int updateByPrimaryKeySelective(NjUserCredit record);

    int updateByPrimaryKey(NjUserCredit record);
}