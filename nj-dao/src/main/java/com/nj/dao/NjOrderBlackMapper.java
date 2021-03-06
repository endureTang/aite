package com.nj.dao;

import com.nj.model.generate.NjOrderBlack;
import com.nj.model.generate.NjOrderBlackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderBlackMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	long countByExample(NjOrderBlackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	int deleteByExample(NjOrderBlackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	int insert(NjOrderBlack record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	int insertSelective(NjOrderBlack record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	List<NjOrderBlack> selectByExample(NjOrderBlackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	NjOrderBlack selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	int updateByExampleSelective(@Param("record") NjOrderBlack record, @Param("example") NjOrderBlackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	int updateByExample(@Param("record") NjOrderBlack record, @Param("example") NjOrderBlackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	int updateByPrimaryKeySelective(NjOrderBlack record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_order_black
	 * @mbg.generated  Mon Jul 31 13:44:12 CST 2017
	 */
	int updateByPrimaryKey(NjOrderBlack record);
}