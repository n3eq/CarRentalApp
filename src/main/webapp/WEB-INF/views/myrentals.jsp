	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ include file="header.jspf" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Yours rentals</title>
</head>
<body>
	
	<div class="container"> 
	<table class="table table-striped">
	<caption>My Rentals</caption>
	
		<thead>
			<tr>
				<th>Brand</th>
				<th>Model</th>
				<th>Rental start date</th>
				<th>Rental finish date</th>
				<th>Pickup city</th>
				<th>Return city</th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${rentals}" var="r">
		
			<tr>
				<td>${r.brand}</td>
				<td>${r.model}</td>
				<td>${r.rental_start_date}</td>
				<td>${r.rental_finish_date}</td>
				<td>${r.pickup_city}</td>
				<td>${r.return_city}</td>
			</tr>
			
			</c:forEach>

		</tbody>
	</table>
	</div>
	
</body>
</html>