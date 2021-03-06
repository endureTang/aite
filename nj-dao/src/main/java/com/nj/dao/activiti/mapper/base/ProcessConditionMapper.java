package com.nj.dao.activiti.mapper.base;

import com.nj.model.activiti.base.ProcessCondition;
import com.nj.model.activiti.base.ProcessConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessConditionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int countByExample(ProcessConditionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int deleteByExample(ProcessConditionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int insert(ProcessCondition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int insertSelective(ProcessCondition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    List<ProcessCondition> selectByExample(ProcessConditionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    ProcessCondition selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int updateByExampleSelective(@Param("record") ProcessCondition record, @Param("example") ProcessConditionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int updateByExample(@Param("record") ProcessCondition record, @Param("example") ProcessConditionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int updateByPrimaryKeySelective(ProcessCondition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_condition
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int updateByPrimaryKey(ProcessCondition record);
}