package ng.bayue.generator.information;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ng.bayue.generator.config.Context;
import ng.bayue.generator.config.TableConfiguration;
import ng.bayue.generator.template.model.EntityProperty;
import ng.bayue.generator.template.model.KeyInfoData;
import ng.bayue.generator.utils.StringUtils;

/**
 * 表详细信息
 * @author lenovopc
 *
 */
public class TableInfo extends AbstractInfo {

	/** 表名 */
	private String tableName;

	/** 表注释  */
	private String comment;

	/** 对应列 */
	private List<Column> columns = new ArrayList<Column>();

	/** 表约束信息 */
	private ConstraintsInfo constraintsInfo;

	private Context context;

	private transient ColumnsInfoExtract extractInfo;

	public TableInfo(Context context) {
		this.context = context;
	}

	public TableConfiguration getTableConfiguration() {
		return context.getTableConfiguration(tableName);
	}

	public void initExtractInfo(List<Column> columns) {
		this.extractInfo = new ColumnsInfoExtract(columns);
	}

	public String getColumnStr() {
		return extractInfo.extractTableColumnsName();
	}

	public List<String> getImports() {
		return extractInfo.extractTableColumnsImports();
	}

	public List<EntityProperty> getEntityProperties() {
		return extractInfo.extractTableProperties();
	}

	public KeyInfoData getKeyInfo(boolean uniqueEnable) {
		KeyInfoData keyInfoData = new KeyInfoData();
		boolean unionPK = constraintsInfo.isUnionPK();
		keyInfoData.setUnionPK(unionPK);
		if (unionPK) {
			KeyInfoData.KeyInfo pk = new KeyInfoData.KeyInfo();
			List<Column> pkColumns = constraintsInfo.getPkInfo().getColumns();
			ColumnsInfoExtract cie = new ColumnsInfoExtract(pkColumns);

			pk.setProperties(cie.extractTableProperties());
			pk.setImports(cie.extractTableColumnsImports());
			pk.setKeyEntityName(humpFormat + "PrimaryKey");

			keyInfoData.setPrimaryKey(pk);
		}
		if (uniqueEnable) {
			Map<String, UniqueKeyInfo> uniqueInfosMap = constraintsInfo.getUniqueInfosMap();
			if (null != uniqueInfosMap && uniqueInfosMap.size() > 0) {
				keyInfoData.setHasUniqueKey(true);
				List<KeyInfoData.KeyInfo> uks = new ArrayList<KeyInfoData.KeyInfo>();
				final String uniqueSuffix = "Unique";
				for (Map.Entry<String, UniqueKeyInfo> entry : uniqueInfosMap.entrySet()) {
					KeyInfoData.KeyInfo uk = new KeyInfoData.KeyInfo();
					String key = entry.getKey();
					UniqueKeyInfo ukInfo = entry.getValue();
					List<Column> columns = ukInfo.getColumns();
					ColumnsInfoExtract cie = new ColumnsInfoExtract(columns);
					if (ukInfo.isUnionKey()) {
						key = StringUtils.toHumpFormat(key);
					} else {
						key = columns.get(0).getHumpFormat();
					}
					uk.setProperties(cie.extractTableProperties());
					uk.setImports(cie.extractTableColumnsImports());
					uk.setKeyEntityName(key + uniqueSuffix);

					uks.add(uk);
				}
				keyInfoData.setUniqueKey(uks);
			}
		} else {
			keyInfoData.setHasUniqueKey(false);
		}
		return keyInfoData;
	}

	public Column getColumnByName(String columnName) {
		if (StringUtils.isBlank(columnName)) {
			throw new NullPointerException();
		}
		for (Column c : columns) {
			if (columnName.equals(c.getColumnName())) {
				return c;
			}
		}
		return null;
	}

	public void addPrimaryKeyConstraints(Column... columns) {
		initTableConstraintsInfo();
		constraintsInfo.addPrimaryKeyColumn(columns);
	}

	public void addUniqueConstraints(String uniqueIndexName, Column column) {
		initTableConstraintsInfo();
		constraintsInfo.addUniqueInfo(uniqueIndexName, column);
	}

	private void initTableConstraintsInfo() {
		if (constraintsInfo == null) {
			constraintsInfo = new ConstraintsInfo();
		}
	}

	@Override
	public String getHumpFormat() {
		super.toHumpFormat(tableName);
		return humpFormat;
	}

	// ===================================
	// methods setter and getter

	public String getTableName() {
		return tableName;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public ConstraintsInfo getConstraintsInfo() {
		return constraintsInfo;
	}

	public void setConstraintsInfo(ConstraintsInfo constraintsInfo) {
		this.constraintsInfo = constraintsInfo;
	}

}
