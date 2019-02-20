<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
			<!-- <p>차량의 상세정보입니다.</p> -->
			차량 ID : ${status.car_id } &nbsp; 위치정보 : ${car.cur_location_x } &nbsp; ${car.cur_location_y }<br>
			배터리 : ${status.battery }% &nbsp; 적재정보 : ${car.cur_load }<br>
			전원 : ${status.ignition }<br>
			충전 : ${status.charge }<br>
			<small class="text-muted"></small>
			<!-- <a href="#" class="btn btn-success">button</a> -->
<h1></h1>