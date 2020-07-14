package com.nj.service.enterprise;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.util.PageData;
import com.nj.dao.NjOrderAreaMapper;
import com.nj.dao.NjStatisticsOrderMapper;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjStatisticsOrderMapperExtend;
import com.nj.model.generate.NjOrderArea;
import com.nj.model.generate.NjOrderAreaExample;
import com.nj.model.generate.NjStatisticsOrder;
import com.nj.model.generate.NjStatisticsOrderExample;

/**
 * enterprise页面统计用
 * @author wkh
 */
@Transactional(readOnly=true)
@Service("visualStatisticsService")
public class VisualStatisticsService extends BaseCachesService{

	Logger logger = LoggerFactory.getLogger(VisualStatisticsService.class);
	
	@Autowired
	private NjLoanOrderMapperExtend njLoanOrderMapperExtend;
	@Autowired
	private NjStatisticsOrderMapper njStatisticsOrderMapper;
	@Autowired
	private NjOrderAreaMapper njOrderAreaMapper;
	@Autowired
	private NjStatisticsOrderMapperExtend njStatisticsOrderMapperExtend;
	
	/**
	 * 获取撮合成功的金额和件数.
	 * 状态为12和99的订单
	 * @param coporateId 企业id
	 * 					  为空时，查询所有企业累计撮合成功金额和件数。
	 * 					 非空时，查询指定企业累计  撮合成功金额和件数。
	 */
	public PageData getTotalAmtAndNumForMatched(String coporateId){
		return njLoanOrderMapperExtend.getTotalAmtAndNumForMatched(coporateId);
	}
	
	/**
	 * 获取productIds的，从beginDate开始每个月撮合金额。若有企业id，则查询指定企业id的统计数据
	 * param 包含3个参数：
	 * 			String beginDate 必填
	 * 			List<String> productIds 必填
	 * 			String coporateId 非必填
	 */
	public List<PageData> getTotalAmtForMonth(Map<String,Object> param){
		return njLoanOrderMapperExtend.getTotalAmtForMonth(param);
	}
	
	/**
	 * 获取统计订单列表
	 */
	public List<NjStatisticsOrder> getStatustucsOrderList(String coporateId,String beginDate,String endDate){
		return  njStatisticsOrderMapperExtend.countOrderStastis(coporateId, beginDate, endDate);
	}
	
	
	/**
	 * 获取各省份撮合金额总和
	 */
	public List<NjOrderArea> getNjOrderAreaListForProvince(){
		NjOrderAreaExample example = new NjOrderAreaExample();
		example.createCriteria().andTypeEqualTo("1");		//省份
		return njOrderAreaMapper.selectByExample(example);
	}
}
