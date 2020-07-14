package com.nj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjProductTemp;
import com.nj.model.generate.NjProductTempExample;

public interface NjProductTempMapper {
    long countByExample(NjProductTempExample example);

	int deleteByExample(NjProductTempExample example);

	int deleteByPrimaryKey(String id);

	int insert(NjProductTemp record);

	int insertSelective(NjProductTemp record);

	List<NjProductTemp> selectByExample(NjProductTempExample example);

	NjProductTemp selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") NjProductTemp record, @Param("example") NjProductTempExample example);

	int updateByExample(@Param("record") NjProductTemp record, @Param("example") NjProductTempExample example);

	int updateByPrimaryKeySelective(NjProductTemp record);

	int updateByPrimaryKey(NjProductTemp record);

	
}