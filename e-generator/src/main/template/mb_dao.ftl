<#include "./common_t.ftl" />
package ${daoPackageName};

import ${commonPackageName}.GenericDAO;
import ${entityPackageName}.${tableEntityClassName};
<#if isUnionPK=='true'>
import ${entityPackageName}.${primaryKeyModelClassSimpleName};
</#if>

/**
 * 自定义DAO
 * @author lenovopc
 *
 */
public interface ${tableEntityClassName}DAO extends GenericDAO<${tableEntityClassName}, ${primaryKeyModelClassSimpleName}> {

}
