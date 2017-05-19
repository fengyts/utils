package com.chane.yfk.mybatis.model;

public class Enterprise {
    /** 自增主键 */
    private Integer id;

    /** 企业名称 */
    private String enterpriseName;

    /** 省 */
    private String province;

    /** 市 */
    private String city;

    /** 区县 */
    private String county;

    /** 详细地址 */
    private String address;

    /** 营业执照图片源 */
    private String licenseImgSrc;

    /** 税务登记证图片源 */
    private String taxImgSrc;

    /** 组织机构担保证图片源 */
    private String guaranteeImgSrc;

    /** 负责人手机号 */
    private String personMobile;

    /** 负责人姓名 */
    private String personName;

    /** 负责人身份证号 */
    private String personIdentityNo;

    /** 负责人身份证图片源 */
    private String personIdentityImgSrc;

    /** 开户行名称 */
    private String bankName;

    /** 银行卡号 */
    private String bankCardNo;

    /** 企业级别，管理表yfk_enterprise_level的字段level_code。 */
    private String enterpriseLevel;

    /** 企业状态，01：启用；02：停用。 */
    private String enterpriseStatus;

    /** 备注 */
    private String remark;

    /** 企业申请编号，对应表yfk_enterprise_application的字段application_no */
    private String applicationNo;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getEnterpriseName() {
        return enterpriseName;
    }

    
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    
    public String getProvince() {
        return province;
    }

    
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    
    public String getCity() {
        return city;
    }

    
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    
    public String getCounty() {
        return county;
    }

    
    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    
    public String getLicenseImgSrc() {
        return licenseImgSrc;
    }

    
    public void setLicenseImgSrc(String licenseImgSrc) {
        this.licenseImgSrc = licenseImgSrc == null ? null : licenseImgSrc.trim();
    }

    
    public String getTaxImgSrc() {
        return taxImgSrc;
    }

    
    public void setTaxImgSrc(String taxImgSrc) {
        this.taxImgSrc = taxImgSrc == null ? null : taxImgSrc.trim();
    }

    
    public String getGuaranteeImgSrc() {
        return guaranteeImgSrc;
    }

    
    public void setGuaranteeImgSrc(String guaranteeImgSrc) {
        this.guaranteeImgSrc = guaranteeImgSrc == null ? null : guaranteeImgSrc.trim();
    }

    
    public String getPersonMobile() {
        return personMobile;
    }

    
    public void setPersonMobile(String personMobile) {
        this.personMobile = personMobile == null ? null : personMobile.trim();
    }

    
    public String getPersonName() {
        return personName;
    }

    
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    
    public String getPersonIdentityNo() {
        return personIdentityNo;
    }

    
    public void setPersonIdentityNo(String personIdentityNo) {
        this.personIdentityNo = personIdentityNo == null ? null : personIdentityNo.trim();
    }

    
    public String getPersonIdentityImgSrc() {
        return personIdentityImgSrc;
    }

    
    public void setPersonIdentityImgSrc(String personIdentityImgSrc) {
        this.personIdentityImgSrc = personIdentityImgSrc == null ? null : personIdentityImgSrc.trim();
    }

    
    public String getBankName() {
        return bankName;
    }

    
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    
    public String getBankCardNo() {
        return bankCardNo;
    }

    
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    
    public String getEnterpriseLevel() {
        return enterpriseLevel;
    }

    
    public void setEnterpriseLevel(String enterpriseLevel) {
        this.enterpriseLevel = enterpriseLevel == null ? null : enterpriseLevel.trim();
    }

    
    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    
    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    
    public String getApplicationNo() {
        return applicationNo;
    }

    
    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo == null ? null : applicationNo.trim();
    }
}