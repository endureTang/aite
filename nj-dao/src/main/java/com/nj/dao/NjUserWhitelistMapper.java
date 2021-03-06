package com.nj.dao;

import com.nj.model.generate.NjUserWhitelist;
import com.nj.model.generate.NjUserWhitelistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserWhitelistMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	long countByExample(NjUserWhitelistExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int deleteByExample(NjUserWhitelistExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int insert(NjUserWhitelist record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int insertSelective(NjUserWhitelist record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	List<NjUserWhitelist> selectByExample(NjUserWhitelistExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	NjUserWhitelist selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByExampleSelective(@Param("record") NjUserWhitelist record,
			@Param("example") NjUserWhitelistExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByExample(@Param("record") NjUserWhitelist record, @Param("example") NjUserWhitelistExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByPrimaryKeySelective(NjUserWhitelist record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_whitelist
	 * @mbg.generated  Tue Mar 07 15:58:03 CST 2017
	 */
	int updateByPrimaryKey(NjUserWhitelist record);
}