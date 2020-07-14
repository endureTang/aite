package com.nj.dao.extend;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Lizy
 * @version 2018/6/27.
 */
public interface NjStatisticsThreePartyCallMapperExtend {
    /**
     * 查询三方调用数据
     */
    List<Map> getThirdPart(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据公司查询三方调用数据
     */
    List<Map> getThirdPartByCompany(@Param("companyId")String companyId, @Param("startTime")String startTime,
                                    @Param("endTime")String endTime,@Param("thirdPart")String thirdPart,@Param("description")String description);
}
