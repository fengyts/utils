package com.chane.yfk.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class EnterpriseExample {
    
    protected String orderByClause;

    
    protected boolean distinct;

    
    protected List<Criteria> oredCriteria;

    
    public EnterpriseExample() {
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

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterprise_name =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterprise_name <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterprise_name >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_name >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterprise_name <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_name <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterprise_name like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterprise_name not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterprise_name in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterprise_name not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterprise_name between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_name not between", value1, value2, "enterpriseName");
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

        public Criteria andLicenseImgSrcIsNull() {
            addCriterion("license_img_src is null");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcIsNotNull() {
            addCriterion("license_img_src is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcEqualTo(String value) {
            addCriterion("license_img_src =", value, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcNotEqualTo(String value) {
            addCriterion("license_img_src <>", value, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcGreaterThan(String value) {
            addCriterion("license_img_src >", value, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("license_img_src >=", value, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcLessThan(String value) {
            addCriterion("license_img_src <", value, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcLessThanOrEqualTo(String value) {
            addCriterion("license_img_src <=", value, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcLike(String value) {
            addCriterion("license_img_src like", value, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcNotLike(String value) {
            addCriterion("license_img_src not like", value, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcIn(List<String> values) {
            addCriterion("license_img_src in", values, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcNotIn(List<String> values) {
            addCriterion("license_img_src not in", values, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcBetween(String value1, String value2) {
            addCriterion("license_img_src between", value1, value2, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andLicenseImgSrcNotBetween(String value1, String value2) {
            addCriterion("license_img_src not between", value1, value2, "licenseImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcIsNull() {
            addCriterion("tax_img_src is null");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcIsNotNull() {
            addCriterion("tax_img_src is not null");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcEqualTo(String value) {
            addCriterion("tax_img_src =", value, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcNotEqualTo(String value) {
            addCriterion("tax_img_src <>", value, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcGreaterThan(String value) {
            addCriterion("tax_img_src >", value, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("tax_img_src >=", value, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcLessThan(String value) {
            addCriterion("tax_img_src <", value, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcLessThanOrEqualTo(String value) {
            addCriterion("tax_img_src <=", value, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcLike(String value) {
            addCriterion("tax_img_src like", value, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcNotLike(String value) {
            addCriterion("tax_img_src not like", value, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcIn(List<String> values) {
            addCriterion("tax_img_src in", values, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcNotIn(List<String> values) {
            addCriterion("tax_img_src not in", values, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcBetween(String value1, String value2) {
            addCriterion("tax_img_src between", value1, value2, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andTaxImgSrcNotBetween(String value1, String value2) {
            addCriterion("tax_img_src not between", value1, value2, "taxImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcIsNull() {
            addCriterion("guarantee_img_src is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcIsNotNull() {
            addCriterion("guarantee_img_src is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcEqualTo(String value) {
            addCriterion("guarantee_img_src =", value, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcNotEqualTo(String value) {
            addCriterion("guarantee_img_src <>", value, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcGreaterThan(String value) {
            addCriterion("guarantee_img_src >", value, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_img_src >=", value, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcLessThan(String value) {
            addCriterion("guarantee_img_src <", value, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcLessThanOrEqualTo(String value) {
            addCriterion("guarantee_img_src <=", value, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcLike(String value) {
            addCriterion("guarantee_img_src like", value, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcNotLike(String value) {
            addCriterion("guarantee_img_src not like", value, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcIn(List<String> values) {
            addCriterion("guarantee_img_src in", values, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcNotIn(List<String> values) {
            addCriterion("guarantee_img_src not in", values, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcBetween(String value1, String value2) {
            addCriterion("guarantee_img_src between", value1, value2, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andGuaranteeImgSrcNotBetween(String value1, String value2) {
            addCriterion("guarantee_img_src not between", value1, value2, "guaranteeImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonMobileIsNull() {
            addCriterion("person_mobile is null");
            return (Criteria) this;
        }

        public Criteria andPersonMobileIsNotNull() {
            addCriterion("person_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andPersonMobileEqualTo(String value) {
            addCriterion("person_mobile =", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileNotEqualTo(String value) {
            addCriterion("person_mobile <>", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileGreaterThan(String value) {
            addCriterion("person_mobile >", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileGreaterThanOrEqualTo(String value) {
            addCriterion("person_mobile >=", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileLessThan(String value) {
            addCriterion("person_mobile <", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileLessThanOrEqualTo(String value) {
            addCriterion("person_mobile <=", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileLike(String value) {
            addCriterion("person_mobile like", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileNotLike(String value) {
            addCriterion("person_mobile not like", value, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileIn(List<String> values) {
            addCriterion("person_mobile in", values, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileNotIn(List<String> values) {
            addCriterion("person_mobile not in", values, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileBetween(String value1, String value2) {
            addCriterion("person_mobile between", value1, value2, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonMobileNotBetween(String value1, String value2) {
            addCriterion("person_mobile not between", value1, value2, "personMobile");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoIsNull() {
            addCriterion("person_identity_no is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoIsNotNull() {
            addCriterion("person_identity_no is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoEqualTo(String value) {
            addCriterion("person_identity_no =", value, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoNotEqualTo(String value) {
            addCriterion("person_identity_no <>", value, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoGreaterThan(String value) {
            addCriterion("person_identity_no >", value, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoGreaterThanOrEqualTo(String value) {
            addCriterion("person_identity_no >=", value, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoLessThan(String value) {
            addCriterion("person_identity_no <", value, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoLessThanOrEqualTo(String value) {
            addCriterion("person_identity_no <=", value, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoLike(String value) {
            addCriterion("person_identity_no like", value, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoNotLike(String value) {
            addCriterion("person_identity_no not like", value, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoIn(List<String> values) {
            addCriterion("person_identity_no in", values, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoNotIn(List<String> values) {
            addCriterion("person_identity_no not in", values, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoBetween(String value1, String value2) {
            addCriterion("person_identity_no between", value1, value2, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityNoNotBetween(String value1, String value2) {
            addCriterion("person_identity_no not between", value1, value2, "personIdentityNo");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcIsNull() {
            addCriterion("person_identity_img_src is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcIsNotNull() {
            addCriterion("person_identity_img_src is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcEqualTo(String value) {
            addCriterion("person_identity_img_src =", value, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcNotEqualTo(String value) {
            addCriterion("person_identity_img_src <>", value, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcGreaterThan(String value) {
            addCriterion("person_identity_img_src >", value, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("person_identity_img_src >=", value, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcLessThan(String value) {
            addCriterion("person_identity_img_src <", value, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcLessThanOrEqualTo(String value) {
            addCriterion("person_identity_img_src <=", value, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcLike(String value) {
            addCriterion("person_identity_img_src like", value, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcNotLike(String value) {
            addCriterion("person_identity_img_src not like", value, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcIn(List<String> values) {
            addCriterion("person_identity_img_src in", values, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcNotIn(List<String> values) {
            addCriterion("person_identity_img_src not in", values, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcBetween(String value1, String value2) {
            addCriterion("person_identity_img_src between", value1, value2, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andPersonIdentityImgSrcNotBetween(String value1, String value2) {
            addCriterion("person_identity_img_src not between", value1, value2, "personIdentityImgSrc");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNull() {
            addCriterion("bank_card_no is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNotNull() {
            addCriterion("bank_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoEqualTo(String value) {
            addCriterion("bank_card_no =", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotEqualTo(String value) {
            addCriterion("bank_card_no <>", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThan(String value) {
            addCriterion("bank_card_no >", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_no >=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThan(String value) {
            addCriterion("bank_card_no <", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThanOrEqualTo(String value) {
            addCriterion("bank_card_no <=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLike(String value) {
            addCriterion("bank_card_no like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotLike(String value) {
            addCriterion("bank_card_no not like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIn(List<String> values) {
            addCriterion("bank_card_no in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotIn(List<String> values) {
            addCriterion("bank_card_no not in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoBetween(String value1, String value2) {
            addCriterion("bank_card_no between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotBetween(String value1, String value2) {
            addCriterion("bank_card_no not between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelIsNull() {
            addCriterion("enterprise_level is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelIsNotNull() {
            addCriterion("enterprise_level is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelEqualTo(String value) {
            addCriterion("enterprise_level =", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelNotEqualTo(String value) {
            addCriterion("enterprise_level <>", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelGreaterThan(String value) {
            addCriterion("enterprise_level >", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_level >=", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelLessThan(String value) {
            addCriterion("enterprise_level <", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelLessThanOrEqualTo(String value) {
            addCriterion("enterprise_level <=", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelLike(String value) {
            addCriterion("enterprise_level like", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelNotLike(String value) {
            addCriterion("enterprise_level not like", value, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelIn(List<String> values) {
            addCriterion("enterprise_level in", values, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelNotIn(List<String> values) {
            addCriterion("enterprise_level not in", values, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelBetween(String value1, String value2) {
            addCriterion("enterprise_level between", value1, value2, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLevelNotBetween(String value1, String value2) {
            addCriterion("enterprise_level not between", value1, value2, "enterpriseLevel");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusIsNull() {
            addCriterion("enterprise_status is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusIsNotNull() {
            addCriterion("enterprise_status is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusEqualTo(String value) {
            addCriterion("enterprise_status =", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusNotEqualTo(String value) {
            addCriterion("enterprise_status <>", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusGreaterThan(String value) {
            addCriterion("enterprise_status >", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_status >=", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusLessThan(String value) {
            addCriterion("enterprise_status <", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusLessThanOrEqualTo(String value) {
            addCriterion("enterprise_status <=", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusLike(String value) {
            addCriterion("enterprise_status like", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusNotLike(String value) {
            addCriterion("enterprise_status not like", value, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusIn(List<String> values) {
            addCriterion("enterprise_status in", values, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusNotIn(List<String> values) {
            addCriterion("enterprise_status not in", values, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusBetween(String value1, String value2) {
            addCriterion("enterprise_status between", value1, value2, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatusNotBetween(String value1, String value2) {
            addCriterion("enterprise_status not between", value1, value2, "enterpriseStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andApplicationNoIsNull() {
            addCriterion("application_no is null");
            return (Criteria) this;
        }

        public Criteria andApplicationNoIsNotNull() {
            addCriterion("application_no is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationNoEqualTo(String value) {
            addCriterion("application_no =", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoNotEqualTo(String value) {
            addCriterion("application_no <>", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoGreaterThan(String value) {
            addCriterion("application_no >", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoGreaterThanOrEqualTo(String value) {
            addCriterion("application_no >=", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoLessThan(String value) {
            addCriterion("application_no <", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoLessThanOrEqualTo(String value) {
            addCriterion("application_no <=", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoLike(String value) {
            addCriterion("application_no like", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoNotLike(String value) {
            addCriterion("application_no not like", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoIn(List<String> values) {
            addCriterion("application_no in", values, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoNotIn(List<String> values) {
            addCriterion("application_no not in", values, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoBetween(String value1, String value2) {
            addCriterion("application_no between", value1, value2, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoNotBetween(String value1, String value2) {
            addCriterion("application_no not between", value1, value2, "applicationNo");
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