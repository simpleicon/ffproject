package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;

@Controller
public class MainController {
	@Resource(name="cbiz")
	Biz biz;
	
	
	@RequestMapping("/registerpage")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerPage");
		return mav;
	}
	
	@RequestMapping("/loginpage")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginPage");
		return mav;
	}
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/listgroup")
	public ModelAndView listgroup(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String item = req.getParameter("item");
		mav.setViewName(item);
		return mav;
	}
	
	
	
	
	
	
}
