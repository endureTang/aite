package com.nj.model.datamodel;

import com.nj.model.generate.NjProcessTemplateFlows;

/**
 * 
 * @Name com.nj.model.datamodel.PrcessOrderDO
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年2月26日 下午2:40:33
 * @Copyright 金鼎财富
 *
 */
public class PrcessOrderDO extends NjProcessTemplateFlows{
	/**
     * 执行时间(以秒为单位)
     */
    private Long execTime;

    /**
     * 状态(0:等待执行,1:正在执行,2:执行完成)
     */
    private Short status;
    
    /**
	 * 执行时间格式化
	 */
	private String strExecTime;

	public Long getExecTime() {
		return execTime;
	}

	public void setExecTime(Long execTime) {
		this.execTime = execTime;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
    
    
}
