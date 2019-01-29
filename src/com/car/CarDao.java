package com.car;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.CarMapper;
import com.vo.Car;

@Repository("cdao")
public class CarDao implements Dao<String, Car> {
	@Autowired
	CarMapper cm;
	
	@Override
	public void insert(Car v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Car v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Car select(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Car> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
