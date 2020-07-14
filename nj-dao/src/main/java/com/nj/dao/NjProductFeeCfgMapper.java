package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductFeeCfg;
import com.nj.model.generate.NjProductFeeCfgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductFeeCfgMapper extends BaseMapper {
    long countByExample(NjProductFeeCfgExample example);

    int deleteByExample(NjProductFeeCfgExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProductFeeCfg record);

    int insertSelective(NjProductFeeCfg record);

    List<NjProductFeeCfg> selectByExample(NjProductFeeCfgExample example);

    NjProductFeeCfg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProductFeeCfg record, @Param("example") NjProductFeeCfgExample example);

    int updateByExample(@Param("record") NjProductFeeCfg record, @Param("example") NjProductFeeCfgExample example);

    int updateByPrimaryKeySelective(NjProductFeeCfg record);

    int updateByPrimaryKey(NjProductFeeCfg record);
}