package com.nj.service.itf;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.entity.ResponseDto;
import com.nj.dao.NjWithdrawingRecordMapper;
import com.nj.dao.extend.NjWithdrawingRecordMapperExtend;
import com.nj.model.generate.NjWithdrawingRecord;
import com.nj.model.generate.NjWithdrawingRecordExample;
import com.nj.model.mq.RepayPlanMq;
import com.nj.mongoModel.after.MoneyBackMainNew;
import com.nj.mongoModel.after.MoneyBackNew;
import com.nj.mongoModel.after.RepayPlanMainNew;
import com.nj.mongoModel.after.RepayPlanNew;
import com.nj.service.remoteing.IMqNdService;
import com.nj.service.remoteing.IMqWDService;
import com.nj.service.remoteing.RepayPlanNewService;

/**
 * 扣款表service
 *
 * @author Lizy
 * @version 2018/8/7.
 */
@Service("withdrawingRecordService")
public class WithdrawingRecordService {
    // 日志
    private static Logger logger = LoggerFactory.getLogger(WithdrawingRecordService.class);
    //dao
    @Resource(name = "BaseDao")
    private BaseDao dao;
    // mqService
    @Resource
    private IMqNdService iMqService;
    @Autowired
    private RepayPlanNewService repayPlanNewService;
    @Autowired
    private NjWithdrawingRecordMapper  njWithdrawingRecordMapper;

//    /**
//     * 根据订单号和期数扣款
//     */
//    public boolean withdrawing(String orderNo, int period) throws Exception {
//        logger.info("调用扣款接口,订单号{},扣款期数{}", orderNo, period);
//        NjWithdrawingRecordMapperExtend njWithdrawingRecordMapperExtend = dao.getMapper(NjWithdrawingRecordMapperExtend.class);
//        NjWithdrawingRecord record = njWithdrawingRecordMapperExtend.getRecordByOrderNoAndPeriod(orderNo, period - 1);
//        // 判断是否存在往期
//        if (null != record && record.getStatus() != 5) {
//            logger.info("存在未扣款订单{}", orderNo);
//            return false;
//        }
//        NjWithdrawingRecord currentRecord = njWithdrawingRecordMapperExtend.getRecordByOrderNoAndPeriod(orderNo, period);
//        // 判断是否存在当期数据
//        if (null != currentRecord && currentRecord.getStatus() != 5) {
//            sendMqMessage(currentRecord);
//            return true;
//        }
//        ResponseDto<RepayPlan> responseDto = repayPlanService.getRepayPlanByOrderNoPeriod(orderNo, period);
//        logger.info("获取还款计划{}", JSON.toJSONString(responseDto));
//        //  判断获取结果
//        if (null != responseDto && responseDto.getReturnCode() == 0) {
//            RepayPlan repayPlan = responseDto.getResult();
//            NjWithdrawingRecord njWithdrawingRecord = saveWithdrawingData(repayPlan);
//            sendMqMessage(njWithdrawingRecord);
//            return true;
//        }
//        return false;
//    }

    /**
     * 发mq
     */
    private void sendMqMessage(NjWithdrawingRecord njWithdrawingRecord) {
        RepayPlanMq repayPlanMq = new RepayPlanMq();
        repayPlanMq.setOrderId(njWithdrawingRecord.getId());
        repayPlanMq.setType(3);
        repayPlanMq.setProcessId(0);
        ResponseDto<String> sendRepayPlanMq = iMqService.sendRepayPlanMq(repayPlanMq);
        logger.info("sendRepayPlanMq=="+sendRepayPlanMq);
    }

    /**
     * 保存数据
     */
//    private NjWithdrawingRecord saveWithdrawingData(RepayPlan repayPlan) throws Exception {
//        // 封装扣款数据并保存
//        NjWithdrawingRecordMapper njWithdrawingRecordMapper = dao.getMapper(NjWithdrawingRecordMapper.class);
//        NjWithdrawingRecord njWithdrawingRecord = new NjWithdrawingRecord();
//        njWithdrawingRecord.setId(repayPlan.getOrderNo() + repayPlan.getPeriod());
//        njWithdrawingRecord.setOrderNo(repayPlan.getOrderNo());
//        njWithdrawingRecord.setCurrentPeriod(repayPlan.getPeriod());
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        njWithdrawingRecord.setCreateDate(calendar.getTime());
//        njWithdrawingRecord.setWithdrawingCapital(repayPlan.getPlanRepayCapital());
//        njWithdrawingRecord.setWithdrawingInterest(repayPlan.getPlanRepayInterest());
//        njWithdrawingRecord.setProductName(repayPlan.getProductName());
//        njWithdrawingRecord.setChannelFee(repayPlan.getPlanChannelFeeForPeriod());
//        njWithdrawingRecord.setDefaultInterest(null);
//        njWithdrawingRecord.setOverdueDay(0);
//        njWithdrawingRecord.setIsOverdue(false);
//        njWithdrawingRecord.setStatus((byte) 0);
//        njWithdrawingRecord.setRate(repayPlan.getYearRate());
//        njWithdrawingRecordMapper.insert(njWithdrawingRecord);
//        return njWithdrawingRecord;
//    }

