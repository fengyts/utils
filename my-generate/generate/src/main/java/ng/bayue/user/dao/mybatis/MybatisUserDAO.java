package ng.bayue.user.dao.mybatis;
import java.util.List;

import org.springframework.stereotype.Component;
import ng.bayue.user.dao.UserDAO;
import ng.bayue.user.domain.UserDO;
import ng.bayue.exception.DAOException;

@Component(value="userDAO")
public class MybatisUserDAO extends MybatisBaseDAO implements UserDAO {
	
	private static final String NAMESPACE = "ng.bayue.user.domain.UserMapper.MybatisUserDAO_";
	
	private static String getStatement (String operation){
		return NAMESPACE + operation;
	}
	
	public Long insert(UserDO userDO) throws DAOException {
		int i = getSqlSession().insert(getStatement("insert"), userDO);
		if (i > 0) {
			return Long.valueOf(userDO.getId());
		}
		return 0L;
	}

	@Override
	public Integer update(UserDO userDO) throws DAOException {
		return getSqlSession().update(getStatement("updateById"), userDO);
	}

	@Override
	public Integer deleteById(Long id) throws DAOException {
		return getSqlSession().delete(getStatement("deleteById"), id);
	}

	@Override
	public Integer updateDynamic(UserDO userDO) throws DAOException {
		return getSqlSession().update(getStatement("update_dynamic"), userDO);
	}

	@Override
	public UserDO selectById(Long id) throws DAOException {
		return getSqlSession().selectOne(getStatement("selectById"), id);
	}

	@Override
	public Long selectCountDynamic(UserDO userDO) throws DAOException {
		return getSqlSession().selectOne(getStatement("select_dynamic_count"), userDO);
	}

	@Override
	public List<UserDO> selectDynamic(UserDO userDO) throws DAOException {
		return getSqlSession().selectList(getStatement("select_dynamic"), userDO);
	}

	@Override
	public List<UserDO> selectDynamicPageQuery(UserDO userDO) throws DAOException {
		return getSqlSession().selectList(getStatement("select_dynamic_page_query"), userDO);
	}

}
