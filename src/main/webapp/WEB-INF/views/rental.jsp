	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="header.jspf" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rent a car</title>
</head>
<body>
	
	
       
     <form action="saverental" method="get">
     	
     	<input type="hidden" id="carId" name="carId" value="${carId}">
     	
     	<label for="start">Start date:</label>

		<input type="date" id="start" name="rental_start"
      	 value="2020-12-31">
      
   		<br>
      
    	<label for="start">Finish date:</label>

		<input type="date" id="finish" name="rental_finish"
       	value="2020-12-31">
     
		<div class="form-group col-md-4">
	      <label for="city_pickup">Pickup city:</label>
	      <select name="city_pickup" id="city" class="form-control">
	        <option value="gdansk">Gdansk</option>
	        <option value="krakow">Krakow</option>
	        <option value="warszawa">Warszawa</option>
	      </select>
	      
	      <label for="city_return">Return city:</label>
	      <select name="city_return" id="city" class="form-control">
	        <option value="gdansk">Gdansk</option>
	        <option value="krakow">Krakow</option>
	        <option value="warszawa">Warszawa</option>
	      </select>
	      
	      <input type="submit" value="submit"/>
	    </div>
	    
    </form>
	
	<script>
	var today = new Date();
	var maxDate = new Date();
	
	var dd = today.getDate();
	var mm = today.getMonth()+1; 
	var yyyy = today.getFullYear();
	
	if(dd<10){
		dd='0'+dd
	} 
	if(mm<10){
		mm='0'+mm
	} 

	today = yyyy+'-'+mm+'-'+dd;
	
	var mDD = 31;
	var mMM = 12
	var mYYYY = 2020;
	
	if(mDD<10){
		mDD='0'+mDD
	} 
	if(mMM<10){
		mMM='0'+mMM
	} 
	
	maxDate = mYYYY+'-'+mMM+'-'+mDD;

	document.getElementById("start").setAttribute("min", today);
	document.getElementById("start").setAttribute("max", maxDate);

	document.getElementById("finish").setAttribute("min", today);
	document.getElementById("finish").setAttribute("max", maxDate);
	
	</script>
	
</body>
</html>