package com.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.AdminMapper;
import com.vo.Admin;

@Repository("adao")
public class AdminDao implements Dao<String, Admin> {
	@Autowired
	AdminMapper am;
	
	@Override
	public void insert(Admin v) {
		am.insert(v);
	}

	@Override
	public void delete(String k) {
		am.delete(k);
	}

	@Override
	public void update(Admin v) {
		am.update(v);
	}

	@Override
	public Admin select(String k) {
		return am.select(k);
	}

	@Override
	public ArrayList<Admin> select() {
		return am.selectall();
	}

	

}
