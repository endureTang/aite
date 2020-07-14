package com.nj.service.process;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.nj.core.base.common.Constants;
import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProcessInfo;
import com.nj.core.base.enums.EProcessResult;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjOrderContractMapper;
import com.nj.dao.NjOrderUpdateLogMapper;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjProcessMapperExtend;
import com.nj.dao.extend.NjProductMapperExtend;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjOrderContract;
import com.nj.model.generate.NjOrderUpdateLog;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.model.mq.OrderMq;
import com.nj.service.enterprise.OrderService;
import com.nj.service.enterprise.ProductService;
import com.nj.service.remoteing.IMqNdService;
import com.nj.service.remoteing.IMqWDService;

/**
 * 
 * @Name com.nj.service.process.ManualProcess
 * @Description 手动过程执行服务类
 * 
 * @Author bruce
 * @Version 2018年2月22日 下午2:12:39
 * @Copyright 金鼎财富
 *
 */
@Service
public class ManualProcess extends BaseAutoProcess {
	@Resource(name = "njProcessFlowsService")
	protected ProcessFlowsService processFlowsService;

	@Resource
	protected IMqWDService mqWDService;
	
	@Resource
	protected IMqNdService mqNdService;

	@Resource(name = "productService")
	private ProductService productService;
	@Resource
	private OrderService orderService;

	/**
	 * 执行手动过程(通过/拒绝)
	 * 
	 * @param orderId
	 * @param execUserId
	 * @param currentProcess
	 * @param checkResult
	 * @param remark
	 * @return
	 * @throws Exception
	 */
	public boolean execManualProcess(String orderId, String execUserId, NjProcessTemplateFlows currentProcess,
			EProcessResult checkResult, String remark) throws Exception {
		boolean result = false;

		Date begin = new Date();
		Date end = new Date();
		result = updateOrderStatus(orderId, currentProcess, execUserId, checkResult, begin, end, remark,0);
		if (!result) {
			return result;
		}
		logger.info("订单：{},{}：{}", orderId, currentProcess.getProcessName(), checkResult.getName());
		if (checkResult.equals(EProcessResult.REFUSE)) {
			logger.info("订单:{},被操作者拒绝,流程结束", orderId);
			return true;
		}
		currentProcess.setPrecondition(checkResult.getValue());
		if (checkResult.equals(EProcessResult.AGREE)) {
			NjProcessTemplateFlows nextCurrent = processFlowsService.selectNextProcess(currentProcess, checkResult);
			if (nextCurrent == null) {
				logger.error("订单:{},当前过程:{},没有查询到下一过程", orderId, currentProcess.getProcessName());
				return true;
			}
			if (nextCurrent.getType() > 1) {
				// 自动任务,发消息队列
				Thread.sleep(50);
				OrderMq orderMq = new OrderMq(orderId, nextCurrent.getProcessId(), nextCurrent.getTemplateId());
				NjLoanOrder loanOrder = orderService.getOrder(orderId);
				if(loanOrder.getCompanyId() != null && !loanOrder.getCompanyId().equals(Constants.DEFAULT_COMPANY_ID)) {//如果是能贷
					ResponseDto<String> tresponse = mqNdService.sendOrderProcessMq(orderMq);
					logger.debug("自动任务:{},发送能贷消息:{}", nextCurrent.getProcessName(), JSON.toJSONString(tresponse));
				}else {
					ResponseDto<String> tresponse = mqWDService.sendOrderProcessMq(orderMq);
					logger.debug("自动任务:{},发送微贷消息:{}", nextCurrent.getProcessName(), JSON.toJSONString(tresponse));
				}
			}
		}
		return result;
	}
	/**
	 * 执行手动过程(通过/拒绝/驳回)
	 * @param orderId
	 * @param execUserId
	 * @param currentProcess
	 * @param checkResult
	 * @param remark
	 * @param rejectProcessId 驳回过程编号
	 * @return
	 * @throws Exception
	 */
	public boolean execManualProcess(String orderId, String execUserId, NjProcessTemplateFlows currentProcess,
			EProcessResult checkResult, String remark, int rejectProcessId) throws Exception {
		boolean result = false;

		Date begin = new Date();
		Date end = new Date();
		result = updateOrderStatus(orderId, currentProcess, execUserId, checkResult, begin, end, remark,rejectProcessId);
		if (!result) {
			return result;
		}
		logger.info("订单：{},{}：{}", orderId, currentProcess.getProcessName(), checkResult.getName());
		if (checkResult.equals(EProcessResult.REFUSE)) {
			logger.info("订单:{},被操作者拒绝,流程结束", orderId);
			return true;
		}
		currentProcess.setPrecondition(checkResult.getValue());
		if (checkResult.equals(EProcessResult.AGREE)) {
			NjProcessTemplateFlows nextCurrent = processFlowsService.selectNextProcess(currentProcess, checkResult);
			if (nextCurrent == null) {
				logger.error("订单:{},当前过程:{},没有查询到下一过程", orderId, currentProcess.getProcessName());
				return true;
			}
			if (nextCurrent.getType() > 1) {
				// 自动任务,发消息队列
				OrderMq orderMq = new OrderMq(orderId, nextCurrent.getProcessId(), nextCurrent.getTemplateId());
				
				NjLoanOrder loanOrder = orderService.getOrder(orderId);
				if(loanOrder.getCompanyId() != null && !loanOrder.getCompanyId().equals(Constants.DEFAULT_COMPANY_ID)) {//如果是能贷
					ResponseDto<String> tresponse = mqNdService.sendOrderProcessMq(orderMq);
					logger.debug("自动任务:{},发送能贷消息:{}", nextCurrent.getProcessName(), JSON.toJSONString(tresponse));
				}else {
					ResponseDto<String> tresponse = mqWDService.sendOrderProcessMq(orderMq);
					logger.debug("自动任务:{},发送微贷消息:{}", nextCurrent.getProcessName(), JSON.toJSONString(tresponse));
				}
			}
		}
		return result;
	}

