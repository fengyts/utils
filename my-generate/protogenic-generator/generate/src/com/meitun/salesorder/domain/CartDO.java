package com.meitun.salesorder.domain;

import com.meitun.salesorder.domain.BaseDO;

import java.util.Date;

/**
 * 
 * @author haisheng.long Fri Dec 12 14:20:26 CST 2014
 */

public class CartDO extends BaseDO {

	/** 主键 */
	private Long id;

	/** 商品ID */
	private Long itemId;

	/** 商品SKU ID */
	private Long skuId;

	/** 会员ID */
	private Long memberId;

	/** 购买数量 */
	private Integer quantity;

	/** 是否购选 */
	private String selected;

	/** 创建时间 */
	private Date createTime;

	/** 修改时间 */
	private Date modifyTime;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 商品ID
	 * 
	 * @param itemId
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * 设置 商品SKU ID
	 * 
	 * @param skuId
	 */
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	/**
	 * 设置 会员ID
	 * 
	 * @param memberId
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	/**
	 * 设置 购买数量
	 * 
	 * @param quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 设置 是否购选
	 * 
	 * @param selected
	 */
	public void setSelected(String selected) {
		this.selected = selected;
	}

	/**
	 * 设置 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置 修改时间
	 * 
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 获取 主键
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 获取 商品ID
	 * 
	 * @return itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * 获取 商品SKU ID
	 * 
	 * @return skuId
	 */
	public Long getSkuId() {
		return skuId;
	}

	/**
	 * 获取 会员ID
	 * 
	 * @return memberId
	 */
	public Long getMemberId() {
		return memberId;
	}

	/**
	 * 获取 购买数量
	 * 
	 * @return quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 获取 是否购选
	 * 
	 * @return selected
	 */
	public String getSelected() {
		return selected;
	}

	/**
	 * 获取 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 修改时间
	 * 
	 * @return modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

}