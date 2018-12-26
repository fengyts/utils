package com.ichecc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ichecc.dao.IcheccConstantsDAO;
import com.ichecc.domain.IcheccConstantsDO;
import com.ichecc.service.IcheccConstantsService;
import ng.bayue.exception.CommonDAOException;
import ng.bayue.exception.CommonServiceException;
import ng.bayue.common.Page;

@Service(value="icheccConstantsService")
public class IcheccConstantsServiceImpl  implements IcheccConstantsService{

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private IcheccConstantsDAO icheccConstantsDAO;

	@Override
	public Long insert(IcheccConstantsDO icheccConstantsDO) throws CommonServiceException {
		try {
			return icheccConstantsDAO.insert(icheccConstantsDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public int update(IcheccConstantsDO icheccConstantsDO,boolean isAllField) throws CommonServiceException {
		try {
			if(isAllField){
				return (Integer) icheccConstantsDAO.update(icheccConstantsDO);
			}else{
				return (Integer) icheccConstantsDAO.updateDynamic(icheccConstantsDO);
			}
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public int deleteById(Long id) throws CommonServiceException {
		try {
			return (Integer) icheccConstantsDAO.deleteById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public int deleteByPrimaryKey(String primaryKey) throws CommonServiceException {
		try {
			return (Integer) icheccConstantsDAO.deleteByPrimaryKey(primaryKey);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}


	@Override
	public IcheccConstantsDO selectById(Long id) throws CommonServiceException {
		try {
			return icheccConstantsDAO.selectById(id);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public IcheccConstantsDO selectByPrimaryKey(String primaryKey) throws CommonServiceException {
		try {
			return icheccConstantsDAO.selectByPrimaryKey(primaryKey);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public int updateByPrimaryKey(IcheccConstantsDO icheccConstantsDO) throws CommonServiceException {
		try {
			return icheccConstantsDAO.updateByPrimaryKey(icheccConstantsDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public Long selectCountDynamic(IcheccConstantsDO icheccConstantsDO) throws CommonServiceException {
		try {
			return icheccConstantsDAO.selectCountDynamic(icheccConstantsDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}

	@Override
	public List<IcheccConstantsDO> selectDynamic(IcheccConstantsDO icheccConstantsDO) throws CommonServiceException {
		try {
			return icheccConstantsDAO.selectDynamic(icheccConstantsDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	

	private List<IcheccConstantsDO> selectDynamicPageQuery(IcheccConstantsDO icheccConstantsDO) throws CommonServiceException {
		try {
			return icheccConstantsDAO.selectDynamicPageQuery(icheccConstantsDO);
		}catch(CommonDAOException e){
			logger.error(e);
            throw new CommonServiceException(e);
		}
	}
	
	@Override
	public Page<IcheccConstantsDO> queryPageListDynamic(IcheccConstantsDO icheccConstantsDO) throws CommonServiceException{
		if (icheccConstantsDO != null) {
			Long totalCount = this.selectCountDynamic(icheccConstantsDO);

			Page<IcheccConstantsDO> page = new Page<IcheccConstantsDO>();
			page.setPageNo(icheccConstantsDO.getStartPage());
			page.setPageSize(icheccConstantsDO.getPageSize());
			page.setTotalCount(totalCount.intValue());
			
			if(null != totalCount && totalCount.longValue() > 0){
				List<IcheccConstantsDO> resultList = this.selectDynamicPageQuery(icheccConstantsDO);
				page.setList(resultList);
			}
			return page;
		}
		return new Page<IcheccConstantsDO>();
	}
	
	@Override
	public Page<IcheccConstantsDO> queryPageListDynamicAndStartPageSize(IcheccConstantsDO icheccConstantsDO, Integer startPage, Integer pageSize) throws CommonServiceException {
		if (icheccConstantsDO != null && startPage>0 && pageSize>0) {
			icheccConstantsDO.setStartPage(startPage);
			icheccConstantsDO.setPageSize(pageSize);
			return this.queryPageListDynamic(icheccConstantsDO);
		}
		return new Page<IcheccConstantsDO>();
	}
	
	
}
