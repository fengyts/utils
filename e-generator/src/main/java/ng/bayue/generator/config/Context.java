package ng.bayue.generator.config;

import java.util.Map;

import ng.bayue.generator.utils.StringUtils;

/**
 * @author lenovopc
 *
 */
public class Context extends AbstractContext {

	private GlobalConfiguration globalConfiguration;

	/** 表名和表特殊配置映射器, key: tableName, value: TableConfiguration */
	private Map<String, TableConfiguration> tableConfigurationMapper;

	private CommentConfiguration commentConfiguration;

	public TableConfiguration getTableConfiguration(String tableName) {
		if (StringUtils.isBlank(tableName)) {
			// return new TableConfiguration();
			throw new NullPointerException();
		}
		TableConfiguration tableConfiguration = null == tableConfigurationMapper ? new TableConfiguration()
				: tableConfigurationMapper.get(tableName);
		return null == tableConfiguration ? new TableConfiguration() : tableConfiguration;
	}

	public GlobalConfiguration getGlobalConfiguration() {
		return globalConfiguration;
	}

	public void setGlobalConfiguration(GlobalConfiguration globalConfiguration) {
		this.globalConfiguration = globalConfiguration;
	}

	public Map<String, TableConfiguration> getTableConfigurationMapper() {
		return tableConfigurationMapper;
	}

	public void setTableConfigurationMapper(Map<String, TableConfiguration> tableConfigurationMapper) {
		this.tableConfigurationMapper = tableConfigurationMapper;
	}

	public CommentConfiguration getCommentConfiguration() {
		return commentConfiguration;
	}

	public void setCommentConfiguration(CommentConfiguration commentConfiguration) {
		this.commentConfiguration = commentConfiguration;
	}
	

}
