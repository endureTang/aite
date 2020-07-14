package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjChannelUser;
import com.nj.model.generate.NjChannelUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjChannelUserMapper extends BaseMapper {
    int countByExample(NjChannelUserExample example);

    int deleteByExample(NjChannelUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjChannelUser record);

    int insertSelective(NjChannelUser record);

    List<NjChannelUser> selectByExample(NjChannelUserExample example);

    NjChannelUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjChannelUser record, @Param("example") NjChannelUserExample example);

    int updateByExample(@Param("record") NjChannelUser record, @Param("example") NjChannelUserExample example);

    int updateByPrimaryKeySelective(NjChannelUser record);

    int updateByPrimaryKey(NjChannelUser record);
}