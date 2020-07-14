package com.nj.dao.extend;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductTransaction;

public interface NjProductTransactionMapperExtend extends BaseMapper {

    /**
     * 鏍规嵁浜у搧ID鑾峰彇浜у搧浜ゆ槗閰嶇疆
     *
     * @param productId
     * @return
     */
    Map<String, Object> selectByProductId(String productId);

    NjProductTransaction getRateByProductId(@Param("productId") String productId);

    NjProductTransaction selectByProductCode(@Param("productCode") String productCode);

    Map<String, Object> selectByProduct(@Param("productCode") String productCode);
}