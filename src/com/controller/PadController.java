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
	
	//��Ʈ���е忡�� ���� ������ �з��ؼ� workplan�� �̸� �־�Ѱ� �ְ� �ƴ� �ֵ��� �����ؼ� �ѱ�� 
	
}
