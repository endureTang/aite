package com.nj.dao;

import com.nj.model.generate.NjLoanOrderPhoneCheck;
import com.nj.model.generate.NjLoanOrderPhoneCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjLoanOrderPhoneCheckMapper {
    long countByExample(NjLoanOrderPhoneCheckExample example);

    int deleteByExample(NjLoanOrderPhoneCheckExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjLoanOrderPhoneCheck record);

    int insertSelective(NjLoanOrderPhoneCheck record);

    List<NjLoanOrderPhoneCheck> selectByExample(NjLoanOrderPhoneCheckExample example);

    NjLoanOrderPhoneCheck selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjLoanOrderPhoneCheck record, @Param("example") NjLoanOrderPhoneCheckExample example);

    int updateByExample(@Param("record") NjLoanOrderPhoneCheck record, @Param("example") NjLoanOrderPhoneCheckExample example);

    int updateByPrimaryKeySelective(NjLoanOrderPhoneCheck record);

    int updateByPrimaryKey(NjLoanOrderPhoneCheck record);
}