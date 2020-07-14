package com.nj.dao.esign.mapper.base;

import com.nj.model.esign.base.EsignSignRecord;
import com.nj.model.esign.base.EsignSignRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EsignSignRecordMapper {
    int countByExample(EsignSignRecordExample example);

    int deleteByExample(EsignSignRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(EsignSignRecord record);

    int insertSelective(EsignSignRecord record);

    List<EsignSignRecord> selectByExample(EsignSignRecordExample example);

    EsignSignRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EsignSignRecord record, @Param("example") EsignSignRecordExample example);

    int updateByExample(@Param("record") EsignSignRecord record, @Param("example") EsignSignRecordExample example);

    int updateByPrimaryKeySelective(EsignSignRecord record);

    int updateByPrimaryKey(EsignSignRecord record);
}