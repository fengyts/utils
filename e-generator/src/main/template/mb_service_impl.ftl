<#include "./common_t.ftl" />
package ${serviceImplPackageName};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${commonPackageName}.Page;
import ${exceptionPackageName}.DAOException;
import ${exceptionPackageName}.ServiceException;
import ${daoPackageName}.${tableEntityClassName}DAO;
import ${entityPackageName}.${tableEntityClassName};
<#if isUnionPK=='true'>
import ${entityPackageName}.${primaryKeyModelClassSimpleName};
</#if>
import ${servicePackageName}.${tableEntityClassName}Service;

@Service(value = "${tableEntityName}Service")
public class ${tableEntityClassName}ServiceImpl implements ${tableEntityClassName}Service {
	
	<#assign daoRefer = tableEntityName + 'DAO' />
	@Autowired
	private ${tableEntityClassName}DAO ${daoRefer};

	@Override
	public ${primaryKeyModelClassSimpleName} insert(${tableEntityClassName} obj) throws ServiceException {
		try {
			${primaryKeyModelClassSimpleName} primaryKey = ${daoRefer}.insert(obj);
			return primaryKey;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int update(${tableEntityClassName} obj, boolean... isAllField) throws ServiceException {
		try {
			boolean allField = true;
			if (null == isAllField || isAllField.length == 0) {
				allField = false;
			} else {
				allField = isAllField[0];
			}
			int res = 0;
			if (allField) {
				res = ${daoRefer}.updateByPrimaryKeyAllFields(obj);
			} else {
				res = ${daoRefer}.updateByPrimaryKeyDynamic(obj);
			}
			return res;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int updateDynamic(${tableEntityClassName} obj, ${tableEntityClassName} condition) throws ServiceException {
		try {
			return ${daoRefer}.updateDynamic(obj, condition);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int deleteByPrimaryKey(${primaryKeyModelClassSimpleName} primaryKey) throws ServiceException {
		try {
			return ${daoRefer}.deleteByPrimaryKey(primaryKey);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int deleteByPrimaryKeyLogic(${tableEntityClassName} obj) throws ServiceException {
		return this.update(obj);
	}

	@Override
	public ${tableEntityClassName} selectByPrimaryKey(${primaryKeyModelClassSimpleName} primaryKey) throws ServiceException {
		try {
			${tableEntityClassName} obj = ${daoRefer}.selectByPrimaryKey(primaryKey);
			return obj;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<${tableEntityClassName}> selectDynamic(${tableEntityClassName} obj) throws ServiceException {
		try {
			List<${tableEntityClassName}> results = ${daoRefer}.selectDynamic(obj);
			return results;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Long selectCountDynamic(${tableEntityClassName} obj) throws ServiceException {
		try {
			Long count = ${daoRefer}.selectCountDynamic(obj);
			return count;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<${tableEntityClassName}> selectDynamicPageQuery(${tableEntityClassName} obj) throws ServiceException {
		try {
			return ${daoRefer}.selectDynamicPageQuery(obj);
		}catch(DAOException e){
            throw new ServiceException(e);
		}
	}
	
	@Override
	public Page<${tableEntityClassName}> queryPageListDynamic(${tableEntityClassName} obj) throws ServiceException {
		if (obj != null) {
			Long totalCount = this.selectCountDynamic(obj);

			Page<${tableEntityClassName}> page = new Page<${tableEntityClassName}>();
			page.setPageNo(obj.getStartPage());
			page.setPageSize(obj.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<${tableEntityClassName}> resultList = this.selectDynamicPageQuery(obj);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<${tableEntityClassName}>();
	}
	
	@Override
	public Page<${tableEntityClassName}> queryPageListByObjAndStartPageSize(${tableEntityClassName} obj, int startPage, int pageSize) throws ServiceException {
		if (obj != null && startPage > 0 && pageSize > 0) {
			obj.setStartPage(startPage);
			obj.setPageSize(pageSize);
			return this.queryPageListDynamic(obj);
		}
		return new Page<${tableEntityClassName}>();
	}

}