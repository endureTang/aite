package com.nj.service.remoteing;

import com.nj.core.base.entity.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Lizy
 * @version 2019/7/1.
 */
@FeignClient(value = "nd-task")
public interface NdTaskRepayPlanService {
    @RequestMapping("/repayPlan/changeStatus")
    ResponseDto changeStatus(@RequestParam("orderNo") String orderNo, @RequestParam("period") int period, @RequestParam("status") int status);
}
