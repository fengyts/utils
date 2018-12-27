<#--
封装freemarker 模板公共变量
-->
<#assign packageData=rootData.packageData>
<#assign tableData=rootData.tableEngityData>
<#if primaryKeyInfoData??>
	<#-- keyEntityName: 键对象名称驼峰形式,首字母小写的 -->
	<#assign primaryKeyEntityName=primaryKeyInfoData.keyEntityName />
	<#assign primaryKeyModelClassSimpleName="${primaryKeyEntityName?cap_first}" />
</#if>
<#if packageData??>
	<#assign basePackageName=packageData.basePackageName />
	<#--<#assign utilsPackageName=packageData.utilsPackageName />-->
	<#assign commonPackageName=packageData.commonPackageName />
	<#assign constantPackageName=packageData.constantPackageName />
	<#assign entityPackageName=packageData.entityPackageName />
	<#assign keyPackageName=packageData.entityPackageName />
	<#assign daoPackageName=packageData.daoPackageName />
	<#assign daoImplPackageName=packageData.daoImplPackageName />
	<#assign servicePackageName=packageData.servicePackageName />
	<#assign serviceImplPackageName=packageData.serviceImplPackageName />
	<#assign exceptionPackageName=packageData.exceptionPackageName />
</#if>
<#if tableData??>
	<#-- tableEntityName: 实体对象名称驼峰形式,首字母小写的 -->
	<#assign tableEntityName=tableData.tableEntityName />
	<#assign tableEntityClassName="${tableEntityName?cap_first}" />
</#if>