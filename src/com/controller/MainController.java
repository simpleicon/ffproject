package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.frame.Biz2;
import com.vo.Car;
import com.vo.CarStatus;
import com.vo.WorkHistory;
import com.vo.WorkPlan;

@Controller
public class MainController {
	
	@Resource(name="cbiz")
	Biz<String, Car> cbiz;
	@Resource(name="csbiz")
	Biz csbiz;
	@Resource(name="whbiz")
	Biz2<String, WorkHistory, String, String> whbiz;
	@Resource(name="wpbiz")
	Biz<String, WorkPlan> biz;
	
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
	
	//리스트탭
	@RequestMapping("/listgroup")
	public ModelAndView listgroup(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		String item = req.getParameter("item");
		mav.setViewName(item);
		if(item.equals("carList")|| item.equals("carHistory")) {
			ArrayList<Car> list = null;
			try {
				list = cbiz.get();
				mav.addObject("list", list);
			} catch (Exception e) {
				System.out.println("리스트 출력 오류");
				e.printStackTrace();
			}
		} else if(item.equals("carEvents") ) {
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
	
	
	//map marker
	@ResponseBody
	@RequestMapping("/carMarker")
	public ArrayList<Car> carMarker(){
		ArrayList<Car> list = null;
		try {
			list = cbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//작업내역
	@ResponseBody
	@RequestMapping("getPlan")
	public WorkPlan plan(HttpServletRequest req) {
		WorkPlan plan = null;
		String plan_num = req.getParameter("plan_num");
		try {
			plan = biz.get(plan_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plan;
	}
	
	//작업내역 검색
	@RequestMapping("/searchHistory")
	public ModelAndView history(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		ArrayList<WorkHistory> list = null;
		String car_id = req.getParameter("car_id");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		mav.setViewName("searchedHistory");
		try {
			list = whbiz.get(car_id, start_date, end_date);
			mav.addObject("historyList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	//차량 상세 정보
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
