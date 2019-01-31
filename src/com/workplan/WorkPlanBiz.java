package com.workplan;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.WorkPlan;

@Service("wpbiz")
public class WorkPlanBiz implements Biz<String, WorkPlan> {
	@Resource(name="wpdao")
	Dao dao;
	
	@Override
	public void register(WorkPlan v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(WorkPlan v) throws Exception {
		dao.update(v);
	}

	@Override
	public WorkPlan get(String k) throws Exception {
		return (WorkPlan)dao.select(k);
	}

	@Override
	public ArrayList<WorkPlan> get() throws Exception {
		return dao.select();
	}

}
