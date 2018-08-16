package ${packgeDO.servicePackageName};

<#--
import java.util.List;
import ${packgeDO.utilPackageName}.Page;
import ng.bayue.common.Page;
import ${packgeDO.exceptionPackageName}.ServiceException;
import ng.bayue.exception.ServiceException;
-->
import ng.bayue.service.common.GeneralService;
<#if tableDO.primaryColumnType == 'String'>
import ng.bayue.exception.CommonServiceException;
</#if>
import ${domain.packageName}.${domain.className};
<#assign len = domain.className?index_of("DO")>
<#assign param="${domain.className?uncap_first}">
<#assign entity="${domain.className}">

 /**
 * ${data_object_comment} Service
 * @author fengyts ${create_time?if_exists?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface ${entity?substring(0,len)}Service extends GeneralService<${entity}, ${entity}> {
	
	<#if tableDO.primaryColumnType == 'String'>
	/**
	 * <pre>
	 * 根据主键查询
	 * </pre>
	 *
	 * @param primaryKey
	 * @return ${domain.className}
	 * @throws CommonServiceException
	 */
	${domain.className} selectByPrimaryKey(String primaryKey);
	
	/**
	 * <pre>
	 * 根据主键删除
	 * </pre>
	 *
	 * @param primaryKey
	 * @return int
	 * @throws CommonServiceException
	 */
	int deleteByPrimaryKey(String primaryKey);
	
	/**
	 * <pre>
	 * 根据主键动态更新
	 * </pre>
	 *
	 * @param ${param}
	 * @return int
	 * @throws CommonServiceException
	 */
	int updateByPrimaryKey(${domain.className} ${param}) throws CommonServiceException;
	</#if>
	
}
