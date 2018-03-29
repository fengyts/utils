package ${packgeDO.daoPackageName};

import ${domain.packageName}.${domain.className};
<#--
import java.util.List;
import ${packgeDO.exceptionPackageName}.DAOException;
-->
import ng.bayue.service.common.GeneralDAO;
<#if tableDO.primaryColumnType == 'String'>
import ng.bayue.exception.CommonDAOException;
</#if>
<#assign len = domain.className?index_of("DO")>
<#assign param="${domain.className?uncap_first}">

 /**
 * ${data_object_comment} DAO
 *
 * @author fengyts ${create_time?if_exists?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface ${domain.className?substring(0,len)}DAO extends GeneralDAO<${domain.className}> {
	
	<#if tableDO.primaryColumnType == 'String'>
	/**
	 * <pre>
	 * 根据主键查询
	 * </pre>
	 *
	 * @param primaryKey
	 * @return ${domain.className}
	 * @throws CommonDAOException
	 */
	${domain.className} selectByPrimaryKey(String primaryKey) throws CommonDAOException;
	
	/**
	 * <pre>
	 * 根据主键删除
	 * </pre>
	 *
	 * @param primaryKey
	 * @return int
	 * @throws CommonDAOException
	 */
	int deleteByPrimaryKey(String primaryKey) throws CommonDAOException;
	</#if>

}
