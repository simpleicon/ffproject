package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PadController {
	
	@ResponseBody
	@RequestMapping("/control")
	public ModelAndView controlSignal(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String id =req.getParameter("id");
		String value =req.getParameter("value");
		System.out.println(id+"  "+ value);
		mav.setViewName("main");
		return mav;
	}
	
}
