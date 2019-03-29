package com.dz.bestnew.po.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserShareExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andNewsTitleIdIsNull() {
            addCriterion("news_title_id is null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdIsNotNull() {
            addCriterion("news_title_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdEqualTo(Integer value) {
            addCriterion("news_title_id =", value, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdNotEqualTo(Integer value) {
            addCriterion("news_title_id <>", value, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdGreaterThan(Integer value) {
            addCriterion("news_title_id >", value, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_title_id >=", value, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdLessThan(Integer value) {
            addCriterion("news_title_id <", value, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("news_title_id <=", value, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdIn(List<Integer> values) {
            addCriterion("news_title_id in", values, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdNotIn(List<Integer> values) {
            addCriterion("news_title_id not in", values, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("news_title_id between", value1, value2, "newsTitleId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("news_title_id not between", value1, value2, "newsTitleId");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andShareWayIsNull() {
            addCriterion("share_way is null");
            return (Criteria) this;
        }

        public Criteria andShareWayIsNotNull() {
            addCriterion("share_way is not null");
            return (Criteria) this;
        }

        public Criteria andShareWayEqualTo(Integer value) {
            addCriterion("share_way =", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayNotEqualTo(Integer value) {
            addCriterion("share_way <>", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayGreaterThan(Integer value) {
            addCriterion("share_way >", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_way >=", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayLessThan(Integer value) {
            addCriterion("share_way <", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayLessThanOrEqualTo(Integer value) {
            addCriterion("share_way <=", value, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayIn(List<Integer> values) {
            addCriterion("share_way in", values, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayNotIn(List<Integer> values) {
            addCriterion("share_way not in", values, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayBetween(Integer value1, Integer value2) {
            addCriterion("share_way between", value1, value2, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareWayNotBetween(Integer value1, Integer value2) {
            addCriterion("share_way not between", value1, value2, "shareWay");
            return (Criteria) this;
        }

        public Criteria andShareTimeIsNull() {
            addCriterion("share_time is null");
            return (Criteria) this;
        }

        public Criteria andShareTimeIsNotNull() {
            addCriterion("share_time is not null");
            return (Criteria) this;
        }

        public Criteria andShareTimeEqualTo(Date value) {
            addCriterionForJDBCTime("share_time =", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("share_time <>", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("share_time >", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("share_time >=", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeLessThan(Date value) {
            addCriterionForJDBCTime("share_time <", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("share_time <=", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeIn(List<Date> values) {
            addCriterionForJDBCTime("share_time in", values, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("share_time not in", values, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("share_time between", value1, value2, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("share_time not between", value1, value2, "shareTime");
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