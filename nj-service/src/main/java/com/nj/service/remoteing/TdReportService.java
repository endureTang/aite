package com.nj.service.remoteing;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nj.core.base.entity.ResponseDto;
import com.nj.mongoModel.TdReportData;

/**
 * 同盾微服务
 * @author Tangrenjian
 */
@FeignClient(value = "data")
public interface TdReportService {

	/**
     * 根据同盾ID获取同盾信息
     * @param tdReportData
     * @return
     */
    @PostMapping(value = "/td/getTdScoreByTdReportId")
    ResponseDto<TdReportData> getTdScoreByTdReportId(@RequestParam("tdReportId") String tdReportId);
    
    /**
     * 根据用户ID获取同盾信息
     * @param tdReportData
     * @return
     */
    @PostMapping(value = "/td/getTdScoreByUserId")
    ResponseDto<List<TdReportData>> getTdScoreByUserId(@RequestParam("userId") String userId);
    
    /**
     * 根据用户三要素生成并获取同盾报告
     * @param tdReportData
     * @return
     */
    @PostMapping(value = "/td/getTdReport")
    ResponseDto<TdReportData> getTdReport(@RequestBody TdReportData tdReportData);
    
    /**
     * 生产同盾报告
     * @param tdReportData
     * @return
     */
    @PostMapping(value = "/td/generateTdReport")
    ResponseDto<TdReportData> generateTdReport(@RequestBody TdReportData tdReportData);
    
    /**
     * 查询所有同盾报告
     */
    @PostMapping(value = "/td/getAll")
    List<TdReportData> getAll();
}
