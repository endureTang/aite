package com.nj.model.generate;

import java.util.Date;

import com.nj.core.base.entity.NjIdEntity;

import io.swagger.annotations.ApiModelProperty;

public class SysRole {
	private String id;
    /**
     * 类型（1：管理后台，2：业务后台）
     */
    @ApiModelProperty(value = "类型（1：管理后台，2：业务后台）")
    private Integer type;

    /**
     * 归属机构
     */
    @ApiModelProperty(value = "归属机构")
    private String officeId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String name;

    /**
     * 英文名称
     */
    @ApiModelProperty(value = "英文名称")
    private String enname;

    /**
     * 角色类型
     */
    @ApiModelProperty(value = "角色类型")
    private String roleType;

    /**
     * 数据范围
     */
    @ApiModelProperty(value = "数据范围")
    private String dataScope;

    /**
     * 是否系统数据
     */
    @ApiModelProperty(value = "是否系统数据")
    private String isSys;

    /**
     * 是否可用
     */
    @ApiModelProperty(value = "是否可用")
    private String useable;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private Boolean delFlag;

    /**
     * 类型（1：管理后台，2：业务后台）
     * @return type 类型（1：管理后台，2：业务后台）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型（1：管理后台，2：业务后台）
     * @param type 类型（1：管理后台，2：业务后台）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 归属机构
     * @return office_id 归属机构
     */
    public String getOfficeId() {
        return officeId;
    }

    /**
     * 归属机构
     * @param officeId 归属机构
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    /**
     * 角色名称
     * @return name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 英文名称
     * @return enname 英文名称
     */
    public String getEnname() {
        return enname;
    }

    /**
     * 英文名称
     * @param enname 英文名称
     */
    public void setEnname(String enname) {
        this.enname = enname;
    }

    /**
     * 角色类型
     * @return role_type 角色类型
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 角色类型
     * @param roleType 角色类型
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    /**
     * 数据范围
     * @return data_scope 数据范围
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * 数据范围
     * @param dataScope 数据范围
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    /**
     * 是否系统数据
     * @return is_sys 是否系统数据
     */
    public String getIsSys() {
        return isSys;
    }

    /**
     * 是否系统数据
     * @param isSys 是否系统数据
     */
    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    /**
     * 是否可用
     * @return useable 是否可用
     */
    public String getUseable() {
        return useable;
    }

    /**
     * 是否可用
     * @param useable 是否可用
     */
    public void setUseable(String useable) {
        this.useable = useable;
    }

    /**
     * 创建者
     * @return create_by 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 更新者
     * @return update_by 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     * @return update_date 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 备注信息
     * @return remarks 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注信息
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 删除标记
     * @return del_flag 删除标记
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标记
     * @param delFlag 删除标记
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
}