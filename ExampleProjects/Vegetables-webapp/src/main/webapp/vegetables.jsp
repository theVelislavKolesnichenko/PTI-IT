<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="bg.tu_varna.sit.vegetables_webapp.Vegetable"%>
<jsp:useBean id="vegetables" type="bg.tu_varna.sit.vegetables_webapp.Vegetables" scope="request"></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vegetables list</title>
<script type="text/javascript" src="js/site.js"></script>
</head>
<body>

<h1>Vegetables list</h1>

<table>
	<tr>
		<td>Name</td>
		<td>Count</td>
		<td>Price</td>
		<td>Action</td>
	</tr>
	<%for(Vegetable vegetable : vegetables.getVegetables()) {%>
		<tr>
			<td><%=vegetable.getName() %></td>
			<td id="<%=vegetable.getName() %>"><%=vegetable.getCount() %></td>
			<td><%=vegetable.getPrice() %></td>
			<td><button type="button" onclick="get_vegetables('<%= vegetable.getName()%>')">Get</button></td>
		</tr>
	<%} %>
</table>

</body>
</html>