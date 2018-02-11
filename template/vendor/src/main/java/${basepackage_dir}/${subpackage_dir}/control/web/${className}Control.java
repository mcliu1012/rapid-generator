<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.control.web;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ecarry.core.web.core.ContextUtil;
import com.ecarry.core.web.core.Page;
import ${basepackage}.po.User;

import org.springframework.beans.factory.annotation.Autowired;

import ${basepackage}.control.web._baseControl;
import ${basepackage}.po.${className};
import ${basepackage}.service.I${className}Service;

/**
 * ${table.tableAlias}Control
 * 
 * @author liujia on ${.now}
 */
@Controller
@RequestMapping("/${classNameLower}")
public class ${className}Control extends _baseControl {
    
    @Autowired
    private I${className}Service ${classNameLower}Service;
    
    /**
     * 跳转到列表页面
     */
    @RequestMapping(value = "/forward.do", method = RequestMethod.GET)
	public ModelAndView forward${className}List(HttpServletRequest request) {
		ModelAndView view = this.createView("/${classNameLower}/${classNameLower}.jsp");
		User user = ContextUtil.getUser(User.class);
		view.addObject("_orgName", user.getOrgName());
		view.addObject("_orgId", user.getOrgId());
		return view;
	}
    
	/**
	 * 分页查询列表数据
	 */
	@RequestMapping(value = "/find.json", method = RequestMethod.POST)
	@ModelAttribute("rows")
	public List<${className}> find${className}s(Page page, ${className} ${classNameLower}) {
		return ${classNameLower}Service.find${className}s(page, ${classNameLower});
	}

	/**
	 * 保存${table.tableAlias}信息
	 */
	@RequestMapping(value = "/save.json", method = RequestMethod.POST)
	public void save${className}(${className} ${classNameLower}) {
		${classNameLower}Service.save${className}(${classNameLower});
	}
	
	/**
	 * 删除${table.tableAlias}信息
	 */
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public void delete${className}s(Long[] ids) {
		${classNameLower}Service.delete${className}s(ids);
	}

}
