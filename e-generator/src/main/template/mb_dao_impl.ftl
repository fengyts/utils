<#include "./common_t.ftl" />
package ${daoImplPackageName};

import java.util.List;

import ${exceptionPackageName}.DAOException;
import ${entityPackageName}.${tableEntityClassName};
import ${entityPackageName}.${primaryKeyModelClassSimpleName};
import ${daoPackageName}.${tableEntityClassName}DAO;

public class ${tableEntityClassName}MybatisDAO extends MybatisBaseDAO implements ${tableEntityClassName}DAO {

	@Override
	public ${primaryKeyModelClassSimpleName} insert(${tableEntityClassName} obj) throws DAOException {
		return null;
	}

	@Override
	public int updateByPrimaryKey(${tableEntityClassName} obj) throws DAOException {
		return 0;
	}

	@Override
	public int updateDynamicByPrimaryKey(${tableEntityClassName} obj) throws DAOException {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(${primaryKeyModelClassSimpleName} primaryKey) throws DAOException {
		return 0;
	}

	@Override
	public ${tableEntityClassName} selectByPrimaryKey(${primaryKeyModelClassSimpleName} primaryKey) throws DAOException {
		return null;
	}

	@Override
	public List<${tableEntityClassName}> selectDynamic(${tableEntityClassName} obj) throws DAOException {
		return null;
	}

	@Override
	public Long selectCountDynamic(${tableEntityClassName} obj) throws DAOException {
		return null;
	}

	@Override
	public List<${tableEntityClassName}> selectDynamicPageQuery(${tableEntityClassName} obj) throws DAOException {
		return null;
	}

}
