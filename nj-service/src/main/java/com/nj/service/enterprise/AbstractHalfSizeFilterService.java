/**
 * 
 */
package com.nj.service.enterprise;

/**
 * 
 * @Name com.nj.service.enterprise.AbstractHalfAssetFilterService
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月19日下午4:45:05
 * @Copyright 金鼎财富
 *
 */
public abstract class AbstractHalfSizeFilterService implements SizeFilterService {

	@Override
	public long filter(long toplimit, long totalCount, String grade) {
		long resultSize = 0L;

		long low = 1L;
		long high = totalCount;
		long mid = 0L;
		long tempCount = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			tempCount = calculateAmountBySizeAndGrade(mid, grade);
			if (tempCount > toplimit) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (tempCount > toplimit) {
			resultSize = mid - 1;
		} else {
			resultSize = mid;
		}
		return resultSize;
	}

	/**
	 * @param mid
	 * @param grade
	 * @return
	 */
	protected abstract long calculateAmountBySizeAndGrade(long mid, String grade);
}
