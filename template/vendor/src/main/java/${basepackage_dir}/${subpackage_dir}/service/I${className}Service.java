<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.service;

import java.util.List;

import com.ecarry.core.web.core.Page;

import ${basepackage}.po.${className};

/**
 * ${table.tableAlias}服务接口
 * 
 * @author liujia on ${.now}
 */
public interface I${className}Service {

	/**
	 * 根据ID获取${table.tableAlias}信息
	 */
	public ${className} getById(Long id);
	
	/**
	 * 分页查询列表数据
	 */
	public List<${className}> find${className}s(Page page, ${className} ${classNameLower});

	/**
	 * 保存${table.tableAlias}信息
	 */
	public void save${className}(${className} ${classNameLower});

	/**
	 * 删除${table.tableAlias}信息
	 */
	public void delete${className}s(Long[] ids);

}
