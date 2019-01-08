<#include "./common_t.ftl" />
package ${servicePackageName};

import ${commonPackageName}.GenericService;
import ${entityPackageName}.${tableEntityClassName};
<#if isUnionPK=='true'>
import ${entityPackageName}.${primaryKeyModelClassSimpleName};
</#if>

public interface ${tableEntityClassName}Service extends GenericService<${tableEntityClassName}, ${primaryKeyModelClassSimpleName}> {
	
}
