<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card card-outline-secondary my-4 ">
	<div class="card-header">Car History</div>
	<div class="card-body car-list">
	
		<div class="">
			<form id="search-form">
			<div class="form-group">
    			<label class="col-lg-4">차량</label>
    			  <select class="" name="car_id" >
	    			  <c:forEach var="car" items="${list}">
	    				<option class="dropdown-item" value="${car.car_id }">${car.car_id }</option>  	
	    			  </c:forEach>
    			  </select>
			</div>
			<div class="form-group">
				<label class="col-lg-4">From</label>
				<input class="col-lg-7 datetime" type="date" name="start_date" >
			</div>
			<div class="form-group">
				<label class="col-lg-4">To</label>
				<input class="col-lg-7 datetime" type="date" name="end_date" >
			</div>
			<div class="form-group">
				<input type="button" class="btn" value="검색" onclick="searchHistory()">
			</div>
			</form>
		</div>
		
		<div id="history">
		</div>
		
	</div>
</div>
<!-- /.card -->