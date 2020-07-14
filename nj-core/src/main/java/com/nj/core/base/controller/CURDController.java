/**
 * 
 */
package com.nj.core.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.core.base.entity.NjIdEntity;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.mapper.BaseMapper;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.base.vo.JsonMessage;
import com.nj.core.base.vo.JsonPage;

/**
 * 
 * @Name com.nj.core.base.controller.CURDController
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月21日下午1:46:42
 * @Copyright 金鼎财富
 *
 */
public abstract class CURDController<T extends NjIdEntity, E> {

	@Autowired
	protected BaseMapper<T, E> mapper;
	
	@ResponseBody
	public JsonMessage create(T entity) {
		JsonMessage msg = new JsonMessage();
		beforeCreate(entity);
		entity.setId(UuidUtil.get32UUID());
		mapper.insert(entity);
		afterCreate(msg);
		return msg;
	}

	
	@ResponseBody
	public JsonMessage update(@ModelAttribute("id") T entity) {
		JsonMessage msg = new JsonMessage();
		beforeUpdate(entity);
		mapper.updateByPrimaryKey(entity);
		afterUpdate(msg);
		return msg;
	}
	
	@ResponseBody
	public JsonMessage get(@PathVariable String id) {
		JsonMessage msg = new JsonMessage();
		NjIdEntity entity = mapper.selectByPrimaryKey(id);
		msg.setData(entity);
		return msg;
	}

	@PostMapping("/list")
	@ResponseBody
	public JsonPage list(HttpServletRequest request) {
		JsonPage page = new JsonPage();
		// 查询数据列表
		PageData pd = new PageData(request);
		PageHelper.startPage(pd.getInteger("start"), pd.getInteger("length"));
		E example = parseFrom(request);
		PageInfo<T> info = new PageInfo<>(mapper.selectByExample(example));

		page.setRecordsTotal(info.getTotal());
		page.setRecordsFiltered(info.getTotal());
		page.setData(info.getList());

		afterRetrieve(page);

		return page;
	}

	@ResponseBody
	public JsonMessage delete(@PathVariable String id) {
		JsonMessage msg = new JsonMessage();
		beforeDelete(id);
		mapper.deleteByPrimaryKey(id);
		afterDelete(msg);
		return msg;
	}

	/**
	 * @param request
	 * @return
	 */
	protected abstract E parseFrom(HttpServletRequest request);

	/**
	 * @param entity
	 * @return
	 */
	protected void beforeCreate(T entity) {

	}

	/**
	 * @param entity
	 */
	protected void beforeUpdate(T entity) {

	}

	/**
	 * @param id
	 */
	protected void beforeDelete(String id) {

	}

	/**
	 * @param page
	 */
	protected void afterRetrieve(JsonPage page) {

	}

	/**
	 * @param msg
	 */
	private void afterUpdate(JsonMessage msg) {

	}

	/**
	 * @param msg
	 */
	protected void afterDelete(JsonMessage msg) {

	}

	/**
	 * @param msg
	 */
	protected void afterCreate(JsonMessage msg) {

	}
}
