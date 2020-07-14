package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserBusinessApproval;
import com.nj.model.generate.NjUserBusinessApprovalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserBusinessApprovalMapper extends BaseMapper {
    long countByExample(NjUserBusinessApprovalExample example);

    int deleteByExample(NjUserBusinessApprovalExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserBusinessApproval record);

    int insertSelective(NjUserBusinessApproval record);

    List<NjUserBusinessApproval> selectByExample(NjUserBusinessApprovalExample example);

    NjUserBusinessApproval selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserBusinessApproval record, @Param("example") NjUserBusinessApprovalExample example);

    int updateByExample(@Param("record") NjUserBusinessApproval record, @Param("example") NjUserBusinessApprovalExample example);

    int updateByPrimaryKeySelective(NjUserBusinessApproval record);

    int updateByPrimaryKey(NjUserBusinessApproval record);
}