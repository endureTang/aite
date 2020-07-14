/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.nj.enterprise.controller.account;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.common.Constants;
import com.nj.core.base.common.api.ResponseMsg;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.service.base.system.LoginService;
import com.nj.service.enterprise.EnterpriseService;
import com.nj.service.enterprise.NjUserService;
import com.nj.service.itf.TfcfHttpService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Resource(name = "enterpriseService")
	private EnterpriseService enterpriseService;

	@Resource(name = "loginService")
	private LoginService loginService;

	@Resource(name = "njUserService")
	private NjUserService njUserService;

	@Resource(name = "tfcfHttpService")
	private TfcfHttpService tfcfHttpService;

	@RequestMapping(value = "/getSmsCode")
	public PageData getSmsCode(Page page, HttpSession session) throws Exception {

		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("userId", session.getAttribute(EntpriseConstant.SessionKey.USER_ID));

		String result = tfcfHttpService.doHttpPostForTfcf("", "", pd, Constants.TFCF.MEMBER_SMS);

		if (StringUtils.isNotEmptyAndNull(result)) {
			// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
			ResponseMsg tfcfResp1 = JSONObject.parseObject(result, ResponseMsg.class);
			if (tfcfResp1 != null) {
				if (tfcfResp1.getResultStatus() == 0) {// 返回成功
					pd.put("status", EntpriseConstant.RestData.SUCCESS);
					pd.put("msg", "發送成功");
				} else {
					pd.put("status", EntpriseConstant.RestData.FAILURE);
					pd.put("msg", tfcfResp1.getMsg());
				}
			}
		}
		return pd;
	}

	@RequestMapping(value = "/reg")
	public PageData reg(Page page, HttpSession session) throws Exception {

		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("userId", session.getAttribute(EntpriseConstant.SessionKey.USER_ID));

		String result = tfcfHttpService.doHttpPostForTfcf("", "", pd, Constants.TFCF.MEMBER_REG);

		if (StringUtils.isNotEmptyAndNull(result)) {
			// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
			ResponseMsg tfcfResp1 = JSONObject.parseObject(result, ResponseMsg.class);
			if (tfcfResp1 != null) {
				if (tfcfResp1.getResultStatus() == 0) {// 返回成功
					pd.put("status", EntpriseConstant.RestData.SUCCESS);
					pd.put("msg", "發送成功");
				} else {
					pd.put("status", EntpriseConstant.RestData.FAILURE);
					pd.put("msg", tfcfResp1.getMsg());
				}
			}
		}
		return pd;
	}

	@RequestMapping(value = "/getOpenSms")
	public PageData getOpenSms(Page page, HttpSession session) throws Exception {

		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("userId", session.getAttribute(EntpriseConstant.SessionKey.USER_ID));

		String result = tfcfHttpService.doHttpPostForTfcf("", "", pd, Constants.TFCF.MEMBER_OPEN_SMS);

		if (StringUtils.isNotEmptyAndNull(result)) {
			// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
			ResponseMsg tfcfResp1 = JSONObject.parseObject(result, ResponseMsg.class);
			if (tfcfResp1 != null) {
				if (tfcfResp1.getResultStatus() == 0) {// 返回成功
					pd.put("status", EntpriseConstant.RestData.SUCCESS);
					pd.put("msg", "發送成功");
				} else {
					pd.put("status", EntpriseConstant.RestData.FAILURE);
					pd.put("msg", tfcfResp1.getMsg());
				}
			}
		}
		return pd;
	}

	@RequestMapping(value = "/open")
	public PageData open(Page page, HttpSession session) throws Exception {

		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("userId", session.getAttribute(EntpriseConstant.SessionKey.USER_ID));

		String result = tfcfHttpService.doHttpPostForTfcf("", "", pd, Constants.TFCF.MEMBER_OPEN);

		if (StringUtils.isNotEmptyAndNull(result)) {
			// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
			ResponseMsg tfcfResp1 = JSONObject.parseObject(result, ResponseMsg.class);
			if (tfcfResp1 != null) {
				if (tfcfResp1.getResultStatus() == 0) {// 返回成功
					pd.put("status", EntpriseConstant.RestData.SUCCESS);
					pd.put("msg", "發送成功");
				} else {
					pd.put("status", EntpriseConstant.RestData.FAILURE);
					pd.put("msg", tfcfResp1.getMsg());
				}
			}
		}
		return pd;
	}

	/*
	 * 获取绑定验证码
	 */

	@RequestMapping(value = "/getOpenSmsCode")
	@ResponseBody
	public PageData getOpenSmsCode(Page page, HttpSession session) throws Exception {

		PageData pd = new PageData();
		pd = this.getPageData();

		String result = tfcfHttpService.doHttpPostForTfcf("", "", pd, Constants.TFCF.GET_MEMBER_SMS);

		if (StringUtils.isNotEmptyAndNull(result)) {
			// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
			ResponseMsg tfcfResp1 = JSONObject.parseObject(result, ResponseMsg.class);
			if (tfcfResp1 != null) {
				if (tfcfResp1.getResultStatus() == 0) {// 返回成功
					pd.put("status", EntpriseConstant.RestData.SUCCESS);
					pd.put("msg", "发送成功");
				} else {
					pd.put("status", EntpriseConstant.RestData.FAILURE);
					pd.put("msg", tfcfResp1.getMsg());
				}
			}
		}
		return pd;
	}
	/*
	 * 绑定
	 */

	@RequestMapping(value = "/registerOpenId")
	public PageData registerOpenId(Page page, HttpSession session) throws Exception {

		PageData pd = new PageData();
		pd = this.getPageData();

		String result = tfcfHttpService.doHttpPostForTfcf("", "", pd, Constants.TFCF.VERIFY_MEMBER_SMS);

		if (StringUtils.isNotEmptyAndNull(result)) {
			// 根据天府财富返回的json,生成对应的object,天府财富的resultstatus:0,成功；-1，-2失败
			ResponseMsg tfcfResp1 = JSONObject.parseObject(result, ResponseMsg.class);
			if (tfcfResp1 != null) {
				if (tfcfResp1.getResultStatus() == 0) {// 返回成功
					pd.put("status", EntpriseConstant.RestData.SUCCESS);
					pd.put("msg", "發送成功");
					// 成功后绑定企业与业务账户关系
				} else {
					pd.put("status", EntpriseConstant.RestData.FAILURE);
					pd.put("msg", tfcfResp1.getMsg());
				}
			}
		}
		return pd;
	}
}
