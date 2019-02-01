<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<div class="card card-outline-secondary my-4">
	<div class="card-header">Car Events</div>
	<div class="card-body">
	<c:forEach var="event" items="${list}">
		<div class="row">
			${event.start_time } <br>
			${event.car_id }&nbsp; ${event.work_status }
			<br>
			<hr>
		</div>
	</c:forEach>
	</div>
</div>
<!-- /.card -->