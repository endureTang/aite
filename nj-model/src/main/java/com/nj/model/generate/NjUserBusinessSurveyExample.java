package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjUserBusinessSurveyExample {
    /**
     * nj_user_business_survey
     */
    protected String orderByClause;

    /**
     * nj_user_business_survey
     */
    protected boolean distinct;

    /**
     * nj_user_business_survey
     */
    protected List<Criteria> oredCriteria;

    public NjUserBusinessSurveyExample() {
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
     * nj_user_business_survey 2018-08-01
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

        public Criteria andPawnIdIsNull() {
            addCriterion("pawn_id is null");
            return (Criteria) this;
        }

        public Criteria andPawnIdIsNotNull() {
            addCriterion("pawn_id is not null");
            return (Criteria) this;
        }

        public Criteria andPawnIdEqualTo(String value) {
            addCriterion("pawn_id =", value, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdNotEqualTo(String value) {
            addCriterion("pawn_id <>", value, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdGreaterThan(String value) {
            addCriterion("pawn_id >", value, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_id >=", value, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdLessThan(String value) {
            addCriterion("pawn_id <", value, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdLessThanOrEqualTo(String value) {
            addCriterion("pawn_id <=", value, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdLike(String value) {
            addCriterion("pawn_id like", value, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdNotLike(String value) {
            addCriterion("pawn_id not like", value, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdIn(List<String> values) {
            addCriterion("pawn_id in", values, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdNotIn(List<String> values) {
            addCriterion("pawn_id not in", values, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdBetween(String value1, String value2) {
            addCriterion("pawn_id between", value1, value2, "pawnId");
            return (Criteria) this;
        }

        public Criteria andPawnIdNotBetween(String value1, String value2) {
            addCriterion("pawn_id not between", value1, value2, "pawnId");
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

        public Criteria andBusinessNoIsNull() {
            addCriterion("business_no is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIsNotNull() {
            addCriterion("business_no is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNoEqualTo(String value) {
            addCriterion("business_no =", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotEqualTo(String value) {
            addCriterion("business_no <>", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoGreaterThan(String value) {
            addCriterion("business_no >", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoGreaterThanOrEqualTo(String value) {
            addCriterion("business_no >=", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLessThan(String value) {
            addCriterion("business_no <", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLessThanOrEqualTo(String value) {
            addCriterion("business_no <=", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLike(String value) {
            addCriterion("business_no like", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotLike(String value) {
            addCriterion("business_no not like", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIn(List<String> values) {
            addCriterion("business_no in", values, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotIn(List<String> values) {
            addCriterion("business_no not in", values, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoBetween(String value1, String value2) {
            addCriterion("business_no between", value1, value2, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotBetween(String value1, String value2) {
            addCriterion("business_no not between", value1, value2, "businessNo");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
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

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeIsNull() {
            addCriterion("pawn_type is null");
            return (Criteria) this;
        }

        public Criteria andPawnTypeIsNotNull() {
            addCriterion("pawn_type is not null");
            return (Criteria) this;
        }

        public Criteria andPawnTypeEqualTo(String value) {
            addCriterion("pawn_type =", value, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeNotEqualTo(String value) {
            addCriterion("pawn_type <>", value, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeGreaterThan(String value) {
            addCriterion("pawn_type >", value, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_type >=", value, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeLessThan(String value) {
            addCriterion("pawn_type <", value, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeLessThanOrEqualTo(String value) {
            addCriterion("pawn_type <=", value, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeLike(String value) {
            addCriterion("pawn_type like", value, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeNotLike(String value) {
            addCriterion("pawn_type not like", value, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeIn(List<String> values) {
            addCriterion("pawn_type in", values, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeNotIn(List<String> values) {
            addCriterion("pawn_type not in", values, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeBetween(String value1, String value2) {
            addCriterion("pawn_type between", value1, value2, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnTypeNotBetween(String value1, String value2) {
            addCriterion("pawn_type not between", value1, value2, "pawnType");
            return (Criteria) this;
        }

        public Criteria andPawnAreaIsNull() {
            addCriterion("pawn_area is null");
            return (Criteria) this;
        }

        public Criteria andPawnAreaIsNotNull() {
            addCriterion("pawn_area is not null");
            return (Criteria) this;
        }

        public Criteria andPawnAreaEqualTo(String value) {
            addCriterion("pawn_area =", value, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaNotEqualTo(String value) {
            addCriterion("pawn_area <>", value, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaGreaterThan(String value) {
            addCriterion("pawn_area >", value, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_area >=", value, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaLessThan(String value) {
            addCriterion("pawn_area <", value, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaLessThanOrEqualTo(String value) {
            addCriterion("pawn_area <=", value, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaLike(String value) {
            addCriterion("pawn_area like", value, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaNotLike(String value) {
            addCriterion("pawn_area not like", value, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaIn(List<String> values) {
            addCriterion("pawn_area in", values, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaNotIn(List<String> values) {
            addCriterion("pawn_area not in", values, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaBetween(String value1, String value2) {
            addCriterion("pawn_area between", value1, value2, "pawnArea");
            return (Criteria) this;
        }

        public Criteria andPawnAreaNotBetween(String value1, String value2) {
            addCriterion("pawn_area not between", value1, value2, "pawnArea");
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

        public Criteria andRatingIsNull() {
            addCriterion("rating is null");
            return (Criteria) this;
        }

        public Criteria andRatingIsNotNull() {
            addCriterion("rating is not null");
            return (Criteria) this;
        }

        public Criteria andRatingEqualTo(String value) {
            addCriterion("rating =", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotEqualTo(String value) {
            addCriterion("rating <>", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThan(String value) {
            addCriterion("rating >", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThanOrEqualTo(String value) {
            addCriterion("rating >=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThan(String value) {
            addCriterion("rating <", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThanOrEqualTo(String value) {
            addCriterion("rating <=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLike(String value) {
            addCriterion("rating like", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotLike(String value) {
            addCriterion("rating not like", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingIn(List<String> values) {
            addCriterion("rating in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotIn(List<String> values) {
            addCriterion("rating not in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingBetween(String value1, String value2) {
            addCriterion("rating between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotBetween(String value1, String value2) {
            addCriterion("rating not between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNull() {
            addCriterion("loan_type is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(String value) {
            addCriterion("loan_type =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(String value) {
            addCriterion("loan_type <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(String value) {
            addCriterion("loan_type >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_type >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(String value) {
            addCriterion("loan_type <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(String value) {
            addCriterion("loan_type <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLike(String value) {
            addCriterion("loan_type like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotLike(String value) {
            addCriterion("loan_type not like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<String> values) {
            addCriterion("loan_type in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<String> values) {
            addCriterion("loan_type not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(String value1, String value2) {
            addCriterion("loan_type between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(String value1, String value2) {
            addCriterion("loan_type not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andUsageDescIsNull() {
            addCriterion("usage_desc is null");
            return (Criteria) this;
        }

        public Criteria andUsageDescIsNotNull() {
            addCriterion("usage_desc is not null");
            return (Criteria) this;
        }

        public Criteria andUsageDescEqualTo(String value) {
            addCriterion("usage_desc =", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescNotEqualTo(String value) {
            addCriterion("usage_desc <>", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescGreaterThan(String value) {
            addCriterion("usage_desc >", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescGreaterThanOrEqualTo(String value) {
            addCriterion("usage_desc >=", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescLessThan(String value) {
            addCriterion("usage_desc <", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescLessThanOrEqualTo(String value) {
            addCriterion("usage_desc <=", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescLike(String value) {
            addCriterion("usage_desc like", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescNotLike(String value) {
            addCriterion("usage_desc not like", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescIn(List<String> values) {
            addCriterion("usage_desc in", values, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescNotIn(List<String> values) {
            addCriterion("usage_desc not in", values, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescBetween(String value1, String value2) {
            addCriterion("usage_desc between", value1, value2, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescNotBetween(String value1, String value2) {
            addCriterion("usage_desc not between", value1, value2, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andOverdueIsNull() {
            addCriterion("overdue is null");
            return (Criteria) this;
        }

        public Criteria andOverdueIsNotNull() {
            addCriterion("overdue is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueEqualTo(Integer value) {
            addCriterion("overdue =", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotEqualTo(Integer value) {
            addCriterion("overdue <>", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueGreaterThan(Integer value) {
            addCriterion("overdue >", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue >=", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLessThan(Integer value) {
            addCriterion("overdue <", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLessThanOrEqualTo(Integer value) {
            addCriterion("overdue <=", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueIn(List<Integer> values) {
            addCriterion("overdue in", values, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotIn(List<Integer> values) {
            addCriterion("overdue not in", values, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueBetween(Integer value1, Integer value2) {
            addCriterion("overdue between", value1, value2, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("overdue not between", value1, value2, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalIsNull() {
            addCriterion("overdue_total is null");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalIsNotNull() {
            addCriterion("overdue_total is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalEqualTo(Integer value) {
            addCriterion("overdue_total =", value, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalNotEqualTo(Integer value) {
            addCriterion("overdue_total <>", value, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalGreaterThan(Integer value) {
            addCriterion("overdue_total >", value, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue_total >=", value, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalLessThan(Integer value) {
            addCriterion("overdue_total <", value, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalLessThanOrEqualTo(Integer value) {
            addCriterion("overdue_total <=", value, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalIn(List<Integer> values) {
            addCriterion("overdue_total in", values, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalNotIn(List<Integer> values) {
            addCriterion("overdue_total not in", values, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalBetween(Integer value1, Integer value2) {
            addCriterion("overdue_total between", value1, value2, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andOverdueTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("overdue_total not between", value1, value2, "overdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueIsNull() {
            addCriterion("credit_overdue is null");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueIsNotNull() {
            addCriterion("credit_overdue is not null");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueEqualTo(Integer value) {
            addCriterion("credit_overdue =", value, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueNotEqualTo(Integer value) {
            addCriterion("credit_overdue <>", value, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueGreaterThan(Integer value) {
            addCriterion("credit_overdue >", value, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit_overdue >=", value, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueLessThan(Integer value) {
            addCriterion("credit_overdue <", value, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueLessThanOrEqualTo(Integer value) {
            addCriterion("credit_overdue <=", value, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueIn(List<Integer> values) {
            addCriterion("credit_overdue in", values, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueNotIn(List<Integer> values) {
            addCriterion("credit_overdue not in", values, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueBetween(Integer value1, Integer value2) {
            addCriterion("credit_overdue between", value1, value2, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("credit_overdue not between", value1, value2, "creditOverdue");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalIsNull() {
            addCriterion("credit_overdue_total is null");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalIsNotNull() {
            addCriterion("credit_overdue_total is not null");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalEqualTo(Integer value) {
            addCriterion("credit_overdue_total =", value, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalNotEqualTo(Integer value) {
            addCriterion("credit_overdue_total <>", value, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalGreaterThan(Integer value) {
            addCriterion("credit_overdue_total >", value, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit_overdue_total >=", value, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalLessThan(Integer value) {
            addCriterion("credit_overdue_total <", value, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalLessThanOrEqualTo(Integer value) {
            addCriterion("credit_overdue_total <=", value, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalIn(List<Integer> values) {
            addCriterion("credit_overdue_total in", values, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalNotIn(List<Integer> values) {
            addCriterion("credit_overdue_total not in", values, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalBetween(Integer value1, Integer value2) {
            addCriterion("credit_overdue_total between", value1, value2, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andCreditOverdueTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("credit_overdue_total not between", value1, value2, "creditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andUserReviewIsNull() {
            addCriterion("user_review is null");
            return (Criteria) this;
        }

        public Criteria andUserReviewIsNotNull() {
            addCriterion("user_review is not null");
            return (Criteria) this;
        }

        public Criteria andUserReviewEqualTo(String value) {
            addCriterion("user_review =", value, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewNotEqualTo(String value) {
            addCriterion("user_review <>", value, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewGreaterThan(String value) {
            addCriterion("user_review >", value, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewGreaterThanOrEqualTo(String value) {
            addCriterion("user_review >=", value, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewLessThan(String value) {
            addCriterion("user_review <", value, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewLessThanOrEqualTo(String value) {
            addCriterion("user_review <=", value, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewLike(String value) {
            addCriterion("user_review like", value, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewNotLike(String value) {
            addCriterion("user_review not like", value, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewIn(List<String> values) {
            addCriterion("user_review in", values, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewNotIn(List<String> values) {
            addCriterion("user_review not in", values, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewBetween(String value1, String value2) {
            addCriterion("user_review between", value1, value2, "userReview");
            return (Criteria) this;
        }

        public Criteria andUserReviewNotBetween(String value1, String value2) {
            addCriterion("user_review not between", value1, value2, "userReview");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueIsNull() {
            addCriterion("together_overdue is null");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueIsNotNull() {
            addCriterion("together_overdue is not null");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueEqualTo(Integer value) {
            addCriterion("together_overdue =", value, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueNotEqualTo(Integer value) {
            addCriterion("together_overdue <>", value, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueGreaterThan(Integer value) {
            addCriterion("together_overdue >", value, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("together_overdue >=", value, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueLessThan(Integer value) {
            addCriterion("together_overdue <", value, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueLessThanOrEqualTo(Integer value) {
            addCriterion("together_overdue <=", value, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueIn(List<Integer> values) {
            addCriterion("together_overdue in", values, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueNotIn(List<Integer> values) {
            addCriterion("together_overdue not in", values, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueBetween(Integer value1, Integer value2) {
            addCriterion("together_overdue between", value1, value2, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("together_overdue not between", value1, value2, "togetherOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalIsNull() {
            addCriterion("together_overdue_total is null");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalIsNotNull() {
            addCriterion("together_overdue_total is not null");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalEqualTo(Integer value) {
            addCriterion("together_overdue_total =", value, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalNotEqualTo(Integer value) {
            addCriterion("together_overdue_total <>", value, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalGreaterThan(Integer value) {
            addCriterion("together_overdue_total >", value, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("together_overdue_total >=", value, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalLessThan(Integer value) {
            addCriterion("together_overdue_total <", value, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalLessThanOrEqualTo(Integer value) {
            addCriterion("together_overdue_total <=", value, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalIn(List<Integer> values) {
            addCriterion("together_overdue_total in", values, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalNotIn(List<Integer> values) {
            addCriterion("together_overdue_total not in", values, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalBetween(Integer value1, Integer value2) {
            addCriterion("together_overdue_total between", value1, value2, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherOverdueTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("together_overdue_total not between", value1, value2, "togetherOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueIsNull() {
            addCriterion("together_credit_overdue is null");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueIsNotNull() {
            addCriterion("together_credit_overdue is not null");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueEqualTo(Integer value) {
            addCriterion("together_credit_overdue =", value, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueNotEqualTo(Integer value) {
            addCriterion("together_credit_overdue <>", value, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueGreaterThan(Integer value) {
            addCriterion("together_credit_overdue >", value, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("together_credit_overdue >=", value, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueLessThan(Integer value) {
            addCriterion("together_credit_overdue <", value, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueLessThanOrEqualTo(Integer value) {
            addCriterion("together_credit_overdue <=", value, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueIn(List<Integer> values) {
            addCriterion("together_credit_overdue in", values, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueNotIn(List<Integer> values) {
            addCriterion("together_credit_overdue not in", values, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueBetween(Integer value1, Integer value2) {
            addCriterion("together_credit_overdue between", value1, value2, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("together_credit_overdue not between", value1, value2, "togetherCreditOverdue");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalIsNull() {
            addCriterion("together_credit_overdue_total is null");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalIsNotNull() {
            addCriterion("together_credit_overdue_total is not null");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalEqualTo(Integer value) {
            addCriterion("together_credit_overdue_total =", value, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalNotEqualTo(Integer value) {
            addCriterion("together_credit_overdue_total <>", value, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalGreaterThan(Integer value) {
            addCriterion("together_credit_overdue_total >", value, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("together_credit_overdue_total >=", value, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalLessThan(Integer value) {
            addCriterion("together_credit_overdue_total <", value, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalLessThanOrEqualTo(Integer value) {
            addCriterion("together_credit_overdue_total <=", value, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalIn(List<Integer> values) {
            addCriterion("together_credit_overdue_total in", values, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalNotIn(List<Integer> values) {
            addCriterion("together_credit_overdue_total not in", values, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalBetween(Integer value1, Integer value2) {
            addCriterion("together_credit_overdue_total between", value1, value2, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andTogetherCreditOverdueTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("together_credit_overdue_total not between", value1, value2, "togetherCreditOverdueTotal");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewIsNull() {
            addCriterion("user_together_review is null");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewIsNotNull() {
            addCriterion("user_together_review is not null");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewEqualTo(String value) {
            addCriterion("user_together_review =", value, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewNotEqualTo(String value) {
            addCriterion("user_together_review <>", value, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewGreaterThan(String value) {
            addCriterion("user_together_review >", value, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewGreaterThanOrEqualTo(String value) {
            addCriterion("user_together_review >=", value, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewLessThan(String value) {
            addCriterion("user_together_review <", value, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewLessThanOrEqualTo(String value) {
            addCriterion("user_together_review <=", value, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewLike(String value) {
            addCriterion("user_together_review like", value, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewNotLike(String value) {
            addCriterion("user_together_review not like", value, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewIn(List<String> values) {
            addCriterion("user_together_review in", values, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewNotIn(List<String> values) {
            addCriterion("user_together_review not in", values, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewBetween(String value1, String value2) {
            addCriterion("user_together_review between", value1, value2, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andUserTogetherReviewNotBetween(String value1, String value2) {
            addCriterion("user_together_review not between", value1, value2, "userTogetherReview");
            return (Criteria) this;
        }

        public Criteria andNetQueryIsNull() {
            addCriterion("net_query is null");
            return (Criteria) this;
        }

        public Criteria andNetQueryIsNotNull() {
            addCriterion("net_query is not null");
            return (Criteria) this;
        }

        public Criteria andNetQueryEqualTo(Boolean value) {
            addCriterion("net_query =", value, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryNotEqualTo(Boolean value) {
            addCriterion("net_query <>", value, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryGreaterThan(Boolean value) {
            addCriterion("net_query >", value, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("net_query >=", value, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryLessThan(Boolean value) {
            addCriterion("net_query <", value, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryLessThanOrEqualTo(Boolean value) {
            addCriterion("net_query <=", value, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryIn(List<Boolean> values) {
            addCriterion("net_query in", values, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryNotIn(List<Boolean> values) {
            addCriterion("net_query not in", values, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryBetween(Boolean value1, Boolean value2) {
            addCriterion("net_query between", value1, value2, "netQuery");
            return (Criteria) this;
        }

        public Criteria andNetQueryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("net_query not between", value1, value2, "netQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryIsNull() {
            addCriterion("credit_net_query is null");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryIsNotNull() {
            addCriterion("credit_net_query is not null");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryEqualTo(Boolean value) {
            addCriterion("credit_net_query =", value, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryNotEqualTo(Boolean value) {
            addCriterion("credit_net_query <>", value, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryGreaterThan(Boolean value) {
            addCriterion("credit_net_query >", value, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("credit_net_query >=", value, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryLessThan(Boolean value) {
            addCriterion("credit_net_query <", value, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryLessThanOrEqualTo(Boolean value) {
            addCriterion("credit_net_query <=", value, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryIn(List<Boolean> values) {
            addCriterion("credit_net_query in", values, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryNotIn(List<Boolean> values) {
            addCriterion("credit_net_query not in", values, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryBetween(Boolean value1, Boolean value2) {
            addCriterion("credit_net_query between", value1, value2, "creditNetQuery");
            return (Criteria) this;
        }

        public Criteria andCreditNetQueryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("credit_net_query not between", value1, value2, "creditNetQuery");
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

        public Criteria andMarrStatusEqualTo(String value) {
            addCriterion("marr_status =", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusNotEqualTo(String value) {
            addCriterion("marr_status <>", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusGreaterThan(String value) {
            addCriterion("marr_status >", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusGreaterThanOrEqualTo(String value) {
            addCriterion("marr_status >=", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusLessThan(String value) {
            addCriterion("marr_status <", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusLessThanOrEqualTo(String value) {
            addCriterion("marr_status <=", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusLike(String value) {
            addCriterion("marr_status like", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusNotLike(String value) {
            addCriterion("marr_status not like", value, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusIn(List<String> values) {
            addCriterion("marr_status in", values, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusNotIn(List<String> values) {
            addCriterion("marr_status not in", values, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusBetween(String value1, String value2) {
            addCriterion("marr_status between", value1, value2, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrStatusNotBetween(String value1, String value2) {
            addCriterion("marr_status not between", value1, value2, "marrStatus");
            return (Criteria) this;
        }

        public Criteria andMarrYearIsNull() {
            addCriterion("marr_year is null");
            return (Criteria) this;
        }

        public Criteria andMarrYearIsNotNull() {
            addCriterion("marr_year is not null");
            return (Criteria) this;
        }

        public Criteria andMarrYearEqualTo(Integer value) {
            addCriterion("marr_year =", value, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearNotEqualTo(Integer value) {
            addCriterion("marr_year <>", value, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearGreaterThan(Integer value) {
            addCriterion("marr_year >", value, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("marr_year >=", value, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearLessThan(Integer value) {
            addCriterion("marr_year <", value, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearLessThanOrEqualTo(Integer value) {
            addCriterion("marr_year <=", value, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearIn(List<Integer> values) {
            addCriterion("marr_year in", values, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearNotIn(List<Integer> values) {
            addCriterion("marr_year not in", values, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearBetween(Integer value1, Integer value2) {
            addCriterion("marr_year between", value1, value2, "marrYear");
            return (Criteria) this;
        }

        public Criteria andMarrYearNotBetween(Integer value1, Integer value2) {
            addCriterion("marr_year not between", value1, value2, "marrYear");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenIsNull() {
            addCriterion("have_children is null");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenIsNotNull() {
            addCriterion("have_children is not null");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenEqualTo(Boolean value) {
            addCriterion("have_children =", value, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenNotEqualTo(Boolean value) {
            addCriterion("have_children <>", value, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenGreaterThan(Boolean value) {
            addCriterion("have_children >", value, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("have_children >=", value, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenLessThan(Boolean value) {
            addCriterion("have_children <", value, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenLessThanOrEqualTo(Boolean value) {
            addCriterion("have_children <=", value, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenIn(List<Boolean> values) {
            addCriterion("have_children in", values, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenNotIn(List<Boolean> values) {
            addCriterion("have_children not in", values, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenBetween(Boolean value1, Boolean value2) {
            addCriterion("have_children between", value1, value2, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andHaveChildrenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("have_children not between", value1, value2, "haveChildren");
            return (Criteria) this;
        }

        public Criteria andSupportNumberIsNull() {
            addCriterion("support_number is null");
            return (Criteria) this;
        }

        public Criteria andSupportNumberIsNotNull() {
            addCriterion("support_number is not null");
            return (Criteria) this;
        }

        public Criteria andSupportNumberEqualTo(Integer value) {
            addCriterion("support_number =", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberNotEqualTo(Integer value) {
            addCriterion("support_number <>", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberGreaterThan(Integer value) {
            addCriterion("support_number >", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("support_number >=", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberLessThan(Integer value) {
            addCriterion("support_number <", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberLessThanOrEqualTo(Integer value) {
            addCriterion("support_number <=", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberIn(List<Integer> values) {
            addCriterion("support_number in", values, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberNotIn(List<Integer> values) {
            addCriterion("support_number not in", values, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberBetween(Integer value1, Integer value2) {
            addCriterion("support_number between", value1, value2, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("support_number not between", value1, value2, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtIsNull() {
            addCriterion("family_debt is null");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtIsNotNull() {
            addCriterion("family_debt is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtEqualTo(BigDecimal value) {
            addCriterion("family_debt =", value, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtNotEqualTo(BigDecimal value) {
            addCriterion("family_debt <>", value, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtGreaterThan(BigDecimal value) {
            addCriterion("family_debt >", value, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("family_debt >=", value, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtLessThan(BigDecimal value) {
            addCriterion("family_debt <", value, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("family_debt <=", value, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtIn(List<BigDecimal> values) {
            addCriterion("family_debt in", values, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtNotIn(List<BigDecimal> values) {
            addCriterion("family_debt not in", values, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("family_debt between", value1, value2, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andFamilyDebtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("family_debt not between", value1, value2, "familyDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtIsNull() {
            addCriterion("other_debt is null");
            return (Criteria) this;
        }

        public Criteria andOtherDebtIsNotNull() {
            addCriterion("other_debt is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDebtEqualTo(BigDecimal value) {
            addCriterion("other_debt =", value, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtNotEqualTo(BigDecimal value) {
            addCriterion("other_debt <>", value, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtGreaterThan(BigDecimal value) {
            addCriterion("other_debt >", value, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_debt >=", value, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtLessThan(BigDecimal value) {
            addCriterion("other_debt <", value, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_debt <=", value, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtIn(List<BigDecimal> values) {
            addCriterion("other_debt in", values, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtNotIn(List<BigDecimal> values) {
            addCriterion("other_debt not in", values, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_debt between", value1, value2, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andOtherDebtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_debt not between", value1, value2, "otherDebt");
            return (Criteria) this;
        }

        public Criteria andMonthRepayIsNull() {
            addCriterion("month_repay is null");
            return (Criteria) this;
        }

        public Criteria andMonthRepayIsNotNull() {
            addCriterion("month_repay is not null");
            return (Criteria) this;
        }

        public Criteria andMonthRepayEqualTo(BigDecimal value) {
            addCriterion("month_repay =", value, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayNotEqualTo(BigDecimal value) {
            addCriterion("month_repay <>", value, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayGreaterThan(BigDecimal value) {
            addCriterion("month_repay >", value, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_repay >=", value, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayLessThan(BigDecimal value) {
            addCriterion("month_repay <", value, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_repay <=", value, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayIn(List<BigDecimal> values) {
            addCriterion("month_repay in", values, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayNotIn(List<BigDecimal> values) {
            addCriterion("month_repay not in", values, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_repay between", value1, value2, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andMonthRepayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_repay not between", value1, value2, "monthRepay");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameIsNull() {
            addCriterion("house_one_name is null");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameIsNotNull() {
            addCriterion("house_one_name is not null");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameEqualTo(String value) {
            addCriterion("house_one_name =", value, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameNotEqualTo(String value) {
            addCriterion("house_one_name <>", value, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameGreaterThan(String value) {
            addCriterion("house_one_name >", value, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameGreaterThanOrEqualTo(String value) {
            addCriterion("house_one_name >=", value, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameLessThan(String value) {
            addCriterion("house_one_name <", value, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameLessThanOrEqualTo(String value) {
            addCriterion("house_one_name <=", value, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameLike(String value) {
            addCriterion("house_one_name like", value, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameNotLike(String value) {
            addCriterion("house_one_name not like", value, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameIn(List<String> values) {
            addCriterion("house_one_name in", values, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameNotIn(List<String> values) {
            addCriterion("house_one_name not in", values, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameBetween(String value1, String value2) {
            addCriterion("house_one_name between", value1, value2, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOneNameNotBetween(String value1, String value2) {
            addCriterion("house_one_name not between", value1, value2, "houseOneName");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceIsNull() {
            addCriterion("house_one_price is null");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceIsNotNull() {
            addCriterion("house_one_price is not null");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceEqualTo(BigDecimal value) {
            addCriterion("house_one_price =", value, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceNotEqualTo(BigDecimal value) {
            addCriterion("house_one_price <>", value, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceGreaterThan(BigDecimal value) {
            addCriterion("house_one_price >", value, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("house_one_price >=", value, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceLessThan(BigDecimal value) {
            addCriterion("house_one_price <", value, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("house_one_price <=", value, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceIn(List<BigDecimal> values) {
            addCriterion("house_one_price in", values, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceNotIn(List<BigDecimal> values) {
            addCriterion("house_one_price not in", values, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_one_price between", value1, value2, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseOnePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_one_price not between", value1, value2, "houseOnePrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameIsNull() {
            addCriterion("house_two_name is null");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameIsNotNull() {
            addCriterion("house_two_name is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameEqualTo(String value) {
            addCriterion("house_two_name =", value, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameNotEqualTo(String value) {
            addCriterion("house_two_name <>", value, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameGreaterThan(String value) {
            addCriterion("house_two_name >", value, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameGreaterThanOrEqualTo(String value) {
            addCriterion("house_two_name >=", value, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameLessThan(String value) {
            addCriterion("house_two_name <", value, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameLessThanOrEqualTo(String value) {
            addCriterion("house_two_name <=", value, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameLike(String value) {
            addCriterion("house_two_name like", value, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameNotLike(String value) {
            addCriterion("house_two_name not like", value, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameIn(List<String> values) {
            addCriterion("house_two_name in", values, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameNotIn(List<String> values) {
            addCriterion("house_two_name not in", values, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameBetween(String value1, String value2) {
            addCriterion("house_two_name between", value1, value2, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoNameNotBetween(String value1, String value2) {
            addCriterion("house_two_name not between", value1, value2, "houseTwoName");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceIsNull() {
            addCriterion("house_two_price is null");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceIsNotNull() {
            addCriterion("house_two_price is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceEqualTo(BigDecimal value) {
            addCriterion("house_two_price =", value, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceNotEqualTo(BigDecimal value) {
            addCriterion("house_two_price <>", value, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceGreaterThan(BigDecimal value) {
            addCriterion("house_two_price >", value, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("house_two_price >=", value, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceLessThan(BigDecimal value) {
            addCriterion("house_two_price <", value, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("house_two_price <=", value, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceIn(List<BigDecimal> values) {
            addCriterion("house_two_price in", values, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceNotIn(List<BigDecimal> values) {
            addCriterion("house_two_price not in", values, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_two_price between", value1, value2, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andHouseTwoPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_two_price not between", value1, value2, "houseTwoPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceIsNull() {
            addCriterion("car_price is null");
            return (Criteria) this;
        }

        public Criteria andCarPriceIsNotNull() {
            addCriterion("car_price is not null");
            return (Criteria) this;
        }

        public Criteria andCarPriceEqualTo(BigDecimal value) {
            addCriterion("car_price =", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotEqualTo(BigDecimal value) {
            addCriterion("car_price <>", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceGreaterThan(BigDecimal value) {
            addCriterion("car_price >", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("car_price >=", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceLessThan(BigDecimal value) {
            addCriterion("car_price <", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("car_price <=", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceIn(List<BigDecimal> values) {
            addCriterion("car_price in", values, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotIn(List<BigDecimal> values) {
            addCriterion("car_price not in", values, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("car_price between", value1, value2, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("car_price not between", value1, value2, "carPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceIsNull() {
            addCriterion("stock_price is null");
            return (Criteria) this;
        }

        public Criteria andStockPriceIsNotNull() {
            addCriterion("stock_price is not null");
            return (Criteria) this;
        }

        public Criteria andStockPriceEqualTo(BigDecimal value) {
            addCriterion("stock_price =", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceNotEqualTo(BigDecimal value) {
            addCriterion("stock_price <>", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceGreaterThan(BigDecimal value) {
            addCriterion("stock_price >", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_price >=", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceLessThan(BigDecimal value) {
            addCriterion("stock_price <", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_price <=", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceIn(List<BigDecimal> values) {
            addCriterion("stock_price in", values, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceNotIn(List<BigDecimal> values) {
            addCriterion("stock_price not in", values, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_price between", value1, value2, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_price not between", value1, value2, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceIsNull() {
            addCriterion("financial_price is null");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceIsNotNull() {
            addCriterion("financial_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceEqualTo(BigDecimal value) {
            addCriterion("financial_price =", value, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceNotEqualTo(BigDecimal value) {
            addCriterion("financial_price <>", value, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceGreaterThan(BigDecimal value) {
            addCriterion("financial_price >", value, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("financial_price >=", value, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceLessThan(BigDecimal value) {
            addCriterion("financial_price <", value, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("financial_price <=", value, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceIn(List<BigDecimal> values) {
            addCriterion("financial_price in", values, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceNotIn(List<BigDecimal> values) {
            addCriterion("financial_price not in", values, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financial_price between", value1, value2, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andFinancialPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financial_price not between", value1, value2, "financialPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIsNull() {
            addCriterion("other_price is null");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIsNotNull() {
            addCriterion("other_price is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPriceEqualTo(BigDecimal value) {
            addCriterion("other_price =", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotEqualTo(BigDecimal value) {
            addCriterion("other_price <>", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceGreaterThan(BigDecimal value) {
            addCriterion("other_price >", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_price >=", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceLessThan(BigDecimal value) {
            addCriterion("other_price <", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_price <=", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIn(List<BigDecimal> values) {
            addCriterion("other_price in", values, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotIn(List<BigDecimal> values) {
            addCriterion("other_price not in", values, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_price between", value1, value2, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_price not between", value1, value2, "otherPrice");
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

        public Criteria andBankDetailEqualTo(BigDecimal value) {
            addCriterion("bank_detail =", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailNotEqualTo(BigDecimal value) {
            addCriterion("bank_detail <>", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailGreaterThan(BigDecimal value) {
            addCriterion("bank_detail >", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_detail >=", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailLessThan(BigDecimal value) {
            addCriterion("bank_detail <", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_detail <=", value, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailIn(List<BigDecimal> values) {
            addCriterion("bank_detail in", values, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailNotIn(List<BigDecimal> values) {
            addCriterion("bank_detail not in", values, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_detail between", value1, value2, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andBankDetailNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_detail not between", value1, value2, "bankDetail");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIsNull() {
            addCriterion("month_income is null");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIsNotNull() {
            addCriterion("month_income is not null");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeEqualTo(String value) {
            addCriterion("month_income =", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotEqualTo(String value) {
            addCriterion("month_income <>", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeGreaterThan(String value) {
            addCriterion("month_income >", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("month_income >=", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLessThan(String value) {
            addCriterion("month_income <", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLessThanOrEqualTo(String value) {
            addCriterion("month_income <=", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLike(String value) {
            addCriterion("month_income like", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotLike(String value) {
            addCriterion("month_income not like", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIn(List<String> values) {
            addCriterion("month_income in", values, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotIn(List<String> values) {
            addCriterion("month_income not in", values, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeBetween(String value1, String value2) {
            addCriterion("month_income between", value1, value2, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotBetween(String value1, String value2) {
            addCriterion("month_income not between", value1, value2, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeIsNull() {
            addCriterion("manage_income is null");
            return (Criteria) this;
        }

        public Criteria andManageIncomeIsNotNull() {
            addCriterion("manage_income is not null");
            return (Criteria) this;
        }

        public Criteria andManageIncomeEqualTo(BigDecimal value) {
            addCriterion("manage_income =", value, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeNotEqualTo(BigDecimal value) {
            addCriterion("manage_income <>", value, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeGreaterThan(BigDecimal value) {
            addCriterion("manage_income >", value, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_income >=", value, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeLessThan(BigDecimal value) {
            addCriterion("manage_income <", value, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_income <=", value, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeIn(List<BigDecimal> values) {
            addCriterion("manage_income in", values, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeNotIn(List<BigDecimal> values) {
            addCriterion("manage_income not in", values, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_income between", value1, value2, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andManageIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_income not between", value1, value2, "manageIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeIsNull() {
            addCriterion("rent_income is null");
            return (Criteria) this;
        }

        public Criteria andRentIncomeIsNotNull() {
            addCriterion("rent_income is not null");
            return (Criteria) this;
        }

        public Criteria andRentIncomeEqualTo(BigDecimal value) {
            addCriterion("rent_income =", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeNotEqualTo(BigDecimal value) {
            addCriterion("rent_income <>", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeGreaterThan(BigDecimal value) {
            addCriterion("rent_income >", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rent_income >=", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeLessThan(BigDecimal value) {
            addCriterion("rent_income <", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rent_income <=", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeIn(List<BigDecimal> values) {
            addCriterion("rent_income in", values, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeNotIn(List<BigDecimal> values) {
            addCriterion("rent_income not in", values, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent_income between", value1, value2, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent_income not between", value1, value2, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeIsNull() {
            addCriterion("other_income is null");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeIsNotNull() {
            addCriterion("other_income is not null");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeEqualTo(BigDecimal value) {
            addCriterion("other_income =", value, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeNotEqualTo(BigDecimal value) {
            addCriterion("other_income <>", value, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeGreaterThan(BigDecimal value) {
            addCriterion("other_income >", value, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_income >=", value, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeLessThan(BigDecimal value) {
            addCriterion("other_income <", value, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_income <=", value, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeIn(List<BigDecimal> values) {
            addCriterion("other_income in", values, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeNotIn(List<BigDecimal> values) {
            addCriterion("other_income not in", values, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_income between", value1, value2, "otherIncome");
            return (Criteria) this;
        }

        public Criteria andOtherIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_income not between", value1, value2, "otherIncome");
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

        public Criteria andTogetherNameIsNull() {
            addCriterion("together_name is null");
            return (Criteria) this;
        }

        public Criteria andTogetherNameIsNotNull() {
            addCriterion("together_name is not null");
            return (Criteria) this;
        }

        public Criteria andTogetherNameEqualTo(String value) {
            addCriterion("together_name =", value, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameNotEqualTo(String value) {
            addCriterion("together_name <>", value, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameGreaterThan(String value) {
            addCriterion("together_name >", value, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameGreaterThanOrEqualTo(String value) {
            addCriterion("together_name >=", value, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameLessThan(String value) {
            addCriterion("together_name <", value, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameLessThanOrEqualTo(String value) {
            addCriterion("together_name <=", value, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameLike(String value) {
            addCriterion("together_name like", value, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameNotLike(String value) {
            addCriterion("together_name not like", value, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameIn(List<String> values) {
            addCriterion("together_name in", values, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameNotIn(List<String> values) {
            addCriterion("together_name not in", values, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameBetween(String value1, String value2) {
            addCriterion("together_name between", value1, value2, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherNameNotBetween(String value1, String value2) {
            addCriterion("together_name not between", value1, value2, "togetherName");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileIsNull() {
            addCriterion("together_mobile is null");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileIsNotNull() {
            addCriterion("together_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileEqualTo(String value) {
            addCriterion("together_mobile =", value, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileNotEqualTo(String value) {
            addCriterion("together_mobile <>", value, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileGreaterThan(String value) {
            addCriterion("together_mobile >", value, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileGreaterThanOrEqualTo(String value) {
            addCriterion("together_mobile >=", value, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileLessThan(String value) {
            addCriterion("together_mobile <", value, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileLessThanOrEqualTo(String value) {
            addCriterion("together_mobile <=", value, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileLike(String value) {
            addCriterion("together_mobile like", value, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileNotLike(String value) {
            addCriterion("together_mobile not like", value, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileIn(List<String> values) {
            addCriterion("together_mobile in", values, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileNotIn(List<String> values) {
            addCriterion("together_mobile not in", values, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileBetween(String value1, String value2) {
            addCriterion("together_mobile between", value1, value2, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherMobileNotBetween(String value1, String value2) {
            addCriterion("together_mobile not between", value1, value2, "togetherMobile");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityIsNull() {
            addCriterion("together_identity is null");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityIsNotNull() {
            addCriterion("together_identity is not null");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityEqualTo(String value) {
            addCriterion("together_identity =", value, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityNotEqualTo(String value) {
            addCriterion("together_identity <>", value, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityGreaterThan(String value) {
            addCriterion("together_identity >", value, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("together_identity >=", value, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityLessThan(String value) {
            addCriterion("together_identity <", value, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityLessThanOrEqualTo(String value) {
            addCriterion("together_identity <=", value, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityLike(String value) {
            addCriterion("together_identity like", value, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityNotLike(String value) {
            addCriterion("together_identity not like", value, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityIn(List<String> values) {
            addCriterion("together_identity in", values, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityNotIn(List<String> values) {
            addCriterion("together_identity not in", values, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityBetween(String value1, String value2) {
            addCriterion("together_identity between", value1, value2, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andTogetherIdentityNotBetween(String value1, String value2) {
            addCriterion("together_identity not between", value1, value2, "togetherIdentity");
            return (Criteria) this;
        }

        public Criteria andPicFileIsNull() {
            addCriterion("pic_file is null");
            return (Criteria) this;
        }

        public Criteria andPicFileIsNotNull() {
            addCriterion("pic_file is not null");
            return (Criteria) this;
        }

        public Criteria andPicFileEqualTo(String value) {
            addCriterion("pic_file =", value, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileNotEqualTo(String value) {
            addCriterion("pic_file <>", value, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileGreaterThan(String value) {
            addCriterion("pic_file >", value, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileGreaterThanOrEqualTo(String value) {
            addCriterion("pic_file >=", value, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileLessThan(String value) {
            addCriterion("pic_file <", value, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileLessThanOrEqualTo(String value) {
            addCriterion("pic_file <=", value, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileLike(String value) {
            addCriterion("pic_file like", value, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileNotLike(String value) {
            addCriterion("pic_file not like", value, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileIn(List<String> values) {
            addCriterion("pic_file in", values, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileNotIn(List<String> values) {
            addCriterion("pic_file not in", values, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileBetween(String value1, String value2) {
            addCriterion("pic_file between", value1, value2, "picFile");
            return (Criteria) this;
        }

        public Criteria andPicFileNotBetween(String value1, String value2) {
            addCriterion("pic_file not between", value1, value2, "picFile");
            return (Criteria) this;
        }
    }

    /**
     * nj_user_business_survey
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_user_business_survey 2018-08-01
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