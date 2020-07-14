package com.nj.dao.extend;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjBaseInfoCompany;
import com.nj.model.generate.NjChannelDevAccount;
import com.nj.model.generate.NjChannelRequset;
import com.nj.model.generate.NjContactCompany;
import com.nj.model.generate.NjDeductionNotice;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjOrderAttachment;
import com.nj.model.generate.NjOrderBhRecord;
import com.nj.model.generate.NjOrderFlows;
import com.nj.model.generate.NjProductTransactionOffline;
import com.nj.model.generate.NjProductTransactionOnline;
import com.nj.model.generate.NjScenesCompany;
import com.nj.model.generate.NjUserActivateNotice;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserCar;

public interface NjLoanOrderMapperExtend {
    public List<Map> getUserOrders(@Param("accountId") String accountId,
                                   @Param("start") int start, @Param("rowNum") int end);

    public List<Map> getUserOrdersByCompany(@Param("accountId") String accountId,
                                            @Param("start") int start, @Param("rowNum") int end, @Param("companyCode") String companyCode);

    public Map<String, Object> getOrderDetailMap(@Param("orderId") String orderId);

    //backend system
    /*
     * 根据条件获取订单
	 */
    @SuppressWarnings("rawtypes")
    public List<Map> selectOrdersListPage(Map<?, ?> condition);

    public List<Map> selectAllLoanOrdersListPage(Map<?, ?> condition);

    public List<Map> selectPreLoanOrdersListPage(Map<?, ?> condition);

    public List<Map> selectAfterLoanOrdersListPage(Map<?, ?> condition);


    public List<Map> selectProcessLoanOrdersListPage(Map<?, ?> condition);

    public Map selectProcessLoanOrdersCount(Map<?, ?> condition);

    public Map<?, ?> selectLoanOrdersListNumAmount(Map<?, ?> condition);

    public List<Map> selectDispatchOrderList(@Param("orderIds") List<String> orderIds);

    public List<String> selectProductIdsByOrderIds(@Param("orderIds") List<String> orderIds);

    public List<Map> selectDispatchUserListByProductIdIds(PageData pd);

    public Map<?, ?> selectLoanOrderUserBaseInfo(String orderId);

    public List<Map> selectOrdersListPageForThird(Map<?, ?> condition);

    public Map<?, ?> getOrderApplyInfo(Map<?, ?> condition);


    public Map getOrderAuditAndUserInfo(Map<?, ?> condition);

    public Map getOrderAuditMoreInfo(Map<?, ?> condition);


    /**
     * 查询电审信息
     *
     * @param orderId
     * @return
     */
    public Map<String, String> selectAuditInfo(String orderId);


    public Map<?, ?> getLoanOrderUserWorkInfo(Map<?, ?> condition);

    public NjUserCar getLoanOrderUserCarInfo(Map<?, ?> condition);

    public List<NjUserCar> getUserCarList(Map<?, ?> condition);

    public List<Map> getHouseAttachmentList(Map<?, ?> condition);

    public List<Map> getCarAttachmentList(Map<?, ?> condition);

    public void saveOrderApplyInfo(Map<?, ?> condition);

    public void saveLoanOrderUserBaseInfo(Map<?, ?> condition);

    public void saveLoanOrderUserWorkInfo(Map<?, ?> condition);

    public void saveLoanOrderUserCarInfo(NjUserCar userCar);


    public void updateOrderAuditInfo(Map<?, ?> condition);

    public Map<?, ?> getOrderDetailsByNo(@Param("orderNo") String orderNo);

    public Map<?, ?> getTradeInfo(Map<?, ?> condition);

    public List<Map> getOrdsByStatus(Map<?, ?> condition);

    public NjLoanOrder getMaxOrder();

    public List<Map> getNewRepayObjs(Map<?, ?> condition);

    public List<Map> getRepayObjs(Map<?, ?> condition);

    public List<Map> getNewPayee(Map<?, ?> condition);

    public List<Map> getPayee(Map<?, ?> condition);

    public List<Map> getTradeConfig(Map<?, ?> condition);

    /**
     * 获取贷后列表
     *
     * @param condition
     * @return
     */
    public List<Map> getListByCoporate(Map<?, ?> condition);


    /**
     * 获取贷后详情
     *
     * @param condition
     * @return
     */
    public Map<String, Object> getLoanInfoByOrderNo(Map<?, ?> condition);

