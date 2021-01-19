package com.nj.dao.extend;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.core.base.util.PageData;
import com.nj.model.datamodel.ChannelStockModel;
import com.nj.model.datamodel.ChannelStockModelNew;
import com.nj.model.datamodel.ErrorErpModel;
import com.nj.model.generate.*;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ActivityStockMapperExtend extends BaseMapper {

    void insertBath(List<ActivityStock> list);

    List<ActivityStock> selectPage(PageData pd);
}