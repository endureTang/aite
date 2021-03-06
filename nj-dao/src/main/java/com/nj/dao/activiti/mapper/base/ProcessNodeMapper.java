package com.nj.dao.activiti.mapper.base;

import com.nj.model.activiti.base.ProcessNode;
import com.nj.model.activiti.base.ProcessNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessNodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int countByExample(ProcessNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int deleteByExample(ProcessNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int insert(ProcessNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int insertSelective(ProcessNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    List<ProcessNode> selectByExample(ProcessNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    ProcessNode selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int updateByExampleSelective(@Param("record") ProcessNode record, @Param("example") ProcessNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int updateByExample(@Param("record") ProcessNode record, @Param("example") ProcessNodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int updateByPrimaryKeySelective(ProcessNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process_node
     *
     * @mbggenerated Fri Jul 28 10:42:09 CST 2017
     */
    int updateByPrimaryKey(ProcessNode record);
}