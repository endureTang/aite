package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProdRepaymentObj;
import com.nj.model.generate.NjProdRepaymentObjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProdRepaymentObjMapper extends BaseMapper {
    long countByExample(NjProdRepaymentObjExample example);

    int deleteByExample(NjProdRepaymentObjExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProdRepaymentObj record);

    int insertSelective(NjProdRepaymentObj record);

    List<NjProdRepaymentObj> selectByExample(NjProdRepaymentObjExample example);

    NjProdRepaymentObj selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProdRepaymentObj record, @Param("example") NjProdRepaymentObjExample example);

    int updateByExample(@Param("record") NjProdRepaymentObj record, @Param("example") NjProdRepaymentObjExample example);

    int updateByPrimaryKeySelective(NjProdRepaymentObj record);

    int updateByPrimaryKey(NjProdRepaymentObj record);
}