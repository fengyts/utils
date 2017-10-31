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
//import com.meitun.salesorder.domain.CartDO;
//import com.meitun.salesorder.service.CartService;
//import com.meitun.salesorder.util.Page;
//
//@Controller
//@Scope(BeanDefinition.SCOPE_SINGLETON)
//public class CartController {
//
//	@Autowired
//	CartService cartService;
//
//	@RequestMapping(value="/cart/add",method=RequestMethod.GET)
//	public String add(final ModelMap model) {
//		CartDO cartDO = new CartDO();
//		model.addAttribute("cart", cartDO);
//		return "cart/add";
//	}
//
//	@RequestMapping(value="/cart/edit/{id}",method=RequestMethod.GET)
//	public String edit(final ModelMap model,@PathVariable Long id) {
//		CartDO cartDO = cartService.selectById(id);
//		model.addAttribute("cart", cartDO);
//		return "cart/edit";
//	}
//
//	@RequestMapping(value="/cart/view/{id}",method=RequestMethod.GET)
//	public String view(final ModelMap model,@PathVariable Long id) {
//		CartDO cartDO = cartService.selectById(id);
//		model.addAttribute("cart", cartDO);
//		return "cart/view";
//	}
//
//	@RequestMapping(value="/cart/save",method=RequestMethod.POST)
//	public String save(@ModelAttribute("cart")@Valid CartDO cart,BindingResult result) {
//		if(result.hasErrors()){
//			return null;
//		}
//		cartService.insert(cart);
//		return "redirect:/cart/list";
//	}
//
//	@RequestMapping(value="/cart/update/{id}",method=RequestMethod.PUT)
//	public String update(@ModelAttribute("cart")@Valid CartDO cart,BindingResult result,@PathVariable Long id) {
//		if(result.hasErrors()){
//			return null;
//		}
//		cart.setId(id);
//		cartService.update(cart,true);
//		return "redirect:/cart/list";
//	}
//
//	@RequestMapping(value="/cart/delete/{id}",method=RequestMethod.DELETE)
//	public String delete(@PathVariable Long id) {
//		cartService.deleteById(id);
//		return "redirect:/cart/list";
//	}
//
//	@RequestMapping(value="/cart/list")
//	public String list(@ModelAttribute("cart") CartDO cart,final ModelMap model,WebRequest request) {
//		if(cart==null){
//			cart=new CartDO();
//		}
//		int startPage=Integer.valueOf(StringUtils.isNotBlank(request.getParameter("pageNo"))?request.getParameter("pageNo"):"1");
//		int pageSize=20;
//		Page<CartDO> page=cartService.queryPageListByCartDOAndStartPageSize(cart,startPage,pageSize);
//
//		model.addAttribute("page", page);
//		return "cart/list";
//	}
//
// }
