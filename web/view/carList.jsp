<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card card-outline-secondary my-4">
	<div class="card-header">Car List</div>
	<div class="card-body car-list">
	<c:forEach var="car" items="${list}">
		<div class="row">
			<button onclick="getStatus(${car.car_id})" class ="car_id col-lg-12 list-group-item" id="${car.car_id }">${car.car_name }</button>
		</div>
	</c:forEach>
		<!-- <a href="#" class="btn btn-success">Leave a Review</a> -->
	</div>
</div>
<!-- /.card -->