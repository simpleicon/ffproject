package com.workhistory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.WorkHistoryMapper;
import com.vo.WorkHistory;

@Repository("whdao")
public class WorkHistoryDao implements Dao<String, WorkHistory> {
	
	@Autowired
	WorkHistoryMapper whm;
	
	@Override
	public void insert(WorkHistory v) {
		whm.insert(v);
	}

	@Override
	public void delete(String k) {
		whm.delete(k);
	}

	@Override
	public void update(WorkHistory v) {
		whm.update(v);
	}

	@Override
	public WorkHistory select(String k) {
		return whm.select(k);
	}

	@Override
	public ArrayList<WorkHistory> select() {
		return whm.selectall();
	}

}
