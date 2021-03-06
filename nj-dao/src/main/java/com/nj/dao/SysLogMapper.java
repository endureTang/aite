package com.nj.dao;

import com.nj.model.generate.SysLog;
import com.nj.model.generate.SysLogExample;
import com.nj.model.generate.SysLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	long countByExample(SysLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int deleteByExample(SysLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int insert(SysLogWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int insertSelective(SysLogWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	List<SysLogWithBLOBs> selectByExampleWithBLOBs(SysLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	List<SysLog> selectByExample(SysLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	SysLogWithBLOBs selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByExampleSelective(@Param("record") SysLogWithBLOBs record, @Param("example") SysLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") SysLogWithBLOBs record, @Param("example") SysLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByPrimaryKeySelective(SysLogWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(SysLogWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_log
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByPrimaryKey(SysLog record);
}