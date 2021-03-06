package com.nj.dao;

import com.nj.model.generate.NjUserCert;
import com.nj.model.generate.NjUserCertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserCertMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	long countByExample(NjUserCertExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	int deleteByExample(NjUserCertExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	int insert(NjUserCert record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	int insertSelective(NjUserCert record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	List<NjUserCert> selectByExample(NjUserCertExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	NjUserCert selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	int updateByExampleSelective(@Param("record") NjUserCert record, @Param("example") NjUserCertExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	int updateByExample(@Param("record") NjUserCert record, @Param("example") NjUserCertExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	int updateByPrimaryKeySelective(NjUserCert record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table nj_user_cert
	 * @mbg.generated  Thu Jul 27 15:47:42 CST 2017
	 */
	int updateByPrimaryKey(NjUserCert record);
}