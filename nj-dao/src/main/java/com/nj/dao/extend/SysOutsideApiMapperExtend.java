package com.nj.dao.extend;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Lizy
 * @version 2018/6/27.
 */
public interface SysOutsideApiMapperExtend {
    /**
     * 获取所有第三方
     */
    List<Map> getAllThirdPartByGroup();

    /**
     * 根据第三方获取接口
     */
    List<Map> getAPiBySupplierName(@Param("supplierName") String supplierName);
}
