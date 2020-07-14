package com.nj.service.remoteing;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nj.core.base.entity.ResponseDto;
import com.nj.core.fee.base.ExterFeeAlgoParamCfg;
import com.nj.model.datamodel.EarlySettleDto;
import com.nj.model.datamodel.UpdatePlanDto;
import com.nj.model.generate.NjStatisticsOverday;
import com.nj.mongoModel.Overdue;
import com.nj.mongoModel.after.CaptialMoneyBackDetaileNew;
import com.nj.mongoModel.after.CaptialMoneyBackMainNew;
import com.nj.mongoModel.after.CaptialMoneyBackNew;
import com.nj.mongoModel.after.MoneyBackMainNew;
import com.nj.mongoModel.after.MoneyBackNew;
import com.nj.mongoModel.after.RepayPlanMainNew;
import com.nj.mongoModel.after.RepayPlanNew;

/**
 * 还款计划、回款计划Service
 *
 * @author MaSong
 */
@FeignClient(value = "after")
public interface RepayPlanNewService {

    /**
     * 根据订单号、期数获取还款计划
     *
     * @param orderNo 订单编号
     * @param period  期数（可选）
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getRepayPlanByOrderNoPeriod", method = RequestMethod.POST)
    public ResponseDto<RepayPlanMainNew> getRepayPlanByOrderNoPeriod(@RequestParam("orderNo") String orderNo,
                                                                     @RequestParam(value = "period", required = false) Integer period);
    
    /**
     * 根据订单编号、还款状态查询还款计划
     * @param orderNo	     订单编号
     * @param repayStatus 还款状态,多个状态用逗号隔开
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getRepayPlanByOrderNoRepayStatus", method = RequestMethod.POST)
    public ResponseDto<RepayPlanMainNew> getRepayPlanByOrderNoRepayStatus(@RequestParam("orderNo") String orderNo, @RequestParam(value = "repayStatus", required = false)String repayStatus);
    
    /**
     * 根据订单号、计划还款日期获取还款计划
     *
     * @param orderNo       订单编号
     * @param planRepayDate 计划还款日期 2019-03-11 00:00:00 ，注意需要传递时分秒都是00:00:00
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getRepayPlanByOrderNoPlanRepayDate", method = RequestMethod.POST)
    public ResponseDto<RepayPlanMainNew> getRepayPlanByOrderNoPlanRepayDate(@RequestParam("orderNo") String orderNo,
                                                                            @RequestParam("planRepayDate") String planRepayDate);
    
    /**
     * 根据订单号、计划还款日期获取小贷公司回款计划
     */
    @RequestMapping(value = "/planQueryNew/getMoneyBackNewByOrderNoPlanRepayDate", method = RequestMethod.POST)
    public ResponseDto<MoneyBackMainNew> getMoneyBackNewByOrderNoPlanRepayDate(@RequestParam("orderNo") String orderNo, 
    																		   @RequestParam("planRepayDate") String planRepayDate);
    
    /**
     * 根据订单号、计划还款日期获取资金渠道的回款计划
     */
    @RequestMapping(value = "/planQueryNew/getCaptialMoneyBackByOrderNoPlanRepayDate", method = RequestMethod.POST)
    public ResponseDto<List<CaptialMoneyBackMainNew>> getCaptialMoneyBackByOrderNoPlanRepayDate(@RequestParam("orderNo") String orderNo, 
    																					        @RequestParam("planRepayDate") String planRepayDate);


