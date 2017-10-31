package com.meitun.salesorder.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.meitun.salesorder.dao.CartDAO;
import com.meitun.salesorder.domain.CartDO;
import com.meitun.salesorder.service.CartService;
import com.meitun.salesorder.exception.DAOException;
import com.meitun.salesorder.exception.ServiceException;
import com.meitun.salesorder.util.Page;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private CartDAO cartDAO;

	@Override
	public Long insert(CartDO cartDO) throws ServiceException {
		try {
			return cartDAO.insert(cartDO);
		} catch (DAOException e) {
			logger.error(e);
			throw new ServiceException(e);
		}
	}

	// @Override
	// public int updateById(CartDO cartDO) throws ServiceException {
	// try {
	// return (Integer) cartDAO.updateById(cartDO);
	// }catch(DAOException e){
	// logger.error(e);
	// throw new ServiceException(e);
	// }
	// }

	@Override
	public int update(CartDO cartDO, boolean isAllField) throws ServiceException {
		try {
			if (isAllField) {
				return (Integer) cartDAO.update(cartDO);
			} else {
				return (Integer) cartDAO.updateDynamic(cartDO);
			}
		} catch (DAOException e) {
			logger.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws ServiceException {
		try {
			return (Integer) cartDAO.deleteById(id);
		} catch (DAOException e) {
			logger.error(e);
			throw new ServiceException(e);
		}
	}

	// @Override
	// public int updateDynamic(CartDO cartDO) throws ServiceException {
	// try {
	// return (Integer) cartDAO.updateDynamic(cartDO);
	// }catch(DAOException e){
	// logger.error(e);
	// throw new ServiceException(e);
	// }
	// }

	@Override
	public CartDO selectById(Long id) throws ServiceException {
		try {
			return cartDAO.selectById(id);
		} catch (DAOException e) {
			logger.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public Long selectCountDynamic(CartDO cartDO) throws ServiceException {
		try {
			return cartDAO.selectCountDynamic(cartDO);
		} catch (DAOException e) {
			logger.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<CartDO> selectDynamic(CartDO cartDO) throws ServiceException {
		try {
			return cartDAO.selectDynamic(cartDO);
		} catch (DAOException e) {
			logger.error(e);
			throw new ServiceException(e);
		}
	}

	public Page<CartDO> queryPageListByCartDO(CartDO cartDO) {
		if (cartDO != null) {
			Long totalCount = this.selectCountDynamic(cartDO);
			List<CartDO> resultList = this.selectDynamic(cartDO);

			Page<CartDO> page = new Page<CartDO>();
			page.setPageNo(cartDO.getStartPage());
			page.setPageSize(cartDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			page.setList(resultList);
			return page;
		}
		return new Page<CartDO>();
	}

	public Page<CartDO> queryPageListByCartDOAndStartPageSize(CartDO cartDO, int startPage, int pageSize) {
		if (cartDO != null && startPage > 0 && pageSize > 0) {
			cartDO.setStartPage(startPage);
			cartDO.setPageSize(pageSize);
			return this.queryPageListByCartDO(cartDO);
		}
		return new Page<CartDO>();
	}

}
