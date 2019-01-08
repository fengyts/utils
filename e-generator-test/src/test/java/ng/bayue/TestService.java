package ng.bayue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

import ng.bayue.generator.exception.DAOException;
import ng.bayue.generator.exception.ServiceException;
import ng.bayue.generator.mybatis.dao.TestGeneratorDAO;
import ng.bayue.generator.mybatis.model.TestGenerator;
import ng.bayue.generator.mybatis.model.TestGeneratorPrimaryKey;
import ng.bayue.generator.service.TestGeneratorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context.xml" })
public class TestService {
	
	@Autowired
	private TestGeneratorService generatorService;
	@Autowired
	private TestGeneratorDAO testGeneratorDAO;
	
	@Test
	public void testService(){
		try {
			TestGenerator obj = new TestGenerator();
			obj.setAddress("address");
			obj.setId(1L);
			obj.setPk1(1);
			obj.setSpecGroupId(1L);
			obj.setUnionId(1L);
			obj.setUserId(2L);
			obj.setItemId(3L);
			obj.setOrderNo("abc");
			obj.setTradeAmount(new BigDecimal(100));
			obj.setItemName("itemName");
			obj.setCreateTime(new Date());
			obj.setTestFk(1L);
//			TestGeneratorPrimaryKey pk = generatorService.insert(obj);
//			
			TestGeneratorPrimaryKey primaryKey = new TestGeneratorPrimaryKey(1L, 1);
			TestGenerator objR = generatorService.selectByPrimaryKey(primaryKey);
			
			printObj(objR);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printObj(Object o){
		String str = JSONObject.toJSONString(o);
		System.out.println(str);
	}

}