    /**
     * 根据订单编号获取还款计划主表
     *
     * @param orderNo 订单编号
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getRepayPlanMainByOrderNo", method = RequestMethod.POST)
    public ResponseDto<RepayPlanMainNew> getRepayPlanMainByOrderNo(@RequestParam("orderNo") String orderNo);


    /**
     * 查询计划还款日期在某时间段内的还款计划 范围：>=开始日期 <=结束日期
     *
     * @param param JSON
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getWithdrawingRepayPlanByDateSection", method = RequestMethod.POST)
    public ResponseDto<List<RepayPlanNew>> getWithdrawingRepayPlanByDateSection(@RequestParam("param") String param);

    /**
     * 查询计划还款日期在某时间段内的还款计划 范围：>=开始日期 <=结束日期
     *
     * @param param JSON
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getRepayPlanByDateSection", method = RequestMethod.POST)
    public ResponseDto<List<RepayPlanNew>> getRepayPlanByDateSection(@RequestParam("param") String param);


    /**
     * 查询实际还款日期在某时间段内的还款计划 范围：>=开始日期 <=结束日期
     *
     * @param param JSON
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getRepayPlanByActualRepayDateSection", method = RequestMethod.POST)
    public ResponseDto<List<RepayPlanNew>> getRepayPlanByActualRepayDateSection(@RequestParam("param") String param);
    


    /**
     * 获取用户已还款的还款计划（包括正常还款和提前结清,提前结清只取扣款那期）
     *
     * @param loanUserId 贷款人ID
     * @param pageNo     页面
     * @param size       每页数据条数
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getRepayedRPByUserid", method = RequestMethod.POST)
    public ResponseDto<List<RepayPlanNew>> getRepayedRPByUserid(@RequestParam("loanUserId") String loanUserId,
                                                                @RequestParam("pageNo") Integer pageNo,
                                                                @RequestParam("size") Integer size);

    /**
     * 根据订单号、期数获取回款计划
     *
     * @param orderNo 订单编号
     * @param period  期数（可选）
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getMoneyBackByOrderNoPeriod", method = RequestMethod.POST)
    public ResponseDto<MoneyBackMainNew> getMoneyBackByOrderNoPeriod(@RequestParam("orderNo") String orderNo, @RequestParam(value = "period", required = false) Integer period);

    /**
     * 根据订单号、期数获取资金渠道回款计划
     * @param orderNo 订单编号
     * @param period  期数（可选）
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getCaptialMoneyBackByOrderNoPeriod", method = RequestMethod.POST)
    public ResponseDto<CaptialMoneyBackMainNew> getCaptialMoneyBackByOrderNoPeriod(@RequestParam("orderNo") String orderNo, @RequestParam(value = "period", required = false) Integer period);
    
    /**
     * 根据贷款用户id获取还款计划逾期笔数
     *
     * @param loanUserId 贷款用户id
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getOverNumByLoanUserId", method = RequestMethod.POST)
    public ResponseDto<Long> getOverNumByLoanUserId(@RequestParam("loanUserId") String loanUserId);


    /**
     * 获取小贷公司贷款余额：放款金额 –已还款本金+
     *
     * @param coporateId 企业ID
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getMoneyBackLoanBalanceByCoporateId", method = RequestMethod.POST)
    public ResponseDto<Map<String, Object>> getMoneyBackLoanBalanceByCoporateId(@RequestParam(value = "coporateId", required = true) String coporateId);

    /**
     * 获取订单的贷款余额：放款金额 –已还款本金
     */
    @RequestMapping(value = "/planQueryNew/getMoneyBackLoanBalanceByOrderNo", method = RequestMethod.POST)
    public ResponseDto<Map<String, Object>> getMoneyBackLoanBalanceByOrderNo(@RequestParam(value = "orderNo", required = true) String orderNo);

    /**
     * 创建并保存还款计划和回款计划
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/planCUDNew/createSavePlan", method = RequestMethod.POST)
    public ResponseDto createSavePlan(@RequestParam("repayWay") String repayWay,
                                      @RequestParam("beginInterestDate") String beginInterestDate,
                                      @RequestParam("planRepayNum") String planRepayNum,
                                      @RequestParam("customerLoanAmount") String customerLoanAmount,
                                      @RequestParam("selfCompanyMaekLoanAmount") String selfCompanyMaekLoanAmount,
                                      @RequestParam("yearRate") String yearRate,
                                      @RequestParam("period") String period,
                                      @RequestParam("orderNo") String orderNo,
                                      @RequestParam("productId") String productId,
                                      @RequestParam("productName") String productName,
                                      @RequestParam("loanUserId") String loanUserId,
                                      @RequestParam("coporateId") String coporateId,
                                      @RequestParam("businessCommissionerId") String businessCommissionerId,
                                      @RequestBody List<ExterFeeAlgoParamCfg> cfgList);

    /**
     * 普通扣款后更新还款计划
     */
    @RequestMapping(value = "/planCUDNew/updateRepayPlan", method = RequestMethod.POST)
    public ResponseDto<Boolean> updateRepayPlan(@RequestBody UpdatePlanDto urpDto);

    /**
     * 普通扣款后更新回款计划
     */
    @RequestMapping(value = "/planCUDNew/updateMoneyBackPlan", method = RequestMethod.POST)
    public ResponseDto<Boolean> updateMoneyBackPlan(@RequestBody UpdatePlanDto urpDto);
    /**
     * 普通扣款后更新回款计划
     */
    @RequestMapping(value = "/planCUDNew/updateCaptialMoneyBackPlan", method = RequestMethod.POST)
    public ResponseDto<Boolean> updateCaptialMoneyBackPlan(@RequestBody UpdatePlanDto urpDto);

