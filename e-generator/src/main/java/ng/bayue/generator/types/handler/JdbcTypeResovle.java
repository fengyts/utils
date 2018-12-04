package ng.bayue.generator.types.handler;

/**
 * jdbcType解析为java类型
 * @author lenovopc
 *
 */
public interface JdbcTypeResovle {

	String getJavaTypeName(String jdbcTypeName);

}
