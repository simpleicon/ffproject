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
		cm.insert(v);
	}

	@Override
	public void delete(String k) {
		cm.delete(k);
		
	}

	@Override
	public void update(Car v) {
		cm.update(v);
		
	}

	@Override
	public Car select(String k) {
		return cm.select(k);
	}

	@Override
	public ArrayList<Car> select() {
		return cm.selectall();
	}

}
