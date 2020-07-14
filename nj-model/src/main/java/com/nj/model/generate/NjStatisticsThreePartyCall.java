package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjStatisticsThreePartyCall {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private String time;

    /**
     * 成功数
     */
    @ApiModelProperty(value = "成功数")
    private Integer succeedNum;

    /**
     * 失败数
     */
    @ApiModelProperty(value = "失败数")
    private Integer failNum;

    /**
     * 平均请求时间
     */
    @ApiModelProperty(value = "平均请求时间")
    private Integer avgTime;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 第三方名称
     */
    @ApiModelProperty(value = "第三方名称")
    private String thirdPart;

    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    private String companyId;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String companyName;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 日期
     * @return time 日期
     */
    public String getTime() {
        return time;
    }

    /**
     * 日期
     * @param time 日期
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 成功数
     * @return succeed_num 成功数
     */
    public Integer getSucceedNum() {
        return succeedNum;
    }

    /**
     * 成功数
     * @param succeedNum 成功数
     */
    public void setSucceedNum(Integer succeedNum) {
        this.succeedNum = succeedNum;
    }

    /**
     * 失败数
     * @return fail_num 失败数
     */
    public Integer getFailNum() {
        return failNum;
    }

    /**
     * 失败数
     * @param failNum 失败数
     */
    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    /**
     * 平均请求时间
     * @return avg_time 平均请求时间
     */
    public Integer getAvgTime() {
        return avgTime;
    }

    /**
     * 平均请求时间
     * @param avgTime 平均请求时间
     */
    public void setAvgTime(Integer avgTime) {
        this.avgTime = avgTime;
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 第三方名称
     * @return third_part 第三方名称
     */
    public String getThirdPart() {
        return thirdPart;
    }

    /**
     * 第三方名称
     * @param thirdPart 第三方名称
     */
    public void setThirdPart(String thirdPart) {
        this.thirdPart = thirdPart;
    }

    /**
     * 企业id
     * @return company_id 企业id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 企业id
     * @param companyId 企业id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 企业名称
     * @return company_name 企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 企业名称
     * @param companyName 企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}