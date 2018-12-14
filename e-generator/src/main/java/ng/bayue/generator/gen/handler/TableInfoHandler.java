package ng.bayue.generator.gen.handler;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.TableConfiguration;
import ng.bayue.generator.constants.ConstraintType;
import ng.bayue.generator.information.Column;
import ng.bayue.generator.information.TableInfo;
import ng.bayue.generator.types.GenericJdbcTypeMapper;
import ng.bayue.generator.types.handler.GenericTypeHandler;
import ng.bayue.generator.utils.JdbcUtil;
import ng.bayue.generator.utils.StringUtils;
import ng.bayue.generator.utils.ThreadPoolUtil;

public class TableInfoHandler {

	private Context context;

	public TableInfoHandler(Context context) {
		this.context = context;
	}

	public List<TableInfo> introspectTable(String tableNamePattern) {
		try {
			Connection conn = JdbcUtil.getConnection();
			DatabaseMetaData metaData = conn.getMetaData();
			final String catalog = conn.getCatalog();
			final String schema = conn.getSchema();
			if (StringUtils.isBlank(catalog)) {
				throw new NullPointerException();
			}
			if (StringUtils.isBlank(tableNamePattern)) {
				tableNamePattern = "%";
			}

			final Param param = new Param();
			param.setCatalog(catalog);
			param.setSchemaPattern(schema);
			param.setTableNamePattern(tableNamePattern);
			param.setColumnNamePattern("%");

			List<TableInfo> results = getTableInfo(metaData, param);
			// executeOrigain(results, metaData, param);
			results = executeTask(results, metaData, param);

			JdbcUtil.closeConnection(conn);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unused")
	private void executeOrigain(final List<TableInfo> tis, final DatabaseMetaData metaData, final Param paramO)
			throws SQLException {
		for (TableInfo ti : tis) {
			paramO.setTableNamePattern(ti.getTableName());
			getColumns(metaData, paramO, ti);
			getConstraintInfo(metaData, paramO, ti);
		}
	}

	private List<TableInfo> executeTask(final List<TableInfo> tis, final DatabaseMetaData metaData, final Param paramO)
			throws Exception {
		if (null == tis || tis.size() == 0) {
			throw new NullPointerException("表不存在");
		}
		int perThreadHandleSize = 4;
		int totalDataSize = tis.size();

		int threadNum = totalDataSize / perThreadHandleSize;
		if (totalDataSize % perThreadHandleSize != 0) {
			threadNum += 1;
		}

		// 任务集合
		List<Callable<List<TableInfo>>> tasks = new ArrayList<Callable<List<TableInfo>>>();
		Callable<List<TableInfo>> task;
		List<TableInfo> perList;

		// 分割数据
		for (int i = 0; i < threadNum; i++) {
			if (i == threadNum - 1) {
				perList = tis.subList(perThreadHandleSize * i, totalDataSize);
			} else {
				perList = tis.subList(perThreadHandleSize * i, perThreadHandleSize * (i + 1));
			}
			final List<TableInfo> perListTask = perList;
			task = new Callable<List<TableInfo>>() {
				private Connection conn = JdbcUtil.getConnection();

				@Override
				public List<TableInfo> call() throws Exception {
					List<TableInfo> taskRes = new ArrayList<TableInfo>(); // 结果集
					final int size = perListTask.size();
					Param param;
					DatabaseMetaData metaData = conn.getMetaData();
					for (int i = 0; i < size; i++) {
						TableInfo ti;
						ti = perListTask.get(i);
						param = new Param();
						param.setTableNamePattern(ti.getTableName());
						param.setCatalog(paramO.getCatalog());
						param.setSchemaPattern(paramO.getSchemaPattern());
						param.setColumnNamePattern("%");

						getColumns(metaData, param, ti);
						getConstraintInfo(metaData, param, ti);
						taskRes.add(ti);
					}
					JdbcUtil.closeConnection(conn);
					return taskRes;
				}
			};
			tasks.add(task);
		}

		// ExecutorService executor = HandleThreadPool.getFixedThreadPool();
		ExecutorService executor = ThreadPoolUtil.getFixedThreadPool();
		List<Future<List<TableInfo>>> invokeAll = executor.invokeAll(tasks);

		// 汇总结果集
		List<TableInfo> results = new ArrayList<TableInfo>();
		for (Future<List<TableInfo>> f : invokeAll) {
			results.addAll(f.get());
		}
		executor.shutdown();
		return results;
	}

	private List<TableInfo> getTableInfo(DatabaseMetaData metaData, Param param) throws SQLException {
		ResultSet tbRs = metaData.getTables(param.getCatalog(), param.getSchemaPattern(), param.getTableNamePattern(),
				null);// String[] types = new String[] { "TABLE" }
		List<TableInfo> results = new ArrayList<TableInfo>();
		TableInfo tableInfo;
		while (tbRs.next()) {
			tableInfo = new TableInfo(context);
			String tableComment = tbRs.getString("REMARKS");
			String tableName = tbRs.getString("TABLE_NAME");
			tableInfo.setTableName(tableName);
			tableInfo.setComment(tableComment);
			results.add(tableInfo);
		}
		closeResultSet(tbRs);
		return results;
	}

	private void getColumns(DatabaseMetaData metaData, Param param, TableInfo tableInfo) throws SQLException {
		if (null == tableInfo || null == param || null == metaData) {
			throw new NullPointerException();
		}
		ResultSet rs = metaData.getColumns(param.getCatalog(), param.getSchemaPattern(), param.getTableNamePattern(),
				param.getColumnNamePattern());

		List<Column> columns = new ArrayList<Column>();
		Column column;
		// GenericTypeHandler handler = new GenericTypeHandler();
		while (rs.next()) {
			column = new Column();
			int jdbcType = rs.getInt("DATA_TYPE");
			// int columnSize = rs.getInt("COLUMN_SIZE");
			// String tableName = rs.getString("TABLE_NAME");
			String columnName = rs.getString("COLUMN_NAME");
			// boolean nullAble =
			// rs.getInt("NULLABLE")==DatabaseMetaData.columnNullable;
			// int decimalDigits = rs.getInt("DECIMAL_DIGITS");
			String remarks = rs.getString("REMARKS");
			String columnDefaultVal = rs.getString("COLUMN_DEF");
			// String isAutoIncrement = rs.getString("IS_AUTOINCREMENT");
			// String isGeneratedColumn = rs.getString("IS_GENERATEDCOLUMN");

			String jdbcTypeName = GenericJdbcTypeMapper.getJdbcTypeName(jdbcType);
			String javaTypeName = GenericTypeHandler.getJavaTypeName(jdbcTypeName);
			column.setColumnName(columnName);
			column.setDefaultValue(columnDefaultVal);
			column.setComment(remarks);
			column.setJdbcTypeName(jdbcTypeName);
			column.setJavaPropertyType(javaTypeName);
			// column.setJavaPropertyName(StringUtils.toHumpFormat(columnName));

			columns.add(column);
		}
		tableInfo.setColumns(columns);
		closeResultSet(rs);
	}

	private void getConstraintInfo(DatabaseMetaData metaData, Param param, TableInfo tableInfo) throws SQLException {
		getPKInfo(metaData, param, tableInfo);
		TableConfiguration tc = context.getTableConfiguration(param.getTableNamePattern());
		boolean uniqueEnable = null == tc ? false : tc.isUniqueEnable();
		if (uniqueEnable) {
			getUniqueInfo(metaData, param, true, tableInfo);
		}
	}

	private void getPKInfo(DatabaseMetaData metaData, Param param, TableInfo tableInfo) throws SQLException {
		ResultSet primaryKeys = metaData.getPrimaryKeys(param.getCatalog(), param.getSchemaPattern(),
				param.getTableNamePattern());
		List<Column> columns = new ArrayList<Column>();
		Column column;
		while (primaryKeys.next()) {
			String columnName = primaryKeys.getString("COLUMN_NAME");
			// short keySeq = primaryKeys.getShort("KEY_SEQ");
			column = tableInfo.getColumnByName(columnName);
			// info.addPrimaryKeyConstraints(column);
			columns.add(column);
		}
		tableInfo.addPrimaryKeyConstraints(columns.toArray(new Column[0]));
		closeResultSet(primaryKeys);
	}

	private void getUniqueInfo(DatabaseMetaData metaData, Param param, boolean isOnlyUnique, TableInfo tableInfo)
			throws SQLException {
		String tableNamePattern = param.getTableNamePattern();
		ResultSet indexInfo = metaData.getIndexInfo(param.getCatalog(), param.getSchemaPattern(), tableNamePattern,
				isOnlyUnique, false);
		Column column;
		while (indexInfo.next()) {
			String indexName = indexInfo.getString("INDEX_NAME");
			if (ConstraintType.PRIMAY_KEY.constraintName.equalsIgnoreCase(indexName)) {
				continue;
			}
			String columnName = indexInfo.getString("COLUMN_NAME");
			column = tableInfo.getColumnByName(columnName);
			tableInfo.addUniqueConstraints(indexName, column);
		}
		closeResultSet(indexInfo);
	}

	private void closeResultSet(ResultSet rs) {
		try {
			JdbcUtil.closeResultSet(rs);
		} catch (Exception e) {
		}
	}

	// private static class HandleThreadPool {
	// private static final int SIZE = 8;
	// private static volatile ExecutorService fixedThreadPool;
	//
	// public static ExecutorService getFixedThreadPool() {
	// if (fixedThreadPool == null) {
	// synchronized (HandleThreadPool.class) {
	// if (fixedThreadPool == null) {
	// fixedThreadPool = Executors.newFixedThreadPool(SIZE);
	// }
	// }
	// }
	// return fixedThreadPool;
	// }
	// }

	private static class Param {
		private String catalog;
		private String schemaPattern;
		private String tableNamePattern;
		private String columnNamePattern;

		public String getCatalog() {
			return catalog;
		}

		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}

		public String getSchemaPattern() {
			return schemaPattern;
		}

		public void setSchemaPattern(String schemaPattern) {
			this.schemaPattern = schemaPattern;
		}

		public String getTableNamePattern() {
			return tableNamePattern;
		}

		public void setTableNamePattern(String tableNamePattern) {
			this.tableNamePattern = tableNamePattern;
		}

		public String getColumnNamePattern() {
			return columnNamePattern;
		}

		public void setColumnNamePattern(String columnNamePattern) {
			this.columnNamePattern = columnNamePattern;
		}

	}

}
