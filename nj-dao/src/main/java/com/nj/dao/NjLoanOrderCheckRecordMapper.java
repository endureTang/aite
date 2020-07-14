package com.nj.dao;

import com.nj.model.generate.NjLoanOrderCheckRecord;
import com.nj.model.generate.NjLoanOrderCheckRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjLoanOrderCheckRecordMapper {
    long countByExample(NjLoanOrderCheckRecordExample example);

    int deleteByExample(NjLoanOrderCheckRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjLoanOrderCheckRecord record);

    int insertSelective(NjLoanOrderCheckRecord record);

    List<NjLoanOrderCheckRecord> selectByExample(NjLoanOrderCheckRecordExample example);

    NjLoanOrderCheckRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjLoanOrderCheckRecord record, @Param("example") NjLoanOrderCheckRecordExample example);

    int updateByExample(@Param("record") NjLoanOrderCheckRecord record, @Param("example") NjLoanOrderCheckRecordExample example);

    int updateByPrimaryKeySelective(NjLoanOrderCheckRecord record);

    int updateByPrimaryKey(NjLoanOrderCheckRecord record);
}