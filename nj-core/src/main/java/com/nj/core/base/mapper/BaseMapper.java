/**
 * 
 */
package com.nj.core.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @Name com.nj.core.base.mapper.BaseMapper
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月21日下午2:47:16
 * @Copyright 金鼎财富
 *
 */
public interface BaseMapper<T, E> {
	
	long countByExample(E example);

	int deleteByExample(E example);

	int deleteByPrimaryKey(String id);

	int insert(T record);

	int insertSelective(T record);

	List<T> selectByExample(E example);

	T selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

	int updateByExample(@Param("record") T record, @Param("example") E example);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);
}
