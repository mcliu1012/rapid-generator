<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.service.impl;

import net.cn.rainbow.framework.mybatis.service.BaseServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import ${basepackage}.service.${className}Service;
import ${basepackage}.po.${className}Entity;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.dto.${className}Request;
import ${basepackage}.dto.${className}Response;

/**
 * ${table.tableAlias}服务实现类
 *
 * @author 刘佳
 * @date ${.now}
 * @version 1.0.0
 */
@Service
public class ${className}ServiceImpl extends BaseServiceImpl<Integer, ${className}Entity> implements ${className}Service, InitializingBean {

	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;

	@Override
	public void afterPropertiesSet() {
		this.setBaseMapper(${classNameLower}Mapper);
	}

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
	@Override
	public List<${className}Response> list${className}(${className}Request ${classNameLower}Request) {
		return ${classNameLower}Mapper.list${className}(${classNameLower}Request);
	}
	
}
