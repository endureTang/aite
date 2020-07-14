package com.nj.service.remoteing;

import com.nj.model.mq.RepayPlanMq;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nj.core.base.entity.ResponseDto;
import com.nj.model.mq.OrderMq;

/**
 * 
 * @Name com.nj.service.remoteing.IMqService
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月29日 下午1:16:29
 * @Copyright 金鼎财富
 *
 */

@FeignClient(value="nd-task")
public interface IMqNdService {
	/**
	 * 发送订单过程消息队列
	 * @param orderMq
	 * @return
	 */
	@RequestMapping(value = "/mqHelper/sendOrderProcessMq", method = RequestMethod.POST)
	public ResponseDto<String> sendOrderProcessMq(@RequestBody OrderMq orderMq);

	/**
	 * 发送还款计划表消息
	 * @param repayPlanMq
	 * @return
	 */
	@RequestMapping(value="/mqHelper/sendRepayPlanMq",method = { RequestMethod.POST },produces={"application/json;charset=utf-8"})
	public ResponseDto<String> sendRepayPlanMq(@RequestBody RepayPlanMq repayPlanMq);
}
