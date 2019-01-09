<#--
<#assign packageData=rootData.packageData />
<#assign tableData=rootData.tableEngityData />
<#assign tableEntityName=tableData.tableEntityName />
-->
<#include "./common_t.ftl" />
package ${packageData.entityPackageName};

<#assign extendsModel = primaryKeyModelClassSimpleName />
<#if isUnionPK=='false'>
<#assign extendsModel = baseModelName />
import ${baseModelPackageName}.${baseModelName};
</#if>
<#assign properties=tableData.properties />
<#assign imports=tableData.imports />
<#if imports?default([])?size!=0>
<#list imports as imp>
import ${imp};
</#list>
</#if>

public class ${tableEntityName?cap_first} extends ${extendsModel} {

	private static final long serialVersionUID = 1L;

	<#if properties?default([])?size!=0>
	<#list properties as prop>
		<#assign isPK=false />
		<#if pkColumns??>
			<#list pkColumns as pkCol>
				<#if prop.propertyName==pkCol.getHumpFormat()>
					<#assign isPK=true />
					<#break>
				</#if>
			</#list>
		</#if>
		<#if isPK==false>
	/** ${prop.comment!""} */
	private ${prop.propertyType!"Object"} ${prop.propertyName};
		</#if>
	</#list>
	</#if>

	<#if properties??>
	<#list properties as prop>
		<#assign isPK=false />
		<#if pkColumns??>
			<#list pkColumns as pkCol>
				<#if prop.propertyName==pkCol.getHumpFormat()>
					<#assign isPK=true />
					<#break>
				</#if>
			</#list>
		</#if>
		<#if isPK==false>
	public void set${prop.propertyName?cap_first}(${prop.propertyType!"Object"} ${prop.propertyName}) {
		this.${prop.propertyName} = ${prop.propertyName};
	}
	
	public ${prop.propertyType!"Object"} get${prop.propertyName?cap_first}() {
		return ${prop.propertyName};
	}
	</#if>

	</#list>
	</#if>
}