/**
 * 
 */
package com.nj.service.enterprise;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.model.generate.NjLoanOrder;

import javax.annotation.Resource;

/**
 * 
 * @Name com.nj.service.enterprise.MemoryCalculateSizeFilterService
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月23日下午3:20:13
 * @Copyright 金鼎财富
 *
 */
@Service
@Primary
public class MemoryCalculateSizeFilterService implements SizeFilterService {

	@Resource
	private NjLoanOrderMapperExtend orderMapperExtend;

	@Override
	public long filter(long toplimit, long totalCount, String grade) {
		long resultSize = 0L;
		List<NjLoanOrder> orders = orderMapperExtend.selectByGradeStatusSize(totalCount, grade,
				ELoanOrderStatus.USER_CONFIRM.getValue());
		BigDecimal tempCount = BigDecimal.ZERO;
		for (int i = 0; i < orders.size(); i++) {
			tempCount = tempCount.add(orders.get(i).getAuditAmount());
			if (tempCount.longValue() >= toplimit) {
				resultSize = i + 1;
				break;
			}
		}
		if (tempCount.longValue() < toplimit) {
			resultSize = totalCount;
		}
		return resultSize;
	}

}
