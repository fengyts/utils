<#include "./common_t.ftl" />
package ${daoImplPackageName};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import ${exceptionPackageName}.DAOException;
import ${entityPackageName}.${tableEntityClassName};
<#if isUnionPK=='true'>
import ${entityPackageName}.${primaryKeyModelClassSimpleName};
</#if>
import ${daoPackageName}.${tableEntityClassName}DAO;

@Component("${tableEntityName}DAO")
public class ${tableEntityClassName}MybatisDAO extends MybatisBaseDAO implements ${tableEntityClassName}DAO {
	
	private static final String NAMESPACE = "${daoPackageName+'.'+tableEntityClassName}Mapper.";
	
	private static String getStatement(String sqlCommandId) {
		return NAMESPACE + sqlCommandId;
	}

	@Override
	public ${primaryKeyModelClassSimpleName} insert(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		getSqlSession().insert(getStatement("insert"), obj);
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
		return getSqlSession().update(getStatement("updateByPrimaryKeyAllFields"), obj);
	}

	@Override
	public int updateByPrimaryKeyDynamic(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().update(getStatement("updateByPrimaryKeyDynamic"), obj);
	}
	
	@Override
	public int updateDynamic(${tableEntityClassName} obj, ${tableEntityClassName} condition) throws DAOException {
		checkNullOrEmptyParam(obj);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("record", obj);
		param.put("example", condition);
		return getSqlSession().update(getStatement("updateDynamic"), param);
	}

	@Override
	public int deleteByPrimaryKey(${primaryKeyModelClassSimpleName} primaryKey) throws DAOException {
		checkNullOrEmptyParam(primaryKey);
		return getSqlSession().delete(getStatement("deleteByPrimaryKey"), primaryKey);
	}

	@Override
	public ${tableEntityClassName} selectByPrimaryKey(${primaryKeyModelClassSimpleName} primaryKey) throws DAOException {
		checkNullOrEmptyParam(primaryKey);
		return getSqlSession().selectOne(getStatement("selectByPrimaryKey"), primaryKey);
	}

	@Override
	public List<${tableEntityClassName}> selectDynamic(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().selectList(getStatement("selectDynamic"), obj);
	}

	@Override
	public Long selectCountDynamic(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().selectOne(getStatement("selectCountDynamic"), obj);
	}

	@Override
	public List<${tableEntityClassName}> selectDynamicPageQuery(${tableEntityClassName} obj) throws DAOException {
		checkNullOrEmptyParam(obj);
		return getSqlSession().selectList(getStatement("selectDynamicPageQuery"), obj);
	}

	<#-- 扩展dao -->
	<#include "./extends/mb_dao_batch_impl.ftl" />

}
