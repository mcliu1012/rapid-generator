<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.control.web;

import java.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.cn.rainbow.framework.restful.controller.BaseController;
import net.cn.rainbow.framework.restful.dto.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ${basepackage}.po.${className};
import ${basepackage}.service.${className}Service;

/**
 * ${table.tableAlias}控制器
 *
 * @author 刘佳
 * @date ${.now}
 * @version 1.0.0
 */
@Api(tags = "${table.tableAlias}")
@RestController
@RequestMapping(value = "/${classNameLower}")
public class ${className}Controller extends BaseController {
    
    @Autowired
    private ${className}Service ${classNameLower}Service;

	/**
	 * 查询${className}列表数据
	 * <p>
	 *
	 * @param ${classNameLower}Request ${className}请求参数
	 * @return ${className}列表数据
	 * @author 刘佳
	 * @date ${.now}
	 * @version 1.0.0
	 */
	@ApiOperation(value = "查询${className}列表数据", httpMethod = "POST")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public RestResult<List<${className}Response>> list(@RequestBody @Validated ${className}Request ${classNameLower}Request) {
		return success(${classNameLower}Service.list${className}(${classNameLower}Request));
	}

}
