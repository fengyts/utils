package com.lhs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.meitun.salesorder.dao.CityDAO;
import com.meitun.salesorder.domain.CityDO;
import com.meitun.salesorder.exception.DAOException;

public class TestDAO {

	public static void main(String[] args) throws DAOException {
		// ApplicationContext ctx = new
		// FileSystemXmlApplicationContext("E:\\workspace\\generate\\bin\\com\\lhs\\test\\ibatis-application.xml");
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"E:\\workspace\\generate\\bin\\com\\lhs\\test\\mybatis-application.xml");
		CityDAO cityDao = (CityDAO) ctx.getBean("cityDAO");
		CityDO city = cityDao.selectById(1L);

		System.out.println(city.toString());
		//
		// /******* insert test ********/
		// LhUserDO user = new LhUserDO();
		// user.setUserName("lhws");
		// user.setPassWord("pwd");
		// user.setGmtCreate(new Date());
		// user.setGmtModified(new Date());
		// long insert_id = lhUserDAO.insert(user);
		// System.out.println("insert_id:" + insert_id);
		//
		// /******* selectDynamic test ********/
		// LhUserDO user2 = new LhUserDO();
		// user2.setUserName("lhws");
		// List<LhUserDO> list = lhUserDAO.selectDynamic(user2);
		// System.out.println("selectDynamic:" + list.size());
		//
		// /******* selectById test ********/
		// Long userId = 2L;
		// LhUserDO user3 = lhUserDAO.selectById(userId);
		// if (user3 != null) {
		// System.out.println("selectById:" + user3.getPassWord());
		// }
		//
		// /******* update test ********/
		// user3.setUserName("中国人");
		// int update_count = lhUserDAO.update(user3);
		// System.out.println("update all:" + update_count);
		//
		// /******* updateDynamic test ********/
		// LhUserDO user4 = new LhUserDO();
		// user4.setId(4L);
		// user4.setUserName("username4");
		// user4.setGmtModified(new Date());
		// System.out.println("updateDynamic:" +
		// lhUserDAO.updateDynamic(user4));
		//
		// /******* selectCountDynamic test ********/
		// LhUserDO lhUserDO = new LhUserDO();
		// lhUserDO.setUserName("lhws");
		// long count = lhUserDAO.selectCountDynamic(lhUserDO);
		// System.out.println("selectCountDynamic:" + count);
		//
		// /******* selectDynamicPageQuery test ********/
		// LhUserDO user10 = new LhUserDO();
		// user10.setStartPage(1);
		// user10.setUserName("lhws");
		// List<LhUserDO> list2 = lhUserDAO.selectDynamicPageQuery(user10);
		// System.out.println("selectDynamicPageQuery:" + list2.size());
		//
		// /******* deleteById test ********/
		// System.out.println("deleteById:" + lhUserDAO.deleteById(insert_id));

		System.out.println(System.getProperty("path.separator"));
	}

}
