package ng.bayue.user.controller;


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

import ng.bayue.user.domain.UserDO;
import ng.bayue.user.service.UserService;
import ng.bayue.util.Page;

@Controller
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="/user/add",method=RequestMethod.GET)
	public String add(final ModelMap model) {
		UserDO userDO = new UserDO();
		model.addAttribute("user", userDO);
		return "user/add";
	}

	@RequestMapping(value="/user/edit/{id}",method=RequestMethod.GET)
	public String edit(final ModelMap model,@PathVariable Long id) {
		UserDO userDO = userService.selectById(id);
		model.addAttribute("user", userDO);
		return "user/edit";
	}

	@RequestMapping(value="/user/view/{id}",method=RequestMethod.GET)
	public String view(final ModelMap model,@PathVariable Long id) {
		UserDO userDO = userService.selectById(id);
		model.addAttribute("user", userDO);
		return "user/view";
	}

	@RequestMapping(value="/user/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("user")@Valid UserDO user,BindingResult result) {
		if(result.hasErrors()){
			return null;
		}
		userService.insert(user);
		return "redirect:/user/list";
	}

	@RequestMapping(value="/user/update/{id}",method=RequestMethod.PUT)
	public String update(@ModelAttribute("user")@Valid UserDO user,BindingResult result,@PathVariable Long id) {
		if(result.hasErrors()){
			return null;
		}
		user.setId(id);
		userService.update(user,true);
		return "redirect:/user/list";
	}

	@RequestMapping(value="/user/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		userService.deleteById(id);
		return "redirect:/user/list";
	}

	@RequestMapping(value="/user/list")
	public String list(@ModelAttribute("user") UserDO user,final ModelMap model,WebRequest request) {
		if(user==null){
			user=new UserDO();
		}
		int startPage=Integer.valueOf(StringUtils.isNotBlank(request.getParameter("pageNo"))?request.getParameter("pageNo"):"1");
		int pageSize=20;
		Page<UserDO> page=userService.queryPageListByUserDOAndStartPageSize(user,startPage,pageSize);

		model.addAttribute("page", page);
		return "user/list";
	}

}
