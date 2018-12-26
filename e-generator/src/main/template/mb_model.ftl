<#--
<#assign packageData=rootData.packageData />
<#assign tableData=rootData.tableEngityData />
<#assign tableEntityName=tableData.tableEntityName />
-->
<#include "./common_t.ftl" />
package ${packageData.entityPackageName};

import ${baseModelPackageName}.${baseModelName};
<#assign properties=tableData.properties />
<#assign imports=tableData.imports />
<#if imports?default([])?size!=0>
<#list imports as imp>
import ${imp};
</#list>
</#if>

public class ${tableEntityName?cap_first} extends ${baseModelName} {

	private static final long serialVersionUID = 1L;

	<#if properties?default([])?size!=0>
	<#list properties as prop>
	/** ${prop.comment!""} */
	private ${prop.propertyType!"Object"} ${prop.propertyName};
		
	</#list>
	</#if>
	<#if properties??>
	<#list properties as prop>
	public void set${prop.propertyName?cap_first}(${prop.propertyType!"Object"} ${prop.propertyName}) {
		this.${prop.propertyName} = ${prop.propertyName};
	}
	
	public ${prop.propertyType!"Object"} get${prop.propertyName?cap_first}() {
		return ${prop.propertyName};
	}
		
	</#list>
	</#if>
}