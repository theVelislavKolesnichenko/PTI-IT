<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bg.tu_varna.sit.petshop.models.Pet" %>
<%@ page import="bg.tu_varna.sit.petshop.models.Pets" %>
<%@ page import="java.util.HashSet" %>
<jsp:useBean id="pets" type="bg.tu_varna.sit.petshop.models.Pets" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/site.js"></script>
	</head>
	<body>
	<%if(request.getAttribute("cookie") == null) {%>
		<form action="coocie" method="post">
			<div>
				We steal data
			</div>
			<input type="submit" value="Submit">
		</form>
	<%} %>
		<h1>Pet Shop <%=session.getMaxInactiveInterval() %></h1>
		<table>
			<tr>
				<td>Pet</td>
				<td>Type</td>
				<td>Cout</td>
				<td>Buy</td>
			</tr>
			<%for(Pet pet : pets.getPets()) { %>
			<tr>
				<td><a href="pet?name=<%=pet.getName() %>"><%=pet.getName() %></a></td>
				<td><%=pet.getType() %></td>
				<td id="<%=pet.getName() %>"><%=pet.getCount() %></td>
				<td><button type="button" onclick="getpet('<%=pet.getName() %>')" >Get</button></td>
			</tr>
			<%} %>
		</table>
	
	</body>
</html>