package com.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.vo.WorkHistory;

public interface WorkHistoryMapper {
	public void insert(WorkHistory obj);
	public void delete(String history_num);
	public void update(WorkHistory obj);
	public ArrayList<WorkHistory> select(@Param("car_id") String car_id,@Param("start_date") String start_date,@Param("end_date") String end_date);
	public ArrayList<WorkHistory> selectall();
}
