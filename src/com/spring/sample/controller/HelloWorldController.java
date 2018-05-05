package com.spring.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sample.bean.User;
import com.spring.sample.service.UserService;
 
@Controller
public class HelloWorldController {
	@Autowired
	UserService userService;
	
	//String message = "Welcome to Spring MVC!";
	
	@RequestMapping("/")
	public ModelAndView start() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
/*	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}*/
	
	@RequestMapping("/login")
	public ModelAndView login(
			@RequestParam(value = "username", required = false, defaultValue = "") String username,
			@RequestParam(value = "password", required = false, defaultValue = "") String password) {
		String errmsg="Invalid username and password";
		ModelAndView mv;
		if(username!="" && password!="") {
			List<User> list=userService.getUserByUserName(username);
			if(list != null && !list.isEmpty()) {
				User user = list.get(0);
				if(user.getUsername().equals(username) && user.getPassword().equals(password))	{
					mv = new ModelAndView("login");
					mv.addObject("username", username);
					return mv;
				}	
			} 
		} 
		
		mv = new ModelAndView("index");
		mv.addObject("errmsg", errmsg);
		
		return mv;
	}
}
