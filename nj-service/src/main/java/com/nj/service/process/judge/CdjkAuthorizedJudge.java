package com.nj.service.process.judge;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nj.core.base.common.AddressConstants;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProcessResult;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.service.process.BaseAutoProcess;
import com.nj.service.process.IAutoProcess;
import com.nj.service.process.ProcessFlowsService;

/**
 * 
 * @Name com.nj.service.process.judge.CdjkAmountJudge
 * @Description 有权限审批判断
 * 
 * @Author bruce
 * @Version 2018年7月5日 下午2:28:37
 * @Copyright 金鼎财富
 *
 * 在某些流程环节，小贷公司的流程并不会完全按照流程模版来执行，此时，加入了有权审批环节，通过该环节去控制订单下一个状态的值，并不会按照流程模版的值来变化。
 */
@Service("cdjkAuthorizedJudge")
public class CdjkAuthorizedJudge extends BaseAutoProcess implements IAutoProcess{
	
	Logger log = LoggerFactory.getLogger(CdjkAuthorizedJudge.class);
	
	@Resource(name = "njProcessFlowsService")
	protected ProcessFlowsService processFlowsService;

	
	@Override
	protected EProcessResult execAutoProcess(String orderId, NjProcessTemplateFlows currentProcess) {
		EProcessResult result = null;
		
		log.info("orderId={},有权限审批判断:currentProcess的id=:",orderId,currentProcess.getId());
		try {
			NjLoanOrderMapper njLoanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
			NjLoanOrder loanOrder = njLoanOrderMapper.selectByPrimaryKey(orderId);
			
			NjProcessTemplateFlows nextProcess = processFlowsService.selectNextProcess(currentProcess, EProcessResult.AGREE);
			log.info("orderId={},nextProcess的id={}",orderId,nextProcess.getId());
			
			Long processCount = processFlowsService.selectProcessCountByOrderId(orderId);
			log.info("processCount=" + processCount);
			
			//如果流程数量等于默认数量，则走大于100w流程
			if(processCount.intValue() == AddressConstants.CdjkProcessNumber.intValue()) {
				//风控经理审核->总监->董事长
				if(nextProcess.getProcessId()>30&&nextProcess.getProcessId()<40) {
					//放款流程
					loanOrder.setStatus(ELoanOrderStatus.THIRD_CHECK_LENDING.getValue());
				}else {
					//审批流程
					loanOrder.setStatus(ELoanOrderStatus.REVIEW_CHECK_SUCCESS.getValue());
				}
			}else {
				//等待有权审批人审核
				if(nextProcess.getProcessId()>30&&nextProcess.getProcessId()<40) {
					//放款流程
					loanOrder.setStatus(ELoanOrderStatus.FOURTH_CHECK_LENDING.getValue());
				}else {
					//审批流程
					loanOrder.setStatus(ELoanOrderStatus.DIRECTOR_REVIEW_CHECK_SUCCESS.getValue());
				}
			}
			result = EProcessResult.AGREE;
			result.setResultStatus(loanOrder.getStatus());
		}catch(Exception ex) {
			logger.error("出现错误：{}",ex);
			result = EProcessResult.PAUSE;
		}
		return result;
	}
	
	@Override
	public NjProcessTemplateFlows getNextProcess(NjProcessTemplateFlows currentProcess, EProcessResult result) {
		NjProcessTemplateFlows nextProcess = null;
		if(currentProcess.getProcessId()>30&&currentProcess.getProcessId()<40) {
			//放款流程
			
		}else {
			//审批流程
		}
		return nextProcess;
		
	}
	
}
