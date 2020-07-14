/**
 * 
 */
package com.nj.service.enterprise;

/**
 * 
 * @Name com.nj.service.enterprise.AssetFilterService
 * @Description 数据条数筛选服务
 * 
 * @Author Frank
 * @Version 2018年3月19日下午4:33:37
 * @Copyright 金鼎财富
 *
 */
public interface SizeFilterService {

	/**
	 * e.g:A资产库存金额100W，数据10W条，筛选比例80%，需要筛选出80W，假如前5W条记录的金额相加最接近80W，则返回5W
	 * 
	 * @param toplimit 需要筛选出的金额 e.g:80W
	 * @param totalCount 记录总条数 e.g:10W
	 * @param grade 记录总条数 e.g:A资产
	 * @return 最接近需要筛选出的金额数据条数 e.g:5W
	 */
	long filter(long toplimit, long totalCount, String grade);
}
