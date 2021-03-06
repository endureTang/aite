package com.nj.dao.extend;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.core.base.util.PageData;
import com.nj.model.datamodel.StockCollectModel;
import com.nj.model.datamodel.StockCollectZipModel;
import com.nj.model.generate.ActivityStock;
import com.nj.model.generate.StockCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockCollectMapperExtend extends BaseMapper {

    void insertBath(List<StockCollect> list);

    List<ActivityStock> selectPage(PageData pd);

    List<String> getStoreNameList();

    List<StockCollectZipModel> selectByStoreName(@Param("storeName") String storeName);

    List<StockCollectModel> selectCollectList();

    long selectCollectCount();


    List<StockCollectModel> selectCollectListPage(@Param("start") int start, @Param("end")int end);
}