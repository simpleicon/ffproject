<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<div class="card card-outline-secondary my-4">
	<div class="card-header">Car Events</div>
	<div class="card-body car-list">
	<table class="table">
	<thead>
		<tr><th>시간</th><th>차량</th><th>이벤트</th></tr>
	</thead>
		<c:forEach var="event" items="${list}">
			<tr class="table-click" onclick="eventMarker(${event.plan_num})">
				<td class="datetime">${fn:substring(event.start_time,0,20) }</td>
				<td>${event.car_id }</td>
				<td>${event.work_status }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</div>
<!-- /.card -->