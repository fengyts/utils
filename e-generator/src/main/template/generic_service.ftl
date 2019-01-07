<#include "./common_t.ftl" />
package ${packageData.commonPackageName};

import java.util.List;
import ${commonPackageName}.Page;
import ${packageData.exceptionPackageName}.ServiceException;


/**
 * @author lenovopc
 *
 * @param <T> - 实体类模型
 * @param <P> - PrimaryKeyType 主键类型
 */
public interface GenericService<T, P> {

	/**
	 * 插入 
	 * @param obj
	 * @return P - 返回插入对象的主键
	 * @throws ServiceException
	 */
	P insert(T obj) throws ServiceException;

	/**
	 * 根据主键动态更新 <T>部分或全部字段
	 * @param obj 要更新的对象
	 * @param isAllField 
	 *		是否更新所有字段(true 更新所有字段, false 动态更新字段, 传null或false将动态更新, 建议动态更新)
	 * @return 更新行数
	 * @throws ServiceException
	 */
	int update(T obj, boolean... isAllField) throws ServiceException;

	/**
	 * 根据条件动态更新 <T>部分或全部字段
	 * @param obj - 要更新的数据
	 * @param condition - 更新条件
	 * @return 更新行数
	 * @throws ServiceException
	 */
	int updateDynamic(T obj, T condition) throws ServiceException;

	/**
	 * 根据主键删除 - 物理删除
	 * @param primaryKey
	 * @return 删除行数
	 * @throws ServiceException
	 */
	int deleteByPrimaryKey(P primaryKey) throws ServiceException;

	/**
	 * 根据主键删除 - 逻辑删除, 实际为根据主键动态更新逻辑删除字段
	 * @param obj
	 * @return 删除行数
	 * @throws ServiceException
	 */
	int deleteByPrimaryKeyLogic(T obj) throws ServiceException;

	/**
	 * 根据主键查询 一条 记录
	 * @param primaryKey
	 * @return T
	 * @throws ServiceException
	 */
	T selectByPrimaryKey(P primaryKey) throws ServiceException;

	/**
	 * 根据  <T> 动态返回 <T> 列表
	 * @param obj
	 * @return List<T>
	 * @throws ServiceException
	 */
	List<T> selectDynamic(T obj) throws ServiceException;

	/**
	 * 根据  <T> 动态返回记录数
	 * @param obj
	 * @return 记录条数
	 * @throws ServiceException
	 */
	Long selectCountDynamic(T obj) throws ServiceException;

	/**
	 * 分页查询列表： 根据  <T> 动态返回 <T> Limit 列表
	 * @param obj start, pageSize - sql分页查询limit的属性, 必须指定
	 * @return List<T>
	 * @throws ServiceException
	 */
	List<T> selectDynamicPageQuery(T obj) throws ServiceException;
	
	/**
	 * 分页查询列表： 根据  <T> 动态返回页Page<T>对象
	 * @param obj start, pageSize - sql分页查询limit的属性, 必须指定
	 * @return List<T>
	 * @throws ServiceException
	 */
	Page<T> queryPageListDynamic(T obj) throws ServiceException;
	
	/**
	 * 分页查询列表： 根据  <T> 动态返回分页Page<T>对象
	 * @param obj, pageNo, pageSize
	 * @return List<T>
	 * @throws ServiceException
	 */
	Page<T> queryPageListByObjAndStartPageSize(T obj, int pageNo, int pageSize) throws ServiceException;

}

