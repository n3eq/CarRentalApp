<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
       
     <form action="rentacar" method="get">
     
     	<label for="start">Start date:</label>

		<input type="date" id="start" name="rental-start"
      	 value="2020-12-31">
      
   		<br>
      
    	<label for="start">Finish date:</label>

		<input type="date" id="finish" name="rental-finish"
       	value="2020-12-31">
     
		<div class="form-group col-md-4">
	      <label for="city-pickup">Pickup city:</label>
	      <select name="city-pickup" id="city" class="form-control">
	        <option value="gdansk">Gdansk</option>
	        <option value="krakow">Krakow</option>
	        <option value="warszawa">Warszawa</option>
	      </select>
	      
	      <label for="city-return">Return city:</label>
	      <select name="city-return" id="city" class="form-control">
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