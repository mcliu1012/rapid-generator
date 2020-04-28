<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.cn.rainbow.framework.restful.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * ${className}请求参数
 *
 * @author 刘佳
 * @date ${.now}
 * @version 1.0.0
 */
@Data
@ApiModel(value = "${className}Request", description = "${className}请求参数")
public class ${className}Request extends BaseDTO {

	<#list table.columns as column>
	/**
	 * ${column.columnAlias}
	 */
	@ApiModelProperty(value = "${column.columnAlias}", name = "${column.columnNameLower}", required = true)
	<#if column.simpleJavaType == 'Timestamp' || column.simpleJavaType == 'Date'>
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	</#if>
	@NotNull(message = "${column.columnAlias}不能为空")
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