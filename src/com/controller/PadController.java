package com.controller;

import java.io.IOException;

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
import com.vo.WorkPlan;

@Controller
public class PadController {
	Server server;
	
	@Resource(name="whbiz")
	Biz2 whbiz;
	@Resource(name="wpbiz")
	Biz wpbiz;
	@Resource(name="cbiz")
	Biz cbiz;
	@Resource(name="csbiz")
	Biz csbiz;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		try {
			server = new Server();
			server.start();
			System.out.println("SERVER STARTED..");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	@ResponseBody
	@RequestMapping("/control")
	public void controlSignal(HttpServletRequest req) {
		String a_id = req.getParameter("admin");
		String car_id =req.getParameter("id");
		String value =req.getParameter("value");
		Car car = new Car();
		String cur_load = null;
		String cur_locx = null;
		String cur_locy = null;
		a_id = "id01";
		int cmd = Integer.parseInt(value.substring(3,11));
		int can_value = Integer.parseInt(value.substring(11,27));
		
		try {
			car = (Car) cbiz.get(car_id);
			cur_load = car.getCur_load();
			cur_locx = car.getCur_location_x();
			cur_locy = car.getCur_location_y();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cmd == 30) {
			String p_load = null;
			
			if(can_value == 10) {
				if(cur_load.equals("������")) {
					p_load = "����";
				}
			}else if(can_value == 11) {
				if(cur_load.equals("������")) {
					p_load = "����";
				}
			}
			
			if(p_load!=null) {
				WorkPlan wp = new WorkPlan(Integer.parseInt(car_id), a_id, cur_locx, cur_locy, p_load);
				try {
					wpbiz.register(wp);
					server.sendMsg(value);
					System.out.println("plan insert & server send");
				} catch (Exception e) {
					System.out.println("worplan insert ����");
					e.printStackTrace();
				}
			}
		}else if(cmd == 40) {
			double locx = Double.parseDouble(cur_locx);
			double locy = Double.parseDouble(cur_locy);
			String p_locx = cur_locx;
			String p_locy = cur_locy;
			if(can_value == 10) {
				locx += 0.00001;
				p_locx = String.valueOf(locx);
			}else if(can_value==11) {
				locx -= 0.00001;
				p_locx = String.valueOf(locx);
			}else if(can_value==12) {
				locy += 0.00001;
				p_locy = String.valueOf(locy);
			}else if(can_value==13) {
				locy += 0.00001;
				p_locy = String.valueOf(locy);
			}
			WorkPlan wp = new WorkPlan(Integer.parseInt(car_id), a_id, p_locx, p_locy, "-");
			try {
				wpbiz.register(wp);
				server.sendMsg(value);
				System.out.println(car_id+"  "+ value);
			} catch (Exception e) {
				System.out.println("moving wp insert error");
				e.printStackTrace();
			}
		}else {
			System.out.println(car_id+"  "+ value);
			server.sendMsg(value);
		}
		
	}
	@RequestMapping("/candata")
	public void candata(HttpServletRequest req) {
		String carid =req.getParameter("id");
		String value =req.getParameter("value");
		String can_id = value.substring(0, 2);
		int can_data = Integer.parseInt(value.substring(2));
		
		if(can_id.equals("10")) {
			CarStatus status = new CarStatus();
			try {
				status = (CarStatus) csbiz.get(carid);
				String ignition = null;
				if(can_data==10) {
					ignition = "ON";
				}else if(can_data==11) {
					ignition = "OFF";
				}
				status.setIgnition(ignition);
				csbiz.modify(status);
			} catch (Exception e) {
				System.out.println("status update error");
				e.printStackTrace();
			}
			
		}else if(can_id.equals("20")) {
			
		}else if(can_id.equals("30")) {
			Car car = new Car();
			String load = null;
			try {
				car = (Car) cbiz.get(carid);
				if(can_data==10) {
					load = "������";
				}else if(can_data==11) {
					load = "������";
				}
				car.setCur_load(load);
				cbiz.register(car);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(can_id.equals("40")) {
			Car car = new Car();
			try {
				car = (Car)cbiz.get(carid);
				double locx = Double.parseDouble(car.getCur_location_x());
				double locy = Double.parseDouble(car.getCur_location_y());
				if(can_data==10) {
					locx += 0.00001;
				}else if(can_data==11) {
					locx -= 0.00001;
				}else if(can_data==12) {
					locy += 0.00001;
				}else if(can_data==13) {
					locy -= 0.00001;
				}
				car.setCur_location_x(String.valueOf(locx));
				car.setCur_location_y(String.valueOf(locy));
				cbiz.modify(car);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("From pad : "+carid+"  "+ value);
		
	}
	
	 
	
}
