package ng.bayue.generator.config;

import java.util.Map;

import ng.bayue.generator.utils.StringUtils;

/**
 * @author lenovopc
 *
 */
public class Context extends AbstractContext {

	private GlobalConfiguration globalConfiguration;

	// private List<TableConfiguration> tableConfigurations;

	/** 表名和表特殊配置映射器  */
	private Map<String, TableConfiguration> tableConfigurationMapper;

	private CommentConfiguration commentConfiguration;
	
	public TableConfiguration getTableConfiguration(String tableName){
		if(StringUtils.isBlank(tableName)){
			return new TableConfiguration();
		}
		return tableConfigurationMapper.get(tableName);
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
