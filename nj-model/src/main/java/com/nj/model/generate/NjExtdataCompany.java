package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjExtdataCompany {
    private String id;

    private String orderId;

    /**
     * 是否命中自然人识别信息
     */
    @ApiModelProperty(value = "是否命中自然人识别信息")
    private String sfmzzrrsbxx;

    /**
     * 是否命中法院信息
     */
    @ApiModelProperty(value = "是否命中法院信息")
    private String sfmzfyxx;

    /**
     * 是否命中特殊名单
     */
    @ApiModelProperty(value = "是否命中特殊名单")
    private String sfmztsmd;

    /**
     * 近3个月申请次数
     */
    @ApiModelProperty(value = "近3个月申请次数")
    private String j3gysqcs;

    /**
     * 近6个月申请次数
     */
    @ApiModelProperty(value = "近6个月申请次数")
    private String j6gysqcs;

    /**
     * 近12个月申请次数
     */
    @ApiModelProperty(value = "近12个月申请次数")
    private String j12gysqcs;

    /**
     * 手机在网状态
     */
    @ApiModelProperty(value = "手机在网状态")
    private String sjzwzt;

    /**
     * 手机在网时长
     */
    @ApiModelProperty(value = "手机在网时长")
    private String sjzwsc;

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return order_id 
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 
     * @param orderId 
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 是否命中自然人识别信息
     * @return sfmzzrrsbxx 是否命中自然人识别信息
     */
    public String getSfmzzrrsbxx() {
        return sfmzzrrsbxx;
    }

    /**
     * 是否命中自然人识别信息
     * @param sfmzzrrsbxx 是否命中自然人识别信息
     */
    public void setSfmzzrrsbxx(String sfmzzrrsbxx) {
        this.sfmzzrrsbxx = sfmzzrrsbxx;
    }

    /**
     * 是否命中法院信息
     * @return sfmzfyxx 是否命中法院信息
     */
    public String getSfmzfyxx() {
        return sfmzfyxx;
    }

    /**
     * 是否命中法院信息
     * @param sfmzfyxx 是否命中法院信息
     */
    public void setSfmzfyxx(String sfmzfyxx) {
        this.sfmzfyxx = sfmzfyxx;
    }

    /**
     * 是否命中特殊名单
     * @return sfmztsmd 是否命中特殊名单
     */
    public String getSfmztsmd() {
        return sfmztsmd;
    }

    /**
     * 是否命中特殊名单
     * @param sfmztsmd 是否命中特殊名单
     */
    public void setSfmztsmd(String sfmztsmd) {
        this.sfmztsmd = sfmztsmd;
    }

    /**
     * 近3个月申请次数
     * @return j3gysqcs 近3个月申请次数
     */
    public String getJ3gysqcs() {
        return j3gysqcs;
    }

    /**
     * 近3个月申请次数
     * @param j3gysqcs 近3个月申请次数
     */
    public void setJ3gysqcs(String j3gysqcs) {
        this.j3gysqcs = j3gysqcs;
    }

    /**
     * 近6个月申请次数
     * @return j6gysqcs 近6个月申请次数
     */
    public String getJ6gysqcs() {
        return j6gysqcs;
    }

    /**
     * 近6个月申请次数
     * @param j6gysqcs 近6个月申请次数
     */
    public void setJ6gysqcs(String j6gysqcs) {
        this.j6gysqcs = j6gysqcs;
    }

    /**
     * 近12个月申请次数
     * @return j12gysqcs 近12个月申请次数
     */
    public String getJ12gysqcs() {
        return j12gysqcs;
    }

    /**
     * 近12个月申请次数
     * @param j12gysqcs 近12个月申请次数
     */
    public void setJ12gysqcs(String j12gysqcs) {
        this.j12gysqcs = j12gysqcs;
    }

    /**
     * 手机在网状态
     * @return sjzwzt 手机在网状态
     */
    public String getSjzwzt() {
        return sjzwzt;
    }

    /**
     * 手机在网状态
     * @param sjzwzt 手机在网状态
     */
    public void setSjzwzt(String sjzwzt) {
        this.sjzwzt = sjzwzt;
    }

    /**
     * 手机在网时长
     * @return sjzwsc 手机在网时长
     */
    public String getSjzwsc() {
        return sjzwsc;
    }

    /**
     * 手机在网时长
     * @param sjzwsc 手机在网时长
     */
    public void setSjzwsc(String sjzwsc) {
        this.sjzwsc = sjzwsc;
    }
}