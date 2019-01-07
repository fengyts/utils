<#include "./common_t.ftl" />
package ${packageData.commonPackageName};

import java.util.List;
import org.apache.ibatis.annotations.Param;
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
	 * 根据主键更新 ,全字段更新
	 * </pre>
	 *
	 * @param obj
	 * @return  更新行数
	 * @throws DAOException
	 */
	int updateByPrimaryKeyAllFields(T obj) throws DAOException;

	/**
	 * 根据主键动态更新 <T>部分或全部字段
	 * @param obj
	 * @return 更新行数
	 * @throws DAOException
	 */
	int updateByPrimaryKeyDynamic(T obj) throws DAOException;
	
	/**
	 * 根据条件动态更新 <T>部分或全部字段
	 * @param obj - 要更新的数据
	 * @param condition - 更新条件
	 * @return 更新行数
	 * @throws DAOException
	 */
	int updateDynamic(@Param("record") T obj, @Param("example") T condition) throws DAOException;

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
