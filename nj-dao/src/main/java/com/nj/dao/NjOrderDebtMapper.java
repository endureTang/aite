package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderDebt;
import com.nj.model.generate.NjOrderDebtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderDebtMapper extends BaseMapper {
    long countByExample(NjOrderDebtExample example);

    int deleteByExample(NjOrderDebtExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderDebt record);

    int insertSelective(NjOrderDebt record);

    List<NjOrderDebt> selectByExample(NjOrderDebtExample example);

    NjOrderDebt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderDebt record, @Param("example") NjOrderDebtExample example);

    int updateByExample(@Param("record") NjOrderDebt record, @Param("example") NjOrderDebtExample example);

    int updateByPrimaryKeySelective(NjOrderDebt record);

    int updateByPrimaryKey(NjOrderDebt record);
}