package com.nj.service.remoteing;

import com.nj.core.base.entity.ResponseDto;
import com.nj.model.generate.NjStatisticsThreePartyCall;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author Lizy
 * @version 2018/5/4.
 */
@FeignClient(value = "data")
public interface StatisticsService {
    @RequestMapping(value = "/statistics/get")
    ResponseDto<List<NjStatisticsThreePartyCall>> getStatistics(@RequestParam("startTime") Date startTime, @RequestParam("endTime") Date endTime);
}
