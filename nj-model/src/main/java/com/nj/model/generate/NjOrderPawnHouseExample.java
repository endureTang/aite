package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjOrderPawnHouseExample {
    /**
     * nj_order_pawn_house
     */
    protected String orderByClause;

    /**
     * nj_order_pawn_house
     */
    protected boolean distinct;

    /**
     * nj_order_pawn_house
     */
    protected List<Criteria> oredCriteria;

    public NjOrderPawnHouseExample() {
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
     * nj_order_pawn_house 2018-08-01
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

        public Criteria andHouseNameIsNull() {
            addCriterion("house_name is null");
            return (Criteria) this;
        }

        public Criteria andHouseNameIsNotNull() {
            addCriterion("house_name is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNameEqualTo(String value) {
            addCriterion("house_name =", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotEqualTo(String value) {
            addCriterion("house_name <>", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameGreaterThan(String value) {
            addCriterion("house_name >", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("house_name >=", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLessThan(String value) {
            addCriterion("house_name <", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLessThanOrEqualTo(String value) {
            addCriterion("house_name <=", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLike(String value) {
            addCriterion("house_name like", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotLike(String value) {
            addCriterion("house_name not like", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameIn(List<String> values) {
            addCriterion("house_name in", values, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotIn(List<String> values) {
            addCriterion("house_name not in", values, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameBetween(String value1, String value2) {
            addCriterion("house_name between", value1, value2, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotBetween(String value1, String value2) {
            addCriterion("house_name not between", value1, value2, "houseName");
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

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
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

        public Criteria andCoveredAreaIsNull() {
            addCriterion("covered_area is null");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaIsNotNull() {
            addCriterion("covered_area is not null");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaEqualTo(BigDecimal value) {
            addCriterion("covered_area =", value, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaNotEqualTo(BigDecimal value) {
            addCriterion("covered_area <>", value, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaGreaterThan(BigDecimal value) {
            addCriterion("covered_area >", value, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("covered_area >=", value, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaLessThan(BigDecimal value) {
            addCriterion("covered_area <", value, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("covered_area <=", value, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaIn(List<BigDecimal> values) {
            addCriterion("covered_area in", values, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaNotIn(List<BigDecimal> values) {
            addCriterion("covered_area not in", values, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("covered_area between", value1, value2, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andCoveredAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("covered_area not between", value1, value2, "coveredArea");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNull() {
            addCriterion("record_date is null");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNotNull() {
            addCriterion("record_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDateEqualTo(Date value) {
            addCriterion("record_date =", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotEqualTo(Date value) {
            addCriterion("record_date <>", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThan(Date value) {
            addCriterion("record_date >", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThanOrEqualTo(Date value) {
            addCriterion("record_date >=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThan(Date value) {
            addCriterion("record_date <", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThanOrEqualTo(Date value) {
            addCriterion("record_date <=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateIn(List<Date> values) {
            addCriterion("record_date in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotIn(List<Date> values) {
            addCriterion("record_date not in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateBetween(Date value1, Date value2) {
            addCriterion("record_date between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotBetween(Date value1, Date value2) {
            addCriterion("record_date not between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andHouseAgeIsNull() {
            addCriterion("house_age is null");
            return (Criteria) this;
        }

        public Criteria andHouseAgeIsNotNull() {
            addCriterion("house_age is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAgeEqualTo(Integer value) {
            addCriterion("house_age =", value, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeNotEqualTo(Integer value) {
            addCriterion("house_age <>", value, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeGreaterThan(Integer value) {
            addCriterion("house_age >", value, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_age >=", value, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeLessThan(Integer value) {
            addCriterion("house_age <", value, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeLessThanOrEqualTo(Integer value) {
            addCriterion("house_age <=", value, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeIn(List<Integer> values) {
            addCriterion("house_age in", values, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeNotIn(List<Integer> values) {
            addCriterion("house_age not in", values, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeBetween(Integer value1, Integer value2) {
            addCriterion("house_age between", value1, value2, "houseAge");
            return (Criteria) this;
        }

        public Criteria andHouseAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("house_age not between", value1, value2, "houseAge");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusIsNull() {
            addCriterion("fitment_status is null");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusIsNotNull() {
            addCriterion("fitment_status is not null");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusEqualTo(String value) {
            addCriterion("fitment_status =", value, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusNotEqualTo(String value) {
            addCriterion("fitment_status <>", value, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusGreaterThan(String value) {
            addCriterion("fitment_status >", value, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("fitment_status >=", value, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusLessThan(String value) {
            addCriterion("fitment_status <", value, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusLessThanOrEqualTo(String value) {
            addCriterion("fitment_status <=", value, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusLike(String value) {
            addCriterion("fitment_status like", value, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusNotLike(String value) {
            addCriterion("fitment_status not like", value, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusIn(List<String> values) {
            addCriterion("fitment_status in", values, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusNotIn(List<String> values) {
            addCriterion("fitment_status not in", values, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusBetween(String value1, String value2) {
            addCriterion("fitment_status between", value1, value2, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andFitmentStatusNotBetween(String value1, String value2) {
            addCriterion("fitment_status not between", value1, value2, "fitmentStatus");
            return (Criteria) this;
        }

        public Criteria andIsOnlyIsNull() {
            addCriterion("is_only is null");
            return (Criteria) this;
        }

        public Criteria andIsOnlyIsNotNull() {
            addCriterion("is_only is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnlyEqualTo(Boolean value) {
            addCriterion("is_only =", value, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyNotEqualTo(Boolean value) {
            addCriterion("is_only <>", value, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyGreaterThan(Boolean value) {
            addCriterion("is_only >", value, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_only >=", value, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyLessThan(Boolean value) {
            addCriterion("is_only <", value, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_only <=", value, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyIn(List<Boolean> values) {
            addCriterion("is_only in", values, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyNotIn(List<Boolean> values) {
            addCriterion("is_only not in", values, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_only between", value1, value2, "isOnly");
            return (Criteria) this;
        }

        public Criteria andIsOnlyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_only not between", value1, value2, "isOnly");
            return (Criteria) this;
        }

        public Criteria andWebOneNameIsNull() {
            addCriterion("web_one_name is null");
            return (Criteria) this;
        }

        public Criteria andWebOneNameIsNotNull() {
            addCriterion("web_one_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebOneNameEqualTo(String value) {
            addCriterion("web_one_name =", value, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameNotEqualTo(String value) {
            addCriterion("web_one_name <>", value, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameGreaterThan(String value) {
            addCriterion("web_one_name >", value, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameGreaterThanOrEqualTo(String value) {
            addCriterion("web_one_name >=", value, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameLessThan(String value) {
            addCriterion("web_one_name <", value, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameLessThanOrEqualTo(String value) {
            addCriterion("web_one_name <=", value, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameLike(String value) {
            addCriterion("web_one_name like", value, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameNotLike(String value) {
            addCriterion("web_one_name not like", value, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameIn(List<String> values) {
            addCriterion("web_one_name in", values, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameNotIn(List<String> values) {
            addCriterion("web_one_name not in", values, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameBetween(String value1, String value2) {
            addCriterion("web_one_name between", value1, value2, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOneNameNotBetween(String value1, String value2) {
            addCriterion("web_one_name not between", value1, value2, "webOneName");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceIsNull() {
            addCriterion("web_one_price is null");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceIsNotNull() {
            addCriterion("web_one_price is not null");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceEqualTo(BigDecimal value) {
            addCriterion("web_one_price =", value, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceNotEqualTo(BigDecimal value) {
            addCriterion("web_one_price <>", value, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceGreaterThan(BigDecimal value) {
            addCriterion("web_one_price >", value, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("web_one_price >=", value, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceLessThan(BigDecimal value) {
            addCriterion("web_one_price <", value, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("web_one_price <=", value, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceIn(List<BigDecimal> values) {
            addCriterion("web_one_price in", values, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceNotIn(List<BigDecimal> values) {
            addCriterion("web_one_price not in", values, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("web_one_price between", value1, value2, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebOnePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("web_one_price not between", value1, value2, "webOnePrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameIsNull() {
            addCriterion("web_two_name is null");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameIsNotNull() {
            addCriterion("web_two_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameEqualTo(String value) {
            addCriterion("web_two_name =", value, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameNotEqualTo(String value) {
            addCriterion("web_two_name <>", value, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameGreaterThan(String value) {
            addCriterion("web_two_name >", value, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameGreaterThanOrEqualTo(String value) {
            addCriterion("web_two_name >=", value, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameLessThan(String value) {
            addCriterion("web_two_name <", value, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameLessThanOrEqualTo(String value) {
            addCriterion("web_two_name <=", value, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameLike(String value) {
            addCriterion("web_two_name like", value, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameNotLike(String value) {
            addCriterion("web_two_name not like", value, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameIn(List<String> values) {
            addCriterion("web_two_name in", values, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameNotIn(List<String> values) {
            addCriterion("web_two_name not in", values, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameBetween(String value1, String value2) {
            addCriterion("web_two_name between", value1, value2, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoNameNotBetween(String value1, String value2) {
            addCriterion("web_two_name not between", value1, value2, "webTwoName");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceIsNull() {
            addCriterion("web_two_price is null");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceIsNotNull() {
            addCriterion("web_two_price is not null");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceEqualTo(BigDecimal value) {
            addCriterion("web_two_price =", value, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceNotEqualTo(BigDecimal value) {
            addCriterion("web_two_price <>", value, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceGreaterThan(BigDecimal value) {
            addCriterion("web_two_price >", value, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("web_two_price >=", value, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceLessThan(BigDecimal value) {
            addCriterion("web_two_price <", value, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("web_two_price <=", value, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceIn(List<BigDecimal> values) {
            addCriterion("web_two_price in", values, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceNotIn(List<BigDecimal> values) {
            addCriterion("web_two_price not in", values, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("web_two_price between", value1, value2, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebTwoPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("web_two_price not between", value1, value2, "webTwoPrice");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameIsNull() {
            addCriterion("web_three_name is null");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameIsNotNull() {
            addCriterion("web_three_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameEqualTo(String value) {
            addCriterion("web_three_name =", value, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameNotEqualTo(String value) {
            addCriterion("web_three_name <>", value, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameGreaterThan(String value) {
            addCriterion("web_three_name >", value, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameGreaterThanOrEqualTo(String value) {
            addCriterion("web_three_name >=", value, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameLessThan(String value) {
            addCriterion("web_three_name <", value, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameLessThanOrEqualTo(String value) {
            addCriterion("web_three_name <=", value, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameLike(String value) {
            addCriterion("web_three_name like", value, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameNotLike(String value) {
            addCriterion("web_three_name not like", value, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameIn(List<String> values) {
            addCriterion("web_three_name in", values, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameNotIn(List<String> values) {
            addCriterion("web_three_name not in", values, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameBetween(String value1, String value2) {
            addCriterion("web_three_name between", value1, value2, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreeNameNotBetween(String value1, String value2) {
            addCriterion("web_three_name not between", value1, value2, "webThreeName");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceIsNull() {
            addCriterion("web_three_price is null");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceIsNotNull() {
            addCriterion("web_three_price is not null");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceEqualTo(BigDecimal value) {
            addCriterion("web_three_price =", value, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceNotEqualTo(BigDecimal value) {
            addCriterion("web_three_price <>", value, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceGreaterThan(BigDecimal value) {
            addCriterion("web_three_price >", value, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("web_three_price >=", value, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceLessThan(BigDecimal value) {
            addCriterion("web_three_price <", value, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("web_three_price <=", value, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceIn(List<BigDecimal> values) {
            addCriterion("web_three_price in", values, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceNotIn(List<BigDecimal> values) {
            addCriterion("web_three_price not in", values, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("web_three_price between", value1, value2, "webThreePrice");
            return (Criteria) this;
        }

        public Criteria andWebThreePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("web_three_price not between", value1, value2, "webThreePrice");
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

        public Criteria andCompanyPriceIsNull() {
            addCriterion("company_price is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceIsNotNull() {
            addCriterion("company_price is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceEqualTo(BigDecimal value) {
            addCriterion("company_price =", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceNotEqualTo(BigDecimal value) {
            addCriterion("company_price <>", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceGreaterThan(BigDecimal value) {
            addCriterion("company_price >", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("company_price >=", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceLessThan(BigDecimal value) {
            addCriterion("company_price <", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("company_price <=", value, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceIn(List<BigDecimal> values) {
            addCriterion("company_price in", values, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceNotIn(List<BigDecimal> values) {
            addCriterion("company_price not in", values, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_price between", value1, value2, "companyPrice");
            return (Criteria) this;
        }

        public Criteria andCompanyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_price not between", value1, value2, "companyPrice");
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

        public Criteria andMortgageNoIsNull() {
            addCriterion("mortgage_no is null");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIsNotNull() {
            addCriterion("mortgage_no is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageNoEqualTo(Byte value) {
            addCriterion("mortgage_no =", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotEqualTo(Byte value) {
            addCriterion("mortgage_no <>", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoGreaterThan(Byte value) {
            addCriterion("mortgage_no >", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoGreaterThanOrEqualTo(Byte value) {
            addCriterion("mortgage_no >=", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLessThan(Byte value) {
            addCriterion("mortgage_no <", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoLessThanOrEqualTo(Byte value) {
            addCriterion("mortgage_no <=", value, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoIn(List<Byte> values) {
            addCriterion("mortgage_no in", values, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotIn(List<Byte> values) {
            addCriterion("mortgage_no not in", values, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoBetween(Byte value1, Byte value2) {
            addCriterion("mortgage_no between", value1, value2, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andMortgageNoNotBetween(Byte value1, Byte value2) {
            addCriterion("mortgage_no not between", value1, value2, "mortgageNo");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceIsNull() {
            addCriterion("loan_balance is null");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceIsNotNull() {
            addCriterion("loan_balance is not null");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceEqualTo(BigDecimal value) {
            addCriterion("loan_balance =", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceNotEqualTo(BigDecimal value) {
            addCriterion("loan_balance <>", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceGreaterThan(BigDecimal value) {
            addCriterion("loan_balance >", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_balance >=", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceLessThan(BigDecimal value) {
            addCriterion("loan_balance <", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_balance <=", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceIn(List<BigDecimal> values) {
            addCriterion("loan_balance in", values, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceNotIn(List<BigDecimal> values) {
            addCriterion("loan_balance not in", values, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_balance between", value1, value2, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_balance not between", value1, value2, "loanBalance");
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

        public Criteria andMarketMoneyIsNull() {
            addCriterion("market_money is null");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyIsNotNull() {
            addCriterion("market_money is not null");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyEqualTo(BigDecimal value) {
            addCriterion("market_money =", value, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyNotEqualTo(BigDecimal value) {
            addCriterion("market_money <>", value, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyGreaterThan(BigDecimal value) {
            addCriterion("market_money >", value, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("market_money >=", value, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyLessThan(BigDecimal value) {
            addCriterion("market_money <", value, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("market_money <=", value, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyIn(List<BigDecimal> values) {
            addCriterion("market_money in", values, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyNotIn(List<BigDecimal> values) {
            addCriterion("market_money not in", values, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_money between", value1, value2, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andMarketMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_money not between", value1, value2, "marketMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIsNull() {
            addCriterion("loan_money is null");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIsNotNull() {
            addCriterion("loan_money is not null");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyEqualTo(BigDecimal value) {
            addCriterion("loan_money =", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotEqualTo(BigDecimal value) {
            addCriterion("loan_money <>", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyGreaterThan(BigDecimal value) {
            addCriterion("loan_money >", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_money >=", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLessThan(BigDecimal value) {
            addCriterion("loan_money <", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_money <=", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIn(List<BigDecimal> values) {
            addCriterion("loan_money in", values, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotIn(List<BigDecimal> values) {
            addCriterion("loan_money not in", values, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_money between", value1, value2, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_money not between", value1, value2, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanTermIsNull() {
            addCriterion("loan_term is null");
            return (Criteria) this;
        }

        public Criteria andLoanTermIsNotNull() {
            addCriterion("loan_term is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTermEqualTo(Byte value) {
            addCriterion("loan_term =", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotEqualTo(Byte value) {
            addCriterion("loan_term <>", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermGreaterThan(Byte value) {
            addCriterion("loan_term >", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermGreaterThanOrEqualTo(Byte value) {
            addCriterion("loan_term >=", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermLessThan(Byte value) {
            addCriterion("loan_term <", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermLessThanOrEqualTo(Byte value) {
            addCriterion("loan_term <=", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermIn(List<Byte> values) {
            addCriterion("loan_term in", values, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotIn(List<Byte> values) {
            addCriterion("loan_term not in", values, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermBetween(Byte value1, Byte value2) {
            addCriterion("loan_term between", value1, value2, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotBetween(Byte value1, Byte value2) {
            addCriterion("loan_term not between", value1, value2, "loanTerm");
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

        public Criteria andPawnStatusIsNull() {
            addCriterion("pawn_status is null");
            return (Criteria) this;
        }

        public Criteria andPawnStatusIsNotNull() {
            addCriterion("pawn_status is not null");
            return (Criteria) this;
        }

        public Criteria andPawnStatusEqualTo(String value) {
            addCriterion("pawn_status =", value, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusNotEqualTo(String value) {
            addCriterion("pawn_status <>", value, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusGreaterThan(String value) {
            addCriterion("pawn_status >", value, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_status >=", value, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusLessThan(String value) {
            addCriterion("pawn_status <", value, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusLessThanOrEqualTo(String value) {
            addCriterion("pawn_status <=", value, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusLike(String value) {
            addCriterion("pawn_status like", value, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusNotLike(String value) {
            addCriterion("pawn_status not like", value, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusIn(List<String> values) {
            addCriterion("pawn_status in", values, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusNotIn(List<String> values) {
            addCriterion("pawn_status not in", values, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusBetween(String value1, String value2) {
            addCriterion("pawn_status between", value1, value2, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnStatusNotBetween(String value1, String value2) {
            addCriterion("pawn_status not between", value1, value2, "pawnStatus");
            return (Criteria) this;
        }

        public Criteria andPawnBankIsNull() {
            addCriterion("pawn_bank is null");
            return (Criteria) this;
        }

        public Criteria andPawnBankIsNotNull() {
            addCriterion("pawn_bank is not null");
            return (Criteria) this;
        }

        public Criteria andPawnBankEqualTo(String value) {
            addCriterion("pawn_bank =", value, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankNotEqualTo(String value) {
            addCriterion("pawn_bank <>", value, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankGreaterThan(String value) {
            addCriterion("pawn_bank >", value, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankGreaterThanOrEqualTo(String value) {
            addCriterion("pawn_bank >=", value, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankLessThan(String value) {
            addCriterion("pawn_bank <", value, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankLessThanOrEqualTo(String value) {
            addCriterion("pawn_bank <=", value, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankLike(String value) {
            addCriterion("pawn_bank like", value, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankNotLike(String value) {
            addCriterion("pawn_bank not like", value, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankIn(List<String> values) {
            addCriterion("pawn_bank in", values, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankNotIn(List<String> values) {
            addCriterion("pawn_bank not in", values, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankBetween(String value1, String value2) {
            addCriterion("pawn_bank between", value1, value2, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPawnBankNotBetween(String value1, String value2) {
            addCriterion("pawn_bank not between", value1, value2, "pawnBank");
            return (Criteria) this;
        }

        public Criteria andPicFileOneIsNull() {
            addCriterion("pic_file_one is null");
            return (Criteria) this;
        }

        public Criteria andPicFileOneIsNotNull() {
            addCriterion("pic_file_one is not null");
            return (Criteria) this;
        }

        public Criteria andPicFileOneEqualTo(String value) {
            addCriterion("pic_file_one =", value, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneNotEqualTo(String value) {
            addCriterion("pic_file_one <>", value, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneGreaterThan(String value) {
            addCriterion("pic_file_one >", value, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneGreaterThanOrEqualTo(String value) {
            addCriterion("pic_file_one >=", value, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneLessThan(String value) {
            addCriterion("pic_file_one <", value, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneLessThanOrEqualTo(String value) {
            addCriterion("pic_file_one <=", value, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneLike(String value) {
            addCriterion("pic_file_one like", value, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneNotLike(String value) {
            addCriterion("pic_file_one not like", value, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneIn(List<String> values) {
            addCriterion("pic_file_one in", values, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneNotIn(List<String> values) {
            addCriterion("pic_file_one not in", values, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneBetween(String value1, String value2) {
            addCriterion("pic_file_one between", value1, value2, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileOneNotBetween(String value1, String value2) {
            addCriterion("pic_file_one not between", value1, value2, "picFileOne");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoIsNull() {
            addCriterion("pic_file_two is null");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoIsNotNull() {
            addCriterion("pic_file_two is not null");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoEqualTo(String value) {
            addCriterion("pic_file_two =", value, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoNotEqualTo(String value) {
            addCriterion("pic_file_two <>", value, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoGreaterThan(String value) {
            addCriterion("pic_file_two >", value, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoGreaterThanOrEqualTo(String value) {
            addCriterion("pic_file_two >=", value, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoLessThan(String value) {
            addCriterion("pic_file_two <", value, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoLessThanOrEqualTo(String value) {
            addCriterion("pic_file_two <=", value, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoLike(String value) {
            addCriterion("pic_file_two like", value, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoNotLike(String value) {
            addCriterion("pic_file_two not like", value, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoIn(List<String> values) {
            addCriterion("pic_file_two in", values, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoNotIn(List<String> values) {
            addCriterion("pic_file_two not in", values, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoBetween(String value1, String value2) {
            addCriterion("pic_file_two between", value1, value2, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileTwoNotBetween(String value1, String value2) {
            addCriterion("pic_file_two not between", value1, value2, "picFileTwo");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeIsNull() {
            addCriterion("pic_file_three is null");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeIsNotNull() {
            addCriterion("pic_file_three is not null");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeEqualTo(String value) {
            addCriterion("pic_file_three =", value, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeNotEqualTo(String value) {
            addCriterion("pic_file_three <>", value, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeGreaterThan(String value) {
            addCriterion("pic_file_three >", value, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeGreaterThanOrEqualTo(String value) {
            addCriterion("pic_file_three >=", value, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeLessThan(String value) {
            addCriterion("pic_file_three <", value, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeLessThanOrEqualTo(String value) {
            addCriterion("pic_file_three <=", value, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeLike(String value) {
            addCriterion("pic_file_three like", value, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeNotLike(String value) {
            addCriterion("pic_file_three not like", value, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeIn(List<String> values) {
            addCriterion("pic_file_three in", values, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeNotIn(List<String> values) {
            addCriterion("pic_file_three not in", values, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeBetween(String value1, String value2) {
            addCriterion("pic_file_three between", value1, value2, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileThreeNotBetween(String value1, String value2) {
            addCriterion("pic_file_three not between", value1, value2, "picFileThree");
            return (Criteria) this;
        }

        public Criteria andPicFileFourIsNull() {
            addCriterion("pic_file_four is null");
            return (Criteria) this;
        }

        public Criteria andPicFileFourIsNotNull() {
            addCriterion("pic_file_four is not null");
            return (Criteria) this;
        }

        public Criteria andPicFileFourEqualTo(String value) {
            addCriterion("pic_file_four =", value, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourNotEqualTo(String value) {
            addCriterion("pic_file_four <>", value, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourGreaterThan(String value) {
            addCriterion("pic_file_four >", value, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourGreaterThanOrEqualTo(String value) {
            addCriterion("pic_file_four >=", value, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourLessThan(String value) {
            addCriterion("pic_file_four <", value, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourLessThanOrEqualTo(String value) {
            addCriterion("pic_file_four <=", value, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourLike(String value) {
            addCriterion("pic_file_four like", value, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourNotLike(String value) {
            addCriterion("pic_file_four not like", value, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourIn(List<String> values) {
            addCriterion("pic_file_four in", values, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourNotIn(List<String> values) {
            addCriterion("pic_file_four not in", values, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourBetween(String value1, String value2) {
            addCriterion("pic_file_four between", value1, value2, "picFileFour");
            return (Criteria) this;
        }

        public Criteria andPicFileFourNotBetween(String value1, String value2) {
            addCriterion("pic_file_four not between", value1, value2, "picFileFour");
            return (Criteria) this;
        }
    }

    /**
     * nj_order_pawn_house
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_order_pawn_house 2018-08-01
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