package com.fc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LendListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LendListExample() {
        oredCriteria = new ArrayList<>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBookidIsNull() {
            addCriterion("bookId is null");
            return (Criteria) this;
        }

        public Criteria andBookidIsNotNull() {
            addCriterion("bookId is not null");
            return (Criteria) this;
        }

        public Criteria andBookidEqualTo(Integer value) {
            addCriterion("bookId =", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotEqualTo(Integer value) {
            addCriterion("bookId <>", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThan(Integer value) {
            addCriterion("bookId >", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookId >=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThan(Integer value) {
            addCriterion("bookId <", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThanOrEqualTo(Integer value) {
            addCriterion("bookId <=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidIn(List<Integer> values) {
            addCriterion("bookId in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotIn(List<Integer> values) {
            addCriterion("bookId not in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidBetween(Integer value1, Integer value2) {
            addCriterion("bookId between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotBetween(Integer value1, Integer value2) {
            addCriterion("bookId not between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andReaderidIsNull() {
            addCriterion("readerId is null");
            return (Criteria) this;
        }

        public Criteria andReaderidIsNotNull() {
            addCriterion("readerId is not null");
            return (Criteria) this;
        }

        public Criteria andReaderidEqualTo(Integer value) {
            addCriterion("readerId =", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotEqualTo(Integer value) {
            addCriterion("readerId <>", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidGreaterThan(Integer value) {
            addCriterion("readerId >", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("readerId >=", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidLessThan(Integer value) {
            addCriterion("readerId <", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidLessThanOrEqualTo(Integer value) {
            addCriterion("readerId <=", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidIn(List<Integer> values) {
            addCriterion("readerId in", values, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotIn(List<Integer> values) {
            addCriterion("readerId not in", values, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidBetween(Integer value1, Integer value2) {
            addCriterion("readerId between", value1, value2, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotBetween(Integer value1, Integer value2) {
            addCriterion("readerId not between", value1, value2, "readerid");
            return (Criteria) this;
        }

        public Criteria andLenddateIsNull() {
            addCriterion("lendDate is null");
            return (Criteria) this;
        }

        public Criteria andLenddateIsNotNull() {
            addCriterion("lendDate is not null");
            return (Criteria) this;
        }

        public Criteria andLenddateEqualTo(Date value) {
            addCriterion("lendDate =", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateNotEqualTo(Date value) {
            addCriterion("lendDate <>", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateGreaterThan(Date value) {
            addCriterion("lendDate >", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("lendDate >=", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateLessThan(Date value) {
            addCriterion("lendDate <", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateLessThanOrEqualTo(Date value) {
            addCriterion("lendDate <=", value, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateIn(List<Date> values) {
            addCriterion("lendDate in", values, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateNotIn(List<Date> values) {
            addCriterion("lendDate not in", values, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateBetween(Date value1, Date value2) {
            addCriterion("lendDate between", value1, value2, "lenddate");
            return (Criteria) this;
        }

        public Criteria andLenddateNotBetween(Date value1, Date value2) {
            addCriterion("lendDate not between", value1, value2, "lenddate");
            return (Criteria) this;
        }

        public Criteria andBackdateIsNull() {
            addCriterion("backDate is null");
            return (Criteria) this;
        }

        public Criteria andBackdateIsNotNull() {
            addCriterion("backDate is not null");
            return (Criteria) this;
        }

        public Criteria andBackdateEqualTo(Date value) {
            addCriterion("backDate =", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotEqualTo(Date value) {
            addCriterion("backDate <>", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateGreaterThan(Date value) {
            addCriterion("backDate >", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateGreaterThanOrEqualTo(Date value) {
            addCriterion("backDate >=", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateLessThan(Date value) {
            addCriterion("backDate <", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateLessThanOrEqualTo(Date value) {
            addCriterion("backDate <=", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateIn(List<Date> values) {
            addCriterion("backDate in", values, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotIn(List<Date> values) {
            addCriterion("backDate not in", values, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateBetween(Date value1, Date value2) {
            addCriterion("backDate between", value1, value2, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotBetween(Date value1, Date value2) {
            addCriterion("backDate not between", value1, value2, "backdate");
            return (Criteria) this;
        }

        public Criteria andBacktypeIsNull() {
            addCriterion("backType is null");
            return (Criteria) this;
        }

        public Criteria andBacktypeIsNotNull() {
            addCriterion("backType is not null");
            return (Criteria) this;
        }

        public Criteria andBacktypeEqualTo(Integer value) {
            addCriterion("backType =", value, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeNotEqualTo(Integer value) {
            addCriterion("backType <>", value, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeGreaterThan(Integer value) {
            addCriterion("backType >", value, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("backType >=", value, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeLessThan(Integer value) {
            addCriterion("backType <", value, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeLessThanOrEqualTo(Integer value) {
            addCriterion("backType <=", value, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeIn(List<Integer> values) {
            addCriterion("backType in", values, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeNotIn(List<Integer> values) {
            addCriterion("backType not in", values, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeBetween(Integer value1, Integer value2) {
            addCriterion("backType between", value1, value2, "backtype");
            return (Criteria) this;
        }

        public Criteria andBacktypeNotBetween(Integer value1, Integer value2) {
            addCriterion("backType not between", value1, value2, "backtype");
            return (Criteria) this;
        }

        public Criteria andExceptremarksIsNull() {
            addCriterion("exceptRemarks is null");
            return (Criteria) this;
        }

        public Criteria andExceptremarksIsNotNull() {
            addCriterion("exceptRemarks is not null");
            return (Criteria) this;
        }

        public Criteria andExceptremarksEqualTo(String value) {
            addCriterion("exceptRemarks =", value, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksNotEqualTo(String value) {
            addCriterion("exceptRemarks <>", value, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksGreaterThan(String value) {
            addCriterion("exceptRemarks >", value, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksGreaterThanOrEqualTo(String value) {
            addCriterion("exceptRemarks >=", value, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksLessThan(String value) {
            addCriterion("exceptRemarks <", value, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksLessThanOrEqualTo(String value) {
            addCriterion("exceptRemarks <=", value, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksLike(String value) {
            addCriterion("exceptRemarks like", value, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksNotLike(String value) {
            addCriterion("exceptRemarks not like", value, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksIn(List<String> values) {
            addCriterion("exceptRemarks in", values, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksNotIn(List<String> values) {
            addCriterion("exceptRemarks not in", values, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksBetween(String value1, String value2) {
            addCriterion("exceptRemarks between", value1, value2, "exceptremarks");
            return (Criteria) this;
        }

        public Criteria andExceptremarksNotBetween(String value1, String value2) {
            addCriterion("exceptRemarks not between", value1, value2, "exceptremarks");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

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