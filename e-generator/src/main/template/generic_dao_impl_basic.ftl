<#include "./common_t.ftl" />
package ${daoImplPackageName};

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisBaseDAO extends SqlSessionDaoSupport<#-- implements BaseDAO--> {
	
	@Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
  		super.setSqlSessionTemplate(sqlSessionTemplate);
    }
	
}