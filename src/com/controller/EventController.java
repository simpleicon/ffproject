package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.Biz;
import com.vo.WorkPlan;

@Controller
public class EventController {
	@Resource(name="wpbiz")
	Biz<String, WorkPlan> biz;
	
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
	
}
