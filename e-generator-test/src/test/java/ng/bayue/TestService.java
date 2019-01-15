package ng.bayue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

import ng.bayue.generator.exception.DAOException;
import ng.bayue.generator.mybatis.dao.TestGeneratorDAO;
import ng.bayue.generator.mybatis.model.TestGenerator;
import ng.bayue.generator.mybatis.model.TestGeneratorPrimaryKey;
import ng.bayue.generator.service.TestGeneratorService;
import ng.bayue.test.LettersAndNumberUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context.xml" })
public class TestService {

	@Autowired
	private TestGeneratorService generatorService;
	@Autowired
	private TestGeneratorDAO testGeneratorDAO;

	private void testInsert() {
		try {
			TestGenerator param = new TestGenerator();
			param.setOrderByClause("id desc,pk_id desc");
			Long itemId = 0L;
			List<TestGenerator> latest = testGeneratorDAO.selectDynamic(param);
			if (null != latest) {
				TestGenerator latestObj = latest.get(0);
				itemId = latestObj.getItemId();
			}

			TestGenerator obj = new TestGenerator();
			obj.setAddress("address");
			obj.setPkId(1);
			obj.setSpecGroupId(1L);
			obj.setUnionId(3L);
			obj.setUserId(3L);
			obj.setItemId(++itemId);
			obj.setOrderNo(LettersAndNumberUtil.getRandomStr(8));
			obj.setTradeAmount(new BigDecimal(100));
			obj.setItemName(LettersAndNumberUtil.getRandomStr(8));
			obj.setCreateTime(new Date());
			obj.setTestFk(1L);

			TestGenerator obj1 = new TestGenerator();
			obj1.setAddress("address-" + LettersAndNumberUtil.getRandomStr(8));
			obj1.setPkId(1);
			obj1.setSpecGroupId(1L);
			obj1.setUnionId(3L);
			obj1.setUserId(3L);
			obj1.setItemId(++itemId);
			obj1.setOrderNo(LettersAndNumberUtil.getRandomStr(8));
			obj1.setTradeAmount(new BigDecimal(100));
			obj1.setItemName(LettersAndNumberUtil.getRandomStr(8));
			obj1.setCreateTime(new Date());
			obj1.setTestFk(1L);

			List<TestGenerator> list = new ArrayList<TestGenerator>();
			list.add(obj);
			list.add(obj1);
			int r = testGeneratorDAO.insertBatch(list);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testSelect() {
		try {
			List<TestGeneratorPrimaryKey> pkLists = new ArrayList<TestGeneratorPrimaryKey>();
			TestGeneratorPrimaryKey pk1 = new TestGeneratorPrimaryKey();
			pk1.setId(3L);
			pk1.setPkId(1);
			TestGeneratorPrimaryKey pk2 = new TestGeneratorPrimaryKey();
			pk2.setId(6L);
			pk2.setPkId(1);
			pkLists.add(pk1);
			pkLists.add(pk2);
			List<TestGenerator> selectBatch = testGeneratorDAO.selectBatchByPrimaryKey(pkLists);
			System.out.println(selectBatch);
			printObj(selectBatch);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testSelectPageQuery() {
		try {
			TestGenerator obj = new TestGenerator();
			// obj.setId(3L);
			List<TestGenerator> pageList = testGeneratorDAO.selectDynamicPageQuery(obj);
			System.out.println(pageList);
			printObj(pageList);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	private void testUpdate() {
		try {
			TestGenerator obj = new TestGenerator();
			obj.setId(7L);
			obj.setPkId(1);
			obj.setTradeAmount(new BigDecimal(88.00));
			int d = testGeneratorDAO.updateByPrimaryKeyDynamic(obj);
			System.out.println(d);

			// List<TestGenerator> updatePks = new ArrayList<TestGenerator>();
			// TestGenerator uObj = new TestGenerator();
			// uObj.setId(3L);
			// uObj.setPkId(1);
			// uObj.setTradeAmount(new BigDecimal(50.00));
			// TestGenerator uObj1 = new TestGenerator();
			// uObj1.setId(6L);
			// uObj1.setPkId(1);
			// uObj1.setTradeAmount(new BigDecimal(80.00));
			// updatePks.add(uObj);
			// updatePks.add(uObj1);
			// int ur = testGeneratorDAO.updateBatchByPrimaryKey(updatePks);
			// System.out.println(ur);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	private void testDelete() {
		try {
			List<TestGeneratorPrimaryKey> pkLists = new ArrayList<TestGeneratorPrimaryKey>();
			TestGeneratorPrimaryKey pk1 = new TestGeneratorPrimaryKey();
			pk1.setId(7L);
			pk1.setPkId(1);
			TestGeneratorPrimaryKey pk2 = new TestGeneratorPrimaryKey();
			pk2.setId(11L);
			pk2.setPkId(1);
			pkLists.add(pk1);
			pkLists.add(pk2);
			int d = testGeneratorDAO.deleteBatchByPrimaryKey(pkLists);
			System.out.println(d);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDAO() {
		try {
			// testInsert();
			// testSelect();
			// testSelectPageQuery();
			// testUpdate();
			testDelete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testService() {
		try {
			TestGenerator obj = new TestGenerator();
			obj.setAddress("address");
			obj.setId(1L);
			obj.setPkId(1);
			obj.setSpecGroupId(1L);
			obj.setUnionId(1L);
			obj.setUserId(2L);
			obj.setItemId(3L);
			obj.setOrderNo("abc");
			obj.setTradeAmount(new BigDecimal(100));
			obj.setItemName("itemName");
			obj.setCreateTime(new Date());
			obj.setTestFk(1L);
			// TestGeneratorPrimaryKey pk = generatorService.insert(obj);
			//
			// TestGeneratorPrimaryKey primaryKey = new
			// TestGeneratorPrimaryKey(1L, 1);
			// TestGenerator objR =
			// generatorService.selectByPrimaryKey(primaryKey);
			//
			// printObj(objR);
			// System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printObj(Object o) {
		String str = JSONObject.toJSONString(o);
		System.out.println(str);
	}

	private static void printObj(List<?> list) {
		for (Object o : list) {
			printObj(o);
		}
	}

}
