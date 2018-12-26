<#include "./common_t.ftl" />
package ${packageData.commonPackageName};

import java.util.List;
import ${packageData.commonPackageName}.Page;
import ${packageData.exceptionPackageName}.ServiceException;

public interface GenericService<T, U> {
	
//	Logger logger = LoggerFactory.getLogger(GeneralService.class);

	/**
	 * <pre>
	 * 
	 * </pre>
	 *
	 * @param t
	 * @return 主键
	 */
	Long insert(T t) throws ServiceException;

	/**
	 * <pre>
	 * 动态更新
	 * </pre>
	 *
	 * @param t
	 * @param isAllField
	 *            是否更新所有字段(false 动态更新字段，true 更新所有字段,传null或false将动态更新，建议动态更新)
	 * @return 更新行数
	 */
	int update(T t, boolean isAllField) throws ServiceException;

	/**
	 * 根据ID删除 规格
	 * 
	 * @param id
	 * @return 物理删除行
	 * @author fengyts 2016-07-26 10:08:30
	 */
	int deleteById(Long id) throws ServiceException;

	/**
	 * 根据ID查询 一个 对象
	 * 
	 * @param id
	 * @return T
	 * @author fengyts 2016-07-26 10:08:30
	 */
	T selectById(Long id) throws ServiceException;

	List<T> selectDynamic(T t) throws ServiceException;

	/**
	 * <pre>
	 * 根据条件动态查询记录数
	 * </pre>
	 *
	 * @param t
	 * @return
	 */
	Long selectCountDynamic(T t) throws ServiceException;

	Page<U> queryPageListDynamic(T t) throws ServiceException;

	Page<U> queryPageListDynamicAndStartPageSize(T t, Integer pageNo, Integer pageSize) throws ServiceException;

}
