package com.mapper;

import java.util.ArrayList;

import com.vo.CarStatus;

public interface CarStatusMapper {
	public void insert(CarStatus obj);
	public void delete(String car_id);
	public void update(CarStatus obj);
	public CarStatus select(String obj);
	public ArrayList<CarStatus> selectall();
}
