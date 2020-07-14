package com.nj.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjOrderArchiveRecordExample {
    /**
     * nj_order_archive_record
     */
    protected String orderByClause;

    /**
     * nj_order_archive_record
     */
    protected boolean distinct;

    /**
     * nj_order_archive_record
     */
    protected List<Criteria> oredCriteria;

    public NjOrderArchiveRecordExample() {
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
     * nj_order_archive_record 2018-09-07
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

        public Criteria andCertificateIsNull() {
            addCriterion("certificate is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNotNull() {
            addCriterion("certificate is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEqualTo(Integer value) {
            addCriterion("certificate =", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotEqualTo(Integer value) {
            addCriterion("certificate <>", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThan(Integer value) {
            addCriterion("certificate >", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThanOrEqualTo(Integer value) {
            addCriterion("certificate >=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThan(Integer value) {
            addCriterion("certificate <", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThanOrEqualTo(Integer value) {
            addCriterion("certificate <=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateIn(List<Integer> values) {
            addCriterion("certificate in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotIn(List<Integer> values) {
            addCriterion("certificate not in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateBetween(Integer value1, Integer value2) {
            addCriterion("certificate between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotBetween(Integer value1, Integer value2) {
            addCriterion("certificate not between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyIsNull() {
            addCriterion("car_warranty is null");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyIsNotNull() {
            addCriterion("car_warranty is not null");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyEqualTo(Integer value) {
            addCriterion("car_warranty =", value, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyNotEqualTo(Integer value) {
            addCriterion("car_warranty <>", value, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyGreaterThan(Integer value) {
            addCriterion("car_warranty >", value, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_warranty >=", value, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyLessThan(Integer value) {
            addCriterion("car_warranty <", value, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyLessThanOrEqualTo(Integer value) {
            addCriterion("car_warranty <=", value, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyIn(List<Integer> values) {
            addCriterion("car_warranty in", values, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyNotIn(List<Integer> values) {
            addCriterion("car_warranty not in", values, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyBetween(Integer value1, Integer value2) {
            addCriterion("car_warranty between", value1, value2, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarWarrantyNotBetween(Integer value1, Integer value2) {
            addCriterion("car_warranty not between", value1, value2, "carWarranty");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceIsNull() {
            addCriterion("car_invoice is null");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceIsNotNull() {
            addCriterion("car_invoice is not null");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceEqualTo(Integer value) {
            addCriterion("car_invoice =", value, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceNotEqualTo(Integer value) {
            addCriterion("car_invoice <>", value, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceGreaterThan(Integer value) {
            addCriterion("car_invoice >", value, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_invoice >=", value, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceLessThan(Integer value) {
            addCriterion("car_invoice <", value, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceLessThanOrEqualTo(Integer value) {
            addCriterion("car_invoice <=", value, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceIn(List<Integer> values) {
            addCriterion("car_invoice in", values, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceNotIn(List<Integer> values) {
            addCriterion("car_invoice not in", values, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceBetween(Integer value1, Integer value2) {
            addCriterion("car_invoice between", value1, value2, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andCarInvoiceNotBetween(Integer value1, Integer value2) {
            addCriterion("car_invoice not between", value1, value2, "carInvoice");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoIsNull() {
            addCriterion("gps_photo is null");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoIsNotNull() {
            addCriterion("gps_photo is not null");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoEqualTo(Integer value) {
            addCriterion("gps_photo =", value, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoNotEqualTo(Integer value) {
            addCriterion("gps_photo <>", value, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoGreaterThan(Integer value) {
            addCriterion("gps_photo >", value, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoGreaterThanOrEqualTo(Integer value) {
            addCriterion("gps_photo >=", value, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoLessThan(Integer value) {
            addCriterion("gps_photo <", value, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoLessThanOrEqualTo(Integer value) {
            addCriterion("gps_photo <=", value, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoIn(List<Integer> values) {
            addCriterion("gps_photo in", values, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoNotIn(List<Integer> values) {
            addCriterion("gps_photo not in", values, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoBetween(Integer value1, Integer value2) {
            addCriterion("gps_photo between", value1, value2, "gpsPhoto");
            return (Criteria) this;
        }

        public Criteria andGpsPhotoNotBetween(Integer value1, Integer value2) {
            addCriterion("gps_photo not between", value1, value2, "gpsPhoto");
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
    }

    /**
     * nj_order_archive_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_order_archive_record 2018-09-07
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