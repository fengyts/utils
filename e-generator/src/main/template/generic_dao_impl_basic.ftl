<#include "./common_t.ftl" />
package ${daoImplPackageName};

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisBaseDAO extends SqlSessionDaoSupport<#-- implements BaseDAO--> {
	
	@Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
  		super.setSqlSessionTemplate(sqlSessionTemplate);
    }
    
 	public static void checkNullOrEmptyParam(final Object param) {
		final String msg = " Null data cannot be allowed ";
		if (null == param) {
			throw new NullPointerException(msg + ": param is null");
		}
		if (param instanceof String) {
			boolean isBlank = true;
			int strLen;
			String cs = (String) param;
			if ((strLen = cs.length()) == 0) {
				throw new NullPointerException(msg + ": param is blank String");
			}
			for (int i = 0; i < strLen; i++) {
				if (Character.isWhitespace(cs.charAt(i)) == false) {
					isBlank = false;
					break;
				}
			}
			if (isBlank) {
				throw new NullPointerException(msg + ": param is blank String");
			}
			return;
		} else if (param instanceof List) {
			if (((List<?>) param).isEmpty()) {
				throw new NullPointerException(msg + ": param is empty list");
			}
			return;
		} else if (param instanceof Map) {
			if (((Map<?, ?>) param).isEmpty()) {
				throw new NullPointerException(msg + ": param is empty map");
			}
			return;
		} else if (param instanceof Collection) {
			if (((Collection<?>) param).isEmpty()) {
				throw new NullPointerException(msg + ": param is empty collection");
			}
			return;
		}
	}
	
}