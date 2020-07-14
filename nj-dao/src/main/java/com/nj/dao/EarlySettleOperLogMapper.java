package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.EarlySettleOperLog;
import com.nj.model.generate.EarlySettleOperLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EarlySettleOperLogMapper extends BaseMapper {
    int countByExample(EarlySettleOperLogExample example);

    int deleteByExample(EarlySettleOperLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(EarlySettleOperLog record);

    int insertSelective(EarlySettleOperLog record);

    List<EarlySettleOperLog> selectByExampleWithBLOBs(EarlySettleOperLogExample example);

    List<EarlySettleOperLog> selectByExample(EarlySettleOperLogExample example);

    EarlySettleOperLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EarlySettleOperLog record, @Param("example") EarlySettleOperLogExample example);

    int updateByExampleWithBLOBs(@Param("record") EarlySettleOperLog record, @Param("example") EarlySettleOperLogExample example);

    int updateByExample(@Param("record") EarlySettleOperLog record, @Param("example") EarlySettleOperLogExample example);

    int updateByPrimaryKeySelective(EarlySettleOperLog record);

    int updateByPrimaryKeyWithBLOBs(EarlySettleOperLog record);

    int updateByPrimaryKey(EarlySettleOperLog record);
}