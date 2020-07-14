package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderPawnHouse;
import com.nj.model.generate.NjOrderPawnHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderPawnHouseMapper extends BaseMapper {
    long countByExample(NjOrderPawnHouseExample example);

    int deleteByExample(NjOrderPawnHouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderPawnHouse record);

    int insertSelective(NjOrderPawnHouse record);

    List<NjOrderPawnHouse> selectByExampleWithBLOBs(NjOrderPawnHouseExample example);

    List<NjOrderPawnHouse> selectByExample(NjOrderPawnHouseExample example);

    NjOrderPawnHouse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderPawnHouse record, @Param("example") NjOrderPawnHouseExample example);

    int updateByExampleWithBLOBs(@Param("record") NjOrderPawnHouse record, @Param("example") NjOrderPawnHouseExample example);

    int updateByExample(@Param("record") NjOrderPawnHouse record, @Param("example") NjOrderPawnHouseExample example);

    int updateByPrimaryKeySelective(NjOrderPawnHouse record);

    int updateByPrimaryKeyWithBLOBs(NjOrderPawnHouse record);

    int updateByPrimaryKey(NjOrderPawnHouse record);
}