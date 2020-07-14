package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjWithdrawingRecord;
import com.nj.model.generate.NjWithdrawingRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjWithdrawingRecordMapper extends BaseMapper {
    long countByExample(NjWithdrawingRecordExample example);

    int deleteByExample(NjWithdrawingRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjWithdrawingRecord record);

    int insertSelective(NjWithdrawingRecord record);

    List<NjWithdrawingRecord> selectByExample(NjWithdrawingRecordExample example);

    NjWithdrawingRecord selectByPrimaryKey(String id);;

    int updateByExampleSelective(@Param("record") NjWithdrawingRecord record, @Param("example") NjWithdrawingRecordExample example);

    int updateByExample(@Param("record") NjWithdrawingRecord record, @Param("example") NjWithdrawingRecordExample example);

    int updateByPrimaryKeySelective(NjWithdrawingRecord record);

    int updateByPrimaryKey(NjWithdrawingRecord record);
}