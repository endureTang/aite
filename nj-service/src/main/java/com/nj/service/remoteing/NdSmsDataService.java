package com.nj.service.remoteing;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nj.core.base.entity.ResponseDto;
import com.nj.model.mq.SmsMq;

/**
 * 能贷短信调用Service
 * @author MaSong
 */
@FeignClient(value="nd-task")
public interface NdSmsDataService {
	
	/**
	 * 发送短信消息队列
	 * @param orderMq
	 * @return
	 */
	@RequestMapping(value = "/mqHelper/sendSmsMq", method = RequestMethod.POST)
	public ResponseDto<String> sendSmsMq(@RequestBody SmsMq smsMq);

}
