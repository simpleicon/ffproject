package com.mapper;

import java.util.ArrayList;

import com.vo.Admin;

public interface AdminMapper {
	public void insert(Admin obj);
	public void delete(String a_id);
	public void update(Admin obj);
	public Admin select(String obj);
	public ArrayList<Admin> selectall();
}
