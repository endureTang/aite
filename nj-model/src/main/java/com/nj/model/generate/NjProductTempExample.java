package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjProductTempExample {
    /**
	 * nj_product_temp
	 */
	protected String orderByClause;

	/**
	 * nj_product_temp
	 */
	protected boolean distinct;

	/**
	 * nj_product_temp
	 */
	protected List<Criteria> oredCriteria;

	public NjProductTempExample() {
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
	 * nj_product_temp 2018-06-26
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

		public Criteria andTemplateIdIsNull() {
			addCriterion("template_id is null");
			return (Criteria) this;
		}

		public Criteria andTemplateIdIsNotNull() {
			addCriterion("template_id is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateIdEqualTo(Integer value) {
			addCriterion("template_id =", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotEqualTo(Integer value) {
			addCriterion("template_id <>", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdGreaterThan(Integer value) {
			addCriterion("template_id >", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("template_id >=", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdLessThan(Integer value) {
			addCriterion("template_id <", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdLessThanOrEqualTo(Integer value) {
			addCriterion("template_id <=", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdIn(List<Integer> values) {
			addCriterion("template_id in", values, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotIn(List<Integer> values) {
			addCriterion("template_id not in", values, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdBetween(Integer value1, Integer value2) {
			addCriterion("template_id between", value1, value2, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("template_id not between", value1, value2, "templateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdIsNull() {
			addCriterion("process_template_id is null");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdIsNotNull() {
			addCriterion("process_template_id is not null");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdEqualTo(String value) {
			addCriterion("process_template_id =", value, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdNotEqualTo(String value) {
			addCriterion("process_template_id <>", value, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdGreaterThan(String value) {
			addCriterion("process_template_id >", value, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdGreaterThanOrEqualTo(String value) {
			addCriterion("process_template_id >=", value, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdLessThan(String value) {
			addCriterion("process_template_id <", value, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdLessThanOrEqualTo(String value) {
			addCriterion("process_template_id <=", value, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdLike(String value) {
			addCriterion("process_template_id like", value, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdNotLike(String value) {
			addCriterion("process_template_id not like", value, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdIn(List<String> values) {
			addCriterion("process_template_id in", values, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdNotIn(List<String> values) {
			addCriterion("process_template_id not in", values, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdBetween(String value1, String value2) {
			addCriterion("process_template_id between", value1, value2, "processTemplateId");
			return (Criteria) this;
		}

		public Criteria andProcessTemplateIdNotBetween(String value1, String value2) {
			addCriterion("process_template_id not between", value1, value2, "processTemplateId");
			return (Criteria) this;
		}
	}

	/**
	 * nj_product_temp
	 */
	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}

	/**
	 * nj_product_temp 2018-06-26
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