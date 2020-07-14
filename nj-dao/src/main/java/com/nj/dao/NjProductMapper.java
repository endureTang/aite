package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductMapper extends BaseMapper {
    long countByExample(NjProductExample example);

    int deleteByExample(NjProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProduct record);

    int insertSelective(NjProduct record);

    List<NjProduct> selectByExample(NjProductExample example);

    NjProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProduct record, @Param("example") NjProductExample example);

    int updateByExample(@Param("record") NjProduct record, @Param("example") NjProductExample example);

    int updateByPrimaryKeySelective(NjProduct record);

    int updateByPrimaryKey(NjProduct record);
}