package com.nj.dao;

import com.nj.model.generate.NjOrderHuoti;
import com.nj.model.generate.NjOrderHuotiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderHuotiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    long countByExample(NjOrderHuotiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    int deleteByExample(NjOrderHuotiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    int insert(NjOrderHuoti record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    int insertSelective(NjOrderHuoti record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    List<NjOrderHuoti> selectByExample(NjOrderHuotiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    NjOrderHuoti selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    int updateByExampleSelective(@Param("record") NjOrderHuoti record, @Param("example") NjOrderHuotiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    int updateByExample(@Param("record") NjOrderHuoti record, @Param("example") NjOrderHuotiExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    int updateByPrimaryKeySelective(NjOrderHuoti record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_huoti
     *
     * @mbg.generated Mon Jul 31 10:04:52 CST 2017
     */
    int updateByPrimaryKey(NjOrderHuoti record);
}