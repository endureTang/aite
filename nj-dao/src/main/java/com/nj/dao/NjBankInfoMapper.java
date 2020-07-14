package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjBankInfo;
import com.nj.model.generate.NjBankInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjBankInfoMapper extends BaseMapper {
    long countByExample(NjBankInfoExample example);

    int deleteByExample(NjBankInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NjBankInfo record);

    int insertSelective(NjBankInfo record);

    List<NjBankInfo> selectByExample(NjBankInfoExample example);

    NjBankInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NjBankInfo record, @Param("example") NjBankInfoExample example);

    int updateByExample(@Param("record") NjBankInfo record, @Param("example") NjBankInfoExample example);

    int updateByPrimaryKeySelective(NjBankInfo record);

    int updateByPrimaryKey(NjBankInfo record);
}