/**
 * 
 */
package com.nj.core.base.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.StringUtils;

import com.nj.core.base.entity.NjIdEntity;
import com.nj.core.base.mapper.BaseMapper;

/**
 * 
 * @param <T>
 * @param <R>
 * @Name com.nj.core.base.controller.StringToEntityConverterFactory
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月21日下午2:28:09
 * @Copyright 金鼎财富
 *
 */
public class StringToEntityConverterFactory implements ConverterFactory<String, NjIdEntity>, BeanFactoryAware {

	private BeanFactory beanFactory;

	@Override
	public <T extends NjIdEntity> Converter<String, T> getConverter(Class<T> targetType) {
		return new StringToEntityConverter<T>(targetType);
	}

	private final class StringToEntityConverter<T extends Object> implements Converter<String, T> {

		private Class<T> targetType;

		public StringToEntityConverter(Class<T> targetType) {
			this.targetType = targetType;
		}

		public T convert(String source) {
			@SuppressWarnings("unchecked")
			BaseMapper<T, ?> mapper = beanFactory
					.getBean(StringUtils.uncapitalize(targetType.getSimpleName()) + "Mapper", BaseMapper.class);
			return (T) mapper.selectByPrimaryKey(source);
		}
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
