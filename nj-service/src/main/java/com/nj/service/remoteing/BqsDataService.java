package com.nj.service.remoteing;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nj.core.base.entity.ResponseDto;
import com.nj.mongoModel.BqsResponseData;

/**
 * 白骑士接口
 * @author MaSong
 * @date 2018-06-12 13:16:07
 */
@FeignClient(value = "data")
public interface BqsDataService {

	/**
	 * 白骑士事件查询
	 * @param eventType	事件类型：cust01:复杂网络 、cust02:多头名单、cust03:风险名单等等
	 * @param orderId	订单ID
	 * @param companyId 公司ID
	 * @param userId	用户ID
	 * @param name		姓名
	 * @param certNo	身份证
	 * @param mobile	手机号
	 * @return
	 */
	@RequestMapping(value = "/kngiht/queryBqsByEventType")
	ResponseDto<BqsResponseData> queryBqsByEventType(@RequestParam("eventType") String eventType,
			@RequestParam("orderId") String orderId,@RequestParam("companyId") String companyId, @RequestParam("userId") String userId,
			@RequestParam("name") String name, @RequestParam("certNo") String certNo,
			@RequestParam("mobile") String mobile);
	

	/**
	 * 白骑士复杂网络查询
	 * @param orderId	订单ID
	 * @param companyId 公司ID
	 * @param userId	用户ID
	 * @param name		姓名
	 * @param certNo	身份证
	 * @param mobile	手机号
	 * @return
	 */
	@RequestMapping(value = "/knight/queryBqsByNetwork")
	ResponseDto<BqsResponseData> queryBqsByNetwork(@RequestParam("orderId") String orderId,@RequestParam("companyId") String companyId,
			@RequestParam("userId") String userId, @RequestParam("name") String name,
			@RequestParam("certNo") String certNo, @RequestParam("mobile") String mobile);

	/**
	 * 白骑士多头名单查询
	 * @param orderId	订单ID
	 * @param companyId 公司ID
	 * @param userId	用户ID
	 * @param name		姓名
	 * @param certNo	身份证
	 * @param mobile	手机号
	 * @return
	 */
	@RequestMapping(value = "/knight/queryBqsByMoreHead")
	ResponseDto<BqsResponseData> queryBqsByMoreHead(@RequestParam("orderId") String orderId,@RequestParam("companyId") String companyId,
			@RequestParam("userId") String userId, @RequestParam("name") String name,
			@RequestParam("certNo") String certNo, @RequestParam("mobile") String mobile);
	
	/**
	 * 白骑士风险名单查询
	 * @param orderId	订单ID
	 * @param companyId 公司ID
	 * @param userId	用户ID
	 * @param name		姓名
	 * @param certNo	身份证
	 * @param mobile	手机号
	 * @return
	 */
	@RequestMapping(value = "/knight/queryBqsByRiskList")
	ResponseDto<BqsResponseData> queryBqsByRiskList(@RequestParam("orderId") String orderId,@RequestParam("companyId") String companyId,
			@RequestParam("userId") String userId, @RequestParam("name") String name,
			@RequestParam("certNo") String certNo, @RequestParam("mobile") String mobile);

}
