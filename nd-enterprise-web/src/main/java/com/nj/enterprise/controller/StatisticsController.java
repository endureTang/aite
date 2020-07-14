package com.nj.enterprise.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jd.core.util.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.CommonStatus;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.enterprise.utils.Util;
import com.nj.model.generate.NjOrderArea;
import com.nj.model.generate.NjStatisticsOrder;
import com.nj.service.enterprise.ProductService;
import com.nj.service.enterprise.VisualStatisticsService;


/**
 * enterprise统计controller
 * 
 * @author wkh
 */
@RestController
@RequestMapping(value = "/statistics")
public class StatisticsController extends BaseController {

	Logger logger = LoggerFactory.getLogger(StatisticsController.class);
	
	@Resource(name = "visualStatisticsService")
	private VisualStatisticsService statisticsService;
	
	@Resource(name = "productService")
	private ProductService productService;
	
	/**
	 * 跳转到dynamic_data.jsp
	 */
	@ResourcesAnnotion(uri="/statistics/statDynamicDataPage",name="数据统计",resourceType=2,parentId="201")
	@GetMapping(value = "/statDynamicDataPage")
	public ModelAndView toDynamicDataPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dynamicData/dynamic_data");
		return mv;
	}
	
	/**
	 * 获取所有企业总的累计撮合金额和累计撮合件数
	 */
	@PostMapping(value="/getTotalMatchAmtAndNum")
	@ResponseBody
	public ResponseDto<PageData> getTotalMatchAmtAndNum(){
		ResponseDto<PageData> result = new ResponseDto<PageData>();
		
		// 获取撮合成功的金额和件数
		PageData totalMatch = statisticsService.getTotalAmtAndNumForMatched(null);
		
		result.setResult(totalMatch);
		return result;
	}

	/**
	 * 获取企业所有统计页面的数据
	 */
	@PostMapping(value = "/getStatusDataForCoporate")
	@ResponseBody
	public ResponseDto<PageData> getStatusDataForCoporate() {
		ResponseDto<PageData> result = new ResponseDto<PageData>();
		String coporateId = Util.getCurrentCoporateId();
		
		try {
			PageData data = new PageData();
			
			// 数据一：获取撮合成功的金额和件数
			PageData totalMatch = statisticsService.getTotalAmtAndNumForMatched(coporateId);
			data.put("matchTotalAmt", totalMatch.get("amt"));
			data.put("matchTotalNum", totalMatch.get("num"));
			
			// 数据二：3C消费类和汽车金融类产品，每月金额撮合走势图
			Map<String,Object> param = new HashMap<String,Object>();
			// 获取最近6个月每个月撮合金额总额
			final Integer monthNum = 6;		
			String beginDate = DateUtil.formatDate(DateUtil.getBeforeDate(new Date(),Calendar.MONTH, monthNum-1),"yyyy-MM");
			param.put("beginDate", beginDate);
			
			// 查询当前用户所在企业的
			param.put("coporateId", coporateId);
			
			//3C消费类 ，未删除且上线的
			List<String> _3CProductIds = new ArrayList<String>();
			_3CProductIds.add("196e2d7d17934090b4dd920d98292440");	//3C消费场景A
			_3CProductIds.add("1d83f779a76a4e90a0838bfe2af8811c");	//手机消费场景
			param.put("productIds", _3CProductIds);
			
			List<PageData> _3CMonthMatchAmt = statisticsService.getTotalAmtForMonth(param);
			List<String []> _3CArrayList = convertMonthMatchAmt(_3CMonthMatchAmt, monthNum, beginDate);
			
			//汽车金融类，未删除且上线的
			List<String> carProductIds = new ArrayList<String>();
			carProductIds.add("79a5770a441d446c8f43c1e58a1a70f0");	//新天府专车贷
			carProductIds.add("06c2dd39459d4d3cb033af0eb03f180d");	//汽车消费场景A
			carProductIds.add("429c9aec979d4932bd63f86e2ebb1d97");	//汽车消费场景B
			carProductIds.add("3f4ca8cd484e4a96ba5f6d631e1c1c1b");	//汽车消费场景C
			carProductIds.add("13f47067340a4c7b93fbe41e4e006e6e");	//随意付-保险分期A
			carProductIds.add("fb828ab00d5141a28eebaf6d83c03e23");	//随意付-保险分期B
			param.put("productIds", carProductIds);
			
			List<PageData> carMonthMatchAmt = statisticsService.getTotalAmtForMonth(param);
			List<String []> carArrayList = convertMonthMatchAmt(carMonthMatchAmt, monthNum, beginDate);
			
			data.put("xAxis", _3CArrayList.get(0));
			data.put("y3C", _3CArrayList.get(1));
			data.put("yCar", carArrayList.get(1));
			
			
			
			String zsBeginDate = DateUtil.formatDate(DateUtil.getBeforeDate(new Date(), Calendar.MONTH, 1), "yyyy-MM-dd");
			String zsEndDate = DateUtil.formatDate(new Date(), "yyyy-MM-dd");
			List<NjStatisticsOrder> soList = statisticsService.getStatustucsOrderList(coporateId, zsBeginDate, zsEndDate);
			
			// 数据三：近1个月每日放款金额走势
			String [] fkjezsX = new String[soList.size()];		//放款金额走势时间数组
			// 数据四：近1个月每日放款订单数量走势
			String [] fkjszsX = new String[soList.size()];		//放款件数走势时间数组
			// 数据五：近1个月每日平均撮合时效走势（小时）
			String [] pjchsxX = new String[soList.size()];		//平均撮合时效走势时间数组
			
			String [] fkjezsY = new String[soList.size()];		//放款金额走势金额数组
			String [] fkjszsY = new String[soList.size()];		//放款件数走势件数数组
			String [] pjchsxY = new String[soList.size()];		//平均撮合时效走势时效数组
			
			for (int i = 0; i < soList.size(); i++) {
				NjStatisticsOrder so = soList.get(i);
				
				fkjezsX[i] = so.getTime();
				fkjszsX[i] = so.getTime();
				pjchsxX[i] = so.getTime();
				
				fkjezsY[i] = String.valueOf(so.getLoanAmount().divide(new BigDecimal(10000)).doubleValue());		//单位是万元
				fkjszsY[i] = so.getLoanNum();
				pjchsxY[i] = String.valueOf(new BigDecimal(so.getAvgMatchHourse()).divide(new BigDecimal(3600),1,RoundingMode.HALF_UP));
			}
			
			data.put("fkjezsX", fkjezsX);		//放款金额走势时间
			data.put("fkjezsY", fkjezsY);		//放款金额走势金额
			data.put("fkjszsX", fkjszsX);		//放款件数走势时间
			data.put("fkjszsY", fkjszsY);		//放款件数走势件数
			data.put("pjchsxX", pjchsxX);		//平均撮合时效走势时间
			data.put("pjchsxY", pjchsxY);		//平均撮合时效走势时效
			
			// 数据六：地图各省份撮合成功累计金额
			List<NjOrderArea> oaList = statisticsService.getNjOrderAreaListForProvince();
			List<Map<String, String>> provinceData = new ArrayList<Map<String, String>>();
			for (int i = 0; i < oaList.size(); i++) {
				NjOrderArea oa = oaList.get(i);
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", oa.getName());
				map.put("value", String.valueOf(oa.getAuditamt().doubleValue()));
				provinceData.add(map);
			}
			data.put("provinceData", provinceData);		//省份撮合金额
			
			result.setResult(data);
		} catch (Exception e) {
			result.setReturnCode(CommonStatus.SYSTEM_ERROR.getCode());
			result.setReturnMsg(CommonStatus.SYSTEM_ERROR.getMessage());	
			logger.error("/getMatchData获取撮合数据时发生异常：",e);
		}
		return result;
	}
	
	private List<String []> convertMonthMatchAmt(List<PageData> monthMatchAmt,final Integer monthNum,String beginDate){
		
		Map<String,String> monthMatchAmtMap = toMap(monthMatchAmt);
		String[] xAxis = new String[monthNum];
		String[] yData = new String[monthNum];
		for (int i = 0; i < monthNum; i++) {
			String curMon = getAfterYearMonth(beginDate, i);
			String CurMonAmt = monthMatchAmtMap.get(curMon);
			if(StringUtils.isEmpty(CurMonAmt)){
				CurMonAmt = "0.00";
			}
			xAxis[i] = curMon;
			yData[i] = CurMonAmt;
		}

		List<String []> result = new ArrayList<String []>();
		result.add(xAxis);
		result.add(yData);
		return result;
	}
	
	private Map<String,String> toMap(List<PageData> monthMatchAmt) {
		Map<String,String> monthMatchAmtMap = new HashMap<String,String>();
		for (PageData temp : monthMatchAmt) {
			monthMatchAmtMap.put(temp.getString("yearMonth"), temp.getString("totalAmt"));
		}
		return monthMatchAmtMap;
	}
	
	private String getAfterYearMonth(String beginDate,Integer num){
		return DateUtil.formatDate(DateUtil.getAfterDate(DateUtil.parseDate(beginDate, "yyyy-MM"), Calendar.MONTH, num),"yyyy-MM");
	}
	
}
