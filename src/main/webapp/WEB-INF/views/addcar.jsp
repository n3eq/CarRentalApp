	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="header.jspf" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="/admin/addcar" method="POST" modelAttribute="car">
	
	  <!-- <fieldset class="form-group">
	    <form:label path="car_id">Car id</form:label>
	    <form:input path="car_id" type="text" class="form-control" placeholder="e.g 1...9999"/>
	  </fieldset> -->
	
	 <fieldset class="form-group">
	    <form:label path="office_id">Office id(1-krakow, 2-warszawa, 3-gdansk)</form:label>
	    <form:input path="office_id" type="text" class="form-control" placeholder="1-krakow, 2-warszawa, 3-gdansk"/>
	  </fieldset>
	  
	  <fieldset class="form-group">
	    <form:label path="carType">Car type</form:label>
	    <form:input path="carType" type="text" class="form-control" placeholder="e.g sport"/>
	  </fieldset>
	  
	   <fieldset class="form-group">
	    <form:label path="brand">Car brand</form:label>
	    <form:input path="brand" type="text" class="form-control" placeholder="e.g audi"/>
	  </fieldset>
	  
	  <fieldset class="form-group">
	    <form:label path="model">Car model</form:label>
	    <form:input path="model" type="text" class="form-control" placeholder="e.g rs5"/>
	  </fieldset>
	  
	  <fieldset class="form-group">
	    <form:label path="production_year">Year</form:label>
	    <form:input path="production_year" type="text" class="form-control" placeholder="e.g 2020"/>
	  </fieldset>
	  
	  <fieldset class="form-group">
	    <form:label path="horsepower">Horsepower</form:label>
	    <form:input path="horsepower" type="text" class="form-control" placeholder="e.g 200"/>
	  </fieldset>
	  
	  <fieldset class="form-group">
	    <form:label path="seats">Seats</form:label>
	    <form:input path="seats" type="text" class="form-control" placeholder="e.g 5"/>
	  </fieldset>
	  
	  <fieldset class="form-group">
	    <form:label path="price">Price</form:label>
	    <form:input path="price" type="text" class="form-control" placeholder="e.g 1000"/>
	  </fieldset>
	  
	  <fieldset class="form-group">
	    <form:label path="avaliable">Avaliable</form:label>
	    <form:input path="avaliable" type="text" class="form-control" placeholder="e.g 1"/>
	  </fieldset>
	  
	  <input type="submit" value="submit">
	  
	</form:form>
	
</body>
</html>