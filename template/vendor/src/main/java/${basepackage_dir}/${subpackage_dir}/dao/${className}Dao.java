<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.ecarry.core.web.core.Page;

import ${basepackage}.dao.BaseDao;
import ${basepackage}.po.${className};
import ${basepackage}.util.StringUtil;

/**
 * ${className}DAO
 * 
 * @author liujia on ${.now}
 *
 */
@Repository
public class ${className}Dao extends BaseDao<${className}> {
    
	/**
	 * 分页查询列表数据
	 */
	public List<${className}> find${className}s(Page page, ${className} ${classNameLower}) {
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("SELECT * FROM ${table.sqlName} T1 WHERE 1=1 ");
		bulid${className}FindSql(${classNameLower}, sql, args);
		
		if (null == page) {
			page = new Page();
		}
		if (StringUtils.isEmpty(page.getOrder())) {
			page.setOrder("T1.ID");
			page.setDesc(true);
		}
		return genericDao.findTs(${className}.class, page, sql.toString(), args.toArray());
	}
	
	/**
	 * 构造查询条件
	 */
	private void bulid${className}FindSql(${className} ${classNameLower}, StringBuffer sql, List<Object> args) {
		<#list table.columns as column>
		if (!StringUtils.isEmpty(${classNameLower}.get${column.columnName}())) {
			sql.append(" AND T1.${column.sqlName} = ? ");
			args.add(${classNameLower}.get${column.columnName}());
		}
		</#list>
	}
	
	/**
	 * 删除${table.tableAlias}信息
	 */
	public void delete${className}s(Long[] ids) {
		genericDao.execute("DELETE FROM ${table.sqlName} WHERE ID" + StringUtil.sqlInAppend(ids.length), (Object[]) ids);
	}
	
}