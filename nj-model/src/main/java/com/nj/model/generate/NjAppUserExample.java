package com.nj.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjAppUserExample {
    /**
     * nj_app_user
     */
    protected String orderByClause;

    /**
     * nj_app_user
     */
    protected boolean distinct;

    /**
     * nj_app_user
     */
    protected List<Criteria> oredCriteria;

    public NjAppUserExample() {
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
     * nj_app_user 2018-06-26
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andMialIsNull() {
            addCriterion("mial is null");
            return (Criteria) this;
        }

        public Criteria andMialIsNotNull() {
            addCriterion("mial is not null");
            return (Criteria) this;
        }

        public Criteria andMialEqualTo(String value) {
            addCriterion("mial =", value, "mial");
            return (Criteria) this;
        }

        public Criteria andMialNotEqualTo(String value) {
            addCriterion("mial <>", value, "mial");
            return (Criteria) this;
        }

        public Criteria andMialGreaterThan(String value) {
            addCriterion("mial >", value, "mial");
            return (Criteria) this;
        }

        public Criteria andMialGreaterThanOrEqualTo(String value) {
            addCriterion("mial >=", value, "mial");
            return (Criteria) this;
        }

        public Criteria andMialLessThan(String value) {
            addCriterion("mial <", value, "mial");
            return (Criteria) this;
        }

        public Criteria andMialLessThanOrEqualTo(String value) {
            addCriterion("mial <=", value, "mial");
            return (Criteria) this;
        }

        public Criteria andMialLike(String value) {
            addCriterion("mial like", value, "mial");
            return (Criteria) this;
        }

        public Criteria andMialNotLike(String value) {
            addCriterion("mial not like", value, "mial");
            return (Criteria) this;
        }

        public Criteria andMialIn(List<String> values) {
            addCriterion("mial in", values, "mial");
            return (Criteria) this;
        }

        public Criteria andMialNotIn(List<String> values) {
            addCriterion("mial not in", values, "mial");
            return (Criteria) this;
        }

        public Criteria andMialBetween(String value1, String value2) {
            addCriterion("mial between", value1, value2, "mial");
            return (Criteria) this;
        }

        public Criteria andMialNotBetween(String value1, String value2) {
            addCriterion("mial not between", value1, value2, "mial");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIsNull() {
            addCriterion("user_avatar is null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIsNotNull() {
            addCriterion("user_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarEqualTo(String value) {
            addCriterion("user_avatar =", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotEqualTo(String value) {
            addCriterion("user_avatar <>", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarGreaterThan(String value) {
            addCriterion("user_avatar >", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("user_avatar >=", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLessThan(String value) {
            addCriterion("user_avatar <", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLessThanOrEqualTo(String value) {
            addCriterion("user_avatar <=", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarLike(String value) {
            addCriterion("user_avatar like", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotLike(String value) {
            addCriterion("user_avatar not like", value, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarIn(List<String> values) {
            addCriterion("user_avatar in", values, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotIn(List<String> values) {
            addCriterion("user_avatar not in", values, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarBetween(String value1, String value2) {
            addCriterion("user_avatar between", value1, value2, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserAvatarNotBetween(String value1, String value2) {
            addCriterion("user_avatar not between", value1, value2, "userAvatar");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andTrueNameIsNull() {
            addCriterion("true_name is null");
            return (Criteria) this;
        }

        public Criteria andTrueNameIsNotNull() {
            addCriterion("true_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrueNameEqualTo(String value) {
            addCriterion("true_name =", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotEqualTo(String value) {
            addCriterion("true_name <>", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameGreaterThan(String value) {
            addCriterion("true_name >", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameGreaterThanOrEqualTo(String value) {
            addCriterion("true_name >=", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLessThan(String value) {
            addCriterion("true_name <", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLessThanOrEqualTo(String value) {
            addCriterion("true_name <=", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLike(String value) {
            addCriterion("true_name like", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotLike(String value) {
            addCriterion("true_name not like", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameIn(List<String> values) {
            addCriterion("true_name in", values, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotIn(List<String> values) {
            addCriterion("true_name not in", values, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameBetween(String value1, String value2) {
            addCriterion("true_name between", value1, value2, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotBetween(String value1, String value2) {
            addCriterion("true_name not between", value1, value2, "trueName");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdIsNull() {
            addCriterion("identify_id is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdIsNotNull() {
            addCriterion("identify_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdEqualTo(String value) {
            addCriterion("identify_id =", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdNotEqualTo(String value) {
            addCriterion("identify_id <>", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdGreaterThan(String value) {
            addCriterion("identify_id >", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdGreaterThanOrEqualTo(String value) {
            addCriterion("identify_id >=", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdLessThan(String value) {
            addCriterion("identify_id <", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdLessThanOrEqualTo(String value) {
            addCriterion("identify_id <=", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdLike(String value) {
            addCriterion("identify_id like", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdNotLike(String value) {
            addCriterion("identify_id not like", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdIn(List<String> values) {
            addCriterion("identify_id in", values, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdNotIn(List<String> values) {
            addCriterion("identify_id not in", values, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdBetween(String value1, String value2) {
            addCriterion("identify_id between", value1, value2, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdNotBetween(String value1, String value2) {
            addCriterion("identify_id not between", value1, value2, "identifyId");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameIsNull() {
            addCriterion("defi_true_name is null");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameIsNotNull() {
            addCriterion("defi_true_name is not null");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameEqualTo(String value) {
            addCriterion("defi_true_name =", value, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameNotEqualTo(String value) {
            addCriterion("defi_true_name <>", value, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameGreaterThan(String value) {
            addCriterion("defi_true_name >", value, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameGreaterThanOrEqualTo(String value) {
            addCriterion("defi_true_name >=", value, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameLessThan(String value) {
            addCriterion("defi_true_name <", value, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameLessThanOrEqualTo(String value) {
            addCriterion("defi_true_name <=", value, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameLike(String value) {
            addCriterion("defi_true_name like", value, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameNotLike(String value) {
            addCriterion("defi_true_name not like", value, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameIn(List<String> values) {
            addCriterion("defi_true_name in", values, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameNotIn(List<String> values) {
            addCriterion("defi_true_name not in", values, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameBetween(String value1, String value2) {
            addCriterion("defi_true_name between", value1, value2, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiTrueNameNotBetween(String value1, String value2) {
            addCriterion("defi_true_name not between", value1, value2, "defiTrueName");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdIsNull() {
            addCriterion("defi_identify_id is null");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdIsNotNull() {
            addCriterion("defi_identify_id is not null");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdEqualTo(String value) {
            addCriterion("defi_identify_id =", value, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdNotEqualTo(String value) {
            addCriterion("defi_identify_id <>", value, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdGreaterThan(String value) {
            addCriterion("defi_identify_id >", value, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdGreaterThanOrEqualTo(String value) {
            addCriterion("defi_identify_id >=", value, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdLessThan(String value) {
            addCriterion("defi_identify_id <", value, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdLessThanOrEqualTo(String value) {
            addCriterion("defi_identify_id <=", value, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdLike(String value) {
            addCriterion("defi_identify_id like", value, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdNotLike(String value) {
            addCriterion("defi_identify_id not like", value, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdIn(List<String> values) {
            addCriterion("defi_identify_id in", values, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdNotIn(List<String> values) {
            addCriterion("defi_identify_id not in", values, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdBetween(String value1, String value2) {
            addCriterion("defi_identify_id between", value1, value2, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andDefiIdentifyIdNotBetween(String value1, String value2) {
            addCriterion("defi_identify_id not between", value1, value2, "defiIdentifyId");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIsNull() {
            addCriterion("auth_token is null");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIsNotNull() {
            addCriterion("auth_token is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTokenEqualTo(String value) {
            addCriterion("auth_token =", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotEqualTo(String value) {
            addCriterion("auth_token <>", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenGreaterThan(String value) {
            addCriterion("auth_token >", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenGreaterThanOrEqualTo(String value) {
            addCriterion("auth_token >=", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLessThan(String value) {
            addCriterion("auth_token <", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLessThanOrEqualTo(String value) {
            addCriterion("auth_token <=", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLike(String value) {
            addCriterion("auth_token like", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotLike(String value) {
            addCriterion("auth_token not like", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIn(List<String> values) {
            addCriterion("auth_token in", values, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotIn(List<String> values) {
            addCriterion("auth_token not in", values, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenBetween(String value1, String value2) {
            addCriterion("auth_token between", value1, value2, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotBetween(String value1, String value2) {
            addCriterion("auth_token not between", value1, value2, "authToken");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsIsNull() {
            addCriterion("last_login_device_os is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsIsNotNull() {
            addCriterion("last_login_device_os is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsEqualTo(String value) {
            addCriterion("last_login_device_os =", value, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsNotEqualTo(String value) {
            addCriterion("last_login_device_os <>", value, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsGreaterThan(String value) {
            addCriterion("last_login_device_os >", value, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_device_os >=", value, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsLessThan(String value) {
            addCriterion("last_login_device_os <", value, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsLessThanOrEqualTo(String value) {
            addCriterion("last_login_device_os <=", value, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsLike(String value) {
            addCriterion("last_login_device_os like", value, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsNotLike(String value) {
            addCriterion("last_login_device_os not like", value, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsIn(List<String> values) {
            addCriterion("last_login_device_os in", values, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsNotIn(List<String> values) {
            addCriterion("last_login_device_os not in", values, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsBetween(String value1, String value2) {
            addCriterion("last_login_device_os between", value1, value2, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceOsNotBetween(String value1, String value2) {
            addCriterion("last_login_device_os not between", value1, value2, "lastLoginDeviceOs");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdIsNull() {
            addCriterion("last_login_device_id is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdIsNotNull() {
            addCriterion("last_login_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdEqualTo(String value) {
            addCriterion("last_login_device_id =", value, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdNotEqualTo(String value) {
            addCriterion("last_login_device_id <>", value, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdGreaterThan(String value) {
            addCriterion("last_login_device_id >", value, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_device_id >=", value, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdLessThan(String value) {
            addCriterion("last_login_device_id <", value, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("last_login_device_id <=", value, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdLike(String value) {
            addCriterion("last_login_device_id like", value, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdNotLike(String value) {
            addCriterion("last_login_device_id not like", value, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdIn(List<String> values) {
            addCriterion("last_login_device_id in", values, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdNotIn(List<String> values) {
            addCriterion("last_login_device_id not in", values, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdBetween(String value1, String value2) {
            addCriterion("last_login_device_id between", value1, value2, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceIdNotBetween(String value1, String value2) {
            addCriterion("last_login_device_id not between", value1, value2, "lastLoginDeviceId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeIsNull() {
            addCriterion("last_login_device_type is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeIsNotNull() {
            addCriterion("last_login_device_type is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeEqualTo(String value) {
            addCriterion("last_login_device_type =", value, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeNotEqualTo(String value) {
            addCriterion("last_login_device_type <>", value, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeGreaterThan(String value) {
            addCriterion("last_login_device_type >", value, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_device_type >=", value, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeLessThan(String value) {
            addCriterion("last_login_device_type <", value, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("last_login_device_type <=", value, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeLike(String value) {
            addCriterion("last_login_device_type like", value, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeNotLike(String value) {
            addCriterion("last_login_device_type not like", value, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeIn(List<String> values) {
            addCriterion("last_login_device_type in", values, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeNotIn(List<String> values) {
            addCriterion("last_login_device_type not in", values, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeBetween(String value1, String value2) {
            addCriterion("last_login_device_type between", value1, value2, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("last_login_device_type not between", value1, value2, "lastLoginDeviceType");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNull() {
            addCriterion("last_login_date is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNotNull() {
            addCriterion("last_login_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateEqualTo(Date value) {
            addCriterion("last_login_date =", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotEqualTo(Date value) {
            addCriterion("last_login_date <>", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThan(Date value) {
            addCriterion("last_login_date >", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_date >=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThan(Date value) {
            addCriterion("last_login_date <", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThanOrEqualTo(Date value) {
            addCriterion("last_login_date <=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIn(List<Date> values) {
            addCriterion("last_login_date in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotIn(List<Date> values) {
            addCriterion("last_login_date not in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateBetween(Date value1, Date value2) {
            addCriterion("last_login_date between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotBetween(Date value1, Date value2) {
            addCriterion("last_login_date not between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncIsNull() {
            addCriterion("is_contact_sync is null");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncIsNotNull() {
            addCriterion("is_contact_sync is not null");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncEqualTo(Boolean value) {
            addCriterion("is_contact_sync =", value, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncNotEqualTo(Boolean value) {
            addCriterion("is_contact_sync <>", value, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncGreaterThan(Boolean value) {
            addCriterion("is_contact_sync >", value, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_contact_sync >=", value, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncLessThan(Boolean value) {
            addCriterion("is_contact_sync <", value, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncLessThanOrEqualTo(Boolean value) {
            addCriterion("is_contact_sync <=", value, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncIn(List<Boolean> values) {
            addCriterion("is_contact_sync in", values, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncNotIn(List<Boolean> values) {
            addCriterion("is_contact_sync not in", values, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncBetween(Boolean value1, Boolean value2) {
            addCriterion("is_contact_sync between", value1, value2, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andIsContactSyncNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_contact_sync not between", value1, value2, "isContactSync");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateIsNull() {
            addCriterion("last_contact_sync_date is null");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateIsNotNull() {
            addCriterion("last_contact_sync_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateEqualTo(Date value) {
            addCriterion("last_contact_sync_date =", value, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateNotEqualTo(Date value) {
            addCriterion("last_contact_sync_date <>", value, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateGreaterThan(Date value) {
            addCriterion("last_contact_sync_date >", value, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_contact_sync_date >=", value, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateLessThan(Date value) {
            addCriterion("last_contact_sync_date <", value, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateLessThanOrEqualTo(Date value) {
            addCriterion("last_contact_sync_date <=", value, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateIn(List<Date> values) {
            addCriterion("last_contact_sync_date in", values, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateNotIn(List<Date> values) {
            addCriterion("last_contact_sync_date not in", values, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateBetween(Date value1, Date value2) {
            addCriterion("last_contact_sync_date between", value1, value2, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andLastContactSyncDateNotBetween(Date value1, Date value2) {
            addCriterion("last_contact_sync_date not between", value1, value2, "lastContactSyncDate");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdIsNull() {
            addCriterion("channel_user_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdIsNotNull() {
            addCriterion("channel_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdEqualTo(String value) {
            addCriterion("channel_user_id =", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdNotEqualTo(String value) {
            addCriterion("channel_user_id <>", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdGreaterThan(String value) {
            addCriterion("channel_user_id >", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_user_id >=", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdLessThan(String value) {
            addCriterion("channel_user_id <", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdLessThanOrEqualTo(String value) {
            addCriterion("channel_user_id <=", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdLike(String value) {
            addCriterion("channel_user_id like", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdNotLike(String value) {
            addCriterion("channel_user_id not like", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdIn(List<String> values) {
            addCriterion("channel_user_id in", values, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdNotIn(List<String> values) {
            addCriterion("channel_user_id not in", values, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdBetween(String value1, String value2) {
            addCriterion("channel_user_id between", value1, value2, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdNotBetween(String value1, String value2) {
            addCriterion("channel_user_id not between", value1, value2, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andFraudTypeIsNull() {
            addCriterion("fraud_type is null");
            return (Criteria) this;
        }

        public Criteria andFraudTypeIsNotNull() {
            addCriterion("fraud_type is not null");
            return (Criteria) this;
        }

        public Criteria andFraudTypeEqualTo(Integer value) {
            addCriterion("fraud_type =", value, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeNotEqualTo(Integer value) {
            addCriterion("fraud_type <>", value, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeGreaterThan(Integer value) {
            addCriterion("fraud_type >", value, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fraud_type >=", value, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeLessThan(Integer value) {
            addCriterion("fraud_type <", value, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeLessThanOrEqualTo(Integer value) {
            addCriterion("fraud_type <=", value, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeIn(List<Integer> values) {
            addCriterion("fraud_type in", values, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeNotIn(List<Integer> values) {
            addCriterion("fraud_type not in", values, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeBetween(Integer value1, Integer value2) {
            addCriterion("fraud_type between", value1, value2, "fraudType");
            return (Criteria) this;
        }

        public Criteria andFraudTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fraud_type not between", value1, value2, "fraudType");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }
    }

    /**
     * nj_app_user
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_app_user 2018-06-26
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