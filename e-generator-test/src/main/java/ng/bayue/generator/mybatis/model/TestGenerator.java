package ng.bayue.generator.mybatis.model;

import java.util.Date;
import java.math.BigDecimal;

public class TestGenerator {
	
	/** 主键1 */
	private Long id;
		
	/**  */
	private Integer pk1;
		
	/** 订单编号 */
	private String orderNo;
		
	/** 用户id */
	private Long userId;
		
	/** 商品id */
	private Long itemId;
		
	/** 单位id */
	private Long unionId;
		
	/** 商品名称 */
	private String itemName;
		
	/** 地址 */
	private String address;
		
	/** 创建时间 */
	private Date createTime;
		
	/** 测试外键 */
	private Long testFk;
		
	/** 金额 */
	private BigDecimal tradeAmount;
		
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
		
	public void setPk1(Integer pk1) {
		this.pk1 = pk1;
	}
	
	public Integer getPk1() {
		return pk1;
	}
		
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
		
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}
		
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public Long getItemId() {
		return itemId;
	}
		
	public void setUnionId(Long unionId) {
		this.unionId = unionId;
	}
	
	public Long getUnionId() {
		return unionId;
	}
		
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemName() {
		return itemName;
	}
		
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
		
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
		
	public void setTestFk(Long testFk) {
		this.testFk = testFk;
	}
	
	public Long getTestFk() {
		return testFk;
	}
		
	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	
	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}
		
}