    /**
     * zhanghai添加
     *
     * @return
     */
    public List<NjOrderFlows> getOrderFlowsGroup();

    public List<Map> getAuditFiles(String orderNo);

    public Integer getAdditionVersion(@Param("orderId") String orderId);

    public List<Map<String, Object>> getAddition(@Param("orderId") String orderId);

    public List<Map<String, Object>> getAdditionAttachmentForWeb(@Param("orderId") String orderId);

    public List<Map> getAdditionAttachment(@Param("additionId") String additionId);


    public Integer deleteUserAttr(@Param("id") String id);


    public List<Map> getInfo1(Map<?, ?> condition);

    public List<Map> getInfo2(Map<?, ?> condition);

    public Integer getInfo3(Map<?, ?> condition);

    public Integer getInfo4(Map<?, ?> condition);

    public Integer getInfo5(Map<?, ?> condition);

    public List<Map<String, Object>> getToProcessLoanOrder(@Param("status") Integer status);

    public NjLoanOrder selectByOutOrderIdAndAppId(@Param("outOrderId") String outOrderId, @Param("appId") String appId);

    public List<NjLoanOrder> getToCallbackOutOrder(@Param("states") List<Integer> states, @Param("coporateId") String coporateId);

    public Map<String, Object> getOutOrderFromChannel(@Param("orderId") String orderId);

    public List<Map> getOrderFlowCategory();

    public List<Map> getTfcfToCreateContractOrders();

    public List<Map> getOrderRepayUsers(@Param("orderId") String orderId);

    public List<Map> getOrderReceiptUsers(@Param("orderId") String orderId);

    public List<Map> getTfcfToCreateProjectOrders();

    /**
     * 获取产品在线下放款的生成合同方式，默认不生成，0:不生成，1：财富端生成，2：自上传
     *
     * @param productId
     * @return
     */
    public Integer getOfflineOrderContractGenType(String productId);

    public Integer getOnlOrderContractGenType(@Param("relendMethod") Integer relendMethod, @Param("productId") String productId);

    public List<Map> getCertImageByOrderIdNew(String orderId);

    public String getOrderAttByIdAndType(@Param("orderId") String orderId, @Param("buziType") Integer buziType);

    public List<String> getHuotiImageByOrderIdNew(String orderId);


    /**
     * 获取线下贷后列表
     *
     * @param pd
     * @return
     */
    List<Map> getOfflineLoanList(PageData pd);

    int getOfflineLoanListCount(PageData pd);

    Map getOfflineLoanInfobyOrderNo(PageData pd);


    List<Map> getThreeOfflineLoanList(PageData pd);

    int getThreeOfflineLoanListCount(PageData pd);

    Map getThreeChennelName(Map pd);

    Map<String, Object> getOldCertHeadImgInner(String orderId);

    Map<String, Object> getOldCertBackImgInner(String orderId);

    Map<String, Object> getOldCertHandImgInner(String orderId);

    /**
     * 获取线上交易，审批完成无需用户确认的订单
     *
     * @return
     */
    List<NjLoanOrder> selectOnlDealNoUserConfirmOrders();

    /**
     * 获取线下交易，审批完成无需用户确认的订单
     *
     * @return
     */
    List<NjLoanOrder> selectOffDealNoUserConfirmOrders();

    /**
     * 获取用户订单对应产品的线下放款交易信息
     *
     * @param orderId
     * @return
     */
    NjProductTransactionOffline selectOffTrasanction(String orderId);

    /**
     * 获取订单对应的产品的线上放款交易信息
     *
     * @param orderId
     * @return
     */
    NjProductTransactionOnline selectOnlTrasanction(String orderId);

    String selectOrderAuditorName(String orderNo);

    String selectOrderRecheckerName(String orderNo);

    //List<NjLoanOrder> selectNoContractOrders();

    List<NjLoanOrder> selectOfflineNeedSignCallbackOrders();

    List<NjLoanOrder> selectOfflineNoSignCallbackOrders();

    public Map<String, Object> getOrderSignTFCFContract(String orderNo);

    public Map<String, Object> getOrderContractBaseParams(String orderNo);

    public Map<String, Object> getSignParam(String orderNo);

    public Map<String, Object> getOrderTfcfProjectBaseParams(String orderNo);

    public Integer getOrderOnlineSignTFCFContract(String orderNo);

