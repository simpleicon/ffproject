<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	<div class="card card-outline-secondary my-4">
		<div class="card-header">���� �� ����</div>
		<div class="card-body">
			<p>������ �������Դϴ�.</p>
			id : ${status.car_id }
			battery: ${status.battery }
			ignition : ${status.ignition }
			charge : ${status.charge }
			<small class="text-muted"></small>
			<a href="#" class="btn btn-success">button</a>
		</div>
	</div>