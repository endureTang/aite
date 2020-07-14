package com.nj.dao;

import com.nj.model.generate.NjUserRelatives;
import com.nj.model.generate.NjUserRelativesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.nj.core.base.mapper.BaseMapper;

public interface NjUserRelativesMapper extends BaseMapper {

	long countByExample(NjUserRelativesExample example);

	int deleteByExample(NjUserRelativesExample example);

	int deleteByPrimaryKey(String id);

	int insert(NjUserRelatives record);

	int insertSelective(NjUserRelatives record);

	List<NjUserRelatives> selectByExample(NjUserRelativesExample example);

	NjUserRelatives selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") NjUserRelatives record,
			@Param("example") NjUserRelativesExample example);

	int updateByExample(@Param("record") NjUserRelatives record, @Param("example") NjUserRelativesExample example);

	int updateByPrimaryKeySelective(NjUserRelatives record);

	int updateByPrimaryKey(NjUserRelatives record);
}