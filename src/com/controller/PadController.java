package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PadController {
	Server server;
	
	
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
		String id =req.getParameter("id");
		String value =req.getParameter("value");
		
		System.out.println(id+"  "+ value);
		//CANmsg to Pad
		server.sendMsg(value);
	}
	@RequestMapping("/candata")
	public void candata(HttpServletRequest req) {
		String id =req.getParameter("id");
		String value =req.getParameter("value");
		System.out.println(id+"  "+ value);
	}
	
	//컨트롤패드에서 받은 데이터 분류해서 workplan에 미리 넣어둘것 있고 아닌 애들은 쓰루해서 넘기고 
	
}
