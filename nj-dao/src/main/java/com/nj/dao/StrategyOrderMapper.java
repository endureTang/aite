package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.StrategyOrder;
import com.nj.model.generate.StrategyOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StrategyOrderMapper extends BaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int countByExample(StrategyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int deleteByExample(StrategyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int insert(StrategyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int insertSelective(StrategyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    List<StrategyOrder> selectByExample(StrategyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    StrategyOrder selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int updateByExampleSelective(@Param("record") StrategyOrder record, @Param("example") StrategyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int updateByExample(@Param("record") StrategyOrder record, @Param("example") StrategyOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int updateByPrimaryKeySelective(StrategyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table strategy_order
     *
     * @mbggenerated Tue Jul 21 13:58:13 CST 2020
     */
    int updateByPrimaryKey(StrategyOrder record);
}