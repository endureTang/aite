package com.nj.dao;

import com.nj.model.generate.NjAcceptThresholds;
import com.nj.model.generate.NjAcceptThresholdsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjAcceptThresholdsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	long countByExample(NjAcceptThresholdsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int deleteByExample(NjAcceptThresholdsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int insert(NjAcceptThresholds record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int insertSelective(NjAcceptThresholds record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	List<NjAcceptThresholds> selectByExample(NjAcceptThresholdsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	NjAcceptThresholds selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByExampleSelective(@Param("record") NjAcceptThresholds record,
			@Param("example") NjAcceptThresholdsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByExample(@Param("record") NjAcceptThresholds record,
			@Param("example") NjAcceptThresholdsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByPrimaryKeySelective(NjAcceptThresholds record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_accept_thresholds
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByPrimaryKey(NjAcceptThresholds record);
}