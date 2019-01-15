<#include "./common_t.ftl" />
package ${daoPackageName};

import ${commonPackageName}.GenericBasicDAO;
import ${commonPackageName}.GenericExtendDAO;
import ${entityPackageName}.${tableEntityClassName};
<#if isUnionPK=='true'>
import ${entityPackageName}.${primaryKeyModelClassSimpleName};
</#if>

/**
 * 自定义DAO
 * @author lenovopc
 *
 */
public interface ${tableEntityClassName}DAO extends GenericBasicDAO<${tableEntityClassName}, ${primaryKeyModelClassSimpleName}>,
		GenericExtendDAO<${tableEntityClassName}, ${primaryKeyModelClassSimpleName}> {

}
