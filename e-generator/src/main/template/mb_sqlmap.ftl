<#include "./common_t.ftl" />
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${daoImplPackageName}.${tableEntityClassName}MybatisDAO">
	<resultMap type="${entityPackageName}.${tableEntityClassName}" id="BaseResultMap">
		<id column="" property="" />
		<result column="" property="" />
	</resultMap>
	
	<sql id="Base_Columns">
		${tableData.allColumns}
	</sql>
	

	<sql id="Dynamic_Where_Clause"><!-- xml转义字符需要 <![CDATA[   ]]> 标签-->
		<where>
		<#--
			<if test="itemId != null  and itemId != '' "> AND item_id=#{itemId} </if>
			<if test="skuId != null  and skuId != '' "> AND sku_id=#{skuId} </if>
			<if test="memberId != null  and memberId != '' "> AND member_id=#{memberId} </if>
			<if test="quantity != null  and quantity != '' "> AND quantity=#{quantity} </if>
			<if test="selected != null  and selected != '' "> AND selected=#{selected} </if>
			-->
		</where>
 	</sql>
	
</mapper>