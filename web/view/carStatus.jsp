<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	<div class="card card-outline-secondary my-4">
		<div class="card-header">차량 상세 정보</div>
		<div class="card-body">
			<p>차량의 상세정보입니다.</p>
			id : ${status.car_id }
			battery: ${status.battery }
			ignition : ${status.ignition }
			charge : ${status.charge }
			<small class="text-muted"></small>
			<a href="#" class="btn btn-success">button</a>
		</div>
	</div>