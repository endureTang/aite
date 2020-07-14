package com.nj.model.datamodel;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.CommonStatus;
import com.nj.core.fee.constant.EBusinessFee;

public class EarlySettleParam {
	
	public static final String REPAY_PLAN = "repayPlan";		//还款计划
	public static final String MONEY_BACK = "moneyBack";		//小贷公司回款计划
	public static final String CAPTIAL_MONEY_BACK = "captialMoneyBack";		//资金渠道回款计划

	private Date accRepayDate;					// 实际还款日期
	private String settleCert;					// 结清凭证url
	private List<FeeCodeValue> feeInfoList;		// 需要更改费用及其更改的值
	private String earlySettleServiceFee;		// 提前结清手续费
	
	private String type;						// 提前结清类型，区分这个参数类属于还款计划还是回款计划。  使用该类中的常量
	private String coporateId;					// 对于还款计划，该参数不传值;对于小贷公司回款计划，该字段不传;对于资金渠道，传自己渠道的渠道id；
	
	/**
	 * 验证传入参数
	 */
	@SuppressWarnings("rawtypes")
	public ResponseDto validate(){
		ResponseDto result = new ResponseDto();
		if(null == this.getAccRepayDate()){
			result.setReturnCode(CommonStatus.SYSTEM_ERROR.getCode());
			result.setReturnMsg("accRepayDate参数为空");
			return result;
		}
		if(null == this.getType()){
			result.setReturnCode(CommonStatus.SYSTEM_ERROR.getCode());
			result.setReturnMsg("type参数为空");
			return result;
		}
		
		if(!CollectionUtils.isEmpty(feeInfoList)){
			for (FeeCodeValue feeCodeValue : feeInfoList) {
				if(!EBusinessFee.isAcc(feeCodeValue.getCode())){
					result.setReturnCode(CommonStatus.SYSTEM_ERROR.getCode());
					result.setReturnMsg("feeInfoList中编码["+feeCodeValue.getCode() + "]是非法的，必须是实还");
					return result;
				}
			}
		}
		return result;
	}

	public Date getAccRepayDate() {
		return accRepayDate;
	}

	public void setAccRepayDate(Date accRepayDate) {
		this.accRepayDate = accRepayDate;
	}

	public String getSettleCert() {
		return settleCert;
	}

	public void setSettleCert(String settleCert) {
		this.settleCert = settleCert;
	}

	public List<FeeCodeValue> getFeeInfoList() {
		return feeInfoList;
	}

	public void setFeeInfoList(List<FeeCodeValue> feeInfoList) {
		this.feeInfoList = feeInfoList;
	}

	public String getEarlySettleServiceFee() {
		return earlySettleServiceFee;
	}

	public void setEarlySettleServiceFee(String earlySettleServiceFee) {
		this.earlySettleServiceFee = earlySettleServiceFee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCoporateId() {
		return coporateId;
	}

	public void setCoporateId(String coporateId) {
		this.coporateId = coporateId;
	}

	@Override
	public String toString() {
		StringBuilder ojbStr = new StringBuilder();
		Field[] fileds = this.getClass().getDeclaredFields();
		for (int i = 0; i < fileds.length; i++) {
			try {
				ojbStr.append(fileds[i].getName()).append("=").append(fileds[i].get(this)==null?"":fileds[i].get(this).toString()).append(",");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return ojbStr.toString();
	}
}
