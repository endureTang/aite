package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserDebtMessageRecord;
import com.nj.model.generate.NjUserDebtMessageRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserDebtMessageRecordMapper extends BaseMapper {
    long countByExample(NjUserDebtMessageRecordExample example);

    int deleteByExample(NjUserDebtMessageRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserDebtMessageRecord record);

    int insertSelective(NjUserDebtMessageRecord record);

    List<NjUserDebtMessageRecord> selectByExample(NjUserDebtMessageRecordExample example);

    NjUserDebtMessageRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserDebtMessageRecord record, @Param("example") NjUserDebtMessageRecordExample example);

    int updateByExample(@Param("record") NjUserDebtMessageRecord record, @Param("example") NjUserDebtMessageRecordExample example);

    int updateByPrimaryKeySelective(NjUserDebtMessageRecord record);

    int updateByPrimaryKey(NjUserDebtMessageRecord record);
}