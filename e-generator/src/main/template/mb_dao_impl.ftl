<#include "./common_t.ftl" />
package ${daoImplPackageName};

import java.util.List;

import ${exceptionPackageName}.DAOException;
import ${entityPackageName}.${tableEntityClassName};
<#if isUnionPK=='true'>
import ${entityPackageName}.${primaryKeyModelClassSimpleName};
</#if>
import ${daoPackageName}.${tableEntityClassName}DAO;

public class ${tableEntityClassName}MybatisDAO extends MybatisBaseDAO implements ${tableEntityClassName}DAO {

	@Override
	public ${primaryKeyModelClassSimpleName} insert(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		getSqlSession().insert("insert", obj);
	<#assign properties=primaryKeyInfoData.properties />
	<#if isUnionPK=='true'>
		${primaryKeyModelClassSimpleName} primaryKey = new ${primaryKeyModelClassSimpleName}();
			<#if properties?default([])?size!=0>
				<#list properties as prop>
		primaryKey.set${prop.propertyName?cap_first}(obj.get${prop.propertyName?cap_first}());
				</#list>
			</#if>
		return primaryKey;
	<#else>
		<#if properties?default([])?size!=0>
			<#list properties as prop>
		${prop.propertyType!"Object"} ${prop.propertyName} = obj.get${prop.propertyName?cap_first}();
		return ${prop.propertyName};
			</#list>
		<#else>
		return null;
		</#if>
	</#if>
	}

	@Override
	public int updateByPrimaryKeyAllFields(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().update("updateByPrimaryKey", obj);
	}

	@Override
	public int updateByPrimaryKeyDynamic(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().update("updateDynamicByPrimaryKey", obj);
	}
	
	@Override
	public int updateDynamic(${tableEntityClassName} obj, ${tableEntityClassName} condition) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().update("updateDynamicByPrimaryKey", obj);
	}

	@Override
	public int deleteByPrimaryKey(${primaryKeyModelClassSimpleName} primaryKey) throws DAOException {
		checkNullOrEmptyParam(primaryKey);
		return getSqlSession().delete("deleteByPrimaryKey", primaryKey);
	}

	@Override
	public ${tableEntityClassName} selectByPrimaryKey(${primaryKeyModelClassSimpleName} primaryKey) throws DAOException {
		checkNullOrEmptyParam(primaryKey);
		return getSqlSession().selectOne("selectByPrimaryKey", primaryKey);
	}

	@Override
	public List<${tableEntityClassName}> selectDynamic(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().selectList("selectDynamic", obj);
	}

	@Override
	public Long selectCountDynamic(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().selectOne("selectCountDynamic", obj);
	}

	@Override
	public List<${tableEntityClassName}> selectDynamicPageQuery(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().selectList("selectDynamicPageQuery", obj);
	}

}
