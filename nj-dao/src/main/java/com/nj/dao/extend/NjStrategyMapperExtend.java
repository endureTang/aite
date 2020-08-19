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

public interface NjStrategyMapperExtend extends BaseMapper {

    List<NjStrategy> selectPage(Map<?, ?> condition);

    List<ErpOrder> selectPageErpOrder(Map<?, ?> condition);

    List<ErpOrder> getErpOrderBySourceNo(@Param("sourceNo") String sourceNo, @Param("stockNo") String stockNo, @Param("specification") String specification);

    List<StockFormat> selectPageStockFormat(PageData pd);

    List<StockBase> selectPageStockBase(PageData pd);

    List<ChannelStock> selectPageChannelStock(PageData pd);

    void insertBath(ArrayList<ChannelStock> list);

    List<ChannelStockModel> selectPageChannelStockModel(PageData pd);

    List<ChannelStockModelNew> selectPageChannelStockModelNew(PageData pd);

    List<ErrorErpModel> listErrorErp();

    void bathInsertErpOrder(ArrayList<ErpOrder> list);

    void bathInsertErrorErpOrder(List<ErrorErpOrderModel> list);

    void insertBlackStockBath(ArrayList<BlackStock> list);

    List<BlackStock> selectPageBlackStock(PageData pd);

    int countErpOrder(PageData pd);
}