package com.vo;

import java.util.Date;

public class WorkHistory {
	int history_num;
	int car_id;
	int plan_num;
	String work_status;
	Date start_time;
	Date end_time;
	
	public WorkHistory() {
		super();
	}

	public WorkHistory(int history_num, int car_id, int plan_num, String work_status, Date start_time) {
		super();
		this.history_num = history_num;
		this.car_id = car_id;
		this.plan_num = plan_num;
		this.work_status = work_status;
		this.start_time = start_time;
	}

	public WorkHistory(int history_num, int car_id, int plan_num, String work_status, Date start_time, Date end_time) {
		super();
		this.history_num = history_num;
		this.car_id = car_id;
		this.plan_num = plan_num;
		this.work_status = work_status;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public int getHistory_num() {
		return history_num;
	}

	public void setHistory_num(int history_num) {
		this.history_num = history_num;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getPlan_num() {
		return plan_num;
	}

	public void setPlan_num(int plan_num) {
		this.plan_num = plan_num;
	}

	public String getWork_status() {
		return work_status;
	}

	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		return "WorkHistory [history_num=" + history_num + ", car_id=" + car_id + ", plan_num=" + plan_num
				+ ", work_status=" + work_status + ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}
	
	
	
}
