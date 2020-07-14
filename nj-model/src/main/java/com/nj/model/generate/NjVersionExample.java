package com.nj.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjVersionExample {
    /**
     * nj_version
     */
    protected String orderByClause;

    /**
     * nj_version
     */
    protected boolean distinct;

    /**
     * nj_version
     */
    protected List<Criteria> oredCriteria;

    public NjVersionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * nj_version 2018-08-06
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeIsNull() {
            addCriterion("update_notice is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeIsNotNull() {
            addCriterion("update_notice is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeEqualTo(String value) {
            addCriterion("update_notice =", value, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeNotEqualTo(String value) {
            addCriterion("update_notice <>", value, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeGreaterThan(String value) {
            addCriterion("update_notice >", value, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("update_notice >=", value, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeLessThan(String value) {
            addCriterion("update_notice <", value, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeLessThanOrEqualTo(String value) {
            addCriterion("update_notice <=", value, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeLike(String value) {
            addCriterion("update_notice like", value, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeNotLike(String value) {
            addCriterion("update_notice not like", value, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeIn(List<String> values) {
            addCriterion("update_notice in", values, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeNotIn(List<String> values) {
            addCriterion("update_notice not in", values, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeBetween(String value1, String value2) {
            addCriterion("update_notice between", value1, value2, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateNoticeNotBetween(String value1, String value2) {
            addCriterion("update_notice not between", value1, value2, "updateNotice");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionIsNull() {
            addCriterion("update_ios_version is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionIsNotNull() {
            addCriterion("update_ios_version is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionEqualTo(String value) {
            addCriterion("update_ios_version =", value, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionNotEqualTo(String value) {
            addCriterion("update_ios_version <>", value, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionGreaterThan(String value) {
            addCriterion("update_ios_version >", value, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionGreaterThanOrEqualTo(String value) {
            addCriterion("update_ios_version >=", value, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionLessThan(String value) {
            addCriterion("update_ios_version <", value, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionLessThanOrEqualTo(String value) {
            addCriterion("update_ios_version <=", value, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionLike(String value) {
            addCriterion("update_ios_version like", value, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionNotLike(String value) {
            addCriterion("update_ios_version not like", value, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionIn(List<String> values) {
            addCriterion("update_ios_version in", values, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionNotIn(List<String> values) {
            addCriterion("update_ios_version not in", values, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionBetween(String value1, String value2) {
            addCriterion("update_ios_version between", value1, value2, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionNotBetween(String value1, String value2) {
            addCriterion("update_ios_version not between", value1, value2, "updateIosVersion");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlIsNull() {
            addCriterion("android_download_url is null");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlIsNotNull() {
            addCriterion("android_download_url is not null");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlEqualTo(String value) {
            addCriterion("android_download_url =", value, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlNotEqualTo(String value) {
            addCriterion("android_download_url <>", value, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlGreaterThan(String value) {
            addCriterion("android_download_url >", value, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("android_download_url >=", value, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlLessThan(String value) {
            addCriterion("android_download_url <", value, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("android_download_url <=", value, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlLike(String value) {
            addCriterion("android_download_url like", value, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlNotLike(String value) {
            addCriterion("android_download_url not like", value, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlIn(List<String> values) {
            addCriterion("android_download_url in", values, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlNotIn(List<String> values) {
            addCriterion("android_download_url not in", values, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlBetween(String value1, String value2) {
            addCriterion("android_download_url between", value1, value2, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andAndroidDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("android_download_url not between", value1, value2, "androidDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlIsNull() {
            addCriterion("ios_download_url is null");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlIsNotNull() {
            addCriterion("ios_download_url is not null");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlEqualTo(String value) {
            addCriterion("ios_download_url =", value, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlNotEqualTo(String value) {
            addCriterion("ios_download_url <>", value, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlGreaterThan(String value) {
            addCriterion("ios_download_url >", value, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ios_download_url >=", value, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlLessThan(String value) {
            addCriterion("ios_download_url <", value, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("ios_download_url <=", value, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlLike(String value) {
            addCriterion("ios_download_url like", value, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlNotLike(String value) {
            addCriterion("ios_download_url not like", value, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlIn(List<String> values) {
            addCriterion("ios_download_url in", values, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlNotIn(List<String> values) {
            addCriterion("ios_download_url not in", values, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlBetween(String value1, String value2) {
            addCriterion("ios_download_url between", value1, value2, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("ios_download_url not between", value1, value2, "iosDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateIsNull() {
            addCriterion("is_force_update is null");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateIsNotNull() {
            addCriterion("is_force_update is not null");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateEqualTo(Boolean value) {
            addCriterion("is_force_update =", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateNotEqualTo(Boolean value) {
            addCriterion("is_force_update <>", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateGreaterThan(Boolean value) {
            addCriterion("is_force_update >", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_force_update >=", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateLessThan(Boolean value) {
            addCriterion("is_force_update <", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateLessThanOrEqualTo(Boolean value) {
            addCriterion("is_force_update <=", value, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateIn(List<Boolean> values) {
            addCriterion("is_force_update in", values, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateNotIn(List<Boolean> values) {
            addCriterion("is_force_update not in", values, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateBetween(Boolean value1, Boolean value2) {
            addCriterion("is_force_update between", value1, value2, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andIsForceUpdateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_force_update not between", value1, value2, "isForceUpdate");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionIsNull() {
            addCriterion("update_android_version is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionIsNotNull() {
            addCriterion("update_android_version is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionEqualTo(String value) {
            addCriterion("update_android_version =", value, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionNotEqualTo(String value) {
            addCriterion("update_android_version <>", value, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionGreaterThan(String value) {
            addCriterion("update_android_version >", value, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionGreaterThanOrEqualTo(String value) {
            addCriterion("update_android_version >=", value, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionLessThan(String value) {
            addCriterion("update_android_version <", value, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionLessThanOrEqualTo(String value) {
            addCriterion("update_android_version <=", value, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionLike(String value) {
            addCriterion("update_android_version like", value, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionNotLike(String value) {
            addCriterion("update_android_version not like", value, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionIn(List<String> values) {
            addCriterion("update_android_version in", values, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionNotIn(List<String> values) {
            addCriterion("update_android_version not in", values, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionBetween(String value1, String value2) {
            addCriterion("update_android_version between", value1, value2, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionNotBetween(String value1, String value2) {
            addCriterion("update_android_version not between", value1, value2, "updateAndroidVersion");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeIsNull() {
            addCriterion("update_ios_version_code is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeIsNotNull() {
            addCriterion("update_ios_version_code is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeEqualTo(Integer value) {
            addCriterion("update_ios_version_code =", value, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeNotEqualTo(Integer value) {
            addCriterion("update_ios_version_code <>", value, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeGreaterThan(Integer value) {
            addCriterion("update_ios_version_code >", value, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_ios_version_code >=", value, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeLessThan(Integer value) {
            addCriterion("update_ios_version_code <", value, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("update_ios_version_code <=", value, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeIn(List<Integer> values) {
            addCriterion("update_ios_version_code in", values, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeNotIn(List<Integer> values) {
            addCriterion("update_ios_version_code not in", values, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeBetween(Integer value1, Integer value2) {
            addCriterion("update_ios_version_code between", value1, value2, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateIosVersionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_ios_version_code not between", value1, value2, "updateIosVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeIsNull() {
            addCriterion("update_android_version_code is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeIsNotNull() {
            addCriterion("update_android_version_code is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeEqualTo(Integer value) {
            addCriterion("update_android_version_code =", value, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeNotEqualTo(Integer value) {
            addCriterion("update_android_version_code <>", value, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeGreaterThan(Integer value) {
            addCriterion("update_android_version_code >", value, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_android_version_code >=", value, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeLessThan(Integer value) {
            addCriterion("update_android_version_code <", value, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("update_android_version_code <=", value, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeIn(List<Integer> values) {
            addCriterion("update_android_version_code in", values, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeNotIn(List<Integer> values) {
            addCriterion("update_android_version_code not in", values, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeBetween(Integer value1, Integer value2) {
            addCriterion("update_android_version_code between", value1, value2, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andUpdateAndroidVersionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_android_version_code not between", value1, value2, "updateAndroidVersionCode");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Integer value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Integer value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Integer value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Integer value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Integer value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<Integer> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<Integer> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Integer value1, Integer value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }
    }

    /**
     * nj_version
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_version 2018-08-06
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}