package com.nj.service.remoteing;

import com.nj.core.base.entity.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Lizy
 * @version 2018/5/8.
 */
@FeignClient("data")
public interface DecisionService {
    @RequestMapping("/decision/save")
    public ResponseDto saveDecisionResult(@RequestParam("orderId") String orderId, @RequestParam("data") String data);
}