	public boolean withdrawingNew(String orderNo, int period, MoneyBackMainNew MoneyBackMainNew )  throws Exception{
		    logger.info("调用扣款接口,订单号{},扣款期数{}", orderNo, period);
	        NjWithdrawingRecordMapperExtend njWithdrawingRecordMapperExtend = dao.getMapper(NjWithdrawingRecordMapperExtend.class);
	        NjWithdrawingRecord record = njWithdrawingRecordMapperExtend.getRecordByOrderNoAndPeriod(orderNo, period - 1);
	        // 判断是否存在往期
	        if (null != record && record.getStatus() != 5) {
	            logger.info("存在未扣款订单{}", orderNo);
	            return false;
	        }
	       // NjWithdrawingRecord currentRecord = njWithdrawingRecordMapperExtend.getRecordByOrderNoAndPeriod(orderNo, period);
	        NjWithdrawingRecord currentRecord = njWithdrawingRecordMapper.selectByPrimaryKey(this.getWithdrawingId(orderNo, period, MoneyBackMainNew.getCoporateId())); 
	        // 判断是否存在当期数据
	        if (null != currentRecord && currentRecord.getStatus() != 5) {
	            sendMqMessage(currentRecord);
	            return true;
	        }
	      
            NjWithdrawingRecord njWithdrawingRecord = saveWithdrawingDataNew(MoneyBackMainNew);
            sendMqMessage(njWithdrawingRecord);
            return true;
	      
	}

	private NjWithdrawingRecord saveWithdrawingDataNew(MoneyBackMainNew moneyBackMainNew)  throws  Exception {
		String orderNo = moneyBackMainNew.getOrderNo();
		List<MoneyBackNew> listMoneyBackNew =  moneyBackMainNew.getListMoneyBackNew() ;
		if(listMoneyBackNew.size()<=0){
			String errorMsg= "repayPlanMainNew=="+moneyBackMainNew +"无listMoneyBackNew记录";
			logger.error(errorMsg);
			throw new Exception(errorMsg);
		}
		MoneyBackNew moneyBackNew = listMoneyBackNew.get(0);
		Integer period = moneyBackNew.getPeriod();
		
		double  amount = 0; 
        Double accRepayTotalAmt = moneyBackNew.getAccRepayTotalAmt().doubleValue();
        Double planRepayTotalAmt = moneyBackNew.getPlanRepayTotalAmt().doubleValue();
        if( null == accRepayTotalAmt || accRepayTotalAmt-0 <=0){
        	amount = planRepayTotalAmt;
        }else{
        	amount = accRepayTotalAmt;
        }
       
        // 封装扣款数据并保存
        NjWithdrawingRecordMapper njWithdrawingRecordMapper = dao.getMapper(NjWithdrawingRecordMapper.class);
        logger.info("order>>" + orderNo +"|period==>"+period);
        NjWithdrawingRecord njWithdrawingRecord = new NjWithdrawingRecord();
        njWithdrawingRecord.setId(this.getWithdrawingId(orderNo, period, moneyBackNew.getCoporateId()));
        njWithdrawingRecord.setOrderNo(orderNo);
        njWithdrawingRecord.setCurrentPeriod(period);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        njWithdrawingRecord.setCreateDate(calendar.getTime());
        njWithdrawingRecord.setWithdrawingCapital(new  BigDecimal(amount) );
        njWithdrawingRecord.setWithdrawingInterest(new  BigDecimal(0));
        njWithdrawingRecord.setProductName(moneyBackMainNew.getProductId());
        njWithdrawingRecord.setChannelFee(new  BigDecimal(0));
        njWithdrawingRecord.setDefaultInterest(null);
        njWithdrawingRecord.setOverdueDay(moneyBackNew.getOverdueDays() == null ? 0 : moneyBackNew.getOverdueDays());
        njWithdrawingRecord.setIsOverdue(true);
        njWithdrawingRecord.setStatus((byte) 0);
        njWithdrawingRecord.setRate(moneyBackMainNew.getYearRate() );
        njWithdrawingRecordMapper.insert(njWithdrawingRecord);
        return njWithdrawingRecord;
	}
	
	/**
	 * 根据订单编号和期数删除
	 * @param orderNo
	 * @param period
	 * @throws Exception
	 */
	public void delWithdrawingData(String orderNo,int period) throws Exception{
		
		NjWithdrawingRecordMapper njWithdrawingRecordMapper = dao.getMapper(NjWithdrawingRecordMapper.class);
		NjWithdrawingRecordExample example = new NjWithdrawingRecordExample();
		example.createCriteria().andOrderNoEqualTo(orderNo).andCurrentPeriodEqualTo(period);
		njWithdrawingRecordMapper.deleteByExample(example);
	}
	
	public  String  getWithdrawingId(String orderNo,int period,String  coporateId){
		return  coporateId+"_"+orderNo+"_"+period;
	}
}