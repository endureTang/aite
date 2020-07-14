package com.nj.service.remoteing;

import com.nj.core.base.entity.ResponseDto;
import com.nj.mongoModel.PhRepayDetail;
import com.nj.mongoModel.PhRepayPlan;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Lizy
 * @version 2018/4/18.
 */
@FeignClient(value = "after")
public interface PhRepaymentService {
    @RequestMapping(value = "/ph/repay/addPlan")
    ResponseDto addRepayPlan(@RequestParam("phRepayPlans") String phRepayPlans);

    @RequestMapping(value = "/ph/repay/addDetail")
    ResponseDto addRepayDetail(@RequestParam("phRepayDetail") String phRepayDetail);

}
