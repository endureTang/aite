package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjChannelRequset;
import com.nj.model.generate.NjChannelRequsetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjChannelRequsetMapper extends BaseMapper {
    long countByExample(NjChannelRequsetExample example);

    int deleteByExample(NjChannelRequsetExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjChannelRequset record);

    int insertSelective(NjChannelRequset record);

    List<NjChannelRequset> selectByExampleWithBLOBs(NjChannelRequsetExample example);

    List<NjChannelRequset> selectByExample(NjChannelRequsetExample example);

    NjChannelRequset selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjChannelRequset record, @Param("example") NjChannelRequsetExample example);

    int updateByExampleWithBLOBs(@Param("record") NjChannelRequset record, @Param("example") NjChannelRequsetExample example);

    int updateByExample(@Param("record") NjChannelRequset record, @Param("example") NjChannelRequsetExample example);

    int updateByPrimaryKeySelective(NjChannelRequset record);

    int updateByPrimaryKeyWithBLOBs(NjChannelRequset record);

    int updateByPrimaryKey(NjChannelRequset record);
}