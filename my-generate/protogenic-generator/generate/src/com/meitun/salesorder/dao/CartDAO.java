package com.meitun.salesorder.dao;

import java.util.List;
import com.meitun.salesorder.domain.CartDO;
import com.meitun.salesorder.exception.DAOException;

/**
 * DAO
 * 
 * @author haisheng.Long 2014-12-12 14:20:26
 */
public interface CartDAO {

	/**
	 * 插入
	 * 
	 * @param cartDO
	 * @return 主键
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Long insert(CartDO cartDO) throws DAOException;

	/**
	 * 根据ID更新 全部属性
	 * 
	 * @param cartDO
	 * @return 更新行数
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Integer update(CartDO cartDO) throws DAOException;

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return 删除行数
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Integer deleteById(Long id) throws DAOException;

	/**
	 * 动态更新 部分属性，包括全部
	 * 
	 * @param cartDO
	 * @return 更新行数
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Integer updateDynamic(CartDO cartDO) throws DAOException;

	/**
	 * 根据ID查询 一个
	 * 
	 * @param id
	 * @return CartDO
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	CartDO selectById(Long id) throws DAOException;

	/**
	 * 根据 动态返回记录数
	 * 
	 * @param cartDO
	 * @return 记录条数
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Long selectCountDynamic(CartDO cartDO) throws DAOException;

	/**
	 * 根据 动态返回 列表
	 * 
	 * @param cartDO
	 * @return List<CartDO>
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	List<CartDO> selectDynamic(CartDO cartDO) throws DAOException;

	/**
	 * 根据 动态返回 Limit 列表
	 * 
	 * @param cartDO
	 *            start,pageSize属性必须指定
	 * @return List<CartDO>
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	List<CartDO> selectDynamicPageQuery(CartDO cartDO) throws DAOException;
}
