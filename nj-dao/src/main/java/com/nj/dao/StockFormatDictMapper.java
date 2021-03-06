package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.StockFormatDict;
import com.nj.model.generate.StockFormatDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockFormatDictMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int countByExample(StockFormatDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int deleteByExample(StockFormatDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int insert(StockFormatDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int insertSelective(StockFormatDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    List<StockFormatDict> selectByExample(StockFormatDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    StockFormatDict selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int updateByExampleSelective(@Param("record") StockFormatDict record, @Param("example") StockFormatDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int updateByExample(@Param("record") StockFormatDict record, @Param("example") StockFormatDictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int updateByPrimaryKeySelective(StockFormatDict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stock_format_dict
     *
     * @mbggenerated Mon Jan 11 16:56:05 CST 2021
     */
    int updateByPrimaryKey(StockFormatDict record);
}