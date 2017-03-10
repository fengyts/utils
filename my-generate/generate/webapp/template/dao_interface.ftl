package ${packgeDO.daoPackageName};

import ${domain.packageName}.${domain.className};
<#--
import java.util.List;
import ${packgeDO.exceptionPackageName}.DAOException;
-->
import ng.bayue.service.common.GeneralDAO;
<#assign len = domain.className?index_of("DO")>
<#assign param="${domain.className?uncap_first}">

 /**
 * ${data_object_comment} DAO
 *
 * @author fengyts ${create_time?if_exists?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface ${domain.className?substring(0,len)}DAO extends GeneralDAO<${domain.className}> {

}
