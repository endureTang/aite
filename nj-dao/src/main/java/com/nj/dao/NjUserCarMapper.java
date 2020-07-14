package com.nj.dao;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjUserCar;
import com.nj.model.generate.NjUserCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjUserCarMapper extends BaseMapper {
    long countByExample(NjUserCarExample example);

    int deleteByExample(NjUserCarExample example);

    int deleteByPrimaryKey(String id);

    int insert(NjUserCar record);

    int insertSelective(NjUserCar record);

    List<NjUserCar> selectByExample(NjUserCarExample example);

    NjUserCar selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NjUserCar record, @Param("example") NjUserCarExample example);

    int updateByExample(@Param("record") NjUserCar record, @Param("example") NjUserCarExample example);

    int updateByPrimaryKeySelective(NjUserCar record);

    int updateByPrimaryKey(NjUserCar record);
}