package ng.bayue.generator.types.handler;

import ng.bayue.generator.types.BaseJdbcType;

public abstract class BaseTypeHandler {
	
	abstract Object handler(BaseJdbcType type);

}
