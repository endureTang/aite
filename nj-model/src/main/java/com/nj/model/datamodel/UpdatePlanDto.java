package com.nj.model.datamodel;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.CommonStatus;
import com.nj.core.base.enums.ERepayStatus;
import com.nj.core.base.util.StringUtils;
import com.nj.core.fee.constant.EBusinessFee;

/**
 * 更新计划接口需要的DTO。 包括还款计划和回款计划
 */
public class UpdatePlanDto {
	
	public static final String MANUAL = "Manual";		//手动扣款
	public static final String AUTO = "auto";			//自动扣款
	
	private String deductObj;				//扣款方式。使用常量：MANUAL、AUTO。必填
	private String orderNo;					//订单编号。必填
	private Integer period;					//更新期数。必填
	private String channelId;				//资金渠道ID。更新资金渠道回款计划时才传入。非必填
	private String accRepayDate;			//实际还款时间。非必填
	private String repayStatus;				//还款状态。非必填：扣款成功要填，失败不填
	private String deductionResult;			//扣款情况。
	private Integer deductionFailReason;	//扣款失败原因。 3:余额不足,失败     4:系统原因,失败
	private List<FeeCodeValue> feeInfoList;	//需要更改的实还费用项及其更改的值。自动扣款时，该字段为空，实还默认=应还。手动扣款时，可传可不传，不传则不更改实还费用，只更改状态、扣款情况、实还时间，传则还要修改实还金额
	private Integer repayType;				//还款方式：0：线上中金扣款,9：线下还款
	/**
	 * 验证传入参数
	 */
	@SuppressWarnings("rawtypes")
	public ResponseDto validate(){
		ResponseDto result = new ResponseDto();
		if(StringUtils.isEmpty(this.getDeductObj())){
			result.setReturnCode(CommonStatus.SYSTEM_ERROR.getCode());
			result.setReturnMsg("deductObj参数为空");
			return result;
		}
		if(StringUtils.isEmpty(this.getOrderNo()) || null == this.getPeriod()){
			result.setReturnCode(CommonStatus.SYSTEM_ERROR.getCode());
			result.setReturnMsg("orderNo或period参数为空");
			return result;
		}
		if(this.getDeductObj().equals(MANUAL)){
			if(!CollectionUtils.isEmpty(feeInfoList)){
				for (FeeCodeValue feeCodeValue : feeInfoList) {
					if(!EBusinessFee.isAcc(feeCodeValue.getCode())){
						result.setReturnCode(CommonStatus.SYSTEM_ERROR.getCode());
						result.setReturnMsg("feeInfoList中编码["+feeCodeValue.getCode() + "]是非法的，必须是实还");
						return result;
					}
				}
			}
		}
		if(StringUtils.isNotEmpty(this.getRepayStatus()) && this.getRepayStatus().equals(ERepayStatus.EARLY_CLEARANCE.getValue())){
			result.setReturnCode(CommonStatus.SYSTEM_ERROR.getCode());
			result.setReturnMsg("该接口不能做提前结清。");
			return result;
		}
		return result;
	}

	public Integer getRepayType() {
		return repayType;
	}

	public void setRepayType(Integer repayType) {
		this.repayType = repayType;
	}

	public String getDeductObj() {
		return deductObj;
	}

	public void setDeductObj(String deductObj) {
		this.deductObj = deductObj;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getAccRepayDate() {
		return accRepayDate;
	}

	public void setAccRepayDate(String accRepayDate) {
		this.accRepayDate = accRepayDate;
	}

	public String getRepayStatus() {
		return repayStatus;
	}

	public void setRepayStatus(String repayStatus) {
		this.repayStatus = repayStatus;
	}

	public String getDeductionResult() {
		return deductionResult;
	}

	public void setDeductionResult(String deductionResult) {
		this.deductionResult = deductionResult;
	}

	public Integer getDeductionFailReason() {
		return deductionFailReason;
	}

	public void setDeductionFailReason(Integer deductionFailReason) {
		this.deductionFailReason = deductionFailReason;
	}

	public List<FeeCodeValue> getFeeInfoList() {
		return feeInfoList;
	}

	public void setFeeInfoList(List<FeeCodeValue> feeInfoList) {
		this.feeInfoList = feeInfoList;
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
