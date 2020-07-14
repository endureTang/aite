/**
 * 
 */
package com.nj.service.enterprise;

/**
 * 
 * @Name com.nj.service.enterprise.SizeFilterContext
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月19日下午6:42:53
 * @Copyright 金鼎财富
 *
 */
public class SizeFilterContext {

	private SizeFilterService filterService;

	private String grade;

	private long toplimit;

	private long totalCount;

	public SizeFilterContext() {

	}

	public SizeFilterContext(SizeFilterService filterService, String grade, long toplimit, long totalCount) {
		this.filterService = filterService;
		this.grade = grade;
		this.toplimit = toplimit;
		this.totalCount = totalCount;
	}

	public long getBestSize() {
		return filterService.filter(toplimit, totalCount, grade);
	}

	public SizeFilterService getFilterService() {
		return filterService;
	}

	public void setFilterService(SizeFilterService filterService) {
		this.filterService = filterService;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getToplimit() {
		return toplimit;
	}

	public void setToplimit(long toplimit) {
		this.toplimit = toplimit;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

}
