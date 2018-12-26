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

	private transient KeyInfoData keyInfoData;

	public TableInfo(Context context) {
		this.context = context;
	}

	public TableConfiguration getTableConfiguration() {
		return context.getTableConfiguration(tableName);
	}

	public void initExtractInfo(List<Column> columns) {
		this.extractInfo = new ColumnsInfoExtract(columns);
		// initKeyInfo(getTableConfiguration().isUniqueEnable());
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

	public KeyInfoData getKeyInfo() {
		return keyInfoData;
	}

	public void initKeyInfo(boolean uniqueEnable) {
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
				int i = 0;
				for (Map.Entry<String, UniqueKeyInfo> entry : uniqueInfosMap.entrySet()) {
					KeyInfoData.KeyInfo uk = new KeyInfoData.KeyInfo();
					String key = "";
					UniqueKeyInfo ukInfo = entry.getValue();
					List<Column> columns = ukInfo.getColumns();
					ColumnsInfoExtract cie = new ColumnsInfoExtract(columns);
					boolean unionKey = ukInfo.isUnionKey();
					if (unionKey) {
						key = humpFormat + uniqueSuffix;
						if (0 < i) {
							key += i;
						}
						i++;
					} else {
						// 非联合键直接使用列名
						key = columns.get(0).getHumpFormat() + uniqueSuffix;
					}
					uk.setProperties(cie.extractTableProperties());
					uk.setImports(cie.extractTableColumnsImports());
					uk.setKeyEntityName(key);
					uk.setUnion(unionKey);

					uks.add(uk);
				}
				keyInfoData.setUniqueKey(uks);
			}
		} else {
			keyInfoData.setHasUniqueKey(false);
		}
		this.keyInfoData = keyInfoData;
		// return keyInfoData;
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
		return super.toHumpFormat(tableName);
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
