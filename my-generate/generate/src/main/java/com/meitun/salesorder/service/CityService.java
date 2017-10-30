package com.meitun.salesorder.service;

import java.util.List;
import com.meitun.salesorder.util.Page;
import com.meitun.salesorder.exception.ServiceException;
import com.meitun.salesorder.domain.CityDO;

/**
 * Service
 * 
 * @author haisheng.long 2014-12-12 14:20:27
 */
public interface CityService {

	/**
	 * 插入
	 * 
	 * @param cityDO
	 * @return 主键
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Long insert(CityDO cityDO) throws ServiceException;

	/**
	 * 根据CityDO对象更新
	 * 
	 * @param cityDO
	 * @param isAllField
	 *            是否更新所有字段
	 * @return 更新行数
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	int update(CityDO cityDO, boolean isAllField) throws ServiceException;

	// /**
	// * 根据ID更新 全部字段
	// * @param cityDO
	// * @return 更新行数
	// * @throws ServiceException
	// * @author longhaisheng 2014-12-12 14:20:27
	// */
	// int updateById(CityDO cityDO) throws ServiceException;

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return 物理删除行
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	int deleteById(Long id) throws ServiceException;

	// /**
	// * 动态更新 部分字段
	// * @param cityDO
	// * @return 更新行数
	// * @throws ServiceException
	// * @author longhaisheng 2014-12-12 14:20:27
	// */
	// int updateDynamic(CityDO cityDO) throws ServiceException;

	/**
	 * 根据ID查询 一个
	 * 
	 * @param id
	 * @return CityDO
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	CityDO selectById(Long id) throws ServiceException;

	/**
	 * 根据 动态返回记录数
	 * 
	 * @param cityDO
	 * @return 记录数
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Long selectCountDynamic(CityDO cityDO) throws ServiceException;

	/**
	 * 动态返回 列表
	 * 
	 * @param cityDO
	 * @return List<CityDO>
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	List<CityDO> selectDynamic(CityDO cityDO) throws ServiceException;

	/**
	 * 动态返回 分页列表
	 * 
	 * @param cityDO
	 * @return Page<CityDO>
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Page<CityDO> queryPageListByCityDO(CityDO cityDO);

	/**
	 * 动态返回 分页列表
	 * 
	 * @param cityDO
	 * @param startPage
	 *            起始页
	 * @param pageSize
	 *            每页记录数
	 * @return Page<CityDO>
	 * @throws ServiceException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Page<CityDO> queryPageListByCityDOAndStartPageSize(CityDO cityDO, int startPage, int pageSize);

}
