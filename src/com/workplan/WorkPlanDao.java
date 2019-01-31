package com.workplan;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.WorkPlanMapper;
import com.vo.WorkPlan;

@Repository("wpdao")
public class WorkPlanDao implements Dao<String, WorkPlan> {
	
	@Autowired
	WorkPlanMapper wpm;
	
	@Override
	public void insert(WorkPlan v) {
		wpm.insert(v);
	}

	@Override
	public void delete(String k) {
		wpm.delete(k);
	}

	@Override
	public void update(WorkPlan v) {
		wpm.update(v);
	}

	@Override
	public WorkPlan select(String k) {
		return wpm.select(k);
	}

	@Override
	public ArrayList<WorkPlan> select() {
		return wpm.selectall();
	}

}
