package com.nj.model.esign.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EsignSignRecordExample {
    /**
	 * esign_sign_record
	 */
	protected String orderByClause;
	/**
	 * esign_sign_record
	 */
	protected boolean distinct;
	/**
	 * esign_sign_record
	 */
	protected List<Criteria> oredCriteria;

	public EsignSignRecordExample() {
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
	 * esign_sign_record 2018-06-25
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

		public Criteria andAccountIdIsNull() {
			addCriterion("account_id is null");
			return (Criteria) this;
		}

		public Criteria andAccountIdIsNotNull() {
			addCriterion("account_id is not null");
			return (Criteria) this;
		}

		public Criteria andAccountIdEqualTo(String value) {
			addCriterion("account_id =", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdNotEqualTo(String value) {
			addCriterion("account_id <>", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdGreaterThan(String value) {
			addCriterion("account_id >", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
			addCriterion("account_id >=", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdLessThan(String value) {
			addCriterion("account_id <", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdLessThanOrEqualTo(String value) {
			addCriterion("account_id <=", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdLike(String value) {
			addCriterion("account_id like", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdNotLike(String value) {
			addCriterion("account_id not like", value, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdIn(List<String> values) {
			addCriterion("account_id in", values, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdNotIn(List<String> values) {
			addCriterion("account_id not in", values, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdBetween(String value1, String value2) {
			addCriterion("account_id between", value1, value2, "accountId");
			return (Criteria) this;
		}

		public Criteria andAccountIdNotBetween(String value1, String value2) {
			addCriterion("account_id not between", value1, value2, "accountId");
			return (Criteria) this;
		}

		public Criteria andFileCateIsNull() {
			addCriterion("file_cate is null");
			return (Criteria) this;
		}

		public Criteria andFileCateIsNotNull() {
			addCriterion("file_cate is not null");
			return (Criteria) this;
		}

		public Criteria andFileCateEqualTo(String value) {
			addCriterion("file_cate =", value, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateNotEqualTo(String value) {
			addCriterion("file_cate <>", value, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateGreaterThan(String value) {
			addCriterion("file_cate >", value, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateGreaterThanOrEqualTo(String value) {
			addCriterion("file_cate >=", value, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateLessThan(String value) {
			addCriterion("file_cate <", value, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateLessThanOrEqualTo(String value) {
			addCriterion("file_cate <=", value, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateLike(String value) {
			addCriterion("file_cate like", value, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateNotLike(String value) {
			addCriterion("file_cate not like", value, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateIn(List<String> values) {
			addCriterion("file_cate in", values, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateNotIn(List<String> values) {
			addCriterion("file_cate not in", values, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateBetween(String value1, String value2) {
			addCriterion("file_cate between", value1, value2, "fileCate");
			return (Criteria) this;
		}

		public Criteria andFileCateNotBetween(String value1, String value2) {
			addCriterion("file_cate not between", value1, value2, "fileCate");
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

		public Criteria andSignRecordIdIsNull() {
			addCriterion("sign_record_id is null");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdIsNotNull() {
			addCriterion("sign_record_id is not null");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdEqualTo(String value) {
			addCriterion("sign_record_id =", value, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdNotEqualTo(String value) {
			addCriterion("sign_record_id <>", value, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdGreaterThan(String value) {
			addCriterion("sign_record_id >", value, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdGreaterThanOrEqualTo(String value) {
			addCriterion("sign_record_id >=", value, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdLessThan(String value) {
			addCriterion("sign_record_id <", value, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdLessThanOrEqualTo(String value) {
			addCriterion("sign_record_id <=", value, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdLike(String value) {
			addCriterion("sign_record_id like", value, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdNotLike(String value) {
			addCriterion("sign_record_id not like", value, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdIn(List<String> values) {
			addCriterion("sign_record_id in", values, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdNotIn(List<String> values) {
			addCriterion("sign_record_id not in", values, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdBetween(String value1, String value2) {
			addCriterion("sign_record_id between", value1, value2, "signRecordId");
			return (Criteria) this;
		}

		public Criteria andSignRecordIdNotBetween(String value1, String value2) {
			addCriterion("sign_record_id not between", value1, value2, "signRecordId");
			return (Criteria) this;
		}
	}

	/**
	 * esign_sign_record 2018-06-25
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table esign_sign_record
     *
     * @mbggenerated do_not_delete_during_merge Fri Nov 17 11:07:54 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}