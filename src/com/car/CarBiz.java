package com.car;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Car;

@Service("cbiz")
public class CarBiz implements Biz<String, Car> {

	@Resource(name="cdao")
	Dao dao;
	
	@Override
	public void register(Car v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Car v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Car get(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Car> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
