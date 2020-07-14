/**
 * 
 */
package com.nj.core.base.controller;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import com.nj.core.base.util.Constants;

/**
 * 
 * @Name com.nj.core.base.controller.WebMvcErrorAttributes
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月22日上午10:28:34
 * @Copyright 金鼎财富
 *
 */
public class WebMvcErrorAttributes extends DefaultErrorAttributes {

	public static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
		logger.error("{}", errorAttributes);

		HttpServletRequest request = (HttpServletRequest) requestAttributes
				.resolveReference(RequestAttributes.REFERENCE_REQUEST);
		if (isAjaxRequest(request)) {
			requestAttributes.setAttribute("javax.servlet.error.status_code", 200, RequestAttributes.SCOPE_REQUEST);
			errorAttributes = new HashMap<String, Object>();
			errorAttributes.put(Constants.Datas.STATUS, 1000);
			if (getError(requestAttributes) != null) {
				errorAttributes.put(Constants.Datas.MSG, getError(requestAttributes).getMessage());
			}
		}
		return errorAttributes;
	}

	private boolean isAjaxRequest(HttpServletRequest request) {
		String requestedWith = request.getHeader("X-Requested-With");
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}
}
