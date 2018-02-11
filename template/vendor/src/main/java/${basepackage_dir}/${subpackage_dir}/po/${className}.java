<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.po;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * ${table.tableAlias}信息
 * 
 * @author liujia on ${.now}
 */
@Getter
@Setter
@Entity
@Table(name = "${table.sqlName}")
@JsonFilter("${basepackage}.po.${className}")
public class ${className} implements Serializable {

	<#list table.columns as column>
	/**
	 * ${column.columnAlias}
	 */
	<#if column.pk>
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	<#elseif column.simpleJavaType == 'Timestamp'>
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	</#if>
	@Column(name = "${column.sqlName}")
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