package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductContractTemplate;
import com.nj.model.generate.NjProductContractTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjProductContractTemplateMapper extends BaseMapper {
    int countByExample(NjProductContractTemplateExample example);

    int deleteByExample(NjProductContractTemplateExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjProductContractTemplate record);

    int insertSelective(NjProductContractTemplate record);

    List<NjProductContractTemplate> selectByExample(NjProductContractTemplateExample example);

    NjProductContractTemplate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjProductContractTemplate record, @Param("example") NjProductContractTemplateExample example);

    int updateByExample(@Param("record") NjProductContractTemplate record, @Param("example") NjProductContractTemplateExample example);

    int updateByPrimaryKeySelective(NjProductContractTemplate record);

    int updateByPrimaryKey(NjProductContractTemplate record);
}