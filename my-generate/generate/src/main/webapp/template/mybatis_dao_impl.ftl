package ${packgeDO.daoPackageName}.mybatis;
<#assign len = domain.className?index_of("DO")>
<#if use_statement_name_spaces?string=="1">
	<#assign ibatis_class_dao="${domain.packageName}.${domain.className?substring(0,len)}Mapper.Mybatis${domain.className?substring(0,len)}DAO">
<#else>
	<#assign ibatis_class_dao="Mybatis${domain.className?substring(0,len)}DAO">
</#if>
<#assign param="${domain.className?uncap_first}">

import java.util.List;

<#--
import org.mybatis.spring.support.SqlSessionDaoSupport;
import ng.bayue.service.common.GeneralDAO;
-->
<#if bean_is_auto_wire?string=="1">
import org.springframework.stereotype.Component;
</#if>
import ${packgeDO.daoPackageName}.${domain.className?substring(0,len)}DAO;
import ${packgeDO.daoPackageName}.base.MybatisBaseDAO;
import ${domain.packageName}.${domain.className};
import ng.bayue.exception.CommonDAOException;
<#--
import ng.bayue.exception.DAOException;
import ${packgeDO.exceptionPackageName}.DAOException;
-->

<#if bean_is_auto_wire?string=="1">
@Component(value="${domain.className?substring(0,len)?uncap_first}DAO")
</#if>
public class Mybatis${domain.className?substring(0,len)}DAO extends MybatisBaseDAO implements ${domain.className?substring(0,len)}DAO {
<#assign getPrimaryMethod="get${tableDO.primaryProperty?cap_first}()">
	
	private static final String NAMESPACE = "${ibatis_class_dao}_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(${domain.className} ${param}) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), ${param});
		if (i > 0) {
			return Long.valueOf(${param}.${getPrimaryMethod});
		}
		return 0L;
	}

	@Override
	public Integer update(${domain.className} ${param}) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), ${param});
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	
	<#if tableDO.primaryColumnType == 'String'>
	@Override
	public int deleteByPrimaryKey(String primaryKey) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteByPrimaryKey"), primaryKey);
	}
	</#if>

	@Override
	public Integer updateDynamic(${domain.className} ${param}) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), ${param});
	}

	@Override
	public ${domain.className} selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	
	<#if tableDO.primaryColumnType == 'String'>
	@Override
	public ${domain.className} selectByPrimaryKey(String primaryKey) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectByPrimaryKey"), primaryKey);
	}
	</#if>

	@Override
	public Long selectCountDynamic(${domain.className} ${param}) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), ${param});
	}

	@Override
	public List<${domain.className}> selectDynamic(${domain.className} ${param}) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), ${param});
	}

	@Override
	public List<${domain.className}> selectDynamicPageQuery(${domain.className} ${param}) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), ${param});
	}

}
