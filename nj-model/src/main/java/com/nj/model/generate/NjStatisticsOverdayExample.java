package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NjStatisticsOverdayExample {
    /**
     * nj_statistics_overday
     */
    protected String orderByClause;

    /**
     * nj_statistics_overday
     */
    protected boolean distinct;

    /**
     * nj_statistics_overday
     */
    protected List<Criteria> oredCriteria;

    public NjStatisticsOverdayExample() {
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
     * nj_statistics_overday 2018-09-13
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andDateIsNull() {
            addCriterion("date_ is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date_ is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date_ =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date_ <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date_ >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date_ >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date_ <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date_ <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date_ in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date_ not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date_ between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date_ not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumIsNull() {
            addCriterion("m1_person_num is null");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumIsNotNull() {
            addCriterion("m1_person_num is not null");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumEqualTo(Integer value) {
            addCriterion("m1_person_num =", value, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumNotEqualTo(Integer value) {
            addCriterion("m1_person_num <>", value, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumGreaterThan(Integer value) {
            addCriterion("m1_person_num >", value, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("m1_person_num >=", value, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumLessThan(Integer value) {
            addCriterion("m1_person_num <", value, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumLessThanOrEqualTo(Integer value) {
            addCriterion("m1_person_num <=", value, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumIn(List<Integer> values) {
            addCriterion("m1_person_num in", values, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumNotIn(List<Integer> values) {
            addCriterion("m1_person_num not in", values, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumBetween(Integer value1, Integer value2) {
            addCriterion("m1_person_num between", value1, value2, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1PersonNumNotBetween(Integer value1, Integer value2) {
            addCriterion("m1_person_num not between", value1, value2, "m1PersonNum");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountIsNull() {
            addCriterion("m1_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountIsNotNull() {
            addCriterion("m1_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountEqualTo(BigDecimal value) {
            addCriterion("m1_total_amount =", value, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("m1_total_amount <>", value, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountGreaterThan(BigDecimal value) {
            addCriterion("m1_total_amount >", value, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m1_total_amount >=", value, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountLessThan(BigDecimal value) {
            addCriterion("m1_total_amount <", value, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("m1_total_amount <=", value, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountIn(List<BigDecimal> values) {
            addCriterion("m1_total_amount in", values, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("m1_total_amount not in", values, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m1_total_amount between", value1, value2, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM1TotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m1_total_amount not between", value1, value2, "m1TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumIsNull() {
            addCriterion("m2_person_num is null");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumIsNotNull() {
            addCriterion("m2_person_num is not null");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumEqualTo(Integer value) {
            addCriterion("m2_person_num =", value, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumNotEqualTo(Integer value) {
            addCriterion("m2_person_num <>", value, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumGreaterThan(Integer value) {
            addCriterion("m2_person_num >", value, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("m2_person_num >=", value, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumLessThan(Integer value) {
            addCriterion("m2_person_num <", value, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumLessThanOrEqualTo(Integer value) {
            addCriterion("m2_person_num <=", value, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumIn(List<Integer> values) {
            addCriterion("m2_person_num in", values, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumNotIn(List<Integer> values) {
            addCriterion("m2_person_num not in", values, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumBetween(Integer value1, Integer value2) {
            addCriterion("m2_person_num between", value1, value2, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2PersonNumNotBetween(Integer value1, Integer value2) {
            addCriterion("m2_person_num not between", value1, value2, "m2PersonNum");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountIsNull() {
            addCriterion("m2_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountIsNotNull() {
            addCriterion("m2_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountEqualTo(BigDecimal value) {
            addCriterion("m2_total_amount =", value, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("m2_total_amount <>", value, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountGreaterThan(BigDecimal value) {
            addCriterion("m2_total_amount >", value, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m2_total_amount >=", value, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountLessThan(BigDecimal value) {
            addCriterion("m2_total_amount <", value, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("m2_total_amount <=", value, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountIn(List<BigDecimal> values) {
            addCriterion("m2_total_amount in", values, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("m2_total_amount not in", values, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m2_total_amount between", value1, value2, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2TotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m2_total_amount not between", value1, value2, "m2TotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumIsNull() {
            addCriterion("m2_more_person_num is null");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumIsNotNull() {
            addCriterion("m2_more_person_num is not null");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumEqualTo(Integer value) {
            addCriterion("m2_more_person_num =", value, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumNotEqualTo(Integer value) {
            addCriterion("m2_more_person_num <>", value, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumGreaterThan(Integer value) {
            addCriterion("m2_more_person_num >", value, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("m2_more_person_num >=", value, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumLessThan(Integer value) {
            addCriterion("m2_more_person_num <", value, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumLessThanOrEqualTo(Integer value) {
            addCriterion("m2_more_person_num <=", value, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumIn(List<Integer> values) {
            addCriterion("m2_more_person_num in", values, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumNotIn(List<Integer> values) {
            addCriterion("m2_more_person_num not in", values, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumBetween(Integer value1, Integer value2) {
            addCriterion("m2_more_person_num between", value1, value2, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MorePersonNumNotBetween(Integer value1, Integer value2) {
            addCriterion("m2_more_person_num not between", value1, value2, "m2MorePersonNum");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountIsNull() {
            addCriterion("m2_more_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountIsNotNull() {
            addCriterion("m2_more_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountEqualTo(BigDecimal value) {
            addCriterion("m2_more_total_amount =", value, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("m2_more_total_amount <>", value, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("m2_more_total_amount >", value, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("m2_more_total_amount >=", value, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountLessThan(BigDecimal value) {
            addCriterion("m2_more_total_amount <", value, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("m2_more_total_amount <=", value, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountIn(List<BigDecimal> values) {
            addCriterion("m2_more_total_amount in", values, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("m2_more_total_amount not in", values, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m2_more_total_amount between", value1, value2, "m2MoreTotalAmount");
            return (Criteria) this;
        }

        public Criteria andM2MoreTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("m2_more_total_amount not between", value1, value2, "m2MoreTotalAmount");
            return (Criteria) this;
        }
    }

    /**
     * nj_statistics_overday
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_statistics_overday 2018-09-13
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