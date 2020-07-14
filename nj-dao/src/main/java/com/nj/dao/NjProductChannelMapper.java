package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductChannelMapper extends BaseMapper {
    long countByExample(NjProductChannelExample example);

    int deleteByExample(NjProductChannelExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProductChannel record);

    int insertSelective(NjProductChannel record);

    List<NjProductChannel> selectByExample(NjProductChannelExample example);

    NjProductChannel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProductChannel record, @Param("example") NjProductChannelExample example);

    int updateByExample(@Param("record") NjProductChannel record, @Param("example") NjProductChannelExample example);

    int updateByPrimaryKeySelective(NjProductChannel record);

    int updateByPrimaryKey(NjProductChannel record);
}