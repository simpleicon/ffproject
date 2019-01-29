package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;

@Controller
public class MainController {
	@Resource(name="cbiz")
	Biz biz;
	
	@RequestMapping("/main.can")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		return mav;
	}
	
	
}
