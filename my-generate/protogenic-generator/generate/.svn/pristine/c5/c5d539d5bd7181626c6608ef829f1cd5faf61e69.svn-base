//package com.meitun.salesorder.controller;
//
//
//import javax.validation.Valid;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.context.request.WebRequest;
//
//import com.meitun.salesorder.domain.CityDO;
//import com.meitun.salesorder.service.CityService;
//import com.meitun.salesorder.util.Page;
//
//@Controller
//@Scope(BeanDefinition.SCOPE_SINGLETON)
//public class CityController {
//
//	@Autowired
//	CityService cityService;
//
//	@RequestMapping(value="/city/add",method=RequestMethod.GET)
//	public String add(final ModelMap model) {
//		CityDO cityDO = new CityDO();
//		model.addAttribute("city", cityDO);
//		return "city/add";
//	}
//
//	@RequestMapping(value="/city/edit/{id}",method=RequestMethod.GET)
//	public String edit(final ModelMap model,@PathVariable Long id) {
//		CityDO cityDO = cityService.selectById(id);
//		model.addAttribute("city", cityDO);
//		return "city/edit";
//	}
//
//	@RequestMapping(value="/city/view/{id}",method=RequestMethod.GET)
//	public String view(final ModelMap model,@PathVariable Long id) {
//		CityDO cityDO = cityService.selectById(id);
//		model.addAttribute("city", cityDO);
//		return "city/view";
//	}
//
//	@RequestMapping(value="/city/save",method=RequestMethod.POST)
//	public String save(@ModelAttribute("city")@Valid CityDO city,BindingResult result) {
//		if(result.hasErrors()){
//			return null;
//		}
//		cityService.insert(city);
//		return "redirect:/city/list";
//	}
//
//	@RequestMapping(value="/city/update/{id}",method=RequestMethod.PUT)
//	public String update(@ModelAttribute("city")@Valid CityDO city,BindingResult result,@PathVariable Integer id) {
//		if(result.hasErrors()){
//			return null;
//		}
//		city.setId(id);
//		cityService.update(city,true);
//		return "redirect:/city/list";
//	}
//
//	@RequestMapping(value="/city/delete/{id}",method=RequestMethod.DELETE)
//	public String delete(@PathVariable Long id) {
//		cityService.deleteById(id);
//		return "redirect:/city/list";
//	}
//
//	@RequestMapping(value="/city/list")
//	public String list(@ModelAttribute("city") CityDO city,final ModelMap model,WebRequest request) {
//		if(city==null){
//			city=new CityDO();
//		}
//		int startPage=Integer.valueOf(StringUtils.isNotBlank(request.getParameter("pageNo"))?request.getParameter("pageNo"):"1");
//		int pageSize=20;
//		Page<CityDO> page=cityService.queryPageListByCityDOAndStartPageSize(city,startPage,pageSize);
//
//		model.addAttribute("page", page);
//		return "city/list";
//	}
//
// }
