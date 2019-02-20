package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Car;
import com.vo.CarStatus;

@Controller
public class CarStatusController {
	
	@Resource(name="cbiz")
	Biz cbiz;
	@Resource(name="csbiz")
	Biz csbiz;
	
	@RequestMapping("/carStatus.can")
	public ModelAndView status(HttpServletRequest req) { 
		ModelAndView mav = new ModelAndView();
		CarStatus status = new CarStatus();
		Car car = new Car();
		String car_id = req.getParameter("car_id");
		try {
			car = (Car)cbiz.get(car_id);
			status = (CarStatus) csbiz.get(car_id);
			mav.addObject("car", car);
			mav.addObject("status", status);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("carStatus");
		return mav;
	}
	
}
