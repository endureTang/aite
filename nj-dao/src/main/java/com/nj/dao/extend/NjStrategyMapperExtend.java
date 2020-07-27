package com.nj.dao.extend;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.core.base.util.PageData;
import com.nj.model.generate.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NjStrategyMapperExtend extends BaseMapper {

    List<NjStrategy> selectPage(Map<?, ?> condition);

    List<ErpOrder> selectPageErpOrder(Map<?, ?> condition);

    List<ErpOrder> getErpOrderBySourceNo(String souruceNo);

    List<StockFormat> selectPageStockFormat(PageData pd);

    List<StockBase> selectPageStockBase(PageData pd);
}