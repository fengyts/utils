package com.meitun.salesorder.dao;

import java.util.List;
import com.meitun.salesorder.domain.CityDO;
import com.meitun.salesorder.exception.DAOException;

/**
 * DAO
 * 
 * @author haisheng.Long 2014-12-12 14:20:27
 */
public interface CityDAO {

	/**
	 * 插入
	 * 
	 * @param cityDO
	 * @return 主键
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Long insert(CityDO cityDO) throws DAOException;

	/**
	 * 根据ID更新 全部属性
	 * 
	 * @param cityDO
	 * @return 更新行数
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Integer update(CityDO cityDO) throws DAOException;

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return 删除行数
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Integer deleteById(Long id) throws DAOException;

	/**
	 * 动态更新 部分属性，包括全部
	 * 
	 * @param cityDO
	 * @return 更新行数
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Integer updateDynamic(CityDO cityDO) throws DAOException;

	/**
	 * 根据ID查询 一个
	 * 
	 * @param id
	 * @return CityDO
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	CityDO selectById(Long id) throws DAOException;

	/**
	 * 根据 动态返回记录数
	 * 
	 * @param cityDO
	 * @return 记录条数
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	Long selectCountDynamic(CityDO cityDO) throws DAOException;

	/**
	 * 根据 动态返回 列表
	 * 
	 * @param cityDO
	 * @return List<CityDO>
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	List<CityDO> selectDynamic(CityDO cityDO) throws DAOException;

	/**
	 * 根据 动态返回 Limit 列表
	 * 
	 * @param cityDO
	 *            start,pageSize属性必须指定
	 * @return List<CityDO>
	 * @throws DAOException
	 * @author longhaisheng 2014-12-12 14:20:27
	 */
	List<CityDO> selectDynamicPageQuery(CityDO cityDO) throws DAOException;
}
