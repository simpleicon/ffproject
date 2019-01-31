<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card card-outline-secondary my-4">
	<div class="card-header">Car List</div>
	<div class="card-body">
	<c:forEach var="car" items="${list}">
		<div class="row">
			${car.car_id }<br>
			${car.car_name }<br>
		</div>
	</c:forEach>		
		
		<a href="#" class="btn btn-success">Leave a Review</a>
	</div>
</div>
<!-- /.card -->