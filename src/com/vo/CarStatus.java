package com.vo;

public class CarStatus {
	int car_id;
	String ignition;
	int battery;
	String charge;
	int speed;
	
	String cur_location_x;
	String cur_location_y;
	
	public CarStatus() {
		super();
	}
	
	public CarStatus(int car_id, String ignition, int battery, String charge, int speed) {
		super();
		this.car_id = car_id;
		this.ignition = ignition;
		this.battery = battery;
		this.charge = charge;
		this.speed = speed;
	}

	public CarStatus(int car_id, String ignition, int battery, String charge, int speed, String cur_location_x,
			String cur_location_y) {
		super();
		this.car_id = car_id;
		this.ignition = ignition;
		this.battery = battery;
		this.charge = charge;
		this.speed = speed;
		this.cur_location_x = cur_location_x;
		this.cur_location_y = cur_location_y;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getIgnition() {
		return ignition;
	}

	public void setIgnition(String ignition) {
		this.ignition = ignition;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	@Override
	public String toString() {
		return "CarStatus [car_id=" + car_id + ", ignition=" + ignition + ", battery=" + battery + ", charge=" + charge
				+ ", speed=" + speed + ", cur_location_x=" + cur_location_x + ", cur_location_y=" + cur_location_y
				+ "]";
	}
	
	
	
	
}
