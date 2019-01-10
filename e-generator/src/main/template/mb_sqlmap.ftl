<#include "./common_t.ftl" />
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<#assign mapperNamespace = daoPackageName + "." + tableEntityClassName + "Mapper" />
<#assign resultMapId = "BaseResultMap" />
<#assign parameterTypeEntity = entityPackageName + "." + tableEntityClassName />
<#assign pkEntity = primaryKeyInfoData.keyClassFullyName />
<#assign tableName = tableData.tableName>
<#-- formatColStr(int indent, int perLineSizeTemp): 格式化列输出列, indent-缩进量,默认2个tab键量, perLineSize-每8个换一行  -->
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
<#-- getPKWhere(): 格式化输出主键where 条件sql -->
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
<#-- getIfWhere(boolean isExampleWhere): 格式化输出动态where 条件sql,isExampleWhere: 是否包含example条件 -->
<#function getIfWhere conditionPrefix...>
	<#assign ifWhereSql>
	<#if allColumns?default([])?size!=0>
		<#assign conditionPrefixTem = '' />
		<#if conditionPrefix??&&(conditionPrefix?size gt 0)>
			<#assign conditionPrefixTem = conditionPrefix?first + "." />
		</#if>
		<#list allColumns as column>
			<#assign propertyName=conditionPrefixTem+column.getHumpFormat()>
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
<mapper namespace="${mapperNamespace}">
	<resultMap type="${parameterTypeEntity}" id="${resultMapId}">
		<#if pkColumns?default([])?size!=0>
			<#list pkColumns as pk>
		<id column="${pk.columnName}" property="${pk.getHumpFormat()}"<#--javaType="${pk.javaTypeInfo.javaTypeShort}"--> />
			</#list>
		</#if>
		<#assign pkSize=0>
		<#if allColumns?default([])?size!=0>
			<#list allColumns as column>
			<#assign pkSize++>
			<#if pkSize gt pkColumnSize >
		<result column="${column.columnName}" property="${column.getHumpFormat()}"<#--javaType="${column.javaTypeInfo.javaTypeShort}"--> />
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
 	<!-- example 动态条件 -->
 	<sql id="Dynamic_Where_Clause_Example">
		<where>
			<#t>${getIfWhere('example')}
		</where>
 	</sql>
 	
 	<insert id="insert" parameterType="${parameterTypeEntity}" useGeneratedKeys="true">
 		<#if isUnionPK != 'true' && pkColumns??>
 		<#assign pkCol = pkColumns?first />
        <selectKey resultType="${pkEntity}" keyProperty="${pkCol.javaPropertyName}" order="AFTER">
            SELECT LAST_INSERT_ID() AS id
        </selectKey>
 		</#if>
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
    
    <update id="updateByPrimaryKeyAllFields" parameterType="${parameterTypeEntity}">
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
	
	<update id="updateByPrimaryKeyDynamic" parameterType="${parameterTypeEntity}">
		UPDATE ${tableName}
		<set>
			<#t>${getIfWhere()}
		</set>
		WHERE 
			${getPKWhere()}
	</update>
	
	<update id="updateDynamic" parameterType="java.util.Map">
		UPDATE ${tableName}
		<set>
			<#t>${getIfWhere('record')}
		</set>
		WHERE 
			<include refid="Dynamic_Where_Clause_Example" />
	</update>
	
	<delete id="deleteByPrimaryKey" parameterType="${pkEntity}">
		DELETE FROM test_generator WHERE ${getPKWhere()}
	</delete>
 	
 	<select id="selectByPrimaryKey" parameterType="${pkEntity}" resultMap="${resultMapId}">
		SELECT
			<include refid="Base_Columns" />
		FROM
			${tableName}
		WHERE
			${getPKWhere()}
	</select>
	
 	<select id="selectDynamic" parameterType="${parameterTypeEntity}" resultMap="${resultMapId}">
		SELECT
			<include refid="Base_Columns" />
		FROM
			${tableName}
		WHERE
			<include refid="Dynamic_Where_Clause" />
	</select>
	
 	<select id="selectCountDynamic" parameterType="${parameterTypeEntity}" resultType="java.lang.Long">
		SELECT
			COUNT(1)
		FROM
			${tableName}
		WHERE
			<include refid="Dynamic_Where_Clause" />
	</select>
	
 	<select id="selectDynamicPageQuery" parameterType="${parameterTypeEntity}" resultType="java.lang.Long">
		SELECT
			<include refid="Base_Columns" />
		FROM
			${tableName}
		WHERE
			<include refid="Dynamic_Where_Clause" />
		ORDER BY <#list pkColumns as pkCol>${pkCol.getHumpFormat()}<#sep> DESC, </#list> DESC 
	 	Limit <#noparse>#{start}, #{pageSize}</#noparse>
	</select>
	
</mapper>