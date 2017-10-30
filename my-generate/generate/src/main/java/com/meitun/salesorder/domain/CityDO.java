package com.meitun.salesorder.domain;

import com.meitun.salesorder.domain.BaseDO;

import java.util.Date;

/**
 * 
 * @author haisheng.long Fri Dec 12 14:20:27 CST 2014
 */

public class CityDO extends BaseDO {

	/** 主键 */
	private Integer id;

	/**  */
	private String name;

	/**  */
	private String spelling;

	/**  */
	private Integer parentId;

	/**  */
	private Integer isDelete;

	/**  */
	private Date addDate;

	/**  */
	private Date lastDate;

	/**  */
	private Integer agencyId;

	/**  */
	private String fristWord;

	/**  */
	private String simpleSpelling;

	/**  */
	private Integer type;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 设置
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置
	 * 
	 * @param spelling
	 */
	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	/**
	 * 设置
	 * 
	 * @param parentId
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 设置
	 * 
	 * @param isDelete
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * 设置
	 * 
	 * @param addDate
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	/**
	 * 设置
	 * 
	 * @param lastDate
	 */
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	/**
	 * 设置
	 * 
	 * @param agencyId
	 */
	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	/**
	 * 设置
	 * 
	 * @param fristWord
	 */
	public void setFristWord(String fristWord) {
		this.fristWord = fristWord;
	}

	/**
	 * 设置
	 * 
	 * @param simpleSpelling
	 */
	public void setSimpleSpelling(String simpleSpelling) {
		this.simpleSpelling = simpleSpelling;
	}

	/**
	 * 设置
	 * 
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取 主键
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 获取
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取
	 * 
	 * @return spelling
	 */
	public String getSpelling() {
		return spelling;
	}

	/**
	 * 获取
	 * 
	 * @return parentId
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 获取
	 * 
	 * @return isDelete
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * 获取
	 * 
	 * @return addDate
	 */
	public Date getAddDate() {
		return addDate;
	}

	/**
	 * 获取
	 * 
	 * @return lastDate
	 */
	public Date getLastDate() {
		return lastDate;
	}

	/**
	 * 获取
	 * 
	 * @return agencyId
	 */
	public Integer getAgencyId() {
		return agencyId;
	}

	/**
	 * 获取
	 * 
	 * @return fristWord
	 */
	public String getFristWord() {
		return fristWord;
	}

	/**
	 * 获取
	 * 
	 * @return simpleSpelling
	 */
	public String getSimpleSpelling() {
		return simpleSpelling;
	}

	/**
	 * 获取
	 * 
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

}