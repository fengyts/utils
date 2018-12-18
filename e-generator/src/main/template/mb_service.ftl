package #{tableDO.packageName};

<#assign tableName=tableDO.tableName />
<#-- -->

public interface #{tableName}Service extends GenericService<#{tableName}>{
	
}

