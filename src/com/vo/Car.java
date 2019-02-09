package com.vo;

public class Car {
	int car_id;
	String car_name;
	String cur_location_x;
	String cur_location_y;
	String cur_load;
	
	public Car() {
		super();
	}
	
	public Car(int car_id, String car_name) {
		super();
		this.car_id = car_id;
		this.car_name = car_name;
	}

	public Car(int car_id, String car_name, String cur_location_x, String cur_location_y, String cur_load) {
		this.car_id = car_id;
		this.car_name = car_name;
		this.cur_location_x = cur_location_x;
		this.cur_location_y = cur_location_y;
		this.cur_load = cur_load;
	}


	public int getCar_id() {
		return car_id;
	}


	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	public String getCar_name() {
		return car_name;
	}


	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}


	public String getCur_location_x() {
		return cur_location_x;
	}


	public void setCur_location_x(String cur_location_x) {
		this.cur_location_x = cur_location_x;
	}


	public String getCur_location_y() {
		return cur_location_y;
	}


	public void setCur_location_y(String cur_location_y) {
		this.cur_location_y = cur_location_y;
	}


	public String getCur_load() {
		return cur_load;
	}


	public void setCur_load(String cur_load) {
		this.cur_load = cur_load;
	}


	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", car_name=" + car_name + ", cur_location_x=" + cur_location_x
				+ ", cur_location_y=" + cur_location_y + ", cur_load=" + cur_load + "]";
	}
	
	
	
}
