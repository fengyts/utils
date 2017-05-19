package ng.bayue.generator;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


public class JunitTest {

	SqlSessionFactory factory = null;

	@Before
	public void testBefore() {
		InputStream is;
		try {
			is = Resources.getResourceAsStream("");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test() {
		SqlSession session = factory.openSession();
	}

}
