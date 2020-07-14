package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderBhRecord;
import com.nj.model.generate.NjOrderBhRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderBhRecordMapper extends BaseMapper {
    long countByExample(NjOrderBhRecordExample example);

    int deleteByExample(NjOrderBhRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderBhRecord record);

    int insertSelective(NjOrderBhRecord record);

    List<NjOrderBhRecord> selectByExample(NjOrderBhRecordExample example);

    NjOrderBhRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderBhRecord record, @Param("example") NjOrderBhRecordExample example);

    int updateByExample(@Param("record") NjOrderBhRecord record, @Param("example") NjOrderBhRecordExample example);

    int updateByPrimaryKeySelective(NjOrderBhRecord record);

    int updateByPrimaryKey(NjOrderBhRecord record);
}