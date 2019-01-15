<#include "./common_t.ftl" />
package ${packageData.entityPackageName};

import java.io.Serializable;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_PAGENO = 1;
	private static final int DEFAULT_PAGESIZE = 10;

	/** 起始页 */
	private Integer startPage = DEFAULT_PAGENO;

	/** 每页记录数 */
	private Integer pageSize = DEFAULT_PAGESIZE;

	/** 排序 */
	private String orderByClause;
	
	public Integer getStart() {
		return startPage <= 0 || pageSize <= 0 ? 0 : (startPage - 1) * pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

}
