package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.controller.Server;
import com.vo.Admin;

@Controller
public class AdminController {
	Server server;
	@Resource(name="abiz")
	Biz biz;
	
	@RequestMapping("/register")
	public ModelAndView register(Admin admin) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginPage");
		
		try {
			biz.register(admin);
			mav.addObject("register", "success");
		} catch (Exception e) {
			mav.setViewName("registerPage");
			e.printStackTrace();
		}
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/duplcheck")
	public int duplcheck(String a_id) {
		Admin admin = new Admin();
		int count = 0;
		try {
			admin = (Admin) biz.get(a_id);
			if(admin != null) {
				count++;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		String a_id = req.getParameter("a_id");
		String a_pw = req.getParameter("a_pw");
		Admin dbadmin = null;
		try {
			dbadmin = (Admin) biz.get(a_id);
			if((dbadmin.getA_pw()).equals(a_pw)) {
				HttpSession session = req.getSession();
				session.setAttribute("login_admin", dbadmin);
				System.out.println("Login OK");
			}else {
				System.out.println("Login Fail1");
				mav.setViewName("loginPage");
				mav.addObject("login_error", "1");
			}	
		} catch (Exception e) {
			System.out.println("Login Fail2");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "loginPage"; 
	}
	
}
