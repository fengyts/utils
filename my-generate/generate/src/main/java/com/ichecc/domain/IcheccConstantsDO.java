package com.ichecc.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
* 常量
* @author fengyts Wed Dec 26 11:12:57 CST 2018
*/

public class IcheccConstantsDO extends BaseDO {

/** 主键 */
private String constKey;

/** 常量值 */
private String constValue;

/** 常量说明 */
private String description;

/** 修改人 */
private Long modifyUserId;

/** 修改时间 */
private Date modifyTime;

/**
* 设置 主键
* @param constKey
*/
	public void setConstKey(String constKey) {
	this.constKey = constKey;
}
/**
* 设置 常量值
* @param constValue
*/
	public void setConstValue(String constValue) {
	this.constValue = constValue;
}
/**
* 设置 常量说明
* @param description
*/
	public void setDescription(String description) {
	this.description = description;
}
/**
* 设置 修改人
* @param modifyUserId
*/
	public void setModifyUserId(Long modifyUserId) {
	this.modifyUserId = modifyUserId;
}
/**
* 设置 修改时间
* @param modifyTime
*/
	public void setModifyTime(Date modifyTime) {
	this.modifyTime = modifyTime;
}
/**
* 获取 主键
* @return constKey
*/
	public String getConstKey() {
	return constKey;
}
/**
* 获取 常量值
* @return constValue
*/
	public String getConstValue() {
	return constValue;
}
/**
* 获取 常量说明
* @return description
*/
	public String getDescription() {
	return description;
}
/**
* 获取 修改人
* @return modifyUserId
*/
	public Long getModifyUserId() {
	return modifyUserId;
}
/**
* 获取 修改时间
* @return modifyTime
*/
	public Date getModifyTime() {
	return modifyTime;
}

}