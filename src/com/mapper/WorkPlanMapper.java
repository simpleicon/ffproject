package com.mapper;

import java.util.ArrayList;

import com.vo.WorkPlan;

public interface WorkPlanMapper {
	public void insert(WorkPlan obj);
	public void delete(String plan_num);
	public void update(WorkPlan obj);
	public WorkPlan select(String obj);
	public ArrayList<WorkPlan> selectall();
}
