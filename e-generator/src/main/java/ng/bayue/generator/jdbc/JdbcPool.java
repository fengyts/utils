package ng.bayue.generator.jdbc;

import java.sql.Connection;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class JdbcPool extends GenericObjectPool<Connection> {

	public JdbcPool(PooledObjectFactory<Connection> factory, GenericObjectPoolConfig<Connection> config) {
		super(factory, config);
	}

}
