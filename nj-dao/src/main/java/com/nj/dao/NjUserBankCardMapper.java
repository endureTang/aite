package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserBankCard;
import com.nj.model.generate.NjUserBankCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserBankCardMapper extends BaseMapper {
    long countByExample(NjUserBankCardExample example);

    int deleteByExample(NjUserBankCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserBankCard record);

    int insertSelective(NjUserBankCard record);

    List<NjUserBankCard> selectByExample(NjUserBankCardExample example);

    NjUserBankCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserBankCard record, @Param("example") NjUserBankCardExample example);

    int updateByExample(@Param("record") NjUserBankCard record, @Param("example") NjUserBankCardExample example);

    int updateByPrimaryKeySelective(NjUserBankCard record);

    int updateByPrimaryKey(NjUserBankCard record);
}