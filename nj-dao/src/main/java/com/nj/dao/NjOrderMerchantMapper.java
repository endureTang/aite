package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderMerchant;
import com.nj.model.generate.NjOrderMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderMerchantMapper extends BaseMapper {
    long countByExample(NjOrderMerchantExample example);

    int deleteByExample(NjOrderMerchantExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderMerchant record);

    int insertSelective(NjOrderMerchant record);

    List<NjOrderMerchant> selectByExample(NjOrderMerchantExample example);

    NjOrderMerchant selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderMerchant record, @Param("example") NjOrderMerchantExample example);

    int updateByExample(@Param("record") NjOrderMerchant record, @Param("example") NjOrderMerchantExample example);

    int updateByPrimaryKeySelective(NjOrderMerchant record);

    int updateByPrimaryKey(NjOrderMerchant record);
}