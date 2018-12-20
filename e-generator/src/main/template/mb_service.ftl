<#assign packageData=rootData.packageData>
<#assign tableData=rootData.tableEngityData>
<#assign tableEntityName=tableData.tableEntityName />
package ${packageData.servicePackageName};

import ${packageData.entityPackageName}.${tableEntityName};

<#-- 
-->

public interface ${tableEntityName}Service extends GenericService<${tableEntityName}>{
	
}

