package com.carstatus;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.CarStatus;

@Service("csbiz")
public class CarStatusBiz implements Biz<String, CarStatus> {
	
	@Resource(name="csdao")
	Dao dao;
	
	@Override
	public void register(CarStatus v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CarStatus v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public CarStatus get(String k) throws Exception {
		return (CarStatus) dao.select(k);
	}

	@Override
	public ArrayList<CarStatus> get() throws Exception {
		return dao.select();
	}

}
