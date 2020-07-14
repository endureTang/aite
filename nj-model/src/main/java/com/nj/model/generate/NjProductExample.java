package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjProductExample {
    /**
     * nj_product
     */
    protected String orderByClause;

    /**
     * nj_product
     */
    protected boolean distinct;

    /**
     * nj_product
     */
    protected List<Criteria> oredCriteria;

    public NjProductExample() {
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
     * nj_product 2019-04-10
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

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjIsNull() {
            addCriterion("product_code_zj is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjIsNotNull() {
            addCriterion("product_code_zj is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjEqualTo(String value) {
            addCriterion("product_code_zj =", value, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjNotEqualTo(String value) {
            addCriterion("product_code_zj <>", value, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjGreaterThan(String value) {
            addCriterion("product_code_zj >", value, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjGreaterThanOrEqualTo(String value) {
            addCriterion("product_code_zj >=", value, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjLessThan(String value) {
            addCriterion("product_code_zj <", value, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjLessThanOrEqualTo(String value) {
            addCriterion("product_code_zj <=", value, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjLike(String value) {
            addCriterion("product_code_zj like", value, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjNotLike(String value) {
            addCriterion("product_code_zj not like", value, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjIn(List<String> values) {
            addCriterion("product_code_zj in", values, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjNotIn(List<String> values) {
            addCriterion("product_code_zj not in", values, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjBetween(String value1, String value2) {
            addCriterion("product_code_zj between", value1, value2, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductCodeZjNotBetween(String value1, String value2) {
            addCriterion("product_code_zj not between", value1, value2, "productCodeZj");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionIsNull() {
            addCriterion("product_description is null");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionIsNotNull() {
            addCriterion("product_description is not null");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionEqualTo(String value) {
            addCriterion("product_description =", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionNotEqualTo(String value) {
            addCriterion("product_description <>", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionGreaterThan(String value) {
            addCriterion("product_description >", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("product_description >=", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionLessThan(String value) {
            addCriterion("product_description <", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionLessThanOrEqualTo(String value) {
            addCriterion("product_description <=", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionLike(String value) {
            addCriterion("product_description like", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionNotLike(String value) {
            addCriterion("product_description not like", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionIn(List<String> values) {
            addCriterion("product_description in", values, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionNotIn(List<String> values) {
            addCriterion("product_description not in", values, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionBetween(String value1, String value2) {
            addCriterion("product_description between", value1, value2, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionNotBetween(String value1, String value2) {
            addCriterion("product_description not between", value1, value2, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductTagsIsNull() {
            addCriterion("product_tags is null");
            return (Criteria) this;
        }

        public Criteria andProductTagsIsNotNull() {
            addCriterion("product_tags is not null");
            return (Criteria) this;
        }

        public Criteria andProductTagsEqualTo(String value) {
            addCriterion("product_tags =", value, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsNotEqualTo(String value) {
            addCriterion("product_tags <>", value, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsGreaterThan(String value) {
            addCriterion("product_tags >", value, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsGreaterThanOrEqualTo(String value) {
            addCriterion("product_tags >=", value, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsLessThan(String value) {
            addCriterion("product_tags <", value, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsLessThanOrEqualTo(String value) {
            addCriterion("product_tags <=", value, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsLike(String value) {
            addCriterion("product_tags like", value, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsNotLike(String value) {
            addCriterion("product_tags not like", value, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsIn(List<String> values) {
            addCriterion("product_tags in", values, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsNotIn(List<String> values) {
            addCriterion("product_tags not in", values, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsBetween(String value1, String value2) {
            addCriterion("product_tags between", value1, value2, "productTags");
            return (Criteria) this;
        }

        public Criteria andProductTagsNotBetween(String value1, String value2) {
            addCriterion("product_tags not between", value1, value2, "productTags");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputIsNull() {
            addCriterion("is_own_input is null");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputIsNotNull() {
            addCriterion("is_own_input is not null");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputEqualTo(Boolean value) {
            addCriterion("is_own_input =", value, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputNotEqualTo(Boolean value) {
            addCriterion("is_own_input <>", value, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputGreaterThan(Boolean value) {
            addCriterion("is_own_input >", value, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_own_input >=", value, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputLessThan(Boolean value) {
            addCriterion("is_own_input <", value, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputLessThanOrEqualTo(Boolean value) {
            addCriterion("is_own_input <=", value, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputIn(List<Boolean> values) {
            addCriterion("is_own_input in", values, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputNotIn(List<Boolean> values) {
            addCriterion("is_own_input not in", values, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputBetween(Boolean value1, Boolean value2) {
            addCriterion("is_own_input between", value1, value2, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andIsOwnInputNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_own_input not between", value1, value2, "isOwnInput");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectIsNull() {
            addCriterion("loan_subject is null");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectIsNotNull() {
            addCriterion("loan_subject is not null");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectEqualTo(Byte value) {
            addCriterion("loan_subject =", value, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectNotEqualTo(Byte value) {
            addCriterion("loan_subject <>", value, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectGreaterThan(Byte value) {
            addCriterion("loan_subject >", value, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectGreaterThanOrEqualTo(Byte value) {
            addCriterion("loan_subject >=", value, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectLessThan(Byte value) {
            addCriterion("loan_subject <", value, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectLessThanOrEqualTo(Byte value) {
            addCriterion("loan_subject <=", value, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectIn(List<Byte> values) {
            addCriterion("loan_subject in", values, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectNotIn(List<Byte> values) {
            addCriterion("loan_subject not in", values, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectBetween(Byte value1, Byte value2) {
            addCriterion("loan_subject between", value1, value2, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andLoanSubjectNotBetween(Byte value1, Byte value2) {
            addCriterion("loan_subject not between", value1, value2, "loanSubject");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeIsNull() {
            addCriterion("guarantee_type is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeIsNotNull() {
            addCriterion("guarantee_type is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeEqualTo(Byte value) {
            addCriterion("guarantee_type =", value, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeNotEqualTo(Byte value) {
            addCriterion("guarantee_type <>", value, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeGreaterThan(Byte value) {
            addCriterion("guarantee_type >", value, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("guarantee_type >=", value, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeLessThan(Byte value) {
            addCriterion("guarantee_type <", value, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("guarantee_type <=", value, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeIn(List<Byte> values) {
            addCriterion("guarantee_type in", values, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeNotIn(List<Byte> values) {
            addCriterion("guarantee_type not in", values, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeBetween(Byte value1, Byte value2) {
            addCriterion("guarantee_type between", value1, value2, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("guarantee_type not between", value1, value2, "guaranteeType");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueIsNull() {
            addCriterion("guarantee_value is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueIsNotNull() {
            addCriterion("guarantee_value is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueEqualTo(String value) {
            addCriterion("guarantee_value =", value, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueNotEqualTo(String value) {
            addCriterion("guarantee_value <>", value, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueGreaterThan(String value) {
            addCriterion("guarantee_value >", value, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_value >=", value, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueLessThan(String value) {
            addCriterion("guarantee_value <", value, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueLessThanOrEqualTo(String value) {
            addCriterion("guarantee_value <=", value, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueLike(String value) {
            addCriterion("guarantee_value like", value, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueNotLike(String value) {
            addCriterion("guarantee_value not like", value, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueIn(List<String> values) {
            addCriterion("guarantee_value in", values, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueNotIn(List<String> values) {
            addCriterion("guarantee_value not in", values, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueBetween(String value1, String value2) {
            addCriterion("guarantee_value between", value1, value2, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andGuaranteeValueNotBetween(String value1, String value2) {
            addCriterion("guarantee_value not between", value1, value2, "guaranteeValue");
            return (Criteria) this;
        }

        public Criteria andIsMortgageIsNull() {
            addCriterion("is_mortgage is null");
            return (Criteria) this;
        }

        public Criteria andIsMortgageIsNotNull() {
            addCriterion("is_mortgage is not null");
            return (Criteria) this;
        }

        public Criteria andIsMortgageEqualTo(Boolean value) {
            addCriterion("is_mortgage =", value, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageNotEqualTo(Boolean value) {
            addCriterion("is_mortgage <>", value, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageGreaterThan(Boolean value) {
            addCriterion("is_mortgage >", value, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_mortgage >=", value, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageLessThan(Boolean value) {
            addCriterion("is_mortgage <", value, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageLessThanOrEqualTo(Boolean value) {
            addCriterion("is_mortgage <=", value, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageIn(List<Boolean> values) {
            addCriterion("is_mortgage in", values, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageNotIn(List<Boolean> values) {
            addCriterion("is_mortgage not in", values, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageBetween(Boolean value1, Boolean value2) {
            addCriterion("is_mortgage between", value1, value2, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andIsMortgageNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_mortgage not between", value1, value2, "isMortgage");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineIsNull() {
            addCriterion("pay_dead_line is null");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineIsNotNull() {
            addCriterion("pay_dead_line is not null");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineEqualTo(String value) {
            addCriterion("pay_dead_line =", value, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineNotEqualTo(String value) {
            addCriterion("pay_dead_line <>", value, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineGreaterThan(String value) {
            addCriterion("pay_dead_line >", value, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineGreaterThanOrEqualTo(String value) {
            addCriterion("pay_dead_line >=", value, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineLessThan(String value) {
            addCriterion("pay_dead_line <", value, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineLessThanOrEqualTo(String value) {
            addCriterion("pay_dead_line <=", value, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineLike(String value) {
            addCriterion("pay_dead_line like", value, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineNotLike(String value) {
            addCriterion("pay_dead_line not like", value, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineIn(List<String> values) {
            addCriterion("pay_dead_line in", values, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineNotIn(List<String> values) {
            addCriterion("pay_dead_line not in", values, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineBetween(String value1, String value2) {
            addCriterion("pay_dead_line between", value1, value2, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andPayDeadLineNotBetween(String value1, String value2) {
            addCriterion("pay_dead_line not between", value1, value2, "payDeadLine");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeIsNull() {
            addCriterion("non_recu_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeIsNotNull() {
            addCriterion("non_recu_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeEqualTo(Integer value) {
            addCriterion("non_recu_fee_type =", value, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeNotEqualTo(Integer value) {
            addCriterion("non_recu_fee_type <>", value, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeGreaterThan(Integer value) {
            addCriterion("non_recu_fee_type >", value, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("non_recu_fee_type >=", value, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeLessThan(Integer value) {
            addCriterion("non_recu_fee_type <", value, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("non_recu_fee_type <=", value, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeIn(List<Integer> values) {
            addCriterion("non_recu_fee_type in", values, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeNotIn(List<Integer> values) {
            addCriterion("non_recu_fee_type not in", values, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("non_recu_fee_type between", value1, value2, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("non_recu_fee_type not between", value1, value2, "nonRecuFeeType");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeIsNull() {
            addCriterion("non_recu_fee is null");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeIsNotNull() {
            addCriterion("non_recu_fee is not null");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeEqualTo(BigDecimal value) {
            addCriterion("non_recu_fee =", value, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeNotEqualTo(BigDecimal value) {
            addCriterion("non_recu_fee <>", value, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeGreaterThan(BigDecimal value) {
            addCriterion("non_recu_fee >", value, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("non_recu_fee >=", value, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeLessThan(BigDecimal value) {
            addCriterion("non_recu_fee <", value, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("non_recu_fee <=", value, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeIn(List<BigDecimal> values) {
            addCriterion("non_recu_fee in", values, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeNotIn(List<BigDecimal> values) {
            addCriterion("non_recu_fee not in", values, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_recu_fee between", value1, value2, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andNonRecuFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_recu_fee not between", value1, value2, "nonRecuFee");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNull() {
            addCriterion("fee_type is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNotNull() {
            addCriterion("fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(Integer value) {
            addCriterion("fee_type =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotEqualTo(Integer value) {
            addCriterion("fee_type <>", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThan(Integer value) {
            addCriterion("fee_type >", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee_type >=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThan(Integer value) {
            addCriterion("fee_type <", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("fee_type <=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIn(List<Integer> values) {
            addCriterion("fee_type in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotIn(List<Integer> values) {
            addCriterion("fee_type not in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("fee_type between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fee_type not between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeIsNull() {
            addCriterion("default_fee is null");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeIsNotNull() {
            addCriterion("default_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeEqualTo(BigDecimal value) {
            addCriterion("default_fee =", value, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeNotEqualTo(BigDecimal value) {
            addCriterion("default_fee <>", value, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeGreaterThan(BigDecimal value) {
            addCriterion("default_fee >", value, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("default_fee >=", value, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeLessThan(BigDecimal value) {
            addCriterion("default_fee <", value, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("default_fee <=", value, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeIn(List<BigDecimal> values) {
            addCriterion("default_fee in", values, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeNotIn(List<BigDecimal> values) {
            addCriterion("default_fee not in", values, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("default_fee between", value1, value2, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andDefaultFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("default_fee not between", value1, value2, "defaultFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeIsNull() {
            addCriterion("min_fee is null");
            return (Criteria) this;
        }

        public Criteria andMinFeeIsNotNull() {
            addCriterion("min_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMinFeeEqualTo(BigDecimal value) {
            addCriterion("min_fee =", value, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeNotEqualTo(BigDecimal value) {
            addCriterion("min_fee <>", value, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeGreaterThan(BigDecimal value) {
            addCriterion("min_fee >", value, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_fee >=", value, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeLessThan(BigDecimal value) {
            addCriterion("min_fee <", value, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_fee <=", value, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeIn(List<BigDecimal> values) {
            addCriterion("min_fee in", values, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeNotIn(List<BigDecimal> values) {
            addCriterion("min_fee not in", values, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_fee between", value1, value2, "minFee");
            return (Criteria) this;
        }

        public Criteria andMinFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_fee not between", value1, value2, "minFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeIsNull() {
            addCriterion("max_fee is null");
            return (Criteria) this;
        }

        public Criteria andMaxFeeIsNotNull() {
            addCriterion("max_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMaxFeeEqualTo(BigDecimal value) {
            addCriterion("max_fee =", value, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeNotEqualTo(BigDecimal value) {
            addCriterion("max_fee <>", value, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeGreaterThan(BigDecimal value) {
            addCriterion("max_fee >", value, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_fee >=", value, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeLessThan(BigDecimal value) {
            addCriterion("max_fee <", value, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_fee <=", value, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeIn(List<BigDecimal> values) {
            addCriterion("max_fee in", values, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeNotIn(List<BigDecimal> values) {
            addCriterion("max_fee not in", values, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_fee between", value1, value2, "maxFee");
            return (Criteria) this;
        }

        public Criteria andMaxFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_fee not between", value1, value2, "maxFee");
            return (Criteria) this;
        }

        public Criteria andRepayWayIsNull() {
            addCriterion("repay_way is null");
            return (Criteria) this;
        }

        public Criteria andRepayWayIsNotNull() {
            addCriterion("repay_way is not null");
            return (Criteria) this;
        }

        public Criteria andRepayWayEqualTo(String value) {
            addCriterion("repay_way =", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotEqualTo(String value) {
            addCriterion("repay_way <>", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayGreaterThan(String value) {
            addCriterion("repay_way >", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayGreaterThanOrEqualTo(String value) {
            addCriterion("repay_way >=", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayLessThan(String value) {
            addCriterion("repay_way <", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayLessThanOrEqualTo(String value) {
            addCriterion("repay_way <=", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayLike(String value) {
            addCriterion("repay_way like", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotLike(String value) {
            addCriterion("repay_way not like", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayIn(List<String> values) {
            addCriterion("repay_way in", values, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotIn(List<String> values) {
            addCriterion("repay_way not in", values, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayBetween(String value1, String value2) {
            addCriterion("repay_way between", value1, value2, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotBetween(String value1, String value2) {
            addCriterion("repay_way not between", value1, value2, "repayWay");
            return (Criteria) this;
        }

        public Criteria andReckonModelIsNull() {
            addCriterion("reckon_model is null");
            return (Criteria) this;
        }

        public Criteria andReckonModelIsNotNull() {
            addCriterion("reckon_model is not null");
            return (Criteria) this;
        }

        public Criteria andReckonModelEqualTo(Integer value) {
            addCriterion("reckon_model =", value, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelNotEqualTo(Integer value) {
            addCriterion("reckon_model <>", value, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelGreaterThan(Integer value) {
            addCriterion("reckon_model >", value, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("reckon_model >=", value, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelLessThan(Integer value) {
            addCriterion("reckon_model <", value, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelLessThanOrEqualTo(Integer value) {
            addCriterion("reckon_model <=", value, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelIn(List<Integer> values) {
            addCriterion("reckon_model in", values, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelNotIn(List<Integer> values) {
            addCriterion("reckon_model not in", values, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelBetween(Integer value1, Integer value2) {
            addCriterion("reckon_model between", value1, value2, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andReckonModelNotBetween(Integer value1, Integer value2) {
            addCriterion("reckon_model not between", value1, value2, "reckonModel");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupIsNull() {
            addCriterion("is_prepay_sup is null");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupIsNotNull() {
            addCriterion("is_prepay_sup is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupEqualTo(Boolean value) {
            addCriterion("is_prepay_sup =", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupNotEqualTo(Boolean value) {
            addCriterion("is_prepay_sup <>", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupGreaterThan(Boolean value) {
            addCriterion("is_prepay_sup >", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_prepay_sup >=", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupLessThan(Boolean value) {
            addCriterion("is_prepay_sup <", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupLessThanOrEqualTo(Boolean value) {
            addCriterion("is_prepay_sup <=", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupIn(List<Boolean> values) {
            addCriterion("is_prepay_sup in", values, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupNotIn(List<Boolean> values) {
            addCriterion("is_prepay_sup not in", values, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prepay_sup between", value1, value2, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prepay_sup not between", value1, value2, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeIsNull() {
            addCriterion("prepay_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeIsNotNull() {
            addCriterion("prepay_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeEqualTo(Integer value) {
            addCriterion("prepay_fee_type =", value, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeNotEqualTo(Integer value) {
            addCriterion("prepay_fee_type <>", value, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeGreaterThan(Integer value) {
            addCriterion("prepay_fee_type >", value, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("prepay_fee_type >=", value, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeLessThan(Integer value) {
            addCriterion("prepay_fee_type <", value, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("prepay_fee_type <=", value, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeIn(List<Integer> values) {
            addCriterion("prepay_fee_type in", values, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeNotIn(List<Integer> values) {
            addCriterion("prepay_fee_type not in", values, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("prepay_fee_type between", value1, value2, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("prepay_fee_type not between", value1, value2, "prepayFeeType");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeIsNull() {
            addCriterion("prepay_raw_fee is null");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeIsNotNull() {
            addCriterion("prepay_raw_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeEqualTo(BigDecimal value) {
            addCriterion("prepay_raw_fee =", value, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeNotEqualTo(BigDecimal value) {
            addCriterion("prepay_raw_fee <>", value, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeGreaterThan(BigDecimal value) {
            addCriterion("prepay_raw_fee >", value, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prepay_raw_fee >=", value, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeLessThan(BigDecimal value) {
            addCriterion("prepay_raw_fee <", value, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prepay_raw_fee <=", value, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeIn(List<BigDecimal> values) {
            addCriterion("prepay_raw_fee in", values, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeNotIn(List<BigDecimal> values) {
            addCriterion("prepay_raw_fee not in", values, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prepay_raw_fee between", value1, value2, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andPrepayRawFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prepay_raw_fee not between", value1, value2, "prepayRawFee");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupIsNull() {
            addCriterion("is_penalty_sup is null");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupIsNotNull() {
            addCriterion("is_penalty_sup is not null");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupEqualTo(Boolean value) {
            addCriterion("is_penalty_sup =", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupNotEqualTo(Boolean value) {
            addCriterion("is_penalty_sup <>", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupGreaterThan(Boolean value) {
            addCriterion("is_penalty_sup >", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_penalty_sup >=", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupLessThan(Boolean value) {
            addCriterion("is_penalty_sup <", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupLessThanOrEqualTo(Boolean value) {
            addCriterion("is_penalty_sup <=", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupIn(List<Boolean> values) {
            addCriterion("is_penalty_sup in", values, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupNotIn(List<Boolean> values) {
            addCriterion("is_penalty_sup not in", values, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupBetween(Boolean value1, Boolean value2) {
            addCriterion("is_penalty_sup between", value1, value2, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_penalty_sup not between", value1, value2, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeIsNull() {
            addCriterion("penalty_raw_fee is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeIsNotNull() {
            addCriterion("penalty_raw_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeEqualTo(BigDecimal value) {
            addCriterion("penalty_raw_fee =", value, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeNotEqualTo(BigDecimal value) {
            addCriterion("penalty_raw_fee <>", value, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeGreaterThan(BigDecimal value) {
            addCriterion("penalty_raw_fee >", value, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("penalty_raw_fee >=", value, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeLessThan(BigDecimal value) {
            addCriterion("penalty_raw_fee <", value, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("penalty_raw_fee <=", value, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeIn(List<BigDecimal> values) {
            addCriterion("penalty_raw_fee in", values, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeNotIn(List<BigDecimal> values) {
            addCriterion("penalty_raw_fee not in", values, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("penalty_raw_fee between", value1, value2, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyRawFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("penalty_raw_fee not between", value1, value2, "penaltyRawFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeIsNull() {
            addCriterion("penalty_type is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeIsNotNull() {
            addCriterion("penalty_type is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeEqualTo(Integer value) {
            addCriterion("penalty_type =", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeNotEqualTo(Integer value) {
            addCriterion("penalty_type <>", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeGreaterThan(Integer value) {
            addCriterion("penalty_type >", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("penalty_type >=", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeLessThan(Integer value) {
            addCriterion("penalty_type <", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("penalty_type <=", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeIn(List<Integer> values) {
            addCriterion("penalty_type in", values, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeNotIn(List<Integer> values) {
            addCriterion("penalty_type not in", values, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeBetween(Integer value1, Integer value2) {
            addCriterion("penalty_type between", value1, value2, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("penalty_type not between", value1, value2, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedIsNull() {
            addCriterion("is_user_customized is null");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedIsNotNull() {
            addCriterion("is_user_customized is not null");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedEqualTo(Boolean value) {
            addCriterion("is_user_customized =", value, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedNotEqualTo(Boolean value) {
            addCriterion("is_user_customized <>", value, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedGreaterThan(Boolean value) {
            addCriterion("is_user_customized >", value, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_user_customized >=", value, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedLessThan(Boolean value) {
            addCriterion("is_user_customized <", value, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_user_customized <=", value, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedIn(List<Boolean> values) {
            addCriterion("is_user_customized in", values, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedNotIn(List<Boolean> values) {
            addCriterion("is_user_customized not in", values, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_user_customized between", value1, value2, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andIsUserCustomizedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_user_customized not between", value1, value2, "isUserCustomized");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeIsNull() {
            addCriterion("visiable_scope is null");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeIsNotNull() {
            addCriterion("visiable_scope is not null");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeEqualTo(Integer value) {
            addCriterion("visiable_scope =", value, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeNotEqualTo(Integer value) {
            addCriterion("visiable_scope <>", value, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeGreaterThan(Integer value) {
            addCriterion("visiable_scope >", value, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("visiable_scope >=", value, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeLessThan(Integer value) {
            addCriterion("visiable_scope <", value, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeLessThanOrEqualTo(Integer value) {
            addCriterion("visiable_scope <=", value, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeIn(List<Integer> values) {
            addCriterion("visiable_scope in", values, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeNotIn(List<Integer> values) {
            addCriterion("visiable_scope not in", values, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeBetween(Integer value1, Integer value2) {
            addCriterion("visiable_scope between", value1, value2, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andVisiableScopeNotBetween(Integer value1, Integer value2) {
            addCriterion("visiable_scope not between", value1, value2, "visiableScope");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderIsNull() {
            addCriterion("recmmand_order is null");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderIsNotNull() {
            addCriterion("recmmand_order is not null");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderEqualTo(Integer value) {
            addCriterion("recmmand_order =", value, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderNotEqualTo(Integer value) {
            addCriterion("recmmand_order <>", value, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderGreaterThan(Integer value) {
            addCriterion("recmmand_order >", value, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("recmmand_order >=", value, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderLessThan(Integer value) {
            addCriterion("recmmand_order <", value, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderLessThanOrEqualTo(Integer value) {
            addCriterion("recmmand_order <=", value, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderIn(List<Integer> values) {
            addCriterion("recmmand_order in", values, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderNotIn(List<Integer> values) {
            addCriterion("recmmand_order not in", values, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderBetween(Integer value1, Integer value2) {
            addCriterion("recmmand_order between", value1, value2, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andRecmmandOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("recmmand_order not between", value1, value2, "recmmandOrder");
            return (Criteria) this;
        }

        public Criteria andIsRecommandIsNull() {
            addCriterion("is_recommand is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommandIsNotNull() {
            addCriterion("is_recommand is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommandEqualTo(Boolean value) {
            addCriterion("is_recommand =", value, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandNotEqualTo(Boolean value) {
            addCriterion("is_recommand <>", value, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandGreaterThan(Boolean value) {
            addCriterion("is_recommand >", value, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_recommand >=", value, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandLessThan(Boolean value) {
            addCriterion("is_recommand <", value, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandLessThanOrEqualTo(Boolean value) {
            addCriterion("is_recommand <=", value, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandIn(List<Boolean> values) {
            addCriterion("is_recommand in", values, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandNotIn(List<Boolean> values) {
            addCriterion("is_recommand not in", values, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandBetween(Boolean value1, Boolean value2) {
            addCriterion("is_recommand between", value1, value2, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andIsRecommandNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_recommand not between", value1, value2, "isRecommand");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNull() {
            addCriterion("display_order is null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNotNull() {
            addCriterion("display_order is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderEqualTo(Integer value) {
            addCriterion("display_order =", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotEqualTo(Integer value) {
            addCriterion("display_order <>", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThan(Integer value) {
            addCriterion("display_order >", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("display_order >=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThan(Integer value) {
            addCriterion("display_order <", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThanOrEqualTo(Integer value) {
            addCriterion("display_order <=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIn(List<Integer> values) {
            addCriterion("display_order in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotIn(List<Integer> values) {
            addCriterion("display_order not in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderBetween(Integer value1, Integer value2) {
            addCriterion("display_order between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("display_order not between", value1, value2, "displayOrder");
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdIsNull() {
            addCriterion("open_product_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdIsNotNull() {
            addCriterion("open_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdEqualTo(String value) {
            addCriterion("open_product_id =", value, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdNotEqualTo(String value) {
            addCriterion("open_product_id <>", value, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdGreaterThan(String value) {
            addCriterion("open_product_id >", value, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_product_id >=", value, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdLessThan(String value) {
            addCriterion("open_product_id <", value, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdLessThanOrEqualTo(String value) {
            addCriterion("open_product_id <=", value, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdLike(String value) {
            addCriterion("open_product_id like", value, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdNotLike(String value) {
            addCriterion("open_product_id not like", value, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdIn(List<String> values) {
            addCriterion("open_product_id in", values, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdNotIn(List<String> values) {
            addCriterion("open_product_id not in", values, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdBetween(String value1, String value2) {
            addCriterion("open_product_id between", value1, value2, "openProductId");
            return (Criteria) this;
        }

        public Criteria andOpenProductIdNotBetween(String value1, String value2) {
            addCriterion("open_product_id not between", value1, value2, "openProductId");
            return (Criteria) this;
        }

        public Criteria andFeeInfoIsNull() {
            addCriterion("fee_info is null");
            return (Criteria) this;
        }

        public Criteria andFeeInfoIsNotNull() {
            addCriterion("fee_info is not null");
            return (Criteria) this;
        }

        public Criteria andFeeInfoEqualTo(String value) {
            addCriterion("fee_info =", value, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoNotEqualTo(String value) {
            addCriterion("fee_info <>", value, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoGreaterThan(String value) {
            addCriterion("fee_info >", value, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoGreaterThanOrEqualTo(String value) {
            addCriterion("fee_info >=", value, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoLessThan(String value) {
            addCriterion("fee_info <", value, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoLessThanOrEqualTo(String value) {
            addCriterion("fee_info <=", value, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoLike(String value) {
            addCriterion("fee_info like", value, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoNotLike(String value) {
            addCriterion("fee_info not like", value, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoIn(List<String> values) {
            addCriterion("fee_info in", values, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoNotIn(List<String> values) {
            addCriterion("fee_info not in", values, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoBetween(String value1, String value2) {
            addCriterion("fee_info between", value1, value2, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andFeeInfoNotBetween(String value1, String value2) {
            addCriterion("fee_info not between", value1, value2, "feeInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoIsNull() {
            addCriterion("amount_info is null");
            return (Criteria) this;
        }

        public Criteria andAmountInfoIsNotNull() {
            addCriterion("amount_info is not null");
            return (Criteria) this;
        }

        public Criteria andAmountInfoEqualTo(String value) {
            addCriterion("amount_info =", value, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoNotEqualTo(String value) {
            addCriterion("amount_info <>", value, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoGreaterThan(String value) {
            addCriterion("amount_info >", value, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoGreaterThanOrEqualTo(String value) {
            addCriterion("amount_info >=", value, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoLessThan(String value) {
            addCriterion("amount_info <", value, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoLessThanOrEqualTo(String value) {
            addCriterion("amount_info <=", value, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoLike(String value) {
            addCriterion("amount_info like", value, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoNotLike(String value) {
            addCriterion("amount_info not like", value, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoIn(List<String> values) {
            addCriterion("amount_info in", values, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoNotIn(List<String> values) {
            addCriterion("amount_info not in", values, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoBetween(String value1, String value2) {
            addCriterion("amount_info between", value1, value2, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andAmountInfoNotBetween(String value1, String value2) {
            addCriterion("amount_info not between", value1, value2, "amountInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoIsNull() {
            addCriterion("term_info is null");
            return (Criteria) this;
        }

        public Criteria andTermInfoIsNotNull() {
            addCriterion("term_info is not null");
            return (Criteria) this;
        }

        public Criteria andTermInfoEqualTo(String value) {
            addCriterion("term_info =", value, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoNotEqualTo(String value) {
            addCriterion("term_info <>", value, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoGreaterThan(String value) {
            addCriterion("term_info >", value, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoGreaterThanOrEqualTo(String value) {
            addCriterion("term_info >=", value, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoLessThan(String value) {
            addCriterion("term_info <", value, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoLessThanOrEqualTo(String value) {
            addCriterion("term_info <=", value, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoLike(String value) {
            addCriterion("term_info like", value, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoNotLike(String value) {
            addCriterion("term_info not like", value, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoIn(List<String> values) {
            addCriterion("term_info in", values, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoNotIn(List<String> values) {
            addCriterion("term_info not in", values, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoBetween(String value1, String value2) {
            addCriterion("term_info between", value1, value2, "termInfo");
            return (Criteria) this;
        }

        public Criteria andTermInfoNotBetween(String value1, String value2) {
            addCriterion("term_info not between", value1, value2, "termInfo");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(Integer value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(Integer value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(Integer value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(Integer value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(Integer value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<Integer> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<Integer> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(Integer value1, Integer value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdIsNull() {
            addCriterion("product_threechannel_id is null");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdIsNotNull() {
            addCriterion("product_threechannel_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdEqualTo(String value) {
            addCriterion("product_threechannel_id =", value, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdNotEqualTo(String value) {
            addCriterion("product_threechannel_id <>", value, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdGreaterThan(String value) {
            addCriterion("product_threechannel_id >", value, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_threechannel_id >=", value, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdLessThan(String value) {
            addCriterion("product_threechannel_id <", value, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdLessThanOrEqualTo(String value) {
            addCriterion("product_threechannel_id <=", value, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdLike(String value) {
            addCriterion("product_threechannel_id like", value, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdNotLike(String value) {
            addCriterion("product_threechannel_id not like", value, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdIn(List<String> values) {
            addCriterion("product_threechannel_id in", values, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdNotIn(List<String> values) {
            addCriterion("product_threechannel_id not in", values, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdBetween(String value1, String value2) {
            addCriterion("product_threechannel_id between", value1, value2, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andProductThreechannelIdNotBetween(String value1, String value2) {
            addCriterion("product_threechannel_id not between", value1, value2, "productThreechannelId");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyIsNull() {
            addCriterion("price_strategy is null");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyIsNotNull() {
            addCriterion("price_strategy is not null");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyEqualTo(Short value) {
            addCriterion("price_strategy =", value, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyNotEqualTo(Short value) {
            addCriterion("price_strategy <>", value, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyGreaterThan(Short value) {
            addCriterion("price_strategy >", value, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyGreaterThanOrEqualTo(Short value) {
            addCriterion("price_strategy >=", value, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyLessThan(Short value) {
            addCriterion("price_strategy <", value, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyLessThanOrEqualTo(Short value) {
            addCriterion("price_strategy <=", value, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyIn(List<Short> values) {
            addCriterion("price_strategy in", values, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyNotIn(List<Short> values) {
            addCriterion("price_strategy not in", values, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyBetween(Short value1, Short value2) {
            addCriterion("price_strategy between", value1, value2, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andPriceStrategyNotBetween(Short value1, Short value2) {
            addCriterion("price_strategy not between", value1, value2, "priceStrategy");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductIsNull() {
            addCriterion("is_overdue_auto_deduct is null");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductIsNotNull() {
            addCriterion("is_overdue_auto_deduct is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductEqualTo(Short value) {
            addCriterion("is_overdue_auto_deduct =", value, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductNotEqualTo(Short value) {
            addCriterion("is_overdue_auto_deduct <>", value, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductGreaterThan(Short value) {
            addCriterion("is_overdue_auto_deduct >", value, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductGreaterThanOrEqualTo(Short value) {
            addCriterion("is_overdue_auto_deduct >=", value, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductLessThan(Short value) {
            addCriterion("is_overdue_auto_deduct <", value, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductLessThanOrEqualTo(Short value) {
            addCriterion("is_overdue_auto_deduct <=", value, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductIn(List<Short> values) {
            addCriterion("is_overdue_auto_deduct in", values, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductNotIn(List<Short> values) {
            addCriterion("is_overdue_auto_deduct not in", values, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductBetween(Short value1, Short value2) {
            addCriterion("is_overdue_auto_deduct between", value1, value2, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andIsOverdueAutoDeductNotBetween(Short value1, Short value2) {
            addCriterion("is_overdue_auto_deduct not between", value1, value2, "isOverdueAutoDeduct");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateIsNull() {
            addCriterion("td_report_valid_date is null");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateIsNotNull() {
            addCriterion("td_report_valid_date is not null");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateEqualTo(Integer value) {
            addCriterion("td_report_valid_date =", value, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateNotEqualTo(Integer value) {
            addCriterion("td_report_valid_date <>", value, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateGreaterThan(Integer value) {
            addCriterion("td_report_valid_date >", value, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("td_report_valid_date >=", value, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateLessThan(Integer value) {
            addCriterion("td_report_valid_date <", value, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateLessThanOrEqualTo(Integer value) {
            addCriterion("td_report_valid_date <=", value, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateIn(List<Integer> values) {
            addCriterion("td_report_valid_date in", values, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateNotIn(List<Integer> values) {
            addCriterion("td_report_valid_date not in", values, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateBetween(Integer value1, Integer value2) {
            addCriterion("td_report_valid_date between", value1, value2, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andTdReportValidDateNotBetween(Integer value1, Integer value2) {
            addCriterion("td_report_valid_date not between", value1, value2, "tdReportValidDate");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoIsNull() {
            addCriterion("wd_usage_no is null");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoIsNotNull() {
            addCriterion("wd_usage_no is not null");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoEqualTo(String value) {
            addCriterion("wd_usage_no =", value, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoNotEqualTo(String value) {
            addCriterion("wd_usage_no <>", value, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoGreaterThan(String value) {
            addCriterion("wd_usage_no >", value, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoGreaterThanOrEqualTo(String value) {
            addCriterion("wd_usage_no >=", value, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoLessThan(String value) {
            addCriterion("wd_usage_no <", value, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoLessThanOrEqualTo(String value) {
            addCriterion("wd_usage_no <=", value, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoLike(String value) {
            addCriterion("wd_usage_no like", value, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoNotLike(String value) {
            addCriterion("wd_usage_no not like", value, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoIn(List<String> values) {
            addCriterion("wd_usage_no in", values, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoNotIn(List<String> values) {
            addCriterion("wd_usage_no not in", values, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoBetween(String value1, String value2) {
            addCriterion("wd_usage_no between", value1, value2, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdUsageNoNotBetween(String value1, String value2) {
            addCriterion("wd_usage_no not between", value1, value2, "wdUsageNo");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeIsNull() {
            addCriterion("wd_borrow_type is null");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeIsNotNull() {
            addCriterion("wd_borrow_type is not null");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeEqualTo(String value) {
            addCriterion("wd_borrow_type =", value, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeNotEqualTo(String value) {
            addCriterion("wd_borrow_type <>", value, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeGreaterThan(String value) {
            addCriterion("wd_borrow_type >", value, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("wd_borrow_type >=", value, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeLessThan(String value) {
            addCriterion("wd_borrow_type <", value, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeLessThanOrEqualTo(String value) {
            addCriterion("wd_borrow_type <=", value, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeLike(String value) {
            addCriterion("wd_borrow_type like", value, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeNotLike(String value) {
            addCriterion("wd_borrow_type not like", value, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeIn(List<String> values) {
            addCriterion("wd_borrow_type in", values, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeNotIn(List<String> values) {
            addCriterion("wd_borrow_type not in", values, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeBetween(String value1, String value2) {
            addCriterion("wd_borrow_type between", value1, value2, "wdBorrowType");
            return (Criteria) this;
        }

        public Criteria andWdBorrowTypeNotBetween(String value1, String value2) {
            addCriterion("wd_borrow_type not between", value1, value2, "wdBorrowType");
            return (Criteria) this;
        }
    }

    /**
     * nj_product
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_product 2019-04-10
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