    public Integer getOrderOfflineSignTFCFContract(String orderNo);


    /**
     * 获取订单还款人银行卡信息（只支持本人扣款不包括渠道和指定人员）
     *
     * @param orderId
     * @param coporateId
     * @return
     */
    public List<Map> getOrderRepayUser(@Param("coporateId") String coporateId, @Param("orderNo") String orderNo);


    public String getCoporateIdByOrderNo(String orderNo);

    /**
     * @param size
     * @param grade
     * @return
     */
    public long calculateAmountBySizeAndGrade(@Param("size") long size, @Param("grade") String grade,
                                              @Param("status") int status);

    public List<Map<String, Object>> orderGradeSummaryInfo(@Param("status") int status);

    /**
     * @return
     */
    public List<Map<String, Object>> orderProductGradeSummaryInfo(@Param("userConfirmStatus") int userConfirmStatus,
                                                        @Param("buildCorporeStatus") int buildCorporeStatus, @Param("fundraisingSuccessStatus") int fundraisingSuccessStatus,
                                                        @Param("makeLoansStatus") int makeLoansStatus,
                                                        @Param("companyId") String companyId);

    /**
     * @return
     */
    public List<Map<?, ?>> listProductGrade(@Param("keyword") String keyword, @Param("coporateId") String coporateId);

    public List<NjLoanOrder> selectByGradeStatusSize(@Param("size") long size, @Param("grade") String grade,
                                                     @Param("status") int status);

    public void batchUpdateByGrade(@Param("size") long size, @Param("grade") String grade,
                                   @Param("newStatus") int newStatus, @Param("oldStatus") int oldStatus);

    public List<Map<?, ?>> listBuildCorporeDetails(@Param("userConfirmStatus") int userConfirmStatus,
                                                   @Param("buildCorporeStatus") int buildCorporeStatus, @Param("statusList") List<Integer> statusList,
                                                   @Param("keyword") String keyword,
                                                   @Param("status") String status);

    public Long sumFundraisingSuccessAmount(@Param("fundraisingSuccessStatus") int fundraisingSuccessStatus);

    Long getAmount(@Param("productId") String productId, @Param("startDate") String startDate, @Param("endDate") String endDate);
    
    Double getProductAmount(@Param("productId") String productId);

    public List<Map<String, Object>> selectUserOrderAttach(@Param("orderId") String orderId);

    public List<Map<String, Object>> selectAttachmentListByOrderId(@Param("orderId") String orderId, @Param("businessType") Integer businessType, @Param("parentIds") String parentIds);
    
    public List<Map<String, Object>> getOrderAttListByFiletag(@Param("orderId") String orderId,@Param("fileTags") String fileTags);

    public NjLoanOrder getOrderByOrderNo(@Param("orderNo") String orderNo);

    public Map<String, String> selectOrderRefuceReson(@Param("orderId") String orderId);

    public Map<String, Object> getStatisticsBase(@Param("companyId") String companyId);

    /**
     * 获取各类资产统计-放款金额
     *
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> selectAmountByProduct(Map<String, Object> paramMap);

    /**
     * 获取各类资产统计-进件情况
     *
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> selectCountByProduct(Map<String, Object> paramMap);

    /**
     * 进件走势统计-进件数据
     *
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> selectCountByDate(Map<String, Object> paramMap);

    /**
     * 进件走势统计-放款金额
     *
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> selectAmountByDate(Map<String, Object> paramMap);

    /**
     * 验证订单过程是否一致
     *
     * @param orderList
     * @return
     */
    public List<Map> selectProcessCountByOrderId(@Param("orderIds") List<String> orderIds);

    public List<String> selectMqApiList(Map<String, Object> map);

    public Integer selectMqApiListCount();

    /**
     * 获取撮合成功的金额和件数
     *
     * @param coporateId 企业id
     *                   为空时，查询所有企业累计撮合成功金额和件数。
     *                   非空时，查询指定企业累计  撮合成功金额和件数。
     */
    public PageData getTotalAmtAndNumForMatched(@Param("coporateId") String coporateId);

    /**
     * 获取productIds的，从beginDate开始每个月撮合金额
     * param 包含2个参数：String beginDate,List<String> productIds
     */
    public List<PageData> getTotalAmtForMonth(Map<String, Object> param);

