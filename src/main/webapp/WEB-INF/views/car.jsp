<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<title>Insert title here</title>
</head>
<body>
	<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout">Logout</a></li>
	</ul>

	<form action="get" method="get">
		<div class="form-group col-md-4">
	      <label for="inputState">Sort by</label>
	      <select name="sortMethod" id="inputState" class="form-control">
	        <option value="">Select sort method</option>
	        <option value="priceDESC">price desc</option>
	        <option value="priceASC">price asc</option>
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
		    			<label>Model:</label>
		    			<input type="text" name="model"/>
		    	 		<input type="submit" value="submit"/>
		    </form>
    
    </div>
    
	<div class="container"> 
	<table class="table table-striped">
	<caption>Cars</caption>
	
		<thead>
			<tr>
				<th>Car type</th>
				<th>Brand</th>
				<th>Model</th>
				<th>Price</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${cars}" var="car">
		
			<tr>
				<td>${car.carType}</td>
				<td>${car.brand}</td>
				<td>${car.model}</td>
				<td>${car.price}</td>
				<td> <a class="btn btn-success" href="/rental/rentacar?id=1">Rent a car</a></td>
			</tr>
			
			</c:forEach>

		</tbody>
	</table>
	</div>
		
</body>
</html>