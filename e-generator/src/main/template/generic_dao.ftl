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
	 * @param t
	 * @return
	 * @throws DAOException
	 */
	P insert(T t) throws DAOException;

	/**
	 * <pre>
	 * 根据ID更新 ,全字段更新
	 * </pre>
	 *
	 * @param t
	 * @return  更新行数
	 * @throws DAOException
	 */
	int update(T t) throws DAOException;

	/**
	 * 动态更新 <T>部分属性,包括全部
	 * @param t
	 * @return 更新行数
	 * @throws DAOException
	 * @author fengyts 2017-03-07 11:29:32
	 */
	int updateDynamic(T t) throws DAOException;

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
	 * <pre>
	 * 根据主键对象模型删除
	 * </pre>
	 * 
	 * @param primaryKeyModel
	 * @return
	 * @throws DAOException
	 */
	//	int deleteByPrimaryKeyModel(BasePrimaryKey primaryKeyModel) throws DAOException;

	/**
	 * 根据主键查询 一条 记录
	 * @param pk
	 * @return T
	 * @throws DAOException
	 * @author fengyts 2017-03-07 11:29:32
	 */
	T selectByPrimaryKey(P primaryKey) throws DAOException;
	
	/**
	 * <pre>
	 * 根据主键对象模型查找
	 * </pre>
	 * 
	 * @param primaryKeyModel
	 * @return
	 * @throws DAOException
	 */
	//	T selectByPrimaryKeyModel(BasePrimaryKey primaryKeyModel) throws DAOException;

	/**
	 * 根据  <T> 动态返回记录数
	 * @param t
	 * @return 记录条数
	 * @throws DAOException
	 * @author fengyts 2017-03-07 11:29:32
	 */
	Long selectCountDynamic(T t) throws DAOException;

	/**
	 * 根据  <T> 动态返回 <T> 列表
	 * @param t
	 * @return List<T>
	 * @throws DAOException
	 * @author fengyts 2017-03-07 11:29:32
	 */
	List<T> selectDynamic(T t) throws DAOException;

	/**
	 * 根据  <T> 动态返回 <T> Limit 列表
	 * @param t start,pageSize属性必须指定
	 * @return List<T>
	 * @throws DAOException
	 * @author fengyts 2017-03-07 11:29:32
	 */
	List<T> selectDynamicPageQuery(T t) throws DAOException;

}
