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

package com.nj.enterprise.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.jd.core.util.StringUtil;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProductTemplate;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.RegExpUtil;
import com.nj.core.fee.constant.BusinessFeeAndAlgorithmRelation;
import com.nj.core.fee.constant.EBusinessFee;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.utils.excel.ExcelReadUtil;
import com.nj.core.utils.excel.ExportFormatConstant;
import com.nj.core.utils.excel.ExportUtil;
import com.nj.core.utils.excel.FreeExportParam;
import com.nj.enterprise.utils.Util;
import com.nj.model.datamodel.ExportOrderModel;
import com.nj.model.datamodel.ExportOverdueDto;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateExample;
import com.nj.model.generate.NjCoporateProductTemp;
import com.nj.model.generate.NjCoporateProductTempExample;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjLoanOrderCheckRecord;
import com.nj.model.generate.SysDict;
import com.nj.mongoModel.TdReportData;
import com.nj.mongoModel.after.RepayPlanMainNew;
import com.nj.mongoModel.after.RepayPlanNew;
import com.nj.service.base.system.DictService;
import com.nj.service.base.system.UserService;
import com.nj.service.enterprise.AfterLoanOrderService;
import com.nj.service.enterprise.ChannelService;
import com.nj.service.enterprise.CoporateService;
import com.nj.service.enterprise.LoanService;
import com.nj.service.enterprise.OrderService;
import com.nj.service.enterprise.ProductService;
import com.nj.service.itf.AppUserService;
import com.nj.service.process.ProcessFlowsService;
import com.nj.service.remoteing.RepayPlanNewService;
import com.nj.service.remoteing.TdReportService;
import com.timevale.tgtext.text.pdf.ca;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**

 * @Description:
 *
 * @Date 2015年5月9日
 * @author dzk
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Resource(name = "njProcessFlowsService")
	private ProcessFlowsService processFlowsService;

	@Resource(name = "coporateService")
	private CoporateService coporateService;

	@Resource(name = "orderService")
	private OrderService orderService;

	@Resource
	private LoanService loanService;

	@Resource
	AfterLoanOrderService afterLoanOrderService;

	@Resource(name = "dictService")
	private DictService dictService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "productService")
	private ProductService productService;
	
	@Resource(name = "channelService")
	private ChannelService channelService;
	
	@Resource 
	private RepayPlanNewService  repayPlanNewService;

	/*
	 * 获取订单状态列表
	 *
	 */
	@RequestMapping(value = "/getOrderStatusList", method = RequestMethod.POST)
	@ResponseBody
	public PageData listOrderStatusList() {
		PageData result = new PageData();
		try {
			HashMap<Object, Object> resultMap = new HashMap<>();
			String coporateId = Util.getCurrentCoporateId();
			NjCoporate coporate = coporateService.getCoporateById(coporateId);
			EnumSet<ELoanOrderStatus> enumSet = EnumSet.allOf(ELoanOrderStatus.class);
			Map<Object, Object> status = new HashMap<>();
			for (ELoanOrderStatus eLoanOrderStatus : enumSet) {
				if (eLoanOrderStatus.getValue() == 0 || eLoanOrderStatus.getValue() == 2) {
					continue;
				}
				if ((eLoanOrderStatus.getValue() >= 30 && eLoanOrderStatus.getValue() < 40) || eLoanOrderStatus.getValue()==53 || eLoanOrderStatus.getValue()==54 || eLoanOrderStatus.getValue()==21 || eLoanOrderStatus.getValue()==20) {
					if (coporate.getCompanCode().equals("1000")) {
						continue;
					}
				}
				if ((eLoanOrderStatus.getValue() > 8 && eLoanOrderStatus.getValue() < 20 && eLoanOrderStatus.getValue() != 12)||eLoanOrderStatus.getValue()==1 || eLoanOrderStatus.getValue()==52 || eLoanOrderStatus.getValue()==70) {
					if (!coporate.getCompanCode().equals("1000")) {
						continue;
					}
				}
				status.put(eLoanOrderStatus.getValue(), eLoanOrderStatus.getName());
			}
			resultMap.put("orderStatus", status);

			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, resultMap);

		} catch (Exception ex) {
			logger.error("系统错误:",ex);
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}

	/**
	 * 查询订单流程和检查记录
	 *
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/listOrderProcess", method = RequestMethod.POST)
	@ResponseBody
	public PageData listOrderProcess(String orderId) {
		PageData result = new PageData();
		try {
			NjLoanOrder order = orderService.getOrder(orderId);
			List<Map<String, Object>> processList = processFlowsService.selectOrderProcessByOrderId(orderId,order.getProductId());
			List<NjLoanOrderCheckRecord> checkRecordList = loanService.selectCheckRecord(orderId);
//			//获取订单初审、复审、终审
//			List<Map<String, Object>> auditUserList = orderService.selectOrderAuditUserList(orderId);
			result.put(Constants.Datas.STATUS, 0);
			result.put("orderStatus", order.getStatus());
			result.put(Constants.Datas.NDATA, processList);
			result.put("checkRecord", checkRecordList);
//			result.put("auditUserList", auditUserList);
		} catch (Exception ex) {
			logger.error("listOrderProcess error:{}", ex);
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}

	/**
	 * 通过类型获取数据字典信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getDictListByType", method = RequestMethod.POST)
	@ResponseBody
	public PageData listOrderPage() {
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			List<SysDict> dicts = dictService.getDictAreaByParent(pd);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, dicts);

		} catch (Exception ex) {
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}

	/**
	 * 获取驳回列表 通过订单ID和ProcessId查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getProcessOrderFlows", method = RequestMethod.POST)
	@ResponseBody
	public PageData getProcessOrderFlows() {
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			String orderId = pd.getString("orderId");
			String processId = pd.getString("processId");

			Map<String, Object> resultMap = new HashMap<>();

			// 驳回列表
			List<Map<String, Object>> processFlowInfo = orderService.getProcessOrderFlows(orderId, processId);
			resultMap.put("processFlowInfo", processFlowInfo);

			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, resultMap);

		} catch (Exception ex) {
			logger.error("系统错误:",ex);
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}

	/**
	 * 获取企业产品模板
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selecttCoporateTemplate", method = RequestMethod.POST)
	@ResponseBody
	public PageData selecttCoporateTemplate() {
		PageData result = new PageData();
		try {
			String coporateId = Util.getCurrentCoporateId();
			NjCoporateProductTempExample tempExample = new NjCoporateProductTempExample();
			tempExample.createCriteria().andCoporateIdEqualTo(coporateId);
			List<NjCoporateProductTemp> cptList = coporateService.getCoporateProductTemp(tempExample);
			List<Map<String, Object>> retList = new ArrayList<>();
			for (NjCoporateProductTemp njCoporateProductTemp : cptList) {
				Map<String, Object> retMap = new HashMap<>();
				retMap.put("productTempId", njCoporateProductTemp.getProductTempId());
				retMap.put("productTempName", EProductTemplate.getEProductTemplate(njCoporateProductTemp.getProductTempId()).getName());
				retList.add(retMap);
			}
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, retList);

		} catch (Exception ex) {
			logger.error("系统错误:",ex);
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value="/personalmodify", method=RequestMethod.POST)
	@ResponseBody
	public PageData personalmodify(){
		PageData result = new PageData();
		try {
			String userId = Util.getCurrentUserId();
			PageData pd = super.getPageData();
			pd.put("userId", userId);
			String password = pd.getString("oldpassword");
			String newPwd = pd.getString("password");
			
			if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(newPwd)) {
				if(!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, newPwd)){
					result.put("status",1000);
					result.put("msg", "密码必须为8到16位的数字字母组成");
					return result;
				} 
				PageData res = this.userService.editPassword(pd);
				return res;
			}else{
				result.put("status", 1000);
				result.put("msg", "旧密码或新密码不能为空");
			}
		} catch (Exception e) {
			logger.error("edit user error", e);
			result.put("status", 1000);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	/**
	 * 获取增补资料附件下拉项
	 * @return
	 */
	@RequestMapping(value="/productFileSelect", method=RequestMethod.POST)
	@ResponseBody
	public PageData productFileSelect(@RequestParam String productTempId){
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			pd.put("productTempId", productTempId);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, productService.selectProductBusinessDict(pd));
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception e) {
			logger.error("edit user error", e);
			result.put("status", 1000);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	/**
	 * 获取产品交易配置代偿账户信息
	 * @return
	 */
	@RequestMapping(value="/getRepayChannelUserList", method=RequestMethod.POST)
	@ResponseBody
	public PageData getRepayChannelUserList(){
		PageData result = new PageData();
		PageData pd = super.getPageData();
		try {
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, channelService.getRepayChannelUserList(pd));
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception e) {
			logger.error("edit user error", e);
			result.put("status", 1000);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	/**
	 * 校验权限
	 * @param phoneCheck
	 * @return
	 */
	@RequestMapping(value="/checkAuthority", method=RequestMethod.POST)
	@ResponseBody
	public PageData checkAuthority(String keyword) {
		PageData result = new PageData();
		try {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("userId", Util.getCurrentUserId());
			paramMap.put("keyword", keyword);
			boolean hasAuthority = userService.getAuthority(paramMap);
			if(hasAuthority) {
				result.put(Constants.Datas.STATUS, 0);
				result.put(Constants.Datas.NDATA, hasAuthority);
			}else {
				result.put(Constants.Datas.STATUS, 1000);
				result.put(Constants.Datas.NDATA, hasAuthority);
			}
				
		}catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, ex.getMessage());
		}
		return result;
	}
	
	
	@Resource
	private  TdReportService  tdReportService;
	/**
	 * 集团数据提取，同盾分数
	 * @param phoneCheck
	 * @return
	 */
	@RequestMapping(value="/tongdunScore", method=RequestMethod.POST)
	@ResponseBody
	public PageData tongdunScore() {
		PageData result = new PageData();
		try {
			String filepath = this.getClass().getResource("/").getPath();
			String picPath =filepath+"2.xlsx";  
	        MultipartFile file = ExcelReadUtil.getMulFileByPath(picPath);  
	        try {
	        	List<ArrayList<String>> str = new ExcelReadUtil().readExcel(file);
	        	for (int i = 0; i < str.size(); i++) {
	        		List<String> str2 = str.get(i);
	        		if(StringUtils.isEmpty(str2.get(0))) {
	        			continue;
	        		}
	        		TdReportData  tdReportData  =  new TdReportData();
	        		tdReportData.setMobile("151");
	  			  	tdReportData.setId_number("151");
	  			  	tdReportData.setName("151");
	    			tdReportData.setUserId(str2.get(0));
	    			ResponseDto<TdReportData> reponse = tdReportService.getTdReport(tdReportData);
	    			System.out.println(reponse.getResult().getFinal_score());
				}
	        	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, ex.getMessage());
		}
		return result;
	}
	
	
