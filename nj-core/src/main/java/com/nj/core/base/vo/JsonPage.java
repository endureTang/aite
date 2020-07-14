/**
 * 
 */
package com.nj.core.base.vo;

import java.math.BigDecimal;

/**
 * 
 * @Name com.nj.core.base.vo.JsonPage
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月21日下午2:14:16
 * @Copyright 金鼎财富
 *
 */
public class JsonPage extends JsonMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6652618725736119341L;

	private long recordsTotal;

	private long recordsFiltered;

	private BigDecimal recordsAmount;

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public BigDecimal getRecordsAmount() {
		return recordsAmount;
	}

	public void setRecordsAmount(BigDecimal recordsAmount) {
		this.recordsAmount = recordsAmount;
	}

}
