<#include "../common_t.ftl" />
package ${commonPackageName};

import java.util.List;

import ${exceptionPackageName}.DAOException;

/**
 * 扩展DAO, 包含了sql批量操作和根据unique index 的基本sql
 * 
 * @author lenovopc
 *
 * @param <T>
 * @param <P>
 */
public interface GenericExtendDAO<T, P> extends GenericDAO<T, P> {

	List<T> selectBatchByPrimaryKey(List<P> pkLists) throws DAOException;

	int insertBatch(List<T> records) throws DAOException;

	int updateBatchByPrimaryKey(List<T> records) throws DAOException;

	int deleteBatchByPrimaryKey(List<P> pkLists) throws DAOException;

}
