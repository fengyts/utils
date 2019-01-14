package ng.bayue.generator.information;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	private String getEntityPackageName() {
		return context.getGlobalConfiguration().getPackageData().getEntityPackageName();
	}

	public void initExtractInfo(List<Column> columns) {
		this.extractInfo = new ColumnsInfoExtract(columns);
		// initKeyInfo(getTableConfiguration().isUniqueEnable());
	}

	public String getColumnStr() {
		return extractInfo.extractTableColumnsName();
	}

	public Set<String> getImports() {
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
		KeyInfoData.KeyInfo pk = new KeyInfoData.KeyInfo();
		pk.setIsUnion(unionPK);

		List<Column> pkColumns = constraintsInfo.getPkInfo().getColumns();
		ColumnsInfoExtract ciePK = new ColumnsInfoExtract(pkColumns);
		pk.setImports(ciePK.extractTableColumnsImports());
		pk.setProperties(ciePK.extractTableProperties());
		if (unionPK) { // 联合列主键
			String keyClassSimpleName = StringUtils.upperCaseCapitalLetter(humpFormat + "PrimaryKey");
			pk.setKeyClassSimpleName(keyClassSimpleName);
			pk.setKeyClassFullyName(getEntityPackageName() + "." + keyClassSimpleName);
		} else { // 单一列主键
			Column pkColumn = pkColumns.get(0);
			pk.setKeyClassSimpleName(pkColumn.getJavaTypeInfo().getJavaTypeShort());
			pk.setKeyClassFullyName(pkColumn.getJavaTypeInfo().getJavaTypeFully());
		}
		keyInfoData.setPrimaryKey(pk);

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
					ColumnsInfoExtract cieUK = new ColumnsInfoExtract(columns);
					boolean unionKey = ukInfo.isUnionKey();
					String keyClassFullyName = "";
					if (unionKey) {
						key = humpFormat + uniqueSuffix;
						if (0 < i) {
							key += i;
						}
						i++;
						keyClassFullyName = getEntityPackageName() + "." + StringUtils.upperCaseCapitalLetter(key);
					} else {
						// 非联合键直接使用列名
						Column column = columns.get(0);
						key = column.getHumpFormat() + uniqueSuffix;
						keyClassFullyName = column.getJavaTypeInfo().getJavaTypeFully();
					}
					uk.setProperties(cieUK.extractTableProperties());
					uk.setImports(cieUK.extractTableColumnsImports());
					uk.setKeyClassSimpleName(key);
					uk.setKeyClassFullyName(keyClassFullyName);
					uk.setIsUnion(unionKey);

					uks.add(uk);
				}
				keyInfoData.setUniqueKey(uks);
			}
		} else {
			keyInfoData.setHasUniqueKey(false);
		}
		this.keyInfoData = keyInfoData;
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
		if (StringUtils.isNotBlank(humpFormat)) {
			return humpFormat;
		}
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