    /**
     * 更新订单状态
     *
     * @param order
     */
    public void updateOrderStatusById(NjLoanOrder order);

    /**
     * 得到贷后还款信息。  用于贷后还款信息页面的还款信息展示
     */
    public Map<String, Object> getLoanAfterRepayInfo(String orderNo);

    public List<Map<String, Object>> selectByStatus(Map<String, Object> map);

    /**
     * 根据筛选条件获取所有订单总数
     *
     * @param pd
     * @return
     */
    public long selectAllLoanOrdersCount(PageData pd);

    public List<Map<String, Object>> getOrderAttById(Map map);

    /**
     * 根据用户ID在订单流程获取相关订单列表信息
     *
     * @param pd
     * @return
     */
    public List<Map> selectMyOrderInOrderFlow(PageData pd);

    /**
     * 客戶经理获取其绑定的用户订单列表
     *
     * @param pd
     * @return
     */
    public List<Map> selectMyOrderByChannelUserId(PageData pd);

    /**
     * 根据创建时间查询订单
     */
    Map<String, Object> getOrderCountByCreateTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("productId") String productId);

    /**
     * 根据审批状态获取订单的统计信息
     */
    Map<String, Object> getApprovalOrderByStatus(@Param("startTime") Date startTime, @Param("endTime") Date endTime,
                                                 @Param("productId") String productId, @Param("status") int status);

    /**
     * 获取拒绝订单
     */
    Map<String, Object> getRefuseOrder(@Param("startTime") Date startTime, @Param("endTime") Date endTime,
                                       @Param("productId") String productId);

    /**
     * 获取指定时间内平均撮合时效
     */
    Map<String, Object> getAvgMatchSecondByStatus(@Param("startTime") Date startTime, @Param("endTime") Date endTime,
                                                  @Param("productId") String productId);


    /**
     * 风控角色获取订单列表
     *
     * @param pd
     * @return
     */
    public List<Map> selectMyOrderByChannelUserIdAndRoleType(PageData pd);

    /**
     * 获取风控专员分单用户列表
     *
     * @return
     */
    public List<Map> selectSendOrderRiskUsersList(PageData pd);

    /**
     * 还款情况页面获取订单数据
     */
    public Map getOrderForRepaySituationPage(String orderNo);

    /**
     * 根据订单状态获取列表
     */
    public List<Map> selectMyOrderByStatus(PageData pd);

    /**
     * 根据订单id获取订单详细信息
     */
    public Map<String, Object> getOrderInfo(String orderId);

    /**
     * 获得驳回列表
     *
     * @param orderId
     * @param processId
     * @return
     */
    public List<Map<String, Object>> getProcessOrderFlows(@Param("orderId") String orderId, @Param("processId") String processId, @Param("templateId") String templateId);

    /**
     * 获取订单初审、复审、终审人员（微鼎金融）
     *
     * @param orderId
     * @return
     */
    public List<Map<String, Object>> selectOrderAuditUserList(@Param("orderId") String orderId);

    
    /**
     * 统计员工时间区间内销售总额
     * @param beginTime		开始时间	
     * @param endTime		结束时间
     * @param userId		用户ID
     * @param companyId		公司ID
     * @return
     */
    public Double statisticsSellAmountForUser(@Param("startTime")Date startTime,@Param("endTime")Date endTime,@Param("userId")String userId,@Param("companyId")String companyId);
    
    /**
     * 查询指定时间段的销售统计排行
     * @param startTime		开始时间
     * @param endTime		结束时间
     * @param companyId		公司ID
     * @return
     */
    public List<Map> getStatisticsSell(@Param("startTime")Date startTime,@Param("endTime")Date endTime,@Param("companyId")String companyId);
    
    
    /**
     * 查询指定时间段的回款统计排行
     * @param startTime		开始时间
     * @param endTime		结束时间
     * @param companyId		公司ID
     * @return
     */
    public List<Map> getStatisticsManagerReturn(@Param("startTime")Date startTime,@Param("endTime")Date endTime,@Param("companyId")String companyId);

    
    /**
     * 根据订单状态获取放款金额，放款笔数
     * @param querymap
     */
	public List<Map<String,Object> > getSumAuditAmountForCompany(Map<String, Object> querymap);
	
	
	/**
	 * 根据订单状态获取每个公司放款人数
	 * @param status
	 */
	public List<Map<String,Object> > getUserCountForCompany(Map<String,Object>  querymap);

	/**
	 * 获取今日审批通过的订单数量
	 */
	public Long getAuditPassOrderNumForToday(@Param("coporateId")String coporateId,@Param("productIds")List<String> productIds);
	
	/**
	 * 获取今日放款金额
	 */
	public BigDecimal getMakeLoanAmtForToday(@Param("coporateId")String coporateId,@Param("productIds")List<String> productIds);

	/**
	 * 获取代偿账户
	 * @param orderId
	 * @return
	 */
	public List<Map<String, Object>> getOrderRepayUserList(String productId);

	public List<NjOrderAttachment> getOrderAttByIdAndFileTag(Map map);
	
	
	/**
	 * 获得指定时间段的订单,并根据订单状态查询（该时间指的是修改时间）
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<NjLoanOrder> getOrderCallBackByStatus(@Param("states")List<Integer> states,@Param("startTime")Date startTime,@Param("endTime")Date endTime);

	/**
	 * 根据用户id和订单状态获取订单总额
	 * @param userId
	 * @param value
	 * @return
	 */
	public Double selectAmountByUserId(@Param("userId") String userId, @Param("status")int status);
    
	
	/**
	 * 查询渠道商对接账号，通过订单中的channelId进行查询
	 * @param channelId
	 * @return
	 */
	public List<NjChannelDevAccount> getChannelDevAccountByChannelId(@Param("channelId") String channelId);

	
	/**
	 * 通过订单ID查询车辆信息
	 * @param orderId
	 * @return
	 */
	public List<NjUserCar> getUsercarByOrderId (@Param("orderId") String orderId) ;

	/**
	 * 根据订单id获取还款账户对应的天赋财富userId
	 * @param orderId
	 * @return
	 */
	public List<Map> getOrderRepaymentUsers(String orderId);

	
	
	/**
	 * 通过时间段查询扣款通知回调信息
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<NjDeductionNotice> getDeductionNoticeList(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
	
	/**
	 * 通过时间段查询通用通知信息
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<NjChannelRequset> getCommonNoticeList (@Param("startTime")Date startTime,@Param("endTime")Date endTime);
	
	/**
	 * 通过时间段查询用户激活通知信息
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<NjUserActivateNotice> getUserActivateNotice(@Param("startTime")Date startTime,@Param("endTime")Date endTime);

	public List<Map<String,String>> getProductIdListOfND();
	/**
	 * 查询当天进件数量
	 * @param productId
	 * @return
	 */
	public List<String> getTodayIncomeCount(@Param("productId")String productId,@Param("date")Date date);

	public List<NjLoanOrder> selectByExamp();

	public void updateSelect(NjLoanOrder order);

	public List<NjLoanOrder> selectContractEsign(@Param("productIds") String productIds,@Param("start") Integer start,@Param("end") Integer end);

	public NjBaseInfoCompany selectLoanOrderCompanyUserBaseInfo(String orderId);

	public NjContactCompany getContactCompanyInfoByOrderId(String orderId);

	public NjScenesCompany getScenesCompanyInfoByOrderId(String orderId);
	
	/**
	 * api增补资料返回map
	 * @param orderId
	 * @return
	 */
	public Map<String, Object> selectLoanOrderCompanyUserBaseInfoMap(String orderId);
	/**
	 * api增补资料返回map
	 * @param orderId
	 * @return
	 */
	public Map<String, Object> getContactCompanyInfoByOrderIdMap(String orderId);
	/**
	 * api增补资料返回map
	 * @param orderId
	 * @return
	 */
	public Map<String, Object> getScenesCompanyInfoByOrderIdMap(String orderId);

	public List<Map<String, Object>> selectExportList(Map<String, Object> param);
	/**
	 * 获取百行上报请求参数数据
	 * @param orderId
	 * @return
	 */
	public Map<String, Object> getBhReportInfo(@Param("orderId") String orderId);

	public void updateBhReportStatus(@Param("orderId") String orderId);

	/**
	 * 获取百行上报数据
	 * @return
	 */
	public List<NjOrderBhRecord> selectBhReportList();
	/**
	 * 获取普惠等第三方附件列表
	 * @return
	 */
	public List<NjUserAttachment> selectPhUserAttachmentList();

	public Map<String, Object> getInfoByOrderNo(@Param("orderNo") String orderNo);
}
