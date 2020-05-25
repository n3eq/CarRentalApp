	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="header.jspf" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<title>Our cars</title>
</head>
<body>

	<form action="get" method="get">
		<div class="form-group col-md-4">
	      <label for="inputState">Sort by</label>
	      <select name="sortMethod" id="inputState" class="form-control">
	        <option value="">Select sort method</option>
	        <option value="DESC">price desc</option>
	        <option value="ASC">price asc</option>
	      </select>
	      <input type="submit" value="submit"/>
	    </div>
	    
    </form>
    
    <div class="form">
		    <form action="get" method="get">
		    			<label>Type:&nbsp&nbsp</label>
		    			<input type="text" name="type">
		    	 		<input type="submit" value="submit"/>
		    </form>
		    
		    <form action="get" method="get">
		    			<label>Brand:</label>
		    			<input type="text" name="brand"/>
		    	 		<input type="submit" value="submit"/>
		    </form>
		    
		    <form action="get" method="get">
		    			<label>Year:&nbsp&nbsp&nbsp</label>
		    			<input type="text" name="year"/>
		    	 		<input type="submit" value="submit"/>
		    </form>
		    
		    <form action="get" method="get">
		    			<label>City:&nbsp&nbsp&nbsp</label>
		    			<input type="text" name="city"/>
		    	 		<input type="submit" value="submit"/>
		    </form>
		    
		   <a class="btn btn-success" href="/cars/get">Reset</a>
    
    </div>
    
	<div class="container"> 
	<table class="table table-striped">
	<caption>Cars</caption>
	
		<thead>
			<tr>
				<th>Car type</th>
				<th>Brand</th>
				<th>Model</th>	
				<th>Year</th>
				<th>Horsepower</th>
				<th>Seats</th>
				<th>Price</th>
				<th>Pickup city</th>
				
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${cars}" var="car">
		
			<tr>
				<td>${car.car_type}</td>
				<td>${car.brand}</td>
				<td>${car.model}</td>
				<td>${car.production_year}</td>
				<td>${car.horsepower}</td>
				<td>${car.seats}</td>
				<td>${car.price}</td>
				<td>${car.city}</td>
				
				
				<td> <a class="btn btn-success" href="/rental/rentacar?id=${car.car_id}&city=${car.city}">Rent a car</a> </td>
			</tr>
			
			</c:forEach>

		</tbody>
	</table>
	</div>
		
</body>
</html>