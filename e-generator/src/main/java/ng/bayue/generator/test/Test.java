package ng.bayue.generator.test;

import java.util.List;

import ng.bayue.generator.types.handler.JdbcTypeResovle;
import ng.bayue.generator.types.handler.MySqlJdbcTypeHandler;

public class Test {

	public static void main(String[] args) {
		// GenericDataSourceConfig conf = new GenericDataSourceConfig();
		JdbcTypeResovle b = new MySqlJdbcTypeHandler();
		b.resovle(null);
		System.out.println(List.class.getName());

	}

}
