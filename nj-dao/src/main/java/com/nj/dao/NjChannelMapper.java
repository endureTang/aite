package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjChannel;
import com.nj.model.generate.NjChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjChannelMapper extends BaseMapper {
    long countByExample(NjChannelExample example);

    int deleteByExample(NjChannelExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjChannel record);

    int insertSelective(NjChannel record);

    List<NjChannel> selectByExample(NjChannelExample example);

    NjChannel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjChannel record, @Param("example") NjChannelExample example);

    int updateByExample(@Param("record") NjChannel record, @Param("example") NjChannelExample example);

    int updateByPrimaryKeySelective(NjChannel record);

    int updateByPrimaryKey(NjChannel record);
}