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
		dao.insert(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public void modify(Car v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public Car get(String k) throws Exception {
		return (Car)dao.select(k);
	}

	@Override
	public ArrayList<Car> get() throws Exception {
		return dao.select();
	}

}
