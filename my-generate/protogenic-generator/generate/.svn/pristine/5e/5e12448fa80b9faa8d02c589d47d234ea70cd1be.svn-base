package com.meitun.salesorder.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import com.meitun.salesorder.dao.CartDAO;
import com.meitun.salesorder.domain.CartDO;
import com.meitun.salesorder.exception.DAOException;

@Component(value = "cartDAO")
public class MybatisCartDAO extends SqlSessionDaoSupport implements CartDAO {
	public Long insert(CartDO cartDO) throws DAOException {
		int i = getSqlSession().insert("com.meitun.salesorder.domain.CartMapper.MybatisCartDAO_insert", cartDO);
		if (i > 0) {
			return Long.valueOf(cartDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(CartDO cartDO) throws DAOException {
		return getSqlSession().update("com.meitun.salesorder.domain.CartMapper.MybatisCartDAO_updateById", cartDO);
	}

	@Override
	public Integer deleteById(Long id) throws DAOException {
		return getSqlSession().delete("com.meitun.salesorder.domain.CartMapper.MybatisCartDAO_deleteById", id);
	}

	@Override
	public Integer updateDynamic(CartDO cartDO) throws DAOException {
		return getSqlSession().update("com.meitun.salesorder.domain.CartMapper.MybatisCartDAO_update_dynamic", cartDO);
	}

	@Override
	public CartDO selectById(Long id) throws DAOException {
		return getSqlSession().selectOne("com.meitun.salesorder.domain.CartMapper.MybatisCartDAO_selectById", id);
	}

	@Override
	public Long selectCountDynamic(CartDO cartDO) throws DAOException {
		return getSqlSession().selectOne("com.meitun.salesorder.domain.CartMapper.MybatisCartDAO_select_dynamic_count", cartDO);
	}

	@Override
	public List<CartDO> selectDynamic(CartDO cartDO) throws DAOException {
		return getSqlSession().selectList("com.meitun.salesorder.domain.CartMapper.MybatisCartDAO_select_dynamic", cartDO);
	}

	@Override
	public List<CartDO> selectDynamicPageQuery(CartDO cartDO) throws DAOException {
		return getSqlSession().selectList("com.meitun.salesorder.domain.CartMapper.MybatisCartDAO_select_dynamic_page_query", cartDO);
	}

}
