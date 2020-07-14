package com.nj.dao;

import com.nj.model.generate.NjUserDebtInfo;
import com.nj.model.generate.NjUserDebtInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.nj.core.base.mapper.BaseMapper;

public interface NjUserDebtInfoMapper extends BaseMapper {

	long countByExample(NjUserDebtInfoExample example);

	int deleteByExample(NjUserDebtInfoExample example);

	int deleteByPrimaryKey(String id);

	int insert(NjUserDebtInfo record);

	int insertSelective(NjUserDebtInfo record);

	List<NjUserDebtInfo> selectByExample(NjUserDebtInfoExample example);

	NjUserDebtInfo selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") NjUserDebtInfo record,
			@Param("example") NjUserDebtInfoExample example);

	int updateByExample(@Param("record") NjUserDebtInfo record, @Param("example") NjUserDebtInfoExample example);

	int updateByPrimaryKeySelective(NjUserDebtInfo record);

	int updateByPrimaryKey(NjUserDebtInfo record);
}