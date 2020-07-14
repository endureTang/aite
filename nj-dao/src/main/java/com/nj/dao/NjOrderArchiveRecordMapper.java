package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderArchiveRecord;
import com.nj.model.generate.NjOrderArchiveRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderArchiveRecordMapper extends BaseMapper {
    long countByExample(NjOrderArchiveRecordExample example);

    int deleteByExample(NjOrderArchiveRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderArchiveRecord record);

    int insertSelective(NjOrderArchiveRecord record);

    List<NjOrderArchiveRecord> selectByExample(NjOrderArchiveRecordExample example);

    NjOrderArchiveRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderArchiveRecord record, @Param("example") NjOrderArchiveRecordExample example);

    int updateByExample(@Param("record") NjOrderArchiveRecord record, @Param("example") NjOrderArchiveRecordExample example);

    int updateByPrimaryKeySelective(NjOrderArchiveRecord record);

    int updateByPrimaryKey(NjOrderArchiveRecord record);
}