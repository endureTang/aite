package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjContactCompanyExample {
    /**
     * nj_contact_company
     */
    protected String orderByClause;

    /**
     * nj_contact_company
     */
    protected boolean distinct;

    /**
     * nj_contact_company
     */
    protected List<Criteria> oredCriteria;

    public NjContactCompanyExample() {
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
     * nj_contact_company 2019-07-05
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

        public Criteria andTrueControlNameIsNull() {
            addCriterion("true_control_name is null");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameIsNotNull() {
            addCriterion("true_control_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameEqualTo(String value) {
            addCriterion("true_control_name =", value, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameNotEqualTo(String value) {
            addCriterion("true_control_name <>", value, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameGreaterThan(String value) {
            addCriterion("true_control_name >", value, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameGreaterThanOrEqualTo(String value) {
            addCriterion("true_control_name >=", value, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameLessThan(String value) {
            addCriterion("true_control_name <", value, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameLessThanOrEqualTo(String value) {
            addCriterion("true_control_name <=", value, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameLike(String value) {
            addCriterion("true_control_name like", value, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameNotLike(String value) {
            addCriterion("true_control_name not like", value, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameIn(List<String> values) {
            addCriterion("true_control_name in", values, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameNotIn(List<String> values) {
            addCriterion("true_control_name not in", values, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameBetween(String value1, String value2) {
            addCriterion("true_control_name between", value1, value2, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlNameNotBetween(String value1, String value2) {
            addCriterion("true_control_name not between", value1, value2, "trueControlName");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardIsNull() {
            addCriterion("true_control_idcard is null");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardIsNotNull() {
            addCriterion("true_control_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardEqualTo(String value) {
            addCriterion("true_control_idcard =", value, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardNotEqualTo(String value) {
            addCriterion("true_control_idcard <>", value, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardGreaterThan(String value) {
            addCriterion("true_control_idcard >", value, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("true_control_idcard >=", value, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardLessThan(String value) {
            addCriterion("true_control_idcard <", value, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardLessThanOrEqualTo(String value) {
            addCriterion("true_control_idcard <=", value, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardLike(String value) {
            addCriterion("true_control_idcard like", value, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardNotLike(String value) {
            addCriterion("true_control_idcard not like", value, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardIn(List<String> values) {
            addCriterion("true_control_idcard in", values, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardNotIn(List<String> values) {
            addCriterion("true_control_idcard not in", values, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardBetween(String value1, String value2) {
            addCriterion("true_control_idcard between", value1, value2, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlIdcardNotBetween(String value1, String value2) {
            addCriterion("true_control_idcard not between", value1, value2, "trueControlIdcard");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileIsNull() {
            addCriterion("true_control_mobile is null");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileIsNotNull() {
            addCriterion("true_control_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileEqualTo(String value) {
            addCriterion("true_control_mobile =", value, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileNotEqualTo(String value) {
            addCriterion("true_control_mobile <>", value, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileGreaterThan(String value) {
            addCriterion("true_control_mobile >", value, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileGreaterThanOrEqualTo(String value) {
            addCriterion("true_control_mobile >=", value, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileLessThan(String value) {
            addCriterion("true_control_mobile <", value, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileLessThanOrEqualTo(String value) {
            addCriterion("true_control_mobile <=", value, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileLike(String value) {
            addCriterion("true_control_mobile like", value, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileNotLike(String value) {
            addCriterion("true_control_mobile not like", value, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileIn(List<String> values) {
            addCriterion("true_control_mobile in", values, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileNotIn(List<String> values) {
            addCriterion("true_control_mobile not in", values, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileBetween(String value1, String value2) {
            addCriterion("true_control_mobile between", value1, value2, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andTrueControlMobileNotBetween(String value1, String value2) {
            addCriterion("true_control_mobile not between", value1, value2, "trueControlMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManNameIsNull() {
            addCriterion("legal_man_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalManNameIsNotNull() {
            addCriterion("legal_man_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalManNameEqualTo(String value) {
            addCriterion("legal_man_name =", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameNotEqualTo(String value) {
            addCriterion("legal_man_name <>", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameGreaterThan(String value) {
            addCriterion("legal_man_name >", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_man_name >=", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameLessThan(String value) {
            addCriterion("legal_man_name <", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameLessThanOrEqualTo(String value) {
            addCriterion("legal_man_name <=", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameLike(String value) {
            addCriterion("legal_man_name like", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameNotLike(String value) {
            addCriterion("legal_man_name not like", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameIn(List<String> values) {
            addCriterion("legal_man_name in", values, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameNotIn(List<String> values) {
            addCriterion("legal_man_name not in", values, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameBetween(String value1, String value2) {
            addCriterion("legal_man_name between", value1, value2, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameNotBetween(String value1, String value2) {
            addCriterion("legal_man_name not between", value1, value2, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardIsNull() {
            addCriterion("legal_man_idcard is null");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardIsNotNull() {
            addCriterion("legal_man_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardEqualTo(String value) {
            addCriterion("legal_man_idcard =", value, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardNotEqualTo(String value) {
            addCriterion("legal_man_idcard <>", value, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardGreaterThan(String value) {
            addCriterion("legal_man_idcard >", value, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("legal_man_idcard >=", value, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardLessThan(String value) {
            addCriterion("legal_man_idcard <", value, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardLessThanOrEqualTo(String value) {
            addCriterion("legal_man_idcard <=", value, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardLike(String value) {
            addCriterion("legal_man_idcard like", value, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardNotLike(String value) {
            addCriterion("legal_man_idcard not like", value, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardIn(List<String> values) {
            addCriterion("legal_man_idcard in", values, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardNotIn(List<String> values) {
            addCriterion("legal_man_idcard not in", values, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardBetween(String value1, String value2) {
            addCriterion("legal_man_idcard between", value1, value2, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManIdcardNotBetween(String value1, String value2) {
            addCriterion("legal_man_idcard not between", value1, value2, "legalManIdcard");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileIsNull() {
            addCriterion("legal_man_mobile is null");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileIsNotNull() {
            addCriterion("legal_man_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileEqualTo(String value) {
            addCriterion("legal_man_mobile =", value, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileNotEqualTo(String value) {
            addCriterion("legal_man_mobile <>", value, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileGreaterThan(String value) {
            addCriterion("legal_man_mobile >", value, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileGreaterThanOrEqualTo(String value) {
            addCriterion("legal_man_mobile >=", value, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileLessThan(String value) {
            addCriterion("legal_man_mobile <", value, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileLessThanOrEqualTo(String value) {
            addCriterion("legal_man_mobile <=", value, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileLike(String value) {
            addCriterion("legal_man_mobile like", value, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileNotLike(String value) {
            addCriterion("legal_man_mobile not like", value, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileIn(List<String> values) {
            addCriterion("legal_man_mobile in", values, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileNotIn(List<String> values) {
            addCriterion("legal_man_mobile not in", values, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileBetween(String value1, String value2) {
            addCriterion("legal_man_mobile between", value1, value2, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andLegalManMobileNotBetween(String value1, String value2) {
            addCriterion("legal_man_mobile not between", value1, value2, "legalManMobile");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNull() {
            addCriterion("contact_mobile is null");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNotNull() {
            addCriterion("contact_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andContactMobileEqualTo(String value) {
            addCriterion("contact_mobile =", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotEqualTo(String value) {
            addCriterion("contact_mobile <>", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThan(String value) {
            addCriterion("contact_mobile >", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThanOrEqualTo(String value) {
            addCriterion("contact_mobile >=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThan(String value) {
            addCriterion("contact_mobile <", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThanOrEqualTo(String value) {
            addCriterion("contact_mobile <=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLike(String value) {
            addCriterion("contact_mobile like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotLike(String value) {
            addCriterion("contact_mobile not like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileIn(List<String> values) {
            addCriterion("contact_mobile in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotIn(List<String> values) {
            addCriterion("contact_mobile not in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileBetween(String value1, String value2) {
            addCriterion("contact_mobile between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotBetween(String value1, String value2) {
            addCriterion("contact_mobile not between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameIsNull() {
            addCriterion("max_shareholder_name is null");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameIsNotNull() {
            addCriterion("max_shareholder_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameEqualTo(String value) {
            addCriterion("max_shareholder_name =", value, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameNotEqualTo(String value) {
            addCriterion("max_shareholder_name <>", value, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameGreaterThan(String value) {
            addCriterion("max_shareholder_name >", value, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameGreaterThanOrEqualTo(String value) {
            addCriterion("max_shareholder_name >=", value, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameLessThan(String value) {
            addCriterion("max_shareholder_name <", value, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameLessThanOrEqualTo(String value) {
            addCriterion("max_shareholder_name <=", value, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameLike(String value) {
            addCriterion("max_shareholder_name like", value, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameNotLike(String value) {
            addCriterion("max_shareholder_name not like", value, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameIn(List<String> values) {
            addCriterion("max_shareholder_name in", values, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameNotIn(List<String> values) {
            addCriterion("max_shareholder_name not in", values, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameBetween(String value1, String value2) {
            addCriterion("max_shareholder_name between", value1, value2, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderNameNotBetween(String value1, String value2) {
            addCriterion("max_shareholder_name not between", value1, value2, "maxShareholderName");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardIsNull() {
            addCriterion("max_shareholder_idcard is null");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardIsNotNull() {
            addCriterion("max_shareholder_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardEqualTo(String value) {
            addCriterion("max_shareholder_idcard =", value, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardNotEqualTo(String value) {
            addCriterion("max_shareholder_idcard <>", value, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardGreaterThan(String value) {
            addCriterion("max_shareholder_idcard >", value, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("max_shareholder_idcard >=", value, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardLessThan(String value) {
            addCriterion("max_shareholder_idcard <", value, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardLessThanOrEqualTo(String value) {
            addCriterion("max_shareholder_idcard <=", value, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardLike(String value) {
            addCriterion("max_shareholder_idcard like", value, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardNotLike(String value) {
            addCriterion("max_shareholder_idcard not like", value, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardIn(List<String> values) {
            addCriterion("max_shareholder_idcard in", values, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardNotIn(List<String> values) {
            addCriterion("max_shareholder_idcard not in", values, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardBetween(String value1, String value2) {
            addCriterion("max_shareholder_idcard between", value1, value2, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderIdcardNotBetween(String value1, String value2) {
            addCriterion("max_shareholder_idcard not between", value1, value2, "maxShareholderIdcard");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileIsNull() {
            addCriterion("max_shareholder_mobile is null");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileIsNotNull() {
            addCriterion("max_shareholder_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileEqualTo(String value) {
            addCriterion("max_shareholder_mobile =", value, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileNotEqualTo(String value) {
            addCriterion("max_shareholder_mobile <>", value, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileGreaterThan(String value) {
            addCriterion("max_shareholder_mobile >", value, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileGreaterThanOrEqualTo(String value) {
            addCriterion("max_shareholder_mobile >=", value, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileLessThan(String value) {
            addCriterion("max_shareholder_mobile <", value, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileLessThanOrEqualTo(String value) {
            addCriterion("max_shareholder_mobile <=", value, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileLike(String value) {
            addCriterion("max_shareholder_mobile like", value, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileNotLike(String value) {
            addCriterion("max_shareholder_mobile not like", value, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileIn(List<String> values) {
            addCriterion("max_shareholder_mobile in", values, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileNotIn(List<String> values) {
            addCriterion("max_shareholder_mobile not in", values, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileBetween(String value1, String value2) {
            addCriterion("max_shareholder_mobile between", value1, value2, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxShareholderMobileNotBetween(String value1, String value2) {
            addCriterion("max_shareholder_mobile not between", value1, value2, "maxShareholderMobile");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameIsNull() {
            addCriterion("max_legal_man_name is null");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameIsNotNull() {
            addCriterion("max_legal_man_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameEqualTo(String value) {
            addCriterion("max_legal_man_name =", value, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameNotEqualTo(String value) {
            addCriterion("max_legal_man_name <>", value, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameGreaterThan(String value) {
            addCriterion("max_legal_man_name >", value, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameGreaterThanOrEqualTo(String value) {
            addCriterion("max_legal_man_name >=", value, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameLessThan(String value) {
            addCriterion("max_legal_man_name <", value, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameLessThanOrEqualTo(String value) {
            addCriterion("max_legal_man_name <=", value, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameLike(String value) {
            addCriterion("max_legal_man_name like", value, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameNotLike(String value) {
            addCriterion("max_legal_man_name not like", value, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameIn(List<String> values) {
            addCriterion("max_legal_man_name in", values, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameNotIn(List<String> values) {
            addCriterion("max_legal_man_name not in", values, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameBetween(String value1, String value2) {
            addCriterion("max_legal_man_name between", value1, value2, "maxLegalManName");
            return (Criteria) this;
        }

        public Criteria andMaxLegalManNameNotBetween(String value1, String value2) {
            addCriterion("max_legal_man_name not between", value1, value2, "maxLegalManName");
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

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("create_date like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("create_date not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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
    }

    /**
     * nj_contact_company
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_contact_company 2019-07-05
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