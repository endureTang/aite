package com.nj.service.process.shunt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nj.core.base.enums.EProcessResult;
import com.nj.core.base.util.Const;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjProcessOrderFlowsMapper;
import com.nj.model.datamodel.ExamineUserDO;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.model.generate.NjProcessOrderFlowsExample;
import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.service.process.BaseAutoProcess;
import com.nj.service.process.IAutoProcess;

/**
 * @Name com.nj.service.process.shunt.BaseShunt
 * @Description 分单基础服务类
 * @Author bruce
 * @Version 2018年2月8日 下午3:49:19
 * @Copyright 金鼎财富
 */
@Service("baseShunt")
public abstract class BaseShunt extends BaseAutoProcess implements IAutoProcess {
	/**
	 * 检查重复派单
	 */
	protected boolean isCheckRepeat=true;
    @Resource
    protected NjLoanOrderMapper orderMapper;

    /**
     * 统计审批人员派单件数
     *
     * @return
     */
    protected abstract List<ExamineUserDO> statShunt(String orderId);

    /**
     * 订单流程分配
     *
     * @return
     */
    protected List<NjProcessOrderFlows> allotProcess(String orderId,List<NjProcessOrderFlows> processList,List<ExamineUserDO> userList){
    	List<NjProcessOrderFlows> processAllowList = new ArrayList<NjProcessOrderFlows>();
        int i = 0;
        if(processList.size()!=userList.size()) {
        	logger.error("分单出现错误：{}","审批人员人数不等于过程数量,自动分单失败,进行手动分单");
            return null;
        }
        for (NjProcessOrderFlows process : processList) {
        	NjProcessOrderFlows processAllow = new NjProcessOrderFlows();
            processAllow.setOrderId(orderId);
            processAllow.setProcessId(process.getProcessId());
            processAllow.setUserId(userList.get(i).getId());
            processAllowList.add(processAllow);
            i++;
        }
        return processAllowList;
    }

    /**
     * 检查订单授权情况
     *
     * @return false:不允许，有重复   true：允许，不重复
     */
    protected boolean checkAllow(List<NjProcessOrderFlows> processAllowList) {
    	if(!isCheckRepeat)
    		return true;
        Set<String> set = new HashSet<String>();
        for (NjProcessOrderFlows proAllow : processAllowList) {
            set.add(proAllow.getUserId());
        }
        if (set.size() != processAllowList.size()) {
            logger.error("检查订单分单出现错误：{}","分配任务时,出现重复用户.");
            return false;// 有重复
        } else {
            return true;// 不重复
        }
    }

    /**
     * 保存派单结果
     *
     * @param processAllowList
     */
    protected void saveAllow(List<NjProcessOrderFlows> processAllowList) throws Exception {
        NjProcessOrderFlowsMapper processAllowMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
        processAllowList.forEach(processAllow -> {
            NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
            example.createCriteria().andOrderIdEqualTo(processAllow.getOrderId()).andProcessIdEqualTo(processAllow.getProcessId());
            processAllowMapper.updateByExampleSelective(processAllow, example);
        });
    }

    /**
     * 查询订单流程
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    protected List<NjProcessOrderFlows> selectProcessByOrder(String orderId) throws Exception {
        NjProcessOrderFlowsMapper processOrderMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
        NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
        example.createCriteria().andOrderIdEqualTo(orderId).andProcessIdIn(Arrays.asList(Const.MANUAL_CHECK));
        example.setOrderByClause(" exec_orders");
        return processOrderMapper.selectByExample(example);
    }

    @Override
    protected EProcessResult execAutoProcess(String orderId,NjProcessTemplateFlows currentProcess) {
        EProcessResult epresult = EProcessResult.PAUSE;
        try {
            List<NjProcessOrderFlows> processList = selectProcessByOrder(orderId);
            if (processList == null || processList.size() == 0) {
                logger.error("没有查询到需要分单的过程");
                return EProcessResult.PAUSE;
            }
            List<ExamineUserDO> userList = statShunt(orderId);
            if(userList==null||userList.size()==0) {
            	logger.error("没有查询到授权分单用户");
            	return EProcessResult.PAUSE;
            }
            List<NjProcessOrderFlows> processAllowList = allotProcess(orderId,processList, userList);
            if (processAllowList == null) {
                return EProcessResult.PAUSE;
            }
            boolean result = checkAllow(processAllowList);
            if (!result) {
                // 自动分单失败,手动分单
                manualShunt(orderId);
            } else {
                // 自动分单成功
                saveAllow(processAllowList);
                epresult = EProcessResult.AGREE;
            }
            logger.info("订单：{},自动分单成功!", orderId);
        } catch (Exception ex) {
            logger.error("自动分单出现错误：{}", ex);
        }
        return epresult;
    }

    /**
     * 手动分单
     *
     * @param orderId
     */
    protected void manualShunt(String orderId) {

    }
}
