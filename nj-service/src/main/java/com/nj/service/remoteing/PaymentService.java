//package com.nj.service.remoteing;
//
//import java.util.List;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//
//
//@FeignClient(value = "jd-payment-web")
//public interface PaymentService {
//
//	/**
//	 * 获取短信验证码
//	 * @param smsCodeReqDto
//	 * @return
//	 */
//	@PostMapping("/transController/getsmsCode")
//	public PayResponseDto<SmsCodeRespDto> getsmsCode(@RequestBody SmsCodeReqDto smsCodeReqDto);
//
//
//	/**
//	 * 用户验证
//	 * @param validateUserReqDto
//	 * @return
//	 */
//	@PostMapping("/transController/validateUser")
//	public PayResponseDto<ValidateUserRespDto> validateUser(@RequestBody ValidateUserReqDto validateUserReqDto);
//
//	/**
//	 * 扣款
//	 * @param deductMoneyReqDto
//	 * @return
//	 */
//	@PostMapping("/transController/deductMoney")
//	public PayResponseDto<DeductMoneyRespDto> deductMoney(@RequestBody DeductMoneyReqDto deductMoneyReqDto);
//
//
//	/**
//	 * 扣款订单查询
//	 * @param deductMoneyOrderReqDto
//	 * @return
//	 */
//	@PostMapping("/transController/deductMoneyOrderQuery")
//	public PayResponseDto<DeductMoneyOrderRespDto> deductMoneyOrderQuery(@RequestBody DeductMoneyOrderReqDto deductMoneyOrderReqDto);
//
//	/**
//	 * 支付
//	 * @param paymentReqDto
//	 * @return
//	 */
//	@PostMapping("/transController/payment")
//	public PayResponseDto<PaymentRespDto> payment(@RequestBody PaymentReqDto paymentReqDto);
//
//
//	/**
//	 * 支付订单查询
//	 * @param paymentOrderReqDto
//	 * @return
//	 */
//	@PostMapping("/transController/paymentOrderQuery")
//	public PayResponseDto<PaymentOrderRespDto> paymentOrderQuery(@RequestBody  PaymentOrderReqDto paymentOrderReqDto);
//
//	/**
//	 * 获取支付渠道列表
//	 * @param channelList
//	 * @return
//	 */
//	@PostMapping("/transController/channelList")
//	public PayResponseDto<List<PaymentChannel>> channelList();
//}
