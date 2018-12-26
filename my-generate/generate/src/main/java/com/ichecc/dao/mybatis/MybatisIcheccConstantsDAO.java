package com.ichecc.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Component;
import com.ichecc.dao.IcheccConstantsDAO;
import com.ichecc.dao.base.MybatisBaseDAO;
import com.ichecc.domain.IcheccConstantsDO;
import ng.bayue.exception.CommonDAOException;

@Component(value="icheccConstantsDAO")
public class MybatisIcheccConstantsDAO extends MybatisBaseDAO implements IcheccConstantsDAO {
	
	private static final String NAMESPACE = "com.ichecc.domain.IcheccConstantsMapper.MybatisIcheccConstantsDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(IcheccConstantsDO icheccConstantsDO) throws CommonDAOException {
		int i = getSqlSession().insert(getStatement("insert"), icheccConstantsDO);
		if (i > 0) {
			return Long.valueOf(icheccConstantsDO.getConstKey());
		}
		return 0L;
	}

	@Override
	public Integer update(IcheccConstantsDO icheccConstantsDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateById"), icheccConstantsDO);
	}

	@Override
	public Integer deleteById(Long id) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}
	
	@Override
	public int deleteByPrimaryKey(String primaryKey) throws CommonDAOException {
		return getSqlSession().delete(getStatement("deleteByPrimaryKey"), primaryKey);
	}

	@Override
	public Integer updateDynamic(IcheccConstantsDO icheccConstantsDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("update_dynamic"), icheccConstantsDO);
	}

	@Override
	public IcheccConstantsDO selectById(Long id) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}
	
	@Override
	public IcheccConstantsDO selectByPrimaryKey(String primaryKey) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("selectByPrimaryKey"), primaryKey);
	}
	
	@Override
	public int updateByPrimaryKey(IcheccConstantsDO icheccConstantsDO) throws CommonDAOException {
		return getSqlSession().update(getStatement("updateByPrimaryKey"), icheccConstantsDO);
	}

	@Override
	public Long selectCountDynamic(IcheccConstantsDO icheccConstantsDO) throws CommonDAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), icheccConstantsDO);
	}

	@Override
	public List<IcheccConstantsDO> selectDynamic(IcheccConstantsDO icheccConstantsDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), icheccConstantsDO);
	}

	@Override
	public List<IcheccConstantsDO> selectDynamicPageQuery(IcheccConstantsDO icheccConstantsDO) throws CommonDAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), icheccConstantsDO);
	}

}
