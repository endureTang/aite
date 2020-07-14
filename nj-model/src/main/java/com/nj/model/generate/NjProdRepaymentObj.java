package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjProdRepaymentObj {
    private String id;

    /**
     * 产品ID
     */
    @ApiModelProperty(value = "产品ID")
    private String productId;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    private String userMobile;

    /**
     * 还款角色(-1:不配置.0:借款人还款,1:渠道还款.2:指定渠道还款)
     */
    @ApiModelProperty(value = "还款角色(-1:不配置.0:借款人还款,1:渠道还款.2:指定渠道还款)")
    private Integer repayRole;

    /**
     * 还款顺序
     */
    @ApiModelProperty(value = "还款顺序")
    private Integer repayOrder;

    /**
     * 展示名称
     */
    @ApiModelProperty(value = "展示名称")
    private String displayName;

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
     * 产品ID
     * @return product_id 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 产品ID
     * @param productId 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 用户手机号
     * @return user_mobile 用户手机号
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 用户手机号
     * @param userMobile 用户手机号
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * 还款角色(-1:不配置.0:借款人还款,1:渠道还款.2:指定渠道还款)
     * @return repay_role 还款角色(-1:不配置.0:借款人还款,1:渠道还款.2:指定渠道还款)
     */
    public Integer getRepayRole() {
        return repayRole;
    }

    /**
     * 还款角色(-1:不配置.0:借款人还款,1:渠道还款.2:指定渠道还款)
     * @param repayRole 还款角色(-1:不配置.0:借款人还款,1:渠道还款.2:指定渠道还款)
     */
    public void setRepayRole(Integer repayRole) {
        this.repayRole = repayRole;
    }

    /**
     * 还款顺序
     * @return repay_order 还款顺序
     */
    public Integer getRepayOrder() {
        return repayOrder;
    }

    /**
     * 还款顺序
     * @param repayOrder 还款顺序
     */
    public void setRepayOrder(Integer repayOrder) {
        this.repayOrder = repayOrder;
    }

    /**
     * 展示名称
     * @return display_name 展示名称
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 展示名称
     * @param displayName 展示名称
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}