package com.vo;

import java.util.Date;

public class WorkPlan {
	int plan_num;
	int car_id;
	String a_id;
	String p_location_x;
	String p_location_y;
	String p_load;
	Date planned_time;
	
	public WorkPlan() {
		super();
	}
	

	public WorkPlan(int car_id, String a_id, String p_location_x, String p_location_y) {
		super();
		this.car_id = car_id;
		this.a_id = a_id;
		this.p_location_x = p_location_x;
		this.p_location_y = p_location_y;
		
	}

	public WorkPlan(int car_id, String a_id, String p_load) {
		super();
		this.car_id = car_id;
		this.a_id = a_id;
		this.p_load = p_load;
		
	}
	

	public WorkPlan(int car_id, String a_id, String p_location_x, String p_location_y, String p_load) {
		super();
		this.car_id = car_id;
		this.a_id = a_id;
		this.p_location_x = p_location_x;
		this.p_location_y = p_location_y;
		this.p_load = p_load;
	}


	public WorkPlan(int plan_num, int car_id, String a_id, String p_location_x, String p_location_y, String p_load) {
		super();
		this.plan_num = plan_num;
		this.car_id = car_id;
		this.a_id = a_id;
		this.p_location_x = p_location_x;
		this.p_location_y = p_location_y;
		this.p_load = p_load;
		
	}


	public int getPlan_num() {
		return plan_num;
	}


	public void setPlan_num(int plan_num) {
		this.plan_num = plan_num;
	}


	public int getCar_id() {
		return car_id;
	}


	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	public String getA_id() {
		return a_id;
	}


	public void setA_id(String a_id) {
		this.a_id = a_id;
	}


	public String getP_location_x() {
		return p_location_x;
	}


	public void setP_location_x(String p_location_x) {
		this.p_location_x = p_location_x;
	}


	public String getP_location_y() {
		return p_location_y;
	}


	public void setP_location_y(String p_location_y) {
		this.p_location_y = p_location_y;
	}


	public String getP_load() {
		return p_load;
	}


	public void setP_load(String p_load) {
		this.p_load = p_load;
	}


	public Date getPlanned_time() {
		return planned_time;
	}


	public void setPlanned_time(Date planned_time) {
		this.planned_time = planned_time;
	}


	@Override
	public String toString() {
		return "WorkPlan [plan_num=" + plan_num + ", car_id=" + car_id + ", a_id=" + a_id + ", p_location_x="
				+ p_location_x + ", p_location_y=" + p_location_y + ", p_load=" + p_load + ", planned_time="
				+ planned_time + "]";
	}
	
	
	
	
	
	
	
	
	
	
}