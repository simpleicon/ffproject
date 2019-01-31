package com.admin;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Admin;

@Service("abiz")
public class AdminBiz implements Biz<String, Admin> {
	@Resource(name="adao")
	Dao dao;
	
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void register(Admin v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(Admin v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public Admin get(String k) throws Exception {
		return (Admin) dao.select(k);
	}

	@Override
	public ArrayList<Admin> get() throws Exception {
		return dao.select();
	}
	


}
