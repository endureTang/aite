package com.nj.service.remoteing;

import com.nj.core.base.entity.ResponseDto;
import com.nj.mongoModel.BrApplyLoanData;
import com.nj.mongoModel.BrIdTwoData;
import com.nj.mongoModel.BrRiskStrategyData;
import com.nj.mongoModel.BrSpecialData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Lizy
 * @version 2018/4/26.
 */
@FeignClient(value = "data")
public interface BrDataListService {
    @RequestMapping(value = "/br/findSpecialData")
    ResponseDto<BrSpecialData> findSpecialData(@RequestParam("username") String username, @RequestParam("identifyId") String identifyId,
                                               @RequestParam("mobile") String mobile, @RequestParam("userId") String userId,
                                               @RequestParam("orderId") String orderId, @RequestParam("companyId") String companyId);

    @RequestMapping(value = "/br/findIdTowData")
    ResponseDto<BrIdTwoData> findIdTowData(@RequestParam("username") String username, @RequestParam("identifyId") String identifyId,
                                           @RequestParam("userId") String userId, @RequestParam("orderId") String orderId, @RequestParam("companyId") String companyId);

    @RequestMapping("/br/findRiskStrategyData")
    public ResponseDto<BrRiskStrategyData> findRiskStrategyData(@RequestParam("username") String username, @RequestParam("identifyId") String identifyId,
                                                                @RequestParam("mobile") String mobile, @RequestParam("userId") String userId,
                                                                @RequestParam("orderId") String orderId, @RequestParam("companyId") String companyId);

    // 借贷意向验证
    @RequestMapping("/br/findApplyLoanData")
    ResponseDto<BrApplyLoanData> findApplyLoanData(@RequestParam("username") String username, @RequestParam("identifyId") String identifyId,
                                                   @RequestParam("mobile") String mobile, @RequestParam("userId") String userId,
                                                   @RequestParam("orderId") String orderId, @RequestParam("companyId") String companyId);

}