//	@Resource  
//	private RepayPlanService repayPlanService1;
	@Resource  
	private	AppUserService appUserService;
	
//	/**
//	 * 集团数据提取，还款计划相关
//	 * @param phoneCheck
//	 * @return
//	 * @throws Exception 
//	 */
//	@RequestMapping(value="/repayPlan2")
//	public void repayPlan2(HttpServletResponse response) throws Exception {
//		ResponseDto<List<Overdue>> dto = repayPlanService1.getOverdueByCondition("");
//		List<Overdue> list = dto.getResult();
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = list.size()-1; j >i; j--) {
//				 if (list.get(i).getOrderNo().equals(list.get(j).getOrderNo())) {
//					 if(list.get(i).getOverdueDays()>list.get(j).getOverdueDays()) {
//						 list.remove(j);
//					 }else {
//						 list.remove(i);
//					 }
//				 }
//			}
//		}
//	 
//		// 2.获取要导出的动态的费用项编码和中文
//					
//		// 3.生成导出工具的参数
//		FreeExportParam freeExportParam = new FreeExportParam();
//		freeExportParam.setFilename("逾期信息.xlsx");
//		freeExportParam.setSheetname("逾期信息");
//		freeExportParam.setTitlename("逾期信息");
//
//		List<String> tableHeaderList = new ArrayList<String>();			
//		List<String> alignList = new ArrayList<String>();			
//		List<String> formatTypeList = new ArrayList<String>();		
//		List<String> formatTypeValueList = new ArrayList<String>();	
//		
//		freeExportParam.setTableHeaderList(tableHeaderList);
//		freeExportParam.setAlignList(alignList);
//		freeExportParam.setFormatTypeList(formatTypeList);
//		freeExportParam.setFormatTypeValueList(formatTypeValueList);
//		
//		tableHeaderList.add("所属公司");
//		alignList.add(ExportFormatConstant.Align.LEFT);
//		formatTypeList.add(ExportFormatConstant.FormatType.STRING);
//		formatTypeValueList.add(null);
//		
//		tableHeaderList.add("贷款人姓名");
//		alignList.add(ExportFormatConstant.Align.LEFT);
//		formatTypeList.add(ExportFormatConstant.FormatType.STRING);
//		formatTypeValueList.add(null);
//		
//		tableHeaderList.add("身份证号");
//		alignList.add(ExportFormatConstant.Align.LEFT);
//		formatTypeList.add(ExportFormatConstant.FormatType.STRING);
//		formatTypeValueList.add(null);
//
//		tableHeaderList.add("逾期起始日期");
//		alignList.add(ExportFormatConstant.Align.LEFT);
//		formatTypeList.add(ExportFormatConstant.FormatType.STRING);
//		formatTypeValueList.add(null);
//
//		tableHeaderList.add("逾期天数");
//		alignList.add(ExportFormatConstant.Align.LEFT);
//		formatTypeList.add(ExportFormatConstant.FormatType.STRING);
//		formatTypeValueList.add(null);
//		
//		// 设置要导出的数据的list
//		List<List<String>> datas = new ArrayList<List<String>>();	
//		for (Overdue rpn : list) {
//			List<String> data = new ArrayList<String>();
//			NjLoanOrder loanOrder = orderService.getOrderByOrderNo(rpn.getOrderNo());
//			if(loanOrder != null) {
//				NjCoporate coporate = coporateService.getCoporateById(loanOrder.getCompanyId());
//				NjAppUserExample example = new NjAppUserExample();
//				example.createCriteria().andIdEqualTo(loanOrder.getUserId());
//				List<NjAppUser> appUsers = appUserService.selectByExample(example);
//				data.add(coporate.getCompanName());
//				data.add(appUsers.get(0).getTrueName());
//				data.add(appUsers.get(0).getIdentifyId());
//				data.add(DateUtil.formatDate(rpn.getOverdueBegin()));
//				data.add(rpn.getOverdueDays()+"");
//				datas.add(data);
//			}
//			
//		}
//		
//		freeExportParam.setDatas(datas);
//		try {
//			ExportUtil.freeExport(freeExportParam, response);
//		} catch (Exception e) {
//			logger.error("ExportUtil.freeExport发生异常：",e);
//		}
//		
//	}
	
//	/**
//	 * 集团数据提取，还款计划相关
//	 * @param phoneCheck
//	 * @return
//	 */
//	@RequestMapping(value="/repayPlan", method=RequestMethod.POST)
//	@ResponseBody
//	public PageData repayPlan1() {
//		PageData result = new PageData();
//		try {
//			String filepath = this.getClass().getResource("/").getPath();
//			String picPath =filepath+"1.xlsx";  
//	        MultipartFile file = ExcelReadUtil.getMulFileByPath(picPath);  
//	        try {
//	        	List<ArrayList<String>> str = new ExcelReadUtil().readExcel(file);
////	        	System.out.println("=========剩余期数==========");
////	        	for (int i = 0; i < str.size(); i++) {
////	        		List<String> str2 = str.get(i);
////	        		String orderNo = str2.get(0);
////	        		if(StringUtils.isEmpty(orderNo)) {
////	        			continue;
////	        		}
////	        		ResponseDto<List<RepayPlan>> response = repayPlanService1.getRepayPlanByOrderNo(orderNo);
////	        		//剩余期数
////	        		int perid  = 0;
////	        		for(RepayPlan  repayPlan :response.getResult() ){
////	        			if(repayPlan.getRepayStatus().equals("未还款")) {
////	        				perid++;	
////	        			}
////	        		}
////	        		System.out.println(perid);
////	        	}
////	        	//到期日期
////	        	System.out.println("=====到期日期=====");
////	        	for (int i = 0; i < str.size(); i++) {
////	        		List<String> str2 = str.get(i);
////	        		String orderNo = str2.get(0);
////	        		if(StringUtils.isEmpty(orderNo)) {
////	        			continue;
////	        		}
////	        		ResponseDto<List<RepayPlan>> response = repayPlanService1.getRepayPlanByOrderNo(orderNo);
////	        		
////	        		//到期日期
////	        		if(response.getReturnCode()==0) {
////	        			List<RepayPlan> repayPlans = response.getResult();
////		        		Date date = repayPlans.get(repayPlans.size()-1).getPlanRepayDate();
//////		        		System.out.println(orderNo+"=="+DateUtil.formatDate(date));
////		        		System.out.println(DateUtil.formatDate(date));
////	        		}else {
////	        			System.out.println(orderNo+"错误");
////	        		}
////				}
//	        	
//	        	//未还本金
//	        	System.out.println("====未还本金====");
//	        	for (int i = 0; i < str.size(); i++) {
//	        		List<String> str2 = str.get(i);
//	        		String orderNo = str2.get(0);
//	        		if(StringUtils.isEmpty(orderNo)) {
//	        			continue;
//	        		}
//	        		ResponseDto<List<RepayPlan>> response = repayPlanService1.getRepayPlanByOrderNo(orderNo);
//	        		
//	        		//未还本金
//	        		Double re1t = new Double(0);
//	        		for(RepayPlan  repayPlan :response.getResult() ){
//	        			if(repayPlan.getRepayStatus().equals("未还款")) {
//	        				re1t+=repayPlan.getPlanRepayCapital().doubleValue();
//	        			}
//	        		}
//	        		re1t = re1t/10000;
//	        		double d = (double) Math.round(re1t * 1000000) / 1000000;
//	        		System.out.println(d);
//				}
////	        	
////	        	//未还利息
////	        	System.out.println("=-=======未还利息==========");
////	        	for (int i = 0; i < str.size(); i++) {
////	        		List<String> str2 = str.get(i);
////	        		String orderNo = str2.get(0);
////	        		if(StringUtils.isEmpty(orderNo)) {
////	        			continue;
////	        		}
////	        		ResponseDto<List<RepayPlan>> response = repayPlanService1.getRepayPlanByOrderNo(orderNo);
////	        		
////	        		//未还利息
////	        		Double re1t = new Double(0);
////	        		for(RepayPlan  repayPlan :response.getResult() ){
////	        			if(repayPlan.getRepayStatus().equals("未还款")) {
////	        				re1t+=repayPlan.getPlanRepayInterest().doubleValue();
////	        			}
////	        		}
////	        		re1t = re1t/10000;
////	        		double d = (double) Math.round(re1t * 1000000) / 1000000;
////	        		System.out.println(d);
////				}
////	        	
////	        	//贷款利息总
////	        	System.out.println("=========贷款利息总===========");
////	        	for (int i = 0; i < str.size(); i++) {
////	        		List<String> str2 = str.get(i);
////	        		String orderNo = str2.get(0);
////	        		if(StringUtils.isEmpty(orderNo)) {
////	        			continue;
////	        		}
////	        		ResponseDto<List<RepayPlan>> response = repayPlanService1.getRepayPlanByOrderNo(orderNo);
////	        		
////	        		//贷款利息总
////
////	        		Double re1t = new Double(0);
////	        		for(RepayPlan  repayPlan :response.getResult() ){
////        				re1t+=repayPlan.getPlanRepayInterest().doubleValue();
////	        		}
////	        		re1t = re1t/10000;
////	        		double d = (double) Math.round(re1t * 1000000) / 1000000;
////	        		System.out.println(d);
////				}
////	        	
////	        	
////	        	//逾期情况
////	        	System.out.println("=============逾期情况============");
////	        	for (int i = 0; i < str.size(); i++) {
////	        		List<String> str2 = str.get(i);
////	        		String orderNo = str2.get(0);
////	        		if(StringUtils.isEmpty(orderNo)) {
////	        			continue;
////	        		}
////	        		//逾期情况
////	        		ResponseDto<RepayPlanMain> responseMainByOrderNo = repayPlanService1.getRepayPlanMainByOrderNo(orderNo);
////	        		String repayStatus = responseMainByOrderNo.getResult().getRepayStatus();
////	        		System.out.println(repayStatus);
////				}
////	        	
////	        	//付息情况
////	        	System.out.println("========付息情况================");
////	        	for (int i = 0; i < str.size(); i++) {
////	        		List<String> str2 = str.get(i);
////	        		String orderNo = str2.get(0);
////	        		if(StringUtils.isEmpty(orderNo)) {
////	        			continue;
////	        		}
////	        		ResponseDto<List<RepayPlan>> response = repayPlanService1.getRepayPlanByOrderNo(orderNo);
////	        		
////	        		//付息情况
////	        		Double ret = new Double(0);
////	        		for(RepayPlan  repayPlan :response.getResult() ){
////	        			if(repayPlan.getRepayStatus().equals("正常还款")) {
////	        				ret+=repayPlan.getAccReapyInterest().doubleValue();
////	        			}
////	        		}
////	        		ret = ret/10000;
////	        		double d2 = (double) Math.round(ret * 1000000) / 1000000;
////	        		System.out.println(d2);
////				}
//	        	
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}catch (Exception ex) {
//			logger.error(ex.getMessage());
//			result.put(Constants.Datas.STATUS, 1000);
//			result.put(Constants.Datas.MSG, ex.getMessage());
//		}
//		return result;
//	}
	
	/**
	 * 获取产品费用配置项信息
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getProductFeeItems", method = RequestMethod.POST)
	@ResponseBody
	public PageData getProductFeeItems() {
		PageData result = new PageData();
		try {
			List<Map<String, Object>> businessFeeAlgorithms = null;
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> businessFeeMap = null;
			for (EBusinessFee businessFee : EBusinessFee.values()) {
				businessFeeMap = new HashMap<>();
				businessFeeMap.put("name", businessFee.getName());
				businessFeeMap.put("code", businessFee.getCode());
				businessFeeMap.put("isMustSelected", businessFee.getIsMustSelected());
				//获取费用类型支持的算法列表
				List<EBusinessFeeAlgorithm> algorithms = BusinessFeeAndAlgorithmRelation.getAlgorithmForFee(businessFee);
				
				if(algorithms != null) {
					businessFeeAlgorithms = new ArrayList<>();
					for (EBusinessFeeAlgorithm eBusinessFeeAlgorithm : algorithms) {
						Map<String, Object> algorithmsMap = new HashMap<>();
						algorithmsMap.put("name", eBusinessFeeAlgorithm.getName());
						algorithmsMap.put("code", eBusinessFeeAlgorithm.getCode());
						algorithmsMap.put("explain", eBusinessFeeAlgorithm.getExplain());
						businessFeeAlgorithms.add(algorithmsMap);
					}
				}
				
				businessFeeMap.put("calList",businessFeeAlgorithms);
				list.add(businessFeeMap);
			}
			result.put(Constants.Datas.NDATA, list);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.MSG, "OK");
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
	
	
	
	/**
	 * 集团数据提取，同盾分数
	 * @param phoneCheck
	 * @return
	 */
	@RequestMapping(value="/tongdunTest", method=RequestMethod.POST)
	@ResponseBody
	public PageData test() {
		PageData result = new PageData();
			
    	try {
    		/*List<NjLoanOrder> loanOrders = orderService.selectByExamp();
         	for (int i = 0; i <loanOrders.size(); i++) {
        		NjLoanOrder order = loanOrders.get(i);
        		TdReportData  tdReportData  =  new TdReportData();
        		tdReportData.setMobile("151");
    		  	tdReportData.setId_number("151");
    		  	tdReportData.setName("151");
    			tdReportData.setUserId(order.getUserId());
    			ResponseDto<TdReportData> reponse = tdReportService.getTdReport(tdReportData);
    			if(reponse.getResult() != null) {
    				order.setTdReportId(reponse.getResult().getId());
    				orderService.update(order);
    			}
    		}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
  	public static void main(String[] args) {}
}
