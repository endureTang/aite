package com.nj.service.process;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProcessResult;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjOrderUpdateLogMapper;
import com.nj.dao.NjProcessOrderFlowsMapper;
import com.nj.dao.NjProcessTemplateFlowsMapper;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjOrderUpdateLog;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.model.generate.NjProcessOrderFlowsExample;
import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.model.generate.NjUserInfo;

import ch.qos.logback.classic.Logger;

/**
 * @Name com.nj.service.process.BaseAutoProcess
 * @Description
 * @Author bruce
 * @Version 2018年2月14日 上午11:21:04
 * @Copyright 金鼎财富
 */
@Service("baseAutoProcess")
public abstract class BaseAutoProcess implements IAutoProcess {

    protected final Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    @Resource(name = "BaseDao")
    protected BaseDao dao;

    @Resource(name = "njProcessFlowsService")
    protected ProcessFlowsService processFlowsService;


    @Transactional(rollbackFor = {Throwable.class}, readOnly = false, propagation = Propagation.REQUIRED)
    public EProcessResult execute(String orderId, NjProcessTemplateFlows currentProcess) {
        EProcessResult result = EProcessResult.PAUSE;
        try {
            Date begin = new Date();
            result = execAutoProcess(orderId, currentProcess);
            if (result.equals(EProcessResult.PAUSE)) {
                return result;
            }
            Date end = new Date();

            updateOrderStatus(orderId, currentProcess, "SYSTEM", result, begin, end,
                    "系统自动执行:" + currentProcess.getProcessName() + " 结果:" + result.getRemark(), 0);
        } catch (Exception ex) {
            logger.error("执行自动任务：{},出现错误： {}", currentProcess.getProcessName(), ex);
            throw new RuntimeException();
        }
        return result;
    }

    /**
     * 执行自动任务
     *
     * @param orderId
     * @param currentProcess
     * @return
     */
    protected EProcessResult execAutoProcess(String orderId, NjProcessTemplateFlows currentProcess) {
        return null;
    }

