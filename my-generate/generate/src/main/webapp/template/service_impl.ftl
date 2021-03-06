package ${packgeDO.serviceImplPackageName};

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
<#if bean_is_auto_wire?string=="1">
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
</#if>
<#assign len = domain.className?index_of("DO")>
<#assign DAOName = "${domain.className?substring(0,len)}DAO">
<#assign lower_dao_name = "${domain.className?substring(0,len)?uncap_first}DAO">
<#assign param="${domain.className?uncap_first}">

import ${packgeDO.daoPackageName}.${domain.className?substring(0,len)}DAO;
import ${domain.packageName}.${domain.className};
import ${packgeDO.servicePackageName}.${domain.className?substring(0,len)}Service;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
<#--
import ${packgeDO.exceptionPackageName}.DAOException;
import ${packgeDO.exceptionPackageName}.ServiceException;
import ${packgeDO.utilPackageName}.Page;
-->
import ng.bayue.common.Page;

<#if bean_is_auto_wire?string=="1">
@Service(value="${domain.className?substring(0,len)?uncap_first}Service")
</#if>
public class ${domain.className?substring(0,len)}ServiceImpl  implements ${domain.className?substring(0,len)}Service{

	private Log logger = LogFactory.getLog(this.getClass());

	<#if bean_is_auto_wire?string=="1">@Autowired</#if>
	private ${DAOName} ${lower_dao_name};

	<#if bean_is_auto_wire?string=="0">
	public void set${DAOName}(${DAOName} ${lower_dao_name}) {
		this.${lower_dao_name} = ${lower_dao_name};
	}

	</#if>
	@Override
	public Long insert(${domain.className} ${param}) throws CommonServiceException {
		try {
			return ${lower_dao_name}.insert(${param});
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

<#--
//	@Override
//	public int updateById(${domain.className} ${param}) throws CommonServiceException {
//		try {
//			return (Integer) ${lower_dao_name}.updateById(${param});
//		}catch(CommonDAOException e){
//			logger.error(e);
//            throw new CommonServiceException(e);
//		}
//	}
-->

	@Override
	public int update(${domain.className} ${param},boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) ${lower_dao_name}.update(${param});
			}else{
				return (Integer) ${lower_dao_name}.updateDynamic(${param});
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) ${lower_dao_name}.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	<#if tableDO.primaryColumnType == 'String'>
	@Override
	public int deleteByPrimaryKey(String primaryKey) throws CommonServiceException {
		try {
			return (Integer) ${lower_dao_name}.deleteByPrimaryKey(primaryKey);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	</#if>

<#--
//	@Override
//	public int updateDynamic(${domain.className} ${param}) throws CommonServiceException {
//		try {
//			return (Integer) ${lower_dao_name}.updateDynamic(${param});
//		}catch(CommonDAOException e){
//			logger.error(e);
//            throw new CommonServiceException(e);
//		}
//	}
-->

	@Override
	public ${domain.className} selectById(Long id) throws CommonServiceException {
		try {
			return ${lower_dao_name}.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	<#if tableDO.primaryColumnType == 'String'>
	@Override
	public ${domain.className} selectByPrimaryKey(String primaryKey) throws CommonServiceException {
		try {
			return ${lower_dao_name}.selectByPrimaryKey(primaryKey);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public int updateByPrimaryKey(${domain.className} ${param}) throws CommonServiceException {
		try {
			return ${lower_dao_name}.updateByPrimaryKey(${param});
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	</#if>

	@Override
	public Long selectCountDynamic(${domain.className} ${param}) throws CommonServiceException {
		try {
			return ${lower_dao_name}.selectCountDynamic(${param});
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<${domain.className}> selectDynamic(${domain.className} ${param}) throws CommonServiceException {
		try {
			return ${lower_dao_name}.selectDynamic(${param});
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<${domain.className}> selectDynamicPageQuery(${domain.className} ${param}) throws CommonServiceException {
		try {
			return ${lower_dao_name}.selectDynamicPageQuery(${param});
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<${domain.className}> queryPageListDynamic(${domain.className} ${param}) throws CommonServiceException{
		if (${param} != null) {
			Long totalCount = this.selectCountDynamic(${param});

			Page<${domain.className}> page = new Page<${domain.className}>();
			page.setPageNo(${param}.getStartPage());
			page.setPageSize(${param}.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<${domain.className}> resultList = this.selectDynamicPageQuery(${param});
				page.setList(resultList);
			}
			return page;
		}
		return new Page<${domain.className}>();
	}
	
	@Override
	public Page<${domain.className}> queryPageListDynamicAndStartPageSize(${domain.className} ${param}, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (${param} != null && startPage>0 && pageSize>0) {
			${param}.setStartPage(startPage);
			${param}.setPageSize(pageSize);
			return this.queryPageListDynamic(${param});
		}
		return new Page<${domain.className}>();
	}
	
	
}
