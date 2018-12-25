package ng.bayue.generator.mybatis.model;

public class TestGeneratorPrimaryKey {

	public TestGeneratorPrimaryKey() {
		super();
	}
	
	public TestGeneratorPrimaryKey(Long id, Integer pk1) {
		this.id = id;
		this.pk1 = pk1;
	}
	
	/** 主键1 */
	private Long id;
		
	/**  */
	private Integer pk1;
		
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

}