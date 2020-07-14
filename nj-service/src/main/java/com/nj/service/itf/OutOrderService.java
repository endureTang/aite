package com.nj.service.itf;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nj.bean.OutBasicInfoBean;
import com.nj.bean.OutCarInfo;
import com.nj.bean.OutCertInfo;
import com.nj.bean.OutHouseInfo;
import com.nj.bean.OutMerchantInfo;
import com.nj.bean.OutOrderBean;
import com.nj.bean.OutRelativeBean;
import com.nj.bean.OutSupplyBean;
import com.nj.bean.OutUntiFraudInfo;
import com.nj.bean.OutWorkInfoBean;
import com.nj.core.base.common.Constants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.exception.NotNullException;
import com.nj.core.base.exception.ParamsException;
import com.nj.core.base.util.DateTimeHelper;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjChannelDevAccountMapper;
import com.nj.dao.NjChannelMapper;
import com.nj.dao.NjChannelRequsetMapper;
import com.nj.dao.NjDeductionNoticeMapper;
import com.nj.dao.NjDeductionRequestMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjOrderAttachmentMapper;
import com.nj.dao.NjOrderBlackMapper;
import com.nj.dao.NjOrderCallbackLogMapper;
import com.nj.dao.NjOrderCertMapper;
import com.nj.dao.NjOrderChannelMapper;
import com.nj.dao.NjOrderFlowsMapper;
import com.nj.dao.NjOrderHouseMapper;
import com.nj.dao.NjOrderHuotiMapper;
import com.nj.dao.NjOrderHuotiScoreMapper;
import com.nj.dao.NjOrderMerchantMapper;
import com.nj.dao.NjOrderRelativeMapper;
import com.nj.dao.NjOrderUpdateLogMapper;
import com.nj.dao.NjOrderUserCarMapper;
import com.nj.dao.NjOrderUserinfoMapper;
import com.nj.dao.NjOrderWorkMapper;
import com.nj.dao.NjProductChannelMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.NjProductTransactionMapper;
import com.nj.dao.NjPuhuiApplyMapper;
import com.nj.dao.NjUserActivateNoticeMapper;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.dao.NjUserBasicInfoMapper;
import com.nj.dao.NjUserBlackMapper;
import com.nj.dao.NjUserCertMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.UserZhimaIvsScoreMapper;
import com.nj.dao.UserZhimaScoreMapper;
import com.nj.dao.extend.NjAssetGradeMapperExtend;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjProductChannelMapperExtend;
import com.nj.dao.extend.NjProductCycleMapperExtend;
import com.nj.dao.extend.NjProductMapperExtend;
import com.nj.dao.extend.NjProductTempMapperExtend;
import com.nj.dao.extend.NjProductTransactionMapperExtend;
import com.nj.dao.extend.NjUserAttachmentMapperExtend;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjAssetGrade;
import com.nj.model.generate.NjChannel;
import com.nj.model.generate.NjChannelDevAccount;
import com.nj.model.generate.NjChannelDevAccountExample;
import com.nj.model.generate.NjChannelRequset;
import com.nj.model.generate.NjChannelRequsetExample;
import com.nj.model.generate.NjDeductionNotice;
import com.nj.model.generate.NjDeductionRequest;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjOrderAttachment;
import com.nj.model.generate.NjOrderBlack;
import com.nj.model.generate.NjOrderCallbackLog;
import com.nj.model.generate.NjOrderCallbackLogExample;
import com.nj.model.generate.NjOrderCert;
import com.nj.model.generate.NjOrderChannel;
import com.nj.model.generate.NjOrderFlows;
import com.nj.model.generate.NjOrderFlowsExample;
import com.nj.model.generate.NjOrderHouse;
import com.nj.model.generate.NjOrderHuoti;
import com.nj.model.generate.NjOrderHuotiScore;
import com.nj.model.generate.NjOrderMerchant;
import com.nj.model.generate.NjOrderMerchantExample;
import com.nj.model.generate.NjOrderRelative;
import com.nj.model.generate.NjOrderUpdateLog;
import com.nj.model.generate.NjOrderUpdateLogExample;
import com.nj.model.generate.NjOrderUserCar;
import com.nj.model.generate.NjOrderUserinfo;
import com.nj.model.generate.NjOrderWork;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import com.nj.model.generate.NjProductCycle;
import com.nj.model.generate.NjProductExample;
import com.nj.model.generate.NjProductTemp;
import com.nj.model.generate.NjProductTransaction;
import com.nj.model.generate.NjProductTransactionExample;
import com.nj.model.generate.NjPuhuiApply;
import com.nj.model.generate.NjUserActivateNotice;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserAttachmentExample;
import com.nj.model.generate.NjUserBasicInfo;
import com.nj.model.generate.NjUserBasicInfoExample;
import com.nj.model.generate.NjUserBlack;
import com.nj.model.generate.NjUserCar;
import com.nj.model.generate.NjUserCert;
import com.nj.model.generate.NjUserHouse;
import com.nj.model.generate.NjUserRelatives;
import com.nj.model.generate.NjUserWorkInfo;
import com.nj.model.generate.SysArea;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysDictExample;
import com.nj.model.generate.UserZhimaIvsScore;
import com.nj.model.generate.UserZhimaScore;
import com.nj.model.mq.OrderMq;
import com.nj.mongoModel.TdReportData;
import com.nj.service.common.SysAreaService;
import com.nj.service.remoteing.IMqNdService;
import com.nj.service.remoteing.IMqWDService;
import com.nj.service.remoteing.TdReportService;

@Transactional(readOnly = true)
@Service("outOrderService")
public class OutOrderService {

    private Logger logger = LoggerFactory.getLogger(OutOrderService.class);

    @Resource(name = "itfAppUserService")
    private AppUserService appUserService;

    @Resource(name = "itfUserAttService")
    private ItfUserAttService itfUserAttService;

    @Resource(name = "itfProductService")
    private ItfProductService itfProductService;

    @Resource(name = "itfLoanOrderService")
    private ItfLoanOrderService itfLoanOrderService;
    
    @Resource
    private IMqWDService iMqService;
    
    @Resource
	protected IMqNdService mqNdService;
    
    @Resource(name = "sysAreaService")
    private SysAreaService sysAreaService;
    
    @Resource(name = "outOrderService")
    private OutOrderService outOrderService;
    
    @Resource(name = "BaseDao")
    private BaseDao dao;
    
    @Resource
    private TdReportService tdReportService;

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjLoanOrder saveOutOrder(OutOrderBean order,String appId,NjAppUser appUser) throws Exception {

        //保存订单
        NjLoanOrder innerOrder = this.saveOrder(order,appId,appUser);

        //保存申请人基本信息
        String basicId = this.saveOutBasicInfo(innerOrder, order.getBasicInfo());
        //保存申请人联系人信息
        List<String> relsId = this.saveOutRelInfo(order.getUserId(), order.getRelativeInfo());
        //保存申请人身份证信息
        String certId = this.saveOutCertInfo(order.getUserId(), order.getCertInfo(), innerOrder.getId());
        //保存申请人车辆信息
        List<String> carId = this.saveOutCarInfo(order.getUserId(), order.getCarInfo());
        //保存申请人房产信息
        List<String> houseId = this.saveOutHouseInfo(order.getUserId(), order.getHouseInfo());
        //保存申请人工作信息
        List<String> workId = this.saveOutWorkInfo(innerOrder, order.getWorkInfo());
        // 保存商户信息
        this.saveOrderMerchant(innerOrder, order.getMerchantInfo());
        
        // 添加合同
        this.addContract(order.getContractUrl(), innerOrder.getId());

//        //保存订单
//        NjLoanOrder innerOrder = this.saveOrder(order);
        //保存申请人反欺诈信息，分为芝麻分，芝麻反欺诈和活体识别分
        //保存活体信息
        this.bindOutHuoti(innerOrder, order.getUntiFraudInfo());

        //保存芝麻分信息,
        this.bindOutZMScore(innerOrder, order.getUntiFraudInfo());
        //保存芝麻反欺诈信息
        this.bindOutZmfqz(innerOrder, order.getUntiFraudInfo());
        //保存黑名单命中情况
        this.bindOutBlackHit(innerOrder, order.getUntiFraudInfo());
        //绑定用户基本信息
        this.bindOutBasic(innerOrder.getId(), basicId);
        //绑定联系人信息
        this.bindOutRels(innerOrder.getId(), relsId);
        //绑定身份信息
        this.bindOutCert(innerOrder.getId(), certId);
        //绑定车辆信息
        this.bindOutCar(innerOrder.getId(), carId);
        //绑定房产信息
        this.bindOutHouse(innerOrder.getId(), houseId);
        this.bindOutWork(innerOrder.getId(), workId);

        try {
            NjProductTempMapperExtend njProductTempMapperExtend = dao.getMapper(NjProductTempMapperExtend.class);
            NjProductTemp njProductTemp = njProductTempMapperExtend.selectByProductId(innerOrder.getProductId());
            if (null != njProductTemp) {
                OrderMq orderMq = new OrderMq();
                orderMq.setOrderId(innerOrder.getId());
                orderMq.setProcessId(1);
                orderMq.setTemplateId(njProductTemp.getProcessTemplateId());
                
				if(innerOrder.getCompanyId() != null && !innerOrder.getCompanyId().equals(Constants.DEFAULT_COMPANY_ID)) {//如果是能贷
					mqNdService.sendOrderProcessMq(orderMq);
				}else {
					iMqService.sendOrderProcessMq(orderMq);
				}
            } else {
                logger.error("提交订单消息队列发送失败，orderId:" + innerOrder.getId());
            }
        } catch (Exception e) {
            logger.error("提交订单消息队列发送失败，orderId:" + innerOrder.getId(), e);
        }
        return innerOrder;
    }
    
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void saveOrderMerchant(NjLoanOrder order,OutMerchantInfo outMerchantInfo)throws Exception{
    	
    	NjOrderMerchant merchant = new NjOrderMerchant();
    	merchant.setId(UuidUtil.get32UUID());
    	if (!StringUtils.isEmpty(outMerchantInfo.getConsociationDate())){    		
    		Date consociationDate =DateTimeHelper.parseToDate(outMerchantInfo.getConsociationDate(),DateTimeHelper.FMT_yyyyMMddHHmmss);
        	merchant.setConsociationDate(consociationDate);
    	}
    	merchant.setMerchantAddress(outMerchantInfo.getMerchantAddress());
    	merchant.setMerchantCity(outMerchantInfo.getMerchantCity());
    	merchant.setMerchantCounty(outMerchantInfo.getMerchantCounty());
    	merchant.setMerchantName(outMerchantInfo.getMerchantName());
    	merchant.setMerchantNo(outMerchantInfo.getMerchantNo());
    	merchant.setMerchantProvince(outMerchantInfo.getMerchantProvince());
    	merchant.setOrderId(order.getId());
    	merchant.setTransactionNo(outMerchantInfo.getTransactionNo());
    	
    	NjOrderMerchantMapper mapper  =  dao.getMapper(NjOrderMerchantMapper.class);
    	mapper.insert(merchant);
 
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void updateOutSupply(OutSupplyBean supply, NjLoanOrder order) throws Exception {
        //更新订单信息
        NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);
        order.setRemarks(supply.getMakeLoansDate());
        orderMapper.updateByPrimaryKeySelective(order);
        //更新用户基础信息
        NjUserBasicInfoMapper userMapper = dao.getMapper(NjUserBasicInfoMapper.class);
        NjUserBasicInfoExample example = new NjUserBasicInfoExample();
        example.createCriteria().andUserIdEqualTo(order.getUserId());
        NjUserBasicInfo userBasicInfo = userMapper.selectByExample(example).get(0);
        userBasicInfo.setBankAccount(supply.getBankAccount());
        userMapper.updateByPrimaryKeySelective(userBasicInfo);
        addContract(supply.getContractUrl(), order.getOrderNo());

    }
    
