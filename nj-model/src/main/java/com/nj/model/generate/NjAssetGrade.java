package com.nj.model.generate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.nj.core.base.entity.NjIdEntity;

public class NjAssetGrade extends NjIdEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -848453828614124026L;

	/**
     * 资产等级
     */
    private String grade;

    /**
     * 说明
     */
    private String descption;

    /**
     * 筛选比列
     */
    @Min(0)
    @Max(100)
    @NotNull
    private Integer screenRate;

    /**
     * 是否默认(1:默认,0:非默认,所有数据中,只能有一条默认)
     */
    private Boolean isDefault;

    /**
     * 资产等级
     * @return grade 资产等级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 资产等级
     * @param grade 资产等级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 说明
     * @return descption 说明
     */
    public String getDescption() {
        return descption;
    }

    /**
     * 说明
     * @param descption 说明
     */
    public void setDescption(String descption) {
        this.descption = descption;
    }

    /**
     * 筛选比列
     * @return screen_rate 筛选比列
     */
    public Integer getScreenRate() {
        return screenRate;
    }

    /**
     * 筛选比列
     * @param screenRate 筛选比列
     */
    public void setScreenRate(Integer screenRate) {
        this.screenRate = screenRate;
    }

    /**
     * 是否默认(1:默认,0:非默认,所有数据中,只能有一条默认)
     * @return is_default 是否默认(1:默认,0:非默认,所有数据中,只能有一条默认)
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * 是否默认(1:默认,0:非默认,所有数据中,只能有一条默认)
     * @param isDefault 是否默认(1:默认,0:非默认,所有数据中,只能有一条默认)
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}