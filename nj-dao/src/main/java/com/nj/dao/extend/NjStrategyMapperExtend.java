package com.nj.dao.extend;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjStrategy;
import com.nj.model.generate.NjStrategyExample;
import com.nj.model.generate.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NjStrategyMapperExtend extends BaseMapper {

    List<NjStrategy> selectPage(Map<?, ?> condition);

}