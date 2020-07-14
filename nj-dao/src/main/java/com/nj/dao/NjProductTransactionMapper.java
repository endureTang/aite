package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductTransaction;
import com.nj.model.generate.NjProductTransactionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductTransactionMapper extends BaseMapper {
    long countByExample(NjProductTransactionExample example);

    int deleteByExample(NjProductTransactionExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProductTransaction record);

    int insertSelective(NjProductTransaction record);

    List<NjProductTransaction> selectByExample(NjProductTransactionExample example);

    NjProductTransaction selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProductTransaction record, @Param("example") NjProductTransactionExample example);

    int updateByExample(@Param("record") NjProductTransaction record, @Param("example") NjProductTransactionExample example);

    int updateByPrimaryKeySelective(NjProductTransaction record);

    int updateByPrimaryKey(NjProductTransaction record);
}