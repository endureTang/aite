package com.nj.service.process;

import com.nj.core.base.enums.EProcessResult;
import com.nj.model.generate.NjProcessTemplateFlows;

/**
 * 
 * @Name com.nj.service.process.IAutoShunt
 * @Description 自动分单接口
 * 
 * @Author bruce
 * @Version 2018年2月8日 下午3:42:24
 * @Copyright 金鼎财富
 *
 */
public interface IAutoProcess {
	/**
	 * 执行过程
	 * @param orderId
	 * @param currentProcess
	 * @return
	 */
	EProcessResult execute(String orderId,NjProcessTemplateFlows currentProcess);
	/**
	 * 获取下一步过程
	 * @return
	 */
	NjProcessTemplateFlows getNextProcess(NjProcessTemplateFlows currentProcess,EProcessResult result);
}
