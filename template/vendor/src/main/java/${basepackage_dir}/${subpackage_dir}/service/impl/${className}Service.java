<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecarry.core.web.core.Page;

import ${basepackage}.service.I${className}Service;
import ${basepackage}.po.${className};
import ${basepackage}.dao.${className}Dao;

/**
 * ${table.tableAlias}服务类
 * 
 * @author liujia on ${.now}
 */
@Service("${classNameLower}Service")
public class ${className}Service implements I${className}Service {
	
    @Autowired
    private ${className}Dao ${classNameLower}Dao;
    
    /**
	 * 根据ID获取${table.tableAlias}信息
	 */
    @Override
	public ${className} getById(Long id) {
		return ${classNameLower}Dao.getById(id);
	}
	
	/**
	 * 分页查询列表数据
	 */
	@Override
	public List<${className}> find${className}s(Page page, ${className} ${classNameLower}) {
		return ${classNameLower}Dao.find${className}s(page, ${classNameLower});
	}

	/**
	 * 保存${table.tableAlias}信息
	 */
	@Override
	public void save${className}(${className} ${classNameLower}) {
		// ${table.tableAlias}信息基础数据校验
		validData(${classNameLower});
		
		if (null == ${classNameLower}.getId()) {
			// 新增
			${classNameLower}Dao.save(${classNameLower});
		} else {
			// 编辑
			${classNameLower}Dao.update(${classNameLower});
		}
	}
	
	/**
	 * ${table.tableAlias}信息基础数据校验
	 */
	private void validData(${className} ${classNameLower}) {
		
	}

	/**
	 * 删除${table.tableAlias}信息
	 */
	@Override
	public void delete${className}s(Long[] ids) {
		if (ids != null && ids.length > 0) {
			${classNameLower}Dao.delete${className}s(ids);
		}
	}
	
}
