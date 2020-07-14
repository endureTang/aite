package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserActivateNotice;
import com.nj.model.generate.NjUserActivateNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserActivateNoticeMapper extends BaseMapper {
    long countByExample(NjUserActivateNoticeExample example);

    int deleteByExample(NjUserActivateNoticeExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserActivateNotice record);

    int insertSelective(NjUserActivateNotice record);

    List<NjUserActivateNotice> selectByExample(NjUserActivateNoticeExample example);

    NjUserActivateNotice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserActivateNotice record, @Param("example") NjUserActivateNoticeExample example);

    int updateByExample(@Param("record") NjUserActivateNotice record, @Param("example") NjUserActivateNoticeExample example);

    int updateByPrimaryKeySelective(NjUserActivateNotice record);

    int updateByPrimaryKey(NjUserActivateNotice record);
}