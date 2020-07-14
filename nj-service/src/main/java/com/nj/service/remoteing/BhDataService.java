package com.nj.service.remoteing;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nj.core.base.entity.ResponseDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 百行征信
 * @author MaSong
 * @date 2019-08-09
 */
@FeignClient(value = "data")
public interface BhDataService {

	/**
	 * 百行征信查询
	 * @param data	该字段是加密传递的JSON，字段由companyCode和requestMsg组成。
	 * @param companyCode 公司编号，平台提供。【该字段为data的解释，无需传递】
	 * @param requestMsg 请求信息，该字段为JSON，与百行请求数据对齐，字段不需要加密。【该字段为data的解释，无需传递】
	 * @return
	 */
	@RequestMapping(value = "/bh/queryBhForC1",method = {RequestMethod.POST})
	public ResponseDto<String> queryBhForC1(@RequestParam("data") String data);
	
	/**
	 * 非循环贷款账户数据上传
	 * @param data	该字段是加密传递的JSON，字段由companyCode和requestMsg组成。
	 * @param companyCode 公司编号，平台提供。【该字段为data的解释，无需传递】
	 * @param requestMsg 请求信息，该字段为JSON，与百行请求数据对齐，字段不需要加密。【该字段为data的解释，无需传递】
	 * @return
	 */
	@RequestMapping(value = "/bh/uploadBhForD2", method = {RequestMethod.POST})
	public ResponseDto<String> uploadBhForD2(String data); 
	
	/**
	 * 非循环贷款贷后数据上传
	 * @param data	该字段是加密传递的JSON，字段由companyCode和requestMsg组成。
	 * @param companyCode 公司编号，平台提供。【该字段为data的解释，无需传递】
	 * @param requestMsg 请求信息，该字段为JSON，与百行请求数据对齐，字段不需要加密。【该字段为data的解释，无需传递】
	 * @return
	 */
	@RequestMapping(value = "/bh/uploadBhForD3", method = {RequestMethod.POST})
	public ResponseDto<String> uploadBhForD3(String data);
	
	/**
	 * 非循环贷款展期数据上传
	 * @param data	该字段是加密传递的JSON，字段由companyCode和requestMsg组成。
	 * @param companyCode 公司编号，平台提供。【该字段为data的解释，无需传递】
	 * @param requestMsg 请求信息，该字段为JSON，与百行请求数据对齐，字段不需要加密。【该字段为data的解释，无需传递】
	 * @return
	 */
	@RequestMapping(value = "/bh/uploadBhForD4", method = {RequestMethod.POST})
	public ResponseDto<String> uploadBhForD4(String data);
}
