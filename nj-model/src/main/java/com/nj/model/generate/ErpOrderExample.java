package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class ErpOrderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public ErpOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoIsNull() {
            addCriterion("source_order_no is null");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoIsNotNull() {
            addCriterion("source_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoEqualTo(String value) {
            addCriterion("source_order_no =", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoNotEqualTo(String value) {
            addCriterion("source_order_no <>", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoGreaterThan(String value) {
            addCriterion("source_order_no >", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("source_order_no >=", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoLessThan(String value) {
            addCriterion("source_order_no <", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoLessThanOrEqualTo(String value) {
            addCriterion("source_order_no <=", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoLike(String value) {
            addCriterion("source_order_no like", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoNotLike(String value) {
            addCriterion("source_order_no not like", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoIn(List<String> values) {
            addCriterion("source_order_no in", values, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoNotIn(List<String> values) {
            addCriterion("source_order_no not in", values, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoBetween(String value1, String value2) {
            addCriterion("source_order_no between", value1, value2, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoNotBetween(String value1, String value2) {
            addCriterion("source_order_no not between", value1, value2, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransWayIsNull() {
            addCriterion("trans_way is null");
            return (Criteria) this;
        }

        public Criteria andTransWayIsNotNull() {
            addCriterion("trans_way is not null");
            return (Criteria) this;
        }

        public Criteria andTransWayEqualTo(String value) {
            addCriterion("trans_way =", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayNotEqualTo(String value) {
            addCriterion("trans_way <>", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayGreaterThan(String value) {
            addCriterion("trans_way >", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayGreaterThanOrEqualTo(String value) {
            addCriterion("trans_way >=", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayLessThan(String value) {
            addCriterion("trans_way <", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayLessThanOrEqualTo(String value) {
            addCriterion("trans_way <=", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayLike(String value) {
            addCriterion("trans_way like", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayNotLike(String value) {
            addCriterion("trans_way not like", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayIn(List<String> values) {
            addCriterion("trans_way in", values, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayNotIn(List<String> values) {
            addCriterion("trans_way not in", values, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayBetween(String value1, String value2) {
            addCriterion("trans_way between", value1, value2, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayNotBetween(String value1, String value2) {
            addCriterion("trans_way not between", value1, value2, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransNoIsNull() {
            addCriterion("trans_no is null");
            return (Criteria) this;
        }

        public Criteria andTransNoIsNotNull() {
            addCriterion("trans_no is not null");
            return (Criteria) this;
        }

        public Criteria andTransNoEqualTo(String value) {
            addCriterion("trans_no =", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoNotEqualTo(String value) {
            addCriterion("trans_no <>", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoGreaterThan(String value) {
            addCriterion("trans_no >", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoGreaterThanOrEqualTo(String value) {
            addCriterion("trans_no >=", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoLessThan(String value) {
            addCriterion("trans_no <", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoLessThanOrEqualTo(String value) {
            addCriterion("trans_no <=", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoLike(String value) {
            addCriterion("trans_no like", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoNotLike(String value) {
            addCriterion("trans_no not like", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoIn(List<String> values) {
            addCriterion("trans_no in", values, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoNotIn(List<String> values) {
            addCriterion("trans_no not in", values, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoBetween(String value1, String value2) {
            addCriterion("trans_no between", value1, value2, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoNotBetween(String value1, String value2) {
            addCriterion("trans_no not between", value1, value2, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransMoneyIsNull() {
            addCriterion("trans_money is null");
            return (Criteria) this;
        }

        public Criteria andTransMoneyIsNotNull() {
            addCriterion("trans_money is not null");
            return (Criteria) this;
        }

        public Criteria andTransMoneyEqualTo(String value) {
            addCriterion("trans_money =", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyNotEqualTo(String value) {
            addCriterion("trans_money <>", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyGreaterThan(String value) {
            addCriterion("trans_money >", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("trans_money >=", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyLessThan(String value) {
            addCriterion("trans_money <", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyLessThanOrEqualTo(String value) {
            addCriterion("trans_money <=", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyLike(String value) {
            addCriterion("trans_money like", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyNotLike(String value) {
            addCriterion("trans_money not like", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyIn(List<String> values) {
            addCriterion("trans_money in", values, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyNotIn(List<String> values) {
            addCriterion("trans_money not in", values, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyBetween(String value1, String value2) {
            addCriterion("trans_money between", value1, value2, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyNotBetween(String value1, String value2) {
            addCriterion("trans_money not between", value1, value2, "transMoney");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(String value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(String value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(String value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLike(String value) {
            addCriterion("source_type like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotLike(String value) {
            addCriterion("source_type not like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<String> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<String> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(String value1, String value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(String value1, String value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStockNoIsNull() {
            addCriterion("stock_no is null");
            return (Criteria) this;
        }

        public Criteria andStockNoIsNotNull() {
            addCriterion("stock_no is not null");
            return (Criteria) this;
        }

        public Criteria andStockNoEqualTo(String value) {
            addCriterion("stock_no =", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoNotEqualTo(String value) {
            addCriterion("stock_no <>", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoGreaterThan(String value) {
            addCriterion("stock_no >", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoGreaterThanOrEqualTo(String value) {
            addCriterion("stock_no >=", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoLessThan(String value) {
            addCriterion("stock_no <", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoLessThanOrEqualTo(String value) {
            addCriterion("stock_no <=", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoLike(String value) {
            addCriterion("stock_no like", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoNotLike(String value) {
            addCriterion("stock_no not like", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoIn(List<String> values) {
            addCriterion("stock_no in", values, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoNotIn(List<String> values) {
            addCriterion("stock_no not in", values, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoBetween(String value1, String value2) {
            addCriterion("stock_no between", value1, value2, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoNotBetween(String value1, String value2) {
            addCriterion("stock_no not between", value1, value2, "stockNo");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table erp_order
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 19 15:30:55 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table erp_order
     *
     * @mbggenerated Wed Aug 19 15:30:55 CST 2020
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