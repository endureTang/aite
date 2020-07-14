package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjUserBasicInfoExample {
    /**
     * nj_user_basic_info
     */
    protected String orderByClause;

    /**
     * nj_user_basic_info
     */
    protected boolean distinct;

    /**
     * nj_user_basic_info
     */
    protected List<Criteria> oredCriteria;

    public NjUserBasicInfoExample() {
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
     * nj_user_basic_info 2019-02-27
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

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
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

        public Criteria andMarrStatusIsNull() {
            addCriterion("marr_status is null");
            return (Criteria) this;
        }

        public Criteria andMarrStatusIsNotNull() {
            addCriterion("marr_status is not null");
            return (Criteria) this;
        }

        public Criteria andMarrStatusEqualTo(Integer value) {
            addCriterion("marr_status =", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusNotEqualTo(Integer value) {
            addCriterion("marr_status <>", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusGreaterThan(Integer value) {
            addCriterion("marr_status >", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("marr_status >=", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusLessThan(Integer value) {
            addCriterion("marr_status <", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusLessThanOrEqualTo(Integer value) {
            addCriterion("marr_status <=", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusIn(List<Integer> values) {
            addCriterion("marr_status in", values, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusNotIn(List<Integer> values) {
            addCriterion("marr_status not in", values, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusBetween(Integer value1, Integer value2) {
            addCriterion("marr_status between", value1, value2, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("marr_status not between", value1, value2, "marrStatus");
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andMaxEducationIsNull() {
            addCriterion("max_education is null");
            return (Criteria) this;
        }

        public Criteria andMaxEducationIsNotNull() {
            addCriterion("max_education is not null");
            return (Criteria) this;
        }

        public Criteria andMaxEducationEqualTo(Integer value) {
            addCriterion("max_education =", value, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationNotEqualTo(Integer value) {
            addCriterion("max_education <>", value, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationGreaterThan(Integer value) {
            addCriterion("max_education >", value, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_education >=", value, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationLessThan(Integer value) {
            addCriterion("max_education <", value, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationLessThanOrEqualTo(Integer value) {
            addCriterion("max_education <=", value, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationIn(List<Integer> values) {
            addCriterion("max_education in", values, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationNotIn(List<Integer> values) {
            addCriterion("max_education not in", values, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationBetween(Integer value1, Integer value2) {
            addCriterion("max_education between", value1, value2, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andMaxEducationNotBetween(Integer value1, Integer value2) {
            addCriterion("max_education not between", value1, value2, "maxEducation");
            return (Criteria) this;
        }

        public Criteria andEstateTypeIsNull() {
            addCriterion("estate_type is null");
            return (Criteria) this;
        }

        public Criteria andEstateTypeIsNotNull() {
            addCriterion("estate_type is not null");
            return (Criteria) this;
        }

        public Criteria andEstateTypeEqualTo(Integer value) {
            addCriterion("estate_type =", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeNotEqualTo(Integer value) {
            addCriterion("estate_type <>", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeGreaterThan(Integer value) {
            addCriterion("estate_type >", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("estate_type >=", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeLessThan(Integer value) {
            addCriterion("estate_type <", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("estate_type <=", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeIn(List<Integer> values) {
            addCriterion("estate_type in", values, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeNotIn(List<Integer> values) {
            addCriterion("estate_type not in", values, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeBetween(Integer value1, Integer value2) {
            addCriterion("estate_type between", value1, value2, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("estate_type not between", value1, value2, "estateType");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkIsNull() {
            addCriterion("bind_bank_cark is null");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkIsNotNull() {
            addCriterion("bind_bank_cark is not null");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkEqualTo(Boolean value) {
            addCriterion("bind_bank_cark =", value, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkNotEqualTo(Boolean value) {
            addCriterion("bind_bank_cark <>", value, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkGreaterThan(Boolean value) {
            addCriterion("bind_bank_cark >", value, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bind_bank_cark >=", value, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkLessThan(Boolean value) {
            addCriterion("bind_bank_cark <", value, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkLessThanOrEqualTo(Boolean value) {
            addCriterion("bind_bank_cark <=", value, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkIn(List<Boolean> values) {
            addCriterion("bind_bank_cark in", values, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkNotIn(List<Boolean> values) {
            addCriterion("bind_bank_cark not in", values, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkBetween(Boolean value1, Boolean value2) {
            addCriterion("bind_bank_cark between", value1, value2, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBindBankCarkNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bind_bank_cark not between", value1, value2, "bindBankCark");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterIsNull() {
            addCriterion("household_register is null");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterIsNotNull() {
            addCriterion("household_register is not null");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterEqualTo(String value) {
            addCriterion("household_register =", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterNotEqualTo(String value) {
            addCriterion("household_register <>", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterGreaterThan(String value) {
            addCriterion("household_register >", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterGreaterThanOrEqualTo(String value) {
            addCriterion("household_register >=", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterLessThan(String value) {
            addCriterion("household_register <", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterLessThanOrEqualTo(String value) {
            addCriterion("household_register <=", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterLike(String value) {
            addCriterion("household_register like", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterNotLike(String value) {
            addCriterion("household_register not like", value, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterIn(List<String> values) {
            addCriterion("household_register in", values, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterNotIn(List<String> values) {
            addCriterion("household_register not in", values, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterBetween(String value1, String value2) {
            addCriterion("household_register between", value1, value2, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andHouseholdRegisterNotBetween(String value1, String value2) {
            addCriterion("household_register not between", value1, value2, "householdRegister");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Boolean value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Boolean value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Boolean value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Boolean value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Boolean> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Boolean> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIsNull() {
            addCriterion("id_card_num is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIsNotNull() {
            addCriterion("id_card_num is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumEqualTo(String value) {
            addCriterion("id_card_num =", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotEqualTo(String value) {
            addCriterion("id_card_num <>", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumGreaterThan(String value) {
            addCriterion("id_card_num >", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_num >=", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLessThan(String value) {
            addCriterion("id_card_num <", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLessThanOrEqualTo(String value) {
            addCriterion("id_card_num <=", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLike(String value) {
            addCriterion("id_card_num like", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotLike(String value) {
            addCriterion("id_card_num not like", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIn(List<String> values) {
            addCriterion("id_card_num in", values, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotIn(List<String> values) {
            addCriterion("id_card_num not in", values, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumBetween(String value1, String value2) {
            addCriterion("id_card_num between", value1, value2, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotBetween(String value1, String value2) {
            addCriterion("id_card_num not between", value1, value2, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
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

        public Criteria andAddressNatureIsNull() {
            addCriterion("address_nature is null");
            return (Criteria) this;
        }

        public Criteria andAddressNatureIsNotNull() {
            addCriterion("address_nature is not null");
            return (Criteria) this;
        }

        public Criteria andAddressNatureEqualTo(String value) {
            addCriterion("address_nature =", value, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureNotEqualTo(String value) {
            addCriterion("address_nature <>", value, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureGreaterThan(String value) {
            addCriterion("address_nature >", value, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureGreaterThanOrEqualTo(String value) {
            addCriterion("address_nature >=", value, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureLessThan(String value) {
            addCriterion("address_nature <", value, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureLessThanOrEqualTo(String value) {
            addCriterion("address_nature <=", value, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureLike(String value) {
            addCriterion("address_nature like", value, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureNotLike(String value) {
            addCriterion("address_nature not like", value, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureIn(List<String> values) {
            addCriterion("address_nature in", values, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureNotIn(List<String> values) {
            addCriterion("address_nature not in", values, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureBetween(String value1, String value2) {
            addCriterion("address_nature between", value1, value2, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressNatureNotBetween(String value1, String value2) {
            addCriterion("address_nature not between", value1, value2, "addressNature");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyIsNull() {
            addCriterion("address_money is null");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyIsNotNull() {
            addCriterion("address_money is not null");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyEqualTo(BigDecimal value) {
            addCriterion("address_money =", value, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyNotEqualTo(BigDecimal value) {
            addCriterion("address_money <>", value, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyGreaterThan(BigDecimal value) {
            addCriterion("address_money >", value, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("address_money >=", value, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyLessThan(BigDecimal value) {
            addCriterion("address_money <", value, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("address_money <=", value, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyIn(List<BigDecimal> values) {
            addCriterion("address_money in", values, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyNotIn(List<BigDecimal> values) {
            addCriterion("address_money not in", values, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("address_money between", value1, value2, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andAddressMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("address_money not between", value1, value2, "addressMoney");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryIsNull() {
            addCriterion("own_industry is null");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryIsNotNull() {
            addCriterion("own_industry is not null");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryEqualTo(String value) {
            addCriterion("own_industry =", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryNotEqualTo(String value) {
            addCriterion("own_industry <>", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryGreaterThan(String value) {
            addCriterion("own_industry >", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("own_industry >=", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryLessThan(String value) {
            addCriterion("own_industry <", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryLessThanOrEqualTo(String value) {
            addCriterion("own_industry <=", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryLike(String value) {
            addCriterion("own_industry like", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryNotLike(String value) {
            addCriterion("own_industry not like", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryIn(List<String> values) {
            addCriterion("own_industry in", values, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryNotIn(List<String> values) {
            addCriterion("own_industry not in", values, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryBetween(String value1, String value2) {
            addCriterion("own_industry between", value1, value2, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryNotBetween(String value1, String value2) {
            addCriterion("own_industry not between", value1, value2, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andWeixinNoIsNull() {
            addCriterion("weixin_no is null");
            return (Criteria) this;
        }

        public Criteria andWeixinNoIsNotNull() {
            addCriterion("weixin_no is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinNoEqualTo(String value) {
            addCriterion("weixin_no =", value, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoNotEqualTo(String value) {
            addCriterion("weixin_no <>", value, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoGreaterThan(String value) {
            addCriterion("weixin_no >", value, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_no >=", value, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoLessThan(String value) {
            addCriterion("weixin_no <", value, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoLessThanOrEqualTo(String value) {
            addCriterion("weixin_no <=", value, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoLike(String value) {
            addCriterion("weixin_no like", value, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoNotLike(String value) {
            addCriterion("weixin_no not like", value, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoIn(List<String> values) {
            addCriterion("weixin_no in", values, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoNotIn(List<String> values) {
            addCriterion("weixin_no not in", values, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoBetween(String value1, String value2) {
            addCriterion("weixin_no between", value1, value2, "weixinNo");
            return (Criteria) this;
        }

        public Criteria andWeixinNoNotBetween(String value1, String value2) {
            addCriterion("weixin_no not between", value1, value2, "weixinNo");
            return (Criteria) this;
        }
    }

    /**
     * nj_user_basic_info
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_user_basic_info 2019-02-27
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