package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjOrderChannel;
import com.nj.model.generate.NjOrderChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjOrderChannelMapper extends BaseMapper {
    int countByExample(NjOrderChannelExample example);

    int deleteByExample(NjOrderChannelExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjOrderChannel record);

    int insertSelective(NjOrderChannel record);

    List<NjOrderChannel> selectByExample(NjOrderChannelExample example);

    NjOrderChannel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjOrderChannel record, @Param("example") NjOrderChannelExample example);

    int updateByExample(@Param("record") NjOrderChannel record, @Param("example") NjOrderChannelExample example);

    int updateByPrimaryKeySelective(NjOrderChannel record);

    int updateByPrimaryKey(NjOrderChannel record);
}