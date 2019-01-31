package com.mapper;

import java.util.ArrayList;

import com.vo.WorkHistory;

public interface WorkHistoryMapper {
	public void insert(WorkHistory obj);
	public void delete(String history_num);
	public void update(WorkHistory obj);
	public WorkHistory select(String obj);
	public ArrayList<WorkHistory> selectall();
}
