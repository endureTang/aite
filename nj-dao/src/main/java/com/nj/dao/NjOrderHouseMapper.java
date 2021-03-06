package com.nj.dao;

import com.nj.model.generate.NjOrderHouse;
import com.nj.model.generate.NjOrderHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderHouseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    long countByExample(NjOrderHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    int deleteByExample(NjOrderHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    int insert(NjOrderHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    int insertSelective(NjOrderHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    List<NjOrderHouse> selectByExample(NjOrderHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    NjOrderHouse selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    int updateByExampleSelective(@Param("record") NjOrderHouse record, @Param("example") NjOrderHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    int updateByExample(@Param("record") NjOrderHouse record, @Param("example") NjOrderHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    int updateByPrimaryKeySelective(NjOrderHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_order_house
     *
     * @mbg.generated Thu Aug 03 10:27:13 CST 2017
     */
    int updateByPrimaryKey(NjOrderHouse record);
}