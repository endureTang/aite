package com.nj.service.itf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.nj.core.base.exception.BaseException;
import com.nj.core.fee.algoParam.external.*;
import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.ManualParam;
import com.nj.dao.extend.*;
import com.nj.model.generate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.common.Constants;
import com.nj.core.base.common.api.ResponseMsg;
import com.nj.core.base.common.api.TFCFResponseMsg;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProcessInfo;
import com.nj.core.base.enums.EProcessResult;
import com.nj.core.base.exception.HttpRequestException;
import com.nj.core.base.exception.ItfException;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.NjAdditionAttachmentMapper;
import com.nj.dao.NjAddtionInfoMapper;
import com.nj.dao.NjAppUserMapper;
import com.nj.dao.NjBaseInfoCompanyMapper;
import com.nj.dao.NjChannelRelativeMapper;
import com.nj.dao.NjContactCompanyMapper;
import com.nj.dao.NjCorpProdMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjOrderAdditionMapper;
import com.nj.dao.NjOrderAttachmentMapper;
import com.nj.dao.NjOrderBhRecordMapper;
import com.nj.dao.NjOrderChannelMapper;
import com.nj.dao.NjOrderContractMapper;
import com.nj.dao.NjOrderFlowsMapper;
import com.nj.dao.NjOrderUpdateLogMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.dao.NjProductCycleMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.NjProductTransactionMapper;
import com.nj.dao.NjScenesCompanyMapper;
import com.nj.dao.NjUserActivateNoticeMapper;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.dao.SysDictMapper;
import com.nj.model.constant.LoanOrderConstant;
import com.nj.model.mq.OrderMq;
import com.nj.mongoModel.TdReportData;
import com.nj.service.enterprise.OrderService;
import com.nj.service.process.ProcessFlowsService;
import com.nj.service.remoteing.IMqNdService;
import com.nj.service.remoteing.IMqWDService;
import com.nj.service.remoteing.TdReportService;

/**
 * @author 009
 */
@Transactional(readOnly = true)
@Service("itfLoanOrderService")
public class ItfLoanOrderService {

    @Resource(name = "BaseDao")
    private BaseDao dao;

    @Resource(name = "itfProductParamService")
    private ItfProductParamService itfProductParamService;

    @Resource(name = "itfLoanOrderBinder")
    private ItfLoanOrderBinder itfLoanOrderBinder;

    @Resource(name = "orderService")
    private OrderService orderService;

    @Resource(name = "tfcfHttpService")
    private TfcfHttpService tfcfHttpService;

    @Resource
    protected IMqWDService mqService;
    @Resource
    protected IMqNdService mqNdService;

    @Resource
    private AppUserService appUserservice;
    @Resource(name = "njProcessFlowsService")
    protected ProcessFlowsService processFlowsService;

    @Resource
    private NjProcessMapperExtend processMapperExtend;

    @Resource(name = "fileOperationService")
    private FileOperationService fileOperationService;

    @Resource(name = "itfProductService")
    private ItfProductService itfProductService;

    @Resource
    private TdReportService tdReportService;

