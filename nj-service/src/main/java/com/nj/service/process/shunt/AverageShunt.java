package com.nj.service.process.shunt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nj.core.base.enums.EProcessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nj.core.base.util.Const;
import com.nj.core.base.util.DateUtil;
import com.nj.dao.extend.NjProcessMapperExtend;
import com.nj.model.datamodel.ExamineUserDO;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.service.process.IAutoProcess;

import javax.annotation.Resource;

/**
 * @Name com.nj.service.process.shunt.AverageShunt
 * @Description 平均分配
 * @Author bruce
 * @Version 2018年3月23日 下午12:19:38
 * @Copyright 金鼎财富
 */
@Service("averageShunt")
public class AverageShunt extends BaseShunt implements IAutoProcess {
    @Resource
    NjProcessMapperExtend njProcessMapperExtend;

    /**
     * 统计派单情况
     *
     * @return
     */
    @Override
    protected List<ExamineUserDO> statShunt(String orderId) {
        String today = DateUtil.getDay() + " 00:00:00";
        NjLoanOrder order = orderMapper.selectByPrimaryKey(orderId);
        return njProcessMapperExtend.statShunt(today, order.getProductId());
    }

    /**
     * 订单流程分配
     *
     * @return
     * @throws Exception
     */
    @Override
    protected List<NjProcessOrderFlows> allotProcess(String orderId,List<NjProcessOrderFlows> processList, List<ExamineUserDO> userList) {
    	if (processList.size() > userList.size()) {
            logger.error("平均分单出现错误：{}","审批人员人数,少于手动过程数量,自动分单失败,进行手动分单");
            return null;
        }
        List<NjProcessOrderFlows> processAllowList = new ArrayList<NjProcessOrderFlows>();
        int i = 0;
        for (NjProcessOrderFlows process : processList) {
            if (Arrays.asList(Const.MANUAL_CHECK).contains(process.getProcessId())) {
                NjProcessOrderFlows processAllow = new NjProcessOrderFlows();
                processAllow.setOrderId(orderId);
                processAllow.setProcessId(process.getProcessId());
                processAllow.setUserId(userList.get(i).getId());
                processAllowList.add(processAllow);
                i++;
            }
        }
        return processAllowList;
    }
    
    public static void main(String[] args) {
    	 String today = DateUtil.getDay() + " 00:00:00";
    	 System.out.println(today);
	}
}
