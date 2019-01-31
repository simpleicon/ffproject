package com.workhistory;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.WorkHistory;

@Service("whbiz")
public class WorkHistoryBiz implements Biz<String, WorkHistory> {
	
	@Resource(name="whdao")
	Dao dao;
	
	@Override
	public void register(WorkHistory v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public void modify(WorkHistory v) throws Exception {
		dao.update(v);
	}

	@Override
	public WorkHistory get(String k) throws Exception {
		return (WorkHistory)dao.select(k);
	}

	@Override
	public ArrayList<WorkHistory> get() throws Exception {
		return dao.select();
	}

}