	@Override
	protected NjProcessOrderFlows getAfterProcessOrder(String orderId, NjProcessTemplateFlows currentProcess,
			String userId, Date begin, Date end) throws Exception {
		NjProcessOrderFlows processOrder = processFlowsService.selectOrderProcess(orderId,
				currentProcess.getProcessId());
		if (processOrder == null) {
			throw new Exception("没有查询到订单的过程信息.");
		}
		if (processOrder.getBeginTime() == null) {
			processOrder.setBeginTime(begin);
		}
		processOrder.setFinishTime(end);
		long diff = (processOrder.getFinishTime().getTime() - processOrder.getBeginTime().getTime()) / 1000;
		if (diff == 0) {
			diff = 1;
		}
		processOrder.setUserId(userId);
		processOrder.setExecTime(diff);
		processOrder.setExecTime(diff);
		processOrder.setStatus((short) 2);
		return processOrder;
	}

	/**
	 * 生成合同
	 * 
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public boolean generateContrace(String orderNo,String contractAttachId) throws Exception {
		// 根据订单号获取相关信息
		Map<String, Object> productRelate = productService.getProductByOrderNo(orderNo);
		if (null == productRelate) {
			throw new Exception("没有查询到orderNo为：" + orderNo + "相关信息");
		}
		boolean needUserConfirm = (boolean) productRelate.get("inOnlineSign");// 是否需要用户确认
		String orderId = (String) productRelate.get("orderId");// 订单id

		// 合同生成成功，执行订单、日志等更新操作
		// //更新执行流程
		// NjProcessOrderFlows processOrder=getAfterProcessOrder("SYSTEM",begin,end);
		// updateProcessStatus(processOrder);
		//插入合同附件地址信息
		NjOrderContractMapper contractMapper = dao.getMapper(NjOrderContractMapper.class);
		NjOrderContract record = new NjOrderContract();
		record.setId(UuidUtil.get32UUID());
		record.setContractName("居间合同");
		record.setContractTemplateId("0");
		record.setCreateBy("SYSTEM");
		record.setCreateDate(new Date());
		record.setOrderNo(orderNo);
		record.setUrl(contractAttachId);
		contractMapper.insertSelective(record);
		// 更新订单状态
		NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder order = orderMapper.selectByPrimaryKey(orderId);
		if (null == order) {
			throw new Exception("没有查询到orderNo为：" + orderNo + "相关信息");
		}
		Integer oldStatus = order.getStatus();
		order.setStatus(ELoanOrderStatus.CREATE_CONTRACT.getValue());
		NjLoanOrderMapperExtend extend = dao.getMapper(NjLoanOrderMapperExtend.class);
		extend.updateOrderStatusById(order);
		// 插入日志
		NjOrderUpdateLog orderLog = new NjOrderUpdateLog();
		orderLog.setUserId("SYSTEM");
		orderLog.setProcessId(EProcessInfo.USER_CONFIRM.getId());
		orderLog.setId(UuidUtil.get32UUID());
		orderLog.setOldStatus(oldStatus);
		orderLog.setOrderId(orderNo);
		orderLog.setUpdateDate(new Date());
		orderLog.setUpdateStatus(order.getStatus());
		orderLog.setUpdateReason("系统自动执行[生成合同],结果：通过");
		orderLog.setRemark("");
		NjOrderUpdateLogMapper orderLogMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
		orderLogMapper.insert(orderLog);
		logger.debug("插入日志信息" + orderLog.toString());

		// 获取当前流程
		NjProcessMapperExtend processMapperExtend = dao.getMapper(NjProcessMapperExtend.class);
		NjProcessTemplateFlows contractProcess = processMapperExtend.selectProcessTemplateByOrderProcess(orderId,
				EProcessInfo.USER_CONFIRM.getId());

		// 判断是否需要用户确认，如果需要用户确认
		if (needUserConfirm) {
			logger.info("需要用户确认，暂停流程");
//			execManualProcess(orderId, "SYSTEM", contractProcess, EProcessResult.PAUSE, "");
		} else {
			logger.info("不需要用户确认，执行下一步流程");
			execManualProcess(orderId, "SYSTEM", contractProcess, EProcessResult.AGREE, "");
		}
		return true;
	}

	/**
	 * 放款成功
	 * 
	 * @param orderNo 订单编号
	 * @param contractEffectiveTime 放款时间
	 * @return
	 * @throws Exception
	 */
	public boolean lendingSuccess(String orderNo,Long contractEffectiveTime) throws Exception {
		// 根据订单号获取相关信息
		Map<String, Object> productRelate = productService.getProductByOrderNo(orderNo);
		if (null == productRelate) {
			logger.info("没有检索到订单号为：" + orderNo + "相关订单信息");
			throw new Exception("没有检索到订单号为：" + orderNo + "相关订单信息");
		}
		if(contractEffectiveTime == null ) {
			logger.info("订单号为：" + orderNo + "放款时间为空");
			throw new Exception("放款时间不能为空");
		}
		String orderId = (String) productRelate.get("orderId");// 订单id

		// 获取当前流程
		NjProcessMapperExtend processMapperExtend = dao.getMapper(NjProcessMapperExtend.class);
		NjProcessTemplateFlows autoLoanProcess = processMapperExtend.selectProcessTemplateByOrderProcess(orderId,
				EProcessInfo.MANUAL_LOAN.getId());
		execManualProcess(orderId, "SYSTEM", autoLoanProcess, EProcessResult.AGREE, "");

		// 更新订单放款时间字段
		NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder order = orderMapper.selectByPrimaryKey(orderId);
		NjLoanOrder updateOrder = new NjLoanOrder();
		updateOrder.setId(order.getId());
		updateOrder.setMakeLoansDate(new Date(contractEffectiveTime * 1000));
		orderMapper.updateByPrimaryKeySelective(updateOrder);
		return true;
	}
}
