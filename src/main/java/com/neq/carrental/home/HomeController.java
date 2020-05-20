package com.neq.carrental.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neq.carrental.user.IUserAuthentication;

@Controller
@RequestMapping(path = "/")
public class HomeController {

	@Autowired
	IUserAuthentication userAuthentication;
	
	@GetMapping
	public String welcome(ModelMap model) {
		
		Authentication auth = userAuthentication.getAuthentication();
		String username = auth.getName();
		
		model.addAttribute("username", username);
		return "welcome";
	}
}
