package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjProcessTemplateFlowsExample {
    /**
     * nj_process_template_flows
     */
    protected String orderByClause;

    /**
     * nj_process_template_flows
     */
    protected boolean distinct;

    /**
     * nj_process_template_flows
     */
    protected List<Criteria> oredCriteria;

    public NjProcessTemplateFlowsExample() {
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
     * nj_process_template_flows 2018-02-11
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("template_id like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("template_id not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(Integer value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(Integer value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(Integer value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(Integer value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(Integer value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<Integer> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<Integer> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(Integer value1, Integer value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNull() {
            addCriterion("process_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("process_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("process_name =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("process_name <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("process_name >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_name >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("process_name <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("process_name <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("process_name like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("process_name not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("process_name in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("process_name not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("process_name between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("process_name not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andExecFunctionIsNull() {
            addCriterion("exec_function is null");
            return (Criteria) this;
        }

        public Criteria andExecFunctionIsNotNull() {
            addCriterion("exec_function is not null");
            return (Criteria) this;
        }

        public Criteria andExecFunctionEqualTo(String value) {
            addCriterion("exec_function =", value, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionNotEqualTo(String value) {
            addCriterion("exec_function <>", value, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionGreaterThan(String value) {
            addCriterion("exec_function >", value, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("exec_function >=", value, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionLessThan(String value) {
            addCriterion("exec_function <", value, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionLessThanOrEqualTo(String value) {
            addCriterion("exec_function <=", value, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionLike(String value) {
            addCriterion("exec_function like", value, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionNotLike(String value) {
            addCriterion("exec_function not like", value, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionIn(List<String> values) {
            addCriterion("exec_function in", values, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionNotIn(List<String> values) {
            addCriterion("exec_function not in", values, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionBetween(String value1, String value2) {
            addCriterion("exec_function between", value1, value2, "execFunction");
            return (Criteria) this;
        }

        public Criteria andExecFunctionNotBetween(String value1, String value2) {
            addCriterion("exec_function not between", value1, value2, "execFunction");
            return (Criteria) this;
        }

        public Criteria andPreconditionIsNull() {
            addCriterion("precondition is null");
            return (Criteria) this;
        }

        public Criteria andPreconditionIsNotNull() {
            addCriterion("precondition is not null");
            return (Criteria) this;
        }

        public Criteria andPreconditionEqualTo(Short value) {
            addCriterion("precondition =", value, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionNotEqualTo(Short value) {
            addCriterion("precondition <>", value, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionGreaterThan(Short value) {
            addCriterion("precondition >", value, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionGreaterThanOrEqualTo(Short value) {
            addCriterion("precondition >=", value, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionLessThan(Short value) {
            addCriterion("precondition <", value, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionLessThanOrEqualTo(Short value) {
            addCriterion("precondition <=", value, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionIn(List<Short> values) {
            addCriterion("precondition in", values, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionNotIn(List<Short> values) {
            addCriterion("precondition not in", values, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionBetween(Short value1, Short value2) {
            addCriterion("precondition between", value1, value2, "precondition");
            return (Criteria) this;
        }

        public Criteria andPreconditionNotBetween(Short value1, Short value2) {
            addCriterion("precondition not between", value1, value2, "precondition");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusIsNull() {
            addCriterion("exec_agree_status is null");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusIsNotNull() {
            addCriterion("exec_agree_status is not null");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusEqualTo(Integer value) {
            addCriterion("exec_agree_status =", value, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusNotEqualTo(Integer value) {
            addCriterion("exec_agree_status <>", value, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusGreaterThan(Integer value) {
            addCriterion("exec_agree_status >", value, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("exec_agree_status >=", value, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusLessThan(Integer value) {
            addCriterion("exec_agree_status <", value, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("exec_agree_status <=", value, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusIn(List<Integer> values) {
            addCriterion("exec_agree_status in", values, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusNotIn(List<Integer> values) {
            addCriterion("exec_agree_status not in", values, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusBetween(Integer value1, Integer value2) {
            addCriterion("exec_agree_status between", value1, value2, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecAgreeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("exec_agree_status not between", value1, value2, "execAgreeStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusIsNull() {
            addCriterion("exec_reject_status is null");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusIsNotNull() {
            addCriterion("exec_reject_status is not null");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusEqualTo(Integer value) {
            addCriterion("exec_reject_status =", value, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusNotEqualTo(Integer value) {
            addCriterion("exec_reject_status <>", value, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusGreaterThan(Integer value) {
            addCriterion("exec_reject_status >", value, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("exec_reject_status >=", value, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusLessThan(Integer value) {
            addCriterion("exec_reject_status <", value, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusLessThanOrEqualTo(Integer value) {
            addCriterion("exec_reject_status <=", value, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusIn(List<Integer> values) {
            addCriterion("exec_reject_status in", values, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusNotIn(List<Integer> values) {
            addCriterion("exec_reject_status not in", values, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusBetween(Integer value1, Integer value2) {
            addCriterion("exec_reject_status between", value1, value2, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRejectStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("exec_reject_status not between", value1, value2, "execRejectStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusIsNull() {
            addCriterion("exec_refuse_status is null");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusIsNotNull() {
            addCriterion("exec_refuse_status is not null");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusEqualTo(Integer value) {
            addCriterion("exec_refuse_status =", value, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusNotEqualTo(Integer value) {
            addCriterion("exec_refuse_status <>", value, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusGreaterThan(Integer value) {
            addCriterion("exec_refuse_status >", value, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("exec_refuse_status >=", value, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusLessThan(Integer value) {
            addCriterion("exec_refuse_status <", value, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("exec_refuse_status <=", value, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusIn(List<Integer> values) {
            addCriterion("exec_refuse_status in", values, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusNotIn(List<Integer> values) {
            addCriterion("exec_refuse_status not in", values, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusBetween(Integer value1, Integer value2) {
            addCriterion("exec_refuse_status between", value1, value2, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecRefuseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("exec_refuse_status not between", value1, value2, "execRefuseStatus");
            return (Criteria) this;
        }

        public Criteria andExecOrdersIsNull() {
            addCriterion("exec_orders is null");
            return (Criteria) this;
        }

        public Criteria andExecOrdersIsNotNull() {
            addCriterion("exec_orders is not null");
            return (Criteria) this;
        }

        public Criteria andExecOrdersEqualTo(Integer value) {
            addCriterion("exec_orders =", value, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersNotEqualTo(Integer value) {
            addCriterion("exec_orders <>", value, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersGreaterThan(Integer value) {
            addCriterion("exec_orders >", value, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersGreaterThanOrEqualTo(Integer value) {
            addCriterion("exec_orders >=", value, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersLessThan(Integer value) {
            addCriterion("exec_orders <", value, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersLessThanOrEqualTo(Integer value) {
            addCriterion("exec_orders <=", value, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersIn(List<Integer> values) {
            addCriterion("exec_orders in", values, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersNotIn(List<Integer> values) {
            addCriterion("exec_orders not in", values, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersBetween(Integer value1, Integer value2) {
            addCriterion("exec_orders between", value1, value2, "execOrders");
            return (Criteria) this;
        }

        public Criteria andExecOrdersNotBetween(Integer value1, Integer value2) {
            addCriterion("exec_orders not between", value1, value2, "execOrders");
            return (Criteria) this;
        }
    }

    /**
     * nj_process_template_flows
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_process_template_flows 2018-02-11
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