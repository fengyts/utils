package ${packgeDO.servicePackageName};

<#--
import java.util.List;
import ${packgeDO.utilPackageName}.Page;
import ng.bayue.common.Page;
import ${packgeDO.exceptionPackageName}.ServiceException;
import ng.bayue.exception.ServiceException;
-->
import ng.bayue.service.common.GeneralService;
import ${domain.packageName}.${domain.className};
<#assign len = domain.className?index_of("DO")>
<#assign param="${domain.className?uncap_first}">
<#assign entity="${domain.className}">

 /**
 * ${data_object_comment} Service
 * @author haisheng.long ${create_time?if_exists?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface ${entity?substring(0,len)}Service extends GeneralService<${entity}, ${entity}> {


}