    /**
     * 更新逾期
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/planCUDNew/updateOverdue", method = RequestMethod.POST)
    public ResponseDto updateOverdue(@RequestParam("data") String data);


    /**
     * 根据订单号删除还款计划、回款计划（主表、计划表、明细表）
     *
     * @param orderNo
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/planCUDNew/deleteRepayPlan", method = RequestMethod.POST)
    public ResponseDto deleteRepayPlan(@RequestParam("orderNo") String orderNo);

    /**
     * 根据订单号删除还款计划、回款计划（主表、计划表、明细表）
     *
     * @param orderNo
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/history/transform", method = RequestMethod.POST)
    public ResponseDto transform(@RequestBody List<Map<String, String>> list);

    /**
     * 根据订单号查询逾期信息
     *
     * @param orderNo
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getOverdueByOrderNo", method = RequestMethod.POST)
    public ResponseDto<List<Overdue>> getOverdueByOrderNo(@RequestParam("orderNo") String orderNo);

//    /**
//     * 还款计划提前结清
//     */
//    @RequestMapping(value = "/planCUDNew/repayPlanEarlySettle", method = RequestMethod.POST)
//    public ResponseDto repayPlanEarlySettle(@RequestBody EarlySettleDto esDto);

//    /**
//     * 回款计划提前结清
//     */
//    @RequestMapping(value = "/planCUDNew/moneyBackPlanEarlySettle", method = RequestMethod.POST)
//    public ResponseDto moneyBackPlanEarlySettle(@RequestBody EarlySettleDto esDto);
    
    /**
	 * 提前结清接口
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/planCUDNew/earlySettle", method = RequestMethod.POST)
	public ResponseDto earlySettle(@RequestBody EarlySettleDto esDto);

    /**
     * 获取逾期统计数据
     */
    @RequestMapping(value = "/planQueryNew/getOverdayStatis", method = RequestMethod.POST)
    public ResponseDto<List<NjStatisticsOverday>> getOverdayStatis(@RequestParam("param") String params);

    /**
     * 修改还款状态
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/planCUDNew/changeStatus")
    public ResponseDto changeStatus(@RequestParam("orderNo") String orderNo, @RequestParam("period") int period, @RequestParam("status") int status);
    
    
    /**
     * 查询某段时间内前三期还款计划列表(导出用户首次逾期)
     *
     * @param param JSON
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getThirdListByDate", method = RequestMethod.POST)
    public ResponseDto<List<RepayPlanNew>> getThirdListByDate(@RequestParam("param") String param);
    
    /**
     * 组合贷产品根据上传的文件生成回款计划
     * @param map
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value="/planCUDNew/createDYBankRepayBackPlan", method = RequestMethod.POST)
    public ResponseDto createDYBankRepayBackPlan(@RequestParam("orderNo") String orderNo,
			@RequestParam("njChannelId") String njChannelId, @RequestParam("userId") String userId,
			@RequestParam("dataStr") String dataStr);
    
    /**
     * 根据订单号查询资金渠道回款计划
     * @param orderNo
     * @return
     */
    @RequestMapping(value="/planQueryNew/getCaptialMoneyBackList", method = RequestMethod.POST)
    public  ResponseDto<List<CaptialMoneyBackDetaileNew>>  getCaptialMoneyBackList(@RequestParam("orderNo") String  orderNo);
    
    /**
	 * 通过订单号、期数、实际还款日期 删除逾期信息
	 * 1.如果没有传实际还款日，则删除所有
	 * 2.如果传了实际还款日，则删除实际还款日之后的逾期信息
	 * @param orderNo	      订单编号
	 * @param period	      期数
	 * @param accRepayDate实际还款日期(选填),没有则null
	 * @param overdueDay  逾期天数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/planCUDNew/deleteOverdue", method = RequestMethod.POST)
	public ResponseDto deleteOverdue(@RequestParam("orderNo") String orderNo,@RequestParam("period") int period,@RequestParam("accRepayDate") Date accRepayDate,@RequestParam("overdueDay") int overdueDay);
	
	/**
	 * 保存修改回款计划，如果不保存子集，传参数的时候就填入null
	 * @param moneyBackMainNew
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/planCUDNew/saveUpdateMoneyBackMainNew")
	public ResponseDto saveUpdateMoneyBackMainNew(@RequestBody MoneyBackMainNew moneyBackMainNew);
	
	/**
	 * 保存修改资金回款计划，如果不保存子集，传参数的时候就填入null
	 * @param moneyBackMainNew
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/planCUDNew/saveUpdateCaptialMoneyBackMainNew")
	public ResponseDto saveUpdateCaptialMoneyBackMainNew(@RequestBody CaptialMoneyBackMainNew moneyBackMainNew);
	
	/**
	 * 保存修改还款计划，如果不保存子集，传参数的时候就填入null
	 * @param moneyBackMainNew
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/planCUDNew/saveUpdateRepayPlanMainNew")
	public ResponseDto saveUpdateRepayPlanMainNew(@RequestBody RepayPlanMainNew repayPlanMainNew);
	
	/**
	 * 重置单笔订单的贷款余额
	 */
	@RequestMapping(value = "/planCUDNew/resetLoanBalanceOne", method = RequestMethod.POST)
	public void resetLoanBalanceOne(@RequestParam("orderNo") String orderNo) ;
	

