<#include "./common_t.ftl" />
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<#assign namespace = daoImplPackageName + "." + tableEntityClassName + "MybatisDAO" />
<#assign resultMapId = "BaseResultMap" />
<#assign parameterTypeEntity = entityPackageName + "." + tableEntityClassName />
<#assign pkEntity = primaryKeyInfoData.keyClassFullyName />
<#assign tableName = tableData.tableName>
<#-- formatColStr(int indent, int perLineSizeTemp):格式化列输出列, indent-缩进量,默认2个tab键量, perLineSize-每8个换一行  -->
<#function formatColStr indent perLineSizeTemp>
	<#assign perLineSize=perLineSizeTemp />
	<#if allColumns?size lt 12>
		<#assign perLineSize=allColumns?size />
	</#if>
	<#assign colStrTemp>
	<#list tableData.allColumns?split(', ')?chunk(perLineSize) as seq>
		<#if indent == 2>
		${seq?join(", ")},
		<#elseif indent == 3>
			${seq?join(", ")},
		</#if>
	</#list>
	</#assign>
	<#return "${colStrTemp?trim?remove_ending(',')}" />
</#function>
<#function getPKWhere>
	<#assign len=0 pkColumnsSize=pkColumns?size />
	<#--
	<#assign pkWhereSql>
		<#list pkColumns as pk>
		<#if len==0>
${pk.columnName} = #${"{"}${pk.getHumpFormat()}}
		<#else>
		AND ${pk.columnName} = #${"{"}${pk.getHumpFormat()}}
		</#if>
		<#assign len++ />
		</#list>
	</#assign>
	-->
	<#assign pkWhereSql>
		<#t><#list pkColumns as pk>
		<#if len == 0>
			${pk.columnName} = #${"{"}${pk.getHumpFormat()}} <#t>
		 <#else>
 			AND ${pk.columnName} = #${"{"}${pk.getHumpFormat()}} <#t>
		</#if>
		<#assign len++ />
		</#list>
	</#assign>
	<#return pkWhereSql />
</#function>
<#function getIfWhere>
	<#assign ifWhereSql>
	<#if allColumns?default([])?size!=0>
	<#list allColumns as column>
		<#assign propertyName=column.getHumpFormat()>
		<#if column.javaTypeInfo.isBasicJavaType()>
			<if test="${propertyName} != null"> AND ${column.columnName} = #${"{" + propertyName + "}"} </if>
		<#else>
			<if test="${propertyName} != null and ${propertyName} != '' "> AND ${column.columnName} = #${"{"}${propertyName}} </if>
		</#if>
	</#list>
	</#if>
	</#assign>
	<#return ifWhereSql />
</#function>
<mapper namespace="${namespace}">
	<resultMap type="${parameterTypeEntity}" id="${resultMapId}">
		<#if pkColumns?default([])?size!=0>
			<#list pkColumns as pk>
		<id column="${pk.columnName}" property="${pk.getHumpFormat()}" <#--javaType="${pk.javaTypeInfo.javaTypeShort}"--> />
			</#list>
		</#if>
		<#assign pkSize=0>
		<#if allColumns?default([])?size!=0>
			<#list allColumns as column>
			<#assign pkSize++>
			<#if pkSize &gt; pkColumnSize >
		<result column="${column.columnName}" property="${column.getHumpFormat()}" <#--javaType="${column.javaTypeInfo.javaTypeShort}"--> />
			</#if>
			</#list>
		</#if>
	</resultMap>
	<#--
	<resultMap type="${entityPackageName}.${tableEntityClassName}" id="BaseResultMap">
		<#if allColumns?default([])?size!=0>
			<#list allColumns as column>
				<#assign ispk='false'>
				<#if pkColumns?default([])?size!=0>
					<#list pkColumns as pk>
						<#if column.columnName == pk.columnName>
							<#assign ispk='true'>
							<#break>
						</#if>
					</#list>
				</#if>
				<#if ispk='true'>
		<id column="${column.columnName}" property="${column.getHumpFormat()}" />
				<#else>
		<result column="${column.columnName}" property="${column.getHumpFormat()}" />
				</#if>
			</#list>
		</#if>
	</resultMap>
	-->
	
	<sql id="Base_Columns">
		${formatColStr(2, 8)}
	</sql>
	
	<!-- 只有varchar char text类型 做 !='' 判断，生成代码时,其他类型时只做!=null 决断 0或fasle与空''是相同的，在mybatis中的动态语句中 -->
	<!-- xml转义字符需要 <![CDATA[   ]]> 标签-->
 	<sql id="Dynamic_Where_Clause">
		<where>
			<#t>${getIfWhere()}
		</where>
 	</sql>
 	
 	<insert id="insert" parameterType="${parameterTypeEntity}" useGeneratedKeys="true">
        <selectKey resultType="long" keyProperty="id" order="AFTER">
            SELECT LAST_INSERT_ID() AS id
        </selectKey>
        INSERT INTO ${tableName} (
			<#--${tableData.allColumns}-->
			${formatColStr(3, 8)}
		) VALUES (
			<#assign len=0 columnsSize=allColumns?size />
			<#list allColumns as column>
			#${"{" + column.getHumpFormat() + "}"}<#if len!=(columnsSize-1)>,</#if>
			<#assign len++ />
			</#list>
		)
    </insert>
    
    <update id="updateByPrimaryKey" parameterType="${parameterTypeEntity}">
		UPDATE ${tableName}
		SET
			<#assign len=0 columnsSize=allColumns?size />
			<#list allColumns as column>
			${column.columnName} = #${"{" + column.getHumpFormat() + "}"}<#if len!=(columnsSize-1)>,</#if>
			<#assign len++ />
			</#list>
		WHERE
			${getPKWhere()}
	</update>
	
	<update id="updateDynamicByPrimaryKey" parameterType="${parameterTypeEntity}">
		UPDATE ${tableName}
		<set>
			<#t>${getIfWhere()}
		</set>
		WHERE 
			${getPKWhere()}
	</update>
 	
 	<select id="selectByPrimaryKey" parameterType="${pkEntity}" resultMap="${resultMapId}">
		SELECT
			<include refid="Base_Columns" />
		FROM
			${tableName}
		WHERE
			${getPKWhere()}
	</select>
	
</mapper>