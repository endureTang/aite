package com.nj.service.remoteing;

import com.nj.core.base.entity.ResponseDto;
import com.nj.mongoModel.PpxQueryData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Lizy
 * @version 2018/4/26.
 */
@FeignClient(value = "data")
public interface PpxRiskListService {

    @RequestMapping(value = "/ppx/getRiskList")
    ResponseDto<PpxQueryData> getRiskList(@RequestParam("username") String username, @RequestParam("identifyId") String identifyId,
                                          @RequestParam("mobile") String mobile, @RequestParam("userId") String userId,
                                          @RequestParam("orderId") String orderId, @RequestParam("companyId") String companyId);
}
