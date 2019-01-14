	<select id="selectBatchByPrimaryKey" parameterType="java.util.List" resultMap="${resultMapId}">
		SELECT
			<include refid="Base_Columns" />
		FROM
			${tableName}
		WHERE
		<#if isUnionPK != 'true' && pkColumns??>
		<#assign pkCol = pkColumns?first />
			${pkCol.columnName} IN 
		(
		<foreach collection="list" item="item" separator=",">
			#${"{item." + pkCol.humpFormat + "}"}
		</foreach>
		)
		<#else>
			(<#list pkColumns as pkCol>${pkCol.columnName}<#sep>, </#list>) IN 
		(
		<foreach collection="list" item="item" separator=",">
			(<#list pkColumns as pkCol>#${"{item." + pkCol.humpFormat + "}"}<#sep>, </#list>)
		</foreach>
		)
		</#if>
	</select>

	<insert id="insertBatch" parameterType="java.util.List">
		INSERT INTO ${tableName} (
			<#--<include refid="Base_Columns" />-->
			${formatColStr(3, 8)}
		) VALUES 
		<foreach collection="list" item="item" separator=",">
		(
			<#list allColumns as col>
			#${"{item." + col.humpFormat + "}"}<#sep>,
			</#list>
		${"\r\n"}		)
		</foreach>
	</insert>

	<update id="updateBatchByPrimaryKey" parameterType="java.util.List">
		<foreach collection="list" item="item" separator="," open="(" close=")">
		UPDATE ${tableName}
		<set>
			${getSetWhere()}
		</set>
		WHERE 
			<#list pkColumns as pkCol>${pkCol.columnName} = #${"{item." + pkCol.humpFormat + "}"}<#sep> AND </#list>
		</foreach>
	</update> 

	<delete id="deleteBatchByPrimaryKey" parameterType="java.util.List">
		DELETE FROM ${tableName} 
		WHERE 
		<#if isUnionPK != 'true' && pkColumns??>
		<#assign pkCol = pkColumns?first />
			${pkCol.columnName} IN 
		(
		<foreach collection="list" item="item" separator=",">
			#${"{item." + pkCol.humpFormat + "}"}
		</foreach>
		)
		<#else>
			(<#list pkColumns as pkCol>${pkCol.columnName}<#sep>, </#list>) IN 
		(
		<foreach collection="list" item="item" separator=",">
			(<#list pkColumns as pkCol>#${"{item." + pkCol.humpFormat + "}"}<#sep>, </#list>)
		</foreach>
		)
		</#if>
	</delete>
