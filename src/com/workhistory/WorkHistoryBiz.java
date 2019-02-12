package com.workhistory;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz2;
import com.frame.Dao2;
import com.vo.WorkHistory;

@Service("whbiz")
public class WorkHistoryBiz implements Biz2<String, WorkHistory, String, String > {
	
	@Resource(name="whdao")
	Dao2 dao;
	
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
	public ArrayList<WorkHistory> get(String k, String a, String b) throws Exception {
		return dao.select(k,a,b);
	}

	@Override
	public ArrayList<WorkHistory> get() throws Exception {
		return dao.select();
	}

}
