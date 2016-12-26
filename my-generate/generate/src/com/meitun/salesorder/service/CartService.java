package com.meitun.salesorder.service;

import java.util.List;
import com.meitun.salesorder.util.Page;
import com.meitun.salesorder.exception.ServiceException;
import com.meitun.salesorder.domain.CartDO;

/**
 * Service
 * 
 * @author haisheng.long 2014-12-12 14:20:26
 */
public interface CartService {

	/**
	 * 插入
	 * 
	 * @param cartDO
	 * @return 主键
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Long insert(CartDO cartDO) throws ServiceException;

	/**
	 * 根据CartDO对象更新
	 * 
	 * @param cartDO
	 * @param isAllField
	 *            是否更新所有字段
	 * @return 更新行数
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	int update(CartDO cartDO, boolean isAllField) throws ServiceException;

	// /**
	// * 根据ID更新 全部字段
	// * @param cartDO
	// * @return 更新行数
	// * @throws ServiceException
	// * @author longhaisheng 2014-12-12 14:20:26
	// */
	// int updateById(CartDO cartDO) throws ServiceException;

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return 物理删除行
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	int deleteById(Long id) throws ServiceException;

	// /**
	// * 动态更新 部分字段
	// * @param cartDO
	// * @return 更新行数
	// * @throws ServiceException
	// * @author longhaisheng 2014-12-12 14:20:26
	// */
	// int updateDynamic(CartDO cartDO) throws ServiceException;

	/**
	 * 根据ID查询 一个
	 * 
	 * @param id
	 * @return CartDO
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	CartDO selectById(Long id) throws ServiceException;

	/**
	 * 根据 动态返回记录数
	 * 
	 * @param cartDO
	 * @return 记录数
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Long selectCountDynamic(CartDO cartDO) throws ServiceException;

	/**
	 * 动态返回 列表
	 * 
	 * @param cartDO
	 * @return List<CartDO>
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	List<CartDO> selectDynamic(CartDO cartDO) throws ServiceException;

	/**
	 * 动态返回 分页列表
	 * 
	 * @param cartDO
	 * @return Page<CartDO>
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Page<CartDO> queryPageListByCartDO(CartDO cartDO);

	/**
	 * 动态返回 分页列表
	 * 
	 * @param cartDO
	 * @param startPage
	 *            起始页
	 * @param pageSize
	 *            每页记录数
	 * @return Page<CartDO>
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:26
	 */
	Page<CartDO> queryPageListByCartDOAndStartPageSize(CartDO cartDO, int startPage, int pageSize);

}
