package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjLoanOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjLoanOrderMapper extends BaseMapper {
    long countByExample(NjLoanOrderExample example);

    int deleteByExample(NjLoanOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjLoanOrder record);

    int insertSelective(NjLoanOrder record);

    List<NjLoanOrder> selectByExample(NjLoanOrderExample example);

    NjLoanOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjLoanOrder record, @Param("example") NjLoanOrderExample example);

    int updateByExample(@Param("record") NjLoanOrder record, @Param("example") NjLoanOrderExample example);

    int updateByPrimaryKeySelective(NjLoanOrder record);

    int updateByPrimaryKey(NjLoanOrder record);
}