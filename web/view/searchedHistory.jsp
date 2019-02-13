<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<c:choose>
<c:when test="${fn:length(historyList) >0}">
	<table class="table">
		<thead>
			<tr><th>Start Time</th><th>End Time</th><th>Status</th></tr>
		</thead>
		<c:forEach var="list" items="${historyList}">
			<tr>
				<td class="datetime">${list.start_time }</td>
				<td class="datetime">${list.end_time } </td>
				<td>${list.work_status }</td>
			</tr>
			 
		</c:forEach>
	</table>	
</c:when>
<c:otherwise>
	데이터를 찾을 수 없습니다.
</c:otherwise>
</c:choose>


