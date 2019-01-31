package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Car;
import com.vo.WorkHistory;

@Controller
public class MainController {
	@Resource(name="cbiz")
	Biz<String, Car> cbiz;
	@Resource(name="whbiz")
	Biz<String, WorkHistory> whbiz;
	
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
		if(item.equals("carList")) {
			ArrayList<Car> list = null;
			try {
				list = cbiz.get();
				mav.addObject("list", list);
			} catch (Exception e) {
				System.out.println("리스트 출력 오류");
				e.printStackTrace();
			}
		} else if(item.equals("carEvents") || item.equals("carHistory")) {
			ArrayList<WorkHistory> list = null;
			try {
				list = whbiz.get();
				mav.addObject("list",list);
			} catch (Exception e) {
				System.out.println("리스트 출력 오류(workhistory)");
				e.printStackTrace();
			}
		} 
		return mav;
	}
	
	
}
