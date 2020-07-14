/**
 * 
 */
package com.nj.service.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.dao.extend.NjLoanOrderMapperExtend;

/**
 * 
 * @Name com.nj.service.enterprise.DBSumHalfSizeFilterService
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月19日下午5:10:04
 * @Copyright 金鼎财富
 *
 */
@Service
public class DBCalculateHalfSizeFilterService extends AbstractHalfSizeFilterService {

	@Autowired
	private NjLoanOrderMapperExtend orderMapper;

	/**
	 * 
	 * @param size
	 * @return
	 */
	public long calculateAmountBySizeAndGrade(long size, String grade) {

		return orderMapper.calculateAmountBySizeAndGrade(size, grade, ELoanOrderStatus.USER_CONFIRM.getValue());
	}
}
