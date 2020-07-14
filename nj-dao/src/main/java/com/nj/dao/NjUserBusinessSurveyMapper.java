package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserBusinessSurvey;
import com.nj.model.generate.NjUserBusinessSurveyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserBusinessSurveyMapper extends BaseMapper {
    long countByExample(NjUserBusinessSurveyExample example);

    int deleteByExample(NjUserBusinessSurveyExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserBusinessSurvey record);

    int insertSelective(NjUserBusinessSurvey record);

    List<NjUserBusinessSurvey> selectByExample(NjUserBusinessSurveyExample example);

    NjUserBusinessSurvey selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserBusinessSurvey record, @Param("example") NjUserBusinessSurveyExample example);

    int updateByExample(@Param("record") NjUserBusinessSurvey record, @Param("example") NjUserBusinessSurveyExample example);

    int updateByPrimaryKeySelective(NjUserBusinessSurvey record);

    int updateByPrimaryKey(NjUserBusinessSurvey record);
}