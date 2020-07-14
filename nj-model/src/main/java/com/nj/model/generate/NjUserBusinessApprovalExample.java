package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjUserBusinessApprovalExample {
    /**
     * nj_user_business_approval
     */
    protected String orderByClause;

    /**
     * nj_user_business_approval
     */
    protected boolean distinct;

    /**
     * nj_user_business_approval
     */
    protected List<Criteria> oredCriteria;

    public NjUserBusinessApprovalExample() {
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
     * nj_user_business_approval 2018-07-04
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

        public Criteria andIdentityCardIsNull() {
            addCriterion("identity_card is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardIsNotNull() {
            addCriterion("identity_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardEqualTo(String value) {
            addCriterion("identity_card =", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotEqualTo(String value) {
            addCriterion("identity_card <>", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGreaterThan(String value) {
            addCriterion("identity_card >", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGreaterThanOrEqualTo(String value) {
            addCriterion("identity_card >=", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLessThan(String value) {
            addCriterion("identity_card <", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLessThanOrEqualTo(String value) {
            addCriterion("identity_card <=", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLike(String value) {
            addCriterion("identity_card like", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotLike(String value) {
            addCriterion("identity_card not like", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardIn(List<String> values) {
            addCriterion("identity_card in", values, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotIn(List<String> values) {
            addCriterion("identity_card not in", values, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBetween(String value1, String value2) {
            addCriterion("identity_card between", value1, value2, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotBetween(String value1, String value2) {
            addCriterion("identity_card not between", value1, value2, "identityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardIsNull() {
            addCriterion("spouse_identity_card is null");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardIsNotNull() {
            addCriterion("spouse_identity_card is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardEqualTo(String value) {
            addCriterion("spouse_identity_card =", value, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardNotEqualTo(String value) {
            addCriterion("spouse_identity_card <>", value, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardGreaterThan(String value) {
            addCriterion("spouse_identity_card >", value, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardGreaterThanOrEqualTo(String value) {
            addCriterion("spouse_identity_card >=", value, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardLessThan(String value) {
            addCriterion("spouse_identity_card <", value, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardLessThanOrEqualTo(String value) {
            addCriterion("spouse_identity_card <=", value, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardLike(String value) {
            addCriterion("spouse_identity_card like", value, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardNotLike(String value) {
            addCriterion("spouse_identity_card not like", value, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardIn(List<String> values) {
            addCriterion("spouse_identity_card in", values, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardNotIn(List<String> values) {
            addCriterion("spouse_identity_card not in", values, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardBetween(String value1, String value2) {
            addCriterion("spouse_identity_card between", value1, value2, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andSpouseIdentityCardNotBetween(String value1, String value2) {
            addCriterion("spouse_identity_card not between", value1, value2, "spouseIdentityCard");
            return (Criteria) this;
        }

        public Criteria andHouseAccountIsNull() {
            addCriterion("house_account is null");
            return (Criteria) this;
        }

        public Criteria andHouseAccountIsNotNull() {
            addCriterion("house_account is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAccountEqualTo(String value) {
            addCriterion("house_account =", value, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountNotEqualTo(String value) {
            addCriterion("house_account <>", value, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountGreaterThan(String value) {
            addCriterion("house_account >", value, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountGreaterThanOrEqualTo(String value) {
            addCriterion("house_account >=", value, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountLessThan(String value) {
            addCriterion("house_account <", value, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountLessThanOrEqualTo(String value) {
            addCriterion("house_account <=", value, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountLike(String value) {
            addCriterion("house_account like", value, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountNotLike(String value) {
            addCriterion("house_account not like", value, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountIn(List<String> values) {
            addCriterion("house_account in", values, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountNotIn(List<String> values) {
            addCriterion("house_account not in", values, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountBetween(String value1, String value2) {
            addCriterion("house_account between", value1, value2, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andHouseAccountNotBetween(String value1, String value2) {
            addCriterion("house_account not between", value1, value2, "houseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountIsNull() {
            addCriterion("spouse_house_account is null");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountIsNotNull() {
            addCriterion("spouse_house_account is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountEqualTo(String value) {
            addCriterion("spouse_house_account =", value, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountNotEqualTo(String value) {
            addCriterion("spouse_house_account <>", value, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountGreaterThan(String value) {
            addCriterion("spouse_house_account >", value, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountGreaterThanOrEqualTo(String value) {
            addCriterion("spouse_house_account >=", value, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountLessThan(String value) {
            addCriterion("spouse_house_account <", value, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountLessThanOrEqualTo(String value) {
            addCriterion("spouse_house_account <=", value, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountLike(String value) {
            addCriterion("spouse_house_account like", value, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountNotLike(String value) {
            addCriterion("spouse_house_account not like", value, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountIn(List<String> values) {
            addCriterion("spouse_house_account in", values, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountNotIn(List<String> values) {
            addCriterion("spouse_house_account not in", values, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountBetween(String value1, String value2) {
            addCriterion("spouse_house_account between", value1, value2, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andSpouseHouseAccountNotBetween(String value1, String value2) {
            addCriterion("spouse_house_account not between", value1, value2, "spouseHouseAccount");
            return (Criteria) this;
        }

        public Criteria andMarrProveIsNull() {
            addCriterion("marr_prove is null");
            return (Criteria) this;
        }

        public Criteria andMarrProveIsNotNull() {
            addCriterion("marr_prove is not null");
            return (Criteria) this;
        }

        public Criteria andMarrProveEqualTo(String value) {
            addCriterion("marr_prove =", value, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveNotEqualTo(String value) {
            addCriterion("marr_prove <>", value, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveGreaterThan(String value) {
            addCriterion("marr_prove >", value, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveGreaterThanOrEqualTo(String value) {
            addCriterion("marr_prove >=", value, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveLessThan(String value) {
            addCriterion("marr_prove <", value, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveLessThanOrEqualTo(String value) {
            addCriterion("marr_prove <=", value, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveLike(String value) {
            addCriterion("marr_prove like", value, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveNotLike(String value) {
            addCriterion("marr_prove not like", value, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveIn(List<String> values) {
            addCriterion("marr_prove in", values, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveNotIn(List<String> values) {
            addCriterion("marr_prove not in", values, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveBetween(String value1, String value2) {
            addCriterion("marr_prove between", value1, value2, "marrProve");
            return (Criteria) this;
        }

        public Criteria andMarrProveNotBetween(String value1, String value2) {
            addCriterion("marr_prove not between", value1, value2, "marrProve");
            return (Criteria) this;
        }

        public Criteria andCreditReportIsNull() {
            addCriterion("credit_report is null");
            return (Criteria) this;
        }

        public Criteria andCreditReportIsNotNull() {
            addCriterion("credit_report is not null");
            return (Criteria) this;
        }

        public Criteria andCreditReportEqualTo(String value) {
            addCriterion("credit_report =", value, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportNotEqualTo(String value) {
            addCriterion("credit_report <>", value, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportGreaterThan(String value) {
            addCriterion("credit_report >", value, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportGreaterThanOrEqualTo(String value) {
            addCriterion("credit_report >=", value, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportLessThan(String value) {
            addCriterion("credit_report <", value, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportLessThanOrEqualTo(String value) {
            addCriterion("credit_report <=", value, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportLike(String value) {
            addCriterion("credit_report like", value, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportNotLike(String value) {
            addCriterion("credit_report not like", value, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportIn(List<String> values) {
            addCriterion("credit_report in", values, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportNotIn(List<String> values) {
            addCriterion("credit_report not in", values, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportBetween(String value1, String value2) {
            addCriterion("credit_report between", value1, value2, "creditReport");
            return (Criteria) this;
        }

        public Criteria andCreditReportNotBetween(String value1, String value2) {
            addCriterion("credit_report not between", value1, value2, "creditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportIsNull() {
            addCriterion("spouse_credit_report is null");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportIsNotNull() {
            addCriterion("spouse_credit_report is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportEqualTo(String value) {
            addCriterion("spouse_credit_report =", value, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportNotEqualTo(String value) {
            addCriterion("spouse_credit_report <>", value, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportGreaterThan(String value) {
            addCriterion("spouse_credit_report >", value, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportGreaterThanOrEqualTo(String value) {
            addCriterion("spouse_credit_report >=", value, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportLessThan(String value) {
            addCriterion("spouse_credit_report <", value, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportLessThanOrEqualTo(String value) {
            addCriterion("spouse_credit_report <=", value, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportLike(String value) {
            addCriterion("spouse_credit_report like", value, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportNotLike(String value) {
            addCriterion("spouse_credit_report not like", value, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportIn(List<String> values) {
            addCriterion("spouse_credit_report in", values, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportNotIn(List<String> values) {
            addCriterion("spouse_credit_report not in", values, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportBetween(String value1, String value2) {
            addCriterion("spouse_credit_report between", value1, value2, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andSpouseCreditReportNotBetween(String value1, String value2) {
            addCriterion("spouse_credit_report not between", value1, value2, "spouseCreditReport");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateIsNull() {
            addCriterion("house_certificate is null");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateIsNotNull() {
            addCriterion("house_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateEqualTo(String value) {
            addCriterion("house_certificate =", value, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateNotEqualTo(String value) {
            addCriterion("house_certificate <>", value, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateGreaterThan(String value) {
            addCriterion("house_certificate >", value, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("house_certificate >=", value, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateLessThan(String value) {
            addCriterion("house_certificate <", value, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateLessThanOrEqualTo(String value) {
            addCriterion("house_certificate <=", value, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateLike(String value) {
            addCriterion("house_certificate like", value, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateNotLike(String value) {
            addCriterion("house_certificate not like", value, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateIn(List<String> values) {
            addCriterion("house_certificate in", values, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateNotIn(List<String> values) {
            addCriterion("house_certificate not in", values, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateBetween(String value1, String value2) {
            addCriterion("house_certificate between", value1, value2, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseCertificateNotBetween(String value1, String value2) {
            addCriterion("house_certificate not between", value1, value2, "houseCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateIsNull() {
            addCriterion("nation_certificate is null");
            return (Criteria) this;
        }

        public Criteria andNationCertificateIsNotNull() {
            addCriterion("nation_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andNationCertificateEqualTo(String value) {
            addCriterion("nation_certificate =", value, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateNotEqualTo(String value) {
            addCriterion("nation_certificate <>", value, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateGreaterThan(String value) {
            addCriterion("nation_certificate >", value, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("nation_certificate >=", value, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateLessThan(String value) {
            addCriterion("nation_certificate <", value, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateLessThanOrEqualTo(String value) {
            addCriterion("nation_certificate <=", value, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateLike(String value) {
            addCriterion("nation_certificate like", value, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateNotLike(String value) {
            addCriterion("nation_certificate not like", value, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateIn(List<String> values) {
            addCriterion("nation_certificate in", values, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateNotIn(List<String> values) {
            addCriterion("nation_certificate not in", values, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateBetween(String value1, String value2) {
            addCriterion("nation_certificate between", value1, value2, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andNationCertificateNotBetween(String value1, String value2) {
            addCriterion("nation_certificate not between", value1, value2, "nationCertificate");
            return (Criteria) this;
        }

        public Criteria andHouseQueryIsNull() {
            addCriterion("house_query is null");
            return (Criteria) this;
        }

        public Criteria andHouseQueryIsNotNull() {
            addCriterion("house_query is not null");
            return (Criteria) this;
        }

        public Criteria andHouseQueryEqualTo(String value) {
            addCriterion("house_query =", value, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryNotEqualTo(String value) {
            addCriterion("house_query <>", value, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryGreaterThan(String value) {
            addCriterion("house_query >", value, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryGreaterThanOrEqualTo(String value) {
            addCriterion("house_query >=", value, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryLessThan(String value) {
            addCriterion("house_query <", value, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryLessThanOrEqualTo(String value) {
            addCriterion("house_query <=", value, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryLike(String value) {
            addCriterion("house_query like", value, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryNotLike(String value) {
            addCriterion("house_query not like", value, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryIn(List<String> values) {
            addCriterion("house_query in", values, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryNotIn(List<String> values) {
            addCriterion("house_query not in", values, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryBetween(String value1, String value2) {
            addCriterion("house_query between", value1, value2, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andHouseQueryNotBetween(String value1, String value2) {
            addCriterion("house_query not between", value1, value2, "houseQuery");
            return (Criteria) this;
        }

        public Criteria andBankDetailIsNull() {
            addCriterion("bank_detail is null");
            return (Criteria) this;
        }

        public Criteria andBankDetailIsNotNull() {
            addCriterion("bank_detail is not null");
            return (Criteria) this;
        }

        public Criteria andBankDetailEqualTo(String value) {
            addCriterion("bank_detail =", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailNotEqualTo(String value) {
            addCriterion("bank_detail <>", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailGreaterThan(String value) {
            addCriterion("bank_detail >", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailGreaterThanOrEqualTo(String value) {
            addCriterion("bank_detail >=", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailLessThan(String value) {
            addCriterion("bank_detail <", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailLessThanOrEqualTo(String value) {
            addCriterion("bank_detail <=", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailLike(String value) {
            addCriterion("bank_detail like", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailNotLike(String value) {
            addCriterion("bank_detail not like", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailIn(List<String> values) {
            addCriterion("bank_detail in", values, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailNotIn(List<String> values) {
            addCriterion("bank_detail not in", values, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailBetween(String value1, String value2) {
            addCriterion("bank_detail between", value1, value2, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailNotBetween(String value1, String value2) {
            addCriterion("bank_detail not between", value1, value2, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andHouseMessageIsNull() {
            addCriterion("house_message is null");
            return (Criteria) this;
        }

        public Criteria andHouseMessageIsNotNull() {
            addCriterion("house_message is not null");
            return (Criteria) this;
        }

        public Criteria andHouseMessageEqualTo(String value) {
            addCriterion("house_message =", value, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageNotEqualTo(String value) {
            addCriterion("house_message <>", value, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageGreaterThan(String value) {
            addCriterion("house_message >", value, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageGreaterThanOrEqualTo(String value) {
            addCriterion("house_message >=", value, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageLessThan(String value) {
            addCriterion("house_message <", value, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageLessThanOrEqualTo(String value) {
            addCriterion("house_message <=", value, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageLike(String value) {
            addCriterion("house_message like", value, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageNotLike(String value) {
            addCriterion("house_message not like", value, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageIn(List<String> values) {
            addCriterion("house_message in", values, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageNotIn(List<String> values) {
            addCriterion("house_message not in", values, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageBetween(String value1, String value2) {
            addCriterion("house_message between", value1, value2, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andHouseMessageNotBetween(String value1, String value2) {
            addCriterion("house_message not between", value1, value2, "houseMessage");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoIsNull() {
            addCriterion("pawn_photo is null");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoIsNotNull() {
            addCriterion("pawn_photo is not null");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoEqualTo(String value) {
            addCriterion("pawn_photo =", value, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoNotEqualTo(String value) {
            addCriterion("pawn_photo <>", value, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoGreaterThan(String value) {
            addCriterion("pawn_photo >", value, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_photo >=", value, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoLessThan(String value) {
            addCriterion("pawn_photo <", value, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoLessThanOrEqualTo(String value) {
            addCriterion("pawn_photo <=", value, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoLike(String value) {
            addCriterion("pawn_photo like", value, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoNotLike(String value) {
            addCriterion("pawn_photo not like", value, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoIn(List<String> values) {
            addCriterion("pawn_photo in", values, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoNotIn(List<String> values) {
            addCriterion("pawn_photo not in", values, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoBetween(String value1, String value2) {
            addCriterion("pawn_photo between", value1, value2, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andPawnPhotoNotBetween(String value1, String value2) {
            addCriterion("pawn_photo not between", value1, value2, "pawnPhoto");
            return (Criteria) this;
        }

        public Criteria andContractProveIsNull() {
            addCriterion("contract_prove is null");
            return (Criteria) this;
        }

        public Criteria andContractProveIsNotNull() {
            addCriterion("contract_prove is not null");
            return (Criteria) this;
        }

        public Criteria andContractProveEqualTo(String value) {
            addCriterion("contract_prove =", value, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveNotEqualTo(String value) {
            addCriterion("contract_prove <>", value, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveGreaterThan(String value) {
            addCriterion("contract_prove >", value, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveGreaterThanOrEqualTo(String value) {
            addCriterion("contract_prove >=", value, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveLessThan(String value) {
            addCriterion("contract_prove <", value, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveLessThanOrEqualTo(String value) {
            addCriterion("contract_prove <=", value, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveLike(String value) {
            addCriterion("contract_prove like", value, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveNotLike(String value) {
            addCriterion("contract_prove not like", value, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveIn(List<String> values) {
            addCriterion("contract_prove in", values, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveNotIn(List<String> values) {
            addCriterion("contract_prove not in", values, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveBetween(String value1, String value2) {
            addCriterion("contract_prove between", value1, value2, "contractProve");
            return (Criteria) this;
        }

        public Criteria andContractProveNotBetween(String value1, String value2) {
            addCriterion("contract_prove not between", value1, value2, "contractProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveIsNull() {
            addCriterion("other_prove is null");
            return (Criteria) this;
        }

        public Criteria andOtherProveIsNotNull() {
            addCriterion("other_prove is not null");
            return (Criteria) this;
        }

        public Criteria andOtherProveEqualTo(String value) {
            addCriterion("other_prove =", value, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveNotEqualTo(String value) {
            addCriterion("other_prove <>", value, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveGreaterThan(String value) {
            addCriterion("other_prove >", value, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveGreaterThanOrEqualTo(String value) {
            addCriterion("other_prove >=", value, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveLessThan(String value) {
            addCriterion("other_prove <", value, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveLessThanOrEqualTo(String value) {
            addCriterion("other_prove <=", value, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveLike(String value) {
            addCriterion("other_prove like", value, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveNotLike(String value) {
            addCriterion("other_prove not like", value, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveIn(List<String> values) {
            addCriterion("other_prove in", values, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveNotIn(List<String> values) {
            addCriterion("other_prove not in", values, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveBetween(String value1, String value2) {
            addCriterion("other_prove between", value1, value2, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOtherProveNotBetween(String value1, String value2) {
            addCriterion("other_prove not between", value1, value2, "otherProve");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNull() {
            addCriterion("opinion is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNotNull() {
            addCriterion("opinion is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionEqualTo(String value) {
            addCriterion("opinion =", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotEqualTo(String value) {
            addCriterion("opinion <>", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThan(String value) {
            addCriterion("opinion >", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("opinion >=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThan(String value) {
            addCriterion("opinion <", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThanOrEqualTo(String value) {
            addCriterion("opinion <=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLike(String value) {
            addCriterion("opinion like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotLike(String value) {
            addCriterion("opinion not like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionIn(List<String> values) {
            addCriterion("opinion in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotIn(List<String> values) {
            addCriterion("opinion not in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionBetween(String value1, String value2) {
            addCriterion("opinion between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotBetween(String value1, String value2) {
            addCriterion("opinion not between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andUserReceiveIsNull() {
            addCriterion("user_receive is null");
            return (Criteria) this;
        }

        public Criteria andUserReceiveIsNotNull() {
            addCriterion("user_receive is not null");
            return (Criteria) this;
        }

        public Criteria andUserReceiveEqualTo(String value) {
            addCriterion("user_receive =", value, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveNotEqualTo(String value) {
            addCriterion("user_receive <>", value, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveGreaterThan(String value) {
            addCriterion("user_receive >", value, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveGreaterThanOrEqualTo(String value) {
            addCriterion("user_receive >=", value, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveLessThan(String value) {
            addCriterion("user_receive <", value, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveLessThanOrEqualTo(String value) {
            addCriterion("user_receive <=", value, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveLike(String value) {
            addCriterion("user_receive like", value, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveNotLike(String value) {
            addCriterion("user_receive not like", value, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveIn(List<String> values) {
            addCriterion("user_receive in", values, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveNotIn(List<String> values) {
            addCriterion("user_receive not in", values, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveBetween(String value1, String value2) {
            addCriterion("user_receive between", value1, value2, "userReceive");
            return (Criteria) this;
        }

        public Criteria andUserReceiveNotBetween(String value1, String value2) {
            addCriterion("user_receive not between", value1, value2, "userReceive");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyIsNull() {
            addCriterion("work_company is null");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyIsNotNull() {
            addCriterion("work_company is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyEqualTo(String value) {
            addCriterion("work_company =", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyNotEqualTo(String value) {
            addCriterion("work_company <>", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyGreaterThan(String value) {
            addCriterion("work_company >", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("work_company >=", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyLessThan(String value) {
            addCriterion("work_company <", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyLessThanOrEqualTo(String value) {
            addCriterion("work_company <=", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyLike(String value) {
            addCriterion("work_company like", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyNotLike(String value) {
            addCriterion("work_company not like", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyIn(List<String> values) {
            addCriterion("work_company in", values, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyNotIn(List<String> values) {
            addCriterion("work_company not in", values, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyBetween(String value1, String value2) {
            addCriterion("work_company between", value1, value2, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyNotBetween(String value1, String value2) {
            addCriterion("work_company not between", value1, value2, "workCompany");
            return (Criteria) this;
        }

        public Criteria andCreditResultIsNull() {
            addCriterion("credit_result is null");
            return (Criteria) this;
        }

        public Criteria andCreditResultIsNotNull() {
            addCriterion("credit_result is not null");
            return (Criteria) this;
        }

        public Criteria andCreditResultEqualTo(String value) {
            addCriterion("credit_result =", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultNotEqualTo(String value) {
            addCriterion("credit_result <>", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultGreaterThan(String value) {
            addCriterion("credit_result >", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultGreaterThanOrEqualTo(String value) {
            addCriterion("credit_result >=", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultLessThan(String value) {
            addCriterion("credit_result <", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultLessThanOrEqualTo(String value) {
            addCriterion("credit_result <=", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultLike(String value) {
            addCriterion("credit_result like", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultNotLike(String value) {
            addCriterion("credit_result not like", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultIn(List<String> values) {
            addCriterion("credit_result in", values, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultNotIn(List<String> values) {
            addCriterion("credit_result not in", values, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultBetween(String value1, String value2) {
            addCriterion("credit_result between", value1, value2, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultNotBetween(String value1, String value2) {
            addCriterion("credit_result not between", value1, value2, "creditResult");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeIsNull() {
            addCriterion("bigdata_query_messge is null");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeIsNotNull() {
            addCriterion("bigdata_query_messge is not null");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeEqualTo(String value) {
            addCriterion("bigdata_query_messge =", value, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeNotEqualTo(String value) {
            addCriterion("bigdata_query_messge <>", value, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeGreaterThan(String value) {
            addCriterion("bigdata_query_messge >", value, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeGreaterThanOrEqualTo(String value) {
            addCriterion("bigdata_query_messge >=", value, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeLessThan(String value) {
            addCriterion("bigdata_query_messge <", value, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeLessThanOrEqualTo(String value) {
            addCriterion("bigdata_query_messge <=", value, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeLike(String value) {
            addCriterion("bigdata_query_messge like", value, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeNotLike(String value) {
            addCriterion("bigdata_query_messge not like", value, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeIn(List<String> values) {
            addCriterion("bigdata_query_messge in", values, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeNotIn(List<String> values) {
            addCriterion("bigdata_query_messge not in", values, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeBetween(String value1, String value2) {
            addCriterion("bigdata_query_messge between", value1, value2, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andBigdataQueryMessgeNotBetween(String value1, String value2) {
            addCriterion("bigdata_query_messge not between", value1, value2, "bigdataQueryMessge");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageIsNull() {
            addCriterion("lawsuit_query_message is null");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageIsNotNull() {
            addCriterion("lawsuit_query_message is not null");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageEqualTo(String value) {
            addCriterion("lawsuit_query_message =", value, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageNotEqualTo(String value) {
            addCriterion("lawsuit_query_message <>", value, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageGreaterThan(String value) {
            addCriterion("lawsuit_query_message >", value, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageGreaterThanOrEqualTo(String value) {
            addCriterion("lawsuit_query_message >=", value, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageLessThan(String value) {
            addCriterion("lawsuit_query_message <", value, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageLessThanOrEqualTo(String value) {
            addCriterion("lawsuit_query_message <=", value, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageLike(String value) {
            addCriterion("lawsuit_query_message like", value, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageNotLike(String value) {
            addCriterion("lawsuit_query_message not like", value, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageIn(List<String> values) {
            addCriterion("lawsuit_query_message in", values, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageNotIn(List<String> values) {
            addCriterion("lawsuit_query_message not in", values, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageBetween(String value1, String value2) {
            addCriterion("lawsuit_query_message between", value1, value2, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andLawsuitQueryMessageNotBetween(String value1, String value2) {
            addCriterion("lawsuit_query_message not between", value1, value2, "lawsuitQueryMessage");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtIsNull() {
            addCriterion("famliy_debt is null");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtIsNotNull() {
            addCriterion("famliy_debt is not null");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtEqualTo(BigDecimal value) {
            addCriterion("famliy_debt =", value, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtNotEqualTo(BigDecimal value) {
            addCriterion("famliy_debt <>", value, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtGreaterThan(BigDecimal value) {
            addCriterion("famliy_debt >", value, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("famliy_debt >=", value, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtLessThan(BigDecimal value) {
            addCriterion("famliy_debt <", value, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("famliy_debt <=", value, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtIn(List<BigDecimal> values) {
            addCriterion("famliy_debt in", values, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtNotIn(List<BigDecimal> values) {
            addCriterion("famliy_debt not in", values, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("famliy_debt between", value1, value2, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andFamliyDebtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("famliy_debt not between", value1, value2, "famliyDebt");
            return (Criteria) this;
        }

        public Criteria andWarrantNoIsNull() {
            addCriterion("warrant_no is null");
            return (Criteria) this;
        }

        public Criteria andWarrantNoIsNotNull() {
            addCriterion("warrant_no is not null");
            return (Criteria) this;
        }

        public Criteria andWarrantNoEqualTo(String value) {
            addCriterion("warrant_no =", value, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoNotEqualTo(String value) {
            addCriterion("warrant_no <>", value, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoGreaterThan(String value) {
            addCriterion("warrant_no >", value, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoGreaterThanOrEqualTo(String value) {
            addCriterion("warrant_no >=", value, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoLessThan(String value) {
            addCriterion("warrant_no <", value, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoLessThanOrEqualTo(String value) {
            addCriterion("warrant_no <=", value, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoLike(String value) {
            addCriterion("warrant_no like", value, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoNotLike(String value) {
            addCriterion("warrant_no not like", value, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoIn(List<String> values) {
            addCriterion("warrant_no in", values, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoNotIn(List<String> values) {
            addCriterion("warrant_no not in", values, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoBetween(String value1, String value2) {
            addCriterion("warrant_no between", value1, value2, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andWarrantNoNotBetween(String value1, String value2) {
            addCriterion("warrant_no not between", value1, value2, "warrantNo");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andPawnSwIsNull() {
            addCriterion("pawn_sw is null");
            return (Criteria) this;
        }

        public Criteria andPawnSwIsNotNull() {
            addCriterion("pawn_sw is not null");
            return (Criteria) this;
        }

        public Criteria andPawnSwEqualTo(String value) {
            addCriterion("pawn_sw =", value, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwNotEqualTo(String value) {
            addCriterion("pawn_sw <>", value, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwGreaterThan(String value) {
            addCriterion("pawn_sw >", value, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_sw >=", value, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwLessThan(String value) {
            addCriterion("pawn_sw <", value, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwLessThanOrEqualTo(String value) {
            addCriterion("pawn_sw <=", value, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwLike(String value) {
            addCriterion("pawn_sw like", value, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwNotLike(String value) {
            addCriterion("pawn_sw not like", value, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwIn(List<String> values) {
            addCriterion("pawn_sw in", values, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwNotIn(List<String> values) {
            addCriterion("pawn_sw not in", values, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwBetween(String value1, String value2) {
            addCriterion("pawn_sw between", value1, value2, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnSwNotBetween(String value1, String value2) {
            addCriterion("pawn_sw not between", value1, value2, "pawnSw");
            return (Criteria) this;
        }

        public Criteria andPawnOrgIsNull() {
            addCriterion("pawn_org is null");
            return (Criteria) this;
        }

        public Criteria andPawnOrgIsNotNull() {
            addCriterion("pawn_org is not null");
            return (Criteria) this;
        }

        public Criteria andPawnOrgEqualTo(String value) {
            addCriterion("pawn_org =", value, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgNotEqualTo(String value) {
            addCriterion("pawn_org <>", value, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgGreaterThan(String value) {
            addCriterion("pawn_org >", value, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_org >=", value, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgLessThan(String value) {
            addCriterion("pawn_org <", value, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgLessThanOrEqualTo(String value) {
            addCriterion("pawn_org <=", value, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgLike(String value) {
            addCriterion("pawn_org like", value, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgNotLike(String value) {
            addCriterion("pawn_org not like", value, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgIn(List<String> values) {
            addCriterion("pawn_org in", values, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgNotIn(List<String> values) {
            addCriterion("pawn_org not in", values, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgBetween(String value1, String value2) {
            addCriterion("pawn_org between", value1, value2, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andPawnOrgNotBetween(String value1, String value2) {
            addCriterion("pawn_org not between", value1, value2, "pawnOrg");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseIsNull() {
            addCriterion("only_house is null");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseIsNotNull() {
            addCriterion("only_house is not null");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseEqualTo(String value) {
            addCriterion("only_house =", value, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseNotEqualTo(String value) {
            addCriterion("only_house <>", value, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseGreaterThan(String value) {
            addCriterion("only_house >", value, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseGreaterThanOrEqualTo(String value) {
            addCriterion("only_house >=", value, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseLessThan(String value) {
            addCriterion("only_house <", value, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseLessThanOrEqualTo(String value) {
            addCriterion("only_house <=", value, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseLike(String value) {
            addCriterion("only_house like", value, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseNotLike(String value) {
            addCriterion("only_house not like", value, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseIn(List<String> values) {
            addCriterion("only_house in", values, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseNotIn(List<String> values) {
            addCriterion("only_house not in", values, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseBetween(String value1, String value2) {
            addCriterion("only_house between", value1, value2, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andOnlyHouseNotBetween(String value1, String value2) {
            addCriterion("only_house not between", value1, value2, "onlyHouse");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNull() {
            addCriterion("house_status is null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNotNull() {
            addCriterion("house_status is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusEqualTo(String value) {
            addCriterion("house_status =", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotEqualTo(String value) {
            addCriterion("house_status <>", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThan(String value) {
            addCriterion("house_status >", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("house_status >=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThan(String value) {
            addCriterion("house_status <", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThanOrEqualTo(String value) {
            addCriterion("house_status <=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLike(String value) {
            addCriterion("house_status like", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotLike(String value) {
            addCriterion("house_status not like", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIn(List<String> values) {
            addCriterion("house_status in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotIn(List<String> values) {
            addCriterion("house_status not in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusBetween(String value1, String value2) {
            addCriterion("house_status between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotBetween(String value1, String value2) {
            addCriterion("house_status not between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseLimitIsNull() {
            addCriterion("house_limit is null");
            return (Criteria) this;
        }

        public Criteria andHouseLimitIsNotNull() {
            addCriterion("house_limit is not null");
            return (Criteria) this;
        }

        public Criteria andHouseLimitEqualTo(String value) {
            addCriterion("house_limit =", value, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitNotEqualTo(String value) {
            addCriterion("house_limit <>", value, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitGreaterThan(String value) {
            addCriterion("house_limit >", value, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitGreaterThanOrEqualTo(String value) {
            addCriterion("house_limit >=", value, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitLessThan(String value) {
            addCriterion("house_limit <", value, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitLessThanOrEqualTo(String value) {
            addCriterion("house_limit <=", value, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitLike(String value) {
            addCriterion("house_limit like", value, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitNotLike(String value) {
            addCriterion("house_limit not like", value, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitIn(List<String> values) {
            addCriterion("house_limit in", values, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitNotIn(List<String> values) {
            addCriterion("house_limit not in", values, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitBetween(String value1, String value2) {
            addCriterion("house_limit between", value1, value2, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andHouseLimitNotBetween(String value1, String value2) {
            addCriterion("house_limit not between", value1, value2, "houseLimit");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceIsNull() {
            addCriterion("cognizance_price is null");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceIsNotNull() {
            addCriterion("cognizance_price is not null");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceEqualTo(BigDecimal value) {
            addCriterion("cognizance_price =", value, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceNotEqualTo(BigDecimal value) {
            addCriterion("cognizance_price <>", value, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceGreaterThan(BigDecimal value) {
            addCriterion("cognizance_price >", value, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cognizance_price >=", value, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceLessThan(BigDecimal value) {
            addCriterion("cognizance_price <", value, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cognizance_price <=", value, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceIn(List<BigDecimal> values) {
            addCriterion("cognizance_price in", values, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceNotIn(List<BigDecimal> values) {
            addCriterion("cognizance_price not in", values, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cognizance_price between", value1, value2, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andCognizancePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cognizance_price not between", value1, value2, "cognizancePrice");
            return (Criteria) this;
        }

        public Criteria andLoanQutaIsNull() {
            addCriterion("loan_quta is null");
            return (Criteria) this;
        }

        public Criteria andLoanQutaIsNotNull() {
            addCriterion("loan_quta is not null");
            return (Criteria) this;
        }

        public Criteria andLoanQutaEqualTo(BigDecimal value) {
            addCriterion("loan_quta =", value, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaNotEqualTo(BigDecimal value) {
            addCriterion("loan_quta <>", value, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaGreaterThan(BigDecimal value) {
            addCriterion("loan_quta >", value, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_quta >=", value, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaLessThan(BigDecimal value) {
            addCriterion("loan_quta <", value, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_quta <=", value, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaIn(List<BigDecimal> values) {
            addCriterion("loan_quta in", values, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaNotIn(List<BigDecimal> values) {
            addCriterion("loan_quta not in", values, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_quta between", value1, value2, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andLoanQutaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_quta not between", value1, value2, "loanQuta");
            return (Criteria) this;
        }

        public Criteria andPawnRateIsNull() {
            addCriterion("pawn_rate is null");
            return (Criteria) this;
        }

        public Criteria andPawnRateIsNotNull() {
            addCriterion("pawn_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPawnRateEqualTo(String value) {
            addCriterion("pawn_rate =", value, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateNotEqualTo(String value) {
            addCriterion("pawn_rate <>", value, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateGreaterThan(String value) {
            addCriterion("pawn_rate >", value, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_rate >=", value, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateLessThan(String value) {
            addCriterion("pawn_rate <", value, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateLessThanOrEqualTo(String value) {
            addCriterion("pawn_rate <=", value, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateLike(String value) {
            addCriterion("pawn_rate like", value, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateNotLike(String value) {
            addCriterion("pawn_rate not like", value, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateIn(List<String> values) {
            addCriterion("pawn_rate in", values, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateNotIn(List<String> values) {
            addCriterion("pawn_rate not in", values, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateBetween(String value1, String value2) {
            addCriterion("pawn_rate between", value1, value2, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andPawnRateNotBetween(String value1, String value2) {
            addCriterion("pawn_rate not between", value1, value2, "pawnRate");
            return (Criteria) this;
        }

        public Criteria andLoanUsageIsNull() {
            addCriterion("loan_usage is null");
            return (Criteria) this;
        }

        public Criteria andLoanUsageIsNotNull() {
            addCriterion("loan_usage is not null");
            return (Criteria) this;
        }

        public Criteria andLoanUsageEqualTo(String value) {
            addCriterion("loan_usage =", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageNotEqualTo(String value) {
            addCriterion("loan_usage <>", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageGreaterThan(String value) {
            addCriterion("loan_usage >", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageGreaterThanOrEqualTo(String value) {
            addCriterion("loan_usage >=", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageLessThan(String value) {
            addCriterion("loan_usage <", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageLessThanOrEqualTo(String value) {
            addCriterion("loan_usage <=", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageLike(String value) {
            addCriterion("loan_usage like", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageNotLike(String value) {
            addCriterion("loan_usage not like", value, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageIn(List<String> values) {
            addCriterion("loan_usage in", values, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageNotIn(List<String> values) {
            addCriterion("loan_usage not in", values, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageBetween(String value1, String value2) {
            addCriterion("loan_usage between", value1, value2, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andLoanUsageNotBetween(String value1, String value2) {
            addCriterion("loan_usage not between", value1, value2, "loanUsage");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIsNull() {
            addCriterion("repay_source is null");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIsNotNull() {
            addCriterion("repay_source is not null");
            return (Criteria) this;
        }

        public Criteria andRepaySourceEqualTo(String value) {
            addCriterion("repay_source =", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotEqualTo(String value) {
            addCriterion("repay_source <>", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceGreaterThan(String value) {
            addCriterion("repay_source >", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceGreaterThanOrEqualTo(String value) {
            addCriterion("repay_source >=", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLessThan(String value) {
            addCriterion("repay_source <", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLessThanOrEqualTo(String value) {
            addCriterion("repay_source <=", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLike(String value) {
            addCriterion("repay_source like", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotLike(String value) {
            addCriterion("repay_source not like", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIn(List<String> values) {
            addCriterion("repay_source in", values, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotIn(List<String> values) {
            addCriterion("repay_source not in", values, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceBetween(String value1, String value2) {
            addCriterion("repay_source between", value1, value2, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotBetween(String value1, String value2) {
            addCriterion("repay_source not between", value1, value2, "repaySource");
            return (Criteria) this;
        }

        public Criteria andProductRequireIsNull() {
            addCriterion("product_require is null");
            return (Criteria) this;
        }

        public Criteria andProductRequireIsNotNull() {
            addCriterion("product_require is not null");
            return (Criteria) this;
        }

        public Criteria andProductRequireEqualTo(String value) {
            addCriterion("product_require =", value, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireNotEqualTo(String value) {
            addCriterion("product_require <>", value, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireGreaterThan(String value) {
            addCriterion("product_require >", value, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireGreaterThanOrEqualTo(String value) {
            addCriterion("product_require >=", value, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireLessThan(String value) {
            addCriterion("product_require <", value, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireLessThanOrEqualTo(String value) {
            addCriterion("product_require <=", value, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireLike(String value) {
            addCriterion("product_require like", value, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireNotLike(String value) {
            addCriterion("product_require not like", value, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireIn(List<String> values) {
            addCriterion("product_require in", values, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireNotIn(List<String> values) {
            addCriterion("product_require not in", values, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireBetween(String value1, String value2) {
            addCriterion("product_require between", value1, value2, "productRequire");
            return (Criteria) this;
        }

        public Criteria andProductRequireNotBetween(String value1, String value2) {
            addCriterion("product_require not between", value1, value2, "productRequire");
            return (Criteria) this;
        }

        public Criteria andRequireMessageIsNull() {
            addCriterion("require_message is null");
            return (Criteria) this;
        }

        public Criteria andRequireMessageIsNotNull() {
            addCriterion("require_message is not null");
            return (Criteria) this;
        }

        public Criteria andRequireMessageEqualTo(String value) {
            addCriterion("require_message =", value, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageNotEqualTo(String value) {
            addCriterion("require_message <>", value, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageGreaterThan(String value) {
            addCriterion("require_message >", value, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageGreaterThanOrEqualTo(String value) {
            addCriterion("require_message >=", value, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageLessThan(String value) {
            addCriterion("require_message <", value, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageLessThanOrEqualTo(String value) {
            addCriterion("require_message <=", value, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageLike(String value) {
            addCriterion("require_message like", value, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageNotLike(String value) {
            addCriterion("require_message not like", value, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageIn(List<String> values) {
            addCriterion("require_message in", values, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageNotIn(List<String> values) {
            addCriterion("require_message not in", values, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageBetween(String value1, String value2) {
            addCriterion("require_message between", value1, value2, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andRequireMessageNotBetween(String value1, String value2) {
            addCriterion("require_message not between", value1, value2, "requireMessage");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Boolean value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Boolean value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Boolean value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Boolean value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Boolean value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Boolean> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Boolean> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
    }

    /**
     * nj_user_business_approval
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_user_business_approval 2018-07-04
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