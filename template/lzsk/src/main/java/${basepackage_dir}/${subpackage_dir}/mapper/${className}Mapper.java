<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.mapper;

import net.cn.rainbow.framework.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import ${basepackage}.po.${className}Entity;
import ${basepackage}.dto.${className}Request;
import ${basepackage}.dto.${className}Response;

/**
 * ${className}Mapper
 *
 * @author 刘佳
 * @version 1.0.0
 * @date ${.now}
 */
@Mapper
@Repository
public interface ${className}Mapper extends BaseMapper<Integer, ${className}Entity> {

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