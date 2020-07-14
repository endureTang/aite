package com.nj.core.base.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Name com.jdcf.asset.task.utils.TaskResponse
 * @Description
 * @Author bruce
 * @Version 2018年3月9日 下午4:38:34
 * @Copyright 金鼎财富
 */
@ApiModel("返回model")
public class ResponseDto<T> implements  Serializable{
    /**
     * 结果(0:成功,非0：失败)
     */
    @ApiModelProperty(value = "返回码(0:成功,非0：失败  1000:未查询到相关还款计划或回款计划)")
    private int returnCode;
    @ApiModelProperty(value = "返回信息")
    private String returnMsg;
    @ApiModelProperty(value = "返回数据")
    private T result;
    @ApiModelProperty(value = "数据总条数")
    private Integer recordsTotal;
    @ApiModelProperty(value = "页数")
    private Integer pageNum;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ResponseDto() {
        returnCode = 0;
        returnMsg = "操作成功";
    }

    public ResponseDto(int returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public ResponseDto(T result) {
        this.returnCode = 0;
        this.returnMsg = "ok";
        this.result = result;
    }

    public ResponseDto(int returnCode, String returnMsg, T result) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.result = result;
    }

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "ResponseDto [returnCode=" + returnCode + ", returnMsg=" + returnMsg + ", result=" + result
				+ ", recordsTotal=" + recordsTotal + ", pageNum=" + pageNum + "]";
	}
	
	

}
