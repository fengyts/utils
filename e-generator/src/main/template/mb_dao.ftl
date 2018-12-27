<#include "./common_t.ftl" />
package ${daoPackageName};

import ${commonPackageName}.GenericDAO;
import ${entityPackageName}.${tableEntityClassName};
import ${entityPackageName}.${primaryKeyModelClassSimpleName};

public interface ${tableEntityClassName}DAO extends GenericDAO<${tableEntityClassName}, ${primaryKeyModelClassSimpleName}> {

}
