package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NjStatisticsOrderExample {
    /**
     * nj_statistics_order
     */
    protected String orderByClause;

    /**
     * nj_statistics_order
     */
    protected boolean distinct;

    /**
     * nj_statistics_order
     */
    protected List<Criteria> oredCriteria;

    public NjStatisticsOrderExample() {
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
     * nj_statistics_order 2018-08-01
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andPassNumIsNull() {
            addCriterion("pass_num is null");
            return (Criteria) this;
        }

        public Criteria andPassNumIsNotNull() {
            addCriterion("pass_num is not null");
            return (Criteria) this;
        }

        public Criteria andPassNumEqualTo(String value) {
            addCriterion("pass_num =", value, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumNotEqualTo(String value) {
            addCriterion("pass_num <>", value, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumGreaterThan(String value) {
            addCriterion("pass_num >", value, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumGreaterThanOrEqualTo(String value) {
            addCriterion("pass_num >=", value, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumLessThan(String value) {
            addCriterion("pass_num <", value, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumLessThanOrEqualTo(String value) {
            addCriterion("pass_num <=", value, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumLike(String value) {
            addCriterion("pass_num like", value, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumNotLike(String value) {
            addCriterion("pass_num not like", value, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumIn(List<String> values) {
            addCriterion("pass_num in", values, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumNotIn(List<String> values) {
            addCriterion("pass_num not in", values, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumBetween(String value1, String value2) {
            addCriterion("pass_num between", value1, value2, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassNumNotBetween(String value1, String value2) {
            addCriterion("pass_num not between", value1, value2, "passNum");
            return (Criteria) this;
        }

        public Criteria andPassAmountIsNull() {
            addCriterion("pass_amount is null");
            return (Criteria) this;
        }

        public Criteria andPassAmountIsNotNull() {
            addCriterion("pass_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPassAmountEqualTo(BigDecimal value) {
            addCriterion("pass_amount =", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountNotEqualTo(BigDecimal value) {
            addCriterion("pass_amount <>", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountGreaterThan(BigDecimal value) {
            addCriterion("pass_amount >", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pass_amount >=", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountLessThan(BigDecimal value) {
            addCriterion("pass_amount <", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pass_amount <=", value, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountIn(List<BigDecimal> values) {
            addCriterion("pass_amount in", values, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountNotIn(List<BigDecimal> values) {
            addCriterion("pass_amount not in", values, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pass_amount between", value1, value2, "passAmount");
            return (Criteria) this;
        }

        public Criteria andPassAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pass_amount not between", value1, value2, "passAmount");
            return (Criteria) this;
        }

        public Criteria andLoanNumIsNull() {
            addCriterion("loan_num is null");
            return (Criteria) this;
        }

        public Criteria andLoanNumIsNotNull() {
            addCriterion("loan_num is not null");
            return (Criteria) this;
        }

        public Criteria andLoanNumEqualTo(String value) {
            addCriterion("loan_num =", value, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumNotEqualTo(String value) {
            addCriterion("loan_num <>", value, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumGreaterThan(String value) {
            addCriterion("loan_num >", value, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumGreaterThanOrEqualTo(String value) {
            addCriterion("loan_num >=", value, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumLessThan(String value) {
            addCriterion("loan_num <", value, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumLessThanOrEqualTo(String value) {
            addCriterion("loan_num <=", value, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumLike(String value) {
            addCriterion("loan_num like", value, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumNotLike(String value) {
            addCriterion("loan_num not like", value, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumIn(List<String> values) {
            addCriterion("loan_num in", values, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumNotIn(List<String> values) {
            addCriterion("loan_num not in", values, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumBetween(String value1, String value2) {
            addCriterion("loan_num between", value1, value2, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanNumNotBetween(String value1, String value2) {
            addCriterion("loan_num not between", value1, value2, "loanNum");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNull() {
            addCriterion("loan_amount is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNotNull() {
            addCriterion("loan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountEqualTo(BigDecimal value) {
            addCriterion("loan_amount =", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotEqualTo(BigDecimal value) {
            addCriterion("loan_amount <>", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThan(BigDecimal value) {
            addCriterion("loan_amount >", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amount >=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThan(BigDecimal value) {
            addCriterion("loan_amount <", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amount <=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIn(List<BigDecimal> values) {
            addCriterion("loan_amount in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotIn(List<BigDecimal> values) {
            addCriterion("loan_amount not in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amount between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amount not between", value1, value2, "loanAmount");
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andRefuseNumIsNull() {
            addCriterion("refuse_num is null");
            return (Criteria) this;
        }

        public Criteria andRefuseNumIsNotNull() {
            addCriterion("refuse_num is not null");
            return (Criteria) this;
        }

        public Criteria andRefuseNumEqualTo(String value) {
            addCriterion("refuse_num =", value, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumNotEqualTo(String value) {
            addCriterion("refuse_num <>", value, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumGreaterThan(String value) {
            addCriterion("refuse_num >", value, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumGreaterThanOrEqualTo(String value) {
            addCriterion("refuse_num >=", value, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumLessThan(String value) {
            addCriterion("refuse_num <", value, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumLessThanOrEqualTo(String value) {
            addCriterion("refuse_num <=", value, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumLike(String value) {
            addCriterion("refuse_num like", value, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumNotLike(String value) {
            addCriterion("refuse_num not like", value, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumIn(List<String> values) {
            addCriterion("refuse_num in", values, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumNotIn(List<String> values) {
            addCriterion("refuse_num not in", values, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumBetween(String value1, String value2) {
            addCriterion("refuse_num between", value1, value2, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andRefuseNumNotBetween(String value1, String value2) {
            addCriterion("refuse_num not between", value1, value2, "refuseNum");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseIsNull() {
            addCriterion("avg_match_hourse is null");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseIsNotNull() {
            addCriterion("avg_match_hourse is not null");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseEqualTo(Double value) {
            addCriterion("avg_match_hourse =", value, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseNotEqualTo(Double value) {
            addCriterion("avg_match_hourse <>", value, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseGreaterThan(Double value) {
            addCriterion("avg_match_hourse >", value, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseGreaterThanOrEqualTo(Double value) {
            addCriterion("avg_match_hourse >=", value, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseLessThan(Double value) {
            addCriterion("avg_match_hourse <", value, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseLessThanOrEqualTo(Double value) {
            addCriterion("avg_match_hourse <=", value, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseIn(List<Double> values) {
            addCriterion("avg_match_hourse in", values, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseNotIn(List<Double> values) {
            addCriterion("avg_match_hourse not in", values, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseBetween(Double value1, Double value2) {
            addCriterion("avg_match_hourse between", value1, value2, "avgMatchHourse");
            return (Criteria) this;
        }

        public Criteria andAvgMatchHourseNotBetween(Double value1, Double value2) {
            addCriterion("avg_match_hourse not between", value1, value2, "avgMatchHourse");
            return (Criteria) this;
        }
    }

    /**
     * nj_statistics_order
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_statistics_order 2018-08-01
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