    /**
     * 增补资料保存
     * @param orderId
     * @param transactionNo
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void saveMerchantInfo (String orderId,String transactionNo) throws Exception {
  
    	NjOrderMerchantMapper mapper = dao.getMapper(NjOrderMerchantMapper.class);
    	NjOrderMerchantExample example = new NjOrderMerchantExample();
    	example.createCriteria().andOrderIdEqualTo(orderId);
    	
    	List<NjOrderMerchant> listOrderMerchant = mapper.selectByExample(example);
    	if (listOrderMerchant.size()>0) {
    		NjOrderMerchant merchant = listOrderMerchant.get(0);
    		merchant.setTransactionNo(transactionNo);
    		mapper.updateByPrimaryKey(merchant);
   
    	} else {
    		NjOrderMerchant merchant = new NjOrderMerchant();
    		merchant.setId(UuidUtil.get32UUID());
    		merchant.setOrderId(orderId);
    		merchant.setTransactionNo(transactionNo);
    		mapper.insert(merchant);
    	}
    }

    // 添加合同信息
    private void addContract(String contractUrl, String orderId) throws Exception {
        if (!StringUtils.isEmpty(contractUrl)) {
            NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
            NjUserAttachmentMapperExtend attExtendMapper = dao.getMapper(NjUserAttachmentMapperExtend.class);
            NjUserAttachment orderAttach = attExtendMapper.getAttachByOrderId(Constants.FILE_TYPE.ContractFile + "", orderId);
            NjOrderAttachmentMapper orderAttachmentMapper = dao.getMapper(NjOrderAttachmentMapper.class);
            if (null == orderAttach) {
                NjUserAttachment att = new NjUserAttachment();
                att.setId(UuidUtil.get32UUID());
                att.setFileTag("others");
                att.setBusinessType(Constants.FILE_TYPE.ContractFile);
                String[] fileNames = contractUrl.split("\\.");
                att.setFileType(fileNames[fileNames.length - 1]);
                att.setFilePath(contractUrl);
                attMapper.insert(att);
                //  保存订单附件关系
                NjOrderAttachment njOrderAttachment = new NjOrderAttachment();
                njOrderAttachment.setAttachId(att.getId());
                njOrderAttachment.setOrderId(orderId);
                njOrderAttachment.setId(UuidUtil.get32UUID());
                orderAttachmentMapper.insert(njOrderAttachment);
            } else {
                // 更新合同地址
                orderAttach.setFilePath(contractUrl);
                NjUserAttachmentExample userAttachmentExample = new NjUserAttachmentExample();
                userAttachmentExample.createCriteria().andIdEqualTo(orderAttach.getId());
                attMapper.updateByExample(orderAttach, userAttachmentExample);
            }
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutBasic(String orderId, String basicId) throws Exception {
        if (StringUtils.isEmpty(basicId))
            return;
        NjOrderUserinfoMapper mapper = dao.getMapper(NjOrderUserinfoMapper.class);
        NjOrderUserinfo info = new NjOrderUserinfo();
        info.setId(UuidUtil.get32UUID());
        info.setBasicInfoId(basicId);
        info.setOrderId(orderId);
        mapper.insert(info);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutCert(String orderId, String certId) throws Exception {
        if (StringUtils.isEmpty(certId))
            return;
        NjOrderCertMapper mapper = dao.getMapper(NjOrderCertMapper.class);
        NjOrderCert info = new NjOrderCert();
        info.setId(UuidUtil.get32UUID());
        info.setCertId(certId);
        info.setOrderId(orderId);
        mapper.insert(info);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutHouse(String orderId, List<String> houses) throws Exception {
        if (houses == null || houses.isEmpty())
            return;
        NjOrderHouseMapper mapper = dao.getMapper(NjOrderHouseMapper.class);
        for (String house : houses) {
            NjOrderHouse info = new NjOrderHouse();
            info.setId(UuidUtil.get32UUID());
            info.setHouseId(house);
            info.setOrderId(orderId);
            mapper.insert(info);
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutWork(String orderId, List<String> works) throws Exception {
        if (works == null || works.isEmpty())
            return;
        NjOrderWorkMapper mapper = dao.getMapper(NjOrderWorkMapper.class);
        for (String work : works) {
            NjOrderWork info = new NjOrderWork();
            info.setId(UuidUtil.get32UUID());
            info.setWorkId(work);
            info.setOrderId(orderId);
            mapper.insert(info);
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutCar(String orderId, List<String> cars) throws Exception {
        if (cars == null || cars.isEmpty())
            return;
        NjOrderUserCarMapper mapper = dao.getMapper(NjOrderUserCarMapper.class);
        for (String car : cars) {
            NjOrderUserCar info = new NjOrderUserCar();
            info.setId(UuidUtil.get32UUID());
            info.setUserCarId(car);
            info.setOrderId(orderId);
            mapper.insert(info);
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutRels(String orderId, List<String> rels) throws Exception {
        if (rels == null || rels.isEmpty())
            return;
        NjOrderRelativeMapper mapper = dao.getMapper(NjOrderRelativeMapper.class);
        for (String rel : rels) {
            NjOrderRelative info = new NjOrderRelative();
            info.setId(UuidUtil.get32UUID());
            info.setRelativeId(rel);
            info.setOrderId(orderId);
            mapper.insert(info);
        }
    }

    /**
     * 保存基本信息
     * @param order
     * @param basicBean
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String saveOutBasicInfo(NjLoanOrder order, OutBasicInfoBean basicBean) throws Exception {
        NjUserBasicInfo basic = new NjUserBasicInfo();
        basic.setId(UuidUtil.get32UUID());
        basic.setUserId(order.getUserId());
        basic.setAddress(basicBean.getAddress());
        basic.setMarrStatus(basicBean.getMarriage());
        basic.setMaxEducation(basicBean.getEducation());
        basic.setEstateType(basicBean.getHouse());
        basic.setVersion(-99);
        basic.setCreateDate(new Date());
        basic.setHouseholdRegister(basicBean.getHouseholdRegister());
        basic.setWeixinNo(basicBean.getWeixinNo());
        String ownIndustry = "13"; 
        if (!StringUtils.isEmpty(basicBean.getOwnIndustry())) {
        	ownIndustry =  basicBean.getOwnIndustry();
        }
        basic.setOwnIndustry(ownIndustry);
        if (basicBean.getBindBankCark() == null) {
            basic.setBindBankCark(false);
        } else {
            basic.setBindBankCark(true);
        }
//        if (basicBean.getBindBankCark() == null) {
//        	basic.setBindBankCark((short) 0);
//        } else {
//        	basic.setBindBankCark(basicBean.getBindBankCark());
//        }
        basic.setBankAccount(basicBean.getBankAccount());
        // 省
        if (!StringUtils.isEmpty(basicBean.getProvince())) {
        	SysArea sysArea  =this.sysAreaService.getSysAreaByName(basicBean.getProvince());
        	basic.setProvince(sysArea.getId());
        }
        // 市
        if (!StringUtils.isEmpty(basicBean.getCity())) {
        	SysArea sysArea  =this.sysAreaService.getSysAreaByName(basicBean.getCity());
        	basic.setCity(sysArea.getId());
        }
        // 县
        if (!StringUtils.isEmpty(basicBean.getCounty())) {
        	SysArea sysArea  =this.sysAreaService.getSysAreaByName(basicBean.getCounty());
        	basic.setCounty(sysArea.getId());
        }
        
        logger.info("订单基本信息"+ JSON.toJSONString(basic));
        appUserService.addOutBasicInfo(basic);
        //绑定基本信息和附件关系
        itfUserAttService.bindBasicInfoUrls(order.getId(), basicBean.getAttachments());
        return basic.getId();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public List<String> saveOutRelInfo(String userId, List<OutRelativeBean> rels) throws Exception {
        if (rels == null || rels.isEmpty())
            return null;
        List<String> relIds = new ArrayList<String>();
        for (OutRelativeBean rel : rels) {
            NjUserRelatives i = new NjUserRelatives();
            i.setId(UuidUtil.get32UUID());
            i.setUserId(userId);
            i.setDelFlag((byte) 0x0);
            i.setVersion(-99);
            i.setRelativeName(rel.getName());
            i.setRelativeMobile(rel.getPhone());
            if (rel.getRelative() != null)
                i.setRelativeType(rel.getRelative().toString());
            i.setCreateDate(new Date());
            appUserService.addOutRelInfo(i);
            relIds.add(i.getId());
        }
        return relIds;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String saveOutCertInfo(String userId, OutCertInfo outCert, String orderId) throws Exception {
        if (outCert == null)
            return null;
        NjUserCert cert = new NjUserCert();
        cert.setId(UuidUtil.get32UUID());
        cert.setUserId(userId);
        cert.setVersion(-99);
        cert.setDelFlag(false);
        cert.setCreateDate(new Date());

        NjOrderAttachmentMapper njOrderAttachmentMapper = dao.getMapper(NjOrderAttachmentMapper.class);
        
        // 身份证正面
        String front = itfUserAttService.saveOutCertFrontImg(userId, outCert.getCertFrontImg());
        NjOrderAttachment frontAttachment = new NjOrderAttachment();
        frontAttachment.setAttachId(front);
        frontAttachment.setOrderId(orderId);
        frontAttachment.setId(UuidUtil.get32UUID());
        njOrderAttachmentMapper.insert(frontAttachment);

        // 身份证背面
        String back = itfUserAttService.saveOutCertBackImg(userId, outCert.getCertBackImg());
        NjOrderAttachment backAttachment = new NjOrderAttachment();
        backAttachment.setAttachId(back);
        backAttachment.setOrderId(orderId);
        backAttachment.setId(UuidUtil.get32UUID());
        njOrderAttachmentMapper.insert(backAttachment);
        
        // 手持身份证
        String hand = "";
        if (!StringUtils.isEmpty(outCert.getVerifyImg())) {
        	
            hand = itfUserAttService.saveOutCertHandImg(userId, outCert.getVerifyImg());
            NjOrderAttachment handAttachment = new NjOrderAttachment();
            handAttachment.setAttachId(hand);
            handAttachment.setOrderId(orderId);
            handAttachment.setId(UuidUtil.get32UUID());
            njOrderAttachmentMapper.insert(handAttachment);
        }
        
        
        // 活体识别照片
        if (!StringUtils.isEmpty(outCert.getLivingImg())) {
        	
        	String living = itfUserAttService.saveOutLivingImg(userId, outCert.getLivingImg());
            NjOrderAttachment livingAttachment = new NjOrderAttachment();
            livingAttachment.setAttachId(living);
            livingAttachment.setOrderId(orderId);
            livingAttachment.setId(UuidUtil.get32UUID());
            njOrderAttachmentMapper.insert(livingAttachment);
        }        

        cert.setBackId(back);
        cert.setFrontId(front);
        cert.setHandCertId(hand);
        NjUserCertMapper mapper = dao.getMapper(NjUserCertMapper.class);
        mapper.insert(cert);
        return cert.getId();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public List<String> saveOutCarInfo(String userId, List<OutCarInfo> cars) throws Exception {
        if (cars == null || cars.isEmpty()) {
            return null;
        }
        List<String> carId = new ArrayList<String>();
        for (OutCarInfo outCar : cars) {
            NjUserCar car = new NjUserCar();
            car.setId(UuidUtil.get32UUID());
            car.setUserId(userId);
            car.setVersion(-99);
            car.setCreateDate(new Date());
            car.setBuyPrice(outCar.getBackImg());
            car.setCarAge(outCar.getCarAge());
            car.setCarNumber(outCar.getCarNumber());
            if (outCar.getCarType() != null)
                car.setCarType(outCar.getCarType().toString());
            car.setRemark(outCar.getRemark());
            car.setBuyDate(outCar.getBuyDate());
            car.setXjcd(outCar.getXjcd());
            car.setShdq(outCar.getShdq());
            car.setDelFlag(false);
            car.setInsuranceNo(outCar.getInsuranceNo());
            car.setVin(outCar.getVin());
            appUserService.addOutCarInfo(car);
            //保存驾驶证前照片
            itfUserAttService.bindOutCarInfoJSZFrontImg(car.getId(), outCar.getFrontImg());
            //保存驾驶证背面照片
            itfUserAttService.bindOutCarInfoJSZFBackImg(car.getId(), outCar.getBackImg());
            //保存行驶证照片
            itfUserAttService.bindOutCarInfoXSZImg(car.getId(), outCar.getDriveLicense());
            carId.add(car.getId());

        }
        return carId;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public List<String> saveOutHouseInfo(String userId, List<OutHouseInfo> houses) throws Exception {
        if (houses == null || houses.isEmpty())
            return null;
        List<String> houseId = new ArrayList<String>();
        for (OutHouseInfo house : houses) {
            NjUserHouse i = new NjUserHouse();
            i.setId(UuidUtil.get32UUID());
            i.setDelFlag(false);
            i.setCreateDate(new Date());
            if (house.getPrice() != null)
                i.setBuyPrice(new BigDecimal(house.getPrice()));
            i.setName(house.getName());
            i.setAddress(house.getAddress());
            appUserService.addOutHouseInfo(i);
            //保存房产证照片信息
            itfUserAttService.bindOutHouseFCZFrontImg(i.getId(), house.getFrontImg());
            //保存房产证后面照片
            itfUserAttService.bindOutHouseFCZBackImg(i.getId(), house.getBackImg());
            //保存房产证图片信息
            itfUserAttService.bindOutHouseImg(i.getId(), house.getImage());
            houseId.add(i.getId());
        }
        return houseId;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public List<String> saveOutWorkInfo(NjLoanOrder order, List<OutWorkInfoBean> works) throws Exception {
        if (works == null || works.isEmpty())
            return null;
        List<String> workId = new ArrayList<String>();
        for (OutWorkInfoBean work : works) {
            NjUserWorkInfo i = new NjUserWorkInfo();
            i.setId(UuidUtil.get32UUID());
            i.setCreateDate(new Date());
            i.setVersion(-99);
            i.setOrgName(work.getCompanyName());
            i.setOrgContact(work.getCompanyTel());
            i.setOrgAddress(work.getCompanyAddr());
            i.setPosition(work.getJob());
            i.setUserId(order.getUserId());
            i.setRecentWorkYears(work.getRecentWorkYears());
            if (work.getAnnualIncome() != null)
                i.setAnnualIncome(work.getAnnualIncome().toString());
            if (work.getMonthIncome() != null) {
            	String incomeStr = work.getMonthIncome();
            	int  index = incomeStr.indexOf("-");
            	double income =0;
            	if(index>0){
            		income = Double.parseDouble(incomeStr.substring(index+1).trim());
            	} else {
            		income = 5001;
            	} 
            	i.setMonthIncome(transMonthIncome(income));
            } else {
            	i.setMonthIncome("1");
            }               
            appUserService.addOutWorkInfo(i);
            //保存图片信息
            itfUserAttService.bindOutWorkUrls(order.getId(), work.getAttachments());
            workId.add(i.getId());
        }
        return workId;
    }
    
    /**
     * 将月收入改成选项
     * @param income
     * @return
     */
    public static String  transMonthIncome(double income){
    	
    	if (income<=3000) {
    		
    		return "1";
    	} else if (income >= 3001 && income <=5000){
    		
    		return "2";
    	} else if (income >= 5001 && income <=7000){
    		
    		return "3";
    	} else if (income >= 7001 && income <=10000){
    		
    		return "4";
    	} else if (income >= 10001 && income <=15000){
    		
    		return "5";
    	} else if (income >15000){
    		
    		return "6";
    	} else {
    		return "1";
    	}
    	
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutZMScore(NjLoanOrder order, OutUntiFraudInfo untiFraud) throws Exception {
        if ((untiFraud == null) || (untiFraud.getZmScore() == null))
            return;
        UserZhimaScore score = new UserZhimaScore();
        UserZhimaScoreMapper scoreMapper = dao.getMapper(UserZhimaScoreMapper.class);
        score.setId(UuidUtil.get32UUID());
        score.setCreateDate(new Date());
        score.setVersion(-99);
        score.setUserId(order.getUserId());
        score.setScore(untiFraud.getZmScore().doubleValue());
        score.setOrderId(order.getId());
        scoreMapper.insert(score);

    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutZmfqz(NjLoanOrder order, OutUntiFraudInfo untiFraud) throws Exception {
        if ((untiFraud == null)) {
            return;
        }
        UserZhimaIvsScore ivs = new UserZhimaIvsScore();
        UserZhimaIvsScoreMapper mapper = dao.getMapper(UserZhimaIvsScoreMapper.class);
        ivs.setId(UuidUtil.get32UUID());
        ivs.setIvsDetail(untiFraud.getZmfqzDetail());
        ivs.setIvsScore(untiFraud.getZmfqzScore().doubleValue());
        ivs.setOrderId(order.getId());
        ivs.setInputMd5("");
        ivs.setCreateDate(new Date());
        mapper.insert(ivs);
    }


    public void bindOutBlackHit(NjLoanOrder order, OutUntiFraudInfo untiFraud) throws Exception {
        if (untiFraud == null || untiFraud.getBlackHit() == null || untiFraud.getBlackHit() < 0) {
            return;
        }
        NjUserBlack ub = new NjUserBlack();
        NjUserBlackMapper ubMapper = dao.getMapper(NjUserBlackMapper.class);
        NjOrderBlackMapper obMapper = dao.getMapper(NjOrderBlackMapper.class);
        ub.setId(UuidUtil.get32UUID());
        ub.setUserId(order.getUserId());
        ub.setBlackHit(untiFraud.getBlackHit());
        ub.setDetail(untiFraud.getBlackHitDetail());
        ub.setDelFlag(false);
        ub.setCreateDate(new Date());
        ub.setVersion(-99);
        ubMapper.insert(ub);
        NjOrderBlack ob = new NjOrderBlack();
        ob.setId(UuidUtil.get32UUID());
        ob.setOrderId(order.getId());
        ob.setBlackHitId(ub.getId());
        obMapper.insert(ob);
    }

    /**
     * @param order
     * @param untiFraud
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void bindOutHuoti(NjLoanOrder order, OutUntiFraudInfo untiFraud) throws Exception {
        if (untiFraud == null) {
            return;
        }
        NjOrderHuotiScoreMapper huotiScoreMapper = dao.getMapper(NjOrderHuotiScoreMapper.class);
        NjOrderHuotiMapper huotiMapper = dao.getMapper(NjOrderHuotiMapper.class);
        NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
        NjOrderHuotiScore huotiScore = new NjOrderHuotiScore();
        huotiScore.setId(UuidUtil.get32UUID());
        huotiScore.setOrderId(order.getId());
        huotiScore.setCreateDate(new Date());
        huotiScore.setDelFlag(false);
        huotiScore.setScore(untiFraud.getHoutiScore());
        huotiScore.setSource(untiFraud.getHuotiFrom());
        huotiScore.setDetail(untiFraud.getHuotiDetail());
        huotiScore.setVersion(-99);
        huotiScoreMapper.insert(huotiScore);
        if (untiFraud.getHuotiImg() != null && !(untiFraud.getHuotiImg().isEmpty())) {
            for (String url : untiFraud.getHuotiImg()) {
                NjUserAttachment a = new NjUserAttachment();
                a.setId(UuidUtil.get32UUID());
                a.setDelFlag(false);
                a.setCreateDate(new Date());
                a.setSource(url);
                a.setBusinessType(Constants.FILE_TYPE.HUOTI_OTHER);
                attMapper.insert(a);
                //创建订单活体图片绑定接口
                NjOrderHuoti huoti = new NjOrderHuoti();
                huoti.setOrderId(order.getId());
                huoti.setAttachmentId(a.getId());
                huoti.setDelFlag(false);
                huoti.setCreateDate(new Date());
                huoti.setVersion(-99);
                huoti.setId(UuidUtil.get32UUID());
                huotiMapper.insert(huoti);
            }
        }

    }

    /**
     * 第三方资产进件保存订单
     * @param outOrder		
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjLoanOrder saveOrder(OutOrderBean outOrder, String appId,NjAppUser appUser) throws Exception {
    	
    	// 非空验证
        if (outOrder == null) {
            throw new Exception("外部订单为空");
        }
        
        // 查询产品
        NjProduct prod = itfProductService.getProductByCode(outOrder.getProductCode()).get(0);
        
        // 构造订单
        NjLoanOrder order = new NjLoanOrder();
        order.setId(UuidUtil.get32UUID());
        order.setDelFlag(false);
        order.setCreateDate(new Date());
        order.setUpdateDate(new Date());
        order.setUserId(outOrder.getUserId());
        order.setProductId(prod.getId());// 产品ID
        order.setAmount(outOrder.getApplySum());// 贷款金额
        order.setPeriod(outOrder.getApplyPeriod());// 贷款期数
        order.setUsageDesc(outOrder.getPurpose());// 借款用途
        order.setSourceOrderNo(outOrder.getOrderCode());// 第三方订单ID
        order.setCallbackUrl(outOrder.getCallbackUrl());// 回调地址
        order.setDiductionCallbackUrl(outOrder.getDiductionCallbackUrl());// 扣款回调地址
        order.setOrderNo(itfLoanOrderService.createOrderCode(order));// 订单编号
        order.setStatus(Constants.ORDERKEYSTATUS.ORDER_NEW);// 订单状态 初始化为0
        order.setFundsUse(outOrder.getRepaySource());// 还款来源
        order.setProjectContent(outOrder.getProjectDetail());//项目情况
        order.setRemarks(outOrder.getMakeLoansDate());// 备注
        order.setProductName(prod.getProductName());// 产品名称
        order.setProjectAmount(outOrder.getProjectAmount());// 项目总金额、产品金额，因为有首付 
        order.setProjectName(outOrder.getProjectName());// 项目名称，如医美分期细项
        order.setFirstAmount(outOrder.getFirstAmount());// 首付款
        order.setEnterpriseCase(outOrder.getPurpose());// 申请用途
        order.setAuditAmount(outOrder.getApplySum()); // 申请金额
        order.setAuditPeriod(outOrder.getApplyPeriod());// 申请期数
        order.setRelendMethod("1");//确认放款方式，1 线上放款， 0 线下放款'
        
        // 资产等级
        SysDictMapper sysDictMapper = dao.getMapper(SysDictMapper.class);
        SysDictExample sysDictExample = new SysDictExample();
        sysDictExample.createCriteria().andTypeEqualTo("CPDKKXQX").andLabelTextEqualTo(outOrder.getApplyPeriod() + "期");
        List<SysDict> sysDicts = sysDictMapper.selectByExample(sysDictExample);
        if (null != sysDicts && !sysDicts.isEmpty()) {
            NjProductCycleMapperExtend cycleMapper = dao.getMapper(NjProductCycleMapperExtend.class);
            NjProductCycle productCycle = cycleMapper.getBySysCycleId(sysDicts.get(0).getId(), prod.getId());
            if (null != productCycle) {
                //设置订单资产登记
                order.setAssetGrade(productCycle.getGrade());
            } else {
                NjAssetGradeMapperExtend grade = dao.getMapper(NjAssetGradeMapperExtend.class);
                NjAssetGrade assetGrade = grade.getDefaultGrade();
                if (null != assetGrade) {
                    order.setAssetGrade(assetGrade.getGrade());
                }
            }
        }
        
        // 查询该产品下配置的所有渠道
       	NjProductChannelMapper  njProductChannelMapper = dao.getMapper(NjProductChannelMapper.class);
       	NjProductChannelExample njProductChannelExample = new NjProductChannelExample();
       	njProductChannelExample.createCriteria().andProductIdEqualTo(prod.getId()).andDelFlagEqualTo(false);
       	List<NjProductChannel> listProductChannel  = njProductChannelMapper.selectByExample(njProductChannelExample);
        
        // 通过APPID查询当前进件渠道
    	NjChannelDevAccountMapper devMapper = dao.getMapper(NjChannelDevAccountMapper.class);
		NjChannelDevAccountExample exp = new NjChannelDevAccountExample();
		exp.createCriteria().andAppIdEqualTo(appId);
		List<NjChannelDevAccount> list =  devMapper.selectByExample(exp);
		String channleId  = list.get(0).getChannelId();// 进件渠道ID
        
        //渠道id为空，为自主进件，默认为0
        //NjProductChannelMapperExtend channelMapperExtend = dao.getMapper(NjProductChannelMapperExtend.class);        
        //List<String> channelIds = channelMapperExtend.getChannelByProductCode(outOrder.getProductCode());
        String productChannleId = "";
		for(NjProductChannel productChannel:listProductChannel){
			if (channleId.equals(productChannel.getNjChannelId())) {
				productChannleId= productChannel.getId();
			}
		}
		
		if (StringUtils.isEmpty(productChannleId)) {
            logger.error("没有检索到相关渠道编号，产品code：" + outOrder.getProductCode());
        } else {
            order.setChannelId(productChannleId);//关联渠道id
            // 添加企业id
            NjChannelMapper njChannelMapper = dao.getMapper(NjChannelMapper.class);
            NjChannel njChannel = njChannelMapper.selectByPrimaryKey(channleId);
            order.setCompanyId(njChannel.getCompanyId());
        }
        NjProductTransactionMapperExtend njProductTransactionMapperExtend = dao.getMapper(NjProductTransactionMapperExtend.class);
        Map<String, Object> njProductTransaction = njProductTransactionMapperExtend.selectByProduct(outOrder.getProductCode());
        order.setAuditRating(((BigDecimal) njProductTransaction.get("fixedInterestRate")).toString()); // 借款人利率 、产品利率
        order.setAuditServiceRating(((BigDecimal) njProductTransaction.get("serviceCharge")).toString());// 平台服务费率(该字段目前没有只使用，暂时也填台趸收服务费率)
        order.setChargeFeeRate(((BigDecimal) njProductTransaction.get("serviceCharge")).toString());// 平台趸收服务费率
        order.setRepayWay((String) njProductTransaction.get("repayWay"));//放款方式
        order.setFixRate(((BigDecimal)njProductTransaction.get("serviceRateTerm")).toString()); // 投资人利率
        int feeFloat = Integer.parseInt( njProductTransaction.get("feeFloat").toString());


        //获取渠道id
//        String productChannelId = getOutProductChannelId(outOrder.getProductCode());
//        order.setChannelId(productChannelId);
        if (outOrder.getLendType() == 1) {
            order.setLendMethod("LEND_ONL");
        } else {
            order.setLendMethod("LEND_OFF");
        }        
               
        // 深证普惠快捷临时处理
        if (outOrder.getProductCode().equals("295")) {            
           
            order.setFundsUse("借款人工资、经营、劳务报酬及投资等收入");// 还款来源
            order.setUsageDesc("购买3C商品"); // 借款用途
            order.setGeAgcyAdvice("第三方公司承担连带责任担保进行代偿");           
            double periodRate = getPeriodRate(outOrder.getApplyPeriod());//投资人年化
            order.setFixRate(String.format("%.6f",periodRate*100));
            order.setAuditRating("10");//借款利率
            // 平台期服务费利率
            String serviceRate = getPeriodServiceRate(periodRate,Double.parseDouble(outOrder.getApplyPeriod().toString()),outOrder.getApplySum().doubleValue());
            order.setFeeRate(serviceRate);
            // 平台期服务费
            String serviceAmount = getPeriodServiceAmount(periodRate,Double.parseDouble(outOrder.getApplyPeriod().toString()),outOrder.getApplySum().doubleValue());
          
            order.setFeeValue( serviceAmount);
            order.setChargeFeeRate("0");
            order.setContractRate(order.getFeeRate());
            logger.info("订单信息:"+JSON.toJSONString(order));
            logger.info("普惠金融计算期利率,贷款金额："+outOrder.getApplySum()+",期数："+outOrder.getApplyPeriod()+",期利率："+periodRate+",服务费利率:"+serviceRate+",订单ID："+order.getId());
            
        }
        
        // 综合利率
        if (feeFloat == 1) {         	
        	
        	if (StringUtils.isEmpty(outOrder.getTotalRating())) {
        		order.setTotalRating(order.getAuditRating());
        	}else {
        		order.setTotalRating(outOrder.getTotalRating());
        	}			
        	
        } else {        	
           // 如果产品没有配置利率是否浮动，则综合利率就是审核利率
           order.setTotalRating(order.getAuditRating());
        }
        
		// 渠道费率设置
		List<NjOrderChannel> listOrderChannel = new ArrayList<NjOrderChannel>();
		NjOrderChannelMapper orderChannelMapper = dao.getMapper(NjOrderChannelMapper.class);
		for (NjProductChannel productChannel : listProductChannel) {				
			
			// 排除其它进件渠道
			if (productChannel.getType() == 1) {
				if (!channleId.equals(productChannel.getNjChannelId())) {
					continue;
				}	
			}
			
			NjOrderChannel orderChannel = new NjOrderChannel();
			orderChannel.setId(UuidUtil.get32UUID());
			orderChannel.setBondType(productChannel.getBondType() != null ? productChannel.getBondType() : 1);
			if (feeFloat == 1 && orderChannel.getBondType().intValue() == 2 && productChannel.getType() ==1) {
				// 当设置产品利率为浮动时，综合利率 - 产品利率 就是进件渠道的期收利率
				double totalRating = Double.parseDouble(order.getTotalRating());
				double auditRating = Double.parseDouble(order.getAuditRating());
				orderChannel.setBondValue((totalRating-auditRating)+"");
			}else {
				orderChannel.setBondValue(!StringUtils.isEmpty(productChannel.getBondValue()) ? productChannel.getBondValue() : "0");
			}			
			orderChannel.setChannelId(productChannel.getNjChannelId());
			orderChannel.setChannelProductId(productChannel.getId());
			orderChannel.setChannelType(productChannel.getType());		
			orderChannel.setOperateFeeType(productChannel.getOperateFeeType()!=null ? productChannel.getOperateFeeType():1);
			orderChannel.setOperateFee(productChannel.getOperateFee()!= null ? productChannel.getOperateFee().toString(): "0");		
			orderChannel.setOrderId(order.getId());			
			orderChannel.setIsRateContract(productChannel.getIsRateContract());
			
			orderChannelMapper.insert(orderChannel);
			listOrderChannel.add(orderChannel);
		}
		
		// 当还款方式为等额本息的时候，需要进行PMT值精算
	    if (!outOrder.getProductCode().equals("295")) { //  普惠排除 
			if (prod.getRepayWay().equals("10102")) {
				
				double financeAmount = order.getAuditAmount().doubleValue();//贷款金额
				double periodRate = getPeriodRate(order.getAuditPeriod());//投资人年化
				double period = Double.parseDouble(order.getAuditPeriod().toString());// 贷款期数
				double firstRate = Double.parseDouble(order.getTotalRating())/100;			
				double secondRate = Double.parseDouble(order.getAuditRating())/100;
				
				// 进件渠道分润
				for (NjOrderChannel njOrderChannel : listOrderChannel) {
					if (njOrderChannel.getChannelType()==1) {
						// 只有配置了渠道
						if (njOrderChannel.getBondType().intValue()==2) {
							if (firstRate ==secondRate){
								secondRate = firstRate - Double.parseDouble(njOrderChannel.getBondValue())/100;
							}
							if (firstRate != secondRate) {
								// 期收费率 年化
								String jjRate = getPeriodServiceRate(firstRate, secondRate, period, financeAmount);
								// 期收金额
								String jjAmount =getPeriodServiceAmount(firstRate, secondRate, period, financeAmount);
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
					if (njOrderChannel.getChannelType()!=1) {
						// 只有配置了渠道
						if (njOrderChannel.getBondType().intValue()==2) {
							if (firstRate == secondRate) {
								secondRate = firstRate - Double.parseDouble(njOrderChannel.getBondValue())/100;
							}
							if (firstRate != secondRate) {
								// 期收费率 年化
								String jjRate = getPeriodServiceRate(firstRate, secondRate, period, financeAmount);
								// 期收金额
								String jjAmount =getPeriodServiceAmount(firstRate, secondRate, period, financeAmount);
								njOrderChannel.setBondValue(jjRate);
								njOrderChannel.setBondFee(jjAmount);
						
								orderChannelMapper.updateByPrimaryKey(njOrderChannel);
								firstRate = secondRate;
							}
						}				
					}
				}
				
				// 平台分润
				String jdRate = getPeriodServiceRate(firstRate, periodRate, period, financeAmount);
				String jdAmount =getPeriodServiceAmount(firstRate, periodRate, period, financeAmount);
				
				BigDecimal contractRate = new BigDecimal(jdRate);
				
				for (NjOrderChannel njOrderChannel : listOrderChannel) {
					if (njOrderChannel.getIsRateContract()) {
						BigDecimal bondRate = new BigDecimal(njOrderChannel.getBondValue());
						contractRate = contractRate.add(bondRate);
					}
				}
				order.setContractRate(String .format("%.6f",contractRate));
				order.setFixRate(String.format("%.6f",periodRate*100));//投资人收益
				order.setFeeRate(jdRate);//期收费率 年化
				order.setFeeValue(jdAmount);//期收金额
			}
	    }
        
        // 保存订单
        NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class);
        mapper.insert(order);
        
//        if (!outOrder.getProductCode().equals("295")) {
//        	NjProductMapper productMapper = dao.getMapper(NjProductMapper.class);
//            NjProduct njProduct = productMapper.selectByPrimaryKey(order.getProductId());
//            
//            //绑定订单与同盾报告
//            ResponseDto<List<TdReportData>> tdList = tdReportService.getTdScoreByUserId(order.getUserId());
//            if(tdList.getReturnCode() == 0 && tdList.getResult().size()>0) {
//            	TdReportData data = tdList.getResult().get(0);
//            	order.setTdReportId(data.getId());
//            	//校验报告时间是否已超过有效期
//            	Integer validatDays = njProduct.getTdReportValidDate();
//            	if(validatDays != null) {
//            		long day = validatDays*24*60*60*1000; // 将有效天数转换成毫秒
//                	long applyTime = data.getApply_time();//报告申请日期，单位毫秒
//                	applyTime = applyTime+day;//有效日期
//                	Date date = DateUtil.parseDate(DateUtil.formatDate(new Date()), "yyyy-MM-dd");
//                	if(date.getTime() > applyTime) {//如果当前日期已经超过有效期，则重新生成同盾报告
//            
//                		TdReportData tdReportData = new TdReportData();
//                		tdReportData.setMobile(appUser.getMobile());
//                		tdReportData.setId_number(appUser.getIdentifyId());
//                		tdReportData.setName(appUser.getTrueName());
//                		tdReportData.setUserId(appUser.getId());
//        		        ResponseDto<TdReportData> responseDto = tdReportService.generateTdReport(tdReportData);
//        		        if(responseDto.getReturnCode() == 0 && responseDto.getResult() != null) {
//        		        	order.setTdReportId(responseDto.getResult().getId());
//        		        }
//                	}
//            	}
//            	
//            }        
//        }
        
        return order;
    }
    
    /**
     * 获得投资人等额本息年华率（普惠）,由于目前公司的投资人利率都是以下设定，所以所有产品暂定以下
     * @param period		
     * @throws ParamsException 
     */
    public static  double getPeriodRate(int period) throws ParamsException{
    	
    	double rate = 0;
    	switch (period) {
		case 3:
			rate = 0.07;
			break;
		case 4: 
			rate = 0.0713;
			break;
		case 6:
			rate = 0.0738;
			break;
		case 9:
			rate = 0.0775;
			break;
		case 10:
			rate = 0.0788;
			break;
		case 12:
			rate = 0.0813;
			break;
		case 15:
			rate = 0.085;
			break;
		case 18:
			rate = 0.0888;
			break;
		default:
			throw new ParamsException("不存在该期数的产品");
		}
    	return rate;
    }
    
     
    /**
     * 平台期收服务费年化利率(普惠)
     * @param rate
     * @param term
     * @param financeAmount
     * @return
     */
    public static String getPeriodServiceRate(double rate,double term,double financeAmount){
    	
    	// 初始话年化10%时的pmt值
    	double initPmt = PMT(0.1,term,financeAmount);
    	// 根据期数算的年化率 时的pmt值
    	double periodPmt = PMT(rate,term,financeAmount);
    	// 服务费利率    	
    	double serviceAmount= Math.ceil(Double.parseDouble(String .format("%.3f",initPmt - periodPmt))*100)/100;
    	double serviceRate =serviceAmount/financeAmount;
    	//double serviceRate = (initPmt - periodPmt)/financeAmount;    	
    	return String .format("%.6f",serviceRate*100*12);	
    }
    
    /**
     * 平台期收服务费金额(普惠)
     * @param rate
     * @param term
     * @param financeAmount
     * @return
     */
    public static String getPeriodServiceAmount(double rate,double term,double financeAmount){
    	
    	// 初始话年化10%时的pmt值
    	double initPmt = PMT(0.1,term,financeAmount);
    	// 根据期数算的年化率 时的pmt值
    	double periodPmt = PMT(rate,term,financeAmount);
    	// 服务费利率
    	double serviceRate = initPmt - periodPmt;
    	
    	serviceRate =Math.ceil(Double.parseDouble(String .format("%.3f",serviceRate))*100)/100;
    	return serviceRate+"";
    }
    
    /**
     * 计算期收服务费率（年化）
     * 期收服务费率是两个值减出来的，所以第一次firstRate是产品利率，后面firstRate是递归出来的计算，
     * @param firstRate		产品利率，产品表配置的利率（年化），数据库存的是带%的，取值后需要除以100
     * @param secondRate	这个字段也是递归出来的
     * @param term			期数
     * @param financeAmount 贷款金额
     * @return 返回值为月化
     */
    public static String getPeriodServiceRate(double firstRate,double secondRate,double term,double financeAmount){
    	
    	// 初始话年化的pmt值
    	double initPmt = PMT(firstRate,term,financeAmount);
    	// 根据期数算的年化率 时的pmt值
    	double periodPmt = PMT(secondRate,term,financeAmount);
    	// 服务费利率    	
    	double serviceAmount= Math.ceil(Double.parseDouble(String .format("%.3f",initPmt - periodPmt))*100)/100;
    	double serviceRate =serviceAmount/financeAmount;
    	//double serviceRate = (initPmt - periodPmt)/financeAmount;    	
    	return String .format("%.6f",serviceRate*100*12);	
    }
    
    /**
     * 计算期收服务费
     * 期收服务费率是两个值减出来的，所以第一次firstRate是产品利率，后面firstRate是递归出来的计算，
     * @param firstRate		产品利率，产品表配置的利率（年化），数据库存的是带%的，取值后需要除以100
     * @param secondRate	这个字段也是递归出来的
     * @param term			期数
     * @param financeAmount 贷款金额
     * @return 返回值为月化
     */
    public static String getPeriodServiceAmount(double firstRate,double secondRate,double term,double financeAmount){
    	
    	// 初始话年化的pmt值
    	double initPmt = PMT(firstRate,term,financeAmount);
    	// 根据期数算的年化率 时的pmt值
    	double periodPmt = PMT(secondRate,term,financeAmount);
    	// 服务费利率
    	double serviceRate = initPmt - periodPmt;
    	
    	serviceRate =Math.ceil(Double.parseDouble(String .format("%.3f",serviceRate))*100)/100;
    	return serviceRate+"";
    }
    
    /**
    * 计算月供PMT
    * @param rate 年利率 年利率除以12就是月利率(不带百分号的),例如数据库存的10（年化），这里就需要传0.1进行计算
    * @param term 贷款期数，单位月
    * @param financeAmount  贷款金额
    * @return
    */
    public static double PMT(double rate,double term,double financeAmount){

        double v = (1+(rate/12)); 
        double t = (-(term/12)*12);  
        double result=(financeAmount*(rate/12))/(1-Math.pow(v,t));
        return result;
    }
    
    public static void main(String []args) throws Exception{
    	double rate = 0.1;
    	double term = 10;
    	double financeAmount = 2570;
    	//System.out.println(PMT(rate,term,financeAmount));
//    	System.out.println(getPeriodServiceAmount(rate,term,financeAmount).toString());
//    	System.out.println(getPeriodServiceRate(rate,term,financeAmount).toString());
    	
//    	double serviceRate = 0.00617290;
//    	System.out.println(String .format("%.6f",serviceRate)); 	
//    	System.out.println(Math.ceil(Double.parseDouble(String .format("%.3f",serviceRate))*100)/100);
//    	
//    	Byte b =new Byte("1");
//    	if (b.intValue()==1) {
//    		System.out.println("nuih");
//    	}
    	
    	
    	
    	//double a = 2.560 ;
    	//System.out.println(Math.ceil(Double.parseDouble(String .format("%.3f",a))*100)/100);
    	
    	
    	//String msg=AESUtil.EncryptTFCF("{\"token\":\"05ae5a373b94556691b8994b7a46ea0d\",\"deviceId\":\"9718C0BAFFA8016F0037442062579491\",\"userId\":\"8a7dad5e678880970167943134e51069\",\"accountType\":\"BorrowAccount\"}", "bae51da7342311e5");;
    	//System.out.println(msg);
    	
//    	List<String> a =new ArrayList<String>();
//    	a.add("http://www.baidu.com");
//    	a.add("http://www.163.com");
//    	System.out.println(JSON.toJSONString(a));
    	
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("a", "");
    	map.put("b", null);
    	
    	if (StringUtils.isNull(map.get("b").toString())){
    		System.out.println("报错");
    	}
    	
    }

    public NjLoanOrder getOutOrderByOutOrderId(String outOrderNo, String appId) throws Exception {
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        return mapper.selectByOutOrderIdAndAppId(outOrderNo, appId);

    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addOutAddtion(NjLoanOrder order, JSONArray atts) throws Exception {
        if (atts == null || atts.isEmpty())
            return;
        NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
        NjOrderAttachmentMapper njOrderAttachmentMapper = dao.getMapper(NjOrderAttachmentMapper.class);

        for (int i = 0; i < atts.size(); i++) {
            NjUserAttachment a = new NjUserAttachment();
            a.setId(UuidUtil.get32UUID());
            a.setDelFlag(false);
            a.setFileTag("others");
            a.setCreateDate(new Date());
            a.setSource(atts.getString(i));
            a.setFilePath(atts.getString(i));
            attMapper.insert(a);
            NjOrderAttachment njOrderAttachment = new NjOrderAttachment();
            njOrderAttachment.setAttachId(a.getId());
            njOrderAttachment.setOrderId(order.getId());
            njOrderAttachment.setId(UuidUtil.get32UUID());
            njOrderAttachmentMapper.insert(njOrderAttachment);
        }
    }

    public List<NjLoanOrder> getToCallbackOutOrder(List<Integer> states, String coporateId) throws Exception {
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        return mapper.getToCallbackOutOrder(states, coporateId);
    }

    public String getOrderLogByState(String orderId, Integer state) throws Exception {
        return itfLoanOrderService.getOrderLogByState(orderId, state);
    }


    public String getOrderStateText(Integer state) {
        try {
            NjOrderFlowsMapper mapper = dao.getMapper(NjOrderFlowsMapper.class);
            NjOrderFlowsExample exp = new NjOrderFlowsExample();
            exp.createCriteria().andCurrentOrderStateEqualTo(state);
            List<NjOrderFlows> flows = mapper.selectByExample(exp);
            return flows.get(0).getCurrentAppProcess();
        } catch (Exception e) {
            logger.error("获取订单状态失败:", e);
            return "";
        }
    }

    /**
     * 通过第三方订单查找订单来源渠道
     *
     * @param order
     * @return
     * @throws Exception
     */
    public Map<String, Object> getOutOrderFromChannel(NjLoanOrder order) throws Exception {
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        return mapper.getOutOrderFromChannel(order.getId());
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void updateCallbacklog(NjLoanOrder order, boolean isSuccess) throws Exception {
        NjOrderCallbackLogMapper mapper = dao.getMapper(NjOrderCallbackLogMapper.class);
        NjOrderCallbackLog log = new NjOrderCallbackLog();
        log.setId(UuidUtil.get32UUID());
        log.setOrderId(order.getId());
        log.setOrderState(order.getStatus());
        log.setResult(isSuccess);
        log.setCallDate(new Date());
        mapper.insert(log);
    }


    /**
     * 查询所有第三方的无需用户确认、已经审批完成的订单
     *
     * @return
     */
    public List<NjLoanOrder> getToCallbackNoUserConfirmOutOrder() throws Exception {
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        List<NjLoanOrder> onlDealOrders = mapper.selectOnlDealNoUserConfirmOrders();
        List<NjLoanOrder> offDealOrders = mapper.selectOffDealNoUserConfirmOrders();
        if (offDealOrders.isEmpty()) {
            return onlDealOrders;
        }
        List<NjLoanOrder> result = new ArrayList<NjLoanOrder>();
        for (NjLoanOrder i : offDealOrders) {
            boolean repetition = false;
            for (NjLoanOrder j : onlDealOrders) {
                if (i.getOrderNo().equals(j.getOrderNo())) {
                    repetition = true;
                    break;
                }
            }
            if (!repetition) {
                onlDealOrders.add(i);
            }
        }
        return onlDealOrders;
    }

    /**
     * 保存订单承诺函
     *
     * @param order
     * @param url
     * @param fileType
     */
    @Transactional(readOnly = false, rollbackFor = {Throwable.class})
    public void addAssureFile(NjLoanOrder order, String url, String fileType) throws Exception {
        NjUserAttachment att = new NjUserAttachment();
        att.setId(UuidUtil.get32UUID());
        att.setSource(url);
        att.setFileType(fileType);
        att.setBusinessType(Constants.FILE_TYPE.AssureFile);
        NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
        attMapper.insert(att);
        NjOrderAttachment noa = new NjOrderAttachment();
        noa.setId(UuidUtil.get32UUID());
        noa.setOrderId(order.getId());
        noa.setAttachId(att.getId());
        NjOrderAttachmentMapper noaMapper = dao.getMapper(NjOrderAttachmentMapper.class);
        noaMapper.insert(noa);
    }

    /**
     * 获取第三方渠道产品的渠道id
     *
     * @param productCode
     * @return
     */
    public String getOutProductChannelId(String productCode) throws Exception {
        // TODO Auto-generated method stub
        NjProductChannelMapperExtend mapper = dao.getMapper(NjProductChannelMapperExtend.class);
        String channelId = mapper.getOutProductChannelId(productCode);
        return channelId;
    }
    
    /**
     * 查询指定时间区间的订单回调日志
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public List<NjOrderCallbackLog> getOrderCallBack(Date startTime,Date endTime) throws Exception{
    	
    	NjOrderCallbackLogExample example = new NjOrderCallbackLogExample();
    	NjOrderCallbackLogMapper mapper = dao.getMapper(NjOrderCallbackLogMapper.class);
    	example.createCriteria().andCallDateBetween(startTime, endTime).andResultEqualTo(true);
    	return mapper.selectByExample(example);
    }
    
    /**
     * 查询指定时间、状态的订单
     * @param states
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public List<NjLoanOrder> getOrderListByStatus(List<Integer> states,Date startTime,Date endTime) throws Exception {
    	NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
    	return mapper.getOrderCallBackByStatus(states, startTime, endTime);
    }
    
    /**
     * 查询回调扣款通知
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public List<NjDeductionNotice> getDeductionNoticeList(Date startTime,Date endTime) throws Exception{
    	
    	NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
    	return mapper.getDeductionNoticeList(startTime, endTime);
    }
    
    /**
     * 查询资金端通用通知
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public List<NjChannelRequset> getCommonNoticeList(Date startTime,Date endTime) throws Exception {
    	NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
    	return mapper.getCommonNoticeList(startTime, endTime);
    }
    
    /**
     * 查询资金端用户激活通知
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public List<NjUserActivateNotice> getUserActivateNotice(Date startTime,Date endTime) throws Exception {
    	NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
    	return mapper.getUserActivateNotice(startTime, endTime);
    }
    
    /**
     * 通过订单Id查询车辆信息
     * @param orderId
     * @return
     * @throws Exception
     */
    public NjUserCar getUsercarByOrderId(String orderId) throws Exception{
    	NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
    	List<NjUserCar> list = mapper.getUsercarByOrderId(orderId);
    	if (list.size()>0) {
    		return list.get(0);
    	}
    	return null;
    }
    
    /**
     * 查询渠道商对接账号，通过订单中的channelId进行查询
     * @param channelId
     * @return
     * @throws Exception 
     */
    public NjChannelDevAccount getChannelDevAccountByChannelId(String channelId) throws Exception{
    	
    	NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);    	
    	List<NjChannelDevAccount> list =mapper.getChannelDevAccountByChannelId(channelId);    	
    	if (list.size()>0){
    		return list.get(0);
    	} else {
    		return null;
    	}
    }
    
    public NjChannelDevAccount getChannelDevAccountByChannelIdT(String channelId)throws Exception{
    	
    	NjChannelDevAccountMapper mapper = dao.getMapper(NjChannelDevAccountMapper.class);
    	NjChannelDevAccountExample example = new NjChannelDevAccountExample();
    	example.createCriteria().andChannelIdEqualTo(channelId);
    	List<NjChannelDevAccount> list = mapper.selectByExample(example);
    	if (list.size()>0) {
    		return list.get(0);
    	} else {
    		return null;
    	}
    	
    }
    
    
    /**
     * 获得订单日志 状态为4 拒绝的日志
     * @param orderNo
     * @return
     * @throws Exception
     */
    public NjOrderUpdateLog getOrderUpdateLog(String orderNo) throws Exception{
    	
    	NjOrderUpdateLogExample example = new NjOrderUpdateLogExample();
    	NjOrderUpdateLogMapper mapper = dao.getMapper(NjOrderUpdateLogMapper.class);
    	example.createCriteria().andOrderIdEqualTo(orderNo).andUpdateStatusEqualTo(4);
    	example.setOrderByClause("update_date  desc");
    	List<NjOrderUpdateLog> list =mapper.selectByExample(example);
    	if(list.size()>0){
    		return list.get(0);
    	}
    	return null;
    }

    /**
     * 查询是否要通知第三方
     *
     * @param order
     * @return
     * @throws Exception
     */
    public boolean needNotifyOutProvider(NjLoanOrder order) throws Exception {
        //查询是否在该状态已经通知过
        NjOrderCallbackLogMapper mapper = dao.getMapper(NjOrderCallbackLogMapper.class);
        NjOrderCallbackLogExample exp = new NjOrderCallbackLogExample();
        exp.createCriteria().andOrderIdEqualTo(order.getId()).andResultEqualTo(true)
                .andOrderStateEqualTo(order.getStatus());
        List<NjOrderCallbackLog> logs = mapper.selectByExample(exp);
        if (logs != null && !logs.isEmpty()) {
            return false;
        }
        NjOrderCallbackLogExample exp2 = new NjOrderCallbackLogExample();
        exp.createCriteria().andOrderIdEqualTo(order.getId()).andResultEqualTo(false)
                .andOrderStateEqualTo(order.getStatus());
        List<NjOrderCallbackLog> logs2 = mapper.selectByExample(exp);
        if (logs2.size() > 10) {
            return false;
        }
        return true;
    }

    /**
     * 添加普惠订单
     *
     * @param njPuhuiApply 普惠订单
     * @throws Exception
     */
    @Transactional(readOnly = false, rollbackFor = {Throwable.class})
    public void applyOrder(NjPuhuiApply njPuhuiApply, String orderId) throws Exception {
        NjPuhuiApplyMapper njPuhuiApplyMapper = dao.getMapper(NjPuhuiApplyMapper.class);
//        njPuhuiApply.setOrderId(orderId);
        njPuhuiApplyMapper.insert(njPuhuiApply);
    }

    public NjPuhuiApply getPuhuiOrder(String loanNo) throws Exception {
        NjPuhuiApplyMapper njPuhuiApplyMapper = dao.getMapper(NjPuhuiApplyMapper.class);
//        njPuhuiApply.setOrderId(orderId);
        return njPuhuiApplyMapper.selectByPrimaryKey(loanNo);
    }

    /**
     * 检查金额是否已经达到上限
     *
     * @return true：已达到；false：未达到
     */
    public int checkAmount(String productCode, BigDecimal amount ,String appId) throws Exception {
    	
        logger.info("进件金额：" + amount + ",进件产品编号：" + productCode);
        
    	// 通过APPID查询当前进件渠道
    	NjChannelDevAccountMapper devMapper = dao.getMapper(NjChannelDevAccountMapper.class);
		NjChannelDevAccountExample exp = new NjChannelDevAccountExample();
		exp.createCriteria().andAppIdEqualTo(appId);
		List<NjChannelDevAccount> list =  devMapper.selectByExample(exp);
		String channleId  = list.get(0).getChannelId();// 进件渠道ID
		
		// 查询产品
		NjProductMapper productMapper = dao.getMapper(NjProductMapper.class);
		NjProductExample productExample = new NjProductExample();
		productExample.createCriteria().andProductCodeEqualTo(productCode);
		List<NjProduct> listProduct = productMapper.selectByExample(productExample);
		NjProduct product = listProduct.get(0);
		String productId = product.getId();
		 
		// 查询渠道
		NjChannelMapper channelMapper = dao .getMapper(NjChannelMapper.class);
		NjChannel channel = channelMapper.selectByPrimaryKey(channleId);
		
		// 产品交易配置
		NjProductTransaction productTransaction = outOrderService.getNjProductTransactionById(product.getId());    
        
		// 每日限额
        double fundsLimit;
        BigDecimal maxAmount = productTransaction.getMaxAmount();
        logger.info("渠道每日进件最大限额：" + channel.getFundsLimit()); 
        logger.info("产品进件最大限额：" + productTransaction.getMaxAmount().doubleValue());
        logger.info("产品id：" + productId);
        if (null == channel.getFundsLimit()) {
            return 1;
        } else {
            fundsLimit = Double.parseDouble(channel.getFundsLimit().toString());
        }
        
        
        NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        String today = DateUtil.getDay();
        BigDecimal current = new BigDecimal(mapper.getAmount(productId, today + " 00:00:00", today + " 23:59:59"));
        logger.info("渠道今日已进件总金额：" + current);
        BigDecimal total = current.add(amount);
        logger.info("渠道今日进件总金额(含本次申请金额)：" + total.longValue()); 
        BigDecimal productAmount = new BigDecimal(mapper.getProductAmount(productId));
        logger.info("产品已进件总金额" + productAmount.doubleValue());
        productAmount = productAmount.add(amount);
        logger.info("产品进件总金额(含本次申请金额)" + productAmount.doubleValue());
        
        // 0 通过   1 每日进件总额超标  2 产品进件总额超标
        int flag = 0 ;
        if (total.longValue() > fundsLimit) {
        	flag = 1;
        }
        
        if (maxAmount.compareTo(productAmount)==-1) {
        	flag = 2;
        }
        
        return flag;
    }
    
    /**
     * 修改扣款通知
     * @param notice
     * @throws Exception
     */
    @Transactional(readOnly = false, rollbackFor = {Throwable.class})
    public void updateDeductionNotice(NjDeductionNotice notice) throws Exception{
    	NjDeductionNoticeMapper mapper = dao.getMapper(NjDeductionNoticeMapper.class);
    	mapper.updateByPrimaryKey(notice);
    }
    
    /**
     * 添加代扣请求日志
     * @param request
     * @throws Exception
     */
    @Transactional(readOnly = false, rollbackFor = {Throwable.class})
    public void saveDeductionRequest(NjDeductionRequest request) throws Exception{
    	NjDeductionRequestMapper mapper = dao.getMapper(NjDeductionRequestMapper.class);
    	mapper.insert(request);
    	
    }
    
    /**
     * 添加通用请求日志
     * @param request
     * @throws Exception
     */
    @Transactional(readOnly = false, rollbackFor = {Throwable.class})
    public void saveChannelRequest(NjChannelRequset request)throws Exception{
    	NjChannelRequsetMapper mapper = dao.getMapper(NjChannelRequsetMapper.class);
    	mapper.insert(request);
    }
    
    /**
     * 修改通用请求日志
     * @param request
     * @throws Exception
     */
    @Transactional(readOnly = false, rollbackFor = {Throwable.class})
    public void updateChannelRequest(NjChannelRequset request)throws Exception{
    	NjChannelRequsetMapper mapper = dao.getMapper(NjChannelRequsetMapper.class);
    	mapper.updateByPrimaryKey(request);
    }
    
    /**
     * 修改用户激活通知
     * @param notice
     * @throws Exception 
     */
    @Transactional(readOnly = false, rollbackFor = {Throwable.class})
    public void updateUserActivate(NjUserActivateNotice notice) throws Exception{
    	NjUserActivateNoticeMapper mapper = dao.getMapper(NjUserActivateNoticeMapper.class);
    	mapper.updateByPrimaryKey(notice);
    }
    
    
    /**
     * 通过业务编号查询请求
     * @param bussinessNo
     * @return
     * @throws Exception
     */
    public NjChannelRequset getChannelRequestByBusinessNO(String bussinessNo,String channelId) throws Exception{
    	NjChannelRequsetMapper mapper = dao.getMapper(NjChannelRequsetMapper.class);
    	NjChannelRequsetExample example  = new NjChannelRequsetExample();
    	example.createCriteria().andBusinessNoEqualTo(bussinessNo).andChannelIdEqualTo(channelId);
    	List<NjChannelRequset> list =  mapper.selectByExample(example);
    	if (list.size()>0) {
    		return list.get(0);
    	}else {
    		return null;
    	}
    	
    }
    
    /**
     * 通过appId查询渠道
     * @param appId
     * @return
     * @throws Exception
     */
    public 	NjChannelDevAccount getNjChannelDevAccountByAppId(String appId) throws Exception{
    	
    	// 通过APPID查询当前进件渠道
    	NjChannelDevAccountMapper devMapper = dao.getMapper(NjChannelDevAccountMapper.class);
		NjChannelDevAccountExample exp = new NjChannelDevAccountExample();
		exp.createCriteria().andAppIdEqualTo(appId);
		List<NjChannelDevAccount> list =  devMapper.selectByExample(exp);
		if (list.size()>0){
			return  list.get(0);
		}
		return null;
    }
    
    /**
     * 通过产品编号查询产品配置
     * @param productCode
     * @return
     * @throws Exception
     */
    public  Map<String,Object> getProductTransactionByProductCode(String  productCode) throws Exception{
    	  
    	NjProductTransactionMapperExtend njProductTransactionMapperExtend = dao.getMapper(NjProductTransactionMapperExtend.class);
    	Map<String, Object> njProductTransaction = njProductTransactionMapperExtend.selectByProduct(productCode);
    	return njProductTransaction;
    }
    
    /**
     * 通过产品ID查询产品交易配置
     * @param productId
     * @return
     * @throws Exception
     */
    public NjProductTransaction getNjProductTransactionById(String productId) throws Exception {
    	
    	NjProductTransactionMapper mapper =  dao.getMapper(NjProductTransactionMapper.class);
    	NjProductTransactionExample example = new NjProductTransactionExample();
    	example.createCriteria().andProductIdEqualTo(productId);
    	List<NjProductTransaction> list =mapper.selectByExample(example);
    	if (list.size()>0) {
    		return list.get(0);
    	}else {
    		return null;
    	}
    }
    

    /**
     * 通过产品字段配置验证非空
     * @param productCode
     * @param orderBean
     * @throws Exception
     */
    public void verifyServiceParam(OutOrderBean orderBean) throws NotNullException, Exception{
    	
    	NjProductMapper productMapper = dao.getMapper(NjProductMapper.class);
		NjProductExample productExample = new NjProductExample();
		productExample.createCriteria().andProductCodeEqualTo(orderBean.getProductCode());
		List<NjProduct> listProduct = productMapper.selectByExample(productExample);
		NjProduct product = listProduct.get(0);
		
		// 获得提交为空的字段
		List<String> listKeyword = transOurOrderBean(orderBean);
		
		// 查询产品配置字段
		NjProductMapperExtend productMapperExtend = dao.getMapper(NjProductMapperExtend.class);
		List<Map<String,Object>> listdict = productMapperExtend.getProductBussinessDictByProductId(product.getId());
		
		StringBuilder sb =  new StringBuilder();
		for(String keyword : listKeyword){
			for (Map<String,Object> map : listdict) {
				String productKeyword = map.get("keyword").toString();
				String descption = map.get("descption").toString();
				int inputType =  Integer.parseInt(map.get("input_type").toString());
				if (keyword.equals(productKeyword)) {
					if (inputType == 1) {
						sb.append(descption+",");
					}
				}
			}
		}
		
		if (sb.length()>0) {
			throw new NotNullException(sb.toString()+"字段不能为空");
		}

    }
    
    
    /**
     * 对第三方传入字段进行数据清洗
     * @param orderBean
     * @return
     */
    public List<String> transOurOrderBean (OutOrderBean orderBean){
    		
    	List<String> listKeyword = new ArrayList<String>();
    	
    	/**工作信息*/ 
    	List<OutWorkInfoBean> listWorkInfoBean = orderBean.getWorkInfo();
    	if (listWorkInfoBean != null) {
    		for (OutWorkInfoBean work : listWorkInfoBean) {
        		
        		// 公司名称
        		if (work.getCompanyName() == null) {
        			listKeyword.add("company_name");
        		} else {
        			if (StringUtils.isEmpty(work.getCompanyName())) {
        				listKeyword.add("company_name");
        			}
        		}    		
        		// 公司电话
        		if (work.getCompanyTel() == null) {
        			listKeyword.add("company_mobile");
        		} else {
        			if (StringUtils.isEmpty(work.getCompanyTel())) {
        				listKeyword.add("company_mobile");
        			}
        		}    		
        		// 公司地址
        		if (work.getCompanyAddr() == null) {
        			listKeyword.add("company_address");
        		} else {
        			if (StringUtils.isEmpty(work.getCompanyAddr())) {
        				listKeyword.add("company_address");
        			}
        		}    		
        		// 公司职务
        		if (work.getJob() == null) {
        			listKeyword.add("company_position");
        		} else {
        			if (StringUtils.isEmpty(work.getJob())) {
        				listKeyword.add("company_position");
        			}
        		}    		
        		// 年收入配置不存在
//        		if (work.getAnnualIncome() == null) {
//        			listKeyword.add("");
//        		} 
        		// 月收入
        		if (work.getMonthIncome() == null) {
        			listKeyword.add("month_income");
        		} else {
        			if (StringUtils.isEmpty(work.getMonthIncome())) {
        				listKeyword.add("month_income");
        			}
        		} 
        		// 在职信息配置不存在
        		// 工作年限
        		if (work.getRecentWorkYears() == null) {
        			listKeyword.add("work_continue");
        		} else {
        			if (StringUtils.isEmpty(work.getRecentWorkYears())) {
        				listKeyword.add("work_continue");
        			}
        		}   
        		// 公司照片配置不存在
        	}
    	} else {
    		listKeyword.add("company_name");
    		listKeyword.add("company_mobile");
    		listKeyword.add("company_address");
    		listKeyword.add("company_position");
    		listKeyword.add("month_income");
    		listKeyword.add("work_continue");
    		
    	}   	
    	
    	/**基本信息*/ 
    	OutBasicInfoBean basicInfo = orderBean.getBasicInfo();
    	if (basicInfo != null) {
    		// 婚姻状态
        	if (basicInfo.getMarriage() == null) {
        		listKeyword.add("marital_status");
        	}
        	// 房产状况配置不存在
//        	if (basicInfo.getHouse() == null) {
//        		listKeyword.add("");
//        	}
        	// 最高学历
        	if (basicInfo.getEducation() == null) {
    			listKeyword.add("education");
    		} 
        	// 居住地址
        	if (basicInfo.getAddress() == null) {
        		listKeyword.add("address");
        	}else {
    			if (StringUtils.isEmpty(basicInfo.getAddress())) {
    				listKeyword.add("address");
    			}
    		}   
        	// 附件照片配置不存在
        	// 手机号
        	if (basicInfo.getPhone() == null) {
        		listKeyword.add("mobile");
        	}else {
    			if (StringUtils.isEmpty(basicInfo.getPhone())) {
    				listKeyword.add("mobile");
    			}
    		} 
        	// 银行卡号配置不存在ownIndustry
        	// 所属行业
        	if (basicInfo.getOwnIndustry() == null) {
        		listKeyword.add("ownIndustry");
        	}else {
    			if (StringUtils.isEmpty(basicInfo.getOwnIndustry())) {
    				listKeyword.add("ownIndustry");
    			}
    		} 
        	// 微信号 、省、市、县配置不存在
    	}  else {
    		
    		listKeyword.add("marital_status");
    		listKeyword.add("education");
    		listKeyword.add("address");
    		listKeyword.add("mobile");
    		listKeyword.add("ownIndustry");
    	}  	
    	
    	/**身份证信息*/
    	OutCertInfo  certInfo = orderBean.getCertInfo();
    	if (certInfo != null) {
    		// 身份证正面
        	if (certInfo.getCertFrontImg() == null) {
        		listKeyword.add("id_card_front_img");
        	}else {
    			if (StringUtils.isEmpty(certInfo.getCertFrontImg())) {
    				listKeyword.add("id_card_front_img");
    			}
    		} 
        	// 身份证背面
        	if (certInfo.getCertBackImg()== null) {
        		listKeyword.add("id_card_back_img");
        	}else {
    			if (StringUtils.isEmpty(certInfo.getCertBackImg())) {
    				listKeyword.add("id_card_back_img");
    			}
    		} 
        	// 手持身份证
        	if (certInfo.getVerifyImg()== null) {
        		listKeyword.add("id_card_on_hand");
        	}else {
    			if (StringUtils.isEmpty(certInfo.getVerifyImg())) {
    				listKeyword.add("id_card_on_hand");
    			}
    		} 
        	// 活体认证图
        	if (certInfo.getLivingImg()== null) {
        		listKeyword.add("living_assure");
        	}else {
    			if (StringUtils.isEmpty(certInfo.getLivingImg())) {
    				listKeyword.add("living_assure");
    			}
    		}
    	} else {
    		listKeyword.add("id_card_front_img");
    		listKeyword.add("id_card_back_img");
    		listKeyword.add("id_card_on_hand");
    		listKeyword.add("living_assure");
    	}   	
    	
    	/**房产信息*/
    	List<OutHouseInfo> listHousInfo = orderBean.getHouseInfo();
    	if (listHousInfo != null) {
    		for (OutHouseInfo houseInfo : listHousInfo){
        		// 房产名称、 地址、价格、配置不存在
        		
        		// 房产信息摘要
        		if (houseInfo.getImage()==null){
        			listKeyword.add("estate_summary");
        		} else {
        			if (houseInfo.getImage().size()==0){
        				listKeyword.add("estate_summary");
        			}
        		}
        		// 房产证照片
        		if (houseInfo.getFrontImg()==null) {
        			listKeyword.add("estate");
        		} else {
        			if (StringUtils.isEmpty(houseInfo.getFrontImg())) {
        				listKeyword.add("estate");
        			}
        		}
        		// 房产证照片
        		if (houseInfo.getBackImg()==null) {
        			listKeyword.add("estate");
        		} else {
        			if (StringUtils.isEmpty(houseInfo.getBackImg())) {
        				listKeyword.add("estate");
        			}
        		}
        	}
    	} else {
    		listKeyword.add("estate_summary");
    		listKeyword.add("estate");
    	}
    	
    	
    	
    	/**车辆信息*/
    	List<OutCarInfo> listCarInfo = orderBean.getCarInfo();
    	if (listCarInfo !=null) {
    		for (OutCarInfo carInfo : listCarInfo) {
        		
        		// 车牌号
        		if (carInfo.getCarNumber()==null) {
        			listKeyword.add("carNumber");
        		} else {
        			if (StringUtils.isEmpty(carInfo.getCarNumber())) {
        				listKeyword.add("carNumber");
        			}
        		}
        		// 车型
        		if (carInfo.getCarType()==null) {
        			listKeyword.add("model");
        		} 
        		// 购置年份配置不存在
        		// 实际购车价
        		if (carInfo.getBuyPrice()==null) {
        			listKeyword.add("buyPrice");
        		} else {
        			if (StringUtils.isEmpty(carInfo.getBuyPrice())) {
        				listKeyword.add("buyPrice");
        			}
        		}
        		// 车龄配置信息不存在
        		// 备注信息配置不存在
        		// 车辆图片
        		if (carInfo.getAttachment()==null) {
        			listKeyword.add("car");
        		} else {
        			if (carInfo.getAttachment().size()==0){
        				listKeyword.add("car");
        			}
        		}
        		// 新旧程度配置信息不存在
        		// 上户地址配置信息不存在
        		// 驾驶证前面
        		if (carInfo.getFrontImg()==null) {
        			listKeyword.add("drive_license");
        		} else {
        			if (StringUtils.isEmpty(carInfo.getFrontImg())) {
        				listKeyword.add("drive_license");
        			}
        		}
        		// 驾驶证背面
        		if (carInfo.getBackImg()==null) {
        			listKeyword.add("drive_license");
        		} else {
        			if (StringUtils.isEmpty(carInfo.getBackImg())) {
        				listKeyword.add("drive_license");
        			}
        		}
        		// 行驶证
        		if (carInfo.getDriveLicense()==null) {
        			listKeyword.add("driving_license");
        		} else {
        			if (StringUtils.isEmpty(carInfo.getDriveLicense())) {
        				listKeyword.add("driving_license");
        			}
        		}
        		// 保单号、车架号、配置信息不存在
        	}
    	} else {
    		listKeyword.add("carNumber");
    		listKeyword.add("model");
    		listKeyword.add("buyPrice");
    		listKeyword.add("car");
    		listKeyword.add("drive_license");
    		listKeyword.add("driving_license");
    	}
    	
    	// 联系人信息 配置信息不足
    	
//		HashSet h = new HashSet(listKeyword);
//		listKeyword.clear();
//		listKeyword.addAll(h);
    	
    	// 商户信息
    	OutMerchantInfo  merchant  = orderBean.getMerchantInfo();
    	if (merchant != null) {
    		
    		// 商户编号
        	if (merchant.getMerchantNo()== null) {
        		listKeyword.add("merchant_no");
        	} else {
        		
        		if (StringUtils.isEmpty(merchant.getMerchantNo())) {
        			listKeyword.add("merchant_no");
        		}
        	}
        	
        	// 商户名称
        	if (merchant.getMerchantName() == null) {
        		listKeyword.add("merchant_name");
        	} else {    		
        		if (StringUtils.isEmpty(merchant.getMerchantName())) {
        			listKeyword.add("merchant_name");
        		}
        	}
        	
        	// 商户所在省
        	if (merchant.getMerchantProvince() == null) {
        		listKeyword.add("merchant_province");
        	} else {
        		if (StringUtils.isEmpty(merchant.getMerchantProvince())) {
        			listKeyword.add("merchant_province");
        		}
        	}
        	
        	// 商户所在市
        	if (merchant.getMerchantCity() == null) {
        		listKeyword.add("merchant_city");
        	} else {
        		if (StringUtils.isEmpty(merchant.getMerchantCity())) {
        			listKeyword.add("merchant_city");
        		}
        	}
        	
        	// 商户所在县
        	if (merchant.getMerchantCounty() == null) {
        		listKeyword.add("merchant_county");
        	} else {
        		if (StringUtils.isEmpty(merchant.getMerchantCounty())) {
        			listKeyword.add("merchant_county");
        		}
        	}
    		
        	// 商户所在地
        	if (merchant.getMerchantAddress() == null) {
        		listKeyword.add("merchant_address");
        	} else {
        		if (StringUtils.isEmpty(merchant.getMerchantAddress())) {
        			listKeyword.add("merchant_address");
        		}
        	}
        	
        	// 开始合作时间
        	if (merchant.getConsociationDate() == null) {
        		listKeyword.add("consociation_date");
        	} else {
        		if (StringUtils.isEmpty(merchant.getConsociationDate())) {
        			listKeyword.add("consociation_date");
        		}
        	}
        	
        	// 交易流水
        	if (merchant.getTransactionNo() == null) {
        		listKeyword.add("transaction_no");
        	} else {
        		if (StringUtils.isEmpty(merchant.getTransactionNo())) {
        			listKeyword.add("transaction_no");
        		}
        	}
        	
    	} else {
    		listKeyword.add("merchant_no");
    		listKeyword.add("merchant_name");
    		listKeyword.add("merchant_province");
    		listKeyword.add("merchant_city");
    		listKeyword.add("merchant_county");
    		listKeyword.add("merchant_address");
    		listKeyword.add("consociation_date");
    	}
    	
    	
    	// 商户所在地
    	
    	
    	removeDuplicateWithOrder(listKeyword);
    	return listKeyword;
    	
    }
    
    public static void removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        System.out.println(" remove duplicate " + list);
    }
    

    
    
    /** 
     * 根据字段名得到实例的字段值 
     *  
     * @param object 
     *            实例对象 
     * @param fieldName 
     *            字段名称 
     * @return 实例字段的值，如果没找到该字段则返回null 
     * @throws IllegalAccessException 
     */  
   public static Object getFieldValue(Object object, String fieldName)  
      throws IllegalAccessException {  
     Set<Field> fields = new HashSet<Field>();  
     // 本类中定义的所有字段  
     Field[] tempFields = object.getClass().getDeclaredFields();  
     for (Field field : tempFields) {  
      field.setAccessible(true);  
      fields.add(field);  
     }  
     // 所有的public字段，包括父类中的  
     tempFields = object.getClass().getFields();  
     for (Field field : tempFields) {  
      fields.add(field);  
     }  
     
     for (Field field : fields) {  
      if (field.getName().equals(fieldName)) {  
       return field.get(object);  
      }  
     }  
     return null;  
   }  
   
   public NjChannelDevAccount getChannelDevAccountByAppId(String appId) throws Exception{
	  
	   NjChannelDevAccountMapper mapper = dao.getMapper(NjChannelDevAccountMapper.class);
		NjChannelDevAccountExample exp = new NjChannelDevAccountExample();
		exp.createCriteria().andAppIdEqualTo(appId);
		List<NjChannelDevAccount> list =  mapper.selectByExample(exp);
		if (list.size()==0) {
			return null;
		} else {
			return list.get(0);
		}
		
   } 

}

