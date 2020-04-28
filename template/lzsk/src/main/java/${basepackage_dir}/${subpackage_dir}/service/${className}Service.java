<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.service;

import net.cn.rainbow.framework.mybatis.service.BaseService;

import java.util.List;

import ${basepackage}.po.${className}Entity;
import ${basepackage}.dto.${className}Request;
import ${basepackage}.dto.${className}Response;

/**
 * ${table.tableAlias}服务接口
 *
 * @author 刘佳
 * @date ${.now}
 * @version 1.0.0
 */
public interface ${className}Service extends BaseService<Integer, ${className}Entity> {

	/**
	 * 查询${className}列表数据
	 * <p>
	 *
	 * @param ${classNameLower}Request
	 * @return
	 * @author 刘佳
	 * @date ${.now}
	 * @version 1.0.0
	 */
	List<${className}Response> list${className}(${className}Request ${classNameLower}Request);
}
