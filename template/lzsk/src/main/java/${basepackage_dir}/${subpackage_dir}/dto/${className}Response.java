<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.cn.rainbow.framework.restful.dto.BaseDTO;

/**
 * ${className}响应参数
 *
 * @author 刘佳
 * @date ${.now}
 * @version 1.0.0
 */
@Data
@ApiModel(value = "${className}Response", description = "${className}响应参数")
public class ${className}Response extends BaseDTO {

	<#list table.columns as column>
	/**
	 * ${column.columnAlias}
	 */
	@ApiModelProperty(value = "${column.columnAlias}", name = "${column.columnAlias}", required = true)
	<#if column.simpleJavaType == 'Timestamp' || column.simpleJavaType == 'Date'>
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	</#if>
	private ${column.simpleJavaType} ${column.columnNameLower};

	</#list>
}
<#macro generateJavaColumns>
	<#list table.columns as column>
	<@generateBycondition column.sqlName>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}

	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}

	</@generateBycondition>
	</#list>
</#macro>