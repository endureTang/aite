package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderArea;
import com.nj.model.generate.NjOrderAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderAreaMapper extends BaseMapper {
    int countByExample(NjOrderAreaExample example);

    int deleteByExample(NjOrderAreaExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderArea record);

    int insertSelective(NjOrderArea record);

    List<NjOrderArea> selectByExample(NjOrderAreaExample example);

    NjOrderArea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderArea record, @Param("example") NjOrderAreaExample example);

    int updateByExample(@Param("record") NjOrderArea record, @Param("example") NjOrderAreaExample example);

    int updateByPrimaryKeySelective(NjOrderArea record);

    int updateByPrimaryKey(NjOrderArea record);
}