    private Logger logger = LoggerFactory.getLogger(ItfLoanOrderService.class);

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjLoanOrder saveLoanOrder(final NjLoanOrder order, final JSONObject data) throws Exception {
        Date nowTime = new Date();
        order.setCreateDate(nowTime);
        order.setUpdateDate(nowTime);
        NjLoanOrderMapper sm = dao.getMapper(NjLoanOrderMapper.class);
        order.setTotalRating(order.getAuditRating());
        sm.insert(order);

        // 查询该产品下配置的所有渠道
        NjProductChannelMapper njProductChannelMapper = dao.getMapper(NjProductChannelMapper.class);
        NjProductChannelExample njProductChannelExample = new NjProductChannelExample();
        njProductChannelExample.createCriteria().andProductIdEqualTo(order.getProductId()).andDelFlagEqualTo(false);
        List<NjProductChannel> listProductChannel = njProductChannelMapper.selectByExample(njProductChannelExample);

        // 渠道费率设置
        List<NjOrderChannel> listOrderChannel = new ArrayList<NjOrderChannel>();
        for (NjProductChannel productChannel : listProductChannel) {

            // 进件渠道
            if (productChannel.getType() == 1) {
                if (!order.getChannelId().equals(productChannel.getId())) {
                    continue;
                }
            }

            NjOrderChannel orderChannel = new NjOrderChannel();
            orderChannel.setId(UuidUtil.get32UUID());
            orderChannel.setBondType(productChannel.getBondType() != null ? productChannel.getBondType() : 1);
            orderChannel.setBondValue(!StringUtils.isEmpty(productChannel.getBondValue()) ? productChannel.getBondValue() : "0");
            orderChannel.setChannelId(productChannel.getNjChannelId());
            orderChannel.setChannelProductId(productChannel.getId());
            orderChannel.setChannelType(productChannel.getType());
            orderChannel.setOperateFee(productChannel.getOperateFee() != null ? productChannel.getOperateFee().toString() : "0");
            orderChannel.setOperateFeeType(productChannel.getOperateFeeType() != null ? productChannel.getOperateFeeType() : 1);
            orderChannel.setOrderId(order.getId());
            orderChannel.setIsRateContract(productChannel.getIsRateContract());

            NjOrderChannelMapper orderChannelMapper = dao.getMapper(NjOrderChannelMapper.class);
            orderChannelMapper.insert(orderChannel);
            listOrderChannel.add(orderChannel);

        }

        // 查询产品
        NjProduct prod = itfProductService.getProductById(order.getProductId());
        NjOrderChannelMapper orderChannelMapper = dao.getMapper(NjOrderChannelMapper.class);
        if (prod.getRepayWay().equals("10102")) { // 等额本息

            double financeAmount = order.getAuditAmount().doubleValue();//贷款金额
            double periodRate = OutOrderService.getPeriodRate(order.getAuditPeriod());//投资人年化
            double period = Double.parseDouble(order.getAuditPeriod().toString());// 贷款期数
            double firstRate = Double.parseDouble(order.getTotalRating()) / 100;
            double secondRate = Double.parseDouble(order.getAuditRating()) / 100;


            // 进件渠道分润
            for (NjOrderChannel njOrderChannel : listOrderChannel) {
                if (njOrderChannel.getChannelType() == 1) {
                    // 只有配置了渠道
                    if (njOrderChannel.getBondType().intValue() == 2) {
                        if (firstRate == secondRate) {
                            secondRate = firstRate - Double.parseDouble(njOrderChannel.getBondValue()) / 100;
                        }
                        if (firstRate != secondRate) {
                            // 期收费率 年化
                            String jjRate = OutOrderService.getPeriodServiceRate(firstRate, secondRate, period, financeAmount);
                            // 期收金额
                            String jjAmount = OutOrderService.getPeriodServiceAmount(firstRate, secondRate, period, financeAmount);
                            njOrderChannel.setBondValue(jjRate);
                            njOrderChannel.setBondFee(jjAmount);

                            orderChannelMapper.updateByPrimaryKey(njOrderChannel);
                            firstRate = secondRate;
                        }
                    }
                }
            }

            // 其它渠道分润
            for (NjOrderChannel njOrderChannel : listOrderChannel) {
                if (njOrderChannel.getChannelType() != 1) {
                    // 只有配置了渠道
                    if (njOrderChannel.getBondType().intValue() == 2) {
                        if (firstRate == secondRate) {
                            secondRate = firstRate - Double.parseDouble(njOrderChannel.getBondValue()) / 100;
                        }
                        if (firstRate != secondRate) {
                            // 期收费率 年化
                            String jjRate = OutOrderService.getPeriodServiceRate(firstRate, secondRate, period, financeAmount);
                            // 期收金额
                            String jjAmount = OutOrderService.getPeriodServiceAmount(firstRate, secondRate, period, financeAmount);
                            njOrderChannel.setBondValue(jjRate);
                            njOrderChannel.setBondFee(jjAmount);

                            orderChannelMapper.updateByPrimaryKey(njOrderChannel);
                            firstRate = secondRate;
                        }
                    }
                }
            }

            // 平台分润
            String jdRate = OutOrderService.getPeriodServiceRate(firstRate, periodRate, period, financeAmount);
            String jdAmount = OutOrderService.getPeriodServiceAmount(firstRate, periodRate, period, financeAmount);

            BigDecimal contractRate = new BigDecimal(jdRate);

            for (NjOrderChannel njOrderChannel : listOrderChannel) {
                if (njOrderChannel.getIsRateContract()) {
                    BigDecimal bondRate = new BigDecimal(njOrderChannel.getBondValue());
                    contractRate = contractRate.add(bondRate);
                }
            }
            order.setContractRate(String.format("%.6f", contractRate));
            order.setFixRate(String.format("%.6f", periodRate * 100));//投资人收益
            order.setFeeRate(jdRate);//期收费率 年化
            order.setFeeValue(jdAmount);//期收金额
        }


        //保存用户上传资料
        String attachIds = data.getString("attachIds");
        if (null != attachIds) {
            String[] ids = attachIds.split(",");
            if (ids.length > 0) {
                NjOrderAttachmentMapper orderAttachmentMapper = dao.getMapper(NjOrderAttachmentMapper.class);
                for (String attachId : ids) {
                    String orderId = order.getId();
                    NjOrderAttachment orderAttachment = new NjOrderAttachment();
                    orderAttachment.setId(UuidUtil.get32UUID());
                    orderAttachment.setAttachId(attachId);
                    orderAttachment.setOrderId(orderId);
                    orderAttachmentMapper.insertSelective(orderAttachment);
                }
            }
        }

//		//获取订单对应产品流程模板
//		try {
//			NjProductTempMapperExtend extend = dao.getMapper(NjProductTempMapperExtend.class);
//			NjProductTemp njProductTemp = extend.selectByProductId(order.getProductId());
//			if(null == njProductTemp || njProductTemp.getProcessTemplateId() == null) {
//				logger.error("产品流程配置错误，没有找到订单id为："+order.getId()+"产品id为："+order.getProductId()+"的流程模板信息");
//				throw new Exception("产品流程配置错误");
//			}
//			OrderMq orderMq = new OrderMq(order.getId(),EProcessInfo.START.getId(),njProductTemp.getProcessTemplateId());
//			ResponseDto tresponse = mqService.sendOrderProcessMq(orderMq);
//			logger.debug("订单提交成功，发送消息:{}",JSON.toJSONString(tresponse));
//		} catch (Exception e) {
//			logger.error("com.nj.service.itf.ItfLoanOrderService.saveLoanOrder--> 下单执行消息队列错误"+e);
//		}

        //获取用户基本信息
        NjAppUserMapper appUserMapper = dao.getMapper(NjAppUserMapper.class);
        NjAppUser appUser = appUserMapper.selectByPrimaryKey(order.getUserId());
        new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {

                    if (appUser.getUserType() != null && appUser.getUserType().intValue() == 0) {
                        try {
                            //绑定订单与用户基本信息
                            itfLoanOrderBinder.bindOrderToUserBasic(order);
                        } catch (Exception e) {
                            logger.error("绑定订单与用户基本信息失败", e);
                        }
                        try {
                            //绑定订单与用户联系人信息
                            itfLoanOrderBinder.bindOrderToUserRel(order);
                        } catch (Exception e) {
                            logger.error("绑定订单与用户联系人信息失败", e);
                        }
                        try {
                            //绑定订单与配偶信息
                            itfLoanOrderBinder.bindOrderToUserSpause(order);
                        } catch (Exception e) {
                            logger.error("绑定订单与配偶信息失败", e);
                        }
                        try {
                            //绑定订单与用户工作信息
                            itfLoanOrderBinder.bindOrderToUserWork(order);
                        } catch (Exception e) {
                            logger.error("绑定订单与用户工作信息失败", e);
                        }
                        try {
                            //绑定订单与车辆信息
                            itfLoanOrderBinder.bindOrderToUserCar(order);
                        } catch (Exception e) {
                            logger.error("绑定订单与用户车辆信息失败", e);
                        }
                        try {
                            //绑定订单与负债信息
                            itfLoanOrderBinder.bindOrderToUserDebt(order);
                        } catch (Exception e) {
                            logger.error("绑定订单与用户负债信息失败", e);
                        }
                        try {
                            //绑定订单与住房信息
                            itfLoanOrderBinder.bindOrderToUserHouse(order);
                        } catch (Exception e) {
                            logger.error("绑定订单与用户住房信息失败", e);
                        }
                        try {
                            //绑定订单与抵押房信息
                            itfLoanOrderBinder.bindOrderToPawnHouse(order);
                        } catch (Exception e) {
                            logger.error("绑定订单与抵押房信息失败", e);
                        }
                        
                        try {
                            //插入订单申请百行数据上报记录数据
                            NjOrderBhRecordMapper orderBhRecordMapper = dao.getMapper(NjOrderBhRecordMapper.class);
                            NjOrderBhRecord record = new NjOrderBhRecord();
                            record.setCreateDate(new Date());
                            record.setId(UuidUtil.get32UUID());
                            record.setOrderId(order.getId());
                            logger.info("插入订单申请百行数据上报记录数据开始..."+JSONObject.toJSONString(record));
                            orderBhRecordMapper.insertSelective(record);
                        } catch (Exception e) {
                            logger.error("插入订单申请百行数据上报记录数据报错", e);
                        }
                        
                    } else {
                        try {
                            //绑定基本信息
                            NjBaseInfoCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjBaseInfoCompanyMapper.class);
                            NjBaseInfoCompanyExample example = new NjBaseInfoCompanyExample();
                            example.createCriteria().andUserIdEqualTo(order.getUserId());
                            example.setOrderByClause("create_date desc");
                            List<NjBaseInfoCompany> baseInfoCompanyList = baseInfoCompanyMapper.selectByExample(example);
                            if (baseInfoCompanyList != null && baseInfoCompanyList.size() > 0) {
                                NjBaseInfoCompany baseInfoCompany = baseInfoCompanyList.get(0);
                                itfLoanOrderBinder.bindOrderBaseInfoCompany(order.getId(), baseInfoCompany.getId());
                            }
                        } catch (Exception e) {
                            logger.error("绑定企业订单与基本信息失败", e);
                        }
                        try {
                            //绑定联系人信息
                            NjContactCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjContactCompanyMapper.class);
                            NjContactCompanyExample example = new NjContactCompanyExample();
                            example.createCriteria().andUserIdEqualTo(order.getUserId());
                            example.setOrderByClause("create_date desc");
                            List<NjContactCompany> baseInfoCompanyList = baseInfoCompanyMapper.selectByExample(example);
                            if (baseInfoCompanyList != null && baseInfoCompanyList.size() > 0) {
                                NjContactCompany baseInfoCompany = baseInfoCompanyList.get(0);
                                itfLoanOrderBinder.bindOrderContactCompany(order.getId(), baseInfoCompany.getId());
                            }
                        } catch (Exception e) {
                            logger.error("绑定企业订单与联系人信息失败", e);
                        }

                        try {
                            //绑定场景信息
                            NjScenesCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjScenesCompanyMapper.class);
                            NjScenesCompanyExample example = new NjScenesCompanyExample();
                            example.createCriteria().andUserIdEqualTo(order.getUserId());
                            example.setOrderByClause("create_date desc");
                            List<NjScenesCompany> baseInfoCompanyList = baseInfoCompanyMapper.selectByExample(example);
                            if (baseInfoCompanyList != null && baseInfoCompanyList.size() > 0) {
                                NjScenesCompany baseInfoCompany = baseInfoCompanyList.get(0);
                                itfLoanOrderBinder.bindOrderScenesCompany(order.getId(), baseInfoCompany.getId());
                            }
                        } catch (Exception e) {
                            logger.error("绑定企业订单与场景信息失败", e);
                        }
                    }

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    logger.error("订单绑定个人信息异常", e);
                }
            }

        }.start();
        return order;
    }

    /**
     * 计算渠道分润
     *
     * @param order
     * @throws Exception
     */
    public void saveOrderChannel(NjLoanOrder order) throws Exception {

        // 查询该产品下配置的所有渠道
        NjProductChannelMapper njProductChannelMapper = dao.getMapper(NjProductChannelMapper.class);
        NjProductChannelExample njProductChannelExample = new NjProductChannelExample();
        njProductChannelExample.createCriteria().andProductIdEqualTo(order.getProductId()).andDelFlagEqualTo(false);
        List<NjProductChannel> listProductChannel = njProductChannelMapper.selectByExample(njProductChannelExample);

        // 渠道费率设置
        List<NjOrderChannel> listOrderChannel = new ArrayList<NjOrderChannel>();
        for (NjProductChannel productChannel : listProductChannel) {

            // 进件渠道
            if (productChannel.getType() == 1) {
                if (!order.getChannelId().equals(productChannel.getId())) {
                    continue;
                }
            }

            NjOrderChannel orderChannel = new NjOrderChannel();
            orderChannel.setId(UuidUtil.get32UUID());
            orderChannel.setBondType(productChannel.getBondType() != null ? productChannel.getBondType() : 1);
            orderChannel.setBondValue(!StringUtils.isEmpty(productChannel.getBondValue()) ? productChannel.getBondValue() : "0");
            orderChannel.setChannelId(productChannel.getNjChannelId());
            orderChannel.setChannelProductId(productChannel.getId());
            orderChannel.setChannelType(productChannel.getType());
            orderChannel.setOperateFee(productChannel.getOperateFee() != null ? productChannel.getOperateFee().toString() : "0");
            orderChannel.setOperateFeeType(productChannel.getOperateFeeType() != null ? productChannel.getOperateFeeType() : 1);
            orderChannel.setOrderId(order.getId());
            orderChannel.setIsRateContract(productChannel.getIsRateContract());

            NjOrderChannelMapper orderChannelMapper = dao.getMapper(NjOrderChannelMapper.class);
            orderChannelMapper.insert(orderChannel);
            listOrderChannel.add(orderChannel);

        }

        // 查询产品
        NjProduct prod = itfProductService.getProductById(order.getProductId());
        NjOrderChannelMapper orderChannelMapper = dao.getMapper(NjOrderChannelMapper.class);
        if (prod.getRepayWay().equals("10102")) { // 等额本息

            double financeAmount = order.getAuditAmount().doubleValue();//贷款金额
            double periodRate = OutOrderService.getPeriodRate(order.getAuditPeriod());//投资人年化
            double period = Double.parseDouble(order.getAuditPeriod().toString());// 贷款期数
            double firstRate = Double.parseDouble(order.getTotalRating()) / 100;
            double secondRate = Double.parseDouble(order.getAuditRating()) / 100;


            // 进件渠道分润
            for (NjOrderChannel njOrderChannel : listOrderChannel) {
                if (njOrderChannel.getChannelType() == 1) {
                    // 只有配置了渠道
                    if (njOrderChannel.getBondType().intValue() == 2) {
                        if (firstRate == secondRate) {
                            secondRate = firstRate - Double.parseDouble(njOrderChannel.getBondValue()) / 100;
                        }
                        if (firstRate != secondRate) {
                            // 期收费率 年化
                            String jjRate = OutOrderService.getPeriodServiceRate(firstRate, secondRate, period, financeAmount);
                            // 期收金额
                            String jjAmount = OutOrderService.getPeriodServiceAmount(firstRate, secondRate, period, financeAmount);
                            njOrderChannel.setBondValue(jjRate);
                            njOrderChannel.setBondFee(jjAmount);

                            orderChannelMapper.updateByPrimaryKey(njOrderChannel);
                            firstRate = secondRate;
                        }
                    }
                }
            }

            // 其它渠道分润
            for (NjOrderChannel njOrderChannel : listOrderChannel) {
                if (njOrderChannel.getChannelType() != 1) {
                    // 只有配置了渠道
                    if (njOrderChannel.getBondType().intValue() == 2) {
                        if (firstRate == secondRate) {
                            secondRate = firstRate - Double.parseDouble(njOrderChannel.getBondValue()) / 100;
                        }
                        if (firstRate != secondRate) {
                            // 期收费率 年化
                            String jjRate = OutOrderService.getPeriodServiceRate(firstRate, secondRate, period, financeAmount);
                            // 期收金额
                            String jjAmount = OutOrderService.getPeriodServiceAmount(firstRate, secondRate, period, financeAmount);
                            njOrderChannel.setBondValue(jjRate);
                            njOrderChannel.setBondFee(jjAmount);

                            orderChannelMapper.updateByPrimaryKey(njOrderChannel);
                            firstRate = secondRate;
                        }
                    }
                }
            }

            // 平台分润
            String jdRate = OutOrderService.getPeriodServiceRate(firstRate, periodRate, period, financeAmount);
            String jdAmount = OutOrderService.getPeriodServiceAmount(firstRate, periodRate, period, financeAmount);

            BigDecimal contractRate = new BigDecimal(jdRate);

            for (NjOrderChannel njOrderChannel : listOrderChannel) {
                if (njOrderChannel.getIsRateContract()) {
                    BigDecimal bondRate = new BigDecimal(njOrderChannel.getBondValue());
                    contractRate = contractRate.add(bondRate);
                }
            }
            order.setContractRate(String.format("%.6f", contractRate));
            order.setFixRate(String.format("%.6f", periodRate * 100));//投资人收益
            order.setFeeRate(jdRate);//期收费率 年化
            order.setFeeValue(jdAmount);//期收金额

            NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);
            orderMapper.updateByPrimaryKey(order);
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjLoanOrder saveLoanOrder(final NjLoanOrder order) throws Exception {
        Date nowTime = new Date();
        order.setCreateDate(nowTime);
        NjLoanOrderMapper sm = dao.getMapper(NjLoanOrderMapper.class);
        sm.insert(order);

        new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    itfLoanOrderBinder.bindOrderToUserBasic(order);
                    itfLoanOrderBinder.bindOrderToUserRel(order);
                    itfLoanOrderBinder.bindOrderToUserWork(order);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    logger.error("订单绑定个人信息已成", e);
                }
            }

        }.start();

        return order;
    }

    /**
     * 根据用户输入数据创建NjLoanOrder的实体，并做合法性校验
     *
     * @param jo
     * @return
     */
    public NjLoanOrder createOrder(JSONObject jo) throws Exception {
        //获取产品风控模板，暂时不实现
        NjLoanOrder order = new NjLoanOrder();
        order.setId(UuidUtil.get32UUID());
        order.setProductId(jo.getString("productId"));
        order.setUserId(jo.getString("accountId"));
        order.setAmount(jo.getBigDecimal("loanAmount"));
        order.setAgentId(jo.getString("channelCommissionerId"));
        order.setRelativeChanId(jo.getString("subChannelId"));
        order.setChannelId(jo.getString("channelId"));
        //获取借款期限具体值,loanPeriodId和loanPeriod 二选一
        String periodId = jo.getString("loanPeriodId");
        Integer periodInt = jo.getInteger("loanPeriod");
        if (!StringUtils.isEmpty(periodId)) {
            NjProductCycleMapper periodMapper = dao.getMapper(NjProductCycleMapper.class);
            NjProductCycle period = periodMapper.selectByPrimaryKey(periodId);
            SysDictMapper sdMapper = dao.getMapper(SysDictMapper.class);
            SysDict sd = sdMapper.selectByPrimaryKey(period.getSysId());
            order.setPeriod(new Integer(sd.getValue()));
        } else {
            order.setPeriod(periodInt);
        }

        //添加用户借款用途
        order.setUsageId(jo.getString("loanPurposeId"));
        order.setUsageDesc(jo.getString("loanPurposeDesc"));
        //订单默认状态
        order.setCreateDate(new Date());
        order.setDelFlag(false);
        order.setOrderNo(createOrderCode(order));
//		order.setStatus(Constants.ITF.ORDER_INIT);
        order.setStatus(LoanOrderConstant.STATUS_0);
        //如果不传，默认为天府财富账号，0x0001,天府财富账号
        //0x0002,线下放款账号
        if (jo.getInteger("loanMode") == null || (jo.getInteger("loanMode") & 0x0001) == 1) {//
            order.setLendMethod("LEND_ONL");
        } else {
            order.setLendMethod("LEND_OFF");
        }
        return order;
    }

    /**
     * 组装订单
     *
     * @param productId
     * @param loanAmount
     * @param period
     * @return
     * @throws Exception
     */
    public NjLoanOrder packageOrder(String productId, BigDecimal loanAmount, String cycleId, Integer period, String accountId, String scopeId, String channelCode) throws Exception {
        NjLoanOrder order = new NjLoanOrder();
        order.setId(UuidUtil.get32UUID());
        order.setProductId(productId);//产品id
        order.setOrderNo(createOrderCode(order));//设置订单编号
        //校验订单编号是否存在
        NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
        NjLoanOrder loanOrder = sm.getOrderByOrderNo(order.getOrderNo());
        if (null != loanOrder) {
            logger.error("订单编号已存在：" + order.getOrderNo());
            throw new Exception("订单编号已存在：" + order.getOrderNo());
        }
        order.setUserId(accountId);//用户id
        order.setAmount(loanAmount);//贷款金额
        order.setPeriod(period);//设置贷款期数
        NjProductCycleMapperExtend cycleMapper = dao.getMapper(NjProductCycleMapperExtend.class);
        //根据数据字典id获取贷款期数
        NjProductCycle productCycle = cycleMapper.getBySysCycleId(cycleId, productId);
        //设置订单资产登记
        order.setAssetGrade(productCycle.getGrade());
        order.setAuditAmount(loanAmount);//审核金额
        order.setAuditPeriod(period);//审核周期
        order.setUsageId(scopeId);//贷款用途id
        //根据借款用途id获取借款用途描述
        SysDictMapper sysDictMapper = dao.getMapper(SysDictMapper.class);
        SysDict sysDict = sysDictMapper.selectByPrimaryKey(scopeId);
        order.setUsageDesc(sysDict.getLabelText());//贷款用途描述

        order.setStatus(0);//订单状态
        order.setDelFlag(false);//是否删除
        //渠道id为空，为自主进件，默认为0
        if (null != channelCode && !"".equals(channelCode)) {
            NjProductChannelMapperExtend channelMapperExtend = dao.getMapper(NjProductChannelMapperExtend.class);
            NjProductChannel channel = channelMapperExtend.getChannelByChannelCodeAndProductId(productId, channelCode);
            if (null == channel) {
                logger.error("没有检索到相关渠道编号，产品id：" + productId + "，渠道编号：" + channelCode);
                throw new Exception("没有检索到相关渠道编号" + channelCode);
            }
            order.setChannelId(channel.getId());//关联渠道id
            //设置
            //该字段目前取的是nj_product_channel中的OperateFee字段（趸收），而这字段的意思是期收。目前有了nj_order_channel后，该字段没有意义，老数据做了数据转换。
            order.setAuditSxf(channel.getOperateFee() + "");
            order.setAuditSxfType(1);//默认比列
        } else {
            order.setChannelId("0");//关联渠道id
            order.setAuditSxf("0");
            order.setAuditSxfType(1);//默认比列
        }
        NjProductTransactionMapperExtend transactionMapperExtend = dao.getMapper(NjProductTransactionMapperExtend.class);
        Map<String, Object> njProductTransaction = transactionMapperExtend.selectByProductId(productId);
        order.setAuditRating(null == njProductTransaction.get("fixedInterestRate") ? "0" : njProductTransaction.get("fixedInterestRate").toString());//借款人利率
        order.setAuditServiceRating(null == njProductTransaction.get("serviceCharge") ? "0" : njProductTransaction.get("serviceCharge").toString());//平台利率
        order.setChargeFeeRate(null == njProductTransaction.get("serviceCharge") ? "0" : njProductTransaction.get("serviceCharge").toString());//等收利率
        order.setFixRate(null == njProductTransaction.get("serviceChargeTerm") ? "0" : njProductTransaction.get("serviceChargeTerm").toString());//投資人固定利率
//		order.setFeeRate(null == njProductTransaction.get("serviceChargeTerm") ?"0":njProductTransaction.get("serviceChargeTerm").toString());//期收利率

        NjProductMapper productMapper = dao.getMapper(NjProductMapper.class);
        NjProduct njProduct = productMapper.selectByPrimaryKey(productId);
        //绑定订单与同盾报告
        ResponseDto<List<TdReportData>> tdList = tdReportService.getTdScoreByUserId(accountId);
        logger.info("用户"+accountId+"下单获取同盾报告返回数据"+JSONArray.toJSONString(tdList));
        if (tdList.getReturnCode() == 0 && tdList.getResult().size() > 0) {
            TdReportData data = tdList.getResult().get(0);
            order.setTdReportId(data.getId());
            //校验报告时间是否已超过有效期
            Integer validatDays = njProduct.getTdReportValidDate();
            if (validatDays != null) {
            	
                long day = validatDays * 24 * 60 * 60 * 1000; // 将有效天数转换成毫秒
                long applyTime = data.getApply_time();//报告申请日期，单位毫秒
                applyTime = applyTime + day;//有效日期
                Date date = DateUtil.parseDate(DateUtil.formatDate(new Date()), "yyyy-MM-dd");
                if (date.getTime() > applyTime) {//如果当前日期已经超过有效期，则重新生成同盾报告
                	logger.info("用户"+accountId+"下单同盾有效期已经过期，有效期为"+validatDays+"，当前同盾报告生成日期为"+DateUtil.formatDate(new Date(new Long(data.getApply_time())), "yyyy-MM-dd HH:mm:ss"));
                	logger.info("比较数据applyTime："+applyTime+"，当前日期"+date.getTime());
                    NjAppUser appUser = appUserservice.getAppUser(accountId);
                    TdReportData tdReportData = new TdReportData();
                    tdReportData.setMobile(appUser.getMobile());
                    tdReportData.setId_number(appUser.getIdentifyId());
                    tdReportData.setName(appUser.getTrueName());
                    tdReportData.setUserId(appUser.getId());
                    ResponseDto<TdReportData> responseDto = tdReportService.generateTdReport(tdReportData);
                    if (responseDto.getReturnCode() == 0 && responseDto.getResult() != null) {
                        order.setTdReportId(responseDto.getResult().getId());
                    }
                }
            }

        }

        Map<String, Object> work = appUserservice.getRecentWorInfoNew(accountId);
        if (null != work) {//还款来源
            String companyNature = work.get("company_nature") == null || work.get("company_nature").equals("") ? "0" : work.get("company_nature").toString();
            if (Integer.valueOf(companyNature) < 6) {
                order.setFundsUse("借款人工资、经营、劳务报酬及投资等收入");
            } else {
                order.setFundsUse("借款人工资、经营、劳务报酬及投资等收入");
            }
        }
        if (null != njProduct) {
            order.setProductName(njProduct.getProductName());//设置产品名称
            order.setProjectContent(njProduct.getProductDescription());//设置项目概况
            order.setGeAgcyAdvice(njProduct.getGuaranteeValue());//设置担保公司
            order.setRepayWay(njProduct.getRepayWay() == null ? "" : njProduct.getRepayWay());//还款方式
            order.setLendMethod("LEND_ONL");//借款方式，线上线下
            order.setEnterpriseCase(sysDict.getLabelText());//借款用途
            if (njProduct.getPriceStrategy().toString().equals("2")) {
                order.setAmount(new BigDecimal(njProduct.getAmountInfo()));
            }
            // 如果产品配置没有配置资金渠道、则订单资金渠道放款默认为已放款
            NjProductChannelMapper njProductChannelMapper = dao.getMapper(NjProductChannelMapper.class);
            NjProductChannelExample example = new NjProductChannelExample();
            //渠道类型。资金(2)、渠道进件(1)类型
            example.createCriteria().andProductIdEqualTo(productId).andDelFlagEqualTo(false).andTypeEqualTo(new Short("2"));
            if (njProductChannelMapper.selectByExample(example).size() > 0) {
                order.setIsCapitalChannelPayed(false);
            } else {
                order.setIsCapitalChannelPayed(true);
            }
            order.setIsCompanyPayed(false);
        }
        // 绑定订单的公司ID
        NjCorpProdMapper corpProdMapper = dao.getMapper(NjCorpProdMapper.class);
        NjCorpProdExample corpProdExample = new NjCorpProdExample();
        corpProdExample.createCriteria().andProductIdEqualTo(productId);
        List<NjCorpProd> listNjCorpProd = corpProdMapper.selectByExample(corpProdExample);
        if (listNjCorpProd != null) {
            if (listNjCorpProd.size() > 0) {
                order.setCompanyId(listNjCorpProd.get(0).getCorporateId());
            }
        }

        return order;
    }

    public synchronized String createOrderCode(NjLoanOrder order) throws Exception {
        String orderCode = "";
        String productId = order.getProductId();
        if (StringUtils.isEmpty(productId))
            return null;
        //根据产品id获取企业编号,如果没有，则为金鼎财富企业编号0001
        NjProductMapperExtend njProductMapperExtend = dao.getMapper(NjProductMapperExtend.class);
        List<Map> maps = njProductMapperExtend.getProductCompanyMap(productId);
        if (maps != null && maps.size() > 0) {
            orderCode = maps.get(0).get("companyCode") == null ? Constants.OrderCodeConstructor.TFCF : maps.get(0).get("companyCode").toString();
        } else {
            orderCode = Constants.OrderCodeConstructor.TFCF;
        }
        NjProductMapper map = dao.getMapper(NjProductMapper.class);
        NjProduct prod = map.selectByPrimaryKey(order.getProductId());
        String prodCode = prod.getProductCode();
        //productCode补上前缀0
        while (prodCode.length() < 4) {
            prodCode = "0" + prodCode;
        }

        //获取渠道订单代码
        NjProductChannelMapperExtend mapExtend = dao.getMapper(NjProductChannelMapperExtend.class);

        //获取渠道号
        String channelId = "0000";//年月日6位

        Long orderCount = getOrderNum() + 100;
        Long orderCodeNum;
        String orderCodeNumStr;
        int maxOrderCode;
        String maxOrderCodeStr;

        orderCodeNum = orderCount + 1;

        orderCodeNumStr = Long.toString(orderCodeNum);
        while (orderCodeNumStr.length() < 6) {
            orderCodeNumStr = "0" + orderCodeNumStr;
        }
//		System.out.println("channelId="+channelId+";prodCode="+prodCode+"orderNo="+Constants.OrderCodeConstructor.TFCF+channelId+prodCode+orderCodeNumStr);
        return orderCode + channelId + prodCode + orderCodeNumStr;
    }

    /**
     * 获取订单详细信息
     *
     * @param orderId
     * @return
     */
    public Map<String, Object> getOrderDetailMap(String orderId) throws Exception {
        NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
        return sm.getOrderDetailMap(orderId);
    }

    /**
     * 根据订单状态生成app端的订单显示标签状态
     *
     * @param status
     * @return
     */
    public String getOrderStatusAppLabel(Integer status) throws Exception {
        for (ELoanOrderStatus iterable : ELoanOrderStatus.values()) {
            if (status.intValue() == iterable.getValue()) {
                return iterable.getName();
            }
        }
        return "未知";
    }

    /**
     * 检查订单前置条件是否完成
     *
     * @param order
     * @throws Exception
     */
    public void checkOrder(NjLoanOrder order) throws Exception {
    }

    /**
     * @param accountId:账户id
     * @return
     */
    public List<Map> getApplyingOrders(String accountId, int start, int rowNum) throws Exception {

        NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
        return sm.getUserOrders(accountId, start, rowNum);
    }

    public List<Map> getMyOrders(String accountId, int start, int rowNum, String companyCode) throws Exception {
        NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
        return sm.getUserOrdersByCompany(accountId, start, rowNum, companyCode);
    }

    public List<Map> getRepayingOrders(String accountId, int start, int rowNum) throws Exception {
        NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
        return sm.getUserOrders(accountId, start, rowNum);
    }

    public int getUserOrderCount(String accountId) throws Exception {
        NjLoanOrderMapper sm = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria().andUserIdEqualTo(accountId);
        return (int) sm.countByExample(example);
    }

    public NjLoanOrder getOrderById(String orderId) throws Exception {
        NjLoanOrderMapper sm = dao.getMapper(NjLoanOrderMapper.class);
        return sm.selectByPrimaryKey(orderId);
    }

    public NjLoanOrder getMaxOrder() throws Exception {
        NjLoanOrderMapperExtend sm = dao.getMapper(NjLoanOrderMapperExtend.class);
        NjLoanOrder m = sm.getMaxOrder();
        return m;
    }

    public Long getOrderNum() throws Exception {
        NjLoanOrderMapper sm = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria();
        return Long.valueOf(sm.countByExample(example));
    }

    public List<NjOrderFlows> getSystemOrderFlows() throws Exception {
        List<NjOrderFlows> orderFlows = null;
        if ((orderFlows = (List<NjOrderFlows>) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.SYSTEM, EhCacheConstant.ITF.ORDER_FLOWS)) == null) {
            NjOrderFlowsMapper mapper = dao.getMapper(NjOrderFlowsMapper.class);
            NjOrderFlowsExample example = new NjOrderFlowsExample();
            example.setOrderByClause("current_order_state asc");
            orderFlows = mapper.selectByExample(example);
            EhCacheUtil.getInstance().put(EhCacheConstant.ITF.SYSTEM, EhCacheConstant.ITF.ORDER_FLOWS, orderFlows);

        }
        return orderFlows;
    }

    public String getOrderFlow(int status, String statusLabel) throws Exception {
        List<Map> orderFlowCategory = getOrderCategory();
        NjOrderFlowsMapper mapper = dao.getMapper(NjOrderFlowsMapper.class);
        NjOrderFlowsExample exp = new NjOrderFlowsExample();
        exp.createCriteria().andCurrentOrderStateEqualTo(status);
        NjOrderFlows state = mapper.selectByExample(exp).get(0);

        List<Map> result = new ArrayList<Map>();
        for (Map i : orderFlowCategory) {
//			Map<String, Object> item = new HashMap<String, Object>();
            if (state.getCategory() == (Integer) i.get("category")) {//当前状态
//				item.put("stepName", i.get("appProcess"));
//				item.put("stepStatus", 2);
                return (String) i.get("appProcess");
//			} else if(state.getCategory() <(Integer)i.get("category")){//未到达该状态
//				item.put("stepName", i.get("appProcess"));
//				item.put("stepStatus", 3);
//			} else{//已到达该状态
//				item.put("stepName", i.get("appProcess"));
//				item.put("stepStatus", 1);
            }
//			result.add(item);
        }
        logger.info("order flow：" + result.toString());
        return "";

    }

    /**
     * @return currentProcess:当前状态,appProcess:当前状态手机展示，category:状态类型
     * @throws Exception
     */
    public List<Map> getOrderCategory() throws Exception {
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        return mapper.getOrderFlowCategory();
    }

    @Transactional(propagation = Propagation.NEVER)
    public void confirmOrder(NjLoanOrder order, String tokenName, String tokenId, String tfcfUserId, String smsCode, String applySequence, String resourceUrl) throws Exception {
        if (StringUtils.isEmpty(tfcfUserId)) {
            throw new ItfException("没有绑定银行卡");
        }
        if (StringUtils.isEmpty(smsCode) || StringUtils.isEmpty(applySequence)) {
            throw new ItfException("短信验证码或请求序列号好为空");
        }

        NjOrderUpdateLog log = new NjOrderUpdateLog();
        log.setUpdateReason("用户确认借款");
        //test not update order state
        //手动提交事务
        //orderService.updateOrderInfo(order, resourceUrl, log);
        //修改tfcf，在tfcf创建项目
        String orderNo = order.getOrderNo();
        Map<String, Object> tfcfParams = new HashMap<String, Object>();
        tfcfParams.put("tfdRequestId", orderNo);
        tfcfParams.put("requestId", orderNo);
        tfcfParams.put("applySequence", applySequence);
        tfcfParams.put("dynamicCode", smsCode);
        tfcfParams.put("userId", tfcfUserId);
        tfcfParams.put("requestType", 1);
        if (!StringUtils.isEmpty(order.getChannelId())) {
            NjProductChannelMapper pcm = dao.getMapper(NjProductChannelMapper.class);
            NjProductChannel pc = pcm.selectByPrimaryKey(order.getChannelId());
            tfcfParams.put("whereCode", pc == null ? "" : pc.getChannelCode());
        } else {
            tfcfParams.put("whereCode", "");
        }

        if (!StringUtils.isEmpty(order.getAgentId())) {
            NjChannelRelativeMapper crm = dao.getMapper(NjChannelRelativeMapper.class);
            NjChannelRelative cr = crm.selectByPrimaryKey(order.getAgentId());
            tfcfParams.put("brokerMobile", cr == null ? "" : cr.getChannelAcct());
        } else {
            tfcfParams.put("brokerMobile", "");
        }

        String srcUri = Constants.TFCF.ORDER_CONFIRM;

        String tfcfResp = tfcfHttpService.doHttpPostForTfcf(tokenName, tokenId, tfcfParams, srcUri);
        if (StringUtils.isEmpty(tfcfResp)) {
            logger.error("tfcf 新建项目失败");
            throw new ItfException("天府财富返回为空");
        }
        Map<String, Object> tfcfMsg = JSONObject.parseObject(tfcfResp, new HashMap<String, Object>().getClass());
        if (tfcfMsg == null || tfcfMsg.isEmpty()) {
            logger.error("tfcf 新建项目返回错误");
            throw new ItfException("天府财富返回错误");
        }
        if ((Integer) tfcfMsg.get("resultStatus") != 0) {
            logger.error("tfcf 返回错误msg:" + (String) tfcfMsg.get("msg"));
            throw new ItfException((String) tfcfMsg.get("msg"));
        }
    }

    @Transactional(propagation = Propagation.NEVER)
    public void createProject(NjLoanOrder order, String tokenName, String tokenId, String tfcfUserId, String resourceUrl) throws Exception {
        if (StringUtils.isEmpty(tfcfUserId)) {
            throw new ItfException("没有绑定银行卡");
        }

        NjOrderUpdateLog log = new NjOrderUpdateLog();
        log.setUpdateReason("用户确认借款");
        //test not update order state
        //手动提交事务
        //orderService.updateOrderInfo(order, resourceUrl, log);
        //修改tfcf，在tfcf创建项目
        String orderNo = order.getOrderNo();
        Map<String, Object> tfcfParams = new HashMap<String, Object>();
        tfcfParams.put("tfdRequestId", orderNo);
        tfcfParams.put("requestId", orderNo);

        tfcfParams.put("userId", tfcfUserId);
        tfcfParams.put("requestType", 1);
        if (!StringUtils.isEmpty(order.getChannelId())) {
            NjProductChannelMapper pcm = dao.getMapper(NjProductChannelMapper.class);
            NjProductChannel pc = pcm.selectByPrimaryKey(order.getChannelId());
            tfcfParams.put("whereCode", pc == null ? "" : pc.getChannelCode());
        } else {
            tfcfParams.put("whereCode", "");
        }

        if (!StringUtils.isEmpty(order.getAgentId())) {
            NjChannelRelativeMapper crm = dao.getMapper(NjChannelRelativeMapper.class);
            NjChannelRelative cr = crm.selectByPrimaryKey(order.getAgentId());
            tfcfParams.put("brokerMobile", cr == null ? "" : cr.getChannelAcct());
        } else {
            tfcfParams.put("brokerMobile", "");
        }

        String srcUri = Constants.TFCF.ORDER_CONFIRM;

        String tfcfResp = tfcfHttpService.doHttpPostForTfcf(tokenName, tokenId, tfcfParams, srcUri);
        if (StringUtils.isEmpty(tfcfResp)) {
            logger.error("tfcf 新建项目失败");
            throw new ItfException("天府财富返回为空");
        }
        Map<String, Object> tfcfMsg = JSONObject.parseObject(tfcfResp, new HashMap<String, Object>().getClass());
        if (tfcfMsg == null || tfcfMsg.isEmpty()) {
            logger.error("tfcf 新建项目返回错误");
            throw new ItfException("天府财富返回错误");
        }
        if ((Integer) tfcfMsg.get("resultStatus") != 0) {
            logger.error("tfcf 返回错误msg:" + (String) tfcfMsg.get("msg"));
            throw new ItfException((String) tfcfMsg.get("msg"));
        }
    }

    public NjLoanOrder getOrderByOrderNo(String orderNo) throws Exception {
        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria().andOrderNoEqualTo(orderNo);
        List<NjLoanOrder> orders = mapper.selectByExample(example);
        if (orders == null || orders.isEmpty())
            return null;
        return orders.get(0);
    }

    public Long getApplyingOrderCount(String userId) throws Exception {
        List<Integer> status = new ArrayList<Integer>();
        //status.add(Constants.ITF.ORDER_SYSTEM_REJECT);
        status.add(Constants.ITF.ORDER_BUSSINESS_REJECT);
        status.add(LoanOrderConstant.STATUS_99);//用户还款完成
        status.add(ELoanOrderStatus.USER_REFUSE.getValue());
        status.add(-1);

        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria().andUserIdEqualTo(userId).andStatusNotIn(status);
        return Long.valueOf(mapper.countByExample(example));
    }

    /**
     * 通过用户ID查询订单
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<NjLoanOrder> getOrderByUserId(String userId) throws Exception {

        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(LoanOrderConstant.STATUS_12);
        return mapper.selectByExample(example);
    }

    /**
     * 通过用户ID查询订单累计借款总笔数，在借和已还款完成的。
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public Long getLoanOrderCount(String userId) throws Exception {
        List<Integer> status = new ArrayList<Integer>();
        status.add(LoanOrderConstant.STATUS_99);//用户还款完成
        status.add(LoanOrderConstant.STATUS_12);//已发款

        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria().andUserIdEqualTo(userId).andStatusIn(status);
        return Long.valueOf(mapper.countByExample(example));
    }


    public double getApplyingOrderAmount(String userId) throws Exception {

        List<Integer> status = new ArrayList<Integer>();
        status.add(Constants.ITF.ORDER_SYSTEM_REJECT);
        status.add(Constants.ITF.ORDER_BUSSINESS_REJECT);
        status.add(LoanOrderConstant.STATUS_99);//用户还款完成
        status.add(ELoanOrderStatus.USER_REFUSE.getValue());

        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria().andUserIdEqualTo(userId).andStatusNotIn(status);
        List<NjLoanOrder> listOrder = mapper.selectByExample(example);
        BigDecimal amount = new BigDecimal("0");
        for (NjLoanOrder order : listOrder) {
            BigDecimal auditAmountObj = order.getAuditAmount();
            if (auditAmountObj == null) {
                amount = amount.add(order.getAmount());
            } else {
                amount = amount.add(order.getAuditAmount());
            }
        }
        return amount.doubleValue();
    }

    public double getApplyingOrderAmountForProduct(String userId, String productId) throws Exception {

        List<Integer> status = new ArrayList<Integer>();
        status.add(Constants.ITF.ORDER_SYSTEM_REJECT);
        status.add(Constants.ITF.ORDER_BUSSINESS_REJECT);
        status.add(LoanOrderConstant.STATUS_99);//用户还款完成
        status.add(ELoanOrderStatus.USER_REFUSE.getValue());

        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria().andUserIdEqualTo(userId).andStatusNotIn(status).andProductIdEqualTo(productId);
        List<NjLoanOrder> listOrder = mapper.selectByExample(example);
        BigDecimal amount = new BigDecimal("0");
        for (NjLoanOrder order : listOrder) {
            BigDecimal auditAmountObj = order.getAuditAmount();
            if (auditAmountObj == null) {
                amount = amount.add(order.getAmount());
            } else {
                amount = amount.add(order.getAuditAmount());
            }
        }
        return amount.doubleValue();
    }

    /**
     * 获得产品的最高限额
     *
     * @param productId
     * @return
     * @throws Exception
     */
    public double getProductAmount(String productId) throws Exception {
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        return mapper.getProductAmount(productId);
    }

    /**
     * 通过用户ID查询订单累计借款总金额，在借和已还款完成的。
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public double getLoanOrderAmount(String userId) throws Exception {

        List<Integer> status = new ArrayList<Integer>();
        status.add(LoanOrderConstant.STATUS_99);//用户还款完成
        status.add(LoanOrderConstant.STATUS_12);//已发款

        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrderExample example = new NjLoanOrderExample();
        example.createCriteria().andUserIdEqualTo(userId).andStatusIn(status);
        List<NjLoanOrder> listOrder = mapper.selectByExample(example);
        BigDecimal amount = new BigDecimal(0);
        for (NjLoanOrder order : listOrder) {
            BigDecimal auditAmountObj = order.getAuditAmount();
            if (auditAmountObj == null) {
                amount = amount.add(new BigDecimal(0));
            } else {
                amount = amount.add(auditAmountObj);
            }
        }
        return amount.doubleValue();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addAdditionInfo(String orderId, String addition, JSONArray atts) throws Exception {
        if (StringUtils.isEmpty(orderId)) {
            return;
        }
        //生成补充信息表
        Date now = new Date();
        NjAddtionInfo add = new NjAddtionInfo();
        add.setAddition(addition);
        add.setDelFlag(false);
        add.setCreateDate(now);
        add.setVersion(getAdditionVersion(orderId) + 1);
        add.setId(UuidUtil.get32UUID());
        NjAddtionInfoMapper addMapper = dao.getMapper(NjAddtionInfoMapper.class);
        NjAdditionAttachmentMapper addAttMapper = dao.getMapper(NjAdditionAttachmentMapper.class);
        NjOrderAdditionMapper orderAddMapper = dao.getMapper(NjOrderAdditionMapper.class);
        addMapper.insert(add);
        //补充信息和附件对应
        if (atts != null && !atts.isEmpty()) {
            for (int i = 0; i < atts.size(); i++) {
                NjAdditionAttachment addAtt = new NjAdditionAttachment();
                addAtt.setId(UuidUtil.get32UUID());
                addAtt.setAdditionId(add.getId());
                addAtt.setAttachmentId(atts.getJSONObject(i).getString("attachmentId"));
                addAtt.setType(atts.getJSONObject(i).getInteger("type"));
                addAtt.setDelFlag(false);
                addAttMapper.insert(addAtt);
            }
        }
        //和订单绑定
        NjOrderAddition orderAdd = new NjOrderAddition();
        orderAdd.setId(UuidUtil.get32UUID());
        orderAdd.setOrderId(orderId);
        orderAdd.setAdditionId(add.getId());
        orderAddMapper.insert(orderAdd);
    }

    public Integer getAdditionVersion(String orderId) throws Exception {
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        Integer version = mapper.getAdditionVersion(orderId);
        if (version == null)
            return 0;
        return version;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public Map<String, Object> getAdditionInfo(String orderId) throws Exception {
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        List<Map> ret = new ArrayList<Map>();
        List<Map<String, Object>> results = mapper.getAddition(orderId);
        if (results == null)
            return null;
        for (Map<String, Object> item : results) {
            String additionId = (String) item.get("additionId");
            if (StringUtils.isEmpty(additionId))
                continue;
            List<Map> atts = mapper.getAdditionAttachment(additionId);
            ret.addAll(atts);
        }
        Map<String, Object> rets = new HashMap<String, Object>();
        rets.put("attachment", ret);
        return rets;
    }

    public String getOrderStateText(int state) throws Exception {
        NjOrderFlowsMapper mapper = dao.getMapper(NjOrderFlowsMapper.class);
        NjOrderFlowsExample exp = new NjOrderFlowsExample();
        exp.createCriteria().andCurrentOrderStateEqualTo(state);
        NjOrderFlows flow = mapper.selectByExample(exp).get(0);
        return flow.getCurrentOrderDisplayState();
    }

    /**
     * 按订单id和订单状态，获取该状态操作的最后一次日志
     *
     * @param orderId:订单code
     * @param state
     * @return
     * @throws Exception
     */
    public String getOrderLogByState(String orderId, Integer state) throws Exception {
        NjOrderUpdateLogMapper logMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
        NjOrderUpdateLogExample exp = new NjOrderUpdateLogExample();
        exp.createCriteria().andOrderIdEqualTo(orderId)
                .andUpdateStatusEqualTo(state);
        exp.setOrderByClause("update_date desc");
        List<NjOrderUpdateLog> logs = logMapper.selectByExample(exp);
        Map<String, Object> ret = new HashMap<String, Object>();
        if (logs == null || logs.isEmpty())
            return "";
        return StringUtils.isEmpty(logs.get(0).getRemark()) ? logs.get(0).getUpdateReason() : logs.get(0).getRemark();
    }

    /**
     * 用户确认订单，只是改变订单状态为 已确认-9
     *
     * @param orderId
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjProductTemp confirmOrder2(String orderId) throws Exception {
        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjOrderUpdateLogMapper logMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
        NjLoanOrder order = mapper.selectByPrimaryKey(orderId);

        NjProcessMapperExtend processMapperExtend = dao.getMapper(NjProcessMapperExtend.class);
        NjProcessTemplateFlows contractProcess = processMapperExtend.selectProcessTemplateByOrderProcess(orderId, EProcessInfo.USER_CONFIRM.getId());

        Integer oldStatus = order.getStatus();
        //更新订单状态
        order.setStatus(LoanOrderConstant.STATUS_9);
        mapper.updateByPrimaryKeySelective(order);

        NjOrderUpdateLog log1 = new NjOrderUpdateLog();
        log1.setId(UuidUtil.get32UUID());
        log1.setId(UuidUtil.get32UUID());
        log1.setOldStatus(oldStatus);
        log1.setUpdateReason("用户确认借款");
        log1.setProcessId(contractProcess.getProcessId());
        log1.setUpdateStatus(LoanOrderConstant.STATUS_9);
        log1.setUpdateChannel(0);
        log1.setUpdateDate(new Date());
        log1.setOrderId(order.getOrderNo());
        NjAppUserMapper appUserMapper = dao.getMapper(NjAppUserMapper.class);
        NjAppUser appUser = appUserMapper.selectByPrimaryKey(order.getUserId());
        log1.setUserId("用户【" + appUser.getTrueName() + "】");
        logMapper.insert(log1);

        NjProductTempMapperExtend extend = dao.getMapper(NjProductTempMapperExtend.class);
        NjProductTemp njProductTemp = extend.selectByProductId(order.getProductId());
        if (null == njProductTemp || njProductTemp.getProcessTemplateId() == null) {
            logger.error("产品流程配置错误，没有找到订单id为：" + order.getId() + "产品id为：" + order.getProductId() + "的流程模板信息");
            throw new Exception("产品流程配置错误");
        }
        Thread.sleep(50);
        //获取订单对应产品流程模板
        try {
            NjProcessTemplateFlows currentProcess = processMapperExtend.selectProcessTemplateByOrderProcess(orderId, EProcessInfo.USER_CONFIRM.getId());
            NjProcessTemplateFlows nextCurrent = processFlowsService.selectNextProcess(currentProcess, EProcessResult.AGREE);
            OrderMq orderMq = new OrderMq(orderId, nextCurrent.getProcessId(), njProductTemp.getProcessTemplateId());

            NjLoanOrder loanOrder = orderService.getOrder(orderId);
            if (loanOrder.getCompanyId() != null && !loanOrder.getCompanyId().equals(Constants.DEFAULT_COMPANY_ID)) {//如果是能贷
                ResponseDto<String> tresponse = mqNdService.sendOrderProcessMq(orderMq);
                logger.debug("用户确认成功，发送消息:{}", JSON.toJSONString(tresponse));
            } else {
                ResponseDto<String> tresponse = mqService.sendOrderProcessMq(orderMq);
                logger.debug("用户确认成功，发送消息:{}", JSON.toJSONString(tresponse));
            }
        } catch (Exception e) {
            logger.error("orderConfirm--> 用户确认订单执行消息队列错误" + e);
            throw new Exception("用户确认订单执行消息队列错误" + e);
        }

        return njProductTemp;
    }

    /**
     * @param order
     * @return 0:不生成合同，1：财富端生成合同，2：自上传合同
     * @throws Exception
     */
    public int getOrderContractSource(NjLoanOrder order) throws Exception {
        /*NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        if(StringUtils.isEmpty(order.getRelendMethod()))
			return 0;
		//订单分成线上还是线下
		//线下放款
		if("0".equals(order.getRelendMethod())){
			Integer type =mapper.getOfflineOrderContractGenType(order.getProductId());
			return type==null?0:type;
		}
		Integer type =mapper.getOnlOrderContractGenType(new Integer(order.getRelendMethod()), order.getProductId());
		return type==null ?0 :type;*/
        if (StringUtils.isEmpty(order.getContractAttrId())) {//财富端生成合同
            return 1;
        } else {//自上传合同
            return 2;
        }
    }

    /**
     * 根据订单id查询是否生成合同
     *
     * @param orderId
     * @return 0:不生成合同，1：生成合同
     */
    public int getOrderIsGenContract(String orderId) throws Exception {
        if (StringUtils.isEmpty(orderId))
            return 0;
        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrder order = mapper.selectByPrimaryKey(orderId);
        if (order == null)
            return 0;
        return getOrderContractSource(order) == 0 ? 0 : 1;
    }

    public List<Map<String, Object>> selectUserOrderAttach(String orderId) throws Exception {
        NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
        return extend.selectUserOrderAttach(orderId);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addUserOrderAttach(Map<String, String> map) throws Exception {
        String orderId = map.get("orderId");
        String attachId = map.get("attachId");
        NjLoanOrderMapper loanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrder loanOrder = loanOrderMapper.selectByPrimaryKey(orderId);
        if (null == loanOrder) {
            throw new Exception("没有检索到订单id为" + orderId + "的订单");
        }
        NjOrderAttachmentMapper orderAttachmentMapper = dao.getMapper(NjOrderAttachmentMapper.class);
        NjOrderAttachment orderAttachment = new NjOrderAttachment();
        orderAttachment.setId(UuidUtil.get32UUID());
        orderAttachment.setAttachId(attachId);
        orderAttachment.setOrderId(orderId);
        orderAttachmentMapper.insertSelective(orderAttachment);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addUserOrderInfo(String productId, String orderId, Double loanAmount, String cycleId, Integer period, String scopeId, String channelCode, String repayWay) throws Exception {
        NjLoanOrderMapper loanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrder loanOrder = loanOrderMapper.selectByPrimaryKey(orderId);
        if (null == loanOrder) {
            throw new Exception("没有检索到订单id为" + orderId + "的订单");
        }
        loanOrder.setAmount(new BigDecimal(loanAmount));//贷款金额
        loanOrder.setPeriod(period);//设置贷款期数
        NjProductCycleMapperExtend cycleMapper = dao.getMapper(NjProductCycleMapperExtend.class);
        //根据数据字典id获取贷款期数
        NjProductCycle productCycle = cycleMapper.getBySysCycleId(cycleId, productId);
        //设置订单资产登记
        loanOrder.setAssetGrade(productCycle.getGrade());
        loanOrder.setUsageId(scopeId);//贷款用途id
        //根据借款用途id获取借款用途描述
        SysDictMapper sysDictMapper = dao.getMapper(SysDictMapper.class);
        SysDict sysDict = sysDictMapper.selectByPrimaryKey(scopeId);
        loanOrder.setUsageDesc(sysDict.getLabelText());//贷款用途描述
        if (repayWay != null && !repayWay.equals("")) {
            loanOrder.setRepayWay(repayWay);
        }
        //渠道id为空，为自主进件，默认为0
        if (null != channelCode && !"".equals(channelCode)) {
            NjProductChannelMapperExtend channelMapperExtend = dao.getMapper(NjProductChannelMapperExtend.class);
            NjProductChannel channel = channelMapperExtend.getChannelByChannelCodeAndProductId(productId, channelCode);
            if (null == channel) {
                logger.error("没有检索到相关渠道编号，产品id：" + productId + "，渠道编号：" + channelCode);
                throw new Exception("没有检索到相关渠道编号" + channelCode);
            }
            loanOrder.setChannelId(channel.getId());//关联渠道id
        } else {
            loanOrder.setChannelId("0");//关联渠道id
        }
        NjLoanOrderMapper sm = dao.getMapper(NjLoanOrderMapper.class);
        sm.updateByPrimaryKeySelective(loanOrder);
    }

    /**
     * 用户确认订单，只是改变订单状态为 已确认-9
     *
     * @param orderId
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void refuseOrder(String orderId) throws Exception {

        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        NjOrderUpdateLogMapper logMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
        NjLoanOrder order = mapper.selectByPrimaryKey(orderId);

        NjProcessMapperExtend processMapperExtend = dao.getMapper(NjProcessMapperExtend.class);
        NjProcessTemplateFlows contractProcess = processMapperExtend.selectProcessTemplateByOrderProcess(orderId, EProcessInfo.USER_CONFIRM.getId());

        NjOrderUpdateLog log1 = new NjOrderUpdateLog();
        log1.setId(UuidUtil.get32UUID());
        log1.setId(UuidUtil.get32UUID());
        log1.setOldStatus(order.getStatus());
        log1.setUpdateReason("用户确认拒绝");
        log1.setProcessId(contractProcess.getProcessId());
        log1.setUpdateStatus(ELoanOrderStatus.USER_REFUSE.getValue());
        log1.setUpdateChannel(0);
        log1.setUpdateDate(new Date());
        log1.setOrderId(order.getOrderNo());
        log1.setUserId(order.getUserId());
        logMapper.insert(log1);

        //更新订单状态
        order.setStatus(ELoanOrderStatus.USER_REFUSE.getValue());
        mapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 增补资料删除附件信息
     *
     * @param map
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void deleteUserOrderAttach(Map<String, String> map) throws Exception {
        NjOrderAttachmentMapperExtend extend = dao.getMapper(NjOrderAttachmentMapperExtend.class);
        NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
        fileOperationService.deleteFile(map.get("attachId"));
        mapper.deleteByPrimaryKey(map.get("attachId"));
        extend.deleteAttach(map);

    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addUserLivingAttach(String orderId, String faceIdObj) throws Exception {
        JSONObject faceId = JSONObject.parseObject(faceIdObj);
        NjLoanOrderMapper loanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
        //清除之前活体认证
        NjOrderHuotiMapperExtend extend = dao.getMapper(NjOrderHuotiMapperExtend.class);
        extend.deleteHuotiByOrderId(orderId);

        if (faceId != null) {
            Map<String, String> map = new HashMap<>();
            if (!StringUtils.isEmpty(faceId.getString("imageBestId"))) {//如果imageBestId不为空
                map.put("attachId", faceId.getString("imageBestId"));
                map.put("orderId", orderId);
                addUserOrderAttach(map);
            }
            if (!StringUtils.isEmpty(faceId.getString("imageEnvId"))) {//如果imageEnvId不为空
                map.put("attachId", faceId.getString("imageEnvId"));
                map.put("orderId", orderId);
                addUserOrderAttach(map);
            }
            if (!StringUtils.isEmpty(faceId.getString("image0Id"))) {//如果image2Id不为空
                map.put("attachId", faceId.getString("image0Id"));
                map.put("orderId", orderId);
                addUserOrderAttach(map);
            }
            if (!StringUtils.isEmpty(faceId.getString("image1Id"))) {//如果image1Id不为空
                map.put("attachId", faceId.getString("image1Id"));
                map.put("orderId", orderId);
                addUserOrderAttach(map);
            }
            if (!StringUtils.isEmpty(faceId.getString("image2Id"))) {//如果image2Id不为空
                map.put("attachId", faceId.getString("image2Id"));
                map.put("orderId", orderId);
                addUserOrderAttach(map);
            }
            /*if(!StringUtils.isEmpty(faceId.getString("imageHeadId"))){//如果imageHeadId不为空
                itfLoanOrderBinder.bindOrderToAttachement(order, faceId.getString("imageHeadId"));
			}
			if(!StringUtils.isEmpty(faceId.getString("imageEmblemId"))){//如果imageEmblemId不为空
				itfLoanOrderBinder.bindOrderToAttachement(order, faceId.getString("imageEmblemId"));
			}*/
            //绑定身份证照片信息,先查是否有上传身份证
//			itfLoanOrderBinder.bindCertImage(order);

        }
    }

    /**
     * 通过产品ID查询产品配置
     *
     * @param productId
     * @return
     * @throws Exception
     */
    public NjProductTransaction getProductTransactionByProductId(String productId) throws Exception {

        NjProductTransactionMapper mapper = dao.getMapper(NjProductTransactionMapper.class);
        NjProductTransactionExample example = new NjProductTransactionExample();
        example.createCriteria().andProductIdEqualTo(productId);
        List<NjProductTransaction> listNjProductTransaction = mapper.selectByExample(example);
        if (listNjProductTransaction.size() > 0) {
            return listNjProductTransaction.get(0);
        }

        return null;

    }

    public ExterBusinessFeeCalcParam getExternalParams(String externalParamClazz, String orderNo, int type) {
        NjOrderFeeMapperExtend njOrderFeeMapperExtend;
        NjLoanOrderMapperExtend njLoanOrderMapperExtend;
        NjOrderChannelMapper njOrderChannelMapper;
        NjProductChannelMapper njProductChannelMapper;
        logger.info("调用获取外部参数,orderNo=" + orderNo + ",externalParamClazz=" + externalParamClazz);
        try {
            njLoanOrderMapperExtend = dao.getMapper(NjLoanOrderMapperExtend.class);
            njOrderFeeMapperExtend = dao.getMapper(NjOrderFeeMapperExtend.class);
            njOrderChannelMapper = dao.getMapper(NjOrderChannelMapper.class);
            njProductChannelMapper = dao.getMapper(NjProductChannelMapper.class);
        } catch (Exception e) {
            return null;
        }
        NjLoanOrder order = njLoanOrderMapperExtend.getOrderByOrderNo(orderNo);
        if (null == order) {
            return null;
        }
        List<NjOrderFee> njOrderFees = njOrderFeeMapperExtend.selectOrderFeeByOrderId(order.getId());
        List<ManualParam> manualParams = new ArrayList<>();
        if (null != njOrderFees && !njOrderFees.isEmpty()) {
            for (NjOrderFee njOrderFee : njOrderFees) {
                ManualParam manualParam = new ManualParam();
                manualParam.setCode(njOrderFee.getBusinessFeeCode());
                manualParam.setValue(njOrderFee.getAmount());
                manualParams.add(manualParam);
            }
        }
        if ("com.nj.core.fee.algoParam.external.PenaltyInterestNotCalcExternalParam".equals(externalParamClazz)) {
            PenaltyInterestNotCalcExternalParam penaltyInterestNotCalcExternalParam = new PenaltyInterestNotCalcExternalParam();
            penaltyInterestNotCalcExternalParam.setManualParams(manualParams);
            return penaltyInterestNotCalcExternalParam;
        } else if ("com.nj.core.fee.algoParam.external.PenaltyInterestHalfOfDayInterestCalcExternalParam".equals(externalParamClazz)) {
            PenaltyInterestHalfOfDayInterestCalcExternalParam penaltyInterestHalfOfDayInterestCalcExternalParam = new PenaltyInterestHalfOfDayInterestCalcExternalParam();
//            penaltyInterestHalfOfDayInterestCalcExternalParam.setLoanAmount(type == ExterFeeAlgoParamCfg.REPAY_PLAN ? order.getAuditAmount() : order.getActualAmount());
            penaltyInterestHalfOfDayInterestCalcExternalParam.setLoanAmount(order.getAuditAmount());
            penaltyInterestHalfOfDayInterestCalcExternalParam.setYearRate(new BigDecimal(order.getAuditRating()).divide(new BigDecimal(100), 6, BigDecimal.ROUND_HALF_EVEN));
            penaltyInterestHalfOfDayInterestCalcExternalParam.setManualParams(manualParams);
            return penaltyInterestHalfOfDayInterestCalcExternalParam;
        } else if ("com.nj.core.fee.algoParam.external.ChannelFeePeriodCollect1CalcExternalParam".equals(externalParamClazz)) {
            ChannelFeePeriodCollect1CalcExternalParam channelFeePeriodCollect1CalcExternalParam = new ChannelFeePeriodCollect1CalcExternalParam();
            channelFeePeriodCollect1CalcExternalParam.setManualParams(manualParams);

            NjProductChannel njProductChannel = njProductChannelMapper.selectByPrimaryKey(order.getChannelId());
            if (null != njProductChannel) {
                NjOrderChannelExample njOrderChannelExample = new NjOrderChannelExample();
                njOrderChannelExample.createCriteria().andOrderIdEqualTo(order.getId()).andChannelIdEqualTo(njProductChannel.getNjChannelId()).andChannelTypeEqualTo((short) 1);
                List<NjOrderChannel> njOrderChannels = njOrderChannelMapper.selectByExample(njOrderChannelExample);
                if (null != njOrderChannels && !njOrderChannels.isEmpty()) {
                    NjOrderChannel njOrderChannel = njOrderChannels.get(0);
                    if (StringUtils.isEmpty(njOrderChannel.getBondValue())) {
                        channelFeePeriodCollect1CalcExternalParam.setChannelFeeRateForMonth(new BigDecimal(0));
                    } else {
                        channelFeePeriodCollect1CalcExternalParam.setChannelFeeRateForMonth(new BigDecimal(njOrderChannel.getBondValue())
                                .divide(new BigDecimal(100), 6, BigDecimal.ROUND_HALF_EVEN));
                    }
                } else {
                    channelFeePeriodCollect1CalcExternalParam.setChannelFeeRateForMonth(new BigDecimal(0));
                }
            } else {
                channelFeePeriodCollect1CalcExternalParam.setChannelFeeRateForMonth(new BigDecimal(0));
            }
//            channelFeePeriodCollect1CalcExternalParam.setLoanAmount(type == ExterFeeAlgoParamCfg.REPAY_PLAN ? order.getAuditAmount() : order.getActualAmount());
            channelFeePeriodCollect1CalcExternalParam.setLoanAmount(order.getAuditAmount());
            return channelFeePeriodCollect1CalcExternalParam;
        } else if ("com.nj.core.fee.algoParam.external.MediacyFeeAvgToPerioCalcExternalParam".equals(externalParamClazz)) {
            MediacyFeeAvgToPerioCalcExternalParam mediacyFeeAvgToPerioCalcExternalParam = new MediacyFeeAvgToPerioCalcExternalParam();
            mediacyFeeAvgToPerioCalcExternalParam.setManualParams(manualParams);
            return mediacyFeeAvgToPerioCalcExternalParam;
        } else if ("com.nj.core.fee.base.ExterBusinessFeeCalcParam".equals(externalParamClazz)) {
            ExterBusinessFeeCalcParam exterBusinessFeeCalcParam = new ExterBusinessFeeCalcParam();
            exterBusinessFeeCalcParam.setManualParams(manualParams);
            return exterBusinessFeeCalcParam;
        } else if ("com.nj.core.fee.algoParam.external.ChannelFeeFirstPeriod1CalcExternalParam".equals(externalParamClazz)) {
            ChannelFeeFirstPeriod1CalcExternalParam channelFeeFirstPeriod1CalcExternalParam = new ChannelFeeFirstPeriod1CalcExternalParam();
            channelFeeFirstPeriod1CalcExternalParam.setLoanAmount(order.getAuditAmount());

            NjProductChannel njProductChannel = njProductChannelMapper.selectByPrimaryKey(order.getChannelId());
            if (null != njProductChannel) {
                NjOrderChannelExample njOrderChannelExample = new NjOrderChannelExample();
                njOrderChannelExample.createCriteria().andOrderIdEqualTo(order.getId()).andChannelIdEqualTo(njProductChannel.getNjChannelId()).andChannelTypeEqualTo((short) 1);
                List<NjOrderChannel> njOrderChannels = njOrderChannelMapper.selectByExample(njOrderChannelExample);
                if (null != njOrderChannels && !njOrderChannels.isEmpty()) {
                    NjOrderChannel njOrderChannel = njOrderChannels.get(0);
                    if (StringUtils.isEmpty(njOrderChannel.getOperateFee())) {
                        channelFeeFirstPeriod1CalcExternalParam.setChannelFeeRate(new BigDecimal(0));
                    } else {
                        if (njOrderChannel.getOperateFeeType() == 2) {
                            channelFeeFirstPeriod1CalcExternalParam.setChannelFeeRate(new BigDecimal(njOrderChannel.getOperateFee())
                                    .divide(new BigDecimal(100), 6, BigDecimal.ROUND_HALF_EVEN));
                        } else {
                            channelFeeFirstPeriod1CalcExternalParam.setChannelFeeRate(new BigDecimal(0));
                        }
                    }
                } else {
                    channelFeeFirstPeriod1CalcExternalParam.setChannelFeeRate(new BigDecimal(0));
                }
            } else {
                channelFeeFirstPeriod1CalcExternalParam.setChannelFeeRate(new BigDecimal(0));
            }
            return channelFeeFirstPeriod1CalcExternalParam;
        } else {
            if ("com.nj.core.fee.algoParam.external.MediacyFeeFirstPeriodCalcExternalParam".equals(externalParamClazz)) {
                MediacyFeeFirstPeriodCalcExternalParam mediacyFeeAvgToPerioCalcExternalParam = new MediacyFeeFirstPeriodCalcExternalParam();
                mediacyFeeAvgToPerioCalcExternalParam.setManualParams(manualParams);
                return mediacyFeeAvgToPerioCalcExternalParam;
            }
        }
        return null;

    }

    /**
     * 合同电子签章（无手签名）
     *
     * @param orderNo
     * @return
     * @throws BaseException
     */
    public void contractEsign(String orderNo) throws BaseException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tfdRequestId", orderNo);
        try {
            String tfcfResp = tfcfHttpService.doHttpPostForTfcf(params, Constants.TFCF.CONTRACT_ESIGN_NO_SEAL);
            if (StringUtils.isEmpty(tfcfResp)) {
                logger.info("返回值为空，资金端电子签章调用失败：" + orderNo);
            } else {
                ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
                int resultStatus = tfcfResp1.getResultStatus();
                if (resultStatus == 0) {
                    logger.info("合同签章成功：" + orderNo);

                } else if (resultStatus == -4) {
                    logger.info("重复签署：" + orderNo);

                } else {
                    logger.info("合同签章失败：" + orderNo + "失败原因" + tfcfResp1.getMsg());

                }
            }
        } catch (Exception e) {
            logger.error(orderNo + "合同签章系统错误：" + e);
            throw new BaseException("系统错误，" + e.getMessage());
        }
    }

    public List<NjLoanOrder> selectContractEsign(String productIds, Integer page, Integer rows) throws Exception {
        NjLoanOrderMapperExtend loanOrderMapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        Integer start = page * rows - rows;
        return loanOrderMapper.selectContractEsign(productIds, start, rows);
    }
    
    /**
     * 保存用户激活通知
     * @param notice
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void saveUserActivateNotice(NjUserActivateNotice notice) throws Exception{
    	
    	NjUserActivateNoticeMapper mapper = dao.getMapper(NjUserActivateNoticeMapper.class);
    	mapper.insert(notice);
    }
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
	public void bathInsertContract(List<ArrayList<String>> str) throws Exception {
		int updateCount = 0;
		int insertCount = 0;
		for (int i = 0; i < str.size(); i++) {
    		List<String> str2 = str.get(i);
    		String orderNo = str2.get(0);
    		String attachId = str2.get(1);
    		NjLoanOrder loanOrder = getOrderByOrderNo(orderNo);
    		if(loanOrder != null) {
				NjOrderContractMapper contractMapper = dao.getMapper(NjOrderContractMapper.class);
				NjOrderContractExample example = new NjOrderContractExample();
				example.createCriteria().andOrderNoEqualTo(orderNo);
				List<NjOrderContract> contracts = contractMapper.selectByExample(example);
				if(contracts!=null && contracts.size()>0) {
					NjOrderContract contract = contracts.get(0);
					contract.setUrl(attachId);
					contractMapper.updateByPrimaryKeySelective(contract);
					updateCount++;
				}else {
					NjOrderContract record = new NjOrderContract();
					record.setId(UuidUtil.get32UUID());
					record.setContractName("居间合同");
					record.setContractTemplateId("0");
					record.setCreateBy("SYSTEM");
					record.setCreateDate(new Date());
					record.setOrderNo(orderNo);
					record.setUrl(attachId);
					contractMapper.insertSelective(record);
					insertCount ++;
				}
    		}
    		if(i == 40000) {
    			logger.info("执行到orderNo："+orderNo);
    			break ;
    		}
		}
		logger.info("同步成功，更新:"+updateCount+";新增："+insertCount);
	}

	public Map<String,Object> getInfoByOrderNo(String orderNo) {
		return orderService.getInfoByOrderNo(orderNo);
	}
}
