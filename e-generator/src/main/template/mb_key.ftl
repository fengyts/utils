<#assign packageData=rootData.packageData />
<#assign keyEntityName=keyInfoData.keyEntityName />
<#assign classSimpleName="${keyEntityName?cap_first}" />
package ${packageData.entityPackageName};

<#assign properties=keyInfoData.properties />
<#assign imports=keyInfoData.imports />
<#if imports?default([])?size!=0>
<#list imports as imp>
import ${imp};
</#list>
</#if>
public class ${classSimpleName} {

	public ${classSimpleName}() {
		super();
	}
	
<#assign constructorParam>
<#if properties?default([])?size!=0>
<#list properties as prop>
${prop.propertyType!"Object"} ${prop.propertyName}${","}
</#list>
</#if>
</#assign>
	public ${classSimpleName}(${constructorParam?replace("\r\n"," ")?remove_ending(", ")}) {
		<#if properties?default([])?size!=0>
		<#list properties as prop>
		this.${prop.propertyName} = ${prop.propertyName};
		</#list>
		</#if>
	}
	
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