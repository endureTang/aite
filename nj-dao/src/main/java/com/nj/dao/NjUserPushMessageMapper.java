package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserPushMessage;
import com.nj.model.generate.NjUserPushMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserPushMessageMapper extends BaseMapper {
    long countByExample(NjUserPushMessageExample example);

    int deleteByExample(NjUserPushMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserPushMessage record);

    int insertSelective(NjUserPushMessage record);

    List<NjUserPushMessage> selectByExample(NjUserPushMessageExample example);

    NjUserPushMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserPushMessage record, @Param("example") NjUserPushMessageExample example);

    int updateByExample(@Param("record") NjUserPushMessage record, @Param("example") NjUserPushMessageExample example);

    int updateByPrimaryKeySelective(NjUserPushMessage record);

    int updateByPrimaryKey(NjUserPushMessage record);
}