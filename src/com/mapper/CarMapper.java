package com.mapper;

import java.util.ArrayList;
import com.vo.Car;

public interface CarMapper {
	public void insert(Car obj);
	public void delete(String car_id);
	public void update(Car obj);
	public Car select(String obj);
	public ArrayList<Car> selectall();
}
