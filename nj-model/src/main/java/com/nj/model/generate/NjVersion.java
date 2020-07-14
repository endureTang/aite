package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjVersion {
    private String id;

    private String updateNotice;

    private String updateIosVersion;

    private String androidDownloadUrl;

    private String iosDownloadUrl;

    private Boolean isForceUpdate;

    private String updateAndroidVersion;

    private Integer updateIosVersionCode;

    private Integer updateAndroidVersionCode;

    private Integer type;

    private Date createDate;

    /**
     * app类型：1：微鼎，2：小贷
     */
    @ApiModelProperty(value = "app类型：1：微鼎，2：小贷")
    private Integer appType;

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
     * @return update_notice 
     */
    public String getUpdateNotice() {
        return updateNotice;
    }

    /**
     * 
     * @param updateNotice 
     */
    public void setUpdateNotice(String updateNotice) {
        this.updateNotice = updateNotice;
    }

    /**
     * 
     * @return update_ios_version 
     */
    public String getUpdateIosVersion() {
        return updateIosVersion;
    }

    /**
     * 
     * @param updateIosVersion 
     */
    public void setUpdateIosVersion(String updateIosVersion) {
        this.updateIosVersion = updateIosVersion;
    }

    /**
     * 
     * @return android_download_url 
     */
    public String getAndroidDownloadUrl() {
        return androidDownloadUrl;
    }

    /**
     * 
     * @param androidDownloadUrl 
     */
    public void setAndroidDownloadUrl(String androidDownloadUrl) {
        this.androidDownloadUrl = androidDownloadUrl;
    }

    /**
     * 
     * @return ios_download_url 
     */
    public String getIosDownloadUrl() {
        return iosDownloadUrl;
    }

    /**
     * 
     * @param iosDownloadUrl 
     */
    public void setIosDownloadUrl(String iosDownloadUrl) {
        this.iosDownloadUrl = iosDownloadUrl;
    }

    /**
     * 
     * @return is_force_update 
     */
    public Boolean getIsForceUpdate() {
        return isForceUpdate;
    }

    /**
     * 
     * @param isForceUpdate 
     */
    public void setIsForceUpdate(Boolean isForceUpdate) {
        this.isForceUpdate = isForceUpdate;
    }

    /**
     * 
     * @return update_android_version 
     */
    public String getUpdateAndroidVersion() {
        return updateAndroidVersion;
    }

    /**
     * 
     * @param updateAndroidVersion 
     */
    public void setUpdateAndroidVersion(String updateAndroidVersion) {
        this.updateAndroidVersion = updateAndroidVersion;
    }

    /**
     * 
     * @return update_ios_version_code 
     */
    public Integer getUpdateIosVersionCode() {
        return updateIosVersionCode;
    }

    /**
     * 
     * @param updateIosVersionCode 
     */
    public void setUpdateIosVersionCode(Integer updateIosVersionCode) {
        this.updateIosVersionCode = updateIosVersionCode;
    }

    /**
     * 
     * @return update_android_version_code 
     */
    public Integer getUpdateAndroidVersionCode() {
        return updateAndroidVersionCode;
    }

    /**
     * 
     * @param updateAndroidVersionCode 
     */
    public void setUpdateAndroidVersionCode(Integer updateAndroidVersionCode) {
        this.updateAndroidVersionCode = updateAndroidVersionCode;
    }

    /**
     * 
     * @return type 
     */
    public Integer getType() {
        return type;
    }

    /**
     * 
     * @param type 
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     * @return create_date 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * app类型：1：微鼎，2：小贷
     * @return app_type app类型：1：微鼎，2：小贷
     */
    public Integer getAppType() {
        return appType;
    }

    /**
     * app类型：1：微鼎，2：小贷
     * @param appType app类型：1：微鼎，2：小贷
     */
    public void setAppType(Integer appType) {
        this.appType = appType;
    }
}