package com.meitun.salesorder.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import com.meitun.salesorder.dao.CityDAO;
import com.meitun.salesorder.domain.CityDO;
import com.meitun.salesorder.exception.DAOException;

@Component(value = "cityDAO")
public class MybatisCityDAO extends SqlSessionDaoSupport implements CityDAO {
	public Long insert(CityDO cityDO) throws DAOException {
		int i = getSqlSession().insert("com.meitun.salesorder.domain.CityMapper.MybatisCityDAO_insert", cityDO);
		if (i > 0) {
			return Long.valueOf(cityDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(CityDO cityDO) throws DAOException {
		return getSqlSession().update("com.meitun.salesorder.domain.CityMapper.MybatisCityDAO_updateById", cityDO);
	}

	@Override
	public Integer deleteById(Long id) throws DAOException {
		return getSqlSession().delete("com.meitun.salesorder.domain.CityMapper.MybatisCityDAO_deleteById", id);
	}

	@Override
	public Integer updateDynamic(CityDO cityDO) throws DAOException {
		return getSqlSession().update("com.meitun.salesorder.domain.CityMapper.MybatisCityDAO_update_dynamic", cityDO);
	}

	@Override
	public CityDO selectById(Long id) throws DAOException {
		return getSqlSession().selectOne("com.meitun.salesorder.domain.CityMapper.MybatisCityDAO_selectById", id);
	}

	@Override
	public Long selectCountDynamic(CityDO cityDO) throws DAOException {
		return getSqlSession().selectOne("com.meitun.salesorder.domain.CityMapper.MybatisCityDAO_select_dynamic_count", cityDO);
	}

	@Override
	public List<CityDO> selectDynamic(CityDO cityDO) throws DAOException {
		return getSqlSession().selectList("com.meitun.salesorder.domain.CityMapper.MybatisCityDAO_select_dynamic", cityDO);
	}

	@Override
	public List<CityDO> selectDynamicPageQuery(CityDO cityDO) throws DAOException {
		return getSqlSession().selectList("com.meitun.salesorder.domain.CityMapper.MybatisCityDAO_select_dynamic_page_query", cityDO);
	}

}
