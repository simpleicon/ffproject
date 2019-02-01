package com.carstatus;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.CarStatusMapper;
import com.vo.CarStatus;
@Repository("csdao")
public class CarStatusDao implements Dao<String, CarStatus> {
	
	@Autowired
	CarStatusMapper csm;
	
	@Override
	public void insert(CarStatus v) {
		csm.insert(v);
	}

	@Override
	public void delete(String k) {
		csm.delete(k);
	}

	@Override
	public void update(CarStatus v) {
		csm.update(v);
	}

	@Override
	public CarStatus select(String k) {
		return csm.select(k);
	}

	@Override
	public ArrayList<CarStatus> select() {
		return csm.selectall();
	}

}