    /**
     * 查询某段时间内前三期还款计划列表(导出用户首次逾期)
     * @param orderNo
     * @return
     */
    @RequestMapping(value="/planCUDNew/selectByOrderNoList", method = RequestMethod.POST)
    public ResponseDto<List<RepayPlanNew>> selectByOrderNoList(@RequestParam("param") String param);
    
    /**
     * 查询小贷公司的回款计划：应还日期在某时间段内 范围：>=开始日期 <=结束日期
     */
    @RequestMapping(value = "/planQueryNew/getMoneyBackNewByPlanDateSection", method = RequestMethod.POST)
    public ResponseDto<List<MoneyBackNew>> getMoneyBackNewByPlanDateSection(@RequestParam("param") String param);

    /**
     * 查询小贷公司的回款计划：实还日期在某时间段内 范围：>=开始日期 <=结束日期
     */
    @RequestMapping(value = "/planQueryNew/getMoneyBackNewByAccDateSection", method = RequestMethod.POST)
    public ResponseDto<List<MoneyBackNew>> getMoneyBackNewByAccDateSection(@RequestParam("param") String param);
    
    /**
     * 查询在指定日期，逾期超过指定天数的回款计划   
     * 如：到2019.7.31时，逾期超过90天的回款计划
     */
    @RequestMapping(value = "/planQueryNew/getMoneyBackNewByOverdueDaysStatisDate", method = RequestMethod.POST)
    public ResponseDto<List<MoneyBackNew>> getMoneyBackNewByOverdueDaysStatisDate(@RequestParam("param") String param);

    @RequestMapping(value = "/planQueryNew/getWithdrawingMoneyByDateSection", method = RequestMethod.POST)
    public ResponseDto<List<MoneyBackNew>> getWithdrawingMoneyByDateSection(@RequestParam("param") String param);
    @RequestMapping(value = "/planQueryNew/getWithdrawingCaptialByDateSection", method = RequestMethod.POST)
    public ResponseDto<List<CaptialMoneyBackNew>> getWithdrawingCaptialByDateSection(@RequestParam("param") String param);

    /**
     * 根据公司ID、还款日期区间 、产品ID查询还款计划（这里是多个产品ID，多个用逗号隔开）
     * @param coporateId	公司ID
     * @param beginDate		起始时间
     * @param endDate		结束时间
     * @param productIds	产品ID
     * @return
     */
    @RequestMapping(value = "/planQueryNew/getRepayPlanListByDate", method = RequestMethod.POST)
    public ResponseDto<List<RepayPlanNew>> getRepayPlanListByDate(@RequestParam("coporateId") String coporateId,@RequestParam("beginDate") Date beginDate,@RequestParam("endDate") Date endDate,@RequestParam("productIds") String productIds);
    
    /**
     * 获取该还款方式最终生成的还款计划或回款计划的总期数
     * ***  在生成还款计划或回款计划前调用。若已生成还款计划，则查询还款计划表即可      ***
	 * 该方法于开发联合贷产品时增加：导入资金渠道时需判断资金渠道的回款计划和小贷的回款计划期数是否一致。
	 * 由于导入数据时还未放款（导入数据后需走审批流程），不确定放款日期，因此，若还款方式的具体期数需放款日期才能确定时，returnCode返回负数，且给出无法计算期数的具体原因。
	 */
    @RequestMapping(value = "/planQueryNew/getAccTotalPeriodsForOrder", method = RequestMethod.POST)
    public ResponseDto<Integer> getAccTotalPeriodsForOrder(@RequestParam("repayWay") String repayWay,
														   @RequestParam("period") String period);
}
