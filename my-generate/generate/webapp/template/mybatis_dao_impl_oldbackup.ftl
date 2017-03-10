package ${packgeDO.daoPackageName}.mybatis;
<#assign len = domain.className?index_of("DO")>
<#if use_statement_name_spaces?string=="1">
	<#assign ibatis_class_dao="${domain.packageName}.${domain.className?substring(0,len)}Mapper.Mybatis${domain.className?substring(0,len)}DAO">
<#else>
	<#assign ibatis_class_dao="Mybatis${domain.className?substring(0,len)}DAO">
</#if>
<#assign param="${domain.className?uncap_first}">
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
<#if bean_is_auto_wire?string=="1">
import org.springframework.stereotype.Component;
</#if>
import ${packgeDO.daoPackageName}.${domain.className?substring(0,len)}DAO;
import ${domain.packageName}.${domain.className};
import ${packgeDO.exceptionPackageName}.DAOException;

<#if bean_is_auto_wire?string=="1">
@Component(value="${domain.className?substring(0,len)?uncap_first}DAO")
</#if>
public class Mybatis${domain.className?substring(0,len)}DAO extends MybatisBaseDAO implements ${domain.className?substring(0,len)}DAO {
<#assign getPrimaryMethod="get${tableDO.primaryProperty?cap_first}()">
	
	private static final String NAMESPACE = "${ibatis_class_dao}_";
	
	public Long insert(${domain.className} ${param}) throws DAOException {
		int i = getSqlSession().insert(NAMESPACE + "insert", ${param});
		if (i > 0) {
			return Long.valueOf(${param}.${getPrimaryMethod});
		}
		return 0L;
	}

	@Override
	public Integer update(${domain.className} ${param}) throws DAOException {
		return getSqlSession().update(NAMESPACE + "updateById", ${param});
	}

	@Override
	public Integer deleteById(Long id) throws DAOException {
		return getSqlSession().delete(NAMESPACE + "deleteById", id);
	}

	@Override
	public Integer updateDynamic(${domain.className} ${param}) throws DAOException {
		return getSqlSession().update(NAMESPACE + "update_dynamic", ${param});
	}

	@Override
	public ${domain.className} selectById(Long id) throws DAOException {
		return getSqlSession().selectOne(NAMESPACE + "selectById", id);
	}

	@Override
	public Long selectCountDynamic(${domain.className} ${param}) throws DAOException {
		return getSqlSession().selectOne(NAMESPACE + "select_dynamic_count", ${param});
	}

	@Override
	public List<${domain.className}> selectDynamic(${domain.className} ${param}) throws DAOException {
		return getSqlSession().selectList(NAMESPACE + "select_dynamic", ${param});
	}

	@Override
	public List<${domain.className}> selectDynamicPageQuery(${domain.className} ${param}) throws DAOException {
		return getSqlSession().selectList(NAMESPACE + "select_dynamic_page_query", ${param});
	}

}
