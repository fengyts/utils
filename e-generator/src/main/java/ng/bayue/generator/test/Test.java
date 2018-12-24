package ng.bayue.generator.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.ShellRunner;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.PropertiesConfigLoader;
import ng.bayue.generator.constants.DbInformationSchemaSql;
import ng.bayue.generator.constants.GeneratorTemplate;
import ng.bayue.generator.gen.EntityGenerator;
import ng.bayue.generator.gen.factory.EntityGeneratorFactory;
import ng.bayue.generator.gen.factory.FactoryGenerator;
import ng.bayue.generator.gen.factory.FactoryProducer;
import ng.bayue.generator.gen.handler.TableInfoHandler;
import ng.bayue.generator.information.Column;
import ng.bayue.generator.information.ConstraintsInfo;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.template.model.FreemarkerDataModel;
import ng.bayue.generator.template.model.KeyInfoData;
import ng.bayue.generator.template.model.PackageData;
import ng.bayue.generator.template.model.TableEntityData;
import ng.bayue.generator.utils.GeneratorFileUtil;
import ng.bayue.generator.utils.JdbcUtil;
import ng.bayue.generator.utils.StringUtils;

public class Test {

	public static void initConfig() {
		String propFilePath = "src/test/metainfo.properties";
		PropertiesConfigLoader config = new PropertiesConfigLoader();
		config.loadPropertieFile(propFilePath);
	}

	public static void testGenerator() {
		// JavaTypeResolver resolver = new JavaTypeResolverDefaultImpl();
		// IntrospectedColumn introspectedColumn = new IntrospectedColumn();
		// introspectedColumn.setActualColumnName("test_pk_supplier");
		// introspectedColumn.setJdbcTypeName("int");
		// introspectedColumn.setJdbcType(4);
		// String jdbcType = resolver.calculateJdbcTypeName(introspectedColumn);
		// FullyQualifiedJavaType javaType =
		// resolver.calculateJavaType(introspectedColumn);
		// System.out.println(jdbcType);
		// System.out.println(javaType.getFullyQualifiedName());

		// ShellRunner r = new ShellRunner();
		String[] args = { "-configfile", "eGenerator.xml" };
		ShellRunner.main(args);
	}

	public static void testEG() {
		Context context = new Context();
		TableInfoHandler handler = new TableInfoHandler(context);
		String tableNamePattern = "test_key";
		// String tableNamePattern = "exchange_order_status";
		// String tableNamePattern = null;
		long timeStart = System.currentTimeMillis();
		List<TableInfo> tis = handler.introspectTable(tableNamePattern);
		long timeEnd = System.currentTimeMillis();
		System.out.println("耗时：" + (timeEnd - timeStart) + "ms");
		int count = 0;
		for (TableInfo ti : tis) {
			ConstraintsInfo constraintsInfo = ti.getConstraintsInfo();
			if (null == constraintsInfo) {
				count++;
				System.out.println("null:" + ti.getTableName());
			}
			String tableName = ti.getTableName();
			List<Column> columns = ti.getColumns();
			for (Column c : columns) {
				if (null == c) {
					System.out.println("null column:" + tableName);
				} else {
					if (StringUtils.isBlank(c.getJavaTypeInfo().getJavaTypeShort())) {
						System.out.println("null javaPropertyType:" + tableName + "-column:" + c.getColumnName());
					}
				}
			}
		}
		System.out.println(tis.size());
		System.out.println(count);
	}

	public static void testEGeneratorMethod() {
		Context context = new Context();
		TableInfoHandler handler = new TableInfoHandler(context);
		String tableNamePattern = "test_key";
		// String tableNamePattern = "exchange_order_status";
		long timeStart = System.currentTimeMillis();
		List<TableInfo> tis = handler.introspectTable(tableNamePattern);
		
		FactoryGenerator<EntityGenerator> factory = FactoryProducer.getFactory(EntityGeneratorFactory.class);
		EntityGenerator eg = factory.create(tis.get(0));
		eg.generate();
	}

	public static void testSqlExecute() {
		try {
			Connection conn = JdbcUtil.getConnection();
			final String dbSchema = "testeg";
			final String tableName = "test_key";
			final String sql = DbInformationSchemaSql.getSqlTableConstrains(dbSchema, true, true, tableName,
					"test_supplier");
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				String str = rs.getString(1);
				String str1 = rs.getString(2);
				String str2 = rs.getString(3);
				System.out.println(str + "-" + str1 + "-" + str2);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void testGenerateFile() {
		FreemarkerDataModel fdm = new FreemarkerDataModel();
		TableEntityData table = new TableEntityData();
		table.setTableName("test_key");
		table.setTableEntityName("TestKey");
		KeyInfoData keyInfo = new KeyInfoData();
		table.setKeyInfo(keyInfo);

		fdm.setTableEngityData(table);

		final String separator = File.separator;
		PackageData packageData = new PackageData();
		String basePackage = "ng" + separator + "bayue" + separator + "generator";
		packageData.setBasePackageName(basePackage);
		packageData.setEntityPackageName(basePackage + ".entity");
		packageData.setServicePackageName(basePackage + ".service");

		packageData.setBasePackageSavePath("abc.bayue.base");
		fdm.setPackageData(packageData);

		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("rootData", fdm);

		String rootPath = Test.class.getResource("/").getPath();

	}

	public static void main(String[] args) {
		initConfig();
		testEG();

	}

}
