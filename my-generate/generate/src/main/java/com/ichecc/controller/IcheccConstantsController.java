package com.ichecc.controller;


import javax.validation.Valid;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.ichecc.domain.IcheccConstantsDO;
import com.ichecc.service.IcheccConstantsService;
import ng.bayue.util.Page;

@Controller
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class IcheccConstantsController {

	@Autowired
	IcheccConstantsService icheccConstantsService;

	@RequestMapping(value="/icheccConstants/add",method=RequestMethod.GET)
	public String add(final ModelMap model) {
		IcheccConstantsDO icheccConstantsDO = new IcheccConstantsDO();
		model.addAttribute("icheccConstants", icheccConstantsDO);
		return "icheccConstants/add";
	}

	@RequestMapping(value="/icheccConstants/edit/{id}",method=RequestMethod.GET)
	public String edit(final ModelMap model,@PathVariable Long id) {
		IcheccConstantsDO icheccConstantsDO = icheccConstantsService.selectById(id);
		model.addAttribute("icheccConstants", icheccConstantsDO);
		return "icheccConstants/edit";
	}

	@RequestMapping(value="/icheccConstants/view/{id}",method=RequestMethod.GET)
	public String view(final ModelMap model,@PathVariable Long id) {
		IcheccConstantsDO icheccConstantsDO = icheccConstantsService.selectById(id);
		model.addAttribute("icheccConstants", icheccConstantsDO);
		return "icheccConstants/view";
	}

	@RequestMapping(value="/icheccConstants/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("icheccConstants")@Valid IcheccConstantsDO icheccConstants,BindingResult result) {
		if(result.hasErrors()){
			return null;
		}
		icheccConstantsService.insert(icheccConstants);
		return "redirect:/icheccConstants/list";
	}

	@RequestMapping(value="/icheccConstants/update/{id}",method=RequestMethod.PUT)
	public String update(@ModelAttribute("icheccConstants")@Valid IcheccConstantsDO icheccConstants,BindingResult result,@PathVariable String id) {
		if(result.hasErrors()){
			return null;
		}
		icheccConstants.setId(id);
		icheccConstantsService.update(icheccConstants,true);
		return "redirect:/icheccConstants/list";
	}

	@RequestMapping(value="/icheccConstants/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		icheccConstantsService.deleteById(id);
		return "redirect:/icheccConstants/list";
	}

	@RequestMapping(value="/icheccConstants/list")
	public String list(@ModelAttribute("icheccConstants") IcheccConstantsDO icheccConstants,final ModelMap model,WebRequest request) {
		if(icheccConstants==null){
			icheccConstants=new IcheccConstantsDO();
		}
		int startPage=Integer.valueOf(StringUtils.isNotBlank(request.getParameter("pageNo"))?request.getParameter("pageNo"):"1");
		int pageSize=20;
		Page<IcheccConstantsDO> page=icheccConstantsService.queryPageListByIcheccConstantsDOAndStartPageSize(icheccConstants,startPage,pageSize);

		model.addAttribute("page", page);
		return "icheccConstants/list";
	}

}