    /**
     * 更新订单状态
     *
     * @throws Exception
     */
    public boolean updateOrderStatus(String orderId, NjProcessTemplateFlows currentProcess, String userId,
                                        EProcessResult epResult, Date begin, Date end, String remark, int rejectProcessId) throws Exception {
        boolean result = false;
        NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);
        logger.info("====orderId:"+orderId+"processId:"+currentProcess.getProcessId()+",orderStatus:"+currentProcess.getExecAgreeStatus()+",value:"+epResult.getValue());
        NjLoanOrder order = orderMapper.selectByPrimaryKey(orderId);
        int orderStatus = order.getStatus();
        int oldOrderStatus = order.getStatus();
        if (epResult == EProcessResult.AGREE || epResult == EProcessResult.REFUSE || epResult == EProcessResult.REJECT
                || epResult == EProcessResult.SKIPCHECK) {
            // 更新订单过程信息
            NjProcessOrderFlows processOrder = getAfterProcessOrder(orderId, currentProcess, userId, begin, end);
            updateProcessStatus(orderId, currentProcess, processOrder);
            if (epResult.getValue() == EProcessResult.AGREE.getValue()) {
                orderStatus = currentProcess.getExecAgreeStatus();
            } else if (epResult.getValue() == EProcessResult.REFUSE.getValue()) {
                orderStatus = ELoanOrderStatus.PLATFORM_REFUSE.getValue();
            } else if (epResult.getValue() == EProcessResult.REJECT.getValue()) {
                Integer rejectProcessExecOrder = null;
                if (rejectProcessId == 0) {
                    //操作者驳回,默认退回到上一个流程
                    /*previousCurrent=processFlowsService.selectPreviousProcess(currentProcess);
                    if(previousCurrent.getType()==2) {
						logger.info("操作者驳回,没有设置驳回过程，上一个过程为自动过程,不能为默认驳回过程,请手动配置流程"); 
						return false;
					}*/
                    // 默认驳回到资料修改
                    orderStatus = ELoanOrderStatus.FIRST_REJECT.getValue();
                    //操作者驳回，重置手动过程
                    rejectProcessExecOrder = 4;
                } else {
                    //操作者指定驳回流程点
                    NjProcessTemplateFlows pointProcess = processFlowsService.selectProcessByTemplateId(currentProcess.getTemplateId(), rejectProcessId, orderId, null);
                    if (pointProcess == null) {
                        logger.error("未找到指定的驳回过程!");
                        return false;
                    } else {
                        rejectProcessExecOrder = pointProcess.getExecOrders();
                        NjProcessTemplateFlows previousCurrent = processFlowsService.selectPreviousProcess(pointProcess);
                        orderStatus = previousCurrent.getExecAgreeStatus();
                    }
                }

                // 修改手动过程状态(手动过程重置)
                resetManualProcess(orderId, rejectProcessExecOrder);
            } else if (epResult.getValue() == EProcessResult.SKIPCHECK.getValue()) {
                // 跳过人工审核
                orderStatus = ELoanOrderStatus.LAST_CHECK_SUCCESS.getValue();
            }
            if (currentProcess.getType() == 3 && epResult.getResultStatus() > 0) {
                //如果是过程为判断，则订单状态使用判断过程返回的状态
                orderStatus = epResult.getResultStatus();
            }
            order.setStatus(orderStatus);
            updateOrderStatus(order);
            result = true;
        } else {
            logger.error("执行任务：{},过程中断.", currentProcess.getProcessName());
        }
        logger.info("====orderId:"+orderId+"processId:"+currentProcess.getProcessId()+",orderStatus:"+orderStatus+",value:"+epResult.getValue());
        saveOrderLog(orderId, currentProcess, epResult, order.getOrderNo(), oldOrderStatus, orderStatus, userId,
                remark);
        return result;
    }

    /**
     * 获取执行后的订单流程对象
     *
     * @param begin
     * @param end
     * @return
     */
    protected NjProcessOrderFlows getAfterProcessOrder(String orderId, NjProcessTemplateFlows currentProcess,
                                                       String userId, Date begin, Date end) throws Exception {
        long diff = (end.getTime() - begin.getTime()) / 1000;
        if (diff == 0) {
            diff = 1;
        }
        NjProcessOrderFlows processOrder = new NjProcessOrderFlows();
        processOrder.setBeginTime(begin);
        processOrder.setFinishTime(end);
        processOrder.setExecTime(diff);
        processOrder.setOrderId(orderId);
        processOrder.setProcessId(currentProcess.getProcessId());
        processOrder.setUserId("SYSTEM");
        processOrder.setStatus((short) 2);
        return processOrder;
    }

    protected void updateProcessStatus(String orderId, NjProcessTemplateFlows currentProcess,
                                       NjProcessOrderFlows processOrder) throws Exception {
        NjProcessOrderFlowsMapper processOrderMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
        NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andProcessIdEqualTo(currentProcess.getProcessId()).andExecOrdersEqualTo(currentProcess.getExecOrders());
        processOrderMapper.updateByExampleSelective(processOrder, example);
    }

    public void updateOrderStatus(NjLoanOrder order) throws Exception {
        NjLoanOrderMapperExtend orderMapper = dao.getMapper(NjLoanOrderMapperExtend.class);
        orderMapper.updateOrderStatusById(order);
    }

    protected void saveOrderLog(String orderId, NjProcessTemplateFlows currentProcess, EProcessResult erResult,
                                String orderNo, int oldStatus, int newStatus, String userId, String remark) {

        String updateReason = "";
        NjOrderUpdateLog orderLog = new NjOrderUpdateLog();
        if (userId.equals("")) {
            userId = "后台程序";
        }
        if (currentProcess.getType() == 1) {
        	NjUserInfo info = null;
        	try {
				NjUserInfoMapper infoMapper = dao.getMapper(NjUserInfoMapper.class);
				info = infoMapper.selectByPrimaryKey(userId);
			} catch (Exception e) {
				logger.error("没有检索到用户id为：{}的用户信息",userId);
			}
//            updateReason = "操作人员手动执行[" + currentProcess.getProcessName() + "],结果:" + erResult.getName();
            updateReason = info == null ?"操作人员":info.getUserName()+"手动执行[" + currentProcess.getProcessName() + "],结果:" + erResult.getName();
        } else if (currentProcess.getType() == 2 || currentProcess.getType() == 3) {
            updateReason = "系统自动执行[" + currentProcess.getProcessName() + "],结果：" + erResult.getName();
        }
        orderLog.setUserId(userId);
        orderLog.setProcessId(currentProcess.getProcessId());
        orderLog.setId(UuidUtil.get32UUID());
        orderLog.setOldStatus(oldStatus);
        orderLog.setOrderId(orderNo);
        orderLog.setUpdateDate(new Date());
        orderLog.setUpdateStatus(newStatus);

        orderLog.setUpdateReason(updateReason);
        orderLog.setRemark(remark);
        try {
        	Thread.sleep(1000);   //若该环节处理很快时，上一环节 保存日志的时间和当前环节保存日志的时间相同（数据库中精确到秒），因此，睡 一秒再保存，才能区分同上个环节的执行顺序
            NjOrderUpdateLogMapper orderLogMapper = dao.getMapper(NjOrderUpdateLogMapper.class);
            orderLogMapper.insert(orderLog);
        } catch (Exception e) {
            logger.error("保存日志异常");
        }

    }

    /**
     * 重置手动过程
     *
     * @param orderId
     * @param rejectProcessExecOrder
     * @throws Exception
     */
    private void resetManualProcess(String orderId, int rejectProcessExecOrder) throws Exception {
        NjProcessOrderFlowsMapper processOrderFlowsMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
        NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andExecOrdersGreaterThanOrEqualTo(rejectProcessExecOrder);
        List<NjProcessOrderFlows> list = processOrderFlowsMapper.selectByExample(example);
        for (NjProcessOrderFlows orderFlow : list) {
            orderFlow.setBeginTime(null);
            orderFlow.setFinishTime(null);
            orderFlow.setStatus((short) 0);
            processOrderFlowsMapper.updateByPrimaryKey(orderFlow);
        }
    }

    public NjProcessTemplateFlows getNextProcess(NjProcessTemplateFlows currentProcess, EProcessResult result) {
        NjProcessTemplateFlows nextProcess = null;
        try {
            currentProcess.setPrecondition(EProcessResult.AGREE.getValue());
            nextProcess = processFlowsService.selectNextProcess(currentProcess, result);
        } catch (Exception ex) {
            logger.error("查询下一过程出现错误：{}", ex.getMessage());
        }
        return nextProcess;
    }
}
