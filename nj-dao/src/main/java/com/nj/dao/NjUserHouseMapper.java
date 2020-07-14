package com.nj.dao;

import com.nj.model.generate.NjUserHouse;
import com.nj.model.generate.NjUserHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.nj.core.base.mapper.BaseMapper;

public interface NjUserHouseMapper extends BaseMapper {

	long countByExample(NjUserHouseExample example);

	int deleteByExample(NjUserHouseExample example);

	int deleteByPrimaryKey(String id);

	int insert(NjUserHouse record);

	int insertSelective(NjUserHouse record);

	List<NjUserHouse> selectByExample(NjUserHouseExample example);

	NjUserHouse selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") NjUserHouse record, @Param("example") NjUserHouseExample example);

	int updateByExample(@Param("record") NjUserHouse record, @Param("example") NjUserHouseExample example);

	int updateByPrimaryKeySelective(NjUserHouse record);

	int updateByPrimaryKey(NjUserHouse record);
}