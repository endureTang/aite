//package com.nj.service.remoteing;
//
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.nj.core.base.entity.ResponseDto;
//import com.nj.model.generate.NjStatisticsOverday;
//import com.nj.mongoModel.Overdue;
//import com.nj.mongoModel.RepayPlan;
//import com.nj.mongoModel.RepayPlanMain;
//
//@FeignClient(value = "after")
//public interface RepayPlanService {
//
//    /**
//     * 创建还款计划并保存
//     */
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(value = "/repayPlan/createRepayPlanSave", method = RequestMethod.POST)
//    public ResponseDto createRepayPlanSave(@RequestParam("repayWay") String repayWay,
//                                           @RequestParam("beginInterestDate") String beginInterestDate,
//                                           @RequestParam("loanAmount") String loanAmount,
//                                           @RequestParam("yearRate") String yearRate,
//                                           @RequestParam("channelFeeType")String channelFeeType,
//   										   @RequestParam("channelFeeValue")String channelFeeValue,
//                                           @RequestParam("period") String period,
//                                           @RequestParam("orderNo") String orderNo,
//                                           @RequestParam("productCode") String productCode,
//                                           @RequestParam("planRepayNum") String planRepayNum,
//                                           @RequestParam("productName") String productName,
//                                           @RequestParam("loanUserId") String loanUserId,
//                                           @RequestParam("coporateId") String coporateId,
//                                           @RequestParam("businessCommissionerId") String businessCommissionerId);
//
//    /**
//     * 修改还款计划的还款状态
//     */
//    @RequestMapping(value = "/repayPlan/updateRepayPlan", method = RequestMethod.POST)
//    public ResponseDto<Boolean> updateRepayPlan(@RequestParam("orderNo")String orderNo,
//												@RequestParam("period")Integer period,
//												@RequestParam("accRepayDate")String accRepayDate,
//												@RequestParam("accRepayCapital")String accRepayCapital,
//												@RequestParam("accReapyInterest")String accReapyInterest,
//												@RequestParam("accChannelFeeForPeriod")String accChannelFeeForPeriod,
//												@RequestParam("accPayPenalty")String accPayPenalty,
//												@RequestParam("repayStatus")String repayStatus,
//												@RequestParam("deductionResult")String deductionResult);
//
//    /**
//     * 提前结清
//     */
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(value = "/repayPlan/earlySettle", method = RequestMethod.POST)
//    public ResponseDto earlySettle(@RequestParam("orderNo") String orderNo,
//                                   @RequestParam("accRepayDate") Date accRepayDate,
//                                   @RequestParam("accRepayCapital") BigDecimal accRepayCapital,
//                                   @RequestParam("accReapyInterest") BigDecimal accReapyInterest,
//                                   @RequestParam("accPayPenalty") BigDecimal accPayPenalty,
//                                   @RequestParam("settleCert") String settleCert);
//	
//	/**
//	 * 根据贷款用户id获取还款计划逾期笔数
//	 */
//	@RequestMapping(value = "/repayPlan/getOverNumByLoanUserId", method = RequestMethod.POST)
//	public ResponseDto<Long> getOverNumByLoanUserId(@RequestParam("loanUserId")String loanUserId);
//
//    /**
//     * 删除还款计划
//     */
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(value = "/repayPlan/deleteRepayPlanByOrderNo", method = RequestMethod.POST)
//    public ResponseDto deleteRepayPlanByOrderNo(@RequestParam("orderNo") String orderNo);
//	
//	/**
//	 * 查询指定订单编号、计划还款日期的还款计划
//	 */
//	@RequestMapping(value = "/repayPlan/getRepayPlanByOrderNoPlanRepayDate", method = RequestMethod.POST)
//	public ResponseDto<List<RepayPlan>> getRepayPlanByOrderNoPlanRepayDate(@RequestParam("param") String param);
//
//    /**
//     * 根据订单号获取还款计划
//     */
//    @RequestMapping(value = "/repayPlan/getRepayPlanByOrderNo", method = RequestMethod.POST)
//    public ResponseDto<List<RepayPlan>> getRepayPlanByOrderNo(@RequestParam("orderNo") String orderNo);
//    
//    /**
//     * 根据订单号获取还款计划
//     */
//    @RequestMapping(value = "/repayPlan/getRepayPlanByOrderNoPeriod", method = RequestMethod.POST)
//    public ResponseDto<RepayPlan> getRepayPlanByOrderNoPeriod(@RequestParam("orderNo")String orderNo,
//    														  @RequestParam("period")Integer period);
//
//    /**
//     * 查询计划还款日期在某时间段内的还款计划 范围：>=开始日期 <=结束日期
//     *
//     * @param param json格式
//     */
//    @RequestMapping(value = "/repayPlan/getRepayPlanByDateSection", method = RequestMethod.POST)
//    public ResponseDto<List<RepayPlan>> getRepayPlanByDateSection(@RequestParam("param") String param);
//    
//    /**
//     * 查询实际还款日期在某时间段内的还款计划 范围：>=开始日期 <=结束日期
//     * @param param json格式
//     */
//    @RequestMapping(value = "/repayPlan/getRepayPlanByActualRepayDateSection", method = RequestMethod.POST)
//    public ResponseDto<List<RepayPlan>> getRepayPlanByActualRepayDateSection(@RequestParam("param") String param);
//    
//    /**
//     * 获取用户已还款的还款计划（包括正常还款和提前结清,提前结清只取扣款那期）
//     */
//    @RequestMapping(value = "/repayPlan/getRepayedRPByUserid", method = RequestMethod.POST)
//    public ResponseDto<List<RepayPlan>> getRepayedRPByUserid(@RequestParam("loanUserId") String loanUserId,
//															 @RequestParam("pageNo") Integer pageNo,
//															 @RequestParam("size") Integer size);
//
//    /**
//     * 保存还款计划扣款记录
//     *
//     * @param repayExes json格式
//     */
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(value = "/repayPlan/addRepayExe", method = RequestMethod.POST)
//    public ResponseDto addRepayExe(@RequestParam("repayExes") String repayExes);
//
//    /**
//     * 保存逾期信息
//     *
//     * @param overdue 逾期信息 json格式
//     */
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(value = "/repayPlan/addOverdue", method = RequestMethod.POST)
//    public ResponseDto addOverdue(@RequestParam("overdue") String overdue);
//
//    /**
//     * 根据订单号获取逾期信息
//     */
//    @RequestMapping(value = "/repayPlan/getOverdueByOrderNo", method = RequestMethod.POST)
//    public ResponseDto<List<Overdue>> getOverdueByOrderNo(@RequestParam("orderNo") String orderNo);
//    
//    /**
//	 * 根据条件获取逾期信息
//	 */
//    @RequestMapping(value = "/repayPlan/getOverdueByCondition", method = RequestMethod.POST)
//    public ResponseDto<List<Overdue>> getOverdueByCondition(@RequestParam("param")String params);
//    
//    /**
//	 * 获取逾期统计数据
//	 */
//    @RequestMapping(value = "/repayPlan/getOverdayStatis", method = RequestMethod.POST)
//    public ResponseDto<List<NjStatisticsOverday>> getOverdayStatis(@RequestParam("param")String params);
//    
//    /**
//     * 根据订单号获取还款计划主表
//     */
//    @RequestMapping(value = "/repayPlan/getRepayPlanMainByOrderNo", method = RequestMethod.POST)
//    public ResponseDto<RepayPlanMain> getRepayPlanMainByOrderNo(@RequestParam("orderNo") String orderNo);
//    
//    /**
//	 * 获取企业贷款余额
//	 */
//	@RequestMapping(value="/repayPlan/getLoanBalance",method=RequestMethod.POST)
//    public ResponseDto<Map<String, Object>> getLoanBalance(@RequestParam(value="coporateId")String coporateId);
//
//}
