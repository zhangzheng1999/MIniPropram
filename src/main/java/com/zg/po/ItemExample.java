package com.zg.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNull() {
            addCriterion("item_price is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNotNull() {
            addCriterion("item_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceEqualTo(Float value) {
            addCriterion("item_price =", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotEqualTo(Float value) {
            addCriterion("item_price <>", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThan(Float value) {
            addCriterion("item_price >", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("item_price >=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThan(Float value) {
            addCriterion("item_price <", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThanOrEqualTo(Float value) {
            addCriterion("item_price <=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceIn(List<Float> values) {
            addCriterion("item_price in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotIn(List<Float> values) {
            addCriterion("item_price not in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceBetween(Float value1, Float value2) {
            addCriterion("item_price between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotBetween(Float value1, Float value2) {
            addCriterion("item_price not between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPicIsNull() {
            addCriterion("item_pic is null");
            return (Criteria) this;
        }

        public Criteria andItemPicIsNotNull() {
            addCriterion("item_pic is not null");
            return (Criteria) this;
        }

        public Criteria andItemPicEqualTo(String value) {
            addCriterion("item_pic =", value, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicNotEqualTo(String value) {
            addCriterion("item_pic <>", value, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicGreaterThan(String value) {
            addCriterion("item_pic >", value, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicGreaterThanOrEqualTo(String value) {
            addCriterion("item_pic >=", value, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicLessThan(String value) {
            addCriterion("item_pic <", value, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicLessThanOrEqualTo(String value) {
            addCriterion("item_pic <=", value, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicLike(String value) {
            addCriterion("item_pic like", value, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicNotLike(String value) {
            addCriterion("item_pic not like", value, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicIn(List<String> values) {
            addCriterion("item_pic in", values, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicNotIn(List<String> values) {
            addCriterion("item_pic not in", values, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicBetween(String value1, String value2) {
            addCriterion("item_pic between", value1, value2, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemPicNotBetween(String value1, String value2) {
            addCriterion("item_pic not between", value1, value2, "itemPic");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeIsNull() {
            addCriterion("item_create_time is null");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeIsNotNull() {
            addCriterion("item_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeEqualTo(Date value) {
            addCriterion("item_create_time =", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeNotEqualTo(Date value) {
            addCriterion("item_create_time <>", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeGreaterThan(Date value) {
            addCriterion("item_create_time >", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("item_create_time >=", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeLessThan(Date value) {
            addCriterion("item_create_time <", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("item_create_time <=", value, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeIn(List<Date> values) {
            addCriterion("item_create_time in", values, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeNotIn(List<Date> values) {
            addCriterion("item_create_time not in", values, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeBetween(Date value1, Date value2) {
            addCriterion("item_create_time between", value1, value2, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("item_create_time not between", value1, value2, "itemCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeIsNull() {
            addCriterion("item_buy_time is null");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeIsNotNull() {
            addCriterion("item_buy_time is not null");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeEqualTo(Date value) {
            addCriterionForJDBCDate("item_buy_time =", value, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("item_buy_time <>", value, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("item_buy_time >", value, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("item_buy_time >=", value, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeLessThan(Date value) {
            addCriterionForJDBCDate("item_buy_time <", value, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("item_buy_time <=", value, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeIn(List<Date> values) {
            addCriterionForJDBCDate("item_buy_time in", values, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("item_buy_time not in", values, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("item_buy_time between", value1, value2, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemBuyTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("item_buy_time not between", value1, value2, "itemBuyTime");
            return (Criteria) this;
        }

        public Criteria andItemStateIsNull() {
            addCriterion("item_state is null");
            return (Criteria) this;
        }

        public Criteria andItemStateIsNotNull() {
            addCriterion("item_state is not null");
            return (Criteria) this;
        }

        public Criteria andItemStateEqualTo(Integer value) {
            addCriterion("item_state =", value, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateNotEqualTo(Integer value) {
            addCriterion("item_state <>", value, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateGreaterThan(Integer value) {
            addCriterion("item_state >", value, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_state >=", value, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateLessThan(Integer value) {
            addCriterion("item_state <", value, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateLessThanOrEqualTo(Integer value) {
            addCriterion("item_state <=", value, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateIn(List<Integer> values) {
            addCriterion("item_state in", values, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateNotIn(List<Integer> values) {
            addCriterion("item_state not in", values, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateBetween(Integer value1, Integer value2) {
            addCriterion("item_state between", value1, value2, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemStateNotBetween(Integer value1, Integer value2) {
            addCriterion("item_state not between", value1, value2, "itemState");
            return (Criteria) this;
        }

        public Criteria andItemSchoolIsNull() {
            addCriterion("item_school is null");
            return (Criteria) this;
        }

        public Criteria andItemSchoolIsNotNull() {
            addCriterion("item_school is not null");
            return (Criteria) this;
        }

        public Criteria andItemSchoolEqualTo(String value) {
            addCriterion("item_school =", value, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolNotEqualTo(String value) {
            addCriterion("item_school <>", value, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolGreaterThan(String value) {
            addCriterion("item_school >", value, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("item_school >=", value, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolLessThan(String value) {
            addCriterion("item_school <", value, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolLessThanOrEqualTo(String value) {
            addCriterion("item_school <=", value, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolLike(String value) {
            addCriterion("item_school like", value, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolNotLike(String value) {
            addCriterion("item_school not like", value, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolIn(List<String> values) {
            addCriterion("item_school in", values, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolNotIn(List<String> values) {
            addCriterion("item_school not in", values, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolBetween(String value1, String value2) {
            addCriterion("item_school between", value1, value2, "itemSchool");
            return (Criteria) this;
        }

        public Criteria andItemSchoolNotBetween(String value1, String value2) {
            addCriterion("item_school not between", value1, value2, "itemSchool");
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