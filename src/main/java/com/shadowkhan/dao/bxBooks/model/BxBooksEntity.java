package com.shadowkhan.dao.bxBooks.model;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class BxBooksEntity {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BxBooksEntity() {
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
        public Criteria andIsbnIsNull() {
            addCriterion("ISBN is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("ISBN is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("ISBN =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("ISBN <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("ISBN >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("ISBN >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("ISBN <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("ISBN <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("ISBN like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("ISBN not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("ISBN in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("ISBN not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("ISBN between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("ISBN not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andBookTitleIsNull() {
            addCriterion("Book_Title is null");
            return (Criteria) this;
        }

        public Criteria andBookTitleIsNotNull() {
            addCriterion("Book_Title is not null");
            return (Criteria) this;
        }

        public Criteria andBookTitleEqualTo(String value) {
            addCriterion("Book_Title =", value, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleNotEqualTo(String value) {
            addCriterion("Book_Title <>", value, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleGreaterThan(String value) {
            addCriterion("Book_Title >", value, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Book_Title >=", value, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleLessThan(String value) {
            addCriterion("Book_Title <", value, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleLessThanOrEqualTo(String value) {
            addCriterion("Book_Title <=", value, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleLike(String value) {
            addCriterion("Book_Title like", value, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleNotLike(String value) {
            addCriterion("Book_Title not like", value, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleIn(List<String> values) {
            addCriterion("Book_Title in", values, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleNotIn(List<String> values) {
            addCriterion("Book_Title not in", values, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleBetween(String value1, String value2) {
            addCriterion("Book_Title between", value1, value2, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookTitleNotBetween(String value1, String value2) {
            addCriterion("Book_Title not between", value1, value2, "bookTitle");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("Book_Author is null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("Book_Author is not null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("Book_Author =", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("Book_Author <>", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("Book_Author >", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("Book_Author >=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("Book_Author <", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("Book_Author <=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("Book_Author like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("Book_Author not like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("Book_Author in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("Book_Author not in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("Book_Author between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("Book_Author not between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationIsNull() {
            addCriterion("Year_Of_Publication is null");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationIsNotNull() {
            addCriterion("Year_Of_Publication is not null");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationEqualTo(Integer value) {
            addCriterion("Year_Of_Publication =", value, "yearOfPublication");
            return (Criteria) this;
        }
        public Criteria andisDeletedEqualTo(String value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationNotEqualTo(Integer value) {
            addCriterion("Year_Of_Publication <>", value, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationGreaterThan(Integer value) {
            addCriterion("Year_Of_Publication >", value, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationGreaterThanOrEqualTo(Integer value) {
            addCriterion("Year_Of_Publication >=", value, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationLessThan(Integer value) {
            addCriterion("Year_Of_Publication <", value, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationLessThanOrEqualTo(Integer value) {
            addCriterion("Year_Of_Publication <=", value, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationIn(List<Integer> values) {
            addCriterion("Year_Of_Publication in", values, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationNotIn(List<Integer> values) {
            addCriterion("Year_Of_Publication not in", values, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationBetween(Integer value1, Integer value2) {
            addCriterion("Year_Of_Publication between", value1, value2, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andYearOfPublicationNotBetween(Integer value1, Integer value2) {
            addCriterion("Year_Of_Publication not between", value1, value2, "yearOfPublication");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNull() {
            addCriterion("Publisher is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNotNull() {
            addCriterion("Publisher is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherEqualTo(String value) {
            addCriterion("Publisher =", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotEqualTo(String value) {
            addCriterion("Publisher <>", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThan(String value) {
            addCriterion("Publisher >", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("Publisher >=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThan(String value) {
            addCriterion("Publisher <", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThanOrEqualTo(String value) {
            addCriterion("Publisher <=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLike(String value) {
            addCriterion("Publisher like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotLike(String value) {
            addCriterion("Publisher not like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherIn(List<String> values) {
            addCriterion("Publisher in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotIn(List<String> values) {
            addCriterion("Publisher not in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherBetween(String value1, String value2) {
            addCriterion("Publisher between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotBetween(String value1, String value2) {
            addCriterion("Publisher not between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andImageUrlSIsNull() {
            addCriterion("Image_URL_S is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlSIsNotNull() {
            addCriterion("Image_URL_S is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlSEqualTo(String value) {
            addCriterion("Image_URL_S =", value, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSNotEqualTo(String value) {
            addCriterion("Image_URL_S <>", value, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSGreaterThan(String value) {
            addCriterion("Image_URL_S >", value, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSGreaterThanOrEqualTo(String value) {
            addCriterion("Image_URL_S >=", value, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSLessThan(String value) {
            addCriterion("Image_URL_S <", value, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSLessThanOrEqualTo(String value) {
            addCriterion("Image_URL_S <=", value, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSLike(String value) {
            addCriterion("Image_URL_S like", value, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSNotLike(String value) {
            addCriterion("Image_URL_S not like", value, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSIn(List<String> values) {
            addCriterion("Image_URL_S in", values, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSNotIn(List<String> values) {
            addCriterion("Image_URL_S not in", values, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSBetween(String value1, String value2) {
            addCriterion("Image_URL_S between", value1, value2, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlSNotBetween(String value1, String value2) {
            addCriterion("Image_URL_S not between", value1, value2, "imageUrlS");
            return (Criteria) this;
        }

        public Criteria andImageUrlMIsNull() {
            addCriterion("Image_URL_M is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlMIsNotNull() {
            addCriterion("Image_URL_M is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlMEqualTo(String value) {
            addCriterion("Image_URL_M =", value, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMNotEqualTo(String value) {
            addCriterion("Image_URL_M <>", value, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMGreaterThan(String value) {
            addCriterion("Image_URL_M >", value, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMGreaterThanOrEqualTo(String value) {
            addCriterion("Image_URL_M >=", value, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMLessThan(String value) {
            addCriterion("Image_URL_M <", value, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMLessThanOrEqualTo(String value) {
            addCriterion("Image_URL_M <=", value, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMLike(String value) {
            addCriterion("Image_URL_M like", value, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMNotLike(String value) {
            addCriterion("Image_URL_M not like", value, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMIn(List<String> values) {
            addCriterion("Image_URL_M in", values, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMNotIn(List<String> values) {
            addCriterion("Image_URL_M not in", values, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMBetween(String value1, String value2) {
            addCriterion("Image_URL_M between", value1, value2, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlMNotBetween(String value1, String value2) {
            addCriterion("Image_URL_M not between", value1, value2, "imageUrlM");
            return (Criteria) this;
        }

        public Criteria andImageUrlLIsNull() {
            addCriterion("Image_URL_L is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlLIsNotNull() {
            addCriterion("Image_URL_L is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlLEqualTo(String value) {
            addCriterion("Image_URL_L =", value, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLNotEqualTo(String value) {
            addCriterion("Image_URL_L <>", value, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLGreaterThan(String value) {
            addCriterion("Image_URL_L >", value, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLGreaterThanOrEqualTo(String value) {
            addCriterion("Image_URL_L >=", value, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLLessThan(String value) {
            addCriterion("Image_URL_L <", value, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLLessThanOrEqualTo(String value) {
            addCriterion("Image_URL_L <=", value, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLLike(String value) {
            addCriterion("Image_URL_L like", value, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLNotLike(String value) {
            addCriterion("Image_URL_L not like", value, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLIn(List<String> values) {
            addCriterion("Image_URL_L in", values, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLNotIn(List<String> values) {
            addCriterion("Image_URL_L not in", values, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLBetween(String value1, String value2) {
            addCriterion("Image_URL_L between", value1, value2, "imageUrlL");
            return (Criteria) this;
        }

        public Criteria andImageUrlLNotBetween(String value1, String value2) {
            addCriterion("Image_URL_L not between", value1, value2, "imageUrlL");
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
