package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjDeductionNotice;
import com.nj.model.generate.NjDeductionNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjDeductionNoticeMapper extends BaseMapper {
    long countByExample(NjDeductionNoticeExample example);

    int deleteByExample(NjDeductionNoticeExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjDeductionNotice record);

    int insertSelective(NjDeductionNotice record);

    List<NjDeductionNotice> selectByExample(NjDeductionNoticeExample example);

    NjDeductionNotice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjDeductionNotice record, @Param("example") NjDeductionNoticeExample example);

    int updateByExample(@Param("record") NjDeductionNotice record, @Param("example") NjDeductionNoticeExample example);

    int updateByPrimaryKeySelective(NjDeductionNotice record);

    int updateByPrimaryKey(NjDeductionNotice record);
}