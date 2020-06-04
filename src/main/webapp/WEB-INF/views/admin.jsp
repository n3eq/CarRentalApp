	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
	
	<b><%= request.getParameter("alert") %></b>
	
	<br>
	
	<b>Click the button to add a new car.</b>
	<a class="btn btn-success" href="/admin/addcar">Add car</a>
	
	<br>
	<br>
	
	<b>Type id car that you want to delete and click the button.</b>
	<form action="/admin/deletecar" method="GET"> 

			Id car to delete<input type="text" class="form-control" name="carId" >
		
		<input class="btn btn-danger" type="submit" value="Delete car"/>
		
	</form>
	
	

</body>
</html>