<#include "./common_t.ftl" />
package ${packageData.commonPackageName};

import java.util.List;
import ${packageData.exceptionPackageName}.DAOException;

/**
 * @author lenovopc
 *
 * @param <T> - 实体类模型
 * @param <P> - PrimaryKeyType 主键类型
 */
public interface GenericDAO<T, P> {

	/**
	 * <pre>
	 * 插入 
	 * </pre>
	 *
	 * @param obj
	 * @return P - 返回插入对象的主键
	 * @throws DAOException
	 */
	P insert(T obj) throws DAOException;

	/**
	 * <pre>
	 * 根据ID更新 ,全字段更新
	 * </pre>
	 *
	 * @param primaryKey
	 * @return  更新行数
	 * @throws DAOException
	 */
	int updateByPrimaryKey(T primaryKey) throws DAOException;

	/**
	 * 动态更新 <T>部分或全部字段
	 * @param primaryKey
	 * @return 更新行数
	 * @throws DAOException
	 */
	int updateDynamicByPrimaryKey(T primaryKey) throws DAOException;

	/**
	 * <pre>
	 * 根据主键删除
	 * </pre>
	 *
	 * @param primaryKey
	 * @return 删除行数
	 * @throws DAOException
	 */
	int deleteByPrimaryKey(P primaryKey) throws DAOException;

	/**
	 * 根据主键查询 一条 记录
	 * @param primaryKey
	 * @return T
	 * @throws DAOException
	 */
	T selectByPrimaryKey(P primaryKey) throws DAOException;

	/**
	 * 根据  <T> 动态返回 <T> 列表
	 * @param obj
	 * @return List<T>
	 * @throws DAOException
	 */
	List<T> selectDynamic(T obj) throws DAOException;

	/**
	 * 根据  <T> 动态返回记录数
	 * @param obj
	 * @return 记录条数
	 * @throws DAOException
	 */
	Long selectCountDynamic(T obj) throws DAOException;

	/**
	 * 分页查询列表： 根据  <T> 动态返回 <T> Limit 列表
	 * @param obj start, pageSize - sql分页查询limit的属性, 必须指定
	 * @return List<T>
	 * @throws DAOException
	 */
	List<T> selectDynamicPageQuery(T obj) throws DAOException;

}
