package com.workhistory;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao2;
import com.mapper.WorkHistoryMapper;
import com.vo.WorkHistory;

@Repository("whdao")
public class WorkHistoryDao implements Dao2<String, WorkHistory, String, String> {
	
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
	public ArrayList<WorkHistory> select(@Param("car_id") String k, @Param("start_date") String a, @Param("end_date") String b) {
		return whm.select(k,a,b);
	}

	@Override
	public ArrayList<WorkHistory> select() {
		return whm.selectall();
	}

}
