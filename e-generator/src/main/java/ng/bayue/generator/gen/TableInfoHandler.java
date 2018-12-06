package ng.bayue.generator.gen;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.TableConfiguration;
import ng.bayue.generator.constants.ColumnConstraintType;
import ng.bayue.generator.model.Column;
import ng.bayue.generator.model.TableInfo;
import ng.bayue.generator.types.GenericJdbcTypeMapper;
import ng.bayue.generator.types.handler.GenericTypeHandler;
import ng.bayue.generator.utils.JdbcUtil;
import ng.bayue.generator.utils.StringUtils;

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
			executeOrigain(results, metaData, param);
			// execute(results, metaData, param);
			// executeTask(results, metaData, param);

			JdbcUtil.closeConnection(conn);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void executeOrigain(final List<TableInfo> tis, final DatabaseMetaData metaData, final Param paramO)
			throws SQLException {
		for (TableInfo ti : tis) {
			paramO.setTableNamePattern(ti.getTableName());
			getColumns(metaData, paramO, ti);
			getConstraintInfo(metaData, paramO, ti);
		}
	}

	private void executeTask(final List<TableInfo> tis, final DatabaseMetaData metaDataO, final Param paramO)
			throws Exception {
		if (null == tis || tis.size() == 0) {
			throw new NullPointerException("表不存在");
		}
		int perThreadHandleSize = HandleThreadPool.SIZE;
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
					final int size = perListTask.size();
					TableInfo ti;
					Param param;
					DatabaseMetaData metaData = conn.getMetaData();
					for (int i = 0; i < size; i++) {
						ti = perListTask.get(i);
						param = new Param();
						param.setTableNamePattern(ti.getTableName());
						param.setCatalog(paramO.getCatalog());
						param.setSchemaPattern(paramO.getSchemaPattern());
						param.setColumnNamePattern("%");

						getColumns(metaData, param, ti);
						getConstraintInfo(metaData, param, ti);
					}
					JdbcUtil.closeConnection(conn);
					return null;
				}
			};
			tasks.add(task);
		}

		ExecutorService executor = HandleThreadPool.getFixedThreadPool();
		List<Future<List<TableInfo>>> invokeAll = executor.invokeAll(tasks);

		// List<TableInfo> results = new ArrayList<TableInfo>();
		// for (Future<List<TableInfo>> f : invokeAll) {
		// results.addAll(f.get());
		// }

		executor.shutdown();
	}

	private void execute(final List<TableInfo> tis, final DatabaseMetaData metaData, final Param paramO) {
		if (null == tis || tis.size() == 0) {
			throw new NullPointerException("表不存在");
		}
		final int lenSrc = tis.size();
		int stepLen = HandleThreadPool.SIZE;
		int taskNum = lenSrc / stepLen;
		int surplus = lenSrc % stepLen;
		if (0 == taskNum) {
			taskNum = 1;
		}
		if (lenSrc <= stepLen) {
			stepLen = lenSrc;
			surplus = 0;
		}
		int tempStart = 0, tempEnd = stepLen;
		ExecutorService executor = HandleThreadPool.getFixedThreadPool();
		for (int i = 1; i <= taskNum; i++) {
			tempStart = (i - 1) * stepLen;
			tempEnd = i * stepLen;
			if (i == taskNum) {
				tempEnd += surplus;
			}
			final int indexStart = tempStart;
			final int indexEnd = tempEnd;

			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						TableInfo ti;
						Param param;
						for (int i = indexStart; i < indexEnd; i++) {
							ti = tis.get(i);
							param = new Param();
							param.setTableNamePattern(ti.getTableName());
							param.setCatalog(paramO.getCatalog());
							param.setSchemaPattern(paramO.getSchemaPattern());
							param.setColumnNamePattern("%");

							getColumns(metaData, param, ti);
							getConstraintInfo(metaData, param, ti);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
		executor.shutdown();
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
		GenericTypeHandler handler = new GenericTypeHandler();
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
			String javaTypeName = handler.getJavaTypeName(jdbcTypeName);
			column.setColumnName(columnName);
			column.setDefaultValue(columnDefaultVal);
			column.setComment(remarks);
			column.setJdbcTypeName(jdbcTypeName);
			column.setJavaPropertyType(javaTypeName);
			column.setJavaPropertyName(StringUtils.toHumpFormat(columnName));

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

	private TableInfo getPKInfo(DatabaseMetaData metaData, Param param, TableInfo tableInfo) throws SQLException {
		TableInfo rti = tableInfo;
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
		rti.addPrimaryKeyConstraints(columns.toArray(new Column[0]));
		closeResultSet(primaryKeys);
		return rti;
	}

	private void getUniqueInfo(DatabaseMetaData metaData, Param param, boolean isOnlyUnique, TableInfo tableInfo)
			throws SQLException {
		String tableNamePattern = param.getTableNamePattern();
		ResultSet indexInfo = metaData.getIndexInfo(param.getCatalog(), param.getSchemaPattern(), tableNamePattern,
				isOnlyUnique, false);
		Column column;
		while (indexInfo.next()) {
			String indexName = indexInfo.getString("INDEX_NAME");
			if (ColumnConstraintType.PRIMAY_KEY.constraintName.equalsIgnoreCase(indexName)) {
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

	private static class HandleThreadPool {
		private static final int SIZE = 5;
		private static volatile ExecutorService fixedThreadPool;

		public static ExecutorService getFixedThreadPool() {
			if (fixedThreadPool == null) {
				synchronized (HandleThreadPool.class) {
					if (fixedThreadPool == null) {
						fixedThreadPool = Executors.newFixedThreadPool(SIZE);
					}
				}
			}
			return fixedThreadPool;
		}
	}

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
