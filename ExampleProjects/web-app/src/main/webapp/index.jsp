<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bg.tu_varna.sit.web_app.modes.Fruit" %>
<%@ page import="bg.tu_varna.sit.web_app.modes.Fruits" %>
<%@ page import="java.util.HashSet" %>
<jsp:useBean id="fruits" type="bg.tu_varna.sit.web_app.modes.Fruits" scope="session">
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruits List</title>
<script type="text/javascript" src="js/site.js"></script>
</head>
<body>
	
	<%if(request.getAttribute("cookie") == null) { %> 
		<form action="cookie" method="post">
			<div>
				We steal data
			</div>
			<input type="submit" value="Submit">
		</form>
	<% }%>
	
	<h1>Fruits List</h1>
	
	<table>
	<tr>
		<td>Fruit</td>
		<td>Type</td>
		<td>Count</td>
		<td>buy</td>
	</tr>
	<%for(Fruit fruit : fruits.getAll()) {%>
	<tr>
		<td id="name"><%=fruit.getName() %></td>
		<td><%=fruit.getType() %></td>
		<td id="<%=fruit.getName() %>"><%=fruit.getCount() %></td>
		<td><a href="fruit?name=<%=fruit.getName() %>">open</a></td>
		<td><button type="button" onclick="extraction('<%=fruit.getName() %>')" >Get 1</button></td>
	</tr>
	<%} %>
	</table>
</body>
</html>